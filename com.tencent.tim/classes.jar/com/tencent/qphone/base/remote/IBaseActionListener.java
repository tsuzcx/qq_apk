package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IBaseActionListener
  extends IInterface
{
  public abstract void onActionResult(FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public abstract void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IBaseActionListener
  {
    private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseActionListener";
    static final int TRANSACTION_onActionResult = 2;
    static final int TRANSACTION_onRecvFromMsg = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qphone.base.remote.IBaseActionListener");
    }
    
    public static IBaseActionListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IBaseActionListener");
      if ((localIInterface != null) && ((localIInterface instanceof IBaseActionListener))) {
        return (IBaseActionListener)localIInterface;
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
        paramParcel2.writeString("com.tencent.qphone.base.remote.IBaseActionListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseActionListener");
        paramParcel2 = localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);
        }
        onRecvFromMsg(paramParcel2);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseActionListener");
      paramParcel2 = localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);
      }
      onActionResult(paramParcel2);
      return true;
    }
    
    static class Proxy
      implements IBaseActionListener
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
        return "com.tencent.qphone.base.remote.IBaseActionListener";
      }
      
      /* Error */
      public void onActionResult(FromServiceMsg paramFromServiceMsg)
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
        //   26: getfield 19	com/tencent/qphone/base/remote/IBaseActionListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
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
      
      /* Error */
      public void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
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
        //   26: getfield 19	com/tencent/qphone/base/remote/IBaseActionListener$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   29: iconst_1
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseActionListener
 * JD-Core Version:    0.7.0.1
 */