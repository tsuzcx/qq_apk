import UserGrowth.downloadConfig;
import UserGrowth.stAioAction;
import UserGrowth.stCallInfo;
import UserGrowth.stCommentConfig;
import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stLinkConfig;
import UserGrowth.stPopWindowsConfig;
import UserGrowth.stUserAuth;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;

public class umu
{
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  private SparseArray<stGlobalConfig> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private stPopWindowsConfig a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if ((localstGlobalConfig != null) && (localstGlobalConfig.windows_config != null) && (localstGlobalConfig.windows_config.size() > 0)) {
      return (stPopWindowsConfig)localstGlobalConfig.windows_config.get(0);
    }
    return null;
  }
  
  public static umu a()
  {
    return umw.a();
  }
  
  private boolean b(int paramInt)
  {
    return (a(paramInt) == null) || (a(paramInt).linkConfig == null);
  }
  
  private void c(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {
      return;
    }
    uya.d("WSGlobalConfigLog", "globalConfig info:stGlobalConfig: {\nis_call_weishi=" + paramstGlobalConfig.is_call_weishi + ", link_strategy_type=" + paramstGlobalConfig.link_strategy_type + ", open_4g_autodownload=" + paramstGlobalConfig.open_4g_autodownload + ", cache_size=" + paramstGlobalConfig.cache_size + ", is_direct_open=" + paramstGlobalConfig.is_direct_open + ", encrypted_deviceid=" + paramstGlobalConfig.encrypted_deviceid + "\ncommentConfig=" + paramstGlobalConfig.commentConfig + "\nlinkConfig=" + paramstGlobalConfig.linkConfig + "\ndownload=" + paramstGlobalConfig.download + "\nmapExt=" + paramstGlobalConfig.mapExt + "\n}");
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.download == null);
  }
  
  @Deprecated
  public int a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public int a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.link_strategy_type;
    }
    return 1;
  }
  
  public stCallInfo a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) {
      return null;
    }
    return this.jdField_a_of_type_UserGrowthStGlobalConfig.callinfo;
  }
  
  public stGlobalConfig a(int paramInt)
  {
    return (stGlobalConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public stJumpInfo a(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.jumpinfo;
    }
    return null;
  }
  
  public stUserAuth a()
  {
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) {
      return null;
    }
    return this.jdField_a_of_type_UserGrowthStGlobalConfig.user_auth;
  }
  
  public String a()
  {
    if (!f()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.packageName;
    }
    return "";
  }
  
  public void a(int paramInt, stGlobalConfig paramstGlobalConfig)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramstGlobalConfig);
    this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
    uya.d("WSGlobalConfigLog", "initGlobalConfig globalConfig:" + paramstGlobalConfig);
    c(paramstGlobalConfig);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a(1, paramstGlobalConfig);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_UserGrowthStGlobalConfig == null) || (this.jdField_a_of_type_UserGrowthStGlobalConfig.open_4g_autodownload != 0);
  }
  
  public boolean a(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.isOpenVideoPage;
    }
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    stJumpInfo localstJumpInfo = a(paramInt2);
    boolean bool1 = bool2;
    if (localstJumpInfo != null)
    {
      bool1 = bool2;
      if (localstJumpInfo.index >= 0)
      {
        bool1 = bool2;
        if (localstJumpInfo.id > 0)
        {
          uya.a("WSGlobalConfigLog", "全屏阻断页是第" + localstJumpInfo.index + "个,id为：" + localstJumpInfo.id);
          bool1 = bool2;
          if (paramInt1 == localstJumpInfo.index) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    if (!f()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.vendorId;
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.callCount;
    }
    return 10000;
  }
  
  public String b()
  {
    if (!f()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.downloadUrl;
    }
    return "";
  }
  
  public void b(stGlobalConfig paramstGlobalConfig)
  {
    if ((paramstGlobalConfig == null) || (paramstGlobalConfig.aioAction == null)) {
      return;
    }
    LocalMultiProcConfig.putInt4Uin("global_key_recommend_page_style", paramstGlobalConfig.aioAction.landingPage, uyo.a());
  }
  
  public boolean b()
  {
    return (!f()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preload);
  }
  
  public int c()
  {
    if (!f()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.versionCode;
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    if (!b(paramInt)) {
      return a(paramInt).linkConfig.downloadCount;
    }
    return 10000;
  }
  
  public String c()
  {
    if (!f()) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.preloadDownloadUrl;
    }
    return "";
  }
  
  public boolean c()
  {
    return (!f()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.appStoreSwitch);
  }
  
  public int d()
  {
    stGlobalConfig localstGlobalConfig = a(1);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.cache_size;
    }
    return 14;
  }
  
  public int d(int paramInt)
  {
    stPopWindowsConfig localstPopWindowsConfig = a(paramInt);
    if (localstPopWindowsConfig != null) {
      return localstPopWindowsConfig.index;
    }
    return -1;
  }
  
  public String d()
  {
    if (!f())
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl))
      {
        this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl = (unq.a() + "&versioncode=" + c());
        uya.c("WeishiDownloadUtil", "服务器下发QQDownloadUrl失败，使用默认的:" + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      }
      uya.d("WeishiDownloadUtil", "服务器下发QQDownloadUrl: " + this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl);
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.download.qqDownloadUrl;
    }
    return unq.a();
  }
  
  public boolean d()
  {
    return (!f()) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.download.enableRock);
  }
  
  public int e(int paramInt)
  {
    stGlobalConfig localstGlobalConfig = a(paramInt);
    if (localstGlobalConfig != null) {
      return localstGlobalConfig.playerType;
    }
    return 0;
  }
  
  public String e()
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
      uya.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
      return str;
    }
    if (this.jdField_a_of_type_UserGrowthStGlobalConfig != null)
    {
      str = this.jdField_a_of_type_UserGrowthStGlobalConfig.encrypted_deviceid;
      if (!TextUtils.isEmpty(str))
      {
        LocalMultiProcConfig.putString("weishi_usergrowth", "encryptedDeviceId", str);
        uya.a("WSGlobalConfigLog", "LocalMultiProcConfig save encrypted_deviceid:" + str);
        return str;
      }
    }
    String str = LocalMultiProcConfig.getString("weishi_usergrowth", "encryptedDeviceId", "");
    uya.a("WSGlobalConfigLog", "LocalMultiProcConfig load encrypted_deviceid:" + str);
    return str;
  }
  
  public boolean e()
  {
    return LocalMultiProcConfig.getInt4Uin("global_key_recommend_page_style", 0, uyo.a()) == 1;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_UserGrowthStGlobalConfig != null) && (this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig != null)) {
      return this.jdField_a_of_type_UserGrowthStGlobalConfig.commentConfig.guideText;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umu
 * JD-Core Version:    0.7.0.1
 */