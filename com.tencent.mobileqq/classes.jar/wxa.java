import org.json.JSONException;
import org.json.JSONObject;

public class wxa
{
  private String a = "0";
  private String b = "0";
  private String c = wwt.c;
  private String d = "1";
  private String e = "1";
  
  public static wxa a(String paramString)
  {
    wxa localwxa = new wxa();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        localwxa.a = paramString.optString("subscribe_entrance_enable", "0");
        localwxa.b = paramString.optString("is_open_sharing", "0");
        localwxa.c = paramString.optString("subscribe_account_title", wwt.c);
        localwxa.d = paramString.optString("newfollowlist", "1");
        localwxa.e = paramString.optString("subscribe_publish_entrance_enable", "1");
      }
      return localwxa;
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
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "k =subscribe_entrance_enable , value = " + this.a + ",k =is_open_sharing , value = " + this.b + ",k =subscribe_account_title , value = " + this.c + ",k =subscribeAccountNewFollowListSwitch , value = " + this.d + ",k =subscribeAccountPublishEntranceSwitch , value = " + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxa
 * JD-Core Version:    0.7.0.1
 */