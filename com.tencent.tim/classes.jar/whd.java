import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.a;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.b;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class whd
  implements View.OnClickListener
{
  public whd(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendGridItem localActivateFriendGridItem = (ActivateFriendGridItem)paramView;
    if (localActivateFriendGridItem.isChecked)
    {
      ActivateFriendGrid.a(this.b);
      if (localActivateFriendGridItem.isChecked) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      localActivateFriendGridItem.setChecked(bool);
      if (ActivateFriendGrid.a(this.b) != null) {
        ActivateFriendGrid.a(this.b).BW(ActivateFriendGrid.c(this.b));
      }
      if (ActivateFriendGrid.a(this.b) != null) {
        ActivateFriendGrid.a(this.b).rr(localActivateFriendGridItem.index);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ActivateFriendGrid.b(this.b);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whd
 * JD-Core Version:    0.7.0.1
 */