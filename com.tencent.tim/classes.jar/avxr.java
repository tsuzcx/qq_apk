import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface avxr
  extends IInterface
{
  public abstract void a(String paramString, float paramFloat, long paramLong)
    throws RemoteException;
  
  public abstract void onInstallBegin(String paramString)
    throws RemoteException;
  
  public abstract void onInstallError(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void onInstallFinish(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements avxr
  {
    public a()
    {
      attachInterface(this, "cooperation.qzone.plugin.OnQZonePluginInstallListner");
    }
    
    public static avxr a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      if ((localIInterface != null) && ((localIInterface instanceof avxr))) {
        return (avxr)localIInterface;
      }
      return new avxr.a.a(paramIBinder);
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
        paramParcel2.writeString("cooperation.qzone.plugin.OnQZonePluginInstallListner");
        return true;
      case 1: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
        onInstallBegin(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
        a(paramParcel1.readString(), paramParcel1.readFloat(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
        onInstallFinish(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      onInstallError(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements avxr
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(String paramString, float paramFloat, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
          localParcel1.writeString(paramString);
          localParcel1.writeFloat(paramFloat);
          localParcel1.writeLong(paramLong);
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void onInstallBegin(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onInstallError(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
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
      
      public void onInstallFinish(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
          localParcel1.writeString(paramString);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxr
 * JD-Core Version:    0.7.0.1
 */