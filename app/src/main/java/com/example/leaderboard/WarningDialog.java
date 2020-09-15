package com.example.leaderboard;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class WarningDialog extends Dialog {
    public WarningDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.warning_dialog);
        ImageView closeButton = findViewById(R.id.btnCancel);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


}
