import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.ClearChatRecordTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class upy
  implements arfj.a
{
  public upy(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    ThreadManager.post(new ChatSettingForTroop.ClearChatRecordTask(this.this$0), 5, null, false);
    aqfr.b("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upy
 * JD-Core Version:    0.7.0.1
 */