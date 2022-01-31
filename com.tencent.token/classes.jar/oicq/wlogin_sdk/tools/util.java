package oicq.wlogin_sdk.tools;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.request.t;

public class util
{
  public static final int ASYN_CHECK_IMAGE = 2;
  public static final int ASYN_CHECK_SMS = 4;
  public static final int ASYN_EXCEPTION = 11;
  public static final int ASYN_GET_A1_WITH_A1 = 6;
  public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
  public static final int ASYN_GET_ST_WITH_PWD = 0;
  public static final int ASYN_QUICKLOG_WITH_PTSIG = 16;
  public static final int ASYN_QUICKLOG_WITH_QQSIG = 15;
  public static final int ASYN_QUICKLOG_WITH_QRSIG = 17;
  public static final int ASYN_REFLUSH_IMAGE = 1;
  public static final int ASYN_REFLUSH_SMS = 3;
  public static final int ASYN_REPORT = 7;
  public static final int ASYN_REPORT_ERROR = 8;
  public static final int ASYN_SMSLOGIN_CHECK = 12;
  public static final int ASYN_SMSLOGIN_REFRESH = 14;
  public static final int ASYN_SMSLOGIN_VERIFY = 13;
  public static final int ASYN_TRANSPORT = 9;
  public static final int ASYN_TRANSPORT_MSF = 10;
  public static final long BUILD_TIME = 1502965326L;
  public static final int D = 2;
  private static SimpleDateFormat DAYFORMAT;
  public static final int E_A1_DECRYPT = -1014;
  public static final int E_A1_FORMAT = -1016;
  public static final int E_ADVANCE_NOTICE = 257;
  public static final int E_APK_CHK_ERR = -1021;
  public static final int E_BUFFER_OVERFLOW = -1023;
  public static final int E_DECRYPT = -1002;
  public static final int E_ENCODING = -1013;
  public static final int E_ENCRYPTION_METHOD = -1024;
  public static final int E_INPUT = -1017;
  public static final int E_LOGIN_THROUGH_QQ = -2001;
  public static final int E_LOGIN_THROUGH_WEB = -2000;
  public static final int E_NAME_INVALID = -1008;
  public static final int E_NEWST_DECRYPT = -1025;
  public static final int E_NO_KEY = -1004;
  public static final int E_NO_NETWORK = -1026;
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
  public static final int MAX_CONTENT_SIZE = 20480;
  public static final int MAX_FILE_SIZE = 524288;
  public static int MAX_NAME_LEN = 0;
  @SuppressLint({"NewApi"})
  private static int MODE_MULTI_PROCESS = 0;
  public static final String SDK_VERSION = "6.0.0.2202";
  public static final int SSO_VERSION = 5;
  public static final long SVN_VER = 2202L;
  public static final int S_BABYLH_EXPIRED = 116;
  public static final int S_GET_IMAGE = 2;
  public static final int S_GET_SMS = 160;
  public static final int S_LH_EXPIRED = 41;
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
  public static boolean loadEncryptSo;
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
    loadEncryptSo = true;
    if (Build.VERSION.SDK_INT > 9) {
      i = 4;
    }
    MODE_MULTI_PROCESS = i;
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
          d.a(paramString1, paramString2);
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
          d.a(paramString1 + ":" + paramString2, paramString3);
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
  
  public static long constructSalt()
  {
    return (get_rand_32() << 32) + get_rand_32();
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
        paramString = paramString.listFiles(new e());
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
      if ((t.at != null) && (t.at.length() != 0))
      {
        deleteExpireFile(t.at, 691200);
        return;
      }
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
  
  public static byte[] generateGuid(Context paramContext)
  {
    Object localObject3 = null;
    if ((t.ai != null) && (t.ai.length != 0))
    {
      LOGI("generate guid from customer guid");
      return t.ai;
    }
    LOGI("generate guid temporarily");
    for (;;)
    {
      try
      {
        localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject1 != null)
        {
          localObject1 = ((TelephonyManager)localObject1).getDeviceId();
          LOGI("imei " + (String)localObject1, "");
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
          LOGI("mac " + (String)localObject2, "");
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
  
  public static String getChannelId(Context paramContext, String paramString)
  {
    int i = 0;
    Object localObject2;
    if (paramString != null)
    {
      localObject2 = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject2 = paramContext.getPackageName();
    }
    paramString = "";
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramString;
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = paramContext.getPackageInfo((String)localObject2, 0).applicationInfo.sourceDir;
        localObject1 = paramString;
        localObject2 = new StringBuilder().append("pkg ").append((String)localObject2).append(" path ");
        if (localObject3 != null) {
          break label468;
        }
        paramContext = "null";
        localObject1 = paramString;
        LOGI(paramContext, "");
        if (localObject3 == null) {
          break label465;
        }
        localObject1 = paramString;
        if (((String)localObject3).length() == 0) {
          return "";
        }
        localObject1 = paramString;
        paramContext = new byte[4];
        localObject1 = paramString;
        paramContext[0] = 80;
        paramContext[1] = 75;
        paramContext[2] = 5;
        paramContext[3] = 6;
        paramContext;
        localObject1 = paramString;
        localObject2 = new FileInputStream((String)localObject3);
        localObject1 = paramString;
        l = ((FileInputStream)localObject2).available();
        localObject1 = paramString;
        localObject3 = new byte[(int)(l - ((FileInputStream)localObject2).skip(l - 256L))];
        localObject1 = paramString;
        ((FileInputStream)localObject2).read((byte[])localObject3);
        localObject1 = paramString;
        ((FileInputStream)localObject2).close();
        localObject1 = paramString;
        if (i >= localObject3.length - 4) {
          break label457;
        }
        if ((localObject3[i] == paramContext[0]) && (localObject3[(i + 1)] == paramContext[1]) && (localObject3[(i + 2)] == paramContext[2]) && (localObject3[(i + 3)] == paramContext[3]))
        {
          l = i;
          if (l == -1L) {
            break label465;
          }
          i = (int)l + 20;
          int j = localObject3[i];
          i = (localObject3[(i + 1)] << 8) + j;
          if (i == 0) {
            break label465;
          }
          localObject1 = paramString;
          localObject2 = new byte[i];
          localObject1 = paramString;
          System.arraycopy(localObject3, (int)(l + 20L), localObject2, 0, i);
          localObject1 = paramString;
          localObject3 = Pattern.compile("channelId=(\\S+)").matcher(new String((byte[])localObject2));
          paramContext = paramString;
          localObject1 = paramString;
          if (((Matcher)localObject3).find())
          {
            localObject1 = paramString;
            paramContext = ((Matcher)localObject3).group(1);
          }
          localObject1 = paramContext;
          LOGI("found comment " + new String((byte[])localObject2) + " channelId:" + paramContext, "");
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        printException(paramContext, "");
        return localObject1;
      }
      i += 1;
      continue;
      label457:
      long l = -1L;
      continue;
      label465:
      return "";
      label468:
      paramContext = (Context)localObject3;
    }
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
  
  /* Error */
  public static byte[] getGuidFromFile(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 649	oicq/wlogin_sdk/request/t:ai	[B
    //   5: ifnull +24 -> 29
    //   8: getstatic 649	oicq/wlogin_sdk/request/t:ai	[B
    //   11: arraylength
    //   12: ifeq +17 -> 29
    //   15: ldc_w 824
    //   18: ldc 180
    //   20: invokestatic 668	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: getstatic 649	oicq/wlogin_sdk/request/t:ai	[B
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: ldc_w 826
    //   32: ldc 180
    //   34: invokestatic 668	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: ifnull -11 -> 27
    //   41: iconst_0
    //   42: newarray byte
    //   44: astore_3
    //   45: new 584	java/io/File
    //   48: dup
    //   49: new 329	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   56: aload_0
    //   57: invokevirtual 635	android/content/Context:getFilesDir	()Ljava/io/File;
    //   60: invokevirtual 625	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 828
    //   69: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 586	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +230 -> 310
    //   83: aload_2
    //   84: invokevirtual 814	java/io/File:exists	()Z
    //   87: ifeq +223 -> 310
    //   90: new 748	java/io/FileInputStream
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 831	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore 5
    //   100: aload 5
    //   102: astore 4
    //   104: aload_3
    //   105: astore_2
    //   106: aload 5
    //   108: invokevirtual 752	java/io/FileInputStream:available	()I
    //   111: istore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload_3
    //   117: astore_2
    //   118: iload_1
    //   119: sipush 1024
    //   122: if_icmpge +32 -> 154
    //   125: aload 5
    //   127: astore 4
    //   129: aload_3
    //   130: astore_2
    //   131: iload_1
    //   132: newarray byte
    //   134: astore_3
    //   135: aload 5
    //   137: astore 4
    //   139: aload_3
    //   140: astore_2
    //   141: aload 5
    //   143: aload_3
    //   144: invokevirtual 759	java/io/FileInputStream:read	([B)I
    //   147: pop
    //   148: aload_3
    //   149: astore_2
    //   150: aload 5
    //   152: astore 4
    //   154: aload_2
    //   155: astore_3
    //   156: aload 4
    //   158: ifnull +147 -> 305
    //   161: aload 4
    //   163: invokevirtual 760	java/io/FileInputStream:close	()V
    //   166: aload_2
    //   167: ifnull +10 -> 177
    //   170: aload_2
    //   171: astore_3
    //   172: aload_2
    //   173: arraylength
    //   174: ifgt -147 -> 27
    //   177: aload_0
    //   178: invokestatic 834	oicq/wlogin_sdk/tools/util:get_saved_imei	(Landroid/content/Context;)[B
    //   181: astore_2
    //   182: aload_2
    //   183: astore_3
    //   184: aload_2
    //   185: ifnull -158 -> 27
    //   188: aload_2
    //   189: astore_3
    //   190: aload_2
    //   191: arraylength
    //   192: ifle -165 -> 27
    //   195: aload_0
    //   196: aload_2
    //   197: invokestatic 838	oicq/wlogin_sdk/tools/util:saveGuidToFile	(Landroid/content/Context;[B)V
    //   200: aload_2
    //   201: areturn
    //   202: astore_3
    //   203: aload_3
    //   204: ldc 180
    //   206: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   209: goto -43 -> 166
    //   212: astore 4
    //   214: aconst_null
    //   215: astore 5
    //   217: aload_3
    //   218: astore_2
    //   219: aload 4
    //   221: astore_3
    //   222: aload 5
    //   224: astore 4
    //   226: getstatic 841	oicq/wlogin_sdk/request/t:Y	I
    //   229: ldc_w 842
    //   232: ior
    //   233: putstatic 841	oicq/wlogin_sdk/request/t:Y	I
    //   236: aload 5
    //   238: astore 4
    //   240: aload_3
    //   241: ldc 180
    //   243: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   246: aload_2
    //   247: astore_3
    //   248: aload 5
    //   250: ifnull +55 -> 305
    //   253: aload 5
    //   255: invokevirtual 760	java/io/FileInputStream:close	()V
    //   258: goto -92 -> 166
    //   261: astore_3
    //   262: aload_3
    //   263: ldc 180
    //   265: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   268: goto -102 -> 166
    //   271: astore_0
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 760	java/io/FileInputStream:close	()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_2
    //   288: aload_2
    //   289: ldc 180
    //   291: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   294: goto -9 -> 285
    //   297: astore_0
    //   298: goto -23 -> 275
    //   301: astore_3
    //   302: goto -80 -> 222
    //   305: aload_3
    //   306: astore_2
    //   307: goto -141 -> 166
    //   310: aconst_null
    //   311: astore 4
    //   313: aload_3
    //   314: astore_2
    //   315: goto -161 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramContext	Context
    //   111	21	1	i	int
    //   78	169	2	localObject1	Object
    //   287	2	2	localIOException1	IOException
    //   306	9	2	localException1	Exception
    //   1	189	3	localObject2	Object
    //   202	16	3	localIOException2	IOException
    //   221	27	3	localObject3	Object
    //   261	2	3	localIOException3	IOException
    //   301	13	3	localException2	Exception
    //   102	60	4	localFileInputStream1	FileInputStream
    //   212	8	4	localException3	Exception
    //   224	88	4	localFileInputStream2	FileInputStream
    //   98	156	5	localFileInputStream3	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   161	166	202	java/io/IOException
    //   45	79	212	java/lang/Exception
    //   83	100	212	java/lang/Exception
    //   253	258	261	java/io/IOException
    //   45	79	271	finally
    //   83	100	271	finally
    //   280	285	287	java/io/IOException
    //   106	112	297	finally
    //   131	135	297	finally
    //   141	148	297	finally
    //   226	236	297	finally
    //   240	246	297	finally
    //   106	112	301	java/lang/Exception
    //   131	135	301	java/lang/Exception
    //   141	148	301	java/lang/Exception
  }
  
  public static String getLanguage(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
    if (paramContext.equals("CN")) {
      return "CN";
    }
    if (paramContext.equals("TW")) {
      return "TW";
    }
    return "EN";
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
  
  public static String getLogDir(Context paramContext)
  {
    if ((t.at != null) && (t.at.length() != 0)) {
      return t.at;
    }
    try
    {
      if (ExistSDCard())
      {
        File localFile = Environment.getExternalStorageDirectory();
        return localFile.getAbsolutePath() + "/" + "tencent/wtlogin" + "/" + paramContext.getPackageName();
      }
      paramContext = paramContext.getFilesDir().getPath();
      paramContext = paramContext + "/" + "tencent/wtlogin";
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getLogFileName(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramContext = getLogDir(paramContext);
    return paramContext + "/wtlogin_" + paramString + ".log";
  }
  
  public static long getLogModifyTime(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    return getFileModifyTime(getLogFileName(paramContext, paramString));
  }
  
  public static String getMaskBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    if (paramInt1 + paramInt2 > paramArrayOfByte.length()) {
      return "***";
    }
    return paramArrayOfByte.substring(0, paramInt1) + "***" + paramArrayOfByte.substring(paramArrayOfByte.length() - paramInt2);
  }
  
  public static String getMaskString(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramString.length()) {
      return "***";
    }
    return paramString.substring(0, paramInt1) + "***" + paramString.substring(paramString.length() - paramInt2);
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
  
  public static byte[] getRequestInitTime()
  {
    byte[] arrayOfByte = new byte[4];
    int64_to_buf32(arrayOfByte, 0, System.currentTimeMillis() / 1000L + t.ac);
    return arrayOfByte;
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
  
  @SuppressLint({"NewApi"})
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
  
  public static byte[] get_bssid_addr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getBSSID();
          if (paramContext != null)
          {
            paramContext = paramContext.toLowerCase().getBytes();
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
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
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: iconst_0
    //   8: newarray byte
    //   10: astore 5
    //   12: aload 5
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 953	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: new 329	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 997
    //   30: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 999
    //   36: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1001
    //   42: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 1007	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: astore 6
    //   53: new 329	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   60: ldc 180
    //   62: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_1
    //   66: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 7
    //   74: new 329	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   81: ldc 180
    //   83: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 8
    //   95: aload_0
    //   96: aload 6
    //   98: iconst_5
    //   99: anewarray 314	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: ldc_w 1009
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: ldc_w 1011
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: ldc_w 1013
    //   119: aastore
    //   120: dup
    //   121: iconst_3
    //   122: ldc_w 1015
    //   125: aastore
    //   126: dup
    //   127: iconst_4
    //   128: ldc_w 1017
    //   131: aastore
    //   132: ldc_w 1019
    //   135: iconst_2
    //   136: anewarray 314	java/lang/String
    //   139: dup
    //   140: iconst_0
    //   141: aload 7
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 8
    //   148: aastore
    //   149: aconst_null
    //   150: invokevirtual 1025	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +98 -> 253
    //   158: aload_0
    //   159: astore 5
    //   161: aload_0
    //   162: invokeinterface 1030 1 0
    //   167: ifeq +86 -> 253
    //   170: aload_0
    //   171: astore 5
    //   173: aload_0
    //   174: aload_0
    //   175: ldc_w 1015
    //   178: invokeinterface 1033 2 0
    //   183: invokeinterface 1035 2 0
    //   188: astore 6
    //   190: aload_0
    //   191: astore 5
    //   193: aload_0
    //   194: aload_0
    //   195: ldc_w 1017
    //   198: invokeinterface 1033 2 0
    //   203: invokeinterface 1035 2 0
    //   208: astore 7
    //   210: aload_0
    //   211: astore 5
    //   213: aload 6
    //   215: invokestatic 1038	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   218: aload 7
    //   220: invokevirtual 318	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +30 -> 253
    //   226: aload_0
    //   227: astore 5
    //   229: aload 6
    //   231: invokestatic 1042	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   234: astore 6
    //   236: aload 6
    //   238: astore 5
    //   240: aload_0
    //   241: ifnull -229 -> 12
    //   244: aload_0
    //   245: invokeinterface 1043 1 0
    //   250: aload 6
    //   252: areturn
    //   253: aload_0
    //   254: ifnull +9 -> 263
    //   257: aload_0
    //   258: invokeinterface 1043 1 0
    //   263: ldc_w 1045
    //   266: invokestatic 1042	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   269: areturn
    //   270: astore 6
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_0
    //   275: astore 5
    //   277: aload 6
    //   279: ldc 180
    //   281: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   284: aload_0
    //   285: ifnull -22 -> 263
    //   288: aload_0
    //   289: invokeinterface 1043 1 0
    //   294: goto -31 -> 263
    //   297: astore_0
    //   298: aload 5
    //   300: ifnull +10 -> 310
    //   303: aload 5
    //   305: invokeinterface 1043 1 0
    //   310: aload_0
    //   311: athrow
    //   312: astore_0
    //   313: goto -15 -> 298
    //   316: astore 6
    //   318: goto -44 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   0	321	1	paramLong1	long
    //   0	321	3	paramLong2	long
    //   1	303	5	localObject1	Object
    //   51	200	6	localObject2	Object
    //   270	8	6	localException1	Exception
    //   316	1	6	localException2	Exception
    //   72	147	7	str1	String
    //   93	54	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   53	154	270	java/lang/Exception
    //   53	154	297	finally
    //   161	170	312	finally
    //   173	190	312	finally
    //   193	210	312	finally
    //   213	226	312	finally
    //   229	236	312	finally
    //   277	284	312	finally
    //   161	170	316	java/lang/Exception
    //   173	190	316	java/lang/Exception
    //   193	210	316	java/lang/Exception
    //   213	226	316	java/lang/Exception
    //   229	236	316	java/lang/Exception
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static int get_last_flag(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("last_flag", 0);
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_guid", new String("")));
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_imei", new String("")));
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_mac", new String("")));
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
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("netretry_type", 0);
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
    return "android".getBytes();
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
  
  @SuppressLint({"NewApi"})
  @TargetApi(4)
  public static String get_proxy_ip()
  {
    if (Build.VERSION.SDK_INT < HONEYCOMB) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  @SuppressLint({"NewApi", "NewApi"})
  @TargetApi(4)
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
    return "2017/08/17 18:22:06";
  }
  
  public static byte[] get_rsa_privkey(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_privkey", ""));
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_pubkey", ""));
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
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
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
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("network_type", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static long get_server_cur_time()
  {
    return t.g();
  }
  
  public static byte[] get_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host2", "").getBytes();
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
  
  public static byte[] get_ssid_addr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getSSID();
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
  
  public static byte[] get_wap_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host2", "").getBytes();
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
  
  public static boolean isMQQExist(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getPackageInfo("com.tencent.mobileqq", 0);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.versionName;
        if (paramContext.compareTo("4.6.0") >= 0) {
          return true;
        }
        try
        {
          int i = Integer.parseInt(paramContext.substring(0, paramContext.indexOf(".")));
          if (i < 10) {
            continue;
          }
          return true;
        }
        catch (Exception paramContext)
        {
          printException(paramContext, "");
          return false;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean isPackageExist(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      LOGI(paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName, "");
      return true;
    }
    catch (Exception paramContext) {}
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
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 188	oicq/wlogin_sdk/tools/util:loadEncryptSo	Z
    //   5: ifne +7 -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: getstatic 193	android/os/Build$VERSION:SDK_INT	I
    //   15: bipush 23
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: getstatic 186	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   25: ifne -15 -> 10
    //   28: aload_1
    //   29: ifnull +14 -> 43
    //   32: aload_0
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: invokevirtual 580	java/lang/String:length	()I
    //   40: ifne +5 -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: new 584	java/io/File
    //   48: dup
    //   49: new 329	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   56: aload_1
    //   57: invokevirtual 635	android/content/Context:getFilesDir	()Ljava/io/File;
    //   60: invokevirtual 1253	java/io/File:getParent	()Ljava/lang/String;
    //   63: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1255
    //   69: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 1257
    //   79: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 586	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore 5
    //   90: aload 5
    //   92: astore 4
    //   94: aload 5
    //   96: invokevirtual 814	java/io/File:exists	()Z
    //   99: ifne +128 -> 227
    //   102: new 584	java/io/File
    //   105: dup
    //   106: new 329	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 635	android/content/Context:getFilesDir	()Ljava/io/File;
    //   117: invokevirtual 1253	java/io/File:getParent	()Ljava/lang/String;
    //   120: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 1259
    //   126: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 1257
    //   136: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 586	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +115 -> 262
    //   150: aload_1
    //   151: invokevirtual 814	java/io/File:exists	()Z
    //   154: ifeq +108 -> 262
    //   157: aload_1
    //   158: invokevirtual 625	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokestatic 1262	java/lang/System:load	(Ljava/lang/String;)V
    //   164: iconst_1
    //   165: istore_2
    //   166: iload_2
    //   167: istore_3
    //   168: iload_2
    //   169: ifne +9 -> 178
    //   172: aload_0
    //   173: invokestatic 1264	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   176: iconst_1
    //   177: istore_3
    //   178: iload_3
    //   179: ifne +3 -> 182
    //   182: iload_3
    //   183: putstatic 186	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   186: new 329	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 1266
    //   196: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: getstatic 186	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   202: invokevirtual 1269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   205: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: ldc 180
    //   210: invokestatic 668	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: iload_3
    //   214: ireturn
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_1
    //   219: aload 4
    //   221: invokestatic 1272	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   224: aload_1
    //   225: astore 4
    //   227: aload 4
    //   229: astore_1
    //   230: goto -84 -> 146
    //   233: astore_1
    //   234: new 329	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 1274
    //   244: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 1277	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: ldc 180
    //   259: invokestatic 668	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: iconst_0
    //   263: istore_2
    //   264: goto -98 -> 166
    //   267: astore_0
    //   268: new 329	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 1274
    //   278: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_0
    //   282: invokevirtual 1277	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: ldc 180
    //   293: invokestatic 668	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: iload_2
    //   297: istore_3
    //   298: goto -120 -> 178
    //   301: astore 4
    //   303: aload 5
    //   305: astore_1
    //   306: goto -87 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   0	309	1	paramContext	Context
    //   1	296	2	bool1	boolean
    //   167	131	3	bool2	boolean
    //   92	1	4	localFile1	File
    //   215	5	4	localException1	Exception
    //   225	3	4	localContext	Context
    //   301	1	4	localException2	Exception
    //   88	216	5	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   45	90	215	java/lang/Exception
    //   157	164	233	java/lang/UnsatisfiedLinkError
    //   172	176	267	java/lang/UnsatisfiedLinkError
    //   94	146	301	java/lang/Exception
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
          if (i > 528384)
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
  
  /* Error */
  public static void saveGuidToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +168 -> 169
    //   4: aload_1
    //   5: ifnull +164 -> 169
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +159 -> 169
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
    //   29: new 584	java/io/File
    //   32: dup
    //   33: new 329	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   40: aload_0
    //   41: invokevirtual 635	android/content/Context:getFilesDir	()Ljava/io/File;
    //   44: invokevirtual 625	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 828
    //   53: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 586	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 8
    //   64: aload 6
    //   66: astore 4
    //   68: aload 7
    //   70: astore_2
    //   71: aload 8
    //   73: invokevirtual 814	java/io/File:exists	()Z
    //   76: ifne +16 -> 92
    //   79: aload 6
    //   81: astore 4
    //   83: aload 7
    //   85: astore_2
    //   86: aload 8
    //   88: invokevirtual 1331	java/io/File:createNewFile	()Z
    //   91: pop
    //   92: aload 5
    //   94: astore_3
    //   95: aload 6
    //   97: astore 4
    //   99: aload 7
    //   101: astore_2
    //   102: aload 8
    //   104: invokevirtual 814	java/io/File:exists	()Z
    //   107: ifeq +44 -> 151
    //   110: aload 5
    //   112: astore_3
    //   113: aload 6
    //   115: astore 4
    //   117: aload 7
    //   119: astore_2
    //   120: aload 8
    //   122: invokevirtual 1334	java/io/File:canWrite	()Z
    //   125: ifeq +26 -> 151
    //   128: aload 6
    //   130: astore 4
    //   132: aload 7
    //   134: astore_2
    //   135: new 1336	java/io/FileOutputStream
    //   138: dup
    //   139: aload 8
    //   141: iconst_0
    //   142: invokespecial 1339	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   145: astore_3
    //   146: aload_3
    //   147: aload_1
    //   148: invokevirtual 1340	java/io/FileOutputStream:write	([B)V
    //   151: aload_3
    //   152: astore 4
    //   154: aload_3
    //   155: astore_2
    //   156: aload_0
    //   157: aload_1
    //   158: invokestatic 1343	oicq/wlogin_sdk/tools/util:save_imei	(Landroid/content/Context;[B)V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 1344	java/io/FileOutputStream:close	()V
    //   169: return
    //   170: astore_0
    //   171: aload_0
    //   172: ldc 180
    //   174: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   177: return
    //   178: astore_0
    //   179: aload 4
    //   181: astore_2
    //   182: aload_0
    //   183: ldc 180
    //   185: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   188: aload 4
    //   190: ifnull -21 -> 169
    //   193: aload 4
    //   195: invokevirtual 1344	java/io/FileOutputStream:close	()V
    //   198: return
    //   199: astore_0
    //   200: aload_0
    //   201: ldc 180
    //   203: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   206: return
    //   207: astore_0
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 1344	java/io/FileOutputStream:close	()V
    //   216: aload_0
    //   217: athrow
    //   218: astore_1
    //   219: aload_1
    //   220: ldc 180
    //   222: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   225: goto -9 -> 216
    //   228: astore_0
    //   229: aload_3
    //   230: astore_2
    //   231: goto -23 -> 208
    //   234: astore_0
    //   235: aload_3
    //   236: astore 4
    //   238: goto -59 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramContext	Context
    //   0	241	1	paramArrayOfByte	byte[]
    //   28	203	2	localObject1	Object
    //   94	142	3	localObject2	Object
    //   24	213	4	localObject3	Object
    //   20	91	5	localObject4	Object
    //   14	115	6	localObject5	Object
    //   17	116	7	localObject6	Object
    //   62	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   165	169	170	java/io/IOException
    //   29	64	178	java/lang/Exception
    //   71	79	178	java/lang/Exception
    //   86	92	178	java/lang/Exception
    //   102	110	178	java/lang/Exception
    //   120	128	178	java/lang/Exception
    //   135	146	178	java/lang/Exception
    //   156	161	178	java/lang/Exception
    //   193	198	199	java/io/IOException
    //   29	64	207	finally
    //   71	79	207	finally
    //   86	92	207	finally
    //   102	110	207	finally
    //   120	128	207	finally
    //   135	146	207	finally
    //   156	161	207	finally
    //   182	188	207	finally
    //   212	216	218	java/io/IOException
    //   146	151	228	finally
    //   146	151	234	java/lang/Exception
  }
  
  public static void save_cur_flag(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putInt("last_flag", paramInt);
      paramContext.commit();
    }
  }
  
  public static void save_cur_guid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_guid", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_imei(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_imei", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_mac(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_mac", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_imei(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("imei", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_network_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
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
    //   7: invokevirtual 953	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 7
    //   12: new 329	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 997
    //   22: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 999
    //   28: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 1001
    //   34: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 1007	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 1372	android/net/Uri:toString	()Ljava/lang/String;
    //   50: invokestatic 555	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   53: new 329	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   60: ldc 180
    //   62: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_1
    //   66: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: new 329	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   81: ldc 180
    //   83: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 9
    //   95: aload 7
    //   97: aload 8
    //   99: iconst_5
    //   100: anewarray 314	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 1009
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: ldc_w 1011
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: ldc_w 1013
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: ldc_w 1015
    //   126: aastore
    //   127: dup
    //   128: iconst_4
    //   129: ldc_w 1017
    //   132: aastore
    //   133: ldc_w 1019
    //   136: iconst_2
    //   137: anewarray 314	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: aload 6
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload 9
    //   149: aastore
    //   150: aconst_null
    //   151: invokevirtual 1025	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnonnull +17 -> 175
    //   161: aload 6
    //   163: ifnull +10 -> 173
    //   166: aload 6
    //   168: invokeinterface 1043 1 0
    //   173: iconst_0
    //   174: ireturn
    //   175: aload_0
    //   176: invokestatic 1374	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   179: invokestatic 1360	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 580	java/lang/String:length	()I
    //   187: istore 5
    //   189: iload 5
    //   191: ifne +17 -> 208
    //   194: aload 6
    //   196: ifnull +10 -> 206
    //   199: aload 6
    //   201: invokeinterface 1043 1 0
    //   206: iconst_0
    //   207: ireturn
    //   208: aload_0
    //   209: invokestatic 1038	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 9
    //   214: aload 6
    //   216: invokeinterface 1377 1 0
    //   221: ifle +53 -> 274
    //   224: new 1379	android/content/ContentValues
    //   227: dup
    //   228: invokespecial 1380	android/content/ContentValues:<init>	()V
    //   231: astore 7
    //   233: aload 7
    //   235: ldc_w 1015
    //   238: aload_0
    //   239: invokevirtual 1383	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 7
    //   244: ldc_w 1017
    //   247: aload 9
    //   249: invokevirtual 1383	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 6
    //   254: invokeinterface 1030 1 0
    //   259: pop
    //   260: aload 6
    //   262: ifnull +10 -> 272
    //   265: aload 6
    //   267: invokeinterface 1043 1 0
    //   272: iconst_1
    //   273: ireturn
    //   274: new 1379	android/content/ContentValues
    //   277: dup
    //   278: invokespecial 1380	android/content/ContentValues:<init>	()V
    //   281: astore 10
    //   283: aload 10
    //   285: ldc_w 1011
    //   288: lload_1
    //   289: invokestatic 1386	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: invokevirtual 1389	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   295: aload 10
    //   297: ldc_w 1013
    //   300: lload_3
    //   301: invokestatic 1386	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   304: invokevirtual 1389	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   307: aload 10
    //   309: ldc_w 1015
    //   312: aload_0
    //   313: invokevirtual 1383	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 10
    //   318: ldc_w 1017
    //   321: aload 9
    //   323: invokevirtual 1383	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 7
    //   328: aload 8
    //   330: aload 10
    //   332: invokevirtual 1393	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   335: astore_0
    //   336: new 329	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 330	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 1395
    //   346: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: invokevirtual 1398	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 1400
    //   356: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: lload_1
    //   360: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: ldc_w 1402
    //   366: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: lload_3
    //   370: invokevirtual 808	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 1404	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   379: goto -119 -> 260
    //   382: astore 7
    //   384: aload 6
    //   386: astore_0
    //   387: aload 7
    //   389: astore 6
    //   391: aload 6
    //   393: ldc 180
    //   395: invokestatic 424	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   398: aload_0
    //   399: ifnull +9 -> 408
    //   402: aload_0
    //   403: invokeinterface 1043 1 0
    //   408: iconst_0
    //   409: ireturn
    //   410: astore_0
    //   411: aconst_null
    //   412: astore 6
    //   414: aload 6
    //   416: ifnull +10 -> 426
    //   419: aload 6
    //   421: invokeinterface 1043 1 0
    //   426: aload_0
    //   427: athrow
    //   428: astore_0
    //   429: goto -15 -> 414
    //   432: astore 7
    //   434: aload_0
    //   435: astore 6
    //   437: aload 7
    //   439: astore_0
    //   440: goto -26 -> 414
    //   443: astore 6
    //   445: aconst_null
    //   446: astore_0
    //   447: goto -56 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	paramContext	Context
    //   0	450	1	paramLong1	long
    //   0	450	3	paramLong2	long
    //   187	3	5	i	int
    //   72	364	6	localObject1	Object
    //   443	1	6	localException1	Exception
    //   10	317	7	localObject2	Object
    //   382	6	7	localException2	Exception
    //   432	6	7	localObject3	Object
    //   43	286	8	localUri	android.net.Uri
    //   93	229	9	str	String
    //   281	50	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   175	189	382	java/lang/Exception
    //   208	260	382	java/lang/Exception
    //   274	379	382	java/lang/Exception
    //   53	156	410	finally
    //   175	189	428	finally
    //   208	260	428	finally
    //   274	379	428	finally
    //   391	398	432	finally
    //   53	156	443	java/lang/Exception
  }
  
  public static void set_ksid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      byte[] arrayOfByte = get_ksid(paramContext);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        paramContext.putString("ksid", buf_to_string(paramArrayOfByte));
        paramContext.commit();
      }
    }
  }
  
  public static void set_net_retry_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putInt("netretry_type", paramInt);
      paramContext.commit();
    }
  }
  
  public static void set_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static boolean shouldKick(int paramInt)
  {
    return (paramInt != -1000) && (paramInt != 257) && (paramInt != -1026);
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
    //   8: invokevirtual 580	java/lang/String:length	()I
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: new 584	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 586	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 814	java/io/File:exists	()Z
    //   33: ifne +30 -> 63
    //   36: aload_3
    //   37: invokevirtual 1444	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull -28 -> 16
    //   47: aload 4
    //   49: invokevirtual 1447	java/io/File:mkdirs	()Z
    //   52: ifne +11 -> 63
    //   55: aload 4
    //   57: invokevirtual 589	java/io/File:isDirectory	()Z
    //   60: ifeq -44 -> 16
    //   63: aload_0
    //   64: invokestatic 1449	oicq/wlogin_sdk/tools/util:getFileSize	(Ljava/lang/String;)I
    //   67: ldc 126
    //   69: if_icmpge -53 -> 16
    //   72: new 1336	java/io/FileOutputStream
    //   75: dup
    //   76: aload_3
    //   77: iconst_1
    //   78: invokespecial 1339	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: invokevirtual 1340	java/io/FileOutputStream:write	([B)V
    //   87: aload_0
    //   88: invokevirtual 1344	java/io/FileOutputStream:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */