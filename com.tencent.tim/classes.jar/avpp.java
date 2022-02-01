import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.PlatformInfor.1;
import cooperation.qzone.util.NetworkState;

public class avpp
{
  private static avpp a;
  private static Object lock = new Object();
  private static String versionName = "";
  private String brk;
  private TelephonyManager d = (TelephonyManager)this.mContext.getSystemService("phone");
  private int exP = -1;
  private Context mContext = BaseApplication.getContext();
  private String mDeviceId;
  private String mDeviceInfo;
  private String mMacAddress;
  
  private avpp()
  {
    try
    {
      versionName = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static avpp a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new avpp();
      }
      return a;
    }
  }
  
  private int bD(Context paramContext)
  {
    if (this.exP == -1)
    {
      ThreadManager.executeOnSubThread(new PlatformInfor.1(this, paramContext));
      return 0;
    }
    return this.exP;
  }
  
  public String Dy()
  {
    if (TextUtils.isEmpty(this.mMacAddress)) {
      this.mMacAddress = auri.rv("52b7f2");
    }
    return this.mMacAddress;
  }
  
  public String FY()
  {
    Object localObject = (WindowManager)this.mContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject).append("a=").append(Build.VERSION.SDK_INT).append('&');
    ((StringBuilder)localObject).append("p=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
    ((StringBuilder)localObject).append("f=").append(Build.MANUFACTURER).append('&');
    ((StringBuilder)localObject).append("mm=").append(aqgz.getSystemTotalMemory() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(aqgz.getCpuFrequency()).append('&');
    ((StringBuilder)localObject).append("cc=").append(aqgz.getCpuNumber()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append("3.4.4");
    return ((StringBuilder)localObject).toString();
  }
  
  public String getDeviceInfor()
  {
    if ((this.mDeviceInfo != null) && (this.mDeviceInfo.length() > 0))
    {
      localObject1 = new StringBuilder(this.mDeviceInfo);
      ((StringBuilder)localObject1).append("sharpP=").append(bD(this.mContext)).append('&');
      ((StringBuilder)localObject1).append("n=").append(getNetworkType());
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = (WindowManager)this.mContext.getSystemService("window");
    Object localObject1 = new DisplayMetrics();
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("i=").append(getIMEI()).append('&');
    ((StringBuilder)localObject2).append("imsi=").append(getIMSI()).append('&');
    ((StringBuilder)localObject2).append("mac=").append(Dy()).append('&');
    ((StringBuilder)localObject2).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject2).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject2).append("a=").append(Build.VERSION.SDK_INT).append('&');
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("sc=");
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1;; i = 0)
    {
      localStringBuilder.append(i).append('&');
      ((StringBuilder)localObject2).append("sd=").append("0").append('&');
      ((StringBuilder)localObject2).append("p=").append(((DisplayMetrics)localObject1).widthPixels).append('*').append(((DisplayMetrics)localObject1).heightPixels).append('&');
      ((StringBuilder)localObject2).append("f=").append(Build.MANUFACTURER).append('&');
      ((StringBuilder)localObject2).append("mm=").append(aqgz.getSystemTotalMemory() / 1048576L).append('&');
      ((StringBuilder)localObject2).append("cf=").append(aqgz.getCpuFrequency()).append('&');
      ((StringBuilder)localObject2).append("cc=").append(aqgz.getCpuNumber()).append('&');
      ((StringBuilder)localObject2).append("aid=").append(aqgz.getAndroidID()).append('&');
      ((StringBuilder)localObject2).append("qimei=").append(UserAction.getQIMEI()).append('&');
      this.mDeviceInfo = ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("sharpP=").append(bD(this.mContext)).append('&');
      ((StringBuilder)localObject2).append("n=").append(getNetworkType());
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public String getIMEI()
  {
    if (TextUtils.isEmpty(this.mDeviceId)) {
      this.mDeviceId = auri.getIMEI("52b7f2");
    }
    return this.mDeviceId;
  }
  
  public String getIMSI()
  {
    if (TextUtils.isEmpty(this.brk)) {
      this.brk = auri.ru("52b7f2");
    }
    return this.brk;
  }
  
  public String getNetworkType()
  {
    switch ()
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 3: 
      return "3g";
    case 2: 
      return "2g";
    case 4: 
      return "4g";
    }
    return "5g";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpp
 * JD-Core Version:    0.7.0.1
 */