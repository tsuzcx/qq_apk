import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface itx
  extends IInterface
{
  public abstract void B(int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements itx
  {
    public static itx a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceCallback");
      if ((localIInterface != null) && ((localIInterface instanceof itx))) {
        return (itx)localIInterface;
      }
      return new itx.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IAVServiceCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceCallback");
      B(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      return true;
    }
    
    static class a
      implements itx
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void B(int paramInt1, int paramInt2, int paramInt3)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceCallback");
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          localParcel.writeInt(paramInt3);
          this.mRemote.transact(1, localParcel, null, 1);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itx
 * JD-Core Version:    0.7.0.1
 */