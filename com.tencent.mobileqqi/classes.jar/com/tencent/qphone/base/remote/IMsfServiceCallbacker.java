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
  public abstract void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public abstract void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IMsfServiceCallbacker
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
    static final int TRANSACTION_onRecvPushResp = 2;
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
          paramParcel2 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label113;
          }
        }
        label113:
        for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          onResponse(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onRecvPushResp(paramParcel1);
        return true;
      }
    }
    
    private static class Proxy
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
      
      /* Error */
      public void onRecvPushResp(FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 26
        //   7: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 50	com/tencent/qphone/base/remote/FromServiceMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 19	com/tencent/qphone/base/remote/IMsfServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 56 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 59	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 59	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	Proxy
        //   0	59	1	paramFromServiceMsg	FromServiceMsg
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
            if (paramToServiceMsg != null)
            {
              localParcel.writeInt(1);
              paramToServiceMsg.writeToParcel(localParcel, 0);
              if (paramFromServiceMsg != null)
              {
                localParcel.writeInt(1);
                paramFromServiceMsg.writeToParcel(localParcel, 0);
                this.mRemote.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker
 * JD-Core Version:    0.7.0.1
 */