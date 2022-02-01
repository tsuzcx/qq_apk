package com.tencent.biz.pubaccount.util;

import acbn;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import anpc;
import aopd;
import arwv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import jqc;
import mqq.app.AppRuntime;
import obt;
import org.json.JSONArray;
import org.json.JSONException;

public class PreloadManager
{
  private static PreloadManager b;
  public final String TAG = "ReadInJoyArticleDetailPreloadManager";
  public Object aV = new Object();
  Object aW = new Object();
  volatile boolean awd;
  volatile boolean awe;
  private volatile HashMap<String, ArrayList<a>> eF = new HashMap();
  private MQLruCache<String, byte[]> f = new MQLruCache(30);
  private List<String> kS = new CopyOnWriteArrayList();
  ArrayList<a> lY = new ArrayList();
  Object lock = new Object();
  Handler mHandler = new Handler(Looper.getMainLooper());
  private List<String> waitingList = new CopyOnWriteArrayList();
  
  private boolean Gw()
  {
    boolean bool2 = false;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool1 = bool2;
    switch (obt.aHM)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "shouldDoStatisticReport->uin:" + str + ", result:" + bool1);
      }
      return bool1;
      bool1 = true;
      continue;
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(obt.Yh))
        {
          bool1 = bool2;
          if (str.endsWith(obt.Yh)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static PreloadManager a()
  {
    if (b == null) {
      b = new PreloadManager();
    }
    return b;
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!Gw()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_dataSource", "1");
    if (obt.aec) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_enableIpConnect", str);
      localHashMap.put("param_connType", String.valueOf(paramInt));
      localHashMap.put("param_host", paramString1);
      localHashMap.put("param_ipAddr", paramString2);
      localHashMap.put("param_ipConnResult", paramString3);
      localHashMap.put("param_hostConnResult", paramString4);
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
      anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyIpConnect", paramBoolean, paramLong, 0L, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "doStatisticReport-->success:" + paramBoolean + ", costTime:" + paramLong + ", param_dataSource:1, param_enableIpConnect:" + str + ", param_connType:" + paramInt + ", param_host:" + paramString1 + ", param_ipAddr:" + paramString2 + ", param_ipConnResult:" + paramString3 + ", param_hostConnResult:" + paramString4);
      return;
    }
  }
  
  static int aR(String paramString)
  {
    Object localObject = arwv.toMD5(paramString);
    paramString = (String)localObject + ".temp";
    localObject = new File(acbn.bnC, (String)localObject);
    paramString = new File(acbn.bnC, paramString);
    if (((File)localObject).exists()) {
      return 2;
    }
    if (paramString.exists()) {
      return 1;
    }
    return 0;
  }
  
  private ArrayList<a> c(String paramString, boolean paramBoolean)
  {
    String str = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    new ArrayList();
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("<head>[.\\s\\S\\w]*?</head>").matcher(paramString);
    Matcher localMatcher;
    Object localObject;
    if (paramString.find())
    {
      localMatcher = Pattern.compile("<meta[.\\s\\S\\w]*?/>").matcher(paramString.group());
      paramString = null;
      while (localMatcher.find())
      {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, localMatcher.group());
        if (Pattern.compile("itemprop[\\s]*=[\\s]*\"[\\s]*prefetch-images[\\s]*\"").matcher(localMatcher.group()).find())
        {
          localObject = Pattern.compile("content[\\s]*=[\\s]*\"(.*?)\"").matcher(localMatcher.group());
          if (!((Matcher)localObject).find()) {
            break label419;
          }
          paramString = ((Matcher)localObject).group(1);
        }
      }
    }
    label419:
    for (;;)
    {
      localObject = Pattern.compile("priority[\\s]*=[\\s]*\"(.*?)\"").matcher(localMatcher.group());
      if (((Matcher)localObject).find()) {
        str = ((Matcher)localObject).group(1);
      }
      for (;;)
      {
        if (paramString != null)
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          localObject = a(paramString, true, paramBoolean);
          List localList = a(str, false, paramBoolean);
          int i = ((List)localObject).size();
          int j = localList.size();
          a locala;
          if ((j == 0) || (j < i) || (j > i))
          {
            i = 0;
            while (i < ((List)localObject).size())
            {
              locala = new a();
              locala.url = ((String)((List)localObject).get(i));
              locala.priority = 0;
              localArrayList.add(locala);
              i += 1;
            }
            break;
          }
          i = 0;
          while (i < ((List)localObject).size())
          {
            locala = new a();
            locala.url = ((String)((List)localObject).get(i));
            try
            {
              locala.priority = Integer.parseInt((String)localList.get(i));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                locala.priority = 0;
                localNumberFormatException.printStackTrace();
                localArrayList.add(locala);
              }
            }
            finally
            {
              localArrayList.add(locala);
            }
            i += 1;
            continue;
            return localArrayList;
          }
        }
        break;
      }
    }
  }
  
  /* Error */
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 362	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 364
    //   14: invokespecial 367	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   17: astore_2
    //   18: ldc_w 364
    //   21: invokestatic 373	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   24: astore_0
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_2
    //   28: invokevirtual 377	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 381	javax/crypto/Cipher:doFinal	([B)[B
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 382	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 383	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 384	java/security/InvalidKeyException:printStackTrace	()V
    //   64: goto -33 -> 31
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 385	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 386	javax/crypto/BadPaddingException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 387	java/lang/OutOfMemoryError:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte1	byte[]
    //   0	88	1	paramArrayOfByte2	byte[]
    //   17	11	2	localSecretKeySpec	SecretKeySpec
    //   59	2	2	localInvalidKeyException	java.security.InvalidKeyException
    // Exception table:
    //   from	to	target	type
    //   18	25	39	java/security/NoSuchAlgorithmException
    //   18	25	49	javax/crypto/NoSuchPaddingException
    //   25	31	59	java/security/InvalidKeyException
    //   31	37	67	javax/crypto/IllegalBlockSizeException
    //   31	37	74	javax/crypto/BadPaddingException
    //   31	37	81	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 362	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 364
    //   8: invokespecial 367	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 364
    //   15: invokestatic 373	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 377	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 381	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 385	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 384	java/security/InvalidKeyException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 382	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 386	javax/crypto/BadPaddingException:printStackTrace	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 383	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 387	java/lang/OutOfMemoryError:printStackTrace	()V
    //   73: aconst_null
    //   74: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramArrayOfByte1	byte[]
    //   0	75	1	paramArrayOfByte2	byte[]
    //   18	8	2	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   25	31	33	javax/crypto/IllegalBlockSizeException
    //   19	25	40	java/security/InvalidKeyException
    //   25	31	40	java/security/InvalidKeyException
    //   34	38	40	java/security/InvalidKeyException
    //   55	59	40	java/security/InvalidKeyException
    //   12	19	47	java/security/NoSuchAlgorithmException
    //   19	25	47	java/security/NoSuchAlgorithmException
    //   25	31	47	java/security/NoSuchAlgorithmException
    //   34	38	47	java/security/NoSuchAlgorithmException
    //   41	45	47	java/security/NoSuchAlgorithmException
    //   55	59	47	java/security/NoSuchAlgorithmException
    //   25	31	54	javax/crypto/BadPaddingException
    //   12	19	61	javax/crypto/NoSuchPaddingException
    //   19	25	61	javax/crypto/NoSuchPaddingException
    //   25	31	61	javax/crypto/NoSuchPaddingException
    //   34	38	61	javax/crypto/NoSuchPaddingException
    //   41	45	61	javax/crypto/NoSuchPaddingException
    //   55	59	61	javax/crypto/NoSuchPaddingException
    //   12	19	68	java/lang/OutOfMemoryError
    //   19	25	68	java/lang/OutOfMemoryError
    //   25	31	68	java/lang/OutOfMemoryError
    //   34	38	68	java/lang/OutOfMemoryError
    //   41	45	68	java/lang/OutOfMemoryError
    //   55	59	68	java/lang/OutOfMemoryError
  }
  
  private String f(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("http:"));
      str = paramString;
    } while (paramString.startsWith("https"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  /* Error */
  private void fM(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   9: lstore_2
    //   10: aload 9
    //   12: astore 8
    //   14: aload_1
    //   15: invokestatic 408	com/tencent/biz/pubaccount/util/PreloadManager:fk	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 11
    //   20: aload 11
    //   22: ifnonnull +22 -> 44
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 410	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   43: return
    //   44: aload 9
    //   46: astore 8
    //   48: invokestatic 104	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   51: invokevirtual 108	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   54: checkcast 414	com/tencent/mobileqq/app/QQAppInterface
    //   57: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   60: astore 12
    //   62: aload 9
    //   64: astore 8
    //   66: new 127	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 420	acbn:bnB	Ljava/lang/String;
    //   76: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 11
    //   81: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 10
    //   89: aload 9
    //   91: astore 8
    //   93: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +45 -> 141
    //   99: aload 9
    //   101: astore 8
    //   103: ldc_w 422
    //   106: iconst_2
    //   107: new 127	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 424
    //   117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 10
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 426
    //   128: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 429	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 9
    //   143: astore 8
    //   145: aload 10
    //   147: invokestatic 434	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   150: ifeq +55 -> 205
    //   153: aload 9
    //   155: astore 8
    //   157: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +16 -> 176
    //   163: aload 9
    //   165: astore 8
    //   167: ldc 50
    //   169: iconst_2
    //   170: ldc_w 436
    //   173: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 9
    //   178: astore 8
    //   180: aload_0
    //   181: aload_1
    //   182: aload 12
    //   184: invokevirtual 439	com/tencent/biz/pubaccount/util/PreloadManager:bS	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_0
    //   188: ifeq -151 -> 37
    //   191: new 410	java/lang/NullPointerException
    //   194: dup
    //   195: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   204: return
    //   205: aload 9
    //   207: astore 8
    //   209: aload_0
    //   210: aload_1
    //   211: invokespecial 442	com/tencent/biz/pubaccount/util/PreloadManager:fl	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnonnull +21 -> 239
    //   221: iconst_0
    //   222: ifeq -185 -> 37
    //   225: new 410	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   238: return
    //   239: aload 9
    //   241: astore 8
    //   243: aload_0
    //   244: aload_0
    //   245: aload 13
    //   247: aload_1
    //   248: ldc_w 396
    //   251: invokevirtual 394	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: invokespecial 171	com/tencent/biz/pubaccount/util/PreloadManager:c	(Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   257: putfield 66	com/tencent/biz/pubaccount/util/PreloadManager:lY	Ljava/util/ArrayList;
    //   260: aload 9
    //   262: astore 8
    //   264: aload_0
    //   265: getfield 61	com/tencent/biz/pubaccount/util/PreloadManager:aV	Ljava/lang/Object;
    //   268: astore_1
    //   269: aload 9
    //   271: astore 8
    //   273: aload_1
    //   274: monitorenter
    //   275: aload_0
    //   276: getfield 82	com/tencent/biz/pubaccount/util/PreloadManager:eF	Ljava/util/HashMap;
    //   279: aload 11
    //   281: aload_0
    //   282: getfield 66	com/tencent/biz/pubaccount/util/PreloadManager:lY	Ljava/util/ArrayList;
    //   285: invokevirtual 189	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: ldc 50
    //   291: iconst_2
    //   292: new 127	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 444
    //   302: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 11
    //   307: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_1
    //   317: monitorexit
    //   318: aload 9
    //   320: astore 8
    //   322: aload_0
    //   323: getfield 446	com/tencent/biz/pubaccount/util/PreloadManager:awe	Z
    //   326: ifne +33 -> 359
    //   329: aload 9
    //   331: astore 8
    //   333: invokestatic 451	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   336: iconst_1
    //   337: if_icmpne +22 -> 359
    //   340: aload 9
    //   342: astore 8
    //   344: aload_0
    //   345: invokevirtual 454	com/tencent/biz/pubaccount/util/PreloadManager:Gv	()Z
    //   348: ifeq +11 -> 359
    //   351: aload 9
    //   353: astore 8
    //   355: aload_0
    //   356: invokevirtual 457	com/tencent/biz/pubaccount/util/PreloadManager:bdl	()V
    //   359: aload 9
    //   361: astore 8
    //   363: aload_0
    //   364: getfield 77	com/tencent/biz/pubaccount/util/PreloadManager:f	Landroid/support/v4/util/MQLruCache;
    //   367: aload 11
    //   369: aload 13
    //   371: invokevirtual 461	java/lang/String:getBytes	()[B
    //   374: invokevirtual 462	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   377: pop
    //   378: aload 9
    //   380: astore 8
    //   382: aload 13
    //   384: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +217 -> 604
    //   390: aload 9
    //   392: astore 8
    //   394: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   397: lstore 4
    //   399: lload 4
    //   401: lload_2
    //   402: lsub
    //   403: lstore_2
    //   404: aload 9
    //   406: astore 8
    //   408: aconst_null
    //   409: ldc 229
    //   411: ldc_w 464
    //   414: ldc_w 464
    //   417: iconst_0
    //   418: iconst_0
    //   419: ldc_w 257
    //   422: new 127	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   429: ldc 229
    //   431: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: lload_2
    //   435: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   438: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: ldc_w 466
    //   444: ldc 229
    //   446: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   449: iconst_0
    //   450: ifeq -413 -> 37
    //   453: new 410	java/lang/NullPointerException
    //   456: dup
    //   457: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   460: athrow
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   466: return
    //   467: astore 10
    //   469: aload_1
    //   470: monitorexit
    //   471: aload 9
    //   473: astore 8
    //   475: aload 10
    //   477: athrow
    //   478: astore_1
    //   479: aload 7
    //   481: astore 8
    //   483: aload_1
    //   484: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   487: aload 7
    //   489: astore 8
    //   491: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   494: lstore 4
    //   496: aload 7
    //   498: astore 8
    //   500: aconst_null
    //   501: ldc 229
    //   503: ldc_w 464
    //   506: ldc_w 464
    //   509: iconst_0
    //   510: iconst_0
    //   511: ldc_w 257
    //   514: new 127	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   521: ldc 229
    //   523: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: lload 4
    //   528: lload_2
    //   529: lsub
    //   530: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: aload_1
    //   537: invokevirtual 474	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: ldc 229
    //   542: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload 7
    //   547: ifnull -510 -> 37
    //   550: aload 7
    //   552: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   555: return
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   561: return
    //   562: astore_1
    //   563: aload 9
    //   565: astore 8
    //   567: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +16 -> 586
    //   573: aload 9
    //   575: astore 8
    //   577: ldc 50
    //   579: iconst_2
    //   580: ldc_w 481
    //   583: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: iconst_0
    //   587: ifeq -550 -> 37
    //   590: new 410	java/lang/NullPointerException
    //   593: dup
    //   594: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   597: athrow
    //   598: astore_1
    //   599: aload_1
    //   600: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   603: return
    //   604: aload 9
    //   606: astore 8
    //   608: new 127	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   615: aload 13
    //   617: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: ldc_w 483
    //   623: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload 11
    //   628: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokevirtual 461	java/lang/String:getBytes	()[B
    //   637: astore_1
    //   638: aload 9
    //   640: astore 8
    //   642: aload 12
    //   644: invokestatic 487	com/tencent/biz/pubaccount/util/PreloadManager:j	(Ljava/lang/String;)[B
    //   647: astore 12
    //   649: aload 12
    //   651: ifnonnull +63 -> 714
    //   654: iconst_0
    //   655: ifeq -618 -> 37
    //   658: new 410	java/lang/NullPointerException
    //   661: dup
    //   662: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   665: athrow
    //   666: astore_1
    //   667: aload_1
    //   668: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   671: return
    //   672: astore_1
    //   673: aload 9
    //   675: astore 8
    //   677: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +16 -> 696
    //   683: aload 9
    //   685: astore 8
    //   687: ldc 50
    //   689: iconst_2
    //   690: ldc_w 481
    //   693: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: iconst_0
    //   697: ifeq -660 -> 37
    //   700: new 410	java/lang/NullPointerException
    //   703: dup
    //   704: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   707: athrow
    //   708: astore_1
    //   709: aload_1
    //   710: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   713: return
    //   714: aload_1
    //   715: ifnonnull +21 -> 736
    //   718: iconst_0
    //   719: ifeq -682 -> 37
    //   722: new 410	java/lang/NullPointerException
    //   725: dup
    //   726: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   729: athrow
    //   730: astore_1
    //   731: aload_1
    //   732: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   735: return
    //   736: aload 9
    //   738: astore 8
    //   740: aload 12
    //   742: aload_1
    //   743: invokestatic 489	com/tencent/biz/pubaccount/util/PreloadManager:encrypt	([B[B)[B
    //   746: astore 12
    //   748: aload 9
    //   750: astore 8
    //   752: new 269	java/io/File
    //   755: dup
    //   756: getstatic 420	acbn:bnB	Ljava/lang/String;
    //   759: invokespecial 491	java/io/File:<init>	(Ljava/lang/String;)V
    //   762: astore_1
    //   763: aload 9
    //   765: astore 8
    //   767: aload_1
    //   768: invokevirtual 280	java/io/File:exists	()Z
    //   771: ifne +36 -> 807
    //   774: aload 9
    //   776: astore 8
    //   778: aload_1
    //   779: invokevirtual 494	java/io/File:mkdirs	()Z
    //   782: istore 6
    //   784: iload 6
    //   786: ifne +21 -> 807
    //   789: iconst_0
    //   790: ifeq -753 -> 37
    //   793: new 410	java/lang/NullPointerException
    //   796: dup
    //   797: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   800: athrow
    //   801: astore_1
    //   802: aload_1
    //   803: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   806: return
    //   807: aload 9
    //   809: astore 8
    //   811: new 476	java/io/FileOutputStream
    //   814: dup
    //   815: new 269	java/io/File
    //   818: dup
    //   819: aload_1
    //   820: new 127	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   827: aload 11
    //   829: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 496
    //   835: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokespecial 499	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   844: invokespecial 502	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   847: astore_1
    //   848: aload 12
    //   850: ifnonnull +96 -> 946
    //   853: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   856: ifeq +12 -> 868
    //   859: ldc 50
    //   861: iconst_2
    //   862: ldc_w 504
    //   865: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   871: lstore 4
    //   873: lload 4
    //   875: lload_2
    //   876: lsub
    //   877: lstore 4
    //   879: lload 4
    //   881: lstore_2
    //   882: aconst_null
    //   883: ldc 229
    //   885: ldc_w 464
    //   888: ldc_w 464
    //   891: iconst_0
    //   892: iconst_0
    //   893: ldc_w 257
    //   896: new 127	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   903: ldc 229
    //   905: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: lload 4
    //   910: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   913: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: ldc_w 466
    //   919: ldc 229
    //   921: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   924: lload 4
    //   926: lstore_2
    //   927: aload_1
    //   928: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   931: aload_1
    //   932: ifnull -895 -> 37
    //   935: aload_1
    //   936: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   939: return
    //   940: astore_1
    //   941: aload_1
    //   942: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   945: return
    //   946: aload_1
    //   947: aload 12
    //   949: invokevirtual 508	java/io/FileOutputStream:write	([B)V
    //   952: aload_1
    //   953: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   956: new 269	java/io/File
    //   959: dup
    //   960: new 127	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   967: getstatic 420	acbn:bnB	Ljava/lang/String;
    //   970: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload 11
    //   975: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: ldc_w 496
    //   981: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokespecial 491	java/io/File:<init>	(Ljava/lang/String;)V
    //   990: new 269	java/io/File
    //   993: dup
    //   994: aload 10
    //   996: invokespecial 491	java/io/File:<init>	(Ljava/lang/String;)V
    //   999: invokevirtual 512	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1002: pop
    //   1003: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   1006: lstore 4
    //   1008: lload 4
    //   1010: lload_2
    //   1011: lsub
    //   1012: lstore 4
    //   1014: lload 4
    //   1016: lstore_2
    //   1017: aconst_null
    //   1018: ldc 229
    //   1020: ldc_w 464
    //   1023: ldc_w 464
    //   1026: iconst_0
    //   1027: iconst_0
    //   1028: ldc 185
    //   1030: new 127	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   1037: ldc 229
    //   1039: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: lload 4
    //   1044: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: ldc_w 466
    //   1053: ldc 229
    //   1055: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1058: aload_1
    //   1059: ifnull -1022 -> 37
    //   1062: aload_1
    //   1063: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1066: return
    //   1067: astore_1
    //   1068: aload_1
    //   1069: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   1072: return
    //   1073: astore_1
    //   1074: aload 8
    //   1076: ifnull +8 -> 1084
    //   1079: aload 8
    //   1081: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1084: aload_1
    //   1085: athrow
    //   1086: astore 7
    //   1088: aload 7
    //   1090: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   1093: goto -9 -> 1084
    //   1096: astore 7
    //   1098: aload_1
    //   1099: astore 8
    //   1101: aload 7
    //   1103: astore_1
    //   1104: goto -30 -> 1074
    //   1107: astore_1
    //   1108: goto -629 -> 479
    //   1111: astore 8
    //   1113: aload_1
    //   1114: astore 7
    //   1116: aload 8
    //   1118: astore_1
    //   1119: goto -640 -> 479
    //   1122: astore 8
    //   1124: aload_1
    //   1125: astore 7
    //   1127: aload 8
    //   1129: astore_1
    //   1130: goto -651 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1133	0	this	PreloadManager
    //   0	1133	1	paramString	String
    //   9	1008	2	l1	long
    //   397	646	4	l2	long
    //   782	3	6	bool	boolean
    //   4	547	7	localObject1	Object
    //   1086	3	7	localIOException1	IOException
    //   1096	6	7	localObject2	Object
    //   1114	12	7	str1	String
    //   12	1088	8	localObject3	Object
    //   1111	6	8	localIOException2	IOException
    //   1122	6	8	localIOException3	IOException
    //   1	807	9	localObject4	Object
    //   87	59	10	str2	String
    //   467	528	10	str3	String
    //   18	956	11	str4	String
    //   60	888	12	localObject5	Object
    //   214	402	13	str5	String
    // Exception table:
    //   from	to	target	type
    //   29	37	38	java/io/IOException
    //   191	199	199	java/io/IOException
    //   225	233	233	java/io/IOException
    //   453	461	461	java/io/IOException
    //   275	318	467	finally
    //   469	471	467	finally
    //   14	20	478	java/io/IOException
    //   48	62	478	java/io/IOException
    //   66	89	478	java/io/IOException
    //   93	99	478	java/io/IOException
    //   103	141	478	java/io/IOException
    //   145	153	478	java/io/IOException
    //   157	163	478	java/io/IOException
    //   167	176	478	java/io/IOException
    //   180	187	478	java/io/IOException
    //   209	216	478	java/io/IOException
    //   243	260	478	java/io/IOException
    //   264	269	478	java/io/IOException
    //   273	275	478	java/io/IOException
    //   322	329	478	java/io/IOException
    //   333	340	478	java/io/IOException
    //   344	351	478	java/io/IOException
    //   355	359	478	java/io/IOException
    //   363	378	478	java/io/IOException
    //   382	390	478	java/io/IOException
    //   394	399	478	java/io/IOException
    //   475	478	478	java/io/IOException
    //   567	573	478	java/io/IOException
    //   577	586	478	java/io/IOException
    //   608	638	478	java/io/IOException
    //   642	649	478	java/io/IOException
    //   677	683	478	java/io/IOException
    //   687	696	478	java/io/IOException
    //   740	748	478	java/io/IOException
    //   752	763	478	java/io/IOException
    //   767	774	478	java/io/IOException
    //   778	784	478	java/io/IOException
    //   811	848	478	java/io/IOException
    //   550	555	556	java/io/IOException
    //   363	378	562	java/lang/OutOfMemoryError
    //   590	598	598	java/io/IOException
    //   658	666	666	java/io/IOException
    //   608	638	672	java/lang/OutOfMemoryError
    //   700	708	708	java/io/IOException
    //   722	730	730	java/io/IOException
    //   793	801	801	java/io/IOException
    //   935	939	940	java/io/IOException
    //   1062	1066	1067	java/io/IOException
    //   14	20	1073	finally
    //   48	62	1073	finally
    //   66	89	1073	finally
    //   93	99	1073	finally
    //   103	141	1073	finally
    //   145	153	1073	finally
    //   157	163	1073	finally
    //   167	176	1073	finally
    //   180	187	1073	finally
    //   209	216	1073	finally
    //   243	260	1073	finally
    //   264	269	1073	finally
    //   273	275	1073	finally
    //   322	329	1073	finally
    //   333	340	1073	finally
    //   344	351	1073	finally
    //   355	359	1073	finally
    //   363	378	1073	finally
    //   382	390	1073	finally
    //   394	399	1073	finally
    //   408	449	1073	finally
    //   475	478	1073	finally
    //   483	487	1073	finally
    //   491	496	1073	finally
    //   500	545	1073	finally
    //   567	573	1073	finally
    //   577	586	1073	finally
    //   608	638	1073	finally
    //   642	649	1073	finally
    //   677	683	1073	finally
    //   687	696	1073	finally
    //   740	748	1073	finally
    //   752	763	1073	finally
    //   767	774	1073	finally
    //   778	784	1073	finally
    //   811	848	1073	finally
    //   1079	1084	1086	java/io/IOException
    //   853	868	1096	finally
    //   868	873	1096	finally
    //   882	924	1096	finally
    //   927	931	1096	finally
    //   946	1008	1096	finally
    //   1017	1058	1096	finally
    //   408	449	1107	java/io/IOException
    //   853	868	1111	java/io/IOException
    //   868	873	1111	java/io/IOException
    //   946	1008	1111	java/io/IOException
    //   882	924	1122	java/io/IOException
    //   927	931	1122	java/io/IOException
    //   1017	1058	1122	java/io/IOException
  }
  
  public static String fk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("article_id");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String fl(String paramString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithCondition:" + obt.aec);
    }
    if (obt.aec) {
      return fm(paramString);
    }
    long l;
    if (Gw()) {
      try
      {
        str1 = new URL(paramString).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          for (;;)
          {
            String str1;
            String str3 = InetAddress.getByName(str1).getHostAddress();
            l = NetConnInfoCenter.getServerTimeMillis();
            try
            {
              paramString = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str1, str3, "-1", "0");
              return paramString;
            }
            catch (IOException paramString)
            {
              String str2;
              String str4;
              a(false, l, 1, str2, str4, "-1", paramString.getMessage());
              throw paramString;
            }
            localMalformedURLException = localMalformedURLException;
            str2 = "";
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            str4 = "";
          }
        }
      }
    }
    return jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  private String fm(String paramString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadHtmlWithIpConnect!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect empty url:" + paramString);
      }
      return null;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    String str3;
    try
    {
      str3 = new URL(paramString).getHost();
      String str1 = aopd.a().aC(str3, 1008);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect host:" + str3 + ", ip:" + str1);
      }
      if (str1 == null) {
        try
        {
          str1 = InetAddress.getByName(str3).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html with host:" + paramString);
              }
              String str4 = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str3, str1, "-1", "0");
              return str4;
            }
            catch (IOException localIOException1)
            {
              String str2;
              localIOException1.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html error:" + localIOException1);
              a(false, l, 1, str3, str2, "-1", localIOException1.getMessage());
              throw localIOException1;
            }
            localUnknownHostException = localUnknownHostException;
            str2 = "";
          }
        }
      }
      str5 = paramString.replaceFirst(str3, localMalformedURLException);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect illegal url:" + paramString);
      }
      return null;
    }
    String str5;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("Host", str3);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip:" + str5);
      }
      str5 = jqc.a(BaseApplication.getContext(), str5, "GET", null, (Bundle)localObject, str3);
      a(true, l, 2, str3, localMalformedURLException, "0", "-1");
      return str5;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip error:" + localIOException2);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html with host:" + paramString);
        }
        localObject = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
        aopd.a().X(str3, localMalformedURLException, 1008);
        a(true, l, 3, str3, localMalformedURLException, localIOException2.getMessage(), "0");
        return localObject;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html error:" + localIOException3);
        }
        a(false, l, 4, str3, localMalformedURLException, localIOException2.getMessage(), localIOException3.getMessage());
        throw localIOException3;
      }
    }
  }
  
  public static byte[] j(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = new SecureRandom();
    byte[] arrayOfByte = new byte[32];
    ((SecureRandom)localObject2).nextBytes(arrayOfByte);
    localObject2 = new PBEKeySpec(paramString.toCharArray(), arrayOfByte, 1000, 256);
    try
    {
      paramString = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    }
    catch (NoSuchAlgorithmException paramString)
    {
      try
      {
        for (;;)
        {
          paramString = paramString.generateSecret((KeySpec)localObject2).getEncoded();
          return new SecretKeySpec(paramString, "AES").getEncoded();
          paramString = paramString;
          paramString.printStackTrace();
          paramString = null;
        }
      }
      catch (InvalidKeySpecException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject1;
        }
      }
    }
  }
  
  private byte[] l(String paramString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithCondition:" + obt.aec);
    }
    if (obt.aec) {
      return n(paramString);
    }
    long l;
    if (Gw()) {
      try
      {
        str1 = new URL(paramString).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          for (;;)
          {
            String str1;
            String str3 = InetAddress.getByName(str1).getHostAddress();
            l = NetConnInfoCenter.getServerTimeMillis();
            try
            {
              paramString = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str1, str3, "-1", "0");
              return paramString;
            }
            catch (IOException paramString)
            {
              String str2;
              String str4;
              a(false, l, 1, str2, str4, "-1", paramString.getMessage());
              throw paramString;
            }
            localMalformedURLException = localMalformedURLException;
            str2 = "";
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            str4 = "";
          }
        }
      }
    }
    return jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  private byte[] n(String paramString)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadImageWithIpConnect!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect empty url:" + paramString);
      }
      return null;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    String str3;
    try
    {
      str3 = new URL(paramString).getHost();
      String str1 = aopd.a().aC(str3, 1009);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect host:" + str3 + ", ip:" + str1);
      }
      if (str1 == null) {
        try
        {
          str1 = InetAddress.getByName(str3).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image with host:" + paramString);
              }
              byte[] arrayOfByte = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str3, str1, "-1", "0");
              return arrayOfByte;
            }
            catch (IOException localIOException1)
            {
              String str2;
              localIOException1.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image error:" + localIOException1);
              a(false, l, 1, str3, str2, "-1", localIOException1.getMessage());
              throw localIOException1;
            }
            localUnknownHostException = localUnknownHostException;
            str2 = "";
          }
        }
      }
      localObject1 = paramString.replaceFirst(str3, localMalformedURLException);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect illegal url:" + paramString);
      }
      return null;
    }
    Object localObject1;
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("Host", str3);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip:" + (String)localObject1);
      }
      localObject1 = jqc.a(BaseApplication.getContext(), (String)localObject1, "GET", null, (Bundle)localObject2, str3);
      a(true, l, 2, str3, localMalformedURLException, "0", "-1");
      return localObject1;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip error:" + localIOException2);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image with host:" + paramString);
        }
        localObject2 = jqc.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
        aopd.a().X(str3, localMalformedURLException, 1009);
        a(true, l, 3, str3, localMalformedURLException, localIOException2.getMessage(), "0");
        return localObject2;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image error:" + localIOException3);
        }
        a(false, l, 4, str3, localMalformedURLException, localIOException2.getMessage(), localIOException3.getMessage());
        throw localIOException3;
      }
    }
  }
  
  public boolean Gu()
  {
    return false;
  }
  
  public boolean Gv()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + localQQAppInterface.getCurrentAccountUin(), 0).getBoolean("kandian_feeds_image_preload", false);
  }
  
  public List<String> a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int j = 0;
    while (i < paramString.length()) {
      if ((paramString.charAt(i) == ';') || (i == paramString.length() - 1))
      {
        if (i == paramString.length() - 1) {}
        for (int k = paramString.length();; k = i)
        {
          if (k <= j) {
            break label175;
          }
          String str2 = paramString.substring(j, k);
          String str1 = str2;
          if (paramBoolean1) {
            str1 = f(str2, paramBoolean2);
          }
          if (str1 != null)
          {
            localArrayList.add(str1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "预下载图片url = " + str1);
            }
          }
          i = k + 1;
          j = i;
          break;
        }
        label175:
        i += 1;
      }
      else
      {
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void bS(String paramString1, String paramString2)
  {
    ThreadManager.executeOnFileThread(new ReadFileThread(paramString1, paramString2));
  }
  
  public void bdi()
  {
    this.kS.addAll(this.waitingList);
    this.waitingList.clear();
    this.awd = true;
    bdk();
  }
  
  public void bdj()
  {
    ThreadManager.post(new PreloadManager.1(this), 5, null, false);
  }
  
  public void bdk()
  {
    ThreadManager.executeOnNetWorkThread(new PreloadThread());
  }
  
  public void bdl()
  {
    if (NetworkState.getNetworkType() != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "current network is not wifi");
      }
      return;
    }
    ThreadManager.executeOnNetWorkThread(new FeedslistDownlaodImageThread());
  }
  
  public void bdm()
  {
    synchronized (this.aV)
    {
      this.waitingList.clear();
      this.kS.clear();
      this.eF.clear();
      return;
    }
  }
  
  public boolean er(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = (AppInterface)((AppRuntime)localObject1).getAppRuntime("modular_web");
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject1).getCurrentAccountUin(), 0).getString("kandian_feeds_fling_LToR_host", "");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if (localObject1 != null)
          {
            int i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).get(i);
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "kandian_feeds_fling_LToR_host canFlingLToRHost:" + localObject2);
              }
              boolean bool = paramString.equals(localObject2);
              if (bool) {
                return true;
              }
              i += 1;
            }
          }
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public boolean es(String paramString)
  {
    // Byte code:
    //   0: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_1
    //   5: invokestatic 265	arwv:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 12
    //   10: new 269	java/io/File
    //   13: dup
    //   14: getstatic 274	acbn:bnC	Ljava/lang/String;
    //   17: invokespecial 491	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 9
    //   22: aload 9
    //   24: invokevirtual 280	java/io/File:exists	()Z
    //   27: ifne +37 -> 64
    //   30: aload 9
    //   32: invokevirtual 494	java/io/File:mkdirs	()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +27 -> 64
    //   40: iconst_0
    //   41: ifeq +11 -> 52
    //   44: new 410	java/lang/NullPointerException
    //   47: dup
    //   48: invokespecial 411	java/lang/NullPointerException:<init>	()V
    //   51: athrow
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: ireturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   61: goto -9 -> 52
    //   64: new 269	java/io/File
    //   67: dup
    //   68: aload 9
    //   70: new 127	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   77: aload 12
    //   79: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 267
    //   85: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 499	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 11
    //   96: new 476	java/io/FileOutputStream
    //   99: dup
    //   100: aload 11
    //   102: invokespecial 502	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore 7
    //   107: aload 7
    //   109: astore 8
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 784	com/tencent/biz/pubaccount/util/PreloadManager:l	(Ljava/lang/String;)[B
    //   116: astore 10
    //   118: aload 10
    //   120: ifnull +172 -> 292
    //   123: aload 7
    //   125: astore 8
    //   127: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +45 -> 175
    //   133: aload 7
    //   135: astore 8
    //   137: ldc 50
    //   139: iconst_2
    //   140: new 127	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 786
    //   150: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 788
    //   160: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   166: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 7
    //   177: astore 8
    //   179: aload 7
    //   181: aload 10
    //   183: invokevirtual 508	java/io/FileOutputStream:write	([B)V
    //   186: aload 7
    //   188: astore 8
    //   190: aload 11
    //   192: new 269	java/io/File
    //   195: dup
    //   196: aload 9
    //   198: aload 12
    //   200: invokespecial 499	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   203: invokevirtual 512	java/io/File:renameTo	(Ljava/io/File;)Z
    //   206: pop
    //   207: aload 7
    //   209: astore 8
    //   211: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   214: lstore 5
    //   216: lload 5
    //   218: lload_3
    //   219: lsub
    //   220: lstore 5
    //   222: aload 7
    //   224: astore 8
    //   226: lload 5
    //   228: lstore_3
    //   229: aconst_null
    //   230: ldc 229
    //   232: ldc_w 790
    //   235: ldc_w 790
    //   238: iconst_0
    //   239: iconst_0
    //   240: ldc 185
    //   242: new 127	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   249: ldc 229
    //   251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: lload 5
    //   256: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: ldc_w 466
    //   265: ldc_w 257
    //   268: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   271: iconst_1
    //   272: istore_2
    //   273: aload 7
    //   275: ifnull -221 -> 54
    //   278: aload 7
    //   280: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   290: iconst_1
    //   291: ireturn
    //   292: aload 7
    //   294: astore 8
    //   296: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +16 -> 315
    //   302: aload 7
    //   304: astore 8
    //   306: ldc 50
    //   308: iconst_2
    //   309: ldc_w 792
    //   312: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 7
    //   317: astore 8
    //   319: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   322: lstore 5
    //   324: lload 5
    //   326: lload_3
    //   327: lsub
    //   328: lstore 5
    //   330: aload 7
    //   332: astore 8
    //   334: lload 5
    //   336: lstore_3
    //   337: aconst_null
    //   338: ldc 229
    //   340: ldc_w 790
    //   343: ldc_w 790
    //   346: iconst_0
    //   347: iconst_0
    //   348: ldc_w 257
    //   351: new 127	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   358: ldc 229
    //   360: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: lload 5
    //   365: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   368: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: ldc_w 466
    //   374: ldc_w 257
    //   377: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 7
    //   382: ifnull +8 -> 390
    //   385: aload 7
    //   387: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   390: iconst_0
    //   391: ireturn
    //   392: astore_1
    //   393: aload_1
    //   394: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   397: goto -7 -> 390
    //   400: astore_1
    //   401: aconst_null
    //   402: astore 7
    //   404: aload 7
    //   406: astore 8
    //   408: invokestatic 405	java/lang/System:currentTimeMillis	()J
    //   411: lstore 5
    //   413: aload 7
    //   415: astore 8
    //   417: aconst_null
    //   418: ldc 229
    //   420: ldc_w 790
    //   423: ldc_w 790
    //   426: iconst_0
    //   427: iconst_0
    //   428: ldc_w 257
    //   431: new 127	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   438: ldc 229
    //   440: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 5
    //   445: lload_3
    //   446: lsub
    //   447: invokevirtual 240	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aload_1
    //   454: invokevirtual 474	java/io/IOException:getMessage	()Ljava/lang/String;
    //   457: ldc_w 257
    //   460: invokestatic 471	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload 7
    //   465: ifnull +8 -> 473
    //   468: aload 7
    //   470: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   473: iconst_0
    //   474: ireturn
    //   475: astore_1
    //   476: aload_1
    //   477: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   480: goto -7 -> 473
    //   483: astore_1
    //   484: aconst_null
    //   485: astore 7
    //   487: aload 7
    //   489: ifnull -16 -> 473
    //   492: aload 7
    //   494: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   497: goto -24 -> 473
    //   500: astore_1
    //   501: aload_1
    //   502: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   505: goto -32 -> 473
    //   508: astore_1
    //   509: aconst_null
    //   510: astore 7
    //   512: aload 7
    //   514: astore 8
    //   516: aload_1
    //   517: invokevirtual 793	java/lang/IllegalArgumentException:printStackTrace	()V
    //   520: aload 7
    //   522: ifnull -49 -> 473
    //   525: aload 7
    //   527: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   530: goto -57 -> 473
    //   533: astore_1
    //   534: aload_1
    //   535: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   538: goto -65 -> 473
    //   541: astore_1
    //   542: aconst_null
    //   543: astore 8
    //   545: aload 8
    //   547: ifnull +8 -> 555
    //   550: aload 8
    //   552: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   555: aload_1
    //   556: athrow
    //   557: astore 7
    //   559: aload 7
    //   561: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   564: goto -9 -> 555
    //   567: astore_1
    //   568: goto -23 -> 545
    //   571: astore_1
    //   572: goto -60 -> 512
    //   575: astore_1
    //   576: goto -89 -> 487
    //   579: astore_1
    //   580: goto -176 -> 404
    //   583: astore_1
    //   584: goto -180 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	PreloadManager
    //   0	587	1	paramString	String
    //   35	238	2	bool	boolean
    //   3	443	3	l1	long
    //   214	230	5	l2	long
    //   105	421	7	localFileOutputStream1	java.io.FileOutputStream
    //   557	3	7	localIOException	IOException
    //   109	442	8	localFileOutputStream2	java.io.FileOutputStream
    //   20	177	9	localFile1	File
    //   116	66	10	arrayOfByte	byte[]
    //   94	97	11	localFile2	File
    //   8	191	12	str	String
    // Exception table:
    //   from	to	target	type
    //   44	52	56	java/io/IOException
    //   278	283	285	java/io/IOException
    //   385	390	392	java/io/IOException
    //   10	36	400	java/io/IOException
    //   64	107	400	java/io/IOException
    //   468	473	475	java/io/IOException
    //   10	36	483	java/lang/OutOfMemoryError
    //   64	107	483	java/lang/OutOfMemoryError
    //   492	497	500	java/io/IOException
    //   10	36	508	java/lang/IllegalArgumentException
    //   64	107	508	java/lang/IllegalArgumentException
    //   525	530	533	java/io/IOException
    //   10	36	541	finally
    //   64	107	541	finally
    //   550	555	557	java/io/IOException
    //   111	118	567	finally
    //   127	133	567	finally
    //   137	175	567	finally
    //   179	186	567	finally
    //   190	207	567	finally
    //   211	216	567	finally
    //   229	271	567	finally
    //   296	302	567	finally
    //   306	315	567	finally
    //   319	324	567	finally
    //   337	380	567	finally
    //   408	413	567	finally
    //   417	463	567	finally
    //   516	520	567	finally
    //   111	118	571	java/lang/IllegalArgumentException
    //   127	133	571	java/lang/IllegalArgumentException
    //   137	175	571	java/lang/IllegalArgumentException
    //   179	186	571	java/lang/IllegalArgumentException
    //   190	207	571	java/lang/IllegalArgumentException
    //   211	216	571	java/lang/IllegalArgumentException
    //   229	271	571	java/lang/IllegalArgumentException
    //   296	302	571	java/lang/IllegalArgumentException
    //   306	315	571	java/lang/IllegalArgumentException
    //   319	324	571	java/lang/IllegalArgumentException
    //   337	380	571	java/lang/IllegalArgumentException
    //   111	118	575	java/lang/OutOfMemoryError
    //   127	133	575	java/lang/OutOfMemoryError
    //   137	175	575	java/lang/OutOfMemoryError
    //   179	186	575	java/lang/OutOfMemoryError
    //   190	207	575	java/lang/OutOfMemoryError
    //   211	216	575	java/lang/OutOfMemoryError
    //   229	271	575	java/lang/OutOfMemoryError
    //   296	302	575	java/lang/OutOfMemoryError
    //   306	315	575	java/lang/OutOfMemoryError
    //   319	324	575	java/lang/OutOfMemoryError
    //   337	380	575	java/lang/OutOfMemoryError
    //   111	118	579	java/io/IOException
    //   127	133	579	java/io/IOException
    //   137	175	579	java/io/IOException
    //   179	186	579	java/io/IOException
    //   190	207	579	java/io/IOException
    //   211	216	579	java/io/IOException
    //   296	302	579	java/io/IOException
    //   306	315	579	java/io/IOException
    //   319	324	579	java/io/IOException
    //   229	271	583	java/io/IOException
    //   337	380	583	java/io/IOException
  }
  
  public byte[] k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (byte[])this.f.get(paramString);
  }
  
  public void oZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "add Task url:" + paramString);
    }
    synchronized (this.lock)
    {
      if (!this.waitingList.contains(paramString))
      {
        this.waitingList.add(paramString);
        if (!this.awd) {
          bdi();
        }
      }
      return;
    }
  }
  
  public ArrayList<a> s(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.aV)
    {
      paramString = (ArrayList)this.eF.get(paramString);
      if (paramString == null) {
        break label97;
      }
      Collections.sort(paramString, new b());
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        a locala = (a)paramString.next();
        if (aR(locala.url) == 0) {
          localArrayList.add(locala);
        }
      }
    }
    return localArrayList;
    label97:
    return null;
  }
  
  class FeedslistDownlaodImageThread
    implements Runnable
  {
    FeedslistDownlaodImageThread() {}
    
    PreloadManager.a a()
    {
      Object localObject1 = PreloadManager.this.aV;
      int i = 3;
      while (i > 0)
      {
        try
        {
          PreloadManager.a locala;
          do
          {
            Iterator localIterator = PreloadManager.a(PreloadManager.this).values().iterator();
            Object localObject3;
            while (!((Iterator)localObject3).hasNext())
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (ArrayList)localIterator.next();
              if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0)) {
                return null;
              }
              localObject3 = ((ArrayList)localObject3).iterator();
            }
            locala = (PreloadManager.a)((Iterator)localObject3).next();
            if (locala == null) {
              return null;
            }
          } while ((PreloadManager.aR(locala.url) != 0) || (locala.priority != i));
          return locala;
        }
        finally {}
        i -= 1;
      }
      return null;
    }
    
    public void run()
    {
      PreloadManager.this.awe = true;
      for (;;)
      {
        PreloadManager.a locala = a();
        if (locala == null) {
          break;
        }
        if (NetworkState.getNetworkType() != 1) {
          return;
        }
        PreloadManager.this.es(locala.url);
      }
      PreloadManager.this.awe = false;
    }
  }
  
  class PreloadThread
    implements Runnable
  {
    PreloadThread() {}
    
    public void run()
    {
      ??? = PreloadManager.a(PreloadManager.this).iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        PreloadManager.a(PreloadManager.this, str);
      }
      synchronized (PreloadManager.this.lock)
      {
        PreloadManager.a(PreloadManager.this).clear();
        if (PreloadManager.b(PreloadManager.this).size() > 0)
        {
          PreloadManager.this.bdi();
          return;
        }
        PreloadManager.this.awd = false;
      }
    }
  }
  
  class ReadFileThread
    implements Runnable
  {
    boolean isHttps = false;
    String uin;
    String url;
    
    public ReadFileThread(String paramString1, String paramString2)
    {
      this.url = paramString1;
      this.uin = paramString2;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:url	Ljava/lang/String;
      //   4: invokestatic 39	com/tencent/biz/pubaccount/util/PreloadManager:fk	(Ljava/lang/String;)Ljava/lang/String;
      //   7: astore 4
      //   9: aload 4
      //   11: ifnonnull +4 -> 15
      //   14: return
      //   15: aload_0
      //   16: aload_0
      //   17: getfield 27	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:url	Ljava/lang/String;
      //   20: ldc 41
      //   22: invokevirtual 47	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   25: putfield 25	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:isHttps	Z
      //   28: aload_0
      //   29: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   32: invokestatic 51	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
      //   35: aload 4
      //   37: invokevirtual 57	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   40: checkcast 59	[B
      //   43: astore_2
      //   44: aload_2
      //   45: ifnonnull +436 -> 481
      //   48: new 61	java/io/File
      //   51: dup
      //   52: new 61	java/io/File
      //   55: dup
      //   56: getstatic 66	acbn:bnB	Ljava/lang/String;
      //   59: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
      //   62: aload 4
      //   64: invokespecial 72	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   67: astore_3
      //   68: aload_3
      //   69: invokevirtual 76	java/io/File:exists	()Z
      //   72: ifeq -58 -> 14
      //   75: invokestatic 82	java/lang/System:currentTimeMillis	()J
      //   78: aload_3
      //   79: invokevirtual 85	java/io/File:lastModified	()J
      //   82: lsub
      //   83: ldc2_w 86
      //   86: lcmp
      //   87: ifge -73 -> 14
      //   90: aconst_null
      //   91: astore_2
      //   92: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   95: ifeq +30 -> 125
      //   98: ldc 94
      //   100: iconst_2
      //   101: new 96	java/lang/StringBuilder
      //   104: dup
      //   105: invokespecial 97	java/lang/StringBuilder:<init>	()V
      //   108: ldc 99
      //   110: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: invokestatic 82	java/lang/System:currentTimeMillis	()J
      //   116: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   119: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   122: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   125: new 116	java/io/FileInputStream
      //   128: dup
      //   129: aload_3
      //   130: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   133: astore_3
      //   134: aload_3
      //   135: invokevirtual 123	java/io/FileInputStream:available	()I
      //   138: newarray byte
      //   140: astore_2
      //   141: aload_3
      //   142: aload_2
      //   143: invokevirtual 127	java/io/FileInputStream:read	([B)I
      //   146: pop
      //   147: aload_3
      //   148: invokevirtual 130	java/io/FileInputStream:close	()V
      //   151: aload_0
      //   152: getfield 29	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:uin	Ljava/lang/String;
      //   155: invokestatic 134	com/tencent/biz/pubaccount/util/PreloadManager:j	(Ljava/lang/String;)[B
      //   158: aload_2
      //   159: invokestatic 138	com/tencent/biz/pubaccount/util/PreloadManager:decrypt	([B[B)[B
      //   162: astore_2
      //   163: aload_2
      //   164: ifnull +243 -> 407
      //   167: new 43	java/lang/String
      //   170: dup
      //   171: aload_2
      //   172: invokespecial 141	java/lang/String:<init>	([B)V
      //   175: astore_2
      //   176: aload_2
      //   177: aload_2
      //   178: ldc 143
      //   180: invokevirtual 147	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   183: bipush 10
      //   185: iadd
      //   186: aload_2
      //   187: invokevirtual 150	java/lang/String:length	()I
      //   190: invokevirtual 154	java/lang/String:substring	(II)Ljava/lang/String;
      //   193: astore 5
      //   195: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   198: ifeq +29 -> 227
      //   201: ldc 94
      //   203: iconst_2
      //   204: new 96	java/lang/StringBuilder
      //   207: dup
      //   208: invokespecial 97	java/lang/StringBuilder:<init>	()V
      //   211: ldc 156
      //   213: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: aload 5
      //   218: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   224: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   227: aload 4
      //   229: aload 5
      //   231: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   234: istore_1
      //   235: iload_1
      //   236: ifne +18 -> 254
      //   239: aload_3
      //   240: ifnull -226 -> 14
      //   243: aload_3
      //   244: invokevirtual 130	java/io/FileInputStream:close	()V
      //   247: return
      //   248: astore_2
      //   249: aload_2
      //   250: invokevirtual 163	java/io/IOException:printStackTrace	()V
      //   253: return
      //   254: aload_2
      //   255: iconst_0
      //   256: aload_2
      //   257: ldc 143
      //   259: invokevirtual 147	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   262: invokevirtual 154	java/lang/String:substring	(II)Ljava/lang/String;
      //   265: astore 5
      //   267: aload_0
      //   268: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   271: getfield 167	com/tencent/biz/pubaccount/util/PreloadManager:aW	Ljava/lang/Object;
      //   274: astore_2
      //   275: aload_2
      //   276: monitorenter
      //   277: aload_0
      //   278: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   281: invokestatic 51	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Landroid/support/v4/util/MQLruCache;
      //   284: aload 4
      //   286: aload 5
      //   288: invokevirtual 171	java/lang/String:getBytes	()[B
      //   291: invokevirtual 175	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   294: pop
      //   295: aload_2
      //   296: monitorexit
      //   297: new 177	java/util/ArrayList
      //   300: dup
      //   301: invokespecial 178	java/util/ArrayList:<init>	()V
      //   304: pop
      //   305: aload_0
      //   306: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   309: aload 5
      //   311: aload_0
      //   312: getfield 25	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:isHttps	Z
      //   315: invokestatic 181	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
      //   318: astore 5
      //   320: aload_0
      //   321: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   324: getfield 184	com/tencent/biz/pubaccount/util/PreloadManager:aV	Ljava/lang/Object;
      //   327: astore_2
      //   328: aload_2
      //   329: monitorenter
      //   330: aload_0
      //   331: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   334: invokestatic 187	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
      //   337: aload 4
      //   339: aload 5
      //   341: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   344: pop
      //   345: ldc 94
      //   347: iconst_2
      //   348: new 96	java/lang/StringBuilder
      //   351: dup
      //   352: invokespecial 97	java/lang/StringBuilder:<init>	()V
      //   355: ldc 192
      //   357: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: aload 4
      //   362: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   365: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   368: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   371: aload_2
      //   372: monitorexit
      //   373: aload_0
      //   374: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   377: getfield 195	com/tencent/biz/pubaccount/util/PreloadManager:awe	Z
      //   380: ifne +27 -> 407
      //   383: invokestatic 200	cooperation/qzone/util/NetworkState:getNetworkType	()I
      //   386: iconst_1
      //   387: if_icmpne +20 -> 407
      //   390: aload_0
      //   391: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   394: invokevirtual 203	com/tencent/biz/pubaccount/util/PreloadManager:Gv	()Z
      //   397: ifeq +10 -> 407
      //   400: aload_0
      //   401: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   404: invokevirtual 206	com/tencent/biz/pubaccount/util/PreloadManager:bdl	()V
      //   407: aload_3
      //   408: ifnull -394 -> 14
      //   411: aload_3
      //   412: invokevirtual 130	java/io/FileInputStream:close	()V
      //   415: return
      //   416: astore_2
      //   417: aload_2
      //   418: invokevirtual 163	java/io/IOException:printStackTrace	()V
      //   421: return
      //   422: astore 4
      //   424: aload_2
      //   425: monitorexit
      //   426: aload 4
      //   428: athrow
      //   429: astore 4
      //   431: aload_3
      //   432: astore_2
      //   433: aload 4
      //   435: astore_3
      //   436: aload_3
      //   437: invokevirtual 163	java/io/IOException:printStackTrace	()V
      //   440: aload_2
      //   441: ifnull -427 -> 14
      //   444: aload_2
      //   445: invokevirtual 130	java/io/FileInputStream:close	()V
      //   448: return
      //   449: astore_2
      //   450: aload_2
      //   451: invokevirtual 163	java/io/IOException:printStackTrace	()V
      //   454: return
      //   455: astore 4
      //   457: aload_2
      //   458: monitorexit
      //   459: aload 4
      //   461: athrow
      //   462: astore_2
      //   463: aload_3
      //   464: ifnull +7 -> 471
      //   467: aload_3
      //   468: invokevirtual 130	java/io/FileInputStream:close	()V
      //   471: aload_2
      //   472: athrow
      //   473: astore_3
      //   474: aload_3
      //   475: invokevirtual 163	java/io/IOException:printStackTrace	()V
      //   478: goto -7 -> 471
      //   481: new 177	java/util/ArrayList
      //   484: dup
      //   485: invokespecial 178	java/util/ArrayList:<init>	()V
      //   488: pop
      //   489: aload_0
      //   490: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   493: new 43	java/lang/String
      //   496: dup
      //   497: aload_2
      //   498: invokespecial 141	java/lang/String:<init>	([B)V
      //   501: aload_0
      //   502: getfield 25	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:isHttps	Z
      //   505: invokestatic 181	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;Ljava/lang/String;Z)Ljava/util/ArrayList;
      //   508: astore_3
      //   509: aload_0
      //   510: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   513: getfield 184	com/tencent/biz/pubaccount/util/PreloadManager:aV	Ljava/lang/Object;
      //   516: astore_2
      //   517: aload_2
      //   518: monitorenter
      //   519: aload_0
      //   520: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   523: invokestatic 187	com/tencent/biz/pubaccount/util/PreloadManager:a	(Lcom/tencent/biz/pubaccount/util/PreloadManager;)Ljava/util/HashMap;
      //   526: aload 4
      //   528: aload_3
      //   529: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   532: pop
      //   533: ldc 94
      //   535: iconst_2
      //   536: new 96	java/lang/StringBuilder
      //   539: dup
      //   540: invokespecial 97	java/lang/StringBuilder:<init>	()V
      //   543: ldc 192
      //   545: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   548: aload 4
      //   550: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   553: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   556: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   559: aload_2
      //   560: monitorexit
      //   561: aload_0
      //   562: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   565: getfield 195	com/tencent/biz/pubaccount/util/PreloadManager:awe	Z
      //   568: ifne -554 -> 14
      //   571: invokestatic 200	cooperation/qzone/util/NetworkState:getNetworkType	()I
      //   574: iconst_1
      //   575: if_icmpne -561 -> 14
      //   578: aload_0
      //   579: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   582: invokevirtual 203	com/tencent/biz/pubaccount/util/PreloadManager:Gv	()Z
      //   585: ifeq -571 -> 14
      //   588: aload_0
      //   589: getfield 20	com/tencent/biz/pubaccount/util/PreloadManager$ReadFileThread:this$0	Lcom/tencent/biz/pubaccount/util/PreloadManager;
      //   592: invokevirtual 206	com/tencent/biz/pubaccount/util/PreloadManager:bdl	()V
      //   595: return
      //   596: astore_2
      //   597: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   600: ifeq -586 -> 14
      //   603: ldc 94
      //   605: iconst_2
      //   606: ldc 208
      //   608: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   611: return
      //   612: astore_3
      //   613: aload_2
      //   614: monitorexit
      //   615: aload_3
      //   616: athrow
      //   617: astore_2
      //   618: aconst_null
      //   619: astore_3
      //   620: goto -157 -> 463
      //   623: astore 4
      //   625: aload_2
      //   626: astore_3
      //   627: aload 4
      //   629: astore_2
      //   630: goto -167 -> 463
      //   633: astore_3
      //   634: goto -198 -> 436
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	637	0	this	ReadFileThread
      //   234	2	1	bool	boolean
      //   43	144	2	localObject1	Object
      //   248	9	2	localIOException1	IOException
      //   274	98	2	localObject2	Object
      //   416	9	2	localIOException2	IOException
      //   432	13	2	localObject3	Object
      //   449	9	2	localIOException3	IOException
      //   462	36	2	arrayOfByte	byte[]
      //   596	18	2	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   617	9	2	localObject5	Object
      //   629	1	2	localObject6	Object
      //   67	401	3	localObject7	Object
      //   473	2	3	localIOException4	IOException
      //   508	21	3	localArrayList	ArrayList
      //   612	4	3	localObject8	Object
      //   619	8	3	localObject9	Object
      //   633	1	3	localIOException5	IOException
      //   7	354	4	str	String
      //   422	5	4	localObject10	Object
      //   429	5	4	localIOException6	IOException
      //   455	94	4	localObject11	Object
      //   623	5	4	localObject12	Object
      //   193	147	5	localObject13	Object
      // Exception table:
      //   from	to	target	type
      //   243	247	248	java/io/IOException
      //   411	415	416	java/io/IOException
      //   277	297	422	finally
      //   424	426	422	finally
      //   134	163	429	java/io/IOException
      //   167	227	429	java/io/IOException
      //   227	235	429	java/io/IOException
      //   254	277	429	java/io/IOException
      //   297	330	429	java/io/IOException
      //   373	407	429	java/io/IOException
      //   426	429	429	java/io/IOException
      //   459	462	429	java/io/IOException
      //   444	448	449	java/io/IOException
      //   330	373	455	finally
      //   457	459	455	finally
      //   134	163	462	finally
      //   167	227	462	finally
      //   227	235	462	finally
      //   254	277	462	finally
      //   297	330	462	finally
      //   373	407	462	finally
      //   426	429	462	finally
      //   459	462	462	finally
      //   467	471	473	java/io/IOException
      //   489	509	596	java/lang/OutOfMemoryError
      //   519	561	612	finally
      //   613	615	612	finally
      //   92	125	617	finally
      //   125	134	617	finally
      //   436	440	623	finally
      //   92	125	633	java/io/IOException
      //   125	134	633	java/io/IOException
    }
  }
  
  public static class a
  {
    public int priority;
    public String url;
  }
  
  public static class b
    implements Comparator<PreloadManager.a>
  {
    public int a(PreloadManager.a parama1, PreloadManager.a parama2)
    {
      return parama2.priority - parama1.priority;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */