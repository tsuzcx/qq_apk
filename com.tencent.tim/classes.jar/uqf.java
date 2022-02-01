import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

public class uqf
  extends acfd
{
  public uqf(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    super.onSetGenralSettingsTroopFilter(paramBoolean, paramMap);
    if ((paramMap == null) || (this.this$0.b == null)) {
      return;
    }
    if (!paramBoolean) {
      if (paramMap.get(this.this$0.b.troopuin) != null) {
        QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131721435), 0).show(this.this$0.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.this$0.mUIHandler.sendEmptyMessage(17);
      return;
      paramMap = (Integer)paramMap.get(this.this$0.b.troopuin);
      if (paramMap != null) {
        this.this$0.b.troopmask = paramMap.intValue();
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l != 0L) {
        this.this$0.fH(l);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
    }
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uqf
 * JD-Core Version:    0.7.0.1
 */