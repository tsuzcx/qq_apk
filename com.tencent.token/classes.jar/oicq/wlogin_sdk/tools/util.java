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
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import java.lang.reflect.Method;
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
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.pb.device_report.DeviceReport;
import oicq.wlogin_sdk.request.u;

public class util
{
  public static final int ASYN_CHECK_IMAGE = 2;
  public static final int ASYN_CHECK_SMS = 4;
  public static final int ASYN_EXCEPTION = 11;
  public static final int ASYN_GET_A1_WITH_A1 = 6;
  public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
  public static final int ASYN_GET_ST_WITH_PWD = 0;
  public static final int ASYN_QUICKLOG_BY_GATEWAY = 19;
  public static final int ASYN_QUICKLOG_BY_WECHAT = 18;
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
  public static final long BUILD_TIME = 1630563984L;
  public static final int BUSINESS_TYPE_LOGIN_GATEWAY = 2;
  public static final int BUSINESS_TYPE_LOGIN_SMS = 3;
  public static final int BUSINESS_TYPE_NULL = 0;
  public static final int D = 2;
  private static SimpleDateFormat DAYFORMAT;
  public static final int E_A1_DECRYPT = -1014;
  public static final int E_A1_FORMAT = -1016;
  public static final int E_A1_SEQ_ERROR = 20;
  public static final int E_ADVANCE_NOTICE = 257;
  public static final int E_APK_CHK_ERR = -1021;
  public static final int E_BUFFER_OVERFLOW = -1023;
  public static final int E_DECRYPT = -1002;
  public static final int E_ENCODING = -1013;
  public static final int E_ENCRYPTION_METHOD = -1024;
  public static final int E_GATEWAY_LOGIN_FAILED = -2005;
  public static final int E_GATEWAY_LOGIN_NUM_FAILED = -2004;
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
  public static final int E_OTHER_EXCEPTION = -2006;
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
  public static final int E_WXLOGIN_NO_REGISTER = 230;
  public static final int E_WXLOGIN_NUM_FAILED = -2003;
  public static final int E_WXLOGIN_TOKEN_FAILED = -2002;
  public static final String FILE_DIR = "wtlogin";
  public static int GUID_DELAY_HOUR = 360;
  private static int HONEYCOMB = 11;
  public static final int I = 1;
  public static final int KEY_TLV543_IN_TLV199 = 1676611;
  public static LogCallBack LCB;
  public static boolean LOGCAT_OUT = false;
  public static final String LOG_DIR = "tencent/wtlogin";
  public static int LOG_LEVEL = 1;
  public static String LOG_TAG_EVENT_REPORT = "event_report";
  public static String LOG_TAG_GATEWAY_LOGIN_NEW_DOV = "gateway_login_new_dov";
  public static String LOG_TAG_POW = "pow";
  public static String LOG_TAG_PRIVACY = "privacy";
  public static String LOG_TAG_QIMEI = "qimei";
  public static int MAX_APPID = 65535;
  public static final int MAX_CONTENT_SIZE = 40960;
  public static final int MAX_FILE_SIZE = 524288;
  public static final int MAX_INIT_KEY_TIME = 3;
  public static int MAX_NAME_LEN = 128;
  @SuppressLint({"NewApi"})
  private static int MODE_MULTI_PROCESS = 0;
  public static final int QQ_APP_ID = 16;
  public static final int REG_CHECK_ERROR_FACE = 59;
  public static final String SDK_VERSION = "6.0.0.2484";
  public static final int SSO_VERSION = 18;
  public static final long SVN_VER = 2484L;
  public static final int S_BABYLH_EXPIRED = 116;
  public static final int S_GET_IMAGE = 2;
  public static final int S_GET_SMS = 160;
  public static final int S_GET_SMS_TOKEN = 239;
  public static final int S_LH_EXPIRED = 41;
  public static final int S_PWD_WRONG = 1;
  public static final int S_ROLL_BACK = 180;
  public static final int S_SEC_GUID = 204;
  public static final int S_SUCCESS = 0;
  public static final String TAG = "wlogin_sdk";
  public static final int TLV542 = 1346;
  public static final int W = 0;
  public static final String WT_LOGIN_URL_HOST = "txz.qq.com";
  static final char[] base64_encode_chars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  static final char base64_pad_url = '_';
  static final short[] base64_reverse_table_url = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static boolean libwtecdh_loaded = false;
  public static boolean loadEncryptSo = true;
  public static String logContent = "";
  public static PrivacyListener privacyListener;
  public static QimeiListener qimeiListener;
  
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
        if (LOGCAT_OUT) {
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
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
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
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
      if (LOG_LEVEL > 0)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString);
          return;
        }
        if (LOGCAT_OUT) {
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
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
      if (LOG_LEVEL > 0)
      {
        if (LCB != null) {
          LCB.OnLog(paramString1);
        } else if (LOGCAT_OUT) {
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
        }
        b.a(u.u, paramString2, paramString1);
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
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
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
          new StringBuilder("wlogin_sdk").append(getLineInfo(2));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(paramString2);
        }
        Object localObject = u.u;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(":");
        localStringBuilder.append(paramString2);
        b.a((Context)localObject, paramString3, localStringBuilder.toString());
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static byte[] RSADecrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if ((paramArrayOfByte != null) && (paramKey != null)) {}
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
          break label175;
        }
        LOGI("len not match block size", "");
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        int k;
        byte[] arrayOfByte;
        paramKey = new StringBuilder("descypt exception:");
        paramKey.append(paramArrayOfByte.toString());
        LOGI(paramKey.toString(), "");
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
        LOGI("data or key is null", "");
        return null;
        label175:
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
      System.arraycopy(localCipher.doFinal(arrayOfByte), 0, paramKey, j * 128, 128);
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
    byte[] tmp18_12 = tmp12_11;
    tmp18_12[1] = -126;
    byte[] tmp24_18 = tmp18_12;
    tmp24_18[2] = 2;
    byte[] tmp29_24 = tmp24_18;
    tmp29_24[3] = 117;
    byte[] tmp35_29 = tmp29_24;
    tmp35_29[4] = 2;
    byte[] tmp40_35 = tmp35_29;
    tmp40_35[5] = 1;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[6] = 0;
    byte[] tmp51_45 = tmp45_40;
    tmp51_45[7] = 48;
    byte[] tmp58_51 = tmp51_45;
    tmp58_51[8] = 13;
    byte[] tmp64_58 = tmp58_51;
    tmp64_58[9] = 6;
    byte[] tmp70_64 = tmp64_58;
    tmp70_64[10] = 9;
    byte[] tmp76_70 = tmp70_64;
    tmp76_70[11] = 42;
    byte[] tmp83_76 = tmp76_70;
    tmp83_76[12] = -122;
    byte[] tmp90_83 = tmp83_76;
    tmp90_83[13] = 72;
    byte[] tmp96_90 = tmp90_83;
    tmp96_90[14] = -122;
    byte[] tmp103_96 = tmp96_90;
    tmp103_96[15] = -9;
    byte[] tmp110_103 = tmp103_96;
    tmp110_103[16] = 13;
    byte[] tmp116_110 = tmp110_103;
    tmp116_110[17] = 1;
    byte[] tmp122_116 = tmp116_110;
    tmp122_116[18] = 1;
    byte[] tmp128_122 = tmp122_116;
    tmp128_122[19] = 1;
    byte[] tmp134_128 = tmp128_122;
    tmp134_128[20] = 5;
    byte[] tmp140_134 = tmp134_128;
    tmp140_134[21] = 0;
    byte[] tmp146_140 = tmp140_134;
    tmp146_140[22] = 4;
    byte[] tmp152_146 = tmp146_140;
    tmp152_146[23] = -126;
    byte[] tmp159_152 = tmp152_146;
    tmp159_152[24] = 2;
    byte[] tmp165_159 = tmp159_152;
    tmp165_159[25] = 95;
    tmp165_159;
    int i = paramArrayOfByte.length - 607;
    arrayOfByte1[3] = ((byte)(arrayOfByte1[3] + i));
    arrayOfByte1[25] = ((byte)(arrayOfByte1[25] + i));
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + 26];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 26);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 26, paramArrayOfByte.length);
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
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      paramArrayOfByte = paramArrayOfByte.getEncoded();
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 26];
      System.arraycopy(paramArrayOfByte, 26, arrayOfByte, 0, arrayOfByte.length);
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
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 22];
    System.arraycopy(new byte[] { 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0 }, 0, arrayOfByte, 0, 22);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 22, paramArrayOfByte.length);
    paramArrayOfByte = new X509EncodedKeySpec(arrayOfByte);
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
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
      paramArrayOfByte = paramArrayOfByte.getEncoded();
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 22];
      System.arraycopy(paramArrayOfByte, 22, arrayOfByte, 0, arrayOfByte.length);
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
      i1 = i;
      if (i == 95) {
        break;
      }
      k = i;
      if (i == 32) {
        k = 42;
      }
      i1 = base64_reverse_table_url[k];
      if (i1 >= 0)
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
      else
      {
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
        return Boolean.TRUE;
      }
      paramString = Boolean.FALSE;
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      label31:
      break label31;
    }
    return Boolean.FALSE;
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
      localObject1 = new StringBuilder("data len:");
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
          LOGI("len:".concat(String.valueOf(k)));
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
      LOGI("file path:".concat(String.valueOf(paramString)));
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(new h());
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
      if ((u.az != null) && (u.az.length() != 0))
      {
        deleteExpireFile(u.az, 691200);
        return;
      }
      if (ExistSDCard())
      {
        localObject = paramContext.getExternalCacheDir();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/tencent/wtlogin/");
        localStringBuilder.append(paramContext.getPackageName());
        deleteExpireFile(localStringBuilder.toString(), 691200);
        return;
      }
      paramContext = paramContext.getFilesDir().getPath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/tencent/wtlogin");
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
    if ((u.al != null) && (u.al.length != 0))
    {
      LOGI("generate guid from customer guid");
      return u.al;
    }
    LOGI("generate guid temporarily");
    Object localObject1 = privacyListener;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = ((PrivacyListener)localObject1).getMac(paramContext);
      localObject1 = privacyListener.getAndroidID(paramContext);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject3 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = "02:00:00:00:00:00";
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = getRandomAndroidId(paramContext);
    }
    LOGI("android_id ".concat(String.valueOf(localObject2)), "");
    LOGI("mac ".concat(String.valueOf(localObject3)), "");
    paramContext = new StringBuilder();
    paramContext.append((String)localObject2);
    paramContext.append((String)localObject3);
    return MD5.toMD5Byte(paramContext.toString().getBytes());
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
  
  public static String getBaseband()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "gsm.version.baseband", "no message" });
      return localObject1;
    }
    catch (Exception localException) {}
    return "";
  }
  
  /* Error */
  public static String getBootId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_0
    //   6: new 819	java/io/FileReader
    //   9: dup
    //   10: ldc_w 821
    //   13: invokespecial 822	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: new 824	java/io/BufferedReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 827	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: invokevirtual 830	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +16 -> 46
    //   33: aload_1
    //   34: invokevirtual 831	java/io/FileReader:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   44: aload_0
    //   45: areturn
    //   46: aload_1
    //   47: invokevirtual 831	java/io/FileReader:close	()V
    //   50: goto +68 -> 118
    //   53: astore_0
    //   54: goto +67 -> 121
    //   57: goto +14 -> 71
    //   60: goto +32 -> 92
    //   63: astore_2
    //   64: aload_0
    //   65: astore_1
    //   66: aload_2
    //   67: astore_0
    //   68: goto +53 -> 121
    //   71: aload_1
    //   72: astore_0
    //   73: ldc_w 836
    //   76: ldc 223
    //   78: invokestatic 838	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: ifnull +36 -> 118
    //   85: aload_1
    //   86: invokevirtual 831	java/io/FileReader:close	()V
    //   89: goto +29 -> 118
    //   92: aload_1
    //   93: astore_0
    //   94: ldc_w 840
    //   97: ldc 223
    //   99: invokestatic 838	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_1
    //   103: ifnull +15 -> 118
    //   106: aload_1
    //   107: invokevirtual 831	java/io/FileReader:close	()V
    //   110: goto +8 -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   118: ldc 223
    //   120: areturn
    //   121: aload_1
    //   122: ifnull +15 -> 137
    //   125: aload_1
    //   126: invokevirtual 831	java/io/FileReader:close	()V
    //   129: goto +8 -> 137
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   137: aload_0
    //   138: athrow
    //   139: astore_0
    //   140: aload_3
    //   141: astore_1
    //   142: goto -50 -> 92
    //   145: astore_0
    //   146: aload_2
    //   147: astore_1
    //   148: goto -77 -> 71
    //   151: astore_0
    //   152: goto -92 -> 60
    //   155: astore_0
    //   156: goto -99 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	40	0	str	String
    //   53	12	0	localObject1	Object
    //   67	27	0	localObject2	Object
    //   113	25	0	localIOException1	IOException
    //   139	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   145	1	0	localIOException2	IOException
    //   151	1	0	localFileNotFoundException2	java.io.FileNotFoundException
    //   155	1	0	localIOException3	IOException
    //   16	18	1	localFileReader	java.io.FileReader
    //   39	8	1	localIOException4	IOException
    //   65	61	1	localObject3	Object
    //   132	2	1	localIOException5	IOException
    //   141	7	1	localObject4	Object
    //   1	1	2	localObject5	Object
    //   63	84	2	localObject6	Object
    //   3	138	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/io/IOException
    //   17	29	53	finally
    //   6	17	63	finally
    //   73	81	63	finally
    //   94	102	63	finally
    //   46	50	113	java/io/IOException
    //   85	89	113	java/io/IOException
    //   106	110	113	java/io/IOException
    //   125	129	132	java/io/IOException
    //   6	17	139	java/io/FileNotFoundException
    //   6	17	145	java/io/IOException
    //   17	29	151	java/io/FileNotFoundException
    //   17	29	155	java/io/IOException
  }
  
  public static int getByteLength(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return paramArrayOfByte.length;
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
    label449:
    label460:
    do
    {
      Object localObject3;
      for (;;)
      {
        try
        {
          localObject3 = paramContext.getPackageInfo((String)localObject2, 0).applicationInfo.sourceDir;
          localObject1 = paramString;
          StringBuilder localStringBuilder = new StringBuilder("pkg ");
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
                break label449;
              }
              l = i;
              break label460;
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
              paramString = new StringBuilder("found comment ");
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
  
  public static String getCurrentPid()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String getDate()
  {
    try
    {
      Object localObject = new StringBuilder("[");
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
    //   0: getstatic 713	oicq/wlogin_sdk/request/u:al	[B
    //   3: ifnull +22 -> 25
    //   6: getstatic 713	oicq/wlogin_sdk/request/u:al	[B
    //   9: arraylength
    //   10: ifeq +15 -> 25
    //   13: ldc_w 950
    //   16: ldc 223
    //   18: invokestatic 423	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 713	oicq/wlogin_sdk/request/u:al	[B
    //   24: areturn
    //   25: ldc_w 952
    //   28: ldc 223
    //   30: invokestatic 423	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   51: new 372	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   58: astore 4
    //   60: aload_2
    //   61: astore 5
    //   63: aload 4
    //   65: aload_0
    //   66: invokevirtual 699	android/content/Context:getFilesDir	()Ljava/io/File;
    //   69: invokevirtual 691	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: astore 5
    //   79: aload 4
    //   81: ldc_w 954
    //   84: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: astore 5
    //   91: new 651	java/io/File
    //   94: dup
    //   95: aload 4
    //   97: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 652	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload_2
    //   106: astore 5
    //   108: aload 4
    //   110: invokevirtual 940	java/io/File:exists	()Z
    //   113: ifeq +77 -> 190
    //   116: aload_2
    //   117: astore 5
    //   119: new 866	java/io/FileInputStream
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 957	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: astore 4
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokevirtual 870	java/io/FileInputStream:available	()I
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
    //   162: invokevirtual 877	java/io/FileInputStream:read	([B)I
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
    //   206: invokevirtual 878	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: astore_3
    //   211: goto +66 -> 277
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 223
    //   218: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
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
    //   240: getstatic 960	oicq/wlogin_sdk/request/u:aa	I
    //   243: ldc_w 961
    //   246: ior
    //   247: putstatic 960	oicq/wlogin_sdk/request/u:aa	I
    //   250: aload 4
    //   252: astore 5
    //   254: aload 6
    //   256: ldc 223
    //   258: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +12 -> 277
    //   268: aload_2
    //   269: astore_3
    //   270: aload 4
    //   272: invokevirtual 878	java/io/FileInputStream:close	()V
    //   275: aload_2
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: aload_3
    //   280: arraylength
    //   281: ifgt +28 -> 309
    //   284: aload_0
    //   285: invokestatic 964	oicq/wlogin_sdk/tools/util:get_saved_android_id	(Landroid/content/Context;)[B
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
    //   304: invokestatic 968	oicq/wlogin_sdk/tools/util:saveGuidToFile	(Landroid/content/Context;[B)V
    //   307: aload_3
    //   308: astore_2
    //   309: aload_2
    //   310: areturn
    //   311: aload 5
    //   313: ifnull +18 -> 331
    //   316: aload 5
    //   318: invokevirtual 878	java/io/FileInputStream:close	()V
    //   321: goto +10 -> 331
    //   324: astore_2
    //   325: aload_2
    //   326: ldc 223
    //   328: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
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
  
  public static byte[] getIccid(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getSimSerialNumber();
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
  
  public static int getInitKeyTime(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getInt("InitKeyTime", 0);
        LOGI("getInitKeyTime ".concat(String.valueOf(i)), "");
        return i;
      }
      catch (Throwable paramContext)
      {
        printThrowable(paramContext, "getReqTimeFromSp");
        return 0;
      }
      int i = 0;
    }
  }
  
  public static String getInnerVersion()
  {
    if (Build.DISPLAY.contains(Build.VERSION.INCREMENTAL)) {
      return Build.DISPLAY;
    }
    return Build.VERSION.INCREMENTAL;
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
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append(":");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label72:
      break label72;
    }
    return "";
  }
  
  public static String getLogDir(Context paramContext)
  {
    if ((u.az != null) && (u.az.length() != 0)) {
      return u.az;
    }
    try
    {
      if (ExistSDCard())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getExternalCacheDir().getAbsolutePath());
        localStringBuilder.append("/tencent/wtlogin/");
        localStringBuilder.append(paramContext.getPackageName());
        return localStringBuilder.toString();
      }
      paramContext = paramContext.getFilesDir().getPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/tencent/wtlogin");
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label104:
      break label104;
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
  
  /* Error */
  public static String getProcVersion()
  {
    // Byte code:
    //   0: new 819	java/io/FileReader
    //   3: dup
    //   4: ldc_w 1094
    //   7: invokespecial 822	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: new 824	java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 827	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: invokevirtual 830	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 831	java/io/FileReader:close	()V
    //   33: aload_2
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   40: aload_2
    //   41: areturn
    //   42: aload_1
    //   43: invokevirtual 831	java/io/FileReader:close	()V
    //   46: goto +67 -> 113
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   54: goto +59 -> 113
    //   57: astore_2
    //   58: goto +12 -> 70
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: goto +57 -> 121
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: new 372	java/lang/StringBuilder
    //   75: dup
    //   76: ldc_w 1096
    //   79: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: astore_3
    //   83: aload_1
    //   84: astore_0
    //   85: aload_3
    //   86: aload_2
    //   87: invokevirtual 436	java/lang/Exception:toString	()Ljava/lang/String;
    //   90: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: astore_0
    //   96: aload_3
    //   97: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: ldc 223
    //   102: invokestatic 838	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 831	java/io/FileReader:close	()V
    //   113: ldc 223
    //   115: areturn
    //   116: astore_2
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: astore_0
    //   121: aload_1
    //   122: ifnull +15 -> 137
    //   125: aload_1
    //   126: invokevirtual 831	java/io/FileReader:close	()V
    //   129: goto +8 -> 137
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 834	java/io/IOException:printStackTrace	()V
    //   137: aload_0
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	1	0	localObject1	Object
    //   35	2	0	localIOException1	IOException
    //   49	2	0	localIOException2	IOException
    //   61	1	0	localObject2	Object
    //   71	67	0	localObject3	Object
    //   10	116	1	localObject4	Object
    //   132	2	1	localIOException3	IOException
    //   24	17	2	str	String
    //   57	1	2	localException1	Exception
    //   67	20	2	localException2	Exception
    //   116	4	2	localObject5	Object
    //   82	15	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/io/IOException
    //   42	46	49	java/io/IOException
    //   109	113	49	java/io/IOException
    //   13	25	57	java/lang/Exception
    //   0	11	61	finally
    //   0	11	67	java/lang/Exception
    //   13	25	116	finally
    //   72	83	116	finally
    //   85	94	116	finally
    //   96	105	116	finally
    //   125	129	132	java/io/IOException
  }
  
  public static String getRandomAndroidId(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 4);
    Object localObject = paramContext.getString("random_AndroidId", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = new StringBuffer();
    int i = 0;
    while (i < 15)
    {
      ((StringBuffer)localObject).append(new Random().nextInt(10));
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    paramContext = paramContext.edit();
    paramContext.putString("random_AndroidId", (String)localObject);
    paramContext.commit();
    return localObject;
  }
  
  public static byte[] getRequestInitTime()
  {
    byte[] arrayOfByte = new byte[4];
    int64_to_buf32(arrayOfByte, 0, System.currentTimeMillis() / 1000L + u.af);
    return arrayOfByte;
  }
  
  public static String getSvnVersion()
  {
    return "[2484]";
  }
  
  public static String getThreadId()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String getThrowableInfo(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static String getUser(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return "[]";
  }
  
  public static byte[] get_IMSI(Context paramContext)
  {
    PrivacyListener localPrivacyListener = privacyListener;
    if (localPrivacyListener != null)
    {
      paramContext = localPrivacyListener.getImsi(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext.getBytes();
      }
    }
    return new byte[0];
  }
  
  public static byte[] get_android_dev_info(Context paramContext)
  {
    Object localObject2 = new byte[0];
    String str1 = null;
    Object localObject1 = localObject2;
    try
    {
      if (privacyListener != null)
      {
        localObject1 = localObject2;
        str1 = privacyListener.getAndroidID(paramContext);
      }
      localObject1 = localObject2;
      String str2 = Build.BOOTLOADER;
      localObject1 = localObject2;
      String str3 = getProcVersion();
      localObject1 = localObject2;
      String str4 = Build.VERSION.CODENAME;
      localObject1 = localObject2;
      String str5 = Build.VERSION.INCREMENTAL;
      localObject1 = localObject2;
      String str6 = Build.FINGERPRINT;
      localObject1 = localObject2;
      String str7 = getBootId();
      localObject1 = localObject2;
      String str8 = getBaseband();
      localObject1 = localObject2;
      String str9 = getInnerVersion();
      localObject1 = localObject2;
      paramContext = new device_report.DeviceReport();
      localObject1 = localObject2;
      paramContext.bytes_bootloader.set(ByteStringMicro.copyFromUtf8(str2));
      localObject1 = localObject2;
      paramContext.bytes_version.set(ByteStringMicro.copyFromUtf8(str3));
      localObject1 = localObject2;
      paramContext.bytes_codename.set(ByteStringMicro.copyFromUtf8(str4));
      localObject1 = localObject2;
      paramContext.bytes_incremental.set(ByteStringMicro.copyFromUtf8(str5));
      localObject1 = localObject2;
      paramContext.bytes_fingerprint.set(ByteStringMicro.copyFromUtf8(str6));
      localObject1 = localObject2;
      paramContext.bytes_boot_id.set(ByteStringMicro.copyFromUtf8(str7));
      localObject1 = localObject2;
      paramContext.bytes_android_id.set(ByteStringMicro.copyFromUtf8(str1));
      localObject1 = localObject2;
      paramContext.bytes_baseband.set(ByteStringMicro.copyFromUtf8(str8));
      localObject1 = localObject2;
      paramContext.bytes_inner_ver.set(ByteStringMicro.copyFromUtf8(str9));
      localObject1 = localObject2;
      paramContext = paramContext.toByteArray();
      localObject1 = paramContext;
      localObject2 = new StringBuilder(300);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str2);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str3);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str4);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str5);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str6);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str7);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str1);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str8);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str9);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      LOGI(((StringBuilder)localObject2).toString(), "");
      localObject1 = paramContext;
    }
    catch (Throwable paramContext)
    {
      label420:
      break label420;
    }
    if (localObject1 != null)
    {
      paramContext = (Context)localObject1;
      if (localObject1.length > 0) {}
    }
    else
    {
      paramContext = new byte[0];
    }
    return paramContext;
  }
  
  public static byte[] get_android_id(Context paramContext)
  {
    Object localObject = privacyListener;
    if (localObject != null)
    {
      localObject = ((PrivacyListener)localObject).getAndroidID(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return ((String)localObject).getBytes();
      }
    }
    paramContext = getRandomAndroidId(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext.getBytes();
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
    PrivacyListener localPrivacyListener = privacyListener;
    if (localPrivacyListener != null)
    {
      paramContext = localPrivacyListener.getBssid(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext.toLowerCase().getBytes();
      }
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
  
  public static String get_cost_time(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      str = paramContext.getSharedPreferences("WLOGIN_COST", 4).getString("costTime", "");
      return str;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String get_cost_trace(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      str = paramContext.getSharedPreferences("WLOGIN_COST", 4).getString("costTrace", "");
      return str;
    }
    catch (Throwable paramContext) {}
    return "";
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
    //   9: invokevirtual 1284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 6
    //   14: new 372	java/lang/StringBuilder
    //   17: dup
    //   18: ldc_w 1286
    //   21: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 1288
    //   29: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_0
    //   34: ldc_w 1290
    //   37: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 1296	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: astore 7
    //   50: aconst_null
    //   51: astore_0
    //   52: aconst_null
    //   53: astore 5
    //   55: aload 6
    //   57: aload 7
    //   59: iconst_5
    //   60: anewarray 351	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: ldc_w 1298
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc_w 1300
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc_w 1302
    //   80: aastore
    //   81: dup
    //   82: iconst_3
    //   83: ldc_w 1304
    //   86: aastore
    //   87: dup
    //   88: iconst_4
    //   89: ldc_w 1306
    //   92: aastore
    //   93: ldc_w 1308
    //   96: iconst_2
    //   97: anewarray 351	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: lload_1
    //   103: invokestatic 1311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: lload_3
    //   110: invokestatic 1311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   113: aastore
    //   114: aconst_null
    //   115: invokevirtual 1317	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 6
    //   120: aload 6
    //   122: ifnull +121 -> 243
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: astore_0
    //   132: aload 6
    //   134: invokeinterface 1322 1 0
    //   139: ifeq +104 -> 243
    //   142: aload 6
    //   144: astore 5
    //   146: aload 6
    //   148: astore_0
    //   149: aload 6
    //   151: aload 6
    //   153: ldc_w 1304
    //   156: invokeinterface 1325 2 0
    //   161: invokeinterface 1327 2 0
    //   166: astore 7
    //   168: aload 6
    //   170: astore 5
    //   172: aload 6
    //   174: astore_0
    //   175: aload 6
    //   177: aload 6
    //   179: ldc_w 1306
    //   182: invokeinterface 1325 2 0
    //   187: invokeinterface 1327 2 0
    //   192: astore 8
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: astore_0
    //   201: aload 7
    //   203: invokestatic 1330	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   206: aload 8
    //   208: invokevirtual 355	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +32 -> 243
    //   214: aload 6
    //   216: astore 5
    //   218: aload 6
    //   220: astore_0
    //   221: aload 7
    //   223: invokestatic 1334	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   226: astore 7
    //   228: aload 6
    //   230: ifnull +10 -> 240
    //   233: aload 6
    //   235: invokeinterface 1335 1 0
    //   240: aload 7
    //   242: areturn
    //   243: aload 6
    //   245: ifnull +35 -> 280
    //   248: aload 6
    //   250: astore_0
    //   251: goto +23 -> 274
    //   254: astore_0
    //   255: goto +32 -> 287
    //   258: astore 6
    //   260: aload_0
    //   261: astore 5
    //   263: aload 6
    //   265: ldc 223
    //   267: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   270: aload_0
    //   271: ifnull +9 -> 280
    //   274: aload_0
    //   275: invokeinterface 1335 1 0
    //   280: ldc_w 1337
    //   283: invokestatic 1334	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   286: areturn
    //   287: aload 5
    //   289: ifnull +10 -> 299
    //   292: aload 5
    //   294: invokeinterface 1335 1 0
    //   299: aload_0
    //   300: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramLong1	long
    //   0	301	3	paramLong2	long
    //   53	240	5	localObject1	Object
    //   12	237	6	localObject2	Object
    //   258	6	6	localException	Exception
    //   48	193	7	localObject3	Object
    //   192	15	8	str	String
    // Exception table:
    //   from	to	target	type
    //   55	120	254	finally
    //   132	142	254	finally
    //   149	168	254	finally
    //   175	194	254	finally
    //   201	214	254	finally
    //   221	228	254	finally
    //   263	270	254	finally
    //   55	120	258	java/lang/Exception
    //   132	142	258	java/lang/Exception
    //   149	168	258	java/lang/Exception
    //   175	194	258	java/lang/Exception
    //   201	214	258	java/lang/Exception
    //   221	228	258	java/lang/Exception
  }
  
  public static String get_device_model()
  {
    Object localObject = privacyListener;
    if (localObject != null)
    {
      localObject = ((PrivacyListener)localObject).getDeviceModel();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    return Build.MODEL;
  }
  
  public static String get_error_msg(int paramInt)
  {
    if (paramInt != -1000) {
      return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    }
    return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4);
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
  
  public static byte[] get_last_android_id(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_android_id", new String("")));
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
    PrivacyListener localPrivacyListener = privacyListener;
    if (localPrivacyListener != null)
    {
      paramContext = localPrivacyListener.getMac(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext.getBytes();
      }
    }
    return "02:00:00:00:00:00".getBytes();
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
  
  public static boolean get_pow_test(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null) {
      try
      {
        bool1 = paramContext.getSharedPreferences("WLOGIN_COST", 4).getBoolean("powTestNew", true);
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(LOG_TAG_POW);
        localStringBuilder.append("get_pow_test ");
        localStringBuilder.append(Log.getStackTraceString(paramContext));
        LOGI(localStringBuilder.toString(), "");
        bool1 = bool2;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append(LOG_TAG_POW);
    paramContext.append("get_pow_test ");
    paramContext.append(bool1);
    LOGI(paramContext.toString(), "");
    return bool1;
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
  
  public static byte[] get_qimei(Context paramContext)
  {
    Object localObject = qimeiListener;
    if (localObject == null)
    {
      paramContext = new StringBuilder();
      paramContext.append(LOG_TAG_QIMEI);
      paramContext.append("get listener = null");
      LOGI(paramContext.toString(), "");
      return new byte[0];
    }
    paramContext = ((QimeiListener)localObject).getQimei(paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append(LOG_TAG_QIMEI);
      paramContext.append("get isEmpty");
      LOGI(paramContext.toString(), "");
      return new byte[0];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(LOG_TAG_QIMEI);
    ((StringBuilder)localObject).append("get length = ");
    ((StringBuilder)localObject).append(paramContext.length());
    LOGI(((StringBuilder)localObject).toString(), "");
    return paramContext.getBytes();
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
    return "2021/09/02 14:26:24";
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
  
  public static byte[] get_saved_android_id(Context paramContext)
  {
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("android_id", new String("")));
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
    return u.g();
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
  
  public static byte[] get_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host2", "").getBytes();
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
    PrivacyListener localPrivacyListener = privacyListener;
    if (localPrivacyListener != null)
    {
      paramContext = localPrivacyListener.getSsid(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext.getBytes();
      }
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
  
  public static byte[] get_wap_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host2", "").getBytes();
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
  
  @Deprecated
  public static boolean isWtLoginUrlV1(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.indexOf("?k=");
    if (i != -1)
    {
      i += 3;
      int j = i + 32;
      if (j > paramString.length()) {
        return false;
      }
      paramString = paramString.substring(i, j);
      return base64_decode_url(paramString.getBytes(), paramString.length()) != null;
    }
    return false;
  }
  
  public static boolean isWtLoginUrlV2(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    try
    {
      String str = Uri.parse(paramString).getHost();
      localObject = str;
    }
    catch (Exception localException)
    {
      printException(localException);
    }
    if (!"txz.qq.com".equals(localObject)) {
      return false;
    }
    return isWtLoginUrlV1(paramString);
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
            StringBuilder localStringBuilder1 = new StringBuilder("loadLibrary failed ");
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
          paramContext = new StringBuilder("loadLibrary failed ");
          paramContext.append(paramString.getMessage());
          LOGI(paramContext.toString(), "");
          bool2 = bool1;
        }
      }
      libwtecdh_loaded = bool2;
      paramString = new StringBuilder("libwtecdh loaded ");
      paramString.append(libwtecdh_loaded);
      LOGI(paramString.toString(), "");
      return bool2;
    }
    return false;
  }
  
  public static boolean needChangeGuid(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0);
    long l2 = paramContext.getLong("change_guid_time", 0L);
    long l1 = u.f();
    StringBuilder localStringBuilder = new StringBuilder("needChangeGuid delay:");
    localStringBuilder.append(l2);
    localStringBuilder.append(" now:");
    localStringBuilder.append(l1);
    LOGI(localStringBuilder.toString(), "");
    if (l2 == 0L)
    {
      l2 = new Random().nextInt(GUID_DELAY_HOUR) * 60 * 60 * 1000;
      paramContext.edit().putLong("change_guid_time", l1 + l2).commit();
      return false;
    }
    if (l2 >= l1)
    {
      paramContext.edit().putLong("change_guid_time", 0L).commit();
      return true;
    }
    return false;
  }
  
  public static boolean need_pow_test(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      LOGI("need_pow_test false because not null");
      return false;
    }
    paramArrayOfByte = u.m();
    if ((!TextUtils.isEmpty(paramArrayOfByte)) && (paramArrayOfByte.endsWith(":MSF"))) {
      return get_pow_test(u.u);
    }
    LOGI("need_pow_test false because not msf");
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
  
  public static String printByte(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    return String.valueOf(paramArrayOfByte.length);
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
    //   1: ifnull +294 -> 295
    //   4: aload_1
    //   5: ifnull +290 -> 295
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +285 -> 295
    //   13: new 372	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 1684
    //   20: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: aload_1
    //   26: invokestatic 1686	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   29: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: ldc 223
    //   39: invokestatic 423	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aconst_null
    //   43: astore 6
    //   45: aconst_null
    //   46: astore 7
    //   48: aconst_null
    //   49: astore 5
    //   51: aload 6
    //   53: astore_2
    //   54: aload 7
    //   56: astore 4
    //   58: new 372	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   65: astore_3
    //   66: aload 6
    //   68: astore_2
    //   69: aload 7
    //   71: astore 4
    //   73: aload_3
    //   74: aload_0
    //   75: invokevirtual 699	android/content/Context:getFilesDir	()Ljava/io/File;
    //   78: invokevirtual 691	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: astore_2
    //   88: aload 7
    //   90: astore 4
    //   92: aload_3
    //   93: ldc_w 954
    //   96: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: astore_2
    //   103: aload 7
    //   105: astore 4
    //   107: new 651	java/io/File
    //   110: dup
    //   111: aload_3
    //   112: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 652	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 8
    //   120: aload 6
    //   122: astore_2
    //   123: aload 7
    //   125: astore 4
    //   127: aload 8
    //   129: invokevirtual 940	java/io/File:exists	()Z
    //   132: ifne +16 -> 148
    //   135: aload 6
    //   137: astore_2
    //   138: aload 7
    //   140: astore 4
    //   142: aload 8
    //   144: invokevirtual 1689	java/io/File:createNewFile	()Z
    //   147: pop
    //   148: aload 5
    //   150: astore_3
    //   151: aload 6
    //   153: astore_2
    //   154: aload 7
    //   156: astore 4
    //   158: aload 8
    //   160: invokevirtual 940	java/io/File:exists	()Z
    //   163: ifeq +60 -> 223
    //   166: aload 5
    //   168: astore_3
    //   169: aload 6
    //   171: astore_2
    //   172: aload 7
    //   174: astore 4
    //   176: aload 8
    //   178: invokevirtual 1692	java/io/File:canWrite	()Z
    //   181: ifeq +42 -> 223
    //   184: aload 6
    //   186: astore_2
    //   187: aload 7
    //   189: astore 4
    //   191: new 1694	java/io/FileOutputStream
    //   194: dup
    //   195: aload 8
    //   197: iconst_0
    //   198: invokespecial 1697	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   201: astore_3
    //   202: aload_3
    //   203: aload_1
    //   204: invokevirtual 1698	java/io/FileOutputStream:write	([B)V
    //   207: goto +16 -> 223
    //   210: astore_0
    //   211: aload_3
    //   212: astore_2
    //   213: goto +62 -> 275
    //   216: astore_0
    //   217: aload_3
    //   218: astore 4
    //   220: goto +35 -> 255
    //   223: aload_3
    //   224: astore_2
    //   225: aload_3
    //   226: astore 4
    //   228: aload_0
    //   229: aload_1
    //   230: invokestatic 1701	oicq/wlogin_sdk/tools/util:save_android_id	(Landroid/content/Context;[B)V
    //   233: aload_3
    //   234: ifnull +61 -> 295
    //   237: aload_3
    //   238: invokevirtual 1702	java/io/FileOutputStream:close	()V
    //   241: return
    //   242: astore_0
    //   243: aload_0
    //   244: ldc 223
    //   246: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   249: return
    //   250: astore_0
    //   251: goto +24 -> 275
    //   254: astore_0
    //   255: aload 4
    //   257: astore_2
    //   258: aload_0
    //   259: ldc 223
    //   261: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   264: aload 4
    //   266: ifnull +29 -> 295
    //   269: aload 4
    //   271: invokevirtual 1702	java/io/FileOutputStream:close	()V
    //   274: return
    //   275: aload_2
    //   276: ifnull +17 -> 293
    //   279: aload_2
    //   280: invokevirtual 1702	java/io/FileOutputStream:close	()V
    //   283: goto +10 -> 293
    //   286: astore_1
    //   287: aload_1
    //   288: ldc 223
    //   290: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   293: aload_0
    //   294: athrow
    //   295: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContext	Context
    //   0	296	1	paramArrayOfByte	byte[]
    //   23	257	2	localObject1	Object
    //   65	173	3	localObject2	Object
    //   56	214	4	localObject3	Object
    //   49	118	5	localObject4	Object
    //   43	142	6	localObject5	Object
    //   46	142	7	localObject6	Object
    //   118	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   202	207	210	finally
    //   202	207	216	java/lang/Exception
    //   237	241	242	java/io/IOException
    //   269	274	242	java/io/IOException
    //   58	66	250	finally
    //   73	85	250	finally
    //   92	100	250	finally
    //   107	120	250	finally
    //   127	135	250	finally
    //   142	148	250	finally
    //   158	166	250	finally
    //   176	184	250	finally
    //   191	202	250	finally
    //   228	233	250	finally
    //   258	264	250	finally
    //   58	66	254	java/lang/Exception
    //   73	85	254	java/lang/Exception
    //   92	100	254	java/lang/Exception
    //   107	120	254	java/lang/Exception
    //   127	135	254	java/lang/Exception
    //   142	148	254	java/lang/Exception
    //   158	166	254	java/lang/Exception
    //   176	184	254	java/lang/Exception
    //   191	202	254	java/lang/Exception
    //   228	233	254	java/lang/Exception
    //   279	283	286	java/io/IOException
  }
  
  public static void saveInitKeyTime(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
        paramContext.putInt("InitKeyTime", paramInt);
        paramContext.commit();
        LOGI("saveInitKeyTime time:".concat(String.valueOf(paramInt)), "");
        return;
      }
      catch (Throwable paramContext)
      {
        printThrowable(paramContext, "saveReqTimeToSp");
        return;
      }
    }
  }
  
  public static void save_android_id(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("android_id", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cost_time(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putString("costTime", paramString);
      paramContext.commit();
    }
  }
  
  public static void save_cost_trace(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putString("costTrace", paramString);
      paramContext.commit();
    }
  }
  
  public static void save_cur_android_id(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_android_id", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
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
  
  public static void save_cur_mac(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_mac", buf_to_string(paramArrayOfByte));
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
  
  public static void save_pow_test(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putBoolean("powTestNew", paramBoolean);
      paramContext.commit();
      LOGI("save_pow_test ".concat(String.valueOf(paramBoolean)), "");
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
    //   7: invokevirtual 1284	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 9
    //   12: new 372	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1286
    //   19: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore 6
    //   24: aload 6
    //   26: ldc_w 1288
    //   29: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 6
    //   35: ldc_w 1290
    //   38: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 6
    //   44: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 1296	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   50: astore 10
    //   52: aload 10
    //   54: invokevirtual 1734	android/net/Uri:toString	()Ljava/lang/String;
    //   57: invokestatic 612	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   60: aconst_null
    //   61: astore 7
    //   63: aconst_null
    //   64: astore 6
    //   66: aload 9
    //   68: aload 10
    //   70: iconst_5
    //   71: anewarray 351	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: ldc_w 1298
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: ldc_w 1300
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: ldc_w 1302
    //   91: aastore
    //   92: dup
    //   93: iconst_3
    //   94: ldc_w 1304
    //   97: aastore
    //   98: dup
    //   99: iconst_4
    //   100: ldc_w 1306
    //   103: aastore
    //   104: ldc_w 1308
    //   107: iconst_2
    //   108: anewarray 351	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: lload_1
    //   114: invokestatic 1311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: lload_3
    //   121: invokestatic 1311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   124: aastore
    //   125: aconst_null
    //   126: invokevirtual 1317	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 8
    //   131: aload 8
    //   133: ifnonnull +17 -> 150
    //   136: aload 8
    //   138: ifnull +10 -> 148
    //   141: aload 8
    //   143: invokeinterface 1335 1 0
    //   148: iconst_0
    //   149: ireturn
    //   150: aload 8
    //   152: astore 6
    //   154: aload 8
    //   156: astore 7
    //   158: aload_0
    //   159: invokestatic 1736	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   162: invokestatic 1686	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   165: astore_0
    //   166: aload 8
    //   168: astore 6
    //   170: aload 8
    //   172: astore 7
    //   174: aload_0
    //   175: invokevirtual 644	java/lang/String:length	()I
    //   178: istore 5
    //   180: iload 5
    //   182: ifne +17 -> 199
    //   185: aload 8
    //   187: ifnull +10 -> 197
    //   190: aload 8
    //   192: invokeinterface 1335 1 0
    //   197: iconst_0
    //   198: ireturn
    //   199: aload 8
    //   201: astore 6
    //   203: aload 8
    //   205: astore 7
    //   207: aload_0
    //   208: invokestatic 1330	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 11
    //   213: aload 8
    //   215: astore 6
    //   217: aload 8
    //   219: astore 7
    //   221: aload 8
    //   223: invokeinterface 1739 1 0
    //   228: ifle +74 -> 302
    //   231: aload 8
    //   233: astore 6
    //   235: aload 8
    //   237: astore 7
    //   239: new 1741	android/content/ContentValues
    //   242: dup
    //   243: invokespecial 1742	android/content/ContentValues:<init>	()V
    //   246: astore 9
    //   248: aload 8
    //   250: astore 6
    //   252: aload 8
    //   254: astore 7
    //   256: aload 9
    //   258: ldc_w 1304
    //   261: aload_0
    //   262: invokevirtual 1745	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 8
    //   267: astore 6
    //   269: aload 8
    //   271: astore 7
    //   273: aload 9
    //   275: ldc_w 1306
    //   278: aload 11
    //   280: invokevirtual 1745	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 8
    //   285: astore 6
    //   287: aload 8
    //   289: astore 7
    //   291: aload 8
    //   293: invokeinterface 1322 1 0
    //   298: pop
    //   299: goto +228 -> 527
    //   302: aload 8
    //   304: astore 6
    //   306: aload 8
    //   308: astore 7
    //   310: new 1741	android/content/ContentValues
    //   313: dup
    //   314: invokespecial 1742	android/content/ContentValues:<init>	()V
    //   317: astore 12
    //   319: aload 8
    //   321: astore 6
    //   323: aload 8
    //   325: astore 7
    //   327: aload 12
    //   329: ldc_w 1300
    //   332: lload_1
    //   333: invokestatic 1748	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   336: invokevirtual 1751	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   339: aload 8
    //   341: astore 6
    //   343: aload 8
    //   345: astore 7
    //   347: aload 12
    //   349: ldc_w 1302
    //   352: lload_3
    //   353: invokestatic 1748	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: invokevirtual 1751	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   359: aload 8
    //   361: astore 6
    //   363: aload 8
    //   365: astore 7
    //   367: aload 12
    //   369: ldc_w 1304
    //   372: aload_0
    //   373: invokevirtual 1745	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 8
    //   378: astore 6
    //   380: aload 8
    //   382: astore 7
    //   384: aload 12
    //   386: ldc_w 1306
    //   389: aload 11
    //   391: invokevirtual 1745	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 8
    //   396: astore 6
    //   398: aload 8
    //   400: astore 7
    //   402: aload 9
    //   404: aload 10
    //   406: aload 12
    //   408: invokevirtual 1755	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   411: astore_0
    //   412: aload 8
    //   414: astore 6
    //   416: aload 8
    //   418: astore 7
    //   420: new 372	java/lang/StringBuilder
    //   423: dup
    //   424: ldc_w 1757
    //   427: invokespecial 374	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   430: astore 9
    //   432: aload 8
    //   434: astore 6
    //   436: aload 8
    //   438: astore 7
    //   440: aload 9
    //   442: aload_0
    //   443: invokevirtual 1760	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 8
    //   449: astore 6
    //   451: aload 8
    //   453: astore 7
    //   455: aload 9
    //   457: ldc_w 1762
    //   460: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 8
    //   466: astore 6
    //   468: aload 8
    //   470: astore 7
    //   472: aload 9
    //   474: lload_1
    //   475: invokevirtual 936	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 8
    //   481: astore 6
    //   483: aload 8
    //   485: astore 7
    //   487: aload 9
    //   489: ldc_w 1764
    //   492: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 8
    //   498: astore 6
    //   500: aload 8
    //   502: astore 7
    //   504: aload 9
    //   506: lload_3
    //   507: invokevirtual 936	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 8
    //   513: astore 6
    //   515: aload 8
    //   517: astore 7
    //   519: aload 9
    //   521: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 1766	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   527: aload 8
    //   529: ifnull +10 -> 539
    //   532: aload 8
    //   534: invokeinterface 1335 1 0
    //   539: iconst_1
    //   540: ireturn
    //   541: astore_0
    //   542: goto +28 -> 570
    //   545: astore_0
    //   546: aload 7
    //   548: astore 6
    //   550: aload_0
    //   551: ldc 223
    //   553: invokestatic 478	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   556: aload 7
    //   558: ifnull +10 -> 568
    //   561: aload 7
    //   563: invokeinterface 1335 1 0
    //   568: iconst_0
    //   569: ireturn
    //   570: aload 6
    //   572: ifnull +10 -> 582
    //   575: aload 6
    //   577: invokeinterface 1335 1 0
    //   582: aload_0
    //   583: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	paramContext	Context
    //   0	584	1	paramLong1	long
    //   0	584	3	paramLong2	long
    //   178	3	5	i	int
    //   22	554	6	localObject1	Object
    //   61	501	7	localObject2	Object
    //   129	404	8	localCursor	android.database.Cursor
    //   10	510	9	localObject3	Object
    //   50	355	10	localUri	Uri
    //   211	179	11	str	String
    //   317	90	12	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   66	131	541	finally
    //   158	166	541	finally
    //   174	180	541	finally
    //   207	213	541	finally
    //   221	231	541	finally
    //   239	248	541	finally
    //   256	265	541	finally
    //   273	283	541	finally
    //   291	299	541	finally
    //   310	319	541	finally
    //   327	339	541	finally
    //   347	359	541	finally
    //   367	376	541	finally
    //   384	394	541	finally
    //   402	412	541	finally
    //   420	432	541	finally
    //   440	447	541	finally
    //   455	464	541	finally
    //   472	479	541	finally
    //   487	496	541	finally
    //   504	511	541	finally
    //   519	527	541	finally
    //   550	556	541	finally
    //   66	131	545	java/lang/Exception
    //   158	166	545	java/lang/Exception
    //   174	180	545	java/lang/Exception
    //   207	213	545	java/lang/Exception
    //   221	231	545	java/lang/Exception
    //   239	248	545	java/lang/Exception
    //   256	265	545	java/lang/Exception
    //   273	283	545	java/lang/Exception
    //   291	299	545	java/lang/Exception
    //   310	319	545	java/lang/Exception
    //   327	339	545	java/lang/Exception
    //   347	359	545	java/lang/Exception
    //   367	376	545	java/lang/Exception
    //   384	394	545	java/lang/Exception
    //   402	412	545	java/lang/Exception
    //   420	432	545	java/lang/Exception
    //   440	447	545	java/lang/Exception
    //   455	464	545	java/lang/Exception
    //   472	479	545	java/lang/Exception
    //   487	496	545	java/lang/Exception
    //   504	511	545	java/lang/Exception
    //   519	527	545	java/lang/Exception
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
  
  public static void set_server_ipv6_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ipv6_host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_ipv6_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ipv6_host2", new String(paramArrayOfByte));
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
  
  public static void set_wap_server_ipv6_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-ipv6_host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_ipv6_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-ipv6_host2", new String(paramArrayOfByte));
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
    byte[][] arrayOfByte1 = null;
    return arrayOfByte1;
  }
  
  public static void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString != null) {
      label91:
      try
      {
        int i = paramString.length();
        if (i != 0) {}
      }
      finally {}
    }
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists())
      {
        File localFile = paramString.getParentFile();
        if (localFile != null)
        {
          if (!localFile.mkdirs())
          {
            boolean bool = localFile.isDirectory();
            if (bool) {}
          }
        }
        else {
          return;
        }
      }
      paramString = new FileOutputStream(paramString, true);
      paramString.write(paramArrayOfByte);
      paramString.close();
      return;
    }
    catch (Exception paramString)
    {
      break label91;
    }
    return;
  }
  
  public static class a
  {
    public static String a(Context paramContext, String paramString)
    {
      try
      {
        paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
        paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
        return paramContext;
      }
      catch (IllegalArgumentException paramContext)
      {
        throw paramContext;
      }
      catch (Exception paramContext)
      {
        label50:
        break label50;
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */