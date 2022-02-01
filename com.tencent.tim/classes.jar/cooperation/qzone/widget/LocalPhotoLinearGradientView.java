package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LocalPhotoLinearGradientView
  extends View
{
  private Paint mPaint = new Paint();
  private float mRadius;
  private RectF mRect = new RectF();
  private Shader mShader = new LinearGradient(0.0F, 0.0F, 0.0F, 0.0F, 0, 0, Shader.TileMode.CLAMP);
  
  public LocalPhotoLinearGradientView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LocalPhotoLinearGradientView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setShader(this.mShader);
    paramCanvas.drawRoundRect(this.mRect, this.mRadius, this.mRadius, this.mPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRect = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
    requestLayout();
  }
  
  public void setShader(@NonNull Shader paramShader)
  {
    this.mShader = paramShader;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.LocalPhotoLinearGradientView
 * JD-Core Version:    0.7.0.1
 */