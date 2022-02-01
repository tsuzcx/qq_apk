import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public abstract interface xuh
  extends IInterface
{
  public abstract MessageForShortVideo a(long paramLong);
  
  public abstract void a(xui paramxui);
  
  public abstract void b(long[] paramArrayOfLong);
  
  public abstract void cD(String paramString, int paramInt);
  
  public abstract void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void destory();
  
  public abstract void downloadMedia(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void favorite(long paramLong);
  
  public abstract void gc(long paramLong);
  
  public abstract void gd(long paramLong);
  
  public abstract void ge(long paramLong);
  
  public abstract Intent getFavorateParams(long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract Intent getForwardData(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int getSaveFileProgress(long paramLong, int paramInt);
  
  public abstract String getTroopMemberName(String paramString1, String paramString2);
  
  public abstract void i(MessageForShortVideo paramMessageForShortVideo);
  
  public abstract void loadMedias(int paramInt);
  
  public abstract void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle);
  
  public abstract void payFlow(long paramLong, int paramInt);
  
  public abstract void reportData(String paramString, int paramInt);
  
  public abstract void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void saveToWeiyun(long paramLong);
  
  public abstract void sendFileToPC(long paramLong);
  
  public abstract void unregisterCallback();
  
  public static abstract class a
    extends Binder
    implements IBinder.DeathRecipient, xuh
  {
    public xui c;
    
    protected a()
    {
      attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    }
    
    public static xuh a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      if ((localIInterface != null) && ((localIInterface instanceof xuh))) {
        return (xuh)localIInterface;
      }
      return new xuh.a.a(paramIBinder);
    }
    
    private boolean a(int paramInt, Parcel paramParcel1, Parcel paramParcel2)
    {
      boolean bool = false;
      switch (paramInt)
      {
      case 17: 
      case 18: 
      case 20: 
      default: 
        return false;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        paramParcel1 = a(paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        unregisterCallback();
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        onFileVideoStatusChange(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readBundle());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        paramInt = getSaveFileProgress(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        cD(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        paramParcel1 = getTroopMemberName(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramInt = paramParcel1.readInt();
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      if (i == 1) {
        bool = true;
      }
      safetyReport(paramInt, bool, str1, str2, str3, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
    
    public void a(xui paramxui)
    {
      try
      {
        paramxui.asBinder().linkToDeath(this, 0);
        this.c = paramxui;
        return;
      }
      catch (RemoteException paramxui)
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
        QLog.d("PEAK", 2, "binder destoryed");
      }
      this.c = null;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
      case 1598968902: 
      case 1: 
      case 2: 
      case 3: 
      case 17: 
      case 18: 
      case 4: 
      case 5: 
        try
        {
          if (!a(paramInt1, paramParcel1, paramParcel2)) {
            break;
          }
          return true;
        }
        catch (RuntimeException paramParcel1)
        {
          paramParcel1.printStackTrace();
          throw paramParcel1;
        }
        paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        downloadMedia(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        cancelDownloadMedia(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        loadMedias(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        gc(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        i((MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()));
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        a(xui.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        paramParcel1 = getFavorateParams(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        break;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        destory();
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        payFlow(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        reportData(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        paramParcel1 = getForwardData(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        break;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        gd(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        saveToWeiyun(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        long[] arrayOfLong = new long[paramParcel1.readInt()];
        paramParcel1.readLongArray(arrayOfLong);
        b(arrayOfLong);
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        ge(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        sendFileToPC(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        favorite(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
      boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      return bool;
      return true;
      return true;
    }
    
    static class a
      implements xuh
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public MessageForShortVideo a(long paramLong)
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: lload_1
        //   20: invokevirtual 38	android/os/Parcel:writeLong	(J)V
        //   23: aload_0
        //   24: getfield 18	xuh$a$a:mRemote	Landroid/os/IBinder;
        //   27: bipush 14
        //   29: aload 4
        //   31: aload 5
        //   33: iconst_0
        //   34: invokeinterface 44 5 0
        //   39: pop
        //   40: aload 5
        //   42: invokevirtual 47	android/os/Parcel:readException	()V
        //   45: aload 5
        //   47: invokevirtual 51	android/os/Parcel:readInt	()I
        //   50: ifeq +29 -> 79
        //   53: getstatic 57	com/tencent/mobileqq/data/MessageForShortVideo:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 5
        //   58: invokeinterface 63 2 0
        //   63: checkcast 53	com/tencent/mobileqq/data/MessageForShortVideo
        //   66: astore_3
        //   67: aload 5
        //   69: invokevirtual 66	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 66	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: areturn
        //   79: aconst_null
        //   80: astore_3
        //   81: goto -14 -> 67
        //   84: astore_3
        //   85: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   88: ifeq +12 -> 100
        //   91: ldc 74
        //   93: iconst_2
        //   94: ldc 76
        //   96: aload_3
        //   97: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   100: aload 5
        //   102: invokevirtual 66	android/os/Parcel:recycle	()V
        //   105: aload 4
        //   107: invokevirtual 66	android/os/Parcel:recycle	()V
        //   110: aconst_null
        //   111: areturn
        //   112: astore_3
        //   113: aload 5
        //   115: invokevirtual 66	android/os/Parcel:recycle	()V
        //   118: aload 4
        //   120: invokevirtual 66	android/os/Parcel:recycle	()V
        //   123: aload_3
        //   124: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	125	0	this	a
        //   0	125	1	paramLong	long
        //   66	15	3	localMessageForShortVideo	MessageForShortVideo
        //   84	13	3	localRemoteException	RemoteException
        //   112	12	3	localObject	Object
        //   3	116	4	localParcel1	Parcel
        //   8	106	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	67	84	android/os/RemoteException
        //   10	67	112	finally
        //   85	100	112	finally
      }
      
      public void a(xui paramxui)
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          if (paramxui != null) {
            localIBinder = paramxui.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(4, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramxui)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, paramxui.getMessage(), paramxui);
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
      
      public void b(long[] paramArrayOfLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeInt(paramArrayOfLong.length);
          localParcel.writeLongArray(paramArrayOfLong);
          this.mRemote.transact(20, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramArrayOfLong)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, paramArrayOfLong.getMessage(), paramArrayOfLong);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void cD(String paramString, int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(21, localParcel1, localParcel2, 1);
          localParcel2.readException();
          return;
        }
        catch (RemoteException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, "cleanMessage exception", paramString);
          }
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          this.mRemote.transact(2, localParcel, null, 1);
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
      
      public void destory()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          this.mRemote.transact(6, localParcel, null, 1);
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
      
      public void downloadMedia(long paramLong, int paramInt1, int paramInt2)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          this.mRemote.transact(1, localParcel, null, 1);
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
      
      public void favorite(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(13, localParcel, null, 1);
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
      
      public void gc(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(17, localParcel, null, 1);
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
      
      public void gd(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(10, localParcel, null, 1);
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
      
      public void ge(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(12, localParcel, null, 1);
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
      
      /* Error */
      public Intent getFavorateParams(long paramLong, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: lload_1
        //   20: invokevirtual 38	android/os/Parcel:writeLong	(J)V
        //   23: aload 5
        //   25: iload_3
        //   26: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   29: aload_0
        //   30: getfield 18	xuh$a$a:mRemote	Landroid/os/IBinder;
        //   33: iconst_5
        //   34: aload 5
        //   36: aload 6
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload 6
        //   47: invokevirtual 47	android/os/Parcel:readException	()V
        //   50: aload 6
        //   52: invokevirtual 51	android/os/Parcel:readInt	()I
        //   55: ifeq +31 -> 86
        //   58: getstatic 125	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   61: aload 6
        //   63: invokeinterface 63 2 0
        //   68: checkcast 124	android/content/Intent
        //   71: astore 4
        //   73: aload 6
        //   75: invokevirtual 66	android/os/Parcel:recycle	()V
        //   78: aload 5
        //   80: invokevirtual 66	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: areturn
        //   86: aconst_null
        //   87: astore 4
        //   89: goto -16 -> 73
        //   92: astore 4
        //   94: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   97: ifeq +16 -> 113
        //   100: ldc 74
        //   102: iconst_2
        //   103: aload 4
        //   105: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   108: aload 4
        //   110: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   113: aload 6
        //   115: invokevirtual 66	android/os/Parcel:recycle	()V
        //   118: aload 5
        //   120: invokevirtual 66	android/os/Parcel:recycle	()V
        //   123: aconst_null
        //   124: areturn
        //   125: astore 4
        //   127: aload 6
        //   129: invokevirtual 66	android/os/Parcel:recycle	()V
        //   132: aload 5
        //   134: invokevirtual 66	android/os/Parcel:recycle	()V
        //   137: aload 4
        //   139: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	140	0	this	a
        //   0	140	1	paramLong	long
        //   0	140	3	paramInt	int
        //   71	17	4	localIntent	Intent
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
      
      /* Error */
      public Intent getForwardData(long paramLong, int paramInt1, int paramInt2)
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 6
        //   19: lload_1
        //   20: invokevirtual 38	android/os/Parcel:writeLong	(J)V
        //   23: aload 6
        //   25: iload_3
        //   26: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   29: aload 6
        //   31: iload 4
        //   33: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 18	xuh$a$a:mRemote	Landroid/os/IBinder;
        //   40: bipush 9
        //   42: aload 6
        //   44: aload 7
        //   46: iconst_0
        //   47: invokeinterface 44 5 0
        //   52: pop
        //   53: aload 7
        //   55: invokevirtual 47	android/os/Parcel:readException	()V
        //   58: aload 7
        //   60: invokevirtual 51	android/os/Parcel:readInt	()I
        //   63: ifeq +31 -> 94
        //   66: getstatic 125	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   69: aload 7
        //   71: invokeinterface 63 2 0
        //   76: checkcast 124	android/content/Intent
        //   79: astore 5
        //   81: aload 6
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload 7
        //   88: invokevirtual 66	android/os/Parcel:recycle	()V
        //   91: aload 5
        //   93: areturn
        //   94: aconst_null
        //   95: astore 5
        //   97: goto -16 -> 81
        //   100: astore 5
        //   102: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   105: ifeq +16 -> 121
        //   108: ldc 74
        //   110: iconst_2
        //   111: aload 5
        //   113: invokevirtual 94	android/os/RemoteException:getMessage	()Ljava/lang/String;
        //   116: aload 5
        //   118: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   121: aload 6
        //   123: invokevirtual 66	android/os/Parcel:recycle	()V
        //   126: aload 7
        //   128: invokevirtual 66	android/os/Parcel:recycle	()V
        //   131: aconst_null
        //   132: areturn
        //   133: astore 5
        //   135: aload 6
        //   137: invokevirtual 66	android/os/Parcel:recycle	()V
        //   140: aload 7
        //   142: invokevirtual 66	android/os/Parcel:recycle	()V
        //   145: aload 5
        //   147: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	148	0	this	a
        //   0	148	1	paramLong	long
        //   0	148	3	paramInt1	int
        //   0	148	4	paramInt2	int
        //   79	17	5	localIntent	Intent
        //   100	17	5	localRemoteException	RemoteException
        //   133	13	5	localObject	Object
        //   3	133	6	localParcel1	Parcel
        //   8	133	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	81	100	android/os/RemoteException
        //   10	81	133	finally
        //   102	121	133	finally
      }
      
      public int getSaveFileProgress(long paramLong, int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        catch (RemoteException localRemoteException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, "getSaveFileProgress exception", localRemoteException);
          }
          return -1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getTroopMemberName(String paramString1, String paramString2)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          return paramString1;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, "getTroopMemberName exception", paramString1);
          }
          return "";
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void i(MessageForShortVideo paramMessageForShortVideo)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeParcelable(paramMessageForShortVideo, 0);
          this.mRemote.transact(18, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramMessageForShortVideo)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, paramMessageForShortVideo.getMessage(), paramMessageForShortVideo);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void loadMedias(int paramInt)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(3, localParcel, null, 1);
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
      
      /* Error */
      public void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: aload 5
        //   7: ldc 30
        //   9: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 5
        //   14: lload_1
        //   15: invokevirtual 38	android/os/Parcel:writeLong	(J)V
        //   18: aload 5
        //   20: iload_3
        //   21: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   24: aload 5
        //   26: aload 4
        //   28: invokevirtual 153	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
        //   31: aload_0
        //   32: getfield 18	xuh$a$a:mRemote	Landroid/os/IBinder;
        //   35: bipush 16
        //   37: aload 5
        //   39: aconst_null
        //   40: iconst_1
        //   41: invokeinterface 44 5 0
        //   46: pop
        //   47: aload 5
        //   49: invokevirtual 66	android/os/Parcel:recycle	()V
        //   52: return
        //   53: astore 4
        //   55: aload 5
        //   57: invokevirtual 66	android/os/Parcel:recycle	()V
        //   60: return
        //   61: astore 4
        //   63: aload 5
        //   65: invokevirtual 66	android/os/Parcel:recycle	()V
        //   68: aload 4
        //   70: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	71	0	this	a
        //   0	71	1	paramLong	long
        //   0	71	3	paramInt	int
        //   0	71	4	paramBundle	Bundle
        //   3	61	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	47	53	android/os/RemoteException
        //   5	47	61	finally
      }
      
      public void payFlow(long paramLong, int paramInt)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          localParcel.writeInt(paramInt);
          this.mRemote.transact(7, localParcel, null, 1);
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
      
      public void reportData(String paramString, int paramInt)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.mRemote.transact(8, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProvider", 2, paramString.getMessage(), paramString);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 7
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 8
        //   8: aload 8
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 8
        //   17: iload_1
        //   18: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   21: iload_2
        //   22: ifeq +61 -> 83
        //   25: iload 7
        //   27: istore_1
        //   28: aload 8
        //   30: iload_1
        //   31: invokevirtual 100	android/os/Parcel:writeInt	(I)V
        //   34: aload 8
        //   36: aload_3
        //   37: invokevirtual 108	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 8
        //   42: aload 4
        //   44: invokevirtual 108	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   47: aload 8
        //   49: aload 5
        //   51: invokevirtual 108	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   54: aload 8
        //   56: aload 6
        //   58: invokevirtual 108	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   61: aload_0
        //   62: getfield 18	xuh$a$a:mRemote	Landroid/os/IBinder;
        //   65: bipush 23
        //   67: aload 8
        //   69: aconst_null
        //   70: iconst_1
        //   71: invokeinterface 44 5 0
        //   76: pop
        //   77: aload 8
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: return
        //   83: iconst_0
        //   84: istore_1
        //   85: goto -57 -> 28
        //   88: astore_3
        //   89: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   92: ifeq +12 -> 104
        //   95: ldc 74
        //   97: iconst_2
        //   98: ldc 160
        //   100: aload_3
        //   101: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   104: aload 8
        //   106: invokevirtual 66	android/os/Parcel:recycle	()V
        //   109: return
        //   110: astore_3
        //   111: aload 8
        //   113: invokevirtual 66	android/os/Parcel:recycle	()V
        //   116: aload_3
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramInt	int
        //   0	118	2	paramBoolean	boolean
        //   0	118	3	paramString1	String
        //   0	118	4	paramString2	String
        //   0	118	5	paramString3	String
        //   0	118	6	paramString4	String
        //   1	25	7	i	int
        //   6	106	8	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	21	88	android/os/RemoteException
        //   28	77	88	android/os/RemoteException
        //   8	21	110	finally
        //   28	77	110	finally
        //   89	104	110	finally
      }
      
      public void saveToWeiyun(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(11, localParcel, null, 1);
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
      
      public void sendFileToPC(long paramLong)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          localParcel.writeLong(paramLong);
          this.mRemote.transact(24, localParcel, null, 1);
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
      
      public void unregisterCallback()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
          this.mRemote.transact(15, localParcel, null, 1);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuh
 * JD-Core Version:    0.7.0.1
 */