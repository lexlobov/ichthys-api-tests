package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import steps.BaseSteps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected String email;
    protected String password;

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

    public void setPassword(String password) {
        this.password = password;
    }

    @BeforeAll
    protected void setUp(){
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("local.properties")){
            props.load(fis);
            setEmail(props.getProperty("adminLogin"));
            setPassword(props.getProperty("adminPassword"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseSteps.getTokenFromAuth(email, password);
    }
}
