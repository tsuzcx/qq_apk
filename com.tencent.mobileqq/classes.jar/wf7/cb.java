package wf7;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.tencent.qqpimsecure.wificore.api.connect.WifiConfig;
import java.lang.reflect.Field;
import java.util.BitSet;

public class cb
{
  public static int gI = -1;
  static String gR = "";
  private static final char[] gS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static int E(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    }
    return 3;
  }
  
  public static int F(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public static boolean G(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return true;
    }
    return false;
  }
  
  public static int a(ScanResult paramScanResult)
  {
    if ((paramScanResult == null) || (paramScanResult.capabilities == null)) {
      return -1;
    }
    if (paramScanResult.capabilities.contains("WEP")) {
      return 1;
    }
    if (paramScanResult.capabilities.contains("PSK")) {
      return 2;
    }
    if (paramScanResult.capabilities.contains("EAP")) {
      return 3;
    }
    return 0;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l(paramString1))
    {
      bool1 = bool2;
      if (l(paramString2))
      {
        bool1 = bool2;
        if (c(paramString1, paramString2)) {
          if ((paramInt1 != -1) && (paramInt2 != -1)) {
            break label53;
          }
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      label53:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt1 != paramInt2);
    }
  }
  
  public static WifiConfig b(String paramString, int paramInt1, int paramInt2)
  {
    WifiConfig localWifiConfig = new WifiConfig();
    localWifiConfig.ey = paramString;
    localWifiConfig.ez = paramInt1;
    localWifiConfig.eE = paramInt2;
    switch (localWifiConfig.eE)
    {
    }
    do
    {
      return localWifiConfig;
      paramString = cg.aL().aN();
    } while (paramString == null);
    localWifiConfig.eH = paramString.eH;
    localWifiConfig.eG = paramString.gu;
    return localWifiConfig;
  }
  
  public static boolean b(ScanResult paramScanResult)
  {
    if ((paramScanResult == null) || (paramScanResult.BSSID == null) || (paramScanResult.SSID == null)) {}
    while ((!k(paramScanResult.BSSID)) || (j(paramScanResult.SSID).length() <= 0)) {
      return false;
    }
    return true;
  }
  
  public static String byte2HexStr(byte paramByte)
  {
    int i = gS[(paramByte & 0xF)];
    paramByte = (byte)(paramByte >>> 4);
    return new String(new char[] { gS[(paramByte & 0xF)], i });
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 6)) {
      return String.format("%s:%s:%s:%s:%s:%s", new Object[] { byte2HexStr(paramArrayOfByte[0]), byte2HexStr(paramArrayOfByte[1]), byte2HexStr(paramArrayOfByte[2]), byte2HexStr(paramArrayOfByte[3]), byte2HexStr(paramArrayOfByte[4]), byte2HexStr(paramArrayOfByte[5]) });
    }
    return "";
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramString1.compareTo(paramString2) == 0);
      bool1 = bool2;
    } while (j(paramString1).compareTo(j(paramString2)) == 0);
    return false;
  }
  
  public static byte char2Byte(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  public static int d(WifiConfiguration paramWifiConfiguration)
  {
    int i = 1;
    if (paramWifiConfiguration.allowedKeyManagement.get(1)) {
      i = 2;
    }
    do
    {
      return i;
      if ((paramWifiConfiguration.allowedKeyManagement.get(2)) || (paramWifiConfiguration.allowedKeyManagement.get(3))) {
        return 3;
      }
    } while (paramWifiConfiguration.wepKeys[0] != null);
    return 0;
  }
  
  public static int d(String paramString, int paramInt)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      i = j;
      if (paramInt != 4) {
        i = -1 + paramString.hashCode() * 10 + paramInt;
      }
    }
    return i;
  }
  
  public static String j(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        do
        {
          return str;
          i = paramString.length();
          str = paramString;
        } while (i <= 1);
        str = paramString;
      } while (paramString.charAt(0) != '"');
      str = paramString;
    } while (paramString.charAt(i - 1) != '"');
    return paramString.substring(1, i - 1);
  }
  
  public static boolean k(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 17)) {}
    while (paramString.compareTo("00:00:00:00:00:00") == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean l(String paramString)
  {
    if (TextUtils.isEmpty(gR)) {}
    try
    {
      gR = (String)Class.forName("android.net.wifi.WifiSsid").getField("NONE").get(null);
      label29:
      return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, gR)) && (!TextUtils.equals(paramString, "0x"));
    }
    catch (Throwable localThrowable)
    {
      break label29;
    }
  }
  
  public static byte[] m(String paramString)
  {
    byte[] arrayOfByte = new byte[6];
    byte[] tmp6_5 = arrayOfByte;
    tmp6_5[0] = 0;
    byte[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 0;
    byte[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    byte[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 0;
    byte[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    byte[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0;
    tmp31_26;
    if (paramString == null) {
      return arrayOfByte;
    }
    paramString = paramString.split(":");
    if ((paramString != null) && (paramString.length == 6))
    {
      int i = 0;
      if (i < paramString.length)
      {
        if ((paramString[i] != null) && (paramString[i].length() == 1)) {
          arrayOfByte[i] = char2Byte(paramString[i].charAt(1));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramString[i] != null) && (paramString[i].length() == 2)) {
            arrayOfByte[i] = ((byte)(char2Byte(paramString[i].charAt(0)) * 16 + char2Byte(paramString[i].charAt(1))));
          }
        }
      }
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cb
 * JD-Core Version:    0.7.0.1
 */