package btmsdkobf;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class f
{
  private static Object l;
  private static Class m;
  private static Method n = null;
  private static Method o = null;
  private static Method p = null;
  private static Method q = null;
  
  static
  {
    try
    {
      m = Class.forName("com.android.id.impl.IdProviderImpl");
      l = m.newInstance();
      n = m.getMethod("getUDID", new Class[] { Context.class });
      o = m.getMethod("getOAID", new Class[] { Context.class });
      p = m.getMethod("getVAID", new Class[] { Context.class });
      q = m.getMethod("getAAID", new Class[] { Context.class });
      return;
    }
    catch (Exception localException)
    {
      Log.e("IdentifierManager", "reflect exception!", localException);
    }
  }
  
  public static String a(Context paramContext)
  {
    return a(paramContext, o);
  }
  
  private static String a(Context paramContext, Method paramMethod)
  {
    if ((l != null) && (paramMethod != null)) {
      try
      {
        paramContext = paramMethod.invoke(l, new Object[] { paramContext });
        if (paramContext != null)
        {
          paramContext = (String)paramContext;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("IdentifierManager", "invoke exception!", paramContext);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.f
 * JD-Core Version:    0.7.0.1
 */