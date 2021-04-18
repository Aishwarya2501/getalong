package com.example.getalong.dialogues;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.getalong.R;
import com.google.android.material.tabs.TabLayout;

import static android.content.ContentValues.TAG;

public class ConfirmPasswordDialog extends DialogFragment {

    private static final String TAG = "ConfirmPasswordDialog";

    public interface OnConfirmPasswordListener{
        public void onConfirmPassword(String password);
    }
    OnConfirmPasswordListener mOnConfirmPasswordListener;

    //vars
    TextView mPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_confirm_password, container, false);
        mPassword = (TextView) view.findViewById(R.id.confirm_password);

        Log.d(TAG, "onCreateView: started.");

        TextView confirmDialog = (TextView) view.findViewById(R.id.dialogueConfirm);
        confirmDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capture password and confirming");

                String password = mPassword.getText().toString();
                if(!password.equals("")){

                }
                else{
                    Toast.makeText(getActivity(), "you must enter a password", Toast.LENGTH_SHORT);
                }
            }
        });

        TextView cancelDialog = (TextView) view.findViewById(R.id.dialogueCancel);
        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing the dialog");
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mOnConfirmPasswordListener = (OnConfirmPasswordListener) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage());
        }



    }
}
