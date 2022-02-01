package com.tencent.qqmail.utilities.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket;

public abstract interface INotifyService
  extends IInterface
{
  public abstract int receivePushMail(ReceivePacket paramReceivePacket)
    throws RemoteException;
  
  public abstract void stopService()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements INotifyService
  {
    private static final String DESCRIPTOR = "com.tencent.qqmail.utilities.aidl.INotifyService";
    static final int TRANSACTION_receivePushMail = 1;
    static final int TRANSACTION_stopService = 2;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qqmail.utilities.aidl.INotifyService");
    }
    
    public static INotifyService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmail.utilities.aidl.INotifyService");
      if ((localIInterface != null) && ((localIInterface instanceof INotifyService))) {
        return (INotifyService)localIInterface;
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
        paramParcel2.writeString("com.tencent.qqmail.utilities.aidl.INotifyService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.qqmail.utilities.aidl.INotifyService");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (ReceivePacket)ReceivePacket.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          paramInt1 = receivePushMail(paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.qqmail.utilities.aidl.INotifyService");
      stopService();
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements INotifyService
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
        return "com.tencent.qqmail.utilities.aidl.INotifyService";
      }
      
      /* Error */
      public int receivePushMail(ReceivePacket paramReceivePacket)
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
        //   21: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 50	com/tencent/qqmail/utilities/qmnetwork/service/ReceivePacket:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 19	com/tencent/qqmail/utilities/aidl/INotifyService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_3
        //   36: aload 4
        //   38: iconst_0
        //   39: invokeinterface 56 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 59	android/os/Parcel:readException	()V
        //   50: aload 4
        //   52: invokevirtual 63	android/os/Parcel:readInt	()I
        //   55: istore_2
        //   56: aload 4
        //   58: invokevirtual 66	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 66	android/os/Parcel:recycle	()V
        //   65: iload_2
        //   66: ireturn
        //   67: aload_3
        //   68: iconst_0
        //   69: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   72: goto -42 -> 30
        //   75: astore_1
        //   76: aload 4
        //   78: invokevirtual 66	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 66	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	Proxy
        //   0	87	1	paramReceivePacket	ReceivePacket
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
      
      public void stopService()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.qqmail.utilities.aidl.INotifyService");
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.aidl.INotifyService
 * JD-Core Version:    0.7.0.1
 */