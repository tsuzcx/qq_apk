import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class inb
{
  imz a = null;
  int aqm = 0;
  ArrayList<ina.a> ip = new ArrayList();
  
  inb()
  {
    a(BaseApplicationImpl.getApplication());
    this.a = imz.a();
    this.aqm = inf.a(this.a);
    QLog.d("QavGPDownloadManager", 1, String.format("QavGPDownloadObserver, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.aqm) }));
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.qavgameplaysomgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new inc(this), localIntentFilter) != null;
  }
  
  boolean ug()
  {
    this.a = imz.a();
    this.aqm = inf.a(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("checkResReady, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.aqm) }));
    }
    return 11 != this.aqm;
  }
  
  boolean uh()
  {
    this.a = imz.a();
    int i = this.aqm;
    this.aqm = inf.a(this.a);
    if (this.aqm == 11)
    {
      this.aqm = 12;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intent localIntent = new Intent();
      localIntent.setAction("from_qavgpsomgr_download");
      localIntent.setClass(localBaseApplicationImpl.getApplicationContext(), JumpActivity.class);
      localIntent.addFlags(268435456);
      localBaseApplicationImpl.getBaseContext().startActivity(localIntent);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGameplay[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.aqm) }));
      }
      return bool;
    }
  }
  
  boolean ui()
  {
    return this.aqm == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inb
 * JD-Core Version:    0.7.0.1
 */