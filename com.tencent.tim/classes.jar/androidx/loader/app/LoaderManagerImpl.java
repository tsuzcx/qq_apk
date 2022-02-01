package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import androidx.loader.content.Loader.OnLoadCompleteListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  @NonNull
  private final LifecycleOwner mLifecycleOwner;
  @NonNull
  private final LoaderViewModel mLoaderViewModel;
  
  LoaderManagerImpl(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull ViewModelStore paramViewModelStore)
  {
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mLoaderViewModel = LoaderViewModel.getInstance(paramViewModelStore);
  }
  
  @MainThread
  @NonNull
  private <D> Loader<D> createAndInstallLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks, @Nullable Loader<D> paramLoader)
  {
    Loader localLoader;
    try
    {
      this.mLoaderViewModel.startCreatingLoader();
      localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (localLoader == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.mLoaderViewModel.finishCreatingLoader();
    }
    if ((localLoader.getClass().isMemberClass()) && (!Modifier.isStatic(localLoader.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + localLoader);
    }
    paramBundle = new LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
    if (DEBUG) {
      Log.v("LoaderManager", "  Created new loader " + paramBundle);
    }
    this.mLoaderViewModel.putLoader(paramInt, paramBundle);
    this.mLoaderViewModel.finishCreatingLoader();
    return paramBundle.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }
  
  @MainThread
  public void destroyLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    }
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null)
    {
      localLoaderInfo.destroy(true);
      this.mLoaderViewModel.removeLoader(paramInt);
    }
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
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
  public <D> Loader<D> initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
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
  
  public void markForRedelivery()
  {
    this.mLoaderViewModel.markForRedelivery();
  }
  
  @MainThread
  @NonNull
  public <D> Loader<D> restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader()) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    }
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
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
  
  public static class LoaderInfo<D>
    extends MutableLiveData<D>
    implements Loader.OnLoadCompleteListener<D>
  {
    @Nullable
    private final Bundle mArgs;
    private final int mId;
    private LifecycleOwner mLifecycleOwner;
    @NonNull
    private final Loader<D> mLoader;
    private LoaderManagerImpl.LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;
    
    LoaderInfo(int paramInt, @Nullable Bundle paramBundle, @NonNull Loader<D> paramLoader1, @Nullable Loader<D> paramLoader2)
    {
      this.mId = paramInt;
      this.mArgs = paramBundle;
      this.mLoader = paramLoader1;
      this.mPriorLoader = paramLoader2;
      this.mLoader.registerListener(paramInt, this);
    }
    
    @MainThread
    Loader<D> destroy(boolean paramBoolean)
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
    Loader<D> getLoader()
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
    
    public void onActive()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Starting: " + this);
      }
      this.mLoader.startLoading();
    }
    
    public void onInactive()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Stopping: " + this);
      }
      this.mLoader.stopLoading();
    }
    
    public void onLoadComplete(@NonNull Loader<D> paramLoader, @Nullable D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "onLoadComplete: " + this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        return;
      }
      if (LoaderManagerImpl.DEBUG) {
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
      }
      postValue(paramD);
    }
    
    public void removeObserver(@NonNull Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.mLifecycleOwner = null;
      this.mObserver = null;
    }
    
    @MainThread
    @NonNull
    Loader<D> setCallback(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
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
    
    public void setValue(D paramD)
    {
      super.setValue(paramD);
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
  
  static class LoaderObserver<D>
    implements Observer<D>
  {
    @NonNull
    private final LoaderManager.LoaderCallbacks<D> mCallback;
    private boolean mDeliveredData = false;
    @NonNull
    private final Loader<D> mLoader;
    
    LoaderObserver(@NonNull Loader<D> paramLoader, @NonNull LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
    {
      this.mLoader = paramLoader;
      this.mCallback = paramLoaderCallbacks;
    }
    
    public void dump(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mDeliveredData=");
      paramPrintWriter.println(this.mDeliveredData);
    }
    
    boolean hasDeliveredData()
    {
      return this.mDeliveredData;
    }
    
    public void onChanged(@Nullable D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(paramD));
      }
      this.mCallback.onLoadFinished(this.mLoader, paramD);
      this.mDeliveredData = true;
    }
    
    @MainThread
    void reset()
    {
      if (this.mDeliveredData)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Resetting: " + this.mLoader);
        }
        this.mCallback.onLoaderReset(this.mLoader);
      }
    }
    
    public String toString()
    {
      return this.mCallback.toString();
    }
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory FACTORY = new LoaderManagerImpl.LoaderViewModel.1();
    private boolean mCreatingLoader = false;
    private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();
    
    @NonNull
    static LoaderViewModel getInstance(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, FACTORY).get(LoaderViewModel.class);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      if (this.mLoaders.size() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        String str = paramString + "    ";
        int i = 0;
        while (i < this.mLoaders.size())
        {
          LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.mLoaders.keyAt(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localLoaderInfo.toString());
          localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    
    void finishCreatingLoader()
    {
      this.mCreatingLoader = false;
    }
    
    <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int paramInt)
    {
      return (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    }
    
    boolean hasRunningLoaders()
    {
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).isCallbackWaitingForData()) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    boolean isCreatingLoader()
    {
      return this.mCreatingLoader;
    }
    
    void markForRedelivery()
    {
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).markForRedelivery();
        i += 1;
      }
    }
    
    public void onCleared()
    {
      super.onCleared();
      int j = this.mLoaders.size();
      int i = 0;
      while (i < j)
      {
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i)).destroy(true);
        i += 1;
      }
      this.mLoaders.clear();
    }
    
    void putLoader(int paramInt, @NonNull LoaderManagerImpl.LoaderInfo paramLoaderInfo)
    {
      this.mLoaders.put(paramInt, paramLoaderInfo);
    }
    
    void removeLoader(int paramInt)
    {
      this.mLoaders.remove(paramInt);
    }
    
    void startCreatingLoader()
    {
      this.mCreatingLoader = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.loader.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */