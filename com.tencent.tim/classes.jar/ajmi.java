import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.mobileqq.music.SongInfo;

public abstract interface ajmi
  extends IInterface
{
  public abstract void onPlaySongChanged(SongInfo paramSongInfo)
    throws RemoteException;
  
  public abstract void onPlayStateChanged(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ajmi
  {
    private static final String DESCRIPTOR = "com.tencent.mobileqq.music.IQQPlayerCallback";
    static final int TRANSACTION_onPlaySongChanged = 2;
    static final int TRANSACTION_onPlayStateChanged = 1;
    
    public a()
    {
      attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerCallback");
    }
    
    public static ajmi asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
      if ((localIInterface != null) && ((localIInterface instanceof ajmi))) {
        return (ajmi)localIInterface;
      }
      return new ajmi.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mobileqq.music.IQQPlayerCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
        onPlayStateChanged(paramParcel1.readInt());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (SongInfo)SongInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onPlaySongChanged(paramParcel1);
        return true;
      }
    }
    
    static class a
      implements ajmi
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
      public void onPlaySongChanged(SongInfo paramSongInfo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 47	com/tencent/mobileqq/music/SongInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	ajmi$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 53 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 56	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 56	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramSongInfo	SongInfo
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      public void onPlayStateChanged(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mobileqq.music.IQQPlayerCallback");
          localParcel.writeInt(paramInt);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmi
 * JD-Core Version:    0.7.0.1
 */