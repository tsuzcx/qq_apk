package dov.com.qq.im.capture.paster;

import android.text.TextUtils;
import aqiw;
import axsz;
import axsz.b;
import axta;
import ayna.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QIMInformationPasterManager$2
  implements Runnable
{
  public QIMInformationPasterManager$2(axsz paramaxsz, List paramList) {}
  
  public void run()
  {
    axsz.a(this.this$0).clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "patch pull res");
    }
    if (!aqiw.isNetworkAvailable(axsz.a(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.Nl.iterator();
      ayna.c localc;
      while (localIterator.hasNext())
      {
        localc = (ayna.c)localIterator.next();
        if ((!TextUtils.isEmpty(localc.resUrl)) && (!this.this$0.a(localc)) && (localc.predownload != 2)) {
          axsz.a(this.this$0).add(localc);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "need download size:" + axsz.a(this.this$0).size());
      }
      localIterator = axsz.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localc = (ayna.c)localIterator.next();
        this.this$0.a.b(localc, new axta(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.2
 * JD-Core Version:    0.7.0.1
 */