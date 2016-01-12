import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/output", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      int length = Integer.parseInt(request.queryParams("length"));
      int width = Integer.parseInt(request.queryParams("width"));
      int height = Integer.parseInt(request.queryParams("height"));
      int weight = Integer.parseInt(request.queryParams("weight"));

      model.put("length", length);
      model.put("width", width);
      model.put("height", height);
      model.put("weight", weight);

      Parcel myParcel = new Parcel(length, width, height, weight);

      double parcelCost = myParcel.getBaseShippingCost();

      model.put("myParcel", myParcel);
      model.put("parcelCost", parcelCost);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
