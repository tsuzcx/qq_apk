package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

public class ActivityOptionsCompat
{
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  @RequiresApi(16)
  private static ActivityOptionsCompat createImpl(ActivityOptions paramActivityOptions)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ActivityOptionsCompatApi24Impl(paramActivityOptions);
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsCompatApi23Impl(paramActivityOptions);
    }
    return new ActivityOptionsCompatApi16Impl(paramActivityOptions);
  }
  
  @NonNull
  public static ActivityOptionsCompat makeBasic()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return createImpl(ActivityOptions.makeBasic());
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return createImpl(ActivityOptions.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return createImpl(ActivityOptions.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return createImpl(ActivityOptions.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, @NonNull View paramView, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return createImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, android.support.v4.util.Pair<View, String>... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = null;
      if (paramVarArgs != null)
      {
        android.util.Pair[] arrayOfPair = new android.util.Pair[paramVarArgs.length];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfPair;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfPair[i] = android.util.Pair.create(paramVarArgs[i].first, paramVarArgs[i].second);
          i += 1;
        }
      }
      return createImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeTaskLaunchBehind()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return createImpl(ActivityOptions.makeTaskLaunchBehind());
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View paramView, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return createImpl(ActivityOptions.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  @Nullable
  public Rect getLaunchBounds()
  {
    return null;
  }
  
  public void requestUsageTimeReport(@NonNull PendingIntent paramPendingIntent) {}
  
  @NonNull
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
  {
    return this;
  }
  
  @Nullable
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(@NonNull ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  @RequiresApi(16)
  private static class ActivityOptionsCompatApi16Impl
    extends ActivityOptionsCompat
  {
    protected final ActivityOptions mActivityOptions;
    
    ActivityOptionsCompatApi16Impl(ActivityOptions paramActivityOptions)
    {
      this.mActivityOptions = paramActivityOptions;
    }
    
    public Bundle toBundle()
    {
      return this.mActivityOptions.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsCompatApi16Impl))
      {
        paramActivityOptionsCompat = (ActivityOptionsCompatApi16Impl)paramActivityOptionsCompat;
        this.mActivityOptions.update(paramActivityOptionsCompat.mActivityOptions);
      }
    }
  }
  
  @RequiresApi(23)
  private static class ActivityOptionsCompatApi23Impl
    extends ActivityOptionsCompat.ActivityOptionsCompatApi16Impl
  {
    ActivityOptionsCompatApi23Impl(ActivityOptions paramActivityOptions)
    {
      super();
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      this.mActivityOptions.requestUsageTimeReport(paramPendingIntent);
    }
  }
  
  @RequiresApi(24)
  private static class ActivityOptionsCompatApi24Impl
    extends ActivityOptionsCompat.ActivityOptionsCompatApi23Impl
  {
    ActivityOptionsCompatApi24Impl(ActivityOptions paramActivityOptions)
    {
      super();
    }
    
    public Rect getLaunchBounds()
    {
      return this.mActivityOptions.getLaunchBounds();
    }
    
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
    {
      return new ActivityOptionsCompatApi24Impl(this.mActivityOptions.setLaunchBounds(paramRect));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * JD-Core Version:    0.7.0.1
 */