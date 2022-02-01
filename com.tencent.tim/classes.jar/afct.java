import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;

public class afct
  extends afcu.a
{
  public afct(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.this$0.app.a().addMessage(paramString, 0, paramInt, paramLong, 1);
      }
      while (!this.this$0.isFinishing())
      {
        this.this$0.cWP();
        return;
        if (this.this$0.app.a().isInMsgBoxRecentList(acbn.bli, this.this$0.cMA))
        {
          paramInt = this.this$0.app.a().A(acbn.bli, this.this$0.cMA);
          this.this$0.app.b().c(this.this$0.bwL, this.this$0.cMA, acbn.bli, this.this$0.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            aalb.l(this.this$0.app, acbn.bli, this.this$0.cMA);
            this.this$0.app.b().a(acbn.bli, this.this$0.cMA, true, true);
          }
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("MsgBoxListActivity", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.this$0.app.a().addMessage(paramString, 0, paramInt, paramLong, 2);
      }
      while (!this.this$0.isFinishing())
      {
        this.this$0.cWP();
        return;
        if (this.this$0.app.a().isInMsgBoxRecentList(acbn.blj, this.this$0.cMA))
        {
          paramInt = this.this$0.app.a().A(acbn.blj, this.this$0.cMA);
          this.this$0.app.b().c(this.this$0.bwL, this.this$0.cMA, acbn.blj, this.this$0.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            aalb.l(this.this$0.app, acbn.blj, this.this$0.cMA);
            this.this$0.app.b().a(acbn.blj, this.this$0.cMA, true, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afct
 * JD-Core Version:    0.7.0.1
 */