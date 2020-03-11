package pro.vlas.sb1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
@author user,2020.03.11
*/
@Service
public class OauthClient {

    @Autowired
    private OAuth2RestTemplate restTemplate;

}
