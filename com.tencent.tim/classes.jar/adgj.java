import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public abstract interface adgj
  extends IInterface
{
  public abstract void KL(int paramInt)
    throws RemoteException;
  
  public abstract void KM(int paramInt)
    throws RemoteException;
  
  public abstract ArConfigInfo a()
    throws RemoteException;
  
  public abstract ArEffectConfig a()
    throws RemoteException;
  
  public abstract void a(adgk paramadgk)
    throws RemoteException;
  
  public abstract void a(adgm paramadgm)
    throws RemoteException;
  
  public abstract void a(adgn paramadgn)
    throws RemoteException;
  
  public abstract void a(adgo paramadgo)
    throws RemoteException;
  
  public abstract boolean adU()
    throws RemoteException;
  
  public abstract boolean adV()
    throws RemoteException;
  
  public abstract boolean adW()
    throws RemoteException;
  
  public abstract boolean adX()
    throws RemoteException;
  
  public abstract ARCommonConfigInfo b()
    throws RemoteException;
  
  public abstract void b(adgk paramadgk)
    throws RemoteException;
  
  public abstract void b(adgm paramadgm)
    throws RemoteException;
  
  public abstract void b(adgn paramadgn)
    throws RemoteException;
  
  public abstract void b(adgo paramadgo)
    throws RemoteException;
  
  public abstract void b(ArConfigInfo paramArConfigInfo)
    throws RemoteException;
  
  public abstract void cQW()
    throws RemoteException;
  
  public abstract void cQX()
    throws RemoteException;
  
  public abstract void cancelDownload()
    throws RemoteException;
  
  public abstract void downloadResource()
    throws RemoteException;
  
  public abstract void yd(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements adgj
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
    }
    
    public static adgj a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      if ((localIInterface != null) && ((localIInterface instanceof adgj))) {
        return (adgj)localIInterface;
      }
      return new adgj.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        a(adgn.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        b(adgn.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        paramParcel1 = b();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        downloadResource();
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        cancelDownload();
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        a(adgk.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        b(adgk.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        KL(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        bool = adU();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        a(adgm.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        b(adgm.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        KM(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        bool = adV();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        bool = adW();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        cQW();
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        a(adgo.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        b(adgo.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        bool = adX();
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        cQX();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      yd(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements adgj
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void KL(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void KM(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
      public ArConfigInfo a()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   18: iconst_3
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 44 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 47	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 57	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 63	com/tencent/mobileqq/ar/aidl/ArConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 69 2 0
        //   48: checkcast 59	com/tencent/mobileqq/ar/aidl/ArConfigInfo
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localArConfigInfo	ArConfigInfo
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public ArEffectConfig a()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   18: iconst_4
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 44 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 47	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 57	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 73	com/tencent/mobileqq/ar/aidl/ArEffectConfig:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 69 2 0
        //   48: checkcast 72	com/tencent/mobileqq/ar/aidl/ArEffectConfig
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localArEffectConfig	ArEffectConfig
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void a(adgk paramadgk)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 80 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 8
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgk	adgk
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void a(adgm paramadgm)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 87 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 12
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgm	adgm
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void a(adgn paramadgn)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 91 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 44 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 47	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 50	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramadgn	adgn
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      /* Error */
      public void a(adgo paramadgo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 95 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 19
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgo	adgo
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public boolean adU()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
      
      public boolean adV()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
      
      public boolean adW()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
      
      public boolean adX()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public ARCommonConfigInfo b()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   18: iconst_5
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 44 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 47	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 57	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 105	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 69 2 0
        //   48: checkcast 104	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 50	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   51	13	1	localARCommonConfigInfo	ARCommonConfigInfo
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
      }
      
      /* Error */
      public void b(adgk paramadgk)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 80 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 9
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgk	adgk
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void b(adgm paramadgm)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 87 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 13
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgm	adgm
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void b(adgn paramadgn)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 91 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 44 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 47	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 50	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramadgn	adgn
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
      }
      
      /* Error */
      public void b(adgo paramadgo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 95 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 20
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 44 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 47	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 50	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 50	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramadgo	adgo
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      /* Error */
      public void b(ArConfigInfo paramArConfigInfo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 31
        //   11: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 110	com/tencent/mobileqq/ar/aidl/ArConfigInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	adgj$a$a:mRemote	Landroid/os/IBinder;
        //   33: bipush 16
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 44 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 47	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 50	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 50	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramArConfigInfo	ArConfigInfo
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void cQW()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void cQX()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void cancelDownload()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void downloadResource()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void yd(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(23, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgj
 * JD-Core Version:    0.7.0.1
 */