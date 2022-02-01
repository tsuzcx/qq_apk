import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;

public abstract interface adgl
  extends IInterface
{
  public abstract ARScanStarFaceConfigInfo a()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements adgl
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
    }
    
    public static adgl a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
      if ((localIInterface != null) && ((localIInterface instanceof adgl))) {
        return (adgl)localIInterface;
      }
      return new adgl.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    
    static class a
      implements adgl
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public ARScanStarFaceConfigInfo a()
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
        //   14: aload_0
        //   15: getfield 18	adgl$a$a:mRemote	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 40 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 43	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 47	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 53	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 59 2 0
        //   48: checkcast 49	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 62	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 62	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 62	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 62	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localARScanStarFaceConfigInfo	ARScanStarFaceConfigInfo
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgl
 * JD-Core Version:    0.7.0.1
 */