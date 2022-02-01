package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.download.AdDownloadConstants;
import com.tencent.ad.tangram.canvas.download.AdDownloader;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.List;

public class e
  extends h
{
  public static final String TAG = "AdCanvasAppBtnUIAdapter";
  public boolean addToDownloadCallbacks;
  private String btnTitle;
  public c data;
  private boolean firstClick = true;
  private AdAppDownloadManager mAdAppDownloadManager;
  private f mAdProgressButton;
  public boolean resumeDownload = false;
  
  public e(c paramc, String paramString, f paramf, AdAppDownloadManager paramAdAppDownloadManager, boolean paramBoolean)
  {
    this.mAdProgressButton = paramf;
    this.mAdAppDownloadManager = paramAdAppDownloadManager;
    this.btnTitle = paramString;
    this.data = paramc;
    this.addToDownloadCallbacks = paramBoolean;
    if (this.data.canShowProgress) {
      this.firstClick = false;
    }
  }
  
  private void dealDownloadInstalled(AdAppBtnData paramAdAppBtnData, Context paramContext)
  {
    installSucceedUpdateUI(paramAdAppBtnData);
    launchApp(paramContext, paramAdAppBtnData.packageName);
  }
  
  private void firstClickInitDownloadApp()
  {
    if ((this.mAdProgressButton.getContext() == null) || (this.mAdAppDownloadManager == null) || (!this.mAdAppDownloadManager.getGdtAppBtnData().isValid())) {
      return;
    }
    AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
    Context localContext = this.mAdProgressButton.getContext();
    this.mAdAppDownloadManager.dealPkgExist(new e.6(this, localContext, localAdAppBtnData));
  }
  
  private void installDownload(AdAppBtnData paramAdAppBtnData)
  {
    if (this.mAdAppDownloadManager != null) {
      this.mAdAppDownloadManager.installDownload(paramAdAppBtnData.apkUrlhttp);
    }
  }
  
  private void launchApp(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.mAdAppDownloadManager.sourceId)) {
      localBundle.putString(AdDownloadConstants.KEY_REF_ID, this.mAdAppDownloadManager.sourceId);
    }
    localBundle.putString(AdDownloadConstants.KEY, AdDownloadConstants.SRC_AD);
    AdAppUtil.launch(paramContext, paramString, localBundle);
  }
  
  private void pauseDownload(AdAppBtnData paramAdAppBtnData)
  {
    this.resumeDownload = false;
    this.mAdAppDownloadManager.pauseDownload(paramAdAppBtnData.packageName, paramAdAppBtnData.apkUrlhttp);
    pauseDownload();
    reportForPaused();
  }
  
  private void pauseDownloadUi(AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new e.1(this, paramAdAppBtnData, paramInt), 0);
  }
  
  private void restartDownload(AdAppBtnData paramAdAppBtnData)
  {
    if (this.mAdProgressButton != null)
    {
      this.mAdAppDownloadManager.startDownload();
      startDownload(0);
    }
  }
  
  private void resumeDownload(AdAppBtnData paramAdAppBtnData)
  {
    this.resumeDownload = true;
    if ((this.mAdProgressButton != null) && ((paramAdAppBtnData.cState == 2) || (paramAdAppBtnData.cState == 1)))
    {
      this.mAdAppDownloadManager.startDownload();
      startDownload(paramAdAppBtnData.cProgerss);
    }
  }
  
  private void startDownload()
  {
    this.mAdAppDownloadManager.startDownload();
    startDownload(0);
  }
  
  private void uninstallSucceedUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    resetDownloadStateUi(paramAdAppBtnData);
  }
  
  public void finishDownloadUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.3(this, paramAdAppBtnData), 0);
  }
  
  public void initDownloadApp(int paramInt)
  {
    try
    {
      if ((this.mAdAppDownloadManager == null) || (this.mAdAppDownloadManager.getGdtAppBtnData() == null)) {
        break label136;
      }
      if (!this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) {
        return;
      }
      AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
      switch (paramInt)
      {
      case 0: 
        resetDownloadStateUi(localAdAppBtnData);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "initDownloadApp: ", localThrowable);
      return;
    }
    startDownload(localThrowable.cProgerss);
    return;
    installSucceedUpdateUI(localThrowable);
    return;
    finishDownloadUpdateUI(localThrowable);
    return;
    pauseDownloadUi(localThrowable, 100);
    label136:
    return;
  }
  
  void installSucceedUpdateUI(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.4(this, paramAdAppBtnData), 0);
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList.size() == 0) || (paramList1.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while ((i < paramList.size()) && (paramList.get(i) != null) && (paramList1.get(i) != null) && (this.mAdAppDownloadManager != null) && (this.mAdAppDownloadManager.getGdtAppBtnData() != null))
      {
        AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
        if ((AdDownloader.isCurrentPkgTask((Pair)paramList1.get(i), localAdAppBtnData)) && ((this.data.canShowProgress) || (this.addToDownloadCallbacks)))
        {
          localAdAppBtnData.cState = 8;
          updateBtnProgressUI(localAdAppBtnData, AdDownloader.getProgress(paramList.get(i)));
        }
        i += 1;
      }
    }
  }
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString)
  {
    if ((paramPair == null) || (TextUtils.isEmpty((CharSequence)paramPair.first)) || (TextUtils.isEmpty((CharSequence)paramPair.second)) || (TextUtils.isEmpty(paramString))) {}
    AdAppBtnData localAdAppBtnData;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while ((this.mAdAppDownloadManager == null) || (this.mAdAppDownloadManager.getGdtAppBtnData() == null));
                localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
                switch (paramInt1)
                {
                default: 
                  return;
                }
              } while ((!AdDownloader.isCurrentPkgTask(paramPair, localAdAppBtnData)) || ((!this.data.canShowProgress) && (!this.addToDownloadCallbacks)));
              pauseDownloadUi(localAdAppBtnData, paramInt2);
              return;
            } while (!AdDownloader.isCurrentPkgTask(paramPair, localAdAppBtnData));
            finishDownloadUpdateUI(localAdAppBtnData);
            return;
          } while ((!AdDownloader.isCurrentPkgTask(paramPair, localAdAppBtnData)) || (!this.data.canShowProgress));
          resetDownloadStateUi(localAdAppBtnData);
          return;
        } while (!AdDownloader.isCurrentPkgTask(paramPair, localAdAppBtnData));
        localAdAppBtnData.cState = 5;
        return;
      } while ((!paramString.equals(localAdAppBtnData.mGdtAd_appId)) || (!((String)paramPair.second).equals(localAdAppBtnData.packageName)));
      installSucceedUpdateUI(localAdAppBtnData);
      return;
    } while ((!paramString.equals(localAdAppBtnData.mGdtAd_appId)) || (!((String)paramPair.second).equals(localAdAppBtnData.packageName)));
    uninstallSucceedUpdateUI(localAdAppBtnData);
  }
  
  public void pauseDownload()
  {
    super.pauseDownload();
    if ((this.mAdAppDownloadManager == null) || (!this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) || (this.mAdProgressButton.getContext() == null) || (this.mAdAppDownloadManager == null)) {
      return;
    }
    AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
    localAdAppBtnData.cState = 2;
    AdLog.i("AdCanvasAppBtnUIAdapter", "pauseDownload ");
    pauseDownloadUi(localAdAppBtnData, localAdAppBtnData.cProgerss);
  }
  
  public void reportForPaused()
  {
    Object localObject2 = null;
    if ((this.mAdAppDownloadManager != null) && (this.mAdAppDownloadManager.ad != null))
    {
      if (this.mAdProgressButton != null) {}
      for (Object localObject1 = this.mAdProgressButton.getContext();; localObject1 = null)
      {
        WeakReference localWeakReference = new WeakReference(localObject1);
        localObject1 = localObject2;
        if (this.mAdAppDownloadManager != null) {
          localObject1 = this.mAdAppDownloadManager.ad;
        }
        b.reportAsync(localWeakReference, (Ad)localObject1, 238);
        return;
      }
    }
    AdLog.e("AdCanvasAppBtnUIAdapter", "reportForPaused ad == null:");
  }
  
  void resetDownloadStateUi(AdAppBtnData paramAdAppBtnData)
  {
    AdThreadManager.INSTANCE.post(new e.5(this, paramAdAppBtnData), 0);
  }
  
  public void startDownload(int paramInt)
  {
    if ((this.mAdAppDownloadManager == null) || (!this.mAdAppDownloadManager.getGdtAppBtnData().isValid()) || (this.mAdProgressButton.getContext() == null) || (this.mAdAppDownloadManager == null)) {
      return;
    }
    AdAppBtnData localAdAppBtnData = this.mAdAppDownloadManager.getGdtAppBtnData();
    AdLog.i("AdCanvasAppBtnUIAdapter", "startDownload " + paramInt);
    updateBtnProgressUI(localAdAppBtnData, paramInt);
    this.resumeDownload = true;
  }
  
  public void updateBtnProgressUI(AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new e.2(this, paramAdAppBtnData, paramInt), 0);
  }
  
  public void updateUIByClick(String paramString, AdAppBtnData paramAdAppBtnData, int paramInt)
  {
    boolean bool = true;
    if (this.mAdAppDownloadManager == null)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick mAdAppDownloadManager == null");
      return;
    }
    if (paramAdAppBtnData == null)
    {
      AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick cgdtAppBtnData == null");
      if (this.resumeDownload)
      {
        this.mAdProgressButton.setDownloadingUI("继续");
        this.mAdProgressButton.setProgress(0);
        if (this.resumeDownload) {
          break label99;
        }
      }
      for (;;)
      {
        this.resumeDownload = bool;
        return;
        this.mAdProgressButton.setDownloadingUI("下载中, 0%");
        this.mAdProgressButton.setProgress(0);
        this.mAdAppDownloadManager.fetchAppDataByOnClick(paramString);
        break;
        label99:
        bool = false;
      }
    }
    AdLog.e("AdCanvasAppBtnUIAdapter", "updateUIByClick firstClick" + this.firstClick + paramString);
    if ((this.firstClick) && (this.mAdAppDownloadManager != null) && (this.mAdAppDownloadManager.hasStartedDownload()))
    {
      firstClickInitDownloadApp();
      this.firstClick = false;
      return;
    }
    this.firstClick = false;
    if (this.data != null) {
      this.data.canShowProgress = true;
    }
    switch (paramInt)
    {
    case 4: 
    case 7: 
    default: 
      return;
    case 0: 
      startDownload();
      return;
    case 6: 
      launchApp(this.mAdProgressButton.getContext(), paramAdAppBtnData.packageName);
      return;
    case 8: 
      pauseDownload(paramAdAppBtnData);
      return;
    case 1: 
    case 2: 
      resumeDownload(paramAdAppBtnData);
      return;
    case 3: 
      installDownload(paramAdAppBtnData);
      return;
    }
    restartDownload(paramAdAppBtnData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.e
 * JD-Core Version:    0.7.0.1
 */