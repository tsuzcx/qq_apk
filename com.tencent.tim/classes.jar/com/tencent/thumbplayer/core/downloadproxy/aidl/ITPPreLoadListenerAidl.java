package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ITPPreLoadListenerAidl
  extends IInterface
{
  public abstract void onPcdnDownloadFailed(String paramString)
    throws RemoteException;
  
  public abstract void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    throws RemoteException;
  
  public abstract void onPrepareError(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void onPrepareOK()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITPPreLoadListenerAidl
  {
    private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl";
    static final int TRANSACTION_onPcdnDownloadFailed = 4;
    static final int TRANSACTION_onPrepareDownloadProgressUpdate = 3;
    static final int TRANSACTION_onPrepareError = 2;
    static final int TRANSACTION_onPrepareOK = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
    }
    
    public static ITPPreLoadListenerAidl asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
      if ((localIInterface != null) && ((localIInterface instanceof ITPPreLoadListenerAidl))) {
        return (ITPPreLoadListenerAidl)localIInterface;
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
      case 1598968902: 
        paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
        onPrepareOK();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
        onPrepareError(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
        onPrepareDownloadProgressUpdate(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
      onPcdnDownloadFailed(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITPPreLoadListenerAidl
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
        return "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl";
      }
      
      public void onPcdnDownloadFailed(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          localParcel1.writeString(paramString);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onPrepareError(int paramInt1, int paramInt2, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onPrepareOK()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
 * JD-Core Version:    0.7.0.1
 */