import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yys
  implements View.OnClickListener
{
  public yys(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof yxc))
    {
      localObject = (yxc)paramView.getTag();
      if (localObject != null) {
        break label30;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label30:
      localObject = TroopInfoActivity.c(((yxc)localObject).aZP, 4);
      ((Bundle)localObject).putInt("t_s_f", 1002);
      apuh.a(this.a.getActivity(), (Bundle)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yys
 * JD-Core Version:    0.7.0.1
 */