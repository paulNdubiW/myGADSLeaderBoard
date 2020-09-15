package com.example.leaderboard;

import android.app.Dialog;
import android.content.Context;


import androidx.annotation.NonNull;

public class SuccessDialog extends Dialog {
    public SuccessDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.success_dialog);

    }
}
