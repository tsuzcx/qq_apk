import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rki
  implements View.OnClickListener
{
  public rki(PermissionSettingActivity paramPermissionSettingActivity) {}
  
  public void onClick(View paramView)
  {
    rkh localrkh = PermissionSettingActivity.a(this.a).a();
    if (localrkh != null)
    {
      PermissionSettingActivity.a(this.a, localrkh);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rki
 * JD-Core Version:    0.7.0.1
 */