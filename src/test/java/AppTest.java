import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Parcel");
  }

  @Test
  public void parcelCalculator() {
    goTo("http://localhost:4567/");
    fill("#length").with("100");
    fill("#width").with("80");
    fill("#height").with("400");
    fill("#weight").with("1000");
    submit(".btn");
    assertThat(pageSource()).contains("$500");
  }
}
