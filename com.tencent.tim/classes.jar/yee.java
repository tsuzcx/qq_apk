import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class yee
  extends achq
{
  yee(ydz paramydz) {}
  
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
    if (paramInt1 == 1005) {
      ydz.a(this.a, paramInt2);
    }
    for (;;)
    {
      this.a.refresh(196608);
      return;
      if (paramInt1 == 1004) {
        ydz.b(this.a, paramInt2);
      } else if (paramInt1 == 1000) {
        ydz.a(this.a, paramString1, paramInt2, paramString2);
      } else if (paramInt1 == 1020) {
        ydz.c(this.a, paramInt2);
      } else if (paramInt1 == 1006) {
        ydz.d(this.a, paramInt2);
      } else if (paramInt1 == 1022) {
        ydz.e(this.a, paramInt2);
      } else if (paramInt1 == 1023) {
        QQToast.a(this.a.mActivity, "errorCode" + paramInt2, 0).show(this.a.mActivity.getTitleBarHeight());
      } else if (paramInt1 == 1025) {
        ydz.a(this.a, paramInt2, paramString2);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.aTl)) {
      return;
    }
    this.a.aSt = true;
    this.a.a(262144, null, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yee
 * JD-Core Version:    0.7.0.1
 */