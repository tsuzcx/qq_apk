package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SoLoadUtil
{
  private static Set<String> di = new HashSet();
  private static SimpleDateFormat sFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  static
  {
    di.add("libamrnb.so");
    di.add("libcodecsilk.so");
  }
  
  public static String Ck()
  {
    return "_32";
  }
  
  private static native int Decode(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static final void L(HashMap<String, String> paramHashMap)
  {
    anpc.a(BaseApplication.getContext()).collectPerformance("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    Object localObject = paramContext;
    if (paramContext == null) {}
    for (;;)
    {
      String str1;
      try
      {
        localObject = BaseApplicationImpl.getContext();
        paramContext = new File(paramString1);
        if (!paramContext.exists()) {
          paramContext.mkdir();
        }
        str1 = paramString1 + "tmp_" + BaseApplicationImpl.sProcessId + "_" + Thread.currentThread() + "/";
        paramContext = new File(str1);
        paramContext.mkdirs();
        String str2 = getPlatformString();
        AssetManager localAssetManager = ((Context)localObject).getAssets();
        try
        {
          a((Context)localObject, "DecodeSo", 0, false, false);
          int j = 0;
          if (j <= 1)
          {
            i = Decode(localAssetManager, paramString2, str1, str2, paramString3);
            if (i != 0) {}
          }
          else
          {
            if (i == 0) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.w("SoLoadUtil", 1, "unCompress7zSo fail, res[" + i + "], tempDirFile[" + paramContext.getAbsolutePath() + "], exists[" + paramContext.exists() + "]");
            }
            paramContext.delete();
            return i;
          }
          j += 1;
          continue;
          QLog.d("SoLoadUtil", 2, "Unsatisfied Link error: " + paramString2.toString() + "abi:" + getPlatformString());
        }
        catch (UnsatisfiedLinkError paramString2)
        {
          if (!QLog.isColorLevel()) {
            break label369;
          }
        }
      }
      finally {}
      paramString2 = new File(str1 + paramString3);
      paramString1 = new File(paramString1 + paramString3);
      if (!paramString1.exists())
      {
        if (!paramString2.renameTo(paramString1)) {
          i = 256;
        }
      }
      else
      {
        paramContext.delete();
        continue;
        label369:
        i = 2;
      }
    }
  }
  
  private static final void a(HashMap<String, String> paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    anpc.d(paramHashMap, paramInt);
    L(paramHashMap);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 206	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 18
    //   8: if_icmpge +39 -> 47
    //   11: aload_1
    //   12: ldc 208
    //   14: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +30 -> 47
    //   20: aload_0
    //   21: ldc 215
    //   23: iconst_0
    //   24: iconst_0
    //   25: iconst_1
    //   26: invokestatic 134	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   29: ifne +18 -> 47
    //   32: ldc 143
    //   34: iconst_1
    //   35: ldc 217
    //   37: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: iconst_0
    //   41: istore_3
    //   42: ldc 2
    //   44: monitorexit
    //   45: iload_3
    //   46: ireturn
    //   47: invokestatic 226	com/tencent/mobileqq/utils/AudioHelper:hG	()J
    //   50: lstore 12
    //   52: ldc 143
    //   54: iconst_1
    //   55: new 87	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   62: ldc 228
    //   64: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 230
    //   73: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload_3
    //   77: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   80: ldc 232
    //   82: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: iload 4
    //   87: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   90: ldc 234
    //   92: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: lload 12
    //   97: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: ldc 158
    //   102: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: invokestatic 239	android/os/SystemClock:uptimeMillis	()J
    //   114: lstore 14
    //   116: aload_1
    //   117: invokestatic 243	com/tencent/mobileqq/utils/SoLoadUtil:x	(Ljava/lang/String;)Ljava/util/HashMap;
    //   120: astore 25
    //   122: iconst_0
    //   123: istore 7
    //   125: aload_0
    //   126: astore 20
    //   128: aload_0
    //   129: ifnonnull +8 -> 137
    //   132: invokestatic 75	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   135: astore 20
    //   137: new 87	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   144: aload 20
    //   146: invokevirtual 247	android/content/Context:getFilesDir	()Ljava/io/File;
    //   149: invokevirtual 250	java/io/File:getParent	()Ljava/lang/String;
    //   152: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 252
    //   157: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 29
    //   165: new 87	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   172: aload 20
    //   174: invokevirtual 247	android/content/Context:getFilesDir	()Ljava/io/File;
    //   177: invokevirtual 250	java/io/File:getParent	()Ljava/lang/String;
    //   180: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 254
    //   185: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_0
    //   192: iload_3
    //   193: ifeq +1731 -> 1924
    //   196: new 77	java/io/File
    //   199: dup
    //   200: new 87	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   207: aload_0
    //   208: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 82	java/io/File:exists	()Z
    //   229: istore_3
    //   230: iload_3
    //   231: ifeq +740 -> 971
    //   234: aload_0
    //   235: invokevirtual 151	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   238: invokestatic 263	java/lang/System:load	(Ljava/lang/String;)V
    //   241: iconst_1
    //   242: istore 7
    //   244: aload 25
    //   246: iconst_0
    //   247: ldc 61
    //   249: invokestatic 239	android/os/SystemClock:uptimeMillis	()J
    //   252: lload 14
    //   254: lsub
    //   255: invokestatic 265	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   258: iload 7
    //   260: istore_3
    //   261: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq -222 -> 42
    //   267: ldc 143
    //   269: iconst_2
    //   270: new 87	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 267
    //   280: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: invokevirtual 151	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 269
    //   293: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload 7
    //   304: istore_3
    //   305: goto -263 -> 42
    //   308: astore_0
    //   309: iconst_1
    //   310: istore_3
    //   311: new 87	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   318: ldc 61
    //   320: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 271
    //   326: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokestatic 275	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   333: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: astore 16
    //   341: iconst_0
    //   342: iconst_2
    //   343: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   346: istore_2
    //   347: ldc 143
    //   349: iconst_1
    //   350: aload 16
    //   352: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: new 77	java/io/File
    //   358: dup
    //   359: new 87	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   366: aload 29
    //   368: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_1
    //   372: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   375: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: astore 26
    //   386: new 87	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 281
    //   396: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: astore 27
    //   408: aload 20
    //   410: ldc_w 283
    //   413: iconst_4
    //   414: invokevirtual 287	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   417: astore 28
    //   419: aload 20
    //   421: aload_1
    //   422: invokestatic 291	com/tencent/mobileqq/utils/SoLoadUtil:aY	(Landroid/content/Context;Ljava/lang/String;)Z
    //   425: ifeq +71 -> 496
    //   428: aload 26
    //   430: invokevirtual 82	java/io/File:exists	()Z
    //   433: ifeq +63 -> 496
    //   436: aload 26
    //   438: invokevirtual 165	java/io/File:delete	()Z
    //   441: istore 7
    //   443: iload 7
    //   445: ifeq +9 -> 454
    //   448: invokestatic 294	com/tencent/mobileqq/utils/AudioHelper:aCz	()Z
    //   451: ifeq +45 -> 496
    //   454: ldc 143
    //   456: iconst_1
    //   457: new 87	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   464: ldc_w 296
    //   467: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: iload 7
    //   472: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   475: ldc 234
    //   477: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: lload 12
    //   482: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: ldc 158
    //   487: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: iload_2
    //   497: istore 6
    //   499: aload 16
    //   501: astore_0
    //   502: aload 26
    //   504: invokevirtual 82	java/io/File:exists	()Z
    //   507: ifne +1434 -> 1941
    //   510: iload 4
    //   512: ifeq +533 -> 1045
    //   515: aload 20
    //   517: aload 29
    //   519: ldc_w 298
    //   522: aload_1
    //   523: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   526: invokestatic 300	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   529: istore 5
    //   531: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +45 -> 579
    //   537: ldc 143
    //   539: iconst_1
    //   540: new 87	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 302
    //   550: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 5
    //   555: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: ldc 234
    //   560: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: lload 12
    //   565: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: ldc 158
    //   570: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iload 5
    //   581: ifeq +432 -> 1013
    //   584: aload 26
    //   586: invokevirtual 165	java/io/File:delete	()Z
    //   589: pop
    //   590: new 87	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   597: aload 16
    //   599: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 304
    //   605: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload_1
    //   609: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: astore 16
    //   617: iload_2
    //   618: bipush 8
    //   620: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   623: istore_2
    //   624: ldc 143
    //   626: iconst_1
    //   627: aload 16
    //   629: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: goto +1303 -> 1935
    //   635: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +58 -> 696
    //   641: ldc 143
    //   643: iconst_1
    //   644: new 87	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 306
    //   654: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_1
    //   658: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc_w 308
    //   664: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 26
    //   669: invokevirtual 82	java/io/File:exists	()Z
    //   672: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc 234
    //   677: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: lload 12
    //   682: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   685: ldc 158
    //   687: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload 26
    //   698: invokevirtual 82	java/io/File:exists	()Z
    //   701: istore 4
    //   703: iload 4
    //   705: ifeq +1185 -> 1890
    //   708: aload 26
    //   710: invokevirtual 151	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   713: invokestatic 263	java/lang/System:load	(Ljava/lang/String;)V
    //   716: iconst_1
    //   717: istore 4
    //   719: iload 4
    //   721: istore_3
    //   722: iload 5
    //   724: istore_2
    //   725: aload 16
    //   727: astore_0
    //   728: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +48 -> 779
    //   734: ldc 143
    //   736: iconst_2
    //   737: new 87	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 267
    //   747: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload 26
    //   752: invokevirtual 151	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   755: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: ldc_w 269
    //   761: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   770: aload 16
    //   772: astore_0
    //   773: iload 5
    //   775: istore_2
    //   776: iload 4
    //   778: istore_3
    //   779: iload_3
    //   780: istore 4
    //   782: iload_2
    //   783: istore 5
    //   785: aload_0
    //   786: astore 16
    //   788: iload_3
    //   789: ifne +1035 -> 1824
    //   792: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   795: ifeq +35 -> 830
    //   798: ldc 143
    //   800: iconst_1
    //   801: new 87	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   808: ldc_w 310
    //   811: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: lload 12
    //   816: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: ldc 158
    //   821: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aload_1
    //   831: invokestatic 313	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   834: iconst_1
    //   835: istore 4
    //   837: iload 4
    //   839: istore_3
    //   840: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq +38 -> 881
    //   846: iload 4
    //   848: istore_3
    //   849: ldc 143
    //   851: iconst_2
    //   852: new 87	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   859: ldc_w 315
    //   862: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: aload_1
    //   866: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: ldc_w 269
    //   872: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: iconst_1
    //   882: istore_3
    //   883: invokestatic 239	android/os/SystemClock:uptimeMillis	()J
    //   886: lload 14
    //   888: lsub
    //   889: lstore 8
    //   891: aload 25
    //   893: iload_2
    //   894: aload_0
    //   895: lload 8
    //   897: invokestatic 265	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   900: ldc 143
    //   902: iconst_1
    //   903: new 87	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   910: ldc_w 306
    //   913: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload_1
    //   917: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: ldc_w 317
    //   923: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: lload 8
    //   928: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   931: ldc_w 319
    //   934: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: iload_3
    //   938: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   941: ldc 234
    //   943: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: lload 12
    //   948: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   951: ldc 158
    //   953: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: goto -920 -> 42
    //   965: astore_0
    //   966: ldc 2
    //   968: monitorexit
    //   969: aload_0
    //   970: athrow
    //   971: new 87	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   978: ldc 61
    //   980: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: ldc_w 321
    //   986: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: astore 16
    //   994: iconst_0
    //   995: iconst_4
    //   996: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   999: istore_2
    //   1000: ldc 143
    //   1002: iconst_1
    //   1003: aload 16
    //   1005: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1008: iconst_0
    //   1009: istore_3
    //   1010: goto -655 -> 355
    //   1013: aload 26
    //   1015: invokestatic 327	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1018: lstore 8
    //   1020: aload 28
    //   1022: invokeinterface 333 1 0
    //   1027: aload 27
    //   1029: lload 8
    //   1031: invokeinterface 339 4 0
    //   1036: invokeinterface 342 1 0
    //   1041: pop
    //   1042: goto +893 -> 1935
    //   1045: aconst_null
    //   1046: astore 22
    //   1048: aconst_null
    //   1049: astore 21
    //   1051: aconst_null
    //   1052: astore 23
    //   1054: aconst_null
    //   1055: astore_0
    //   1056: aload_0
    //   1057: astore 19
    //   1059: aload 23
    //   1061: astore 17
    //   1063: aload 22
    //   1065: astore 18
    //   1067: new 77	java/io/File
    //   1070: dup
    //   1071: aload 29
    //   1073: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   1076: astore 24
    //   1078: aload_0
    //   1079: astore 19
    //   1081: aload 23
    //   1083: astore 17
    //   1085: aload 22
    //   1087: astore 18
    //   1089: aload 24
    //   1091: invokevirtual 82	java/io/File:exists	()Z
    //   1094: ifne +26 -> 1120
    //   1097: aload_0
    //   1098: astore 19
    //   1100: aload 23
    //   1102: astore 17
    //   1104: aload 22
    //   1106: astore 18
    //   1108: aload 24
    //   1110: invokevirtual 85	java/io/File:mkdir	()Z
    //   1113: istore 4
    //   1115: iload 4
    //   1117: ifeq +794 -> 1911
    //   1120: aload_0
    //   1121: astore 19
    //   1123: aload 23
    //   1125: astore 17
    //   1127: aload 22
    //   1129: astore 18
    //   1131: aload 20
    //   1133: invokevirtual 129	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1136: new 87	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1143: iconst_0
    //   1144: invokestatic 346	com/tencent/mobileqq/utils/SoLoadUtil:z	(Z)Ljava/lang/String;
    //   1147: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload_1
    //   1151: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   1154: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokevirtual 352	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1163: astore 24
    //   1165: aload 24
    //   1167: astore_0
    //   1168: aload_0
    //   1169: astore 19
    //   1171: aload_0
    //   1172: astore 17
    //   1174: aload 22
    //   1176: astore 18
    //   1178: new 354	java/io/FileOutputStream
    //   1181: dup
    //   1182: new 87	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1189: aload 29
    //   1191: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: aload_1
    //   1195: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   1198: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokespecial 355	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1207: astore 20
    //   1209: aload_0
    //   1210: aload 20
    //   1212: invokestatic 361	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1215: lstore 10
    //   1217: aload 20
    //   1219: ifnull +8 -> 1227
    //   1222: aload 20
    //   1224: invokevirtual 366	java/io/OutputStream:close	()V
    //   1227: iload_2
    //   1228: istore 5
    //   1230: aload 16
    //   1232: astore 17
    //   1234: lload 10
    //   1236: lstore 8
    //   1238: aload_0
    //   1239: ifnull +18 -> 1257
    //   1242: aload_0
    //   1243: invokevirtual 369	java/io/InputStream:close	()V
    //   1246: lload 10
    //   1248: lstore 8
    //   1250: aload 16
    //   1252: astore 17
    //   1254: iload_2
    //   1255: istore 5
    //   1257: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +12 -> 1272
    //   1263: ldc 143
    //   1265: iconst_2
    //   1266: ldc_w 371
    //   1269: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: iload 5
    //   1274: istore 6
    //   1276: aload 17
    //   1278: astore_0
    //   1279: aload 26
    //   1281: invokevirtual 82	java/io/File:exists	()Z
    //   1284: ifeq +657 -> 1941
    //   1287: lload 8
    //   1289: aload 26
    //   1291: invokevirtual 374	java/io/File:length	()J
    //   1294: lcmp
    //   1295: ifeq +251 -> 1546
    //   1298: aload 26
    //   1300: invokevirtual 165	java/io/File:delete	()Z
    //   1303: pop
    //   1304: new 87	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1311: aload 17
    //   1313: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: ldc_w 376
    //   1319: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: astore 16
    //   1327: iload 5
    //   1329: bipush 8
    //   1331: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   1334: istore 5
    //   1336: ldc 143
    //   1338: iconst_1
    //   1339: aload 16
    //   1341: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1344: goto -709 -> 635
    //   1347: astore 17
    //   1349: aload_0
    //   1350: astore 19
    //   1352: aload 23
    //   1354: astore 17
    //   1356: aload 22
    //   1358: astore 18
    //   1360: aload 20
    //   1362: invokevirtual 129	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1365: new 87	java/lang/StringBuilder
    //   1368: dup
    //   1369: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1372: iconst_1
    //   1373: invokestatic 346	com/tencent/mobileqq/utils/SoLoadUtil:z	(Z)Ljava/lang/String;
    //   1376: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_1
    //   1380: invokestatic 258	com/tencent/mobileqq/utils/SoLoadUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   1383: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokevirtual 352	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1392: astore_0
    //   1393: goto -225 -> 1168
    //   1396: astore 17
    //   1398: aload 21
    //   1400: astore 20
    //   1402: aload 19
    //   1404: astore_0
    //   1405: aload 17
    //   1407: astore 19
    //   1409: aload_0
    //   1410: astore 17
    //   1412: aload 20
    //   1414: astore 18
    //   1416: new 87	java/lang/StringBuilder
    //   1419: dup
    //   1420: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1423: aload 16
    //   1425: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: ldc_w 378
    //   1431: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: aload 19
    //   1436: invokestatic 275	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1439: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1445: astore 16
    //   1447: aload_0
    //   1448: astore 17
    //   1450: aload 20
    //   1452: astore 18
    //   1454: iload_2
    //   1455: bipush 16
    //   1457: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   1460: istore 5
    //   1462: aload_0
    //   1463: astore 17
    //   1465: aload 20
    //   1467: astore 18
    //   1469: ldc 143
    //   1471: iconst_1
    //   1472: aload 16
    //   1474: aload 19
    //   1476: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1479: aload 20
    //   1481: ifnull +8 -> 1489
    //   1484: aload 20
    //   1486: invokevirtual 366	java/io/OutputStream:close	()V
    //   1489: aload_0
    //   1490: ifnull +409 -> 1899
    //   1493: aload_0
    //   1494: invokevirtual 369	java/io/InputStream:close	()V
    //   1497: ldc2_w 382
    //   1500: lstore 8
    //   1502: aload 16
    //   1504: astore 17
    //   1506: goto -249 -> 1257
    //   1509: astore_0
    //   1510: ldc2_w 382
    //   1513: lstore 8
    //   1515: aload 16
    //   1517: astore 17
    //   1519: goto -262 -> 1257
    //   1522: astore_1
    //   1523: aload 17
    //   1525: astore_0
    //   1526: aload 18
    //   1528: ifnull +8 -> 1536
    //   1531: aload 18
    //   1533: invokevirtual 366	java/io/OutputStream:close	()V
    //   1536: aload_0
    //   1537: ifnull +7 -> 1544
    //   1540: aload_0
    //   1541: invokevirtual 369	java/io/InputStream:close	()V
    //   1544: aload_1
    //   1545: athrow
    //   1546: aload 26
    //   1548: invokestatic 327	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1551: lstore 8
    //   1553: aload 28
    //   1555: invokeinterface 333 1 0
    //   1560: aload 27
    //   1562: lload 8
    //   1564: invokeinterface 339 4 0
    //   1569: invokeinterface 342 1 0
    //   1574: pop
    //   1575: iload 5
    //   1577: istore 6
    //   1579: aload 17
    //   1581: astore_0
    //   1582: goto +359 -> 1941
    //   1585: astore_0
    //   1586: iconst_0
    //   1587: istore_3
    //   1588: aload 26
    //   1590: invokestatic 327	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1593: lstore 8
    //   1595: aload 28
    //   1597: aload 27
    //   1599: ldc2_w 382
    //   1602: invokeinterface 387 4 0
    //   1607: lstore 10
    //   1609: lload 8
    //   1611: ldc2_w 382
    //   1614: lcmp
    //   1615: ifeq +98 -> 1713
    //   1618: lload 8
    //   1620: lload 10
    //   1622: lcmp
    //   1623: ifeq +90 -> 1713
    //   1626: aload 26
    //   1628: invokevirtual 165	java/io/File:delete	()Z
    //   1631: pop
    //   1632: new 87	java/lang/StringBuilder
    //   1635: dup
    //   1636: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1639: aload 16
    //   1641: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: ldc_w 389
    //   1647: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: lload 8
    //   1652: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1655: ldc_w 391
    //   1658: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: lload 10
    //   1663: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1666: ldc_w 393
    //   1669: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: aload 26
    //   1674: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1677: ldc_w 395
    //   1680: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: aload_0
    //   1684: invokestatic 275	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1687: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1693: astore_0
    //   1694: iload 5
    //   1696: sipush 128
    //   1699: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   1702: istore_2
    //   1703: ldc 143
    //   1705: iconst_1
    //   1706: aload_0
    //   1707: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1710: goto -931 -> 779
    //   1713: new 87	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1720: aload 16
    //   1722: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: ldc_w 397
    //   1728: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: aload 26
    //   1733: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1736: ldc_w 395
    //   1739: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: aload_0
    //   1743: invokestatic 275	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1746: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1752: astore_0
    //   1753: iload 5
    //   1755: bipush 32
    //   1757: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   1760: istore_2
    //   1761: ldc 143
    //   1763: iconst_1
    //   1764: aload_0
    //   1765: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1768: goto -989 -> 779
    //   1771: astore 17
    //   1773: new 87	java/lang/StringBuilder
    //   1776: dup
    //   1777: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1780: aload_0
    //   1781: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: ldc_w 399
    //   1787: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: aload 17
    //   1792: invokestatic 275	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1795: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: astore 16
    //   1803: iload_2
    //   1804: bipush 64
    //   1806: invokestatic 279	com/tencent/mobileqq/utils/SoLoadUtil:aV	(II)I
    //   1809: istore 5
    //   1811: ldc 143
    //   1813: iconst_1
    //   1814: aload 16
    //   1816: aload 17
    //   1818: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1821: iload_3
    //   1822: istore 4
    //   1824: iload 4
    //   1826: istore_3
    //   1827: iload 5
    //   1829: istore_2
    //   1830: aload 16
    //   1832: astore_0
    //   1833: goto -950 -> 883
    //   1836: astore 17
    //   1838: goto -611 -> 1227
    //   1841: astore_0
    //   1842: iload_2
    //   1843: istore 5
    //   1845: aload 16
    //   1847: astore 17
    //   1849: lload 10
    //   1851: lstore 8
    //   1853: goto -596 -> 1257
    //   1856: astore 17
    //   1858: goto -369 -> 1489
    //   1861: astore 16
    //   1863: goto -327 -> 1536
    //   1866: astore_0
    //   1867: goto -323 -> 1544
    //   1870: astore_1
    //   1871: aload 20
    //   1873: astore 18
    //   1875: goto -349 -> 1526
    //   1878: astore 19
    //   1880: goto -471 -> 1409
    //   1883: astore_0
    //   1884: iload 7
    //   1886: istore_3
    //   1887: goto -1576 -> 311
    //   1890: iload 5
    //   1892: istore_2
    //   1893: aload 16
    //   1895: astore_0
    //   1896: goto -1117 -> 779
    //   1899: ldc2_w 382
    //   1902: lstore 8
    //   1904: aload 16
    //   1906: astore 17
    //   1908: goto -651 -> 1257
    //   1911: aconst_null
    //   1912: astore 20
    //   1914: aconst_null
    //   1915: astore_0
    //   1916: ldc2_w 382
    //   1919: lstore 10
    //   1921: goto -704 -> 1217
    //   1924: iconst_0
    //   1925: istore_2
    //   1926: iconst_0
    //   1927: istore_3
    //   1928: ldc 61
    //   1930: astore 16
    //   1932: goto -1577 -> 355
    //   1935: iload_2
    //   1936: istore 5
    //   1938: goto -1303 -> 635
    //   1941: iload 6
    //   1943: istore 5
    //   1945: aload_0
    //   1946: astore 16
    //   1948: goto -1313 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1951	0	paramContext	Context
    //   0	1951	1	paramString	String
    //   0	1951	2	paramInt	int
    //   0	1951	3	paramBoolean1	boolean
    //   0	1951	4	paramBoolean2	boolean
    //   529	1415	5	i	int
    //   497	1445	6	j	int
    //   123	1762	7	bool	boolean
    //   889	1014	8	l1	long
    //   1215	705	10	l2	long
    //   50	897	12	l3	long
    //   114	773	14	l4	long
    //   339	1507	16	localObject1	Object
    //   1861	44	16	localIOException1	java.io.IOException
    //   1930	17	16	localObject2	Object
    //   1061	251	17	localObject3	Object
    //   1347	1	17	localException	java.lang.Exception
    //   1354	1	17	localObject4	Object
    //   1396	10	17	localIOException2	java.io.IOException
    //   1410	170	17	localObject5	Object
    //   1771	46	17	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   1836	1	17	localIOException3	java.io.IOException
    //   1847	1	17	localObject6	Object
    //   1856	1	17	localIOException4	java.io.IOException
    //   1906	1	17	localIOException5	java.io.IOException
    //   1065	809	18	localObject7	Object
    //   1057	418	19	localObject8	Object
    //   1878	1	19	localIOException6	java.io.IOException
    //   126	1787	20	localObject9	Object
    //   1049	350	21	localObject10	Object
    //   1046	311	22	localObject11	Object
    //   1052	301	23	localObject12	Object
    //   1076	90	24	localObject13	Object
    //   120	772	25	localHashMap	HashMap
    //   384	1348	26	localFile	File
    //   406	1192	27	str1	String
    //   417	1179	28	localSharedPreferences	SharedPreferences
    //   163	1027	29	str2	String
    // Exception table:
    //   from	to	target	type
    //   244	258	308	java/lang/UnsatisfiedLinkError
    //   261	302	308	java/lang/UnsatisfiedLinkError
    //   3	40	965	finally
    //   47	122	965	finally
    //   132	137	965	finally
    //   137	192	965	finally
    //   196	230	965	finally
    //   234	241	965	finally
    //   244	258	965	finally
    //   261	302	965	finally
    //   311	355	965	finally
    //   355	443	965	finally
    //   448	454	965	finally
    //   454	496	965	finally
    //   502	510	965	finally
    //   515	579	965	finally
    //   584	632	965	finally
    //   635	696	965	finally
    //   696	703	965	finally
    //   708	716	965	finally
    //   728	770	965	finally
    //   792	830	965	finally
    //   830	834	965	finally
    //   840	846	965	finally
    //   849	881	965	finally
    //   883	962	965	finally
    //   971	1008	965	finally
    //   1013	1042	965	finally
    //   1222	1227	965	finally
    //   1242	1246	965	finally
    //   1257	1272	965	finally
    //   1279	1344	965	finally
    //   1484	1489	965	finally
    //   1493	1497	965	finally
    //   1531	1536	965	finally
    //   1540	1544	965	finally
    //   1544	1546	965	finally
    //   1546	1575	965	finally
    //   1588	1609	965	finally
    //   1626	1710	965	finally
    //   1713	1768	965	finally
    //   1773	1821	965	finally
    //   1131	1165	1347	java/lang/Exception
    //   1067	1078	1396	java/io/IOException
    //   1089	1097	1396	java/io/IOException
    //   1108	1115	1396	java/io/IOException
    //   1131	1165	1396	java/io/IOException
    //   1178	1209	1396	java/io/IOException
    //   1360	1393	1396	java/io/IOException
    //   1493	1497	1509	java/io/IOException
    //   1067	1078	1522	finally
    //   1089	1097	1522	finally
    //   1108	1115	1522	finally
    //   1131	1165	1522	finally
    //   1178	1209	1522	finally
    //   1360	1393	1522	finally
    //   1416	1447	1522	finally
    //   1454	1462	1522	finally
    //   1469	1479	1522	finally
    //   708	716	1585	java/lang/UnsatisfiedLinkError
    //   728	770	1585	java/lang/UnsatisfiedLinkError
    //   830	834	1771	java/lang/UnsatisfiedLinkError
    //   840	846	1771	java/lang/UnsatisfiedLinkError
    //   849	881	1771	java/lang/UnsatisfiedLinkError
    //   1222	1227	1836	java/io/IOException
    //   1242	1246	1841	java/io/IOException
    //   1484	1489	1856	java/io/IOException
    //   1531	1536	1861	java/io/IOException
    //   1540	1544	1866	java/io/IOException
    //   1209	1217	1870	finally
    //   1209	1217	1878	java/io/IOException
    //   234	241	1883	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean aFd()
  {
    return ((!TextUtils.isEmpty(Build.CPU_ABI)) && (Build.CPU_ABI.contains("x86"))) || ((!TextUtils.isEmpty(Build.CPU_ABI2)) && (Build.CPU_ABI2.contains("x86"))) || (aFe());
  }
  
  public static boolean aFe()
  {
    String str = System.getProperty("os.arch");
    return (Build.BRAND.equals("asus")) && ((Build.CPU_ABI2.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("x86")) || (str.toLowerCase(Locale.US).contains("i386")) || (str.toLowerCase(Locale.US).contains("i686")) || (str.toLowerCase(Locale.US).contains("i586")) || (str.toLowerCase(Locale.US).contains("i486")));
  }
  
  private static int aV(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static boolean aY(Context paramContext, String paramString)
  {
    String str1 = AppSetting.getRevision() + Ck();
    String str2 = "key_so_version_" + paramString;
    paramContext = paramContext.getSharedPreferences("so_sp", 4);
    String str3 = paramContext.getString(str2, "");
    if (!TextUtils.equals(str1, str3)) {}
    for (boolean bool = true;; bool = false)
    {
      if (AudioHelper.aCz()) {
        QLog.w("SoLoadUtil", 1, "loadNativeLibrary, libName[" + paramString + "], nowVersion[" + str3 + "], revision[" + str1 + "], needUpdate[" + bool + "]");
      }
      if (bool)
      {
        if (!TextUtils.equals("0" + Ck(), str1)) {
          break;
        }
        paramContext.edit().putString(str2, "-1" + Ck()).apply();
      }
      return bool;
    }
    paramContext.edit().putString(str2, str1).apply();
    return bool;
  }
  
  /* Error */
  private static String getDefaultPlatformString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 406	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 487
    //   15: invokevirtual 417	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 489
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: ldc_w 491
    //   33: astore_0
    //   34: goto -9 -> 25
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	28	0	str	String
    //   37	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	37	finally
    //   11	21	37	finally
  }
  
  private static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  /* Error */
  private static String getPlatform32String()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 406	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 414
    //   15: invokevirtual 417	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 414
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 498
    //   38: invokevirtual 417	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 500
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:aFe	()Z
    //   54: ifeq +10 -> 64
    //   57: ldc_w 414
    //   60: astore_0
    //   61: goto -36 -> 25
    //   64: ldc_w 491
    //   67: astore_0
    //   68: goto -43 -> 25
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	62	0	str	String
    //   71	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   11	21	71	finally
    //   34	44	71	finally
    //   51	57	71	finally
  }
  
  private static String getPlatformString()
  {
    try
    {
      String str = getPlatform32String();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean loadNativeLibrary(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramContext, paramString, paramInt, paramBoolean, true);
  }
  
  private static final HashMap<String, String> x(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", sFormatter.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static String z(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/" + getDefaultPlatformString() + "/";
    }
    return "lib/" + getPlatformString() + "/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadUtil
 * JD-Core Version:    0.7.0.1
 */