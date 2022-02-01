import android.content.Context;
import android.telephony.TelephonyManager;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

public class tbc
  extends arug
{
  private static final String SDCARD_PATH = ;
  
  public static String ar(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    String str = "" + alla.a((TelephonyManager)localObject);
    localObject = "" + alla.d((TelephonyManager)localObject);
    long l1 = ("" + alla.getString(paramContext.getContentResolver(), "android_id")).hashCode();
    long l2 = str.hashCode();
    return new UUID(l1, ((String)localObject).hashCode() | l2 << 32).toString();
  }
  
  public static String getLocalIpAddress()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = alkz.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return localObject;
    }
    catch (SocketException localSocketException) {}
    return null;
  }
  
  public static String ob()
  {
    return SDCARD_PATH + File.separator + ".GameCenterWebBuffer" + File.separator + "Images/games";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbc
 * JD-Core Version:    0.7.0.1
 */