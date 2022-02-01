import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public abstract interface xui
  extends IInterface
{
  public abstract void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle);
  
  public abstract void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
  
  public abstract void notifyFinish();
  
  public static abstract class a
    extends Binder
    implements xui
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    }
    
    public static xui a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      if ((localIInterface != null) && ((localIInterface instanceof xui))) {
        return (xui)localIInterface;
      }
      return new xui.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        l1 = paramParcel1.readLong();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        paramParcel2 = paramParcel1.readString();
        if (paramParcel1.readByte() != 0) {}
        for (bool = true;; bool = false)
        {
          b(l1, paramInt1, paramInt2, i, paramParcel2, bool);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        b((AIORichMediaData[])paramParcel1.createTypedArray(AIORichMediaData.CREATOR), paramParcel1.readInt());
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        l1 = paramParcel1.readLong();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        long l2 = paramParcel1.readLong();
        if (paramParcel1.readByte() == 1) {}
        for (bool = true;; bool = false)
        {
          b(l1, paramInt1, paramInt2, i, l2, bool);
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        notifyFinish();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IAIOImageProviderCallBack", 2, "carverW onTransact -> case TRANSACTION_notifyVideoURL");
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      long l1 = paramParcel1.readLong();
      paramInt2 = paramParcel1.readInt();
      int i = paramParcel1.readInt();
      paramParcel2 = paramParcel1.readString();
      int j = paramParcel1.readInt();
      String[] arrayOfString = new String[j];
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        arrayOfString[paramInt1] = paramParcel1.readString();
        paramInt1 += 1;
      }
      a(l1, paramInt2, i, paramParcel2, arrayOfString, paramParcel1.readString(), (MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()), paramParcel1.readInt(), paramParcel1.readBundle());
      return true;
    }
    
    static class a
      implements xui
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
      {
        int i = 0;
        if (QLog.isColorLevel()) {
          QLog.d("IAIOImageProviderCallBack", 2, "carverW notifyVideoUrl");
        }
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
          localParcel.writeLong(paramLong);
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          localParcel.writeString(paramString1);
          if (paramArrayOfString != null)
          {
            paramInt2 = paramArrayOfString.length;
            localParcel.writeInt(paramInt2);
            paramInt1 = i;
            while (paramInt1 < paramInt2)
            {
              localParcel.writeString(paramArrayOfString[paramInt1]);
              paramInt1 += 1;
            }
          }
          localParcel.writeInt(-1);
          localParcel.writeString(paramString2);
          localParcel.writeParcelable(paramMessageForShortVideo, 0);
          localParcel.writeInt(paramInt3);
          localParcel.writeBundle(paramBundle);
          this.mRemote.transact(7, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProviderCallBack", 2, paramString1.getMessage(), paramString1);
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
      
      /* Error */
      public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 9
        //   3: invokestatic 42	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 10
        //   8: aload 10
        //   10: ldc 44
        //   12: invokevirtual 48	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 10
        //   17: lload_1
        //   18: invokevirtual 52	android/os/Parcel:writeLong	(J)V
        //   21: aload 10
        //   23: iload_3
        //   24: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   27: aload 10
        //   29: iload 4
        //   31: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   34: aload 10
        //   36: iload 5
        //   38: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   41: aload 10
        //   43: lload 6
        //   45: invokevirtual 52	android/os/Parcel:writeLong	(J)V
        //   48: iload 8
        //   50: ifeq +34 -> 84
        //   53: iload 9
        //   55: istore_3
        //   56: aload 10
        //   58: iload_3
        //   59: i2b
        //   60: invokevirtual 92	android/os/Parcel:writeByte	(B)V
        //   63: aload_0
        //   64: getfield 18	xui$a$a:mRemote	Landroid/os/IBinder;
        //   67: iconst_3
        //   68: aload 10
        //   70: aconst_null
        //   71: iconst_1
        //   72: invokeinterface 73 5 0
        //   77: pop
        //   78: aload 10
        //   80: invokevirtual 76	android/os/Parcel:recycle	()V
        //   83: return
        //   84: iconst_0
        //   85: istore_3
        //   86: goto -30 -> 56
        //   89: astore 11
        //   91: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   94: ifeq +16 -> 110
        //   97: ldc 30
        //   99: iconst_2
        //   100: aload 11
        //   102: invokevirtual 80	android/os/RemoteException:getMessage	()Ljava/lang/String;
        //   105: aload 11
        //   107: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   110: aload 10
        //   112: invokevirtual 76	android/os/Parcel:recycle	()V
        //   115: return
        //   116: astore 11
        //   118: aload 10
        //   120: invokevirtual 76	android/os/Parcel:recycle	()V
        //   123: aload 11
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	a
        //   0	126	1	paramLong1	long
        //   0	126	3	paramInt1	int
        //   0	126	4	paramInt2	int
        //   0	126	5	paramInt3	int
        //   0	126	6	paramLong2	long
        //   0	126	8	paramBoolean	boolean
        //   1	53	9	i	int
        //   6	113	10	localParcel	Parcel
        //   89	17	11	localRemoteException	RemoteException
        //   116	8	11	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	48	89	android/os/RemoteException
        //   56	78	89	android/os/RemoteException
        //   8	48	116	finally
        //   56	78	116	finally
        //   91	110	116	finally
      }
      
      /* Error */
      public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 8
        //   3: invokestatic 42	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 9
        //   8: aload 9
        //   10: ldc 44
        //   12: invokevirtual 48	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload 9
        //   17: lload_1
        //   18: invokevirtual 52	android/os/Parcel:writeLong	(J)V
        //   21: aload 9
        //   23: iload_3
        //   24: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   27: aload 9
        //   29: iload 4
        //   31: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   34: aload 9
        //   36: iload 5
        //   38: invokevirtual 56	android/os/Parcel:writeInt	(I)V
        //   41: aload 9
        //   43: aload 6
        //   45: invokevirtual 59	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: iload 7
        //   50: ifeq +34 -> 84
        //   53: iload 8
        //   55: istore_3
        //   56: aload 9
        //   58: iload_3
        //   59: i2b
        //   60: invokevirtual 92	android/os/Parcel:writeByte	(B)V
        //   63: aload_0
        //   64: getfield 18	xui$a$a:mRemote	Landroid/os/IBinder;
        //   67: iconst_1
        //   68: aload 9
        //   70: aconst_null
        //   71: iconst_1
        //   72: invokeinterface 73 5 0
        //   77: pop
        //   78: aload 9
        //   80: invokevirtual 76	android/os/Parcel:recycle	()V
        //   83: return
        //   84: iconst_0
        //   85: istore_3
        //   86: goto -30 -> 56
        //   89: astore 6
        //   91: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
        //   94: ifeq +16 -> 110
        //   97: ldc 30
        //   99: iconst_2
        //   100: aload 6
        //   102: invokevirtual 80	android/os/RemoteException:getMessage	()Ljava/lang/String;
        //   105: aload 6
        //   107: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
        //   110: aload 9
        //   112: invokevirtual 76	android/os/Parcel:recycle	()V
        //   115: return
        //   116: astore 6
        //   118: aload 9
        //   120: invokevirtual 76	android/os/Parcel:recycle	()V
        //   123: aload 6
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	a
        //   0	126	1	paramLong	long
        //   0	126	3	paramInt1	int
        //   0	126	4	paramInt2	int
        //   0	126	5	paramInt3	int
        //   0	126	6	paramString	String
        //   0	126	7	paramBoolean	boolean
        //   1	53	8	i	int
        //   6	113	9	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	48	89	android/os/RemoteException
        //   56	78	89	android/os/RemoteException
        //   8	48	116	finally
        //   56	78	116	finally
        //   91	110	116	finally
      }
      
      public void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
          localParcel.writeTypedArray(paramArrayOfAIORichMediaData, 0);
          localParcel.writeInt(paramInt);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        catch (RemoteException paramArrayOfAIORichMediaData)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IAIOImageProviderCallBack", 2, paramArrayOfAIORichMediaData.getMessage(), paramArrayOfAIORichMediaData);
          }
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void notifyFinish()
      {
        // Byte code:
        //   0: invokestatic 42	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: aload_1
        //   5: ldc 44
        //   7: invokevirtual 48	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_0
        //   11: getfield 18	xui$a$a:mRemote	Landroid/os/IBinder;
        //   14: iconst_4
        //   15: aload_1
        //   16: aconst_null
        //   17: iconst_1
        //   18: invokeinterface 73 5 0
        //   23: pop
        //   24: aload_1
        //   25: invokevirtual 76	android/os/Parcel:recycle	()V
        //   28: return
        //   29: astore_2
        //   30: aload_1
        //   31: invokevirtual 76	android/os/Parcel:recycle	()V
        //   34: return
        //   35: astore_2
        //   36: aload_1
        //   37: invokevirtual 76	android/os/Parcel:recycle	()V
        //   40: aload_2
        //   41: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	42	0	this	a
        //   3	34	1	localParcel	Parcel
        //   29	1	2	localRemoteException	RemoteException
        //   35	6	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   4	24	29	android/os/RemoteException
        //   4	24	35	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xui
 * JD-Core Version:    0.7.0.1
 */