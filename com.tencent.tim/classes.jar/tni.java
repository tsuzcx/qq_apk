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

public class tni
  implements Handler.Callback, aolm.a, aolm.b, Manager
{
  private Handler bG;
  private ConcurrentHashMap<String, aomg> cK = new ConcurrentHashMap();
  private QQAppInterface mAppInterface;
  
  public tni(QQAppInterface paramQQAppInterface)
  {
    this.mAppInterface = paramQQAppInterface;
    this.bG = new Handler(ThreadManager.getFileThreadLooper(), this);
  }
  
  private void a(aomh paramaomh)
  {
    tni.a locala = (tni.a)paramaomh.b.U();
    if ((locala == null) || (locala.b == null))
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp requestData is null");
      return;
    }
    if (paramaomh.mResult == 3)
    {
      QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp is downloading");
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = locala.startTime;
    String str3 = locala.b.ot();
    String str1 = locala.b.ou();
    int i = locala.b.uZ();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp reslut=" + paramaomh.mResult + ", mTotalFileLen=" + paramaomh.apU + ", downloadPatchSize=" + i + ", cost time=" + (l1 - l2));
    String str2 = PatchCommonUtil.getPatchPath(str1);
    Object localObject = PatchCommonUtil.getPatchPath(str3);
    for (;;)
    {
      try
      {
        if ((paramaomh.mResult != 0) || (paramaomh.apU != i)) {
          break label397;
        }
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!locala.b.Ol())
        {
          bool1 = bool2;
          if (PatchCommonUtil.isArtGeN()) {
            bool1 = tnj.a(locala.b);
          }
        }
        bool2 = bool1;
        if (bool1) {
          bool2 = PatchChecker.checkPatchValid(locala.patchType, str3);
        }
        if (bool2)
        {
          b(locala.b);
          swu.bBB();
          swu.showToastForSafeModeTest(acfp.m(2131709411));
          new DexClassLoader((String)localObject, BaseApplicationImpl.sApplication.getDir("dex", 0).getAbsolutePath(), (String)localObject, BaseApplicationImpl.sApplication.getClassLoader());
          PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.mAppInterface.getCurrentAccountUin(), "actPatchDownload", 200, str1);
          this.cK.remove(str1);
          return;
        }
      }
      catch (Throwable paramaomh)
      {
        QLog.d("PatchLogTag", 1, "PatchDownloadManager doOnResp throwable=" + paramaomh);
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.mAppInterface.getCurrentAccountUin(), "actPatchDownload", 202, str1);
        return;
      }
      paramaomh = new File((String)localObject);
      if (paramaomh.exists())
      {
        paramaomh.delete();
        continue;
        label397:
        if (paramaomh.mResult != 0)
        {
          str3 = "PatchDownloadManager doOnResp NOT ResultOk mErrCode=" + paramaomh.mErrCode + ", mErrDesc=" + paramaomh.clO;
          QLog.d("PatchLogTag", 1, str3);
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences("hotpatch_preference", 4);
          l1 = ((SharedPreferences)localObject).getLong("patch_download_fail_report_time", 0L);
          l2 = System.currentTimeMillis();
          if (l2 - l1 > 21600000L)
          {
            annt.e(new RuntimeException(), str3);
            ((SharedPreferences)localObject).edit().putLong("patch_download_fail_report_time", l2).commit();
          }
          if ((paramaomh.mErrCode == 9039) || (paramaomh.mErrCode == 9301))
          {
            paramaomh = new File(paramaomh.b.mTempPath);
            QLog.d("PatchLogTag", 1, "write temp patch fail path=" + paramaomh.getAbsolutePath() + ", isExist=" + paramaomh.exists() + ", canWrite=" + paramaomh.canWrite());
          }
        }
        if (locala.retryCount < 3)
        {
          a(locala.retryCount, locala.patchType, locala.b);
          return;
        }
        swu.bBB();
        paramaomh = new File(str2);
        if (paramaomh.exists()) {
          paramaomh.delete();
        }
        PatchReporter.reportPatchEvent(BaseApplicationImpl.sApplication, this.mAppInterface.getCurrentAccountUin(), "actPatchDownload", 201, str1);
      }
    }
  }
  
  /* Error */
  private void b(tnp paramtnp)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 144	tnp:Ol	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 98	tnp:ot	()Ljava/lang/String;
    //   12: invokestatic 140	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: new 314	com/tencent/commonsdk/zip/QZipFile
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 315	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: new 196	java/io/File
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 318	java/io/File:getParent	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: ldc_w 320
    //   45: invokevirtual 324	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   48: astore 4
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: ldc_w 326
    //   56: invokevirtual 324	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore 5
    //   61: aload_2
    //   62: astore_1
    //   63: aload_2
    //   64: ldc_w 328
    //   67: invokevirtual 324	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   70: astore 6
    //   72: aload 4
    //   74: ifnull +90 -> 164
    //   77: aload 5
    //   79: ifnull +85 -> 164
    //   82: aload 6
    //   84: ifnull +80 -> 164
    //   87: aload_2
    //   88: astore_1
    //   89: ldc 68
    //   91: iconst_1
    //   92: ldc_w 330
    //   95: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: aload 4
    //   103: invokevirtual 334	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   106: new 196	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: ldc_w 320
    //   114: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: invokestatic 343	tnh:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   120: aload_2
    //   121: astore_1
    //   122: aload_2
    //   123: aload 5
    //   125: invokevirtual 334	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   128: new 196	java/io/File
    //   131: dup
    //   132: aload_3
    //   133: ldc_w 326
    //   136: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: invokestatic 343	tnh:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   142: aload_2
    //   143: astore_1
    //   144: aload_2
    //   145: aload 6
    //   147: invokevirtual 334	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   150: new 196	java/io/File
    //   153: dup
    //   154: aload_3
    //   155: ldc_w 328
    //   158: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: invokestatic 343	tnh:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload_2
    //   167: ldc_w 345
    //   170: invokevirtual 324	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +52 -> 229
    //   180: aload_2
    //   181: astore_1
    //   182: ldc 68
    //   184: iconst_1
    //   185: ldc_w 347
    //   188: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_2
    //   192: astore_1
    //   193: new 196	java/io/File
    //   196: dup
    //   197: aload_3
    //   198: ldc_w 345
    //   201: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: astore 5
    //   206: aload_2
    //   207: astore_1
    //   208: aload 5
    //   210: invokevirtual 233	java/io/File:exists	()Z
    //   213: ifne +31 -> 244
    //   216: aload_2
    //   217: astore_1
    //   218: aload_2
    //   219: aload 4
    //   221: invokevirtual 334	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   224: aload 5
    //   226: invokestatic 343	tnh:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   229: aload_2
    //   230: ifnull -223 -> 7
    //   233: aload_2
    //   234: invokevirtual 350	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   237: return
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   243: return
    //   244: aload_2
    //   245: astore_1
    //   246: aload_2
    //   247: aload 4
    //   249: invokevirtual 334	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   252: new 196	java/io/File
    //   255: dup
    //   256: aload_3
    //   257: ldc_w 355
    //   260: invokespecial 337	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: invokestatic 343	tnh:copy	(Ljava/io/InputStream;Ljava/io/File;)V
    //   266: goto -37 -> 229
    //   269: astore_3
    //   270: aload_2
    //   271: astore_1
    //   272: aload_3
    //   273: invokevirtual 356	java/lang/Throwable:printStackTrace	()V
    //   276: aload_2
    //   277: ifnull -270 -> 7
    //   280: aload_2
    //   281: invokevirtual 350	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   284: return
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   290: return
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 350	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   302: aload_2
    //   303: athrow
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   309: goto -7 -> 302
    //   312: astore_2
    //   313: goto -19 -> 294
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_2
    //   319: goto -49 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	tni
    //   0	322	1	paramtnp	tnp
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
  
  public void a(int paramInt, String paramString, tnp paramtnp)
  {
    String str1 = paramtnp.ov();
    String str2 = paramtnp.ou();
    QLog.d("PatchLogTag", 1, "PatchDownloadManager tryDownloadPatch retryCount=" + paramInt + ", downloadPatchName=" + str2 + ", downloadUrl=" + str1);
    if ((paramInt < 3) && (this.cK.contains(str2))) {
      return;
    }
    aolm localaolm = this.mAppInterface.getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.a = this;
    localaoll.bZ = str1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = PatchCommonUtil.getPatchPath(str2);
    localaoll.bw(new tni.a(paramInt + 1, SystemClock.elapsedRealtime(), paramString, paramtnp));
    this.cK.put(str2, localaoll);
    localaolm.a(localaoll);
  }
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    while (!(paramaomg instanceof aoll)) {
      return;
    }
    paramaomg = (aoll)paramaomg;
    paramaomg.apS += paramaomh.apW;
    paramaomh.apW = 0L;
    paramaomg.u.put("Range", "bytes=" + paramaomg.apS + "-");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((aomh)paramMessage.obj);
      continue;
      QLog.d("PatchLogTag", 1, "PatchDownloadManager patch download on progress curOffset=" + paramMessage.arg1 + ", totalLen=" + paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.bG != null)
    {
      this.bG.removeCallbacksAndMessages(null);
      this.bG = null;
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (this.bG != null) {
      this.bG.obtainMessage(1, paramaomh).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.bG.obtainMessage(2, (int)paramLong1, (int)paramLong2, paramaomg).sendToTarget();
  }
  
  class a
  {
    public tnp b;
    public String patchType;
    public int retryCount;
    public long startTime;
    
    public a(int paramInt, long paramLong, String paramString, tnp paramtnp)
    {
      this.retryCount = paramInt;
      this.startTime = paramLong;
      this.patchType = paramString;
      this.b = paramtnp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tni
 * JD-Core Version:    0.7.0.1
 */