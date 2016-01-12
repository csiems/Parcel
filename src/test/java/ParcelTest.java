import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {

  @Test
  public void newParcel_instantiatesCorrectly() {
    Parcel testParcel = new Parcel(3, 3, 3, 3);
    assertEquals(true, testParcel instanceof Parcel);
  }

  @Test
  public void newParcel_getLength_4() {
    Parcel testParcel = new Parcel(4, 5, 6, 7);
    assertEquals(4, testParcel.getLength());
  }

  @Test
  public void newParcel_getWidth_5() {
    Parcel testParcel = new Parcel(4, 5, 6, 7);
    assertEquals(5, testParcel.getWidth());
  }

  @Test
  public void newParcel_getHeight_6() {
    Parcel testParcel = new Parcel(4, 5, 6, 7);
    assertEquals(6, testParcel.getHeight());
  }

  @Test
  public void newParcel_getWeight_7() {
    Parcel testParcel = new Parcel(4, 5, 6, 7);
    assertEquals(7, testParcel.getWeight());
  }

  @Test
  public void newParcel_getVolume_27() {
    Parcel testParcel = new Parcel(3, 3, 3, 50);
    assertEquals(27, testParcel.getVolume());
  }

  @Test
  public void newParcel_getCategory_small() {
    Parcel testParcel = new Parcel(10, 10, 10, 50);
    assertEquals("small", testParcel.getCategory());
  }

  @Test
  public void newParcel_getCategory_medium() {
    Parcel testParcel = new Parcel(12, 12, 10, 50);
    assertEquals("medium", testParcel.getCategory());
  }

  @Test
  public void newParcel_getCategory_large() {
    Parcel testParcel = new Parcel(100, 80, 400, 50);
    assertEquals("large", testParcel.getCategory());
  }

  @Test
  public void newParcel_getBaseShippingCost_150() {
    Parcel testParcel = new Parcel(3, 3, 3, 1000);
    assertEquals(750, testParcel.getBaseShippingCost(), 750);
  }

  @Test
  public void newParcel_getBaseShippingCost_exeption() {
    Parcel testParcel = new Parcel(100, 80, 400, 1000);
    assertEquals(500, testParcel.getBaseShippingCost(), 500);
  }
}
