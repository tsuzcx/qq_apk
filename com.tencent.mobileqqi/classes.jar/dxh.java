import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class dxh
  implements View.OnClickListener
{
  public dxh(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new ProfileActivity.AllInOne(this.a.b.a(), 0);
    paramView.g = ContactUtils.g(this.a.b, this.a.b.a());
    paramView.e = 3;
    paramView.f = 4;
    ProfileActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxh
 * JD-Core Version:    0.7.0.1
 */