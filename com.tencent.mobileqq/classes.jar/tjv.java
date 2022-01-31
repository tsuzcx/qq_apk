import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SharedPreUtils;

class tjv
  implements Runnable
{
  tjv(tju paramtju) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.a(this.a.a, this.a.a.app);
    StorageReport.a().a(true);
    this.a.a.a.sendEmptyMessageDelayed(0, 1000L);
    SharedPreUtils.a(this.a.a.app.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjv
 * JD-Core Version:    0.7.0.1
 */