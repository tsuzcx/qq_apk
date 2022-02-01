import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface auyf
  extends IInterface
{
  public abstract boolean aJX()
    throws RemoteException;
  
  public abstract String getOaid()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements auyf
  {
    public static auyf a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      if ((localIInterface != null) && ((localIInterface instanceof auyf))) {
        return (auyf)localIInterface;
      }
      return new auyf.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        paramParcel1 = getOaid();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      boolean bool = aJX();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    
    static class a
      implements auyf
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public boolean aJX()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
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
      
      public String getOaid()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     auyf
 * JD-Core Version:    0.7.0.1
 */