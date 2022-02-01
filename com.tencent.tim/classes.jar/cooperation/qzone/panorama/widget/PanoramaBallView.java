package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import aqnm;

public class PanoramaBallView
  extends View
{
  public static final int HEIGHT = aqnm.dpToPx(32.0F);
  public static final int WIDTH = aqnm.dpToPx(32.0F);
  private int JO = WIDTH;
  private int colorBackground;
  private int ezi;
  private int ezj;
  private int ezk;
  private int ezl;
  private int ezm = 360;
  private Paint mPaint;
  private int mViewHeight = HEIGHT;
  private int modeType;
  private float zf;
  
  public PanoramaBallView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaBallView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void bP(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    paramCanvas.drawArc(new RectF(this.ezi - this.ezj, this.ezi - this.ezj, this.ezi + this.ezj, this.ezi + this.ezj), -90 - this.ezm / 2, this.ezm, false, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int i = (this.ezi - this.ezj) / 2;
    int j = i / 2;
    localPath.moveTo(this.ezi, this.ezi - this.ezj - i);
    localPath.lineTo(this.ezi - j, this.ezi - this.ezj);
    localPath.lineTo(this.ezi + j, this.ezi - this.ezj);
    localPath.close();
    paramCanvas.drawPath(localPath, this.mPaint);
  }
  
  private void drawBackground(Canvas paramCanvas)
  {
    this.mPaint.setColor(this.colorBackground);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.JO / 2, this.JO / 2, this.JO / 2, this.mPaint);
  }
  
  private void drawContent(Canvas paramCanvas)
  {
    int i = (this.ezi - this.ezj) / 2;
    RectF localRectF = new RectF(this.ezi - this.ezj + i, this.ezi - this.ezj + i, this.ezi + this.ezj - i, this.ezi + this.ezj - i);
    this.mPaint.setColor(-1);
    float f3 = -90.0F - this.zf / 2.0F + this.ezk;
    float f2 = f3;
    if (this.ezm != 360)
    {
      f1 = f3;
      if (f3 < -90 - this.ezm / 2) {
        f1 = -90 - this.ezm / 2;
      }
      f2 = f1;
      if (this.zf + f1 <= this.ezm / 2 - 90) {}
    }
    for (float f1 = this.ezm / 2 - 90 - this.zf;; f1 = f2)
    {
      paramCanvas.drawArc(localRectF, f1, this.zf, true, this.mPaint);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.colorBackground = paramContext.getResources().getColor(2131165397);
  }
  
  private int measureHeight(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.mViewHeight = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.mViewHeight);
      } else {
        paramInt = this.mViewHeight;
      }
    }
  }
  
  private int measureWidth(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {}
    for (;;)
    {
      this.JO = paramInt;
      return paramInt;
      if (i == -2147483648) {
        paramInt = Math.min(paramInt, this.JO);
      } else {
        paramInt = this.JO;
      }
    }
  }
  
  public int PS()
  {
    return this.ezk;
  }
  
  public int PT()
  {
    return this.ezl;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.ezi = (this.JO / 2);
    this.ezj = (this.ezi - this.JO / 6);
    drawBackground(paramCanvas);
    bP(paramCanvas);
    drawContent(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setDegreeChange(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.ezm = paramInt1;
    this.ezk = paramInt2;
    this.ezl = paramInt3;
    if (this.modeType == 2) {}
    for (paramFloat = (paramFloat - 0.122F) / 0.878F;; paramFloat = (paramFloat - 0.35F) / 1.15F)
    {
      this.zf = (paramFloat * 75.0F + 45.0F);
      postInvalidate();
      return;
    }
  }
  
  public void setModeType(int paramInt)
  {
    this.modeType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaBallView
 * JD-Core Version:    0.7.0.1
 */