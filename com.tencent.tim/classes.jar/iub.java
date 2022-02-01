import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;

public abstract interface iub
  extends IInterface
{
  public abstract void a(boolean paramBoolean, LBSInfo paramLBSInfo)
    throws RemoteException;
  
  public abstract void ae(int paramInt, String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements iub
  {
    public static iub a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceLocationCallback");
      if ((localIInterface != null) && ((localIInterface instanceof iub))) {
        return (iub)localIInterface;
      }
      return new iub.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IQQServiceLocationCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceLocationCallback");
        ae(paramParcel1.readInt(), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceLocationCallback");
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label125;
        }
      }
      label125:
      for (paramParcel1 = (LBSInfo)LBSInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        return true;
        bool = false;
        break;
      }
    }
    
    static class a
      implements iub
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public void a(boolean paramBoolean, LBSInfo paramLBSInfo)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: aload 4
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: iload_1
        //   15: ifeq +47 -> 62
        //   18: aload 4
        //   20: iload_3
        //   21: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   24: aload_2
        //   25: ifnull +42 -> 67
        //   28: aload 4
        //   30: iconst_1
        //   31: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   34: aload_2
        //   35: aload 4
        //   37: iconst_0
        //   38: invokevirtual 44	com/tencent/av/service/LBSInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   41: aload_0
        //   42: getfield 18	iub$a$a:mRemote	Landroid/os/IBinder;
        //   45: iconst_2
        //   46: aload 4
        //   48: aconst_null
        //   49: iconst_1
        //   50: invokeinterface 50 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 53	android/os/Parcel:recycle	()V
        //   61: return
        //   62: iconst_0
        //   63: istore_3
        //   64: goto -46 -> 18
        //   67: aload 4
        //   69: iconst_0
        //   70: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   73: goto -32 -> 41
        //   76: astore_2
        //   77: aload 4
        //   79: invokevirtual 53	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramBoolean	boolean
        //   0	84	2	paramLBSInfo	LBSInfo
        //   1	63	3	i	int
        //   5	73	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   7	14	76	finally
        //   18	24	76	finally
        //   28	41	76	finally
        //   41	56	76	finally
        //   67	73	76	finally
      }
      
      public void ae(int paramInt, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceLocationCallback");
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString);
          this.mRemote.transact(1, localParcel, null, 1);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iub
 * JD-Core Version:    0.7.0.1
 */