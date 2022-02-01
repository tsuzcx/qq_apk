import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class ppf
{
  public static boolean IC()
  {
    return ppq.IC();
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    return ppl.a(paramClass, paramVarArgs);
  }
  
  public static <T extends Activity> ppi<T> a(Class<? extends ppi<T>> paramClass, Class<ppi<T>> paramClass1, Object... paramVarArgs)
  {
    return (ppi)ppl.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static rsd a(Context paramContext, int paramInt)
  {
    return ppo.a(paramContext, paramInt);
  }
  
  public static void b(Context paramContext, int paramInt, long paramLong)
  {
    ppr.b(paramContext, paramInt, paramLong);
  }
  
  public static void f(Context paramContext, int paramInt, String paramString)
  {
    ppr.f(paramContext, paramInt, paramString);
  }
  
  public static String fQ(String paramString)
  {
    return paramString;
  }
  
  public static Boolean getBoolean(int paramInt)
  {
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getResources().getBoolean(paramInt));
  }
  
  public static int getInteger(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getInteger(paramInt);
  }
  
  public static String getString(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt);
  }
  
  public static String getString(int paramInt, Object... paramVarArgs)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt, paramVarArgs);
  }
  
  public static String[] getStringArray(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
  
  public static void inject(Object paramObject)
  {
    ppp.ai(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppf
 * JD-Core Version:    0.7.0.1
 */