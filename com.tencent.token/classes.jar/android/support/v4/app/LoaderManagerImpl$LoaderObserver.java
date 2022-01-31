package android.support.v4.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;
import java.io.PrintWriter;

class LoaderManagerImpl$LoaderObserver
  implements Observer
{
  @NonNull
  private final LoaderManager.LoaderCallbacks mCallback;
  private boolean mDeliveredData = false;
  @NonNull
  private final Loader mLoader;
  
  LoaderManagerImpl$LoaderObserver(@NonNull Loader paramLoader, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks)
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
  
  public void onChanged(@Nullable Object paramObject)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(paramObject));
    }
    this.mCallback.onLoadFinished(this.mLoader, paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderObserver
 * JD-Core Version:    0.7.0.1
 */