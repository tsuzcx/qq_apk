import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class anv
  implements View.OnClickListener
{
  public anv(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296903)
    {
      ForwardRecentActivity.a(this.a, 10);
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
    default: 
      return;
    case 2131296857: 
      localIntent.setClass(this.a, PhoneFrameActivity.class);
      localIntent.putExtra("key_req_type", 2);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "1", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404B", "0X800404B", 0, 0, "", "", "", "");
      return;
      Bundle localBundle = this.a.getIntent().getExtras();
      if ("com.tencent.intent.QQLite_FORWARD".equals(this.a.getIntent().getAction())) {
        localIntent.setAction("com.tencent.intent.QQLite_FORWARD");
      }
      for (;;)
      {
        localIntent.putExtras(localBundle);
        break;
        if (this.a.b) {
          localIntent.setAction("com.tencent.intent.QQLite_FORWARD");
        }
      }
    case 2131296861: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404C", "0X800404C", 0, 0, "", "", "", "");
      return;
    case 2131296863: 
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 1);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.setClass(this.a, TroopActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404D", "0X800404D", 0, 0, "", "", "", "");
      return;
    case 2131297137: 
      localIntent.setClass(this.a, ForwardFriendListActivity.class);
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404A", "0X800404A", 0, 0, "", "", "", "");
      return;
    }
    if ((this.a.b) && (this.a.f != 11)) {
      ForwardRecentActivity.a(this.a);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800404E", "0X800404E", 0, 0, "", "", "", "");
      return;
      ForwardRecentActivity.a(this.a).a("-1010", -1, "", this.a.getString(2131362373));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anv
 * JD-Core Version:    0.7.0.1
 */