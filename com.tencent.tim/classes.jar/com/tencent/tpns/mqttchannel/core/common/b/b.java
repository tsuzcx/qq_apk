package com.tencent.tpns.mqttchannel.core.common.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tpns.mqttchannel.core.common.a.a;

public abstract interface b
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(a parama);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
    }
    
    public static b a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          a(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        a();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        b();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (a)a.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class a
      implements b
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public void a()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void a(a parama)
      {
        // Byte code:
        //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 26
        //   11: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +41 -> 56
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 53	com/tencent/tpns/mqttchannel/core/common/a/a:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/b$a$a:a	Landroid/os/IBinder;
        //   33: iconst_4
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokeinterface 36 5 0
        //   42: pop
        //   43: aload_3
        //   44: invokevirtual 39	android/os/Parcel:readException	()V
        //   47: aload_3
        //   48: invokevirtual 42	android/os/Parcel:recycle	()V
        //   51: aload_2
        //   52: invokevirtual 42	android/os/Parcel:recycle	()V
        //   55: return
        //   56: aload_2
        //   57: iconst_0
        //   58: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   61: goto -32 -> 29
        //   64: astore_1
        //   65: aload_3
        //   66: invokevirtual 42	android/os/Parcel:recycle	()V
        //   69: aload_2
        //   70: invokevirtual 42	android/os/Parcel:recycle	()V
        //   73: aload_1
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	parama	a
        //   3	67	2	localParcel1	Parcel
        //   7	59	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	64	finally
        //   18	29	64	finally
        //   29	47	64	finally
        //   56	61	64	finally
      }
      
      /* Error */
      public void a(boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 26
        //   14: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +38 -> 56
        //   21: aload_3
        //   22: iload_2
        //   23: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   26: aload_0
        //   27: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/b$a$a:a	Landroid/os/IBinder;
        //   30: iconst_1
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 36 5 0
        //   40: pop
        //   41: aload 4
        //   43: invokevirtual 39	android/os/Parcel:readException	()V
        //   46: aload 4
        //   48: invokevirtual 42	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 42	android/os/Parcel:recycle	()V
        //   55: return
        //   56: iconst_0
        //   57: istore_2
        //   58: goto -37 -> 21
        //   61: astore 5
        //   63: aload 4
        //   65: invokevirtual 42	android/os/Parcel:recycle	()V
        //   68: aload_3
        //   69: invokevirtual 42	android/os/Parcel:recycle	()V
        //   72: aload 5
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	a
        //   0	75	1	paramBoolean	boolean
        //   1	57	2	i	int
        //   5	64	3	localParcel1	Parcel
        //   9	55	4	localParcel2	Parcel
        //   61	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	17	61	finally
        //   21	46	61	finally
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public void b()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
          this.a.transact(3, localParcel1, localParcel2, 0);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.b.b
 * JD-Core Version:    0.7.0.1
 */