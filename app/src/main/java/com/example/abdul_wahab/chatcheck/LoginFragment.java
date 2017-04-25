package com.example.abdul_wahab.chatcheck;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private EditText etUsername;
    private EditText etPassword;
    private ProgressBar progressBar;
    private Button btnLogin;

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = (Button) v.findViewById(R.id.btnLogin);

        etUsername = (EditText) v.findViewById(R.id.etUsername);
        etPassword = (EditText) v.findViewById(R.id.etPassword);

        progressBar = (ProgressBar) v.findViewById(R.id.progressBarLoginFragment);
        progressBar.setVisibility(View.INVISIBLE);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                if (mListener != null) {
                    new LoginTask().execute(username, password);
                }
            }
        });

        return v;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {


        void onLoginSuccess(String username);

        void onLoginFailure();
    }


    class LoginTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            // super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);

            btnLogin.setClickable(false);
            etPassword.setEnabled(false);
            etUsername.setEnabled(false);

        }

        @Override
        protected Boolean doInBackground(String... credentials) {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (credentials[0].equalsIgnoreCase(credentials[1])) {
                return true;
            }

            return false;
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            // super.onPostExecute(aBoolean);


            btnLogin.setClickable(true);
            etPassword.setEnabled(true);
            etUsername.setEnabled(true);


            progressBar.setVisibility(View.INVISIBLE);
            if (aBoolean) {
                mListener.onLoginSuccess(etUsername.getText().toString());

            } else {
                mListener.onLoginFailure();

            }
        }
    }


}
