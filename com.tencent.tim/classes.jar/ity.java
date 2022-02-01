import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.av.service.AVPbInfo;

public abstract interface ity
  extends IInterface
{
  public abstract void D(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void F(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void G(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract AVPbInfo a(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void a(itx paramitx)
    throws RemoteException;
  
  public abstract void aqG()
    throws RemoteException;
  
  public abstract void aqH()
    throws RemoteException;
  
  public abstract void aqI()
    throws RemoteException;
  
  public abstract void b(boolean paramBoolean, Notification paramNotification)
    throws RemoteException;
  
  public abstract void cB(long paramLong)
    throws RemoteException;
  
  public abstract int d(long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract void g(String paramString, Bitmap paramBitmap)
    throws RemoteException;
  
  public abstract void jB(String paramString)
    throws RemoteException;
  
  public abstract void r(long paramLong, String paramString)
    throws RemoteException;
  
  public abstract void setSoundEnable(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ity
  {
    public a()
    {
      attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
    }
    
    public static ity a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
      if ((localIInterface != null) && ((localIInterface instanceof ity))) {
        return (ity)localIInterface;
      }
      return new ity.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a(itx.a.a(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        D(paramParcel1.createByteArray());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        F(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        G(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label292;
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
      case 6: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        paramParcel2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          g(paramParcel2, paramParcel1);
          return true;
        }
      case 7: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        paramInt1 = d(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        jB(paramParcel1.readString());
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        paramParcel1 = a(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        r(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        cB(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        aqG();
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        aqH();
        paramParcel2.writeNoException();
        return true;
      case 14: 
        label292:
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        setSoundEnable(bool);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      aqI();
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements ity
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
          localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void F(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
      
      public void G(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel1.writeByteArray(paramArrayOfByte);
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
      
      /* Error */
      public AVPbInfo a(byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 38	android/os/Parcel:writeByteArray	([B)V
        //   19: aload_0
        //   20: getfield 18	ity$a$a:mRemote	Landroid/os/IBinder;
        //   23: bipush 9
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 44 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 52	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 58	android/os/Parcel:readInt	()I
        //   42: ifeq +26 -> 68
        //   45: getstatic 64	com/tencent/av/service/AVPbInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 70 2 0
        //   54: checkcast 60	com/tencent/av/service/AVPbInfo
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:recycle	()V
        //   62: aload_2
        //   63: invokevirtual 47	android/os/Parcel:recycle	()V
        //   66: aload_1
        //   67: areturn
        //   68: aconst_null
        //   69: astore_1
        //   70: goto -12 -> 58
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 47	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 47	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramArrayOfByte	byte[]
        //   3	76	2	localParcel1	Parcel
        //   7	68	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	58	73	finally
      }
      
      public void a(itx paramitx)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
      
      public void aqG()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void aqH()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void aqI()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
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
        //   26: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: ifnull +53 -> 83
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   39: aload_2
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 95	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	ity$a$a:mRemote	Landroid/os/IBinder;
        //   50: iconst_5
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 44 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 52	android/os/Parcel:readException	()V
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
        //   86: invokevirtual 89	android/os/Parcel:writeInt	(I)V
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
      
      public void cB(long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int d(long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public void g(String paramString, Bitmap paramBitmap)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 31
        //   7: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_3
        //   11: aload_1
        //   12: invokevirtual 107	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   15: aload_2
        //   16: ifnull +34 -> 50
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 110	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	ity$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 6
        //   36: aload_3
        //   37: aconst_null
        //   38: iconst_1
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:recycle	()V
        //   49: return
        //   50: aload_3
        //   51: iconst_0
        //   52: invokevirtual 89	android/os/Parcel:writeInt	(I)V
        //   55: goto -25 -> 30
        //   58: astore_1
        //   59: aload_3
        //   60: invokevirtual 47	android/os/Parcel:recycle	()V
        //   63: aload_1
        //   64: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	65	0	this	a
        //   0	65	1	paramString	String
        //   0	65	2	paramBitmap	Bitmap
        //   3	57	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	15	58	finally
        //   19	30	58	finally
        //   30	45	58	finally
        //   50	55	58	finally
      }
      
      public void jB(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel.writeString(paramString);
          this.mRemote.transact(8, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void r(long paramLong, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setSoundEnable(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ity
 * JD-Core Version:    0.7.0.1
 */