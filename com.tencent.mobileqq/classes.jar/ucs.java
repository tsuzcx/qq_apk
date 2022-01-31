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

public class ucs
  implements View.OnClickListener
{
  public ucs(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L)) {
      return;
    }
    TroopRequestActivity.c = l;
    Bundle localBundle = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 4);
    localBundle.putInt("t_s_f", 1001);
    int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    QQAppInterface localQQAppInterface;
    String str;
    if ((i == 2) || (i == 10) || (i == 12))
    {
      i = 1;
      localQQAppInterface = this.a.app;
      str = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
      if (i == 0) {
        break label182;
      }
    }
    label182:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucs
 * JD-Core Version:    0.7.0.1
 */