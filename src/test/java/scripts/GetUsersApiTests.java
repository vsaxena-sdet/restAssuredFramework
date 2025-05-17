package scripts;

import com.vs.core.request.Request;
import com.vs.core.response.ApiExecutor;
import com.vs.core.response.ApiExecutorBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import validations.GetUsersApiValidations;

public class GetUsersApiTests extends BaseTest {

    GetUsersApiValidations getUsersApiValidations;
    SoftAssert softAssert;
    private static final Logger logger = LogManager.getLogger(GetUsersApiTests.class);


    @BeforeMethod
    public void beforeMethodSetup(){
        softAssert = new SoftAssert();
    }

    @BeforeTest
    public void beforeTestSetup(){
        getUsersApiValidations = new GetUsersApiValidations();
    }

    @Test
    public void test_1 (){
        Request getUsersRequest = requestHelper.getUsersRequest();
        Response res = new ApiExecutor(getUsersRequest).execute();
        getUsersApiValidations.validateApiResponse(res,softAssert);
        softAssert.assertAll();
    }


    @Test
    public void test_2() {
        logger.info("This is an info log.");
        logger.error("This is an error log.");
    }
}