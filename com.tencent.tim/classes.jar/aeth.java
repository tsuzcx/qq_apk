import org.json.JSONException;
import org.json.JSONObject;

public class aeth
{
  private String aYd = "";
  private String mTips = acfp.m(2131715233);
  
  public static aeth a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aeth localaeth = new aeth();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      localaeth.mTips = paramArrayOfaeic.getString("emptyShowWording");
      localaeth.aYd = paramArrayOfaeic.getString("linkWord");
      return localaeth;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
      return localaeth;
    }
    catch (NullPointerException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaeth;
  }
  
  public String getTips()
  {
    return this.mTips;
  }
  
  public String tM()
  {
    return this.aYd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeth
 * JD-Core Version:    0.7.0.1
 */