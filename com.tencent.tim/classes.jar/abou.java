import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class abou
  implements EIPCResultCallback
{
  abou(abos paramabos) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    long l1 = 0L;
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null)) {}
    Activity localActivity;
    do
    {
      int i;
      CmGameInitParams localCmGameInitParams;
      do
      {
        return;
        i = paramEIPCResult.data.getInt("result");
        localActivity = this.this$0.q();
        if (i != 0) {
          break;
        }
        long l2 = paramEIPCResult.data.getLong("ResultCode");
        localCmGameInitParams = (CmGameInitParams)paramEIPCResult.data.getSerializable("CmGameInitParams");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "queryCheckGameFromMainProcess onCallback cmGameInitParams", localCmGameInitParams });
        }
        if ((l2 != 0L) || (localCmGameInitParams == null)) {
          break;
        }
      } while (!(localActivity instanceof ApolloGameActivity));
      if (abos.a(this.this$0) == null) {}
      for (;;)
      {
        paramEIPCResult = (CmGameStartChecker.StartCheckParam)paramEIPCResult.data.getSerializable("StartCheckParam");
        this.this$0.n(paramEIPCResult);
        abmt.x(new Object[] { "[checkFinish], loading from main process but waiting for tool, before cost:", Long.valueOf(l1) });
        ((ApolloGameActivity)localActivity).n(paramEIPCResult);
        ((ApolloGameActivity)localActivity).b(localCmGameInitParams);
        return;
        l1 = System.currentTimeMillis() - abos.a(this.this$0).mCreateTs;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, new Object[] { "queryCheckGameFromMainProcess onCallback result:", Integer.valueOf(i) });
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).cET();
      }
    } while (localActivity == null);
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abou
 * JD-Core Version:    0.7.0.1
 */