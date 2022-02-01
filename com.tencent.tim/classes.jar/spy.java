import org.json.JSONException;
import org.json.JSONObject;

public class spy
{
  private String aFD = "0";
  private String aFE = "1";
  private String aFF = spp.aFw;
  private String aFG = "1";
  private String aFH = "1";
  
  public static spy a(String paramString)
  {
    spy localspy = new spy();
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        localspy.aFD = paramString.optString("subscribe_entrance_enable", "0");
        localspy.aFE = paramString.optString("is_open_sharing", "1");
        localspy.aFF = paramString.optString("subscribe_account_title", spp.aFw);
        localspy.aFG = paramString.optString("newfollowlist", "1");
        localspy.aFH = paramString.optString("subscribe_publish_entrance_enable", "1");
      }
      return localspy;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public String nJ()
  {
    return this.aFD;
  }
  
  public String nK()
  {
    return this.aFE;
  }
  
  public String nL()
  {
    return this.aFF;
  }
  
  public String nM()
  {
    return this.aFG;
  }
  
  public String nN()
  {
    return this.aFH;
  }
  
  public String toString()
  {
    return "k =subscribe_entrance_enable , value = " + this.aFD + ",k =is_open_sharing , value = " + this.aFE + ",k =subscribe_account_title , value = " + this.aFF + ",k =subscribeAccountNewFollowListSwitch , value = " + this.aFG + ",k =subscribeAccountPublishEntranceSwitch , value = " + this.aFH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spy
 * JD-Core Version:    0.7.0.1
 */