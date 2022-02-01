import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class wew
{
  public static SparseArray<Class<? extends zgz>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, yis.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, yiz.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static zgz a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(anvx.a(2131713158));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (zgz)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(anvx.a(2131713154), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(anvx.a(2131713157), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(anvx.a(2131713160), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(anvx.a(2131713156), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new yju(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(anvx.a(2131713161), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(anvx.a(2131713155), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wew
 * JD-Core Version:    0.7.0.1
 */