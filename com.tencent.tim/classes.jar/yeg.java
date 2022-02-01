import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class yeg
  extends acfd
{
  public yeg(TroopChatPie paramTroopChatPie) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = this.this$0.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap == null)
      {
        i = 0;
        QLog.d(str, 2, i);
      }
    }
    else
    {
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break label83;
      }
    }
    label83:
    while (!this.this$0.mActivity.isResume())
    {
      return;
      i = paramMap.size();
      break;
    }
    if (paramBoolean)
    {
      QQToast.a(this.this$0.app.getApp(), 2, this.this$0.mActivity.getString(2131721436), 0).show(this.this$0.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 1, this.this$0.mActivity.getString(2131721435), 0).show(this.this$0.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yeg
 * JD-Core Version:    0.7.0.1
 */