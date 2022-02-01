package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import anmc;
import anpc;
import aqdr;
import arwu;
import aszr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import imm;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import jll;

public class AVSoUtils
  extends Step
{
  private static String ceL = "";
  private static String ceM = "";
  
  public static String Af()
  {
    return ceL;
  }
  
  public static String Ag()
  {
    return ceM;
  }
  
  static void QJ(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      boolean bool2 = localFile.exists();
      boolean bool1 = false;
      if (bool2) {
        bool1 = localFile.delete();
      }
      QLog.w("AVModuleExtract", 1, "delSoFromCache, soPath[" + paramString + "], exist[" + bool2 + "], ret[" + bool1 + "]");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean a(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    QLog.d("AVModuleExtract", 1, "LoadExtractedSo begin, libName[" + paramString + "], seq[" + paramLong + "]");
    localObject1 = null;
    bool2 = false;
    bool1 = bool2;
    try
    {
      str1 = paramContext.getFilesDir().getParent() + "/txlib/" + getLibActualName(paramString);
      bool1 = bool2;
      localObject1 = str1;
      bool2 = new File(str1).exists();
      bool1 = bool2;
      localObject1 = str1;
      if (AudioHelper.aCz())
      {
        bool1 = bool2;
        localObject1 = str1;
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo, strLibPath[" + str1 + "], exists[" + bool2 + "], seq[" + paramLong + "]");
      }
      str3 = "";
      localObject6 = str1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str1;
        label201:
        label247:
        String str3 = QLog.getStackTraceString(localException1);
        label338:
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", localException1);
        bool2 = bool1;
        localObject6 = localObject1;
      }
    }
    try
    {
      System.load((String)localObject6);
      paramBoolean = true;
      str1 = "";
      localObject1 = "";
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      localObject1 = QLog.getStackTraceString(localUnsatisfiedLinkError2);
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo, Exception, seq[" + paramLong + "]", localUnsatisfiedLinkError2);
      localObject2 = new File((String)localObject6);
      if (!((File)localObject2).exists()) {
        break label891;
      }
      bool1 = ((File)localObject2).delete();
      if (!QLog.isDevelopLevel()) {
        break label818;
      }
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo, del file ret[" + bool1 + "], seq[" + paramLong + "]");
      for (;;)
      {
        for (;;)
        {
          paramBoolean = b(paramLong, paramContext, paramString, paramBoolean);
          QLog.w("AVModuleExtract", 1, "LoadExtractedSo, re extractLibraryFromAssert, bret[" + paramBoolean + "], seq[" + paramLong + "]");
          try
          {
            System.load((String)localObject6);
            localObject4 = "";
            localObject2 = localObject1;
            paramBoolean = true;
            localObject1 = localObject4;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
          {
            localObject3 = QLog.getStackTraceString(localUnsatisfiedLinkError1);
            QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", (Throwable)localObject4);
            localObject4 = localObject1;
            paramBoolean = false;
            localObject1 = localObject3;
            localObject3 = localObject4;
          }
        }
        QLog.w("AVModuleExtract", 1, "LoadExtractedSo file not exists, seq[" + paramLong + "]");
      }
      break label201;
      Object localObject4 = "";
      break label247;
    }
    if (!paramBoolean)
    {
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo,  system way. seq[" + paramLong + "]");
      try
      {
        System.loadLibrary(paramString);
        str2 = "";
        paramBoolean = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        for (;;)
        {
          String str2;
          boolean bool3;
          String str4;
          long l1;
          Object localObject5;
          localObject4 = QLog.getStackTraceString(localUnsatisfiedLinkError3);
          QLog.w("AVModuleExtract", 1, "LoadExtractedSo Exception, seq[" + paramLong + "]", localUnsatisfiedLinkError3);
        }
      }
      if (!paramBoolean)
      {
        bool3 = false;
        str4 = "";
        l1 = 0L;
        localObject5 = str4;
        bool1 = bool3;
      }
      try
      {
        File localFile = new File((String)localObject6);
        localObject5 = str4;
        bool1 = bool3;
        bool3 = localFile.exists();
        localObject5 = str4;
        bool1 = bool3;
        localObject6 = arwu.getFileMD5(localFile);
        localObject5 = localObject6;
        bool1 = bool3;
        long l2 = localFile.length();
        l1 = l2;
        bool1 = bool3;
        localObject5 = localObject6;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        Object localObject3;
        break label338;
      }
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo,  failed. seq[" + paramLong + "], msg1[" + str3 + "], msg2[" + str1 + "], msg3[" + (String)localObject1 + "], msg4[" + str2 + "]");
      localObject6 = new HashMap();
      ((HashMap)localObject6).put("soname", paramString);
      ((HashMap)localObject6).put("existFirst", String.valueOf(bool2));
      ((HashMap)localObject6).put("existLast", String.valueOf(bool1));
      ((HashMap)localObject6).put("md5", localObject5);
      ((HashMap)localObject6).put("fileLength", String.valueOf(l1));
      ((HashMap)localObject6).put("msg1", nz(str3));
      ((HashMap)localObject6).put("msg2", nz(str1));
      ((HashMap)localObject6).put("msg3", nz((String)localObject1));
      ((HashMap)localObject6).put("msg4", nz(str2));
      ((HashMap)localObject6).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject6).put("man", nz(Build.MANUFACTURER));
      ((HashMap)localObject6).put("mod", nz(Build.MODEL));
      ((HashMap)localObject6).put("qq_ver", String.valueOf(jll.mM()));
      anpc.a(paramContext).collectPerformance("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject6, "");
      QLog.w("AVModuleExtract", 1, "LoadExtractedSo end , result[" + paramBoolean + "], libName[" + paramString + "], seq[" + paramLong + "]");
      return paramBoolean;
    }
  }
  
  public static boolean ayu()
  {
    LoadExtResult localLoadExtResult = b("TcHevcDec");
    return (localLoadExtResult != null) && (localLoadExtResult.isSucc());
  }
  
  private static boolean ayv()
  {
    Object localObject = b("TcHevcEnc");
    if ((localObject != null) && (((LoadExtResult)localObject).isSucc())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = ((LoadExtResult)localObject).getSoLoadPath("TcHevcEnc");
        String str = ceL;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ceL = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(File.separator));
        }
        QLog.i("AVModuleExtract", 1, "loadAndDownloadSo. new HevcEncSoDir = " + ceL + ", old HevcEncSoDir = " + str);
      }
      return bool;
    }
  }
  
  private static boolean ayw()
  {
    Object localObject = b("TcHevcDec2");
    if ((localObject != null) && (((LoadExtResult)localObject).isSucc())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = ((LoadExtResult)localObject).getSoLoadPath("TcHevcDec2");
        String str = ceM;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ceM = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(File.separator));
        }
        QLog.i("AVModuleExtract", 1, "loadAndDownloadSo. new HevcDecSoDir = " + ceM + ", old HevcDecSoDir = " + str);
      }
      return bool;
    }
  }
  
  public static LoadExtResult b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    LoadExtResult localLoadExtResult = anmc.a().a(paramString);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder().append("loadAndDownloadSo. soName = ").append(paramString).append(", result = ").append(localLoadExtResult).append(", time len = ").append(l2 - l1).append(", so path = ");
    if (localLoadExtResult != null) {}
    for (paramString = localLoadExtResult.getSoLoadPath(paramString);; paramString = "null")
    {
      QLog.i("AVModuleExtract", 1, paramString);
      return localLoadExtResult;
    }
  }
  
  /* Error */
  public static boolean b(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 12
    //   9: aload_2
    //   10: ldc_w 323
    //   13: iconst_4
    //   14: invokevirtual 327	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   17: astore 33
    //   19: new 41	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   26: invokestatic 332	com/tencent/common/config/AppSetting:getRevision	()Ljava/lang/String;
    //   29: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 337	com/tencent/mobileqq/utils/SoLoadUtil:Ck	()Ljava/lang/String;
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 34
    //   43: new 41	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 339
    //   53: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 35
    //   65: new 41	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 341
    //   75: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokestatic 337	com/tencent/mobileqq/utils/SoLoadUtil:Ck	()Ljava/lang/String;
    //   81: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 36
    //   89: aload 33
    //   91: aload 35
    //   93: aload 36
    //   95: invokeinterface 347 3 0
    //   100: astore 15
    //   102: invokestatic 350	com/tencent/mobileqq/startup/step/AVSoUtils:getTxlibPath	()Ljava/lang/String;
    //   105: astore 37
    //   107: aload 37
    //   109: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore 14
    //   114: new 28	java/io/File
    //   117: dup
    //   118: new 41	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   125: aload 37
    //   127: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 32
    //   145: ldc 39
    //   147: iconst_1
    //   148: new 41	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 352
    //   158: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 354
    //   168: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 15
    //   173: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 356
    //   179: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 34
    //   184: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 358
    //   190: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload 4
    //   195: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   198: ldc_w 360
    //   201: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 14
    //   206: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: ldc_w 362
    //   212: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 32
    //   217: invokevirtual 34	java/io/File:exists	()Z
    //   220: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: ldc 74
    //   225: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: lload_0
    //   229: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   232: ldc 57
    //   234: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload 14
    //   245: ifeq +12 -> 257
    //   248: iconst_0
    //   249: istore 4
    //   251: ldc 2
    //   253: monitorexit
    //   254: iload 4
    //   256: ireturn
    //   257: aload 15
    //   259: aload 34
    //   261: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   264: ifeq +17 -> 281
    //   267: aload 32
    //   269: invokevirtual 34	java/io/File:exists	()Z
    //   272: ifeq +9 -> 281
    //   275: iconst_1
    //   276: istore 4
    //   278: goto -27 -> 251
    //   281: invokestatic 371	android/os/SystemClock:uptimeMillis	()J
    //   284: lstore 10
    //   286: aload 32
    //   288: invokevirtual 37	java/io/File:delete	()Z
    //   291: pop
    //   292: aload 32
    //   294: invokevirtual 34	java/io/File:exists	()Z
    //   297: ifne +1626 -> 1923
    //   300: iload 4
    //   302: ifeq +362 -> 664
    //   305: aload_2
    //   306: aload 37
    //   308: ldc_w 373
    //   311: aload_3
    //   312: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokestatic 376	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   318: istore 5
    //   320: aload 32
    //   322: invokevirtual 34	java/io/File:exists	()Z
    //   325: ifeq +282 -> 607
    //   328: iload 5
    //   330: ifeq +134 -> 464
    //   333: aload 32
    //   335: invokevirtual 37	java/io/File:delete	()Z
    //   338: pop
    //   339: iconst_0
    //   340: istore 4
    //   342: ldc 39
    //   344: iconst_1
    //   345: new 41	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 378
    //   355: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload 5
    //   360: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: ldc 74
    //   365: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: lload_0
    //   369: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   372: ldc 57
    //   374: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: invokestatic 371	android/os/SystemClock:uptimeMillis	()J
    //   386: lstore 6
    //   388: ldc 39
    //   390: iconst_1
    //   391: new 41	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   398: ldc_w 383
    //   401: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_3
    //   405: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 385
    //   411: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: lload 6
    //   416: lload 10
    //   418: lsub
    //   419: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc 104
    //   424: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 32
    //   429: invokevirtual 34	java/io/File:exists	()Z
    //   432: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   435: ldc 74
    //   437: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: lload_0
    //   441: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: ldc 57
    //   446: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto -204 -> 251
    //   458: astore_2
    //   459: ldc 2
    //   461: monitorexit
    //   462: aload_2
    //   463: athrow
    //   464: aload 34
    //   466: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifne +33 -> 502
    //   472: aload 34
    //   474: new 41	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 387
    //   484: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokestatic 337	com/tencent/mobileqq/utils/SoLoadUtil:Ck	()Ljava/lang/String;
    //   490: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   499: ifeq +83 -> 582
    //   502: aload 33
    //   504: invokeinterface 391 1 0
    //   509: aload 35
    //   511: aload 36
    //   513: invokeinterface 397 3 0
    //   518: invokeinterface 400 1 0
    //   523: pop
    //   524: ldc 39
    //   526: iconst_1
    //   527: new 41	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 402
    //   537: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 35
    //   542: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc_w 404
    //   548: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 34
    //   553: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc 74
    //   558: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: lload_0
    //   562: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: ldc 57
    //   567: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: iconst_1
    //   577: istore 4
    //   579: goto -196 -> 383
    //   582: aload 33
    //   584: invokeinterface 391 1 0
    //   589: aload 35
    //   591: aload 34
    //   593: invokeinterface 397 3 0
    //   598: invokeinterface 400 1 0
    //   603: pop
    //   604: goto -80 -> 524
    //   607: ldc 39
    //   609: iconst_1
    //   610: new 41	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 406
    //   620: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: iload 5
    //   625: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: ldc 104
    //   630: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: iconst_0
    //   634: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   637: ldc 74
    //   639: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: lload_0
    //   643: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: ldc 57
    //   648: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: iload 12
    //   659: istore 4
    //   661: goto -278 -> 383
    //   664: aconst_null
    //   665: astore 31
    //   667: aconst_null
    //   668: astore 24
    //   670: aconst_null
    //   671: astore 25
    //   673: aconst_null
    //   674: astore 26
    //   676: aconst_null
    //   677: astore 23
    //   679: aconst_null
    //   680: astore 30
    //   682: aconst_null
    //   683: astore 15
    //   685: aconst_null
    //   686: astore 16
    //   688: aconst_null
    //   689: astore 28
    //   691: aconst_null
    //   692: astore 29
    //   694: aconst_null
    //   695: astore 27
    //   697: aload 28
    //   699: astore 20
    //   701: aload 23
    //   703: astore 18
    //   705: aload 24
    //   707: astore 22
    //   709: aload 29
    //   711: astore 19
    //   713: aload 30
    //   715: astore 17
    //   717: aload 25
    //   719: astore 21
    //   721: new 28	java/io/File
    //   724: dup
    //   725: aload 37
    //   727: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   730: astore 38
    //   732: aload 28
    //   734: astore 20
    //   736: aload 23
    //   738: astore 18
    //   740: aload 24
    //   742: astore 22
    //   744: aload 29
    //   746: astore 19
    //   748: aload 30
    //   750: astore 17
    //   752: aload 25
    //   754: astore 21
    //   756: aload 38
    //   758: invokevirtual 34	java/io/File:exists	()Z
    //   761: ifne +47 -> 808
    //   764: aload 28
    //   766: astore 20
    //   768: aload 23
    //   770: astore 18
    //   772: aload 24
    //   774: astore 22
    //   776: aload 29
    //   778: astore 19
    //   780: aload 30
    //   782: astore 17
    //   784: aload 25
    //   786: astore 21
    //   788: aload 38
    //   790: invokevirtual 409	java/io/File:mkdir	()Z
    //   793: istore 4
    //   795: iload 13
    //   797: istore 12
    //   799: aload 31
    //   801: astore 17
    //   803: iload 4
    //   805: ifeq +625 -> 1430
    //   808: aload 28
    //   810: astore 20
    //   812: aload 23
    //   814: astore 18
    //   816: aload 24
    //   818: astore 22
    //   820: aload 29
    //   822: astore 19
    //   824: aload 30
    //   826: astore 17
    //   828: aload 25
    //   830: astore 21
    //   832: aload_2
    //   833: invokevirtual 413	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   836: new 41	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   843: invokestatic 416	com/tencent/mobileqq/startup/step/AVSoUtils:getLibPath	()Ljava/lang/String;
    //   846: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_3
    //   850: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   853: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokevirtual 422	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   862: astore 15
    //   864: aload 27
    //   866: astore 16
    //   868: aload 26
    //   870: astore_2
    //   871: aload 15
    //   873: ifnull +58 -> 931
    //   876: aload 16
    //   878: astore 20
    //   880: aload 15
    //   882: astore 18
    //   884: aload 24
    //   886: astore 22
    //   888: aload 16
    //   890: astore 19
    //   892: aload 15
    //   894: astore 17
    //   896: aload 25
    //   898: astore 21
    //   900: new 424	java/io/FileOutputStream
    //   903: dup
    //   904: new 41	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   911: aload 37
    //   913: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload_3
    //   917: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   920: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: iconst_1
    //   927: invokespecial 427	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   930: astore_2
    //   931: lconst_0
    //   932: lstore 6
    //   934: aload 16
    //   936: astore 20
    //   938: aload 15
    //   940: astore 18
    //   942: aload_2
    //   943: astore 22
    //   945: aload 16
    //   947: astore 19
    //   949: aload 15
    //   951: astore 17
    //   953: aload_2
    //   954: astore 21
    //   956: sipush 8192
    //   959: newarray byte
    //   961: astore 23
    //   963: lload 6
    //   965: lstore 8
    //   967: aload 15
    //   969: ifnull +234 -> 1203
    //   972: aload 16
    //   974: astore 20
    //   976: aload 15
    //   978: astore 18
    //   980: aload_2
    //   981: astore 22
    //   983: aload 16
    //   985: astore 19
    //   987: aload 15
    //   989: astore 17
    //   991: aload_2
    //   992: astore 21
    //   994: aload 15
    //   996: aload 23
    //   998: iconst_0
    //   999: aload 23
    //   1001: arraylength
    //   1002: invokevirtual 433	java/io/InputStream:read	([BII)I
    //   1005: istore 5
    //   1007: lload 6
    //   1009: lstore 8
    //   1011: iload 5
    //   1013: iconst_m1
    //   1014: if_icmpeq +189 -> 1203
    //   1017: aload 16
    //   1019: astore 20
    //   1021: aload 15
    //   1023: astore 18
    //   1025: aload_2
    //   1026: astore 22
    //   1028: aload 16
    //   1030: astore 19
    //   1032: aload 15
    //   1034: astore 17
    //   1036: aload_2
    //   1037: astore 21
    //   1039: aload_2
    //   1040: aload 23
    //   1042: iconst_0
    //   1043: iload 5
    //   1045: invokevirtual 439	java/io/OutputStream:write	([BII)V
    //   1048: lload 6
    //   1050: iload 5
    //   1052: i2l
    //   1053: ladd
    //   1054: lstore 6
    //   1056: goto -93 -> 963
    //   1059: astore 15
    //   1061: aconst_null
    //   1062: astore 17
    //   1064: aconst_null
    //   1065: astore 18
    //   1067: aload 28
    //   1069: astore 20
    //   1071: aload 24
    //   1073: astore 22
    //   1075: aload 29
    //   1077: astore 19
    //   1079: aload 25
    //   1081: astore 21
    //   1083: aload_2
    //   1084: invokevirtual 413	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1087: new 41	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1094: invokestatic 416	com/tencent/mobileqq/startup/step/AVSoUtils:getLibPath	()Ljava/lang/String;
    //   1097: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: aload_3
    //   1101: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   1104: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: ldc_w 441
    //   1110: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokevirtual 422	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1119: astore 23
    //   1121: aload 27
    //   1123: astore 16
    //   1125: aload 23
    //   1127: astore 15
    //   1129: aload 23
    //   1131: ifnull -263 -> 868
    //   1134: aload 28
    //   1136: astore 20
    //   1138: aload 23
    //   1140: astore 18
    //   1142: aload 24
    //   1144: astore 22
    //   1146: aload 29
    //   1148: astore 19
    //   1150: aload 23
    //   1152: astore 17
    //   1154: aload 25
    //   1156: astore 21
    //   1158: aload_2
    //   1159: invokevirtual 413	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1162: new 41	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1169: invokestatic 416	com/tencent/mobileqq/startup/step/AVSoUtils:getLibPath	()Ljava/lang/String;
    //   1172: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: aload_3
    //   1176: invokestatic 95	com/tencent/mobileqq/startup/step/AVSoUtils:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   1179: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: ldc_w 443
    //   1185: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1191: invokevirtual 422	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1194: astore 16
    //   1196: aload 23
    //   1198: astore 15
    //   1200: goto -332 -> 868
    //   1203: aload 16
    //   1205: ifnull +86 -> 1291
    //   1208: aload 16
    //   1210: astore 20
    //   1212: aload 15
    //   1214: astore 18
    //   1216: aload_2
    //   1217: astore 22
    //   1219: aload 16
    //   1221: astore 19
    //   1223: aload 15
    //   1225: astore 17
    //   1227: aload_2
    //   1228: astore 21
    //   1230: aload 16
    //   1232: aload 23
    //   1234: iconst_0
    //   1235: aload 23
    //   1237: arraylength
    //   1238: invokevirtual 433	java/io/InputStream:read	([BII)I
    //   1241: istore 5
    //   1243: iload 5
    //   1245: iconst_m1
    //   1246: if_icmpeq +45 -> 1291
    //   1249: aload 16
    //   1251: astore 20
    //   1253: aload 15
    //   1255: astore 18
    //   1257: aload_2
    //   1258: astore 22
    //   1260: aload 16
    //   1262: astore 19
    //   1264: aload 15
    //   1266: astore 17
    //   1268: aload_2
    //   1269: astore 21
    //   1271: aload_2
    //   1272: aload 23
    //   1274: iconst_0
    //   1275: iload 5
    //   1277: invokevirtual 439	java/io/OutputStream:write	([BII)V
    //   1280: lload 8
    //   1282: iload 5
    //   1284: i2l
    //   1285: ladd
    //   1286: lstore 8
    //   1288: goto -85 -> 1203
    //   1291: aload 16
    //   1293: astore 20
    //   1295: aload 15
    //   1297: astore 18
    //   1299: aload_2
    //   1300: astore 22
    //   1302: aload 16
    //   1304: astore 19
    //   1306: aload 15
    //   1308: astore 17
    //   1310: aload_2
    //   1311: astore 21
    //   1313: aload 32
    //   1315: invokevirtual 34	java/io/File:exists	()Z
    //   1318: ifeq +509 -> 1827
    //   1321: aload 16
    //   1323: astore 20
    //   1325: aload 15
    //   1327: astore 18
    //   1329: aload_2
    //   1330: astore 22
    //   1332: aload 16
    //   1334: astore 19
    //   1336: aload 15
    //   1338: astore 17
    //   1340: aload_2
    //   1341: astore 21
    //   1343: lload 8
    //   1345: aload 32
    //   1347: invokevirtual 124	java/io/File:length	()J
    //   1350: lcmp
    //   1351: ifeq +128 -> 1479
    //   1354: aload 16
    //   1356: astore 20
    //   1358: aload 15
    //   1360: astore 18
    //   1362: aload_2
    //   1363: astore 22
    //   1365: aload 16
    //   1367: astore 19
    //   1369: aload 15
    //   1371: astore 17
    //   1373: aload_2
    //   1374: astore 21
    //   1376: aload 32
    //   1378: invokevirtual 37	java/io/File:delete	()Z
    //   1381: pop
    //   1382: aload 16
    //   1384: astore 19
    //   1386: aload 15
    //   1388: astore 17
    //   1390: aload_2
    //   1391: astore 21
    //   1393: ldc 39
    //   1395: iconst_1
    //   1396: new 41	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 445
    //   1406: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: lload_0
    //   1410: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1413: ldc 57
    //   1415: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1421: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1424: iconst_0
    //   1425: istore 12
    //   1427: aload_2
    //   1428: astore 17
    //   1430: aload 17
    //   1432: ifnull +8 -> 1440
    //   1435: aload 17
    //   1437: invokevirtual 448	java/io/OutputStream:close	()V
    //   1440: aload 15
    //   1442: ifnull +8 -> 1450
    //   1445: aload 15
    //   1447: invokevirtual 449	java/io/InputStream:close	()V
    //   1450: iload 12
    //   1452: istore 4
    //   1454: aload 16
    //   1456: ifnull -1073 -> 383
    //   1459: aload 16
    //   1461: invokevirtual 449	java/io/InputStream:close	()V
    //   1464: iload 12
    //   1466: istore 4
    //   1468: goto -1085 -> 383
    //   1471: astore_2
    //   1472: iload 12
    //   1474: istore 4
    //   1476: goto -1093 -> 383
    //   1479: aload 16
    //   1481: astore 20
    //   1483: aload 15
    //   1485: astore 18
    //   1487: aload_2
    //   1488: astore 22
    //   1490: aload 16
    //   1492: astore 19
    //   1494: aload 15
    //   1496: astore 17
    //   1498: aload_2
    //   1499: astore 21
    //   1501: aload 34
    //   1503: invokestatic 270	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1506: ifne +36 -> 1542
    //   1509: aload 16
    //   1511: astore 20
    //   1513: aload 15
    //   1515: astore 18
    //   1517: aload_2
    //   1518: astore 22
    //   1520: aload 16
    //   1522: astore 19
    //   1524: aload 15
    //   1526: astore 17
    //   1528: aload_2
    //   1529: astore 21
    //   1531: aload 34
    //   1533: ldc_w 387
    //   1536: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1539: ifeq +130 -> 1669
    //   1542: aload 16
    //   1544: astore 20
    //   1546: aload 15
    //   1548: astore 18
    //   1550: aload_2
    //   1551: astore 22
    //   1553: aload 16
    //   1555: astore 19
    //   1557: aload 15
    //   1559: astore 17
    //   1561: aload_2
    //   1562: astore 21
    //   1564: aload 33
    //   1566: invokeinterface 391 1 0
    //   1571: aload 35
    //   1573: aload 36
    //   1575: invokeinterface 397 3 0
    //   1580: invokeinterface 400 1 0
    //   1585: pop
    //   1586: aload 16
    //   1588: astore 20
    //   1590: aload 15
    //   1592: astore 18
    //   1594: aload_2
    //   1595: astore 22
    //   1597: aload 16
    //   1599: astore 19
    //   1601: aload 15
    //   1603: astore 17
    //   1605: aload_2
    //   1606: astore 21
    //   1608: ldc 39
    //   1610: iconst_1
    //   1611: new 41	java/lang/StringBuilder
    //   1614: dup
    //   1615: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1618: ldc_w 451
    //   1621: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: aload 35
    //   1626: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: ldc_w 404
    //   1632: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: aload 34
    //   1637: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: ldc 74
    //   1642: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: lload_0
    //   1646: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1649: ldc 57
    //   1651: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1657: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1660: iconst_1
    //   1661: istore 12
    //   1663: aload_2
    //   1664: astore 17
    //   1666: goto -236 -> 1430
    //   1669: aload 16
    //   1671: astore 20
    //   1673: aload 15
    //   1675: astore 18
    //   1677: aload_2
    //   1678: astore 22
    //   1680: aload 16
    //   1682: astore 19
    //   1684: aload 15
    //   1686: astore 17
    //   1688: aload_2
    //   1689: astore 21
    //   1691: aload 33
    //   1693: invokeinterface 391 1 0
    //   1698: aload 35
    //   1700: aload 34
    //   1702: invokeinterface 397 3 0
    //   1707: invokeinterface 400 1 0
    //   1712: pop
    //   1713: goto -127 -> 1586
    //   1716: astore 17
    //   1718: aload 22
    //   1720: astore_2
    //   1721: aload 18
    //   1723: astore 15
    //   1725: aload 20
    //   1727: astore 16
    //   1729: aload 17
    //   1731: astore 18
    //   1733: iconst_0
    //   1734: istore 12
    //   1736: aload 16
    //   1738: astore 19
    //   1740: aload 15
    //   1742: astore 17
    //   1744: aload_2
    //   1745: astore 21
    //   1747: ldc 39
    //   1749: iconst_1
    //   1750: new 41	java/lang/StringBuilder
    //   1753: dup
    //   1754: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1757: ldc_w 453
    //   1760: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: lload_0
    //   1764: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1767: ldc 57
    //   1769: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1775: aload 18
    //   1777: invokestatic 226	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1780: aload_2
    //   1781: ifnull +7 -> 1788
    //   1784: aload_2
    //   1785: invokevirtual 448	java/io/OutputStream:close	()V
    //   1788: aload 15
    //   1790: ifnull +8 -> 1798
    //   1793: aload 15
    //   1795: invokevirtual 449	java/io/InputStream:close	()V
    //   1798: iload 12
    //   1800: istore 4
    //   1802: aload 16
    //   1804: ifnull -1421 -> 383
    //   1807: aload 16
    //   1809: invokevirtual 449	java/io/InputStream:close	()V
    //   1812: iload 12
    //   1814: istore 4
    //   1816: goto -1433 -> 383
    //   1819: astore_2
    //   1820: iload 12
    //   1822: istore 4
    //   1824: goto -1441 -> 383
    //   1827: aload 16
    //   1829: astore 20
    //   1831: aload 15
    //   1833: astore 18
    //   1835: aload_2
    //   1836: astore 22
    //   1838: aload 16
    //   1840: astore 19
    //   1842: aload 15
    //   1844: astore 17
    //   1846: aload_2
    //   1847: astore 21
    //   1849: ldc 39
    //   1851: iconst_1
    //   1852: new 41	java/lang/StringBuilder
    //   1855: dup
    //   1856: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1859: ldc_w 455
    //   1862: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: lload_0
    //   1866: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1869: ldc 57
    //   1871: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1880: iload 13
    //   1882: istore 12
    //   1884: aload_2
    //   1885: astore 17
    //   1887: goto -457 -> 1430
    //   1890: astore_2
    //   1891: aload 21
    //   1893: ifnull +8 -> 1901
    //   1896: aload 21
    //   1898: invokevirtual 448	java/io/OutputStream:close	()V
    //   1901: aload 17
    //   1903: ifnull +8 -> 1911
    //   1906: aload 17
    //   1908: invokevirtual 449	java/io/InputStream:close	()V
    //   1911: aload 19
    //   1913: ifnull +8 -> 1921
    //   1916: aload 19
    //   1918: invokevirtual 449	java/io/InputStream:close	()V
    //   1921: aload_2
    //   1922: athrow
    //   1923: ldc 39
    //   1925: iconst_1
    //   1926: new 41	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   1933: ldc_w 457
    //   1936: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: lload_0
    //   1940: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1943: ldc 57
    //   1945: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1951: invokestatic 66	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1954: iload 12
    //   1956: istore 4
    //   1958: goto -1575 -> 383
    //   1961: astore_2
    //   1962: goto -522 -> 1440
    //   1965: astore_2
    //   1966: goto -516 -> 1450
    //   1969: astore_2
    //   1970: goto -182 -> 1788
    //   1973: astore_2
    //   1974: goto -176 -> 1798
    //   1977: astore_3
    //   1978: goto -77 -> 1901
    //   1981: astore_3
    //   1982: goto -71 -> 1911
    //   1985: astore_3
    //   1986: goto -65 -> 1921
    //   1989: astore 18
    //   1991: goto -258 -> 1733
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1994	0	paramLong	long
    //   0	1994	2	paramContext	Context
    //   0	1994	3	paramString	String
    //   0	1994	4	paramBoolean	boolean
    //   318	965	5	i	int
    //   386	669	6	l1	long
    //   965	379	8	l2	long
    //   284	133	10	l3	long
    //   7	1948	12	bool1	boolean
    //   4	1877	13	bool2	boolean
    //   112	132	14	bool3	boolean
    //   100	933	15	localObject1	Object
    //   1059	1	15	localFileNotFoundException	java.io.FileNotFoundException
    //   1127	716	15	localObject2	Object
    //   686	1153	16	localObject3	Object
    //   715	972	17	localObject4	Object
    //   1716	14	17	localIOException1	java.io.IOException
    //   1742	165	17	localObject5	Object
    //   703	1131	18	localObject6	Object
    //   1989	1	18	localIOException2	java.io.IOException
    //   711	1206	19	localObject7	Object
    //   699	1131	20	localObject8	Object
    //   719	1178	21	localObject9	Object
    //   707	1130	22	localObject10	Object
    //   677	596	23	localObject11	Object
    //   668	475	24	localObject12	Object
    //   671	484	25	localObject13	Object
    //   674	195	26	localObject14	Object
    //   695	427	27	localObject15	Object
    //   689	446	28	localObject16	Object
    //   692	455	29	localObject17	Object
    //   680	145	30	localObject18	Object
    //   665	135	31	localObject19	Object
    //   143	1234	32	localFile1	File
    //   17	1675	33	localSharedPreferences	SharedPreferences
    //   41	1660	34	str1	String
    //   63	1636	35	str2	String
    //   87	1487	36	str3	String
    //   105	807	37	str4	String
    //   730	59	38	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   9	243	458	finally
    //   257	275	458	finally
    //   281	300	458	finally
    //   305	328	458	finally
    //   333	339	458	finally
    //   342	383	458	finally
    //   383	455	458	finally
    //   464	502	458	finally
    //   502	524	458	finally
    //   524	576	458	finally
    //   582	604	458	finally
    //   607	657	458	finally
    //   1435	1440	458	finally
    //   1445	1450	458	finally
    //   1459	1464	458	finally
    //   1784	1788	458	finally
    //   1793	1798	458	finally
    //   1807	1812	458	finally
    //   1896	1901	458	finally
    //   1906	1911	458	finally
    //   1916	1921	458	finally
    //   1921	1923	458	finally
    //   1923	1954	458	finally
    //   832	864	1059	java/io/FileNotFoundException
    //   1459	1464	1471	java/io/IOException
    //   721	732	1716	java/io/IOException
    //   756	764	1716	java/io/IOException
    //   788	795	1716	java/io/IOException
    //   832	864	1716	java/io/IOException
    //   900	931	1716	java/io/IOException
    //   956	963	1716	java/io/IOException
    //   994	1007	1716	java/io/IOException
    //   1039	1048	1716	java/io/IOException
    //   1083	1121	1716	java/io/IOException
    //   1158	1196	1716	java/io/IOException
    //   1230	1243	1716	java/io/IOException
    //   1271	1280	1716	java/io/IOException
    //   1313	1321	1716	java/io/IOException
    //   1343	1354	1716	java/io/IOException
    //   1376	1382	1716	java/io/IOException
    //   1501	1509	1716	java/io/IOException
    //   1531	1542	1716	java/io/IOException
    //   1564	1586	1716	java/io/IOException
    //   1608	1660	1716	java/io/IOException
    //   1691	1713	1716	java/io/IOException
    //   1849	1880	1716	java/io/IOException
    //   1807	1812	1819	java/io/IOException
    //   721	732	1890	finally
    //   756	764	1890	finally
    //   788	795	1890	finally
    //   832	864	1890	finally
    //   900	931	1890	finally
    //   956	963	1890	finally
    //   994	1007	1890	finally
    //   1039	1048	1890	finally
    //   1083	1121	1890	finally
    //   1158	1196	1890	finally
    //   1230	1243	1890	finally
    //   1271	1280	1890	finally
    //   1313	1321	1890	finally
    //   1343	1354	1890	finally
    //   1376	1382	1890	finally
    //   1393	1424	1890	finally
    //   1501	1509	1890	finally
    //   1531	1542	1890	finally
    //   1564	1586	1890	finally
    //   1608	1660	1890	finally
    //   1691	1713	1890	finally
    //   1747	1780	1890	finally
    //   1849	1880	1890	finally
    //   1435	1440	1961	java/io/IOException
    //   1445	1450	1965	java/io/IOException
    //   1784	1788	1969	java/io/IOException
    //   1793	1798	1973	java/io/IOException
    //   1896	1901	1977	java/io/IOException
    //   1906	1911	1981	java/io/IOException
    //   1916	1921	1985	java/io/IOException
    //   1393	1424	1989	java/io/IOException
  }
  
  public static boolean c(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(0L, paramContext, paramString, paramBoolean);
  }
  
  public static boolean d(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = b(0L, paramContext, paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  static void dRF()
  {
    if (!BaseApplicationImpl.isCurrentVersionFirstLaunch) {
      return;
    }
    if (imm.getCpuArchitecture() <= 2) {}
    for (int i = 1;; i = 0)
    {
      String str = getTxlibPath();
      Object localObject1;
      if (i != 0)
      {
        localObject1 = new String[3];
        localObject1[0] = "libTcVpxDec-armeabi.so";
        localObject1[1] = "libTcVpxEnc-armeabi.so";
        localObject1[2] = "libtraeimp-armeabi.so";
      }
      for (;;)
      {
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(Arrays.asList((Object[])localObject1));
        ((ArrayList)localObject2).addAll(Arrays.asList(new String[] { "libSDKCommon.so", "libVideoCtrl.so", "libtraeimp-qq.so", "libqav_graphics.so", "libqav_gaudio_engine.so", "libqav_utils.so", "libqav_media_engine.so", "libhwcodec.so", "libTcVpxEnc.so", "libTcVpxDec.so" }));
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          QJ(str + (String)localObject2);
        }
        break;
        localObject1 = new String[5];
        localObject1[0] = "libTcHevcDec.so";
        localObject1[1] = "libTcHevcDec2.so";
        localObject1[2] = "libTcHevcEnc.so";
        localObject1[3] = "libtraeopus-armeabi.so";
        localObject1[4] = "libtraeopus-armeabi-v7a.so";
      }
    }
  }
  
  public static void dRG()
  {
    String str = getTxlibPath();
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("DecodeSo").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libTcHevcDec.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libTcHevcDec2.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libtraeimp-qq.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libqav_graphics.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libqav_gaudio_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libqav_utils.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libqav_media_engine.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libSDKCommon.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libVideoCtrl.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libxplatform.so").toString()));
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libc++_shared.so").toString()));
    str = aqdr.getSoLibPath(BaseApplicationImpl.sApplication);
    QLog.w("AVModuleExtract", 1, "printSO, " + ny(new StringBuilder().append(str).append("libc++_shared.so").toString()));
  }
  
  private static void dRH()
  {
    Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.appStartTime);
    }
    String str = "first_qq_lauch_" + AppSetting.getRevision();
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.appStartTime > 0L) {}
    for (long l = BaseApplicationImpl.appStartTime;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong(str, l).commit();
      return;
    }
  }
  
  public static void dRI()
  {
    if ((TextUtils.isEmpty(Af())) || (TextUtils.isEmpty(Ag())))
    {
      ayv();
      ayw();
      return;
    }
    ThreadManager.excute(new AVSoUtils.1(), 16, null, false);
  }
  
  public static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String getLibPath()
  {
    return "lib/armeabi/";
  }
  
  public static String getTxlibPath()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVModuleExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  public static void lx(long paramLong)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    b(paramLong, localBaseApplicationImpl, "SDKCommon", true);
    b(paramLong, localBaseApplicationImpl, "VideoCtrl", true);
    b(paramLong, localBaseApplicationImpl, "traeimp-qq", true);
    b(paramLong, localBaseApplicationImpl, "qav_graphics", true);
    b(paramLong, localBaseApplicationImpl, "qav_gaudio_engine", true);
    b(paramLong, localBaseApplicationImpl, "qav_utils", true);
    b(paramLong, localBaseApplicationImpl, "qav_media_engine", true);
  }
  
  public static String ny(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      String str1 = aszr.getFileMD5String(localFile);
      paramString = "[" + paramString + "], exists[" + localFile.exists();
      return paramString + "], md5[" + str1 + "]";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "Exception";
      }
    }
  }
  
  public static String nz(String paramString)
  {
    return paramString.replace("=", "@1").replace("&", "@2").replace("|", "@3").replace("\"", "@6");
  }
  
  protected boolean doStep()
  {
    dRF();
    lx(-1046L);
    dRH();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.AVSoUtils
 * JD-Core Version:    0.7.0.1
 */