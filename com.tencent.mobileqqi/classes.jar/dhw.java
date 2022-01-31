import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class dhw
  implements View.OnClickListener
{
  public dhw(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SetTroopAdminsActivity.a(this.a) > 0) && (SetTroopAdminsActivity.a(this.a) <= SetTroopAdminsActivity.a(this.a).size() - 1))
    {
      QQToast.a(this.a, 1, String.format(this.a.getString(2131562353), new Object[] { Integer.valueOf(SetTroopAdminsActivity.a(this.a)) }), 0).b(this.a.d());
      return;
    }
    paramView = new Intent(this.a, TroopMemberListActivity.class);
    paramView.putExtra("troop_code", SetTroopAdminsActivity.a(this.a));
    paramView.putExtra("troop_uin", SetTroopAdminsActivity.b(this.a));
    paramView.putExtra("mode", 1);
    this.a.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhw
 * JD-Core Version:    0.7.0.1
 */