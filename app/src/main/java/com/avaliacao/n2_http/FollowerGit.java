package com.avaliacao.n2_http;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class FollowerGit extends AppCompatActivity {

    private ProgressDialog load;
    private TextView id2;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_git);

        id2 = (TextView)findViewById(R.id.id);
        login = (TextView)findViewById(R.id.login);

        DownloadGit2 pessoa = new DownloadGit2();
        pessoa.execute();

    }

    private class DownloadGit2 extends AsyncTask<Void, Void, Follower> {

        @Override
        protected void onPreExecute() {
            //inicia o dialog
            load = ProgressDialog.show(FollowerGit.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Follower doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao2("https://api.github.com/users/guivmartins");
            // Não consegui acessar os dados... deixei funcionando com outro Link
            //return util.getInformacao2("https://api.github.com/users/giselezrossi/followers");
        }

        @Override
        public void onPostExecute(Follower follower) {

            login.setText(follower.getLogin());
            id2.setText(follower.getId2());
            load.dismiss();
        }}

}

