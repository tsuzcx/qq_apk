package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class PanoramaLoadingBackground
  extends View
{
  public static int ezn = 180;
  private int JO = PanoramaLoadingLayout.WIDTH;
  private int colorBackground;
  private int ezi;
  private int ezo;
  private int ezp;
  private int ezq = 255;
  private Paint mPaint;
  private int mViewHeight = PanoramaLoadingLayout.HEIGHT;
  
  public PanoramaLoadingBackground(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PanoramaLoadingBackground(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void bL(Canvas paramCanvas)
  {
    this.mPaint.setColor(-1);
    this.mPaint.setAlpha(this.ezq);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.JO / 2, this.JO / 2, this.ezp, this.mPaint);
  }
  
  private void bQ(Canvas paramCanvas)
  {
    this.mPaint.setColor(-16777216);
    this.mPaint.setAlpha(this.ezq);
    this.mPaint.setTextSize(this.JO / 5);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.mPaint.setStrokeWidth(0.0F);
    Paint.FontMetricsInt localFontMetricsInt = this.mPaint.getFontMetricsInt();
    int i = this.mViewHeight / 2;
    int j = localFontMetricsInt.descent;
    int k = (localFontMetricsInt.descent - localFontMetricsInt.ascent) / 2;
    paramCanvas.drawText("360", getWidth() / 2, k + (i - j), this.mPaint);
  }
  
  private void bR(Canvas paramCanvas)
  {
    this.mPaint.setAlpha(255);
    this.mPaint.setColor(this.colorBackground);
    this.mPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.JO / 2, this.JO / 2, this.ezi, this.mPaint);
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.ezi = (this.JO / 2);
    this.ezo = (this.ezi - this.ezi / 5);
    this.ezp = (this.ezi - this.ezi * 2 / 5);
    bR(paramCanvas);
    bL(paramCanvas);
    bQ(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureWidth(paramInt1), measureHeight(paramInt2));
  }
  
  public void setContentAlpha(int paramInt)
  {
    this.ezq = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBackground
 * JD-Core Version:    0.7.0.1
 */