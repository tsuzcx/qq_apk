package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface MiniCmdCallback
  extends IInterface
{
  public abstract void onCmdResult(boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements MiniCmdCallback
  {
    private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback";
    static final int TRANSACTION_onCmdResult = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback");
    }
    
    public static MiniCmdCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback");
      if ((localIInterface != null) && ((localIInterface instanceof MiniCmdCallback))) {
        return (MiniCmdCallback)localIInterface;
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
        paramParcel2.writeString("com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label101;
        }
      }
      label101:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onCmdResult(bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    }
    
    static class Proxy
      implements MiniCmdCallback
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
        return "com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback";
      }
      
      /* Error */
      public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 26
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: iload_1
        //   20: ifeq +58 -> 78
        //   23: aload 4
        //   25: iload_3
        //   26: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: ifnull +53 -> 83
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   39: aload_2
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 50	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 19	com/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 56 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 59	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 62	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 62	android/os/Parcel:recycle	()V
        //   77: return
        //   78: iconst_0
        //   79: istore_3
        //   80: goto -57 -> 23
        //   83: aload 4
        //   85: iconst_0
        //   86: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   89: goto -43 -> 46
        //   92: astore_2
        //   93: aload 5
        //   95: invokevirtual 62	android/os/Parcel:recycle	()V
        //   98: aload 4
        //   100: invokevirtual 62	android/os/Parcel:recycle	()V
        //   103: aload_2
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	Proxy
        //   0	105	1	paramBoolean	boolean
        //   0	105	2	paramBundle	Bundle
        //   1	79	3	i	int
        //   5	94	4	localParcel1	Parcel
        //   10	84	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	19	92	finally
        //   23	29	92	finally
        //   33	46	92	finally
        //   46	67	92	finally
        //   83	89	92	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
 * JD-Core Version:    0.7.0.1
 */