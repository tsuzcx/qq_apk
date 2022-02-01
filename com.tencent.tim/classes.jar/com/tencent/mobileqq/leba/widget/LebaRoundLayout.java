package com.tencent.mobileqq.leba.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class LebaRoundLayout
  extends RelativeLayout
{
  public static final int[] lG = { 1, 2, 4, 8 };
  private float[] cz = new float[8];
  public int ddZ = 15;
  public int mRadius;
  public Path mRoundPath;
  private Paint paint;
  
  public LebaRoundLayout(Context paramContext)
  {
    super(paramContext);
    dsV();
  }
  
  public LebaRoundLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    dsV();
  }
  
  public LebaRoundLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dsV();
  }
  
  private void aT(Canvas paramCanvas)
  {
    int i = 0;
    if (i < this.cz.length)
    {
      if ((lG[(i / 2)] & this.ddZ) != 0) {
        this.cz[i] = this.mRadius;
      }
      for (;;)
      {
        i += 1;
        break;
        this.cz[i] = 0.0F;
      }
    }
    this.mRoundPath.reset();
    this.mRoundPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.cz, Path.Direction.CW);
    paramCanvas.drawPath(this.mRoundPath, this.paint);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.mRadius == 0) || (this.ddZ == 0))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    i = paramCanvas.saveLayer(0.0F, 0.0F, i, j, null, 31);
    super.dispatchDraw(paramCanvas);
    try
    {
      aT(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("LebaRoundLayout", 1, "checkPathChanged", localException);
      return;
    }
    finally
    {
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void dsV()
  {
    this.mRoundPath = new Path();
    this.mRoundPath.setFillType(Path.FillType.INVERSE_WINDING);
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.paint.setColor(0);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.widget.LebaRoundLayout
 * JD-Core Version:    0.7.0.1
 */