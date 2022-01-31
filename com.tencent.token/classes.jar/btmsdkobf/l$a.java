package btmsdkobf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class l$a
  extends Binder
  implements l
{
  public static l b(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
    if ((localIInterface != null) && ((localIInterface instanceof l))) {
      return (l)localIInterface;
    }
    return new jd(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
      paramParcel1 = g();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
      paramParcel1 = k();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
      bool = l();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
      paramParcel1 = e(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
      paramParcel1 = f(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
    boolean bool = g(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramInt1 = j;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.l.a
 * JD-Core Version:    0.7.0.1
 */