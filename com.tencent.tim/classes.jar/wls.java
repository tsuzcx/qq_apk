import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class wls
  implements View.OnClickListener
{
  wls(wll paramwll) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.mDataList == null) || (this.this$0.mDataList.isEmpty())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopWithCommonFriendsFragment.zo(this.this$0.mFriendUin);
      TroopWithCommonFriendsFragment.ac(paramView.getContext(), 2);
      anot.a(null, "dc00898", "", "", "0X800AD22", "0X800AD22", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wls
 * JD-Core Version:    0.7.0.1
 */