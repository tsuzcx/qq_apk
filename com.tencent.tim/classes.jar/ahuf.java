import android.os.Bundle;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView.3.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

public class ahuf
  implements EIPCResultCallback
{
  public ahuf(GameSessionView paramGameSessionView) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    List localList;
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        localList = (List)paramEIPCResult.getSerializable("key_get_game_msg");
        if (GameSessionView.a(this.this$0)) {
          break label101;
        }
        GameSessionView.a(this.this$0, paramEIPCResult.getInt("key_get_game_view_type", 1));
        if (paramEIPCResult.getBoolean("key_get_game_gray_user", false)) {
          break label77;
        }
        if (QLog.isColorLevel()) {
          QLog.d(GameSessionView.TAG, 0, "[setData] gray is not open. return.");
        }
      }
    }
    return;
    label77:
    GameSessionView.a(this.this$0, paramEIPCResult.getBoolean("key_get_game_show_on_list", false));
    GameSessionView.b(this.this$0, true);
    label101:
    QLog.e(GameSessionView.TAG, 1, "[onCallback] list:" + localList.size() + ",type:" + GameSessionView.a(this.this$0));
    GameSessionView.a(this.this$0).post(new GameSessionView.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuf
 * JD-Core Version:    0.7.0.1
 */