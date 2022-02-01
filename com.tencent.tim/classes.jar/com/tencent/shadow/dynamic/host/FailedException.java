package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.shadow.proguard.h;

public class FailedException
  extends Exception
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  public static final int ERROR_CODE_FILE_NOT_FOUND_EXCEPTION = 3;
  public static final int ERROR_CODE_RELOAD_LOADER_EXCEPTION = 8;
  public static final int ERROR_CODE_RELOAD_RUNTIME_EXCEPTION = 7;
  public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
  public static final int ERROR_CODE_RESET_UUID_EXCEPTION = 6;
  public static final int ERROR_CODE_RUNTIME_EXCEPTION = 2;
  public static final int ERROR_CODE_UUID_MANAGER_DEAD_EXCEPTION = 5;
  public static final int ERROR_CODE_UUID_MANAGER_NULL_EXCEPTION = 4;
  public final int errorCode;
  public final String errorMessage;
  
  public FailedException(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMessage = paramString;
  }
  
  public FailedException(Parcel paramParcel)
  {
    this.errorCode = paramParcel.readInt();
    this.errorMessage = paramParcel.readString();
  }
  
  public FailedException(RemoteException paramRemoteException)
  {
    this.errorCode = 1;
    this.errorMessage = (paramRemoteException.getClass().getSimpleName() + ":" + paramRemoteException.getMessage());
  }
  
  public FailedException(RuntimeException paramRuntimeException)
  {
    this.errorCode = 2;
    this.errorMessage = (paramRuntimeException.getClass().getSimpleName() + ":" + paramRuntimeException.getMessage());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.errorCode);
    paramParcel.writeString(this.errorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.FailedException
 * JD-Core Version:    0.7.0.1
 */