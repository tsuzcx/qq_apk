import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginBizObserver;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.a;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.i;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.j;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import java.util.ArrayList;
import java.util.Iterator;

public class ujo
  extends DingdongPluginBizObserver
{
  public ujo(BaseChatPie paramBaseChatPie) {}
  
  public void a(DingdongPluginBizObserver.i parami)
  {
    super.a(parami);
    if (this.this$0.app == null) {}
    String str;
    do
    {
      return;
      if (parami.summaryData.specialFlag == -1)
      {
        BaseChatPie.a(this.this$0, parami.summaryData.id, "4", "getScheduleDetailReturn1", true);
        return;
      }
      str = this.this$0.app.getCurrentAccountUin();
    } while (parami.summaryData.authorUin.equals(str));
    Iterator localIterator = parami.Ef.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        DingdongPluginBizObserver.a locala = (DingdongPluginBizObserver.a)localIterator.next();
        if (locala.uin.equals(str)) {
          if (locala.dT == 2) {
            str = "2";
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        BaseChatPie.a(this.this$0, parami.summaryData.id, "4", "getScheduleDetailReturn2", true);
        return;
        str = "1";
        break;
      }
      BaseChatPie.a(this.this$0, parami.summaryData.id, str, "getScheduleDetailReturn3", true);
      return;
      str = "";
    }
  }
  
  public void a(DingdongPluginBizObserver.j paramj)
  {
    super.a(paramj);
    if ((paramj == null) || (paramj.summaryData == null) || (TextUtils.isEmpty(paramj.summaryData.id))) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i(this.this$0.TAG, 1, "ScheduleAccept onAcceptScheduleNotifyPush:" + paramj.summaryData.id);
    }
    BaseChatPie.a(this.this$0, paramj.summaryData.id, "2", "acceptScheduleNotify", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujo
 * JD-Core Version:    0.7.0.1
 */