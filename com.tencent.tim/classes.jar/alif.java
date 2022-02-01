import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class alif
  implements INetInfoHandler
{
  private boolean Tn = true;
  public String bWv;
  public String bWw;
  public String bWx;
  private String bWy;
  
  public alif()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this);
    dGi();
  }
  
  public static String aF(Context paramContext)
  {
    try
    {
      long l = System.nanoTime();
      paramContext = alkz.a((WifiManager)paramContext.getSystemService("wifi"));
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        if (QLog.isColorLevel()) {
          QLog.e("PttIpSaver", 2, "getWifiMac " + paramContext + " time=" + (System.nanoTime() - l) / 1000000L);
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String xV()
  {
    return "XGIdentifier";
  }
  
  public void clear(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PttIpSaver", 2, "clear ip:" + paramInt);
    }
    if (paramInt == -1)
    {
      this.bWv = null;
      this.bWw = null;
      this.bWx = null;
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        this.bWv = null;
        return;
      }
      if (paramInt == 1)
      {
        this.bWw = null;
        return;
      }
    } while (paramInt != 2);
    this.bWx = null;
  }
  
  public void dGi()
  {
    try
    {
      this.bWy = aF(BaseApplicationImpl.getContext());
      this.Tn = true;
      if (this.bWy == null)
      {
        this.bWy = xV();
        this.Tn = false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.bWy);
      }
      return;
    }
    finally {}
  }
  
  public void destroy()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean isWifi()
  {
    try
    {
      boolean bool = this.Tn;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onNetMobile2None()
  {
    try
    {
      clear(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.bWy = aF(BaseApplicationImpl.getContext());
      clear(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetMobile2Wifi  " + this.bWy);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.bWy = xV();
      this.Tn = false;
      clear(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetNone2Mobile  " + this.bWy);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.bWy = aF(BaseApplicationImpl.getContext());
      this.Tn = true;
      clear(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetNone2Wifi  " + this.bWy);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.bWy = xV();
      this.Tn = false;
      clear(-1);
      if (QLog.isColorLevel()) {
        QLog.e("PttIpSaver", 2, "onNetWifi2Mobile  " + this.bWy);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      clear(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String xW()
  {
    try
    {
      String str = this.bWy;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alif
 * JD-Core Version:    0.7.0.1
 */