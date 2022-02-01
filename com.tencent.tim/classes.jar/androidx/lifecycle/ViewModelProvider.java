package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider
{
  private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
  private final Factory mFactory;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(@NonNull ViewModelStore paramViewModelStore, @NonNull Factory paramFactory)
  {
    this.mFactory = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, @NonNull Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @MainThread
  @NonNull
  public <T extends ViewModel> T get(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    ViewModel localViewModel = this.mViewModelStore.get(paramString);
    if (paramClass.isInstance(localViewModel)) {
      return localViewModel;
    }
    if ((localViewModel == null) || ((this.mFactory instanceof KeyedFactory))) {}
    for (paramClass = ((KeyedFactory)this.mFactory).create(paramString, paramClass);; paramClass = this.mFactory.create(paramClass))
    {
      this.mViewModelStore.put(paramString, paramClass);
      return paramClass;
    }
  }
  
  public static class AndroidViewModelFactory
    extends ViewModelProvider.NewInstanceFactory
  {
    private static AndroidViewModelFactory sInstance;
    private Application mApplication;
    
    public AndroidViewModelFactory(@NonNull Application paramApplication)
    {
      this.mApplication = paramApplication;
    }
    
    @NonNull
    public static AndroidViewModelFactory getInstance(@NonNull Application paramApplication)
    {
      if (sInstance == null) {
        sInstance = new AndroidViewModelFactory(paramApplication);
      }
      return sInstance;
    }
    
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.mApplication });
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localNoSuchMethodException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInvocationTargetException);
        }
      }
      return super.create(paramClass);
    }
  }
  
  public static abstract interface Factory
  {
    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull Class<T> paramClass);
  }
  
  static abstract class KeyedFactory
    implements ViewModelProvider.Factory
  {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }
    
    @NonNull
    public abstract <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass);
  }
  
  public static class NewInstanceFactory
    implements ViewModelProvider.Factory
  {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
    {
      try
      {
        ViewModel localViewModel = (ViewModel)paramClass.newInstance();
        return localViewModel;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */