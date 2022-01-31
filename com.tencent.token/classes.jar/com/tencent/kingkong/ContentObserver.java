package com.tencent.kingkong;

import android.net.Uri;
import android.os.Handler;

public abstract class ContentObserver
  extends android.database.ContentObserver
{
  Handler mHandler;
  private final Object mLock = new Object();
  private Transport mTransport;
  
  public ContentObserver(Handler paramHandler)
  {
    super(paramHandler);
    this.mHandler = paramHandler;
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void dispatchChanges(boolean paramBoolean, Uri paramUri)
  {
    if (this.mHandler == null)
    {
      onChange(paramBoolean, paramUri);
      return;
    }
    this.mHandler.post(new NotificationRunnable(paramBoolean, paramUri));
  }
  
  public IContentObserver getContentObserver()
  {
    synchronized (this.mLock)
    {
      if (this.mTransport == null) {
        this.mTransport = new Transport(this);
      }
      Transport localTransport = this.mTransport;
      return localTransport;
    }
  }
  
  public void onChange(boolean paramBoolean) {}
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    onChange(paramBoolean);
  }
  
  public IContentObserver releaseContentObserver()
  {
    synchronized (this.mLock)
    {
      Transport localTransport = this.mTransport;
      if (localTransport != null)
      {
        localTransport.releaseContentObserver();
        this.mTransport = null;
      }
      return localTransport;
    }
  }
  
  private final class NotificationRunnable
    implements Runnable
  {
    private final boolean mSelfChange;
    private final Uri mUri;
    
    public NotificationRunnable(boolean paramBoolean, Uri paramUri)
    {
      this.mSelfChange = paramBoolean;
      this.mUri = paramUri;
    }
    
    public void run()
    {
      ContentObserver.this.onChange(this.mSelfChange, this.mUri);
    }
  }
  
  private static final class Transport
    extends IContentObserver.Stub
  {
    private ContentObserver mContentObserver;
    
    public Transport(ContentObserver paramContentObserver)
    {
      this.mContentObserver = paramContentObserver;
    }
    
    public void onChange(boolean paramBoolean, Uri paramUri)
    {
      ContentObserver localContentObserver = this.mContentObserver;
      if (localContentObserver != null) {
        localContentObserver.dispatchChanges(paramBoolean, paramUri);
      }
    }
    
    public void releaseContentObserver()
    {
      this.mContentObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.ContentObserver
 * JD-Core Version:    0.7.0.1
 */