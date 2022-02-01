package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.reflect.Method;

public final class aqm
  extends aql
{
  private IBinder f;
  
  public aqm(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    try
    {
      this.f = ((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "com.huawei.permissionmanager.service.holdservice" }));
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private int b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/token/aqm:f	Landroid/os/IBinder;
    //   4: astore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_3
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore_3
    //   17: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   20: astore 4
    //   22: aload_3
    //   23: ldc 59
    //   25: invokevirtual 63	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   28: aload_3
    //   29: invokestatic 69	android/os/Process:myUid	()I
    //   32: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   35: aload_3
    //   36: invokestatic 76	android/os/Process:myPid	()I
    //   39: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   42: aload_3
    //   43: iload_1
    //   44: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   47: aload_3
    //   48: aconst_null
    //   49: invokevirtual 79	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 48	com/tencent/token/aqm:f	Landroid/os/IBinder;
    //   56: bipush 7
    //   58: aload_3
    //   59: aload 4
    //   61: iconst_0
    //   62: invokeinterface 83 5 0
    //   67: pop
    //   68: aload 4
    //   70: invokevirtual 87	android/os/Parcel:readException	()V
    //   73: aload 4
    //   75: invokevirtual 90	android/os/Parcel:readInt	()I
    //   78: istore_1
    //   79: iload_1
    //   80: tableswitch	default:+24 -> 104, 2:+34->114, 3:+29->109
    //   105: istore_1
    //   106: goto +27 -> 133
    //   109: iconst_1
    //   110: istore_1
    //   111: goto +22 -> 133
    //   114: iconst_m1
    //   115: istore_1
    //   116: goto +17 -> 133
    //   119: astore 5
    //   121: aload_3
    //   122: invokevirtual 93	android/os/Parcel:recycle	()V
    //   125: aload 4
    //   127: invokevirtual 93	android/os/Parcel:recycle	()V
    //   130: aload 5
    //   132: athrow
    //   133: aload_3
    //   134: invokevirtual 93	android/os/Parcel:recycle	()V
    //   137: aload 4
    //   139: invokevirtual 93	android/os/Parcel:recycle	()V
    //   142: iload_1
    //   143: ireturn
    //   144: astore 5
    //   146: iload_2
    //   147: istore_1
    //   148: goto -15 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	aqm
    //   0	151	1	paramInt	int
    //   6	141	2	i	int
    //   4	130	3	localObject1	Object
    //   20	118	4	localParcel	android.os.Parcel
    //   119	12	5	localObject2	Object
    //   144	1	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	79	119	finally
    //   22	79	144	java/lang/Throwable
  }
  
  public final int a(int paramInt)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j < 19) {
      return 0;
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 15: 
    case 17: 
    case 19: 
    case 25: 
    case 31: 
    case 33: 
    default: 
      break;
    case 35: 
      if (Build.VERSION.SDK_INT > 23) {
        break label316;
      }
      i = 8388608;
      break;
    case 34: 
      if (Build.VERSION.SDK_INT > 23) {
        break label316;
      }
      i = 2097152;
      break;
    case 32: 
      return 0;
    case 30: 
      i = 128;
      break;
    case 29: 
      i = 1024;
      break;
    case 27: 
    case 28: 
      i = 2048;
      break;
    case 26: 
      i = 16777216;
      break;
    case 24: 
      if (Build.VERSION.SDK_INT > 23) {
        break label316;
      }
      i = 8;
      break;
    case 23: 
      i = 131072;
      break;
    case 22: 
      i = 16384;
      break;
    case 21: 
      i = 1;
      break;
    case 20: 
      i = 8192;
      break;
    case 16: 
      i = 32;
      break;
    case 14: 
    case 18: 
      i = 4;
      break;
    case 13: 
      i = 262144;
      break;
    case 12: 
      i = 32768;
      break;
    case 11: 
      i = 2;
      break;
    case 10: 
      i = 64;
      break;
    case 7: 
      i = 33554432;
      break;
    case 1: 
      i = 16;
    }
    i = b(i);
    switch (i)
    {
    default: 
      return i;
    case 1: 
      if (super.a(paramInt) == -1) {
        return -1;
      }
      break;
    case 0: 
      label316:
      i = super.a(paramInt);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqm
 * JD-Core Version:    0.7.0.1
 */