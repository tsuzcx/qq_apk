package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

public abstract interface BusResponseCallback
{
  public abstract BusResponseResult innerError(Activity paramActivity, int paramInt, String paramString);
  
  public abstract BusResponseResult succeedReturn(Activity paramActivity, int paramInt, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.activity.internal.BusResponseCallback
 * JD-Core Version:    0.7.0.1
 */