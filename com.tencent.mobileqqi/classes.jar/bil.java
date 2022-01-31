import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.IQQServiceForAV;

public class bil
  implements IQQServiceForAV
{
  private IBinder a;
  
  public bil(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 7
    //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 8
    //   13: aload 7
    //   15: ldc 25
    //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 7
    //   22: iload_1
    //   23: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   26: aload 7
    //   28: aload_2
    //   29: invokevirtual 32	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: aload 7
    //   34: aload_3
    //   35: invokevirtual 32	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   38: iload 4
    //   40: ifeq +80 -> 120
    //   43: iconst_1
    //   44: istore_1
    //   45: aload 7
    //   47: iload_1
    //   48: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   51: iload 5
    //   53: ifeq +72 -> 125
    //   56: iload 6
    //   58: istore_1
    //   59: aload 7
    //   61: iload_1
    //   62: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   65: aload_0
    //   66: getfield 15	bil:a	Landroid/os/IBinder;
    //   69: iconst_2
    //   70: aload 7
    //   72: aload 8
    //   74: iconst_0
    //   75: invokeinterface 38 5 0
    //   80: pop
    //   81: aload 8
    //   83: invokevirtual 41	android/os/Parcel:readException	()V
    //   86: aload 8
    //   88: invokevirtual 45	android/os/Parcel:readInt	()I
    //   91: ifeq +39 -> 130
    //   94: getstatic 59	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
    //   97: aload 8
    //   99: invokeinterface 65 2 0
    //   104: checkcast 55	android/graphics/Bitmap
    //   107: astore_2
    //   108: aload 8
    //   110: invokevirtual 48	android/os/Parcel:recycle	()V
    //   113: aload 7
    //   115: invokevirtual 48	android/os/Parcel:recycle	()V
    //   118: aload_2
    //   119: areturn
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -77 -> 45
    //   125: iconst_0
    //   126: istore_1
    //   127: goto -68 -> 59
    //   130: aconst_null
    //   131: astore_2
    //   132: goto -24 -> 108
    //   135: astore_2
    //   136: aload 8
    //   138: invokevirtual 48	android/os/Parcel:recycle	()V
    //   141: aload 7
    //   143: invokevirtual 48	android/os/Parcel:recycle	()V
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	bil
    //   0	148	1	paramInt	int
    //   0	148	2	paramString1	String
    //   0	148	3	paramString2	String
    //   0	148	4	paramBoolean1	boolean
    //   0	148	5	paramBoolean2	boolean
    //   1	56	6	i	int
    //   6	136	7	localParcel1	Parcel
    //   11	126	8	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	38	135	finally
    //   45	51	135	finally
    //   59	108	135	finally
  }
  
  public String a()
  {
    return "com.tencent.av.service.IQQServiceForAV";
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString1 = localParcel2.readString();
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(4, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString1);
      localParcel.writeString(paramString2);
      this.a.transact(8, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceCallback != null) {
        localIBinder = paramIQQServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(6, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      this.a.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeLong(paramLong);
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 25
    //   16: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: aload_1
    //   22: invokevirtual 32	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 15	bil:a	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload 4
    //   32: aload 5
    //   34: iconst_0
    //   35: invokeinterface 38 5 0
    //   40: pop
    //   41: aload 5
    //   43: invokevirtual 41	android/os/Parcel:readException	()V
    //   46: aload 5
    //   48: invokevirtual 45	android/os/Parcel:readInt	()I
    //   51: istore_2
    //   52: iload_2
    //   53: ifeq +15 -> 68
    //   56: aload 5
    //   58: invokevirtual 48	android/os/Parcel:recycle	()V
    //   61: aload 4
    //   63: invokevirtual 48	android/os/Parcel:recycle	()V
    //   66: iload_3
    //   67: ireturn
    //   68: iconst_0
    //   69: istore_3
    //   70: goto -14 -> 56
    //   73: astore_1
    //   74: aload 5
    //   76: invokevirtual 48	android/os/Parcel:recycle	()V
    //   79: aload 4
    //   81: invokevirtual 48	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	bil
    //   0	86	1	paramString	String
    //   51	2	2	i	int
    //   1	69	3	bool	boolean
    //   5	75	4	localParcel1	Parcel
    //   10	65	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	52	73	finally
  }
  
  public long[] a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      localParcel1.writeString(paramString);
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createLongArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(IQQServiceCallback paramIQQServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceForAV");
      if (paramIQQServiceCallback != null) {
        localIBinder = paramIQQServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(7, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bil
 * JD-Core Version:    0.7.0.1
 */