import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface mew
  extends IInterface
{
  public abstract mez a()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements mew
  {
    public a()
    {
      attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
    }
    
    public static mew a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
      if ((localIInterface != null) && ((localIInterface instanceof mew))) {
        return (mew)localIInterface;
      }
      return new mew.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    static class a
      implements mew
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public mez a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.IRIJAidlInterface");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          mez localmez = mez.a.a(localParcel2.readStrongBinder());
          return localmez;
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mew
 * JD-Core Version:    0.7.0.1
 */