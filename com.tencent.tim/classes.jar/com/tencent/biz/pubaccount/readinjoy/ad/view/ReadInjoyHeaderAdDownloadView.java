package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import wja;

public class ReadInjoyHeaderAdDownloadView
  extends FrameLayout
{
  private int aKL;
  private int aKM;
  private SimpleRoundProgress c;
  private ImageView ip;
  private ImageView iq;
  private int mPadding;
  private int mState;
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext)
  {
    super(paramContext);
    at(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    at(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    at(paramContext);
  }
  
  private void at(Context paramContext)
  {
    this.c = new SimpleRoundProgress(paramContext);
    this.c.aKN = Color.parseColor("#D9FFFFFF");
    this.c.aKO = Color.parseColor("#FF00CAFC");
    this.c.iD = wja.dp2px(1.5F, paramContext.getResources());
    this.c.iE = wja.dp2px(1.5F, paramContext.getResources());
    this.c.iF = wja.dp2px(7.0F, paramContext.getResources());
    this.c.max = 100;
    this.c.aJo = 270;
    this.c.style = 0;
    this.c.progress = 65;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.c, localLayoutParams);
    this.ip = new ImageView(paramContext);
    this.aKM = 2130842616;
    this.ip.setImageResource(this.aKM);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.ip, localLayoutParams);
    this.iq = new ImageView(paramContext);
    this.aKL = 2130842618;
    this.iq.setImageResource(this.aKL);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.iq, localLayoutParams);
    this.mPadding = wja.dp2px(1.5F, paramContext.getResources());
    ct(0, 0);
  }
  
  public void ct(int paramInt1, int paramInt2)
  {
    this.mState = paramInt1;
    this.ip.setVisibility(8);
    this.iq.setVisibility(8);
    this.c.setVisibility(8);
    switch (this.mState)
    {
    case 3: 
    default: 
      return;
    case 0: 
      if (getPaddingTop() != this.mPadding) {
        setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
      }
      this.ip.setVisibility(0);
      return;
    case 4: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      this.c.setVisibility(0);
      this.c.setPaused(true);
      this.c.setProgress(paramInt2);
      return;
    case 1: 
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      this.c.setVisibility(0);
      this.c.setPaused(false);
      this.c.setProgress(paramInt2);
      return;
    }
    if (getPaddingTop() != this.mPadding) {
      setPadding(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
    }
    this.iq.setVisibility(0);
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public void updateProgress(int paramInt)
  {
    if (this.mState != 1)
    {
      this.mState = 1;
      ct(1, paramInt);
      return;
    }
    this.c.setProgress(paramInt);
  }
  
  public static class SimpleRoundProgress
    extends View
  {
    RectF C;
    public int aJo;
    public int aKN;
    public int aKO;
    public float iD;
    public float iE;
    public float iF;
    private volatile boolean isPause;
    public int max;
    public Paint paint = new Paint();
    public int progress;
    public int style;
    
    public SimpleRoundProgress(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    public SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      int i = getWidth() / 2;
      int j = (int)(i - this.iD / 2.0F);
      this.paint.setStrokeWidth(this.iD);
      this.paint.setColor(this.aKN);
      this.paint.setAntiAlias(true);
      this.paint.setStrokeCap(Paint.Cap.ROUND);
      RectF localRectF;
      switch (this.style)
      {
      default: 
        paramCanvas.drawCircle(i, i, j, this.paint);
        this.paint.setStrokeWidth(this.iE);
        this.paint.setColor(this.aKO);
        localRectF = new RectF(i - j, i - j, i + j, j + i);
        j = this.progress * 360 / this.max;
        switch (this.style)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.isPause)
        {
          this.paint.setStyle(Paint.Style.FILL);
          float f = this.iF / 2.0F;
          if (this.C == null) {
            this.C = new RectF(i - f, i - f, i + f, f + i);
          }
          paramCanvas.drawRect(this.C, this.paint);
        }
        return;
        this.paint.setStyle(Paint.Style.STROKE);
        break;
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        break;
        paramCanvas.drawArc(localRectF, this.aJo, j, false, this.paint);
        continue;
        paramCanvas.drawArc(localRectF, this.aJo, j, true, this.paint);
      }
    }
    
    public void setMax(int paramInt)
    {
      if (paramInt < 0) {
        try
        {
          throw new IllegalArgumentException("max not less than 0");
        }
        finally {}
      }
      this.max = paramInt;
    }
    
    public void setPauseWithoutInvalidate(boolean paramBoolean)
    {
      this.isPause = paramBoolean;
    }
    
    public void setPaused(boolean paramBoolean)
    {
      this.isPause = paramBoolean;
      postInvalidate();
    }
    
    public void setProgress(int paramInt)
    {
      if (paramInt < 0) {
        try
        {
          throw new IllegalArgumentException("progress not less than 0");
        }
        finally {}
      }
      int i = paramInt;
      if (paramInt > this.max) {
        i = this.max;
      }
      this.progress = i;
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView
 * JD-Core Version:    0.7.0.1
 */