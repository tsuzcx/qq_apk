import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cooperation.qzone.plugin.PluginRecord;

public abstract interface avyr
  extends IInterface
{
  public abstract PluginRecord a(String paramString)
    throws RemoteException;
  
  public abstract void a(avxq paramavxq, int paramInt)
    throws RemoteException;
  
  public abstract boolean a(String paramString, avxr paramavxr, int paramInt)
    throws RemoteException;
  
  public abstract void eCv()
    throws RemoteException;
  
  public abstract boolean isPluginInstalled(String paramString)
    throws RemoteException;
  
  public abstract boolean isReady()
    throws RemoteException;
  
  public abstract boolean tB(String paramString)
    throws RemoteException;
  
  public abstract boolean tr(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements avyr
  {
    public a()
    {
      attachInterface(this, "cooperation.qzone.plugin.QZoneRemotePluginManager");
    }
    
    public static avyr a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      if ((localIInterface != null) && ((localIInterface instanceof avyr))) {
        return (avyr)localIInterface;
      }
      return new avyr.a.a(paramIBinder);
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
      int n = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("cooperation.qzone.plugin.QZoneRemotePluginManager");
        return true;
      case 1: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        bool = isReady();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        bool = isPluginInstalled(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        bool = a(paramParcel1.readString(), avxr.a.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        bool = tB(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        bool = tr(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        paramParcel1 = a(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 7: 
        paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
        a(avxq.a.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("cooperation.qzone.plugin.QZoneRemotePluginManager");
      eCv();
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements avyr
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public PluginRecord a(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	avyr$a$a:mRemote	Landroid/os/IBinder;
        //   23: bipush 6
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 43 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 46	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 50	android/os/Parcel:readInt	()I
        //   42: ifeq +26 -> 68
        //   45: getstatic 56	cooperation/qzone/plugin/PluginRecord:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 62 2 0
        //   54: checkcast 52	cooperation/qzone/plugin/PluginRecord
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 65	android/os/Parcel:recycle	()V
        //   62: aload_2
        //   63: invokevirtual 65	android/os/Parcel:recycle	()V
        //   66: aload_1
        //   67: areturn
        //   68: aconst_null
        //   69: astore_1
        //   70: goto -12 -> 58
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 65	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 65	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramString	String
        //   3	76	2	localParcel1	Parcel
        //   7	68	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	58	73	finally
      }
      
      /* Error */
      public void a(avxq paramavxq, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 73 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 76	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 18	avyr$a$a:mRemote	Landroid/os/IBinder;
        //   40: bipush 7
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 43 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 46	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 65	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 65	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 65	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 65	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramavxq	avxq
        //   0	84	2	paramInt	int
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	72	finally
        //   19	26	72	finally
        //   26	57	72	finally
      }
      
      /* Error */
      public boolean a(String paramString, avxr paramavxr, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload_2
        //   27: ifnull +69 -> 96
        //   30: aload_2
        //   31: invokeinterface 84 1 0
        //   36: astore_1
        //   37: aload 5
        //   39: aload_1
        //   40: invokevirtual 76	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: aload 5
        //   45: iload_3
        //   46: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   49: aload_0
        //   50: getfield 18	avyr$a$a:mRemote	Landroid/os/IBinder;
        //   53: iconst_3
        //   54: aload 5
        //   56: aload 6
        //   58: iconst_0
        //   59: invokeinterface 43 5 0
        //   64: pop
        //   65: aload 6
        //   67: invokevirtual 46	android/os/Parcel:readException	()V
        //   70: aload 6
        //   72: invokevirtual 50	android/os/Parcel:readInt	()I
        //   75: istore_3
        //   76: iload_3
        //   77: ifeq +6 -> 83
        //   80: iconst_1
        //   81: istore 4
        //   83: aload 6
        //   85: invokevirtual 65	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: invokevirtual 65	android/os/Parcel:recycle	()V
        //   93: iload 4
        //   95: ireturn
        //   96: aconst_null
        //   97: astore_1
        //   98: goto -61 -> 37
        //   101: astore_1
        //   102: aload 6
        //   104: invokevirtual 65	android/os/Parcel:recycle	()V
        //   107: aload 5
        //   109: invokevirtual 65	android/os/Parcel:recycle	()V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	a
        //   0	114	1	paramString	String
        //   0	114	2	paramavxr	avxr
        //   0	114	3	paramInt	int
        //   1	93	4	bool	boolean
        //   6	102	5	localParcel1	Parcel
        //   11	92	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	101	finally
        //   30	37	101	finally
        //   37	76	101	finally
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void eCv()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isPluginInstalled(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
          localParcel1.writeString(paramString);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
      public boolean isReady()
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_0
        //   18: getfield 18	avyr$a$a:mRemote	Landroid/os/IBinder;
        //   21: iconst_1
        //   22: aload_3
        //   23: aload 4
        //   25: iconst_0
        //   26: invokeinterface 43 5 0
        //   31: pop
        //   32: aload 4
        //   34: invokevirtual 46	android/os/Parcel:readException	()V
        //   37: aload 4
        //   39: invokevirtual 50	android/os/Parcel:readInt	()I
        //   42: istore_1
        //   43: iload_1
        //   44: ifeq +14 -> 58
        //   47: aload 4
        //   49: invokevirtual 65	android/os/Parcel:recycle	()V
        //   52: aload_3
        //   53: invokevirtual 65	android/os/Parcel:recycle	()V
        //   56: iload_2
        //   57: ireturn
        //   58: iconst_0
        //   59: istore_2
        //   60: goto -13 -> 47
        //   63: astore 5
        //   65: aload 4
        //   67: invokevirtual 65	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 65	android/os/Parcel:recycle	()V
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
      
      public boolean tB(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
          localParcel1.writeString(paramString);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
      
      public boolean tr(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("cooperation.qzone.plugin.QZoneRemotePluginManager");
          localParcel1.writeString(paramString);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyr
 * JD-Core Version:    0.7.0.1
 */