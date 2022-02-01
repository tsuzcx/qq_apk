import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostUIHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import cooperation.qzone.QUA;
import java.util.List;

public class vvq
{
  private static volatile vvq jdField_a_of_type_Vvq;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private final BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplicationImpl.context;
  private vvi jdField_a_of_type_Vvi;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private vvq()
  {
    f();
    e();
    d();
    c();
  }
  
  /* Error */
  public static vvq a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 38	vvq:jdField_a_of_type_Vvq	Lvvq;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 38	vvq:jdField_a_of_type_Vvq	Lvvq;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	vvq
    //   21: dup
    //   22: invokespecial 39	vvq:<init>	()V
    //   25: putstatic 38	vvq:jdField_a_of_type_Vvq	Lvvq;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 38	vvq:jdField_a_of_type_Vvq	Lvvq;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localvvq	vvq
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void c()
  {
    QCircleInitInject.g().injectApp(new vvr(this)).injectLogDelegate(new vvb()).injectToastDelegate(new vvd()).injectPluginInfoDelegate(new vvc()).injectDaTongReportDelegate(new vva());
  }
  
  private void d()
  {
    bapt.a(BaseApplicationImpl.context, new vvs(this));
  }
  
  private void e()
  {
    QIPCServerHelper.getInstance().register(new vvf("Q_CIRCLE_HOST_MODULE_NAME"));
  }
  
  private void f()
  {
    a();
    DynamicRuntime.recoveryRuntime(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
    vvj.a().a();
    HostUIHelper.init(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
  }
  
  private void g()
  {
    List localList = vvj.a().a();
    if (localList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < localList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)localList.get(i))) {
          localStringBuilder.append("plugin").append(i + 1).append(":").append((String)localList.get(i)).append("\n");
        }
        i += 1;
      }
      QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    }
  }
  
  public String a()
  {
    return QUA.getQUA3() + "_" + b();
  }
  
  public vvi a()
  {
    try
    {
      if (this.jdField_a_of_type_Vvi == null)
      {
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_start").setPluginType("UnKnow"));
        localObject1 = vvj.a().a();
        if ((localObject1 != null) && (((vvm)localObject1).getLatest() != null))
        {
          this.jdField_a_of_type_Vvi = new vvi("QQ_CIRCLE", new DynamicPluginManager((PluginManagerUpdater)localObject1));
          this.jdField_a_of_type_Vvi.a((vvm)localObject1);
          this.jdField_a_of_type_Vvi.a(((vvm)localObject1).a());
          g();
        }
      }
      Object localObject1 = this.jdField_a_of_type_Vvi;
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      LoggerFactory.setILoggerFactory(avru.a());
      label13:
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label13;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if (paramString.toLowerCase().contains("qcircle"))
        {
          int i = this.jdField_a_of_type_Vvi.a().a();
          SharedPreferences localSharedPreferences = BaseApplicationImpl.context.getSharedPreferences("QCircle_crash_share", 0);
          int j = localSharedPreferences.getInt("QCircle_crash_count_" + i, 0) + 1;
          localSharedPreferences.edit().putInt("QCircle_crash_count_" + i, j).commit();
          if (j >= QzoneConfig.getQCircleMaxCrashCount()) {
            vwj.a().a(i);
          }
          QLog.i("QCIRCLE_PLUGIN", 1, "crashCount: " + j + " crashVersion:" + i + "---------" + paramString);
          return;
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public String b()
  {
    String str3 = "0";
    String str4 = "U";
    String str2 = str4;
    String str1 = str3;
    if (this.jdField_a_of_type_Vvi != null)
    {
      vvp localvvp = this.jdField_a_of_type_Vvi.a();
      str2 = str4;
      str1 = str3;
      if (localvvp != null)
      {
        str1 = localvvp.a() + "";
        str2 = localvvp.d();
      }
    }
    return str2 + "_" + str1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvq
 * JD-Core Version:    0.7.0.1
 */