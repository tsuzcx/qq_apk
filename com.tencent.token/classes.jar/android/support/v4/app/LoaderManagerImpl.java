package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  private boolean mCreatingLoader;
  @NonNull
  private final LifecycleOwner mLifecycleOwner;
  @NonNull
  private final LoaderManagerImpl.LoaderViewModel mLoaderViewModel;
  
  LoaderManagerImpl(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull ViewModelStore paramViewModelStore)
  {
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mLoaderViewModel = LoaderManagerImpl.LoaderViewModel.getInstance(paramViewModelStore);
  }
  
  @MainThread
  @NonNull
  private Loader createAndInstallLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks, @Nullable Loader paramLoader)
  {
    Loader localLoader;
    try
    {
      this.mCreatingLoader = true;
      localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if ((localLoader.getClass().isMemberClass()) && (!Modifier.isStatic(localLoader.getClass().getModifiers()))) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + localLoader);
      }
    }
    finally
    {
      this.mCreatingLoader = false;
    }
    paramBundle = new LoaderManagerImpl.LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
    if (DEBUG) {
      Log.v("LoaderManager", "  Created new loader " + paramBundle);
    }
    this.mLoaderViewModel.putLoader(paramInt, paramBundle);
    this.mCreatingLoader = false;
    return paramBundle.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }
  
  @MainThread
  public void destroyLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null)
    {
      localLoaderInfo.destroy(true);
      this.mLoaderViewModel.removeLoader(paramInt);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public Loader getLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null) {
      return localLoaderInfo.getLoader();
    }
    return null;
  }
  
  public boolean hasRunningLoaders()
  {
    return this.mLoaderViewModel.hasRunningLoaders();
  }
  
  @MainThread
  @NonNull
  public Loader initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (DEBUG) {
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo == null) {
      return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, null);
    }
    if (DEBUG) {
      Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
    }
    return localLoaderInfo.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }
  
  void markForRedelivery()
  {
    this.mLoaderViewModel.markForRedelivery();
  }
  
  @MainThread
  @NonNull
  public Loader restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    }
    LoaderManagerImpl.LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    Loader localLoader = null;
    if (localLoaderInfo != null) {
      localLoader = localLoaderInfo.destroy(false);
    }
    return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, localLoader);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mLifecycleOwner, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */