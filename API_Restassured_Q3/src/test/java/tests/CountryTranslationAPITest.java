package tests;

import base.APIBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.List;

public class CountryTranslationAPITest {
    private static final String TEST_DATA_PATH = "testdata/TranslationTestData.xlsx";

    @DataProvider(name = "translationData")
    public Object[][] getTranslationData() {
        List<String> translations = ExcelReader.getTranslations(TEST_DATA_PATH, "Sheet1");
        Object[][] data = new Object[translations.size()][1];
        for (int i = 0; i < translations.size(); i++) {
            data[i][0] = translations.get(i);
        }
        return data;
    }

    @Test(dataProvider = "translationData")
    public void testTranslationAPI(String translation) {
        Response response = APIBase.getCountryTranslation(translation);
        System.out.println("Endpoint for  "+translation);
        Assert.assertEquals(response.statusCode(), 200, "Failed");

        if (response.statusCode() == 200) {
            System.out.println(response.prettyPrint());
            System.out.println("API Response for '" + translation + "' returned status: " + response.statusCode());
        } else {
            System.out.println("API Response for '" + translation + "' returned status: " + response.statusCode());
            Assert.assertNotEquals(response.statusCode(), 200, "Failed");
        }
    }
}
