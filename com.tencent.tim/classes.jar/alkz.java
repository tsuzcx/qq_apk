import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class alkz
{
  public static WifiInfo a(WifiManager paramWifiManager)
  {
    return paramWifiManager.getConnectionInfo();
  }
  
  public static byte[] a(NetworkInterface paramNetworkInterface)
    throws SocketException
  {
    paramNetworkInterface = new Throwable();
    QLog.d("NetworkMonitor", 1, "[getHardwareAddress] invoke");
    allb.h("mac", "getHardwareAddress", paramNetworkInterface);
    arrayOfByte = new byte[6];
    try
    {
      String str = Pandora.getRealMac(BaseApplication.getContext());
      paramNetworkInterface = str;
      if (TextUtils.isEmpty(str)) {
        paramNetworkInterface = "02:00:00:00:00:00";
      }
      paramNetworkInterface = paramNetworkInterface.replaceAll(":", "");
      int i = 0;
      while (i < 6)
      {
        arrayOfByte[i] = Integer.valueOf(paramNetworkInterface.substring(i * 2, i * 2 + 2), 16).byteValue();
        i += 1;
      }
      return arrayOfByte;
    }
    catch (Exception paramNetworkInterface)
    {
      QLog.e("NetworkMonitor", 1, "getHardwareAddress monitor exception ", paramNetworkInterface);
    }
  }
  
  @SuppressLint({"HardwareIds"})
  public static String c(WifiInfo paramWifiInfo)
  {
    paramWifiInfo = new Throwable();
    QLog.e("NetworkMonitor", 1, "[getMacAddress] invoke", paramWifiInfo);
    allb.Or("getMacAddress()");
    allb.h("mac", "getMacAddress", paramWifiInfo);
    return Pandora.getMac(BaseApplication.getContext());
  }
  
  public static Enumeration<NetworkInterface> getNetworkInterfaces()
    throws SocketException
  {
    return NetworkInterface.getNetworkInterfaces();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkz
 * JD-Core Version:    0.7.0.1
 */