package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IContentObserver
  extends IInterface
{
  public abstract void onChange(boolean paramBoolean, Uri paramUri);
  
  public static abstract class Stub
    extends Binder
    implements IContentObserver
  {
    private static final String DESCRIPTOR = "com.tencent.wcdb.IContentObserver";
    static final int TRANSACTION_onChange = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.wcdb.IContentObserver");
    }
    
    public static IContentObserver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.IContentObserver");
      if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
        return (IContentObserver)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.wcdb.IContentObserver");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.wcdb.IContentObserver");
      boolean bool;
      if (paramParcel1.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramParcel1.readInt() != 0) {
        paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = null;
      }
      onChange(bool, paramParcel1);
      return true;
    }
    
    private static class Proxy
      implements IContentObserver
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
        return "com.tencent.wcdb.IContentObserver";
      }
      
      public void onChange(boolean paramBoolean, Uri paramUri)
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.tencent.wcdb.IContentObserver");
            if (paramBoolean)
            {
              i = 1;
              localParcel.writeInt(i);
              if (paramUri != null)
              {
                localParcel.writeInt(1);
                paramUri.writeToParcel(localParcel, 0);
              }
              else
              {
                localParcel.writeInt(0);
              }
              this.mRemote.transact(1, localParcel, null, 1);
              return;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver
 * JD-Core Version:    0.7.0.1
 */