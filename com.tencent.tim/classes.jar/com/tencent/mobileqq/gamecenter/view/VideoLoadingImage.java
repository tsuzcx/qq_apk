package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class VideoLoadingImage
  extends ImageView
{
  private int dbn;
  private int dbo;
  private int dbp;
  private int dbq;
  private Bitmap fj;
  private Bitmap fk;
  private int mHeight;
  private int mWidth;
  public float wz;
  
  public VideoLoadingImage(Context paramContext)
  {
    super(paramContext);
    initData();
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initData();
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initData();
  }
  
  public void initData()
  {
    this.fj = BitmapFactory.decodeResource(getResources(), 2130840556);
    if (this.fj != null)
    {
      this.dbn = this.fj.getHeight();
      this.dbo = this.fj.getWidth();
    }
    this.fk = BitmapFactory.decodeResource(getResources(), 2130840557);
    if (this.fk != null)
    {
      this.dbp = this.fk.getHeight();
      this.dbq = this.fk.getWidth();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mHeight == 0)
    {
      this.mHeight = getMeasuredHeight();
      this.mWidth = getMeasuredWidth();
    }
    if ((this.fj != null) && (this.fk != null))
    {
      this.wz += 2.5F;
      paramCanvas.save();
      paramCanvas.rotate(this.wz, getWidth() >> 1, getHeight() >> 1);
      paramCanvas.drawBitmap(this.fj, new Rect(0, 0, this.dbo, this.dbn), new Rect(0, 0, this.mWidth, this.mHeight), null);
      paramCanvas.restore();
      paramCanvas.rotate(-this.wz, getWidth() >> 1, getHeight() >> 1);
      paramCanvas.drawBitmap(this.fk, new Rect(0, 0, this.dbq, this.dbp), new Rect(this.mWidth >> 2, this.mHeight >> 2, this.mWidth * 3 / 4, this.mHeight * 3 / 4), null);
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage
 * JD-Core Version:    0.7.0.1
 */