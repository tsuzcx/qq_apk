import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class bpq
  implements View.OnClickListener
{
  public bpq(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.d > 0L) && (l - TroopRequestActivity.d < 800L)) {
      return;
    }
    TroopRequestActivity.d = l;
    Bundle localBundle = TroopInfoActivity.a(this.a.p, 4);
    int i = TroopRequestActivity.a(this.a).msg.group_msg_type.get();
    QQAppInterface localQQAppInterface;
    String str;
    if ((i == 2) || (i == 10) || (i == 12))
    {
      i = 1;
      localQQAppInterface = this.a.app;
      str = TroopRequestActivity.a(this.a).msg.group_code.get() + "";
      if (i == 0) {
        break label172;
      }
    }
    label172:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, paramView, "", "");
      ChatSettingForTroop.a(this.a, localBundle, 2);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bpq
 * JD-Core Version:    0.7.0.1
 */