package android.support.v4.app;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStore;
import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl$LoaderViewModel
  extends ViewModel
{
  private static final ViewModelProvider.Factory FACTORY = new LoaderManagerImpl.LoaderViewModel.1();
  private SparseArrayCompat mLoaders = new SparseArrayCompat();
  
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
  
  LoaderManagerImpl.LoaderInfo getLoader(int paramInt)
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
  
  protected void onCleared()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderViewModel
 * JD-Core Version:    0.7.0.1
 */