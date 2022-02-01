import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.biz.pubaccount.util.PAReportManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;

public class obk
  implements Handler.Callback, Manager
{
  private QQAppInterface app;
  private aurf c;
  private EntityManager em;
  private List<PAReportInfo> kQ = new ArrayList();
  private volatile int mCount = -1;
  
  public obk(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = this.app.a().createEntityManager();
    this.c = new aurf(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void a(PAReportInfo paramPAReportInfo)
  {
    this.c.post(new PAReportManager.1(this, paramPAReportInfo));
  }
  
  public void bdf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "scheduleReport ... size = " + this.kQ.size() + ", count = " + this.mCount);
    }
    if ((this.kQ.size() == 0) && (this.mCount == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "scheduleReport ... No need query DB");
      }
    }
    do
    {
      return;
      if (this.kQ.size() != 0) {
        break;
      }
    } while (this.c.hasMessages(100001));
    this.c.sendEmptyMessageDelayed(100001, 3000L);
    return;
    this.c.sendEmptyMessage(100002);
  }
  
  public void bdg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "queryDatabases ... size = " + this.kQ.size() + ", count = " + this.mCount);
    }
    if (this.mCount == -1) {
      this.mCount = this.app.getReadableDatabase().getCount(PAReportInfo.class.getSimpleName());
    }
    List localList2 = this.em.query(PAReportInfo.class, true, null, (String[])null, null, null, null, String.valueOf(20));
    if (localList2 != null) {}
    synchronized (this.kQ)
    {
      this.kQ.addAll(localList2);
      this.c.sendEmptyMessage(100002);
      return;
    }
  }
  
  public void bdh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAReport", 2, "reporting ... size = " + this.kQ.size() + ", count = " + this.mCount);
    }
    if (this.kQ.size() <= 0) {}
    for (;;)
    {
      return;
      Object localObject1 = (PAReportInfo)this.kQ.get(0);
      if (!this.em.remove((Entity)localObject1)) {
        continue;
      }
      this.mCount -= 1;
      synchronized (this.kQ)
      {
        this.kQ.remove(0);
        ??? = new ArrayList();
        localObject1 = ((PAReportInfo)localObject1).msgIds.split("\\|");
        int j = localObject1.length;
        int i = 0;
        if (i >= j) {
          continue;
        }
        ((List)???).add(localObject1[i]);
        i += 1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      bdg();
      return true;
    }
    if (paramMessage.what == 100002)
    {
      bdh();
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.em.close();
    synchronized (this.kQ)
    {
      this.kQ.clear();
      this.mCount = -1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obk
 * JD-Core Version:    0.7.0.1
 */