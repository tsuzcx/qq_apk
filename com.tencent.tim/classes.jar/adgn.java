import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public abstract interface adgn
  extends IInterface
{
  public abstract void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo)
    throws RemoteException;
  
  public abstract void ez(int paramInt)
    throws RemoteException;
  
  public abstract void m(long paramLong1, long paramLong2)
    throws RemoteException;
  
  public abstract void onDownloadSuccess()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements adgn
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    }
    
    public static adgn a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      if ((localIInterface != null) && ((localIInterface instanceof adgn))) {
        return (adgn)localIInterface;
      }
      return new adgn.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        onDownloadSuccess();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        m(paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        ez(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      ArConfigInfo localArConfigInfo;
      ArEffectConfig localArEffectConfig;
      if (paramParcel1.readInt() != 0)
      {
        localArConfigInfo = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label219;
        }
        localArEffectConfig = (ArEffectConfig)ArEffectConfig.CREATOR.createFromParcel(paramParcel1);
        label178:
        if (paramParcel1.readInt() == 0) {
          break label225;
        }
      }
      label219:
      label225:
      for (paramParcel1 = (ARCommonConfigInfo)ARCommonConfigInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(localArConfigInfo, localArEffectConfig, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localArConfigInfo = null;
        break;
        localArEffectConfig = null;
        break label178;
      }
    }
    
    static class a
      implements adgn
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
            if (paramArConfigInfo != null)
            {
              localParcel1.writeInt(1);
              paramArConfigInfo.writeToParcel(localParcel1, 0);
              if (paramArEffectConfig != null)
              {
                localParcel1.writeInt(1);
                paramArEffectConfig.writeToParcel(localParcel1, 0);
                if (paramARCommonConfigInfo == null) {
                  break label131;
                }
                localParcel1.writeInt(1);
                paramARCommonConfigInfo.writeToParcel(localParcel1, 0);
                this.mRemote.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label131:
          localParcel1.writeInt(0);
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void ez(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
          localParcel1.writeInt(paramInt);
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
      
      public void m(long paramLong1, long paramLong2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
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
      
      public void onDownloadSuccess()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgn
 * JD-Core Version:    0.7.0.1
 */