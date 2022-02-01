package com.tencent.token;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.wcdb.CursorWindow;

public abstract class ahf
  extends Binder
  implements ahm
{
  public static ahm a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    ahm localahm = (ahm)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
    if (localahm != null) {
      return localahm;
    }
    return new ahg(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      break;
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
      try
      {
        paramParcel1.enforceInterface("android.content.IBulkCursor");
        b();
        paramParcel2.writeNoException();
        return true;
      }
      catch (Exception paramParcel1)
      {
        IInterface localIInterface;
        ahk.a(paramParcel2, paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = a(paramParcel1.readBundle(getClass().getClassLoader()));
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      b(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = null;
      }
      else
      {
        localIInterface = paramParcel1.queryLocalInterface("com.tencent.wcdb.IContentObserver");
        if ((localIInterface != null) && ((localIInterface instanceof ahn))) {
          paramParcel1 = (ahn)localIInterface;
        } else {
          paramParcel1 = new ahn.a.a(paramParcel1);
        }
      }
      paramInt1 = a(paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeBundle(c());
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      a();
      paramParcel2.writeNoException();
      return true;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 == null)
      {
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahf
 * JD-Core Version:    0.7.0.1
 */