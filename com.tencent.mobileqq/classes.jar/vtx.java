import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.qphone.base.util.QLog;

public class vtx
  implements IAIOImageProviderCallBack
{
  private IBinder a;
  
  public vtx(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 10
    //   8: aload 10
    //   10: ldc 27
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 10
    //   17: lload_1
    //   18: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   21: aload 10
    //   23: iload_3
    //   24: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   27: aload 10
    //   29: iload 4
    //   31: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   34: aload 10
    //   36: iload 5
    //   38: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   41: aload 10
    //   43: lload 6
    //   45: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   48: iload 8
    //   50: ifeq +34 -> 84
    //   53: iload 9
    //   55: istore_3
    //   56: aload 10
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 43	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 15	vtx:a	Landroid/os/IBinder;
    //   67: iconst_3
    //   68: aload 10
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 49 5 0
    //   77: pop
    //   78: aload 10
    //   80: invokevirtual 52	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 11
    //   91: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 60
    //   99: iconst_2
    //   100: aload 11
    //   102: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 11
    //   107: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 10
    //   112: invokevirtual 52	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 11
    //   118: aload 10
    //   120: invokevirtual 52	android/os/Parcel:recycle	()V
    //   123: aload 11
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	vtx
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
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 9
    //   8: aload 9
    //   10: ldc 27
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 9
    //   17: lload_1
    //   18: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   21: aload 9
    //   23: iload_3
    //   24: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   27: aload 9
    //   29: iload 4
    //   31: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   34: aload 9
    //   36: iload 5
    //   38: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   41: aload 9
    //   43: aload 6
    //   45: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   48: iload 7
    //   50: ifeq +34 -> 84
    //   53: iload 8
    //   55: istore_3
    //   56: aload 9
    //   58: iload_3
    //   59: i2b
    //   60: invokevirtual 43	android/os/Parcel:writeByte	(B)V
    //   63: aload_0
    //   64: getfield 15	vtx:a	Landroid/os/IBinder;
    //   67: iconst_1
    //   68: aload 9
    //   70: aconst_null
    //   71: iconst_1
    //   72: invokeinterface 49 5 0
    //   77: pop
    //   78: aload 9
    //   80: invokevirtual 52	android/os/Parcel:recycle	()V
    //   83: return
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -30 -> 56
    //   89: astore 6
    //   91: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +16 -> 110
    //   97: ldc 60
    //   99: iconst_2
    //   100: aload 6
    //   102: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   105: aload 6
    //   107: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 9
    //   112: invokevirtual 52	android/os/Parcel:recycle	()V
    //   115: return
    //   116: astore 6
    //   118: aload 9
    //   120: invokevirtual 52	android/os/Parcel:recycle	()V
    //   123: aload 6
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	vtx
    //   0	126	1	paramLong	long
    //   0	126	3	paramInt1	int
    //   0	126	4	paramInt2	int
    //   0	126	5	paramInt3	int
    //   0	126	6	paramString	java.lang.String
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
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      localParcel.writeTypedArray(paramArrayOfAIORichMediaData, 0);
      localParcel.writeInt(paramInt);
      this.a.transact(2, localParcel, null, 1);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtx
 * JD-Core Version:    0.7.0.1
 */