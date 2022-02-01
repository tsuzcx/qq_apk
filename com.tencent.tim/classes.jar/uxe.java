import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class uxe
  implements amsf.a
{
  public uxe(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void cR(View paramView)
  {
    int i = 1;
    ampt localampt = (ampt)paramView.getTag(2131381960);
    if (localampt == null) {}
    for (;;)
    {
      return;
      String str1 = localampt.getUin();
      String str2 = localampt.getTitle().toString();
      paramView = "-1";
      if ((localampt instanceof amoj))
      {
        paramView = ((amoj)localampt).zc();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.this$0, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.this$0).notifyDataSetChanged();
        return;
        if ((localampt instanceof amon)) {
          paramView = ((amon)localampt).mTroopUin;
        } else if ((localampt instanceof amos)) {
          paramView = ((amos)localampt).a().troopuin;
        } else if ((localampt instanceof amok)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */