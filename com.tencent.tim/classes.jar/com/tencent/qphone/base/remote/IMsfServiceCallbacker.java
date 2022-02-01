package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IMsfServiceCallbacker
  extends IInterface
{
  public abstract void onFirstPkgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void onNextPkgResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onReceiveFirstPkgPushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public abstract void onReceiveNextPkgPushResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void onReceivePushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public abstract void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IMsfServiceCallbacker
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
    static final int TRANSACTION_onFirstPkgResp = 2;
    static final int TRANSACTION_onNextPkgResp = 3;
    static final int TRANSACTION_onReceiveFirstPkgPushResp = 5;
    static final int TRANSACTION_onReceiveNextPkgPushResp = 6;
    static final int TRANSACTION_onReceivePushResp = 4;
    static final int TRANSACTION_onResponse = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IMsfServiceCallbacker");
    }
    
    public static IMsfServiceCallbacker asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      if ((localIInterface != null) && ((localIInterface instanceof IMsfServiceCallbacker))) {
        return (IMsfServiceCallbacker)localIInterface;
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
      FromServiceMsg localFromServiceMsg = null;
      Object localObject;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label156;
          }
        }
        for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onResponse((ToServiceMsg)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        if (paramParcel1.readInt() != 0) {}
        for (localObject = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);; localObject = null)
        {
          if (paramParcel1.readInt() != 0) {
            localFromServiceMsg = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);
          }
          onFirstPkgResp((ToServiceMsg)localObject, localFromServiceMsg, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        onNextPkgResp(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onReceivePushResp(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        label156:
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
        if (paramParcel1.readInt() != 0) {}
        for (localObject = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; localObject = null)
        {
          onReceiveFirstPkgPushResp((FromServiceMsg)localObject, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      onReceiveNextPkgPushResp(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements IMsfServiceCallbacker
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
        return "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
      }
      
      public void onFirstPkgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
            if (paramToServiceMsg != null)
            {
              localParcel1.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel1, 0);
              if (paramFromServiceMsg != null)
              {
                localParcel1.writeInt(1);
                paramFromServiceMsg.writeToParcel(localParcel1, 0);
                localParcel1.writeInt(paramInt1);
                localParcel1.writeInt(paramInt2);
                localParcel1.writeInt(paramInt3);
                this.mRemote.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void onNextPkgResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
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
      
      /* Error */
      public void onReceiveFirstPkgPushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +67 -> 85
        //   21: aload 5
        //   23: iconst_1
        //   24: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 5
        //   30: iconst_0
        //   31: invokevirtual 53	com/tencent/qphone/base/remote/FromServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 5
        //   36: iload_2
        //   37: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   40: aload 5
        //   42: iload_3
        //   43: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   46: aload 5
        //   48: iload 4
        //   50: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   53: aload_0
        //   54: getfield 19	com/tencent/qphone/base/remote/IMsfServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   57: iconst_5
        //   58: aload 5
        //   60: aload 6
        //   62: iconst_0
        //   63: invokeinterface 59 5 0
        //   68: pop
        //   69: aload 6
        //   71: invokevirtual 62	android/os/Parcel:readException	()V
        //   74: aload 6
        //   76: invokevirtual 65	android/os/Parcel:recycle	()V
        //   79: aload 5
        //   81: invokevirtual 65	android/os/Parcel:recycle	()V
        //   84: return
        //   85: aload 5
        //   87: iconst_0
        //   88: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   91: goto -57 -> 34
        //   94: astore_1
        //   95: aload 6
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 65	android/os/Parcel:recycle	()V
        //   105: aload_1
        //   106: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	107	0	this	Proxy
        //   0	107	1	paramFromServiceMsg	FromServiceMsg
        //   0	107	2	paramInt1	int
        //   0	107	3	paramInt2	int
        //   0	107	4	paramInt3	int
        //   3	98	5	localParcel1	Parcel
        //   8	88	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	94	finally
        //   21	34	94	finally
        //   34	74	94	finally
        //   85	91	94	finally
      }
      
      public void onReceiveNextPkgPushResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void onReceivePushResp(FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 53	com/tencent/qphone/base/remote/FromServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 19	com/tencent/qphone/base/remote/IMsfServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   33: iconst_4
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 59 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 62	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 65	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 65	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 65	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 65	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramFromServiceMsg	FromServiceMsg
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
            if (paramToServiceMsg != null)
            {
              localParcel1.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel1, 0);
              if (paramFromServiceMsg != null)
              {
                localParcel1.writeInt(1);
                paramFromServiceMsg.writeToParcel(localParcel1, 0);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker
 * JD-Core Version:    0.7.0.1
 */