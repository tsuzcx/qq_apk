package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  FragmentActivity mActivity;
  boolean mCreatingLoader;
  final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.mWho = paramString;
    this.mActivity = paramFragmentActivity;
    this.mStarted = paramBoolean;
  }
  
  private LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.mCreatingLoader = true;
      paramBundle = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(paramBundle);
      return paramBundle;
    }
    finally
    {
      this.mCreatingLoader = false;
    }
  }
  
  private LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderInfo localLoaderInfo = new LoaderInfo(paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localLoaderInfo;
  }
  
  public void destroyLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "destroyLoader in " + this + " of " + paramInt);
    }
    int i = this.mLoaders.indexOfKey(paramInt);
    LoaderInfo localLoaderInfo;
    if (i >= 0)
    {
      localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      localLoaderInfo.destroy();
    }
    paramInt = this.mInactiveLoaders.indexOfKey(paramInt);
    if (paramInt >= 0)
    {
      localLoaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(paramInt);
      this.mInactiveLoaders.removeAt(paramInt);
      localLoaderInfo.destroy();
    }
    if ((this.mActivity != null) && (!hasRunningLoaders())) {
      this.mActivity.mFragments.startPendingDeferredFragments();
    }
  }
  
  void doDestroy()
  {
    if (!this.mRetaining)
    {
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "Destroying Active in " + this);
      }
      i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderInfo)this.mLoaders.valueAt(i)).destroy();
        i -= 1;
      }
      this.mLoaders.clear();
    }
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Destroying Inactive in " + this);
    }
    int i = this.mInactiveLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy();
      i -= 1;
    }
    this.mInactiveLoaders.clear();
  }
  
  void doReportNextStart()
  {
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true;
      i -= 1;
    }
  }
  
  void doReportStart()
  {
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
      i -= 1;
    }
  }
  
  void doRetain()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Retaining in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doRetain when not started: " + this, localRuntimeException);
      }
    }
    for (;;)
    {
      return;
      this.mRetaining = true;
      this.mStarted = false;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderInfo)this.mLoaders.valueAt(i)).retain();
        i -= 1;
      }
    }
  }
  
  void doStart()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Starting in " + this);
    }
    if (this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doStart when already started: " + this, localRuntimeException);
      }
    }
    for (;;)
    {
      return;
      this.mStarted = true;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderInfo)this.mLoaders.valueAt(i)).start();
        i -= 1;
      }
    }
  }
  
  void doStop()
  {
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "Stopping in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.w("LoaderManager", 4, "Called doStop when not started: " + this, localRuntimeException);
      }
      return;
    }
    int i = this.mLoaders.size() - 1;
    while (i >= 0)
    {
      ((LoaderInfo)this.mLoaders.valueAt(i)).stop();
      i -= 1;
    }
    this.mStarted = false;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    LoaderInfo localLoaderInfo;
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.mLoaders.size())
      {
        localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.mInactiveLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.mInactiveLoaders.size())
      {
        localLoaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "Finished Retaining in " + this);
      }
      this.mRetaining = false;
      int i = this.mLoaders.size() - 1;
      while (i >= 0)
      {
        ((LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
        i -= 1;
      }
    }
  }
  
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    if (localLoaderInfo != null)
    {
      if (localLoaderInfo.mPendingLoader != null) {
        return localLoaderInfo.mPendingLoader.mLoader;
      }
      return localLoaderInfo.mLoader;
    }
    return null;
  }
  
  public boolean hasRunningLoaders()
  {
    int j = this.mLoaders.size();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      if ((localLoaderInfo.mStarted) && (!localLoaderInfo.mDeliveredData)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "initLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo == null)
    {
      paramLoaderCallbacks = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks);
      paramBundle = paramLoaderCallbacks;
      if (DEBUG)
      {
        paramBundle = paramLoaderCallbacks;
        if (QLog.isDevelopLevel()) {
          QLog.d("LoaderManager", 4, "  Created new loader " + paramLoaderCallbacks);
        }
      }
    }
    for (paramBundle = paramLoaderCallbacks;; paramBundle = localLoaderInfo)
    {
      if ((paramBundle.mHaveData) && (this.mStarted)) {
        paramBundle.callOnLoadFinished(paramBundle.mLoader, paramBundle.mData);
      }
      return paramBundle.mLoader;
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Re-using existing loader " + localLoaderInfo);
      }
      localLoaderInfo.mCallbacks = paramLoaderCallbacks;
    }
  }
  
  void installLoader(LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted) {
      paramLoaderInfo.start();
    }
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo1 = (LoaderInfo)this.mLoaders.get(paramInt);
    if ((DEBUG) && (QLog.isDevelopLevel())) {
      QLog.d("LoaderManager", 4, "restartLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo1 != null)
    {
      LoaderInfo localLoaderInfo2 = (LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (localLoaderInfo2 == null) {
        break label339;
      }
      if (!localLoaderInfo1.mHaveData) {
        break label187;
      }
      if ((DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Removing last inactive loader: " + localLoaderInfo1);
      }
      localLoaderInfo2.mDeliveredData = false;
      localLoaderInfo2.destroy();
      localLoaderInfo1.mLoader.abandon();
      this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
    }
    for (;;)
    {
      return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks).mLoader;
      label187:
      if (!localLoaderInfo1.mStarted)
      {
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Current loader is stopped; replacing");
        }
        this.mLoaders.put(paramInt, null);
        localLoaderInfo1.destroy();
      }
      else
      {
        if (localLoaderInfo1.mPendingLoader != null)
        {
          if ((DEBUG) && (QLog.isDevelopLevel())) {
            QLog.d("LoaderManager", 4, "  Removing pending loader: " + localLoaderInfo1.mPendingLoader);
          }
          localLoaderInfo1.mPendingLoader.destroy();
          localLoaderInfo1.mPendingLoader = null;
        }
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Enqueuing as new pending loader");
        }
        localLoaderInfo1.mPendingLoader = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
        return localLoaderInfo1.mPendingLoader.mLoader;
        label339:
        if ((DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Making last loader inactive: " + localLoaderInfo1);
        }
        localLoaderInfo1.mLoader.abandon();
        this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void updateActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
  
  final class LoaderInfo
    implements Loader.OnLoadCompleteListener<Object>
  {
    final Bundle mArgs;
    LoaderManager.LoaderCallbacks<Object> mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader<Object> mLoader;
    LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    
    public LoaderInfo(Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
    {
      this.mId = paramBundle;
      this.mArgs = paramLoaderCallbacks;
      Object localObject;
      this.mCallbacks = localObject;
    }
    
    void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
    {
      String str;
      if (this.mCallbacks != null)
      {
        if (LoaderManagerImpl.this.mActivity == null) {
          break label164;
        }
        str = LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause;
        LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
      }
      for (;;)
      {
        try
        {
          if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
            QLog.d("LoaderManager", 4, "  onLoadFinished in " + paramLoader + ": " + paramLoader.dataToString(paramObject));
          }
          this.mCallbacks.onLoadFinished(paramLoader, paramObject);
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
          this.mDeliveredData = true;
          return;
        }
        finally
        {
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
        }
        label164:
        str = null;
      }
    }
    
    void destroy()
    {
      if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Destroying: " + this);
      }
      this.mDestroyed = true;
      boolean bool = this.mDeliveredData;
      this.mDeliveredData = false;
      String str;
      if ((this.mCallbacks != null) && (this.mLoader != null) && (this.mHaveData) && (bool))
      {
        if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Reseting: " + this);
        }
        if (LoaderManagerImpl.this.mActivity == null) {
          break label281;
        }
        str = LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause;
        LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
      }
      for (;;)
      {
        try
        {
          this.mCallbacks.onLoaderReset(this.mLoader);
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
          this.mCallbacks = null;
          this.mData = null;
          this.mHaveData = false;
          if (this.mLoader != null)
          {
            if (this.mListenerRegistered)
            {
              this.mListenerRegistered = false;
              this.mLoader.unregisterListener(this);
            }
            this.mLoader.reset();
          }
          if (this.mPendingLoader != null) {
            this.mPendingLoader.destroy();
          }
          return;
        }
        finally
        {
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
        }
        label281:
        str = null;
      }
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.mCallbacks);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.mLoader);
      if (this.mLoader != null) {
        this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      if ((this.mHaveData) || (this.mDeliveredData))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(this.mHaveData);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(this.mDeliveredData);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(this.mData);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.mStarted);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(this.mReportNextStart);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.mDestroyed);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(this.mRetaining);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(this.mRetainingStarted);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(this.mListenerRegistered);
      if (this.mPendingLoader != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(this.mPendingLoader);
        paramPrintWriter.println(":");
        this.mPendingLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    
    void finishRetain()
    {
      if (this.mRetaining)
      {
        if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Finished Retaining: " + this);
        }
        this.mRetaining = false;
        if ((this.mStarted != this.mRetainingStarted) && (!this.mStarted)) {
          stop();
        }
      }
      if ((this.mStarted) && (this.mHaveData) && (!this.mReportNextStart)) {
        callOnLoadFinished(this.mLoader, this.mData);
      }
    }
    
    public void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
    {
      if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "onLoadComplete: " + this);
      }
      if (this.mDestroyed) {
        if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Ignoring load complete -- destroyed");
        }
      }
      do
      {
        do
        {
          return;
          if (LoaderManagerImpl.this.mLoaders.get(this.mId) == this) {
            break;
          }
        } while ((!LoaderManagerImpl.DEBUG) || (!QLog.isDevelopLevel()));
        QLog.d("LoaderManager", 4, "  Ignoring load complete -- not active");
        return;
        LoaderInfo localLoaderInfo = this.mPendingLoader;
        if (localLoaderInfo != null)
        {
          if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
            QLog.d("LoaderManager", 4, "  Switching to pending loader: " + localLoaderInfo);
          }
          this.mPendingLoader = null;
          LoaderManagerImpl.this.mLoaders.put(this.mId, null);
          destroy();
          LoaderManagerImpl.this.installLoader(localLoaderInfo);
          return;
        }
        if ((this.mData != paramObject) || (!this.mHaveData))
        {
          this.mData = paramObject;
          this.mHaveData = true;
          if (this.mStarted) {
            callOnLoadFinished(paramLoader, paramObject);
          }
        }
        paramLoader = (LoaderInfo)LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
        if ((paramLoader != null) && (paramLoader != this))
        {
          paramLoader.mDeliveredData = false;
          paramLoader.destroy();
          LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
        }
      } while ((LoaderManagerImpl.this.mActivity == null) || (LoaderManagerImpl.this.hasRunningLoaders()));
      LoaderManagerImpl.this.mActivity.mFragments.startPendingDeferredFragments();
    }
    
    void reportStart()
    {
      if ((this.mStarted) && (this.mReportNextStart))
      {
        this.mReportNextStart = false;
        if (this.mHaveData) {
          callOnLoadFinished(this.mLoader, this.mData);
        }
      }
    }
    
    void retain()
    {
      if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Retaining: " + this);
      }
      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
    }
    
    void start()
    {
      if ((this.mRetaining) && (this.mRetainingStarted)) {
        this.mStarted = true;
      }
      do
      {
        do
        {
          return;
        } while (this.mStarted);
        this.mStarted = true;
        if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
          QLog.d("LoaderManager", 4, "  Starting: " + this);
        }
        if ((this.mLoader == null) && (this.mCallbacks != null)) {
          this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
        }
      } while (this.mLoader == null);
      if ((this.mLoader.getClass().isMemberClass()) && (!Modifier.isStatic(this.mLoader.getClass().getModifiers()))) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
      }
      if (!this.mListenerRegistered)
      {
        this.mLoader.registerListener(this.mId, this);
        this.mListenerRegistered = true;
      }
      this.mLoader.startLoading();
    }
    
    void stop()
    {
      if ((LoaderManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("LoaderManager", 4, "  Stopping: " + this);
      }
      this.mStarted = false;
      if ((!this.mRetaining) && (this.mLoader != null) && (this.mListenerRegistered))
      {
        this.mListenerRegistered = false;
        this.mLoader.unregisterListener(this);
        this.mLoader.stopLoading();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */