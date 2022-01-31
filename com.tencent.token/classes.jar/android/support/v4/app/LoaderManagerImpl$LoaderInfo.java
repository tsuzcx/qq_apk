package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LoaderManagerImpl$LoaderInfo
  extends MutableLiveData
  implements Loader.OnLoadCompleteListener
{
  @Nullable
  private final Bundle mArgs;
  private final int mId;
  private LifecycleOwner mLifecycleOwner;
  @NonNull
  private final Loader mLoader;
  private LoaderManagerImpl.LoaderObserver mObserver;
  private Loader mPriorLoader;
  
  LoaderManagerImpl$LoaderInfo(int paramInt, @Nullable Bundle paramBundle, @NonNull Loader paramLoader1, @Nullable Loader paramLoader2)
  {
    this.mId = paramInt;
    this.mArgs = paramBundle;
    this.mLoader = paramLoader1;
    this.mPriorLoader = paramLoader2;
    this.mLoader.registerListener(paramInt, this);
  }
  
  @MainThread
  Loader destroy(boolean paramBoolean)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Destroying: " + this);
    }
    this.mLoader.cancelLoad();
    this.mLoader.abandon();
    LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
    if (localLoaderObserver != null)
    {
      removeObserver(localLoaderObserver);
      if (paramBoolean) {
        localLoaderObserver.reset();
      }
    }
    this.mLoader.unregisterListener(this);
    if (((localLoaderObserver != null) && (!localLoaderObserver.hasDeliveredData())) || (paramBoolean))
    {
      this.mLoader.reset();
      return this.mPriorLoader;
    }
    return this.mLoader;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.mArgs);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.mLoader);
    this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mObserver != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.mObserver);
      this.mObserver.dump(paramString + "  ", paramPrintWriter);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mData=");
    paramPrintWriter.println(getLoader().dataToString(getValue()));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.println(hasActiveObservers());
  }
  
  @NonNull
  Loader getLoader()
  {
    return this.mLoader;
  }
  
  boolean isCallbackWaitingForData()
  {
    if (!hasActiveObservers()) {}
    while ((this.mObserver == null) || (this.mObserver.hasDeliveredData())) {
      return false;
    }
    return true;
  }
  
  void markForRedelivery()
  {
    LifecycleOwner localLifecycleOwner = this.mLifecycleOwner;
    LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
    if ((localLifecycleOwner != null) && (localLoaderObserver != null))
    {
      super.removeObserver(localLoaderObserver);
      observe(localLifecycleOwner, localLoaderObserver);
    }
  }
  
  protected void onActive()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Starting: " + this);
    }
    this.mLoader.startLoading();
  }
  
  protected void onInactive()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    this.mLoader.stopLoading();
  }
  
  public void onLoadComplete(@NonNull Loader paramLoader, @Nullable Object paramObject)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadComplete: " + this);
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setValue(paramObject);
      return;
    }
    if (LoaderManagerImpl.DEBUG) {
      Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
    }
    postValue(paramObject);
  }
  
  public void removeObserver(@NonNull Observer paramObserver)
  {
    super.removeObserver(paramObserver);
    this.mLifecycleOwner = null;
    this.mObserver = null;
  }
  
  @MainThread
  @NonNull
  Loader setCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks)
  {
    paramLoaderCallbacks = new LoaderManagerImpl.LoaderObserver(this.mLoader, paramLoaderCallbacks);
    observe(paramLifecycleOwner, paramLoaderCallbacks);
    if (this.mObserver != null) {
      removeObserver(this.mObserver);
    }
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mObserver = paramLoaderCallbacks;
    return this.mLoader;
  }
  
  public void setValue(Object paramObject)
  {
    super.setValue(paramObject);
    if (this.mPriorLoader != null)
    {
      this.mPriorLoader.reset();
      this.mPriorLoader = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderInfo
 * JD-Core Version:    0.7.0.1
 */