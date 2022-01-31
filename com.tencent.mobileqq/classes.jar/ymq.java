import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class ymq
  extends CmGameStartChecker.DefaultGameCheckListener
{
  public ymq(ApolloWebGameActivity paramApolloWebGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (ApolloWebGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloWebGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
    } while (paramICmGameConfirmListener == null);
    paramICmGameConfirmListener.a(paramStartCheckParam);
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.ApolloWebGameActivity", 1, "[onDownloadGameResFail]");
    paramStartCheckParam = ApolloWebGameActivity.a(this.a).obtainMessage(17);
    paramStartCheckParam.obj = "下载失败，请稍后重试~";
    ApolloWebGameActivity.a(this.a).sendMessage(paramStartCheckParam);
  }
  
  public void onGameCheckFinish(int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloWebGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("cmgame_process.ApolloWebGameActivity", 1, new Object[] { "[onGameCheckFinish] resultCode=", Integer.valueOf(paramInt) });
          if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloWebGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloWebGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (paramInt != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloWebGameActivity", 2, "onGameCheckFinish resultCode != 0");
        }
        paramCmGameInitParams = ApolloWebGameActivity.a(this.a).obtainMessage(17);
        paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
        ApolloWebGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
        return;
      }
      ApolloGameStateMachine.a().a(1, "ApolloWebGameActivity.openGame");
      ApolloGameStateMachine.a().a(2, "ApolloWebGameActivity.openGame");
    } while (ApolloWebGameActivity.a(this.a) == null);
    ApolloWebGameActivity.a(this.a).a(this.a, paramCmGameInitParams);
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ApolloWebGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label37;
      }
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      onGameCheckFinish(-1, paramStartCheckParam, null);
      return;
      label37:
      QLog.d("cmgame_process.ApolloWebGameActivity", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymq
 * JD-Core Version:    0.7.0.1
 */