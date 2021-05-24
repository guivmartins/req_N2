package com.avaliacao.n2_http;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserGit extends AppCompatActivity {

    private ProgressDialog load;
    private TextView id;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_git);

        Button botaoSeguidor = (Button) findViewById(R.id.botaoSeg);

        id = (TextView)findViewById(R.id.id);
        name = (TextView)findViewById(R.id.name);

        DownloadGit pessoa = new DownloadGit();
        pessoa.execute();

        botaoSeguidor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(UserGit.this, FollowerGit.class);
                startActivity(it);
            }
        });

    }

    private class DownloadGit extends AsyncTask<Void, Void, User> {

        @Override
        protected void onPreExecute() {
            //inicia o dialog
            load = ProgressDialog.show(UserGit.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected User doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao("https://api.github.com/users/giselezrossi");
        }

        @Override
        protected void onPostExecute(User user) {

            name.setText(user.getName());
            id.setText(user.getId());
            load.dismiss();
        }}

    }

