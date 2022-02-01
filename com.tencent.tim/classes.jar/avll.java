import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable;
import cooperation.qqpim.QQPimGetTipsInfoIPC.a;
import cooperation.qqpim.QQPimTipsInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class avll
  implements EIPCResultCallback
{
  public avll(QQPimGetTipsInfoIPC.GetContactTipsRunnable paramGetContactTipsRunnable) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.onCallback() " + QQPimGetTipsInfoIPC.a(this.a.this$0).hashCode());
    }
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data.getParcelable(avli.cLT);
      if (paramEIPCResult != null)
      {
        paramEIPCResult = (QQPimTipsInfo)paramEIPCResult;
        this.a.this$0.a = paramEIPCResult;
        QQPimGetTipsInfoIPC.a(this.a.this$0).b(paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avll
 * JD-Core Version:    0.7.0.1
 */