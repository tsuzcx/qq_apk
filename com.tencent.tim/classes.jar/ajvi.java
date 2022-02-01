import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public abstract interface ajvi
  extends IInterface
{
  public abstract BasicTypeDataParcel b(BasicTypeDataParcel paramBasicTypeDataParcel)
    throws RemoteException;
  
  public abstract Message d(Message paramMessage)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ajvi
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
    }
    
    public static ajvi a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
      if ((localIInterface != null) && ((localIInterface instanceof ajvi))) {
        return (ajvi)localIInterface;
      }
      return new ajvi.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = b((BasicTypeDataParcel)localObject1);
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
      paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Message)Message.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = d((Message)localObject1);
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
    
    static class a
      implements ajvi
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public BasicTypeDataParcel b(BasicTypeDataParcel paramBasicTypeDataParcel)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
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
      
      public Message d(Message paramMessage)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
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
 * Qualified Name:     ajvi
 * JD-Core Version:    0.7.0.1
 */