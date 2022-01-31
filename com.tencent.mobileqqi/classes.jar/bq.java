import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionCallback;

class bq
  implements PermissionCallback
{
  bq(bn parambn) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a, paramInt, paramArrayOfString, new br(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StatisticAssist.a(this.a.a.b.getApplication().getApplicationContext(), this.a.a.b.a(), "dl_ckpic");
    this.a.a.b();
    ReportController.b(this.a.a.b, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.7.0.1
 */