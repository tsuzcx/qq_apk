import org.json.JSONObject;

public class sne
{
  public String Gx;
  public String aET;
  public String aEU;
  public String aEV;
  public String aEW;
  public boolean aMf;
  public boolean aMg;
  public boolean aMh;
  public int addTime;
  public int bxW;
  public int bxX;
  public int bxY;
  public int bxZ;
  public int bya;
  public int byb;
  public int byc;
  public int byd;
  public int giftId;
  public int mIndex;
  public boolean mSelected;
  
  public sne(JSONObject paramJSONObject, int paramInt)
  {
    this.aET = paramJSONObject.optString("goodsWord");
    this.Gx = paramJSONObject.optString("gifUrl");
    this.aEU = paramJSONObject.optString("pngUrl");
    this.bxW = paramJSONObject.optInt("packageID");
    this.bxX = paramJSONObject.optInt("quantity");
    this.bxY = paramJSONObject.optInt("playRule");
    this.aEV = paramJSONObject.optString("selectedWording");
    this.bxZ = paramJSONObject.optInt("giftValue");
    this.giftId = paramJSONObject.optInt("giftID");
    this.bya = paramJSONObject.optInt("giftPrice");
    this.aMg = paramJSONObject.optBoolean("isFreeGift");
    this.addTime = paramJSONObject.optInt("addTime");
    this.byb = paramJSONObject.optInt("freegiftlimit");
    this.mIndex = paramInt;
    this.byc = paramJSONObject.optInt("svip");
    this.byd = paramJSONObject.optInt("year_svip");
    this.aEW = paramJSONObject.optString("svip_logo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sne
 * JD-Core Version:    0.7.0.1
 */