package android.support.v4.app;

import android.app.ActivityOptions;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class ActivityOptionsCompat$ActivityOptionsCompatApi24Impl
  extends ActivityOptionsCompat.ActivityOptionsCompatApi23Impl
{
  ActivityOptionsCompat$ActivityOptionsCompatApi24Impl(ActivityOptions paramActivityOptions)
  {
    super(paramActivityOptions);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi24Impl
 * JD-Core Version:    0.7.0.1
 */