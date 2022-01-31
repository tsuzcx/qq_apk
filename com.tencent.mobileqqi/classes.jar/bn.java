import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class bn
  implements AdapterView.OnItemClickListener
{
  public bn(LiteActivity paramLiteActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (LiteActivity.a(this.a).a()[paramInt][1])
    {
    default: 
      return;
    case 2130837773: 
      if ((!this.a.permissionManager.checkPermission("android.permission.CAMERA")) || (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new bo(this));
        return;
      }
      StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "dl_cktkphoto");
      this.a.d_();
      ReportController.b(this.a.b, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      return;
    case 2130837778: 
      if (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new bq(this));
        return;
      }
      StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "dl_ckpic");
      this.a.b();
      ReportController.b(this.a.b, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return;
    case 2130837782: 
      if (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new bs(this));
        return;
      }
      StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "dl_ckvideo");
      paramAdapterView = new Intent(this.a.getApplicationContext(), LiteVideoActivity.class);
      this.a.startActivityForResult(paramAdapterView, 1);
      ReportController.b(this.a.b, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
      return;
    }
    if (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new bu(this));
      return;
    }
    StatisticAssist.a(this.a.b.getApplication().getApplicationContext(), this.a.b.a(), "dl_ckfile");
    paramAdapterView = new Intent(this.a.getApplicationContext(), FMLocalFileActivity.class);
    paramAdapterView.putExtra("category", 6);
    paramAdapterView.putExtra("selectMode", true);
    paramAdapterView.putExtra("targetUin", AppConstants.P);
    this.a.startActivityForResult(paramAdapterView, 2);
    ReportController.b(this.a.b, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.7.0.1
 */