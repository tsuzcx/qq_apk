import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zeh
  implements View.OnClickListener
{
  public zeh(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    zef localzef = PermissionSettingActivity.a(this.a).a();
    if (localzef != null)
    {
      PermissionSettingActivity.a(this.a, localzef);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zeh
 * JD-Core Version:    0.7.0.1
 */