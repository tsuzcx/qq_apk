package com.tencent.moai.nativepages.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.moai.nativepages.model.AdLandingPageComponentDownloadApkBtnInfo;
import com.tencent.moai.nativepages.util.AppInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdLandingPageBtnDownloadApk$2
  implements View.OnClickListener
{
  AdLandingPageBtnDownloadApk$2(AdLandingPageBtnDownloadApk paramAdLandingPageBtnDownloadApk, AdLandingPageComponentDownloadApkBtnInfo paramAdLandingPageComponentDownloadApkBtnInfo) {}
  
  public void onClick(View paramView)
  {
    this.this$0.addClickCount();
    AppInfoUtil.downloadApp(this.this$0.context, this.val$info.downloadUrl, this.val$info.showName);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtnDownloadApk.2
 * JD-Core Version:    0.7.0.1
 */