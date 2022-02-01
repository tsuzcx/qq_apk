import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface awob
  extends IInterface
{
  public abstract void a(awoc paramawoc)
    throws RemoteException;
  
  public abstract void b(awoc paramawoc)
    throws RemoteException;
  
  public abstract void b(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements awob
  {
    public a()
    {
      attachInterface(this, "cooperation.wadl.ipc.IWadlService");
    }
    
    public static awob a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.wadl.ipc.IWadlService");
      if ((localIInterface != null) && ((localIInterface instanceof awob))) {
        return (awob)localIInterface;
      }
      return new awob.a.a(paramIBinder);
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
        paramParcel2.writeString("cooperation.wadl.ipc.IWadlService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
        paramParcel2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b(paramParcel2, paramParcel1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
        a(awoc.a.a(paramParcel1.readStrongBinder()));
        return true;
      }
      paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
      b(awoc.a.a(paramParcel1.readStrongBinder()));
      return true;
    }
    
    static class a
      implements awob
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(awoc paramawoc)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("cooperation.wadl.ipc.IWadlService");
          if (paramawoc != null) {
            localIBinder = paramawoc.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void b(awoc paramawoc)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("cooperation.wadl.ipc.IWadlService");
          if (paramawoc != null) {
            localIBinder = paramawoc.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void b(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 30
        //   7: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_3
        //   11: aload_1
        //   12: invokevirtual 58	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   15: aload_2
        //   16: ifnull +33 -> 49
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 62	android/os/Parcel:writeInt	(I)V
        //   24: aload_2
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 68	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_0
        //   31: getfield 18	awob$a$a:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_3
        //   36: aconst_null
        //   37: iconst_1
        //   38: invokeinterface 49 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 52	android/os/Parcel:recycle	()V
        //   48: return
        //   49: aload_3
        //   50: iconst_0
        //   51: invokevirtual 62	android/os/Parcel:writeInt	(I)V
        //   54: goto -24 -> 30
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 52	android/os/Parcel:recycle	()V
        //   62: aload_1
        //   63: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	64	0	this	a
        //   0	64	1	paramString	String
        //   0	64	2	paramBundle	Bundle
        //   3	56	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	15	57	finally
        //   19	30	57	finally
        //   30	44	57	finally
        //   49	54	57	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awob
 * JD-Core Version:    0.7.0.1
 */