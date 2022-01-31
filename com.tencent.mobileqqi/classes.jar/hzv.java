import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class hzv
  extends AsyncTask
{
  public String a;
  public final ArrayList a;
  public String b;
  public String c;
  private String d;
  
  public hzv(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.c = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    paramVarArgs = PluginUtils.installPlugin(BaseApplication.getContext(), this.b, "master");
    if (paramVarArgs != null) {
      PluginStatisticsCollector.a(BaseApplication.getContext(), this.c, this.b, paramVarArgs);
    }
    this.d = paramVarArgs;
    if (paramVarArgs == null) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public void a(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    paramActivity = new hzw(this, paramActivity, paramPluginParams);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramActivity);
  }
  
  public void a(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    paramContext = new hzy(this, paramContext, paramPluginParams);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
  }
  
  protected void a(Boolean paramBoolean)
  {
    synchronized ()
    {
      IPluginManager.a().remove(this.b);
      if (!paramBoolean.booleanValue())
      {
        IPluginManager.a(this.d, this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramBoolean.hasNext()) {
      ((hzx)paramBoolean.next()).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    paramContext = new hzz(this, paramContext, paramPluginParams);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzv
 * JD-Core Version:    0.7.0.1
 */