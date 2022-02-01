import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ppo
{
  public static SparseArray<Class<? extends rsd>> aE = new SparseArray();
  public static SparseArray<Boolean> aF = new SparseArray();
  
  static
  {
    aE.put(1, qzc.class);
    aF.put(1, Boolean.valueOf(true));
    aE.put(5, qzf.class);
    aF.put(5, Boolean.valueOf(true));
  }
  
  public static rsd a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)aE.get(paramInt, null);
    Boolean localBoolean = (Boolean)aF.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(acfp.m(2131714181));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (rsd)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(acfp.m(2131714177), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(acfp.m(2131714180), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(acfp.m(2131714183), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(acfp.m(2131714179), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new qzw(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(acfp.m(2131714184), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(acfp.m(2131714178), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppo
 * JD-Core Version:    0.7.0.1
 */