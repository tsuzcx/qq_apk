import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;

public abstract interface itz
  extends IInterface
{
  public abstract Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
    throws RemoteException;
  
  public abstract void b(RecvMsg paramRecvMsg)
    throws RemoteException;
  
  public abstract void c(String paramString, int paramInt, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void d(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements itz
  {
    public a()
    {
      attachInterface(this, "com.tencent.av.service.IQQServiceCallback");
    }
    
    public static itz a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceCallback");
      if ((localIInterface != null) && ((localIInterface instanceof itz))) {
        return (itz)localIInterface;
      }
      return new itz.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Bundle localBundle = null;
      String str = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.av.service.IQQServiceCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
        paramParcel2 = str;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);
        }
        b(paramParcel2);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
        a((RecvGVideoLevelInfo[])paramParcel1.createTypedArray(RecvGVideoLevelInfo.CREATOR));
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
        a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          d(bool, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = a(str, paramInt1, paramInt2, localBundle);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceCallback");
      c(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static class a
      implements itz
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              this.mRemote.transact(5, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
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
      
      public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
          localParcel.writeTypedArray(paramArrayOfRecvGVideoLevelInfo, 0);
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
      
      /* Error */
      public void b(RecvMsg paramRecvMsg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 30
        //   7: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 91	com/tencent/av/service/RecvMsg:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	itz$a$a:mRemote	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 53 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 73	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 73	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	a
        //   0	59	1	paramRecvMsg	RecvMsg
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      public void c(String paramString, int paramInt, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void d(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.av.service.IQQServiceCallback");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itz
 * JD-Core Version:    0.7.0.1
 */