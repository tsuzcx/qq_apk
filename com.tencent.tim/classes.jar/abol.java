import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class abol
  implements EIPCResultCallback
{
  abol(long paramLong, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("resData");
    abmt.a().callbackFromRequest(this.Od, 0, this.val$cmd, paramEIPCResult);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_DRESS_PATH onCallback resJson:" + paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abol
 * JD-Core Version:    0.7.0.1
 */