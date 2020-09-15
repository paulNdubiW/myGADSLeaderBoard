package com.example.leaderboard;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class FailureDialog extends Dialog {
    public FailureDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.failure_dialog);
    }
}
