import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ycc
  extends achq
{
  private ybt a;
  
  ycc(ybt paramybt)
  {
    this.a = paramybt;
  }
  
  private void DE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QQToast.a(this.a.mActivity, this.a.mActivity.getString(2131718915), 0).show(this.a.mActivity.getTitleBarHeight());
  }
  
  protected void L(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.sessionInfo.aTl != null) && (this.a.sessionInfo.aTl.equals(paramString)))
    {
      ChatActivityUtils.bJs();
      if (paramBoolean) {
        this.a.bGP();
      }
    }
  }
  
  protected void M(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.sessionInfo.aTl != null) && (this.a.sessionInfo.aTl.equals(paramString)))
    {
      ChatActivityUtils.bJs();
      if (paramBoolean) {
        this.a.bGP();
      }
    }
  }
  
  protected void U(boolean paramBoolean, String paramString)
  {
    this.a.refresh(65536);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.sessionInfo.aTl)) || (paramInt1 != this.a.sessionInfo.cZ))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.TAG, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1009) {
      DE(paramInt2);
    }
    this.a.refresh(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.aTl)) {
      return;
    }
    this.a.aSt = true;
    this.a.a(262144, null, paramLong);
    if (this.a.blh)
    {
      paramString = new Message();
      paramString.what = 39;
      paramString.obj = this.a.aXg;
      this.a.getUIHandler().removeMessages(39);
      this.a.getUIHandler().sendMessage(paramString);
    }
    ThreadManagerV2.excute(new NearbyChatPieObserver.1(this, paramBoolean, this.a.mActivity.getIntent().getStringExtra("NEARBY_MSG_REPORT_SOURCE"), (ajpj)this.a.app.getManager(106)), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */