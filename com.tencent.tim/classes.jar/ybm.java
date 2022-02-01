import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ybm
  extends MqqHandler
{
  ybm(ybl paramybl) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
      this.this$0.bF((List)paramMessage.obj);
      if ((ybl.a(this.this$0) == null) || (ybl.a(this.this$0).size() == 0))
      {
        ybl.a(this.this$0, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
        }
        this.this$0.startTitleProgress();
        this.this$0.ez = new MultiForwardChatPie.1.1(this);
        ybl.a(this.this$0).postDelayed(this.this$0.ez, 60000L);
        ThreadRegulator.a().JX(1);
        ajlc.a().a(this.this$0.app, this.this$0.aXd, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, this.this$0.uniseq, 1035, this.this$0.a(ybl.a(this.this$0)));
        return;
      }
      paramMessage = ChatActivityUtils.a(ybl.a(this.this$0), this.this$0.sessionInfo, this.this$0.app);
      paramMessage = ChatActivityUtils.a(this.this$0.app, BaseApplicationImpl.getContext(), this.this$0.sessionInfo, paramMessage, -1L);
      ybl.a(this.this$0).setVisibility(8);
      ybl.a(this.this$0).setVisibility(0);
      ybl.a(this.this$0).setVisibility(0);
      ybl.a(this.this$0).a(ybl.a(this.this$0), paramMessage);
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybm
 * JD-Core Version:    0.7.0.1
 */