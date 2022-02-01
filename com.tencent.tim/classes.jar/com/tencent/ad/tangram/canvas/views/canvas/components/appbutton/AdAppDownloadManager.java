package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener;
import com.tencent.ad.tangram.canvas.download.AdDownloadTask;
import com.tencent.ad.tangram.canvas.download.AdDownloader;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.report.AdReport;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.landing_page_collect_data.LandingPageCollectData;
import com.tencent.ad.tangram.statistics.a.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public class AdAppDownloadManager
  implements IAdDownloader.Callback
{
  public static final int DOWNLOAD_CANCELED = 4;
  public static final int DOWNLOAD_ERROR = 5;
  public static final int DOWNLOAD_FINISHED = 3;
  public static final int DOWNLOAD_ING = 8;
  public static final int DOWNLOAD_INSTALL_SUCCESS = 6;
  public static final int DOWNLOAD_NONE = 0;
  public static final int DOWNLOAD_PAUSED = 2;
  public static final int DOWNLOAD_STARTED = 1;
  public static final int DOWNLOAD_UNINSTALL_SUCCESS = 7;
  private static final int MAX_TRY = 3;
  private static final String TAG = "AdAppDownloadManager";
  public Ad ad;
  private ArrayList<AdRefreshCallback> adRefreshCallbacks = new ArrayList();
  private a appDataDownloadCallbacks = null;
  private boolean autodownload = false;
  private ArrayList<c> downloadStatusCallbacks = new ArrayList();
  private g downloaderWrapper = null;
  private volatile boolean initialized;
  private boolean isLoadingAppData;
  private CopyOnWriteArrayList<h> mBtnUIPresenterList = new CopyOnWriteArrayList();
  private volatile AdAppBtnData mCgdtAppBtnData;
  private b mClickLoadAppJob = null;
  private WeakReference<Context> mContext;
  private Runnable mLoadAppJob = new AdAppDownloadManager.2(this);
  private boolean mStartedDownload = false;
  private Runnable mWiFiDelayJob = new AdAppDownloadManager.1(this);
  public String sourceId;
  
  private void callAdRefreshCallback()
  {
    this.adRefreshCallbacks.add(AdReport.getAdReportAdapter());
    int i = 0;
    while (i < this.adRefreshCallbacks.size())
    {
      ((AdRefreshCallback)this.adRefreshCallbacks.get(i)).onAdRefresh(this.ad);
      i += 1;
    }
  }
  
  private void callAppDataDownloadCallback()
  {
    if (this.appDataDownloadCallbacks != null) {
      this.appDataDownloadCallbacks.onLoadSuccess();
    }
  }
  
  private void dealDownloadInstalled(String paramString)
  {
    AdLog.w("AdAppDownloadManager", "onActivityResume already installed. " + paramString);
    paramString = this.mBtnUIPresenterList.iterator();
    for (;;)
    {
      h localh;
      if (paramString.hasNext())
      {
        localh = (h)paramString.next();
        if ((localh instanceof e)) {}
      }
      else
      {
        return;
      }
      ((e)localh).installSucceedUpdateUI(this.mCgdtAppBtnData);
    }
  }
  
  private void fetchAppData()
  {
    AdLog.d("AdAppDownloadManager", "going fetch AppData");
    if ((!this.isLoadingAppData) && (this.mCgdtAppBtnData == null) && (this.mContext != null) && (com.tencent.ad.tangram.net.a.isNetValid((Context)this.mContext.get())))
    {
      this.isLoadingAppData = true;
      AdThreadManager.INSTANCE.post(this.mLoadAppJob, 4);
    }
  }
  
  private h findPresenter(String paramString)
  {
    Object localObject;
    if ((this.mBtnUIPresenterList == null) || (this.mBtnUIPresenterList.size() == 0))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.mBtnUIPresenterList.size()) {
        break label121;
      }
      h localh = (h)this.mBtnUIPresenterList.get(i);
      if (localh == null) {
        return null;
      }
      if (TextUtils.isEmpty(paramString))
      {
        localObject = localh;
        if ((localh instanceof a)) {
          break;
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ((localh instanceof e)))
      {
        localObject = localh;
        if (TextUtils.equals(paramString, ((e)this.mBtnUIPresenterList.get(i)).data.id)) {
          break;
        }
      }
      i += 1;
    }
    label121:
    return null;
  }
  
  private void firstAutoDownloadReport()
  {
    if ((this.autodownload) && (this.mContext != null) && (this.mCgdtAppBtnData != null) && (com.tencent.ad.tangram.net.a.isWifiConnected((Context)this.mContext.get()))) {
      dealPkgExist(new AdAppDownloadManager.7(this));
    }
  }
  
  private void initAutoRefreshUICallback()
  {
    registerDownloadListener();
    this.appDataDownloadCallbacks = new AdAppDownloadManager.3(this);
  }
  
  private void reprtAppDataLoad(boolean paramBoolean, long paramLong)
  {
    a.a locala = new a.a();
    locala.context = this.mContext;
    locala.ad = this.ad;
    landing_page_collect_data.LandingPageCollectData localLandingPageCollectData = locala.data;
    if (paramBoolean) {}
    for (int i = 36;; i = 37)
    {
      localLandingPageCollectData.landing_page_action_type = i;
      locala.data.landing_error_code = 0;
      locala.data.latency_ms = paramLong;
      com.tencent.ad.tangram.statistics.a.report(locala);
      return;
    }
  }
  
  private void setmCgdtAppBtnData(AdAppBtnData paramAdAppBtnData)
  {
    try
    {
      if (this.mCgdtAppBtnData == null)
      {
        this.mCgdtAppBtnData = paramAdAppBtnData;
        AdDownloadTask.setDownloadUrl(this.mCgdtAppBtnData.apkUrlhttp);
      }
      return;
    }
    finally
    {
      paramAdAppBtnData = finally;
      throw paramAdAppBtnData;
    }
  }
  
  private void syncDownloadBtnUI(int paramInt)
  {
    callDownloadStatusCallbacks();
    if ((this.mBtnUIPresenterList == null) || (this.mBtnUIPresenterList.size() == 0)) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator = this.mBtnUIPresenterList.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        h localh = (h)localIterator.next();
        if ((!(localh instanceof e)) || (((e)localh).data == null))
        {
          AdLog.e("AdCanvasAppBtnUIAdapter", "syncDownloadBtnUI failed");
          return;
        }
        if (!(findPresenter(((e)localh).data.id) instanceof e)) {
          break;
        }
        AdLog.i("AdCanvasAppBtnUIAdapter", "syncDownloadBtnUI :" + paramInt);
        localh.initDownloadApp(paramInt);
      }
    }
  }
  
  public void callDownloadStatusCallbacks()
  {
    Iterator localIterator = this.downloadStatusCallbacks.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc != null) && (this.mContext != null) && (this.mCgdtAppBtnData != null))
      {
        AdLog.i("AdAppDownloadManager", "getDownloadStatus" + this.mCgdtAppBtnData.cState);
        localc.getDownloadStatus(this.mCgdtAppBtnData.cState);
      }
      else
      {
        AdLog.i("AdAppDownloadManager", " no data");
      }
    }
  }
  
  public void dealPkgExist(d paramd)
  {
    AdThreadManager.INSTANCE.post(new AdAppDownloadManager.5(this, paramd), 5);
  }
  
  public void fetchAppDataByOnClick(String paramString)
  {
    if (this.mClickLoadAppJob == null) {
      this.mClickLoadAppJob = new b(paramString);
    }
    if ((this.mContext != null) && (com.tencent.ad.tangram.net.a.isNetValid((Context)this.mContext.get())) && (!this.isLoadingAppData))
    {
      this.isLoadingAppData = true;
      AdThreadManager.INSTANCE.post(this.mClickLoadAppJob, 4);
    }
  }
  
  public void fetchDownloadStatus(c paramc)
  {
    if (paramc == null) {
      return;
    }
    this.downloadStatusCallbacks.add(paramc);
  }
  
  public int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    while (this.downloaderWrapper == null) {
      return 0;
    }
    return this.downloaderWrapper.getCurrentPkgDownloadProgress(paramContext, paramString1, paramString2);
  }
  
  public g getDownloader()
  {
    return this.downloaderWrapper;
  }
  
  public AdAppBtnData getGdtAppBtnData()
  {
    return this.mCgdtAppBtnData;
  }
  
  public boolean hasStartedDownload()
  {
    return this.mStartedDownload;
  }
  
  public void init(Context paramContext, boolean paramBoolean, Ad paramAd, String paramString)
  {
    if (this.initialized) {}
    do
    {
      return;
      try
      {
        if (this.initialized) {
          return;
        }
      }
      finally {}
      this.initialized = true;
      this.mContext = new WeakReference(paramContext);
      this.autodownload = paramBoolean;
      this.ad = paramAd;
      this.sourceId = paramString;
      setDownloader();
      initAutoRefreshUICallback();
      fetchAppData();
      callAdRefreshCallback();
    } while (!com.tencent.ad.tangram.net.a.isWifiConnected(paramContext));
    AdThreadManager.INSTANCE.postDelayed(this.mWiFiDelayJob, 3, 1000L);
  }
  
  public void initDownloadAction(boolean paramBoolean)
  {
    try
    {
      if ((this.mCgdtAppBtnData == null) || (this.mContext == null)) {
        return;
      }
      if (this.mContext.get() == null) {
        return;
      }
      String str = this.mCgdtAppBtnData.packageName;
      if (AdAppUtil.isInstalled((Context)this.mContext.get(), str))
      {
        AdLog.i("AdAppDownloadManager", "App already installed " + str);
        this.mCgdtAppBtnData.cState = 6;
        syncDownloadBtnUI(6);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdAppDownloadManager", "initDownloadAction: ", localThrowable);
      return;
    }
    dealPkgExist(new AdAppDownloadManager.4(this, paramBoolean));
  }
  
  public void installDownload(String paramString)
  {
    if ((this.downloaderWrapper == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.downloaderWrapper.installDownload(this.downloaderWrapper.getDownloadInfoByUrl(paramString));
  }
  
  public int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    while (this.downloaderWrapper == null) {
      return -1;
    }
    return this.downloaderWrapper.isPkgDownloadPaused(paramContext, paramString1, paramString2);
  }
  
  public int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    while (this.downloaderWrapper == null) {
      return -1;
    }
    return this.downloaderWrapper.isPkgDownloading(paramContext, paramString1, paramString2);
  }
  
  public boolean isPkgExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    while ((this.downloaderWrapper == null) || (!this.downloaderWrapper.isPkgExist(paramContext, paramString1, paramString2))) {
      return false;
    }
    return true;
  }
  
  public void onActivityResume()
  {
    dealPkgExist(new AdAppDownloadManager.6(this));
  }
  
  public void onDestroy()
  {
    AdLog.i("AdCanvasAppBtnUIAdapter", "onDestroy resetStaticVariables");
    unregisterDownloadListener();
    this.mContext = null;
    this.mCgdtAppBtnData = null;
    this.isLoadingAppData = false;
    this.mStartedDownload = false;
    if (this.mBtnUIPresenterList != null) {
      this.mBtnUIPresenterList.clear();
    }
    if (this.adRefreshCallbacks != null) {
      this.adRefreshCallbacks.clear();
    }
    this.appDataDownloadCallbacks = null;
    this.downloadStatusCallbacks.clear();
    this.initialized = false;
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    Iterator localIterator;
    if ((this.mBtnUIPresenterList != null) && (this.mBtnUIPresenterList.size() > 0)) {
      localIterator = this.mBtnUIPresenterList.iterator();
    }
    for (;;)
    {
      h localh;
      if (localIterator.hasNext())
      {
        localh = (h)localIterator.next();
        if (localh != null) {}
      }
      else
      {
        return;
      }
      localh.onDownloadProgressUpdate(paramList, paramList1);
    }
  }
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString)
  {
    Iterator localIterator;
    if ((this.mBtnUIPresenterList != null) && (this.mBtnUIPresenterList.size() > 0)) {
      localIterator = this.mBtnUIPresenterList.iterator();
    }
    for (;;)
    {
      h localh;
      if (localIterator.hasNext())
      {
        localh = (h)localIterator.next();
        if (localh != null) {}
      }
      else
      {
        return;
      }
      localh.onDownloadStatusChanged(paramInt1, paramInt2, paramPair, paramString);
    }
  }
  
  public void pauseDownload(String paramString1, String paramString2)
  {
    if (this.downloaderWrapper != null) {
      this.downloaderWrapper.pauseDownload(paramString1, paramString2);
    }
  }
  
  public void registerDownloadListener()
  {
    AdLog.d("AdAppDownloadManager", "registerDownloadListener: ");
    if (this.downloaderWrapper != null) {
      this.downloaderWrapper.registerListener(AdCanvasDownloadListener.getDownloadListener(this));
    }
  }
  
  public void removePresenter(h paramh)
  {
    if ((this.mBtnUIPresenterList != null) && (this.mBtnUIPresenterList.contains(paramh))) {
      this.mBtnUIPresenterList.remove(paramh);
    }
  }
  
  public void setAppBtnUIPresenter(h paramh)
  {
    if (!this.mBtnUIPresenterList.contains(paramh))
    {
      this.mBtnUIPresenterList.add(paramh);
      callAppDataDownloadCallback();
    }
  }
  
  public void setDownloader()
  {
    if (this.downloaderWrapper == null) {
      this.downloaderWrapper = new g(AdDownloader.getDownloader());
    }
  }
  
  public void setStartedDownload(boolean paramBoolean)
  {
    this.mStartedDownload = paramBoolean;
  }
  
  public void startDownload()
  {
    if (this.mCgdtAppBtnData == null) {
      return;
    }
    this.mStartedDownload = true;
    AdAppBtnData localAdAppBtnData = this.mCgdtAppBtnData;
    if (this.ad != null) {}
    for (String str = this.ad.getVia();; str = null)
    {
      localAdAppBtnData.via = str;
      if ((this.downloaderWrapper != null) && (this.mContext != null) && ((this.mContext.get() instanceof Activity))) {
        this.downloaderWrapper.startRealDownload((Activity)this.mContext.get(), this.mCgdtAppBtnData);
      }
      AdReport.downloadReport(this.ad, this.mCgdtAppBtnData.mGdtAd_appId, this.mCgdtAppBtnData.cProgerss, this.autodownload, this.mCgdtAppBtnData);
      return;
    }
  }
  
  public void startRealDownload(Activity paramActivity, AdAppBtnData paramAdAppBtnData)
  {
    this.mStartedDownload = true;
    if (this.downloaderWrapper != null) {
      this.downloaderWrapper.startRealDownload(paramActivity, paramAdAppBtnData);
    }
  }
  
  public void unregisterDownloadListener()
  {
    AdLog.d("AdAppDownloadManager", "unregisterDownloadListener");
    if (this.downloaderWrapper != null) {
      this.downloaderWrapper.unregisterListener(AdCanvasDownloadListener.getDownloadListener(this));
    }
  }
  
  static abstract interface a
  {
    public abstract void onLoadSuccess();
  }
  
  class b
    implements Runnable
  {
    String id;
    
    b(String paramString)
    {
      this.id = paramString;
    }
    
    public void run()
    {
      long l1;
      long l2;
      if ((AdAppDownloadManager.this.ad != null) && (AdAppDownloadManager.this.mCgdtAppBtnData == null))
      {
        Object localObject = new b();
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(AdAppDownloadManager.this.ad.getAppId()))
        {
          localObject = ((b)localObject).loadGdtAppBtnData(AdAppDownloadManager.this.ad.getAppId(), AdAppDownloadManager.this.ad.getAppChannelId(), -1);
          if ((localObject != null) && (((AdAppBtnData)localObject).isValid()))
          {
            ((AdAppBtnData)localObject).mGdtAd_appId = AdAppDownloadManager.this.ad.getAppId();
            AdAppDownloadManager.this.setmCgdtAppBtnData((AdAppBtnData)localObject);
          }
        }
        if (AdAppDownloadManager.this.mCgdtAppBtnData == null) {
          break label172;
        }
        AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader sucess!!!");
        AdAppDownloadManager.this.initDownloadAction(true);
        l2 = System.currentTimeMillis();
        AdAppDownloadManager.this.reprtAppDataLoad(true, l2 - l1);
      }
      for (;;)
      {
        AdAppDownloadManager.access$602(AdAppDownloadManager.this, false);
        return;
        label172:
        AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader failed!!!");
        l2 = System.currentTimeMillis();
        AdAppDownloadManager.this.reprtAppDataLoad(false, l2 - l1);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void getDownloadStatus(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void onPkgExist(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */