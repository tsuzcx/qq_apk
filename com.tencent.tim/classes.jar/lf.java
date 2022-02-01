import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.etrump.mixlayout.VasShieldFont.1;
import com.etrump.mixlayout.VasShieldFont.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class lf
{
  private static AtomicBoolean P = new AtomicBoolean(false);
  private static AtomicBoolean R = new AtomicBoolean(false);
  private static AtomicBoolean T = new AtomicBoolean(false);
  private static Typeface b;
  public static Typeface c;
  private static boolean cJ;
  public static final String eF = "default_font" + File.separator;
  public static String eG;
  private static String eI;
  public static int iN = -1;
  public static int iO;
  public static int iP;
  private static int iQ;
  
  static
  {
    eG = "";
    iO = -1;
    iP = -1;
    iQ = -1;
    cJ = true;
  }
  
  public static String V()
  {
    if (TextUtils.isEmpty(eI)) {
      eI = aqnl.getSoDir() + eF + "default.ttf";
    }
    return eI;
  }
  
  public static Typeface a()
  {
    if ((iP != 0) || (iQ > 0) || (iO < 1)) {
      return c;
    }
    return b;
  }
  
  public static Typeface a(MessageRecord paramMessageRecord)
  {
    if ((iO < 1) || (paramMessageRecord == null)) {
      return Typeface.DEFAULT;
    }
    if ((paramMessageRecord.isSend()) && (iQ > 0)) {
      return c;
    }
    if (TextHook.getInstance().isDefault()) {
      return b;
    }
    return Typeface.DEFAULT;
  }
  
  public static Typeface a(String paramString)
  {
    if (iO < 1) {
      return null;
    }
    if (TextHook.getInstance().isDefault()) {
      return b;
    }
    return Typeface.DEFAULT;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = ku.dV + File.separator + "default.zip";
      if (!ahbj.isFileExists(str)) {}
    }
    try
    {
      aqhq.W(str, aqnl.getSoDir() + eF, false);
      s(paramQQAppInterface);
      P.set(false);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("VasShieldFont", 2, "uncompress zip failed", localIOException);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = acfp.m(2131716321);
    int i = ((String)localObject).length();
    paramString = new ahwa(paramString, eG, (String)localObject, paramInt, -5020, 1179653, anaz.gQ());
    paramString.lw = new int[] { 1179653 };
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", aqqj.getUrl("myFont"));
    paramString.addHightlightItem(i - 7, i - 3, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
    ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        if (iO >= 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VasShieldFont", 2, "loadDefaultFont: user not uses color font.");
      return;
      if (R.compareAndSet(false, true)) {
        ThreadManager.excute(new VasShieldFont.1(paramQQAppInterface, paramMqqHandler), 64, null, true);
      }
    } while ((paramMqqHandler == null) || (paramSessionInfo == null) || (!cJ) || (iO <= 0) || (iN <= 1) || (iP != 0));
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "loadDefaultFont: ShowGrayTip: sSysColorFont=" + iO + " sDefaultFontType=" + iN);
    }
    paramMqqHandler.removeMessages(87);
    paramMqqHandler.sendEmptyMessage(87);
    ThreadManager.getTimer().schedule(new VasShieldFont.2(paramQQAppInterface, paramSessionInfo), 2000L);
  }
  
  public static int aA()
  {
    if (iQ < 0) {
      iQ = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt("keySysFontSetting", 0);
    }
    return iQ;
  }
  
  public static int aC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "hasSysColorFont: defaultFontType=" + iN + " sysColorFont=" + iO + " sUserFontId=" + iP);
    }
    if ((iN > 1) && (iP == 0)) {
      return iO;
    }
    return 0;
  }
  
  /* Error */
  private static boolean aG()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 9
    //   13: new 26	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   20: invokestatic 86	aqnl:getSoDir	()Ljava/lang/String;
    //   23: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 46	lf:eF	Ljava/lang/String;
    //   29: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 10
    //   37: new 37	java/io/File
    //   40: dup
    //   41: new 26	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   48: aload 10
    //   50: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 321
    //   56: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 12
    //   67: new 37	java/io/File
    //   70: dup
    //   71: invokestatic 326	lf:V	()Ljava/lang/String;
    //   74: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 11
    //   79: ldc 50
    //   81: astore 4
    //   83: aload 12
    //   85: invokevirtual 329	java/io/File:exists	()Z
    //   88: ifeq +623 -> 711
    //   91: aload 12
    //   93: invokevirtual 332	java/io/File:isFile	()Z
    //   96: ifeq +615 -> 711
    //   99: new 334	java/io/InputStreamReader
    //   102: dup
    //   103: new 336	java/io/FileInputStream
    //   106: dup
    //   107: aload 12
    //   109: invokespecial 339	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   112: ldc_w 341
    //   115: invokespecial 344	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   118: astore_3
    //   119: new 346	java/io/BufferedReader
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 349	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   127: astore_1
    //   128: aload_2
    //   129: astore 4
    //   131: aload_1
    //   132: astore 5
    //   134: aload_3
    //   135: astore 7
    //   137: aload_1
    //   138: invokevirtual 352	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore_2
    //   142: aload_2
    //   143: astore 4
    //   145: aload_1
    //   146: astore_2
    //   147: aload_3
    //   148: astore_1
    //   149: aload 4
    //   151: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +88 -> 242
    //   157: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +47 -> 207
    //   163: ldc 148
    //   165: iconst_2
    //   166: new 26	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 354
    //   176: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 12
    //   181: invokevirtual 329	java/io/File:exists	()Z
    //   184: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: ldc_w 359
    //   190: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 12
    //   195: invokevirtual 332	java/io/File:isFile	()Z
    //   198: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 10
    //   209: invokestatic 362	aqhq:cn	(Ljava/lang/String;)V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 365	java/io/BufferedReader:close	()V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   228: iconst_0
    //   229: ifeq +11 -> 240
    //   232: new 368	java/lang/NullPointerException
    //   235: dup
    //   236: invokespecial 369	java/lang/NullPointerException:<init>	()V
    //   239: athrow
    //   240: iload_0
    //   241: ireturn
    //   242: aload 11
    //   244: invokevirtual 329	java/io/File:exists	()Z
    //   247: ifeq +153 -> 400
    //   250: aload 11
    //   252: invokevirtual 332	java/io/File:isFile	()Z
    //   255: ifeq +145 -> 400
    //   258: new 336	java/io/FileInputStream
    //   261: dup
    //   262: aload 11
    //   264: invokespecial 339	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   267: astore_3
    //   268: aload_3
    //   269: aload 11
    //   271: invokevirtual 371	java/io/File:length	()J
    //   274: invokestatic 377	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   277: invokestatic 383	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:bytesToHexString	([B)Ljava/lang/String;
    //   280: astore 5
    //   282: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +41 -> 326
    //   288: ldc 148
    //   290: iconst_2
    //   291: new 26	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 385
    //   301: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 5
    //   306: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 387
    //   312: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 4
    //   317: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aload 5
    //   328: aload 4
    //   330: invokevirtual 391	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: istore_0
    //   334: iload_0
    //   335: ifeq +34 -> 369
    //   338: iconst_1
    //   339: istore_0
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 365	java/io/BufferedReader:close	()V
    //   348: aload_1
    //   349: ifnull +7 -> 356
    //   352: aload_1
    //   353: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   356: aload_3
    //   357: ifnull -117 -> 240
    //   360: aload_3
    //   361: invokevirtual 392	java/io/FileInputStream:close	()V
    //   364: iconst_1
    //   365: ireturn
    //   366: astore_1
    //   367: iconst_1
    //   368: ireturn
    //   369: aload_2
    //   370: ifnull +7 -> 377
    //   373: aload_2
    //   374: invokevirtual 365	java/io/BufferedReader:close	()V
    //   377: aload_1
    //   378: ifnull +7 -> 385
    //   381: aload_1
    //   382: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   385: aload_3
    //   386: ifnull +7 -> 393
    //   389: aload_3
    //   390: invokevirtual 392	java/io/FileInputStream:close	()V
    //   393: aload 10
    //   395: invokestatic 362	aqhq:cn	(Ljava/lang/String;)V
    //   398: iconst_0
    //   399: ireturn
    //   400: aload 9
    //   402: astore_3
    //   403: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq -37 -> 369
    //   409: ldc 148
    //   411: iconst_2
    //   412: new 26	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 394
    //   422: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 11
    //   427: invokevirtual 329	java/io/File:exists	()Z
    //   430: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   433: ldc_w 359
    //   436: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 11
    //   441: invokevirtual 332	java/io/File:isFile	()Z
    //   444: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   447: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 235	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload 9
    //   455: astore_3
    //   456: goto -87 -> 369
    //   459: astore 4
    //   461: aload_1
    //   462: astore_3
    //   463: aload_2
    //   464: astore_1
    //   465: aload 4
    //   467: astore_2
    //   468: aload 6
    //   470: astore 4
    //   472: aload_1
    //   473: astore 5
    //   475: aload_3
    //   476: astore 7
    //   478: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +23 -> 504
    //   484: aload 6
    //   486: astore 4
    //   488: aload_1
    //   489: astore 5
    //   491: aload_3
    //   492: astore 7
    //   494: ldc 148
    //   496: iconst_2
    //   497: ldc_w 396
    //   500: aload_2
    //   501: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: aload_1
    //   505: ifnull +7 -> 512
    //   508: aload_1
    //   509: invokevirtual 365	java/io/BufferedReader:close	()V
    //   512: aload_3
    //   513: ifnull +7 -> 520
    //   516: aload_3
    //   517: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   520: aload 6
    //   522: ifnull -129 -> 393
    //   525: aload 6
    //   527: invokevirtual 392	java/io/FileInputStream:close	()V
    //   530: goto -137 -> 393
    //   533: astore_1
    //   534: goto -141 -> 393
    //   537: astore_3
    //   538: aconst_null
    //   539: astore_2
    //   540: aconst_null
    //   541: astore_1
    //   542: aload 8
    //   544: astore 4
    //   546: aload_2
    //   547: ifnull +7 -> 554
    //   550: aload_2
    //   551: invokevirtual 365	java/io/BufferedReader:close	()V
    //   554: aload_1
    //   555: ifnull +7 -> 562
    //   558: aload_1
    //   559: invokevirtual 366	java/io/InputStreamReader:close	()V
    //   562: aload 4
    //   564: ifnull +8 -> 572
    //   567: aload 4
    //   569: invokevirtual 392	java/io/FileInputStream:close	()V
    //   572: aload_3
    //   573: athrow
    //   574: astore_2
    //   575: goto -355 -> 220
    //   578: astore_1
    //   579: goto -351 -> 228
    //   582: astore_1
    //   583: iconst_0
    //   584: ireturn
    //   585: astore_2
    //   586: goto -238 -> 348
    //   589: astore_1
    //   590: goto -234 -> 356
    //   593: astore_2
    //   594: goto -217 -> 377
    //   597: astore_1
    //   598: goto -213 -> 385
    //   601: astore_1
    //   602: goto -209 -> 393
    //   605: astore_1
    //   606: goto -94 -> 512
    //   609: astore_1
    //   610: goto -90 -> 520
    //   613: astore_2
    //   614: goto -60 -> 554
    //   617: astore_1
    //   618: goto -56 -> 562
    //   621: astore_1
    //   622: goto -50 -> 572
    //   625: astore 4
    //   627: aload_3
    //   628: astore_1
    //   629: aconst_null
    //   630: astore_2
    //   631: aload 4
    //   633: astore_3
    //   634: aload 8
    //   636: astore 4
    //   638: goto -92 -> 546
    //   641: astore_3
    //   642: aload 7
    //   644: astore_1
    //   645: aload 5
    //   647: astore_2
    //   648: goto -102 -> 546
    //   651: astore_3
    //   652: aload 8
    //   654: astore 4
    //   656: goto -110 -> 546
    //   659: astore 5
    //   661: aload_3
    //   662: astore 4
    //   664: aload 5
    //   666: astore_3
    //   667: goto -121 -> 546
    //   670: astore_2
    //   671: aconst_null
    //   672: astore_1
    //   673: aconst_null
    //   674: astore_3
    //   675: goto -207 -> 468
    //   678: astore_2
    //   679: aconst_null
    //   680: astore_1
    //   681: goto -213 -> 468
    //   684: astore_2
    //   685: goto -217 -> 468
    //   688: astore 6
    //   690: aload_2
    //   691: astore 5
    //   693: aload_1
    //   694: astore 4
    //   696: aload 6
    //   698: astore_2
    //   699: aload_3
    //   700: astore 6
    //   702: aload 5
    //   704: astore_1
    //   705: aload 4
    //   707: astore_3
    //   708: goto -240 -> 468
    //   711: aconst_null
    //   712: astore_2
    //   713: aconst_null
    //   714: astore_1
    //   715: goto -566 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	339	0	bool	boolean
    //   127	226	1	localObject1	Object
    //   366	96	1	localException1	Exception
    //   464	45	1	localObject2	Object
    //   533	1	1	localException2	Exception
    //   541	18	1	localObject3	Object
    //   578	1	1	localException3	Exception
    //   582	1	1	localException4	Exception
    //   589	1	1	localException5	Exception
    //   597	1	1	localException6	Exception
    //   601	1	1	localException7	Exception
    //   605	1	1	localException8	Exception
    //   609	1	1	localException9	Exception
    //   617	1	1	localException10	Exception
    //   621	1	1	localException11	Exception
    //   628	87	1	localObject4	Object
    //   9	542	2	localObject5	Object
    //   574	1	2	localException12	Exception
    //   585	1	2	localException13	Exception
    //   593	1	2	localException14	Exception
    //   613	1	2	localException15	Exception
    //   630	18	2	localObject6	Object
    //   670	1	2	localException16	Exception
    //   678	1	2	localException17	Exception
    //   684	7	2	localException18	Exception
    //   698	15	2	localException19	Exception
    //   118	399	3	localObject7	Object
    //   537	91	3	localObject8	Object
    //   633	1	3	localObject9	Object
    //   641	1	3	localObject10	Object
    //   651	11	3	localObject11	Object
    //   666	42	3	localObject12	Object
    //   81	248	4	localObject13	Object
    //   459	7	4	localException20	Exception
    //   470	98	4	localObject14	Object
    //   625	7	4	localObject15	Object
    //   636	70	4	localObject16	Object
    //   132	514	5	localObject17	Object
    //   659	6	5	localObject18	Object
    //   691	12	5	localException21	Exception
    //   3	523	6	localObject19	Object
    //   688	9	6	localException22	Exception
    //   700	1	6	localObject20	Object
    //   135	508	7	localObject21	Object
    //   6	647	8	localObject22	Object
    //   11	443	9	localObject23	Object
    //   35	359	10	str	String
    //   77	363	11	localFile1	File
    //   65	129	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   360	364	366	java/lang/Exception
    //   149	207	459	java/lang/Exception
    //   207	212	459	java/lang/Exception
    //   242	268	459	java/lang/Exception
    //   403	453	459	java/lang/Exception
    //   525	530	533	java/lang/Exception
    //   37	79	537	finally
    //   83	119	537	finally
    //   216	220	574	java/lang/Exception
    //   224	228	578	java/lang/Exception
    //   232	240	582	java/lang/Exception
    //   344	348	585	java/lang/Exception
    //   352	356	589	java/lang/Exception
    //   373	377	593	java/lang/Exception
    //   381	385	597	java/lang/Exception
    //   389	393	601	java/lang/Exception
    //   508	512	605	java/lang/Exception
    //   516	520	609	java/lang/Exception
    //   550	554	613	java/lang/Exception
    //   558	562	617	java/lang/Exception
    //   567	572	621	java/lang/Exception
    //   119	128	625	finally
    //   137	142	641	finally
    //   478	484	641	finally
    //   494	504	641	finally
    //   149	207	651	finally
    //   207	212	651	finally
    //   242	268	651	finally
    //   403	453	651	finally
    //   268	326	659	finally
    //   326	334	659	finally
    //   37	79	670	java/lang/Exception
    //   83	119	670	java/lang/Exception
    //   119	128	678	java/lang/Exception
    //   137	142	684	java/lang/Exception
    //   268	326	688	java/lang/Exception
    //   326	334	688	java/lang/Exception
  }
  
  public static void d(TextView paramTextView)
  {
    int m = 1;
    if (iO < 0) {}
    for (;;)
    {
      int i;
      try
      {
        paramTextView.setDrawingCacheEnabled(true);
        Bitmap localBitmap = paramTextView.getDrawingCache();
        c = paramTextView.getTypeface();
        int n = paramTextView.getCurrentTextColor();
        if (localBitmap == null) {
          break label239;
        }
        if (localBitmap.isRecycled())
        {
          break label239;
          iO = i;
          if (QLog.isColorLevel()) {
            QLog.d("VasShieldFont", 2, "checkColorFont: sSysColorFont=" + iO);
          }
          paramTextView.setDrawingCacheEnabled(false);
          if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            break;
          }
          ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class).sendEmptyMessage(1060);
          return;
        }
        i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int[] arrayOfInt = new int[i * j];
        localBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
        j = 0;
        i = 0;
        k = i;
        if (j >= arrayOfInt.length) {
          break label241;
        }
        k = arrayOfInt[j];
        int i1 = k & 0xFFFFFF;
        k = i;
        if (i1 != 0)
        {
          k = i;
          if (i1 != (n & 0xFFFFFF)) {
            k = 1;
          }
        }
        j += 1;
        i = k;
        continue;
        i = 0;
        continue;
        paramTextView.setVisibility(8);
      }
      catch (Exception paramTextView)
      {
        QLog.e("VasShieldFont", 2, "checkSysColorFont: ", paramTextView);
        return;
      }
      return;
      label239:
      int k = 0;
      label241:
      if (k != 0) {
        i = m;
      }
    }
  }
  
  private static void eV()
  {
    if (ahbj.isFileExists(V())) {}
    switch (iN)
    {
    case 4: 
    default: 
      return;
    }
    try
    {
      b = Typeface.createFromFile(V());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VasShieldFont", 2, "createFromFile:", localException);
    }
  }
  
  public static void eW()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aqnl.H((AppInterface)localObject);
      localObject = ((QQAppInterface)localObject).getHandler(ChatActivity.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(87);
        ((MqqHandler)localObject).sendEmptyMessage(87);
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("VasShieldFont", 2, "refreshAIO: " + BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static void s(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, null, null);
  }
  
  private static void t(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (P.get()) {
      return;
    }
    P.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "downloadDefaultFont");
    }
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(1004L, "defaultFont_775", "defaultFont");
  }
  
  public static boolean w(int paramInt)
  {
    if (paramInt > -1)
    {
      iQ = paramInt;
      eW();
      return BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("keySysFontSetting", paramInt).commit();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lf
 * JD-Core Version:    0.7.0.1
 */