import UserGrowth.downloadConfig;
import UserGrowth.stAioAction;
import UserGrowth.stCommentConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stLinkConfig;
import UserGrowth.stPopWindowsConfig;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ugb
{
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private Map<String, stGlobalConfig> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static ugb a()
  {
    return ugd.a();
  }
  
  private void c(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {
      return;
    }
    upe.d("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + paramstGlobalConfig.is_call_weishi + ", link_strategy_type=" + paramstGlobalConfig.link_strategy_type + ", open_4g_autodownload=" + paramstGlobalConfig.open_4g_autodownload + ", cache_size=" + paramstGlobalConfig.cache_size + ", is_direct_open=" + paramstGlobalConfig.is_direct_open + ", encrypted_deviceid=" + paramstGlobalConfig.encrypted_deviceid + "\ncommentConfig=" + paramstGlobalConfig.commentConfig + "\nlinkConfig=" + paramstGlobalConfig.linkConfig + "\ndownload=" + paramstGlobalConfig.download + "\nmapExt=" + paramstGlobalConfig.mapExt + "\n}");
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig == null);
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.download == null);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public stGlobalConfig a()
  {
    return this.jdField_a_of_type_UserGrowthStGlobalConfig;
  }
  
  public stJumpInfo a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.jumpinfo;
    }
    return null;
  }
  
  public stPopWindowsConfig a()
  {
    if ((this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.windows_config != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.windows_config.size() > 0)) {
      return (stPopWindowsConfig)this.jdField_a_of_type_UserGrowthStGlobalConfig.windows_config.get(0);
    }
    return null;
  }
  
  public String a()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.packageName;
    }
    return "";
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a(paramstGlobalConfig, "");
  }
  
  public void a(stGlobalConfig paramstGlobalConfig, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramstGlobalConfig);
    }
    this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
    upe.d("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
    uof.a(paramstGlobalConfig);
    c(paramstGlobalConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_UserGrowthStGlobalConfig = ((stGlobalConfig)this.jdField_a_of_type_JavaUtilMap.get(paramString));
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new Gson().toJson(paramMap));
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.open_4g_autodownload != 0);
  }
  
  public int b()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.callCount;
    }
    return 10000;
  }
  
  public String b()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.downloadUrl;
    }
    return "";
  }
  
  public void b(stGlobalConfig paramstGlobalConfig)
  {
    if ((paramstGlobalConfig == null) || (paramstGlobalConfig.aioAction == null)) {
      return;
    }
    LocalMultiProcConfig.putInt4Uin("global_key_recommend_page_style", paramstGlobalConfig.aioAction.landingPage, ups.a());
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public boolean b()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public int c()
  {
    if (!g()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public String c()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public boolean c()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preload);
  }
  
  public int d()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.vendorId;
    }
    return 0;
  }
  
  public String d()
  {
    if (!h())
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl))
      {
        this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl = (ugx.a() + "&versioncode=" + e());
        upe.c("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      }
      upe.d("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl;
    }
    return ugx.a();
  }
  
  public boolean d()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.appStoreSwitch);
  }
  
  public int e()
  {
    if (!h()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.versionCode;
    }
    return 0;
  }
  
  public String e()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
      upe.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
      return str;
    }
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
    {
      str = this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid;
      if (!TextUtils.isEmpty(str))
      {
        LocalMultiProcConfig.putString("weishi_usergrowth", "encryptedDeviceId", str);
        upe.a("WSGlobalConfigLog", "LocalMultiProcConfig save encrypted_deviceid:" + str);
        return str;
      }
    }
    String str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
    upe.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
    return str;
  }
  
  public boolean e()
  {
    return (!h()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.enableRock);
  }
  
  public int f()
  {
    stGlobalConfig localstGlobalConfig = (stGlobalConfig)this.jdField_a_of_type_JavaUtilMap.get("global_key_recommend");
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.cache_size;
    }
    return 14;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig != null)) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig.guideText;
    }
    return "";
  }
  
  public boolean f()
  {
    return LocalMultiProcConfig.getInt4Uin("global_key_recommend_page_style", 0, ups.a()) == 1;
  }
  
  public int g()
  {
    stPopWindowsConfig localstPopWindowsConfig = a();
    if (localstPopWindowsConfig != null) {
      return localstPopWindowsConfig.index;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugb
 * JD-Core Version:    0.7.0.1
 */