package com.tencent.shadow.proguard;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.NotFoundException;
import com.tencent.shadow.dynamic.host.UuidManager;

final class e
  implements UuidManager
{
  private IBinder a;
  
  e(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  private static void a(Parcel paramParcel)
    throws FailedException, NotFoundException
  {
    int i = paramParcel.readInt();
    if (i == 1) {
      throw new FailedException(paramParcel);
    }
    if (i == 2) {
      throw new NotFoundException(paramParcel);
    }
    if (i != 0) {
      throw new RuntimeException("不认识的Code==" + i);
    }
  }
  
  /* Error */
  public final com.tencent.shadow.core.common.InstalledApk getPlugin(java.lang.String paramString1, java.lang.String paramString2)
    throws android.os.RemoteException, FailedException, NotFoundException
  {
    // Byte code:
    //   0: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: getstatic 61	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   13: invokevirtual 64	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 15	com/tencent/shadow/proguard/e:a	Landroid/os/IBinder;
    //   30: iconst_1
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 73 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokestatic 75	com/tencent/shadow/proguard/e:a	(Landroid/os/Parcel;)V
    //   46: aload 4
    //   48: invokevirtual 27	android/os/Parcel:readInt	()I
    //   51: ifeq +28 -> 79
    //   54: getstatic 81	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   57: aload 4
    //   59: invokeinterface 87 2 0
    //   64: checkcast 77	com/tencent/shadow/core/common/InstalledApk
    //   67: astore_1
    //   68: aload 4
    //   70: invokevirtual 90	android/os/Parcel:recycle	()V
    //   73: aload_3
    //   74: invokevirtual 90	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: areturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 90	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 90	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	e
    //   0	96	1	paramString1	java.lang.String
    //   0	96	2	paramString2	java.lang.String
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	68	84	finally
  }
  
  /* Error */
  public final com.tencent.shadow.core.common.InstalledApk getPluginLoader(java.lang.String paramString)
    throws android.os.RemoteException, NotFoundException, FailedException
  {
    // Byte code:
    //   0: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 61	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   12: invokevirtual 64	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 15	com/tencent/shadow/proguard/e:a	Landroid/os/IBinder;
    //   24: iconst_2
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 73 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokestatic 75	com/tencent/shadow/proguard/e:a	(Landroid/os/Parcel;)V
    //   38: aload_3
    //   39: invokevirtual 27	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 81	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 87 2 0
    //   54: checkcast 77	com/tencent/shadow/core/common/InstalledApk
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 90	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 90	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 90	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 90	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	e
    //   0	84	1	paramString	java.lang.String
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
  
  /* Error */
  public final com.tencent.shadow.core.common.InstalledApk getRuntime(java.lang.String paramString)
    throws android.os.RemoteException, NotFoundException, FailedException
  {
    // Byte code:
    //   0: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 57	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 61	com/tencent/shadow/dynamic/host/UuidManager:DESCRIPTOR	Ljava/lang/String;
    //   12: invokevirtual 64	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 15	com/tencent/shadow/proguard/e:a	Landroid/os/IBinder;
    //   24: iconst_3
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 73 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokestatic 75	com/tencent/shadow/proguard/e:a	(Landroid/os/Parcel;)V
    //   38: aload_3
    //   39: invokevirtual 27	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 81	com/tencent/shadow/core/common/InstalledApk:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 87 2 0
    //   54: checkcast 77	com/tencent/shadow/core/common/InstalledApk
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 90	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 90	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 90	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 90	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	e
    //   0	84	1	paramString	java.lang.String
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.proguard.e
 * JD-Core Version:    0.7.0.1
 */