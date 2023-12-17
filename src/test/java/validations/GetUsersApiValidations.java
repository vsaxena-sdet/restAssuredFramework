package validations;

import com.vs.helpers.restHelper.JsonHelper;
import com.vs.models.response.getUsersResponse.Root;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class GetUsersApiValidations {

    private static final Logger logger = LoggerFactory.getLogger(GetUsersApiValidations.class);

    public void validateApiResponse(Response getUserApiResponse, SoftAssert softAssert) {
        Root getUsersDataRespObj = JsonHelper.parseJsonResponse(getUserApiResponse, Root.class);
        assert getUsersDataRespObj != null;
        softAssert.assertEquals(getUsersDataRespObj.getPage(),1);
        softAssert.assertEquals(getUsersDataRespObj.getPer_page(),6);
        softAssert.assertEquals(getUsersDataRespObj.getTotal(),12);
        softAssert.assertEquals(getUsersDataRespObj.getTotal_pages(),2);




    }
}
