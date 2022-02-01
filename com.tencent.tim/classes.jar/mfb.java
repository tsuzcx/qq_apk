import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface mfb
  extends IInterface
{
  public abstract void lJ(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements mfb
  {
    public a()
    {
      attachInterface(this, "com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
    }
    
    public static mfb a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
      if ((localIInterface != null) && ((localIInterface instanceof mfb))) {
        return (mfb)localIInterface;
      }
      return new mfb.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.biz.pubaccount.readinjoy.service.redpacket.IShouldDoTaskTimingCallback");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        lJ(bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class a
      implements mfb
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
      public void lJ(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 33
        //   14: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +38 -> 56
        //   21: aload_3
        //   22: iload_2
        //   23: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   26: aload_0
        //   27: getfield 18	mfb$a$a:mRemote	Landroid/os/IBinder;
        //   30: iconst_1
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 47 5 0
        //   40: pop
        //   41: aload 4
        //   43: invokevirtual 50	android/os/Parcel:readException	()V
        //   46: aload 4
        //   48: invokevirtual 53	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 53	android/os/Parcel:recycle	()V
        //   55: return
        //   56: iconst_0
        //   57: istore_2
        //   58: goto -37 -> 21
        //   61: astore 5
        //   63: aload 4
        //   65: invokevirtual 53	android/os/Parcel:recycle	()V
        //   68: aload_3
        //   69: invokevirtual 53	android/os/Parcel:recycle	()V
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfb
 * JD-Core Version:    0.7.0.1
 */