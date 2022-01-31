package android.support.v4.app;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager
{
  public static void enableDebugLogging(boolean paramBoolean)
  {
    LoaderManagerImpl.DEBUG = paramBoolean;
  }
  
  @MainThread
  public abstract void destroyLoader(int paramInt);
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @Nullable
  public abstract Loader getLoader(int paramInt);
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  @MainThread
  @NonNull
  public abstract Loader initLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks);
  
  @MainThread
  @NonNull
  public abstract Loader restartLoader(int paramInt, @Nullable Bundle paramBundle, @NonNull LoaderManager.LoaderCallbacks paramLoaderCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManager
 * JD-Core Version:    0.7.0.1
 */