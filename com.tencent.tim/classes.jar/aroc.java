import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class aroc
{
  public static String APN_TYPE_3GNET = "3gnet";
  public static String APN_TYPE_3GWAP = "3gwap";
  public static String APN_TYPE_CMNET;
  public static String APN_TYPE_CMWAP;
  public static String APN_TYPE_CTNET = "ctnet";
  public static String APN_TYPE_CTWAP = "ctwap";
  public static String APN_TYPE_UNINET;
  public static String APN_TYPE_UNIWAP;
  
  static
  {
    APN_TYPE_CMNET = "cmnet";
    APN_TYPE_CMWAP = "cmwap";
    APN_TYPE_UNINET = "uninet";
    APN_TYPE_UNIWAP = "uniwap";
  }
  
  public static String bD(Context paramContext)
  {
    String str1 = "nomatch";
    String str2 = AppNetConnInfo.getCurrentAPN();
    paramContext = str1;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(APN_TYPE_CTNET)) {
        break label32;
      }
      paramContext = APN_TYPE_CTNET;
    }
    label32:
    do
    {
      return paramContext;
      if (str2.startsWith(APN_TYPE_CTWAP)) {
        return APN_TYPE_CTWAP;
      }
      if (str2.startsWith(APN_TYPE_CMNET)) {
        return APN_TYPE_CMNET;
      }
      if (str2.startsWith(APN_TYPE_CMWAP)) {
        return APN_TYPE_CMWAP;
      }
      if (str2.startsWith(APN_TYPE_UNINET)) {
        return APN_TYPE_UNINET;
      }
      if (str2.startsWith(APN_TYPE_UNIWAP)) {
        return APN_TYPE_UNIWAP;
      }
      if (str2.startsWith(APN_TYPE_3GNET)) {
        return APN_TYPE_3GNET;
      }
      paramContext = str1;
    } while (!str2.startsWith(APN_TYPE_3GWAP));
    return APN_TYPE_3GWAP;
  }
  
  public static int getNetType(Context paramContext)
  {
    int i = 0;
    switch (AppNetConnInfo.getConnInfo())
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NetUtil", 2, "getNetType " + i);
      }
      return i;
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        break;
      case 1: 
        i = 2;
        break;
      case 2: 
        i = 3;
        break;
      case 3: 
        i = 4;
        continue;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aroc
 * JD-Core Version:    0.7.0.1
 */