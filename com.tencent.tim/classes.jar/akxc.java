import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface akxc
  extends IInterface
{
  public abstract void IP(int paramInt)
    throws RemoteException;
  
  public abstract int[] V()
    throws RemoteException;
  
  public abstract boolean[] a()
    throws RemoteException;
  
  public abstract void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void dDP()
    throws RemoteException;
  
  public abstract void fw(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract int lk()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements akxc
  {
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.pic.IPresendPicMgr");
    }
    
    public static akxc a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      if ((localIInterface != null) && ((localIInterface instanceof akxc))) {
        return (akxc)localIInterface;
      }
      return new akxc.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.pic.IPresendPicMgr");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          b(str1, str2, bool, paramParcel1.readInt(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        fw(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        IP(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        dDP();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        paramInt1 = lk();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
        paramParcel1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeBooleanArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      paramParcel1 = V();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    }
    
    static class a
      implements akxc
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void IP(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
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
      
      public int[] V()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
      
      public boolean[] a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          boolean[] arrayOfBoolean = localParcel2.createBooleanArray();
          return arrayOfBoolean;
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
      public void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 6
        //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 7
        //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 8
        //   13: aload 7
        //   15: ldc 31
        //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 7
        //   22: aload_1
        //   23: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload 7
        //   28: aload_2
        //   29: invokevirtual 67	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   32: iload_3
        //   33: ifeq +56 -> 89
        //   36: aload 7
        //   38: iload 6
        //   40: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   43: aload 7
        //   45: iload 4
        //   47: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   50: aload 7
        //   52: iload 5
        //   54: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   57: aload_0
        //   58: getfield 18	akxc$a$a:mRemote	Landroid/os/IBinder;
        //   61: iconst_1
        //   62: aload 7
        //   64: aload 8
        //   66: iconst_0
        //   67: invokeinterface 44 5 0
        //   72: pop
        //   73: aload 8
        //   75: invokevirtual 47	android/os/Parcel:readException	()V
        //   78: aload 8
        //   80: invokevirtual 50	android/os/Parcel:recycle	()V
        //   83: aload 7
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: return
        //   89: iconst_0
        //   90: istore 6
        //   92: goto -56 -> 36
        //   95: astore_1
        //   96: aload 8
        //   98: invokevirtual 50	android/os/Parcel:recycle	()V
        //   101: aload 7
        //   103: invokevirtual 50	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	a
        //   0	108	1	paramString1	String
        //   0	108	2	paramString2	String
        //   0	108	3	paramBoolean	boolean
        //   0	108	4	paramInt1	int
        //   0	108	5	paramInt2	int
        //   1	90	6	i	int
        //   6	96	7	localParcel1	Parcel
        //   11	86	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	32	95	finally
        //   36	78	95	finally
      }
      
      public void dDP()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void fw(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
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
      
      public int lk()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxc
 * JD-Core Version:    0.7.0.1
 */