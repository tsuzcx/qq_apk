import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uqv
  implements CompoundButton.OnCheckedChangeListener
{
  public uqv(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue()) {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    int i;
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
          return;
        } while (this.this$0.b == null);
        i = this.this$0.app.cs(this.this$0.a.troopUin);
      } while (i == -1);
      if (!paramBoolean) {
        break;
      }
    } while (i != 1);
    ChatSettingForTroop.a(this.this$0, 4);
    label82:
    if (ChatSettingForTroop.a(this.this$0) != null) {
      ChatSettingForTroop.d(this.this$0);
    }
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean)
    {
      str = "msg_open";
      label116:
      anot.a(localQQAppInterface, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, this.this$0.a.troopUin, "", "", "");
      if (!paramBoolean) {
        break label224;
      }
    }
    label224:
    for (String str = "msg_open";; str = "msg_close")
    {
      aqfr.b("Grp_msg", "grpData_admin", str, 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a) });
      break;
      if (i == 1) {
        break;
      }
      ChatSettingForTroop.a(this.this$0, 1);
      break label82;
      str = "msg_close";
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqv
 * JD-Core Version:    0.7.0.1
 */