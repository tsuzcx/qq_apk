import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.TreeSet;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class aboy
  implements abpr
{
  aboy.a jdField_a_of_type_Aboy$a = new aboy.a();
  private abqc jdField_a_of_type_Abqc;
  public ApolloPanel.b a;
  public boolean bEx;
  public Set<String> bF = new TreeSet();
  private auru e;
  public CmGameStartChecker.StartCheckParam f;
  public CmGameInitParams f;
  private WeakReference<BaseChatPie> fj;
  public WeakReference<Context> mContextRef;
  
  public aboy(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    BaseChatPie localBaseChatPie = c();
    if (localBaseChatPie != null)
    {
      String str = localBaseChatPie.a().aTl;
      this.bF.add(str);
      this.fj = new WeakReference(localBaseChatPie);
    }
    this.mContextRef = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b = new ApolloPanel.b();
    this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    paramActivity = new abqc(paramActivity, paramStartCheckParam);
    paramActivity.a(this);
    this.jdField_a_of_type_Abqc = paramActivity;
    this.e = new auru(Looper.getMainLooper(), this.jdField_a_of_type_Abqc);
    this.bEx = true;
  }
  
  public static void CB(String paramString)
  {
    aboy localaboy = c();
    if ((localaboy != null) && (localaboy.bF != null)) {
      localaboy.bF.add(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "onShare2Aio currentApolloGame:" + localaboy + ",aioUin:" + paramString);
    }
  }
  
  public static aboy a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = c();
    }
    aboy localaboy;
    do
    {
      return localObject;
      localaboy = c();
      if ((localaboy == null) || (localaboy.bF == null)) {
        break;
      }
      localObject = localaboy;
    } while (localaboy.bF.contains(paramString));
    return null;
  }
  
  public static aboy c()
  {
    return abmt.a();
  }
  
  private BaseChatPie c()
  {
    Object localObject = abmt.getAppInterface();
    if (localObject != null)
    {
      localObject = (abhh)((AppInterface)localObject).getManager(153);
      if (localObject != null)
      {
        localObject = ((abhh)localObject).g();
        if (localObject != null) {
          return (BaseChatPie)((WeakReference)localObject).get();
        }
      }
    }
    return null;
  }
  
  public static void cDR()
  {
    aboy localaboy = c();
    if ((localaboy != null) && (localaboy.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", 3, 0, new String[] { localaboy.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + "" });
    }
  }
  
  public void CC(String paramString)
  {
    Object localObject1;
    Object localObject2;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localObject1 = abmt.getAppInterface();
        if (!(localObject1 instanceof QQAppInterface)) {
          return;
        }
        localObject2 = new SessionInfo();
        localObject3 = c();
        if (localObject3 != null)
        {
          localObject2 = ((BaseChatPie)localObject3).sessionInfo;
          localQQAppInterface = (QQAppInterface)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameMainManager", 2, new Object[] { "[onJoinRoom],", paramString });
          }
          localJSONObject = new JSONObject(paramString);
          i = localJSONObject.optInt("retcode");
          if (i == 0) {
            break;
          }
          QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], retCode is 0, fail to joinroom, return. retCode:" + i);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], json error ", paramString);
        return;
      }
      ((SessionInfo)localObject2).cZ = this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.aioType;
      ((SessionInfo)localObject2).troopUin = this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin;
      QLog.w("cmgame_process.CmGameMainManager", 1, "basechatpie is null.");
    }
    int i = localJSONObject.optInt("gameId");
    Object localObject3 = localJSONObject.optString("uin");
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom], uin is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.init();
    if (!((String)localObject3).equals(localQQAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameMainManager", 2, "[onJoinRoom], uin:" + (String)localObject3 + "jionroom, show JionRoom Tips");
      }
      localObject1 = null;
      paramString = (String)localObject1;
      if (localQQAppInterface != null)
      {
        paramString = (String)localObject1;
        if (this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          if (this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionType != 1) {
            break label796;
          }
        }
      }
    }
    label787:
    label796:
    for (paramString = aqgv.o(localQQAppInterface, this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin, (String)localObject3);; paramString = null)
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject1 = ((acff)localQQAppInterface.getManager(51)).b((String)localObject3);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((Friends)localObject1).getFriendNick();; localObject1 = paramString)
      {
        paramString = (String)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = aqgv.c(localQQAppInterface, (String)localObject3, true);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameMainManager", 2, "handleMessage MSG_CODE_JION_ROOM, nickName:" + paramString);
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = localObject3;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = this.e.obtainMessage(26);
          paramString.obj = localObject1;
          paramString.sendToTarget();
        }
        long l = localJSONObject.optLong("roomId");
        if ((this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (0L != l)) {
          this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = l;
        }
        int j = localJSONObject.optInt("gameMode");
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "join_game", ApolloUtil.a((SessionInfo)localObject2, localQQAppInterface), 0, new String[] { "" + i, "", "", "" + l });
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.gameId = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.roomId = l;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.gameMode = j;
        localObject2 = (abxk)localQQAppInterface.getManager(155);
        localObject1 = ((abxk)localObject2).a(i);
        paramString = acfp.m(2131704119);
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ApolloGameData)localObject1).name)))
        {
          localObject2 = ((abxk)localObject2).a(((ApolloGameData)localObject1).actionId);
          if (localObject2 == null) {
            break label787;
          }
          paramString = ((ApolloActionData)localObject2).actionName;
        }
        for (;;)
        {
          i = ((ApolloGameData)localObject1).actionId;
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.gameName = ((ApolloGameData)localObject1).name;
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.actionName = paramString;
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.actionId = i;
            paramString = localJSONObject.optString("extendInfo");
            localObject1 = new JSONObject();
            if (TextUtils.isEmpty(paramString)) {
              return;
            }
            ((JSONObject)localObject1).put("extendInfo", paramString);
            if (paramString.length() < 100) {
              break;
            }
            QLog.w("cmgame_process.CmGameMainManager", 1, "[onJoinRoom],extendInfo is too long, extendInfo:" + paramString);
            return;
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.gameName = acfp.m(2131704120);
            i = 0;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b.gameExtendJson = ((JSONObject)localObject1).toString();
          return;
        }
      }
    }
  }
  
  public void CD(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("resp");
      if (paramString != null)
      {
        this.bEx = true;
        paramString = paramString.optJSONObject("data");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("userInfo");
          if (paramString != null)
          {
            int i = paramString.optInt("remainPlays");
            if (this.fj == null) {
              return;
            }
            paramString = (BaseChatPie)this.fj.get();
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameMainManager", 2, "onStartGame, game coin count=" + i);
            }
            if (paramString != null) {
              ApolloGameUtil.c(paramString.app, i);
            }
            if ((paramString != null) && (paramString.a != null))
            {
              paramString.a.bYN();
              return;
            }
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameMainManager", 2, "onStartGame error " + paramString.toString());
    }
  }
  
  public void CE(String paramString)
  {
    if (this.fj == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        paramString = (BaseChatPie)this.fj.get();
      } while (((paramString != null) && (paramString.app != null) && (paramString.getUIHandler() == null)) || (paramString == null) || (paramString.sessionInfo == null));
      localQQAppInterface = paramString.getApp();
    } while (localQQAppInterface == null);
    ApolloGameUtil.L(localQQAppInterface, paramString.sessionInfo.aTl);
  }
  
  public void CF(String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = this.e.obtainMessage(28);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void CG(String paramString)
  {
    if (this.e == null) {
      return;
    }
    if ((this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId == 0L)) {
      this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId = ApolloUtil.d(paramString, "roomId");
    }
    Message localMessage = this.e.obtainMessage(23);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void CH(String paramString)
  {
    if (this.e == null) {
      return;
    }
    this.e.removeMessages(19);
    this.e.removeMessages(20);
    Message localMessage = this.e.obtainMessage(19);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    CC(paramString);
  }
  
  public void CI(String paramString)
  {
    this.jdField_a_of_type_Abqc.DY(true);
    CD(paramString);
    paramString = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
    if ((paramString != null) && (this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
    {
      AppInterface localAppInterface = abmt.getAppInterface();
      if (localAppInterface != null) {
        paramString.edit().putBoolean("is_ever_play_cmgame" + this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + localAppInterface.getCurrentAccountUin(), true).commit();
      }
    }
  }
  
  public void CJ(String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = this.e.obtainMessage(17);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean YQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameMainManager", 2, "showCurrentGameView");
    }
    if (this.e != null)
    {
      this.e.sendEmptyMessage(18);
      return true;
    }
    return false;
  }
  
  public QQAppInterface a()
  {
    AppInterface localAppInterface = abmt.getAppInterface();
    if (!(localAppInterface instanceof QQAppInterface)) {
      return null;
    }
    return (QQAppInterface)localAppInterface;
  }
  
  public void bM(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.bM(paramActivity);
    }
  }
  
  public void cDL()
  {
    if (this.fj == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.fj.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.getUIHandler() != null));
  }
  
  public void cDM()
  {
    if (this.e == null) {
      return;
    }
    this.e.obtainMessage(21).sendToTarget();
  }
  
  public void cDN()
  {
    if (this.e == null) {
      return;
    }
    this.e.obtainMessage(22).sendToTarget();
  }
  
  public void cDO()
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.cDO();
    }
  }
  
  public void cDP()
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.cDP();
    }
  }
  
  public void cDQ()
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.cEg();
    }
  }
  
  public void dh(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new JSONObject();
        localObject = ((JSONObject)localObject).getString("puin");
        AppInterface localAppInterface = abmt.getAppInterface();
        if (localAppInterface == null) {
          break;
        }
        if (((acja)localAppInterface.getManager(56)).f(Long.valueOf(Long.parseLong((String)localObject))))
        {
          i = 1;
          paramString.put("is_follow", i);
          CmGameCmdChannel.a((QQAppInterface)localAppInterface).f(0, "cs.check_pubAccount_state.local", paramString.toString(), paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameMainManager", 1, "CHECK_FOLLOW_STATE error:", paramString);
        return;
      }
      int i = 0;
    }
  }
  
  public void di(String paramString, int paramInt)
  {
    Object localObject2 = new JSONObject();
    Object localObject1 = a();
    if (localObject1 == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        try
        {
          int i = new JSONObject(paramString).getInt("gameId");
          paramString = ((abxk)((QQAppInterface)localObject1).getManager(155)).a(this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
          if ((i != this.jdField_f_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) || ((paramString != null) && (paramString.needOpenKey != 1)))
          {
            CmGameCmdChannel.a((QQAppInterface)localObject1).f(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameMainManager", 1, "ON_GET_OPEN_KEY error:", paramString);
          return;
        }
        if ((paramString == null) || (System.currentTimeMillis() - paramString.lastRequestOpenKey <= 3600000L)) {
          break;
        }
        localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        localObject1 = (WtloginManager)((QQAppInterface)localObject1).getManager(1);
        this.jdField_a_of_type_Aboy$a.gameId = paramString.gameId;
        this.jdField_a_of_type_Aboy$a.callbackId = paramInt;
        ((WtloginManager)localObject1).GetOpenKeyWithoutPasswd((String)localObject2, 16L, paramString.appId, this.jdField_a_of_type_Aboy$a);
        paramString.lastRequestOpenKey = System.currentTimeMillis();
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameMainManager", 2, "do get open key.");
      return;
    } while (paramString == null);
    ((JSONObject)localObject2).put("appId", paramString.appId);
    ((JSONObject)localObject2).put("gameId", paramString.gameId);
    ((JSONObject)localObject2).put("openKey", paramString.openKey);
    CmGameCmdChannel.a((QQAppInterface)localObject1).f(0, "cs.on_get_open_key.local", ((JSONObject)localObject2).toString(), paramInt);
  }
  
  public void onActivityResume()
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.onActivityResume();
    }
  }
  
  public void onActivityStop()
  {
    if (this.jdField_a_of_type_Abqc != null) {
      this.jdField_a_of_type_Abqc.onActivityStop();
    }
  }
  
  public void onDestroy()
  {
    this.bEx = false;
    this.fj = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b = null;
    this.jdField_f_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    if (this.bF != null) {
      this.bF.clear();
    }
    this.bF = null;
    if (this.jdField_a_of_type_Abqc != null)
    {
      this.jdField_a_of_type_Abqc.cEg();
      this.jdField_a_of_type_Abqc.cEe();
    }
  }
  
  public boolean r(Activity paramActivity)
  {
    if ((this.mContextRef != null) && (this.mContextRef.get() != null) && (paramActivity != null) && (paramActivity.getClass() != ((Context)this.mContextRef.get()).getClass()))
    {
      Intent localIntent = new Intent(paramActivity, ((Context)this.mContextRef.get()).getClass());
      localIntent.addFlags(131072);
      paramActivity.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameMainManager", 2, new Object[] { "[resumeGameContext] from ", paramActivity, this.mContextRef.get() });
      }
      return true;
    }
    return false;
  }
  
  class a
    extends WtloginObserver
  {
    public int callbackId;
    public int gameId;
    
    a() {}
    
    public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
    {
      if (paramInt2 == 0)
      {
        paramString = util.buf_to_string(paramArrayOfByte2);
        if (QLog.isColorLevel()) {
          QLog.i("cmgame_process.CmGameMainManager", 2, "OnGetOpenKeyWithoutPasswd token:" + paramString);
        }
        paramArrayOfByte1 = aboy.this.a();
        if (paramArrayOfByte1 != null) {
          break label57;
        }
      }
      for (;;)
      {
        return;
        try
        {
          label57:
          paramArrayOfByte2 = new JSONObject();
          paramArrayOfByte2.put("appId", paramLong2);
          paramArrayOfByte2.put("gameId", this.gameId);
          paramArrayOfByte2.put("openKey", paramString);
          CmGameCmdChannel.a(paramArrayOfByte1).f(0, "cs.on_get_open_key.local", paramArrayOfByte2.toString(), this.callbackId);
          paramArrayOfByte1 = ((abxk)paramArrayOfByte1.getManager(155)).a(aboy.this.f.gameId);
          if (paramArrayOfByte1 != null)
          {
            paramArrayOfByte1.openKey = paramString;
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameMainManager", 1, "OpenKeyObserver error:", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboy
 * JD-Core Version:    0.7.0.1
 */