import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.qphone.base.util.QLog;

public class dqe
  implements View.OnClickListener
{
  public dqe(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mOnTroopBarItemClickListener, mTroopMemberCard == null");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.a.a.gbarLinkUrl)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "mOnTroopBarItemClickListener, gbarLinkUrl is empty");
    return;
    this.a.d(this.a.a.gbarLinkUrl);
    this.a.f("Clk_tribe");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqe
 * JD-Core Version:    0.7.0.1
 */