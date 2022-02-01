import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class abma
  implements EIPCResultCallback
{
  abma(ablz paramablz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_game_friUin");
      QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] current game friendUin:" + paramEIPCResult + ",mCurrentFriUin:" + ablz.a(this.b));
      if (!ablz.a(this.b).equals(paramEIPCResult))
      {
        ablz.a(this.b).removeMessages(1);
        ablz.a(this.b).sendEmptyMessage(1);
      }
      return;
    }
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "[onCallback] game is not exist. exit room");
    ablz.a(this.b).removeMessages(1);
    ablz.a(this.b).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abma
 * JD-Core Version:    0.7.0.1
 */