package com.tencent.qmsp.sdk.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract interface a
  extends IInterface
{
  public abstract String b(String paramString);
  
  public abstract boolean c();
  
  public abstract String g();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
      if ((localIInterface == null) || (!(localIInterface instanceof a))) {
        return new a(paramIBinder);
      }
      return (a)localIInterface;
    }
    
    static class a
      implements a
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      /* Error */
      public String b(String paramString)
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 17	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
        //   23: iconst_5
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokeinterface 45 5 0
        //   32: pop
        //   33: aload_3
        //   34: invokevirtual 48	android/os/Parcel:readException	()V
        //   37: aload_3
        //   38: invokevirtual 52	android/os/Parcel:readString	()Ljava/lang/String;
        //   41: astore_1
        //   42: aload_3
        //   43: invokevirtual 55	android/os/Parcel:recycle	()V
        //   46: aload_2
        //   47: invokevirtual 55	android/os/Parcel:recycle	()V
        //   50: aload_1
        //   51: areturn
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 55	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 55	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: athrow
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 55	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aconst_null
        //   73: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramString	String
        //   3	66	2	localParcel1	android.os.Parcel
        //   7	58	3	localParcel2	android.os.Parcel
        // Exception table:
        //   from	to	target	type
        //   8	42	52	finally
        //   8	42	63	android/os/RemoteException
      }
      
      /* Error */
      public boolean c()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 17	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
        //   21: iconst_3
        //   22: aload_3
        //   23: aload 4
        //   25: iconst_0
        //   26: invokeinterface 45 5 0
        //   31: pop
        //   32: aload 4
        //   34: invokevirtual 48	android/os/Parcel:readException	()V
        //   37: aload 4
        //   39: invokevirtual 61	android/os/Parcel:readInt	()I
        //   42: istore_1
        //   43: iload_1
        //   44: ifeq +5 -> 49
        //   47: iconst_1
        //   48: istore_2
        //   49: aload 4
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_3
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: iload_2
        //   59: ireturn
        //   60: astore 5
        //   62: aload 4
        //   64: invokevirtual 55	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload 5
        //   73: athrow
        //   74: astore 5
        //   76: goto -27 -> 49
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   42	2	1	i	int
        //   1	58	2	bool	boolean
        //   5	63	3	localParcel1	android.os.Parcel
        //   9	54	4	localParcel2	android.os.Parcel
        //   60	12	5	localObject	Object
        //   74	1	5	localRemoteException	android.os.RemoteException
        // Exception table:
        //   from	to	target	type
        //   11	43	60	finally
        //   11	43	74	android/os/RemoteException
      }
      
      /* Error */
      public String g()
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 17	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokeinterface 45 5 0
        //   27: pop
        //   28: aload_2
        //   29: invokevirtual 48	android/os/Parcel:readException	()V
        //   32: aload_2
        //   33: invokevirtual 52	android/os/Parcel:readString	()Ljava/lang/String;
        //   36: astore_3
        //   37: aload_2
        //   38: invokevirtual 55	android/os/Parcel:recycle	()V
        //   41: aload_1
        //   42: invokevirtual 55	android/os/Parcel:recycle	()V
        //   45: aload_3
        //   46: areturn
        //   47: astore_3
        //   48: aload_2
        //   49: invokevirtual 55	android/os/Parcel:recycle	()V
        //   52: aload_1
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: aload_3
        //   57: athrow
        //   58: astore_3
        //   59: aload_2
        //   60: invokevirtual 55	android/os/Parcel:recycle	()V
        //   63: aload_1
        //   64: invokevirtual 55	android/os/Parcel:recycle	()V
        //   67: aconst_null
        //   68: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	69	0	this	a
        //   3	61	1	localParcel1	android.os.Parcel
        //   7	53	2	localParcel2	android.os.Parcel
        //   36	10	3	str	String
        //   47	10	3	localObject	Object
        //   58	1	3	localRemoteException	android.os.RemoteException
        // Exception table:
        //   from	to	target	type
        //   8	37	47	finally
        //   8	37	58	android/os/RemoteException
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.a
 * JD-Core Version:    0.7.0.1
 */