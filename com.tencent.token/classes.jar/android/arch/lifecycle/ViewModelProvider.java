package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class ViewModelProvider
{
  private static final String DEFAULT_KEY = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
  private final ViewModelProvider.Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(@NonNull ViewModelStore paramViewModelStore, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, @NonNull ViewModelProvider.Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  @NonNull
  public ViewModel get(@NonNull Class paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return get("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @MainThread
  @NonNull
  public ViewModel get(@NonNull String paramString, @NonNull Class paramClass)
  {
    ViewModel localViewModel = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localViewModel)) {
      return localViewModel;
    }
    if (localViewModel != null) {}
    paramClass = this.mFactory.create(paramClass);
    this.mViewModelStore.put(paramString, paramClass);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */