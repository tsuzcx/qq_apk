import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.QCircleConstants;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class vgp
{
  private static final String jdField_a_of_type_JavaLangString = QCircleConstants.QCIRCLE_INNER_ROOT_PATH + "qcirclePlugin/";
  private static vgp jdField_a_of_type_Vgp;
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "pluginAsset/";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.context;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private Future<vgv> jdField_a_of_type_JavaUtilConcurrentFuture;
  private Future<vgv> jdField_b_of_type_JavaUtilConcurrentFuture;
  private Future<vgv> c;
  
  private String a(Future<vgv> paramFuture)
  {
    if (paramFuture != null) {
      try
      {
        if (paramFuture.get() != null)
        {
          paramFuture = ((vgv)paramFuture.get()).toString();
          return paramFuture;
        }
      }
      catch (Exception paramFuture)
      {
        return "";
      }
    }
    return "";
  }
  
  public static vgp a()
  {
    try
    {
      if (jdField_a_of_type_Vgp == null) {
        jdField_a_of_type_Vgp = new vgp();
      }
      vgp localvgp = jdField_a_of_type_Vgp;
      return localvgp;
    }
    finally {}
  }
  
  private vgs a(vgv paramvgv)
  {
    if (paramvgv != null)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_wns_load_asset").setPluginType("Q_CIRCLE_PLUGIN_ASSET").setPluginVersion(paramvgv.a()));
      QLog.i("QCIRCLE_PLUGIN", 1, "checkWNS():WNS force use asset");
      return a(paramvgv, false);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():WNS force use asset no asset info");
    return null;
  }
  
  private vgs a(vgv paramvgv1, vgv paramvgv2)
  {
    if (paramvgv1.a() > paramvgv2.a())
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_asset").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvgv1.a()).setExt1(String.valueOf(paramvgv2.a())).setRetCode(0L));
      if (a(paramvgv1.a(), paramvgv1.c()))
      {
        if (paramvgv1.a() >= 1000)
        {
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_minversion").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvgv1.a()).setExt1(String.valueOf(1000)).setRetCode(0L));
          QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():use netWork plugin, net version:" + paramvgv1.a() + " asset version:" + paramvgv2.a() + " MiniSupportVersion" + 1000);
          return new vgs(paramvgv1);
        }
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_minversion").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvgv1.a()).setExt1(String.valueOf(1000)).setRetCode(1L));
        QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvgv1.a() + " mini not support, go to checkAsset");
        return a(paramvgv2, true);
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_crash_max").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvgv1.a()).setExt1(String.valueOf(1000)).setRetCode(1L));
      QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvgv1.a() + " crash too many, go to checkAsset");
      return a(paramvgv2, true);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvgv1.a() + " lower then asset, go to checkAsset");
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_asset").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvgv1.a()).setExt1(String.valueOf(paramvgv2.a())).setRetCode(1L));
    return a(paramvgv2, true);
  }
  
  private vgs a(vgv paramvgv, boolean paramBoolean)
  {
    if (a(paramvgv.a(), paramvgv.c()))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "checkAsset():use asset plugin , assetVersion:" + paramvgv.a() + " , hasNetPlugin: " + paramBoolean + " ,MiniSupportVersion" + 1000);
      return new vgs(paramvgv);
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result").setPluginType("Q_CIRCLE_PLUGIN_ASSET").setPluginVersion(paramvgv.a()).setRetCode(3L));
    ILoadPluginDelegate.disPatchCallback(3, "crash too many");
    return null;
  }
  
  private boolean a()
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "isUnSupport():false");
      return false;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_system_unsupport"));
    QLog.i("QCIRCLE_PLUGIN", 1, "isUnSupport():true");
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    int i = BaseApplicationImpl.context.getSharedPreferences("QCircle_crash_share", 0).getInt("QCircle_crash_count_" + paramInt, 0);
    if ("Q_CIRCLE_PLUGIN_ASSET".equals(paramString)) {}
    while (i < QzoneConfig.getQCircleMaxCrashCount()) {
      return true;
    }
    vho.a().a(paramInt);
    QLog.i("QCIRCLE_PLUGIN", 1, "crashValidEnable():net plugin ,current version:" + paramInt + ",crashed to many times");
    return false;
  }
  
  private vgs b(vgv paramvgv)
  {
    if (paramvgv != null) {}
    return null;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(a(this.jdField_b_of_type_JavaUtilConcurrentFuture));
      localArrayList.add(a(this.jdField_a_of_type_JavaUtilConcurrentFuture));
      localArrayList.add(a(this.c));
      return localArrayList;
    }
    catch (Exception localException) {}
    return localArrayList;
  }
  
  public Future<vgv> a(String paramString1, String paramString2, int paramInt)
  {
    if (this.c == null) {
      this.c = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vgq(this, "Q_CIRCLE_PLUGIN_NETWORK", paramString1, paramString2, paramInt));
    }
    return this.c;
  }
  
  public vgs a()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = (vgv)this.jdField_b_of_type_JavaUtilConcurrentFuture.get();
        vgv localvgv2 = (vgv)this.jdField_a_of_type_JavaUtilConcurrentFuture.get();
        if (this.c == null) {
          break label183;
        }
        localvgv1 = (vgv)this.c.get();
        if (a()) {
          return null;
        }
        vgs localvgs = b((vgv)localObject1);
        localObject2 = localvgs;
        if (localvgs == null)
        {
          if (QzoneConfig.useQCircleAssetPluginAlways()) {
            return a(localvgv2);
          }
          localObject1 = localvgs;
          if (localvgv1 != null)
          {
            localObject1 = localvgs;
            if (localvgv2 != null) {
              localObject1 = a(localvgv1, localvgv2);
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localvgv2 != null)
            {
              localObject1 = a(localvgv2, false);
              return localObject1;
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result").setRetCode(5L));
        ILoadPluginDelegate.disPatchCallback(5, "un know exception");
        QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():there is no plugin can be used");
        return null;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        continue;
      }
      return localObject2;
      label183:
      vgv localvgv1 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ThreadManagerExecutor.getExecutorService(192);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vgq(this, "Q_CIRCLE_PLUGIN_ASSET", "", "", -1));
    String str1 = AppConstants.SDCARD_ROOT + "/" + "qcircle-plugin.jpg";
    String str2 = AppConstants.SDCARD_ROOT + "/" + "qcircle-pluginmanager.jpg";
    this.jdField_b_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vgq(this, "Q_CIRCLE_PLUGIN_TEST", str1, str2, -2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgp
 * JD-Core Version:    0.7.0.1
 */