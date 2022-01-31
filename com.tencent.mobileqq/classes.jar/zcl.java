import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchChecker;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class zcl
  implements Handler.Callback, ayrz, aysa, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aysw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public zcl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  private void a(aysx paramaysx)
  {
    zcm localzcm = (zcm)paramaysx.jdField_a_of_type_Aysw.a();
    if ((localzcm == null) || (localzcm.jdField_a_of_type_Zct == null))
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
    }
    if (paramaysx.jdField_a_of_type_Int == 3)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = localzcm.jdField_a_of_type_Long;
    String str3 = localzcm.jdField_a_of_type_Zct.b();
    String str1 = localzcm.jdField_a_of_type_Zct.c();
    int i = localzcm.jdField_a_of_type_Zct.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramaysx.jdField_a_of_type_Int + ", mTotalFileLen=" + paramaysx.jdField_a_of_type_Long + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
    String str2 = PatchCommonUtil.getPatchPath(str1);
    Object localObject = PatchCommonUtil.getPatchPath(str3);
    for (;;)
    {
      try
      {
        if ((paramaysx.jdField_a_of_type_Int != 0) || (paramaysx.jdField_a_of_type_Long != i)) {
          break label397;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!localzcm.jdField_a_of_type_Zct.b())
        {
          bool1 = bool2;
          if (PatchCommonUtil.isArtGeN()) {
            bool1 = zcn.a(localzcm.jdField_a_of_type_Zct);
          }
        }
        bool2 = bool1;
        if (bool1) {
          bool2 = PatchChecker.checkPatchValid(localzcm.jdField_a_of_type_JavaLangString, str3);
        }
        if (bool2)
        {
          a(localzcm.jdField_a_of_type_Zct);
          xos.c();
          xos.a(ajyc.a(2131707899));
          new DexClassLoader((String)localObject, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject, BaseApplicationImpl.sApplication.getClassLoader());
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          return;
        }
      }
      catch (Throwable paramaysx)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramaysx);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      paramaysx = new File((String)localObject);
      if (paramaysx.exists())
      {
        paramaysx.delete();
        continue;
        label397:
        if (paramaysx.jdField_a_of_type_Int != 0)
        {
          str3 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramaysx.b + ", mErrDesc=" + paramaysx.jdField_a_of_type_JavaLangString;
          QLog.d("PatchLogTag", 1, str3);
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 4);
          l1 = ((SharedPreferences)localObject).getLong("patch_download_fail_report_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > 21600000L)
          {
            axps.a(new RuntimeException(), str3);
            ((SharedPreferences)localObject).edit().putLong("patch_download_fail_report_time", l2).commit();
          }
          if ((paramaysx.b == 9039) || (paramaysx.b == 9301))
          {
            paramaysx = new File(paramaysx.jdField_a_of_type_Aysw.d);
            QLog.d("PatchLogTag", 1, "write temp patch fail path=" + paramaysx.getAbsolutePath() + ", isExist=" + paramaysx.exists() + ", canWrite=" + paramaysx.canWrite());
          }
        }
        if (localzcm.jdField_a_of_type_Int < 3)
        {
          a(localzcm.jdField_a_of_type_Int, localzcm.jdField_a_of_type_JavaLangString, localzcm.jdField_a_of_type_Zct);
          return;
        }
        xos.c();
        paramaysx = new File(str2);
        if (paramaysx.exists()) {
          paramaysx.delete();
        }
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
      }
    }
  }
  
  /* Error */
  private void a(zct paramzct)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 133	zct:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 91	zct:b	()Ljava/lang/String;
    //   12: invokestatic 130	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: new 292	com/tencent/commonsdk/zip/QZipFile
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 293	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: new 181	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 296	java/io/File:getParent	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: ldc_w 298
    //   45: invokevirtual 302	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   48: astore 4
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: ldc_w 304
    //   56: invokevirtual 302	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore 5
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: ldc_w 306
    //   67: invokevirtual 302	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   70: astore 6
    //   72: aload 4
    //   74: ifnull +90 -> 164
    //   77: aload 5
    //   79: ifnull +85 -> 164
    //   82: aload 6
    //   84: ifnull +80 -> 164
    //   87: aload_2
    //   88: astore_1
    //   89: ldc 63
    //   91: iconst_1
    //   92: ldc_w 308
    //   95: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: aload 4
    //   103: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   106: new 181	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 298
    //   114: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: invokestatic 320	zck:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   120: aload_2
    //   121: astore_1
    //   122: aload_2
    //   123: aload 5
    //   125: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   128: new 181	java/io/File
    //   131: dup
    //   132: aload_3
    //   133: ldc_w 304
    //   136: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: invokestatic 320	zck:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   142: aload_2
    //   143: astore_1
    //   144: aload_2
    //   145: aload 6
    //   147: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   150: new 181	java/io/File
    //   153: dup
    //   154: aload_3
    //   155: ldc_w 306
    //   158: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: invokestatic 320	zck:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload_2
    //   167: ldc_w 322
    //   170: invokevirtual 302	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +52 -> 229
    //   180: aload_2
    //   181: astore_1
    //   182: ldc 63
    //   184: iconst_1
    //   185: ldc_w 324
    //   188: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_2
    //   192: astore_1
    //   193: new 181	java/io/File
    //   196: dup
    //   197: aload_3
    //   198: ldc_w 322
    //   201: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: astore 5
    //   206: aload_2
    //   207: astore_1
    //   208: aload 5
    //   210: invokevirtual 218	java/io/File:exists	()Z
    //   213: ifne +31 -> 244
    //   216: aload_2
    //   217: astore_1
    //   218: aload_2
    //   219: aload 4
    //   221: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   224: aload 5
    //   226: invokestatic 320	zck:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   229: aload_2
    //   230: ifnull -223 -> 7
    //   233: aload_2
    //   234: invokevirtual 327	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   237: return
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 330	java/io/IOException:printStackTrace	()V
    //   243: return
    //   244: aload_2
    //   245: astore_1
    //   246: aload_2
    //   247: aload 4
    //   249: invokevirtual 312	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   252: new 181	java/io/File
    //   255: dup
    //   256: aload_3
    //   257: ldc_w 332
    //   260: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: invokestatic 320	zck:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   266: goto -37 -> 229
    //   269: astore_3
    //   270: aload_2
    //   271: astore_1
    //   272: aload_3
    //   273: invokevirtual 333	java/lang/Throwable:printStackTrace	()V
    //   276: aload_2
    //   277: ifnull -270 -> 7
    //   280: aload_2
    //   281: invokevirtual 327	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   284: return
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 330	java/io/IOException:printStackTrace	()V
    //   290: return
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 327	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   302: aload_2
    //   303: athrow
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 330	java/io/IOException:printStackTrace	()V
    //   309: goto -7 -> 302
    //   312: astore_2
    //   313: goto -19 -> 294
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_2
    //   319: goto -49 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	zcl
    //   0	322	1	paramzct	zct
    //   24	257	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   291	12	2	localObject1	Object
    //   312	1	2	localObject2	Object
    //   318	1	2	localObject3	Object
    //   15	242	3	str	String
    //   269	4	3	localThrowable1	Throwable
    //   316	1	3	localThrowable2	Throwable
    //   48	200	4	localZipEntry1	java.util.zip.ZipEntry
    //   59	166	5	localObject4	Object
    //   70	76	6	localZipEntry2	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   233	237	238	java/io/IOException
    //   27	39	269	java/lang/Throwable
    //   41	50	269	java/lang/Throwable
    //   52	61	269	java/lang/Throwable
    //   63	72	269	java/lang/Throwable
    //   89	98	269	java/lang/Throwable
    //   100	120	269	java/lang/Throwable
    //   122	142	269	java/lang/Throwable
    //   144	164	269	java/lang/Throwable
    //   166	175	269	java/lang/Throwable
    //   182	191	269	java/lang/Throwable
    //   193	206	269	java/lang/Throwable
    //   208	216	269	java/lang/Throwable
    //   218	229	269	java/lang/Throwable
    //   246	266	269	java/lang/Throwable
    //   280	284	285	java/io/IOException
    //   8	25	291	finally
    //   298	302	304	java/io/IOException
    //   27	39	312	finally
    //   41	50	312	finally
    //   52	61	312	finally
    //   63	72	312	finally
    //   89	98	312	finally
    //   100	120	312	finally
    //   122	142	312	finally
    //   144	164	312	finally
    //   166	175	312	finally
    //   182	191	312	finally
    //   193	206	312	finally
    //   208	216	312	finally
    //   218	229	312	finally
    //   246	266	312	finally
    //   272	276	312	finally
    //   8	25	316	java/lang/Throwable
  }
  
  public void a(int paramInt, String paramString, zct paramzct)
  {
    String str1 = paramzct.d();
    String str2 = paramzct.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str2 + ", downloadUrl=" + str1);
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str2))) {
      return;
    }
    ayry localayry = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_Ayrz = this;
    localayrv.jdField_a_of_type_JavaLangString = str1;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = PatchCommonUtil.getPatchPath(str2);
    localayrv.a(new zcm(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramzct));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localayrv);
    localayry.a(localayrv);
  }
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    while (!(paramaysw instanceof ayrv)) {
      return;
    }
    paramaysw = (ayrv)paramaysw;
    paramaysw.jdField_a_of_type_Long += paramaysx.c;
    paramaysx.c = 0L;
    paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + paramaysw.jdField_a_of_type_Long + "-");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((aysx)paramMessage.obj);
      continue;
      QLog.d("PatchLogTag", 1, "PatchDownloadManager patch download on progress curOffset=" + paramMessage.arg1 + ", totalLen=" + paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramaysx).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramaysw).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zcl
 * JD-Core Version:    0.7.0.1
 */