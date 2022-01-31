package com.tencent.biz.common.util;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import lr;
import ls;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineSecurity
{
  private static final int jdField_a_of_type_Int = 1;
  public static Handler a;
  public static OfflineSecurity.VerifyListener a;
  protected static String a;
  private static char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int jdField_b_of_type_Int = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "offlneSecurity";
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  
  static
  {
    b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    paramString1 = new FileInputStream(paramString1);
    byte[] arrayOfByte = new byte[4096];
    paramString2 = MessageDigest.getInstance(paramString2);
    for (;;)
    {
      int i = paramString1.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramString2.update(arrayOfByte, 0, i);
    }
    paramString1.close();
    return a(paramString2.digest());
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(jdField_a_of_type_JavaLangString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label14:
      break label14;
    }
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("offlneSecurity", 2, "report:" + paramInt);
    }
  }
  
  private static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    jdField_a_of_type_JavaLangString = str;
  }
  
  public static void a(String paramString1, OfflineSecurity.VerifyListener paramVerifyListener, String paramString2)
  {
    a(paramString2);
    jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener = paramVerifyListener;
    jdField_a_of_type_AndroidOsHandler = new lr();
    new Thread(new ls(paramString1, paramString2)).start();
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      Object localObject1 = new File(paramString + "/verify.json");
      if (!((File)localObject1).exists()) {
        return false;
      }
      Object localObject2 = new FileInputStream((File)localObject1);
      localObject1 = a((InputStream)localObject2);
      ((InputStream)localObject2).close();
      paramString = new File(paramString + "/verify.signature");
      if (paramString.exists())
      {
        paramString = new FileInputStream(paramString);
        localObject2 = a(paramString);
        paramString.close();
        boolean bool = a(b, (byte[])localObject1, (byte[])localObject2);
        return bool;
      }
    }
    catch (FileNotFoundException paramString)
    {
      a(1);
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      a(2);
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (a(paramString1)) {
      return b(paramString1);
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString3);
    if (a(paramString1)) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramString = Base64Util.a(paramString.getBytes("UTF-8"), 0);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localKeyFactory.generatePublic(new X509EncodedKeySpec(paramString)));
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      a(4);
    }
    return false;
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  private static boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new FileInputStream(new File(paramString + "/verify.json"));
        localJSONObject = new JSONObject(a((InputStream)localObject));
        ((InputStream)localObject).close();
        localObject = localJSONObject.keys();
      }
      catch (FileNotFoundException paramString)
      {
        try
        {
          Object localObject;
          JSONObject localJSONObject;
          if (localJSONObject.getString(str).equals(a(paramString + File.separator + str))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "check md5 fail:" + str);
          }
          a(6);
          return false;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          a(5);
        }
        paramString = paramString;
        a(1);
        paramString.printStackTrace();
        return false;
      }
      catch (JSONException paramString)
      {
        a(3);
        paramString.printStackTrace();
        return false;
      }
      catch (IOException paramString)
      {
        a(2);
        paramString.printStackTrace();
        return false;
      }
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = ((Iterator)localObject).next().toString();
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "JSONException:" + str);
      }
    }
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    a(paramString2);
    return a(paramString1);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    a(paramString3);
    if (a(paramString2)) {
      return c(paramString1, paramString2, paramString3);
    }
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 17
    //   8: iconst_2
    //   9: new 113	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 327
    //   19: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 329
    //   29: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_1
    //   50: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: new 199	java/io/File
    //   61: dup
    //   62: new 113	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   69: aload_0
    //   70: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 309	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 205	java/io/File:exists	()Z
    //   92: ifeq -36 -> 56
    //   95: new 89	java/io/FileInputStream
    //   98: dup
    //   99: new 199	java/io/File
    //   102: dup
    //   103: new 113	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 309	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 337
    //   123: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore 4
    //   137: new 286	org/json/JSONObject
    //   140: dup
    //   141: aload 4
    //   143: invokestatic 288	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   146: invokespecial 289	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   149: astore_3
    //   150: aload 4
    //   152: invokevirtual 104	java/io/InputStream:close	()V
    //   155: aload_3
    //   156: ldc_w 339
    //   159: invokevirtual 343	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   162: astore 5
    //   164: aload_3
    //   165: ldc_w 345
    //   168: invokevirtual 343	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   171: astore 6
    //   173: new 347	java/util/HashMap
    //   176: dup
    //   177: invokespecial 348	java/util/HashMap:<init>	()V
    //   180: astore 4
    //   182: aload 5
    //   184: ifnull +141 -> 325
    //   187: aload 5
    //   189: invokevirtual 293	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   192: astore 7
    //   194: aload 7
    //   196: invokeinterface 298 1 0
    //   201: ifeq +124 -> 325
    //   204: aload 7
    //   206: invokeinterface 302 1 0
    //   211: invokevirtual 303	java/lang/Object:toString	()Ljava/lang/String;
    //   214: astore 8
    //   216: aload 5
    //   218: aload 8
    //   220: invokevirtual 306	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_3
    //   225: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne -34 -> 194
    //   231: aload 4
    //   233: aload 8
    //   235: aload_3
    //   236: invokeinterface 354 3 0
    //   241: pop
    //   242: goto -48 -> 194
    //   245: astore_0
    //   246: iconst_1
    //   247: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   250: aload_0
    //   251: invokevirtual 219	java/io/FileNotFoundException:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_0
    //   257: iconst_3
    //   258: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   261: aload_0
    //   262: invokevirtual 321	org/json/JSONException:printStackTrace	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_0
    //   268: iconst_2
    //   269: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   272: aload_0
    //   273: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_3
    //   279: aload_3
    //   280: invokevirtual 321	org/json/JSONException:printStackTrace	()V
    //   283: iconst_5
    //   284: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   287: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +30 -> 320
    //   293: ldc 17
    //   295: iconst_2
    //   296: new 113	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 323
    //   306: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 8
    //   311: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aconst_null
    //   321: astore_3
    //   322: goto -98 -> 224
    //   325: aload 6
    //   327: ifnull +541 -> 868
    //   330: aload 6
    //   332: invokevirtual 293	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   335: astore_3
    //   336: aload_3
    //   337: invokeinterface 298 1 0
    //   342: ifeq +526 -> 868
    //   345: aload_3
    //   346: invokeinterface 302 1 0
    //   351: invokevirtual 303	java/lang/Object:toString	()Ljava/lang/String;
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull -22 -> 336
    //   361: aload_1
    //   362: aload 5
    //   364: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq -31 -> 336
    //   370: aload 4
    //   372: aload_1
    //   373: invokeinterface 358 2 0
    //   378: checkcast 63	java/lang/String
    //   381: astore_3
    //   382: new 113	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   389: aload_0
    //   390: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: getstatic 309	java/io/File:separator	Ljava/lang/String;
    //   396: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 311	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: astore_1
    //   410: aload_3
    //   411: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   414: ifne +11 -> 425
    //   417: aload_3
    //   418: aload_1
    //   419: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifne +58 -> 480
    //   425: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq -372 -> 56
    //   431: ldc 17
    //   433: iconst_2
    //   434: new 113	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 317
    //   444: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 5
    //   449: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 360
    //   455: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_3
    //   459: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 362
    //   465: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: iconst_0
    //   479: ireturn
    //   480: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +36 -> 519
    //   486: ldc 17
    //   488: iconst_2
    //   489: new 113	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 364
    //   499: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 5
    //   504: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: ldc_w 366
    //   510: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: aload 6
    //   521: aload 5
    //   523: invokevirtual 370	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   526: astore_3
    //   527: aload_3
    //   528: ifnull +340 -> 868
    //   531: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +43 -> 577
    //   537: ldc 17
    //   539: iconst_2
    //   540: new 113	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 364
    //   550: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 5
    //   555: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 372
    //   561: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_3
    //   565: invokevirtual 375	org/json/JSONArray:toString	()Ljava/lang/String;
    //   568: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: iconst_0
    //   578: istore_2
    //   579: iload_2
    //   580: aload_3
    //   581: invokevirtual 378	org/json/JSONArray:length	()I
    //   584: if_icmpge +284 -> 868
    //   587: aload_3
    //   588: iload_2
    //   589: invokevirtual 381	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   592: astore_1
    //   593: aload_1
    //   594: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifne +206 -> 803
    //   600: aload 4
    //   602: aload_1
    //   603: invokeinterface 358 2 0
    //   608: checkcast 63	java/lang/String
    //   611: astore 6
    //   613: new 113	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   620: aload_0
    //   621: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: getstatic 309	java/io/File:separator	Ljava/lang/String;
    //   627: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_1
    //   631: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 311	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   640: astore 7
    //   642: aload 6
    //   644: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   647: ifne +13 -> 660
    //   650: aload 6
    //   652: aload 7
    //   654: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifne +146 -> 803
    //   660: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq -607 -> 56
    //   666: ldc 17
    //   668: iconst_2
    //   669: new 113	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 383
    //   679: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 5
    //   684: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 385
    //   690: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_1
    //   694: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: ldc_w 387
    //   700: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 6
    //   705: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: ldc_w 389
    //   711: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 7
    //   716: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: iconst_0
    //   726: ireturn
    //   727: astore_1
    //   728: aload_1
    //   729: invokevirtual 321	org/json/JSONException:printStackTrace	()V
    //   732: iconst_5
    //   733: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   736: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq +30 -> 769
    //   742: ldc 17
    //   744: iconst_2
    //   745: new 113	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 323
    //   755: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 5
    //   760: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aconst_null
    //   770: astore_3
    //   771: goto -244 -> 527
    //   774: astore_1
    //   775: aload_1
    //   776: invokevirtual 321	org/json/JSONException:printStackTrace	()V
    //   779: iconst_5
    //   780: invokestatic 218	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   783: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   786: ifeq +12 -> 798
    //   789: ldc 17
    //   791: iconst_2
    //   792: ldc_w 391
    //   795: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: aconst_null
    //   799: astore_1
    //   800: goto -207 -> 593
    //   803: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +48 -> 854
    //   809: new 113	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   816: ldc_w 393
    //   819: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 5
    //   824: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 395
    //   830: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: astore 6
    //   835: aload_1
    //   836: ifnull +25 -> 861
    //   839: ldc 17
    //   841: iconst_2
    //   842: aload 6
    //   844: aload_1
    //   845: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: iload_2
    //   855: iconst_1
    //   856: iadd
    //   857: istore_2
    //   858: goto -279 -> 579
    //   861: ldc_w 397
    //   864: astore_1
    //   865: goto -26 -> 839
    //   868: iconst_1
    //   869: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	paramString1	String
    //   0	870	1	paramString2	String
    //   578	280	2	i	int
    //   149	87	3	localObject1	Object
    //   278	2	3	localJSONException	JSONException
    //   321	450	3	localObject2	Object
    //   135	466	4	localObject3	Object
    //   162	661	5	localObject4	Object
    //   171	672	6	localObject5	Object
    //   192	523	7	localObject6	Object
    //   214	96	8	str	String
    // Exception table:
    //   from	to	target	type
    //   95	173	245	java/io/FileNotFoundException
    //   95	173	256	org/json/JSONException
    //   95	173	267	java/io/IOException
    //   216	224	278	org/json/JSONException
    //   519	527	727	org/json/JSONException
    //   587	593	774	org/json/JSONException
  }
  
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    a(paramString3);
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramString3 = new FileInputStream(new File(paramString2 + "/verify.json"));
        JSONObject localJSONObject = new JSONObject(a(paramString3));
        paramString3.close();
        paramString3 = localJSONObject.optString(paramString1);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString3))
        {
          bool1 = bool2;
          if (!paramString3.equals(a(paramString2 + File.separator + paramString1)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("offlneSecurity", 2, "check md5 fail:" + paramString1);
            }
            a(6);
            return false;
          }
        }
      }
      catch (FileNotFoundException paramString1)
      {
        a(1);
        paramString1.printStackTrace();
        return false;
      }
      catch (JSONException paramString1)
      {
        a(3);
        paramString1.printStackTrace();
        return false;
      }
      catch (IOException paramString1)
      {
        a(2);
        paramString1.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.OfflineSecurity
 * JD-Core Version:    0.7.0.1
 */