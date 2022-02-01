import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import mqq.app.permission.PermissionManager;

public class csb
  implements AdapterView.OnItemClickListener
{
  public csb(Leba paramLeba) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (Leba.b(this.a)) {
      if (paramInt == 1) {
        if ((!this.a.a().permissionManager.checkPermission("android.permission.CAMERA")) || (!this.a.a().permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) || (!this.a.a().permissionManager.checkPermission("android.permission.ACCESS_FINE_LOCATION")))
        {
          paramAdapterView = new PermissionsDialog();
          localBaseActivity = this.a.a();
          paramView = new csc(this, paramView, paramInt);
          paramAdapterView.a(localBaseActivity, new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION" }, paramView);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      BaseActivity localBaseActivity;
      return;
      Leba.b(this.a, false);
      this.a.a(paramView, paramInt, null);
      this.a.a.postDelayed(new csg(this), 500L);
      return;
      if ((paramInt == 2) || (paramInt == 7) || (paramInt == 8))
      {
        if (!this.a.a().permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
        {
          paramAdapterView = new PermissionsDialog();
          localBaseActivity = this.a.a();
          paramView = new csh(this, paramView, paramInt);
          paramAdapterView.a(localBaseActivity, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, paramView);
          return;
        }
        Leba.b(this.a, false);
        this.a.a(paramView, paramInt, null);
        this.a.a.postDelayed(new csl(this), 500L);
        return;
      }
      Leba.b(this.a, false);
      this.a.a(paramView, paramInt, null);
      this.a.a.postDelayed(new csm(this), 500L);
      return;
    }
    QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csb
 * JD-Core Version:    0.7.0.1
 */