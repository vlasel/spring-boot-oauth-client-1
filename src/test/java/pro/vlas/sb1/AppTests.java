package pro.vlas.sb1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

    @Autowired
    private OauthClient client;


   /* @Test
    void contextLoads() {
    }*/

    @Test
    void oauthClient() {
        System.out.println();
    }

}
