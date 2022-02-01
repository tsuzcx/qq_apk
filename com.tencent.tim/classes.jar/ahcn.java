import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.1;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.2;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.3;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahcn
{
  public static String TAG = "UniformDownloaderAppBabySdk<FileAssistant>";
  private static ahcn a;
  private ITMAssistantDownloadClientListener b = new ahco(this);
  private Handler cR;
  private TMAssistantDownloadClient d;
  private Map<String, ahcn.a> kN = new HashMap();
  private HandlerThread mHandlerThread;
  
  private void JR(String paramString)
  {
    dmn();
    ahcn.a locala = a(paramString);
    if (locala == null) {
      QLog.e(TAG, 1, "[UniformDL] inPStartDownload. not found ctx.url:" + paramString);
    }
    do
    {
      return;
      if (this.d != null) {
        break;
      }
      QLog.e(TAG, 1, "[UniformDL] inPStartDownload.client = null");
    } while (locala.a == null);
    paramString = new ahcn.b(0L, locala.getDownloadSize()).toBundle();
    locala.a.b(41, ahcj.em(41), paramString);
    return;
    Object localObject1 = AppNetConnInfo.getRecentNetworkInfo();
    if (localObject1 != null) {
      locala.netType = ((NetworkInfo)localObject1).getType();
    }
    int i;
    try
    {
      localObject1 = this.d.getDownloadTaskState(paramString);
      if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 2))
      {
        QLog.w(TAG, 1, "[UniformDL] inPStartDownload.but it is downloading.url = " + paramString);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        Object localObject2 = null;
      }
      i = 0;
      try
      {
        int j = this.d.startDownloadTask(paramString, "application/vnd.android.package-archive");
        i = j;
        QLog.i(TAG, 1, "[UniformDL] inPStartDownload.startDownloadTask. url = " + paramString);
        i = j;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
        if (4 != i) {
          break label265;
        }
        a(paramString, locala);
        return;
        a(paramString, locala, i);
      }
      if (i == 0)
      {
        b(paramString, locala);
        return;
      }
    }
    label265:
  }
  
  private void JS(String paramString)
  {
    dmn();
    ahcn.a locala = a(paramString);
    if (locala == null) {
      QLog.e(TAG, 1, "[UniformDL] inPPauseDownload. not found ctx.url:" + paramString);
    }
    if (this.d == null)
    {
      QLog.e(TAG, 1, "[UniformDL] inPPauseDownload.client = null");
      if ((locala != null) && (locala.a != null))
      {
        paramString = new ahcn.b(0L, locala.getDownloadSize()).toBundle();
        locala.a.b(41, ahcj.em(41), paramString);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.d.getDownloadTaskState(paramString);
          if (localTMAssistantDownloadTaskInfo != null)
          {
            try
            {
              this.d.pauseDownloadTask(paramString);
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
            if (locala == null) {
              continue;
            }
            aI(locala.gf(), locala.netType);
            locala.jT(0L);
            if (locala.a == null) {
              continue;
            }
            paramString = new ahcn.b(locala.getDownloadSize(), locala.getDownloadSize()).toBundle();
            locala.a.b(21, ahcj.em(21), paramString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (locala != null)
            {
              aI(locala.gf(), locala.netType);
              locala.jT(0L);
              if (locala.a != null)
              {
                localBundle = new ahcn.b(locala.getDownloadSize(), locala.getDownloadSize()).toBundle();
                locala.a.b(20, ahcj.em(20), localBundle);
              }
            }
            Bundle localBundle = null;
          }
          QLog.e(TAG, 1, "[UniformDL] inPPauseDownload. no run load");
        }
      }
    } while ((locala == null) || (locala.a == null));
    locala.a.cF(null);
  }
  
  private void JT(String paramString)
  {
    dmn();
    if (this.d == null)
    {
      QLog.e(TAG, 1, "[UniformDL] inPStopDownload.client = null");
      return;
    }
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.d.getDownloadTaskState(paramString);
      if (localTMAssistantDownloadTaskInfo == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.d.cancelDownloadTask(paramString);
          di(paramString);
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          Object localObject = null;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        QLog.e(TAG, 1, "[UniformDL] inPStopDownload. no run load");
      }
    }
  }
  
  private void R(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(TAG, 1, "[UniformDL] >>>inPPDwonloadSDKErr errcode:" + paramInt + " errStr:" + paramString2 + " url:" + paramString1);
    ahcn.a locala = a(paramString1);
    if (locala == null) {
      QLog.e(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateFailed. not found ctx.  errcode:[" + paramInt + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    }
    do
    {
      return;
      locala.setStatus(2);
      aI(locala.gf(), locala.netType);
      locala.jT(0L);
    } while (locala.a == null);
    paramString1 = new ahcn.b(locala.getDownloadSize(), locala.getDownloadSize()).toBundle();
    locala.a.b(paramInt, paramString2, paramString1);
  }
  
  private int a(String paramString, ahcn.a parama)
  {
    if ((parama == null) || (paramString == null)) {
      return -1;
    }
    synchronized (this.kN)
    {
      if (this.kN.containsKey(paramString)) {
        return -2;
      }
    }
    this.kN.put(paramString, parama);
    QLog.i(TAG, 1, "[UniformDL][" + parama.Zd + "] addDownloadCtx...total:[" + this.kN.size() + "] add it. url:[ " + paramString + "]");
    return 0;
  }
  
  private ahcn.a a(String paramString)
  {
    synchronized (this.kN)
    {
      paramString = (ahcn.a)this.kN.get(paramString);
      return paramString;
    }
  }
  
  public static ahcn a()
  {
    try
    {
      if (a == null) {
        a = new ahcn();
      }
      ahcn localahcn = a;
      return localahcn;
    }
    finally {}
  }
  
  private void a(ahcn.a parama, int paramInt, String paramString)
  {
    QLog.e(TAG, 1, "[UniformDL] >>>handleDownloadSDKTaskStateFailed. errCode:" + paramInt + " errStr" + paramString);
    int i = 5;
    ahcj.em(5);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramInt = 2;
      paramString = ahcj.em(paramInt);
      if (parama != null)
      {
        aI(parama.gf(), parama.netType);
        parama.jT(0L);
        if (parama.a != null)
        {
          Bundle localBundle = new ahcn.b(parama.getDownloadSize(), parama.getDownloadSize()).toBundle();
          parama.a.b(paramInt, paramString, localBundle);
        }
      }
      return;
    }
    if (601 == paramInt)
    {
      i = 38;
      label134:
      if (!aqfo.isExistSDCard()) {
        break label458;
      }
    }
    label458:
    for (long l = aqfo.getSDCardAvailableSize() * 1024L;; l = aqfo.getSystemAvailableSize() * 1024L)
    {
      paramInt = i;
      if (parama == null) {
        break;
      }
      paramInt = i;
      if (l >= parama.nFileSize - parama.getDownloadSize()) {
        break;
      }
      QLog.e(TAG, 1, "[UniformDL][" + parama.Zd + "] write file failed.  space is no enough:[" + parama.nFileSize + " " + parama.getDownloadSize() + " " + l + "]");
      paramInt = 9;
      break;
      if (702 == paramInt)
      {
        i = 23;
        break label134;
      }
      if (600 == paramInt)
      {
        i = 24;
        break label134;
      }
      if (paramInt == 0)
      {
        i = 25;
        break label134;
      }
      if (704 == paramInt)
      {
        i = 26;
        break label134;
      }
      if (706 == paramInt)
      {
        i = 27;
        break label134;
      }
      if (709 == paramInt)
      {
        i = 28;
        break label134;
      }
      if (701 == paramInt)
      {
        i = 29;
        break label134;
      }
      if (707 == paramInt)
      {
        i = 30;
        break label134;
      }
      if (602 == paramInt)
      {
        i = 31;
        break label134;
      }
      if (705 == paramInt)
      {
        i = 32;
        break label134;
      }
      if (604 == paramInt)
      {
        i = 39;
        break label134;
      }
      if (603 == paramInt)
      {
        i = 34;
        break label134;
      }
      if (708 == paramInt)
      {
        i = 35;
        break label134;
      }
      if (700 == paramInt)
      {
        i = 36;
        break label134;
      }
      if (703 != paramInt) {
        break label134;
      }
      i = 37;
      break label134;
    }
  }
  
  private void a(String paramString, ahcn.a parama)
  {
    QLog.w(TAG, 1, "[UniformDL] inPStartDownload. file existed. sucess dricetly. url = " + paramString);
    parama.setStatus(2);
    for (;;)
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
      try
      {
        localTMAssistantDownloadTaskInfo = this.d.getDownloadTaskState(paramString);
        di(paramString);
        if (parama != null)
        {
          parama.setDownloadSize(parama.nFileSize);
          if (parama.a != null)
          {
            Bundle localBundle = new ahcn.b(0L, parama.getDownloadSize()).toBundle();
            parama = parama.a;
            if (localTMAssistantDownloadTaskInfo != null) {
              break label171;
            }
            paramString = null;
            parama.G(paramString, localBundle);
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (parama == null) {
          continue;
        }
        aI(parama.gf(), parama.netType);
        parama.jT(0L);
        if (parama.a == null) {
          continue;
        }
        paramString = new ahcn.b(0L, parama.getDownloadSize()).toBundle();
        parama.a.b(20, ahcj.em(20), paramString);
        return;
      }
      label171:
      paramString = localTMAssistantDownloadTaskInfo.mSavePath;
    }
  }
  
  private void a(String paramString, ahcn.a parama, int paramInt)
  {
    QLog.e(TAG, 1, "[UniformDL] inPStartDownload. task failed. result:" + paramInt + ". url = " + paramString);
    parama.setStatus(2);
    int i = 15;
    paramString = "start failed";
    if (5 == paramInt)
    {
      i = 16;
      paramString = "busy";
    }
    for (;;)
    {
      if ((parama != null) && (parama.a != null))
      {
        Bundle localBundle = new ahcn.b(0L, parama.getDownloadSize()).toBundle();
        parama.a.b(i, paramString, localBundle);
      }
      return;
      if (1 == paramInt)
      {
        i = 17;
        paramString = "net broken";
      }
      else if (2 == paramInt)
      {
        i = 18;
        paramString = "set only for wifi";
      }
      else if (3 == paramInt)
      {
        i = 19;
        paramString = "param err";
      }
    }
  }
  
  private void aI(long paramLong, int paramInt)
  {
    if (0L == paramLong) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("flowstat", 2, "fileType:" + 5 + ",busiType:" + 0);
    }
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface == null)
    {
      QLog.e(TAG, 1, "[UniformDL]. reportFlow failed.APP=null");
      return;
    }
    localQQAppInterface.sendAppDataIncerment(localQQAppInterface.getAccount(), false, paramInt, 5, 0, paramLong);
  }
  
  private void b(String paramString, ahcn.a parama)
  {
    QLog.i(TAG, 1, "[UniformDL] inPStartDownload success.. url = " + paramString);
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.d.getDownloadTaskState(paramString);
      if ((parama != null) && (localTMAssistantDownloadTaskInfo != null))
      {
        long l = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        parama.setDownloadSize(l);
        QLog.i(TAG, 1, "[UniformDL] inPStartDownload success. rSize:" + l + " url = " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        do
        {
          paramString.printStackTrace();
        } while (parama == null);
        aI(parama.gf(), parama.netType);
        parama.jT(0L);
      } while (parama.a == null);
      paramString = new ahcn.b(0L, parama.getDownloadSize()).toBundle();
      parama.a.b(20, ahcj.em(20), paramString);
    }
  }
  
  private void d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    ahcn.a locala = a(paramString1);
    if (locala == null) {
      QLog.e(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged. not found ctx.  state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
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
            switch (paramInt1)
            {
            default: 
              QLog.e(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  unkown state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
              return;
            case 1: 
              QLog.i(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[WAITING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
            }
          } while ((locala == null) || (locala.a == null));
          locala.a.cG(null);
          return;
          QLog.i(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[DOWNLOADING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        } while ((locala == null) || (locala.a == null));
        locala.a.cE(null);
        return;
        QLog.i(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[FAILED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        locala.setStatus(2);
        aI(locala.gf(), locala.netType);
        locala.jT(0L);
        a(locala, paramInt2, paramString2);
        return;
        QLog.i(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[SUCCEED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        locala.setStatus(2);
        aI(locala.gf(), locala.netType);
        locala.jT(0L);
        di(paramString1);
      } while ((locala == null) || (locala.a == null));
      paramString1 = new ahcn.b(locala.getDownloadSize(), locala.getDownloadSize()).toBundle();
      locala.a.G(paramString3, paramString1);
      return;
      QLog.i(TAG, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[PAUSED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
      locala.setStatus(2);
      aI(locala.gf(), locala.netType);
      locala.jT(0L);
    } while ((locala == null) || (locala.a == null));
    locala.a.cF(null);
  }
  
  private int di(String paramString)
  {
    synchronized (this.kN)
    {
      ahcn.a locala = (ahcn.a)this.kN.remove(paramString);
      int i = this.kN.size();
      QLog.i(TAG, 1, "[UniformDL][" + locala.Zd + "] delDownloadCtx...total:[" + i + "] add it. url:[ " + paramString + "]");
      return i;
    }
  }
  
  private void dmk()
  {
    try
    {
      if (this.mHandlerThread == null)
      {
        this.mHandlerThread = new HandlerThread("DL_ABSdkThread");
        this.mHandlerThread.start();
        this.cR = new Handler(this.mHandlerThread.getLooper());
        QLog.i(TAG, 1, "[UniformDL] >>>start thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dml()
  {
    try
    {
      if (this.mHandlerThread != null)
      {
        this.mHandlerThread.getLooper().quit();
        this.mHandlerThread = null;
        this.cR = null;
        QLog.i(TAG, 1, "[UniformDL] >>>stop thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dmm()
  {
    synchronized (this.kN)
    {
      int i = this.kN.size();
      if (i == 0)
      {
        dml();
        dmo();
      }
      return;
    }
  }
  
  private void dmn()
  {
    if (this.d == null)
    {
      QLog.i(TAG, 1, "[UniformDL] >>>create ABSdkClient...");
      this.d = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("UF_DL_CLIENT");
      this.d.registerDownloadTaskListener(this.b);
    }
  }
  
  private void dmp()
  {
    QLog.e(TAG, 1, "[UniformDL] >>>inPDwonloadSDKServiceInvalid service invalid ");
    dmo();
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    synchronized (this.kN)
    {
      localObject3 = this.kN.values().iterator();
      if (((Iterator)localObject3).hasNext()) {
        localArrayList.add((ahcn.a)((Iterator)localObject3).next());
      }
    }
    this.kN.clear();
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      ahcn.a locala = (ahcn.a)((Iterator)???).next();
      if (locala != null)
      {
        aI(locala.gf(), locala.netType);
        locala.jT(0L);
        if (locala.a != null)
        {
          localObject3 = new ahcn.b(locala.getDownloadSize(), locala.getDownloadSize()).toBundle();
          locala.a.b(10, ahcj.em(10), (Bundle)localObject3);
        }
      }
    }
  }
  
  private void eJ(String paramString, int paramInt)
  {
    QLog.i(TAG, 1, "[UniformDL] inPRunABSdkDownloadCmd.cmd:" + paramInt + " url = " + paramString);
    switch (paramInt)
    {
    default: 
      QLog.e(TAG, 1, "[UniformDL] inPRunABSdkDownloadCmd, errcmd: " + paramInt);
      return;
    case 1: 
      JR(paramString);
      return;
    case 2: 
      JS(paramString);
      return;
    }
    JT(paramString);
  }
  
  private void k(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    ahcn.a locala = a(paramString);
    if (locala != null)
    {
      locala.jT(paramLong1 - locala.getDownloadSize() + locala.gf());
      locala.setDownloadSize(paramLong1);
      if (locala.a != null) {
        locala.a.q(i, null);
      }
      return;
    }
    QLog.e(TAG, 1, "[UniformDL] inPDownloadSDKTaskProgressChanged. not found ctx, url: " + paramString);
  }
  
  public int a(long paramLong1, String paramString, long paramLong2, ahcl.a parama)
  {
    if (paramString == null)
    {
      QLog.e(TAG, 1, "[UniformDL] [" + paramLong1 + "] initADownload, url = null");
      return -1;
    }
    ahcn.a locala = new ahcn.a(paramLong1, paramString, paramLong2);
    locala.a = parama;
    int i = a(paramString, locala);
    if (i != 0)
    {
      QLog.w(TAG, 1, "[UniformDL]  [" + paramLong1 + "] initADownload failed:" + i);
      return -2;
    }
    return 0;
  }
  
  public int dj(String paramString)
  {
    QLog.i(TAG, 1, "[UniformDL] startADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(TAG, 1, "[UniformDL] startADownload, url = null");
      return -1;
    }
    ahcn.a locala = a(paramString);
    if (locala == null)
    {
      QLog.w(TAG, 1, "[UniformDL] startADownload, not exsit download,url = " + paramString);
      return -2;
    }
    locala.setStatus(1);
    dmk();
    if (!this.cR.post(new UniformDownloaderAppBabySdk.1(this, paramString)))
    {
      QLog.i(TAG, 1, "[UniformDL] startADownload.post failed url = " + paramString);
      locala.setStatus(2);
      return -3;
    }
    return 0;
  }
  
  public int dk(String paramString)
  {
    QLog.i(TAG, 1, "[UniformDL] puaseADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(TAG, 1, "[UniformDL] puaseADownload, url = null");
      return -1;
    }
    ahcn.a locala = a(paramString);
    if (locala == null)
    {
      QLog.w(TAG, 1, "[UniformDL] puaseADownload, not exsit download,url = " + paramString);
      return -2;
    }
    locala.setStatus(2);
    dmk();
    if (!this.cR.post(new UniformDownloaderAppBabySdk.2(this, paramString)))
    {
      QLog.i(TAG, 1, "[UniformDL] puaseADownload.post failed url = " + paramString);
      return -3;
    }
    return 0;
  }
  
  public int dl(String paramString)
  {
    int i = 0;
    QLog.i(TAG, 1, "[UniformDL] stopADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(TAG, 1, "[UniformDL] stopADownload, url = null");
      i = -1;
    }
    do
    {
      return i;
      ahcn.a locala = a(paramString);
      if (locala == null)
      {
        QLog.w(TAG, 1, "[UniformDL] stopADownload, not exsit download,url = " + paramString);
        return 0;
      }
      locala.setStatus(2);
      dmk();
    } while (this.cR.post(new UniformDownloaderAppBabySdk.3(this, paramString)));
    di(paramString);
    QLog.w(TAG, 1, "[UniformDL] stopADownload, post failed,url = " + paramString);
    return 0;
  }
  
  public void dmo()
  {
    if (this.d != null)
    {
      QLog.w(TAG, 1, "[UniformDL] >>>release ABSdkClient...");
      this.d.unRegisterDownloadTaskListener(this.b);
      this.d = null;
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).releaseDownloadSDKClient("UF_DL_CLIENT");
      return;
    }
    QLog.w(TAG, 1, "[UniformDL] releaseABSdkClient. client had be stoped");
  }
  
  public boolean mK(String paramString)
  {
    return a(paramString) != null;
  }
  
  class a
  {
    long YD;
    final long Zd;
    ahcl.a a;
    long aao;
    Object dP = new Object();
    Object dQ = new Object();
    Object dR = new Object();
    int mStatus;
    final String mUrl;
    final long nFileSize;
    int netType;
    
    a(long paramLong1, String paramString, long paramLong2)
    {
      this.Zd = paramLong1;
      this.mStatus = 2;
      this.mUrl = paramString;
      this.nFileSize = paramLong2;
      this.YD = 0L;
      this.aao = 0L;
      this.netType = -1;
    }
    
    long getDownloadSize()
    {
      synchronized (this.dP)
      {
        long l = this.YD;
        return l;
      }
    }
    
    long gf()
    {
      synchronized (this.dR)
      {
        long l = this.aao;
        return l;
      }
    }
    
    void jT(long paramLong)
    {
      synchronized (this.dR)
      {
        this.aao = paramLong;
        return;
      }
    }
    
    void setDownloadSize(long paramLong)
    {
      synchronized (this.dP)
      {
        this.YD = paramLong;
        return;
      }
    }
    
    void setStatus(int paramInt)
    {
      synchronized (this.dQ)
      {
        QLog.i(ahcn.TAG, 1, "[UniformDL] setStatus:" + this.mStatus + " -> " + paramInt + "url:" + this.mUrl);
        this.mStatus = paramInt;
        return;
      }
    }
  }
  
  public static class b
  {
    public long aap;
    public long aaq;
    
    public b(long paramLong1, long paramLong2)
    {
      this.aap = paramLong1;
      this.aaq = paramLong2;
    }
    
    public static b a(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return null;
      }
      return new b(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("RPARAM_RECV_SIZE", this.aap);
      localBundle.putLong("RPARAM_TRANS_SIZE", this.aaq);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcn
 * JD-Core Version:    0.7.0.1
 */