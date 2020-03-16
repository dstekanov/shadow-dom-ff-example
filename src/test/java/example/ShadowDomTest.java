package example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class ShadowDomTest {

    @Test
    void setValueViaShadowDomInsideIFrame() {
        Configuration.browser = "firefox";
        Selenide.open("https://mdn.github.io/web-components-examples/editable-list/");

        WebElement targetWebElement = Selenide
                .executeJavaScript("return document.querySelector(arguments[0]).shadowRoot.querySelector(arguments[1])",
                        "body editable-list", "input.add-new-list-item-input");

        // org.openqa.selenium.ElementNotInteractableException: Element <input class="add-new-list-item-input" type="text"> is not reachable by keyboard
        targetWebElement.sendKeys("this will fail");
    }

}
