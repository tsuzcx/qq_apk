package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import gix;
import giy;
import java.util.HashMap;
import mqq.app.NewIntent;

public class AppLaucherHelper
{
  public static final int a = 1;
  protected static long a = 0L;
  public static boolean a = false;
  public static final int b = 2;
  public static String b;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public static final int g = 64;
  public static final int h = 128;
  public static final int i = 256;
  public Handler a;
  public String a;
  public HashMap a;
  public NewIntent a;
  public boolean b;
  protected int j = 0;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AppLaucherHelper()
  {
    this.jdField_a_of_type_MqqAppNewIntent = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
  {
    int m = 0;
    if (paramString.contains("$OPID$")) {
      m = 1;
    }
    int k = m;
    if (paramString.contains("$AT$")) {
      k = m | 0x2;
    }
    m = k;
    if (paramString.contains("$PT$")) {
      m = k | 0x4;
    }
    k = m;
    if (paramString.contains("$PF$")) {
      k = m | 0x40;
    }
    m = k;
    if (paramString.contains("$ESK$")) {
      m = k | 0x80;
    }
    return m;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localBundle;
      paramString = paramString.split("&");
    } while (paramString == null);
    int m = paramString.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = paramString[k];
      int n = localObject.indexOf('=');
      if (n != -1) {}
      try
      {
        localBundle.putString(localObject.substring(0, n), localObject.substring(n + 1));
        k += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  /* Error */
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: new 125	giz
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   8: aload 5
    //   10: aload_2
    //   11: iload 7
    //   13: invokespecial 134	giz:<init>	(Lcom/tencent/mobileqq/service/gamecenter/AppLaucherHelper;JLjava/lang/String;Landroid/content/Context;I)V
    //   16: astore 14
    //   18: aload_0
    //   19: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   22: ifnonnull +17 -> 39
    //   25: aload_0
    //   26: new 136	mqq/app/NewIntent
    //   29: dup
    //   30: aload_2
    //   31: ldc 138
    //   33: invokespecial 141	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: putfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   39: new 143	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest
    //   42: dup
    //   43: invokespecial 144	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:<init>	()V
    //   46: astore 15
    //   48: lconst_0
    //   49: lstore 9
    //   51: aload_1
    //   52: invokevirtual 148	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   55: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: lstore 11
    //   60: lload 11
    //   62: lstore 9
    //   64: aload 15
    //   66: getfield 158	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:uin	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   69: lload 9
    //   71: invokevirtual 164	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   74: lconst_0
    //   75: lstore 9
    //   77: aload_3
    //   78: invokestatic 154	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 11
    //   83: lload 11
    //   85: lstore 9
    //   87: aload 15
    //   89: getfield 167	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:client_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   92: lload 9
    //   94: invokevirtual 164	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   97: aload 15
    //   99: getfield 171	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:pf	Lcom/tencent/mobileqq/pb/PBStringField;
    //   102: ldc 41
    //   104: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   107: aload_2
    //   108: invokestatic 181	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   111: astore_3
    //   112: aload 15
    //   114: getfield 184	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:qqv	Lcom/tencent/mobileqq/pb/PBStringField;
    //   117: aload_3
    //   118: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   121: aload 15
    //   123: getfield 187	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sdkp	Lcom/tencent/mobileqq/pb/PBStringField;
    //   126: ldc 188
    //   128: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   131: getstatic 193	android/os/Build:DISPLAY	Ljava/lang/String;
    //   134: astore_3
    //   135: aload 15
    //   137: getfield 196	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:os	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: aload_3
    //   141: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 199	com/tencent/common/app/AppInterface:getSid	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload 15
    //   151: getfield 202	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   154: aload_3
    //   155: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   158: aload 15
    //   160: getfield 205	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:skey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   163: aload 6
    //   165: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   168: ldc 41
    //   170: astore_3
    //   171: aload_1
    //   172: instanceof 207
    //   175: ifeq +65 -> 240
    //   178: aload_1
    //   179: checkcast 207	com/tencent/mobileqq/app/QQAppInterface
    //   182: invokevirtual 209	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   185: astore_3
    //   186: aload_3
    //   187: astore 6
    //   189: aload_3
    //   190: ifnonnull +7 -> 197
    //   193: ldc 41
    //   195: astore 6
    //   197: aload 15
    //   199: getfield 212	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:vkey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   202: aload 6
    //   204: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   207: aload 4
    //   209: invokestatic 214	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)I
    //   212: istore 8
    //   214: iload 8
    //   216: ifne +42 -> 258
    //   219: aload_2
    //   220: aload 5
    //   222: aload_0
    //   223: getfield 216	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokestatic 218	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   229: iload 7
    //   231: invokestatic 221	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   234: pop
    //   235: iconst_0
    //   236: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   239: return
    //   240: aload_1
    //   241: instanceof 223
    //   244: ifeq -58 -> 186
    //   247: aload_1
    //   248: checkcast 223	com/tencent/mobileqq/app/BrowserAppInterface
    //   251: invokevirtual 225	com/tencent/mobileqq/app/BrowserAppInterface:b	()Ljava/lang/String;
    //   254: astore_3
    //   255: goto -69 -> 186
    //   258: aload 15
    //   260: getfield 229	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:flags	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   263: iload 8
    //   265: invokevirtual 234	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   268: ldc 41
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: aload_2
    //   276: invokevirtual 240	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   279: aload 5
    //   281: bipush 64
    //   283: invokevirtual 246	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   286: getfield 252	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   289: astore 16
    //   291: aload 4
    //   293: astore_3
    //   294: aload 16
    //   296: ifnull +77 -> 373
    //   299: aload 4
    //   301: astore 6
    //   303: aload 4
    //   305: astore_3
    //   306: ldc 254
    //   308: invokestatic 260	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   311: astore 13
    //   313: aload 4
    //   315: astore 6
    //   317: aload 4
    //   319: astore_3
    //   320: aload 13
    //   322: aload 16
    //   324: iconst_0
    //   325: aaload
    //   326: invokevirtual 266	android/content/pm/Signature:toByteArray	()[B
    //   329: invokevirtual 270	java/security/MessageDigest:update	([B)V
    //   332: aload 4
    //   334: astore 6
    //   336: aload 4
    //   338: astore_3
    //   339: aload 13
    //   341: invokevirtual 273	java/security/MessageDigest:digest	()[B
    //   344: invokestatic 278	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   347: astore 4
    //   349: aload 4
    //   351: invokevirtual 281	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   354: astore_3
    //   355: aload_3
    //   356: astore 4
    //   358: aload 4
    //   360: astore 6
    //   362: aload 4
    //   364: astore_3
    //   365: aload 13
    //   367: invokevirtual 284	java/security/MessageDigest:reset	()V
    //   370: aload 4
    //   372: astore_3
    //   373: aload_3
    //   374: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifeq +69 -> 446
    //   380: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +17 -> 400
    //   386: aload_0
    //   387: invokevirtual 292	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 297	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   393: iconst_2
    //   394: ldc_w 299
    //   397: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iconst_0
    //   401: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   404: aload_2
    //   405: aload 5
    //   407: aload_0
    //   408: getfield 216	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   411: invokestatic 218	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   414: iload 7
    //   416: invokestatic 221	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   419: pop
    //   420: return
    //   421: astore 13
    //   423: aload 6
    //   425: astore 4
    //   427: aload 4
    //   429: astore_3
    //   430: aload 13
    //   432: invokevirtual 305	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   435: aload 4
    //   437: astore_3
    //   438: goto -65 -> 373
    //   441: astore 4
    //   443: goto -70 -> 373
    //   446: aload 15
    //   448: getfield 308	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:apk_sign	Lcom/tencent/mobileqq/pb/PBStringField;
    //   451: aload_3
    //   452: invokevirtual 176	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   455: aload_0
    //   456: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   459: ldc_w 310
    //   462: ldc_w 312
    //   465: invokevirtual 316	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   468: pop
    //   469: aload_0
    //   470: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   473: ldc_w 318
    //   476: aload 15
    //   478: invokevirtual 319	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:toByteArray	()[B
    //   481: invokevirtual 322	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   484: pop
    //   485: aload_0
    //   486: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   489: aload 14
    //   491: invokevirtual 326	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   494: aload_1
    //   495: aload_0
    //   496: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   499: invokevirtual 330	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   502: aload_0
    //   503: getfield 51	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   506: iconst_0
    //   507: ldc2_w 331
    //   510: invokevirtual 338	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   513: pop
    //   514: return
    //   515: astore_1
    //   516: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +18 -> 537
    //   522: aload_0
    //   523: invokevirtual 292	java/lang/Object:getClass	()Ljava/lang/Class;
    //   526: invokevirtual 297	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   529: iconst_2
    //   530: aload_1
    //   531: invokevirtual 115	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   534: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: iconst_0
    //   538: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   541: return
    //   542: astore_3
    //   543: goto -456 -> 87
    //   546: astore_3
    //   547: aload 4
    //   549: astore_3
    //   550: goto -177 -> 373
    //   553: astore 13
    //   555: goto -128 -> 427
    //   558: astore 13
    //   560: goto -496 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	AppLaucherHelper
    //   0	563	1	paramAppInterface	AppInterface
    //   0	563	2	paramContext	Context
    //   0	563	3	paramString1	String
    //   0	563	4	paramString2	String
    //   0	563	5	paramString3	String
    //   0	563	6	paramString4	String
    //   0	563	7	paramInt	int
    //   212	52	8	k	int
    //   49	44	9	l1	long
    //   58	26	11	l2	long
    //   311	55	13	localMessageDigest	java.security.MessageDigest
    //   421	10	13	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   553	1	13	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   558	1	13	localException	Exception
    //   16	474	14	localgiz	giz
    //   46	431	15	localAuthorizeRequest	com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest
    //   289	34	16	arrayOfSignature	android.content.pm.Signature[]
    // Exception table:
    //   from	to	target	type
    //   306	313	421	java/security/NoSuchAlgorithmException
    //   320	332	421	java/security/NoSuchAlgorithmException
    //   339	349	421	java/security/NoSuchAlgorithmException
    //   365	370	421	java/security/NoSuchAlgorithmException
    //   275	291	441	java/lang/Exception
    //   306	313	441	java/lang/Exception
    //   320	332	441	java/lang/Exception
    //   339	349	441	java/lang/Exception
    //   365	370	441	java/lang/Exception
    //   430	435	441	java/lang/Exception
    //   469	485	515	java/lang/Exception
    //   77	83	542	java/lang/Exception
    //   349	355	546	java/lang/Exception
    //   349	355	553	java/security/NoSuchAlgorithmException
    //   51	60	558	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new gix(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {}
    long l;
    for (this.jdField_a_of_type_JavaLangString = paramString2.substring(1);; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      l = System.currentTimeMillis();
      if ((l - jdField_a_of_type_Long >= 3600000L) || (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))) {
        break;
      }
      QLog.d(AppLaucherHelper.class.getSimpleName(), 2, "use cache");
      a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, jdField_b_of_type_JavaLangString, paramInt);
      return true;
    }
    jdField_a_of_type_Long = l;
    new LoginHelper(paramContext, paramAppInterface, new giy(this, paramAppInterface, paramContext, paramString1, paramString2, paramString3, paramInt));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper
 * JD-Core Version:    0.7.0.1
 */