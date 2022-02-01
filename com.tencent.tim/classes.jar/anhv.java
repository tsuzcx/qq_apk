import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class anhv
{
  ArrayList<anhs.a> AB = new ArrayList();
  DownloadInfo a = null;
  int dGj = 0;
  
  anhv()
  {
    a(BaseApplicationImpl.getApplication());
    this.a = DownloadInfo.get();
    this.dGj = anhx.a(this.a);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.dGj) }));
  }
  
  void a(boolean paramBoolean, anhs.a parama)
  {
    localArrayList = this.AB;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.AB.add(parama);
        return;
      }
      finally {}
      this.AB.remove(parama);
    }
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new anhw(this), localIntentFilter) != null;
  }
  
  boolean axd()
  {
    return this.dGj == 1;
  }
  
  boolean axe()
  {
    boolean bool = true;
    if (this.a == null) {
      return false;
    }
    if ((this.dGj == 1) && (anhx.c(this.a))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean ug()
  {
    this.a = DownloadInfo.get();
    this.dGj = anhx.a(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("checkResReady, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.dGj) }));
    }
    return 11 != this.dGj;
  }
  
  boolean uh()
  {
    this.a = DownloadInfo.get();
    int i = this.dGj;
    this.dGj = anhx.a(this.a);
    if (this.dGj == 11)
    {
      this.dGj = 12;
      BusinessCommonConfig.notifyQQDownload(1, null, 0);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGesture", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGesture[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.dGj) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhv
 * JD-Core Version:    0.7.0.1
 */