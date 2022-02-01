import android.app.Application;
import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class axzz
{
  private final axzz.b jdField_a_of_type_Axzz$b;
  private final ayaa jdField_a_of_type_Ayaa;
  
  public axzz(@NonNull ayaa paramayaa, @NonNull axzz.b paramb)
  {
    this.jdField_a_of_type_Axzz$b = paramb;
    this.jdField_a_of_type_Ayaa = paramayaa;
  }
  
  public axzz(@NonNull ayab paramayab, @NonNull axzz.b paramb)
  {
    this(paramayab.a(), paramb);
  }
  
  @NonNull
  public <T extends axzy> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    axzy localaxzy = this.jdField_a_of_type_Ayaa.a(paramString);
    if (paramClass.isInstance(localaxzy)) {
      return localaxzy;
    }
    if (localaxzy != null) {}
    paramClass = this.jdField_a_of_type_Axzz$b.a(paramClass);
    this.jdField_a_of_type_Ayaa.a(paramString, paramClass);
    return paramClass;
  }
  
  @NonNull
  public <T extends axzy> T b(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  public static class a
    extends axzz.c
  {
    private static a a;
    private Application mApplication;
    
    public a(@NonNull Application paramApplication)
    {
      this.mApplication = paramApplication;
    }
    
    @NonNull
    public static a a(@NonNull Application paramApplication)
    {
      if (a == null) {
        a = new a(paramApplication);
      }
      return a;
    }
    
    @NonNull
    public <T extends axzy> T a(@NonNull Class<T> paramClass)
    {
      if (axzx.class.isAssignableFrom(paramClass)) {
        try
        {
          axzy localaxzy = (axzy)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.mApplication });
          return localaxzy;
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
      return super.a(paramClass);
    }
  }
  
  public static abstract interface b
  {
    @NonNull
    public abstract <T extends axzy> T a(@NonNull Class<T> paramClass);
  }
  
  public static class c
    implements axzz.b
  {
    @NonNull
    public <T extends axzy> T a(@NonNull Class<T> paramClass)
    {
      try
      {
        axzy localaxzy = (axzy)paramClass.newInstance();
        return localaxzy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzz
 * JD-Core Version:    0.7.0.1
 */