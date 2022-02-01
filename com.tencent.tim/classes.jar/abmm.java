import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.2;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.3;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class abmm
  extends QIPCModule
{
  public static boolean bDY;
  public static boolean sIsDownLoadingSo;
  private long NW;
  private abox a = new abox();
  private boolean bDZ;
  private CmGameStartChecker.StartCheckParam jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameInitParams jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  private WeakReference<CmGameLoadingFragment> fG;
  
  public abmm(String paramString)
  {
    super(paramString);
  }
  
  public static abmm a()
  {
    return abmm.a.b();
  }
  
  public static void registerModule()
  {
    abmm localabmm = a();
    if (!bDY)
    {
      QIPCServerHelper.getInstance().register(localabmm);
      bDY = true;
    }
  }
  
  public abow a(int paramInt)
  {
    if (this.a != null) {
      return this.a.a(paramInt);
    }
    return null;
  }
  
  public abox a()
  {
    return this.a;
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong, CmGameInitParams paramCmGameInitParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd cmGameInitParams:", paramCmGameInitParams });
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    if (paramStartCheckParam != null) {
      this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    }
    this.NW = paramLong;
    if (paramLong != 0L) {
      ApolloGameUtil.a(paramStartCheckParam, true);
    }
    this.bDZ = true;
    if ((this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (abmt.aY(BaseApplicationImpl.getContext())))
    {
      paramStartCheckParam = new Bundle();
      paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      paramStartCheckParam.putLong("ResultCode", this.NW);
      if (this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
        paramStartCheckParam.putSerializable("CmGameInitParams", this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_check_game_data", paramStartCheckParam, null);
    }
  }
  
  public void a(CmGameLoadingFragment paramCmGameLoadingFragment, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    this.NW = -1L;
    this.fG = new WeakReference(paramCmGameLoadingFragment);
    this.bDZ = false;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingStart startCheckParam:", paramStartCheckParam });
    }
  }
  
  public void as(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpen", paramBoolean);
    localBundle.putString("key_game_friUin", paramString);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_update_audio_status", localBundle, null);
  }
  
  public void cDo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "closeAllGames");
    }
    if (this.a != null)
    {
      List localList = this.a.dF();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          abow localabow = (abow)localList.get(i);
          if ((localabow != null) && (!abmt.hP(localabow.getGameId())) && (!abmt.hP(localabow.getGameId())))
          {
            abml.Hw(localabow.getGameId());
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "closeAllGame gameId:" + localabow.getGameId());
          }
          i += 1;
        }
      }
    }
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    super.callbackResult(paramInt, paramEIPCResult);
  }
  
  public void dt(ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("CmShow onDressChanged uins.size:");
      if (paramArrayList == null) {
        break label80;
      }
    }
    label80:
    for (int i = paramArrayList.size();; i = 0)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 1, i);
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("key_dress_change_uin", paramArrayList);
      QIPCServerHelper.getInstance().callClient(LocalMultiProcConfig.PROCESS_NAME, "cm_game_client_module", "action_dress_changed", (Bundle)localObject, new abms(this));
      return;
    }
  }
  
  public void h(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("startTime", System.currentTimeMillis());
    localBundle.putSerializable("StartCheckParam", paramStartCheckParam);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_start_cmgame_direct", localBundle, null);
  }
  
  public void i(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "onGameLoadingCheckEnd startCheckParam:", paramStartCheckParam });
    }
    ApolloGameUtil.a(paramStartCheckParam, true);
    paramStartCheckParam = new Bundle();
    paramStartCheckParam.putSerializable("StartCheckParam", this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    paramStartCheckParam.putLong("ResultCode", this.NW);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_game_loading_closed", paramStartCheckParam, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "onCall main server action=" + paramString);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface)) {
      return null;
    }
    try
    {
      if ("action_aduio_query_voice_status".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        paramBundle = (abhh)((QQAppInterface)localObject1).getManager(153);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("isOpen", paramBundle.a().ju(paramString));
        ((Bundle)localObject1).putBoolean("display", ablz.bDM);
        callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
      }
      else if ("action_audio_exit_room".equals(paramString))
      {
        paramString = paramBundle.getString("key_game_friUin");
        ((abhh)((QQAppInterface)localObject1).getManager(153)).a().de(paramString, 318);
      }
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, paramString, new Object[0]);
    }
    int i;
    label519:
    label630:
    Object localObject2;
    if ("action_aduio_enter_room".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      boolean bool = paramBundle.getBoolean("key_open_voice", false);
      paramBundle = ((abhh)((QQAppInterface)localObject1).getManager(153)).a();
      if ((bool) || ((ablz.bDL) && (!paramBundle.Yz()))) {
        paramBundle.dd(paramString, 318);
      }
    }
    else if ("action_voice_switch".equals(paramString))
    {
      paramString = paramBundle.getString("key_game_friUin");
      ((abhh)((QQAppInterface)localObject1).getManager(153)).a().dc(paramString, 318);
    }
    else if ("action_chanel_req".equals(paramString))
    {
      CmGameCmdChannel.a((QQAppInterface)localObject1).a(paramBundle.getString("cmd"), paramBundle.getString("reqData"), paramBundle.getBoolean("async"), paramInt, paramBundle.getInt("gameId"));
    }
    else if ("action_get_accountInfo".equals(paramString))
    {
      i = paramBundle.getInt("type");
      paramString = paramBundle.getString("uin");
      CmGameCmdChannel.a((QQAppInterface)localObject1).u(paramInt, paramString, i);
    }
    else if ("action_loadyoutu".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString != null) && ((paramString instanceof QQAppInterface)))
      {
        paramString = (QQAppInterface)paramString;
        break label2282;
        paramString = new kqh(paramString, BaseApplicationImpl.getContext());
        sIsDownLoadingSo = true;
        paramString.a(new abmn(this, paramInt));
        paramString.start();
        break label2280;
      }
    }
    else
    {
      if ("onGameCheckStart".equals(paramString))
      {
        if (!QLog.isColorLevel()) {
          break label2288;
        }
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONGAMECHECKSTART" });
        break label2288;
        paramString = abmt.getAppInterface();
        if (!(paramString instanceof QQAppInterface)) {
          return null;
        }
        paramString = (QQAppInterface)paramString;
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if (paramBundle == null) {
          return null;
        }
        if (abmt.hP(paramBundle.gameId))
        {
          if (!QLog.isColorLevel()) {
            break label2294;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "the game is IsLand");
          break label2294;
        }
        ApolloGameUtil.a(paramString, paramBundle);
        break label2280;
      }
      if ("onDownloadGameResDown".equals(paramString))
      {
        if (!QLog.isColorLevel()) {
          break label2296;
        }
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_START_CHECKER_ONDOWNLOADGAMERESDOWN" });
        break label2296;
        paramString = abmt.getAppInterface();
        if (!(paramString instanceof QQAppInterface)) {
          return null;
        }
        paramString = (QQAppInterface)paramString;
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        if ((paramBundle == null) || (paramBundle.game == null)) {
          break label2302;
        }
        ApolloGameUtil.b(paramString, paramBundle);
        break label2280;
      }
      int j;
      if ("game_activity_lifecycle".equals(paramString))
      {
        paramInt = paramBundle.getInt("gameId");
        i = paramBundle.getInt("status");
        j = paramBundle.getInt("activityId");
        paramString = paramBundle.getSerializable("para");
        if ((paramString != null) && ((paramString instanceof CmGameStartChecker.StartCheckParam)))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramString;
          label740:
          if (this.a == null) {
            break label2280;
          }
          this.a.a(paramInt, i, j, paramString);
          break label2280;
        }
      }
      else if ("action_get_action_data".equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "apollo_cmGame_", " ACTION_GET_ACTION_DATA params:" + paramBundle });
        }
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString != null) && ((paramString instanceof QQAppInterface)))
        {
          paramString = (QQAppInterface)paramString;
          break label2304;
          label844:
          ThreadManager.post(new CmGameServerQIPCModule.2(this, paramString, paramBundle.getString("reqData"), paramInt), 5, null, true);
          break label2280;
        }
      }
      else
      {
        if ("action_update_game_push".equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_UPDATE_GAME_PUSH params:" + paramBundle);
          }
          paramString = (QQAppInterface)abmt.getAppInterface();
          if (paramString == null) {
            return null;
          }
          paramBundle = (CmGamePushItem)paramBundle.getSerializable("CmGamePushItem");
          if (paramBundle == null) {
            break label2280;
          }
          ((abhh)paramString.getManager(153)).a().a(paramBundle);
          break label2280;
        }
        if ("action_query_check_game_data".equals(paramString))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_QUERY_CHECK_GAME_DATA params:" + paramString);
          }
          if (paramString == null) {
            break label2280;
          }
          paramBundle = new Bundle();
          if ((this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs != paramString.mCreateTs))
          {
            paramBundle.putInt("result", -1);
            paramBundle.putSerializable("StartCheckParam", paramString);
            callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          }
          while (this.fG != null)
          {
            paramString = (CmGameLoadingFragment)this.fG.get();
            if (paramString == null) {
              break;
            }
            paramString.DO(this.bDZ);
            break;
            if (this.bDZ)
            {
              paramBundle.putInt("result", 0);
              paramBundle.putLong("ResultCode", this.NW);
              if (this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
                paramBundle.putSerializable("CmGameInitParams", this.jdField_c_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams);
              }
              paramBundle.putSerializable("StartCheckParam", this.jdField_c_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
            }
            else
            {
              QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_QUERY_CHECK_GAME_DATA mCheckGameEnd false");
            }
          }
        }
        if ("action_on_game_activity_closed".equals(paramString))
        {
          paramString = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED params:" + paramString);
          }
          if ((paramString == null) || (this.fG == null)) {
            break label2280;
          }
          paramString = (CmGameLoadingFragment)this.fG.get();
          if ((paramString == null) || (paramString.getActivity() == null)) {
            break label2280;
          }
          paramString.gU(100L);
          if (!QLog.isColorLevel()) {
            break label2280;
          }
          QLog.d("cmgame_process.CmGameServerQIPCModule", 2, "ACTION_ON_GAME_ACTIVITY_CLOSED close loadingView");
          break label2280;
        }
        if ("action_render_view_get_initavatar_js".equals(paramString))
        {
          paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
          ThreadManagerV2.excute(new CmGameServerQIPCModule.3(this, (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext"), paramInt), 16, null, false);
          break label2280;
        }
        if ("action_render_view_get_base_data".equals(paramString))
        {
          if ((localObject1 instanceof QQAppInterface)) {
            abvg.W((QQAppInterface)localObject1);
          }
          paramString = new Bundle();
          paramString.putString("sApolloBaseScriptId", abxi.bjH);
          paramString.putBoolean("sDisableCreateRenderThread", abhh.bCR);
          paramString.putBoolean("sApolloEngineLockEnable", abhh.bCS);
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
          break label2280;
        }
        if ("action_init_cmshow_data".equals(paramString))
        {
          paramString = paramBundle.getString("selfUin");
          paramBundle = paramBundle.getString("friendUin");
          QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA selfUin:" + ApolloUtil.iY(paramString) + " friendUin:" + ApolloUtil.iY(paramBundle));
          if (!(localObject1 instanceof QQAppInterface)) {
            break label2280;
          }
          Object localObject3 = (abhh)((QQAppInterface)localObject1).getManager(153);
          localObject1 = (aqrb)((QQAppInterface)localObject1).getBusinessHandler(71);
          localObject2 = ((abhh)localObject3).b(paramString);
          ApolloBaseInfo localApolloBaseInfo = ((abhh)localObject3).b(paramBundle);
          localObject3 = new ArrayList();
          if ((!TextUtils.isEmpty(paramString)) && ((localObject2 == null) || (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS))) {
            ((List)localObject3).add(paramString);
          }
          if ((!TextUtils.isEmpty(paramBundle)) && ((localApolloBaseInfo == null) || (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS))) {
            ((List)localObject3).add(paramBundle);
          }
          if (!((List)localObject3).isEmpty())
          {
            QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA but ApolloBaseInfo need update size:" + ((List)localObject3).size());
            localObject2 = new String[((List)localObject3).size()];
            i = 0;
            while (i < ((List)localObject3).size())
            {
              localObject2[i] = ((String)((List)localObject3).get(i));
              i += 1;
            }
            ((aqrb)localObject1).a(new abmo(this, (List)localObject3, paramString, paramBundle, paramInt));
            ((aqrb)localObject1).Z((String[])localObject2);
            break label2280;
          }
          i = abhh.c(ApolloUtil.a(), paramString, true);
          j = abhh.c(ApolloUtil.a(), paramBundle, true);
          paramString = new Bundle();
          paramString.putInt("selfUinStatus", i);
          paramString.putInt("friendUinStatus", j);
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
          break label2280;
        }
        if ("action_render_view_play_action".equals(paramString))
        {
          long l = System.currentTimeMillis();
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PLAY_ACTION");
          paramBundle.setClassLoader(IPCSpriteContext.class.getClassLoader());
          paramString = (IPCSpriteContext)paramBundle.getParcelable("IPCSpriteContext");
          paramBundle = (CmShowRenderView.PlayActionConfig)paramBundle.getParcelable("PlayActionConfig");
          if ((paramBundle == null) || (paramString == null))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PLAY_ACTION playActionConfig == null || ipcSpriteContext == null");
            return null;
          }
          i = paramBundle.mActionId;
          j = paramBundle.crn;
          localObject1 = new SpriteTaskParam();
          ((SpriteTaskParam)localObject1).mActionId = i;
          ThreadManagerV2.excute(new CmGameServerQIPCModule.5(this, i, (SpriteTaskParam)localObject1, paramString, j, paramBundle, l, paramInt), 16, null, false);
          break label2280;
        }
        if ("action_render_view_preload_res".equals(paramString))
        {
          QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "CmShow ACTION_RENDER_VIEW_PRELOAD_RES");
          paramString = paramBundle.getIntArray("actionIds");
          if ((paramString == null) || (paramString.length < 0))
          {
            QLog.e("cmgame_process.CmGameServerQIPCModule", 1, "ACTION_RENDER_VIEW_PRELOAD_RES actionIds==null");
            callbackResult(paramInt, EIPCResult.createResult(-1, null));
            break label2280;
          }
          paramBundle = new ArrayList();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramString.length)
      {
        localObject1 = abrj.a(ApolloUtil.a(), paramString[i]);
        if (localObject1 != null)
        {
          localObject2 = new abto.a(3, paramString[i]);
          ((abto.a)localObject2).mActionType = ((ApolloActionData)localObject1).actionType;
          paramBundle.add(localObject2);
        }
      }
      else
      {
        abto.a(ApolloUtil.a(), "", new abmq(this, paramInt), paramBundle, false);
        break label2280;
        if ("action_cmshow_tracereport".equals(paramString))
        {
          abwo.s(paramBundle.getString("action"), paramBundle.getBundle("bundle"));
        }
        else
        {
          if ("action_render_view_open_store".equals(paramString))
          {
            paramBundle = paramBundle.getString("url");
            if (BaseActivity.sTopActivity != null) {}
            for (paramString = BaseActivity.sTopActivity;; paramString = BaseApplicationImpl.getContext())
            {
              ApolloUtil.a(paramString, null, null, paramBundle, null);
              QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_OPEN_STORE url:" + paramBundle);
              callbackResult(paramInt, EIPCResult.createResult(0, null));
              break;
            }
          }
          if ("action_render_view_change_mode".equals(paramString))
          {
            i = paramBundle.getInt("mode");
            paramString = (aqrb)((QQAppInterface)localObject1).getBusinessHandler(71);
            paramString.a(new abmr(this, paramString, paramInt));
            if (i == 2) {}
            for (paramInt = 1;; paramInt = 0)
            {
              paramString.gs("cmshow_sdk", paramInt);
              break;
            }
            paramString = null;
            break label2304;
            paramString = null;
            break label740;
            paramString = null;
            break label2282;
          }
        }
        label2280:
        return null;
        label2282:
        if (paramString != null) {
          break;
        }
        return null;
        label2288:
        if (paramBundle != null) {
          break label519;
        }
        return null;
        label2294:
        return null;
        label2296:
        if (paramBundle != null) {
          break label630;
        }
        return null;
        label2302:
        return null;
        label2304:
        if (paramString != null) {
          break label844;
        }
        return null;
      }
      i += 1;
    }
  }
  
  public int zE()
  {
    if (this.a != null) {
      return this.a.zE();
    }
    QLog.w("cmgame_process.CmGameServerQIPCModule", 1, "no running game.");
    return -1;
  }
  
  static class a
  {
    private static abmm a = new abmm("cm_game_module");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmm
 * JD-Core Version:    0.7.0.1
 */