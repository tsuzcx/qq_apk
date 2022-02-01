package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.moai.nativepages.model.AdLandingPageComponentInfo;

public class AdLandingPageBaseComponent
{
  protected static final int NON_LAYOUT = 2147483647;
  protected AdLandingPageComponentInfo adLandingPageComponentInfo;
  private boolean bViewAppear = false;
  protected int backgroundColor;
  protected ViewGroup containerGroup;
  protected View contentView = null;
  protected Context context;
  
  public AdLandingPageBaseComponent(Context paramContext, AdLandingPageComponentInfo paramAdLandingPageComponentInfo, ViewGroup paramViewGroup)
  {
    this.context = paramContext;
    this.adLandingPageComponentInfo = paramAdLandingPageComponentInfo;
    this.containerGroup = paramViewGroup;
  }
  
  private int getGravity()
  {
    int i = 0;
    switch (this.adLandingPageComponentInfo.verticalAlignment)
    {
    }
    for (;;)
    {
      switch (this.adLandingPageComponentInfo.horizontalAlignment)
      {
      default: 
        return i;
        i = 80;
        continue;
        i = 16;
        continue;
        i = 48;
      }
    }
    return i | 0x1;
    return i | 0x3;
    return i | 0x5;
  }
  
  private void setAdLandingPageComponentInfo(AdLandingPageComponentInfo paramAdLandingPageComponentInfo)
  {
    this.adLandingPageComponentInfo = paramAdLandingPageComponentInfo;
  }
  
  protected void applyLayoutParams()
  {
    applyLayoutParams(false);
  }
  
  protected void applyLayoutParams(boolean paramBoolean)
  {
    if (this.contentView == null) {
      throw new IllegalStateException("set field contentView first");
    }
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    int i;
    if (this.adLandingPageComponentInfo != null)
    {
      localLayoutParams = this.contentView.getLayoutParams();
      if (localLayoutParams == null) {
        break label222;
      }
      if (this.adLandingPageComponentInfo.layoutWidth != 2.147484E+009F) {
        localLayoutParams.width = ((int)this.adLandingPageComponentInfo.layoutWidth);
      }
      if (this.adLandingPageComponentInfo.layoutHeight != 2.147484E+009F) {
        localLayoutParams.height = ((int)this.adLandingPageComponentInfo.layoutHeight);
      }
      if ((paramBoolean) && ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.adLandingPageComponentInfo.paddingLeft, (int)this.adLandingPageComponentInfo.paddingTop, (int)this.adLandingPageComponentInfo.paddingRight, (int)this.adLandingPageComponentInfo.paddingBottom);
      }
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break label182;
      }
      localObject = (LinearLayout.LayoutParams)localLayoutParams;
      i = getGravity();
      if (i == 0) {
        break label173;
      }
      ((LinearLayout.LayoutParams)localObject).gravity = i;
    }
    for (;;)
    {
      this.contentView.setLayoutParams(localLayoutParams);
      return;
      label173:
      ((LinearLayout.LayoutParams)localObject).gravity = -1;
      continue;
      label182:
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject = (FrameLayout.LayoutParams)localLayoutParams;
        i = getGravity();
        if (i != 0) {
          ((FrameLayout.LayoutParams)localObject).gravity = i;
        } else {
          ((FrameLayout.LayoutParams)localObject).gravity = -1;
        }
      }
    }
    label222:
    throw new IllegalStateException("params null");
  }
  
  protected View createView()
  {
    return this.contentView;
  }
  
  protected View customLayout()
  {
    return null;
  }
  
  protected void fillItem() {}
  
  public AdLandingPageComponentInfo getAdLandingPageComponentInfo()
  {
    return this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2147483647;
  }
  
  public final View getView()
  {
    if (this.contentView != null) {
      return this.contentView;
    }
    inflateLayout();
    createView();
    fillItem();
    applyLayoutParams();
    return this.contentView;
  }
  
  public boolean getViewAppeared()
  {
    return this.bViewAppear;
  }
  
  protected void inflateLayout()
  {
    if (this.contentView != null) {}
    for (;;)
    {
      return;
      int i = getLayout();
      if (i != 2147483647) {
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.containerGroup, false);
      }
      while (this.contentView == null)
      {
        throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        this.contentView = customLayout();
        if (this.contentView.getLayoutParams() == null)
        {
          this.containerGroup.addView(this.contentView);
          ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
          this.containerGroup.removeView(this.contentView);
          this.contentView.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void updateDataSet(AdLandingPageComponentInfo paramAdLandingPageComponentInfo)
  {
    AdLandingPageComponentInfo localAdLandingPageComponentInfo = getAdLandingPageComponentInfo();
    if (localAdLandingPageComponentInfo == paramAdLandingPageComponentInfo) {}
    while ((localAdLandingPageComponentInfo != null) && (localAdLandingPageComponentInfo.equals(paramAdLandingPageComponentInfo))) {
      return;
    }
    setAdLandingPageComponentInfo(paramAdLandingPageComponentInfo);
    fillItem();
    applyLayoutParams();
  }
  
  public void viewAppeared(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void viewWillAppear()
  {
    if (this.bViewAppear) {
      return;
    }
    this.bViewAppear = true;
  }
  
  public void viewWillDestroy()
  {
    viewWillDisappear();
  }
  
  public void viewWillDisappear()
  {
    if (!this.bViewAppear) {
      return;
    }
    this.bViewAppear = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageBaseComponent
 * JD-Core Version:    0.7.0.1
 */