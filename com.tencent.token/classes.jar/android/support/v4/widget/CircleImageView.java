package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView
  extends ImageView
{
  private static final int FILL_SHADOW_COLOR = 1023410176;
  private static final int KEY_SHADOW_COLOR = 503316480;
  private static final int SHADOW_ELEVATION = 4;
  private static final float SHADOW_RADIUS = 3.5F;
  private static final float X_OFFSET = 0.0F;
  private static final float Y_OFFSET = 1.75F;
  private Animation.AnimationListener mListener;
  int mShadowRadius;
  
  CircleImageView(Context paramContext, int paramInt)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.mShadowRadius = ((int)(3.5F * f));
    if (elevationSupported())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ViewCompat.setElevation(this, f * 4.0F);
    }
    else
    {
      paramContext = new ShapeDrawable(new OvalShadow(this.mShadowRadius));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.mShadowRadius, j, i, 503316480);
      i = this.mShadowRadius;
      setPadding(i, i, i, i);
    }
    paramContext.getPaint().setColor(paramInt);
    ViewCompat.setBackground(this, paramContext);
  }
  
  private boolean elevationSupported()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = this.mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = this.mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!elevationSupported()) {
      setMeasuredDimension(getMeasuredWidth() + this.mShadowRadius * 2, getMeasuredHeight() + this.mShadowRadius * 2);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.mListener = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  public void setBackgroundColorRes(int paramInt)
  {
    setBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  private class OvalShadow
    extends OvalShape
  {
    private RadialGradient mRadialGradient;
    private Paint mShadowPaint = new Paint();
    
    OvalShadow(int paramInt)
    {
      CircleImageView.this.mShadowRadius = paramInt;
      updateRadialGradient((int)rect().width());
    }
    
    private void updateRadialGradient(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = CircleImageView.this.mShadowRadius;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.mRadialGradient = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, localTileMode);
      this.mShadowPaint.setShader(this.mRadialGradient);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int j = CircleImageView.this.getWidth();
      int i = CircleImageView.this.getHeight();
      j /= 2;
      float f1 = j;
      float f2 = i / 2;
      paramCanvas.drawCircle(f1, f2, f1, this.mShadowPaint);
      paramCanvas.drawCircle(f1, f2, j - CircleImageView.this.mShadowRadius, paramPaint);
    }
    
    protected void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      updateRadialGradient((int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */