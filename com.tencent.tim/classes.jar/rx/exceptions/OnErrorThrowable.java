package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class OnErrorThrowable
  extends RuntimeException
{
  private static final long serialVersionUID = -569558213262703934L;
  private final boolean hasValue;
  private final Object value;
  
  private OnErrorThrowable(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.hasValue = false;
    this.value = null;
  }
  
  private OnErrorThrowable(Throwable paramThrowable, Object paramObject)
  {
    super(paramThrowable);
    this.hasValue = true;
    this.value = paramObject;
  }
  
  public static Throwable addValueAsLastCause(Throwable paramThrowable, Object paramObject)
  {
    Object localObject = paramThrowable;
    if (paramThrowable == null) {
      localObject = new NullPointerException();
    }
    paramThrowable = Exceptions.getFinalCause((Throwable)localObject);
    if ((paramThrowable != null) && ((paramThrowable instanceof OnNextValue)) && (((OnNextValue)paramThrowable).getValue() == paramObject)) {
      return localObject;
    }
    Exceptions.addCause((Throwable)localObject, new OnNextValue(paramObject));
    return localObject;
  }
  
  public static OnErrorThrowable from(Throwable paramThrowable)
  {
    Object localObject = paramThrowable;
    if (paramThrowable == null) {
      localObject = new NullPointerException();
    }
    paramThrowable = Exceptions.getFinalCause((Throwable)localObject);
    if ((paramThrowable instanceof OnNextValue)) {
      return new OnErrorThrowable((Throwable)localObject, ((OnNextValue)paramThrowable).getValue());
    }
    return new OnErrorThrowable((Throwable)localObject);
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public boolean isValueNull()
  {
    return this.hasValue;
  }
  
  public static class OnNextValue
    extends RuntimeException
  {
    private static final long serialVersionUID = -3454462756050397899L;
    private final Object value;
    
    public OnNextValue(Object paramObject)
    {
      super();
      this.value = paramObject;
    }
    
    static String renderValue(Object paramObject)
    {
      if (paramObject == null) {
        return "null";
      }
      if (Primitives.INSTANCE.contains(paramObject.getClass())) {
        return paramObject.toString();
      }
      if ((paramObject instanceof String)) {
        return (String)paramObject;
      }
      if ((paramObject instanceof Enum)) {
        return ((Enum)paramObject).name();
      }
      String str = RxJavaPlugins.getInstance().getErrorHandler().handleOnNextValueRendering(paramObject);
      if (str != null) {
        return str;
      }
      return paramObject.getClass().getName() + ".class";
    }
    
    public Object getValue()
    {
      return this.value;
    }
    
    static final class Primitives
    {
      static final Set<Class<?>> INSTANCE = ;
      
      private static Set<Class<?>> create()
      {
        HashSet localHashSet = new HashSet();
        localHashSet.add(Boolean.class);
        localHashSet.add(Character.class);
        localHashSet.add(Byte.class);
        localHashSet.add(Short.class);
        localHashSet.add(Integer.class);
        localHashSet.add(Long.class);
        localHashSet.add(Float.class);
        localHashSet.add(Double.class);
        return localHashSet;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.exceptions.OnErrorThrowable
 * JD-Core Version:    0.7.0.1
 */