import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionCallback;

class bu
  implements PermissionCallback
{
  bu(bn parambn) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a, paramInt, paramArrayOfString, new bv(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StatisticAssist.a(this.a.a.b.getApplication().getApplicationContext(), this.a.a.b.a(), "dl_ckfile");
    paramArrayOfString = new Intent(this.a.a.getApplicationContext(), FMLocalFileActivity.class);
    paramArrayOfString.putExtra("category", 6);
    paramArrayOfString.putExtra("selectMode", true);
    paramArrayOfString.putExtra("targetUin", AppConstants.P);
    this.a.a.startActivityForResult(paramArrayOfString, 2);
    ReportController.b(this.a.a.b, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.7.0.1
 */