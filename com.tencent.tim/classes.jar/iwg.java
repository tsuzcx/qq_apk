import android.content.IntentFilter;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class iwg
{
  DownloadInfo a = null;
  int auQ = 0;
  ArrayList<iwd.a> iD = new ArrayList();
  
  iwg()
  {
    a(BaseApplicationImpl.getApplication());
    this.a = DownloadInfo.get();
    this.auQ = iwi.a(this.a);
    QLog.d("QavSo", 1, String.format("SoMgr, mStatusSo[%s]", new Object[] { Integer.valueOf(this.auQ) }));
  }
  
  DownloadInfo a()
  {
    if (this.a == null) {
      this.a = DownloadInfo.get();
    }
    return this.a;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.somgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new iwh(this), localIntentFilter) != null;
  }
  
  boolean ug()
  {
    this.a = DownloadInfo.get();
    this.auQ = iwi.a(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavSo", 4, String.format("checkResReady, mStatusSo[%s]", new Object[] { Integer.valueOf(this.auQ) }));
    }
    return 11 != this.auQ;
  }
  
  boolean uh()
  {
    this.a = DownloadInfo.get();
    int i = this.auQ;
    this.auQ = iwi.a(this.a);
    if (this.auQ == 11)
    {
      this.auQ = 12;
      BusinessCommonConfig.notifyQQDownload(3, null, 0);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSo", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusSo[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.auQ) }));
      }
      return bool;
    }
  }
  
  boolean vO()
  {
    return this.auQ == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwg
 * JD-Core Version:    0.7.0.1
 */