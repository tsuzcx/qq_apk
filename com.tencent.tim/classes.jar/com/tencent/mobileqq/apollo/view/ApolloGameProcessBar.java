package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;

public class ApolloGameProcessBar
  extends View
{
  private String TAG = "ApolloGameProcessBar";
  private boolean bGw;
  private Bitmap eH;
  private Bitmap eI;
  private int height;
  private int progress;
  private int width;
  
  public ApolloGameProcessBar(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    try
    {
      this.eH = BitmapFactory.decodeResource(paramContext.getResources(), paramInt1);
      this.eI = BitmapFactory.decodeResource(paramContext.getResources(), paramInt2);
      this.width = this.eH.getWidth();
      this.height = this.eH.getHeight();
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "out of memory");
      }
      this.eH = null;
      this.eI = null;
      this.width = 0;
      this.height = 0;
    }
  }
  
  public ApolloGameProcessBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloGameProcessBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int at(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != -2147483648);
    return Math.min(paramInt2, i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.eH == null) || (this.eI == null)) {
      return;
    }
    if (!this.bGw)
    {
      this.eH = Bitmap.createScaledBitmap(this.eH, this.width, this.height, false);
      this.eI = Bitmap.createScaledBitmap(this.eI, this.width, this.height, false);
      this.bGw = true;
    }
    super.onDraw(paramCanvas);
    if (this.progress == 0)
    {
      paramCanvas.drawBitmap(this.eH, 0.0F, 0.0F, null);
      return;
    }
    if (this.progress == 100)
    {
      paramCanvas.drawBitmap(this.eI, 0.0F, 0.0F, null);
      return;
    }
    int i = (int)Math.floor(this.height * this.progress / 100);
    Bitmap localBitmap1 = Bitmap.createBitmap(this.eH, 0, 0, this.width, this.height - i);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.eI, 0, this.height - i, this.width, i);
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
    paramCanvas.drawBitmap(localBitmap2, 0.0F, this.height - i, null);
    localBitmap1.recycle();
    localBitmap2.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.width = at(paramInt1, this.width);
    this.height = at(paramInt2, this.height);
    setMeasuredDimension(this.width, this.height);
  }
  
  public void setBitmaps(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.eH = paramBitmap1;
    this.eI = paramBitmap2;
    this.width = paramBitmap1.getWidth();
    this.height = paramBitmap2.getHeight();
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.eH == null) || (this.eI == null)) {}
    while ((paramInt > 100) || (paramInt < 0)) {
      return;
    }
    this.progress = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameProcessBar
 * JD-Core Version:    0.7.0.1
 */