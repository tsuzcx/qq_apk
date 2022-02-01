package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import com.huawei.hms.support.api.client.Status;

public class ResolvableApiException
  extends ApiException
{
  public ResolvableApiException(Status paramStatus)
  {
    super(paramStatus);
  }
  
  public PendingIntent getResolution()
  {
    return this.mStatus.getResolution();
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.ResolvableApiException
 * JD-Core Version:    0.7.0.1
 */