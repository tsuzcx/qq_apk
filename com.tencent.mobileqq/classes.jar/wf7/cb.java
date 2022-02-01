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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {}
            return -1;
          }
          return 3;
        }
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static int F(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return -1;
            }
            return 3;
          }
          return 1;
        }
        return 2;
      }
      return 0;
    }
    return 4;
  }
  
  public static boolean G(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {}
      return true;
    }
    return false;
  }
  
  public static int a(ScanResult paramScanResult)
  {
    if ((paramScanResult != null) && (paramScanResult.capabilities != null))
    {
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
    return -1;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    boolean bool3 = l(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (l(paramString2))
      {
        bool1 = bool2;
        if (c(paramString1, paramString2)) {
          if ((paramInt1 != -1) && (paramInt2 != -1))
          {
            bool1 = bool2;
            if (paramInt1 != paramInt2) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static WifiConfig b(String paramString, int paramInt1, int paramInt2)
  {
    WifiConfig localWifiConfig = new WifiConfig();
    localWifiConfig.ey = paramString;
    localWifiConfig.ez = paramInt1;
    localWifiConfig.eE = paramInt2;
    paramInt1 = localWifiConfig.eE;
    if ((paramInt1 != 19) && (paramInt1 != 25) && (paramInt1 != 27)) {
      return localWifiConfig;
    }
    paramString = cg.aL().aN();
    if (paramString != null)
    {
      localWifiConfig.eH = paramString.eH;
      localWifiConfig.eG = paramString.gu;
    }
    return localWifiConfig;
  }
  
  public static boolean b(ScanResult paramScanResult)
  {
    if ((paramScanResult != null) && (paramScanResult.BSSID != null))
    {
      if (paramScanResult.SSID == null) {
        return false;
      }
      if ((k(paramScanResult.BSSID)) && (j(paramScanResult.SSID).length() > 0)) {
        return true;
      }
    }
    return false;
  }
  
  public static String byte2HexStr(byte paramByte)
  {
    char[] arrayOfChar = gS;
    int i = arrayOfChar[(paramByte & 0xF)];
    return new String(new char[] { arrayOfChar[((byte)(paramByte >>> 4) & 0xF)], i });
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
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      if (paramString1.compareTo(paramString2) == 0) {
        return true;
      }
      if (j(paramString1).compareTo(j(paramString2)) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public static byte char2Byte(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramChar -= '0';
      return (byte)paramChar;
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      paramChar = paramChar - c + 10;
      break;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return 0;
  }
  
  public static int d(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration.allowedKeyManagement.get(1)) {
      return 2;
    }
    if (!paramWifiConfiguration.allowedKeyManagement.get(2))
    {
      if (paramWifiConfiguration.allowedKeyManagement.get(3)) {
        return 3;
      }
      paramWifiConfiguration = paramWifiConfiguration.wepKeys;
      int i = 0;
      if (paramWifiConfiguration[0] != null) {
        i = 1;
      }
      return i;
    }
    return 3;
  }
  
  public static int d(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = -1;
    int i = j;
    if (!bool)
    {
      i = j;
      if (paramInt != 4) {
        i = paramString.hashCode() * 10 - 1 + paramInt;
      }
    }
    return i;
  }
  
  public static String j(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.length();
    String str = paramString;
    if (i > 1)
    {
      str = paramString;
      if (paramString.charAt(0) == '"')
      {
        i -= 1;
        str = paramString;
        if (paramString.charAt(i) == '"') {
          str = paramString.substring(1, i);
        }
      }
    }
    return str;
  }
  
  public static boolean k(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() != 17) {
        return false;
      }
      return paramString.compareTo("00:00:00:00:00:00") != 0;
    }
    return false;
  }
  
  public static boolean l(String paramString)
  {
    if (TextUtils.isEmpty(gR)) {}
    try
    {
      gR = (String)Class.forName("android.net.wifi.WifiSsid").getField("NONE").get(null);
    }
    catch (Throwable localThrowable)
    {
      label32:
      break label32;
    }
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, gR)) && (!TextUtils.equals(paramString, "0x"));
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
      while (i < paramString.length)
      {
        if ((paramString[i] != null) && (paramString[i].length() == 1)) {
          arrayOfByte[i] = char2Byte(paramString[i].charAt(1));
        } else if ((paramString[i] != null) && (paramString[i].length() == 2)) {
          arrayOfByte[i] = ((byte)(char2Byte(paramString[i].charAt(0)) * 16 + char2Byte(paramString[i].charAt(1))));
        }
        i += 1;
      }
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cb
 * JD-Core Version:    0.7.0.1
 */