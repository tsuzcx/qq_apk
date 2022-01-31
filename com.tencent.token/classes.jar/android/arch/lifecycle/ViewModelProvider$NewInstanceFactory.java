package android.arch.lifecycle;

import android.support.annotation.NonNull;

public class ViewModelProvider$NewInstanceFactory
  implements ViewModelProvider.Factory
{
  @NonNull
  public ViewModel create(@NonNull Class paramClass)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider.NewInstanceFactory
 * JD-Core Version:    0.7.0.1
 */