import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class algo
  implements View.OnClickListener
{
  public algo(ProfileHeaderView paramProfileHeaderView, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.app.getApp().getSharedPreferences(this.this$0.app.getCurrentAccountUin(), 0).edit().putBoolean("common_topic_friend_list_should_show", false).apply();
    this.FY.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algo
 * JD-Core Version:    0.7.0.1
 */