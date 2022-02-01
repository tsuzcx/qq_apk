import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yxv
  implements View.OnClickListener
{
  public yxv(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    yxt localyxt = PermissionSettingActivity.a(this.a).a();
    if (localyxt != null)
    {
      PermissionSettingActivity.a(this.a, localyxt);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxv
 * JD-Core Version:    0.7.0.1
 */