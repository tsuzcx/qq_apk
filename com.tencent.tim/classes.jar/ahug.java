import android.content.Context;
import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class ahug
  implements EIPCResultCallback
{
  public ahug(GameSessionView paramGameSessionView, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramEIPCResult = paramEIPCResult.getString("key_get_msg_list_url");
        QLog.i(GameSessionView.TAG, 1, "[onCallback] url:" + paramEIPCResult);
        ahtc.a(paramEIPCResult, this.I, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahug
 * JD-Core Version:    0.7.0.1
 */