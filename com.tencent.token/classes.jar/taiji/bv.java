package taiji;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.reflect.Method;

public class bv
  extends bu
{
  private IBinder f;
  
  bv(Context paramContext)
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
  private int a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 48	taiji/bv:f	Landroid/os/IBinder;
    //   6: ifnonnull +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore_3
    //   15: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   18: astore 4
    //   20: aload_3
    //   21: ldc 59
    //   23: invokevirtual 63	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   26: aload_3
    //   27: invokestatic 69	android/os/Process:myUid	()I
    //   30: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   33: aload_3
    //   34: invokestatic 76	android/os/Process:myPid	()I
    //   37: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 73	android/os/Parcel:writeInt	(I)V
    //   45: aload_3
    //   46: aconst_null
    //   47: invokevirtual 79	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 48	taiji/bv:f	Landroid/os/IBinder;
    //   54: bipush 7
    //   56: aload_3
    //   57: aload 4
    //   59: iconst_0
    //   60: invokeinterface 83 5 0
    //   65: pop
    //   66: aload 4
    //   68: invokevirtual 87	android/os/Parcel:readException	()V
    //   71: aload 4
    //   73: invokevirtual 90	android/os/Parcel:readInt	()I
    //   76: istore_1
    //   77: iload_1
    //   78: tableswitch	default:+22 -> 100, 2:+35->113, 3:+40->118
    //   101: istore_1
    //   102: aload_3
    //   103: invokevirtual 93	android/os/Parcel:recycle	()V
    //   106: aload 4
    //   108: invokevirtual 93	android/os/Parcel:recycle	()V
    //   111: iload_1
    //   112: ireturn
    //   113: iconst_m1
    //   114: istore_1
    //   115: goto -13 -> 102
    //   118: iconst_1
    //   119: istore_1
    //   120: goto -18 -> 102
    //   123: astore 5
    //   125: aload_3
    //   126: invokevirtual 93	android/os/Parcel:recycle	()V
    //   129: aload 4
    //   131: invokevirtual 93	android/os/Parcel:recycle	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore 5
    //   138: aload_3
    //   139: invokevirtual 93	android/os/Parcel:recycle	()V
    //   142: aload 4
    //   144: invokevirtual 93	android/os/Parcel:recycle	()V
    //   147: aload 5
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	bv
    //   0	150	1	paramInt	int
    //   1	100	2	i	int
    //   14	125	3	localParcel1	android.os.Parcel
    //   18	125	4	localParcel2	android.os.Parcel
    //   123	1	5	localThrowable	Throwable
    //   136	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	77	123	java/lang/Throwable
    //   20	77	136	finally
  }
  
  public int checkPermission(int paramInt)
  {
    int j = 0;
    if (Build.VERSION.SDK_INT < 19) {
      return 0;
    }
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
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
      switch (i)
      {
      }
      break;
    }
    do
    {
      return i;
      i = a(16);
      break;
      i = a(33554432);
      break;
      i = a(64);
      break;
      i = a(2);
      break;
      i = a(32768);
      break;
      i = a(262144);
      break;
      i = a(4);
      break;
      i = a(32);
      break;
      i = a(8192);
      break;
      i = a(1);
      break;
      i = a(16384);
      break;
      i = a(131072);
      break;
      i = j;
      if (Build.VERSION.SDK_INT > 23) {
        break;
      }
      i = a(8);
      break;
      i = a(16777216);
      break;
      i = a(2048);
      break;
      i = a(1024);
      break;
      i = a(128);
      break;
      i = j;
      if (Build.VERSION.SDK_INT > 23) {
        break;
      }
      i = a(2097152);
      break;
      i = j;
      if (Build.VERSION.SDK_INT > 23) {
        break;
      }
      i = a(8388608);
      break;
      return 0;
      return super.checkPermission(paramInt);
    } while (super.checkPermission(paramInt) != -1);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bv
 * JD-Core Version:    0.7.0.1
 */