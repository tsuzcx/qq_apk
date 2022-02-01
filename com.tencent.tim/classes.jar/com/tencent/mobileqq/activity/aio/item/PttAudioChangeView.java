package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class PttAudioChangeView
  extends PttThemeBaseView
{
  private int bUb;
  Bitmap ec;
  
  public PttAudioChangeView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.bUb = paramInt1;
    init(paramInt2);
  }
  
  public PttAudioChangeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet);
    this.bUb = paramInt1;
    init(paramInt2);
  }
  
  public PttAudioChangeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    this.bUb = paramInt2;
    init(paramInt3);
  }
  
  protected boolean SA()
  {
    return (this.bitmapSrc != null) && (!this.bitmapSrc.isRecycled()) && (this.ec != null) && (!this.ec.isRecycled());
  }
  
  protected void aB(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.ec, null, this.aj, this.bo);
  }
  
  public void destory()
  {
    super.destory();
    if ((this.ec != null) && (!this.ec.isRecycled())) {
      this.ec.recycle();
    }
    this.ec = null;
  }
  
  protected void init(int paramInt)
  {
    super.init(paramInt);
    this.ec = BitmapFactory.decodeResource(getResources(), this.bUb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioChangeView
 * JD-Core Version:    0.7.0.1
 */