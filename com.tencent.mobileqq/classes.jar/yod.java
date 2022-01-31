import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class yod
  implements EIPCResultCallback
{
  public yod(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("resData");
    CmGameUtil.a().callbackFromRequest(this.a, 0, "sc.script_notify_action_ready.local", paramEIPCResult);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_ACTION_DATA onCallback resJson:" + paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yod
 * JD-Core Version:    0.7.0.1
 */