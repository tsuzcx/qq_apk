import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cmm
  implements View.OnClickListener
{
  public cmm(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131233087)
    {
      ForwardRecentActivity.a(this.a, 10);
      return;
    }
    if (paramView.getId() == 2131231380)
    {
      if ((ForwardRecentActivity.a(this.a) != null) && (ForwardRecentActivity.a(this.a).u == 11))
      {
        ForwardOperations.a(this.a, false, "shareToQQ", ForwardRecentActivity.a(this.a).a);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = false;
      }
      this.a.finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("call_by_forward", true);
    if (this.a.jdField_a_of_type_AndroidNetUri != null) {
      localIntent.setData(this.a.jdField_a_of_type_AndroidNetUri);
    }
    if (this.a.getIntent().getBooleanExtra("isFromShare", false))
    {
      localIntent.putExtras(this.a.jdField_a_of_type_AndroidOsBundle);
      localIntent.setAction(this.a.getIntent().getAction());
    }
    switch (paramView.getId())
    {
    case 2131231713: 
    case 2131231715: 
    case 2131231717: 
    case 2131231719: 
    case 2131231721: 
    default: 
      return;
    case 2131231712: 
      localIntent.setClass(this.a, ForwardFriendListActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.b, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
      ReportController.b(this.a.b, "CliOper", "", "", "0X800404A", "0X800404A", 0, 0, "", "", "", "");
      return;
      Bundle localBundle = this.a.getIntent().getExtras();
      if ("com.tencent.intent.QQI_FORWARD".equals(this.a.getIntent().getAction())) {
        localIntent.setAction("com.tencent.intent.QQI_FORWARD");
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        break;
        if (this.a.jdField_a_of_type_Boolean) {
          localIntent.setAction("com.tencent.intent.QQI_FORWARD");
        }
      }
    case 2131231714: 
      localIntent.setClass(this.a, PhoneFrameActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.b, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "1", "", "", "");
      ReportController.b(this.a.b, "CliOper", "", "", "0X800404B", "0X800404B", 0, 0, "", "", "", "");
      return;
    case 2131231718: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.b, "CliOper", "", "", "0X800404C", "0X800404C", 0, 0, "", "", "", "");
      return;
    case 2131231720: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 1);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.b, "CliOper", "", "", "0X800404D", "0X800404D", 0, 0, "", "", "", "");
      return;
    case 2131231716: 
      ReportController.b(this.a.b, "CliOper", "", "", "Network_circle", "Forward_circle_clk", 0, 0, "", "", "", "");
      localIntent.setClass(this.a, NewFriendActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      return;
    }
    if ((this.a.jdField_a_of_type_Boolean) && (this.a.f != 11)) {
      ForwardRecentActivity.a(this.a);
    }
    for (;;)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "0X800404E", "0X800404E", 0, 0, "", "", "", "");
      return;
      ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131560461));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmm
 * JD-Core Version:    0.7.0.1
 */