package pro.vlas.sb1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;
import java.util.List;

/**
 * @author user, 2020.03.11
 */
@Configuration
@EnableOAuth2Client
public class OauthConfig {

    @Value("${accessTokenUri}")
    private String accessTokenUri;

    @Value("${clientID}")
    private String clientID;

    @Value("${clientSecret}")
    private String clientSecret;

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//        details.setId("reddit");
        details.setClientId(clientID);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
//        details.setTokenName("oauth_token");
        details.setTokenName("Bearer");
        details.setScope(List.of("identity")); //TODO
//        details.setPreEstablishedRedirectUri("http://localhost/login");
        details.setUseCurrentUri(false);
        return details;
    }

   /* @Bean
    public OAuth2RestTemplate restTemplate() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
    }*/

    @Bean
    public OAuth2RestTemplate redditRestTemplate(OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(resource(), clientContext);
        /*AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(
                Arrays.<AccessTokenProvider> asList(
                        new MyAuthorizationCodeAccessTokenProvider(),
                        new ImplicitAccessTokenProvider(),
                        new ResourceOwnerPasswordAccessTokenProvider(),
                        new ClientCredentialsAccessTokenProvider())
        );
        template.setAccessTokenProvider(accessTokenProvider);*/
        return template;
    }

}
