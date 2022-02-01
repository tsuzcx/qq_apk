import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class whg
  implements View.OnClickListener
{
  public whg(ActivateFriendView paramActivateFriendView) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendViewItem localActivateFriendViewItem = (ActivateFriendViewItem)paramView;
    if (localActivateFriendViewItem.isChecked)
    {
      ActivateFriendView.a(this.a);
      if (localActivateFriendViewItem.isChecked) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      localActivateFriendViewItem.setChecked(bool);
      if (ActivateFriendView.a(this.a) != null) {
        ActivateFriendView.a(this.a).BW(ActivateFriendView.c(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ActivateFriendView.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whg
 * JD-Core Version:    0.7.0.1
 */