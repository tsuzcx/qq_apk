package com.tencent.qqmail.utilities.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPushService
  extends IInterface
{
  public static abstract class Stub
    extends Binder
    implements IPushService
  {
    private static final String DESCRIPTOR = "com.tencent.qqmail.utilities.aidl.IPushService";
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qqmail.utilities.aidl.IPushService");
    }
    
    public static IPushService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmail.utilities.aidl.IPushService");
      if ((localIInterface != null) && ((localIInterface instanceof IPushService))) {
        return (IPushService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.tencent.qqmail.utilities.aidl.IPushService");
      return true;
    }
    
    static class Proxy
      implements IPushService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.qqmail.utilities.aidl.IPushService";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.aidl.IPushService
 * JD-Core Version:    0.7.0.1
 */