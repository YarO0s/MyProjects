package tests;

import model.UserRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class consoleRequestParsing {

    @DataProvider(name = "consoleMessageParsingDataProvider")
    public Object[][] consoleMessageParsingDataProvider(){
        return new Object[][]{
                {new UserRequest("send wassup boy"), "send", "wassup boy"},
                {new UserRequest("send "), "send", ""},
                {new UserRequest("    send w"), "send", "w"},
                {new UserRequest("send"), "send", ""}
        };
    }

    @Test(dataProvider = "consoleMessageParsingDataProvider")
    public void consoleMessageParsingTest(UserRequest initRequest, String expectedInstruction, String expectedContent ){
        String actualInstruction = initRequest.getInstruction();
        String actualContent = initRequest.getContent();
        assertEquals(expectedContent, actualContent);
        assertEquals(expectedInstruction, actualInstruction);
    }

}
