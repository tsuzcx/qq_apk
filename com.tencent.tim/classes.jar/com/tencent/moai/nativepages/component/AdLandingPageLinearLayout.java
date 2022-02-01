package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.moai.nativepages.CompRenderer;
import com.tencent.moai.nativepages.model.AdLandingPageComponentLinearLayoutInfo;

public class AdLandingPageLinearLayout
  extends AdLandingPageBaseComp
{
  private LinearLayout mainLinearLayout;
  private CompRenderer renderer;
  
  public AdLandingPageLinearLayout(Context paramContext, AdLandingPageComponentLinearLayoutInfo paramAdLandingPageComponentLinearLayoutInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentLinearLayoutInfo, paramViewGroup);
  }
  
  public View createView()
  {
    this.mainLinearLayout = ((LinearLayout)this.contentView.findViewById(2131378536));
    return this.contentView;
  }
  
  protected void fillItem()
  {
    if (getInfo().linearLayoutOrientation == 0) {
      this.mainLinearLayout.setOrientation(1);
    }
    while (this.renderer == null)
    {
      this.renderer = new CompRenderer(getInfo().componentList, this.context, getInfo().bgColor, this.mainLinearLayout);
      this.renderer.layout();
      return;
      if (getInfo().linearLayoutOrientation == 1) {
        this.mainLinearLayout.setOrientation(0);
      }
    }
    this.renderer.notify(getInfo().componentList);
  }
  
  public AdLandingPageComponentLinearLayoutInfo getInfo()
  {
    return (AdLandingPageComponentLinearLayoutInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563094;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageLinearLayout
 * JD-Core Version:    0.7.0.1
 */