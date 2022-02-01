package com.tencent.qqmail.qmui.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public abstract class QMUIBasePopup
{
  protected Drawable mBackground = null;
  protected Context mContext;
  private PopupWindow.OnDismissListener mDismissListener;
  private boolean mNeedCacheSize = true;
  protected View mRootView;
  private RootView mRootViewWrapper;
  protected Point mScreenSize = new Point();
  protected PopupWindow mWindow;
  protected int mWindowHeight = 0;
  protected WindowManager mWindowManager;
  protected int mWindowWidth = 0;
  
  public QMUIBasePopup(Context paramContext)
  {
    this.mContext = paramContext;
    this.mWindow = new PopupWindow(paramContext);
    this.mWindow.setTouchInterceptor(new QMUIBasePopup.1(this));
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void measureWindowSize()
  {
    this.mRootView.measure(-2, -2);
    this.mWindowWidth = this.mRootView.getMeasuredWidth();
    this.mWindowHeight = this.mRootView.getMeasuredHeight();
  }
  
  private void preShow()
  {
    if (this.mRootViewWrapper == null) {
      throw new IllegalStateException("setContentView was not called with a view to display.");
    }
    onPreShow();
    if (this.mBackground == null) {
      this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
    }
    for (;;)
    {
      this.mWindow.setWidth(-2);
      this.mWindow.setHeight(-2);
      this.mWindow.setTouchable(true);
      this.mWindow.setFocusable(true);
      this.mWindow.setOutsideTouchable(true);
      this.mWindow.setContentView(this.mRootViewWrapper);
      return;
      this.mWindow.setBackgroundDrawable(this.mBackground);
    }
  }
  
  public void dismiss()
  {
    this.mWindow.dismiss();
  }
  
  public boolean isShowing()
  {
    return (this.mWindow != null) && (this.mWindow.isShowing());
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {}
  
  protected void onDismiss() {}
  
  protected void onPreShow() {}
  
  protected abstract Point onShow(View paramView);
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("setContentView was not called with a view to display.");
    }
    this.mRootViewWrapper = new RootView(this.mContext);
    this.mRootViewWrapper.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mRootView = paramView;
    this.mRootViewWrapper.addView(paramView);
    this.mWindow.setContentView(this.mRootViewWrapper);
    this.mWindow.setOnDismissListener(new QMUIBasePopup.3(this));
  }
  
  public void setNeedCacheSize(boolean paramBoolean)
  {
    this.mNeedCacheSize = paramBoolean;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mDismissListener = paramOnDismissListener;
  }
  
  public final void show(View paramView1, View paramView2)
  {
    preShow();
    this.mWindowManager.getDefaultDisplay().getSize(this.mScreenSize);
    if ((this.mWindowWidth == 0) || (this.mWindowHeight == 0) || (!this.mNeedCacheSize)) {
      measureWindowSize();
    }
    Point localPoint = onShow(paramView2);
    this.mWindow.showAtLocation(paramView1, 0, localPoint.x, localPoint.y);
    paramView2.addOnAttachStateChangeListener(new QMUIBasePopup.2(this));
  }
  
  public class RootView
    extends FrameLayout
  {
    public RootView(Context paramContext)
    {
      super();
    }
    
    public RootView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onConfigurationChanged(Configuration paramConfiguration)
    {
      if ((QMUIBasePopup.this.mWindow != null) && (QMUIBasePopup.this.mWindow.isShowing())) {
        QMUIBasePopup.this.mWindow.dismiss();
      }
      QMUIBasePopup.this.onConfigurationChanged(paramConfiguration);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIBasePopup
 * JD-Core Version:    0.7.0.1
 */