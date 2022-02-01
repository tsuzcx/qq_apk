import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yyt
  implements View.OnClickListener
{
  public yyt(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    yxc localyxc;
    if ((paramView.getTag() instanceof yxc))
    {
      localyxc = (yxc)paramView.getTag();
      if ((localyxc != null) && (yyx.ae(TroopWithCommonFriendsFragment.mFriendUin, localyxc.aZP))) {
        break label43;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label43:
      yyx.t(TroopWithCommonFriendsFragment.mFriendUin, localyxc.aZP, false);
      String str = this.a.getString(2131701829);
      localyxc.ej.setText(str);
      localyxc.ej.setClickable(false);
      localyxc.ej.setBackgroundDrawable(null);
      localyxc.ej.setTextAppearance(this.a.k, 2131756687);
      yyx.a(localyxc.aZP, TroopWithCommonFriendsFragment.mFriendUin, "", TroopWithCommonFriendsFragment.a(this.a));
      anot.a(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyt
 * JD-Core Version:    0.7.0.1
 */