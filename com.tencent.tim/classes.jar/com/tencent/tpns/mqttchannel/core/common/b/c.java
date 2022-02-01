package com.tencent.tpns.mqttchannel.core.common.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface c
  extends IInterface
{
  public abstract void a(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1);
  
  public abstract void a(a parama);
  
  public abstract void b(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1);
  
  public abstract void b(a parama);
  
  public abstract void c(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1);
  
  public abstract void c(a parama);
  
  public abstract void d(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1);
  
  public abstract void d(a parama);
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
    }
    
    public static c a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
      if ((localIInterface != null) && ((localIInterface instanceof c))) {
        return (c)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        a(a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        b(a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        c(a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        d(a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (com.tencent.tpns.mqttchannel.core.common.a.a)com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(paramParcel1);
        }
        a((com.tencent.tpns.mqttchannel.core.common.a.a)localObject1, a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (com.tencent.tpns.mqttchannel.core.common.a.a)com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(paramParcel1);
        }
        b((com.tencent.tpns.mqttchannel.core.common.a.a)localObject1, a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (com.tencent.tpns.mqttchannel.core.common.a.a)com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(paramParcel1);
        }
        c((com.tencent.tpns.mqttchannel.core.common.a.a)localObject1, a.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (com.tencent.tpns.mqttchannel.core.common.a.a)com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(paramParcel1);
      }
      d((com.tencent.tpns.mqttchannel.core.common.a.a)localObject1, a.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements c
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public void a(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (parama1 != null)
              {
                parama = parama1.asBinder();
                localParcel1.writeStrongBinder(parama);
                this.a.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            parama = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(a parama)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 47 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 50	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/c$a$a:a	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 56 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 59	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 62	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 62	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 62	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 62	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	parama	a
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public void b(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (parama1 != null)
              {
                parama = parama1.asBinder();
                localParcel1.writeStrongBinder(parama);
                this.a.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            parama = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void b(a parama)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 47 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 50	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/c$a$a:a	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 56 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 59	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 62	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 62	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 62	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 62	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	parama	a
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public void c(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (parama1 != null)
              {
                parama = parama1.asBinder();
                localParcel1.writeStrongBinder(parama);
                this.a.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            parama = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void c(a parama)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 47 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 50	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/c$a$a:a	Landroid/os/IBinder;
        //   34: iconst_3
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 56 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 59	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 62	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 62	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 62	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 62	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	parama	a
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      public void d(com.tencent.tpns.mqttchannel.core.common.a.a parama, a parama1)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (parama1 != null)
              {
                parama = parama1.asBinder();
                localParcel1.writeStrongBinder(parama);
                this.a.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            parama = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void d(a parama)
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 47 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 50	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 17	com/tencent/tpns/mqttchannel/core/common/b/c$a$a:a	Landroid/os/IBinder;
        //   34: iconst_4
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 56 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 59	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 62	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 62	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 62	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 62	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	parama	a
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.common.b.c
 * JD-Core Version:    0.7.0.1
 */