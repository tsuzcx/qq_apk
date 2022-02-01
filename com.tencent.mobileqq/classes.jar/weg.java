import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class weg
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
    return wet.a(paramClass, paramVarArgs);
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
  
  public static <T extends Activity> wep<T> a(Class<? extends wep<T>> paramClass, Class<wep<T>> paramClass1, Object... paramVarArgs)
  {
    return (wep)wet.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static zgz a(Context paramContext, int paramInt)
  {
    return wew.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    wez.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    wez.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    wex.a(paramObject);
  }
  
  public static boolean a()
  {
    return wey.a();
  }
  
  public static String[] a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weg
 * JD-Core Version:    0.7.0.1
 */