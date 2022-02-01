import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class abta
  implements EIPCResultCallback
{
  public abta(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    boolean bool1 = paramEIPCResult.getBoolean("isOpen");
    boolean bool2 = paramEIPCResult.getBoolean("display", false);
    this.this$0.i(bool2, bool1, ApolloGameActivity.a(this.this$0).mTempAIOUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abta
 * JD-Core Version:    0.7.0.1
 */