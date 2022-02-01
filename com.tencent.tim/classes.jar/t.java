import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.SubscriptionInfo;
import java.util.List;

public abstract interface t
  extends IInterface
{
  public abstract void C(int paramInt)
    throws RemoteException;
  
  public abstract int H()
    throws RemoteException;
  
  public abstract int N()
    throws RemoteException;
  
  public abstract int Q()
    throws RemoteException;
  
  public abstract int S()
    throws RemoteException;
  
  public abstract int Z()
    throws RemoteException;
  
  public abstract int a(String paramString, int paramInt, long paramLong)
    throws RemoteException;
  
  public abstract SubscriptionInfo a(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract SubscriptionInfo a(String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract int[] a(int paramInt)
    throws RemoteException;
  
  public abstract void aA()
    throws RemoteException;
  
  public abstract int aa()
    throws RemoteException;
  
  public abstract SubscriptionInfo b(int paramInt, String paramString)
    throws RemoteException;
  
  public abstract String b(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void b(int paramInt, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract int c(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int c(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract int e(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract int[] e()
    throws RemoteException;
  
  public abstract int f(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int f(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract List<SubscriptionInfo> f(String paramString)
    throws RemoteException;
  
  public abstract int g(String paramString)
    throws RemoteException;
  
  public abstract List<SubscriptionInfo> g(String paramString)
    throws RemoteException;
  
  public abstract int j(String paramString)
    throws RemoteException;
  
  public abstract int p(int paramInt)
    throws RemoteException;
  
  public abstract int q(int paramInt)
    throws RemoteException;
  
  public abstract boolean q(int paramInt)
    throws RemoteException;
  
  public abstract int r(int paramInt)
    throws RemoteException;
  
  public abstract void y(int paramInt)
    throws RemoteException;
  
  public abstract void z(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements t
  {
    public static t a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.internal.telephony.ISub");
      if ((localIInterface != null) && ((localIInterface instanceof t))) {
        return (t)localIInterface;
      }
      return new t.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.android.internal.telephony.ISub");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = f(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = g(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString());
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
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
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
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = b(paramParcel1.readInt(), paramParcel1.readString());
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
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = g(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = j(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = H();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = c(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = c(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = e(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = f(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = f(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = p(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = a(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = N();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = Q();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = q(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = S();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        y(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = Z();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        z(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = aa();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        C(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        aA();
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = e();
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramParcel1 = b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
        paramInt1 = r(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      boolean bool = q(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static class a
      implements t
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void C(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int H()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
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
      
      public int N()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
      
      public int Q()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
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
      
      public int S()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
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
      
      public int Z()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          this.mRemote.transact(22, localParcel1, localParcel2, 0);
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
      
      public int a(String paramString, int paramInt, long paramLong)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          localParcel1.writeLong(paramLong);
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public SubscriptionInfo a(int paramInt, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   20: aload_3
        //   21: aload_2
        //   22: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 18	t$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_3
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 44 5 0
        //   39: pop
        //   40: aload 4
        //   42: invokevirtual 47	android/os/Parcel:readException	()V
        //   45: aload 4
        //   47: invokevirtual 56	android/os/Parcel:readInt	()I
        //   50: ifeq +28 -> 78
        //   53: getstatic 75	android/telephony/SubscriptionInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 4
        //   58: invokeinterface 81 2 0
        //   63: checkcast 71	android/telephony/SubscriptionInfo
        //   66: astore_2
        //   67: aload 4
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: areturn
        //   78: aconst_null
        //   79: astore_2
        //   80: goto -13 -> 67
        //   83: astore_2
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 50	android/os/Parcel:recycle	()V
        //   93: aload_2
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramInt	int
        //   0	95	2	paramString	String
        //   3	87	3	localParcel1	Parcel
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	67	83	finally
      }
      
      /* Error */
      public SubscriptionInfo a(String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_2
        //   22: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 18	t$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_4
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 44 5 0
        //   39: pop
        //   40: aload 4
        //   42: invokevirtual 47	android/os/Parcel:readException	()V
        //   45: aload 4
        //   47: invokevirtual 56	android/os/Parcel:readInt	()I
        //   50: ifeq +28 -> 78
        //   53: getstatic 75	android/telephony/SubscriptionInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 4
        //   58: invokeinterface 81 2 0
        //   63: checkcast 71	android/telephony/SubscriptionInfo
        //   66: astore_1
        //   67: aload 4
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: areturn
        //   78: aconst_null
        //   79: astore_1
        //   80: goto -13 -> 67
        //   83: astore_1
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 50	android/os/Parcel:recycle	()V
        //   93: aload_1
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramString1	String
        //   0	95	2	paramString2	String
        //   3	87	3	localParcel1	Parcel
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	67	83	finally
      }
      
      public int[] a(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int[] arrayOfInt = localParcel2.createIntArray();
          return arrayOfInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void aA()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          this.mRemote.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int aa()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          this.mRemote.transact(24, localParcel1, localParcel2, 0);
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public SubscriptionInfo b(int paramInt, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   20: aload_3
        //   21: aload_2
        //   22: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_0
        //   26: getfield 18	t$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_5
        //   30: aload_3
        //   31: aload 4
        //   33: iconst_0
        //   34: invokeinterface 44 5 0
        //   39: pop
        //   40: aload 4
        //   42: invokevirtual 47	android/os/Parcel:readException	()V
        //   45: aload 4
        //   47: invokevirtual 56	android/os/Parcel:readInt	()I
        //   50: ifeq +28 -> 78
        //   53: getstatic 75	android/telephony/SubscriptionInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   56: aload 4
        //   58: invokeinterface 81 2 0
        //   63: checkcast 71	android/telephony/SubscriptionInfo
        //   66: astore_2
        //   67: aload 4
        //   69: invokevirtual 50	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 50	android/os/Parcel:recycle	()V
        //   76: aload_2
        //   77: areturn
        //   78: aconst_null
        //   79: astore_2
        //   80: goto -13 -> 67
        //   83: astore_2
        //   84: aload 4
        //   86: invokevirtual 50	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 50	android/os/Parcel:recycle	()V
        //   93: aload_2
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramInt	int
        //   0	95	2	paramString	String
        //   3	87	3	localParcel1	Parcel
        //   7	78	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	67	83	finally
      }
      
      public String b(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(29, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          return paramString1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void b(int paramInt, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int c(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int c(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int e(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int[] e()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          this.mRemote.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int[] arrayOfInt = localParcel2.createIntArray();
          return arrayOfInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int f(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int f(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public List<SubscriptionInfo> f(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createTypedArrayList(SubscriptionInfo.CREATOR);
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int g(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      
      public List<SubscriptionInfo> g(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = localParcel2.createTypedArrayList(SubscriptionInfo.CREATOR);
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int j(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeString(paramString);
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
      
      public int p(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int q(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean q(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public int r(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void y(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void z(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISub");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     t
 * JD-Core Version:    0.7.0.1
 */