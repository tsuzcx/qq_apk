package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class QMReadMailScreenShotBubbleImageView
  extends ImageView
{
  private static final int PRESSED_MASK_COLOR = 855638016;
  private Bitmap mBitmap;
  private Paint mBorderPaint;
  private Matrix mMatrix;
  private Drawable mShadowDrawable;
  
  public QMReadMailScreenShotBubbleImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private Drawable getShadowDrawable()
  {
    if (this.mShadowDrawable == null) {
      this.mShadowDrawable = getResources().getDrawable(2130840847);
    }
    return this.mShadowDrawable;
  }
  
  private void init()
  {
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setColor(getResources().getColor(2131167167));
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
    this.mBorderPaint.setStrokeWidth(2.0F);
    this.mMatrix = new Matrix();
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    super.dispatchSetPressed(paramBoolean);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mBitmap == null) {
      super.onDraw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.mBorderPaint);
      Drawable localDrawable = getShadowDrawable();
      localDrawable.setBounds(0, 0, getWidth(), getHeight());
      localDrawable.draw(paramCanvas);
      if (isPressed()) {
        paramCanvas.drawColor(855638016);
      }
      return;
      float f = getWidth() / this.mBitmap.getWidth();
      this.mMatrix.reset();
      this.mMatrix.setScale(f, f);
      paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailScreenShotBubbleImageView
 * JD-Core Version:    0.7.0.1
 */