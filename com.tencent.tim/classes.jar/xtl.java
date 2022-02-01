import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xtl
  implements View.OnClickListener
{
  xtl(xtj paramxtj, AIOShortVideoData paramAIOShortVideoData) {}
  
  public void onClick(View paramView)
  {
    xtj.a(this.a, xtj.a(this.a), acfp.m(2131702214));
    boolean bool = anhq.a().axa();
    Activity localActivity = xtj.b(this.a);
    int j = this.b.istroop;
    String str = this.b.friendUin;
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      DanceMachineQQBrowserActivity.a(localActivity, j, str, i, -999, 1, 0, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtl
 * JD-Core Version:    0.7.0.1
 */