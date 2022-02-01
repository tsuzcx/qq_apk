package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResolvingResultCallbacks<R extends Result>
  extends ResultCallbacks<R>
{
  private final Activity a;
  private final int b;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    this.a = ((Activity)Preconditions.checkNotNull(paramActivity, "Activity must not be null"));
    this.b = paramInt;
  }
  
  public final void onFailure(Status paramStatus)
  {
    try
    {
      if (paramStatus.hasResolution())
      {
        paramStatus.startResolutionForResult(this.a, this.b);
        return;
      }
      onUnresolvableFailure(paramStatus);
      return;
    }
    catch (Exception paramStatus)
    {
      HMSLog.e("ResolvingResultCallbacks", "Failed to start resolution: " + paramStatus);
      onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
    }
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.ResolvingResultCallbacks
 * JD-Core Version:    0.7.0.1
 */