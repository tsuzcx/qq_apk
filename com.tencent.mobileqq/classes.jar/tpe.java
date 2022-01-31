import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

class tpe
  implements Runnable
{
  tpe(tpd paramtpd) {}
  
  public void run()
  {
    ReportController.b(this.a.a.app, "dc00898", "", "", "0X8007914", "0X8007914", 0, 0, this.a.a.app.getCurrentAccountUin(), "", "", "");
    HttpDownloadUtil.a("http://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpe
 * JD-Core Version:    0.7.0.1
 */