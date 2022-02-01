package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import oij;
import oir;
import ong;
import ooz;

public class RockDownloadPresenter$1
  extends RockDownloadListener
{
  public RockDownloadPresenter$1(oij paramoij, RockDownloadListenerWrapper paramRockDownloadListenerWrapper) {}
  
  public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = oir.getEventType();
    ooz.i("RockDownloader", "rockdownload onDownloadCancel");
    oir.beX();
    WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadCancel(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    boolean bool = true;
    oir.beX();
    ooz.e("RockDownloader", "onDownloadFail errorCode: " + paramInt + ",errorInfo:" + paramString + ",    " + paramRockDownloadInfo.toString());
    this.this$0.a(paramRockDownloadInfo);
    int i = oir.getEventType();
    WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 3, 1, 0);
    ooz.e("RockDownloader", "Rock下载失败，QQ下载兜底！,eventType = " + i);
    Activity localActivity = oij.a(this.this$0);
    oij localoij = this.this$0;
    WSDownloadParams localWSDownloadParams = oij.a(this.this$0);
    if (i != 1) {}
    for (;;)
    {
      oir.a(localActivity, localoij, localWSDownloadParams, bool, i);
      if (this.val$listenerWrapper == null) {
        break;
      }
      this.val$listenerWrapper.onDownloadFail(paramRockDownloadInfo, paramString, paramInt);
      return;
      bool = false;
    }
    ooz.e("RockDownloader", "Rock onDownloadFail, listenerWrapper is null！");
  }
  
  public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
  {
    ooz.i("RockDownloader", "rockdownload onDownloadFinish");
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadFinish(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
  {
    ooz.i("RockDownloader", "rockdownload onDownloadProceedOn,process" + paramInt);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadProceedOn(paramRockDownloadInfo, paramInt);
    }
  }
  
  public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = oir.getEventType();
    ooz.d("RockDownloader", "rockdownload onDownloadStart,eventType = " + i);
    oir.beY();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadStart(paramRockDownloadInfo);
    }
  }
  
  public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = oir.getEventType();
    ooz.w("RockDownloader", "rockdownload onDownloadSuccess,eventType = " + i);
    oir.beX();
    ong.uN(1);
    WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 2, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadSuccess(paramRockDownloadInfo);
    }
    if (i != 1)
    {
      this.this$0.a(paramRockDownloadInfo, 2);
      return;
    }
    ooz.w("RockDownloader", "rockdownload onDownloadSuccess,but preload need not call install. eventType = " + i);
  }
  
  public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
  {
    ooz.w("RockDownloader", "rockdownload onDownloadWait");
    oir.beY();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onDownloadWait(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
  {
    int i = oir.getEventType();
    ooz.d("RockDownloader", "rockdownload onPermissionDeny");
    oir.beX();
    WSPublicAccReport.getInstance().reportDownload(oir.rk(), i, 3, 1, 0);
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionDeny(paramRockDownloadInfo);
    }
  }
  
  public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
  {
    ooz.d("RockDownloader", "rockdownload onPermissionPermit");
    oir.beY();
    if (this.val$listenerWrapper != null) {
      this.val$listenerWrapper.onPermissionPermit(paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.1
 * JD-Core Version:    0.7.0.1
 */