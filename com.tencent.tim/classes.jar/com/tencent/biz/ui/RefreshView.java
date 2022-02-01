package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import auuo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import son;
import sot;
import sou;

public class RefreshView
  extends CustomScrollView
{
  private b a;
  private volatile boolean aMp = true;
  public son b;
  private Handler mHandler = new sot(this);
  private auuo mOverScrollViewListener = new sou(this);
  private int mOverscrollHeadState = 0;
  public int mState;
  private boolean overscrolling;
  private final int wr = 0;
  
  public RefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cM(paramContext);
  }
  
  @SuppressLint({"InflateParams"})
  private void cM(Context paramContext)
  {
    this.b = ((PullRefreshHeader)LayoutInflater.from(paramContext).inflate(2131559847, null));
    addView(this.b.getHeaderView(), 0);
    initHeader();
  }
  
  private boolean ev()
  {
    boolean bool2 = false;
    int i = getScrollY();
    if (i < 0)
    {
      if (i <= -getOverScrollHeight()) {
        break label92;
      }
      if (!this.overscrolling) {
        break label61;
      }
      if ((this.mOverscrollHeadState == 0) || (this.mOverscrollHeadState == 2)) {
        this.mOverScrollViewListener.a(0, null, null);
      }
    }
    for (;;)
    {
      this.mOverscrollHeadState = 1;
      return false;
      label61:
      if ((this.mOverscrollHeadState == 1) || (this.mOverscrollHeadState == 2)) {
        this.mOverScrollViewListener.c(0, null, null);
      }
    }
    label92:
    boolean bool1;
    if (this.overscrolling) {
      if (this.mOverscrollHeadState != 0)
      {
        bool1 = bool2;
        if (this.mOverscrollHeadState != 1) {}
      }
      else
      {
        this.mOverScrollViewListener.b(0, null, null);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.mOverscrollHeadState = 2;
      return bool1;
      bool1 = bool2;
      if (this.mOverscrollHeadState == 2) {
        bool1 = this.mOverScrollViewListener.a(0, null, null);
      }
    }
  }
  
  private int getOverScrollHeight()
  {
    return this.b.getHeaderView().getMeasuredHeight();
  }
  
  private void initHeader()
  {
    float f = getResources().getDisplayMetrics().density;
    this.b.getHeaderView().setMinimumHeight((int)(f * 60.0F));
    this.b.getHeaderView().setVisibility(8);
  }
  
  private void onRefresh()
  {
    if (this.a != null)
    {
      this.a.onRefresh();
      return;
    }
    ps();
  }
  
  protected boolean Nd()
  {
    return (this.aMp) || (this.mState == 3);
  }
  
  public boolean Ne()
  {
    return this.overscrolling;
  }
  
  public void onBack()
  {
    this.overscrolling = false;
    if (this.a == null)
    {
      super.onBack();
      return;
    }
    ev();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.getHeaderView().layout(0, -this.b.getHeaderView().getMeasuredHeight(), this.b.getHeaderView().getMeasuredWidth(), 0);
  }
  
  public void onOverScroll(int paramInt)
  {
    super.onOverScroll(paramInt);
    this.overscrolling = true;
    if (this.mState != 2) {
      ev();
    }
  }
  
  public void onRefreshComplete()
  {
    this.aMp = true;
    this.mState = 3;
    if (this.b.dl() == 0L)
    {
      ps();
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(0, this.b.dl());
  }
  
  public void ps()
  {
    this.aMp = true;
    super.onBack();
  }
  
  public void setDelayBeforeScrollBack(long paramLong)
  {
    if ((this.b instanceof PullRefreshHeader)) {
      ((PullRefreshHeader)this.b).yb = paramLong;
    }
  }
  
  public void setHeader(son paramson)
  {
    if (paramson == null) {
      return;
    }
    removeViewAt(0);
    this.b = paramson;
    addView(this.b.getHeaderView(), 0);
    initHeader();
  }
  
  public final void setHeaderBgColor(int paramInt)
  {
    if (this.b != null) {
      this.b.setHeaderBgColor(paramInt);
    }
  }
  
  public final void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (this.b != null) {
      this.b.setHeaderBgDrawable(paramDrawable);
    }
  }
  
  public final void setHeaderBgRes(int paramInt)
  {
    if (this.b != null) {
      this.b.setHeaderBgRes(paramInt);
    }
  }
  
  public final void setHeaderTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.b != null) {
      this.b.setTextColor(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public void setOnCancelListener(a parama) {}
  
  public void setOnRefreshListener(b paramb)
  {
    this.a = paramb;
    if (paramb == null)
    {
      this.b.getHeaderView().setVisibility(8);
      return;
    }
    this.b.getHeaderView().setVisibility(0);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void onRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView
 * JD-Core Version:    0.7.0.1
 */