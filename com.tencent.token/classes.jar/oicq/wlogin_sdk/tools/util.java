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
import java.io.FileOutputStream;
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
  public static int LOG_LEVEL = 1;
  public static int MAX_APPID = 65535;
  public static final int MAX_CONTENT_SIZE = 20480;
  public static final int MAX_FILE_SIZE = 524288;
  public static int MAX_NAME_LEN = 128;
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
  private static boolean libwtecdh_loaded = false;
  public static boolean loadEncryptSo = true;
  public static String logContent = "";
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT > 9) {
      i = 4;
    } else {
      i = 0;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.d(localStringBuilder.toString(), paramString);
        }
      }
      return;
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
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.d((String)localObject, localStringBuilder.toString());
        }
      }
      return;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.i(localStringBuilder.toString(), paramString);
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGI(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1);
        }
        else if (LOGCAT_OUT)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.i(localStringBuilder.toString(), paramString1);
        }
        d.a(paramString1, paramString2);
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
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.w((String)localObject, localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1, paramString2);
        }
        else if (LOGCAT_OUT)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.w((String)localObject, localStringBuilder.toString());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramString2);
        d.a(((StringBuilder)localObject).toString(), paramString3);
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static byte[] RSADecrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if (paramArrayOfByte != null) {
      if (paramKey == null) {
        return null;
      }
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramKey);
        k = paramArrayOfByte.length;
        paramKey = new byte[k];
        if (k % 128 == 0) {
          break label129;
        }
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        int k;
        byte[] arrayOfByte;
        return null;
      }
      if (i < k / 128)
      {
        arrayOfByte = new byte[''];
        System.arraycopy(paramArrayOfByte, i * 128, arrayOfByte, 0, 128);
        arrayOfByte = localCipher.doFinal(arrayOfByte);
        System.arraycopy(arrayOfByte, 0, paramKey, j, arrayOfByte.length);
        j += arrayOfByte.length;
        i += 1;
      }
      else
      {
        paramArrayOfByte = new byte[j];
        System.arraycopy(paramKey, 0, paramArrayOfByte, 0, j);
        return paramArrayOfByte;
        return null;
        label129:
        i = 0;
        j = 0;
      }
    }
  }
  
  public static byte[] RSAEncrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if (paramArrayOfByte != null) {
      if (paramKey == null) {
        return null;
      }
    }
    for (;;)
    {
      int i;
      int j;
      int m;
      int k;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, paramKey);
        i = paramArrayOfByte.length;
        j = i / 117;
        double d = j;
        Double.isNaN(d);
        m = (int)Math.round(d + 0.5D);
        paramKey = new byte[m * 128];
        j = 0;
        k = 117;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        byte[] arrayOfByte;
        return null;
      }
      arrayOfByte = new byte[k];
      System.arraycopy(paramArrayOfByte, j * 117, arrayOfByte, 0, k);
      System.arraycopy(localCipher.doFinal(arrayOfByte), 0, paramKey, 128 * j, 128);
      i -= k;
      j += 1;
      break label139;
      return paramKey;
      return null;
      label139:
      if (j < m) {
        if (i < 117) {
          k = i;
        }
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
    arrayOfByte1[25] = ((byte)(arrayOfByte1[25] + i));
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
    int i = 0;
    int j = 0;
    int m = 0;
    int n = 0;
    int k = paramInt;
    paramInt = n;
    int i1;
    for (;;)
    {
      n = k - 1;
      i1 = j;
      if (k <= 0) {
        break;
      }
      j = i + 1;
      i = paramArrayOfByte[i];
      i1 = i;
      if (i == 0) {
        break;
      }
      if (i == 95)
      {
        i1 = i;
        break;
      }
      k = i;
      if (i == 32) {
        k = 42;
      }
      i1 = base64_reverse_table_url[k];
      if (i1 < 0)
      {
        i = j;
        k = n;
        j = i1;
      }
      else
      {
        switch (m % 4)
        {
        default: 
          break;
        case 3: 
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1));
          paramInt += 1;
          break;
        case 2: 
          i = paramInt + 1;
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1 >> 2));
          arrayOfByte[i] = ((byte)((i1 & 0x3) << 6));
          paramInt = i;
          break;
        case 1: 
          i = paramInt + 1;
          arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i1 >> 4));
          arrayOfByte[i] = ((byte)((i1 & 0xF) << 4));
          paramInt = i;
          break;
        case 0: 
          arrayOfByte[paramInt] = ((byte)(i1 << 2));
        }
        m += 1;
        i = j;
        k = n;
        j = i1;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      default: 
        return arrayOfByte;
      case 2: 
        i = paramInt + 1;
      case 3: 
        arrayOfByte[i] = 0;
        return arrayOfByte;
      }
      return null;
    }
    return arrayOfByte;
  }
  
  public static String base64_encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int k;
    for (int i = 0; i < j; i = k + 1)
    {
      int m = i + 1;
      i = paramArrayOfByte[i] & 0xFF;
      if (m == j)
      {
        localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4)]);
        break;
      }
      k = m + 1;
      m = paramArrayOfByte[m] & 0xFF;
      if (k == j)
      {
        localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
        localStringBuffer.append(base64_encode_chars[((m & 0xF) << 2)]);
        break;
      }
      int n = paramArrayOfByte[k] & 0xFF;
      localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
      localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
      localStringBuffer.append(base64_encode_chars[((m & 0xF) << 2 | (n & 0xC0) >>> 6)]);
      localStringBuffer.append(base64_encode_chars[(n & 0x3F)]);
    }
    return localStringBuffer.toString();
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
    return (paramArrayOfByte[paramInt] << 56 & 0x0) + 0L + (paramArrayOfByte[(paramInt + 1)] << 48 & 0x0) + (paramArrayOfByte[(paramInt + 2)] << 40 & 0x0) + (paramArrayOfByte[(paramInt + 3)] << 32 & 0x0) + (paramArrayOfByte[(paramInt + 4)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 5)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 6)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 7)] << 0 & 0xFF);
  }
  
  public static int buf_to_int8(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    String str = "";
    paramInt = 0;
    while (paramInt < i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[paramInt] >> 4 & 0xF));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[paramInt] & 0xF));
      str = localStringBuilder.toString();
      paramInt += 1;
    }
    return str;
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
    catch (NumberFormatException paramString)
    {
      label31:
      break label31;
    }
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
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      localByteArrayOutputStream = new ByteArrayOutputStream();
    }
    try
    {
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label44:
      break label44;
    }
    return new byte[0];
    return paramArrayOfByte;
  }
  
  public static long constructSalt()
  {
    return (get_rand_32() << 32) + get_rand_32();
  }
  
  public static void decompress(byte[] paramArrayOfByte)
  {
    Object localObject1;
    int j;
    int i;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("data len:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      LOGI(((StringBuilder)localObject1).toString());
      j = 0;
      i = 0;
    }
    for (;;)
    {
      int k;
      Object localObject2;
      if (paramArrayOfByte.length > j + 3)
      {
        k = buf_to_int32(paramArrayOfByte, j);
        if (paramArrayOfByte.length > j + k + 3)
        {
          localObject2 = new byte[k];
          j += 4;
          System.arraycopy(paramArrayOfByte, j, localObject2, 0, k);
          j += k;
          i += 1;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("len:");
          ((StringBuilder)localObject1).append(k);
          LOGI(((StringBuilder)localObject1).toString());
          localObject1 = new ByteArrayOutputStream();
          localObject2 = new ByteArrayInputStream((byte[])localObject2);
        }
      }
      try
      {
        localObject2 = new InflaterInputStream((InputStream)localObject2);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          k = ((InflaterInputStream)localObject2).read(arrayOfByte);
          if (k == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write(arrayOfByte, 0, k);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(((ByteArrayOutputStream)localObject1).toString());
        LOGI(((StringBuilder)localObject2).toString());
      }
      catch (IOException localIOException) {}
      return;
      return;
    }
  }
  
  public static void deleteExpireFile(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file path:");
      localStringBuilder.append(paramString);
      LOGI(localStringBuilder.toString());
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(new e());
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            if ((!paramString[i].isDirectory()) && ((System.currentTimeMillis() - paramString[i].lastModified()) / 1000L > paramInt)) {
              paramString[i].delete();
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramString) {}
    return;
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
        localObject = Environment.getExternalStorageDirectory();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("tencent/wtlogin");
        localStringBuilder.append("/");
        localStringBuilder.append(paramContext.getPackageName());
        deleteExpireFile(localStringBuilder.toString(), 691200);
        return;
      }
      paramContext = paramContext.getFilesDir().getPath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("tencent/wtlogin");
      deleteExpireFile(((StringBuilder)localObject).toString(), 259200);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int format_ret_code(int paramInt)
  {
    int i = 2;
    if ((paramInt != -1006) && (paramInt != -1002))
    {
      if (paramInt != -1000) {
        if (paramInt != 0) {
          if (paramInt == 2) {
            return i;
          }
        }
      }
      switch (paramInt)
      {
      default: 
        return 17;
        return 0;
        return 1;
      }
    }
    i = 5;
    return i;
  }
  
  public static byte[] generateGuid(Context paramContext)
  {
    if ((t.ai != null) && (t.ai.length != 0))
    {
      LOGI("generate guid from customer guid");
      return t.ai;
    }
    LOGI("generate guid temporarily");
    try
    {
      localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
      localObject3 = null;
      if (localObject1 == null) {
        break label242;
      }
      localObject1 = ((TelephonyManager)localObject1).getDeviceId();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject2;
        continue;
        Object localObject1 = null;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("imei ");
    ((StringBuilder)localObject2).append((String)localObject1);
    LOGI(((StringBuilder)localObject2).toString(), "");
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    localObject2 = localObject3;
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      localObject2 = localObject3;
      if (paramContext != null) {
        localObject2 = paramContext.getMacAddress();
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("mac ");
    paramContext.append((String)localObject2);
    LOGI(paramContext.toString(), "");
    paramContext = "";
    if (localObject1 != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append((String)localObject1);
      paramContext = paramContext.toString();
    }
    localObject1 = paramContext;
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((String)localObject1).length() <= 0) {
      return new byte[0];
    }
    paramContext = MD5.toMD5Byte(((String)localObject1).getBytes());
    return paramContext;
    return new byte[0];
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
    catch (Exception localException)
    {
      label21:
      break label21;
    }
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
    catch (Throwable paramContext)
    {
      label42:
      break label42;
    }
    return new byte[0];
  }
  
  public static String getChannelId(Context paramContext, String paramString)
  {
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
    int i;
    label466:
    label477:
    do
    {
      Object localObject3;
      for (;;)
      {
        try
        {
          localObject3 = paramContext.getPackageInfo((String)localObject2, 0).applicationInfo.sourceDir;
          localObject1 = paramString;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = paramString;
          localStringBuilder.append("pkg ");
          localObject1 = paramString;
          localStringBuilder.append((String)localObject2);
          localObject1 = paramString;
          localStringBuilder.append(" path ");
          if (localObject3 == null)
          {
            paramContext = "null";
            localObject1 = paramString;
            localStringBuilder.append(paramContext);
            localObject1 = paramString;
            LOGI(localStringBuilder.toString(), "");
            if (localObject3 != null)
            {
              localObject1 = paramString;
              if (((String)localObject3).length() == 0) {
                return "";
              }
              localObject1 = paramString;
              paramContext = new byte[4];
              paramContext[0] = 80;
              paramContext[1] = 75;
              paramContext[2] = 5;
              paramContext[3] = 6;
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
              i = 0;
              localObject1 = paramString;
              if (i >= localObject3.length - 4) {
                break;
              }
              if ((localObject3[i] != paramContext[0]) || (localObject3[(i + 1)] != paramContext[1]) || (localObject3[(i + 2)] != paramContext[2]) || (localObject3[(i + 3)] != paramContext[3])) {
                break label466;
              }
              l = i;
              break label477;
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
              paramString = new StringBuilder();
              localObject1 = paramContext;
              paramString.append("found comment ");
              localObject1 = paramContext;
              paramString.append(new String((byte[])localObject2));
              localObject1 = paramContext;
              paramString.append(" channelId:");
              localObject1 = paramContext;
              paramString.append(paramContext);
              localObject1 = paramContext;
              LOGI(paramString.toString(), "");
              return paramContext;
            }
            return "";
          }
        }
        catch (Exception paramContext)
        {
          printException(paramContext, "");
          return localObject1;
        }
        paramContext = (Context)localObject3;
        continue;
        i += 1;
      }
      long l = -1L;
      if (l == -1L) {
        return "";
      }
      i = (int)l + 20;
      i = localObject3[i] + (localObject3[(i + 1)] << 8);
    } while (i != 0);
    return "";
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
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return null;
  }
  
  public static String getDate()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static long getFileModifyTime(String paramString)
  {
    if (paramString != null) {
      if (paramString.length() == 0) {
        return 0L;
      }
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (!paramString.isFile()) {
          return 0L;
        }
        long l = paramString.lastModified();
        return l;
      }
      return 0L;
    }
    catch (Exception paramString) {}
    return 0L;
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
    //   0: getstatic 644	oicq/wlogin_sdk/request/t:ai	[B
    //   3: ifnull +22 -> 25
    //   6: getstatic 644	oicq/wlogin_sdk/request/t:ai	[B
    //   9: arraylength
    //   10: ifeq +15 -> 25
    //   13: ldc_w 821
    //   16: ldc 169
    //   18: invokestatic 663	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 644	oicq/wlogin_sdk/request/t:ai	[B
    //   24: areturn
    //   25: ldc_w 823
    //   28: ldc 169
    //   30: invokestatic 663	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aconst_null
    //   34: astore 7
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_0
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: iconst_0
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_2
    //   49: astore 5
    //   51: new 318	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   58: astore 4
    //   60: aload_2
    //   61: astore 5
    //   63: aload 4
    //   65: aload_0
    //   66: invokevirtual 630	android/content/Context:getFilesDir	()Ljava/io/File;
    //   69: invokevirtual 620	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: astore 5
    //   79: aload 4
    //   81: ldc_w 825
    //   84: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: astore 5
    //   91: new 579	java/io/File
    //   94: dup
    //   95: aload 4
    //   97: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 581	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload_2
    //   106: astore 5
    //   108: aload 4
    //   110: invokevirtual 811	java/io/File:exists	()Z
    //   113: ifeq +77 -> 190
    //   116: aload_2
    //   117: astore 5
    //   119: new 743	java/io/FileInputStream
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 828	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: astore 4
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokevirtual 747	java/io/FileInputStream:available	()I
    //   137: istore_1
    //   138: aload_3
    //   139: astore_2
    //   140: aload 4
    //   142: astore 5
    //   144: iload_1
    //   145: sipush 1024
    //   148: if_icmpge +47 -> 195
    //   151: aload_3
    //   152: astore_2
    //   153: iload_1
    //   154: newarray byte
    //   156: astore_3
    //   157: aload_3
    //   158: astore_2
    //   159: aload 4
    //   161: aload_3
    //   162: invokevirtual 754	java/io/FileInputStream:read	([B)I
    //   165: pop
    //   166: aload_3
    //   167: astore_2
    //   168: aload 4
    //   170: astore 5
    //   172: goto +23 -> 195
    //   175: astore_0
    //   176: aload 4
    //   178: astore 5
    //   180: goto +131 -> 311
    //   183: astore_3
    //   184: aload_3
    //   185: astore 6
    //   187: goto +49 -> 236
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_3
    //   194: astore_2
    //   195: aload_2
    //   196: astore_3
    //   197: aload 5
    //   199: ifnull +78 -> 277
    //   202: aload_2
    //   203: astore_3
    //   204: aload 5
    //   206: invokevirtual 755	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: astore_3
    //   211: goto +66 -> 277
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 169
    //   218: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   221: goto +56 -> 277
    //   224: astore_0
    //   225: goto +86 -> 311
    //   228: astore 6
    //   230: aload_3
    //   231: astore_2
    //   232: aload 7
    //   234: astore 4
    //   236: aload 4
    //   238: astore 5
    //   240: getstatic 831	oicq/wlogin_sdk/request/t:Y	I
    //   243: ldc_w 832
    //   246: ior
    //   247: putstatic 831	oicq/wlogin_sdk/request/t:Y	I
    //   250: aload 4
    //   252: astore 5
    //   254: aload 6
    //   256: ldc 169
    //   258: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +12 -> 277
    //   268: aload_2
    //   269: astore_3
    //   270: aload 4
    //   272: invokevirtual 755	java/io/FileInputStream:close	()V
    //   275: aload_2
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: aload_3
    //   280: arraylength
    //   281: ifgt +28 -> 309
    //   284: aload_0
    //   285: invokestatic 835	oicq/wlogin_sdk/tools/util:get_saved_imei	(Landroid/content/Context;)[B
    //   288: astore_3
    //   289: aload_3
    //   290: astore_2
    //   291: aload_3
    //   292: ifnull +17 -> 309
    //   295: aload_3
    //   296: astore_2
    //   297: aload_3
    //   298: arraylength
    //   299: ifle +10 -> 309
    //   302: aload_0
    //   303: aload_3
    //   304: invokestatic 839	oicq/wlogin_sdk/tools/util:saveGuidToFile	(Landroid/content/Context;[B)V
    //   307: aload_3
    //   308: astore_2
    //   309: aload_2
    //   310: areturn
    //   311: aload 5
    //   313: ifnull +18 -> 331
    //   316: aload 5
    //   318: invokevirtual 755	java/io/FileInputStream:close	()V
    //   321: goto +10 -> 331
    //   324: astore_2
    //   325: aload_2
    //   326: ldc 169
    //   328: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   331: aload_0
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramContext	Context
    //   137	17	1	i	int
    //   37	173	2	localObject1	Object
    //   214	2	2	localIOException1	IOException
    //   231	79	2	localObject2	Object
    //   324	2	2	localIOException2	IOException
    //   47	120	3	arrayOfByte	byte[]
    //   183	11	3	localException1	Exception
    //   196	112	3	localObject3	Object
    //   58	213	4	localObject4	Object
    //   49	268	5	localObject5	Object
    //   185	1	6	localException2	Exception
    //   228	27	6	localException3	Exception
    //   34	199	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   132	138	175	finally
    //   153	157	175	finally
    //   159	166	175	finally
    //   132	138	183	java/lang/Exception
    //   153	157	183	java/lang/Exception
    //   159	166	183	java/lang/Exception
    //   204	209	214	java/io/IOException
    //   270	275	214	java/io/IOException
    //   51	60	224	finally
    //   63	76	224	finally
    //   79	88	224	finally
    //   91	105	224	finally
    //   108	116	224	finally
    //   119	130	224	finally
    //   240	250	224	finally
    //   254	261	224	finally
    //   51	60	228	java/lang/Exception
    //   63	76	228	java/lang/Exception
    //   79	88	228	java/lang/Exception
    //   91	105	228	java/lang/Exception
    //   108	116	228	java/lang/Exception
    //   119	130	228	java/lang/Exception
    //   316	321	324	java/io/IOException
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append(":");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label77:
      break label77;
    }
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
        localObject = Environment.getExternalStorageDirectory();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("tencent/wtlogin");
        localStringBuilder.append("/");
        localStringBuilder.append(paramContext.getPackageName());
        return localStringBuilder.toString();
      }
      paramContext = paramContext.getFilesDir().getPath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("tencent/wtlogin");
      paramContext = ((StringBuilder)localObject).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label127:
      break label127;
    }
    return "";
  }
  
  public static String getLogFileName(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramContext = getLogDir(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/wtlogin_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".log");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static long getLogModifyTime(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0)) {
      return getFileModifyTime(getLogFileName(paramContext, paramString));
    }
    return 0L;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfByte.substring(0, paramInt1));
    localStringBuilder.append("***");
    localStringBuilder.append(paramArrayOfByte.substring(paramArrayOfByte.length() - paramInt2));
    return localStringBuilder.toString();
  }
  
  public static String getMaskString(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramString.length()) {
      return "***";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, paramInt1));
    localStringBuilder.append("***");
    localStringBuilder.append(paramString.substring(paramString.length() - paramInt2));
    return localStringBuilder.toString();
  }
  
  public static byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures != null) && (paramContext.signatures.length > 0) && (paramContext.signatures[0] != null)) {
        return MD5.toMD5Byte(paramContext.signatures[0].toByteArray());
      }
      return new byte[0];
    }
    catch (Throwable paramContext)
    {
      label55:
      break label55;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String getUser(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
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
    catch (Throwable paramContext)
    {
      label31:
      break label31;
    }
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
    catch (Throwable paramContext)
    {
      label22:
      break label22;
    }
    return new byte[0];
  }
  
  public static byte[] get_apk_id(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName().getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label10:
      break label10;
    }
    return new byte[0];
  }
  
  public static byte[] get_apk_v(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label18:
      break label18;
    }
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
    catch (Throwable paramContext)
    {
      label36:
      break label36;
    }
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
    catch (Throwable paramContext)
    {
      label43:
      break label43;
    }
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
    //   0: aload_0
    //   1: ifnonnull +7 -> 8
    //   4: iconst_0
    //   5: newarray byte
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 950	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 8
    //   14: new 318	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   21: astore_0
    //   22: aload_0
    //   23: ldc_w 994
    //   26: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_0
    //   31: ldc_w 996
    //   34: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc_w 998
    //   42: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1004	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   53: astore 9
    //   55: aconst_null
    //   56: astore 7
    //   58: aconst_null
    //   59: astore 6
    //   61: aload 6
    //   63: astore 5
    //   65: aload 7
    //   67: astore_0
    //   68: new 318	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   75: astore 10
    //   77: aload 6
    //   79: astore 5
    //   81: aload 7
    //   83: astore_0
    //   84: aload 10
    //   86: ldc 169
    //   88: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 6
    //   94: astore 5
    //   96: aload 7
    //   98: astore_0
    //   99: aload 10
    //   101: lload_1
    //   102: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 6
    //   108: astore 5
    //   110: aload 7
    //   112: astore_0
    //   113: aload 10
    //   115: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 10
    //   120: aload 6
    //   122: astore 5
    //   124: aload 7
    //   126: astore_0
    //   127: new 318	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   134: astore 11
    //   136: aload 6
    //   138: astore 5
    //   140: aload 7
    //   142: astore_0
    //   143: aload 11
    //   145: ldc 169
    //   147: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: astore 5
    //   155: aload 7
    //   157: astore_0
    //   158: aload 11
    //   160: lload_3
    //   161: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: astore 5
    //   169: aload 7
    //   171: astore_0
    //   172: aload 11
    //   174: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 11
    //   179: aload 6
    //   181: astore 5
    //   183: aload 7
    //   185: astore_0
    //   186: aload 8
    //   188: aload 9
    //   190: iconst_5
    //   191: anewarray 297	java/lang/String
    //   194: dup
    //   195: iconst_0
    //   196: ldc_w 1006
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: ldc_w 1008
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: ldc_w 1010
    //   211: aastore
    //   212: dup
    //   213: iconst_3
    //   214: ldc_w 1012
    //   217: aastore
    //   218: dup
    //   219: iconst_4
    //   220: ldc_w 1014
    //   223: aastore
    //   224: ldc_w 1016
    //   227: iconst_2
    //   228: anewarray 297	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: aload 10
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: aload 11
    //   240: aastore
    //   241: aconst_null
    //   242: invokevirtual 1022	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   245: astore 6
    //   247: aload 6
    //   249: ifnull +121 -> 370
    //   252: aload 6
    //   254: astore 5
    //   256: aload 6
    //   258: astore_0
    //   259: aload 6
    //   261: invokeinterface 1027 1 0
    //   266: ifeq +104 -> 370
    //   269: aload 6
    //   271: astore 5
    //   273: aload 6
    //   275: astore_0
    //   276: aload 6
    //   278: aload 6
    //   280: ldc_w 1012
    //   283: invokeinterface 1030 2 0
    //   288: invokeinterface 1032 2 0
    //   293: astore 7
    //   295: aload 6
    //   297: astore 5
    //   299: aload 6
    //   301: astore_0
    //   302: aload 6
    //   304: aload 6
    //   306: ldc_w 1014
    //   309: invokeinterface 1030 2 0
    //   314: invokeinterface 1032 2 0
    //   319: astore 8
    //   321: aload 6
    //   323: astore 5
    //   325: aload 6
    //   327: astore_0
    //   328: aload 7
    //   330: invokestatic 1035	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   333: aload 8
    //   335: invokevirtual 301	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +32 -> 370
    //   341: aload 6
    //   343: astore 5
    //   345: aload 6
    //   347: astore_0
    //   348: aload 7
    //   350: invokestatic 1039	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   353: astore 7
    //   355: aload 6
    //   357: ifnull +10 -> 367
    //   360: aload 6
    //   362: invokeinterface 1040 1 0
    //   367: aload 7
    //   369: areturn
    //   370: aload 6
    //   372: ifnull +35 -> 407
    //   375: aload 6
    //   377: astore_0
    //   378: goto +23 -> 401
    //   381: astore_0
    //   382: goto +32 -> 414
    //   385: astore 6
    //   387: aload_0
    //   388: astore 5
    //   390: aload 6
    //   392: ldc 169
    //   394: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   397: aload_0
    //   398: ifnull +9 -> 407
    //   401: aload_0
    //   402: invokeinterface 1040 1 0
    //   407: ldc_w 1042
    //   410: invokestatic 1039	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   413: areturn
    //   414: aload 5
    //   416: ifnull +10 -> 426
    //   419: aload 5
    //   421: invokeinterface 1040 1 0
    //   426: aload_0
    //   427: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramContext	Context
    //   0	428	1	paramLong1	long
    //   0	428	3	paramLong2	long
    //   63	357	5	localObject1	Object
    //   59	317	6	localCursor	android.database.Cursor
    //   385	6	6	localException	Exception
    //   56	312	7	localObject2	Object
    //   12	322	8	localObject3	Object
    //   53	136	9	localUri	android.net.Uri
    //   75	159	10	localObject4	Object
    //   134	105	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   68	77	381	finally
    //   84	92	381	finally
    //   99	106	381	finally
    //   113	120	381	finally
    //   127	136	381	finally
    //   143	151	381	finally
    //   158	165	381	finally
    //   172	179	381	finally
    //   186	247	381	finally
    //   259	269	381	finally
    //   276	295	381	finally
    //   302	321	381	finally
    //   328	341	381	finally
    //   348	355	381	finally
    //   390	397	381	finally
    //   68	77	385	java/lang/Exception
    //   84	92	385	java/lang/Exception
    //   99	106	385	java/lang/Exception
    //   113	120	385	java/lang/Exception
    //   127	136	385	java/lang/Exception
    //   143	151	385	java/lang/Exception
    //   158	165	385	java/lang/Exception
    //   172	179	385	java/lang/Exception
    //   186	247	385	java/lang/Exception
    //   259	269	385	java/lang/Exception
    //   276	295	385	java/lang/Exception
    //   302	321	385	java/lang/Exception
    //   328	341	385	java/lang/Exception
    //   348	355	385	java/lang/Exception
  }
  
  public static String get_error_msg(int paramInt)
  {
    if (paramInt != -1000) {
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
    catch (Throwable paramContext)
    {
      label31:
      break label31;
    }
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
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return new byte[0];
  }
  
  public static String get_mpasswd()
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = SecureRandom.getSeed(16);
        str = "";
        i = 0;
        if (i >= arrayOfByte.length) {
          continue;
        }
        boolean bool = new Random().nextBoolean();
        k = Math.abs(arrayOfByte[i] % 26);
        if (!bool) {
          continue;
        }
        j = 97;
      }
      catch (Throwable localThrowable)
      {
        String str;
        int i;
        int k;
        StringBuilder localStringBuilder;
        continue;
        int j = 65;
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf((char)(k + j)));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
    return "1234567890123456";
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
    }
    catch (Throwable paramContext)
    {
      int i;
      label20:
      break label20;
    }
    i = 0;
    if (i == 0) {
      return 1;
    }
    if (i == 1) {
      return 2;
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
    catch (Throwable localThrowable)
    {
      label66:
      break label66;
    }
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
    catch (Throwable paramSecureRandom)
    {
      label12:
      break label12;
    }
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
    catch (Throwable paramArrayOfByte)
    {
      label40:
      break label40;
    }
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
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
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
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
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
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
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
    catch (Exception paramString)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  public static boolean isMQQExist(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo("com.tencent.mobileqq", 0);
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.versionName;
      if (paramContext.compareTo("4.6.0") >= 0) {
        return true;
      }
      try
      {
        int i = Integer.parseInt(paramContext.substring(0, paramContext.indexOf(".")));
        return i >= 10;
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
        if (paramContext.equalsIgnoreCase("uniwap")) {
          return true;
        }
        if (paramContext.equalsIgnoreCase("ctwap")) {
          return true;
        }
        boolean bool = paramContext.equalsIgnoreCase("3gwap");
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label59:
      break label59;
    }
    return false;
  }
  
  public static boolean is_wap_retry(Context paramContext)
  {
    return get_net_retry_type(paramContext) != 0;
  }
  
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    boolean bool1 = loadEncryptSo;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return false;
    }
    if (libwtecdh_loaded) {
      return true;
    }
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return false;
      }
      StringBuilder localStringBuilder2 = null;
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getFilesDir().getParent());
        ((StringBuilder)localObject).append("/txlib/lib");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(".so");
        localObject = new File(((StringBuilder)localObject).toString());
        try
        {
          if (!((File)localObject).exists())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramContext.getFilesDir().getParent());
            localStringBuilder2.append("/lib/lib");
            localStringBuilder2.append(paramString);
            localStringBuilder2.append(".so");
            paramContext = new File(localStringBuilder2.toString());
          }
          else
          {
            paramContext = (Context)localObject;
          }
        }
        catch (Exception localException2)
        {
          paramContext = (Context)localObject;
          localObject = localException2;
        }
        printException(localException1);
      }
      catch (Exception localException1)
      {
        paramContext = localException2;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.exists()) {
          try
          {
            System.load(paramContext.getAbsolutePath());
            bool1 = true;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("loadLibrary failed ");
            localStringBuilder1.append(paramContext.getMessage());
            LOGI(localStringBuilder1.toString(), "");
            bool1 = bool2;
          }
        }
      }
      bool2 = bool1;
      if (!bool1) {
        try
        {
          System.loadLibrary(paramString);
          bool2 = true;
        }
        catch (UnsatisfiedLinkError paramString)
        {
          paramContext = new StringBuilder();
          paramContext.append("loadLibrary failed ");
          paramContext.append(paramString.getMessage());
          LOGI(paramContext.toString(), "");
          bool2 = bool1;
        }
      }
      libwtecdh_loaded = bool2;
      paramString = new StringBuilder();
      paramString.append("libwtecdh loaded ");
      paramString.append(libwtecdh_loaded);
      LOGI(paramString.toString(), "");
      return bool2;
    }
    return false;
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
    if (paramString != null) {
      if (paramString.length() == 0) {
        return null;
      }
    }
    try
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        if (!((File)localObject).isFile()) {
          return null;
        }
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
      return null;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  public static byte[] readLog(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0)) {
      return readFile(getLogFileName(paramContext, paramString));
    }
    return null;
  }
  
  /* Error */
  public static void saveGuidToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +265 -> 266
    //   4: aload_1
    //   5: ifnull +261 -> 266
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +256 -> 266
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 7
    //   19: aconst_null
    //   20: astore 5
    //   22: aload 6
    //   24: astore_2
    //   25: aload 7
    //   27: astore 4
    //   29: new 318	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   36: astore_3
    //   37: aload 6
    //   39: astore_2
    //   40: aload 7
    //   42: astore 4
    //   44: aload_3
    //   45: aload_0
    //   46: invokevirtual 630	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 620	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 6
    //   58: astore_2
    //   59: aload 7
    //   61: astore 4
    //   63: aload_3
    //   64: ldc_w 825
    //   67: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: astore_2
    //   74: aload 7
    //   76: astore 4
    //   78: new 579	java/io/File
    //   81: dup
    //   82: aload_3
    //   83: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 581	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 8
    //   91: aload 6
    //   93: astore_2
    //   94: aload 7
    //   96: astore 4
    //   98: aload 8
    //   100: invokevirtual 811	java/io/File:exists	()Z
    //   103: ifne +16 -> 119
    //   106: aload 6
    //   108: astore_2
    //   109: aload 7
    //   111: astore 4
    //   113: aload 8
    //   115: invokevirtual 1332	java/io/File:createNewFile	()Z
    //   118: pop
    //   119: aload 5
    //   121: astore_3
    //   122: aload 6
    //   124: astore_2
    //   125: aload 7
    //   127: astore 4
    //   129: aload 8
    //   131: invokevirtual 811	java/io/File:exists	()Z
    //   134: ifeq +60 -> 194
    //   137: aload 5
    //   139: astore_3
    //   140: aload 6
    //   142: astore_2
    //   143: aload 7
    //   145: astore 4
    //   147: aload 8
    //   149: invokevirtual 1335	java/io/File:canWrite	()Z
    //   152: ifeq +42 -> 194
    //   155: aload 6
    //   157: astore_2
    //   158: aload 7
    //   160: astore 4
    //   162: new 1337	java/io/FileOutputStream
    //   165: dup
    //   166: aload 8
    //   168: iconst_0
    //   169: invokespecial 1340	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   172: astore_3
    //   173: aload_3
    //   174: aload_1
    //   175: invokevirtual 1341	java/io/FileOutputStream:write	([B)V
    //   178: goto +16 -> 194
    //   181: astore_0
    //   182: aload_3
    //   183: astore_2
    //   184: goto +62 -> 246
    //   187: astore_0
    //   188: aload_3
    //   189: astore 4
    //   191: goto +27 -> 218
    //   194: aload_3
    //   195: astore_2
    //   196: aload_3
    //   197: astore 4
    //   199: aload_0
    //   200: aload_1
    //   201: invokestatic 1344	oicq/wlogin_sdk/tools/util:save_imei	(Landroid/content/Context;[B)V
    //   204: aload_3
    //   205: ifnull +61 -> 266
    //   208: aload_3
    //   209: invokevirtual 1345	java/io/FileOutputStream:close	()V
    //   212: return
    //   213: astore_0
    //   214: goto +32 -> 246
    //   217: astore_0
    //   218: aload 4
    //   220: astore_2
    //   221: aload_0
    //   222: ldc 169
    //   224: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   227: aload 4
    //   229: ifnull +37 -> 266
    //   232: aload 4
    //   234: invokevirtual 1345	java/io/FileOutputStream:close	()V
    //   237: return
    //   238: astore_0
    //   239: aload_0
    //   240: ldc 169
    //   242: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   245: return
    //   246: aload_2
    //   247: ifnull +17 -> 264
    //   250: aload_2
    //   251: invokevirtual 1345	java/io/FileOutputStream:close	()V
    //   254: goto +10 -> 264
    //   257: astore_1
    //   258: aload_1
    //   259: ldc 169
    //   261: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   264: aload_0
    //   265: athrow
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramContext	Context
    //   0	267	1	paramArrayOfByte	byte[]
    //   24	227	2	localObject1	Object
    //   36	173	3	localObject2	Object
    //   27	206	4	localObject3	Object
    //   20	118	5	localObject4	Object
    //   14	142	6	localObject5	Object
    //   17	142	7	localObject6	Object
    //   89	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   173	178	181	finally
    //   173	178	187	java/lang/Exception
    //   29	37	213	finally
    //   44	56	213	finally
    //   63	71	213	finally
    //   78	91	213	finally
    //   98	106	213	finally
    //   113	119	213	finally
    //   129	137	213	finally
    //   147	155	213	finally
    //   162	173	213	finally
    //   199	204	213	finally
    //   221	227	213	finally
    //   29	37	217	java/lang/Exception
    //   44	56	217	java/lang/Exception
    //   63	71	217	java/lang/Exception
    //   78	91	217	java/lang/Exception
    //   98	106	217	java/lang/Exception
    //   113	119	217	java/lang/Exception
    //   129	137	217	java/lang/Exception
    //   147	155	217	java/lang/Exception
    //   162	173	217	java/lang/Exception
    //   199	204	217	java/lang/Exception
    //   208	212	238	java/io/IOException
    //   232	237	238	java/io/IOException
    //   250	254	257	java/io/IOException
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
    //   7: invokevirtual 950	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 10
    //   12: new 318	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: aload 6
    //   23: ldc_w 994
    //   26: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: ldc_w 996
    //   35: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc_w 998
    //   44: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 1004	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   56: astore 11
    //   58: aload 11
    //   60: invokevirtual 1373	android/net/Uri:toString	()Ljava/lang/String;
    //   63: invokestatic 550	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   66: aconst_null
    //   67: astore 9
    //   69: aconst_null
    //   70: astore 8
    //   72: aload 8
    //   74: astore 6
    //   76: aload 9
    //   78: astore 7
    //   80: new 318	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   87: astore 12
    //   89: aload 8
    //   91: astore 6
    //   93: aload 9
    //   95: astore 7
    //   97: aload 12
    //   99: ldc 169
    //   101: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: astore 6
    //   109: aload 9
    //   111: astore 7
    //   113: aload 12
    //   115: lload_1
    //   116: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 8
    //   122: astore 6
    //   124: aload 9
    //   126: astore 7
    //   128: aload 12
    //   130: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 12
    //   135: aload 8
    //   137: astore 6
    //   139: aload 9
    //   141: astore 7
    //   143: new 318	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   150: astore 13
    //   152: aload 8
    //   154: astore 6
    //   156: aload 9
    //   158: astore 7
    //   160: aload 13
    //   162: ldc 169
    //   164: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: astore 6
    //   172: aload 9
    //   174: astore 7
    //   176: aload 13
    //   178: lload_3
    //   179: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 8
    //   185: astore 6
    //   187: aload 9
    //   189: astore 7
    //   191: aload 13
    //   193: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 13
    //   198: aload 8
    //   200: astore 6
    //   202: aload 9
    //   204: astore 7
    //   206: aload 10
    //   208: aload 11
    //   210: iconst_5
    //   211: anewarray 297	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 1006
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: ldc_w 1008
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: ldc_w 1010
    //   231: aastore
    //   232: dup
    //   233: iconst_3
    //   234: ldc_w 1012
    //   237: aastore
    //   238: dup
    //   239: iconst_4
    //   240: ldc_w 1014
    //   243: aastore
    //   244: ldc_w 1016
    //   247: iconst_2
    //   248: anewarray 297	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: aload 12
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload 13
    //   260: aastore
    //   261: aconst_null
    //   262: invokevirtual 1022	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   265: astore 8
    //   267: aload 8
    //   269: ifnonnull +17 -> 286
    //   272: aload 8
    //   274: ifnull +10 -> 284
    //   277: aload 8
    //   279: invokeinterface 1040 1 0
    //   284: iconst_0
    //   285: ireturn
    //   286: aload 8
    //   288: astore 6
    //   290: aload 8
    //   292: astore 7
    //   294: aload_0
    //   295: invokestatic 1375	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   298: invokestatic 1361	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   301: astore_0
    //   302: aload 8
    //   304: astore 6
    //   306: aload 8
    //   308: astore 7
    //   310: aload_0
    //   311: invokevirtual 575	java/lang/String:length	()I
    //   314: istore 5
    //   316: iload 5
    //   318: ifne +17 -> 335
    //   321: aload 8
    //   323: ifnull +10 -> 333
    //   326: aload 8
    //   328: invokeinterface 1040 1 0
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 8
    //   337: astore 6
    //   339: aload 8
    //   341: astore 7
    //   343: aload_0
    //   344: invokestatic 1035	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 9
    //   349: aload 8
    //   351: astore 6
    //   353: aload 8
    //   355: astore 7
    //   357: aload 8
    //   359: invokeinterface 1378 1 0
    //   364: ifle +74 -> 438
    //   367: aload 8
    //   369: astore 6
    //   371: aload 8
    //   373: astore 7
    //   375: new 1380	android/content/ContentValues
    //   378: dup
    //   379: invokespecial 1381	android/content/ContentValues:<init>	()V
    //   382: astore 10
    //   384: aload 8
    //   386: astore 6
    //   388: aload 8
    //   390: astore 7
    //   392: aload 10
    //   394: ldc_w 1012
    //   397: aload_0
    //   398: invokevirtual 1384	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 8
    //   403: astore 6
    //   405: aload 8
    //   407: astore 7
    //   409: aload 10
    //   411: ldc_w 1014
    //   414: aload 9
    //   416: invokevirtual 1384	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 8
    //   421: astore 6
    //   423: aload 8
    //   425: astore 7
    //   427: aload 8
    //   429: invokeinterface 1027 1 0
    //   434: pop
    //   435: goto +242 -> 677
    //   438: aload 8
    //   440: astore 6
    //   442: aload 8
    //   444: astore 7
    //   446: new 1380	android/content/ContentValues
    //   449: dup
    //   450: invokespecial 1381	android/content/ContentValues:<init>	()V
    //   453: astore 12
    //   455: aload 8
    //   457: astore 6
    //   459: aload 8
    //   461: astore 7
    //   463: aload 12
    //   465: ldc_w 1008
    //   468: lload_1
    //   469: invokestatic 1387	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: invokevirtual 1390	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   475: aload 8
    //   477: astore 6
    //   479: aload 8
    //   481: astore 7
    //   483: aload 12
    //   485: ldc_w 1010
    //   488: lload_3
    //   489: invokestatic 1387	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: invokevirtual 1390	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   495: aload 8
    //   497: astore 6
    //   499: aload 8
    //   501: astore 7
    //   503: aload 12
    //   505: ldc_w 1012
    //   508: aload_0
    //   509: invokevirtual 1384	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload 8
    //   514: astore 6
    //   516: aload 8
    //   518: astore 7
    //   520: aload 12
    //   522: ldc_w 1014
    //   525: aload 9
    //   527: invokevirtual 1384	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 8
    //   532: astore 6
    //   534: aload 8
    //   536: astore 7
    //   538: aload 10
    //   540: aload 11
    //   542: aload 12
    //   544: invokevirtual 1394	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   547: astore_0
    //   548: aload 8
    //   550: astore 6
    //   552: aload 8
    //   554: astore 7
    //   556: new 318	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   563: astore 9
    //   565: aload 8
    //   567: astore 6
    //   569: aload 8
    //   571: astore 7
    //   573: aload 9
    //   575: ldc_w 1396
    //   578: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 8
    //   584: astore 6
    //   586: aload 8
    //   588: astore 7
    //   590: aload 9
    //   592: aload_0
    //   593: invokevirtual 1399	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 8
    //   599: astore 6
    //   601: aload 8
    //   603: astore 7
    //   605: aload 9
    //   607: ldc_w 1401
    //   610: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 8
    //   616: astore 6
    //   618: aload 8
    //   620: astore 7
    //   622: aload 9
    //   624: lload_1
    //   625: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 8
    //   631: astore 6
    //   633: aload 8
    //   635: astore 7
    //   637: aload 9
    //   639: ldc_w 1403
    //   642: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 8
    //   648: astore 6
    //   650: aload 8
    //   652: astore 7
    //   654: aload 9
    //   656: lload_3
    //   657: invokevirtual 805	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 8
    //   663: astore 6
    //   665: aload 8
    //   667: astore 7
    //   669: aload 9
    //   671: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 1405	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   677: aload 8
    //   679: ifnull +10 -> 689
    //   682: aload 8
    //   684: invokeinterface 1040 1 0
    //   689: iconst_1
    //   690: ireturn
    //   691: astore_0
    //   692: goto +28 -> 720
    //   695: astore_0
    //   696: aload 7
    //   698: astore 6
    //   700: aload_0
    //   701: ldc 169
    //   703: invokestatic 419	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   706: aload 7
    //   708: ifnull +10 -> 718
    //   711: aload 7
    //   713: invokeinterface 1040 1 0
    //   718: iconst_0
    //   719: ireturn
    //   720: aload 6
    //   722: ifnull +10 -> 732
    //   725: aload 6
    //   727: invokeinterface 1040 1 0
    //   732: aload_0
    //   733: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	734	0	paramContext	Context
    //   0	734	1	paramLong1	long
    //   0	734	3	paramLong2	long
    //   314	3	5	i	int
    //   19	707	6	localObject1	Object
    //   78	634	7	localObject2	Object
    //   70	613	8	localCursor	android.database.Cursor
    //   67	603	9	localObject3	Object
    //   10	529	10	localObject4	Object
    //   56	485	11	localUri	android.net.Uri
    //   87	456	12	localObject5	Object
    //   150	109	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   80	89	691	finally
    //   97	105	691	finally
    //   113	120	691	finally
    //   128	135	691	finally
    //   143	152	691	finally
    //   160	168	691	finally
    //   176	183	691	finally
    //   191	198	691	finally
    //   206	267	691	finally
    //   294	302	691	finally
    //   310	316	691	finally
    //   343	349	691	finally
    //   357	367	691	finally
    //   375	384	691	finally
    //   392	401	691	finally
    //   409	419	691	finally
    //   427	435	691	finally
    //   446	455	691	finally
    //   463	475	691	finally
    //   483	495	691	finally
    //   503	512	691	finally
    //   520	530	691	finally
    //   538	548	691	finally
    //   556	565	691	finally
    //   573	582	691	finally
    //   590	597	691	finally
    //   605	614	691	finally
    //   622	629	691	finally
    //   637	646	691	finally
    //   654	661	691	finally
    //   669	677	691	finally
    //   700	706	691	finally
    //   80	89	695	java/lang/Exception
    //   97	105	695	java/lang/Exception
    //   113	120	695	java/lang/Exception
    //   128	135	695	java/lang/Exception
    //   143	152	695	java/lang/Exception
    //   160	168	695	java/lang/Exception
    //   176	183	695	java/lang/Exception
    //   191	198	695	java/lang/Exception
    //   206	267	695	java/lang/Exception
    //   294	302	695	java/lang/Exception
    //   310	316	695	java/lang/Exception
    //   343	349	695	java/lang/Exception
    //   357	367	695	java/lang/Exception
    //   375	384	695	java/lang/Exception
    //   392	401	695	java/lang/Exception
    //   409	419	695	java/lang/Exception
    //   427	435	695	java/lang/Exception
    //   446	455	695	java/lang/Exception
    //   463	475	695	java/lang/Exception
    //   483	495	695	java/lang/Exception
    //   503	512	695	java/lang/Exception
    //   520	530	695	java/lang/Exception
    //   538	548	695	java/lang/Exception
    //   556	565	695	java/lang/Exception
    //   573	582	695	java/lang/Exception
    //   590	597	695	java/lang/Exception
    //   605	614	695	java/lang/Exception
    //   622	629	695	java/lang/Exception
    //   637	646	695	java/lang/Exception
    //   654	661	695	java/lang/Exception
    //   669	677	695	java/lang/Exception
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
      int j = i * 2;
      arrayOfByte[i] = ((byte)((get_char((byte)paramString.charAt(j)) << 4) + get_char((byte)paramString.charAt(j + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[][] unpackBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("len");
      int i = 0;
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
  
  public static void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString != null)
    {
      File localFile1;
      label100:
      try
      {
        int i = paramString.length();
        if (i != 0) {}
      }
      finally {}
    }
    try
    {
      localFile1 = new File(paramString);
      if (!localFile1.exists())
      {
        File localFile2 = localFile1.getParentFile();
        if (localFile2 != null)
        {
          if (!localFile2.mkdirs())
          {
            boolean bool = localFile2.isDirectory();
            if (bool) {}
          }
        }
        else {
          return;
        }
      }
      if (getFileSize(paramString) < 524288)
      {
        paramString = new FileOutputStream(localFile1, true);
        paramString.write(paramArrayOfByte);
        paramString.close();
      }
    }
    catch (Exception paramString)
    {
      break label100;
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */