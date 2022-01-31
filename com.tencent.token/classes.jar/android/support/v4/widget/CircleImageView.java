package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
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
    for (;;)
    {
      paramContext.getPaint().setColor(paramInt);
      ViewCompat.setBackground(this, paramContext);
      return;
      paramContext = new ShapeDrawable(new CircleImageView.OvalShadow(this, this.mShadowRadius));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.mShadowRadius, j, i, 503316480);
      i = this.mShadowRadius;
      setPadding(i, i, i, i);
    }
  }
  
  private boolean elevationSupported()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.mListener != null) {
      this.mListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.mListener != null) {
      this.mListener.onAnimationStart(getAnimation());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */