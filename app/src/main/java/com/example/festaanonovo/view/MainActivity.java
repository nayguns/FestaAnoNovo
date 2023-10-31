package com.example.festaanonovo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.festaanonovo.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textName = findViewById(R.id.text_name_user);
        this.mViewHolder.textParty = findViewById(R.id.text_party);
        this.mViewHolder.buttonContinue = findViewById(R.id.button_continue);

        this.mViewHolder.buttonContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameUser = this.mViewHolder.textName.getText().toString();
        String party = this.mViewHolder.textParty.getText().toString();

        if (v.getId() == R.id.button_continue) {
            if (nameUser == "" || nameUser.isEmpty() || party == "" || party.isEmpty()) {
                Toast.makeText(this, "Favor informar os dados.", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(this, DetailsActivity.class);
                Bundle dataUserParty = new Bundle();
                if (dataUserParty != null) {
                    dataUserParty.putString("user", nameUser);
                    dataUserParty.putString("party", party);
                }
                i.putExtras(dataUserParty);
                startActivity(i);
            }
        }
    }

    private static class ViewHolder {
        TextView textName;
        TextView textParty;
        Button buttonContinue;
    }
}