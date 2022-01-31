import android.os.IBinder;
import com.tencent.av.service.IQQServiceCallback;

public class bik
  implements IQQServiceCallback
{
  private IBinder a;
  
  public bik(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.av.service.IQQServiceCallback";
  }
  
  /* Error */
  public void a(com.tencent.av.service.RecvMsg paramRecvMsg)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 19
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 34	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 40	com/tencent/av/service/RecvMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 15	bik:a	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 46 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 49	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 34	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 49	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bik
    //   0	59	1	paramRecvMsg	com.tencent.av.service.RecvMsg
    //   3	51	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bik
 * JD-Core Version:    0.7.0.1
 */