import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.android.internal.telephony.SmsRawData;
import java.util.ArrayList;
import java.util.List;

public abstract interface s
  extends IInterface
{
  public abstract void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, List<String> paramList, List<PendingIntent> paramList1, List<PendingIntent> paramList2)
    throws RemoteException;
  
  public abstract boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws RemoteException;
  
  public abstract boolean b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract List<SmsRawData> h()
    throws RemoteException;
  
  public abstract boolean o(int paramInt)
    throws RemoteException;
  
  public abstract boolean p(int paramInt)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements s
  {
    public static s a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.internal.telephony.ISms");
      if ((localIInterface != null) && ((localIInterface instanceof s))) {
        return (s)localIInterface;
      }
      return new s.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject = null;
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      String str1;
      String str2;
      PendingIntent localPendingIntent;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.android.internal.telephony.ISms");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        paramParcel1 = h();
        paramParcel2.writeNoException();
        paramParcel2.writeTypedList(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        bool = b(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        bool = a(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        byte[] arrayOfByte = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {}
        for (localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
          }
          a(str1, str2, paramInt1, arrayOfByte, localPendingIntent, (PendingIntent)localObject);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        localObject = paramParcel1.readString();
        str1 = paramParcel1.readString();
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label418;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a((String)localObject, str1, str2, localPendingIntent, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localPendingIntent = null;
          break;
        }
      case 6: 
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.createTypedArrayList(PendingIntent.CREATOR), paramParcel1.createTypedArrayList(PendingIntent.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        label418:
        paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
        bool = o(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      boolean bool = p(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static class a
      implements s
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeInt(paramInt);
            localParcel1.writeByteArray(paramArrayOfByte);
            if (paramPendingIntent1 != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent1.writeToParcel(localParcel1, 0);
              if (paramPendingIntent2 != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent2.writeToParcel(localParcel1, 0);
                this.mRemote.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            localParcel1.writeString(paramString3);
            if (paramPendingIntent1 != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent1.writeToParcel(localParcel1, 0);
              if (paramPendingIntent2 != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent2.writeToParcel(localParcel1, 0);
                this.mRemote.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(String paramString1, String paramString2, List<String> paramList, List<PendingIntent> paramList1, List<PendingIntent> paramList2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeStringList(paramList);
          localParcel1.writeTypedList(paramList1);
          localParcel1.writeTypedList(paramList2);
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
      
      public boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          localParcel1.writeInt(paramInt);
          localParcel1.writeByteArray(paramArrayOfByte1);
          localParcel1.writeByteArray(paramArrayOfByte2);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public boolean b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          if (paramInt1 != 0) {
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
      
      public List<SmsRawData> h()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.createTypedArrayList(SmsRawData.CREATOR);
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean o(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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
      
      public boolean p(int paramInt)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.android.internal.telephony.ISms");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt != 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     s
 * JD-Core Version:    0.7.0.1
 */