import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.13.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class apqo
  implements anyo.a
{
  apqo(apqk paramapqk) {}
  
  public void byj()
  {
    this.this$0.playState = 1;
    if ((this.this$0.mBaseChatPie == null) && (this.this$0.mActivity == null) && (!apqk.cqs.equals(this.this$0.cqt))) {}
    String str1;
    List localList;
    do
    {
      return;
      if (this.this$0.mBaseChatPie == null) {
        break;
      }
      str1 = this.this$0.mBaseChatPie.sessionInfo.aTl;
      localList = (List)this.this$0.op.get(str1);
    } while ((aptj.isListEmpty(localList)) || (localList == null));
    if (localList != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (apqk.c)localList.remove(0);
        if ((localObject3 instanceof MessageForDeliverGiftTips))
        {
          localObject3 = (MessageForDeliverGiftTips)localObject3;
          String str2 = aptj.b((MessageForDeliverGiftTips)localObject3);
          ((MessageForDeliverGiftTips)localObject3).hasFetchButFailed = false;
          if (QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "onMagicPlayEnd id:" + str2);
          }
          if (this.this$0.a != null) {
            this.this$0.a.cR(str1, str2);
          }
        }
        if (localList.size() == 0) {
          break label250;
        }
        Collections.sort(localList, this.this$0.ah);
        this.this$0.mHandler.post(new AIOAnimationControlManager.13.1(this));
        return;
      }
      finally {}
      Object localObject2 = this.this$0.cqt;
      break;
      label250:
      this.this$0.b.b(null);
      apqk.a(this.this$0, false);
      localObject2 = ChatActivityUtils.a((String)localObject2, this.this$0.mApp.getCurrentAccountUin());
      if ((apqk.cRX) && (localObject2 != null) && (-1 == ((Integer)localObject2).intValue()) && (this.this$0.mBaseChatPie != null)) {
        apqk.cRX = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqo
 * JD-Core Version:    0.7.0.1
 */