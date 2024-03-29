package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String USER = "eroshenkoam";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void searchForIssue() {
       open("https://github.com/");
       $(".header-search-input").click();
       $(".header-search-input").sendKeys("eroshenkoam/allure-example");
       $(".header-search-input").submit();
       $(By.linkText("eroshenkoam/allure-example")).click();
       $(withText("Issues")).click();
       $(withText("#68")).should(Condition.exist);
    }
}
