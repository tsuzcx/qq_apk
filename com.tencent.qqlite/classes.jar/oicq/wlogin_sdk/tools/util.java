package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.request.y;

public class util
{
  public static final int ASYN_CHECK_IMAGE = 2;
  public static final int ASYN_CHECK_SMS = 4;
  public static final int ASYN_EXCEPTION = 11;
  public static final int ASYN_GET_A1_WITH_A1 = 6;
  public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
  public static final int ASYN_GET_ST_WITH_PWD = 0;
  public static final int ASYN_REFLUSH_IMAGE = 1;
  public static final int ASYN_REFLUSH_SMS = 3;
  public static final int ASYN_REPORT = 7;
  public static final int ASYN_REPORT_ERROR = 8;
  public static final int ASYN_SMSLOGIN_CHECK = 12;
  public static final int ASYN_SMSLOGIN_REFRESH = 14;
  public static final int ASYN_SMSLOGIN_VERIFY = 13;
  public static final int ASYN_TRANSPORT = 9;
  public static final int ASYN_TRANSPORT_MSF = 10;
  public static final long BUILD_TIME = 1414386621L;
  public static final int D = 2;
  private static SimpleDateFormat DAYFORMAT;
  public static final int E_A1_DECRYPT = -1014;
  public static final int E_A1_FORMAT = -1016;
  public static final int E_APK_CHK_ERR = -1021;
  public static final int E_DECRYPT = -1002;
  public static final int E_ENCODING = -1013;
  public static final int E_INPUT = -1017;
  public static final int E_NAME_INVALID = -1008;
  public static final int E_NO_KEY = -1004;
  public static final int E_NO_REG_CMD = -1010;
  public static final int E_NO_RET = -1000;
  public static final int E_NO_TGTKEY = -1006;
  public static final int E_NO_UIN = -1003;
  public static final int E_PENDING = -1001;
  public static final int E_PK_LEN = -1009;
  public static final int E_PUSH_REG = -1011;
  public static final int E_RESOLVE_ADDR = -1007;
  public static final int E_SAVE_TICKET_ERROR = -1022;
  public static final int E_SHARE_SERVICE_EXCEPTION = -1020;
  public static final int E_SHARE_SERVICE_PARAM = -1019;
  public static final int E_SHARE_SERVICE_UNCHECK = -1018;
  public static final int E_SYSTEM = -1012;
  public static final int E_TLV_DECRYPT = -1015;
  public static final int E_TLV_VERIFY = -1005;
  public static final String FILE_DIR = "wtlogin";
  private static int HONEYCOMB = 11;
  public static final int I = 1;
  public static LogCallBack LCB;
  public static boolean LOGCAT_OUT = false;
  public static final String LOG_DIR = "tencent/wtlogin";
  public static int LOG_LEVEL = 0;
  public static int MAX_APPID = 0;
  public static final int MAX_CONTENT_SIZE = 4096;
  public static final int MAX_FILE_SIZE = 102400;
  public static int MAX_NAME_LEN = 0;
  private static int MODE_MULTI_PROCESS = 0;
  public static final String SDK_VERSION = "5.2.3.1";
  public static final int SSO_VERSION = 5;
  public static final int S_GET_IMAGE = 2;
  public static final int S_GET_SMS = 160;
  public static final int S_PWD_WRONG = 1;
  public static final int S_ROLL_BACK = 180;
  public static final int S_SEC_GUID = 204;
  public static final int S_SUCCESS = 0;
  public static final String TAG = "wlogin_sdk";
  public static final int W = 0;
  static final char[] base64_encode_chars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  static final char base64_pad_url = '_';
  static final short[] base64_reverse_table_url = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static boolean libwtecdh_loaded;
  public static String logContent;
  
  static
  {
    int i = 0;
    MAX_APPID = 65535;
    MAX_NAME_LEN = 128;
    LOG_LEVEL = 1;
    LCB = null;
    LOGCAT_OUT = false;
    logContent = "";
    DAYFORMAT = null;
    libwtecdh_loaded = false;
    if (Build.VERSION.SDK_INT > 9) {
      i = 4;
    }
    MODE_MULTI_PROCESS = i;
  }
  
  public static boolean CheckMayFastLogin(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getPackageInfo("com.tencent.mobileqq", 1);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.versionName;
        if (paramContext.compareTo("4.6.0") >= 0) {
          return true;
        }
        int i = paramContext.indexOf(".");
        if (i < 0) {
          continue;
        }
        paramContext = paramContext.substring(0, i);
        try
        {
          i = Integer.parseInt(paramContext);
          if (i < 10) {
            continue;
          }
          return true;
        }
        catch (Exception paramContext)
        {
          return false;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean ExistSDCard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static void LOGD(String paramString)
  {
    try
    {
      if (LOG_LEVEL >= 2)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.d("wlogin_sdk" + getLineInfo(2), paramString);
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGD(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 2)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1, paramString2);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.d("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          return;
        }
      }
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGI(String paramString)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.i("wlogin_sdk" + getLineInfo(2), paramString);
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGI(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null) {
          LCB.OnLog(paramString1);
        }
        for (;;)
        {
          c.a(y.r, paramString2, paramString1);
          return;
          if (LOGCAT_OUT) {
            Log.i("wlogin_sdk" + getLineInfo(2), paramString1);
          }
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1, paramString2);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.w("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          return;
        }
      }
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        if (LCB != null) {
          LCB.OnLog(paramString1, paramString2);
        }
        for (;;)
        {
          c.a(y.r, paramString3, paramString1 + ":" + paramString2);
          return;
          if (LOGCAT_OUT) {
            Log.w("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          }
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static byte[] RSADecrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramKey == null)) {}
    for (;;)
    {
      return null;
      try
      {
        Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramKey);
        int k = paramArrayOfByte.length;
        paramKey = new byte[k];
        if (k % 128 == 0)
        {
          int j = 0;
          while (i < k / 128)
          {
            byte[] arrayOfByte = new byte[''];
            System.arraycopy(paramArrayOfByte, i * 128, arrayOfByte, 0, 128);
            arrayOfByte = localCipher.doFinal(arrayOfByte);
            System.arraycopy(arrayOfByte, 0, paramKey, j, arrayOfByte.length);
            j += arrayOfByte.length;
            i += 1;
          }
          paramArrayOfByte = new byte[j];
          System.arraycopy(paramKey, 0, paramArrayOfByte, 0, j);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte) {}
    }
    return null;
  }
  
  public static byte[] RSAEncrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if ((paramArrayOfByte == null) || (paramKey == null))
    {
      paramKey = null;
      return paramKey;
    }
    for (;;)
    {
      int i;
      int m;
      byte[] arrayOfByte;
      int k;
      int j;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, paramKey);
        i = paramArrayOfByte.length;
        m = (int)Math.round(i / 117 + 0.5D);
        arrayOfByte = new byte[128 * m];
        k = 0;
        j = 117;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        return null;
      }
      paramKey = new byte[j];
      System.arraycopy(paramArrayOfByte, k * 117, paramKey, 0, j);
      System.arraycopy(localCipher.doFinal(paramKey), 0, arrayOfByte, 128 * k, 128);
      k += 1;
      i -= j;
      paramKey = arrayOfByte;
      if (k >= m) {
        break;
      }
      if (i < 117) {
        j = i;
      }
    }
  }
  
  public static Key RSAPrivKeyFromJNI(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[26];
    byte[] tmp12_11 = arrayOfByte1;
    tmp12_11[0] = 48;
    byte[] tmp17_12 = tmp12_11;
    tmp17_12[1] = -126;
    byte[] tmp23_17 = tmp17_12;
    tmp23_17[2] = 2;
    byte[] tmp28_23 = tmp23_17;
    tmp28_23[3] = 117;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 2;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 1;
    byte[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 0;
    byte[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 48;
    byte[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 13;
    byte[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 6;
    byte[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 9;
    byte[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 42;
    byte[] tmp80_73 = tmp73_67;
    tmp80_73[12] = -122;
    byte[] tmp87_80 = tmp80_73;
    tmp87_80[13] = 72;
    byte[] tmp93_87 = tmp87_80;
    tmp93_87[14] = -122;
    byte[] tmp100_93 = tmp93_87;
    tmp100_93[15] = -9;
    byte[] tmp107_100 = tmp100_93;
    tmp107_100[16] = 13;
    byte[] tmp113_107 = tmp107_100;
    tmp113_107[17] = 1;
    byte[] tmp119_113 = tmp113_107;
    tmp119_113[18] = 1;
    byte[] tmp125_119 = tmp119_113;
    tmp125_119[19] = 1;
    byte[] tmp131_125 = tmp125_119;
    tmp131_125[20] = 5;
    byte[] tmp137_131 = tmp131_125;
    tmp137_131[21] = 0;
    byte[] tmp143_137 = tmp137_131;
    tmp143_137[22] = 4;
    byte[] tmp149_143 = tmp143_137;
    tmp149_143[23] = -126;
    byte[] tmp156_149 = tmp149_143;
    tmp156_149[24] = 2;
    byte[] tmp162_156 = tmp156_149;
    tmp162_156[25] = 95;
    tmp162_156;
    int i = paramArrayOfByte.length - 607;
    arrayOfByte1[3] = ((byte)(arrayOfByte1[3] + i));
    arrayOfByte1[25] = ((byte)(i + arrayOfByte1[25]));
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    try
    {
      paramArrayOfByte = new PKCS8EncodedKeySpec(arrayOfByte2);
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] RSAPrivKeyFromJava(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    try
    {
      Object localObject = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      paramArrayOfByte = new byte[26];
      paramArrayOfByte[0] = 48;
      paramArrayOfByte[1] = -126;
      paramArrayOfByte[2] = 2;
      paramArrayOfByte[3] = 117;
      paramArrayOfByte[4] = 2;
      paramArrayOfByte[5] = 1;
      paramArrayOfByte[6] = 0;
      paramArrayOfByte[7] = 48;
      paramArrayOfByte[8] = 13;
      paramArrayOfByte[9] = 6;
      paramArrayOfByte[10] = 9;
      paramArrayOfByte[11] = 42;
      paramArrayOfByte[12] = -122;
      paramArrayOfByte[13] = 72;
      paramArrayOfByte[14] = -122;
      paramArrayOfByte[15] = -9;
      paramArrayOfByte[16] = 13;
      paramArrayOfByte[17] = 1;
      paramArrayOfByte[18] = 1;
      paramArrayOfByte[19] = 1;
      paramArrayOfByte[20] = 5;
      paramArrayOfByte[21] = 0;
      paramArrayOfByte[22] = 4;
      paramArrayOfByte[23] = -126;
      paramArrayOfByte[24] = 2;
      paramArrayOfByte[25] = 95;
      paramArrayOfByte;
      localObject = ((PrivateKey)localObject).getEncoded();
      byte[] arrayOfByte = new byte[localObject.length - paramArrayOfByte.length];
      System.arraycopy(localObject, paramArrayOfByte.length, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static Key RSAPubKeyFromJNI(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[22];
    byte[] tmp12_11 = arrayOfByte1;
    tmp12_11[0] = 48;
    byte[] tmp17_12 = tmp12_11;
    tmp17_12[1] = -127;
    byte[] tmp23_17 = tmp17_12;
    tmp23_17[2] = -97;
    byte[] tmp29_23 = tmp23_17;
    tmp29_23[3] = 48;
    byte[] tmp34_29 = tmp29_23;
    tmp34_29[4] = 13;
    byte[] tmp39_34 = tmp34_29;
    tmp39_34[5] = 6;
    byte[] tmp44_39 = tmp39_34;
    tmp44_39[6] = 9;
    byte[] tmp50_44 = tmp44_39;
    tmp50_44[7] = 42;
    byte[] tmp57_50 = tmp50_44;
    tmp57_50[8] = -122;
    byte[] tmp64_57 = tmp57_50;
    tmp64_57[9] = 72;
    byte[] tmp70_64 = tmp64_57;
    tmp70_64[10] = -122;
    byte[] tmp77_70 = tmp70_64;
    tmp77_70[11] = -9;
    byte[] tmp84_77 = tmp77_70;
    tmp84_77[12] = 13;
    byte[] tmp90_84 = tmp84_77;
    tmp90_84[13] = 1;
    byte[] tmp96_90 = tmp90_84;
    tmp96_90[14] = 1;
    byte[] tmp102_96 = tmp96_90;
    tmp102_96[15] = 1;
    byte[] tmp108_102 = tmp102_96;
    tmp108_102[16] = 5;
    byte[] tmp114_108 = tmp108_102;
    tmp114_108[17] = 0;
    byte[] tmp120_114 = tmp114_108;
    tmp120_114[18] = 3;
    byte[] tmp126_120 = tmp120_114;
    tmp126_120[19] = -127;
    byte[] tmp133_126 = tmp126_120;
    tmp133_126[20] = -115;
    byte[] tmp140_133 = tmp133_126;
    tmp140_133[21] = 0;
    tmp140_133;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    paramArrayOfByte = new X509EncodedKeySpec(arrayOfByte2);
    try
    {
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] RSAPubKeyFromJava(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    try
    {
      Object localObject = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
      paramArrayOfByte = new byte[22];
      paramArrayOfByte[0] = 48;
      paramArrayOfByte[1] = -127;
      paramArrayOfByte[2] = -97;
      paramArrayOfByte[3] = 48;
      paramArrayOfByte[4] = 13;
      paramArrayOfByte[5] = 6;
      paramArrayOfByte[6] = 9;
      paramArrayOfByte[7] = 42;
      paramArrayOfByte[8] = -122;
      paramArrayOfByte[9] = 72;
      paramArrayOfByte[10] = -122;
      paramArrayOfByte[11] = -9;
      paramArrayOfByte[12] = 13;
      paramArrayOfByte[13] = 1;
      paramArrayOfByte[14] = 1;
      paramArrayOfByte[15] = 1;
      paramArrayOfByte[16] = 5;
      paramArrayOfByte[17] = 0;
      paramArrayOfByte[18] = 3;
      paramArrayOfByte[19] = -127;
      paramArrayOfByte[20] = -115;
      paramArrayOfByte[21] = 0;
      paramArrayOfByte;
      localObject = ((PublicKey)localObject).getEncoded();
      byte[] arrayOfByte = new byte[localObject.length - paramArrayOfByte.length];
      System.arraycopy(localObject, paramArrayOfByte.length, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] base64_decode_url(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = base64_reverse_table_url[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  public static String base64_encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int n;
      int k;
      if (i < j)
      {
        n = i + 1;
        k = paramArrayOfByte[i] & 0xFF;
        if (n != j) {
          break label72;
        }
        localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4)]);
      }
      for (;;)
      {
        return localStringBuffer.toString();
        label72:
        m = n + 1;
        n = paramArrayOfByte[n] & 0xFF;
        if (m != j) {
          break;
        }
        localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
        localStringBuffer.append(base64_encode_chars[((n & 0xF) << 2)]);
      }
      i = m + 1;
      int m = paramArrayOfByte[m] & 0xFF;
      localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
      localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
      localStringBuffer.append(base64_encode_chars[((n & 0xF) << 2 | (m & 0xC0) >>> 6)]);
      localStringBuffer.append(base64_encode_chars[(m & 0x3F)]);
    }
  }
  
  public static long buf_len(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public static int buf_to_int16(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 1)] << 0 & 0xFF);
  }
  
  public static int buf_to_int32(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF);
  }
  
  public static long buf_to_int64(byte[] paramArrayOfByte, int paramInt)
  {
    return 0L + (paramArrayOfByte[paramInt] << 56 & 0x0) + (paramArrayOfByte[(paramInt + 1)] << 48 & 0x0) + (paramArrayOfByte[(paramInt + 2)] << 40 & 0x0) + (paramArrayOfByte[(paramInt + 3)] << 32 & 0x0) + (paramArrayOfByte[(paramInt + 4)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 5)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 6)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 7)] << 0 & 0xFF);
  }
  
  public static int buf_to_int8(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xF);
      i += 1;
    }
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return localObject;
    }
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    String str = "";
    paramInt = 0;
    for (;;)
    {
      localObject = str;
      if (paramInt >= i) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[paramInt] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[paramInt] & 0xF);
      paramInt += 1;
    }
  }
  
  public static Boolean check_uin_account(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if ((l >= 10000L) && (l <= 4000000000L)) {
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (NumberFormatException paramString) {}
    return Boolean.valueOf(false);
  }
  
  public static void chg_retry_type(Context paramContext)
  {
    if (get_net_retry_type(paramContext) == 0)
    {
      set_net_retry_type(paramContext, 1);
      return;
    }
    set_net_retry_type(paramContext, 0);
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return new byte[0];
  }
  
  public static void decompress(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    label205:
    for (;;)
    {
      return;
      LOGI("data len:" + paramArrayOfByte.length);
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (paramArrayOfByte.length <= j + 3) {
          break label205;
        }
        int k = buf_to_int32(paramArrayOfByte, j);
        if (paramArrayOfByte.length <= j + k + 3) {
          break;
        }
        Object localObject = new byte[k];
        System.arraycopy(paramArrayOfByte, j + 4, localObject, 0, k);
        j = j + 4 + k;
        i += 1;
        LOGI("len:" + k);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new ByteArrayInputStream((byte[])localObject);
        try
        {
          localObject = new InflaterInputStream((InputStream)localObject);
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            k = ((InflaterInputStream)localObject).read(arrayOfByte);
            if (k == -1) {
              break;
            }
            localByteArrayOutputStream.write(arrayOfByte, 0, k);
          }
          LOGI(i + localByteArrayOutputStream.toString());
        }
        catch (IOException localIOException) {}
      }
    }
  }
  
  public static void deleteExpireFile(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      LOGI("file path:" + paramString);
      try
      {
        paramString = new File(paramString);
        if (!paramString.isDirectory()) {
          continue;
        }
        paramString = paramString.listFiles();
        if (paramString == null) {
          continue;
        }
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if ((!paramString[i].isDirectory()) && ((System.currentTimeMillis() - paramString[i].lastModified()) / 1000L > paramInt)) {
            paramString[i].delete();
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void deleteExpireLog(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      if (ExistSDCard())
      {
        File localFile = Environment.getExternalStorageDirectory();
        deleteExpireFile(localFile.getAbsolutePath() + "/" + "tencent/wtlogin" + "/" + paramContext.getPackageName(), 691200);
        return;
      }
      paramContext = paramContext.getFilesDir().getPath();
      deleteExpireFile(paramContext + "/" + "tencent/wtlogin", 259200);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int format_ret_code(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 17;
    case 0: 
      return 0;
    case -1000: 
      return 1;
    case 2: 
      return 2;
    }
    return 5;
  }
  
  public static KeyPair generateRSAKeyPair()
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject).initialize(1024);
      localObject = ((KeyPairGenerator)localObject).generateKeyPair();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static byte[] getAppName(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      if (localApplicationInfo != null)
      {
        paramContext = paramContext.getPackageManager().getApplicationLabel(localApplicationInfo).toString();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String getCurrentDay()
  {
    try
    {
      if (DAYFORMAT == null) {
        DAYFORMAT = new SimpleDateFormat("yyyyMMdd");
      }
      String str = DAYFORMAT.format(new Date());
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getDate()
  {
    try
    {
      String str = "[" + System.currentTimeMillis() + "]";
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static long getFileModifyTime(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        paramString = new File(paramString);
        if ((paramString.exists()) && (paramString.isFile()))
        {
          long l = paramString.lastModified();
          return l;
        }
      }
      catch (Exception paramString) {}
    }
    return 0L;
  }
  
  public static int getFileSize(String paramString)
  {
    int j = 0;
    try
    {
      paramString = new File(paramString);
      int i = j;
      if (paramString.exists())
      {
        i = j;
        if (paramString.isFile())
        {
          long l = paramString.length();
          i = (int)l;
        }
      }
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String getLineInfo(int paramInt)
  {
    if (paramInt < 0) {
      return "";
    }
    try
    {
      Object localObject = new Throwable().getStackTrace()[paramInt];
      localObject = "[" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + "]";
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String getLogFileName(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      if (ExistSDCard())
      {
        File localFile = Environment.getExternalStorageDirectory();
        return localFile.getAbsolutePath() + "/" + "tencent/wtlogin" + "/" + paramContext.getPackageName() + "/" + base64_encode(paramString.getBytes());
      }
      paramContext = paramContext.getFilesDir().getPath();
      paramContext = paramContext + "/" + "tencent/wtlogin" + "/" + base64_encode(paramString.getBytes());
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static long getLogModifyTime(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    return getFileModifyTime(getLogFileName(paramContext, paramString));
  }
  
  public static byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0) || (paramContext.signatures[0] == null)) {
        return new byte[0];
      }
      paramContext = MD5.toMD5Byte(paramContext.signatures[0].toByteArray());
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String getSdkVersion()
  {
    return "[5]";
  }
  
  public static String getThreadId()
  {
    return "[" + Thread.currentThread().getId() + "]";
  }
  
  public static String getUser(String paramString)
  {
    if (paramString != null) {
      return "[" + paramString + "]";
    }
    return "[]";
  }
  
  public static byte[] get_IMEI(Context paramContext)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject1 != null)
        {
          localObject1 = ((TelephonyManager)localObject1).getDeviceId();
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          Object localObject2 = localObject3;
          if (paramContext != null)
          {
            paramContext = paramContext.getConnectionInfo();
            localObject2 = localObject3;
            if (paramContext != null) {
              localObject2 = paramContext.getMacAddress();
            }
          }
          paramContext = "";
          if (localObject1 != null) {
            paramContext = "" + (String)localObject1;
          }
          localObject1 = paramContext;
          if (localObject2 != null) {
            localObject1 = paramContext + (String)localObject2;
          }
          if (((String)localObject1).length() <= 0) {
            return new byte[0];
          }
          paramContext = MD5.toMD5Byte(((String)localObject1).getBytes());
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        return new byte[0];
      }
      Object localObject1 = null;
    }
  }
  
  public static byte[] get_IMSI(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getSubscriberId();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_android_id(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext != null)
      {
        paramContext = paramContext.getBytes();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_apk_id(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName().getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_apk_v(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String get_apn_string(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 0)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null) {
          return paramContext;
        }
      }
      else
      {
        return "wifi";
      }
    }
    catch (Throwable paramContext) {}
    return "wifi";
  }
  
  public static byte get_char(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57)) {
      return (byte)(paramByte - 48);
    }
    if ((paramByte >= 97) && (paramByte <= 102)) {
      return (byte)(paramByte - 97 + 10);
    }
    if ((paramByte >= 65) && (paramByte <= 70)) {
      return (byte)(paramByte - 65 + 10);
    }
    return 0;
  }
  
  /* Error */
  public static byte[] get_cp_pubkey(Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +11 -> 12
    //   4: iconst_0
    //   5: newarray byte
    //   7: astore 6
    //   9: aload 6
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 796	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: astore_0
    //   17: new 342	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 830
    //   27: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 832
    //   33: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 834
    //   39: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 840	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: astore 6
    //   50: new 342	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   57: ldc 149
    //   59: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: lload_1
    //   63: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 7
    //   71: new 342	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   78: ldc 149
    //   80: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload_3
    //   84: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 8
    //   92: aload_0
    //   93: aload 6
    //   95: iconst_5
    //   96: anewarray 301	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 842
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc_w 844
    //   110: aastore
    //   111: dup
    //   112: iconst_2
    //   113: ldc_w 846
    //   116: aastore
    //   117: dup
    //   118: iconst_3
    //   119: ldc_w 848
    //   122: aastore
    //   123: dup
    //   124: iconst_4
    //   125: ldc_w 850
    //   128: aastore
    //   129: ldc_w 852
    //   132: iconst_2
    //   133: anewarray 301	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: aload 7
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload 8
    //   145: aastore
    //   146: aconst_null
    //   147: invokevirtual 858	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +187 -> 339
    //   155: aload_0
    //   156: astore 6
    //   158: aload_0
    //   159: invokeinterface 863 1 0
    //   164: ifeq +175 -> 339
    //   167: aload_0
    //   168: astore 6
    //   170: aload_0
    //   171: aload_0
    //   172: ldc_w 842
    //   175: invokeinterface 866 2 0
    //   180: invokeinterface 869 2 0
    //   185: istore 5
    //   187: aload_0
    //   188: astore 6
    //   190: aload_0
    //   191: aload_0
    //   192: ldc_w 848
    //   195: invokeinterface 866 2 0
    //   200: invokeinterface 871 2 0
    //   205: astore 7
    //   207: aload_0
    //   208: astore 6
    //   210: aload_0
    //   211: aload_0
    //   212: ldc_w 850
    //   215: invokeinterface 866 2 0
    //   220: invokeinterface 871 2 0
    //   225: astore 8
    //   227: aload_0
    //   228: astore 6
    //   230: new 342	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 873
    //   240: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: iload 5
    //   245: invokevirtual 565	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc_w 875
    //   251: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: lload_1
    //   255: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   258: ldc_w 875
    //   261: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: lload_3
    //   265: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: ldc_w 875
    //   271: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 7
    //   276: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 875
    //   282: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 8
    //   287: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 877	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: astore 6
    //   299: aload 7
    //   301: invokestatic 880	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   304: aload 8
    //   306: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq +30 -> 339
    //   312: aload_0
    //   313: astore 6
    //   315: aload 7
    //   317: invokestatic 884	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   320: astore 7
    //   322: aload 7
    //   324: astore 6
    //   326: aload_0
    //   327: ifnull -318 -> 9
    //   330: aload_0
    //   331: invokeinterface 885 1 0
    //   336: aload 7
    //   338: areturn
    //   339: aload_0
    //   340: ifnull +9 -> 349
    //   343: aload_0
    //   344: invokeinterface 885 1 0
    //   349: ldc_w 887
    //   352: invokestatic 884	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   355: areturn
    //   356: astore 7
    //   358: aconst_null
    //   359: astore_0
    //   360: aload_0
    //   361: astore 6
    //   363: aload 7
    //   365: ldc 149
    //   367: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   370: aload_0
    //   371: ifnull -22 -> 349
    //   374: aload_0
    //   375: invokeinterface 885 1 0
    //   380: goto -31 -> 349
    //   383: astore_0
    //   384: aconst_null
    //   385: astore 6
    //   387: aload 6
    //   389: ifnull +10 -> 399
    //   392: aload 6
    //   394: invokeinterface 885 1 0
    //   399: aload_0
    //   400: athrow
    //   401: astore_0
    //   402: goto -15 -> 387
    //   405: astore 7
    //   407: goto -47 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramLong1	long
    //   0	410	3	paramLong2	long
    //   185	59	5	i	int
    //   7	386	6	localObject1	Object
    //   69	268	7	localObject2	Object
    //   356	8	7	localException1	Exception
    //   405	1	7	localException2	Exception
    //   90	215	8	str	String
    // Exception table:
    //   from	to	target	type
    //   50	151	356	java/lang/Exception
    //   50	151	383	finally
    //   158	167	401	finally
    //   170	187	401	finally
    //   190	207	401	finally
    //   210	227	401	finally
    //   230	296	401	finally
    //   299	312	401	finally
    //   315	322	401	finally
    //   363	370	401	finally
    //   158	167	405	java/lang/Exception
    //   170	187	405	java/lang/Exception
    //   190	207	405	java/lang/Exception
    //   210	227	405	java/lang/Exception
    //   230	296	405	java/lang/Exception
    //   299	312	405	java/lang/Exception
    //   315	322	405	java/lang/Exception
  }
  
  public static String get_error_msg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    }
    return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4);
  }
  
  /* Error */
  public static byte[] get_file_imei(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_3
    //   7: areturn
    //   8: iconst_0
    //   9: newarray byte
    //   11: astore_3
    //   12: new 597	java/io/File
    //   15: dup
    //   16: new 342	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: invokevirtual 639	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: invokevirtual 628	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 630
    //   36: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 905
    //   42: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +230 -> 283
    //   56: aload_2
    //   57: invokevirtual 702	java/io/File:exists	()Z
    //   60: ifeq +223 -> 283
    //   63: new 907	java/io/FileInputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 910	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore 5
    //   73: aload 5
    //   75: astore 4
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: invokevirtual 913	java/io/FileInputStream:available	()I
    //   84: istore_1
    //   85: aload 5
    //   87: astore 4
    //   89: aload_3
    //   90: astore_2
    //   91: iload_1
    //   92: sipush 1024
    //   95: if_icmpge +32 -> 127
    //   98: aload 5
    //   100: astore 4
    //   102: aload_3
    //   103: astore_2
    //   104: iload_1
    //   105: newarray byte
    //   107: astore_3
    //   108: aload 5
    //   110: astore 4
    //   112: aload_3
    //   113: astore_2
    //   114: aload 5
    //   116: aload_3
    //   117: invokevirtual 914	java/io/FileInputStream:read	([B)I
    //   120: pop
    //   121: aload_3
    //   122: astore_2
    //   123: aload 5
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: aload 4
    //   131: ifnull +147 -> 278
    //   134: aload 4
    //   136: invokevirtual 915	java/io/FileInputStream:close	()V
    //   139: aload_2
    //   140: ifnull +10 -> 150
    //   143: aload_2
    //   144: astore_3
    //   145: aload_2
    //   146: arraylength
    //   147: ifgt -141 -> 6
    //   150: aload_0
    //   151: invokestatic 918	oicq/wlogin_sdk/tools/util:get_saved_imei	(Landroid/content/Context;)[B
    //   154: astore_2
    //   155: aload_2
    //   156: astore_3
    //   157: aload_2
    //   158: ifnull -152 -> 6
    //   161: aload_2
    //   162: astore_3
    //   163: aload_2
    //   164: arraylength
    //   165: ifle -159 -> 6
    //   168: aload_0
    //   169: aload_2
    //   170: invokestatic 922	oicq/wlogin_sdk/tools/util:save_file_imei	(Landroid/content/Context;[B)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_3
    //   176: aload_3
    //   177: ldc 149
    //   179: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   182: goto -43 -> 139
    //   185: astore 4
    //   187: aconst_null
    //   188: astore 5
    //   190: aload_3
    //   191: astore_2
    //   192: aload 4
    //   194: astore_3
    //   195: aload 5
    //   197: astore 4
    //   199: getstatic 925	oicq/wlogin_sdk/request/y:U	I
    //   202: ldc_w 926
    //   205: ior
    //   206: putstatic 925	oicq/wlogin_sdk/request/y:U	I
    //   209: aload 5
    //   211: astore 4
    //   213: aload_3
    //   214: ldc 149
    //   216: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   219: aload_2
    //   220: astore_3
    //   221: aload 5
    //   223: ifnull +55 -> 278
    //   226: aload 5
    //   228: invokevirtual 915	java/io/FileInputStream:close	()V
    //   231: goto -92 -> 139
    //   234: astore_3
    //   235: aload_3
    //   236: ldc 149
    //   238: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   241: goto -102 -> 139
    //   244: astore_0
    //   245: aconst_null
    //   246: astore 4
    //   248: aload 4
    //   250: ifnull +8 -> 258
    //   253: aload 4
    //   255: invokevirtual 915	java/io/FileInputStream:close	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore_2
    //   261: aload_2
    //   262: ldc 149
    //   264: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   267: goto -9 -> 258
    //   270: astore_0
    //   271: goto -23 -> 248
    //   274: astore_3
    //   275: goto -80 -> 195
    //   278: aload_3
    //   279: astore_2
    //   280: goto -141 -> 139
    //   283: aconst_null
    //   284: astore 4
    //   286: aload_3
    //   287: astore_2
    //   288: goto -161 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramContext	Context
    //   84	21	1	i	int
    //   51	169	2	localObject1	Object
    //   260	2	2	localIOException1	IOException
    //   279	9	2	localException1	Exception
    //   1	162	3	localObject2	Object
    //   175	16	3	localIOException2	IOException
    //   194	27	3	localObject3	Object
    //   234	2	3	localIOException3	IOException
    //   274	13	3	localException2	Exception
    //   75	60	4	localFileInputStream1	FileInputStream
    //   185	8	4	localException3	Exception
    //   197	88	4	localFileInputStream2	FileInputStream
    //   71	156	5	localFileInputStream3	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   134	139	175	java/io/IOException
    //   12	52	185	java/lang/Exception
    //   56	73	185	java/lang/Exception
    //   226	231	234	java/io/IOException
    //   12	52	244	finally
    //   56	73	244	finally
    //   253	258	260	java/io/IOException
    //   79	85	270	finally
    //   104	108	270	finally
    //   114	121	270	finally
    //   199	209	270	finally
    //   213	219	270	finally
    //   79	85	274	java/lang/Exception
    //   104	108	274	java/lang/Exception
    //   114	121	274	java/lang/Exception
  }
  
  public static byte[] get_imei_id(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getDeviceId();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_ksid(Context paramContext)
  {
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("ksid", new String("")));
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static int get_last_flag(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getInt("last_flag", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static byte[] get_last_guid(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("last_guid", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_last_imei(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("last_imei", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_last_mac(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("last_mac", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_mac_addr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          if (paramContext != null)
          {
            paramContext = paramContext.getBytes();
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String get_mpasswd()
  {
    try
    {
      byte[] arrayOfByte = SecureRandom.getSeed(16);
      int i = 0;
      String str1 = "";
      String str2 = str1;
      if (i < arrayOfByte.length)
      {
        boolean bool = new Random().nextBoolean();
        int k = Math.abs(arrayOfByte[i] % 26);
        if (bool) {}
        for (int j = 97;; j = 65)
        {
          str1 = str1 + String.valueOf((char)(j + k));
          i += 1;
          break;
        }
      }
      return str2;
    }
    catch (Throwable localThrowable)
    {
      str2 = "1234567890123456";
    }
  }
  
  public static int get_net_retry_type(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getInt("netretry_type", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static int get_network_type(Context paramContext)
  {
    try
    {
      i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (i == 0) {
        return 1;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      for (;;)
      {
        i = 0;
      }
      if (i == 1) {
        return 2;
      }
    }
    return 0;
  }
  
  public static byte[] get_os_type()
  {
    return new String("android").getBytes();
  }
  
  public static byte[] get_os_version()
  {
    return Build.VERSION.RELEASE.getBytes();
  }
  
  public static byte[] get_prand_16byte()
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      int32_to_buf(arrayOfByte, 0, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 4, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 8, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 12, (int)(Math.random() * 2147483647.0D));
      arrayOfByte = MD5.toMD5Byte(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable) {}
    return new byte[16];
  }
  
  public static String get_proxy_ip()
  {
    if (Build.VERSION.SDK_INT < HONEYCOMB) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static int get_proxy_port()
  {
    if (Build.VERSION.SDK_INT < HONEYCOMB) {
      return Proxy.getDefaultPort();
    }
    try
    {
      int i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return -1;
  }
  
  public static byte[] get_rand_16byte(SecureRandom paramSecureRandom)
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      paramSecureRandom.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable paramSecureRandom) {}
    return get_prand_16byte();
  }
  
  public static byte[] get_rand_16byte(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte1 = SecureRandom.getSeed(16);
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
      paramArrayOfByte = MD5.toMD5Byte(arrayOfByte2);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return get_prand_16byte();
  }
  
  public static int get_rand_32()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  public static String get_release_time()
  {
    return new String("2014/10/27 13:10");
  }
  
  public static byte[] get_rsa_privkey(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_privkey", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_rsa_pubkey(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_pubkey", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_saved_imei(Context paramContext)
  {
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("imei", new String("")));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      printThrowable(paramContext, "");
    }
    return new byte[0];
  }
  
  public static int get_saved_network_type(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getInt("network_type", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static long get_server_cur_time()
  {
    return y.g();
  }
  
  public static byte[] get_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_sim_operator_name(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext.getSimState() == 5)
      {
        paramContext = paramContext.getSimOperatorName().getBytes();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("wap-host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("wap-host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static void int16_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 8));
  }
  
  public static void int32_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24));
  }
  
  public static void int64_to_buf(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 56));
  }
  
  public static void int64_to_buf32(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 24));
  }
  
  public static void int8_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
  }
  
  public static boolean isFileExist(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean is_wap_proxy_retry(Context paramContext)
  {
    try
    {
      paramContext = get_apn_string(paramContext);
      if (paramContext != null)
      {
        if (paramContext.equalsIgnoreCase("cmwap")) {
          return true;
        }
        if ((paramContext.equalsIgnoreCase("uniwap")) || (paramContext.equalsIgnoreCase("ctwap"))) {
          break label59;
        }
        boolean bool = paramContext.equalsIgnoreCase("3gwap");
        if (bool) {
          break label59;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label53:
      break label53;
    }
    return false;
    label59:
    return true;
  }
  
  public static boolean is_wap_retry(Context paramContext)
  {
    return get_net_retry_type(paramContext) != 0;
  }
  
  /* Error */
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: getstatic 155	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_1
    //   7: ireturn
    //   8: aload_1
    //   9: ifnull +14 -> 23
    //   12: aload_0
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 593	java/lang/String:length	()I
    //   20: ifne +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 597	java/io/File
    //   28: dup
    //   29: new 342	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 639	android/content/Context:getFilesDir	()Ljava/io/File;
    //   40: invokevirtual 1097	java/io/File:getParent	()Ljava/lang/String;
    //   43: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 1099
    //   49: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 1101
    //   59: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 4
    //   70: aload 4
    //   72: invokevirtual 702	java/io/File:exists	()Z
    //   75: ifne +142 -> 217
    //   78: new 597	java/io/File
    //   81: dup
    //   82: new 342	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: invokevirtual 639	android/content/Context:getFilesDir	()Ljava/io/File;
    //   93: invokevirtual 1097	java/io/File:getParent	()Ljava/lang/String;
    //   96: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 1103
    //   102: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 1101
    //   112: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +89 -> 212
    //   126: aload_1
    //   127: invokevirtual 702	java/io/File:exists	()Z
    //   130: ifeq +82 -> 212
    //   133: aload_1
    //   134: invokevirtual 628	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   137: invokestatic 1106	java/lang/System:load	(Ljava/lang/String;)V
    //   140: iconst_1
    //   141: istore_2
    //   142: iload_2
    //   143: istore_3
    //   144: iload_2
    //   145: ifne +9 -> 154
    //   148: aload_0
    //   149: invokestatic 1108	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   152: iconst_1
    //   153: istore_3
    //   154: iload_3
    //   155: putstatic 155	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   158: new 342	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 1110
    //   168: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: getstatic 155	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   174: invokevirtual 1113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   177: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: ldc 149
    //   182: invokestatic 1115	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: iload_3
    //   186: ireturn
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -68 -> 122
    //   193: astore_1
    //   194: iconst_0
    //   195: istore_2
    //   196: goto -54 -> 142
    //   199: astore_0
    //   200: iload_2
    //   201: istore_3
    //   202: goto -48 -> 154
    //   205: astore_1
    //   206: aload 4
    //   208: astore_1
    //   209: goto -19 -> 190
    //   212: iconst_0
    //   213: istore_2
    //   214: goto -72 -> 142
    //   217: aload 4
    //   219: astore_1
    //   220: goto -98 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramString	String
    //   0	223	1	paramContext	Context
    //   141	73	2	bool1	boolean
    //   143	59	3	bool2	boolean
    //   68	150	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   25	70	187	java/lang/Exception
    //   133	140	193	java/lang/UnsatisfiedLinkError
    //   148	152	199	java/lang/UnsatisfiedLinkError
    //   70	122	205	java/lang/Exception
  }
  
  public static Bundle packBundle(byte[][] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localBundle.putInt("len", paramArrayOfByte.length);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localBundle.putByteArray(String.valueOf(i), paramArrayOfByte[i]);
        i += 1;
      }
    }
    if (localBundle.isEmpty()) {
      return null;
    }
    return localBundle;
  }
  
  public static void printException(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("exception:", localStringWriter.toString());
  }
  
  public static void printException(Exception paramException, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("exception", localStringWriter.toString(), paramString);
  }
  
  public static void printThrowable(Throwable paramThrowable, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("throwable", localStringWriter.toString(), paramString);
  }
  
  public static byte[] readFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = new File(paramString);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          paramString = new FileInputStream(paramString);
          int i = paramString.available();
          if (i > 106496)
          {
            paramString.close();
            return null;
          }
          localObject = new byte[i];
          paramString.read((byte[])localObject);
          paramString.close();
          return localObject;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static byte[] readLog(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return readFile(getLogFileName(paramContext, paramString));
  }
  
  public static void save_cur_flag(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putInt("last_flag", paramInt);
      paramContext.commit();
    }
  }
  
  public static void save_cur_guid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("last_guid", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_imei(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("last_imei", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_mac(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("last_mac", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  /* Error */
  public static void save_file_imei(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +174 -> 175
    //   4: aload_1
    //   5: ifnull +170 -> 175
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +165 -> 175
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 7
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 6
    //   24: astore 4
    //   26: aload 7
    //   28: astore_2
    //   29: new 597	java/io/File
    //   32: dup
    //   33: new 342	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   40: aload_0
    //   41: invokevirtual 639	android/content/Context:getFilesDir	()Ljava/io/File;
    //   44: invokevirtual 628	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 630
    //   53: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 905
    //   59: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 8
    //   70: aload 6
    //   72: astore 4
    //   74: aload 7
    //   76: astore_2
    //   77: aload 8
    //   79: invokevirtual 702	java/io/File:exists	()Z
    //   82: ifne +16 -> 98
    //   85: aload 6
    //   87: astore 4
    //   89: aload 7
    //   91: astore_2
    //   92: aload 8
    //   94: invokevirtual 1193	java/io/File:createNewFile	()Z
    //   97: pop
    //   98: aload 5
    //   100: astore_3
    //   101: aload 6
    //   103: astore 4
    //   105: aload 7
    //   107: astore_2
    //   108: aload 8
    //   110: invokevirtual 702	java/io/File:exists	()Z
    //   113: ifeq +44 -> 157
    //   116: aload 5
    //   118: astore_3
    //   119: aload 6
    //   121: astore 4
    //   123: aload 7
    //   125: astore_2
    //   126: aload 8
    //   128: invokevirtual 1196	java/io/File:canWrite	()Z
    //   131: ifeq +26 -> 157
    //   134: aload 6
    //   136: astore 4
    //   138: aload 7
    //   140: astore_2
    //   141: new 1198	java/io/FileOutputStream
    //   144: dup
    //   145: aload 8
    //   147: iconst_0
    //   148: invokespecial 1201	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   151: astore_3
    //   152: aload_3
    //   153: aload_1
    //   154: invokevirtual 1202	java/io/FileOutputStream:write	([B)V
    //   157: aload_3
    //   158: astore 4
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload_1
    //   164: invokestatic 1205	oicq/wlogin_sdk/tools/util:save_imei	(Landroid/content/Context;[B)V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 1206	java/io/FileOutputStream:close	()V
    //   175: return
    //   176: astore_0
    //   177: aload_0
    //   178: ldc 149
    //   180: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   183: return
    //   184: astore_0
    //   185: aload 4
    //   187: astore_2
    //   188: aload_0
    //   189: ldc 149
    //   191: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   194: aload 4
    //   196: ifnull -21 -> 175
    //   199: aload 4
    //   201: invokevirtual 1206	java/io/FileOutputStream:close	()V
    //   204: return
    //   205: astore_0
    //   206: aload_0
    //   207: ldc 149
    //   209: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   212: return
    //   213: astore_0
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 1206	java/io/FileOutputStream:close	()V
    //   222: aload_0
    //   223: athrow
    //   224: astore_1
    //   225: aload_1
    //   226: ldc 149
    //   228: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   231: goto -9 -> 222
    //   234: astore_0
    //   235: aload_3
    //   236: astore_2
    //   237: goto -23 -> 214
    //   240: astore_0
    //   241: aload_3
    //   242: astore 4
    //   244: goto -59 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	Context
    //   0	247	1	paramArrayOfByte	byte[]
    //   28	209	2	localObject1	Object
    //   100	142	3	localObject2	Object
    //   24	219	4	localObject3	Object
    //   20	97	5	localObject4	Object
    //   14	121	6	localObject5	Object
    //   17	122	7	localObject6	Object
    //   68	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   171	175	176	java/io/IOException
    //   29	70	184	java/lang/Exception
    //   77	85	184	java/lang/Exception
    //   92	98	184	java/lang/Exception
    //   108	116	184	java/lang/Exception
    //   126	134	184	java/lang/Exception
    //   141	152	184	java/lang/Exception
    //   162	167	184	java/lang/Exception
    //   199	204	205	java/io/IOException
    //   29	70	213	finally
    //   77	85	213	finally
    //   92	98	213	finally
    //   108	116	213	finally
    //   126	134	213	finally
    //   141	152	213	finally
    //   162	167	213	finally
    //   188	194	213	finally
    //   218	222	224	java/io/IOException
    //   152	157	234	finally
    //   152	157	240	java/lang/Exception
  }
  
  public static void save_imei(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("imei", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_network_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putInt("network_type", paramInt);
      paramContext.commit();
    }
  }
  
  public static void save_rsa_privkey(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("rsa_privkey", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_rsa_pubkey(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("rsa_pubkey", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  /* Error */
  public static boolean set_cp_pubkey(Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 796	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 7
    //   12: new 342	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 830
    //   22: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 832
    //   28: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 834
    //   34: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 840	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 1212	android/net/Uri:toString	()Ljava/lang/String;
    //   50: invokestatic 567	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   53: new 342	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   60: ldc 149
    //   62: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_1
    //   66: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: new 342	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   81: ldc 149
    //   83: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 9
    //   95: aload 7
    //   97: aload 8
    //   99: iconst_5
    //   100: anewarray 301	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 842
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: ldc_w 844
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: ldc_w 846
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: ldc_w 848
    //   126: aastore
    //   127: dup
    //   128: iconst_4
    //   129: ldc_w 850
    //   132: aastore
    //   133: ldc_w 852
    //   136: iconst_2
    //   137: anewarray 301	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: aload 6
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload 9
    //   149: aastore
    //   150: aconst_null
    //   151: invokevirtual 858	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnonnull +17 -> 175
    //   161: aload 6
    //   163: ifnull +10 -> 173
    //   166: aload 6
    //   168: invokeinterface 885 1 0
    //   173: iconst_0
    //   174: ireturn
    //   175: aload_0
    //   176: invokestatic 1214	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   179: invokestatic 1184	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 593	java/lang/String:length	()I
    //   187: istore 5
    //   189: iload 5
    //   191: ifne +17 -> 208
    //   194: aload 6
    //   196: ifnull +10 -> 206
    //   199: aload 6
    //   201: invokeinterface 885 1 0
    //   206: iconst_0
    //   207: ireturn
    //   208: aload_0
    //   209: invokestatic 880	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 9
    //   214: aload 6
    //   216: invokeinterface 1217 1 0
    //   221: ifle +139 -> 360
    //   224: new 1219	android/content/ContentValues
    //   227: dup
    //   228: invokespecial 1220	android/content/ContentValues:<init>	()V
    //   231: astore 10
    //   233: aload 10
    //   235: ldc_w 848
    //   238: aload_0
    //   239: invokevirtual 1223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 10
    //   244: ldc_w 850
    //   247: aload 9
    //   249: invokevirtual 1223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 6
    //   254: invokeinterface 863 1 0
    //   259: pop
    //   260: aload 7
    //   262: aload 8
    //   264: aload 10
    //   266: ldc_w 852
    //   269: iconst_2
    //   270: anewarray 301	java/lang/String
    //   273: dup
    //   274: iconst_0
    //   275: new 342	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   282: ldc 149
    //   284: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: lload_1
    //   288: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: new 342	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   304: ldc 149
    //   306: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: lload_3
    //   310: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aastore
    //   317: invokevirtual 1227	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   320: istore 5
    //   322: new 342	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 1229
    //   332: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 5
    //   337: invokevirtual 565	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 877	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   346: aload 6
    //   348: ifnull +10 -> 358
    //   351: aload 6
    //   353: invokeinterface 885 1 0
    //   358: iconst_1
    //   359: ireturn
    //   360: new 1219	android/content/ContentValues
    //   363: dup
    //   364: invokespecial 1220	android/content/ContentValues:<init>	()V
    //   367: astore 10
    //   369: aload 10
    //   371: ldc_w 844
    //   374: lload_1
    //   375: invokestatic 1232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: invokevirtual 1235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   381: aload 10
    //   383: ldc_w 846
    //   386: lload_3
    //   387: invokestatic 1232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: invokevirtual 1235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   393: aload 10
    //   395: ldc_w 848
    //   398: aload_0
    //   399: invokevirtual 1223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload 10
    //   404: ldc_w 850
    //   407: aload 9
    //   409: invokevirtual 1223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 7
    //   414: aload 8
    //   416: aload 10
    //   418: invokevirtual 1239	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   421: astore_0
    //   422: new 342	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 1241
    //   432: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 1244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: ldc_w 1246
    //   442: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: lload_1
    //   446: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: ldc_w 1248
    //   452: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: lload_3
    //   456: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   459: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 877	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   465: goto -119 -> 346
    //   468: astore 7
    //   470: aload 6
    //   472: astore_0
    //   473: aload 7
    //   475: astore 6
    //   477: aload 6
    //   479: ldc 149
    //   481: invokestatic 444	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   484: aload_0
    //   485: ifnull +9 -> 494
    //   488: aload_0
    //   489: invokeinterface 885 1 0
    //   494: iconst_0
    //   495: ireturn
    //   496: astore_0
    //   497: aconst_null
    //   498: astore 6
    //   500: aload 6
    //   502: ifnull +10 -> 512
    //   505: aload 6
    //   507: invokeinterface 885 1 0
    //   512: aload_0
    //   513: athrow
    //   514: astore_0
    //   515: goto -15 -> 500
    //   518: astore 7
    //   520: aload_0
    //   521: astore 6
    //   523: aload 7
    //   525: astore_0
    //   526: goto -26 -> 500
    //   529: astore 6
    //   531: aconst_null
    //   532: astore_0
    //   533: goto -56 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	paramContext	Context
    //   0	536	1	paramLong1	long
    //   0	536	3	paramLong2	long
    //   187	149	5	i	int
    //   72	450	6	localObject1	Object
    //   529	1	6	localException1	Exception
    //   10	403	7	localContentResolver	android.content.ContentResolver
    //   468	6	7	localException2	Exception
    //   518	6	7	localObject2	Object
    //   43	372	8	localUri	android.net.Uri
    //   93	315	9	str	String
    //   231	186	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   175	189	468	java/lang/Exception
    //   208	346	468	java/lang/Exception
    //   360	465	468	java/lang/Exception
    //   53	156	496	finally
    //   175	189	514	finally
    //   208	346	514	finally
    //   360	465	514	finally
    //   477	484	518	finally
    //   53	156	529	java/lang/Exception
  }
  
  public static void set_ksid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      byte[] arrayOfByte = get_ksid(paramContext);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
        paramContext.putString("ksid", buf_to_string(paramArrayOfByte));
        paramContext.commit();
      }
    }
  }
  
  public static void set_net_retry_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putInt("netretry_type", paramInt);
      paramContext.commit();
    }
  }
  
  public static void set_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("wap-host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("wap-host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static byte[] string_to_buf(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (i < paramString.length() / 2)
    {
      arrayOfByte[i] = ((byte)((get_char((byte)paramString.charAt(i * 2)) << 4) + get_char((byte)paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[][] unpackBundle(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("len");
      byte[][] arrayOfByte2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { j, 0 });
      for (;;)
      {
        arrayOfByte1 = arrayOfByte2;
        if (i >= j) {
          break;
        }
        arrayOfByte2[i] = paramBundle.getByteArray(String.valueOf(i));
        i += 1;
      }
    }
    byte[][] arrayOfByte1 = (byte[][])null;
    return arrayOfByte1;
  }
  
  /* Error */
  public static void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 593	java/lang/String:length	()I
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: new 597	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 599	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 702	java/io/File:exists	()Z
    //   33: ifne +30 -> 63
    //   36: aload_3
    //   37: invokevirtual 1287	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull -28 -> 16
    //   47: aload 4
    //   49: invokevirtual 1290	java/io/File:mkdirs	()Z
    //   52: ifne +11 -> 63
    //   55: aload 4
    //   57: invokevirtual 602	java/io/File:isDirectory	()Z
    //   60: ifeq -44 -> 16
    //   63: aload_0
    //   64: invokestatic 1292	oicq/wlogin_sdk/tools/util:getFileSize	(Ljava/lang/String;)I
    //   67: ldc 106
    //   69: if_icmpge -53 -> 16
    //   72: new 1198	java/io/FileOutputStream
    //   75: dup
    //   76: aload_3
    //   77: iconst_1
    //   78: invokespecial 1201	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: invokevirtual 1202	java/io/FileOutputStream:write	([B)V
    //   87: aload_0
    //   88: invokevirtual 1206	java/io/FileOutputStream:close	()V
    //   91: goto -75 -> 16
    //   94: astore_0
    //   95: goto -79 -> 16
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramString	String
    //   0	104	1	paramArrayOfByte	byte[]
    //   11	2	2	i	int
    //   28	49	3	localFile1	File
    //   40	16	4	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   20	42	94	java/lang/Exception
    //   47	63	94	java/lang/Exception
    //   63	91	94	java/lang/Exception
    //   7	12	98	finally
    //   20	42	98	finally
    //   47	63	98	finally
    //   63	91	98	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */