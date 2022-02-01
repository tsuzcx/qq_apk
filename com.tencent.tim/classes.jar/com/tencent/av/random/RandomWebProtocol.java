package com.tencent.av.random;

import android.graphics.Bitmap;
import android.text.TextUtils;
import aqhs;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class RandomWebProtocol
{
  private static String mSelfUin;
  private b a;
  int asq;
  private Map<String, MatchTask> de = new ConcurrentHashMap();
  List<a> listeners = new ArrayList();
  private VideoAppInterface mApp;
  
  RandomWebProtocol(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    mSelfUin = this.mApp.getCurrentAccountUin();
    this.a = new b();
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    if (paramLong != 0L)
    {
      if (vl()) {
        QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
      }
      paramString = new f(paramInt1, paramLong, paramInt2, paramString);
      if ((MatchTask)this.de.get(paramString.key) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb][multiRoomOwner]sessionType(" + paramInt1 + ")");
        }
        MatchTask localMatchTask = new MatchTask(paramString);
        this.de.put(paramString.key, localMatchTask);
        localMatchTask.start();
      }
    }
  }
  
  private static String ds(String paramString)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {
      str = ChatActivityUtils.av(mSelfUin, paramString);
    }
    return str;
  }
  
  private static byte[] h(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      return arrayOfByte;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  /* Error */
  public static String k(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 173
    //   7: astore 4
    //   9: new 201	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 204	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 208	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 210	java/net/HttpURLConnection
    //   23: astore_0
    //   24: aload_0
    //   25: iconst_1
    //   26: invokevirtual 214	java/net/HttpURLConnection:setDoInput	(Z)V
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 217	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   34: aload_0
    //   35: ldc 219
    //   37: ldc 221
    //   39: invokevirtual 225	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_2
    //   43: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: ldc 227
    //   52: aload_2
    //   53: invokevirtual 225	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: ldc 229
    //   59: invokevirtual 232	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: iconst_0
    //   64: invokevirtual 235	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload_0
    //   68: sipush 5000
    //   71: invokevirtual 239	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: aload_0
    //   75: sipush 10000
    //   78: invokevirtual 242	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   81: aload_0
    //   82: invokevirtual 245	java/net/HttpURLConnection:connect	()V
    //   85: aload_1
    //   86: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +28 -> 117
    //   92: new 247	java/io/DataOutputStream
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 251	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   100: invokespecial 254	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   103: astore_2
    //   104: aload_2
    //   105: aload_1
    //   106: invokevirtual 257	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   109: aload_2
    //   110: invokevirtual 260	java/io/DataOutputStream:flush	()V
    //   113: aload_2
    //   114: invokevirtual 263	java/io/DataOutputStream:close	()V
    //   117: new 265	java/io/BufferedReader
    //   120: dup
    //   121: new 267	java/io/InputStreamReader
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 271	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: invokespecial 274	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   132: invokespecial 277	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   135: astore_1
    //   136: new 121	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   143: astore_2
    //   144: aload_1
    //   145: invokevirtual 280	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +33 -> 183
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -15 -> 144
    //   162: astore_1
    //   163: aload_0
    //   164: astore_3
    //   165: aload_1
    //   166: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   169: aload 4
    //   171: astore_1
    //   172: aload_0
    //   173: ifnull +55 -> 228
    //   176: aload_0
    //   177: invokevirtual 286	java/net/HttpURLConnection:disconnect	()V
    //   180: ldc 173
    //   182: areturn
    //   183: aload_1
    //   184: invokevirtual 287	java/io/BufferedReader:close	()V
    //   187: aload_2
    //   188: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_2
    //   192: aload_2
    //   193: astore_1
    //   194: aload_0
    //   195: ifnull +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 286	java/net/HttpURLConnection:disconnect	()V
    //   202: aload_2
    //   203: areturn
    //   204: astore_1
    //   205: aload_3
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 286	java/net/HttpURLConnection:disconnect	()V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: goto -11 -> 207
    //   221: astore_1
    //   222: aload 5
    //   224: astore_0
    //   225: goto -62 -> 163
    //   228: aload_1
    //   229: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramString1	String
    //   0	230	1	paramString2	String
    //   0	230	2	paramString3	String
    //   1	205	3	str1	String
    //   7	163	4	str2	String
    //   3	220	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	56	162	java/lang/Exception
    //   56	117	162	java/lang/Exception
    //   117	144	162	java/lang/Exception
    //   144	149	162	java/lang/Exception
    //   153	159	162	java/lang/Exception
    //   183	192	162	java/lang/Exception
    //   9	24	204	finally
    //   165	169	204	finally
    //   24	56	217	finally
    //   56	117	217	finally
    //   117	144	217	finally
    //   144	149	217	finally
    //   153	159	217	finally
    //   183	192	217	finally
    //   9	24	221	java/lang/Exception
  }
  
  public static boolean vl()
  {
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchDouble ***");
    }
    boolean bool = vl();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/dchat_test/cgi-bin/chatplay/onechat";; localObject = "https://play.mobile.qq.com/dchat/cgi-bin/chatplay/onechat")
    {
      paramVarArgs = new c(this.a, (String)localObject, paramInt1, paramInt2, paramInt3, paramVarArgs);
      localObject = (MatchTask)this.de.get(paramVarArgs.key);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchDouble: last matching not finished, dropped it!");
        }
        ((MatchTask)localObject).cancel();
      }
      localObject = new MatchTask(paramVarArgs);
      this.de.put(paramVarArgs.key, localObject);
      ((MatchTask)localObject).start();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    boolean bool = vl();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/grouppull";; localObject = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/grouppull")
    {
      localObject = new e(this.a, (String)localObject, paramInt1, paramInt2, paramString, paramInt3, paramLong);
      if ((MatchTask)this.de.get(((e)localObject).key) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb][pullhead] ====== pullMulti ====== type(" + paramInt2 + "), uin(" + paramString + "), groupId(" + paramLong + "), gender(" + paramInt3 + ")");
      }
      paramString = new MatchTask((b)localObject);
      this.de.put(((e)localObject).key, paramString);
      paramString.start();
      return;
    }
  }
  
  public void apK()
  {
    MatchTask localMatchTask = (MatchTask)this.de.get("[d] RequestDouble");
    if (localMatchTask != null) {
      localMatchTask.cancel();
    }
    localMatchTask = (MatchTask)this.de.get("[m] RequestMulti");
    if (localMatchTask != null) {
      localMatchTask.cancel();
    }
  }
  
  public void apL()
  {
    MatchTask localMatchTask = (MatchTask)this.de.get("[m] RequestMultiRoomOwner");
    if (localMatchTask != null) {
      localMatchTask.cancel();
    }
  }
  
  public void ba(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] ====== pullDouble ====== uin(" + paramString1 + "), url(" + paramString2 + ")");
    }
    new RandomWebProtocol.1(this, paramString2, paramString1).start();
  }
  
  /* Error */
  Bitmap c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 96
    //   8: iconst_2
    //   9: new 121	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 349
    //   19: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 351
    //   29: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 73	com/tencent/av/random/RandomWebProtocol:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   46: invokevirtual 354	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   49: aload_1
    //   50: iconst_1
    //   51: invokevirtual 359	com/tencent/av/VideoController:b	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull +60 -> 118
    //   61: aload 4
    //   63: astore 5
    //   65: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +39 -> 107
    //   71: ldc 96
    //   73: iconst_2
    //   74: new 121	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 361
    //   84: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 363
    //   94: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 4
    //   105: astore 5
    //   107: aload 5
    //   109: areturn
    //   110: astore 4
    //   112: aconst_null
    //   113: astore 4
    //   115: goto -59 -> 56
    //   118: new 121	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   125: invokestatic 368	jjy:hs	()Ljava/lang/String;
    //   128: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokestatic 373	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: aload_2
    //   140: ldc_w 375
    //   143: invokevirtual 379	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   146: invokevirtual 383	java/lang/String:substring	(I)Ljava/lang/String;
    //   149: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore 5
    //   157: aload 5
    //   159: invokestatic 389	ahbj:isFileExists	(Ljava/lang/String;)Z
    //   162: ifeq +107 -> 269
    //   165: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +40 -> 208
    //   171: ldc 96
    //   173: iconst_2
    //   174: new 121	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 391
    //   184: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 393
    //   194: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 5
    //   210: invokestatic 389	ahbj:isFileExists	(Ljava/lang/String;)Z
    //   213: istore_3
    //   214: aload 4
    //   216: astore_2
    //   217: iload_3
    //   218: ifeq +32 -> 250
    //   221: new 395	java/io/BufferedInputStream
    //   224: dup
    //   225: new 397	java/io/FileInputStream
    //   228: dup
    //   229: aload 5
    //   231: invokespecial 398	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   234: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   237: astore 4
    //   239: aload 4
    //   241: invokestatic 405	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   244: astore_2
    //   245: aload 4
    //   247: invokevirtual 406	java/io/BufferedInputStream:close	()V
    //   250: aload_2
    //   251: ifnull +145 -> 396
    //   254: aload_0
    //   255: getfield 73	com/tencent/av/random/RandomWebProtocol:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   258: invokevirtual 354	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   261: aload_1
    //   262: aload_2
    //   263: iconst_1
    //   264: invokevirtual 409	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   267: aload_2
    //   268: areturn
    //   269: new 411	java/io/File
    //   272: dup
    //   273: aload 5
    //   275: invokespecial 412	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore 6
    //   280: aload_0
    //   281: getfield 73	com/tencent/av/random/RandomWebProtocol:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   284: aload_2
    //   285: aload 6
    //   287: invokestatic 417	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   290: istore_3
    //   291: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq -86 -> 208
    //   297: ldc 96
    //   299: iconst_2
    //   300: new 121	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 391
    //   310: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 419
    //   320: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 421
    //   330: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 5
    //   335: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 423
    //   341: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: iload_3
    //   345: invokevirtual 426	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   348: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto -146 -> 208
    //   357: astore_2
    //   358: aload 4
    //   360: astore_2
    //   361: goto -111 -> 250
    //   364: astore_2
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -117 -> 250
    //   370: astore_2
    //   371: aconst_null
    //   372: astore_2
    //   373: goto -123 -> 250
    //   376: astore_2
    //   377: aload_0
    //   378: getfield 73	com/tencent/av/random/RandomWebProtocol:mApp	Lcom/tencent/av/app/VideoAppInterface;
    //   381: invokevirtual 354	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   384: aload_1
    //   385: aconst_null
    //   386: iconst_1
    //   387: invokevirtual 409	com/tencent/av/VideoController:a	(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V
    //   390: aload 4
    //   392: astore_2
    //   393: goto -143 -> 250
    //   396: aload_2
    //   397: astore 5
    //   399: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq -295 -> 107
    //   405: ldc 96
    //   407: iconst_2
    //   408: new 121	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 391
    //   418: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_1
    //   422: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 428
    //   428: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload_2
    //   438: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	RandomWebProtocol
    //   0	439	1	paramString1	String
    //   0	439	2	paramString2	String
    //   213	132	3	bool	boolean
    //   54	50	4	localBitmap	Bitmap
    //   110	1	4	localException	Exception
    //   113	278	4	localBufferedInputStream	java.io.BufferedInputStream
    //   63	335	5	localObject	Object
    //   278	8	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   42	56	110	java/lang/Exception
    //   118	208	357	java/lang/Exception
    //   208	214	357	java/lang/Exception
    //   269	354	357	java/lang/Exception
    //   221	250	364	java/lang/OutOfMemoryError
    //   221	250	370	java/lang/Exception
    //   118	208	376	java/lang/OutOfMemoryError
    //   208	214	376	java/lang/OutOfMemoryError
    //   269	354	376	java/lang/OutOfMemoryError
  }
  
  public void lv(int paramInt)
  {
    this.a.asr = paramInt;
  }
  
  public void s(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomWebProtocol", 2, "[randomWeb] *** matchMulti~ ***");
    }
    boolean bool = vl();
    if (bool) {
      QLog.w("RandomWebProtocol", 2, "[randomWeb]In Test Env");
    }
    if (bool) {}
    for (Object localObject = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/groupchat";; localObject = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/groupchat")
    {
      localObject = new d(this.a, (String)localObject, paramBoolean, paramInt);
      MatchTask localMatchTask = (MatchTask)this.de.get(((d)localObject).key);
      if (localMatchTask != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] matchMulti~: last matching not finished, dropped it!");
        }
        localMatchTask.cancel();
      }
      localMatchTask = new MatchTask((b)localObject);
      this.de.put(((d)localObject).key, localMatchTask);
      localMatchTask.start();
      return;
    }
  }
  
  public void v(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 5, null);
  }
  
  public boolean vk()
  {
    return this.a.asr != -1;
  }
  
  class MatchTask
    extends Thread
  {
    RandomWebProtocol.g a;
    RandomWebProtocol.b b;
    List<RandomWebProtocol.a> fs = new ArrayList();
    boolean isCancel = false;
    
    MatchTask(RandomWebProtocol.b paramb)
    {
      this.fs.addAll(RandomWebProtocol.this.listeners);
      this.b = paramb;
    }
    
    void cancel()
    {
      this.fs.clear();
      this.isCancel = true;
    }
    
    public void run()
    {
      this.a = null;
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[random room owner] realRequest.reqtype:" + this.b.reqtype);
      }
      if (this.b != null)
      {
        if (1 != this.b.reqtype) {
          break label106;
        }
        this.a = new RandomWebProtocol.h();
      }
      while ((this.b == null) || (this.a == null) || (TextUtils.isEmpty(this.b.url)))
      {
        t(true, -2);
        return;
        label106:
        if (2 == this.b.reqtype) {
          this.a = new RandomWebProtocol.j(RandomWebProtocol.this);
        } else if (3 == this.b.reqtype) {
          this.a = new RandomWebProtocol.k(RandomWebProtocol.this);
        } else if ((4 == this.b.reqtype) || (5 == this.b.reqtype)) {
          this.a = new RandomWebProtocol.l(RandomWebProtocol.this);
        }
      }
      String str1 = this.b.toJson();
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb] [random room owner][1v1] json post:" + str1);
      }
      if (this.isCancel)
      {
        t(false, -2);
        return;
      }
      long l = System.currentTimeMillis();
      if (System.currentTimeMillis() - l < this.a.asv)
      {
        if (this.isCancel)
        {
          t(false, -2);
          return;
        }
        String str2 = RandomWebProtocol.k(this.b.url, str1, null);
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb][random room owner][1v1] json result:" + str2);
        }
        this.a.aD(str2);
        int i = this.a.retcode;
        switch (i)
        {
        default: 
          i = 1;
        case 0: 
        case 1: 
        case 1000: 
        case 2: 
        case -1002: 
        case -1: 
        case 7: 
          while (i != 0)
          {
            try
            {
              Thread.sleep(this.a.asw);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            break;
            if (((this.a instanceof RandomWebProtocol.h)) && (i == 1))
            {
              t(true, 1);
              return;
            }
            t(true, 0);
            return;
            if ((this.a instanceof RandomWebProtocol.l)) {
              i = 1;
            } else {
              i = 0;
            }
          }
        case -1003: 
        case -1000: 
        case 6: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
          t(true, -2);
          return;
        case -1015: 
        case 13: 
          t(true, -3);
          return;
        case 4: 
          t(true, -1);
          return;
        }
        t(true, 100);
        return;
      }
      t(true, -1);
    }
    
    void t(boolean paramBoolean, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomWebProtocol", 2, "[randomWeb] quitMatch. result: " + paramInt);
      }
      if ((paramBoolean) && (!this.isCancel) && (this.a != null))
      {
        Iterator localIterator = this.fs.iterator();
        while (localIterator.hasNext()) {
          ((RandomWebProtocol.a)localIterator.next()).a(paramInt, this.a);
        }
      }
      cancel();
      if (this.b != null) {
        RandomWebProtocol.a(RandomWebProtocol.this).remove(this.b.key);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, RandomWebProtocol.g paramg);
  }
  
  class b
  {
    String Qb;
    String Qc;
    String Qd = "client";
    boolean Uu;
    int asr;
    String key;
    long mM;
    int reqtype;
    String url;
    JSONObject y;
    
    b()
    {
      this.reqtype = 0;
      String str = RandomWebProtocol.a(RandomWebProtocol.this).getAccount();
      this$1 = (TicketManager)RandomWebProtocol.a(RandomWebProtocol.this).getManager(2);
      if (RandomWebProtocol.this == null) {
        return;
      }
      this.Qb = "3.4.4";
      this.Uu = false;
      try
      {
        this.mM = Long.parseLong(str);
        this.Qc = RandomWebProtocol.this.getSkey(str);
        this.asr = -1;
        this.y = null;
        this.url = null;
        this.key = null;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          this.mM = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("RandomWebProtocol", 2, "[randomWeb] init Req error: failed parse self_uin: " + str);
          }
        }
      }
    }
    
    b(b paramb)
    {
      this.reqtype = paramb.reqtype;
      this.Qb = paramb.Qb;
      this.Uu = paramb.Uu;
      this.mM = paramb.mM;
      this.Qc = paramb.Qc;
      this.asr = paramb.asr;
      this.y = paramb.y;
      this.url = paramb.url;
      this.key = paramb.key;
      this.Qd = paramb.Qd;
    }
    
    String toJson()
    {
      if (this.reqtype == 0) {
        return "";
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("reqtype", this.reqtype).put("qqversion", this.Qb).put("isdebug", this.Uu).put("self_uin", this.mM).put("self_skey", this.Qc).put("self_gender", this.asr).put("reqbody", this.y);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return "";
    }
  }
  
  public class c
    extends RandomWebProtocol.b
  {
    String Qe;
    int ass;
    int reqtype;
    int session_type;
    
    c(RandomWebProtocol.b paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, String... paramVarArgs)
    {
      super(paramb);
      this.reqtype = 1;
      this.url = paramString;
      this.session_type = paramInt1;
      this.ass = paramInt2;
      this.reqtype = paramInt3;
      if ((this.reqtype == 2) && (paramVarArgs != null) && (paramVarArgs.length == 1)) {
        this.Qe = paramVarArgs[0];
      }
      this.key = "[d] RequestDouble";
    }
    
    String toJson()
    {
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject = localJSONObject1;
      for (;;)
      {
        try
        {
          this.y = new JSONObject().put("peer_gender", this.ass).put("session_type", this.session_type).put("reqtype", this.reqtype);
          localObject = localJSONObject1;
          if (this.reqtype == 2)
          {
            localObject = localJSONObject1;
            if (this.Qe != null)
            {
              localObject = localJSONObject1;
              this.y.put("uniqkey", this.Qe);
              localObject = localJSONObject1;
              JSONObject localJSONObject2 = new JSONObject(super.toJson());
              localObject = localJSONObject1;
              if (this.reqtype != 1) {
                break label178;
              }
              localObject = localJSONObject1;
              i = RandomWebProtocol.this.asq;
              localObject = localJSONObject1;
              localJSONObject1 = localJSONObject2.put("rand", i);
              localObject = localJSONObject1;
              return localJSONObject1.toString();
            }
          }
          localObject = localJSONObject1;
          if (this.reqtype != 1) {
            continue;
          }
          localObject = localJSONObject1;
          RandomWebProtocol.this.asq = new Random().nextInt();
          continue;
          localObject = localException;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return ((JSONObject)localObject).toString();
        }
        label178:
        int i = new Random().nextInt();
      }
    }
  }
  
  class d
    extends RandomWebProtocol.b
  {
    boolean Uv;
    int session_type;
    
    d(RandomWebProtocol.b paramb, String paramString, boolean paramBoolean, int paramInt)
    {
      super(paramb);
      this.reqtype = 2;
      this.url = paramString;
      this.Uv = paramBoolean;
      this.session_type = paramInt;
      this.key = "[m] RequestMulti";
    }
    
    String toJson()
    {
      this.y = null;
      try
      {
        this.y = new JSONObject().put("session_type", this.session_type);
        return super.toJson();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public class e
    extends RandomWebProtocol.b
  {
    String Qf;
    int ass;
    int ast;
    long mN;
    int session_type;
    
    e(RandomWebProtocol.b paramb, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, long paramLong)
    {
      super(paramb);
      this.reqtype = 3;
      this.url = paramString1;
      this.session_type = paramInt1;
      this.ast = paramInt2;
      this.Qf = paramString2;
      this.ass = paramInt3;
      this.mN = paramLong;
      this.key = ("[p]" + paramInt1 + paramInt2 + paramString2 + paramInt3 + paramLong);
    }
    
    String toJson()
    {
      this.y = null;
      try
      {
        this.y = new JSONObject().put("session_type", this.session_type).put("reqtype", this.ast).put("groupid", this.mN);
        if (2 == this.ast) {
          this.y.put("peer_enuin", ChatActivityUtils.aw(RandomWebProtocol.mSelfUin, this.Qf)).put("peer_gender", this.ass);
        }
        return super.toJson();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  class f
    extends RandomWebProtocol.b
  {
    public f(int paramInt1, long paramLong, int paramInt2, String paramString)
    {
      super();
      boolean bool = RandomWebProtocol.vl();
      this$1 = new JSONObject();
      try
      {
        RandomWebProtocol.this.put("session_type", paramInt1).put("groupid", paramLong);
        if (4 == paramInt2) {
          RandomWebProtocol.this.put("peer_enuin", ChatActivityUtils.aw(RandomWebProtocol.mSelfUin, paramString));
        }
      }
      catch (Exception paramString)
      {
        do
        {
          for (;;)
          {
            paramString.printStackTrace();
            continue;
            this$1 = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/getroomowner";
          }
        } while (paramInt2 != 4);
        if (!bool) {
          break label139;
        }
      }
      this.reqtype = paramInt2;
      this.y = RandomWebProtocol.this;
      this.Uu = bool;
      if (paramInt2 == 5) {
        if (bool)
        {
          this$1 = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/getroomowner";
          this.url = RandomWebProtocol.this;
          this.key = "[m] RequestMultiRoomOwner";
          return;
        }
      }
      label139:
      for (this$1 = "https://play.mobile.qq.com/randchat_test/cgi-bin/chatplay/multichatkick";; this$1 = "https://play.mobile.qq.com/randchat/cgi-bin/chatplay/multichatkick")
      {
        this.url = RandomWebProtocol.this;
        break;
      }
    }
  }
  
  public static class g
  {
    public int asu;
    int asv = 7000;
    int asw = 1000;
    int asx = 0;
    public String errmsg;
    int retcode;
    public JSONObject z;
    
    void aD(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("result");
        this.asu = paramString.optInt("rsptype", 0);
        this.retcode = paramString.optInt("retcode", -1);
        this.errmsg = paramString.optString("errmsg");
        this.z = paramString.optJSONObject("rspbody");
        paramString = paramString.optString("remain");
        try
        {
          this.asx = Integer.valueOf(paramString).intValue();
          return;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        return;
      }
      catch (Exception paramString)
      {
        this.retcode = 14;
        paramString.printStackTrace();
      }
    }
  }
  
  public static class h
    extends RandomWebProtocol.g
  {
    String Qf;
    String Qg;
    String Qh;
    String Qi;
    byte[] aY;
    int ass;
    int asy = -1;
    public int asz;
    Bitmap bg;
    String headurl;
    
    void aD(String paramString)
    {
      super.aD(paramString);
      if ((1 == this.asu) && (this.z != null))
      {
        if (this.retcode != 0) {
          break label205;
        }
        this.asy = this.z.optInt("ismask", -1);
        this.ass = this.z.optInt("peer_gender");
        this.Qg = aqhs.hexString2String(this.z.optString("peer_ennick", null));
        this.Qh = aqhs.hexString2String(this.z.optString("ensessionname", null));
        this.headurl = this.z.optString("headurl", null);
        if (!this.z.optBoolean("oldproto", false)) {
          break label164;
        }
        if (QLog.isColorLevel()) {
          QLog.w("RandomWebProtocol", 2, "[1v1] parse method is oldproto");
        }
        this.Qf = RandomWebProtocol.ds(this.z.optString("peer_enuin", null));
        this.aY = RandomWebProtocol.i(this.z.optString("vaskey", null));
      }
      label164:
      label205:
      while (this.retcode != 1)
      {
        return;
        this.Qf = ChatActivityUtils.c(RandomWebProtocol.mSelfUin, aqhs.hexStr2Bytes(this.z.optString("peer_enuin", null)));
        this.aY = aqhs.hexStr2Bytes(this.z.optString("vaskey", null));
        return;
      }
      this.asz = Math.max(this.z.optInt("waittime"), 200);
      this.Qi = this.z.optString("uniqkey", null);
    }
  }
  
  public class i
    extends RandomWebProtocol.g
  {
    public Bitmap bg;
    
    i()
    {
      this.asu = -100;
    }
  }
  
  class j
    extends RandomWebProtocol.g
  {
    String Qj;
    String Qk;
    boolean Uw;
    int asA = -1;
    int asy = -1;
    
    j() {}
    
    void aD(String paramString)
    {
      super.aD(paramString);
      if ((2 == this.asu) && (this.z != null))
      {
        this.asy = this.z.optInt("ismask", -1);
        this.Qj = this.z.optString("groupids");
        this.asA = this.z.optInt("businessid", -1);
        this.Qk = RandomWebProtocol.ds(this.z.optString("roomowner"));
        this.Uw = this.z.optBoolean("ownerenable", true);
      }
    }
  }
  
  public class k
    extends RandomWebProtocol.g
  {
    public String Qf;
    public String Qh;
    public String Ql;
    public int asB = 0;
    Bitmap bg;
    public String headurl;
    public long mM;
    
    k()
    {
      this.asv = 5000;
      this.asw = 900;
    }
    
    /* Error */
    void aD(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 42	com/tencent/av/random/RandomWebProtocol$g:aD	(Ljava/lang/String;)V
      //   5: iconst_3
      //   6: aload_0
      //   7: getfield 45	com/tencent/av/random/RandomWebProtocol$g:asu	I
      //   10: if_icmpne +175 -> 185
      //   13: aload_0
      //   14: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   17: ifnull +168 -> 185
      //   20: aload_0
      //   21: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   24: ldc 51
      //   26: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   29: ifeq +16 -> 45
      //   32: aload_0
      //   33: aload_0
      //   34: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   37: ldc 51
      //   39: invokevirtual 61	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   42: putfield 29	com/tencent/av/random/RandomWebProtocol$k:asB	I
      //   45: aload_0
      //   46: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   49: ldc 63
      //   51: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   54: ifeq +22 -> 76
      //   57: aload_0
      //   58: aload_0
      //   59: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   62: ldc 63
      //   64: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   67: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
      //   70: invokestatic 78	aqhs:hexString2String	(Ljava/lang/String;)Ljava/lang/String;
      //   73: putfield 80	com/tencent/av/random/RandomWebProtocol$k:Ql	Ljava/lang/String;
      //   76: aload_0
      //   77: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   80: ldc 81
      //   82: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   85: ifeq +16 -> 101
      //   88: aload_0
      //   89: aload_0
      //   90: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   93: ldc 81
      //   95: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   98: putfield 83	com/tencent/av/random/RandomWebProtocol$k:headurl	Ljava/lang/String;
      //   101: aload_0
      //   102: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   105: ldc 85
      //   107: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   110: ifeq +22 -> 132
      //   113: aload_0
      //   114: aload_0
      //   115: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   118: ldc 85
      //   120: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   123: invokestatic 78	aqhs:hexString2String	(Ljava/lang/String;)Ljava/lang/String;
      //   126: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
      //   129: putfield 87	com/tencent/av/random/RandomWebProtocol$k:Qh	Ljava/lang/String;
      //   132: aload_0
      //   133: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   136: ldc 89
      //   138: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   141: ifeq +16 -> 157
      //   144: aload_0
      //   145: aload_0
      //   146: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   149: ldc 89
      //   151: invokevirtual 93	org/json/JSONObject:getLong	(Ljava/lang/String;)J
      //   154: putfield 95	com/tencent/av/random/RandomWebProtocol$k:mM	J
      //   157: aload_0
      //   158: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   161: ldc 97
      //   163: invokevirtual 57	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   166: ifeq +19 -> 185
      //   169: aload_0
      //   170: aload_0
      //   171: getfield 49	com/tencent/av/random/RandomWebProtocol$g:z	Lorg/json/JSONObject;
      //   174: ldc 97
      //   176: invokevirtual 67	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   179: invokestatic 100	com/tencent/av/random/RandomWebProtocol:access$200	(Ljava/lang/String;)Ljava/lang/String;
      //   182: putfield 102	com/tencent/av/random/RandomWebProtocol$k:Qf	Ljava/lang/String;
      //   185: iconst_1
      //   186: aload_0
      //   187: getfield 29	com/tencent/av/random/RandomWebProtocol$k:asB	I
      //   190: if_icmpeq +19 -> 209
      //   193: iconst_3
      //   194: aload_0
      //   195: getfield 29	com/tencent/av/random/RandomWebProtocol$k:asB	I
      //   198: if_icmpeq +11 -> 209
      //   201: iconst_4
      //   202: aload_0
      //   203: getfield 29	com/tencent/av/random/RandomWebProtocol$k:asB	I
      //   206: if_icmpne +144 -> 350
      //   209: aload_0
      //   210: getfield 95	com/tencent/av/random/RandomWebProtocol$k:mM	J
      //   213: invokestatic 106	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   216: astore_2
      //   217: aload_2
      //   218: astore_1
      //   219: aload_2
      //   220: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   223: ifeq +14 -> 237
      //   226: aload_0
      //   227: getfield 24	com/tencent/av/random/RandomWebProtocol$k:this$0	Lcom/tencent/av/random/RandomWebProtocol;
      //   230: invokestatic 116	com/tencent/av/random/RandomWebProtocol:a	(Lcom/tencent/av/random/RandomWebProtocol;)Lcom/tencent/av/app/VideoAppInterface;
      //   233: invokevirtual 121	com/tencent/av/app/VideoAppInterface:getAccount	()Ljava/lang/String;
      //   236: astore_1
      //   237: iconst_2
      //   238: aload_0
      //   239: getfield 29	com/tencent/av/random/RandomWebProtocol$k:asB	I
      //   242: if_icmpne +8 -> 250
      //   245: aload_0
      //   246: getfield 102	com/tencent/av/random/RandomWebProtocol$k:Qf	Ljava/lang/String;
      //   249: astore_1
      //   250: aload_1
      //   251: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   254: ifne +32 -> 286
      //   257: aload_0
      //   258: getfield 80	com/tencent/av/random/RandomWebProtocol$k:Ql	Ljava/lang/String;
      //   261: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   264: ifne +22 -> 286
      //   267: aload_0
      //   268: getfield 24	com/tencent/av/random/RandomWebProtocol$k:this$0	Lcom/tencent/av/random/RandomWebProtocol;
      //   271: invokestatic 116	com/tencent/av/random/RandomWebProtocol:a	(Lcom/tencent/av/random/RandomWebProtocol;)Lcom/tencent/av/app/VideoAppInterface;
      //   274: invokevirtual 125	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
      //   277: aload_1
      //   278: aload_0
      //   279: getfield 80	com/tencent/av/random/RandomWebProtocol$k:Ql	Ljava/lang/String;
      //   282: iconst_1
      //   283: invokevirtual 131	com/tencent/av/VideoController:h	(Ljava/lang/String;Ljava/lang/String;Z)V
      //   286: aload_0
      //   287: getfield 83	com/tencent/av/random/RandomWebProtocol$k:headurl	Ljava/lang/String;
      //   290: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   293: ifne +40 -> 333
      //   296: aload_0
      //   297: getfield 83	com/tencent/av/random/RandomWebProtocol$k:headurl	Ljava/lang/String;
      //   300: ldc 133
      //   302: invokestatic 137	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
      //   305: ifne +28 -> 333
      //   308: aload_0
      //   309: aload_0
      //   310: getfield 24	com/tencent/av/random/RandomWebProtocol$k:this$0	Lcom/tencent/av/random/RandomWebProtocol;
      //   313: aload_1
      //   314: aload_0
      //   315: getfield 83	com/tencent/av/random/RandomWebProtocol$k:headurl	Ljava/lang/String;
      //   318: invokevirtual 141	com/tencent/av/random/RandomWebProtocol:c	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   321: putfield 143	com/tencent/av/random/RandomWebProtocol$k:bg	Landroid/graphics/Bitmap;
      //   324: return
      //   325: astore_1
      //   326: aload_1
      //   327: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   330: goto -145 -> 185
      //   333: aload_0
      //   334: aconst_null
      //   335: putfield 143	com/tencent/av/random/RandomWebProtocol$k:bg	Landroid/graphics/Bitmap;
      //   338: return
      //   339: astore_1
      //   340: aload_1
      //   341: invokevirtual 146	java/lang/Exception:printStackTrace	()V
      //   344: aload_0
      //   345: aconst_null
      //   346: putfield 143	com/tencent/av/random/RandomWebProtocol$k:bg	Landroid/graphics/Bitmap;
      //   349: return
      //   350: aconst_null
      //   351: astore_1
      //   352: goto -115 -> 237
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	355	0	this	k
      //   0	355	1	paramString	String
      //   216	4	2	str	String
      // Exception table:
      //   from	to	target	type
      //   20	45	325	java/lang/Exception
      //   45	76	325	java/lang/Exception
      //   76	101	325	java/lang/Exception
      //   101	132	325	java/lang/Exception
      //   132	157	325	java/lang/Exception
      //   157	185	325	java/lang/Exception
      //   185	209	339	java/lang/Exception
      //   209	217	339	java/lang/Exception
      //   219	237	339	java/lang/Exception
      //   237	250	339	java/lang/Exception
      //   250	286	339	java/lang/Exception
      //   286	324	339	java/lang/Exception
      //   333	338	339	java/lang/Exception
    }
  }
  
  public class l
    extends RandomWebProtocol.g
  {
    public String Qk;
    
    l() {}
    
    void aD(String paramString)
    {
      super.aD(paramString);
      if ((this.asu == 5) && (this.z != null)) {
        this.Qk = RandomWebProtocol.ds(this.z.optString("roomowner"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol
 * JD-Core Version:    0.7.0.1
 */