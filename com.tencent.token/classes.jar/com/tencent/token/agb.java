package com.tencent.token;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface agb
  extends IInterface
{
  public abstract void a(boolean paramBoolean, Uri paramUri);
  
  public static abstract class a
    extends Binder
    implements agb
  {
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.wcdb.IContentObserver");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.wcdb.IContentObserver");
      boolean bool;
      if (paramParcel1.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramParcel1.readInt() != 0) {
        paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = null;
      }
      a(bool, paramParcel1);
      return true;
    }
    
    static final class a
      implements agb
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final void a(boolean paramBoolean, Uri paramUri)
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.tencent.wcdb.IContentObserver");
            if (paramBoolean)
            {
              i = 1;
              localParcel.writeInt(i);
              if (paramUri != null)
              {
                localParcel.writeInt(1);
                paramUri.writeToParcel(localParcel, 0);
              }
              else
              {
                localParcel.writeInt(0);
              }
              this.a.transact(1, localParcel, null, 1);
              return;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          int i = 0;
        }
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agb
 * JD-Core Version:    0.7.0.1
 */