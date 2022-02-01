import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxa
  implements View.OnClickListener
{
  public aaxa(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.a.yW(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxa
 * JD-Core Version:    0.7.0.1
 */