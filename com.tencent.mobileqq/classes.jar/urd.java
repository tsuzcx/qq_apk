import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class urd
{
  public static SparseArray<Class<? extends xvp>> a = new SparseArray();
  public static SparseArray<Boolean> b = new SparseArray();
  
  static
  {
    a.put(1, wvg.class);
    b.put(1, Boolean.valueOf(true));
    a.put(5, wvn.class);
    b.put(5, Boolean.valueOf(true));
  }
  
  public static xvp a(Context paramContext, int paramInt)
  {
    Object localObject = (Class)a.get(paramInt, null);
    Boolean localBoolean = (Boolean)b.get(paramInt, Boolean.valueOf(true));
    if (localObject == null) {
      throw new IllegalArgumentException(alud.a(2131714091));
    }
    if (localBoolean.booleanValue()) {
      try
      {
        paramContext = (xvp)((Class)localObject).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (NoSuchMethodException paramContext)
      {
        throw new IllegalStateException(alud.a(2131714087), paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        throw new IllegalStateException(alud.a(2131714090), paramContext);
      }
      catch (InstantiationException paramContext)
      {
        throw new IllegalStateException(alud.a(2131714093), paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        throw new IllegalArgumentException(alud.a(2131714089), paramContext);
      }
    }
    try
    {
      localObject = (String)((Class)localObject).getDeclaredField("KEY").get(null);
      return new wwi(paramContext, (String)localObject);
    }
    catch (NoSuchFieldException paramContext)
    {
      throw new IllegalStateException(alud.a(2131714094), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new IllegalStateException(alud.a(2131714088), paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urd
 * JD-Core Version:    0.7.0.1
 */