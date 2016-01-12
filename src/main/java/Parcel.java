public class Parcel {
  private int mLength;
  private int mWidth;
  private int mHeight;
  private int mWeight;
  private final double SML_PARCEL_PRICE = 0.75;
  private final double MED_PARCEL_PRICE = 0.7;
  private final double LRG_PARCEL_PRICE = 0.5;

  public Parcel (int length, int width, int height, int weight){
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
  }

  public int getLength() {
    return mLength;
  }
  public int getWidth() {
    return mWidth;
  }
  public int getHeight() {
    return mHeight;
  }
  public int getWeight() {
    return mWeight;
  }

  public int getVolume() {
    return mLength * mHeight * mWidth;
  }

  public String getCategory() {
    if (getVolume() > 0 && getVolume() <= 1000) {
      return "small";
    } else if (getVolume() > 1000 && getVolume() <= 60000) {
      return "medium";
    } else if (getVolume() > 60000) {
      return "large";
    } else {
      throw new IllegalArgumentException();
    }
  }

  public double getBaseShippingCost(){
    double parcelCost = 0;
    try {
      if (getCategory().equals("small")) {
        parcelCost = getWeight() * SML_PARCEL_PRICE;
      } else if (getCategory().equals("medium")) {
        parcelCost = getWeight() * MED_PARCEL_PRICE;
      } else {
        parcelCost = getWeight() * LRG_PARCEL_PRICE;
      }
    } catch (Exception iae) {
      System.err.println("Exception " + iae + ": Must enter valid dimensions.");
    }
    return parcelCost;
  }
}
