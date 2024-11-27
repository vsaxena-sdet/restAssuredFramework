package scripts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vs.core.request.Request;
import com.vs.core.response.ApiExecutor;
import com.vs.models.request.CreatePetStoreUser_usingLombokBuilderDesgn;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePetStoreUserTests extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CreatePetStoreUserTests.class);
    SoftAssert softAssert;

    @BeforeMethod
    public void beforeMethodSetup(){
        softAssert = new SoftAssert();
    }


    // this is implementation of Builder design pattern using Lombok Library
    @Test
    public void testCreatePetStoreUser (){
        CreatePetStoreUser_usingLombokBuilderDesgn cpsuReq = CreatePetStoreUser_usingLombokBuilderDesgn.builder().setId(12).setUserStatus(1).setEmail("abc@xyax.com").setFirstName("va").setLastName("sa").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody= objectMapper.writeValueAsString(cpsuReq);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Request request = requestHelper.createPetStoreUserRequest(requestBody);
        Response response = new ApiExecutor(request).execute();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    // this is implemented using lambdas builder design pattern
    @Test
    public void testCreatePetStoreUser2 (){
        CreatePetStoreUser2_usingLambdasBuilderDesign user = new CreatePetStoreUser2_usingLambdasBuilderDesign.Builder().with(
                 $->{
                     $.username("abc");
                     $.id(123);
                     $.userStatus(1);
                     $.email("abc@yx.com");
                     $.firstName("avvfd");
                     $.lastName("fecvxfg");
                 })
                 .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody= objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Request request = requestHelper.createPetStoreUserRequest(requestBody);
        Response response = new ApiExecutor(request).execute();
        Assert.assertEquals(response.getStatusCode(),200);
    }



}
