import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.NetworkState;
import java.util.List;

public class avwk
  extends avwc
{
  public avwk(QzoneModuleManager paramQzoneModuleManager) {}
  
  private void eBY()
  {
    if (!NetworkState.isWifiConn())
    {
      QLog.w("QzoneModuleManager", 1, "isWifiConn:false,so stop update.");
      return;
    }
    QzoneModuleManager.access$008(this.this$0);
    for (;;)
    {
      if (QzoneModuleManager.access$000(this.this$0) < QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
      {
        String str = (String)QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.get(QzoneModuleManager.access$000(this.this$0));
        if (this.this$0.checkIfNeedUpdate(str)) {
          this.this$0.updateModule(str, this);
        }
      }
      else
      {
        if (QzoneModuleManager.access$000(this.this$0) != QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size()) {
          break;
        }
        QLog.i("QzoneModuleManager", 1, "updateAllModules completed--totalModules:" + QzoneModuleManager.access$000(this.this$0));
        return;
      }
      QzoneModuleManager.access$008(this.this$0);
    }
  }
  
  public void onDownloadCanceled(String paramString)
  {
    super.onDownloadCanceled(paramString);
    eBY();
  }
  
  public void onDownloadFailed(String paramString)
  {
    super.onDownloadFailed(paramString);
    eBY();
  }
  
  public void onDownloadSucceed(String paramString)
  {
    super.onDownloadSucceed(paramString);
    eBY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwk
 * JD-Core Version:    0.7.0.1
 */