package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface TPDownloadProxyFactoryAidl
  extends IInterface
{
  public abstract String getNativeVersion()
    throws RemoteException;
  
  public abstract ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
    throws RemoteException;
  
  public abstract boolean isReadyForDownload()
    throws RemoteException;
  
  public abstract boolean isReadyForPlay()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements TPDownloadProxyFactoryAidl
  {
    private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl";
    static final int TRANSACTION_getNativeVersion = 4;
    static final int TRANSACTION_getTPDownloadProxy = 1;
    static final int TRANSACTION_isReadyForDownload = 3;
    static final int TRANSACTION_isReadyForPlay = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
    }
    
    public static TPDownloadProxyFactoryAidl asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
      if ((localIInterface != null) && ((localIInterface instanceof TPDownloadProxyFactoryAidl))) {
        return (TPDownloadProxyFactoryAidl)localIInterface;
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
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
        paramParcel1 = getTPDownloadProxy(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
        bool = isReadyForPlay();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
        bool = isReadyForDownload();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
      paramParcel1 = getNativeVersion();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    
    static class Proxy
      implements TPDownloadProxyFactoryAidl
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
        return "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl";
      }
      
      public String getNativeVersion()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ITPDownloadProxyAidl localITPDownloadProxyAidl = ITPDownloadProxyAidl.Stub.asInterface(localParcel2.readStrongBinder());
          return localITPDownloadProxyAidl;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isReadyForDownload()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isReadyForPlay()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
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
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
 * JD-Core Version:    0.7.0.1
 */