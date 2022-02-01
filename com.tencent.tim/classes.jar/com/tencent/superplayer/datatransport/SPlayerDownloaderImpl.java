package com.tencent.superplayer.datatransport;

import android.content.Context;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.datatransport.TPProxyUtils;

public class SPlayerDownloaderImpl
  implements ISPlayerDownloader
{
  private static final String TAG = SPlayerDownloaderImpl.class.getSimpleName();
  private ITPDownloadProxy mTPDownloadProxy;
  
  public SPlayerDownloaderImpl(Context paramContext, int paramInt)
  {
    CommonUtil.initDataTransportDataFolder(CommonUtil.getDownloadProxyServiceType(paramInt));
    paramContext = TPProxyGlobalManager.getInstance().getPlayerProxy(CommonUtil.getDownloadProxyServiceType(paramInt));
    if ((paramContext != null) && (paramContext.getDownloadProxy() != null)) {
      this.mTPDownloadProxy = paramContext.getDownloadProxy();
    }
  }
  
  private int getDlTypeForDownloadParam(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 10;
    case 101: 
      return 1;
    }
    return 3;
  }
  
  public void pauseOfflineDownload(int paramInt)
  {
    if (this.mTPDownloadProxy != null) {
      this.mTPDownloadProxy.pauseDownload(paramInt);
    }
  }
  
  public void resumeOfflineDownload(int paramInt)
  {
    if (this.mTPDownloadProxy != null) {
      this.mTPDownloadProxy.resumeDownload(paramInt);
    }
  }
  
  public int startOfflineDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, ISPlayerDownloader.Listener paramListener)
  {
    if ((this.mTPDownloadProxy == null) || (paramSuperPlayerVideoInfo == null))
    {
      LogUtil.e(TAG, "error, mTPDownloadProxy = " + this.mTPDownloadProxy + ", videoInfo = " + paramSuperPlayerVideoInfo + ", return");
      return 0;
    }
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localTPDownloadParamData.setDownloadFileID(CommonUtil.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo));
    localTPDownloadParamData.setDlType(getDlTypeForDownloadParam(paramSuperPlayerVideoInfo.getFormat()));
    int i = this.mTPDownloadProxy.startOfflineDownload(CommonUtil.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo), TPProxyUtils.convertProxyDownloadParams(null, localTPDownloadParamData, CommonUtil.createHttpHeaderForFirstUrl(paramSuperPlayerVideoInfo)), null);
    TPListenerManager.getInstance().setOfflineDownloadListener(i, new SPlayerDownloaderImpl.1(this, paramListener, i));
    this.mTPDownloadProxy.startTask(i);
    return i;
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    if (this.mTPDownloadProxy != null) {
      this.mTPDownloadProxy.stopOfflineDownload(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */