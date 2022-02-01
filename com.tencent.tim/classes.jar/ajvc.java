import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public abstract interface ajvc
  extends IInterface
{
  public abstract BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
    throws RemoteException;
  
  public abstract void a(ajvi paramajvi)
    throws RemoteException;
  
  public abstract Message c(Message paramMessage)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ajvc
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
    }
    
    public static ajvc a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
      if ((localIInterface != null) && ((localIInterface instanceof ajvc))) {
        return (ajvc)localIInterface;
      }
      return new ajvc.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = a((BasicTypeDataParcel)localObject1);
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
        paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Message)Message.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = c((Message)localObject1);
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
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
      a(ajvi.a.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements ajvc
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
            if (paramBasicTypeDataParcel != null)
            {
              localParcel1.writeInt(1);
              paramBasicTypeDataParcel.writeToParcel(localParcel1, 0);
              this.mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBasicTypeDataParcel = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(localParcel2);
                return paramBasicTypeDataParcel;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBasicTypeDataParcel = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(ajvi paramajvi)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 78 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 81	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	ajvc$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_3
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 70	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 70	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 70	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 70	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramajvi	ajvi
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public Message c(Message paramMessage)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
            if (paramMessage != null)
            {
              localParcel1.writeInt(1);
              paramMessage.writeToParcel(localParcel1, 0);
              this.mRemote.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramMessage = (Message)Message.CREATOR.createFromParcel(localParcel2);
                return paramMessage;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramMessage = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvc
 * JD-Core Version:    0.7.0.1
 */