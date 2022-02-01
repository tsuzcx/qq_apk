import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface iob
  extends IInterface
{
  public abstract void D(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void a(itx paramitx)
    throws RemoteException;
  
  public abstract void aoF()
    throws RemoteException;
  
  public abstract void b(boolean paramBoolean, Notification paramNotification)
    throws RemoteException;
  
  public abstract int d(long paramLong, int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements iob
  {
    public static iob a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      if ((localIInterface != null) && ((localIInterface instanceof iob))) {
        return (iob)localIInterface;
      }
      return new iob.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.gvideo.IGVServiceForQQ");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
        a(itx.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
        D(paramParcel1.createByteArray());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
        boolean bool;
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label168;
          }
        }
        for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b(bool, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          bool = false;
          break;
        }
      case 4: 
        label168:
        paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
        paramInt1 = d(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      aoF();
      return true;
    }
    
    static class a
      implements iob
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void D(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
          localParcel.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(itx paramitx)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
          if (paramitx != null) {
            localIBinder = paramitx.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void aoF()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public void b(boolean paramBoolean, Notification paramNotification)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 31
        //   16: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: iload_1
        //   20: ifeq +58 -> 78
        //   23: aload 4
        //   25: iload_3
        //   26: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: ifnull +53 -> 83
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   39: aload_2
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 71	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	iob$a$a:mRemote	Landroid/os/IBinder;
        //   50: iconst_3
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 44 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 74	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 47	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 47	android/os/Parcel:recycle	()V
        //   77: return
        //   78: iconst_0
        //   79: istore_3
        //   80: goto -57 -> 23
        //   83: aload 4
        //   85: iconst_0
        //   86: invokevirtual 65	android/os/Parcel:writeInt	(I)V
        //   89: goto -43 -> 46
        //   92: astore_2
        //   93: aload 5
        //   95: invokevirtual 47	android/os/Parcel:recycle	()V
        //   98: aload 4
        //   100: invokevirtual 47	android/os/Parcel:recycle	()V
        //   103: aload_2
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramBoolean	boolean
        //   0	105	2	paramNotification	Notification
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
      
      public int d(long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iob
 * JD-Core Version:    0.7.0.1
 */