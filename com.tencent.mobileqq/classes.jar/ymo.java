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

public class ymo
{
  private static volatile ymo jdField_a_of_type_Ymo;
  private Map<String, Timer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private String a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return paramString + "_" + str;
  }
  
  public static ymo a()
  {
    if (jdField_a_of_type_Ymo == null) {}
    try
    {
      if (jdField_a_of_type_Ymo == null) {
        jdField_a_of_type_Ymo = new ymo();
      }
      return jdField_a_of_type_Ymo;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString, ymp paramymp)
  {
    paramContext = ymn.a(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(a(paramString), 0);
      if (paramymp != null) {
        paramymp.a(i + 1);
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return ymn.a(paramContext).getInt(a(paramString), 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = ymn.a(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = a(paramString);
    localEditor.putInt(paramString, paramContext.getInt(paramString, 0) + paramInt);
    localEditor.apply();
  }
  
  public void a(Context paramContext, String paramString, int paramInt, ymp paramymp)
  {
    if (paramInt > 0)
    {
      a(paramString);
      Timer localTimer = new Timer();
      localTimer.schedule(new TimeAndCountHelper.1(this, paramContext, paramString, paramymp), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, paramymp);
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
 * Qualified Name:     ymo
 * JD-Core Version:    0.7.0.1
 */