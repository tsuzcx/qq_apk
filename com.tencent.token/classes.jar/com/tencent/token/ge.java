package com.tencent.token;

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
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public final class ge
  extends ImageView
{
  public Animation.AnimationListener a;
  int b;
  
  public ge(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    this.b = ((int)(3.5F * f));
    if (a())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      fo.a(this, f * 4.0F);
    }
    else
    {
      paramContext = new ShapeDrawable(new a(this.b));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.b, j, i, 503316480);
      i = this.b;
      setPadding(i, i, i, i);
    }
    paramContext.getPaint().setColor(-328966);
    fo.a(this, paramContext);
  }
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = this.a;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a()) {
      setMeasuredDimension(getMeasuredWidth() + this.b * 2, getMeasuredHeight() + this.b * 2);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  final class a
    extends OvalShape
  {
    private RadialGradient b;
    private Paint c = new Paint();
    
    a(int paramInt)
    {
      ge.this.b = paramInt;
      a((int)rect().width());
    }
    
    private void a(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = ge.this.b;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, localTileMode);
      this.c.setShader(this.b);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int j = ge.this.getWidth();
      int i = ge.this.getHeight();
      j /= 2;
      float f1 = j;
      float f2 = i / 2;
      paramCanvas.drawCircle(f1, f2, f1, this.c);
      paramCanvas.drawCircle(f1, f2, j - ge.this.b, paramPaint);
    }
    
    protected final void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      a((int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ge
 * JD-Core Version:    0.7.0.1
 */