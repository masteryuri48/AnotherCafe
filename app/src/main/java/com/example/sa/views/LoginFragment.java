package com.example.sa.views;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sa.R;

public class LoginFragment extends Fragment {

    private Button Login;
    private EditText Password;
    private EditText Name;

    private String Username = "User";
    private String Passwords = "123456789";

    boolean isValid = false;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        Name = view.findViewById(R.id.userText);
        Password = view.findViewById(R.id.textPassword);
        Login = view.findViewById(R.id.loginbtn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = Name.getText().toString();
                String inputPassword = Password.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = vallidate(inputName,inputPassword);
                    if (!isValid){
                        Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);

                    }
                }
            }
        });

        return view;
    }
    private boolean vallidate(String name,String passwords){
        if(name.equals(Username)&&passwords.equals(Passwords)){
            return true;
        }
        return false;
    }
}