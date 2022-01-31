package android.support.v4.app;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@RequiresApi(16)
class ActivityOptionsCompat$ActivityOptionsCompatApi16Impl
  extends ActivityOptionsCompat
{
  protected final ActivityOptions mActivityOptions;
  
  ActivityOptionsCompat$ActivityOptionsCompatApi16Impl(ActivityOptions paramActivityOptions)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi16Impl
 * JD-Core Version:    0.7.0.1
 */