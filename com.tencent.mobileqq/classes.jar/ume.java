import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class ume
{
  public static int a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getInteger(paramInt);
  }
  
  public static Boolean a(int paramInt)
  {
    return Boolean.valueOf(BaseApplicationImpl.getApplication().getResources().getBoolean(paramInt));
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    return umr.a(paramClass, paramVarArgs);
  }
  
  public static String a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt);
  }
  
  public static String a(int paramInt, Object... paramVarArgs)
  {
    return BaseApplicationImpl.getApplication().getResources().getString(paramInt, paramVarArgs);
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static <T extends Activity> umn<T> a(Class<? extends umn<T>> paramClass, Class<umn<T>> paramClass1, Object... paramVarArgs)
  {
    return (umn)umr.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static xrg a(Context paramContext, int paramInt)
  {
    return umu.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    umx.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    umx.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    umv.a(paramObject);
  }
  
  public static boolean a()
  {
    return umw.a();
  }
  
  public static String[] a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ume
 * JD-Core Version:    0.7.0.1
 */