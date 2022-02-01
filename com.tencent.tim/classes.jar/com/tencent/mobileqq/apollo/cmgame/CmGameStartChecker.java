package com.tencent.mobileqq.apollo.cmgame;

import abkb;
import abmt;
import aboz;
import abpi;
import abpl;
import abpq;
import abxi;
import abya;
import android.os.Bundle;
import android.text.TextUtils;
import anpc;
import aqiw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollo.STCheckGame.STCheckGameRsp;
import com.tencent.pb.apollo.STCheckGame.STGameConfInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;

public class CmGameStartChecker
  implements abpq, BusinessObserver
{
  public long NJ;
  public long NK;
  public long NL;
  private abpi jdField_a_of_type_Abpi;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private volatile int cps;
  private WeakReference<abkb> fx;
  private WeakReference<AppInterface> mAppRef;
  
  public CmGameStartChecker(AppInterface paramAppInterface)
  {
    this.mAppRef = new WeakReference(paramAppInterface);
  }
  
  private void cCx()
  {
    if ((this.fx == null) || (this.fx.get() == null)) {
      return;
    }
    if (abmt.c(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))
    {
      cCy();
      return;
    }
    abkb localabkb = (abkb)this.fx.get();
    this.cps += 1;
    if (this.cps == 1)
    {
      localabkb.onGameCheckRetry(1);
      Hn(1);
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      gS(-17L);
      return;
    }
    localabkb.onGameCheckRetry(2);
  }
  
  private void gS(long paramLong)
  {
    if (this.fx != null)
    {
      abkb localabkb = (abkb)this.fx.get();
      if (localabkb != null)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameCheckFail:", Long.valueOf(paramLong), ",startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        localabkb.onGameCheckFinish(paramLong, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, null);
      }
    }
  }
  
  private void gT(long paramLong)
  {
    if (this.fx != null)
    {
      abkb localabkb = (abkb)this.fx.get();
      if (localabkb != null)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameFail:", Long.valueOf(paramLong), ",startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        localabkb.onGameFailed(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramLong);
      }
    }
  }
  
  public void C(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    do
    {
      do
      {
        return;
      } while (this.fx == null);
      paramString = (abkb)this.fx.get();
    } while (paramString == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "[onDownloadProgress] progress:" + paramInt1);
    paramString.onDownloadGameResProgress(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramInt1);
  }
  
  public void Hn(int paramInt)
  {
    if ((this.mAppRef.get() == null) || ((!aqiw.isNetSupport(((AppInterface)this.mAppRef.get()).getApp())) && (!abmt.c(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))))
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] none network");
      gS(-10L);
      return;
    }
    ThreadManagerV2.excute(new CmGameStartChecker.2(this, paramInt), 192, null, true);
  }
  
  public void a(StartCheckParam paramStartCheckParam, abkb paramabkb)
  {
    if ((paramStartCheckParam == null) || (paramabkb == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, "[launchGame],startCheckParam == null || gameStartCheckListener == nul");
      }
    }
    do
    {
      return;
      this.NJ = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[launchGame], startCheckerParam:", paramStartCheckParam });
      }
      ApolloGameStateMachine.a().reset();
      ApolloGameStateMachine.a().fY(1);
      this.fx = new WeakReference(paramabkb);
      this.cps = 0;
      if (!paramStartCheckParam.isRunning) {
        break;
      }
      startGame();
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameStartChecker", 2, "startGame from game resume");
    return;
    Hn(0);
  }
  
  public void a(b paramb, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    abkb localabkb;
    do
    {
      do
      {
        return;
      } while (this.fx == null);
      localabkb = (abkb)this.fx.get();
    } while (localabkb == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "[onDownloadConfirm] startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    localabkb.onDownloadConfirm(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramb, paramLong);
  }
  
  public void bI(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startT = -1L;
      } while (this.fx == null);
      paramString = (abkb)this.fx.get();
    } while (paramString == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onDownloadGameResStart startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    paramString.onDownloadGameResStart(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void bJ(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mUpdated = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType = ApolloGameUtil.gg(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode = ApolloGameUtil.as(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType);
    if (this.fx != null)
    {
      paramString = (abkb)this.fx.get();
      if (paramString != null)
      {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "gameCheckListener.onDownloadGameResDown startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        paramString.onDownloadGameResDown(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
    }
    cCz();
  }
  
  public void bK(int paramInt, String paramString)
  {
    QLog.e("cmgame_process.CmGameStartChecker", 1, "[onDownloadFailure], ret:" + paramInt);
    abmt.x(new Object[] { "[downloadRes], failed ret:", Integer.valueOf(paramInt), ", packName:", paramString });
    gT(-12L);
  }
  
  protected void bT(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    Object localObject1;
    label27:
    int k;
    int m;
    Object localObject4;
    Object localObject3;
    try
    {
      if (this.fx == null) {
        break label1902;
      }
      localObject1 = (abkb)this.fx.get();
      k = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
      m = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameMode;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from;
      localObject3 = new STCheckGame.STCheckGameRsp();
      ((STCheckGame.STCheckGameRsp)localObject3).mergeFrom(paramBundle.getByteArray("data"));
      paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).wording.get();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.wordingV2 = ((STCheckGame.STCheckGameRsp)localObject3).wordingV2.get();
      if (!TextUtils.isEmpty(paramBundle))
      {
        QLog.i("cmgame_process.CmGameStartChecker", 1, "onGetGameKey failwording:" + paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.wordingV2 = paramBundle;
        ApolloItemBuilder.a(paramBundle, 1, BaseApplicationImpl.getContext());
        ApolloGameStateMachine.a().n(5, "fail in get key");
        gS(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 2, "onGetGameKey e:", paramBundle);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode != 0L)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "onGetGameKey checkGame failed retCode:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode) });
      ApolloGameStateMachine.a().n(5, "fail in get key");
      gS(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode);
      return;
    }
    String str4 = ((STCheckGame.STCheckGameRsp)localObject3).st.get();
    String str5 = ((STCheckGame.STCheckGameRsp)localObject3).stKey.get();
    int n = ((STCheckGame.STCheckGameRsp)localObject3).remainPlays.get();
    int i1 = ((STCheckGame.STCheckGameRsp)localObject3).svrResVer.get();
    boolean bool1;
    label303:
    boolean bool2;
    label318:
    String str1;
    String str2;
    String str3;
    long l1;
    long l2;
    label391:
    int i;
    label411:
    int j;
    label431:
    boolean bool3;
    if (((STCheckGame.STCheckGameRsp)localObject3).updateFlag.get() == 1)
    {
      bool1 = true;
      if (((STCheckGame.STCheckGameRsp)localObject3).isPatch.get() != 1) {
        break label1914;
      }
      bool2 = true;
      str1 = ((STCheckGame.STCheckGameRsp)localObject3).patchUrl.get();
      str2 = ((STCheckGame.STCheckGameRsp)localObject3).zipUrl.get();
      str3 = ((STCheckGame.STCheckGameRsp)localObject3).zipMd5.get();
      l1 = ((STCheckGame.STCheckGameRsp)localObject3).packageSize.get();
      l2 = ((STCheckGame.STCheckGameRsp)localObject3).tipsSize.get();
      if (((STCheckGame.STCheckGameRsp)localObject3).patchContent.has())
      {
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).patchContent.get().toByteArray();
        if (((STCheckGame.STCheckGameRsp)localObject3).appIdSource.has())
        {
          i = ((STCheckGame.STCheckGameRsp)localObject3).appIdSource.get();
          if (((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.has())
          {
            j = ((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.get();
            if (((STCheckGame.STCheckGameRsp)localObject3).adDevUin.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adDevUin = ((STCheckGame.STCheckGameRsp)localObject3).adDevUin.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adForbidPosId = ((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).adShareRate.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adShareRate = ((STCheckGame.STCheckGameRsp)localObject3).adShareRate.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).rpUrl.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.rpUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpUrl.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).rpPic.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.rpIconUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpPic.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.has())
            {
              localObject2 = ((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.get();
              if (localObject1 != null)
              {
                QLog.d("cmgame_process.CmGameStartChecker", 2, "onGetGameKey gameCheckListener.onSsoCmdRuleRsp startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                ((abkb)localObject1).onSsoCmdRuleRsp(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, (String)localObject2);
              }
            }
            for (;;)
            {
              localObject2 = "";
              if (((STCheckGame.STCheckGameRsp)localObject3).extInfo.has()) {
                localObject2 = new String(((STCheckGame.STCheckGameRsp)localObject3).extInfo.get().toByteArray());
              }
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey checkGame done gameId: " + k, ", from: " + (String)localObject4 + ", gameMode: " + m + ",extInfo:" + (String)localObject2 });
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.apolloGameSt = str4;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.apolloGameStkey = str5;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId = ((STCheckGame.STCheckGameRsp)localObject3).openId.get();
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionOpenId = ((STCheckGame.STCheckGameRsp)localObject3).sessionOpenId.get();
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extInfoFromSvr = ((String)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.appIdSrc = i;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag = j;
              if (((STCheckGame.STCheckGameRsp)localObject3).gameConfInfo.has())
              {
                localObject2 = new STCheckGame.STGameConfInfo();
                ((STCheckGame.STGameConfInfo)localObject2).mergeFrom(((STCheckGame.STGameConfInfo)((STCheckGame.STCheckGameRsp)localObject3).gameConfInfo.get()).toByteArray());
                localObject4 = new ApolloGameData();
                ((ApolloGameData)localObject4).gameId = ((STCheckGame.STGameConfInfo)localObject2).game_id.get();
                ((ApolloGameData)localObject4).actionId = ((STCheckGame.STGameConfInfo)localObject2).action_id.get();
                ((ApolloGameData)localObject4).appId = ((STCheckGame.STGameConfInfo)localObject2).appid.get();
                ((ApolloGameData)localObject4).developerName = ((STCheckGame.STGameConfInfo)localObject2).ep_name.get();
                ((ApolloGameData)localObject4).minVer = ((STCheckGame.STGameConfInfo)localObject2).g_start_ver.get();
                ((ApolloGameData)localObject4).maxVer = ((STCheckGame.STGameConfInfo)localObject2).g_end_ver.get();
                ((ApolloGameData)localObject4).name = ((STCheckGame.STGameConfInfo)localObject2).game_name.get();
                ((ApolloGameData)localObject4).hasOwnArk = ((STCheckGame.STGameConfInfo)localObject2).has_own_ark.get();
                if (((STCheckGame.STGameConfInfo)localObject2).isfeatured.get() != 1) {
                  break label1920;
                }
                bool3 = true;
                label992:
                ((ApolloGameData)localObject4).isFeatured = bool3;
                ((ApolloGameData)localObject4).isShow = ((STCheckGame.STGameConfInfo)localObject2).is_show_onpanel.get();
                ((ApolloGameData)localObject4).listCoverUrl = ((STCheckGame.STGameConfInfo)localObject2).list_cover_url.get();
                ((ApolloGameData)localObject4).logoUrl = ((STCheckGame.STGameConfInfo)localObject2).logo_url.get();
                ((ApolloGameData)localObject4).needOpenKey = ((STCheckGame.STGameConfInfo)localObject2).need_open_key.get();
                ((ApolloGameData)localObject4).officialAccountUin = String.valueOf(((STCheckGame.STGameConfInfo)localObject2).puin.get());
                ((ApolloGameData)localObject4).screenMode = ((STCheckGame.STGameConfInfo)localObject2).screen_mode.get();
                ((ApolloGameData)localObject4).viewMode = ((STCheckGame.STGameConfInfo)localObject2).view_mode.get();
                if (localObject1 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey game_conf_info gameData:", ((ApolloGameData)localObject4).toString() });
                  }
                  this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = ((ApolloGameData)localObject4);
                  this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode = ((ApolloGameData)localObject4).viewMode;
                  ((abkb)localObject1).onGetGameData(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                break;
              }
              QLog.e("cmgame_process.CmGameStartChecker", 1, "onGetGameKey get game is null");
              gS(-11L);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey ssoCmdRule, no ssoCmdRule for game ", Integer.valueOf(k) });
              }
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).transInfo.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.transInfo = new String(((STCheckGame.STCheckGameRsp)localObject3).transInfo.get().toByteArray());
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.delayMs = ((STCheckGame.STCheckGameRsp)localObject3).delayMs.get();
            abhh.bfR = str4;
            abhh.bfS = str5;
            localObject3 = (AppInterface)this.mAppRef.get();
            if (localObject3 != null) {
              ApolloGameUtil.c((AppInterface)localObject3, n);
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from)) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from = "updateRes";
            }
            QLog.i("cmgame_process.CmGameStartChecker", 1, "[game_launch_cost], check game:" + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startT));
            if (bool1) {
              abmt.Cj(ApolloUtil.dp(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            }
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            if (!bool1) {
              break label1926;
            }
          }
        }
      }
    }
    label1920:
    label1926:
    for (Object localObject2 = "1";; localObject2 = "0")
    {
      ((HashMap)localObject4).put("param_update", localObject2);
      anpc.a(((AppInterface)localObject3).getApp()).collectPerformance(((AppInterface)localObject3).getCurrentAccountUin(), "cmgame_checkgame_update", true, 0L, 0L, (HashMap)localObject4, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_checkgame_update, needUpdate=", Boolean.valueOf(bool1), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      if (localObject1 != null) {
        ((abkb)localObject1).onGameCheckFinish(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, null);
      }
      if (abya.c(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId))
      {
        localObject1 = new abpl();
        ((abpl)localObject1).itemId = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        ((abpl)localObject1).Ok = l2;
        ((abpl)localObject1).Ol = l1;
        ((abpl)localObject1).cM = paramBundle;
        ((abpl)localObject1).isPatch = bool2;
        ((abpl)localObject1).isUpdate = bool1;
        ((abpl)localObject1).md5 = str3;
        ((abpl)localObject1).patchUrl = str1;
        ((abpl)localObject1).bhl = str2;
        ((abpl)localObject1).gameId = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
        ((abpl)localObject1).cqD = i1;
        ((abpl)localObject1).enter = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        ((abpl)localObject1).from = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from;
        ((abpl)localObject1).cqE = 0;
        ((abpl)localObject1).startT = System.currentTimeMillis();
        ((abpl)localObject1).delayMs = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.delayMs;
        this.jdField_a_of_type_Abpi = new abpi((abpl)localObject1, this);
        bool3 = this.jdField_a_of_type_Abpi.YT();
        abmt.x(new Object[] { "[checkRes], serverVersion:" + i1 + ", isPatch:" + bool2, ", isUpdate:" + bool1, ",delay:", Integer.valueOf(((abpl)localObject1).delayMs) });
        QLog.i("cmgame_process.CmGameStartChecker", 1, "onGetGameKey [cmgame_pack_main], response, gameId:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + ",ver:" + i1 + ",isPatch:" + bool2 + ",isUpdate:" + bool1);
        if (bool3) {
          break;
        }
        cCz();
        return;
      }
      cCz();
      return;
      j = 0;
      break label431;
      i = 0;
      break label411;
      paramBundle = null;
      break label391;
      label1902:
      localObject1 = null;
      break label27;
      bool1 = false;
      break label303;
      label1914:
      bool2 = false;
      break label318;
      bool3 = false;
      break label992;
    }
  }
  
  public void cCy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.transInfo = "{\"standAlone\":1}";
    cCz();
  }
  
  public void cCz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife startCheckParam is null");
      return;
    }
    Object localObject = (AppInterface)this.mAppRef.get();
    if (localObject == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife app == null");
      return;
    }
    int i = ApolloGameUtil.d((AppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, " checkLife  life =" + i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode == abxi.OQ)
    {
      if (this.fx != null)
      {
        localObject = (abkb)this.fx.get();
        if (localObject != null)
        {
          QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onGameLifeTipShow startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          ((abkb)localObject).onGameLifeTipShow(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "game_times_short", 0, 0, new String[] { "" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId });
      return;
    }
    startGame();
  }
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 7
    //   12: iload 7
    //   14: istore_1
    //   15: iload 9
    //   17: istore 6
    //   19: aload_3
    //   20: ldc_w 837
    //   23: invokevirtual 841	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   26: istore 8
    //   28: iload 7
    //   30: istore_1
    //   31: iload 8
    //   33: istore 4
    //   35: iload 9
    //   37: istore 6
    //   39: iload 8
    //   41: istore 5
    //   43: aload_3
    //   44: ldc_w 843
    //   47: invokevirtual 847	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 14
    //   52: iload 7
    //   54: istore_1
    //   55: iload 8
    //   57: istore 4
    //   59: iload 9
    //   61: istore 6
    //   63: iload 8
    //   65: istore 5
    //   67: ldc_w 849
    //   70: aload 14
    //   72: invokevirtual 853	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +36 -> 111
    //   78: iload 7
    //   80: istore_1
    //   81: iload 8
    //   83: istore 4
    //   85: iload 9
    //   87: istore 6
    //   89: iload 8
    //   91: istore 5
    //   93: aload_0
    //   94: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   97: getfield 722	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:isWhiteUsr	Z
    //   100: invokestatic 859	abor:o	(Z)Ljava/lang/String;
    //   103: aload 14
    //   105: invokevirtual 853	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifeq +1055 -> 1163
    //   111: iload 7
    //   113: istore_1
    //   114: iload 8
    //   116: istore 4
    //   118: iload 9
    //   120: istore 6
    //   122: iload 8
    //   124: istore 5
    //   126: aload_3
    //   127: ldc_w 861
    //   130: invokevirtual 847	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 864	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   136: istore 7
    //   138: iload 7
    //   140: istore_1
    //   141: iload 8
    //   143: istore 4
    //   145: iload 7
    //   147: istore 6
    //   149: iload 8
    //   151: istore 5
    //   153: aload_0
    //   154: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   157: putfield 866	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NL	J
    //   160: iload 7
    //   162: istore_1
    //   163: iload 8
    //   165: istore 4
    //   167: iload 7
    //   169: istore 6
    //   171: iload 8
    //   173: istore 5
    //   175: aload_3
    //   176: ldc_w 299
    //   179: invokevirtual 305	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   182: astore 14
    //   184: aload 14
    //   186: ifnull +545 -> 731
    //   189: iload_2
    //   190: ifeq +541 -> 731
    //   193: iload 7
    //   195: istore_1
    //   196: iload 8
    //   198: istore 4
    //   200: iload 7
    //   202: istore 6
    //   204: iload 8
    //   206: istore 5
    //   208: new 868	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   211: dup
    //   212: invokespecial 869	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   215: astore_3
    //   216: iload 7
    //   218: istore_1
    //   219: iload 8
    //   221: istore 4
    //   223: iload 7
    //   225: istore 6
    //   227: iload 8
    //   229: istore 5
    //   231: aload_3
    //   232: aload 14
    //   234: invokevirtual 870	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   237: pop
    //   238: iload 7
    //   240: istore_1
    //   241: iload 8
    //   243: istore 4
    //   245: iload 7
    //   247: istore 6
    //   249: iload 8
    //   251: istore 5
    //   253: new 301	android/os/Bundle
    //   256: dup
    //   257: invokespecial 871	android/os/Bundle:<init>	()V
    //   260: astore 14
    //   262: iload 7
    //   264: istore_1
    //   265: iload 8
    //   267: istore 4
    //   269: iload 7
    //   271: istore 6
    //   273: iload 8
    //   275: istore 5
    //   277: aload 14
    //   279: ldc_w 872
    //   282: aload_3
    //   283: getfield 876	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   286: invokevirtual 879	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   289: invokevirtual 883	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   292: iload 7
    //   294: istore_1
    //   295: iload 8
    //   297: istore 4
    //   299: iload 7
    //   301: istore 6
    //   303: iload 8
    //   305: istore 5
    //   307: aload_0
    //   308: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   311: aload_3
    //   312: getfield 876	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   315: invokevirtual 879	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   318: putfield 350	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   321: iload 7
    //   323: istore_1
    //   324: iload 8
    //   326: istore 4
    //   328: iload 7
    //   330: istore 6
    //   332: iload 8
    //   334: istore 5
    //   336: aload 14
    //   338: ldc_w 299
    //   341: aload_3
    //   342: getfield 886	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: invokevirtual 413	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   348: invokevirtual 419	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   351: invokevirtual 890	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   354: iload 7
    //   356: istore_1
    //   357: iload 8
    //   359: istore 4
    //   361: iload 7
    //   363: istore 6
    //   365: iload 8
    //   367: istore 5
    //   369: new 892	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$3
    //   372: dup
    //   373: aload_0
    //   374: aload 14
    //   376: invokespecial 895	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$3:<init>	(Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker;Landroid/os/Bundle;)V
    //   379: sipush 128
    //   382: aconst_null
    //   383: iconst_1
    //   384: invokestatic 898	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   387: iload 7
    //   389: istore_1
    //   390: aload_0
    //   391: getfield 42	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:mAppRef	Ljava/lang/ref/WeakReference;
    //   394: invokevirtual 59	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   397: checkcast 148	com/tencent/common/app/AppInterface
    //   400: astore 15
    //   402: aload 15
    //   404: ifnull +326 -> 730
    //   407: aload_0
    //   408: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   411: ifnull +319 -> 730
    //   414: iload 8
    //   416: sipush 1000
    //   419: if_icmpne +785 -> 1204
    //   422: aload_0
    //   423: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   426: getfield 350	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   429: lstore 10
    //   431: aload_0
    //   432: getfield 866	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NL	J
    //   435: aload_0
    //   436: getfield 900	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NK	J
    //   439: lsub
    //   440: lstore 12
    //   442: aconst_null
    //   443: invokestatic 906	aroc:getNetType	(Landroid/content/Context;)I
    //   446: istore 6
    //   448: new 679	java/util/HashMap
    //   451: dup
    //   452: invokespecial 680	java/util/HashMap:<init>	()V
    //   455: astore_3
    //   456: aload_3
    //   457: ldc_w 908
    //   460: lload 10
    //   462: invokestatic 610	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   465: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: aload_3
    //   470: ldc_w 682
    //   473: aload_0
    //   474: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   477: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   480: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   483: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: pop
    //   487: aload_3
    //   488: ldc_w 910
    //   491: iload 6
    //   493: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   496: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: aload 15
    //   502: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   505: invokestatic 697	anpc:a	(Landroid/content/Context;)Lanpc;
    //   508: astore 14
    //   510: aload 15
    //   512: invokevirtual 700	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   515: astore 15
    //   517: lload 10
    //   519: lconst_0
    //   520: lcmp
    //   521: ifne +691 -> 1212
    //   524: iconst_1
    //   525: istore_2
    //   526: aload 14
    //   528: aload 15
    //   530: ldc_w 912
    //   533: iload_2
    //   534: lload 12
    //   536: lconst_0
    //   537: aload_3
    //   538: ldc_w 471
    //   541: iconst_0
    //   542: invokevirtual 706	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   545: lload 10
    //   547: lconst_0
    //   548: lcmp
    //   549: ifne +668 -> 1217
    //   552: iconst_0
    //   553: istore 4
    //   555: aload_0
    //   556: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   559: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   562: istore 7
    //   564: iload_1
    //   565: iconst_2
    //   566: if_icmpne +657 -> 1223
    //   569: aload_0
    //   570: getfield 72	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:cps	I
    //   573: iconst_2
    //   574: isub
    //   575: istore 5
    //   577: aconst_null
    //   578: ldc_w 824
    //   581: ldc_w 826
    //   584: ldc_w 914
    //   587: iload_1
    //   588: iload 4
    //   590: iconst_2
    //   591: anewarray 476	java/lang/String
    //   594: dup
    //   595: iconst_0
    //   596: iload 7
    //   598: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   601: aastore
    //   602: dup
    //   603: iconst_1
    //   604: iload 5
    //   606: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   609: aastore
    //   610: invokestatic 833	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   613: ldc_w 708
    //   616: iconst_1
    //   617: bipush 9
    //   619: anewarray 4	java/lang/Object
    //   622: dup
    //   623: iconst_0
    //   624: ldc_w 916
    //   627: aastore
    //   628: dup
    //   629: iconst_1
    //   630: lload 12
    //   632: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   635: aastore
    //   636: dup
    //   637: iconst_2
    //   638: ldc_w 717
    //   641: aastore
    //   642: dup
    //   643: iconst_3
    //   644: aload_0
    //   645: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   648: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   651: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: aastore
    //   655: dup
    //   656: iconst_4
    //   657: ldc_w 918
    //   660: aastore
    //   661: dup
    //   662: iconst_5
    //   663: lload 10
    //   665: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: dup
    //   670: bipush 6
    //   672: ldc_w 920
    //   675: aastore
    //   676: dup
    //   677: bipush 7
    //   679: iload 6
    //   681: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: dup
    //   686: bipush 8
    //   688: ldc_w 719
    //   691: aastore
    //   692: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   695: iconst_4
    //   696: anewarray 4	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: ldc_w 922
    //   704: aastore
    //   705: dup
    //   706: iconst_1
    //   707: lload 10
    //   709: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   712: aastore
    //   713: dup
    //   714: iconst_2
    //   715: ldc_w 924
    //   718: aastore
    //   719: dup
    //   720: iconst_3
    //   721: lload 12
    //   723: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   726: aastore
    //   727: invokestatic 281	abmt:x	([Ljava/lang/Object;)V
    //   730: return
    //   731: iload 7
    //   733: istore_1
    //   734: iload 8
    //   736: istore 4
    //   738: iload 7
    //   740: istore 6
    //   742: iload 8
    //   744: istore 5
    //   746: ldc 91
    //   748: iconst_1
    //   749: iconst_2
    //   750: anewarray 4	java/lang/Object
    //   753: dup
    //   754: iconst_0
    //   755: ldc_w 926
    //   758: aastore
    //   759: dup
    //   760: iconst_1
    //   761: iload 8
    //   763: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   766: aastore
    //   767: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   770: iload 7
    //   772: istore_1
    //   773: iload 8
    //   775: istore 4
    //   777: iload 7
    //   779: istore 6
    //   781: iload 8
    //   783: istore 5
    //   785: aload_0
    //   786: invokespecial 928	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:cCx	()V
    //   789: goto -402 -> 387
    //   792: astore_3
    //   793: ldc 91
    //   795: iconst_1
    //   796: new 101	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 930
    //   806: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_3
    //   810: invokevirtual 933	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: aload_0
    //   823: getfield 42	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:mAppRef	Ljava/lang/ref/WeakReference;
    //   826: invokevirtual 59	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   829: checkcast 148	com/tencent/common/app/AppInterface
    //   832: astore 15
    //   834: aload 15
    //   836: ifnull -106 -> 730
    //   839: aload_0
    //   840: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   843: ifnull -113 -> 730
    //   846: iload 4
    //   848: sipush 1000
    //   851: if_icmpne +378 -> 1229
    //   854: aload_0
    //   855: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   858: getfield 350	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   861: lstore 10
    //   863: aload_0
    //   864: getfield 866	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NL	J
    //   867: aload_0
    //   868: getfield 900	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NK	J
    //   871: lsub
    //   872: lstore 12
    //   874: aconst_null
    //   875: invokestatic 906	aroc:getNetType	(Landroid/content/Context;)I
    //   878: istore 6
    //   880: new 679	java/util/HashMap
    //   883: dup
    //   884: invokespecial 680	java/util/HashMap:<init>	()V
    //   887: astore_3
    //   888: aload_3
    //   889: ldc_w 908
    //   892: lload 10
    //   894: invokestatic 610	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   897: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   900: pop
    //   901: aload_3
    //   902: ldc_w 682
    //   905: aload_0
    //   906: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   909: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   912: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   915: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   918: pop
    //   919: aload_3
    //   920: ldc_w 910
    //   923: iload 6
    //   925: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   928: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   931: pop
    //   932: aload 15
    //   934: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   937: invokestatic 697	anpc:a	(Landroid/content/Context;)Lanpc;
    //   940: astore 14
    //   942: aload 15
    //   944: invokevirtual 700	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   947: astore 15
    //   949: lload 10
    //   951: lconst_0
    //   952: lcmp
    //   953: ifne +284 -> 1237
    //   956: iconst_1
    //   957: istore_2
    //   958: aload 14
    //   960: aload 15
    //   962: ldc_w 912
    //   965: iload_2
    //   966: lload 12
    //   968: lconst_0
    //   969: aload_3
    //   970: ldc_w 471
    //   973: iconst_0
    //   974: invokevirtual 706	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   977: lload 10
    //   979: lconst_0
    //   980: lcmp
    //   981: ifne +261 -> 1242
    //   984: iconst_0
    //   985: istore 4
    //   987: aload_0
    //   988: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   991: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   994: istore 7
    //   996: iload_1
    //   997: iconst_2
    //   998: if_icmpne +250 -> 1248
    //   1001: aload_0
    //   1002: getfield 72	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:cps	I
    //   1005: iconst_2
    //   1006: isub
    //   1007: istore 5
    //   1009: aconst_null
    //   1010: ldc_w 824
    //   1013: ldc_w 826
    //   1016: ldc_w 914
    //   1019: iload_1
    //   1020: iload 4
    //   1022: iconst_2
    //   1023: anewarray 476	java/lang/String
    //   1026: dup
    //   1027: iconst_0
    //   1028: iload 7
    //   1030: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1033: aastore
    //   1034: dup
    //   1035: iconst_1
    //   1036: iload 5
    //   1038: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1041: aastore
    //   1042: invokestatic 833	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1045: ldc_w 708
    //   1048: iconst_1
    //   1049: bipush 9
    //   1051: anewarray 4	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: ldc_w 916
    //   1059: aastore
    //   1060: dup
    //   1061: iconst_1
    //   1062: lload 12
    //   1064: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1067: aastore
    //   1068: dup
    //   1069: iconst_2
    //   1070: ldc_w 717
    //   1073: aastore
    //   1074: dup
    //   1075: iconst_3
    //   1076: aload_0
    //   1077: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1080: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1083: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1086: aastore
    //   1087: dup
    //   1088: iconst_4
    //   1089: ldc_w 918
    //   1092: aastore
    //   1093: dup
    //   1094: iconst_5
    //   1095: lload 10
    //   1097: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1100: aastore
    //   1101: dup
    //   1102: bipush 6
    //   1104: ldc_w 920
    //   1107: aastore
    //   1108: dup
    //   1109: bipush 7
    //   1111: iload 6
    //   1113: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1116: aastore
    //   1117: dup
    //   1118: bipush 8
    //   1120: ldc_w 719
    //   1123: aastore
    //   1124: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1127: iconst_4
    //   1128: anewarray 4	java/lang/Object
    //   1131: dup
    //   1132: iconst_0
    //   1133: ldc_w 922
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_1
    //   1139: lload 10
    //   1141: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1144: aastore
    //   1145: dup
    //   1146: iconst_2
    //   1147: ldc_w 924
    //   1150: aastore
    //   1151: dup
    //   1152: iconst_3
    //   1153: lload 12
    //   1155: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1158: aastore
    //   1159: invokestatic 281	abmt:x	([Ljava/lang/Object;)V
    //   1162: return
    //   1163: iload 7
    //   1165: istore_1
    //   1166: iload 8
    //   1168: istore 4
    //   1170: iload 9
    //   1172: istore 6
    //   1174: iload 8
    //   1176: istore 5
    //   1178: ldc 91
    //   1180: iconst_1
    //   1181: iconst_2
    //   1182: anewarray 4	java/lang/Object
    //   1185: dup
    //   1186: iconst_0
    //   1187: ldc_w 935
    //   1190: aastore
    //   1191: dup
    //   1192: iconst_1
    //   1193: aload 14
    //   1195: aastore
    //   1196: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1199: iconst_0
    //   1200: istore_1
    //   1201: goto -811 -> 390
    //   1204: iload 8
    //   1206: i2l
    //   1207: lstore 10
    //   1209: goto -778 -> 431
    //   1212: iconst_0
    //   1213: istore_2
    //   1214: goto -688 -> 526
    //   1217: iconst_1
    //   1218: istore 4
    //   1220: goto -665 -> 555
    //   1223: iconst_0
    //   1224: istore 5
    //   1226: goto -649 -> 577
    //   1229: iload 4
    //   1231: i2l
    //   1232: lstore 10
    //   1234: goto -371 -> 863
    //   1237: iconst_0
    //   1238: istore_2
    //   1239: goto -281 -> 958
    //   1242: iconst_1
    //   1243: istore 4
    //   1245: goto -258 -> 987
    //   1248: iconst_0
    //   1249: istore 5
    //   1251: goto -242 -> 1009
    //   1254: astore_3
    //   1255: iload 6
    //   1257: istore_1
    //   1258: iload 5
    //   1260: istore 4
    //   1262: aload_0
    //   1263: getfield 42	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:mAppRef	Ljava/lang/ref/WeakReference;
    //   1266: invokevirtual 59	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1269: checkcast 148	com/tencent/common/app/AppInterface
    //   1272: astore 16
    //   1274: aload 16
    //   1276: ifnull +331 -> 1607
    //   1279: aload_0
    //   1280: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1283: ifnull +324 -> 1607
    //   1286: iload 4
    //   1288: sipush 1000
    //   1291: if_icmpne +318 -> 1609
    //   1294: aload_0
    //   1295: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1298: getfield 350	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   1301: lstore 10
    //   1303: aload_0
    //   1304: getfield 866	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NL	J
    //   1307: aload_0
    //   1308: getfield 900	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:NK	J
    //   1311: lsub
    //   1312: lstore 12
    //   1314: aconst_null
    //   1315: invokestatic 906	aroc:getNetType	(Landroid/content/Context;)I
    //   1318: istore 6
    //   1320: new 679	java/util/HashMap
    //   1323: dup
    //   1324: invokespecial 680	java/util/HashMap:<init>	()V
    //   1327: astore 14
    //   1329: aload 14
    //   1331: ldc_w 908
    //   1334: lload 10
    //   1336: invokestatic 610	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1339: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1342: pop
    //   1343: aload 14
    //   1345: ldc_w 682
    //   1348: aload_0
    //   1349: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1352: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1355: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1358: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1361: pop
    //   1362: aload 14
    //   1364: ldc_w 910
    //   1367: iload 6
    //   1369: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1372: invokevirtual 688	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1375: pop
    //   1376: aload 16
    //   1378: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1381: invokestatic 697	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1384: astore 15
    //   1386: aload 16
    //   1388: invokevirtual 700	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1391: astore 16
    //   1393: lload 10
    //   1395: lconst_0
    //   1396: lcmp
    //   1397: ifne +220 -> 1617
    //   1400: iconst_1
    //   1401: istore_2
    //   1402: aload 15
    //   1404: aload 16
    //   1406: ldc_w 912
    //   1409: iload_2
    //   1410: lload 12
    //   1412: lconst_0
    //   1413: aload 14
    //   1415: ldc_w 471
    //   1418: iconst_0
    //   1419: invokevirtual 706	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1422: lload 10
    //   1424: lconst_0
    //   1425: lcmp
    //   1426: ifne +196 -> 1622
    //   1429: iconst_0
    //   1430: istore 4
    //   1432: aload_0
    //   1433: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1436: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1439: istore 7
    //   1441: iload_1
    //   1442: iconst_2
    //   1443: if_icmpne +185 -> 1628
    //   1446: aload_0
    //   1447: getfield 72	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:cps	I
    //   1450: iconst_2
    //   1451: isub
    //   1452: istore 5
    //   1454: aconst_null
    //   1455: ldc_w 824
    //   1458: ldc_w 826
    //   1461: ldc_w 914
    //   1464: iload_1
    //   1465: iload 4
    //   1467: iconst_2
    //   1468: anewarray 476	java/lang/String
    //   1471: dup
    //   1472: iconst_0
    //   1473: iload 7
    //   1475: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1478: aastore
    //   1479: dup
    //   1480: iconst_1
    //   1481: iload 5
    //   1483: invokestatic 684	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1486: aastore
    //   1487: invokestatic 833	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1490: ldc_w 708
    //   1493: iconst_1
    //   1494: bipush 9
    //   1496: anewarray 4	java/lang/Object
    //   1499: dup
    //   1500: iconst_0
    //   1501: ldc_w 916
    //   1504: aastore
    //   1505: dup
    //   1506: iconst_1
    //   1507: lload 12
    //   1509: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1512: aastore
    //   1513: dup
    //   1514: iconst_2
    //   1515: ldc_w 717
    //   1518: aastore
    //   1519: dup
    //   1520: iconst_3
    //   1521: aload_0
    //   1522: getfield 46	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1525: getfield 242	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1528: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1531: aastore
    //   1532: dup
    //   1533: iconst_4
    //   1534: ldc_w 918
    //   1537: aastore
    //   1538: dup
    //   1539: iconst_5
    //   1540: lload 10
    //   1542: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1545: aastore
    //   1546: dup
    //   1547: bipush 6
    //   1549: ldc_w 920
    //   1552: aastore
    //   1553: dup
    //   1554: bipush 7
    //   1556: iload 6
    //   1558: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1561: aastore
    //   1562: dup
    //   1563: bipush 8
    //   1565: ldc_w 719
    //   1568: aastore
    //   1569: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1572: iconst_4
    //   1573: anewarray 4	java/lang/Object
    //   1576: dup
    //   1577: iconst_0
    //   1578: ldc_w 922
    //   1581: aastore
    //   1582: dup
    //   1583: iconst_1
    //   1584: lload 10
    //   1586: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1589: aastore
    //   1590: dup
    //   1591: iconst_2
    //   1592: ldc_w 924
    //   1595: aastore
    //   1596: dup
    //   1597: iconst_3
    //   1598: lload 12
    //   1600: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1603: aastore
    //   1604: invokestatic 281	abmt:x	([Ljava/lang/Object;)V
    //   1607: aload_3
    //   1608: athrow
    //   1609: iload 4
    //   1611: i2l
    //   1612: lstore 10
    //   1614: goto -311 -> 1303
    //   1617: iconst_0
    //   1618: istore_2
    //   1619: goto -217 -> 1402
    //   1622: iconst_1
    //   1623: istore 4
    //   1625: goto -193 -> 1432
    //   1628: iconst_0
    //   1629: istore 5
    //   1631: goto -177 -> 1454
    //   1634: astore_3
    //   1635: goto -373 -> 1262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1638	0	this	CmGameStartChecker
    //   0	1638	1	paramInt	int
    //   0	1638	2	paramBoolean	boolean
    //   0	1638	3	paramBundle	Bundle
    //   4	1620	4	i	int
    //   1	1629	5	j	int
    //   17	1540	6	k	int
    //   10	1464	7	m	int
    //   26	1179	8	n	int
    //   7	1164	9	i1	int
    //   429	1184	10	l1	long
    //   440	1159	12	l2	long
    //   50	1364	14	localObject1	Object
    //   400	1003	15	localObject2	Object
    //   1272	133	16	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	28	792	java/lang/Exception
    //   43	52	792	java/lang/Exception
    //   67	78	792	java/lang/Exception
    //   93	111	792	java/lang/Exception
    //   126	138	792	java/lang/Exception
    //   153	160	792	java/lang/Exception
    //   175	184	792	java/lang/Exception
    //   208	216	792	java/lang/Exception
    //   231	238	792	java/lang/Exception
    //   253	262	792	java/lang/Exception
    //   277	292	792	java/lang/Exception
    //   307	321	792	java/lang/Exception
    //   336	354	792	java/lang/Exception
    //   369	387	792	java/lang/Exception
    //   746	770	792	java/lang/Exception
    //   785	789	792	java/lang/Exception
    //   1178	1199	792	java/lang/Exception
    //   19	28	1254	finally
    //   43	52	1254	finally
    //   67	78	1254	finally
    //   93	111	1254	finally
    //   126	138	1254	finally
    //   153	160	1254	finally
    //   175	184	1254	finally
    //   208	216	1254	finally
    //   231	238	1254	finally
    //   253	262	1254	finally
    //   277	292	1254	finally
    //   307	321	1254	finally
    //   336	354	1254	finally
    //   369	387	1254	finally
    //   746	770	1254	finally
    //   785	789	1254	finally
    //   1178	1199	1254	finally
    //   793	822	1634	finally
  }
  
  public void startGame()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "startGame startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
    }
    ThreadManager.post(new CmGameStartChecker.1(this), 5, null, true);
  }
  
  public String t(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return "";
    }
    return ApolloUtil.dq(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
  }
  
  public static class StartCheckParam
    implements Serializable
  {
    public static final int COMMON_FLAG_BIT_SHOW_QUIT_TIPS = 1;
    public static final int COMMON_FLAG_BIT_SHOW_RED_PACKET_BTN = 2;
    public static final int COMMON_FLAG_BIT_SHOW_RED_PACKET_FLOAT_VIEW = 4;
    public static final int START_MODE_FROM_TIPBAR = 1;
    public static final int START_MODE_IN_GAME = 2;
    public static final int START_MODE_MAIN_LOADING = 3;
    public static final int START_MODE_NORMAL = 0;
    private static final long serialVersionUID = 1L;
    public long adDevUin;
    public String adForbidPosId;
    public int adShareRate;
    public int aioType;
    public String apolloGameSt;
    public String apolloGameStkey;
    public int apolloStatus;
    public int appIdSrc;
    public int commFlag;
    public int delayMs;
    public boolean disableMinGame;
    public boolean enableMenu = true;
    public int enter;
    public String extInfoFromSvr;
    public String extendJson;
    public String from;
    public ApolloGameData game;
    public int gameId;
    public int gameMode;
    public String gameName;
    public int gameTypeForRedPacket;
    public int gender;
    public boolean isCreator;
    public boolean isEnableMSAA;
    public boolean isGameRscExist;
    public boolean isNeedConfInfo;
    public boolean isPatch;
    public boolean isRequestConf;
    public boolean isRunning;
    public boolean isWhiteUsr;
    public boolean launchNewGame;
    public long mCreateTs;
    public String mExtraStr;
    public String mFriendUin;
    public int mGameType;
    public boolean mIsTransGame;
    public boolean mLoadingOnMainProcess;
    public boolean mOpenTempAIOOnFinish;
    public String mRobotOpenId;
    public String mSSORule;
    public String mSendMsgUin;
    public int mStartType = 0;
    public String mTempAIONickName;
    public String mTempAIOUin;
    public boolean mUpdated;
    public int msgGameStatus;
    public boolean notFullScreen;
    public String openId;
    public CmGamePushItem pushItem;
    public String redUrl;
    public long requestCode;
    public long retCode;
    public long roomId;
    public String rpIconUrl;
    public String rpUrl;
    public String sessionOpenId;
    public int sessionType;
    public String sessionUin;
    public boolean showAlertTips;
    public int src;
    public long startCallEngine;
    public long startCheckGame;
    public long startT;
    public ConcurrentHashMap<String, Long> statMap = new ConcurrentHashMap();
    public String styleString;
    public String transInfo;
    public String version;
    public int viewMode;
    public String wordingV2;
    public String zipMD5;
    
    public StartCheckParam(int paramInt1, boolean paramBoolean, String paramString1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, int paramInt6, String paramString3)
    {
      this.gameId = paramInt1;
      this.isCreator = paramBoolean;
      this.from = paramString1;
      this.enter = paramInt2;
      this.gameMode = paramInt3;
      this.sessionType = paramInt5;
      this.sessionUin = paramString2;
      this.src = paramInt6;
      this.aioType = paramInt4;
      this.roomId = paramLong;
      this.gameName = paramString3;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("StartCheckParam{");
      localStringBuffer.append("game=").append(this.game);
      localStringBuffer.append(", pushItem=").append(this.pushItem);
      localStringBuffer.append(", mSendMsgUin='").append(this.mSendMsgUin).append('\'');
      localStringBuffer.append(", gameId=").append(this.gameId);
      localStringBuffer.append(", gameName='").append(this.gameName).append('\'');
      localStringBuffer.append(", isCreator=").append(this.isCreator);
      localStringBuffer.append(", from='").append(this.from).append('\'');
      localStringBuffer.append(", roomId=").append(this.roomId);
      localStringBuffer.append(", enter=").append(this.enter);
      localStringBuffer.append(", isRunning=").append(this.isRunning);
      localStringBuffer.append(", gameMode=").append(this.gameMode);
      localStringBuffer.append(", viewMode=").append(this.viewMode);
      localStringBuffer.append(", sessionType=").append(this.sessionType);
      localStringBuffer.append(", aioType=").append(this.aioType);
      localStringBuffer.append(", sessionUin='").append(this.sessionUin).append('\'');
      localStringBuffer.append(", src=").append(this.src);
      localStringBuffer.append(", requestCode=").append(this.requestCode);
      localStringBuffer.append(", extendJson='").append(this.extendJson).append('\'');
      localStringBuffer.append(", version='").append(this.version).append('\'');
      localStringBuffer.append(", isPatch=").append(this.isPatch);
      localStringBuffer.append(", zipMD5='").append(this.zipMD5).append('\'');
      localStringBuffer.append(", retCode=").append(this.retCode);
      localStringBuffer.append(", wordingV2='").append(this.wordingV2).append('\'');
      localStringBuffer.append(", apolloGameSt='").append(this.apolloGameSt).append('\'');
      localStringBuffer.append(", apolloGameStkey='").append(this.apolloGameStkey).append('\'');
      localStringBuffer.append(", openId='").append(this.openId).append('\'');
      localStringBuffer.append(", sessionOpenId='").append(this.sessionOpenId).append('\'');
      localStringBuffer.append(", extInfoFromSvr='").append(this.extInfoFromSvr).append('\'');
      localStringBuffer.append(", mExtraStr='").append(this.mExtraStr).append('\'');
      localStringBuffer.append(", mFriendUin='").append(this.mFriendUin).append('\'');
      localStringBuffer.append(", showAlertTips=").append(this.showAlertTips);
      localStringBuffer.append(", msgGameStatus=").append(this.msgGameStatus);
      localStringBuffer.append(", launchNewGame=").append(this.launchNewGame);
      localStringBuffer.append(", isWhiteUsr=").append(this.isWhiteUsr);
      localStringBuffer.append(", gender=").append(this.gender);
      localStringBuffer.append(", apolloStatus=").append(this.apolloStatus);
      localStringBuffer.append(", mGameType=").append(this.mGameType);
      localStringBuffer.append(", mUpdated=").append(this.mUpdated);
      localStringBuffer.append(", gameTypeForRedPacket=").append(this.gameTypeForRedPacket);
      localStringBuffer.append(", redUrl='").append(this.redUrl).append('\'');
      localStringBuffer.append(", startT=").append(this.startT);
      localStringBuffer.append(", startCheckGame=").append(this.startCheckGame);
      localStringBuffer.append(", startCallEngine=").append(this.startCallEngine);
      localStringBuffer.append(", appIdSrc=").append(this.appIdSrc);
      localStringBuffer.append(", commFlag=").append(this.commFlag);
      localStringBuffer.append(", enableMenu=").append(this.enableMenu);
      localStringBuffer.append(", disableMinGame=").append(this.disableMinGame);
      localStringBuffer.append(", mStartType=").append(this.mStartType);
      localStringBuffer.append(", mOpenTempAIOOnFinish=").append(this.mOpenTempAIOOnFinish);
      localStringBuffer.append(", mTempAIOUin='").append(this.mTempAIOUin).append('\'');
      localStringBuffer.append(", mTempAIONickName='").append(this.mTempAIONickName).append('\'');
      localStringBuffer.append(", adDevUin=").append(this.adDevUin);
      localStringBuffer.append(", adShareRate=").append(this.adShareRate);
      localStringBuffer.append(", adForbidPosId='").append(this.adForbidPosId).append('\'');
      localStringBuffer.append(", rpUrl='").append(this.rpUrl).append('\'');
      localStringBuffer.append(", rpIconUrl='").append(this.rpIconUrl).append('\'');
      localStringBuffer.append(", isNeedConfInfo=").append(this.isNeedConfInfo);
      localStringBuffer.append(", isRequestConf=").append(this.isRequestConf);
      localStringBuffer.append(", mRobotOpenId='").append(this.mRobotOpenId).append('\'');
      localStringBuffer.append(", isEnableMSAA=").append(this.isEnableMSAA);
      localStringBuffer.append(", mCreateTs=").append(this.mCreateTs);
      localStringBuffer.append(", mLoadingOnMainProcess=").append(this.mLoadingOnMainProcess);
      localStringBuffer.append(", mSSORule='").append(this.mSSORule).append('\'');
      localStringBuffer.append(", statMap=").append(this.statMap);
      localStringBuffer.append(", mIsTransGame=").append(this.mIsTransGame);
      localStringBuffer.append(", transInfo=").append(this.transInfo);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
  
  public static abstract class a
    implements abkb
  {
    private AppInterface mApp;
    private final boolean mInMainProcess;
    
    public a(AppInterface paramAppInterface, boolean paramBoolean)
    {
      this.mApp = paramAppInterface;
      this.mInMainProcess = paramBoolean;
    }
    
    public void onDownloadGameResDown(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
        QLog.e("cmgame_process.CmGameStartChecker", 1, "onDownloadGameResDown startCheckParam == null");
      }
      do
      {
        return;
        if (!this.mInMainProcess) {
          break;
        }
      } while (!(this.mApp instanceof QQAppInterface));
      ApolloGameUtil.b((QQAppInterface)this.mApp, paramStartCheckParam);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "onDownloadGameResDown", localBundle, null);
    }
    
    public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
    
    public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt) {}
    
    public void onDownloadGameResStart(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
    
    public void onGameCheckRetry(int paramInt) {}
    
    public void onGameCheckStart(CmGameStartChecker.StartCheckParam paramStartCheckParam)
    {
      if (paramStartCheckParam == null) {
        QLog.e("cmgame_process.CmGameStartChecker", 1, "onGameCheckStart startCheckParam == null");
      }
      do
      {
        return;
        if (!this.mInMainProcess) {
          break;
        }
      } while (!(this.mApp instanceof QQAppInterface));
      ApolloGameUtil.a((QQAppInterface)this.mApp, paramStartCheckParam);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "onGameCheckStart", localBundle, null);
    }
    
    public void onGameFailed(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong) {}
    
    public void onGetGameData(CmGameStartChecker.StartCheckParam paramStartCheckParam) {}
    
    public void onSsoCmdRuleRsp(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString)
    {
      if (paramStartCheckParam == null) {
        QLog.e("cmgame_process.CmGameStartChecker", 1, "onSsoCmdRuleRsp startCheckParam == null");
      }
      Object localObject;
      do
      {
        return;
        if (this.mInMainProcess)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putSerializable("StartCheckParam", paramStartCheckParam);
          ((Bundle)localObject).putString("rule", paramString);
          paramStartCheckParam.mSSORule = paramString;
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_set_sso_rule", (Bundle)localObject, null);
          return;
        }
        localObject = abmt.a();
      } while (localObject == null);
      ((aboz)localObject).bQ(paramStartCheckParam.gameId, paramString);
    }
    
    public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  }
  
  public static abstract interface b
  {
    public abstract void b(CmGameStartChecker.StartCheckParam paramStartCheckParam);
    
    public abstract void c(CmGameStartChecker.StartCheckParam paramStartCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker
 * JD-Core Version:    0.7.0.1
 */