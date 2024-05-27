package com.example.fragmetlambdajava;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ListenerFragmentComunication listener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Context context = getActivity();
        if (context instanceof ListenerFragmentComunication) {
            listener = (ListenerFragmentComunication) context;
        } else {
            throw new ClassCastException(context.toString() + " Error: must implement ListenerFragmentComunication");
        }

        EditText editUserName = view.findViewById(R.id.edtUsernameFragment);
        EditText editFirstName = view.findViewById(R.id.edtFirtsNameFragment);
        EditText editLastName = view.findViewById(R.id.edtLastNameFragment);
        EditText editEmail = view.findViewById(R.id.edtEmailFragment);
        EditText editPassword = view.findViewById(R.id.edtPasswordFragment);
        EditText editPhone = view.findViewById(R.id.edtPhoneFragment);
        Button btnAcceptFragment = view.findViewById(R.id.btnAcceptFragment);

        btnAcceptFragment.setOnClickListener(v -> {
            String userName = editUserName.getText().toString();
            String firstName = editFirstName.getText().toString();
            String lastName = editLastName.getText().toString();
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();
            String phone = editPhone.getText().toString();

            Usuario usuario = new Usuario(userName, firstName, lastName, email, password, phone);
            if (listener != null) {
                listener.listenerFragment(usuario);
            }
        });
        return view;
    }
}