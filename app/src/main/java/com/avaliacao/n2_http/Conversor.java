package com.avaliacao.n2_http;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversor {

    public User getInformacao(String end){
        String json = ConexaoAPI.getJsonFromApi(end);
        User retorno = parseJson(json);
        return retorno;
    }

    private User parseJson(String json) {
        try {
            User user = new User();

            JSONObject jsonObj = new JSONObject(json);

            user.setId(jsonObj.getString("id"));
            user.setName(jsonObj.getString("name"));

            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
        public Follower getInformacao2(String end){
            String json = ConexaoAPI.getJsonFromApi(end);
            Follower retorno2 = parseJson2(json);
            return retorno2;
        }

        private Follower parseJson2(String json){
            try {
                Follower follower = new Follower();
                JSONObject jsonObj = new JSONObject(json);

                follower.setId2(jsonObj.getString("id"));
                follower.setLogin(jsonObj.getString("login"));

                // Não consegui acessar os dados... deixei funcionando com outro Link

                /*JSONArray array = jsonObj.getJSONArray(null);
                JSONObject objArray = array.getJSONObject(1);


                follower.setLogin(objArray.getString("login"));
                follower.setLogin(objArray.getString("login"));*/



                return follower;

            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;

    }
}
