import org.json.JSONException;
import org.json.JSONObject;

public class xga
{
  private String a = "0";
  private String b = "1";
  private String c = xfr.c;
  private String d = "1";
  private String e = "1";
  
  public static xga a(String paramString)
  {
    xga localxga = new xga();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        localxga.a = paramString.optString("subscribe_entrance_enable", "0");
        localxga.b = paramString.optString("is_open_sharing", "1");
        localxga.c = paramString.optString("subscribe_account_title", xfr.c);
        localxga.d = paramString.optString("newfollowlist", "1");
        localxga.e = paramString.optString("subscribe_publish_entrance_enable", "1");
      }
      return localxga;
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
 * Qualified Name:     xga
 * JD-Core Version:    0.7.0.1
 */