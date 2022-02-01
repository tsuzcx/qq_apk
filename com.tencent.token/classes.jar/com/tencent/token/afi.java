package com.tencent.token;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.turingfd.sdk.qps.Sorgo;

public abstract interface afi
  extends IInterface
{
  public abstract int a();
  
  public abstract Sorgo b();
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract int e();
  
  public static abstract class a
    extends Binder
    implements afi
  {
    public static final String a = agg.a(agg.aN);
    
    public static final class a
      implements afi
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
          localParcel1.writeInterfaceToken(afi.a.a);
          localParcel1.writeInt(2000);
          if (!this.a.transact(1, localParcel1, localParcel2, 0)) {
            String str = afi.a.a;
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
      
      public final Sorgo b()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken(afi.a.a);
          localParcel1.writeInt(2000);
          Object localObject1;
          if (!this.a.transact(2, localParcel1, localParcel2, 0)) {
            localObject1 = afi.a.a;
          }
          localParcel2.readException();
          if (localParcel2.readInt() != 0) {
            localObject1 = new Sorgo(localParcel2);
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
          localParcel1.writeInterfaceToken(afi.a.a);
          localParcel1.writeInt(2000);
          Object localObject1 = this.a;
          boolean bool = false;
          if (!((IBinder)localObject1).transact(3, localParcel1, localParcel2, 0)) {
            localObject1 = afi.a.a;
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
          localParcel1.writeInterfaceToken(afi.a.a);
          localParcel1.writeInt(2000);
          if (!this.a.transact(7, localParcel1, localParcel2, 0)) {
            String str = afi.a.a;
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
          localParcel1.writeInterfaceToken(afi.a.a);
          if (!this.a.transact(12, localParcel1, localParcel2, 0)) {
            String str = afi.a.a;
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
 * Qualified Name:     com.tencent.token.afi
 * JD-Core Version:    0.7.0.1
 */