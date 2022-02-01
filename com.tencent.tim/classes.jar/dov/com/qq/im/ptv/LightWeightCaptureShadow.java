package dov.com.qq.im.ptv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import azbx;

public class LightWeightCaptureShadow
  extends View
{
  private Paint Q;
  private RectF bN = new RectF();
  private int captureHeight = azbx.dip2px(160.0F);
  private int captureWidth = azbx.dip2px(160.0F);
  private int eJm = -1929379840;
  private int mHeight;
  private int mRadius = azbx.dip2px(14.0F);
  int mStrokeWidth = 2;
  private int mWidth;
  private int shadowColor = 0;
  
  public LightWeightCaptureShadow(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LightWeightCaptureShadow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  protected void cb(Canvas paramCanvas)
  {
    int i = (this.mWidth - this.captureWidth) / 2;
    this.Q.setColor(this.shadowColor);
    this.Q.setShadowLayer(i, 0.0F, 0.0F, this.shadowColor);
    i = (this.mWidth - this.captureWidth) / 2;
    int j = (this.mHeight - this.captureHeight) / 2;
    this.mWidth = this.captureWidth;
    this.mHeight = this.captureHeight;
    int k = this.mStrokeWidth / 2;
    float f1 = this.mRadius + k;
    float f2 = k;
    float f3 = this.mWidth;
    paramCanvas.drawLine(i + f1, f2 + j, f3 - f1 + i, f2 + j, this.Q);
    f1 = this.mRadius + k;
    f2 = this.mHeight - k;
    f3 = this.mWidth;
    paramCanvas.drawLine(i + f1, f2 + j, f3 - f1 + i, f2 + j, this.Q);
    f1 = k;
    f2 = this.mRadius + k;
    f3 = this.mHeight;
    paramCanvas.drawLine(i + f1, f2 + j, i + f1, f3 - f2 + j, this.Q);
    f1 = this.mWidth - k;
    f2 = this.mRadius + k;
    f3 = this.mHeight;
    paramCanvas.drawLine(i + f1, f2 + j, i + f1, f3 - f2 + j, this.Q);
    int m = this.mRadius + this.mRadius;
    RectF localRectF1 = this.bN;
    RectF localRectF2 = this.bN;
    f1 = k;
    localRectF2.top = f1;
    localRectF1.left = f1;
    localRectF1 = this.bN;
    localRectF2 = this.bN;
    f1 = k + m;
    localRectF2.bottom = f1;
    localRectF1.right = f1;
    this.bN.offset(i, j);
    paramCanvas.drawArc(this.bN, 180.0F, 90.0F, false, this.Q);
    this.bN.left = k;
    this.bN.top = (this.mHeight - (k + m));
    this.bN.right = (k + m);
    this.bN.bottom = (this.mHeight - k);
    this.bN.offset(i, j);
    paramCanvas.drawArc(this.bN, 90.0F, 90.0F, false, this.Q);
    this.bN.left = (this.mWidth - (k + m));
    this.bN.top = (this.mHeight - (k + m));
    this.bN.right = (this.mWidth - k);
    this.bN.bottom = (this.mHeight - k);
    this.bN.offset(i, j);
    paramCanvas.drawArc(this.bN, 0.0F, 90.0F, false, this.Q);
    this.bN.left = (this.mWidth - (k + m));
    this.bN.top = k;
    this.bN.right = (this.mWidth - k);
    this.bN.bottom = (k + m);
    this.bN.offset(i, j);
    paramCanvas.drawArc(this.bN, 270.0F, 90.0F, false, this.Q);
  }
  
  protected void init()
  {
    setLayerType(1, null);
    this.Q = new Paint();
    this.Q.setAntiAlias(true);
    this.Q.setStyle(Paint.Style.STROKE);
    this.Q.setStrokeWidth(this.mStrokeWidth);
    this.Q.setColor(this.shadowColor);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    if (this.mWidth <= 0) {
      return;
    }
    cb(paramCanvas);
  }
  
  public void setShadowColor(int paramInt)
  {
    this.shadowColor = (0xFFFFFF & paramInt | this.eJm);
    invalidate();
  }
  
  public void setShadowColorAlpha(int paramInt)
  {
    this.eJm = paramInt;
    setShadowColor(this.shadowColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureShadow
 * JD-Core Version:    0.7.0.1
 */