import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public abstract interface atwl
  extends IInterface
{
  public abstract void a(atwm paramatwm);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  
  public abstract void an(int paramInt, String paramString1, String paramString2);
  
  public abstract void c(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5);
  
  public abstract void j(Bitmap paramBitmap, int paramInt);
  
  public abstract void jk(String paramString1, String paramString2);
  
  public abstract void pauseDownload(String paramString);
  
  public abstract void unregisterCallback();
  
  public static abstract class a
    extends Binder
    implements IBinder.DeathRecipient, atwl
  {
    protected atwm b;
    
    public a()
    {
      attachInterface(this, "com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
    }
    
    public static atwl a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
      if ((localIInterface != null) && ((localIInterface instanceof atwl))) {
        return (atwl)localIInterface;
      }
      return new atwl.a.a(paramIBinder);
    }
    
    public void a(atwm paramatwm)
    {
      try
      {
        paramatwm.asBinder().linkToDeath(this, 0);
        this.b = paramatwm;
        return;
      }
      catch (RemoteException paramatwm)
      {
        binderDied();
      }
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public void binderDied()
    {
      destory();
    }
    
    public void destory()
    {
      if (QLog.isColorLevel()) {
        QLog.d("IFileManagerProvider", 2, "binder destoryed");
      }
      this.b = null;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        try
        {
          paramParcel2.writeString("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        a(atwm.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        jk(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        an(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        pauseDownload(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        j((Bitmap)paramParcel1.readParcelable(Bitmap.class.getClassLoader()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class a
      implements atwl
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(atwm paramatwm)
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          if (paramatwm != null) {
            localIBinder = paramatwm.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramatwm)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramatwm.getMessage(), paramatwm);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          localParcel.writeString(paramString4);
          localParcel.writeLong(paramLong);
          this.mRemote.transact(8, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramString1.getMessage(), paramString1);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void an(int paramInt, String paramString1, String paramString2)
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
            localParcel.writeInt(paramInt);
            localParcel.writeString(paramString1);
            localParcel.writeString(paramString2);
            switch (paramInt)
            {
            case 0: 
              throw new UnsupportedOperationException();
            }
          }
          catch (RemoteException paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.e("IFileManagerProvider", 2, paramString1.getMessage(), paramString1);
            }
            return;
            paramInt = 3;
            this.mRemote.transact(paramInt, localParcel, null, 1);
            return;
            paramInt = 4;
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void c(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          localParcel.writeString(paramString3);
          localParcel.writeString(paramString4);
          localParcel.writeLong(paramLong);
          localParcel.writeString(paramString5);
          this.mRemote.transact(5, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramString1.getMessage(), paramString1);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void j(Bitmap paramBitmap, int paramInt)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          localParcel.writeParcelable(paramBitmap, 0);
          localParcel.writeInt(paramInt);
          this.mRemote.transact(7, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramBitmap)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramBitmap.getMessage(), paramBitmap);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void jk(String paramString1, String paramString2)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          localParcel.writeString(paramString1);
          localParcel.writeString(paramString2);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramString1.getMessage(), paramString1);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void pauseDownload(String paramString)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          localParcel.writeString(paramString);
          this.mRemote.transact(6, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, paramString.getMessage(), paramString);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void unregisterCallback()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.tim.filemanager.data.provider.IFileManagerProvider");
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IFileManagerProvider", 2, localRemoteException.getMessage(), localRemoteException);
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
 * Qualified Name:     atwl
 * JD-Core Version:    0.7.0.1
 */