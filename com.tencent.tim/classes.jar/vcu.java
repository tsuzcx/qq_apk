import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vcu
  implements View.OnClickListener
{
  public vcu(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 20);
      this.a.bPG();
      continue;
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 21);
      this.a.bPG();
      continue;
      Intent localIntent = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(localIntent);
      continue;
      localIntent = new Intent(this.a, GesturePWDCreateActivity.class);
      this.a.startActivityForResult(localIntent, 11);
      this.a.overridePendingTransition(2130772009, 2130772002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */