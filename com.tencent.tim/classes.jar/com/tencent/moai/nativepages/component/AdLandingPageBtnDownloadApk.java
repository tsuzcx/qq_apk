package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.moai.nativepages.model.AdLandingPageComponentDownloadApkBtnInfo;
import com.tencent.moai.nativepages.util.AppInfoUtil;
import com.tencent.moai.nativepages.util.DataUtil;

public class AdLandingPageBtnDownloadApk
  extends AdLandingPageBtn
{
  public AdLandingPageBtnDownloadApk(Context paramContext, AdLandingPageComponentDownloadApkBtnInfo paramAdLandingPageComponentDownloadApkBtnInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentDownloadApkBtnInfo, paramViewGroup);
  }
  
  public AdLandingPageComponentDownloadApkBtnInfo getInfo()
  {
    return (AdLandingPageComponentDownloadApkBtnInfo)this.adLandingPageComponentInfo;
  }
  
  protected void setClickAction(Button paramButton)
  {
    AdLandingPageComponentDownloadApkBtnInfo localAdLandingPageComponentDownloadApkBtnInfo = getInfo();
    if (AppInfoUtil.isAppInstalled(this.context, localAdLandingPageComponentDownloadApkBtnInfo.handleJumpedAppId)) {
      paramButton.setOnClickListener(new AdLandingPageBtnDownloadApk.1(this, localAdLandingPageComponentDownloadApkBtnInfo));
    }
    for (;;)
    {
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Button_Click", 1L);
      return;
      paramButton.setOnClickListener(new AdLandingPageBtnDownloadApk.2(this, localAdLandingPageComponentDownloadApkBtnInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtnDownloadApk
 * JD-Core Version:    0.7.0.1
 */