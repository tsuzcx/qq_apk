import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aetx
{
  private String bBw = "";
  private String bBx = "";
  private boolean bWv;
  private int cPi;
  private String hL = "";
  
  public static aetx a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    aetx localaetx = new aetx();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfaeic.toString());
      }
      a(localaetx, paramArrayOfaeic);
      return localaetx;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaetx;
  }
  
  public static void a(aetx paramaetx, JSONObject paramJSONObject)
  {
    if ((paramaetx == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.isDev()) && (AudioHelper.jY(10) == 1)) {
        AudioHelper.UA(acfp.m(2131715226));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", acfp.m(2131715219));
        paramJSONObject.put("hightLightContent", acfp.m(2131715222));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
        if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
          paramaetx.bWv = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
        }
        if (paramJSONObject.has("plainContent")) {
          paramaetx.bBw = paramJSONObject.optString("plainContent");
        }
        if (paramJSONObject.has("hightLightContent")) {
          paramaetx.bBx = paramJSONObject.optString("hightLightContent");
        }
        if (paramJSONObject.has("showTimes")) {
          paramaetx.cPi = paramJSONObject.optInt("showTimes");
        }
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramaetx.hL = paramJSONObject.optString("linkUrl");
        return;
      }
      catch (Exception localException)
      {
        break label81;
      }
    }
  }
  
  public int Cy()
  {
    return this.cPi;
  }
  
  public String aL()
  {
    return this.hL;
  }
  
  public boolean ahW()
  {
    return this.bWv;
  }
  
  public String getPlainContent()
  {
    return this.bBw;
  }
  
  public String ua()
  {
    return this.bBx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetx
 * JD-Core Version:    0.7.0.1
 */