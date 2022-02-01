import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.MatchingStateHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afxe
  extends afxb
  implements Handler.Callback
{
  public final String TAG = "ExtendFriendLimitChatMatchingStateHandler";
  private String bFR = "";
  public final int cVd = 60;
  private int cVe = 1;
  public final int cVf = 1;
  Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private int status = 101;
  
  afxe(afxd paramafxd, int paramInt)
  {
    super(paramafxd, paramInt);
  }
  
  private void cn(int paramInt, String paramString)
  {
    if (this.b != null)
    {
      this.b.a(100, null);
      ddz();
    }
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onFailedMatchPb  failedType：" + paramInt);
    if ((this.b != null) && (this.b.b != null)) {
      this.b.b.a(paramInt, null, "", paramString);
    }
  }
  
  private void ddA()
  {
    ThreadManager.getSubThreadHandler().post(new MatchingStateHandler.1(this));
  }
  
  private void ddz()
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "clearMsg");
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  void IH(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  public void NB(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "requestMatch in matching state id:" + paramInt);
  }
  
  public void af(int paramInt, long paramLong)
  {
    Message localMessage = this.mHandler.obtainMessage(paramInt);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void apK()
  {
    if ((this.status == 101) || (this.status == 104))
    {
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state REQUEST_MATCHING or WAIT_PUSH ");
      ddz();
      if (this.b != null)
      {
        afsg localafsg = (afsg)this.b.mApp.getBusinessHandler(127);
        if (localafsg != null) {
          localafsg.mc(this.b.mApp.getCurrentAccountUin());
        }
        this.b.a(100, null);
        return;
      }
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state machine is null");
      return;
    }
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state unknown!!" + this.status);
  }
  
  void b(boolean paramBoolean, int paramInt, aftr paramaftr, String paramString)
  {
    long l2 = 60000L;
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg");
    long l1;
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        if ((paramaftr != null) && (paramaftr.akm()))
        {
          QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramaftr.toString());
          b(paramaftr);
          e(paramaftr.bFC, paramaftr.uin, paramaftr.sig);
          fz(paramaftr.bFC, paramaftr.aeN);
          this.status = 105;
          ddA();
          return;
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg MatchInfo is wrong ");
        cn(1, paramString);
        return;
      }
      if (paramInt == 1)
      {
        this.status = 104;
        l1 = 30000L;
        if (paramaftr != null)
        {
          l1 = paramaftr.matchExpiredTime * 1000;
          if (60000L >= l1) {
            break label486;
          }
          l1 = l2;
        }
      }
    }
    label462:
    label468:
    label474:
    label486:
    for (;;)
    {
      af(1, l1);
      if (paramString == null) {}
      for (paramaftr = "";; paramaftr = paramString)
      {
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg - 》 STATE_PROTO_WAIT_PUSH  pushimte ：" + l1 + "tips errm:" + paramaftr);
        this.bFR = paramString;
        return;
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg STATE_PROTO_WAIT_PUSH but matchinfo  is wrong,push time use 30");
        break;
        if (paramInt == 3) {
          if (paramString != null) {
            break label474;
          }
        }
        for (paramaftr = "";; paramaftr = paramString)
        {
          QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramaftr);
          cn(7, paramString);
          return;
          if (paramInt == 4) {
            if (paramString != null) {
              break label468;
            }
          }
          for (paramaftr = "";; paramaftr = paramString)
          {
            QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Limit errmsg:" + paramaftr);
            cn(8, paramString);
            return;
            if (paramInt == 2) {
              if (paramString != null) {
                break label462;
              }
            }
            for (paramaftr = "";; paramaftr = paramString)
            {
              QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:" + paramaftr);
              cn(6, paramString);
              return;
              if (paramString == null) {}
              for (paramaftr = "";; paramaftr = paramString)
              {
                QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg RECODE = " + paramInt + " errMsg:" + paramaftr);
                cn(1, paramString);
                return;
                QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg success = " + paramBoolean);
                cn(1, "");
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, aftr paramaftr)
  {
    if ((paramBoolean) && (paramaftr != null) && (paramaftr.tagId != this.cVe))
    {
      e(paramaftr.bFC, paramaftr.uin, paramaftr.sig);
      d(paramaftr);
      fz(paramaftr.bFC, paramaftr.aeN);
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "ON PUSH WITH PUSH TAG" + paramaftr.tagId + " wait id:" + this.cVe);
    }
    do
    {
      return;
      this.mHandler.removeMessages(1);
      if (paramaftr == null)
      {
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg null indo");
        return;
      }
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg ");
      if (!paramBoolean) {
        break label259;
      }
      e(paramaftr.bFC, paramaftr.uin, paramaftr.sig);
      b(paramaftr);
      fz(paramaftr.bFC, paramaftr.aeN);
      if (this.status != 104) {
        break;
      }
    } while (!paramaftr.akm());
    b(paramaftr);
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "STATE_PROTO_WAIT_PUSH - 》 STATE_PROTO_AIO_OPEN matchinf:" + paramaftr.toString());
    this.status = 105;
    ddA();
    return;
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "WAIT PUSH IN STATE: UN HANDLED" + this.status + paramaftr.toString());
    return;
    label259:
    cn(2, this.bFR);
  }
  
  public void c(aftr paramaftr)
  {
    this.c.clear();
    if (paramaftr != null)
    {
      b(paramaftr);
      this.cVe = paramaftr.tagId;
    }
    this.status = 101;
  }
  
  public void clearStatus()
  {
    this.c.clear();
    ddz();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "超时 on timer TIMER_FOR_PUSH：" + this.c.toString());
      apK();
      cn(2, this.bFR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxe
 * JD-Core Version:    0.7.0.1
 */