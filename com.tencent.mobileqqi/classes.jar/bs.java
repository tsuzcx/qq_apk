import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionCallback;

class bs
  implements PermissionCallback
{
  bs(bn parambn) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a, paramInt, paramArrayOfString, new bt(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StatisticAssist.a(this.a.a.b.getApplication().getApplicationContext(), this.a.a.b.a(), "dl_ckvideo");
    paramArrayOfString = new Intent(this.a.a.getApplicationContext(), LiteVideoActivity.class);
    this.a.a.startActivityForResult(paramArrayOfString, 1);
    ReportController.b(this.a.a.b, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bs
 * JD-Core Version:    0.7.0.1
 */