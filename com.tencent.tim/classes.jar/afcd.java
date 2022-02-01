import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class afcd
  implements Handler.Callback
{
  public afcd(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label192:
    do
    {
      return false;
      if ((!this.this$0.Pr()) && (this.this$0.a.getMode() == -1) && (paramMessage.obj != null))
      {
        paramMessage = (List)paramMessage.obj;
        this.this$0.f.cS(paramMessage);
        this.this$0.yT.clear();
        this.this$0.yT.addAll(paramMessage);
        this.this$0.cWQ();
        int j = this.this$0.q(paramMessage);
        ajrb.c(this.this$0.app.getCurrentAccountUin(), "nearby_msg_tab_last_num", Integer.valueOf(j));
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("BaseMsgBoxActivity, MSG_REFRESH_LIST_UI, lastUnReadNum=").append(this.this$0.cQa).append(", newUnReadNum=").append(j).append(", msgList.size=");
          if (paramMessage == null)
          {
            i = 0;
            QLog.d("nearby.msgbox.tab", 2, i + ", showRedDot=" + this.this$0.bXg);
          }
        }
        else if (this.this$0.isFromNearby)
        {
          localObject = this.this$0.mUIHandler.obtainMessage(1);
          this.this$0.mUIHandler.removeMessages(1);
          ((Message)localObject).arg1 = j;
          this.this$0.mUIHandler.sendMessageDelayed((Message)localObject, 500L);
          if (paramMessage.size() != 0) {
            break label403;
          }
          this.this$0.BB.setVisibility(0);
          if (!BaseMsgBoxActivity.a(this.this$0)) {
            break label418;
          }
          this.this$0.mFooterView.setVisibility(8);
        }
        while (!this.this$0.bTI)
        {
          this.this$0.F.setVisibility(8);
          this.this$0.bTI = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg_box", 2, "init ui cost time : " + (System.currentTimeMillis() - this.this$0.VX));
          return false;
          i = paramMessage.size();
          break label192;
          this.this$0.BB.setVisibility(8);
          break label298;
          this.this$0.mFooterView.setVisibility(0);
        }
      }
      this.this$0.bTJ = true;
      return false;
      this.this$0.bXg = true;
      int i = paramMessage.arg1;
      this.this$0.cQa = i;
      if (this.this$0.cQa < 0) {
        this.this$0.bXg = false;
      }
    } while ((this.this$0.s == null) || (!this.this$0.bXg));
    label298:
    NearbyActivity.a(this.this$0.s, this.this$0.cQa);
    label403:
    label418:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcd
 * JD-Core Version:    0.7.0.1
 */