import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.telephony.SubscriptionInfo;

public abstract class x
  extends Binder
  implements w
{
  public static w a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.internal.telephony.ISub");
    if ((localIInterface != null) && ((localIInterface instanceof w))) {
      return (w)localIInterface;
    }
    return new y(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.internal.telephony.ISub");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = b(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = b(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = c(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = b(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = f();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      c(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      a();
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
      paramInt1 = c(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.android.internal.telephony.ISub");
    boolean bool = a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    paramInt1 = i;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     x
 * JD-Core Version:    0.7.0.1
 */