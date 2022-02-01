import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class upw
  implements ausj.a
{
  public upw(ChatSettingForTroop paramChatSettingForTroop, int paramInt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      i = 0;
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != this.bFQ) {
        ChatSettingForTroop.a(this.this$0, paramInt);
      }
      try
      {
        this.val$sheet.dismiss();
        aqfr.b("Grp_msg", "grpData_admin", "Close_setmsg", 0, 0, new String[] { this.this$0.a.troopUin, aqfr.a(this.this$0.a), String.valueOf(i) });
        return;
        i = 3;
        paramInt = 4;
        continue;
        i = 1;
        paramInt = 2;
        continue;
        int j = 2;
        paramInt = i;
        i = j;
      }
      catch (Exception paramView)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("Q.chatopttroop", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upw
 * JD-Core Version:    0.7.0.1
 */