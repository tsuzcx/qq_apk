import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.QCircleConstants;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class vvj
{
  private static final String jdField_a_of_type_JavaLangString = QCircleConstants.QCIRCLE_INNER_ROOT_PATH + "qcirclePlugin/";
  private static volatile vvj jdField_a_of_type_Vvj;
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "pluginAsset/";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.context;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private Future<vvp> jdField_a_of_type_JavaUtilConcurrentFuture;
  private Future<vvp> jdField_b_of_type_JavaUtilConcurrentFuture;
  private Future<vvp> c;
  
  private String a(Future<vvp> paramFuture)
  {
    if (paramFuture != null) {
      try
      {
        if (paramFuture.get() != null)
        {
          paramFuture = ((vvp)paramFuture.get()).toString();
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
  
  public static vvj a()
  {
    if (jdField_a_of_type_Vvj == null) {}
    try
    {
      if (jdField_a_of_type_Vvj == null) {
        jdField_a_of_type_Vvj = new vvj();
      }
      return jdField_a_of_type_Vvj;
    }
    finally {}
  }
  
  private vvm a(vvp paramvvp)
  {
    if (paramvvp != null)
    {
      if (!a(paramvvp.a(), paramvvp.c())) {
        break label47;
      }
      if (paramvvp.a() >= 8041000) {
        return new vvm(paramvvp);
      }
      QLog.i("QCIRCLE_PLUGIN", 1, "checkNetOnly():version not support");
    }
    for (;;)
    {
      return null;
      label47:
      QLog.i("QCIRCLE_PLUGIN", 1, "checkNetOnly():crash to many time");
    }
  }
  
  private vvm a(vvp paramvvp1, vvp paramvvp2)
  {
    if (paramvvp1.a() > paramvvp2.a())
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_asset").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvvp1.a()).setExt1(String.valueOf(paramvvp2.a())).setRetCode(0L));
      if (a(paramvvp1.a(), paramvvp1.c()))
      {
        if (paramvvp1.a() >= 8041000)
        {
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_minversion").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvvp1.a()).setExt1(String.valueOf(8041000)).setRetCode(0L));
          QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():use netWork plugin, net version:" + paramvvp1.a() + " asset version:" + paramvvp2.a() + " MiniSupportVersion" + 8041000);
          return new vvm(paramvvp1);
        }
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_minversion").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvvp1.a()).setExt1(String.valueOf(8041000)).setRetCode(1L));
        QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvvp1.a() + " mini not support, go to checkAsset");
        return a(paramvvp2, true);
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_crash_max").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvvp1.a()).setExt1(String.valueOf(8041000)).setRetCode(1L));
      QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvvp1.a() + " crash too many, go to checkAsset");
      return a(paramvvp2, true);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "checkNet():net plugin version:" + paramvvp1.a() + " lower then asset, go to checkAsset");
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_net_compare_asset").setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(paramvvp1.a()).setExt1(String.valueOf(paramvvp2.a())).setRetCode(1L));
    return a(paramvvp2, true);
  }
  
  private vvm a(vvp paramvvp, boolean paramBoolean)
  {
    if (a(paramvvp.a(), paramvvp.c()))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "checkAsset():use asset plugin , assetVersion:" + paramvvp.a() + " , hasNetPlugin: " + paramBoolean + " ,MiniSupportVersion" + 8041000);
      return new vvm(paramvvp);
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result").setPluginType("Q_CIRCLE_PLUGIN_ASSET").setPluginVersion(paramvvp.a()).setRetCode(3L));
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
    vwj.a().a(paramInt);
    QLog.i("QCIRCLE_PLUGIN", 1, "crashValidEnable():net plugin ,current version:" + paramInt + ",crashed to many times");
    return false;
  }
  
  private boolean a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    if (paramQCirclePluginInfo == null) {
      return false;
    }
    if ((FileUtil.isFileExists(paramQCirclePluginInfo.pluginManagerPath)) && (FileUtil.isFileExists(paramQCirclePluginInfo.pluginZipPath)))
    {
      File localFile1 = new File(paramQCirclePluginInfo.pluginManagerPath);
      File localFile2 = new File(paramQCirclePluginInfo.pluginZipPath);
      if ((localFile1.length() == paramQCirclePluginInfo.managerFilelength) && (localFile2.length() == paramQCirclePluginInfo.zipFileLength))
      {
        QLog.i("QCIRCLE_PLUGIN", 1, "fileLengthValid():true");
        return true;
      }
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "fileLengthValid():false");
    return false;
  }
  
  private vvm b(vvp paramvvp)
  {
    if (paramvvp != null)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_wns_load_asset").setPluginType("Q_CIRCLE_PLUGIN_ASSET").setPluginVersion(paramvvp.a()));
      QLog.i("QCIRCLE_PLUGIN", 1, "checkWNS():WNS force use asset");
      return a(paramvvp, false);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():WNS force use asset no asset info");
    return null;
  }
  
  private vvm c(vvp paramvvp)
  {
    if (paramvvp != null) {}
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
  
  public Future<vvp> a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    if (!a(paramQCirclePluginInfo)) {
      return null;
    }
    if (this.c == null) {
      this.c = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vvk(this, "Q_CIRCLE_PLUGIN_NETWORK", paramQCirclePluginInfo));
    }
    return this.c;
  }
  
  public vvm a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (vvp)this.jdField_b_of_type_JavaUtilConcurrentFuture.get();
        vvp localvvp2 = (vvp)this.jdField_a_of_type_JavaUtilConcurrentFuture.get();
        if (this.c != null)
        {
          localvvp1 = (vvp)this.c.get();
          if (a()) {
            return null;
          }
          Object localObject2 = c((vvp)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (QzoneConfig.useQCircleAssetPluginAlways()) {
              return b(localvvp2);
            }
            localObject1 = localObject2;
            if (localvvp1 != null)
            {
              localObject1 = localObject2;
              if (localvvp2 != null) {
                localObject1 = a(localvvp1, localvvp2);
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              if (localvvp2 != null) {
                localObject2 = a(localvvp2, false);
              }
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (localvvp1 != null)
              {
                localObject1 = localObject2;
                if (localvvp2 == null)
                {
                  localObject1 = a(localvvp1);
                  return localObject1;
                }
              }
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():exception:" + localInterruptedException.getMessage());
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_load_result").setRetCode(5L));
        ILoadPluginDelegate.disPatchCallback(5, "un know exception");
        QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():there is no plugin can be used");
        return null;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
        QLog.i("QCIRCLE_PLUGIN", 1, "createMangerUpdate():exception:" + localExecutionException.getMessage());
        continue;
        return localExecutionException;
      }
      vvp localvvp1 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = QCircleFeedPicLoader.createPool(1, 1);
    QCirclePluginInfo localQCirclePluginInfo = new QCirclePluginInfo();
    localQCirclePluginInfo.version = -1;
    this.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vvk(this, "Q_CIRCLE_PLUGIN_ASSET", localQCirclePluginInfo));
    localQCirclePluginInfo = new QCirclePluginInfo();
    localQCirclePluginInfo.version = -2;
    localQCirclePluginInfo.pluginZipPath = (AppConstants.SDCARD_ROOT + "/" + "qcircle-plugin.jpg");
    localQCirclePluginInfo.pluginManagerPath = (AppConstants.SDCARD_ROOT + "/" + "qcircle-pluginmanager.jpg");
    this.jdField_b_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new vvk(this, "Q_CIRCLE_PLUGIN_TEST", localQCirclePluginInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvj
 * JD-Core Version:    0.7.0.1
 */