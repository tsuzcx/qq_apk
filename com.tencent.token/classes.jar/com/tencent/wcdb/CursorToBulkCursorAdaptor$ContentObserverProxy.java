package com.tencent.wcdb;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;

final class CursorToBulkCursorAdaptor$ContentObserverProxy
  extends ContentObserver
{
  protected IContentObserver mRemote;
  
  public CursorToBulkCursorAdaptor$ContentObserverProxy(IContentObserver paramIContentObserver, IBinder.DeathRecipient paramDeathRecipient)
  {
    super(null);
    this.mRemote = paramIContentObserver;
    try
    {
      paramIContentObserver.asBinder().linkToDeath(paramDeathRecipient, 0);
      return;
    }
    catch (RemoteException paramIContentObserver) {}
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    try
    {
      this.mRemote.onChange(paramBoolean, paramUri);
      return;
    }
    catch (RemoteException paramUri) {}
  }
  
  public boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient)
  {
    return this.mRemote.asBinder().unlinkToDeath(paramDeathRecipient, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.CursorToBulkCursorAdaptor.ContentObserverProxy
 * JD-Core Version:    0.7.0.1
 */