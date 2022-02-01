package cooperation.qzone.report;

import android.text.TextUtils;
import common.config.service.QzoneConfig;

class QzoneReportManager$2
  implements Runnable
{
  public void run()
  {
    if (!QzoneReportManager.aLV())
    {
      QzoneReportManager.config = QzoneConfig.getInstance().getConfig("ClientReport", "report_plog", "");
      QzoneReportManager.dpw = true;
    }
    if (TextUtils.isEmpty(QzoneReportManager.config)) {}
    while ((QzoneReportManager.nH(this.val$type)) && (!QzoneReportManager.nI(this.val$type))) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager.2
 * JD-Core Version:    0.7.0.1
 */