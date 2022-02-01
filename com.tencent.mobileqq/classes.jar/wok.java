import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class wok
{
  public static SparseArray<Class<? extends zsv>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, ysm.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, yst.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static zsv a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(anzj.a(2131712579));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (zsv)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(anzj.a(2131712575), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(anzj.a(2131712578), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(anzj.a(2131712581), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(anzj.a(2131712577), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new yto(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(anzj.a(2131712582), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(anzj.a(2131712576), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wok
 * JD-Core Version:    0.7.0.1
 */