package com.tencent.wcdb;

import android.os.IBinder;

class IContentObserver$Stub$Proxy
  implements IContentObserver
{
  private IBinder mRemote;
  
  IContentObserver$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.wcdb.IContentObserver";
  }
  
  /* Error */
  public void onChange(boolean paramBoolean, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: aload 4
    //   9: ldc 22
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: iload_1
    //   15: ifeq +47 -> 62
    //   18: aload 4
    //   20: iload_3
    //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: ifnull +42 -> 67
    //   28: aload 4
    //   30: iconst_1
    //   31: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   34: aload_2
    //   35: aload 4
    //   37: iconst_0
    //   38: invokevirtual 44	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
    //   41: aload_0
    //   42: getfield 15	com/tencent/wcdb/IContentObserver$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   45: iconst_1
    //   46: aload 4
    //   48: aconst_null
    //   49: iconst_1
    //   50: invokeinterface 50 5 0
    //   55: pop
    //   56: aload 4
    //   58: invokevirtual 53	android/os/Parcel:recycle	()V
    //   61: return
    //   62: iconst_0
    //   63: istore_3
    //   64: goto -46 -> 18
    //   67: aload 4
    //   69: iconst_0
    //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
    //   73: goto -32 -> 41
    //   76: astore_2
    //   77: aload 4
    //   79: invokevirtual 53	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	Proxy
    //   0	84	1	paramBoolean	boolean
    //   0	84	2	paramUri	android.net.Uri
    //   1	63	3	i	int
    //   5	73	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   7	14	76	finally
    //   18	24	76	finally
    //   28	41	76	finally
    //   41	56	76	finally
    //   67	73	76	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */