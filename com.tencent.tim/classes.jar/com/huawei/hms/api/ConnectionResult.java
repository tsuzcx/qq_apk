package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Objects;

public final class ConnectionResult
  implements Parcelable
{
  public static final int API_UNAVAILABLE = 1000;
  public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
  public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
  public static final int CANCELED = 13;
  public static final Parcelable.Creator<ConnectionResult> CREATOR = new ConnectionResult.1();
  public static final int DEVELOPER_ERROR = 10;
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 9000;
  public static final int RESOLUTION_REQUIRED = 9001;
  public static final int RESTRICTED_PROFILE = 9003;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_MISSING_PERMISSION = 19;
  public static final int SERVICE_UNSUPPORTED = 21;
  public static final int SERVICE_UPDATING = 9004;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_FAILED = 9005;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  private int a = 1;
  private PendingIntent b = null;
  private String c = null;
  private int d;
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    this.a = paramInt1;
    this.d = paramInt2;
    this.b = paramPendingIntent;
    this.c = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  private ConnectionResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.c = paramParcel.readString();
    paramParcel = (Parcelable)PendingIntent.CREATOR.createFromParcel(paramParcel);
    if (paramParcel != null) {
      this.b = ((PendingIntent)paramParcel);
    }
  }
  
  static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 12: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    default: 
      return "UNKNOWN_ERROR_CODE(" + paramInt + ")";
    case -1: 
      return "UNKNOWN";
    case 0: 
      return "SUCCESS";
    case 1: 
      return "SERVICE_MISSING";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 7: 
      return "NETWORK_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 9: 
      return "SERVICE_INVALID";
    case 10: 
      return "DEVELOPER_ERROR";
    case 11: 
      return "LICENSE_CHECK_FAILED";
    case 13: 
      return "CANCELED";
    case 14: 
      return "TIMEOUT";
    case 19: 
      return "SERVICE_MISSING_PERMISSION";
    }
    return "API_VERSION_UPDATE_REQUIRED";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    try
    {
      if (((paramObject instanceof ConnectionResult)) && (this.a == ((ConnectionResult)paramObject).a) && (this.d == ((ConnectionResult)paramObject).d) && (this.c.equals(((ConnectionResult)paramObject).c)))
      {
        boolean bool = this.b.equals(((ConnectionResult)paramObject).b);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public int getErrorCode()
  {
    return this.d;
  }
  
  public final String getErrorMessage()
  {
    return this.c;
  }
  
  public final PendingIntent getResolution()
  {
    return this.b;
  }
  
  public final boolean hasResolution()
  {
    return HuaweiApiAvailability.getInstance().isUserResolvableError(this.d, this.b);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.a), Long.valueOf(getErrorCode()), getErrorMessage(), this.b });
  }
  
  public final boolean isSuccess()
  {
    return this.d == 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (hasResolution()) {
      HuaweiApiAvailability.getInstance().resolveError(paramActivity, this.d, paramInt, this.b);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.c);
    this.b.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */