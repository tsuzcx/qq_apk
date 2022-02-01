package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import rpq;

public abstract class ProviderView
  extends FrameLayout
{
  private QQSlidingTabView a;
  private QQSlidingTabView b;
  protected a c;
  protected QQSlidingTabView c;
  protected boolean cBk = true;
  protected int dzM;
  protected AppInterface mApp;
  protected View mBaseView;
  protected int mContentHeight = 206;
  protected ViewGroup mContentLayout;
  protected View mContentView;
  Context mContext;
  protected boolean mInited;
  protected Handler mThreadHandler;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mThreadHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public void TZ(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void addContentView(View paramView)
  {
    if (this.mContentLayout == null) {
      throw new IllegalStateException("no content layout");
    }
    this.mContentLayout.addView(paramView);
  }
  
  public boolean ava()
  {
    return this.cBk;
  }
  
  public void dKI() {}
  
  public void dLs() {}
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.mBaseView == null)
    {
      paramBundle = LayoutInflater.from(getContext()).inflate(2131561236, this, false);
      addView(paramBundle);
      this.a = ((QQSlidingTabView)paramBundle.findViewById(2131373722));
      this.b = ((QQSlidingTabView)paramBundle.findViewById(2131373717));
      this.mContentLayout = ((ViewGroup)paramBundle.findViewById(2131373719));
    }
    paramBundle = this.mContentLayout.getLayoutParams();
    paramBundle.height = rpq.dip2px(getContext(), this.mContentHeight);
    this.mContentLayout.setLayoutParams(paramBundle);
    if (this.cBk)
    {
      if (this.dzM != 1) {
        break label155;
      }
      paramBundle = this.a;
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView = paramBundle;
      this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.setVisibility(0);
      if (this.dzM != 1) {
        break label163;
      }
      findViewById(2131373723).setVisibility(0);
    }
    for (;;)
    {
      this.mInited = true;
      return;
      label155:
      paramBundle = this.b;
      break;
      label163:
      if (this.dzM != 2) {}
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.cBk = paramBoolean;
  }
  
  public void setProviderViewListener(a parama)
  {
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$a = parama;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.dzM = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void TJ(int paramInt);
    
    public abstract void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString);
    
    public abstract void b(FilterCategoryItem paramFilterCategoryItem);
    
    public abstract void c(FilterCategoryItem paramFilterCategoryItem);
    
    public abstract void d(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo);
    
    public abstract void dC(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */