package btmsdkobf;

import android.content.Context;
import java.lang.reflect.Method;

public class f
{
  private static Object l;
  private static Class<?> m;
  private static Method n;
  private static Method o;
  private static Method p;
  private static Method q;
  
  static
  {
    try
    {
      Class localClass = Class.forName("com.android.id.impl.IdProviderImpl");
      m = localClass;
      l = localClass.newInstance();
      n = m.getMethod("getUDID", new Class[] { Context.class });
      o = m.getMethod("getOAID", new Class[] { Context.class });
      p = m.getMethod("getVAID", new Class[] { Context.class });
      q = m.getMethod("getAAID", new Class[] { Context.class });
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String a(Context paramContext)
  {
    return a(paramContext, o);
  }
  
  private static String a(Context paramContext, Method paramMethod)
  {
    Object localObject = l;
    if ((localObject != null) && (paramMethod != null)) {}
    try
    {
      paramContext = paramMethod.invoke(localObject, new Object[] { paramContext });
      if (paramContext != null)
      {
        paramContext = (String)paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      label37:
      break label37;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.f
 * JD-Core Version:    0.7.0.1
 */