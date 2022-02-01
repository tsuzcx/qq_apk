package dov.com.qq.im.ae.album.nocropper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import atau.a;

public class AECropperGridView
  extends View
{
  private float DE = 0.8F;
  private long aBC = 200L;
  private boolean dsN;
  private int mAlpha = 200;
  private int mColor = 268435455;
  private Handler mHandler;
  private Runnable mHideRunnable = new AECropperGridView.1(this);
  private Paint mPaint;
  private Path mPath;
  private int mStrokeWidth = 3;
  
  public AECropperGridView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    init(paramContext, paramAttributeSet);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    float f1 = 0.0F;
    float f2;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.px);
      this.mColor = paramContext.getColor(0, this.mColor);
      this.DE = paramContext.getFloat(1, 1.0F);
      f2 = this.DE * 255.0F;
      if (f2 >= 0.0F) {
        break label185;
      }
    }
    for (;;)
    {
      this.mAlpha = ((int)f1);
      this.mStrokeWidth = paramContext.getDimensionPixelOffset(2, this.mStrokeWidth);
      paramContext.recycle();
      this.mPaint = new Paint();
      this.mPaint.setColor(this.mColor);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeCap(Paint.Cap.ROUND);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      this.mPaint.setAlpha(this.mAlpha);
      this.mPath = new Path();
      this.mHandler = new Handler();
      if (isInEditMode()) {
        this.dsN = true;
      }
      return;
      label185:
      if (f2 > 255.0F) {
        f1 = 255.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.dsN) {
      return;
    }
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    this.mPath.reset();
    this.mPath.moveTo(i / 3, 0.0F);
    this.mPath.lineTo(i / 3, j);
    this.mPath.moveTo(i * 2 / 3, 0.0F);
    this.mPath.lineTo(i * 2 / 3, j);
    this.mPath.moveTo(0.0F, j / 3);
    this.mPath.lineTo(i, j / 3);
    this.mPath.moveTo(0.0F, j * 2 / 3);
    this.mPath.lineTo(i, j * 2 / 3);
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i == 1) || (i == 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
  }
  
  public void setShowGrid(boolean paramBoolean)
  {
    if (this.dsN != paramBoolean)
    {
      this.dsN = paramBoolean;
      if (this.dsN)
      {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        setAlpha(this.DE);
        invalidate();
      }
    }
    else
    {
      return;
    }
    this.mHandler.postDelayed(this.mHideRunnable, this.aBC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperGridView
 * JD-Core Version:    0.7.0.1
 */