package mqq.app;

import alkz;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.mobileqq.Pandora.util.Log;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.listener.PrivacyListener;

public class WtloginPrivacyListenerImpl
  implements PrivacyListener
{
  private static final String TAG = "WtloginPrivacyListenerImpl";
  private static volatile WtloginPrivacyListenerImpl singleton;
  private String deviceModel;
  
  private WtloginPrivacyListenerImpl()
  {
    Log.setLogCallback(new WtloginPrivacyListenerImpl.1(this));
  }
  
  public static WtloginPrivacyListenerImpl getSingleton()
  {
    if (singleton == null) {}
    try
    {
      if (singleton == null) {
        singleton = new WtloginPrivacyListenerImpl();
      }
      return singleton;
    }
    finally {}
  }
  
  public String getAndroidID(Context paramContext)
  {
    return Pandora.getAndroidID(paramContext);
  }
  
  public String getBssid(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = alkz.a(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.getBSSID();
          if (paramContext != null) {
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.d("WtloginPrivacyListenerImpl", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  public String getDeviceModel()
  {
    if (TextUtils.isEmpty(this.deviceModel)) {
      this.deviceModel = Build.MODEL;
    }
    return this.deviceModel;
  }
  
  public String getImsi(Context paramContext)
  {
    return Pandora.getImsi(paramContext);
  }
  
  public String getMac(Context paramContext)
  {
    return Pandora.getMac(paramContext);
  }
  
  public String getSsid(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = alkz.a(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.getSSID();
          if (paramContext != null) {
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.d("WtloginPrivacyListenerImpl", 1, paramContext, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.WtloginPrivacyListenerImpl
 * JD-Core Version:    0.7.0.1
 */