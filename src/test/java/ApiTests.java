import com.vs.core.request.Request;
import com.vs.core.response.ApiExecutor;
import com.vs.enums.HttpMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTests {

    @Test
    public void abc (){
        Request request = new Request();
        Map<String,Object> queryParams = new HashMap<String, Object>();
        queryParams.put("page",1);
        request.baseURI = "https://reqres.in/";
        request.path="api/users";
        request.queryParams=queryParams;
        request.method= HttpMethods.GET;
        request.contentType= ContentType.JSON.getAcceptHeader();
        Response res = new ApiExecutor(request).execute();
        res.prettyPrint();
    }

    @Test
    public void abcd () {
        Request request = new Request();
        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("page", 1);
        request.baseURI = "https://reqres.in/";
        request.path = "api/users";
        request.queryParams = queryParams;
        request.method = HttpMethods.PUT;
        request.contentType = ContentType.JSON.getAcceptHeader();
        Response res = new ApiExecutor(request).execute();
        res.prettyPrint();
    }
}