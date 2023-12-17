package scripts;

import com.vs.helpers.restHelper.RequestHelper;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public RequestHelper requestHelper;

    @BeforeSuite
    public void beforeSuiteSetup(){
        requestHelper = new RequestHelper();
    }
}
