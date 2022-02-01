import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface mfa
  extends IInterface
{
  public abstract void o(boolean paramBoolean, String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements mfa
  {
    public a()
    {
      attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
    }
    
    public static mfa a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
      if ((localIInterface != null) && ((localIInterface instanceof mfa))) {
        return (mfa)localIInterface;
      }
      return new mfa.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IReportTaskProgressCallback");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        o(bool, paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class a
      implements mfa
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public void o(boolean paramBoolean, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 33
        //   16: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: iload_1
        //   20: ifeq +47 -> 67
        //   23: aload 4
        //   25: iload_3
        //   26: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   29: aload 4
        //   31: aload_2
        //   32: invokevirtual 44	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   35: aload_0
        //   36: getfield 18	mfa$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_1
        //   40: aload 4
        //   42: aload 5
        //   44: iconst_0
        //   45: invokeinterface 50 5 0
        //   50: pop
        //   51: aload 5
        //   53: invokevirtual 53	android/os/Parcel:readException	()V
        //   56: aload 5
        //   58: invokevirtual 56	android/os/Parcel:recycle	()V
        //   61: aload 4
        //   63: invokevirtual 56	android/os/Parcel:recycle	()V
        //   66: return
        //   67: iconst_0
        //   68: istore_3
        //   69: goto -46 -> 23
        //   72: astore_2
        //   73: aload 5
        //   75: invokevirtual 56	android/os/Parcel:recycle	()V
        //   78: aload 4
        //   80: invokevirtual 56	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	a
        //   0	85	1	paramBoolean	boolean
        //   0	85	2	paramString	String
        //   1	68	3	i	int
        //   5	74	4	localParcel1	Parcel
        //   10	64	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   12	19	72	finally
        //   23	56	72	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfa
 * JD-Core Version:    0.7.0.1
 */