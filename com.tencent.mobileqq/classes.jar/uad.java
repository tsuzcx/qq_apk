import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class uad
  implements View.OnClickListener
{
  public uad(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == 15) && (TroopMemberListActivity.a(this.a).size() > 0))
    {
      paramView = new Intent();
      paramView.putExtra("param_deleted_uins", TroopMemberListActivity.a(this.a));
      this.a.setResult(-1, paramView);
      if ((this.a.e == null) || (!this.a.e.equals(this.a.app.getCurrentAccountUin()))) {
        break label159;
      }
    }
    label159:
    for (int i = 0;; i = 1)
    {
      ReportController.b(this.a.app, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.a.b, "" + i, "1", TroopMemberListActivity.a(this.a).toString());
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */