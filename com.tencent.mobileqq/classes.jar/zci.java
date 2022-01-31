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

public class zci
  implements Handler.Callback, aysb, aysc, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, aysy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public zci(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  private void a(aysz paramaysz)
  {
    zcj localzcj = (zcj)paramaysz.jdField_a_of_type_Aysy.a();
    if ((localzcj == null) || (localzcj.jdField_a_of_type_Zcq == null))
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
    }
    if (paramaysz.jdField_a_of_type_Int == 3)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = localzcj.jdField_a_of_type_Long;
    String str3 = localzcj.jdField_a_of_type_Zcq.b();
    String str1 = localzcj.jdField_a_of_type_Zcq.c();
    int i = localzcj.jdField_a_of_type_Zcq.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramaysz.jdField_a_of_type_Int + ", mTotalFileLen=" + paramaysz.jdField_a_of_type_Long + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
    String str2 = PatchCommonUtil.getPatchPath(str1);
    Object localObject = PatchCommonUtil.getPatchPath(str3);
    for (;;)
    {
      try
      {
        if ((paramaysz.jdField_a_of_type_Int != 0) || (paramaysz.jdField_a_of_type_Long != i)) {
          break label397;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!localzcj.jdField_a_of_type_Zcq.b())
        {
          bool1 = bool2;
          if (PatchCommonUtil.isArtGeN()) {
            bool1 = zck.a(localzcj.jdField_a_of_type_Zcq);
          }
        }
        bool2 = bool1;
        if (bool1) {
          bool2 = PatchChecker.checkPatchValid(localzcj.jdField_a_of_type_JavaLangString, str3);
        }
        if (bool2)
        {
          a(localzcj.jdField_a_of_type_Zcq);
          xop.c();
          xop.a(ajya.a(2131707910));
          new DexClassLoader((String)localObject, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject, BaseApplicationImpl.sApplication.getClassLoader());
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
          return;
        }
      }
      catch (Throwable paramaysz)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramaysz);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      paramaysz = new File((String)localObject);
      if (paramaysz.exists())
      {
        paramaysz.delete();
        continue;
        label397:
        if (paramaysz.jdField_a_of_type_Int != 0)
        {
          str3 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramaysz.b + ", mErrDesc=" + paramaysz.jdField_a_of_type_JavaLangString;
          QLog.d("PatchLogTag", 1, str3);
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 4);
          l1 = ((SharedPreferences)localObject).getLong("patch_download_fail_report_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > 21600000L)
          {
            axpu.a(new RuntimeException(), str3);
            ((SharedPreferences)localObject).edit().putLong("patch_download_fail_report_time", l2).commit();
          }
          if ((paramaysz.b == 9039) || (paramaysz.b == 9301))
          {
            paramaysz = new File(paramaysz.jdField_a_of_type_Aysy.d);
            QLog.d("PatchLogTag", 1, "write temp patch fail path=" + paramaysz.getAbsolutePath() + ", isExist=" + paramaysz.exists() + ", canWrite=" + paramaysz.canWrite());
          }
        }
        if (localzcj.jdField_a_of_type_Int < 3)
        {
          a(localzcj.jdField_a_of_type_Int, localzcj.jdField_a_of_type_JavaLangString, localzcj.jdField_a_of_type_Zcq);
          return;
        }
        xop.c();
        paramaysz = new File(str2);
        if (paramaysz.exists()) {
          paramaysz.delete();
        }
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
      }
    }
  }
  
  /* Error */
  private void a(zcq paramzcq)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 133	zcq:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 91	zcq:b	()Ljava/lang/String;
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
    //   117: invokestatic 320	zch:a	(Ljava/io/InputStream;Ljava/io/File;)V
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
    //   139: invokestatic 320	zch:a	(Ljava/io/InputStream;Ljava/io/File;)V
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
    //   161: invokestatic 320	zch:a	(Ljava/io/InputStream;Ljava/io/File;)V
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
    //   226: invokestatic 320	zch:a	(Ljava/io/InputStream;Ljava/io/File;)V
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
    //   263: invokestatic 320	zch:a	(Ljava/io/InputStream;Ljava/io/File;)V
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
    //   0	322	0	this	zci
    //   0	322	1	paramzcq	zcq
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
  
  public void a(int paramInt, String paramString, zcq paramzcq)
  {
    String str1 = paramzcq.d();
    String str2 = paramzcq.c();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str2 + ", downloadUrl=" + str1);
    if ((paramInt < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str2))) {
      return;
    }
    aysa localaysa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_Aysb = this;
    localayrx.jdField_a_of_type_JavaLangString = str1;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = PatchCommonUtil.getPatchPath(str2);
    localayrx.a(new zcj(this, paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramzcq));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str2, localayrx);
    localaysa.a(localayrx);
  }
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    while (!(paramaysy instanceof ayrx)) {
      return;
    }
    paramaysy = (ayrx)paramaysy;
    paramaysy.jdField_a_of_type_Long += paramaysz.c;
    paramaysz.c = 0L;
    paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + paramaysy.jdField_a_of_type_Long + "-");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((aysz)paramMessage.obj);
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
  
  public void onResp(aysz paramaysz)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramaysz).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramaysy).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zci
 * JD-Core Version:    0.7.0.1
 */