package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;

public abstract class AdLandingPageBtnBase
  extends AdLandingPageBaseComp
{
  private int clickCount = 0;
  
  public AdLandingPageBtnBase(Context paramContext, AdLandingPageComponentInfo paramAdLandingPageComponentInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentInfo, paramViewGroup);
  }
  
  protected void addClickCount()
  {
    this.clickCount += 1;
  }
  
  protected int getClickCount()
  {
    return this.clickCount;
  }
  
  public void setClickCount(int paramInt)
  {
    this.clickCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBtnBase
 * JD-Core Version:    0.7.0.1
 */