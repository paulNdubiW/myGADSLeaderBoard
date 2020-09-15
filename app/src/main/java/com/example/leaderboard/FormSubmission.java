package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.leaderboard.network.ServiceBuilder;
import com.example.leaderboard.network.ServiceRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormSubmission extends AppCompatActivity {

    public static final String SERVICE_REQUEST = "Service Request";
    private ImageButton mBackArrow;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mLinkToProject;
    private Button mSubmit;
    private WarningDialog mDialogWarning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_submission);

        mBackArrow = findViewById(R.id.back_arrow);
        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mEmailAddress = (EditText) findViewById(R.id.email_address);
        mLinkToProject = (EditText) findViewById(R.id.project_link);
        mSubmit = (Button) findViewById(R.id.button_submit);

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormSubmission.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                issueWarningDialog();
            }
        });


    }

    private void issueWarningDialog() {
        mDialogWarning = new WarningDialog(FormSubmission.this);
        Button proceed = mDialogWarning.findViewById(R.id.warning_button);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeServiceRequest();
                mDialogWarning.dismiss();
            }
        });

        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 40);
        mDialogWarning.show();
        mDialogWarning.setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialogWarning.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mDialogWarning.getWindow().setAttributes(layoutParams);
        mDialogWarning.getWindow().setBackgroundDrawable(inset);
    }

    private void makeServiceRequest() {
        ServiceRequest serviceRequest = ServiceBuilder.buildService(ServiceRequest.class);
        Call<Void> postRequest = serviceRequest.submitProject(
                mFirstName.getText().toString(),
                mLastName.getText().toString(),
                mEmailAddress.getText().toString(),
                mLinkToProject.getText().toString()
        );

        postRequest.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> request, Response<Void> response) {
                issueSuccessDialog();
            }

            @Override
            public void onFailure(Call<Void> request, Throwable t) {
                issueFailureDialog();
                Log.d(SERVICE_REQUEST, "Debug Message: ", t);
            }
        });
    }

    private void issueFailureDialog() {
        FailureDialog dialogFailure = new FailureDialog(FormSubmission.this);
        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 40);
        dialogFailure.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialogFailure.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogFailure.getWindow().setAttributes(layoutParams);
        dialogFailure.getWindow().setBackgroundDrawable(inset);



    }

    private void issueSuccessDialog() {
        SuccessDialog dialogSuccess = new SuccessDialog(FormSubmission.this);
        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 40);
        dialogSuccess.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialogSuccess.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogSuccess.getWindow().setAttributes(layoutParams);
        dialogSuccess.getWindow().setBackgroundDrawable(inset);
    }
}