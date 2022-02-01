import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.av.service.AVRedPacketConfig;

public abstract interface itw
  extends IInterface
{
  public abstract void a(boolean paramBoolean, AVRedPacketConfig paramAVRedPacketConfig)
    throws RemoteException;
  
  public abstract void d(boolean paramBoolean, String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements itw
  {
    public static itw a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVRedPacketCallback");
      if ((localIInterface != null) && ((localIInterface instanceof itw))) {
        return (itw)localIInterface;
      }
      return new itw.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IAVRedPacketCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label109;
          }
        }
        label109:
        for (paramParcel1 = (AVRedPacketConfig)AVRedPacketConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a(bool, paramParcel1);
          return true;
          bool = false;
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      d(bool, paramParcel1.readString(), paramParcel1.readString());
      return true;
    }
    
    static class a
      implements itw
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public void a(boolean paramBoolean, AVRedPacketConfig paramAVRedPacketConfig)
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
        //   38: invokevirtual 44	com/tencent/av/service/AVRedPacketConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   41: aload_0
        //   42: getfield 18	itw$a$a:mRemote	Landroid/os/IBinder;
        //   45: iconst_1
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
        //   0	84	2	paramAVRedPacketConfig	AVRedPacketConfig
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public void d(boolean paramBoolean, String paramString1, String paramString2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: aload 5
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: iload_1
        //   16: ifeq +43 -> 59
        //   19: aload 5
        //   21: iload 4
        //   23: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   26: aload 5
        //   28: aload_2
        //   29: invokevirtual 61	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   32: aload 5
        //   34: aload_3
        //   35: invokevirtual 61	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 18	itw$a$a:mRemote	Landroid/os/IBinder;
        //   42: iconst_2
        //   43: aload 5
        //   45: aconst_null
        //   46: iconst_1
        //   47: invokeinterface 50 5 0
        //   52: pop
        //   53: aload 5
        //   55: invokevirtual 53	android/os/Parcel:recycle	()V
        //   58: return
        //   59: iconst_0
        //   60: istore 4
        //   62: goto -43 -> 19
        //   65: astore_2
        //   66: aload 5
        //   68: invokevirtual 53	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	a
        //   0	73	1	paramBoolean	boolean
        //   0	73	2	paramString1	String
        //   0	73	3	paramString2	String
        //   1	60	4	i	int
        //   6	61	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	15	65	finally
        //   19	53	65	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itw
 * JD-Core Version:    0.7.0.1
 */