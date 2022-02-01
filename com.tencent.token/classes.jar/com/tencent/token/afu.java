package com.tencent.token;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.wcdb.CursorWindow;

public abstract class afu
  extends Binder
  implements agb
{
  public static agb a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    agb localagb = (agb)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
    if (localagb != null) {
      return localagb;
    }
    return new afv(paramIBinder);
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
        afz.a(paramParcel2, paramParcel1);
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
        if ((localIInterface != null) && ((localIInterface instanceof agc))) {
          paramParcel1 = (agc)localIInterface;
        } else {
          paramParcel1 = new agc.a.a(paramParcel1);
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
 * Qualified Name:     com.tencent.token.afu
 * JD-Core Version:    0.7.0.1
 */