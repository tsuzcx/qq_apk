import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.HashSet;
import java.util.Set;

public class ajcn
{
  public long ace;
  public long acf;
  public String appId;
  public String appName;
  public int appState;
  public int appType;
  public int appVersion;
  public String bQE;
  public String bQF;
  public String bQG = "";
  public Set<String> cH = new HashSet();
  public String cacheKey;
  public long expirationTime;
  public Bundle extras;
  public String iconUrl;
  public String pkgName;
  public int platform;
  public String sdkVersion;
  public String signature;
  public String wording;
  
  public ajcn(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.appType = paramInt;
    this.cacheKey = ao(paramString, paramInt);
    this.extras = new Bundle();
  }
  
  public static String ao(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static String[] q(String paramString)
  {
    return paramString.split("_");
  }
  
  public boolean aqo()
  {
    return this.expirationTime > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean aqp()
  {
    return this.ace > NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String toString()
  {
    return "MiniAppInfo: appId=" + this.appId + ", appType=" + this.appType + ", platform=" + this.platform + ", appName=" + this.appName + ", appState=" + this.appState + ", appVersion=" + this.appVersion + ", appPkgUrl=" + this.bQG + ", wording=" + this.wording + ", infoNextReqMillis=" + this.ace;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcn
 * JD-Core Version:    0.7.0.1
 */