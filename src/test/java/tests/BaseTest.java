package tests;

import org.junit.jupiter.api.BeforeEach;
import steps.BaseSteps;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected  String email;
    protected  String password;

    protected BaseSteps baseSteps = new BaseSteps();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @BeforeEach
    public void setUp(){
        Properties props = loadProperties();
        email = props.getProperty("adminLogin");
        password = props.getProperty("adminPassword");
        baseSteps.getTokenFromAuth(email, password);
        //RestAssured.filters(new AllureRestAssured());
    }

    private Properties loadProperties() {
        Properties props = new Properties();

        String path = "local.properties";
        if (Files.exists(Path.of(path))) {
            loadFromFile(props, path);
        } else {
            props.setProperty("dminLogin", System.getenv("adminLogin"));
            props.setProperty("adminPassword", System.getenv("adminPassword"));
        }
        return props;
    }

    private void loadFromFile(Properties props, String path) {
        try (FileInputStream fis = new FileInputStream(path)){
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

