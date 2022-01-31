import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.qphone.base.util.QLog;

public class ehu
  implements IAIOImageProvider
{
  private IBinder a;
  
  public ehu(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public android.content.Intent a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: lload_1
    //   20: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   23: aload 5
    //   25: iload_3
    //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   29: aload_0
    //   30: getfield 15	ehu:a	Landroid/os/IBinder;
    //   33: iconst_5
    //   34: aload 5
    //   36: aload 6
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload 6
    //   47: invokevirtual 49	android/os/Parcel:readInt	()I
    //   50: ifeq +31 -> 81
    //   53: getstatic 55	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   56: aload 6
    //   58: invokeinterface 61 2 0
    //   63: checkcast 51	android/content/Intent
    //   66: astore 4
    //   68: aload 6
    //   70: invokevirtual 64	android/os/Parcel:recycle	()V
    //   73: aload 5
    //   75: invokevirtual 64	android/os/Parcel:recycle	()V
    //   78: aload 4
    //   80: areturn
    //   81: aconst_null
    //   82: astore 4
    //   84: goto -16 -> 68
    //   87: astore 4
    //   89: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +16 -> 108
    //   95: ldc 72
    //   97: iconst_2
    //   98: aload 4
    //   100: invokevirtual 76	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   103: aload 4
    //   105: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload 6
    //   110: invokevirtual 64	android/os/Parcel:recycle	()V
    //   113: aload 5
    //   115: invokevirtual 64	android/os/Parcel:recycle	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore 4
    //   122: aload 6
    //   124: invokevirtual 64	android/os/Parcel:recycle	()V
    //   127: aload 5
    //   129: invokevirtual 64	android/os/Parcel:recycle	()V
    //   132: aload 4
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	ehu
    //   0	135	1	paramLong	long
    //   0	135	3	paramInt	int
    //   66	17	4	localIntent	android.content.Intent
    //   87	17	4	localRemoteException	RemoteException
    //   120	13	4	localObject	Object
    //   3	125	5	localParcel1	Parcel
    //   8	115	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	68	87	android/os/RemoteException
    //   10	68	120	finally
    //   89	108	120	finally
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider";
  }
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      this.a.transact(6, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt);
      this.a.transact(7, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      if (paramIAIOImageProviderCallBack != null) {
        localIBinder = paramIAIOImageProviderCallBack.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(4, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramIAIOImageProviderCallBack)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, paramIAIOImageProviderCallBack.getMessage(), paramIAIOImageProviderCallBack);
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
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehu
 * JD-Core Version:    0.7.0.1
 */