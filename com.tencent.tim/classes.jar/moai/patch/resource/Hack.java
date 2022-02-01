package moai.patch.resource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Hack
{
  public static <T> HackedClass<T> clazz(Class<T> paramClass)
  {
    return new HackedClass(paramClass);
  }
  
  public static <T> HackedClass<T> clazz(String paramString)
    throws ClassNotFoundException
  {
    return new HackedClass(Class.forName(paramString));
  }
  
  public static class HackedClass<C>
  {
    protected Class<C> mClass;
    
    public HackedClass(Class<C> paramClass)
    {
      this.mClass = paramClass;
    }
    
    public Hack.HackedConstructor constructor(Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      return new Hack.HackedConstructor(this.mClass, paramVarArgs);
    }
    
    public <T> Hack.HackedField<C, T> field(String paramString)
      throws NoSuchFieldException
    {
      return new Hack.HackedField(this.mClass, paramString, 0);
    }
    
    public Class<C> getmClass()
    {
      return this.mClass;
    }
    
    public Hack.HackedMethod method(String paramString, Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      return new Hack.HackedMethod(this.mClass, paramString, paramVarArgs, 0);
    }
    
    public <T> Hack.HackedField<C, T> staticField(String paramString)
      throws NoSuchFieldException
    {
      return new Hack.HackedField(this.mClass, paramString, 8);
    }
    
    public Hack.HackedMethod staticMethod(String paramString, Class<?>... paramVarArgs)
      throws NoSuchMethodException
    {
      return new Hack.HackedMethod(this.mClass, paramString, paramVarArgs, 8);
    }
  }
  
  public static class HackedConstructor
  {
    protected Constructor<?> mConstructor;
    
    HackedConstructor(Class<?> paramClass, Class<?>[] paramArrayOfClass)
      throws NoSuchMethodException
    {
      this.mConstructor = paramClass.getDeclaredConstructor(paramArrayOfClass);
    }
    
    public Object newInstance(Object... paramVarArgs)
      throws Exception
    {
      this.mConstructor.setAccessible(true);
      return this.mConstructor.newInstance(paramVarArgs);
    }
  }
  
  public static class HackedField<C, T>
  {
    private final Field mField;
    
    HackedField(Class<C> paramClass, String paramString, int paramInt)
      throws NoSuchFieldException
    {
      if (paramClass == null)
      {
        this.mField = null;
        return;
      }
      paramClass = paramClass.getDeclaredField(paramString);
      if ((paramInt > 0) && ((paramClass.getModifiers() & paramInt) != paramInt)) {
        throw new IllegalStateException(paramClass + " does not match modifiers: " + paramInt);
      }
      paramClass.setAccessible(true);
      this.mField = paramClass;
    }
    
    public T get(C paramC)
      throws IllegalAccessException
    {
      return this.mField.get(paramC);
    }
    
    public Field getField()
    {
      return this.mField;
    }
    
    public void set(C paramC, Object paramObject)
      throws IllegalAccessException
    {
      this.mField.set(paramC, paramObject);
    }
  }
  
  public static class HackedMethod
  {
    protected final Method mMethod;
    
    HackedMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, int paramInt)
      throws NoSuchMethodException
    {
      if (paramClass == null)
      {
        this.mMethod = null;
        return;
      }
      paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      if ((paramInt > 0) && ((paramClass.getModifiers() & paramInt) != paramInt)) {
        throw new IllegalStateException(paramClass + " does not match modifiers: " + paramInt);
      }
      paramClass.setAccessible(true);
      this.mMethod = paramClass;
    }
    
    public Method getMethod()
    {
      return this.mMethod;
    }
    
    public Object invoke(Object paramObject, Object... paramVarArgs)
      throws Exception
    {
      return this.mMethod.invoke(paramObject, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.resource.Hack
 * JD-Core Version:    0.7.0.1
 */