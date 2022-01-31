import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class umu
{
  public static SparseArray<Class<? extends xrg>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, wqx.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, wre.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static xrg a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(alpo.a(2131714079));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (xrg)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(alpo.a(2131714075), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(alpo.a(2131714078), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(alpo.a(2131714081), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(alpo.a(2131714077), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new wrz(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(alpo.a(2131714082), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(alpo.a(2131714076), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umu
 * JD-Core Version:    0.7.0.1
 */