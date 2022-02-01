package com.tencent.mobileqq.vas;

import ahbr;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Proxy;
import android.os.Build.VERSION;
import anpc;
import aopd;
import aopo;
import aopp;
import aopq;
import aqqn;
import aqqq;
import aqrb;
import aqsm;
import aqsw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jqc;
import mqq.app.AppRuntime;

public class VasQuickUpdateEngine
{
  public static final String ENGINE_CONFIG_PATH = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "quickupdate";
  public static final int LOAD_SO_MAX_RETRY_TIME = 2;
  private static final String TAG = "VasQuickUpdateEngine";
  private static final String TAG_NATIVE = "VasQuickUpdateEngine_Native";
  public static AtomicBoolean hasSoLoaded = new AtomicBoolean(false);
  public static AtomicBoolean isSoLoadFail = new AtomicBoolean(false);
  public static int loadSoRetryTime;
  private static VasQuickUpdateEngine mInstance;
  AtomicBoolean engineReady = new AtomicBoolean(false);
  public long mUpdateManagerInstance;
  public WeakReference<aqrb> mWeakHandler;
  ArrayList<PendingTask> pendingTasks = new ArrayList();
  
  private VasQuickUpdateEngine()
  {
    loadSo();
  }
  
  public static void QuickUpdateLog(int paramInt, byte[] paramArrayOfByte)
  {
    do
    {
      do
      {
        do
        {
          try
          {
            paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
            switch (paramInt)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
              }
              return;
            }
          }
          catch (Throwable paramArrayOfByte)
          {
            QLog.e("VasQuickUpdateEngine_Native", 1, "Couldn't convert the jbyteArray to jstring", paramArrayOfByte);
            return;
          }
          QLog.e("VasQuickUpdateEngine_Native", 1, paramArrayOfByte);
          return;
        } while (!QLog.isColorLevel());
        QLog.w("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateEngine_Native", 2, paramArrayOfByte);
  }
  
  public static byte[] alloc(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  private boolean bsPatch(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "bsPatch: srcFile = " + paramString1 + " patchFile = " + paramString2);
    }
    return BspatchUtil.D(paramString1, paramString2, paramString1);
  }
  
  private QQAppInterface getApp()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {}
    for (localObject = ((BaseApplicationImpl)localObject).getRuntime();; localObject = null) {
      return (QQAppInterface)localObject;
    }
  }
  
  public static VasQuickUpdateEngine getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new VasQuickUpdateEngine();
      }
      VasQuickUpdateEngine localVasQuickUpdateEngine = mInstance;
      return localVasQuickUpdateEngine;
    }
    finally {}
  }
  
  private int getNetType()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getNetType");
    }
    int j = jqc.getNetWorkType();
    int i = j;
    if (j == 5) {
      i = 1;
    }
    return i + 1;
  }
  
  private boolean initEngine(String paramString)
  {
    this.mUpdateManagerInstance = nativeCreateManager(paramString, Proxy.getDefaultHost(), Proxy.getDefaultPort());
    QLog.d("VasQuickUpdateEngine", 1, "initEngine: createManager");
    if (this.mUpdateManagerInstance != 0L)
    {
      nativeSetLocalInfo(this.mUpdateManagerInstance, "2", "3.4.4.3058", ThemeUtil.getThemeDensity(BaseApplicationImpl.getApplication()));
      this.engineReady.set(true);
      nativeupdateAllItem(this.mUpdateManagerInstance);
      runPendingTasks();
      return true;
    }
    return false;
  }
  
  private boolean isFileExists(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "isFileExists bid = " + paramLong + " scid = " + paramString);
    }
    aqsm localaqsm = aqsw.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "isFileExists: get null app " + paramString);
    }
    return (localaqsm != null) && (localaqsm.isFileExists(localQQAppInterface, paramLong, paramString));
  }
  
  private void loadSo()
  {
    ThreadManagerV2.excute(new VasQuickUpdateEngine.1(this), 64, null, true);
  }
  
  private void onPreloadDownloadComplete(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasQuickUpdateEngine", 2, "onPreloadDownloadComplete url = " + paramString + " fileSize = " + paramLong);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((aopo)((QQAppInterface)localAppRuntime).getManager(193)).be(paramString, paramLong);
      return;
    }
    QLog.e("VasQuickUpdateEngine", 1, "onPreloadDownloadComplete app is not QQAppInterface");
  }
  
  private void onPreloadDownloadStart(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasQuickUpdateEngine", 2, "onPreloadDownloadStart");
    }
    paramString4 = new VasQuickUpdateEngine.2(this, paramString1, paramString2, paramString3, paramLong, paramString4);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (aopo)localQQAppInterface.getManager(193);
      paramString4 = new aopp(localQQAppInterface, paramString1, paramString4, 4000L);
      ((aopo)localObject).a(10019, "vas", paramString1, ((Integer)aopq.nY.get(Integer.valueOf(10019))).intValue(), paramString2, paramString3, 2, 0, true, paramString4);
      return;
    }
    QLog.e("VasQuickUpdateEngine", 1, "onPreloadDownloadStart app is not QQAppInterface");
    paramString4.run();
  }
  
  private void recordFlowBytes(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "recordFlowBytes nBytes = " + paramInt1 + " netType = " + paramInt2);
    }
    int i = paramInt2 - 1;
    paramInt2 = i;
    if (i == 5) {
      paramInt2 = 0;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).sendAppDataIncerment(str, false, paramInt2, 0, 8999, paramInt1);
    }
  }
  
  private void reportDLEvent(int paramInt1, long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    VasWebviewUtil.reportQuickUpdateDownload(paramInt1, paramLong, paramString1, paramString2, paramBoolean, paramInt2, paramInt3, paramInt4, paramString3, paramString4, paramString5);
    if ((int)(Math.random() * 10000.0D) == 1)
    {
      paramString3 = new HashMap();
      paramString3.put("from", String.valueOf(paramInt1));
      paramString3.put("bid", String.valueOf(paramLong));
      paramString3.put("scid", String.valueOf(paramString1));
      paramString3.put("md5", String.valueOf(paramString2));
      paramString3.put("eventCode", String.valueOf(paramInt2));
      paramString3.put("httpCode", String.valueOf(paramInt3));
      paramString3.put("retry", String.valueOf(paramInt4));
      anpc.a(BaseApplication.getContext()).collectPerformance("", "qqvas_updatemgr_complete", false, 0L, -1L, paramString3, "", true);
    }
  }
  
  private void reportSTEvent(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "reportSTEvent:");
    }
    VasWebviewUtil.reportQuickUpdateST(paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5);
  }
  
  public static boolean safeDeleteFile(File paramFile)
  {
    return safeDeleteFile(paramFile, "");
  }
  
  public static boolean safeDeleteFile(File paramFile, String paramString)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          safeDeleteFile(arrayOfFile[i], paramString);
          i += 1;
        }
      }
    }
    paramString = new File(paramFile.getParent() + File.separator + paramString + System.currentTimeMillis());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
  
  private boolean sendPbMsg(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (paramArrayOfByte == null)
        {
          QLog.e("VasQuickUpdateEngine", 1, "sendPbMsg null buff");
          return false;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VasQuickUpdateEngine", 1, "sendPbMsg failed", paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "sendPbMsg: cmd = " + paramString + " buff = " + paramArrayOfByte);
        }
        localObject = this.mWeakHandler;
        if (localObject != null)
        {
          localObject = (aqrb)((WeakReference)localObject).get();
          if (localObject != null) {
            return ((aqrb)localObject).bX(paramString, paramArrayOfByte);
          }
        }
        QLog.e("VasQuickUpdateEngine", 1, "sendPbMsg: error VasExtensionHandler = null");
        return false;
      }
      paramArrayOfByte = null;
    }
  }
  
  /* Error */
  private static String unZipFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 478	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 481	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 485	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 10
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 11
    //   26: aconst_null
    //   27: astore 4
    //   29: aconst_null
    //   30: astore 5
    //   32: aload 6
    //   34: astore 9
    //   36: aload 4
    //   38: astore 8
    //   40: aload 5
    //   42: astore 7
    //   44: aload 10
    //   46: invokeinterface 490 1 0
    //   51: ifeq +533 -> 584
    //   54: aload 6
    //   56: astore 9
    //   58: aload 4
    //   60: astore 8
    //   62: aload 5
    //   64: astore 7
    //   66: aload 10
    //   68: invokeinterface 493 1 0
    //   73: checkcast 495	java/util/zip/ZipEntry
    //   76: astore 12
    //   78: aload 6
    //   80: astore 9
    //   82: aload 4
    //   84: astore 8
    //   86: aload 5
    //   88: astore 7
    //   90: aload 12
    //   92: invokevirtual 498	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc_w 500
    //   98: invokevirtual 504	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifne -69 -> 32
    //   104: aload 6
    //   106: astore 9
    //   108: aload 4
    //   110: astore 8
    //   112: aload 5
    //   114: astore 7
    //   116: aload 12
    //   118: invokevirtual 505	java/util/zip/ZipEntry:isDirectory	()Z
    //   121: ifeq +201 -> 322
    //   124: aload 6
    //   126: astore 9
    //   128: aload 4
    //   130: astore 8
    //   132: aload 5
    //   134: astore 7
    //   136: invokestatic 508	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   139: ifeq +46 -> 185
    //   142: aload 6
    //   144: astore 9
    //   146: aload 4
    //   148: astore 8
    //   150: aload 5
    //   152: astore 7
    //   154: ldc_w 510
    //   157: iconst_4
    //   158: new 52	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 512
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 12
    //   173: invokevirtual 498	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   176: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload 6
    //   187: astore 9
    //   189: aload 4
    //   191: astore 8
    //   193: aload 5
    //   195: astore 7
    //   197: new 112	java/lang/String
    //   200: dup
    //   201: new 52	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   208: aload_1
    //   209: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 12
    //   214: invokevirtual 498	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   217: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: ldc_w 514
    //   226: invokevirtual 518	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   229: ldc_w 520
    //   232: invokespecial 117	java/lang/String:<init>	([BLjava/lang/String;)V
    //   235: astore_0
    //   236: aload 6
    //   238: astore 9
    //   240: aload 4
    //   242: astore 8
    //   244: aload 5
    //   246: astore 7
    //   248: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +42 -> 293
    //   254: aload 6
    //   256: astore 9
    //   258: aload 4
    //   260: astore 8
    //   262: aload 5
    //   264: astore 7
    //   266: ldc_w 510
    //   269: iconst_2
    //   270: new 52	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 522
    //   280: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload 6
    //   295: astore 9
    //   297: aload 4
    //   299: astore 8
    //   301: aload 5
    //   303: astore 7
    //   305: new 67	java/io/File
    //   308: dup
    //   309: aload_0
    //   310: invokespecial 442	java/io/File:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 525	java/io/File:mkdir	()Z
    //   316: pop
    //   317: aload_0
    //   318: astore_3
    //   319: goto -287 -> 32
    //   322: aload 6
    //   324: astore 9
    //   326: aload 4
    //   328: astore 8
    //   330: aload 5
    //   332: astore 7
    //   334: aload 12
    //   336: invokevirtual 498	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   339: astore_0
    //   340: aload 6
    //   342: astore 9
    //   344: aload 4
    //   346: astore 8
    //   348: aload 5
    //   350: astore 7
    //   352: new 67	java/io/File
    //   355: dup
    //   356: new 52	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   363: aload_1
    //   364: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload 12
    //   369: invokevirtual 498	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   372: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokespecial 442	java/io/File:<init>	(Ljava/lang/String;)V
    //   381: astore_3
    //   382: aload 6
    //   384: astore 9
    //   386: aload 4
    //   388: astore 8
    //   390: aload 5
    //   392: astore 7
    //   394: aload_3
    //   395: invokevirtual 528	java/io/File:getParentFile	()Ljava/io/File;
    //   398: invokevirtual 531	java/io/File:mkdirs	()Z
    //   401: pop
    //   402: aload 6
    //   404: astore 9
    //   406: aload 4
    //   408: astore 8
    //   410: aload 5
    //   412: astore 7
    //   414: aload_3
    //   415: invokevirtual 423	java/io/File:exists	()Z
    //   418: ifeq +20 -> 438
    //   421: aload 6
    //   423: astore 9
    //   425: aload 4
    //   427: astore 8
    //   429: aload 5
    //   431: astore 7
    //   433: aload_3
    //   434: invokevirtual 448	java/io/File:delete	()Z
    //   437: pop
    //   438: aload 6
    //   440: astore 9
    //   442: aload 4
    //   444: astore 8
    //   446: aload 5
    //   448: astore 7
    //   450: new 533	java/io/BufferedOutputStream
    //   453: dup
    //   454: new 535	java/io/FileOutputStream
    //   457: dup
    //   458: aload_3
    //   459: invokespecial 536	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   462: invokespecial 539	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   465: astore_3
    //   466: aload 6
    //   468: aload 12
    //   470: invokevirtual 543	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   473: astore 5
    //   475: aload 5
    //   477: aload 11
    //   479: iconst_0
    //   480: sipush 8192
    //   483: invokevirtual 549	java/io/InputStream:read	([BII)I
    //   486: istore_2
    //   487: iload_2
    //   488: iconst_m1
    //   489: if_icmpeq +74 -> 563
    //   492: aload_3
    //   493: aload 11
    //   495: iconst_0
    //   496: iload_2
    //   497: invokevirtual 555	java/io/OutputStream:write	([BII)V
    //   500: goto -25 -> 475
    //   503: astore_1
    //   504: aload 5
    //   506: astore 4
    //   508: aload 6
    //   510: astore 9
    //   512: aload 4
    //   514: astore 8
    //   516: aload_3
    //   517: astore 7
    //   519: ldc 30
    //   521: iconst_1
    //   522: ldc_w 557
    //   525: aload_1
    //   526: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   529: aload_3
    //   530: ifnull +7 -> 537
    //   533: aload_3
    //   534: invokevirtual 560	java/io/OutputStream:close	()V
    //   537: aload 4
    //   539: ifnull +8 -> 547
    //   542: aload 4
    //   544: invokevirtual 561	java/io/InputStream:close	()V
    //   547: aload_0
    //   548: astore_1
    //   549: aload 6
    //   551: ifnull +10 -> 561
    //   554: aload 6
    //   556: invokevirtual 562	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   559: aload_0
    //   560: astore_1
    //   561: aload_1
    //   562: areturn
    //   563: aload 5
    //   565: invokevirtual 561	java/io/InputStream:close	()V
    //   568: aload_3
    //   569: invokevirtual 560	java/io/OutputStream:close	()V
    //   572: aload 5
    //   574: astore 4
    //   576: aload_3
    //   577: astore 5
    //   579: aload_0
    //   580: astore_3
    //   581: goto -549 -> 32
    //   584: aload 6
    //   586: astore 9
    //   588: aload 4
    //   590: astore 8
    //   592: aload 5
    //   594: astore 7
    //   596: aload 6
    //   598: invokevirtual 562	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   601: aload 5
    //   603: ifnull +8 -> 611
    //   606: aload 5
    //   608: invokevirtual 560	java/io/OutputStream:close	()V
    //   611: aload 4
    //   613: ifnull +8 -> 621
    //   616: aload 4
    //   618: invokevirtual 561	java/io/InputStream:close	()V
    //   621: aload 6
    //   623: ifnull +402 -> 1025
    //   626: aload 6
    //   628: invokevirtual 562	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   631: aload_3
    //   632: areturn
    //   633: astore_0
    //   634: ldc 30
    //   636: iconst_1
    //   637: ldc_w 564
    //   640: aload_0
    //   641: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   644: goto -33 -> 611
    //   647: astore_0
    //   648: ldc 30
    //   650: iconst_1
    //   651: ldc_w 564
    //   654: aload_0
    //   655: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   658: goto -37 -> 621
    //   661: astore_0
    //   662: ldc 30
    //   664: iconst_1
    //   665: ldc_w 564
    //   668: aload_0
    //   669: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   672: aload_3
    //   673: areturn
    //   674: astore_1
    //   675: ldc 30
    //   677: iconst_1
    //   678: ldc_w 564
    //   681: aload_1
    //   682: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   685: goto -148 -> 537
    //   688: astore_1
    //   689: ldc 30
    //   691: iconst_1
    //   692: ldc_w 564
    //   695: aload_1
    //   696: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   699: goto -152 -> 547
    //   702: astore_1
    //   703: ldc 30
    //   705: iconst_1
    //   706: ldc_w 564
    //   709: aload_1
    //   710: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   713: aload_0
    //   714: areturn
    //   715: astore_1
    //   716: aconst_null
    //   717: astore 6
    //   719: aconst_null
    //   720: astore 4
    //   722: aconst_null
    //   723: astore_3
    //   724: aconst_null
    //   725: astore_0
    //   726: aload 6
    //   728: astore 9
    //   730: aload 4
    //   732: astore 8
    //   734: aload_3
    //   735: astore 7
    //   737: ldc 30
    //   739: iconst_1
    //   740: ldc_w 566
    //   743: aload_1
    //   744: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   747: aload_3
    //   748: ifnull +7 -> 755
    //   751: aload_3
    //   752: invokevirtual 560	java/io/OutputStream:close	()V
    //   755: aload 4
    //   757: ifnull +8 -> 765
    //   760: aload 4
    //   762: invokevirtual 561	java/io/InputStream:close	()V
    //   765: aload_0
    //   766: astore_1
    //   767: aload 6
    //   769: ifnull -208 -> 561
    //   772: aload 6
    //   774: invokevirtual 562	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   777: aload_0
    //   778: areturn
    //   779: astore_1
    //   780: ldc 30
    //   782: iconst_1
    //   783: ldc_w 564
    //   786: aload_1
    //   787: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   790: aload_0
    //   791: areturn
    //   792: astore_1
    //   793: ldc 30
    //   795: iconst_1
    //   796: ldc_w 564
    //   799: aload_1
    //   800: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   803: goto -48 -> 755
    //   806: astore_1
    //   807: ldc 30
    //   809: iconst_1
    //   810: ldc_w 564
    //   813: aload_1
    //   814: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   817: goto -52 -> 765
    //   820: astore_0
    //   821: aconst_null
    //   822: astore 6
    //   824: aconst_null
    //   825: astore 4
    //   827: aconst_null
    //   828: astore_1
    //   829: aload_1
    //   830: ifnull +7 -> 837
    //   833: aload_1
    //   834: invokevirtual 560	java/io/OutputStream:close	()V
    //   837: aload 4
    //   839: ifnull +8 -> 847
    //   842: aload 4
    //   844: invokevirtual 561	java/io/InputStream:close	()V
    //   847: aload 6
    //   849: ifnull +8 -> 857
    //   852: aload 6
    //   854: invokevirtual 562	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   857: aload_0
    //   858: athrow
    //   859: astore_1
    //   860: ldc 30
    //   862: iconst_1
    //   863: ldc_w 564
    //   866: aload_1
    //   867: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   870: goto -33 -> 837
    //   873: astore_1
    //   874: ldc 30
    //   876: iconst_1
    //   877: ldc_w 564
    //   880: aload_1
    //   881: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   884: goto -37 -> 847
    //   887: astore_1
    //   888: ldc 30
    //   890: iconst_1
    //   891: ldc_w 564
    //   894: aload_1
    //   895: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   898: goto -41 -> 857
    //   901: astore_0
    //   902: aconst_null
    //   903: astore 4
    //   905: aconst_null
    //   906: astore_1
    //   907: goto -78 -> 829
    //   910: astore_0
    //   911: aload 5
    //   913: astore 4
    //   915: aload_3
    //   916: astore_1
    //   917: goto -88 -> 829
    //   920: astore_0
    //   921: aload 9
    //   923: astore 6
    //   925: aload 8
    //   927: astore 4
    //   929: aload 7
    //   931: astore_1
    //   932: goto -103 -> 829
    //   935: astore_0
    //   936: aload_3
    //   937: astore_1
    //   938: goto -109 -> 829
    //   941: astore_1
    //   942: aconst_null
    //   943: astore 4
    //   945: aconst_null
    //   946: astore_3
    //   947: aconst_null
    //   948: astore_0
    //   949: goto -223 -> 726
    //   952: astore_1
    //   953: aload 5
    //   955: astore 4
    //   957: goto -231 -> 726
    //   960: astore_1
    //   961: aload_3
    //   962: astore_0
    //   963: aload 5
    //   965: astore_3
    //   966: goto -240 -> 726
    //   969: astore_1
    //   970: aload 5
    //   972: astore_3
    //   973: goto -247 -> 726
    //   976: astore_1
    //   977: goto -251 -> 726
    //   980: astore_1
    //   981: aconst_null
    //   982: astore 6
    //   984: aconst_null
    //   985: astore 4
    //   987: aconst_null
    //   988: astore_3
    //   989: aconst_null
    //   990: astore_0
    //   991: goto -483 -> 508
    //   994: astore_1
    //   995: aconst_null
    //   996: astore 4
    //   998: aconst_null
    //   999: astore_3
    //   1000: aconst_null
    //   1001: astore_0
    //   1002: goto -494 -> 508
    //   1005: astore_1
    //   1006: aload_3
    //   1007: astore_0
    //   1008: aload 5
    //   1010: astore_3
    //   1011: goto -503 -> 508
    //   1014: astore_1
    //   1015: aload 5
    //   1017: astore_3
    //   1018: goto -510 -> 508
    //   1021: astore_1
    //   1022: goto -514 -> 508
    //   1025: aload_3
    //   1026: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	paramFile	File
    //   0	1027	1	paramString	String
    //   486	11	2	i	int
    //   1	1025	3	localObject1	Object
    //   27	970	4	localObject2	Object
    //   30	986	5	localObject3	Object
    //   10	973	6	localObject4	Object
    //   42	888	7	localObject5	Object
    //   38	888	8	localObject6	Object
    //   34	888	9	localObject7	Object
    //   17	50	10	localEnumeration	java.util.Enumeration
    //   24	470	11	arrayOfByte	byte[]
    //   76	393	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   475	487	503	java/lang/Exception
    //   492	500	503	java/lang/Exception
    //   563	572	503	java/lang/Exception
    //   606	611	633	java/lang/Exception
    //   616	621	647	java/lang/Exception
    //   626	631	661	java/lang/Exception
    //   533	537	674	java/lang/Exception
    //   542	547	688	java/lang/Exception
    //   554	559	702	java/lang/Exception
    //   2	12	715	java/lang/OutOfMemoryError
    //   772	777	779	java/lang/Exception
    //   751	755	792	java/lang/Exception
    //   760	765	806	java/lang/Exception
    //   2	12	820	finally
    //   833	837	859	java/lang/Exception
    //   842	847	873	java/lang/Exception
    //   852	857	887	java/lang/Exception
    //   12	26	901	finally
    //   475	487	910	finally
    //   492	500	910	finally
    //   563	572	910	finally
    //   44	54	920	finally
    //   66	78	920	finally
    //   90	104	920	finally
    //   116	124	920	finally
    //   136	142	920	finally
    //   154	185	920	finally
    //   197	236	920	finally
    //   248	254	920	finally
    //   266	293	920	finally
    //   305	317	920	finally
    //   334	340	920	finally
    //   352	382	920	finally
    //   394	402	920	finally
    //   414	421	920	finally
    //   433	438	920	finally
    //   450	466	920	finally
    //   519	529	920	finally
    //   596	601	920	finally
    //   737	747	920	finally
    //   466	475	935	finally
    //   12	26	941	java/lang/OutOfMemoryError
    //   475	487	952	java/lang/OutOfMemoryError
    //   492	500	952	java/lang/OutOfMemoryError
    //   563	572	952	java/lang/OutOfMemoryError
    //   44	54	960	java/lang/OutOfMemoryError
    //   66	78	960	java/lang/OutOfMemoryError
    //   90	104	960	java/lang/OutOfMemoryError
    //   116	124	960	java/lang/OutOfMemoryError
    //   136	142	960	java/lang/OutOfMemoryError
    //   154	185	960	java/lang/OutOfMemoryError
    //   197	236	960	java/lang/OutOfMemoryError
    //   248	254	960	java/lang/OutOfMemoryError
    //   266	293	960	java/lang/OutOfMemoryError
    //   305	317	960	java/lang/OutOfMemoryError
    //   334	340	960	java/lang/OutOfMemoryError
    //   596	601	960	java/lang/OutOfMemoryError
    //   352	382	969	java/lang/OutOfMemoryError
    //   394	402	969	java/lang/OutOfMemoryError
    //   414	421	969	java/lang/OutOfMemoryError
    //   433	438	969	java/lang/OutOfMemoryError
    //   450	466	969	java/lang/OutOfMemoryError
    //   466	475	976	java/lang/OutOfMemoryError
    //   2	12	980	java/lang/Exception
    //   12	26	994	java/lang/Exception
    //   44	54	1005	java/lang/Exception
    //   66	78	1005	java/lang/Exception
    //   90	104	1005	java/lang/Exception
    //   116	124	1005	java/lang/Exception
    //   136	142	1005	java/lang/Exception
    //   154	185	1005	java/lang/Exception
    //   197	236	1005	java/lang/Exception
    //   248	254	1005	java/lang/Exception
    //   266	293	1005	java/lang/Exception
    //   305	317	1005	java/lang/Exception
    //   334	340	1005	java/lang/Exception
    //   596	601	1005	java/lang/Exception
    //   352	382	1014	java/lang/Exception
    //   394	402	1014	java/lang/Exception
    //   414	421	1014	java/lang/Exception
    //   433	438	1014	java/lang/Exception
    //   450	466	1014	java/lang/Exception
    //   466	475	1021	java/lang/Exception
  }
  
  private String uncompressZip(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "uncompressZip: bZip0 = " + paramBoolean + " srcFile = " + paramString);
    }
    Object localObject = new File(paramString);
    paramString = ((File)localObject).getParent() + File.separator;
    try
    {
      localObject = unZipFile((File)localObject, paramString);
      if (localObject != null)
      {
        paramString = paramString + (String)localObject;
        if (!QLog.isColorLevel()) {
          return paramString;
        }
        QLog.d("VasQuickUpdateEngine", 2, "uncompressZip result = " + paramString);
        return paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VasQuickUpdateEngine", 2, "uncompressZip fail");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateEngine", 2, "uncompressZip error : ", paramString);
        }
      }
    }
    return null;
    return paramString;
  }
  
  public void DBdeleteItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBdeleteItem: table = " + paramInt + " itemId = " + paramString);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).edit();
    localEditor.remove(paramString);
    if (!localEditor.commit()) {
      QLog.e("VasQuickUpdateEngine", 1, "DBdeleteItem table = " + paramInt + " itemId = " + paramString + " fail");
    }
  }
  
  public ArrayList<TagItemRecord> DBselectAllItems(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectAllItems: table = " + paramInt);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0);
    if (localObject1 == null) {}
    do
    {
      return null;
      localObject2 = ((SharedPreferences)localObject1).getAll();
    } while ((localObject2 == null) || (((Map)localObject2).size() <= 0));
    localObject1 = new ArrayList();
    Object localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      TagItemRecord localTagItemRecord = new TagItemRecord();
      localTagItemRecord.itemId = ((String)localEntry.getKey());
      localTagItemRecord.content = ((String)localEntry.getValue());
      ((ArrayList)localObject1).add(localTagItemRecord);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateEngine", 2, "DBselectAllItems table = " + paramInt + " itemId = " + localTagItemRecord.itemId + " content = " + localTagItemRecord.content);
      }
    }
    return localObject1;
  }
  
  public String DBselectItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectItem: table = " + paramInt + " itemId = " + paramString);
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).getString(paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectItem result = " + paramString);
    }
    return paramString;
  }
  
  public ArrayList<TagItemVersion> DBselectOldItems(int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectOldItems bids = " + paramArrayOfInt);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      i += 1;
    }
    return localArrayList;
  }
  
  public void DBupdateItem(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBupdateItem: table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).edit();
    localEditor.putString(paramString1, paramString2);
    if (!localEditor.commit()) {
      QLog.e("VasQuickUpdateEngine", 1, "DBupdateItem table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2 + " fail");
    }
  }
  
  void addPendingTask(PendingTask paramPendingTask)
  {
    synchronized (this.pendingTasks)
    {
      this.pendingTasks.add(paramPendingTask);
      if (this.engineReady.get()) {
        runPendingTasks();
      }
      return;
    }
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "canUpdate bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    aqsm localaqsm = aqsw.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "canUpdate: get null app " + paramString1);
    }
    return (localaqsm != null) && (localaqsm.canUpdate(localQQAppInterface, paramLong, paramString1, paramString2));
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (isSoLoadFail.get())
    {
      if (loadSoRetryTime < 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "downloadItem so load fail, retry " + (loadSoRetryTime + 1) + "time");
        }
        loadSo();
        loadSoRetryTime += 1;
        removePendingTask(new DownloadTask(paramLong, paramString, null));
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("VasQuickUpdateEngine", 2, "downloadItem so load fail, has retried 2 times");
      return;
    }
    if (!this.engineReady.get())
    {
      removePendingTask(new DownloadTask(paramLong, paramString, null));
      return;
    }
    nativeCancelDownload(this.mUpdateManagerInstance, paramLong, paramString);
  }
  
  public void cancelQuery(VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    removePendingTask(new QueryTask(0, "", false, paramQueryItemVersionCallback));
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "deleteFiles bid = " + paramLong + " scid = " + paramString);
    }
    aqsm localaqsm = aqsw.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "deleteFiles: get null app " + paramString);
    }
    return (localaqsm != null) && (localaqsm.deleteFiles(localQQAppInterface, paramLong, paramString));
  }
  
  public void doLoad()
  {
    if ((!hasSoLoaded.get()) || (isSoLoadFail.get())) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getApplication(), "c++_shared", 0, false);
        }
        if (!SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getApplication(), "xplatform", 0, false)) {
          continue;
        }
        boolean bool = SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getApplication(), "vasscupdate", 0, false);
        if (!bool) {
          continue;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VasQuickUpdateEngine", 1, "load lib fail: ", localThrowable);
        isSoLoadFail.set(true);
        int i = 0;
        continue;
      }
      hasSoLoaded.set(true);
      if (i != 0)
      {
        isSoLoadFail.set(false);
        initEngine(ENGINE_CONFIG_PATH);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateEngine", 2, "async loadso");
      }
      return;
      i = 0;
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + paramArrayOfString + " from = " + paramString2);
    }
    if (this.mUpdateManagerInstance != 0L) {
      nativeDownloadGatherItem(this.mUpdateManagerInstance, paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (isSoLoadFail.get())
    {
      if (loadSoRetryTime < 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "downloadItem so load fail, retry " + (loadSoRetryTime + 1) + "time");
        }
        loadSo();
        loadSoRetryTime += 1;
        addPendingTask(new DownloadTask(paramLong, paramString1, paramString2));
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("VasQuickUpdateEngine", 2, "downloadItem so load fail, has retried 2 times");
      return;
    }
    if (!this.engineReady.get())
    {
      addPendingTask(new DownloadTask(paramLong, paramString1, paramString2));
      return;
    }
    nativeDownloadItem(this.mUpdateManagerInstance, paramLong, paramString1, paramString2);
  }
  
  public ArrayList<String> getDirectConnectIpsByHost(String paramString)
  {
    boolean bool = ahbr.amL();
    Object localObject = aopd.a();
    if (bool) {}
    for (int i = 28;; i = 1)
    {
      localObject = ((aopd)localObject).a(paramString, 1014, true, i);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateEngine", 2, "getDirectConnectIpsByHost host = " + paramString + " isIPv6 = " + bool + " ip = " + localObject);
      }
      return localObject;
    }
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString);
    }
    aqsm localaqsm = aqsw.a(paramLong);
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QLog.e("VasQuickUpdateEngine", 1, "getItemInfo: get null app " + paramString);
    }
    if (localaqsm == null) {
      return null;
    }
    return localaqsm.getItemInfo(localQQAppInterface, paramLong, paramString);
  }
  
  public native void nativeCancelDownload(long paramLong1, long paramLong2, String paramString);
  
  public native long nativeCreateManager(String paramString1, String paramString2, int paramInt);
  
  public native void nativeDestroyManager(long paramLong);
  
  public native void nativeDownloadGatherItem(long paramLong1, long paramLong2, String paramString1, String[] paramArrayOfString, String paramString2);
  
  public native void nativeDownloadItem(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  public native void nativeOnPbMsgRecv(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public native void nativeRegisterUpdateItem(long paramLong1, long paramLong2, String paramString);
  
  public native void nativeSetLocalInfo(long paramLong, String paramString1, String paramString2, String paramString3);
  
  public native void nativeStartPreloadDownload(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4);
  
  public native void nativeUnregisterUpdateItem(long paramLong1, long paramLong2, String paramString);
  
  public native void nativequeryItemVer(long paramLong, int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback);
  
  public native void nativeupdateAllItem(long paramLong);
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("VasQuickUpdateEngine", 1, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " dlFrom = " + paramInt1 + " errorCode = " + paramInt2 + " httpCode = " + paramInt3);
    aqsm localaqsm = aqsw.a(paramLong);
    if (localaqsm != null)
    {
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        QLog.e("VasQuickUpdateEngine", 1, "onCompleted: get null app " + paramString1);
      }
      localaqsm.onCompleted(localQQAppInterface, paramLong, paramString1, paramString2, paramString3, paramInt2, paramInt3);
    }
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    if (this.mUpdateManagerInstance != 0L) {
      nativeOnPbMsgRecv(this.mUpdateManagerInstance, paramInt, paramString1, paramString2);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "onProgress bid = " + paramLong1 + " scid = " + paramString1 + " cfgScid = " + paramString2 + "dwProgress = " + paramLong2 + " dwProgressMax = " + paramLong3);
    }
    aqsm localaqsm = aqsw.a(paramLong1);
    if (localaqsm != null)
    {
      QQAppInterface localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        QLog.e("VasQuickUpdateEngine", 1, "onProgress: get null app " + paramString1);
      }
      localaqsm.onProgress(localQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    if (this.engineReady.get())
    {
      nativequeryItemVer(this.mUpdateManagerInstance, paramInt, paramString, paramBoolean, paramQueryItemVersionCallback);
      return;
    }
    addPendingTask(new QueryTask(paramInt, paramString, paramBoolean, paramQueryItemVersionCallback));
  }
  
  void removePendingTask(PendingTask paramPendingTask)
  {
    for (;;)
    {
      int i;
      synchronized (this.pendingTasks)
      {
        i = this.pendingTasks.size() - 1;
        if (i >= 0)
        {
          PendingTask localPendingTask = (PendingTask)this.pendingTasks.get(i);
          if ((localPendingTask.getClass() == paramPendingTask.getClass()) && (localPendingTask.equals(paramPendingTask))) {
            this.pendingTasks.remove(i);
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  void runPendingTasks()
  {
    ArrayList localArrayList = this.pendingTasks;
    int i = 0;
    try
    {
      while (i < this.pendingTasks.size())
      {
        ((PendingTask)this.pendingTasks.get(i)).run(this);
        i += 1;
      }
      this.pendingTasks.clear();
      return;
    }
    finally {}
  }
  
  public static class DownloadTask
    extends VasQuickUpdateEngine.PendingTask
  {
    public DownloadTask(long paramLong, String paramString1, String paramString2)
    {
      this.bid = paramLong;
      this.scid = paramString1;
      this.from = paramString2;
    }
    
    public void run(VasQuickUpdateEngine paramVasQuickUpdateEngine)
    {
      paramVasQuickUpdateEngine.downloadItem(this.bid, this.scid, this.from);
    }
  }
  
  public static abstract class PendingTask
  {
    public long bid;
    public String from;
    public String scid;
    
    public boolean equals(PendingTask paramPendingTask)
    {
      return (this.bid == paramPendingTask.bid) && (this.scid.equals(paramPendingTask.scid));
    }
    
    public abstract void run(VasQuickUpdateEngine paramVasQuickUpdateEngine);
  }
  
  public static class QueryTask
    extends VasQuickUpdateEngine.PendingTask
  {
    private VasQuickUpdateManager.QueryItemVersionCallback callback;
    private boolean isCfg;
    
    public QueryTask(int paramInt, String paramString, boolean paramBoolean, VasQuickUpdateManager.QueryItemVersionCallback paramQueryItemVersionCallback)
    {
      this.bid = paramInt;
      this.scid = paramString;
      this.isCfg = paramBoolean;
      this.callback = paramQueryItemVersionCallback;
    }
    
    public boolean equals(VasQuickUpdateEngine.PendingTask paramPendingTask)
    {
      paramPendingTask = (QueryTask)paramPendingTask;
      return this.callback == paramPendingTask.callback;
    }
    
    public void run(VasQuickUpdateEngine paramVasQuickUpdateEngine)
    {
      paramVasQuickUpdateEngine.queryItemVersion((int)this.bid, this.scid, this.isCfg, this.callback);
    }
  }
  
  public static class TagItemInfo
  {
    public boolean bPreConfig;
    public boolean bSaveInDir;
    public String strSavePath;
  }
  
  public class TagItemRecord
  {
    public String content;
    public String itemId;
    
    public TagItemRecord() {}
  }
  
  public class TagItemVersion
  {
    String itemCfgId;
    String itemId;
    String md5;
    
    public TagItemVersion() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine
 * JD-Core Version:    0.7.0.1
 */