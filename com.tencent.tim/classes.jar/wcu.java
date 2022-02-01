import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wcu
  implements View.OnClickListener
{
  public wcu(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.Hw > 0L) && (l - TroopRequestActivity.Hw < 800L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopRequestActivity.Hw = l;
    Bundle localBundle = TroopInfoActivity.c(this.this$0.aKI, 4);
    localBundle.putInt("t_s_f", 1001);
    int i = this.this$0.a.msg.group_msg_type.get();
    label97:
    QQAppInterface localQQAppInterface;
    String str2;
    if ((i == 2) || (i == 10) || (i == 12))
    {
      i = 1;
      localQQAppInterface = this.this$0.app;
      str2 = this.this$0.a.msg.group_code.get() + "";
      if (i == 0) {
        break label193;
      }
    }
    label193:
    for (String str1 = "0";; str1 = "1")
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str2, str1, "", "");
      apuh.a(this.this$0, localBundle, 2);
      break;
      i = 0;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wcu
 * JD-Core Version:    0.7.0.1
 */