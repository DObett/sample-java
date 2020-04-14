package macaca.client;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.*;


public class H5SampleTest {
    MacacaClient driver = new MacacaClient();


    @BeforeEach
    public void setUp() throws Exception {

        JSONObject porps = new JSONObject();
        porps.put("autoAcceptAlerts", true);
        porps.put("browserName", "Chrome");
        porps.put("platformName", "desktop"); // android or ios
        porps.put("javascriptEnabled", true);
        porps.put("platform", "ANY");
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        driver.initDriver(desiredCapabilities)
                .maximize();
    }

    @Test
    public void testCaseOne() throws Exception {

        System.out.println("------------#1 h5 web test-------------------");

        driver.get("http://www.baidu.com");
        String source = driver.title();
        Assertions.assertEquals(source,"百度一下，你就知道");

    }

    @AfterEach
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
