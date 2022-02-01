package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.qphone.base.util.QLog;

public class PullToZoomHeaderListView
  extends XListView
{
  private View Lx;
  private ProfileBaseView a;
  private int aDM;
  private int aYk;
  private ImageView gl;
  
  public PullToZoomHeaderListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToZoomHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PullToZoomHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aWf()
  {
    int i = 0;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if ((this.gl != null) && (this.aYk > 0))
    {
      j = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("PullToZoomHeaderListView", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(j) }));
      }
      k = this.gl.getLeft();
      m = this.gl.getTop();
      n = this.gl.getRight();
      i1 = this.gl.getBottom();
      if (j < 0) {
        break label143;
      }
    }
    for (;;)
    {
      if (i != m)
      {
        this.gl.layout(k, i, n, i1);
        if (this.Lx != null) {
          this.Lx.layout(k, i, n, i1);
        }
        if (this.a != null) {
          this.a.SN(i);
        }
      }
      return;
      label143:
      i = j;
    }
  }
  
  private void init()
  {
    this.aDM = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomHeaderListView", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.aDM) }));
    }
  }
  
  public void computeScroll()
  {
    aWf();
    super.computeScroll();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewGroup localViewGroup;
    if ((this.gl != null) && (this.aYk == 0))
    {
      this.aYk = this.gl.getHeight();
      localViewGroup = (ViewGroup)this.gl.getParent();
    }
    for (;;)
    {
      if (localViewGroup != null)
      {
        localViewGroup.setClipChildren(false);
        localViewGroup.setClipToPadding(false);
        if (localViewGroup != this) {}
      }
      else
      {
        return;
      }
      try
      {
        localViewGroup = (ViewGroup)localViewGroup.getParent();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PullToZoomHeaderListView", 2, "onLayout setClipChildren fail!", localException);
        }
        Object localObject = null;
      }
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.aDM, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.gl = paramImageView;
    this.aYk = 0;
  }
  
  public void setHeaderMask(View paramView)
  {
    this.Lx = paramView;
  }
  
  public void setProfileBaseView(ProfileBaseView paramProfileBaseView)
  {
    this.a = paramProfileBaseView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PullToZoomHeaderListView
 * JD-Core Version:    0.7.0.1
 */