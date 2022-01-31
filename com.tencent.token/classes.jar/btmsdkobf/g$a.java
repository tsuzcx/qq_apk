package btmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class g$a
  extends Binder
  implements g
{
  public static g a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
    if ((localIInterface != null) && ((localIInterface instanceof g))) {
      return (g)localIInterface;
    }
    return new jb(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
      paramParcel1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
    boolean bool = d();
    paramParcel2.writeNoException();
    if (bool) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.g.a
 * JD-Core Version:    0.7.0.1
 */