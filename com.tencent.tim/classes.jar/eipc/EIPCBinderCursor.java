package eipc;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class EIPCBinderCursor
  extends MatrixCursor
{
  public static final String KEY_BINDER = "EIPCBinderCursor";
  Bundle mBinderExtra = new Bundle();
  
  public EIPCBinderCursor(String[] paramArrayOfString, IBinder paramIBinder)
  {
    super(paramArrayOfString);
    if (paramIBinder != null)
    {
      paramArrayOfString = new BinderParcelable(paramIBinder);
      this.mBinderExtra.putParcelable("EIPCBinderCursor", paramArrayOfString);
    }
  }
  
  public Bundle getExtras()
  {
    return this.mBinderExtra;
  }
  
  public static class BinderParcelable
    implements Parcelable
  {
    public static final Parcelable.Creator<BinderParcelable> CREATOR = new EIPCBinderCursor.BinderParcelable.1();
    public IBinder mBinder;
    
    BinderParcelable(IBinder paramIBinder)
    {
      this.mBinder = paramIBinder;
    }
    
    BinderParcelable(Parcel paramParcel)
    {
      this.mBinder = paramParcel.readStrongBinder();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeStrongBinder(this.mBinder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPCBinderCursor
 * JD-Core Version:    0.7.0.1
 */