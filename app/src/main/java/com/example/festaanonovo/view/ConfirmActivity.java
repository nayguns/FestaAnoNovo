package com.example.festaanonovo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.festaanonovo.R;
import com.example.festaanonovo.constant.AnoNovoConstant;
import com.example.festaanonovo.data.SecurityPreferences;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.checkbox_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.checkbox_participate) {

            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSecurityPreferences.storeString(AnoNovoConstant.PRESENCE_KEY, AnoNovoConstant.CONFIRMATION_YES);
            } else {
                this.mSecurityPreferences.storeString(AnoNovoConstant.PRESENCE_KEY, AnoNovoConstant.CONFIRMATION_NO);
            }

        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(AnoNovoConstant.PRESENCE_KEY);
            if (presence != null && presence.equals(AnoNovoConstant.CONFIRMATION_YES)) {
                this.mViewHolder.checkParticipate.setChecked(true);
            } else {
                this.mViewHolder.checkParticipate.setChecked(false);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}