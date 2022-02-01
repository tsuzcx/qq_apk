import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.8.2;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class xyp
  extends achq
{
  xyp(xyi paramxyi) {}
  
  private void ys(String paramString)
  {
    try
    {
      if (!this.this$0.mActivity.isFinishing()) {
        aqha.a(this.this$0.mActivity, 230, acfp.m(2131705128), this.this$0.mActivity.getString(2131719481), new xyr(this, paramString), null).show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.this$0.TAG, 1, "ERR!! send_discussion_msg_failed_not_member:" + paramString.getMessage());
    }
  }
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.this$0.refresh(65536);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.this$0.app.b().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        ajlc.a().a(this.this$0.app, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      default: 
        if (paramInt2 > 100) {
          QQToast.a(this.this$0.mActivity, paramString2, 0).show(this.this$0.mActivity.getTitleBarHeight());
        }
        break;
      }
    }
    for (;;)
    {
      this.this$0.refresh(196608);
      return;
      QQToast.a(this.this$0.mActivity, 2131719479, 1).show(this.this$0.mActivity.getTitleBarHeight());
      continue;
      QQToast.a(this.this$0.mActivity, 2131719482, 1).show(this.this$0.mActivity.getTitleBarHeight());
      continue;
      aqha.a(this.this$0.mActivity, 230, acfp.m(2131705127), this.this$0.mActivity.getString(2131692890), new xyq(this, paramString1), null).show();
      continue;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.this$0.mActivity.runOnUiThread(new DiscussChatPie.8.2(this, paramString1));
      } else {
        ys(paramString1);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.d paramd)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.this$0.sessionInfo.aTl)) {
      return;
    }
    this.this$0.aSt = true;
    this.this$0.a(262144, paramd, paramLong);
  }
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onMsgRevokeNotice:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.this$0.a != null)
      {
        int i = this.this$0.a.Lf();
        if (i != -1)
        {
          apnu localapnu = (apnu)this.this$0.app.getManager(363);
          long l = localapnu.aQ(this.this$0.sessionInfo.aTl + "&" + 3000);
          if (((MessageRecord)localObject).uniseq == l)
          {
            localapnu.gl(this.this$0.sessionInfo.aTl + "&" + 3000, i);
            this.this$0.a.Ww(i);
            this.this$0.a.dYs();
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d(this.this$0.TAG + ".troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.b(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void yh(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.this$0.refresh(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyp
 * JD-Core Version:    0.7.0.1
 */