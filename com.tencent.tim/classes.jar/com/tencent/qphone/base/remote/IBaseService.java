package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IBaseService
  extends IInterface
{
  public abstract int getMsfConnectedIPFamily()
    throws RemoteException;
  
  public abstract int getMsfConnectedNetType()
    throws RemoteException;
  
  public abstract int onKillProcess()
    throws RemoteException;
  
  public abstract int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
    throws RemoteException;
  
  public abstract FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException;
  
  public abstract int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IBaseService
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseService";
    static final int TRANSACTION_getMsfConnectedIPFamily = 4;
    static final int TRANSACTION_getMsfConnectedNetType = 3;
    static final int TRANSACTION_onKillProcess = 6;
    static final int TRANSACTION_onProcessViewableChanged = 5;
    static final int TRANSACTION_sendSyncToServiceMsg = 1;
    static final int TRANSACTION_sendToServiceMsg = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IBaseService");
    }
    
    public static IBaseService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IBaseService");
      if ((localIInterface != null) && ((localIInterface instanceof IBaseService))) {
        return (IBaseService)localIInterface;
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
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.qphone.base.remote.IBaseService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = sendSyncToServiceMsg((ToServiceMsg)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = sendToServiceMsg((ToServiceMsg)localObject1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        paramInt1 = getMsfConnectedNetType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        paramInt1 = getMsfConnectedIPFamily();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramInt1 = onProcessViewableChanged(bool, paramParcel1.readLong(), paramParcel1.readString());
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      paramInt1 = onKillProcess();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static class Proxy
      implements IBaseService
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
        return "com.tencent.qphone.base.remote.IBaseService";
      }
      
      public int getMsfConnectedIPFamily()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getMsfConnectedNetType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int onKillProcess()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
            if (paramToServiceMsg != null)
            {
              localParcel1.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel1, 0);
              this.mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramToServiceMsg = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(localParcel2);
                return paramToServiceMsg;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramToServiceMsg = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 26
        //   12: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 64	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 79	com/tencent/qphone/base/remote/ToServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 19	com/tencent/qphone/base/remote/IBaseService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 46 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 49	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 52	android/os/Parcel:readInt	()I
        //   55: istore_2
        //   56: aload 4
        //   58: invokevirtual 55	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 55	android/os/Parcel:recycle	()V
        //   65: iload_2
        //   66: ireturn
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 64	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore_1
        //   76: aload 4
        //   78: invokevirtual 55	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 55	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	Proxy
        //   0	87	1	paramToServiceMsg	ToServiceMsg
        //   55	11	2	i	int
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	75	finally
        //   19	30	75	finally
        //   30	56	75	finally
        //   67	72	75	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseService
 * JD-Core Version:    0.7.0.1
 */