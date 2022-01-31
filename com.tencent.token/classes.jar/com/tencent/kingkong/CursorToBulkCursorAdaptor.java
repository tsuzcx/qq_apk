package com.tencent.kingkong;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;

public final class CursorToBulkCursorAdaptor
  extends BulkCursorNative
  implements IBinder.DeathRecipient
{
  private static final String TAG = "Cursor";
  private CrossProcessCursor mCursor;
  private CursorWindow mFilledWindow;
  private final Object mLock = new Object();
  private ContentObserverProxy mObserver;
  private final String mProviderName;
  
  public CursorToBulkCursorAdaptor(Cursor arg1, IContentObserver paramIContentObserver, String paramString)
  {
    if ((??? instanceof CrossProcessCursor)) {
      this.mCursor = ((CrossProcessCursor)???);
    }
    for (;;)
    {
      this.mProviderName = paramString;
      synchronized (this.mLock)
      {
        createAndRegisterObserverProxyLocked(paramIContentObserver);
        return;
        this.mCursor = new CrossProcessCursorWrapper(???);
      }
    }
  }
  
  private void closeFilledWindowLocked()
  {
    if (this.mFilledWindow != null)
    {
      this.mFilledWindow.close();
      this.mFilledWindow = null;
    }
  }
  
  private void createAndRegisterObserverProxyLocked(IContentObserver paramIContentObserver)
  {
    if (this.mObserver != null) {
      throw new IllegalStateException("an observer is already registered");
    }
    this.mObserver = new ContentObserverProxy(paramIContentObserver, this);
    this.mCursor.registerContentObserver(this.mObserver);
  }
  
  private void disposeLocked()
  {
    if (this.mCursor != null)
    {
      unregisterObserverProxyLocked();
      this.mCursor.close();
      this.mCursor = null;
    }
    closeFilledWindowLocked();
  }
  
  private void throwIfCursorIsClosed()
  {
    if (this.mCursor == null) {
      throw new StaleDataException("Attempted to access a cursor after it has been closed.");
    }
  }
  
  private void unregisterObserverProxyLocked()
  {
    if (this.mObserver != null)
    {
      this.mCursor.unregisterContentObserver(this.mObserver);
      this.mObserver.unlinkToDeath(this);
      this.mObserver = null;
    }
  }
  
  public void binderDied()
  {
    synchronized (this.mLock)
    {
      disposeLocked();
      return;
    }
  }
  
  public void close()
  {
    synchronized (this.mLock)
    {
      disposeLocked();
      return;
    }
  }
  
  public void deactivate()
  {
    synchronized (this.mLock)
    {
      if (this.mCursor != null)
      {
        unregisterObserverProxyLocked();
        this.mCursor.deactivate();
      }
      closeFilledWindowLocked();
      return;
    }
  }
  
  public BulkCursorDescriptor getBulkCursorDescriptor()
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      BulkCursorDescriptor localBulkCursorDescriptor = new BulkCursorDescriptor();
      localBulkCursorDescriptor.cursor = this;
      localBulkCursorDescriptor.columnNames = this.mCursor.getColumnNames();
      localBulkCursorDescriptor.wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
      localBulkCursorDescriptor.count = this.mCursor.getCount();
      localBulkCursorDescriptor.window = this.mCursor.getWindow();
      if (localBulkCursorDescriptor.window != null) {
        localBulkCursorDescriptor.window.acquireReference();
      }
      return localBulkCursorDescriptor;
    }
  }
  
  public Bundle getExtras()
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      Bundle localBundle = this.mCursor.getExtras();
      return localBundle;
    }
  }
  
  public CursorWindow getWindow(int paramInt)
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      if (!this.mCursor.moveToPosition(paramInt))
      {
        closeFilledWindowLocked();
        return null;
      }
      CursorWindow localCursorWindow1 = this.mCursor.getWindow();
      if (localCursorWindow1 != null)
      {
        closeFilledWindowLocked();
        if (localCursorWindow1 != null) {
          localCursorWindow1.acquireReference();
        }
        return localCursorWindow1;
      }
    }
    CursorWindow localCursorWindow2 = this.mFilledWindow;
    Object localObject2;
    if (localCursorWindow2 == null)
    {
      this.mFilledWindow = new CursorWindow(this.mProviderName);
      localObject2 = this.mFilledWindow;
    }
    for (;;)
    {
      this.mCursor.fillWindow(paramInt, (CursorWindow)localObject2);
      break;
      if (paramInt >= localCursorWindow2.getStartPosition())
      {
        localObject2 = localCursorWindow2;
        if (paramInt < localCursorWindow2.getStartPosition() + localCursorWindow2.getNumRows()) {}
      }
      else
      {
        localCursorWindow2.clear();
        localObject2 = localCursorWindow2;
      }
    }
  }
  
  public void onMove(int paramInt)
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      this.mCursor.onMove(this.mCursor.getPosition(), paramInt);
      return;
    }
  }
  
  public int requery(IContentObserver paramIContentObserver)
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      closeFilledWindowLocked();
      try
      {
        boolean bool = this.mCursor.requery();
        if (!bool) {
          return -1;
        }
      }
      catch (IllegalStateException paramIContentObserver)
      {
        throw new IllegalStateException(this.mProviderName + " Requery misuse db, mCursor isClosed:" + this.mCursor.isClosed(), paramIContentObserver);
      }
    }
    unregisterObserverProxyLocked();
    createAndRegisterObserverProxyLocked(paramIContentObserver);
    int i = this.mCursor.getCount();
    return i;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    synchronized (this.mLock)
    {
      throwIfCursorIsClosed();
      paramBundle = this.mCursor.respond(paramBundle);
      return paramBundle;
    }
  }
  
  private static final class ContentObserverProxy
    extends ContentObserver
  {
    protected IContentObserver mRemote;
    
    public ContentObserverProxy(IContentObserver paramIContentObserver, IBinder.DeathRecipient paramDeathRecipient)
    {
      super();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.CursorToBulkCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */