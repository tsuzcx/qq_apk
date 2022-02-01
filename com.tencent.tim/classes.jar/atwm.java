import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public abstract interface atwm
  extends IInterface
{
  public abstract void a(long paramLong1, String paramString1, String paramString2, long paramLong2);
  
  public abstract void a(String paramString, long paramLong, Bundle paramBundle);
  
  public abstract void b(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void cE(Bundle paramBundle);
  
  public abstract void q(int paramInt, Bundle paramBundle);
  
  public abstract void r(int paramInt, Bundle paramBundle);
  
  public abstract void s(int paramInt, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements atwm
  {
    public a()
    {
      attachInterface(this, "com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
    }
    
    public static atwm a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
      if ((localIInterface != null) && ((localIInterface instanceof atwm))) {
        return (atwm)localIInterface;
      }
      return new atwm.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        a(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        cE(paramParcel1.readBundle());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        q(paramParcel1.readInt(), paramParcel1.readBundle());
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        r(paramParcel1.readInt(), paramParcel1.readBundle());
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        s(paramParcel1.readInt(), paramParcel1.readBundle());
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
        a(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readBundle());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
      b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readBundle());
      return true;
    }
    
    static class a
      implements atwm
    {
      private IBinder mRemote;
      
      public a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(long paramLong1, String paramString1, String paramString2, long paramLong2)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeLong(paramLong1);
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeLong(paramLong2);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramString1.getMessage(), paramString1);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(String paramString, long paramLong, Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeString(paramString);
          localParcel.writeLong(paramLong);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(6, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramString.getMessage(), paramString);
          }
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
      
      public void b(int paramInt, String paramString, Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(7, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramString.getMessage(), paramString);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void cE(Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramBundle.getMessage(), paramBundle);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void q(int paramInt, Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeInt(paramInt);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramBundle.getMessage(), paramBundle);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void r(int paramInt, Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeInt(paramInt);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(4, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramBundle.getMessage(), paramBundle);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void s(int paramInt, Bundle paramBundle)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProviderCallback");
          localParcel.writeInt(paramInt);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProviderCallback", 2, paramBundle.getMessage(), paramBundle);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwm
 * JD-Core Version:    0.7.0.1
 */