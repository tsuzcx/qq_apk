package com.tencent.qmsp.sdk.g.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface a
  extends IInterface
{
  public abstract String c();
  
  public abstract boolean g();
  
  public abstract String h();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static class a
      implements a
    {
      public IBinder a;
      
      public a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public String c()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return "";
      }
      
      /* Error */
      public boolean g()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 17	com/tencent/qmsp/sdk/g/a/a$a$a:a	Landroid/os/IBinder;
        //   21: iconst_1
        //   22: aload_3
        //   23: aload 4
        //   25: iconst_0
        //   26: invokeinterface 40 5 0
        //   31: pop
        //   32: aload 4
        //   34: invokevirtual 43	android/os/Parcel:readException	()V
        //   37: aload 4
        //   39: invokevirtual 59	android/os/Parcel:readInt	()I
        //   42: istore_1
        //   43: iload_1
        //   44: ifne +30 -> 74
        //   47: aload 4
        //   49: invokevirtual 49	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 49	android/os/Parcel:recycle	()V
        //   56: iload_2
        //   57: ireturn
        //   58: astore 5
        //   60: aload 4
        //   62: invokevirtual 49	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 49	android/os/Parcel:recycle	()V
        //   69: aload 5
        //   71: athrow
        //   72: astore 5
        //   74: iconst_1
        //   75: istore_2
        //   76: goto -29 -> 47
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   42	2	1	i	int
        //   1	75	2	bool	boolean
        //   5	61	3	localParcel1	Parcel
        //   9	52	4	localParcel2	Parcel
        //   58	12	5	localObject	Object
        //   72	1	5	localException	java.lang.Exception
        // Exception table:
        //   from	to	target	type
        //   11	43	58	finally
        //   11	43	72	java/lang/Exception
      }
      
      public String h()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.a
 * JD-Core Version:    0.7.0.1
 */