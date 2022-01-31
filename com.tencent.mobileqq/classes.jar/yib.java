import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper.1;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import mqq.app.AppRuntime;

public class yib
{
  private static volatile yib jdField_a_of_type_Yib;
  private Map<String, Timer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private String a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return paramString + "_" + str;
  }
  
  public static yib a()
  {
    if (jdField_a_of_type_Yib == null) {}
    try
    {
      if (jdField_a_of_type_Yib == null) {
        jdField_a_of_type_Yib = new yib();
      }
      return jdField_a_of_type_Yib;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString, yic paramyic)
  {
    paramContext = yia.a(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(a(paramString), 0);
      if (paramyic != null) {
        paramyic.a(i + 1);
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return yia.a(paramContext).getInt(a(paramString), 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = yia.a(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = a(paramString);
    localEditor.putInt(paramString, paramContext.getInt(paramString, 0) + paramInt);
    localEditor.apply();
  }
  
  public void a(Context paramContext, String paramString, int paramInt, yic paramyic)
  {
    if (paramInt > 0)
    {
      a(paramString);
      Timer localTimer = new Timer();
      localTimer.schedule(new TimeAndCountHelper.1(this, paramContext, paramString, paramyic), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, paramyic);
  }
  
  public void a(String paramString)
  {
    Timer localTimer = (Timer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localTimer != null)
    {
      localTimer.cancel();
      localTimer.purge();
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yib
 * JD-Core Version:    0.7.0.1
 */