import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import cooperation.wadl.ipc.WadlParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ascg
{
  private static String androidId = ;
  private static int elE;
  public static String imei = auri.getIMEI("b84cf5");
  private static String imsi = aqgz.getIMSI();
  public long DZ;
  public WadlParams a;
  public String apkChannel = "";
  private long awV;
  public String bXT;
  private String cEi;
  public String cEj;
  public String cEk;
  public String cEl;
  private boolean ddQ;
  public int errCode;
  private String mChannelId;
  public String packageName;
  public String taskId;
  
  static
  {
    try
    {
      elE = aqgz.LU();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static ascg a()
  {
    ascg localascg = new ascg();
    try
    {
      localascg.ddQ = AppNetConnInfo.isWifiConn();
      localascg.awV = (aqgz.getSystemAvaialbeMemory() / 1048576L);
      localascg.cEi = String.valueOf(aqgz.getSDCardMemory()[1]);
      localascg.cEj = "";
      localascg.errCode = 0;
      return localascg;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localascg;
  }
  
  public String DJ()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!TextUtils.isEmpty(androidId))
        {
          String str1 = androidId;
          localJSONObject.put("androidId", str1);
          if (TextUtils.isEmpty(imei)) {
            break label161;
          }
          str1 = imei;
          localJSONObject.put("imei", str1);
          if (!TextUtils.isEmpty(imsi))
          {
            str1 = imsi;
            localJSONObject.put("imsi", str1);
            localJSONObject.put("mobileCarriers", elE);
            localJSONObject.put("isWifiStatusOn", this.ddQ);
            localJSONObject.put("leftMemorySize", this.awV);
            localJSONObject.put("leftDiskSize", this.cEi);
            localJSONObject.put("downloadRate", this.cEj);
            localJSONObject.put("pageUrl", this.cEk);
            return localJSONObject.toString();
          }
          str1 = "";
          continue;
        }
        str2 = "";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label161:
      String str2 = "";
    }
  }
  
  public ascg a(int paramInt)
  {
    this.errCode = paramInt;
    return this;
  }
  
  public ascg a(String paramString)
  {
    this.cEj = paramString;
    return this;
  }
  
  public void f(WadlParams paramWadlParams)
  {
    this.a = paramWadlParams;
  }
  
  public String getChannelId()
  {
    return this.mChannelId;
  }
  
  public void setChannelId(String paramString)
  {
    this.mChannelId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ascg
 * JD-Core Version:    0.7.0.1
 */