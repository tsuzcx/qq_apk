package android.support.v4.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class ActivityOptionsCompat$ActivityOptionsCompatApi23Impl
  extends ActivityOptionsCompat.ActivityOptionsCompatApi16Impl
{
  ActivityOptionsCompat$ActivityOptionsCompatApi23Impl(ActivityOptions paramActivityOptions)
  {
    super(paramActivityOptions);
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent)
  {
    this.mActivityOptions.requestUsageTimeReport(paramPendingIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat.ActivityOptionsCompatApi23Impl
 * JD-Core Version:    0.7.0.1
 */