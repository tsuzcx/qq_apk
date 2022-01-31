package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class CircleImageView$OvalShadow
  extends OvalShape
{
  private RadialGradient mRadialGradient;
  private Paint mShadowPaint = new Paint();
  
  CircleImageView$OvalShadow(CircleImageView paramCircleImageView, int paramInt)
  {
    paramCircleImageView.mShadowRadius = paramInt;
    updateRadialGradient((int)rect().width());
  }
  
  private void updateRadialGradient(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = paramInt / 2;
    float f3 = this.this$0.mShadowRadius;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.mRadialGradient = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
    this.mShadowPaint.setShader(this.mRadialGradient);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.this$0.getWidth();
    int j = this.this$0.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.mShadowPaint);
    paramCanvas.drawCircle(i / 2, j / 2, i / 2 - this.this$0.mShadowRadius, paramPaint);
  }
  
  protected void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    updateRadialGradient((int)paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircleImageView.OvalShadow
 * JD-Core Version:    0.7.0.1
 */