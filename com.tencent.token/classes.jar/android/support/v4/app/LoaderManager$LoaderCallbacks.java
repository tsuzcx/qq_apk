package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;

public abstract interface LoaderManager$LoaderCallbacks
{
  @MainThread
  @NonNull
  public abstract Loader onCreateLoader(int paramInt, @Nullable Bundle paramBundle);
  
  @MainThread
  public abstract void onLoadFinished(@NonNull Loader paramLoader, Object paramObject);
  
  @MainThread
  public abstract void onLoaderReset(@NonNull Loader paramLoader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManager.LoaderCallbacks
 * JD-Core Version:    0.7.0.1
 */