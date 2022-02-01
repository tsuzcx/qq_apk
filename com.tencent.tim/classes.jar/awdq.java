import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.BaseApplication;

public class awdq
{
  static volatile String cPr = null;
  
  public static String GP()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = j("N/A");
        if (localObject1 != "N/A")
        {
          String str = ((WifiInfo)localObject1).getBSSID();
          localObject1 = str;
          if (str == null) {
            localObject1 = "N/A";
          }
          cPr = (String)localObject1;
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public static String getBSSID()
  {
    if (cPr == null) {}
    try
    {
      if (cPr == null) {
        GP();
      }
      if (("N/A".equals(cPr)) || ("00:00:00:00:00:00".equals(cPr)) || ("FF:FF:FF:FF:FF:FF".equalsIgnoreCase(cPr))) {
        return null;
      }
    }
    finally {}
    return cPr;
  }
  
  private static Object j(Object paramObject)
  {
    Object localObject1 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (localObject1 == null) {}
    for (;;)
    {
      return paramObject;
      try
      {
        localObject1 = alkz.a((WifiManager)localObject1);
        if (localObject1 == null) {
          continue;
        }
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdq
 * JD-Core Version:    0.7.0.1
 */