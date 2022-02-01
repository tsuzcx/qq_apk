package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public final class DrawableSplashScreen
  implements SplashScreen
{
  private final long crossfadeDurationInMillis;
  private final Drawable drawable;
  private final ImageView.ScaleType scaleType;
  private DrawableSplashScreenView splashView;
  
  public DrawableSplashScreen(@NonNull Drawable paramDrawable)
  {
    this(paramDrawable, ImageView.ScaleType.FIT_XY, 500L);
  }
  
  public DrawableSplashScreen(@NonNull Drawable paramDrawable, @NonNull ImageView.ScaleType paramScaleType, long paramLong)
  {
    this.drawable = paramDrawable;
    this.scaleType = paramScaleType;
    this.crossfadeDurationInMillis = paramLong;
  }
  
  @Nullable
  public View createSplashView(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    this.splashView = new DrawableSplashScreenView(paramContext);
    this.splashView.setSplashDrawable(this.drawable, this.scaleType);
    return this.splashView;
  }
  
  public void transitionToFlutter(@NonNull Runnable paramRunnable)
  {
    if (this.splashView == null)
    {
      paramRunnable.run();
      return;
    }
    this.splashView.animate().alpha(0.0F).setDuration(this.crossfadeDurationInMillis).setListener(new DrawableSplashScreen.1(this, paramRunnable));
  }
  
  public static class DrawableSplashScreenView
    extends ImageView
  {
    public DrawableSplashScreenView(@NonNull Context paramContext)
    {
      this(paramContext, null, 0);
    }
    
    public DrawableSplashScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    public DrawableSplashScreenView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void setSplashDrawable(@Nullable Drawable paramDrawable)
    {
      setSplashDrawable(paramDrawable, ImageView.ScaleType.FIT_XY);
    }
    
    public void setSplashDrawable(@Nullable Drawable paramDrawable, @NonNull ImageView.ScaleType paramScaleType)
    {
      setScaleType(paramScaleType);
      setImageDrawable(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen
 * JD-Core Version:    0.7.0.1
 */