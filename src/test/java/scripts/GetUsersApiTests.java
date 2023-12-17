package scripts;

import com.vs.core.request.Request;
import com.vs.core.response.ApiExecutor;
import com.vs.enums.HttpMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import validations.GetUsersApiValidations;

import java.util.HashMap;
import java.util.Map;

public class GetUsersApiTests extends BaseTest {

    GetUsersApiValidations getUsersApiValidations;
    SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethodSetup(){
        softAssert = new SoftAssert();
    }

    @BeforeTest
    public void beforeTestSetup(){
        getUsersApiValidations = new GetUsersApiValidations();
    }

    @Test
    public void abc (){
        Request getUsersRequest = requestHelper.getUsersRequest();
        Response res = new ApiExecutor(getUsersRequest).execute();
        getUsersApiValidations.validateApiResponse(res,softAssert);
        softAssert.assertAll();
    }
}