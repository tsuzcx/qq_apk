package com.tencent.shadow.proguard;

import android.os.Binder;
import android.os.Parcel;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsStatus;

public class o
  extends Binder
{
  public static final String a = o.class.getName();
  private final PluginProcessService b;
  
  public o(PluginProcessService paramPluginProcessService)
  {
    this.b = paramPluginProcessService;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return false;
    case 1598968902: 
      paramParcel2.writeString(a);
      return true;
    case 1: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.b.a(paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = paramParcel1.readString();
      try
      {
        this.b.b(paramParcel1);
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null) {}
      for (paramParcel1 = new e(paramParcel1);; paramParcel1 = null)
      {
        this.b.a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface(a);
      this.b.a();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface(a);
      paramParcel1 = this.b;
      String str = paramParcel1.e;
      boolean bool3 = paramParcel1.d;
      if (paramParcel1.c != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramParcel1.b != null) {
          bool2 = true;
        }
        paramParcel1 = new PpsStatus(str, bool3, bool1, bool2);
        paramParcel2.writeNoException();
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
    }
    paramParcel1.enforceInterface(a);
    paramParcel1 = this.b.c;
    paramParcel2.writeNoException();
    paramParcel2.writeStrongBinder(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.proguard.o
 * JD-Core Version:    0.7.0.1
 */