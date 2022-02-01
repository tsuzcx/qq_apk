import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeru
{
  private String bAG = "https://club.vip.qq.com/grouphaoma/home?_wv=131072&_fv=0&_proxy=1&from={from}";
  private String bAH = "https://club.vip.qq.com/grouphaoma/mine?_wv=131072&_fv=0&_proxy=1&from={from}&groupnum={groupnum}";
  private String bAI = "https://mc.vip.qq.com/group/create2k?_wwv=4&_wv=1027&_wvx=3";
  private String bAJ = "https://mc.vip.qq.com/group/create3k?_wwv=4&_wv=1027&_wvx=3";
  public boolean bWa;
  public boolean bWb;
  
  @NonNull
  public static aeru a(String paramString)
  {
    boolean bool2 = false;
    aeru localaeru = new aeru();
    if (TextUtils.isEmpty(paramString)) {
      return localaeru;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("showCreateIcon") == 1)
        {
          bool1 = true;
          localaeru.bWb = bool1;
          localaeru.bAG = paramString.optString("pretty_home", "https://club.vip.qq.com/grouphaoma/home?_wv=131072&_fv=0&_proxy=1&from={from}");
          localaeru.bAH = paramString.optString("pretty_mine", "https://club.vip.qq.com/grouphaoma/mine?_wv=131072&_fv=0&_proxy=1&from={from}&groupnum={groupnum}");
          localaeru.bAI = paramString.optString("2k", "https://mc.vip.qq.com/group/create2k?_wwv=4&_wv=1027&_wvx=3");
          localaeru.bAJ = paramString.optString("3k", "https://mc.vip.qq.com/group/create3k?_wwv=4&_wv=1027&_wvx=3");
          bool1 = bool2;
          if (paramString.optInt("limit_off", 0) == 1) {
            bool1 = true;
          }
          localaeru.bWa = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vip_pretty.ConfigProcessor", 1, localaeru.toString());
          return localaeru;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("vip_pretty.ConfigProcessor", 1, "json parse error:" + paramString);
        return localaeru;
      }
      boolean bool1 = false;
    }
  }
  
  public String aU(String paramString1, String paramString2)
  {
    return this.bAH.replace("{from}", paramString1).replace("{groupnum}", paramString2);
  }
  
  public String kl(String paramString)
  {
    return this.bAG.replace("{from}", paramString);
  }
  
  public String tI()
  {
    return this.bAI;
  }
  
  public String tJ()
  {
    return this.bAJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeru
 * JD-Core Version:    0.7.0.1
 */