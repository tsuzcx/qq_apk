package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;

public class PttAudioPlayView
  extends PttThemeBaseView
{
  private final int bUc = 12;
  private int bUd = 2130838307;
  private boolean bhm;
  Bitmap ed;
  Bitmap ee;
  
  public PttAudioPlayView(Context paramContext)
  {
    super(paramContext);
    init(12);
  }
  
  public PttAudioPlayView(Context paramContext, int paramInt)
  {
    super(paramContext);
    init(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(12);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    init(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    init(paramInt2);
  }
  
  protected boolean SA()
  {
    return (this.ee != null) && (!this.ee.isRecycled()) && (this.ed != null) && (!this.ed.isRecycled()) && (this.bitmapSrc != null) && (!this.bitmapSrc.isRecycled());
  }
  
  protected void aB(Canvas paramCanvas)
  {
    if (!this.bhm)
    {
      paramCanvas.drawBitmap(this.ee, null, this.aj, this.bo);
      return;
    }
    paramCanvas.drawBitmap(this.ed, null, this.aj, this.bo);
  }
  
  public void destory()
  {
    super.destory();
    if ((this.ed != null) && (!this.ed.isRecycled())) {
      this.ed.recycle();
    }
    if ((this.ee != null) && (!this.ee.isRecycled())) {
      this.ee.recycle();
    }
    this.ed = null;
    this.ee = null;
  }
  
  public boolean getPlayState()
  {
    return this.bhm;
  }
  
  protected void init(int paramInt)
  {
    super.init(paramInt);
    this.ed = BitmapFactory.decodeResource(getResources(), this.bUd);
    this.ee = BitmapFactory.decodeResource(getResources(), 2130838308);
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.bhm = paramBoolean;
    this.bhE = true;
    invalidate();
  }
  
  public void setPttPauseOrStopDrawable(@DrawableRes int paramInt)
  {
    this.bUd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioPlayView
 * JD-Core Version:    0.7.0.1
 */