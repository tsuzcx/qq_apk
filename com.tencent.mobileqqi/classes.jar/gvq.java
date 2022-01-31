import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.ViewHolder;

public class gvq
  implements View.OnClickListener
{
  public gvq(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopAdminList.ViewHolder)paramView.getTag();
    if (paramView != null)
    {
      paramView = paramView.a;
      if (!this.a.b.a().equals(paramView)) {
        break label53;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 0);
    }
    for (;;)
    {
      ProfileActivity.a(this.a, paramView);
      return;
      label53:
      Friends localFriends = ((FriendManager)this.a.b.getManager(8)).c(paramView);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
        paramView.g = localFriends.name;
        paramView.h = localFriends.remark;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 19);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvq
 * JD-Core Version:    0.7.0.1
 */