import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.j;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.ScheduleReminderMgr.1;

public class atnq
{
  private atnq.a jdField_a_of_type_Atnq$a;
  private DingdongPluginBizObserver.j jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$j;
  private QQAppInterface mApp;
  private Context mContext;
  
  public atnq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = this.mApp.getApp().getBaseContext();
    euk();
  }
  
  private void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScheduleReminderMgr", 1, "showReminderDialog curThread: " + Thread.currentThread() + ", uiThread:" + Looper.getMainLooper().getThread());
    }
    new atnr(this, paramScheduleSummaryData).execute(new Void[] { null, null, null });
  }
  
  private void euk()
  {
    QQAppInterface localQQAppInterface;
    if (!jjl.cK("dingdong_schedule_notify.mp3"))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleReminderMgr", 2, "initSound");
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleReminderMgr", 2, "initSound tempApp is null ");
      }
    }
    return;
    label51:
    jjl.y(localQQAppInterface);
  }
  
  public void b(atnq.a parama)
  {
    this.jdField_a_of_type_Atnq$a = parama;
  }
  
  public void c(DingdongPluginBizObserver.j paramj)
  {
    if (paramj != null)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("ScheduleReminderMgr", 1, "HandlerScheduleOfflineNotify.endTime = " + paramj.summaryData.endTime + " nowTime = " + l);
      }
      if ((paramj.summaryData.endTime > l) && (this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$j == null))
      {
        this.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$j = paramj;
        paramj = new Handler(Looper.myLooper());
        if (paramj != null) {
          paramj.postDelayed(new ScheduleReminderMgr.1(this), 8000L);
        }
      }
    }
  }
  
  public void d(DingdongPluginBizObserver.j paramj)
  {
    if (paramj == null) {
      return;
    }
    if (this.jdField_a_of_type_Atnq$a == null)
    {
      a(paramj.summaryData);
      return;
    }
    this.jdField_a_of_type_Atnq$a.b(paramj.summaryData);
  }
  
  public static abstract interface a
  {
    public abstract void b(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnq
 * JD-Core Version:    0.7.0.1
 */