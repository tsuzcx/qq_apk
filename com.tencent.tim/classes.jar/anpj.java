import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.qmsp.sdk.u.U;
import com.tencent.qphone.base.util.QLog;

public class anpj
{
  private static anpj a;
  private String androidID = "";
  private String cgb = "";
  private String cgc = "";
  private String cgd = "";
  private String imei = "";
  private String imei2 = "";
  private String imsi = "";
  private String mac = "";
  private String model = "";
  private String oaid = "";
  
  public anpj(Context paramContext)
  {
    fe(paramContext);
    fd(paramContext);
    Rt();
    fb(paramContext);
    fc(paramContext);
    ff(paramContext);
  }
  
  private void Rt()
  {
    this.model = Build.MODEL;
  }
  
  public static anpj a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anpj(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void fb(Context paramContext)
  {
    try
    {
      U.init_o(paramContext, true, true);
      U.getOAID(new anpk(this));
      this.oaid = U.getOAIDSync(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("TimBeaconPrivacyInfo", 1, "initOAID exception", paramContext);
    }
  }
  
  private void fc(Context paramContext)
  {
    paramContext = Pandora.getAndroidID(paramContext);
    if (paramContext != null) {
      this.androidID = paramContext.toLowerCase();
    }
  }
  
  private void fd(Context paramContext)
  {
    this.mac = Pandora.getRealMac(paramContext);
  }
  
  private void fe(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      paramContext = Pandora.getDeviceID(paramContext);
      if (paramContext != null) {
        this.imei = paramContext.toLowerCase();
      }
      this.imei2 = this.imei;
      this.cgb = this.imei;
      return;
    }
    this.imei2 = Pandora.getImei(paramContext, 1);
    this.cgb = Pandora.getMeid(paramContext);
  }
  
  private void ff(Context paramContext)
  {
    paramContext = Pandora.getImsi(paramContext);
    if (paramContext != null) {
      this.imsi = paramContext.toLowerCase();
    }
  }
  
  public String getAndroidID()
  {
    return this.androidID;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImei2()
  {
    return this.imei2;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getMeid()
  {
    return this.cgb;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getOaid()
  {
    return this.oaid;
  }
  
  public String getWifiMacAddress()
  {
    return this.cgc;
  }
  
  public String getWifiSSID()
  {
    return this.cgd;
  }
  
  public String toString()
  {
    return "QQBeaconPrivateInfo{androidID='" + this.androidID + '\'' + ", imei='" + this.imei + '\'' + ", imei2='" + this.imei2 + '\'' + ", imsi='" + this.imsi + '\'' + ", meid='" + this.cgb + '\'' + ", model='" + this.model + '\'' + ", mac='" + this.mac + '\'' + ", wifiMacAddress='" + this.cgc + '\'' + ", wifiSSID='" + this.cgd + '\'' + ", oaid='" + this.oaid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpj
 * JD-Core Version:    0.7.0.1
 */