import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class wkp
{
  public static SparseArray<Class<? extends zpa>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, yor.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, yoy.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static zpa a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(anni.a(2131712470));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (zpa)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(anni.a(2131712466), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(anni.a(2131712469), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(anni.a(2131712472), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(anni.a(2131712468), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new ypt(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(anni.a(2131712473), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(anni.a(2131712467), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkp
 * JD-Core Version:    0.7.0.1
 */