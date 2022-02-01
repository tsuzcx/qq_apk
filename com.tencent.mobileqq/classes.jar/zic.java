import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zic
  implements View.OnClickListener
{
  public zic(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    zia localzia = PermissionSettingActivity.a(this.a).a();
    if (localzia != null)
    {
      PermissionSettingActivity.a(this.a, localzia);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zic
 * JD-Core Version:    0.7.0.1
 */