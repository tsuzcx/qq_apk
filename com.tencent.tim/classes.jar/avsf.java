import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public final class avsf
  implements IUploadEnv, IUploadSoLoader
{
  avsh a = new avsh();
  private volatile boolean doB = true;
  
  public avsf()
  {
    this.a.eBL();
  }
  
  private static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {}
      for (paramContext = "getActiveNetworkInfo null";; paramContext = localNetworkInfo.toString())
      {
        QLog.d("UploadEnv", 1, paramContext);
        return localNetworkInfo;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      QLog.d("UploadEnv", 1, "fail to get active network info " + paramContext.toString());
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static int lv(int paramInt)
  {
    if (!nD(paramInt)) {
      return 1;
    }
    try
    {
      paramInt = com.tencent.upload.network.NetworkState.getNetworkStackType();
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QZLog.e("UploadEnv", "getIpStack error", localUnsatisfiedLinkError);
    }
    return 1;
  }
  
  public static boolean nD(int paramInt)
  {
    int i = QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadEnableV6RouteForAll", 7);
    if (paramInt != 1) {
      QZLog.d("UploadEnv", 1, "enableV6Switch:" + (i >> paramInt & 0x1) + " type:" + paramInt);
    }
    return (i >> paramInt & 0x1) == 1;
  }
  
  public String getApnName()
  {
    return cooperation.qzone.util.NetworkState.getAPN();
  }
  
  public String getBSSID()
  {
    return aqgz.getBSSID(BaseApplication.getContext());
  }
  
  public int getBatchControlCount()
  {
    return 8;
  }
  
  public int getCurrentNetworkCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public int getFileConcurrentCount()
  {
    return 3;
  }
  
  public int getMobileOperatorCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public String getProviderName()
  {
    return cooperation.qzone.util.NetworkState.getProviderName();
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return aqul.getSDKPrivatePath(paramString);
  }
  
  public String getSoVersion()
  {
    return "v1.3";
  }
  
  public int getSocketCount()
  {
    return 2;
  }
  
  public boolean isAvailable()
  {
    boolean bool = cooperation.qzone.util.NetworkState.isNetSupport();
    this.doB = isNetworkAvailable(BaseApplication.getContext());
    QLog.d("upload2:", 2, "msf network isAvailable:" + bool + " observer:" + this.doB);
    return (bool) && (this.doB);
  }
  
  public boolean isMobile()
  {
    return cooperation.qzone.util.NetworkState.isMobile();
  }
  
  public boolean isWap()
  {
    return cooperation.qzone.util.NetworkState.isWap();
  }
  
  public boolean isWifi()
  {
    return cooperation.qzone.util.NetworkState.isWifiConn();
  }
  
  public boolean loadLibrary(String paramString)
  {
    boolean bool = this.a.loadLibrary(paramString);
    QLog.d("UploadEnv", 1, "useDownloadedSo " + bool);
    if (bool) {
      return true;
    }
    try
    {
      QLog.d("UploadEnv", 1, "try to load library: " + paramString + " from system lib");
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("UploadEnv", 1, "cannot load library " + paramString + " from system lib", localThrowable);
    }
    return false;
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver");
    }
    cooperation.qzone.util.NetworkState.addListener(new avsg(this, paramNetworkStateObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsf
 * JD-Core Version:    0.7.0.1
 */