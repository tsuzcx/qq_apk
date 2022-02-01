package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import aqiz;
import arvv;
import aryx;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import jzk;
import knc;
import knl;
import mqq.os.MqqHandler;
import mrm;
import mrn;
import mro;
import mrx;
import mtg.b;
import mtg.g;
import mtg.l;
import org.json.JSONException;
import org.json.JSONObject;
import tky;
import tll;

public class ADVideoAppDownloadManager
  implements aryx
{
  private static AtomicInteger W = new AtomicInteger(0);
  private mro jdField_a_of_type_Mro;
  private mtg.b jdField_a_of_type_Mtg$b;
  private mtg.g jdField_a_of_type_Mtg$g;
  private int aTQ;
  private boolean anB;
  private boolean anC;
  private ITMAssistantDownloadClientListener b = new mrn(this);
  protected ConcurrentHashMap<String, mrm> bs = new ConcurrentHashMap();
  private mrm c;
  private Runnable cL = new ADVideoAppDownloadManager.1(this);
  protected List<mrm> fP = new CopyOnWriteArrayList();
  private boolean isLoadingAppData;
  protected List<LoadTask> jx = new CopyOnWriteArrayList();
  private Context mContext;
  private Handler mSubHandler;
  
  public ADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.anB = paramBoolean;
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private int a(Context paramContext, mrm parammrm)
  {
    if ((paramContext == null) || (parammrm == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = parammrm.mPackageName;
          parammrm = parammrm.mAppID;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(parammrm))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + parammrm + " false");
        return -1;
        localDownloadInfo = arvv.a().f(paramContext);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + parammrm + " false");
      return -1;
      if (localDownloadInfo.getState() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + parammrm + " true");
        }
        return localDownloadInfo.progress;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + parammrm + " false");
    return -1;
  }
  
  private void a(Activity paramActivity, mrm parammrm)
  {
    if ((paramActivity == null) || (parammrm == null)) {
      return;
    }
    paramActivity = new WeakReference(paramActivity);
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.2(this, parammrm, paramActivity));
  }
  
  private boolean a(Context paramContext, mrm parammrm)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (parammrm != null) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = parammrm.mPackageName;
            str2 = parammrm.mAppID;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = arvv.a().f(str1);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      parammrm = "";
      if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
        break;
      }
      parammrm = localDownloadInfo.filePath;
      bool1 = bool3;
      if (!TextUtils.isEmpty(parammrm))
      {
        bool1 = bool3;
        if (new File(parammrm).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + parammrm);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.downloadType == 0)
    {
      localTMAssistantDownloadTaskInfo2 = arvv.a().b(localDownloadInfo.urlStr);
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().a(localDownloadInfo);
        parammrm = paramContext;
      }
    }
    for (;;)
    {
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.filePath = paramContext;
      localDownloadInfo.setState(4);
      arvv.a().j(localDownloadInfo);
      parammrm = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = arvv.a().a(localDownloadInfo);
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().b(localDownloadInfo.urlStr);
        parammrm = paramContext;
      }
    }
  }
  
  private void aBt()
  {
    this.mSubHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jx.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.removeJobFromThreadPool((LoadTask)localIterator.next(), 128);
    }
    ThreadManager.removeJobFromThreadPool(this.cL, 128);
    this.isLoadingAppData = false;
    this.aTQ = 0;
    this.jdField_a_of_type_Mtg$b = null;
    this.c = null;
  }
  
  private String c(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject == null) {
          break label107;
        }
        paramJSONObject = paramJSONObject.optString("dstlink");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramJSONObject = "";
          continue;
          paramJSONObject = "";
        }
      }
      localObject = paramJSONObject;
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ADVideoAppDownloadManager", 2, " parseDestLinkJson destLink = " + paramJSONObject);
          return paramJSONObject;
        }
      }
      catch (Exception localException1) {}
    }
    localException1.printStackTrace();
    QLog.d("ADVideoAppDownloadManager", 1, "parseDestLinkJson exception :" + localException1.toString());
    return paramJSONObject;
  }
  
  private String converStreamToString(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  private void reprtAppDataLoad(boolean paramBoolean, long paramLong) {}
  
  /* Error */
  private String z(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +39 -> 58
    //   22: ldc 118
    //   24: iconst_2
    //   25: new 120	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 335
    //   35: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 337
    //   45: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: new 120	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 342
    //   72: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +29 -> 111
    //   85: ldc 118
    //   87: iconst_2
    //   88: new 120	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 344
    //   98: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: new 346	java/net/URL
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 347	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 351	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   122: checkcast 353	java/net/HttpURLConnection
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 355
    //   130: invokevirtual 358	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: ldc_w 360
    //   137: ldc_w 362
    //   140: invokevirtual 366	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_3
    //   144: ldc_w 368
    //   147: ldc_w 370
    //   150: invokevirtual 366	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_3
    //   154: ldc_w 372
    //   157: ldc_w 374
    //   160: invokevirtual 366	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_3
    //   164: sipush 3000
    //   167: invokevirtual 377	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   170: aload_3
    //   171: sipush 3000
    //   174: invokevirtual 380	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   177: aload_3
    //   178: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   181: sipush 200
    //   184: if_icmpne +106 -> 290
    //   187: aload_0
    //   188: aload_3
    //   189: invokevirtual 387	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   192: invokespecial 389	com/tencent/biz/pubaccount/readinjoy/video/ADVideoAppDownloadManager:converStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   195: astore_1
    //   196: aload_1
    //   197: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +29 -> 229
    //   203: aload_0
    //   204: new 290	org/json/JSONObject
    //   207: dup
    //   208: aload_1
    //   209: invokespecial 390	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   212: invokespecial 392	com/tencent/biz/pubaccount/readinjoy/video/ADVideoAppDownloadManager:c	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   215: astore_1
    //   216: aload_1
    //   217: astore 4
    //   219: aload_3
    //   220: ifnull -207 -> 13
    //   223: aload_3
    //   224: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   227: aload_1
    //   228: areturn
    //   229: ldc 118
    //   231: iconst_1
    //   232: ldc_w 397
    //   235: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload 5
    //   240: astore_1
    //   241: goto -25 -> 216
    //   244: astore 5
    //   246: aload_3
    //   247: astore_1
    //   248: aload 5
    //   250: astore_3
    //   251: ldc 118
    //   253: iconst_1
    //   254: new 120	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 399
    //   264: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_3
    //   268: invokevirtual 308	java/lang/Exception:toString	()Ljava/lang/String;
    //   271: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_1
    //   281: ifnull -268 -> 13
    //   284: aload_1
    //   285: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   288: aconst_null
    //   289: areturn
    //   290: ldc 118
    //   292: iconst_1
    //   293: new 120	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 401
    //   303: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_3
    //   307: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   310: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 5
    //   321: astore_1
    //   322: goto -106 -> 216
    //   325: astore 4
    //   327: aload_3
    //   328: astore_1
    //   329: aload 4
    //   331: astore_3
    //   332: aload_1
    //   333: ifnull +7 -> 340
    //   336: aload_1
    //   337: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   340: aload_3
    //   341: athrow
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_1
    //   345: goto -13 -> 332
    //   348: astore_3
    //   349: goto -17 -> 332
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -104 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	ADVideoAppDownloadManager
    //   0	358	1	paramString	String
    //   0	358	2	paramInt	int
    //   125	216	3	localObject1	Object
    //   342	1	3	localObject2	Object
    //   348	1	3	localObject3	Object
    //   352	1	3	localException1	Exception
    //   4	214	4	str	String
    //   325	5	4	localObject4	Object
    //   1	238	5	localObject5	Object
    //   244	76	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   126	216	244	java/lang/Exception
    //   229	238	244	java/lang/Exception
    //   290	319	244	java/lang/Exception
    //   126	216	325	finally
    //   229	238	325	finally
    //   290	319	325	finally
    //   111	126	342	finally
    //   251	280	348	finally
    //   111	126	352	java/lang/Exception
  }
  
  protected int a(mrm parammrm)
  {
    if (parammrm != null) {
      return parammrm.mState;
    }
    return 0;
  }
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return;
      } while (this.c == null);
      this.jdField_a_of_type_Mro.p(this.c);
      return;
    case 3: 
      onDownloadUpdate(new ArrayList(1));
      return;
    case 5: 
      onDownloadFinish(paramDownloadInfo);
      return;
    case 1: 
      installSucceed(paramDownloadInfo.cCL, paramDownloadInfo.packageName);
      return;
    case 4: 
      onDownloadPause(paramDownloadInfo);
      return;
    }
    onDownloadError(paramDownloadInfo, 0, "", paramInt);
  }
  
  public void a(mrm parammrm, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + parammrm.mPackageName + " progress " + paramInt);
    }
    parammrm.mState = 3;
    this.jdField_a_of_type_Mro.e(parammrm, paramInt);
    Activity localActivity = (Activity)this.mContext;
    this.jdField_a_of_type_Mro.resumeDownload = true;
    a(localActivity, parammrm);
  }
  
  protected void a(mrm parammrm, int paramInt1, int paramInt2) {}
  
  public boolean a(mrm parammrm)
  {
    if (parammrm != null) {
      ThreadManager.excute(new ADVideoAppDownloadManager.3(this, parammrm), 128, null, true);
    }
    return false;
  }
  
  public void aRy()
  {
    if ((!this.isLoadingAppData) && (tky.isNetValid(this.mContext)))
    {
      this.isLoadingAppData = true;
      LoadTask localLoadTask = new LoadTask(this, this.c);
      this.jx.add(localLoadTask);
      ThreadManager.excute(localLoadTask, 128, null, true);
    }
  }
  
  public void aRz()
  {
    if ((tky.isNetValid(this.mContext)) && (!this.isLoadingAppData))
    {
      this.isLoadingAppData = true;
      ThreadManager.excute(this.cL, 128, null, true);
    }
  }
  
  public void b(mrm parammrm, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ADVideoAppDownloadManager.6(this, parammrm, paramInt));
  }
  
  public void click()
  {
    if (this.c == null)
    {
      this.jdField_a_of_type_Mro.c(null, 0);
      return;
    }
    if (this.c.mState == 5)
    {
      h(this.c);
      return;
    }
    this.jdField_a_of_type_Mro.c(this.c, this.c.mState);
  }
  
  public void d(mrm parammrm)
  {
    String str = parammrm.mDownloadUrl;
    if (!TextUtils.isEmpty(str))
    {
      arvv.a().fx(str);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.4(this, parammrm));
  }
  
  public void d(mtg.l paraml)
  {
    this.jdField_a_of_type_Mtg$g = paraml;
    if (this.jdField_a_of_type_Mtg$b != null)
    {
      this.jdField_a_of_type_Mtg$b.aor = false;
      this.jdField_a_of_type_Mtg$b.lx.setVisibility(8);
      this.jdField_a_of_type_Mtg$b.jdField_a_of_type_Mrx.e(this.jdField_a_of_type_Mtg$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d);
    }
    if ((paraml instanceof mtg.b))
    {
      aBt();
      this.jdField_a_of_type_Mtg$b = ((mtg.b)paraml);
      if (this.jdField_a_of_type_Mtg$b != null)
      {
        paraml = this.jdField_a_of_type_Mtg$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
        if (paraml != null) {
          break label96;
        }
      }
    }
    label96:
    VideoAdInfo localVideoAdInfo;
    do
    {
      return;
      localVideoAdInfo = paraml.b;
    } while ((localVideoAdInfo == null) || (!paraml.isAD) || (!knc.d(localVideoAdInfo)) || (!AdvertisementInfo.isAppAdvertisementInfo(knl.b(localVideoAdInfo))));
    paraml = mrm.a(localVideoAdInfo);
    if (TextUtils.isEmpty(paraml)) {
      paraml = "STUB_PACK_NAME_" + W.incrementAndGet();
    }
    for (;;)
    {
      mrm localmrm2 = (mrm)this.bs.get(paraml);
      mrm localmrm1 = localmrm2;
      if (localmrm2 == null) {
        localmrm1 = mrm.a(localVideoAdInfo);
      }
      if (localmrm1 == null) {
        break;
      }
      localmrm1.mPackageName = paraml;
      this.bs.put(paraml, localmrm1);
      this.c = localmrm1;
      this.jdField_a_of_type_Mro = new mro(this.jdField_a_of_type_Mtg$b, this, this.mContext);
      arvv.a().a(this);
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " onCenterViewChanged  mState = " + this.c.mState);
      }
      if ((localmrm1.mState == 4) || (localmrm1.mState == 3))
      {
        this.jdField_a_of_type_Mro.resumeDownload = true;
        this.jdField_a_of_type_Mro.aRA();
        if (localmrm1.mState != 3) {
          break label341;
        }
        this.jdField_a_of_type_Mro.e(localmrm1, localmrm1.aTP);
      }
      for (;;)
      {
        aRy();
        return;
        label341:
        if (localmrm1.mState == 4) {
          this.jdField_a_of_type_Mro.j(localmrm1);
        }
      }
    }
  }
  
  public boolean d(VideoInfo paramVideoInfo)
  {
    boolean bool1 = true;
    if (paramVideoInfo == null) {}
    while ((paramVideoInfo.b == null) || (paramVideoInfo == null) || (paramVideoInfo.b == null) || (paramVideoInfo.b.aGV != 12)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.b.Wo);
        boolean bool2 = aqiz.isAppInstalled(this.mContext, paramVideoInfo.optString("pkg_name"));
        if (bool2) {
          return bool1;
        }
      }
      catch (JSONException paramVideoInfo)
      {
        QLog.d("ADVideoAppDownloadManager", 1, "isAppInstalled JSONException = " + paramVideoInfo.toString());
        return false;
      }
      bool1 = false;
    }
  }
  
  public void doOnDestory()
  {
    aBt();
    arvv.a().b(this);
    this.mContext = null;
  }
  
  public void doOnPause() {}
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " doOnResume ");
    }
    if ((this.c != null) && (this.jdField_a_of_type_Mtg$b != null) && (this.jdField_a_of_type_Mtg$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.jdField_a_of_type_Mtg$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (knc.d(this.jdField_a_of_type_Mtg$b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b))) {
      b(this.c, this.c.mState);
    }
  }
  
  public void g(mrm parammrm)
  {
    if ((this.mContext == null) || (this.jdField_a_of_type_Mro == null) || (parammrm == null) || (!parammrm.isValid())) {
      QLog.d("ADVideoAppDownloadManager", 1, "initDownloadApp return null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp begin");
            }
            if (jzk.C(this.mContext, parammrm.mPackageName))
            {
              QLog.d("ADVideoAppDownloadManager", 1, "already installed." + parammrm.mPackageName);
              this.jdField_a_of_type_Mro.resumeDownload = true;
              this.jdField_a_of_type_Mro.aRA();
              this.jdField_a_of_type_Mro.m(parammrm);
              return;
            }
            if (a(this.mContext, parammrm))
            {
              QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + parammrm.mPackageName);
              this.jdField_a_of_type_Mro.resumeDownload = true;
              this.jdField_a_of_type_Mro.aRA();
              this.jdField_a_of_type_Mro.n(parammrm);
              return;
            }
            int j = a(this.mContext, parammrm);
            int i = j;
            if (j == -1)
            {
              i = j;
              if (parammrm.aTP > 0) {
                i = parammrm.aTP;
              }
            }
            if ((i < 0) || ((parammrm.mState != 3) && (parammrm.mState != 4))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + parammrm.mPackageName + " " + i);
            }
            if (parammrm.mState == 3)
            {
              this.jdField_a_of_type_Mro.e(parammrm, i);
              return;
            }
          } while (parammrm.mState != 4);
          this.jdField_a_of_type_Mro.j(parammrm);
          return;
          if ((!this.jdField_a_of_type_Mro.resumeDownload) && ((!this.anB) || (!tll.isWifiConnected()))) {
            break;
          }
          if (this.jdField_a_of_type_Mro.resumeDownload)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ADVideoAppDownloadManager", 2, "autodownload not by userClick");
            }
            a(parammrm, 0);
            return;
          }
        } while ((!this.anB) || (!tll.isWifiConnected()));
        if (!this.anC)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ADVideoAppDownloadManager", 2, "autodownload for getAppData <1s");
          }
          a(parammrm, 0);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "dont autodownload for getAppData >1s");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
  
  void h(mrm parammrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "startDownload " + parammrm.mPackageName);
    }
    Activity localActivity = (Activity)this.mContext;
    this.jdField_a_of_type_Mro.resumeDownload = true;
    a(localActivity, parammrm);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "installSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Mro.a(paramString1, paramString2, this.c);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.packageName);
    }
    this.jdField_a_of_type_Mro.c(paramDownloadInfo, this.c);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.packageName);
    }
    this.jdField_a_of_type_Mro.a(paramDownloadInfo, paramInt1, paramString, paramInt2, this.c);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadFinish " + paramDownloadInfo.packageName);
    }
    this.jdField_a_of_type_Mro.d(paramDownloadInfo, this.c);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadPause " + paramDownloadInfo.packageName);
    }
    if ((paramDownloadInfo != null) && (this.c != null) && (this.c.mPackageName != null) && (this.c.mPackageName.equals(paramDownloadInfo.packageName)) && (paramDownloadInfo.progress != 0) && (paramDownloadInfo.progress != 100)) {
      this.c.aTP = paramDownloadInfo.progress;
    }
    this.jdField_a_of_type_Mro.a(paramDownloadInfo, this.c);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    this.jdField_a_of_type_Mro.a(paramList, this.c);
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "onDownloadWait " + paramDownloadInfo.packageName);
    }
    this.jdField_a_of_type_Mro.b(paramDownloadInfo, this.c);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Mro.c(paramString1, paramString2, this.c);
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    this.jdField_a_of_type_Mro.b(paramString1, paramString2, this.c);
  }
  
  public static class LoadTask
    implements Runnable
  {
    private int aTQ;
    private WeakReference<ADVideoAppDownloadManager> cm;
    private mrm e;
    
    public LoadTask(ADVideoAppDownloadManager paramADVideoAppDownloadManager, mrm parammrm)
    {
      this.cm = new WeakReference(paramADVideoAppDownloadManager);
      this.e = parammrm;
    }
    
    public void run()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob running... ");
        }
        if (this.e != null)
        {
          localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.cm.get();
          if (localADVideoAppDownloadManager == null) {
            return;
          }
          l = System.currentTimeMillis();
          this.aTQ += 1;
          mrm localmrm = this.e;
          if (!localmrm.isValid()) {
            break label192;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ADVideoAppDownloadManager", 2, "mLoadAppJob loader sucess!!! " + localmrm.mDownloadUrl);
          }
          if ((ADVideoAppDownloadManager.a(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).mPackageName)) && (ADVideoAppDownloadManager.a(localADVideoAppDownloadManager).mPackageName.equals(localmrm.mPackageName))) {
            localADVideoAppDownloadManager.g(localmrm);
          }
          ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, true, System.currentTimeMillis() - l);
        }
      }
      catch (Exception localException)
      {
        ADVideoAppDownloadManager localADVideoAppDownloadManager;
        long l;
        while (QLog.isColorLevel())
        {
          QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob exception");
          return;
          label192:
          QLog.d("ADVideoAppDownloadManager", 1, "mLoadAppJob loader failed!!!");
          ADVideoAppDownloadManager.a(localException, false, System.currentTimeMillis() - l);
        }
      }
      localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.cm.get();
      if (localADVideoAppDownloadManager != null)
      {
        ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */