package com.tencent.token;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.turingfd.sdk.qps.Tangerine;

public abstract interface agf
  extends IInterface
{
  public abstract int a();
  
  public abstract Tangerine b();
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract int e();
  
  public static abstract class a
    extends Binder
    implements agf
  {
    public static final String a = afz.a(afz.aN);
    
    public static final class a
      implements agf
    {
      public IBinder a;
      
      public a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final int a()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(agf.a.a);
          localParcel1.writeInt(2000);
          if (!this.a.transact(1, localParcel1, localParcel2, 0)) {
            String str = agf.a.a;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final Tangerine b()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(agf.a.a);
          localParcel1.writeInt(2000);
          Object localObject1;
          if (!this.a.transact(2, localParcel1, localParcel2, 0)) {
            localObject1 = agf.a.a;
          }
          localParcel2.readException();
          if (localParcel2.readInt() != 0) {
            localObject1 = new Tangerine(localParcel2);
          } else {
            localObject1 = null;
          }
          return localObject1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final boolean c()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(agf.a.a);
          localParcel1.writeInt(2000);
          Object localObject1 = this.a;
          boolean bool = false;
          if (!((IBinder)localObject1).transact(3, localParcel1, localParcel2, 0)) {
            localObject1 = agf.a.a;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final int d()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(agf.a.a);
          localParcel1.writeInt(2000);
          if (!this.a.transact(7, localParcel1, localParcel2, 0)) {
            String str = agf.a.a;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final int e()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(agf.a.a);
          if (!this.a.transact(12, localParcel1, localParcel2, 0)) {
            String str = agf.a.a;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agf
 * JD-Core Version:    0.7.0.1
 */