package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IResultReceiver$Stub
  extends Binder
  implements IResultReceiver
{
  private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
  static final int TRANSACTION_send = 1;
  
  public IResultReceiver$Stub()
  {
    attachInterface(this, "android.support.v4.os.IResultReceiver");
  }
  
  public static IResultReceiver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
    if ((localIInterface != null) && ((localIInterface instanceof IResultReceiver))) {
      return (IResultReceiver)localIInterface;
    }
    return new IResultReceiver.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("android.support.v4.os.IResultReceiver");
      return true;
    }
    paramParcel1.enforceInterface("android.support.v4.os.IResultReceiver");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      send(paramInt1, paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.IResultReceiver.Stub
 * JD-Core Version:    0.7.0.1
 */