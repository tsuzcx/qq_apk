import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class arzd
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  arzd(aryy paramaryy) {}
  
  public void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList)
  {
    if ((paramArrayList == null) && (QLog.isColorLevel())) {
      QLog.i("DownloadManager_", 2, "logList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzd
 * JD-Core Version:    0.7.0.1
 */