import android.text.TextUtils;
import org.json.JSONObject;

public class jyt
{
  public int MS;
  public String Vf;
  public String Vg;
  public String Vh;
  public String Vi;
  public String hL;
  public String mAppName;
  public String mAppid;
  public String mIconUrl;
  public int mJumpType;
  public String mPackageName;
  public String mScheme;
  
  public static jyt a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      jyt localjyt = new jyt();
      paramString = new JSONObject(paramString);
      localjyt.MS = paramString.optInt("bannerType");
      localjyt.mIconUrl = paramString.optString("iconUrl");
      localjyt.Vf = paramString.optString("abstractText");
      localjyt.mJumpType = paramString.optInt("jumpType");
      localjyt.hL = paramString.optString("linkUrl");
      localjyt.mAppid = paramString.optString("appid");
      localjyt.mScheme = paramString.optString("scheme");
      localjyt.mPackageName = paramString.optString("packagename");
      localjyt.Vg = paramString.optString("androidDownloadUrl");
      localjyt.Vh = paramString.optString("iOSDownloadUrl");
      localjyt.mAppName = paramString.optString("appName");
      localjyt.Vi = paramString.optString("apkUrl");
      return localjyt;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public boolean yP()
  {
    if ((TextUtils.isEmpty(this.mIconUrl)) || (TextUtils.isEmpty(this.Vf))) {}
    while (((this.MS == 2) && (TextUtils.isEmpty(this.hL))) || ((this.MS == 1) && ((TextUtils.isEmpty(this.mPackageName)) || (TextUtils.isEmpty(this.Vi))))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyt
 * JD-Core Version:    0.7.0.1
 */