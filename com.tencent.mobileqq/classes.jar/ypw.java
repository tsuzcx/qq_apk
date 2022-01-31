import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager;
import com.tencent.mobileqq.apollo.game.ApolloGameView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class ypw
  extends CmGameStartChecker.DefaultGameCheckListener
{
  public ypw(ApolloGameActivity paramApolloGameActivity, AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (ApolloGameActivity.a(this.a)) {}
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
        QLog.d("cmgame_process.ApolloGameActivity", 2, "onDownloadConfirm mStartCheckParam == null || mStartCheckParam.game == null");
        return;
        if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloGameActivity", 2, "onDownloadConfirm startCheckParam.requestCode != mStartCheckParam.requestCode");
      return;
      if (paramLong > 0L) {
        break;
      }
      QLog.d("cmgame_process.ApolloGameActivity", 2, new Object[] { "[onDownloadConfirm] packageSize is invalid, packageSize=", Long.valueOf(paramLong) });
    } while (paramICmGameConfirmListener == null);
    paramICmGameConfirmListener.a(paramStartCheckParam);
    return;
    this.a.runOnUiThread(new ypy(this, paramLong, paramICmGameConfirmListener, paramStartCheckParam));
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.ApolloGameActivity", 1, "[onDownloadGameResFail]");
    paramStartCheckParam = ApolloGameActivity.a(this.a).obtainMessage(19);
    paramStartCheckParam.obj = "下载失败，请稍后重试~";
    ApolloGameActivity.a(this.a).sendMessage(paramStartCheckParam);
  }
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 100) {
        i = 99;
      }
      paramStartCheckParam = ApolloGameActivity.a(this.a).obtainMessage(22);
      paramStartCheckParam.obj = Integer.valueOf(i);
      ApolloGameActivity.a(this.a).removeMessages(22);
      ApolloGameActivity.a(this.a).sendMessage(paramStartCheckParam);
      return;
    }
  }
  
  public void onGameCheckFinish(int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (ApolloGameActivity.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            QLog.d("cmgame_process.ApolloGameActivity", 1, new Object[] { "[onGameCheckFinish] resultCode=", Integer.valueOf(paramInt) });
            if ((paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.ApolloGameActivity", 2, "onGameCheckFinish mStartCheckParam == null || mStartCheckParam.game == null");
          return;
          if ((ApolloGameActivity.a(this.a) == null) || (paramStartCheckParam.requestCode == ApolloGameActivity.a(this.a).requestCode)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.ApolloGameActivity", 2, "onGameCheckFinish startCheckParam.requestCode != mStartCheckParam.requestCode");
        return;
        if (paramInt != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloGameActivity", 2, "onGameCheckFinish resultCode != 0");
          }
          paramCmGameInitParams = ApolloGameActivity.a(this.a).obtainMessage(19);
          paramCmGameInitParams.obj = paramStartCheckParam.wordingV2;
          ApolloGameActivity.a(this.a).sendMessage(paramCmGameInitParams);
          return;
        }
        if (!this.a.b()) {
          break;
        }
      } while (ApolloGameActivity.a(this.a) == null);
      ApolloGameActivity.a(this.a).a(this.a, paramCmGameInitParams);
      return;
      if (ApolloGameActivity.a(this.a) != null) {
        ApolloGameActivity.a(this.a).b(this.a, paramCmGameInitParams);
      }
    } while (ApolloGameActivity.a(this.a) == null);
    if (ApolloGameActivity.a(this.a).mUpdated) {
      ApolloGameUtil.a(this.a, ApolloGameActivity.a(this.a).game.gameId, ApolloFragmentManager.a().a(), ApolloGameActivity.a(this.a).mGameType, ApolloGameActivity.a(this.a));
    }
    if (this.a.a()) {
      this.a.runOnUiThread(new ypx(this));
    }
    ApolloGameActivity.a(this.a).a(paramCmGameInitParams);
    this.a.a(0L);
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (ApolloGameActivity.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      if (paramStartCheckParam != null) {
        break label37;
      }
      QLog.d("cmgame_process.ApolloGameActivity", 2, "showGameLifeTip mStartCheckParam is null");
    }
    for (;;)
    {
      onGameCheckFinish(-1, paramStartCheckParam, null);
      return;
      label37:
      QLog.d("cmgame_process.ApolloGameActivity", 2, new Object[] { "showGameLifeTip mStartCheckParam:", paramStartCheckParam });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypw
 * JD-Core Version:    0.7.0.1
 */