package wf7;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class gx
  extends Binder
  implements gn
{
  public static gn a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    gn localgn = (gn)paramIBinder.queryLocalInterface("android.os.IServiceManager");
    if (localgn != null) {
      return localgn;
    }
    return new gy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          if (paramInt1 != 4) {
            return false;
          }
        }
      }
    }
    try
    {
      paramParcel1.enforceInterface("android.os.IServiceManager");
      paramParcel2.writeStringArray(eY());
      return true;
    }
    catch (RemoteException paramParcel1)
    {
      IBinder localIBinder;
      return false;
    }
    paramParcel1.enforceInterface("android.os.IServiceManager");
    paramParcel2 = paramParcel1.readString();
    localIBinder = paramParcel1.readStrongBinder();
    boolean bool;
    if (paramParcel1.readInt() != 0) {
      bool = true;
    }
    for (;;)
    {
      a(paramParcel2, localIBinder, bool);
      return true;
      paramParcel1.enforceInterface("android.os.IServiceManager");
      paramParcel2.writeStrongBinder(Q(paramParcel1.readString()));
      return true;
      paramParcel1.enforceInterface("android.os.IServiceManager");
      paramParcel2.writeStrongBinder(P(paramParcel1.readString()));
      return true;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gx
 * JD-Core Version:    0.7.0.1
 */