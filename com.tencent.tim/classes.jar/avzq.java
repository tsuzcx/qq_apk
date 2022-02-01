import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class avzq
  implements BusinessObserver
{
  private static avzq a;
  private ArrayList<String> Fj = new ArrayList();
  private long aAE;
  private int ezz;
  private long lastReportTime;
  private String reportId;
  
  public avzq()
  {
    ands.a locala = new ands.a();
    locala.load();
    this.aAE = (locala.dFd * 1000);
    this.ezz = locala.report_count;
    this.reportId = locala.reportId;
  }
  
  public static avzq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avzq();
      }
      return a;
    }
    finally {}
  }
  
  private boolean aLW()
  {
    if ((this.Fj != null) && (this.Fj.size() >= this.ezz)) {}
    while (System.currentTimeMillis() - this.lastReportTime > this.aAE) {
      return true;
    }
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("key_response_code");
      String str = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("WMDReportManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
      }
      return;
    }
    QLog.e("WMDReportManager", 1, "onReceive bundle is null");
  }
  
  public void report(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("WMDReportManager", 1, "action is null");
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(this.reportId))
      {
        QLog.e("WMDReportManager", 1, "reportId is null");
        return;
      }
      if (this.lastReportTime == 0L) {
        this.lastReportTime = System.currentTimeMillis();
      }
      synchronized (this.Fj)
      {
        this.Fj.add(paramString);
        if (!aLW()) {
          continue;
        }
        reportImediately();
        return;
      }
    }
  }
  
  public void reportImediately()
  {
    if (this.Fj.isEmpty()) {
      return;
    }
    synchronized (this.Fj)
    {
      Object localObject2 = (ArrayList)this.Fj.clone();
      this.Fj.clear();
      this.lastReportTime = System.currentTimeMillis();
      ??? = new avzr(this.reportId, (ArrayList)localObject2, null);
      localObject2 = new QzoneCommonIntent(BaseApplicationImpl.getContext(), afaf.class);
      ((QzoneCommonIntent)localObject2).setRequest((avpr)???);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzq
 * JD-Core Version:    0.7.0.1
 */