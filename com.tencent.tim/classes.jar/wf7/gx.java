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
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    gn localgn;
    do
    {
      return localObject;
      localgn = (gn)paramIBinder.queryLocalInterface("android.os.IServiceManager");
      localObject = localgn;
    } while (localgn != null);
    return new gy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    }
    try
    {
      paramParcel1.enforceInterface("android.os.IServiceManager");
      paramParcel2.writeStrongBinder(P(paramParcel1.readString()));
      return true;
    }
    catch (RemoteException paramParcel1) {}
    paramParcel1.enforceInterface("android.os.IServiceManager");
    paramParcel2.writeStrongBinder(Q(paramParcel1.readString()));
    return true;
    paramParcel1.enforceInterface("android.os.IServiceManager");
    paramParcel2 = paramParcel1.readString();
    IBinder localIBinder = paramParcel1.readStrongBinder();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramParcel2, localIBinder, bool);
      return true;
      paramParcel1.enforceInterface("android.os.IServiceManager");
      paramParcel2.writeStringArray(eY());
      return true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gx
 * JD-Core Version:    0.7.0.1
 */