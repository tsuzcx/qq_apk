import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class vqb
{
  public static SparseArray<Class<? extends ysg>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, xtx.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, xue.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static ysg a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(amtj.a(2131712811));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (ysg)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(amtj.a(2131712807), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(amtj.a(2131712810), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(amtj.a(2131712813), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(amtj.a(2131712809), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new xuz(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(amtj.a(2131712814), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(amtj.a(2131712808), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqb
 * JD-Core Version:    0.7.0.1
 */