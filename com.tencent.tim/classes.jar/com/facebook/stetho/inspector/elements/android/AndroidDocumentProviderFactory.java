package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.HandlerUtil;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;

public final class AndroidDocumentProviderFactory
  implements ThreadBound, DocumentProviderFactory
{
  private final Application mApplication;
  private final Handler mHandler;
  
  public AndroidDocumentProviderFactory(Application paramApplication)
  {
    this.mApplication = ((Application)Util.throwIfNull(paramApplication));
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean checkThreadAccess()
  {
    return HandlerUtil.checkThreadAccess(this.mHandler);
  }
  
  public DocumentProvider create()
  {
    return new AndroidDocumentProvider(this.mApplication, this);
  }
  
  public <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable)
  {
    return HandlerUtil.postAndWait(this.mHandler, paramUncheckedCallable);
  }
  
  public void postAndWait(Runnable paramRunnable)
  {
    HandlerUtil.postAndWait(this.mHandler, paramRunnable);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (!this.mHandler.postDelayed(paramRunnable, paramLong)) {
      throw new RuntimeException("Handler.postDelayed() returned false");
    }
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    this.mHandler.removeCallbacks(paramRunnable);
  }
  
  public void verifyThreadAccess()
  {
    HandlerUtil.verifyThreadAccess(this.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.AndroidDocumentProviderFactory
 * JD-Core Version:    0.7.0.1
 */