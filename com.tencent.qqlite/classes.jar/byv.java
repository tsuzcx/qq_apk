import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.qphone.base.util.QLog;

public class byv
  implements IAIOImageProvider
{
  private IBinder a;
  
  public byv(IBinder paramIBinder)
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
    //   30: getfield 15	byv:a	Landroid/os/IBinder;
    //   33: iconst_5
    //   34: aload 5
    //   36: aload 6
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload 6
    //   47: invokevirtual 48	android/os/Parcel:readException	()V
    //   50: aload 6
    //   52: invokevirtual 52	android/os/Parcel:readInt	()I
    //   55: ifeq +31 -> 86
    //   58: getstatic 58	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   61: aload 6
    //   63: invokeinterface 64 2 0
    //   68: checkcast 54	android/content/Intent
    //   71: astore 4
    //   73: aload 6
    //   75: invokevirtual 67	android/os/Parcel:recycle	()V
    //   78: aload 5
    //   80: invokevirtual 67	android/os/Parcel:recycle	()V
    //   83: aload 4
    //   85: areturn
    //   86: aconst_null
    //   87: astore 4
    //   89: goto -16 -> 73
    //   92: astore 4
    //   94: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +16 -> 113
    //   100: ldc 75
    //   102: iconst_2
    //   103: aload 4
    //   105: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: aload 4
    //   110: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 6
    //   115: invokevirtual 67	android/os/Parcel:recycle	()V
    //   118: aload 5
    //   120: invokevirtual 67	android/os/Parcel:recycle	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore 4
    //   127: aload 6
    //   129: invokevirtual 67	android/os/Parcel:recycle	()V
    //   132: aload 5
    //   134: invokevirtual 67	android/os/Parcel:recycle	()V
    //   137: aload 4
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	byv
    //   0	140	1	paramLong	long
    //   0	140	3	paramInt	int
    //   71	17	4	localIntent	android.content.Intent
    //   92	17	4	localException	java.lang.Exception
    //   125	13	4	localObject	Object
    //   3	130	5	localParcel1	Parcel
    //   8	120	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	73	92	java/lang/Exception
    //   10	73	125	finally
    //   94	113	125	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     byv
 * JD-Core Version:    0.7.0.1
 */