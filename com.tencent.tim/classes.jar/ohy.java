import UserGrowth.downloadConfig;
import UserGrowth.stCommentConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stLinkConfig;
import UserGrowth.stPopWindowsConfig;
import android.text.TextUtils;
import com.google.gson.Gson;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ohy
{
  private stGlobalConfig b;
  private ConcurrentHashMap<String, String> bD = new ConcurrentHashMap();
  private Map<String, stGlobalConfig> fm = new HashMap();
  
  private boolean GO()
  {
    return (this.b == null) || (this.b.linkConfig == null);
  }
  
  private boolean GS()
  {
    return (this.b == null) || (this.b.download == null);
  }
  
  private stPopWindowsConfig a()
  {
    if ((this.b != null) && (this.b.windows_config != null) && (this.b.windows_config.size() > 0)) {
      return (stPopWindowsConfig)this.b.windows_config.get(0);
    }
    return null;
  }
  
  public static ohy a()
  {
    return ohy.a.b();
  }
  
  private void b(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {
      return;
    }
    ooz.e("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + paramstGlobalConfig.is_call_weishi + ", link_strategy_type=" + paramstGlobalConfig.link_strategy_type + ", open_4g_autodownload=" + paramstGlobalConfig.open_4g_autodownload + ", cache_size=" + paramstGlobalConfig.cache_size + ", is_direct_open=" + paramstGlobalConfig.is_direct_open + ", encrypted_deviceid=" + paramstGlobalConfig.encrypted_deviceid + "\ncommentConfig=" + paramstGlobalConfig.commentConfig + "\nlinkConfig=" + paramstGlobalConfig.linkConfig + "\ndownload=" + paramstGlobalConfig.download + "\nmapExt=" + paramstGlobalConfig.mapExt + "\n}");
  }
  
  public boolean GM()
  {
    return (this.b == null) || (this.b.open_4g_autodownload != 0);
  }
  
  public boolean GN()
  {
    if (!GO()) {
      return this.b.linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public boolean GP()
  {
    return (!GS()) && (this.b.download.preload);
  }
  
  public boolean GQ()
  {
    return (!GS()) && (this.b.download.appStoreSwitch);
  }
  
  public boolean GR()
  {
    return (!GS()) && (this.b.download.enableRock);
  }
  
  public stGlobalConfig a()
  {
    return this.b;
  }
  
  public stJumpInfo a()
  {
    if (this.b != null) {
      return this.b.jumpinfo;
    }
    return null;
  }
  
  public void a(stGlobalConfig paramstGlobalConfig, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.fm.put(paramString, paramstGlobalConfig);
    }
    this.b = paramstGlobalConfig;
    ooz.e("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
    oog.c(paramstGlobalConfig);
    b(paramstGlobalConfig);
  }
  
  public void beV()
  {
    this.bD.clear();
  }
  
  public void f(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null)) {
      this.bD.put(paramString, new Gson().toJson(paramMap));
    }
  }
  
  public String fv(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.bD.get(paramString);
    }
    return "";
  }
  
  public void initGlobalConfig(stGlobalConfig paramstGlobalConfig)
  {
    a(paramstGlobalConfig, "");
  }
  
  public String lo()
  {
    if (!GS()) {
      return this.b.download.packageName;
    }
    return "";
  }
  
  public String lp()
  {
    if (!GS()) {
      return this.b.download.downloadUrl;
    }
    return "";
  }
  
  public String lq()
  {
    if (!GS()) {
      return this.b.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public String lr()
  {
    if (!GS())
    {
      if (TextUtils.isEmpty(this.b.download.qqDownloadUrl))
      {
        this.b.download.qqDownloadUrl = (oir.lv() + "&versioncode=" + rt());
        ooz.w("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.b.download.qqDownloadUrl);
      }
      ooz.e("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.b.download.qqDownloadUrl);
      return this.b.download.qqDownloadUrl;
    }
    return oir.lv();
  }
  
  public String ls()
  {
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.encrypted_deviceid)))
    {
      LocalMultiProcConfig.putString("weishi_usergrowth", "encryptedDeviceId", this.b.encrypted_deviceid);
      str = this.b.encrypted_deviceid;
      ooz.i("WSGlobalConfigLog", "LocalMultiProcConfig save encrypted_deviceid:" + str);
      return str;
    }
    String str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
    ooz.i("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
    return str;
  }
  
  public String lt()
  {
    if ((this.b != null) && (this.b.commentConfig != null)) {
      return this.b.commentConfig.guideText;
    }
    return "";
  }
  
  public void pA(String paramString)
  {
    this.fm.remove(paramString);
  }
  
  public void pz(String paramString)
  {
    this.b = ((stGlobalConfig)this.fm.get(paramString));
  }
  
  public int rp()
  {
    if (this.b != null) {
      return this.b.link_strategy_type;
    }
    return 1;
  }
  
  public int rq()
  {
    if (!GO()) {
      return this.b.linkConfig.callCount;
    }
    return 10000;
  }
  
  public int rr()
  {
    if (!GO()) {
      return this.b.linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public int rs()
  {
    if (!GS()) {
      return this.b.download.vendorId;
    }
    return 0;
  }
  
  public int rt()
  {
    if (!GS()) {
      return this.b.download.versionCode;
    }
    return 0;
  }
  
  public int ru()
  {
    if (this.b != null) {
      return this.b.cache_size;
    }
    return 14;
  }
  
  public int rv()
  {
    stPopWindowsConfig localstPopWindowsConfig = a();
    if (localstPopWindowsConfig != null) {
      return localstPopWindowsConfig.index;
    }
    return -1;
  }
  
  static class a
  {
    private static final ohy a = new ohy(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohy
 * JD-Core Version:    0.7.0.1
 */