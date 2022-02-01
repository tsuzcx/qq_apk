import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class afwj
  implements afxd.a
{
  afwj(afwh paramafwh) {}
  
  public void a(int paramInt, aftr paramaftr, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, "onMatchingResult, result = " + paramInt + " nickName : " + paramString1);
      if (paramaftr != null) {
        QLog.d("ExtendFriendLimitChatManagerExtendFriendLimitChat", 2, " info：" + paramaftr.toString());
      }
    }
    if ((afwh.a(this.a) == null) || (afwh.a(this.a).get() == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendLimitChatManager", 2, "onMatchingResult, listener = null");
      }
    }
    while (this.a.getState() != 2) {
      return;
    }
    if ((paramInt != 0) || (paramaftr == null)) {
      this.a.a().Ny(104);
    }
    for (;;)
    {
      ((afwh.a)afwh.a(this.a).get()).b(paramInt, paramaftr, paramString1, paramString2);
      return;
      afwh.a(this.a, paramaftr.a());
      this.a.bFL = paramString1;
      this.a.a().Ny(105);
      if (!afwh.a(this.a))
      {
        QQNotificationManager.getInstance().createLimitChatNotificationChannel();
        afwh.a(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwj
 * JD-Core Version:    0.7.0.1
 */