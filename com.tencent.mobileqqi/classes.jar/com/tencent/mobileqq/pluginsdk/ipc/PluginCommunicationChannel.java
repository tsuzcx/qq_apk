package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface PluginCommunicationChannel
  extends IInterface
{
  public abstract String getNickName()
    throws RemoteException;
  
  public abstract String getSKey()
    throws RemoteException;
  
  public abstract String getSid()
    throws RemoteException;
  
  public abstract long getUin()
    throws RemoteException;
  
  public abstract Bundle transfer(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void transferAsync(String paramString, Bundle paramBundle, RemotesCallback paramRemotesCallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements PluginCommunicationChannel
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
    static final int TRANSACTION_getNickName = 2;
    static final int TRANSACTION_getSKey = 3;
    static final int TRANSACTION_getSid = 4;
    static final int TRANSACTION_getUin = 1;
    static final int TRANSACTION_transfer = 5;
    static final int TRANSACTION_transferAsync = 6;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
    }
    
    public static PluginCommunicationChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      if ((localIInterface != null) && ((localIInterface instanceof PluginCommunicationChannel))) {
        return (PluginCommunicationChannel)localIInterface;
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
        paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        long l = getUin();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getNickName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSKey();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSid();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramParcel1 = transfer((String)localObject, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (Object localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        transferAsync(str, (Bundle)localObject, RemotesCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class Proxy
      implements PluginCommunicationChannel
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
        return "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
      }
      
      public String getNickName()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      
      public String getSKey()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
      
      public String getSid()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
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
      
      public long getUin()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public Bundle transfer(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(5, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void transferAsync(String paramString, Bundle paramBundle, RemotesCallback paramRemotesCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramRemotesCallback != null)
              {
                paramString = paramRemotesCallback.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.mRemote.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */