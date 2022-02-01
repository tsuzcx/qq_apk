import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable;
import cooperation.qqpim.QQPimGetTipsInfoIPC.NoticeClickTipsRunnable;
import cooperation.qqpim.QQPimGetTipsInfoIPC.a;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;

public class avlk
  extends QIPCModule
{
  public avlk(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.onCall()" + paramString);
    }
    if (avli.cLw.equals(paramString)) {
      if (QQPimGetTipsInfoIPC.access$100() != -1) {}
    }
    while ((!avli.cLN.equals(paramString)) || (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.this$0) < 500L))
    {
      do
      {
        do
        {
          return null;
        } while (System.currentTimeMillis() - QQPimGetTipsInfoIPC.a(this.this$0) < 500L);
        QQPimGetTipsInfoIPC.a(this.this$0, System.currentTimeMillis());
        if (QQPimGetTipsInfoIPC.access$100() == 0)
        {
          QQPimGetTipsInfoIPC.access$102(-1);
          ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.GetContactTipsRunnable(this.this$0, QQPimGetTipsInfoIPC.a(this.this$0), QQPimGetTipsInfoIPC.b(this.this$0)), null, true);
          return null;
        }
      } while (QQPimGetTipsInfoIPC.access$100() != 1);
      QQPimGetTipsInfoIPC.access$102(-1);
      ThreadManager.postImmediately(new QQPimGetTipsInfoIPC.NoticeClickTipsRunnable(this.this$0, null), null, true);
      return null;
    }
    QQPimGetTipsInfoIPC.a(this.this$0, System.currentTimeMillis());
    paramString = new QQPimTipsInfo();
    paramString.tipsType = 0;
    QQPimGetTipsInfoIPC.a(this.this$0).b(paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlk
 * JD-Core Version:    0.7.0.1
 */