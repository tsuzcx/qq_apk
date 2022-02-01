import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract interface alvq
  extends IInterface
{
  public abstract void K(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle b(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void e(CompressInfo paramCompressInfo)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements alvq
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.richmedia.ICallBack");
    }
    
    public static alvq a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.richmedia.ICallBack");
      if ((localIInterface != null) && ((localIInterface instanceof alvq))) {
        return (alvq)localIInterface;
      }
      return new alvq.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.richmedia.ICallBack");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = b(paramInt1, (Bundle)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CompressInfo)CompressInfo.CREATOR.createFromParcel(paramParcel1);
        }
        e((CompressInfo)localObject1);
        paramParcel2.writeNoException();
        if (localObject1 != null)
        {
          paramParcel2.writeInt(1);
          ((CompressInfo)localObject1).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
      paramInt1 = paramParcel1.readInt();
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      K(paramInt1, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements alvq
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public void K(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +44 -> 65
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 45	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	alvq$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_3
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 51 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 54	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 57	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 57	android/os/Parcel:recycle	()V
        //   64: return
        //   65: aload_3
        //   66: iconst_0
        //   67: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   70: goto -35 -> 35
        //   73: astore_2
        //   74: aload 4
        //   76: invokevirtual 57	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: invokevirtual 57	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	a
        //   0	85	1	paramInt	int
        //   0	85	2	paramBundle	Bundle
        //   3	77	3	localParcel1	Parcel
        //   7	68	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	73	finally
        //   24	35	73	finally
        //   35	55	73	finally
        //   65	70	73	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public Bundle b(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.richmedia.ICallBack");
            localParcel1.writeInt(paramInt);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void e(CompressInfo paramCompressInfo)
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
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 81	com/tencent/mobileqq/pic/CompressInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	alvq$a$a:mRemote	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 51 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 54	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 66	android/os/Parcel:readInt	()I
        //   51: ifeq +8 -> 59
        //   54: aload_1
        //   55: aload_3
        //   56: invokevirtual 85	com/tencent/mobileqq/pic/CompressInfo:readFromParcel	(Landroid/os/Parcel;)V
        //   59: aload_3
        //   60: invokevirtual 57	android/os/Parcel:recycle	()V
        //   63: aload_2
        //   64: invokevirtual 57	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore_1
        //   77: aload_3
        //   78: invokevirtual 57	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: invokevirtual 57	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	a
        //   0	87	1	paramCompressInfo	CompressInfo
        //   3	79	2	localParcel1	Parcel
        //   7	71	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	59	76	finally
        //   68	73	76	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvq
 * JD-Core Version:    0.7.0.1
 */