package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

public class BubblePopupWindow
  extends PopupWindow
{
  private SharpView a;
  private int aWN;
  private int aWO = 80;
  private int aWP = 49;
  private FrameLayout an;
  private FrameLayout.LayoutParams c;
  private int mBackgroundColor;
  private View mContentView;
  private Context mContext;
  
  public BubblePopupWindow(Context paramContext)
  {
    super(-2, -2);
    this.mContext = paramContext;
    aUR();
  }
  
  private void aUR()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.mContext);
    SharpView localSharpView = new SharpView(this.mContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.a = localSharpView;
    this.an = localFrameLayout;
    this.c = localLayoutParams;
    setBackgroundDrawable(new ColorDrawable(0));
    setTouchable(true);
    setFocusable(false);
    setSoftInputMode(1);
    setInputMethodMode(2);
    cZ(24, 12);
    sZ(12);
    ta(6);
    setBackgroundColor(-1);
  }
  
  private void aUS()
  {
    this.an.removeAllViews();
    this.c.gravity = this.aWP;
    SharpView.a(this.a).setColor(this.mBackgroundColor);
    this.an.addView(this.a, this.c);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.aWO;
    switch (this.aWO)
    {
    }
    for (;;)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(this.mBackgroundColor);
      localGradientDrawable.setCornerRadius(this.aWN);
      this.mContentView.setBackgroundDrawable(localGradientDrawable);
      this.an.addView(this.mContentView, localLayoutParams);
      super.setContentView(this.an);
      return;
      localLayoutParams.rightMargin = SharpView.a(this.a);
      this.a.setRotation(90.0F);
      continue;
      localLayoutParams.bottomMargin = SharpView.b(this.a);
      this.a.setRotation(180.0F);
      continue;
      localLayoutParams.leftMargin = SharpView.a(this.a);
      this.a.setRotation(270.0F);
      continue;
      localLayoutParams.topMargin = SharpView.b(this.a);
      this.a.setRotation(0.0F);
    }
  }
  
  private void tb(int paramInt)
  {
    this.aWP = paramInt;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 49;
    if (!isShowing())
    {
      int i = j;
      switch (paramInt1)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        this.aWO = paramInt1;
        tb(i);
        showAtLocation(paramView, 0, paramInt2, paramInt3);
        return;
        i = 81;
        continue;
        i = 19;
        continue;
        i = 21;
      }
    }
    dismiss();
  }
  
  public void cZ(int paramInt1, int paramInt2)
  {
    SharpView.a(this.a, paramInt1);
    SharpView.b(this.a, paramInt2);
  }
  
  public int getMeasuredHeight()
  {
    if (this.mContentView == null) {
      return 0;
    }
    this.mContentView.measure(0, 0);
    return this.mContentView.getMeasuredHeight();
  }
  
  public int getMeasuredWidth()
  {
    if (this.mContentView == null) {
      return 0;
    }
    this.mContentView.measure(0, 0);
    return this.mContentView.getMeasuredWidth();
  }
  
  public void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.leftMargin = paramInt1;
    this.c.rightMargin = paramInt2;
    this.c.topMargin = paramInt3;
    this.c.bottomMargin = paramInt4;
  }
  
  public int qm()
  {
    return SharpView.b(this.a);
  }
  
  public void sZ(int paramInt)
  {
    SharpView.c(this.a, paramInt);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mContentView != null) {
      aUS();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mContentView != null) {
      aUS();
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void ta(int paramInt)
  {
    this.aWN = paramInt;
  }
  
  class SharpView
    extends View
  {
    private int aWQ;
    private int height;
    private final Paint mPaint = new Paint(1);
    private final Path mPath = new Path();
    private int width;
    
    public SharpView(Context paramContext)
    {
      super();
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setAntiAlias(true);
      Path localPath = this.mPath;
      localPath.reset();
      localPath.moveTo(this.aWQ, 0.0F);
      localPath.lineTo(0.0F, getHeight());
      localPath.lineTo(getWidth(), getHeight());
      localPath.close();
      paramCanvas.drawPath(localPath, this.mPaint);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      setMeasuredDimension(this.width, this.height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */