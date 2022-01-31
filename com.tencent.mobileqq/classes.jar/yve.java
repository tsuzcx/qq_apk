import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.OnGameStartCheckListener;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class yve
  implements Runnable
{
  public yve(CmGameStartChecker paramCmGameStartChecker, CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {
      return;
    }
    Object localObject;
    if (CmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker) != null)
    {
      localObject = (OnGameStartCheckListener)CmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker).get();
      if (localObject != null)
      {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onGameCheckStart startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        ((OnGameStartCheckListener)localObject).onGameCheckStart(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
    }
    if (new RSAVerify(ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game) + "/" + "main.js.sig", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId)).a(0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "verify pass startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
      }
      localObject = new CmGameInitParams();
      ((CmGameInitParams)localObject).mGamePath = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
      ((CmGameInitParams)localObject).mServerIp = ApolloGameBasicEventUtil.a();
      ((CmGameInitParams)localObject).mPort = ApolloGameBasicEventUtil.a();
      ((CmGameInitParams)localObject).mVersion = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.version;
      ((CmGameInitParams)localObject).mIsMaster = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isCreator;
      ((CmGameInitParams)localObject).mGameMode = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameMode;
      ((CmGameInitParams)localObject).mGameEnter = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
      ((CmGameInitParams)localObject).mScreenMode = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.screenMode;
      ((CmGameInitParams)localObject).mViewMode = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.viewMode;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson)) {
        ((CmGameInitParams)localObject).mGameParam = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson;
      }
      ((CmGameInitParams)localObject).mSrc = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId != 0L) {
        ((CmGameInitParams)localObject).mRoomId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId;
      }
      ((CmGameInitParams)localObject).mSessionId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin;
      if (CmGameStartChecker.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker).get() != null) {
        ((CmGameInitParams)localObject).mSelfUin = ((AppInterface)CmGameStartChecker.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker).get()).getCurrentAccountUin();
      }
      ((CmGameInitParams)localObject).mGameName = ("" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId);
      ((CmGameInitParams)localObject).mSessionType = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionType;
      ((CmGameInitParams)localObject).mAioType = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 204) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 220)) {
        ((CmGameInitParams)localObject).mAioType = 0;
      }
      ((CmGameInitParams)localObject).mExtraStr = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mExtraStr;
      ((CmGameInitParams)localObject).mFriendUin = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mFriendUin;
      ((CmGameInitParams)localObject).gender = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gender;
      ((CmGameInitParams)localObject).isWhiteUsr = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr;
      ((CmGameInitParams)localObject).apolloStatus = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.apolloStatus;
      ((CmGameInitParams)localObject).mChineseName = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name;
      ((CmGameInitParams)localObject).mActionId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.actionId;
      ((CmGameInitParams)localObject).sessionOpenId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionOpenId;
      ((CmGameInitParams)localObject).extInfoFromSvr = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extInfoFromSvr;
      ((CmGameInitParams)localObject).openId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId;
      ((CmGameInitParams)localObject).gameType = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameType;
      ((CmGameInitParams)localObject).redUrl = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.redUrl;
      if (CmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker) != null)
      {
        OnGameStartCheckListener localOnGameStartCheckListener = (OnGameStartCheckListener)CmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker).get();
        if (localOnGameStartCheckListener != null)
        {
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onGameCheckFinish startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          localOnGameStartCheckListener.onGameCheckFinish(0, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, (CmGameInitParams)localObject);
        }
      }
      ApolloGameStateMachine.a().a(2, "ApolloManager.startGame");
      try
      {
        ApolloUtil.a().edit().putLong(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId), NetConnInfoCenter.getServerTimeMillis()).commit();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    CmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    QLog.e("apollo_cmGame_CmGameStartChecker", 1, new Object[] { "verify lua fail and delete local res startCheckParam=", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
    FileUtils.a(ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yve
 * JD-Core Version:    0.7.0.1
 */