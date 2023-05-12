package steps;

import clients.AuthenticationClient;
import models.athentication.AuthenticationResponse;

public class BaseSteps {

    private String token;
    AuthenticationClient client = new AuthenticationClient();

    public void getTokenFromAuth(String login, String password){
        AuthenticationResponse response = client.loginUserModel(login, password);
        setToken(response.getAccessToken());
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
