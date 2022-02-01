import org.json.JSONObject;

public class spq
{
  private String aFx = spp.aFv;
  private String aFy = "1";
  private String aFz = spp.aFu;
  
  public static spq a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      spq localspq = new spq();
      paramString = new JSONObject(paramString);
      localspq.aFx = paramString.optString("mine_videostory_entrance", spp.aFv);
      localspq.aFy = paramString.optString("enable_click_take_picture", "1");
      localspq.aFz = paramString.optString("mine_videostory_drawer_entrance", spp.aFu);
      return localspq;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String nF()
  {
    return this.aFx;
  }
  
  public String nG()
  {
    return this.aFy;
  }
  
  public String nH()
  {
    return this.aFz;
  }
  
  public String toString()
  {
    return "k = mine_videostory_entrance, value = " + this.aFx + "\n k = enableClickTakePicture, value = " + this.aFy + "\n k = mine_videostory_chouti_entrance, value = " + this.aFz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spq
 * JD-Core Version:    0.7.0.1
 */