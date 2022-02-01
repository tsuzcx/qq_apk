import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class uxn
  implements amsf.a
{
  public uxn(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void cR(View paramView)
  {
    int i = 3000;
    paramView = (ampt)paramView.getTag(2131381960);
    if (paramView == null) {
      return;
    }
    String str1 = paramView.getUin();
    String str2 = paramView.getTitle().toString();
    if ((paramView instanceof amoj)) {
      paramView = ((amoj)paramView).zc();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onAction, uin = " + str1 + ", displayName = " + str2 + ", troopUin = " + paramView + ", type = " + i);
      }
      if ((i != -1) && (ForwardRecentActivity.a(this.this$0, new ResultRecord(str1, str2, i, paramView, "")))) {
        ForwardRecentActivity.a(this.this$0).notifyDataSetChanged();
      }
      ForwardRecentActivity.h(this.this$0);
      return;
      if ((paramView instanceof amoi))
      {
        paramView = ((amoi)paramView).getUin();
      }
      else if ((paramView instanceof amon))
      {
        paramView = ((amon)paramView).mTroopUin;
        i = 1;
      }
      else if ((paramView instanceof amos))
      {
        paramView = ((amos)paramView).a().troopuin;
        i = 1;
      }
      else if ((paramView instanceof amok))
      {
        i = 0;
        paramView = "-1";
      }
      else
      {
        i = -1;
        paramView = "-1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxn
 * JD-Core Version:    0.7.0.1
 */