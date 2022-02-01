package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.moai.nativepages.model.AdLandingPageComponentBtnInfo;
import com.tencent.moai.nativepages.util.AppInfoUtil;

public class AdLandingPageBtnOpenApp
  extends AdLandingPageBtn
{
  public AdLandingPageBtnOpenApp(Context paramContext, AdLandingPageComponentBtnInfo paramAdLandingPageComponentBtnInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentBtnInfo, paramViewGroup);
  }
  
  public AdLandingPageComponentBtnInfo getInfo()
  {
    return (AdLandingPageComponentBtnInfo)this.adLandingPageComponentInfo;
  }
  
  protected void setClickAction(Button paramButton)
  {
    AdLandingPageComponentBtnInfo localAdLandingPageComponentBtnInfo = getInfo();
    if (AppInfoUtil.isAppInstalled(this.context, localAdLandingPageComponentBtnInfo.handleJumpedAppId))
    {
      paramButton.setOnClickListener(new AdLandingPageBtnOpenApp.1(this, localAdLandingPageComponentBtnInfo));
      return;
    }
    paramButton.setOnClickListener(new AdLandingPageBtnOpenApp.2(this, localAdLandingPageComponentBtnInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtnOpenApp
 * JD-Core Version:    0.7.0.1
 */