package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

public final class Status
  extends Result
  implements Parcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new Status.1();
  public static final Status CoreException;
  public static final Status FAILURE;
  public static final Status MessageNotFound;
  @Deprecated
  public static final Status RESULT_CANCELED;
  @Deprecated
  public static final Status RESULT_DEAD_CLIENT;
  @Deprecated
  public static final Status RESULT_INTERNAL_ERROR;
  @Deprecated
  public static final Status RESULT_INTERRUPTED;
  @Deprecated
  public static final Status RESULT_TIMEOUT;
  public static final Status SUCCESS = new Status(0);
  @Packed
  private final PendingIntent pendingIntent;
  @Packed
  private int statusCode;
  @Packed
  private String statusMessage;
  
  static
  {
    FAILURE = new Status(1);
    RESULT_CANCELED = new Status(16);
    RESULT_DEAD_CLIENT = new Status(18);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_TIMEOUT = new Status(15);
    MessageNotFound = new Status(404);
    CoreException = new Status(500);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  public Status(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
    this.pendingIntent = paramPendingIntent;
  }
  
  private static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof Status))) {
        break;
      }
      paramObject = (Status)paramObject;
    } while ((this.statusCode == paramObject.statusCode) && (equal(this.statusMessage, paramObject.statusMessage)) && (equal(this.pendingIntent, paramObject.pendingIntent)));
    return false;
    return false;
  }
  
  public String getErrorString()
  {
    return getStatusMessage();
  }
  
  public PendingIntent getResolution()
  {
    return this.pendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getStatusMessage()
  {
    return this.statusMessage;
  }
  
  public boolean hasResolution()
  {
    return this.pendingIntent != null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent });
  }
  
  public boolean isCanceled()
  {
    return false;
  }
  
  public boolean isInterrupted()
  {
    return false;
  }
  
  public boolean isSuccess()
  {
    return this.statusCode <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (hasResolution()) {
      paramActivity.startIntentSenderForResult(this.pendingIntent.getIntentSender(), paramInt, (Intent)null, 0, 0, 0);
    }
  }
  
  public String toString()
  {
    return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + this.pendingIntent + ", }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.statusCode);
    paramParcel.writeString(this.statusMessage);
    if (this.pendingIntent != null) {
      this.pendingIntent.writeToParcel(paramParcel, paramInt);
    }
    PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.Status
 * JD-Core Version:    0.7.0.1
 */