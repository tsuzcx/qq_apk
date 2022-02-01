import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;

class vwl
  implements Downloader.DownloadListener
{
  vwl(vwj paramvwj, QCirclePluginInfo paramQCirclePluginInfo, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1001L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
    QLog.e("QCirclePluginManager", 1, "onDownloadFailed qcirle-plugin.zip ");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String arg1, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-plugin.zip ");
    ??? = new File(this.jdField_a_of_type_JavaLangString);
    if ((???.exists()) && (???.length() == this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.zipFileLength))
    {
      String str2 = "";
      String str3 = "";
      String str1 = str3;
      ??? = str2;
      if (paramDownloadResult != null)
      {
        str1 = str3;
        ??? = str2;
        if (paramDownloadResult.getReport() != null)
        {
          ??? = String.valueOf(paramDownloadResult.getReport().fileSize);
          str1 = String.valueOf(paramDownloadResult.getReport().downloadTime);
        }
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1000L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version).setExt1(???).setExt2(str1));
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath)) {
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
      }
      synchronized (vwj.a())
      {
        while (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady)
        {
          vwj.a(this.jdField_a_of_type_Vwj).delete(QCirclePluginInfo.class.getSimpleName(), null, null);
          this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.setStatus(1000);
          vwj.a(this.jdField_a_of_type_Vwj).persistOrReplace(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo);
          return;
          ??? = (QCirclePluginInfo)vwj.a(this.jdField_a_of_type_Vwj).find(QCirclePluginInfo.class, this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version + "");
          if ((??? != null) && (???.pluginManagerPath != null))
          {
            this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath = ???.pluginManagerPath;
            this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
          }
        }
        vwj.a(this.jdField_a_of_type_Vwj).delete(QCirclePluginInfo.class.getSimpleName(), "version=?", new String[] { this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version + "" });
      }
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1002L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
    QLog.e("QCirclePluginManager", 1, "file.exists " + ???.exists() + "file.length()= " + ???.length() + " zipFileLength= " + this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.zipFileLength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwl
 * JD-Core Version:    0.7.0.1
 */