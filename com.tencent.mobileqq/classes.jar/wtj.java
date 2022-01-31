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

public class wtj
{
  private static volatile wtj jdField_a_of_type_Wtj;
  private Map<String, Timer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private String a(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return paramString + "_" + str;
  }
  
  public static wtj a()
  {
    if (jdField_a_of_type_Wtj == null) {}
    try
    {
      if (jdField_a_of_type_Wtj == null) {
        jdField_a_of_type_Wtj = new wtj();
      }
      return jdField_a_of_type_Wtj;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString, wtk paramwtk)
  {
    paramContext = wti.a(paramContext);
    if (paramContext != null)
    {
      int i = paramContext.getInt(a(paramString), 0);
      if (paramwtk != null) {
        paramwtk.a(i + 1);
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return wti.a(paramContext).getInt(a(paramString), 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = wti.a(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramString = a(paramString);
    localEditor.putInt(paramString, paramContext.getInt(paramString, 0) + paramInt);
    localEditor.apply();
  }
  
  public void a(Context paramContext, String paramString, int paramInt, wtk paramwtk)
  {
    if (paramInt > 0)
    {
      a(paramString);
      Timer localTimer = new Timer();
      localTimer.schedule(new TimeAndCountHelper.1(this, paramContext, paramString, paramwtk), paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localTimer);
      return;
    }
    a(paramContext, paramString, paramwtk);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtj
 * JD-Core Version:    0.7.0.1
 */