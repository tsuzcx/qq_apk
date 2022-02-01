import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface mez
  extends IInterface
{
  public abstract boolean Dr()
    throws RemoteException;
  
  public abstract boolean Ds()
    throws RemoteException;
  
  public abstract boolean Dt()
    throws RemoteException;
  
  public abstract boolean Dx()
    throws RemoteException;
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, mfa parammfa)
    throws RemoteException;
  
  public abstract void a(mfb parammfb)
    throws RemoteException;
  
  public abstract void aJ(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract boolean dQ(String paramString)
    throws RemoteException;
  
  public abstract boolean dR(String paramString)
    throws RemoteException;
  
  public abstract String jD()
    throws RemoteException;
  
  public abstract String jE()
    throws RemoteException;
  
  public abstract String jF()
    throws RemoteException;
  
  public abstract void nA(String paramString)
    throws RemoteException;
  
  public abstract void nB(String paramString)
    throws RemoteException;
  
  public abstract void ny(String paramString)
    throws RemoteException;
  
  public abstract int oT()
    throws RemoteException;
  
  public abstract int oU()
    throws RemoteException;
  
  public abstract int oV()
    throws RemoteException;
  
  public abstract int oW()
    throws RemoteException;
  
  public abstract int oY()
    throws RemoteException;
  
  public abstract int oZ()
    throws RemoteException;
  
  public abstract int pa()
    throws RemoteException;
  
  public abstract int pb()
    throws RemoteException;
  
  public abstract int pc()
    throws RemoteException;
  
  public abstract int pd()
    throws RemoteException;
  
  public abstract int pe()
    throws RemoteException;
  
  public abstract int pf()
    throws RemoteException;
  
  public abstract void r(boolean paramBoolean, long paramLong)
    throws RemoteException;
  
  public abstract void rE(int paramInt)
    throws RemoteException;
  
  public abstract void rF(int paramInt)
    throws RemoteException;
  
  public abstract void rG(int paramInt)
    throws RemoteException;
  
  public abstract void rH(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements mez
  {
    public a()
    {
      attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
    }
    
    public static mez a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      if ((localIInterface != null) && ((localIInterface instanceof mez))) {
        return (mez)localIInterface;
      }
      return new mez.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = Ds();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        nA(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        rE(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pc();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramParcel1 = jF();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        rF(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pd();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pb();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pe();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        r(bool, paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        ny(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = dQ(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        rG(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pf();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        aJ(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oY();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramParcel1 = jD();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oT();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        rH(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oU();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), mfa.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = dR(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        nB(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = Dr();
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = Dt();
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        bool = Dx();
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramParcel1 = jE();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = pa();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oV();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oZ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
        paramInt1 = oW();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
      a(mfb.a.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements mez
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public boolean Dr()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public boolean Ds()
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 18	mez$a$a:mRemote	Landroid/os/IBinder;
        //   21: iconst_1
        //   22: aload_3
        //   23: aload 4
        //   25: iconst_0
        //   26: invokeinterface 41 5 0
        //   31: pop
        //   32: aload 4
        //   34: invokevirtual 44	android/os/Parcel:readException	()V
        //   37: aload 4
        //   39: invokevirtual 48	android/os/Parcel:readInt	()I
        //   42: istore_1
        //   43: iload_1
        //   44: ifeq +14 -> 58
        //   47: aload 4
        //   49: invokevirtual 51	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 51	android/os/Parcel:recycle	()V
        //   56: iload_2
        //   57: ireturn
        //   58: iconst_0
        //   59: istore_2
        //   60: goto -13 -> 47
        //   63: astore 5
        //   65: aload 4
        //   67: invokevirtual 51	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 51	android/os/Parcel:recycle	()V
        //   74: aload 5
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	a
        //   42	2	1	i	int
        //   1	59	2	bool	boolean
        //   5	66	3	localParcel1	Parcel
        //   9	57	4	localParcel2	Parcel
        //   63	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	43	63	finally
      }
      
      public boolean Dt()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(25, localParcel1, localParcel2, 0);
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
      
      public boolean Dx()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public void a(String paramString, int paramInt1, int paramInt2, mfa parammfa)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: aload 5
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 5
        //   19: aload_1
        //   20: invokevirtual 59	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload 5
        //   25: iload_2
        //   26: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   29: aload 5
        //   31: iload_3
        //   32: invokevirtual 63	android/os/Parcel:writeInt	(I)V
        //   35: aload 4
        //   37: ifnull +50 -> 87
        //   40: aload 4
        //   42: invokeinterface 69 1 0
        //   47: astore_1
        //   48: aload 5
        //   50: aload_1
        //   51: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 18	mez$a$a:mRemote	Landroid/os/IBinder;
        //   58: bipush 21
        //   60: aload 5
        //   62: aload 6
        //   64: iconst_0
        //   65: invokeinterface 41 5 0
        //   70: pop
        //   71: aload 6
        //   73: invokevirtual 44	android/os/Parcel:readException	()V
        //   76: aload 6
        //   78: invokevirtual 51	android/os/Parcel:recycle	()V
        //   81: aload 5
        //   83: invokevirtual 51	android/os/Parcel:recycle	()V
        //   86: return
        //   87: aconst_null
        //   88: astore_1
        //   89: goto -41 -> 48
        //   92: astore_1
        //   93: aload 6
        //   95: invokevirtual 51	android/os/Parcel:recycle	()V
        //   98: aload 5
        //   100: invokevirtual 51	android/os/Parcel:recycle	()V
        //   103: aload_1
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramString	String
        //   0	105	2	paramInt1	int
        //   0	105	3	paramInt2	int
        //   0	105	4	parammfa	mfa
        //   3	96	5	localParcel1	Parcel
        //   8	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	35	92	finally
        //   40	48	92	finally
        //   48	76	92	finally
      }
      
      /* Error */
      public void a(mfb parammfb)
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
        //   19: invokeinterface 76 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	mez$a$a:mRemote	Landroid/os/IBinder;
        //   34: bipush 32
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 41 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 44	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 51	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 51	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 51	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 51	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	parammfb	mfb
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public void aJ(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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
      
      public boolean dQ(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
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
      
      public boolean dR(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
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
      
      public String jD()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String jE()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String jF()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void nA(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void nB(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
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
      
      public void ny(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeString(paramString);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oT()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oU()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oV()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(29, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oW()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oY()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int oZ()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pa()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pb()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pc()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pd()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pe()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int pf()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void r(boolean paramBoolean, long paramLong)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          localParcel1.writeLong(paramLong);
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
      
      public void rE(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void rF(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeInt(paramInt);
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
      
      public void rG(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void rH(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IRIJAidlInterfaceForRedPacket");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mez
 * JD-Core Version:    0.7.0.1
 */