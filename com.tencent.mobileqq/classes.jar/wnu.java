import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class wnu
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
    return woh.a(paramClass, paramVarArgs);
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
  
  public static <T extends Activity> wod<T> a(Class<? extends wod<T>> paramClass, Class<wod<T>> paramClass1, Object... paramVarArgs)
  {
    return (wod)woh.a(paramClass, paramClass1, paramVarArgs);
  }
  
  public static zsv a(Context paramContext, int paramInt)
  {
    return wok.a(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, long paramLong)
  {
    won.a(paramContext, paramInt, paramLong);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    won.a(paramContext, paramInt, paramString);
  }
  
  public static void a(Object paramObject)
  {
    wol.a(paramObject);
  }
  
  public static boolean a()
  {
    return wom.a();
  }
  
  public static String[] a(int paramInt)
  {
    return BaseApplicationImpl.getApplication().getResources().getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnu
 * JD-Core Version:    0.7.0.1
 */