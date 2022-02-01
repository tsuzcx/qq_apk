import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;

public class vvi
  implements bdwo
{
  private final DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private final String jdField_a_of_type_JavaLangString;
  private vvm jdField_a_of_type_Vvm;
  private vvp jdField_a_of_type_Vvp;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public vvi(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
  }
  
  public vvp a()
  {
    return this.jdField_a_of_type_Vvp;
  }
  
  public void a(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    try
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#preLoad():idle status " + this.jdField_a_of_type_Boolean);
      enter(paramContext, paramLong, paramBundle, paramEnterCallback);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(vvm paramvvm)
  {
    this.jdField_a_of_type_Vvm = paramvvm;
  }
  
  public void a(vvp paramvvp)
  {
    this.jdField_a_of_type_Vvp = paramvvp;
  }
  
  public void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#enter():enter formId:" + paramLong);
    }
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Vvm != null) && (this.jdField_a_of_type_Vvm.getLatest().exists())) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
    }
    do
    {
      return;
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginEnterManger#enter():plugin source file is deleted");
    } while (paramLong != 1000L);
    paramBundle = new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result");
    if (this.jdField_a_of_type_Vvp != null)
    {
      paramContext = this.jdField_a_of_type_Vvp.c();
      paramContext = paramBundle.setPluginType(paramContext);
      if (this.jdField_a_of_type_Vvp == null) {
        break label163;
      }
    }
    label163:
    for (paramLong = this.jdField_a_of_type_Vvp.a();; paramLong = -3L)
    {
      QCirclePluginQualityReporter.report(paramContext.setPluginVersion(paramLong).setRetCode(1L));
      ILoadPluginDelegate.disPatchCallback(1, "file has delete");
      return;
      paramContext = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvi
 * JD-Core Version:    0.7.0.1
 */