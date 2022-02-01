import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class upm
  implements ajdq<aqsy>
{
  public upm(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(aqsy paramaqsy)
  {
    if (this.this$0.mIsDestroyed) {
      return;
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.this$0.p[40];
    localFormSimpleItem.setRightText(paramaqsy.tips);
    localFormSimpleItem.setTag(2131375592, paramaqsy);
    anot.b(null, "dc00898", "", this.this$0.a.troopUin, "qq_vip", "0X800A8F7", paramaqsy.reportType, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upm
 * JD-Core Version:    0.7.0.1
 */