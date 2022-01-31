package com.tencent.a.a.a;

import android.os.IBinder;
import android.os.Parcel;

final class c
  implements a
{
  private IBinder a;
  
  c(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public final int a(d paramd)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +52 -> 68
    //   19: aload_1
    //   20: invokeinterface 35 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_0
    //   32: getfield 15	com/tencent/a/a/a/c:a	Landroid/os/IBinder;
    //   35: iconst_2
    //   36: aload_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 44 5 0
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 47	android/os/Parcel:readException	()V
    //   51: aload 4
    //   53: invokevirtual 51	android/os/Parcel:readInt	()I
    //   56: istore_2
    //   57: aload 4
    //   59: invokevirtual 54	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 54	android/os/Parcel:recycle	()V
    //   66: iload_2
    //   67: ireturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -44 -> 26
    //   73: astore_1
    //   74: aload 4
    //   76: invokevirtual 54	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 54	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	c
    //   0	85	1	paramd	d
    //   56	11	2	i	int
    //   3	77	3	localParcel1	Parcel
    //   7	68	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	73	finally
    //   19	26	73	finally
    //   26	57	73	finally
  }
  
  /* Error */
  public final int a(String paramString1, String paramString2, d paramd)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: aload_1
    //   20: invokevirtual 58	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 5
    //   25: aload_2
    //   26: invokevirtual 58	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload_3
    //   30: ifnull +57 -> 87
    //   33: aload_3
    //   34: invokeinterface 35 1 0
    //   39: astore_1
    //   40: aload 5
    //   42: aload_1
    //   43: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   46: aload_0
    //   47: getfield 15	com/tencent/a/a/a/c:a	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 5
    //   53: aload 6
    //   55: iconst_0
    //   56: invokeinterface 44 5 0
    //   61: pop
    //   62: aload 6
    //   64: invokevirtual 47	android/os/Parcel:readException	()V
    //   67: aload 6
    //   69: invokevirtual 51	android/os/Parcel:readInt	()I
    //   72: istore 4
    //   74: aload 6
    //   76: invokevirtual 54	android/os/Parcel:recycle	()V
    //   79: aload 5
    //   81: invokevirtual 54	android/os/Parcel:recycle	()V
    //   84: iload 4
    //   86: ireturn
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -49 -> 40
    //   92: astore_1
    //   93: aload 6
    //   95: invokevirtual 54	android/os/Parcel:recycle	()V
    //   98: aload 5
    //   100: invokevirtual 54	android/os/Parcel:recycle	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	c
    //   0	105	1	paramString1	String
    //   0	105	2	paramString2	String
    //   0	105	3	paramd	d
    //   72	13	4	i	int
    //   3	96	5	localParcel1	Parcel
    //   8	86	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	29	92	finally
    //   33	40	92	finally
    //   40	74	92	finally
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createByteArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.a.transact(4, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */