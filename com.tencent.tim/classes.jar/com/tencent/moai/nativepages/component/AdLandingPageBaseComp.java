package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;

public class AdLandingPageBaseComp
  extends AdLandingPageBaseComponent
{
  protected boolean appearFlag = true;
  protected long appearTime = 0L;
  
  public AdLandingPageBaseComp(Context paramContext, AdLandingPageComponentInfo paramAdLandingPageComponentInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentInfo, paramViewGroup);
  }
  
  protected void applyLayoutParams()
  {
    applyLayoutParams(true);
  }
  
  protected long getStayTime()
  {
    if (this.appearTime == 0L) {
      return 0L;
    }
    return System.currentTimeMillis() - this.appearTime;
  }
  
  protected <T> T getWrapInfo()
  {
    try
    {
      AdLandingPageComponentInfo localAdLandingPageComponentInfo = this.adLandingPageComponentInfo;
      return localAdLandingPageComponentInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    this.appearTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBaseComp
 * JD-Core Version:    0.7.0.1
 */