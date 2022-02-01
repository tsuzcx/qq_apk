import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yjc
  implements View.OnClickListener
{
  public yjc(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    yja localyja = PermissionSettingActivity.a(this.a).a();
    if (localyja != null)
    {
      PermissionSettingActivity.a(this.a, localyja);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjc
 * JD-Core Version:    0.7.0.1
 */