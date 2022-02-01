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

public class vgw
{
  private static vgw jdField_a_of_type_Vgw;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private final BaseApplication jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication = BaseApplicationImpl.context;
  private vgo jdField_a_of_type_Vgo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private vgw()
  {
    f();
    e();
    d();
    c();
  }
  
  public static vgw a()
  {
    try
    {
      if (jdField_a_of_type_Vgw == null) {
        jdField_a_of_type_Vgw = new vgw();
      }
      vgw localvgw = jdField_a_of_type_Vgw;
      return localvgw;
    }
    finally {}
  }
  
  private void c()
  {
    QCircleInitInject.g().injectApp(new vgx(this)).injectLogDelegate(new vgi()).injectToastDelegate(new vgk()).injectPluginInfoDelegate(new vgj()).injectDaTongReportDelegate(new vgh());
  }
  
  private void d()
  {
    azjl.a(BaseApplicationImpl.context, new vgy(this));
  }
  
  private void e()
  {
    QIPCServerHelper.getInstance().register(new vgl("Q_CIRCLE_HOST_MODULE_NAME"));
  }
  
  private void f()
  {
    a();
    DynamicRuntime.recoveryRuntime(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
    vgp.a().a();
    HostUIHelper.init(this.jdField_a_of_type_ComTencentQphoneBaseUtilBaseApplication);
  }
  
  private void g()
  {
    List localList = vgp.a().a();
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
    String str3 = "0";
    String str4 = "U";
    String str2 = str4;
    String str1 = str3;
    if (this.jdField_a_of_type_Vgo != null)
    {
      vgv localvgv = this.jdField_a_of_type_Vgo.a();
      str2 = str4;
      str1 = str3;
      if (localvgv != null)
      {
        str1 = localvgv.a() + "";
        str2 = localvgv.d();
      }
    }
    return QUA.getQUA3() + "_" + str2 + "_" + str1;
  }
  
  public vgo a()
  {
    try
    {
      if (this.jdField_a_of_type_Vgo == null)
      {
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_start").setPluginType("UnKnow"));
        localObject1 = vgp.a().a();
        if ((localObject1 != null) && (((vgs)localObject1).getLatest() != null))
        {
          this.jdField_a_of_type_Vgo = new vgo("QQ_CIRCLE", new DynamicPluginManager((PluginManagerUpdater)localObject1));
          this.jdField_a_of_type_Vgo.a((vgs)localObject1);
          this.jdField_a_of_type_Vgo.a(((vgs)localObject1).a());
          g();
        }
      }
      Object localObject1 = this.jdField_a_of_type_Vgo;
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      LoggerFactory.setILoggerFactory(aulz.a());
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
          int i = this.jdField_a_of_type_Vgo.a().a();
          SharedPreferences localSharedPreferences = BaseApplicationImpl.context.getSharedPreferences("QCircle_crash_share", 0);
          int j = localSharedPreferences.getInt("QCircle_crash_count_" + i, 0) + 1;
          localSharedPreferences.edit().putInt("QCircle_crash_count_" + i, j).commit();
          if (j >= QzoneConfig.getQCircleMaxCrashCount()) {
            vho.a().a(i);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgw
 * JD-Core Version:    0.7.0.1
 */