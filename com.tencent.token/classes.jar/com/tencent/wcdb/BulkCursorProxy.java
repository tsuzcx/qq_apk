package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class BulkCursorProxy
  implements IBulkCursor
{
  private Bundle mExtras;
  private IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
    this.mExtras = null;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void close()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public void deactivate()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public Bundle getExtras()
  {
    if (this.mExtras == null)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("android.content.IBulkCursor");
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        DatabaseUtils.readExceptionFromParcel(localParcel2);
        this.mExtras = localParcel2.readBundle(getClass().getClassLoader());
        localParcel1.recycle();
        localParcel2.recycle();
      }
      finally
      {
        localParcel1.recycle();
        localParcel2.recycle();
      }
    }
    return this.mExtras;
  }
  
  public CursorWindow getWindow(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      CursorWindow localCursorWindow = null;
      if (localParcel2.readInt() == 1) {
        localCursorWindow = CursorWindow.newFromParcel(localParcel2);
      }
      return localCursorWindow;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public void onMove(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public int requery(IContentObserver paramIContentObserver)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeStrongInterface(paramIContentObserver);
      boolean bool = this.mRemote.transact(3, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      int i;
      if (!bool)
      {
        i = -1;
      }
      else
      {
        i = localParcel2.readInt();
        this.mExtras = localParcel2.readBundle(getClass().getClassLoader());
      }
      return i;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeBundle(paramBundle);
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      paramBundle = localParcel2.readBundle(getClass().getClassLoader());
      return paramBundle;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorProxy
 * JD-Core Version:    0.7.0.1
 */