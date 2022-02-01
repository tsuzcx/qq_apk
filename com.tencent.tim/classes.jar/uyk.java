import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class uyk
  implements amsf.a
{
  public uyk(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
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
      while ((i != -1) && (ForwardTroopListFragment.a(this.this$0, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.this$0.b.notifyDataSetChanged();
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
 * Qualified Name:     uyk
 * JD-Core Version:    0.7.0.1
 */