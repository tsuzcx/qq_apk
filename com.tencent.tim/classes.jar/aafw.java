import android.os.Bundle;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class aafw
  implements EIPCResultCallback
{
  aafw(anly paramanly) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null)) {}
    try
    {
      if (this.a != null) {
        this.a.a((SoLoadInfo)paramEIPCResult.data.getSerializable("res"));
      }
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("SoLoadWidget.IPC", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafw
 * JD-Core Version:    0.7.0.1
 */