import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.a;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.b;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.c;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.10;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.4;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.5;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.7;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.8;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.9;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

public class aboc
  implements ApolloCmdChannel.a
{
  public static int cqp = 1;
  public static int cqq = 2;
  public static int cqr = 3;
  private Pattern V;
  private abxy jdField_a_of_type_Abxy;
  private abyb jdField_a_of_type_Abyb;
  private WeakReference<Activity> aG;
  private int cqo = 1;
  private HashMap<String, ably> ir = new HashMap();
  private HashMap<String, Bitmap> is = new HashMap();
  private String mAccessToken;
  private int mGameId;
  
  public aboc(int paramInt, Activity paramActivity)
  {
    this.jdField_a_of_type_Abxy = new abxy(abmt.getAppInterface(), paramActivity);
    this.jdField_a_of_type_Abyb = new abyb(paramActivity, abmt.getAppInterface());
    this.mGameId = paramInt;
    this.aG = new WeakReference(paramActivity);
  }
  
  private void Cq(String paramString) {}
  
  private void Cr(String paramString)
  {
    ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.7(this, paramString));
  }
  
  private void Cs(String paramString)
  {
    ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.8(this, paramString));
  }
  
  private void Ct(String paramString)
  {
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent();
    localBundle.putInt("apollo.game.invite.from", 4);
    localBundle.putInt("forward_type", 34);
    localBundle.putString("forward.apollo.redpacket_info", paramString);
    localIntent.putExtras(localBundle);
    paramString = p();
    if (paramString != null) {
      ahgq.f(paramString, localIntent, 20180427);
    }
  }
  
  private void Cu(String paramString)
  {
    if (this.jdField_a_of_type_Abxy == null) {}
    for (;;)
    {
      return;
      String str = "";
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        str = new JSONObject(paramString).optString("wording");
        abos localabos = abmt.a(this.mGameId);
        if (localabos != null)
        {
          localabos.cqu = 0;
          ApolloPanel.b localb2 = localabos.a();
          ApolloPanel.b localb1;
          if ((localb2 != null) && (localb2.roomId != 0L))
          {
            localb1 = localb2;
            if (localb2.gameId != 0) {}
          }
          else
          {
            localb1 = this.jdField_a_of_type_Abxy.a(paramString);
          }
          if (localb1 != null)
          {
            this.jdField_a_of_type_Abxy.a(localb1);
            this.jdField_a_of_type_Abxy.CZ(str);
            ThreadManager.getUIHandler().post(new CmGameSubProcessHandler.9(this));
            paramString = localabos.c();
            if (paramString != null)
            {
              VipUtils.a(null, "cmshow", "Apollo", "clk_invite", 0, 0, new String[] { paramString.mGameName });
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[inviteFriends], errInfo->" + paramString.getMessage());
      }
    }
  }
  
  private void Cv(String paramString)
  {
    abos localabos;
    ApolloPanel.b localb;
    try
    {
      localabos = abmt.a(this.mGameId);
      if (localabos == null) {
        return;
      }
      localb = localabos.a();
      paramString = new JSONObject(paramString);
      i = paramString.optInt("retcode");
      if (i != 0)
      {
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onJoinRoom], retCode is 0, fail to joinroom, return. retCode:" + i);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
      return;
    }
    int i = paramString.optInt("gameId");
    localb.init();
    long l = paramString.optLong("roomId");
    int j = paramString.optInt("gameMode");
    localb.gameId = i;
    localb.roomId = l;
    localb.gameMode = j;
    localb.gameExtendJson = paramString.optString("extendInfo");
    paramString = localabos.c();
    if (paramString != null)
    {
      paramString.mRoomId = l;
      localb.gameName = paramString.mChineseName;
      localb.actionId = paramString.mActionId;
    }
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "save game msginfo.");
  }
  
  private void Cw(String paramString)
  {
    AppInterface localAppInterface = abmt.getAppInterface();
    if (localAppInterface != null) {
      abxt.c(localAppInterface, paramString);
    }
  }
  
  private void M(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleReportEvent] reqData=", paramString });
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject(paramString);
        if ((!localJSONObject.has("mid")) || (!localJSONObject.has("value"))) {
          continue;
        }
        i = localJSONObject.optInt("mid");
        int j = localJSONObject.optInt("value");
        int k = localJSONObject.optInt("failCode", 0);
        paramString = localJSONObject.optJSONObject("extInfo");
        abmt.a(abmt.getAppInterface(), i, j, this.mGameId, k, paramString);
        i = 0;
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] e=", paramString);
        int i = -1;
        continue;
      }
      paramString = abmt.a();
      if (paramString != null) {
        paramString.callbackFromRequest(paramLong, i, "cs.report_event.local", "{}");
      }
      return;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, new Object[] { "[handleReportEvent] reqData invalid, reqData=", paramString });
      i = -1;
      continue;
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[handleReportEvent] reqData null");
      i = -1;
    }
  }
  
  private void N(long paramLong, String paramString)
  {
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[checkFileCorrectness], launcher is null, mGameId:" + this.mGameId);
    }
    do
    {
      return;
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    ((abpm)localObject).ab(paramLong, paramString);
  }
  
  private void O(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "createGameShortCut reqData:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManagerV2.excute(new CmGameSubProcessHandler.1(this, paramString, paramLong), 16, null, false);
    }
  }
  
  private void P(long paramLong, String paramString)
  {
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[handleLoadSuppack], launcher is null, mGameId:" + this.mGameId);
    }
    do
    {
      return;
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    ((abpm)localObject).aa(paramLong, paramString);
  }
  
  private void Q(long paramLong, String paramString)
  {
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.mGameId);
    }
    CmGameInitParams localCmGameInitParams;
    do
    {
      do
      {
        return;
        localCmGameInitParams = ((abos)localObject).c();
      } while (localCmGameInitParams == null);
      localObject = ((abos)localObject).a(localCmGameInitParams.appId, ((abos)localObject).q());
    } while (localObject == null);
    if (localCmGameInitParams.accessTokenRet != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "login first, cmd:", paramString });
      }
      ((tzg)localObject).a("login", null, new abog(this, paramString, paramLong, (tzg)localObject, localCmGameInitParams));
      return;
    }
    a(paramLong, paramString, (tzg)localObject);
  }
  
  private void T(long paramLong, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[hanldeGetRedPacketResult] luncher is null");
    }
    do
    {
      return;
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    for (;;)
    {
      int i;
      try
      {
        i = new JSONObject(paramString).optInt("score");
        ((abos.a)localObject).cqx = i;
        if ((((abos.a)localObject).cqv <= 0) || (((abos.a)localObject).cqx < ((abos.a)localObject).cqv)) {
          break label345;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[hanldeGetRedPacketResult] score:" + ((abos.a)localObject).cqx + "info.grabState:" + ((abos.a)localObject).cqw);
        }
        if (((abos.a)localObject).cqw == 3)
        {
          a(paramLong, 0, (abos.a)localObject);
          if (!"0".equals(((abos.a)localObject).state)) {
            break label429;
          }
          aagd.a(((abos.a)localObject).listId, ((abos.a)localObject).uin, ((abos.a)localObject).cqx + "", Integer.parseInt(((abos.a)localObject).aNy), bool1, false, this.mGameId);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((abos.a)localObject).cqw == 0)
      {
        if ((this.aG != null) && (this.aG.get() != null)) {
          aagd.a(abmt.getAppInterface(), ((abos.a)localObject).bhj + "", this.mGameId + "", i + "", new CmGameSubProcessHandler.4(this, null, paramLong));
        }
        ((abos.a)localObject).cqw = 1;
        return;
      }
      ((abos.a)localObject).bEw = true;
      return;
      label345:
      a(paramLong, 0, (abos.a)localObject);
      if ("0".equals(((abos.a)localObject).state)) {}
      for (bool1 = bool2;; bool1 = false)
      {
        aagd.a(((abos.a)localObject).listId, ((abos.a)localObject).uin, ((abos.a)localObject).cqx + "", Integer.parseInt(((abos.a)localObject).aNy), bool1, false, this.mGameId);
        return;
      }
      label429:
      bool1 = false;
    }
  }
  
  private void U(long paramLong, String paramString)
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = new JSONObject(paramString).optInt("score");
        paramString = localabos.a();
        if (paramString != null)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "gameScore:" + i + ",target:" + paramString.cqv);
          if ((paramString.cqv > 0) && (i >= paramString.cqv) && (paramString.cqw == 0))
          {
            aagd.a(abmt.getAppInterface(), paramString.bhj + "", this.mGameId + "", i + "", new CmGameSubProcessHandler.5(this, null, paramLong));
            paramString.cqw = 1;
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void X(long paramLong, String paramString)
  {
    Object localObject = abmt.b(paramLong);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = abmt.a((int)paramLong);
    }
    if (paramString != null)
    {
      localObject = paramString.c();
      if (localObject != null)
      {
        paramString = paramString.a(((CmGameInitParams)localObject).appId, paramString.q());
        if (paramString == null) {
          break label139;
        }
        paramString.a("login", null, new abof(this, (CmGameInitParams)localObject, paramLong));
      }
    }
    try
    {
      paramString = abmt.a();
      if (paramString != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("type", "complete");
        paramString.callbackFromRequest(paramLong, 0, "cs.xy_login.local", ((JSONObject)localObject).toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
      return;
    }
    label139:
    QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "fail to create DoraemonAPIManager.");
  }
  
  private void Y(long paramLong, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optJSONArray("pattern");
      int j = ((JSONObject)localObject).getInt("repeate");
      localObject = new long[paramString.length()];
      int i = 0;
      while (i < paramString.length())
      {
        localObject[i] = paramString.getLong(i);
        i += 1;
      }
      ApolloRender.vibrate(this.mGameId, paramLong, (long[])localObject, j);
      return;
    }
    catch (Exception paramString)
    {
      abmt.a().callbackFromRequest(paramLong, 6, "cs.xy_device_vibrate.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void Z(long paramLong, String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("interval");
      ApolloRender.startGyroSensor(this.mGameId, paramLong, i);
      return;
    }
    catch (Exception paramString)
    {
      abmt.a().callbackFromRequest(paramLong, 4, "cs.xy_device_gyro_sensor_start.local", "{}");
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private void a(long paramLong, int paramInt, abos.a parama)
  {
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if (localApolloCmdChannel != null)
    {
      localApolloCmdChannel.callbackFromRequest(paramLong, paramInt, "cs.get_redPacket_result.local", parama.getResult());
      parama.cqw = 0;
      parama.bEw = false;
      return;
    }
    QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[notifyRedPacketResult] cmdChannel is null");
  }
  
  private void a(long paramLong, String paramString, tzg paramtzg)
  {
    if (paramtzg == null) {
      return;
    }
    String str = "";
    if ("cs.get_app_friends.local".equals(paramString)) {
      str = "getAppFriends";
    }
    while (TextUtils.isEmpty(str))
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "invalid cmd:" + paramString);
      return;
      if ("cs.get_user_info.local".equals(paramString)) {
        str = "getUserInfo";
      } else if ("cs.get_location.local".equals(paramString)) {
        str = "getLocation";
      } else if ("cs.get_city.local".equals(paramString)) {
        str = "getCity";
      }
    }
    paramtzg.a(str, null, new aboh(this, paramString, paramLong));
  }
  
  private boolean c(String paramString1, String paramString2, long paramLong)
  {
    if ((!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!abjn.jq(paramString1)) && (jr(paramString1))) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "ssoCmdRule, [game],cmd:" + paramString1);
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString2);
        ((JSONObject)localObject2).put("from", "cmshow_game_" + this.mGameId);
        if ("apollo_router_game.apollo_user_rankinglist_linkcmd_custom_ranking".equals(paramString1))
        {
          paramString2 = abmt.a(this.mGameId);
          if ((paramString2 == null) || (paramString2.a() == null) || (TextUtils.isEmpty(paramString2.a().sessionUin))) {
            continue;
          }
          if (((JSONObject)localObject2).optInt("rankType", 0) != 0)
          {
            ((JSONObject)localObject2).put("rankType", ApolloUtil.gm(paramString2.a().sessionType));
            ((JSONObject)localObject2).put("sessionId", Integer.parseInt(paramString2.a().sessionUin));
            paramString2 = abmt.getAppInterface();
            if (paramString2 != null)
            {
              localObject1 = (TicketManager)paramString2.getManager(2);
              if (localObject1 != null)
              {
                localObject1 = ((TicketManager)localObject1).getSkey(paramString2.getCurrentAccountUin());
                paramString2 = (String)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramString2 = "";
                }
                ((JSONObject)localObject2).put("skey", paramString2);
              }
            }
          }
        }
        paramString2 = null;
        Object localObject1 = ((JSONObject)localObject2).toString();
        if ("apollo_router_game.game_ad_linkcmd_get_ad".equals(paramString1))
        {
          paramString2 = q((String)localObject1);
          bool = true;
          localObject2 = abmt.a();
          if (localObject2 == null) {
            break;
          }
          ((abpu)localObject2).a(paramString1, (String)localObject1, paramLong, 4, bool, paramString2);
          break;
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "[isSSoRequest] lancher or sessionUin is null");
          continue;
          return false;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "errInfo->", paramString1);
      }
      boolean bool = false;
    }
    return true;
  }
  
  private void cDr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "[onFirstFrameDrawn]");
    }
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        Activity localActivity = ((abos)localObject).q();
        if ((localActivity instanceof ApolloGameActivity)) {
          ((ApolloGameActivity)localActivity).cER();
        }
        localObject = ((abos)localObject).a();
      } while (localObject == null);
      l2 = ((CmGameStartChecker.StartCheckParam)localObject).startT;
    } while (l2 <= 0L);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - l2;
    l1 -= ((CmGameStartChecker.StartCheckParam)localObject).startCallEngine;
    QLog.i("cmgame_process.CmGameSubProcessHandler", 1, "startApolloGame initGameCost: " + l1 + ", totalCost:" + l2);
    if (l2 > 20000L)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "sth must be wrong because it's too long.");
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "start_game_time_cost", 0, 0, new String[] { String.valueOf(this.mGameId), String.valueOf(l2), l1 + "" });
    ((CmGameStartChecker.StartCheckParam)localObject).startT = -1L;
  }
  
  private void cDs()
  {
    Activity localActivity = p();
    if (localActivity != null) {
      abmt.a(this.mGameId, localActivity);
    }
  }
  
  private void cDt()
  {
    Activity localActivity = p();
    if (localActivity != null)
    {
      localActivity.finish();
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).cEP();
      }
    }
  }
  
  private void cDu()
  {
    try
    {
      ApolloRender.cancelVibrate(this.mGameId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void gX(long paramLong)
  {
    try
    {
      ApolloRender.stopGyroSensor();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
  
  private void j(String paramString, long paramLong, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[nofityApiRequestFailure], cmd:", paramString, ",code:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt);
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null) {
        localApolloCmdChannel.callbackFromRequest(paramLong, paramInt, paramString, localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  private boolean jr(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (this.V == null)
        {
          Object localObject = abmt.a();
          if (localObject != null)
          {
            localObject = ((aboz)localObject).df(this.mGameId);
            if (QLog.isColorLevel()) {
              QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "isValidSsoCmd cmd:" + paramString + ", rule: " + (String)localObject);
            }
            this.V = Pattern.compile((String)localObject);
          }
        }
      } while (this.V == null);
      bool2 = this.V.matcher(paramString).matches();
      bool1 = bool2;
    } while (bool2);
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "ssoCmdRule,fail to match sso cmd, cmd:" + paramString + ", gameId: " + this.mGameId);
    return bool2;
  }
  
  private void o(long paramLong, String paramString1, String paramString2)
  {
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[showBannerAds], launcher is null, mGameId:" + this.mGameId);
    }
    do
    {
      return;
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    ((abmw)localObject).m(paramLong, paramString1, paramString2);
  }
  
  private byte[] q(String paramString)
  {
    Object localObject1 = p();
    if (localObject1 == null) {
      return null;
    }
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
      Object localObject2 = new qq_ad_get.QQAdGet.UserInfo();
      ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(l);
      localQQAdGet.user_info.set((MessageMicro)localObject2);
      paramString = new JSONObject(paramString);
      localObject2 = new ArrayList();
      qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
      localPositionInfo.pos_id.set(paramString.optString("posid"));
      localPositionInfo.ad_count.set(paramString.optInt("count", 1));
      ((List)localObject2).add(localPositionInfo);
      localQQAdGet.position_info.set((List)localObject2);
      localObject1 = tln.a((Context)localObject1);
      localQQAdGet.device_info.set((MessageMicro)localObject1);
      localObject1 = new qq_ad_get.QQAdGet.ContextInfo();
      ((qq_ad_get.QQAdGet.ContextInfo)localObject1).article_id.set(paramString.optInt("game_id"));
      localQQAdGet.context_info.set((MessageMicro)localObject1);
      paramString = localQQAdGet.toByteArray();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "getAdPacket error:", paramString);
    }
    return null;
  }
  
  public void Cm(String paramString)
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos == null)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[playADsVideo], launcher is null.");
      return;
    }
    localabos.Cm(paramString);
  }
  
  public void Cn(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      paramString = abmt.a(this.mGameId);
      if (paramString != null) {
        paramString.HD(i);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void Co(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("taskId");
      abos localabos = abmt.a(this.mGameId);
      if (localabos != null) {
        localabos.bP(i, paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void Cp(String paramString)
  {
    Activity localActivity = p();
    if ((TextUtils.isEmpty(paramString)) || (localActivity == null)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getString("puin");
      Intent localIntent = new Intent(localActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("report_src_param_type", "");
      localIntent.putExtra("report_src_param_name", "");
      localIntent.setFlags(67108864);
      localActivity.startActivityForResult(localIntent, 9999);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "ENTER_PUBACCOUNT_CARD error:", paramString);
    }
  }
  
  public void R(long paramLong, String paramString)
  {
    paramString = abqk.a(paramString);
    abos localabos = abmt.a(this.mGameId);
    if ((paramString == null) || (localabos == null))
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[playADsVideo], adInfo or launcher is null.");
      return;
    }
    paramString.jsState = paramLong;
    localabos.a(paramString);
  }
  
  public void S(long paramLong, String paramString)
  {
    int i = this.cqo;
    if (abxt.b(p(), paramString, this.mGameId, i)) {}
    try
    {
      paramString = new JSONObject();
      paramString.put("taskId", i);
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(paramLong, 0, "cs.openWebViewWithoutUrl.local", paramString.toString());
        this.cqo += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void V(long paramLong, String paramString)
  {
    int i = 0;
    abpu localabpu = abmt.a();
    if (localabpu != null)
    {
      localObject1 = abmt.a(this.mGameId);
      if (localObject1 == null) {
        QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.mGameId);
      }
    }
    else
    {
      return;
    }
    Object localObject1 = ((abos)localObject1).c();
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString).optJSONArray("openIdList");
        paramString = new JSONArray();
        if (i < ((JSONArray)localObject2).length())
        {
          String str = ((JSONArray)localObject2).getString(i);
          if ((this.ir != null) && (!this.ir.containsKey(str))) {
            paramString.put(str);
          }
        }
        else
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("gameId", this.mGameId);
          ((JSONObject)localObject2).put("selfUid", ((CmGameInitParams)localObject1).openId);
          ((JSONObject)localObject2).put("selfKey", this.mAccessToken);
          ((JSONObject)localObject2).put("uidList", paramString);
          localabpu.a("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject2).toString(), paramLong, cqr, false, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        return;
      }
      i += 1;
    }
  }
  
  public void W(long paramLong, String paramString)
  {
    Object localObject2 = abmt.b(paramLong);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = abmt.a((int)paramLong);
    }
    if (localObject1 != null)
    {
      localObject2 = ((abos)localObject1).a();
      if (localObject2 != null) {
        try
        {
          CmGameInitParams localCmGameInitParams = ((abos)localObject1).c();
          if (localCmGameInitParams != null)
          {
            if (!localCmGameInitParams.isWhiteUsr) {
              return;
            }
            paramString = new JSONObject(paramString);
            paramString.put("action", "show");
            paramString.put("title", "JS Error");
            int i = ((abos)localObject1).getGameId();
            localObject1 = "[game:" + i + "]" + paramString.optString("data");
            paramString.put("content", localObject1);
            ((abqe)localObject2).A("Dialog", "alert", "", paramString.toString());
            paramString = abmt.a();
            if (paramString != null)
            {
              paramString.b("JS_Error", 3, new Object[] { localObject1 });
              return;
            }
          }
        }
        catch (Throwable paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
        }
      }
    }
  }
  
  public void Y(String paramString, long paramLong)
  {
    Object localObject = abmt.a(this.mGameId);
    if (localObject == null) {
      return;
    }
    localObject = ((abos)localObject).c();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("now");
      }
      catch (Throwable paramString)
      {
        try
        {
          j = paramString.optInt("delta");
          paramString = ApolloGameInterfaceProxy.a(i, j, (CmGameInitParams)localObject);
          localObject = abmt.a();
          if (localObject == null) {
            break;
          }
          ((ApolloCmdChannel)localObject).callbackFromRequest(paramLong, 0, "cs.fetch_cloud_signature.local", paramString);
          return;
        }
        catch (Throwable paramString)
        {
          int i;
          int j;
          break label85;
        }
        paramString = paramString;
        i = 0;
      }
      label85:
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "get cloud errInfo->", paramString);
      j = 0;
    }
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "[handleCmd], cmd:", paramString1 });
    }
    abos localabos = abmt.a(this.mGameId);
    if ((localabos != null) && (!localabos.YN())) {
      if (paramLong == localabos.getGameId()) {
        break label104;
      }
    }
    label104:
    do
    {
      do
      {
        do
        {
          return null;
        } while ((localabos == null) || (localabos.b() == null));
        if (localabos.b().getLuaState() == paramLong) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "abandon it, not the same jsState.");
      return null;
      if (c(paramString1, paramString2, paramLong)) {
        return new abjp();
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        Cv(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        cDs();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        cDt();
        return null;
      }
      if ("cs.report_data_2_compass.local".equals(paramString1))
      {
        Cw(paramString2);
        return null;
      }
      if ("cs.invite_friends.local".equals(paramString1))
      {
        Cu(paramString2);
        return null;
      }
      if ("cs.send_b2c_redpacket.local".equals(paramString1))
      {
        Ct(paramString2);
        return null;
      }
      if ("cs.share_game_result.local".equals(paramString1))
      {
        Cs(paramString2);
        return null;
      }
      if ("cs.qta_notify_test_result.local".equals(paramString1))
      {
        Cq(paramString2);
        return null;
      }
      if ("cs.share_pic.local".equals(paramString1))
      {
        Cr(paramString2);
        return null;
      }
      if ("cs.first_frame_drawn.local".equals(paramString1))
      {
        cDr();
        return null;
      }
      if ("cs.apolloGameWebMessage.local".equals(paramString1))
      {
        abxt.CY(paramString2);
        return null;
      }
      if ("cs.openWebViewWithoutUrl.local".equals(paramString1))
      {
        S(paramLong, paramString2);
        return null;
      }
      if ("cs.share_game_in_ark.local".equals(paramString1))
      {
        abxt.b(this.mGameId, paramString2, p());
        return null;
      }
      if ("cs.enter_pubAccount_card.local".equals(paramString1))
      {
        Cp(paramString2);
        return null;
      }
      if ("cs.game_update_score.local".equals(paramString1))
      {
        U(paramLong, paramString2);
        return null;
      }
      if ("cs.get_redPacket_result.local".equals(paramString1))
      {
        T(paramLong, paramString2);
        return null;
      }
      if ("cs.fetch_cloud_signature.local".equals(paramString1))
      {
        Y(paramString2, paramLong);
        return null;
      }
      if ("cs.closeWebview.local".equals(paramString1))
      {
        Cn(paramString2);
        return null;
      }
      if ("cs.apolloGameTargetWebMessage.local".equals(paramString1))
      {
        Co(paramString2);
        return null;
      }
      if ("cs.game_ad_video_jump.local".equals(paramString1))
      {
        R(paramLong, paramString2);
        return null;
      }
      if ("cs.game_ad_video_close.local".equals(paramString1))
      {
        cDq();
        return null;
      }
      if (("cs.get_user_info.local".equals(paramString1)) || ("cs.get_app_friends.local".equals(paramString1)) || ("cs.get_location.local".equals(paramString1)) || ("cs.get_city.local".equals(paramString1)))
      {
        Q(paramLong, paramString1);
        return null;
      }
      if ("cs.create_xy_shortcut.local".equals(paramString1))
      {
        O(paramLong, paramString2);
        return null;
      }
      if ("cs.load_subpackage.local".equals(paramString1))
      {
        P(paramLong, paramString2);
        return null;
      }
      if ("cs.file_correctness_check.local".equals(paramString1))
      {
        N(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_ad_banner_jump.local".equals(paramString1))
      {
        Cm(paramString2);
        return null;
      }
      if ("cs.preload_userInfoList.local".equals(paramString1))
      {
        V(paramLong, paramString2);
        return null;
      }
      if (("cs.game_ad_banner_load.local".equals(paramString1)) || ("cs.game_ad_banner_show.local".equals(paramString1)) || ("cs.game_ad_banner_close.local".equals(paramString1)) || ("cs.game_ad_banner_resize.local".equals(paramString1)) || ("cs.game_ad_banner_hide.local".equals(paramString1)))
      {
        o(paramLong, paramString1, paramString2);
        return null;
      }
      if ("cs.xy_error_info.local".equals(paramString1))
      {
        W(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_login.local".equals(paramString1))
      {
        X(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_vibrate.local".equals(paramString1))
      {
        Y(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_vibrate_cancel.local".equals(paramString1))
      {
        cDu();
        return null;
      }
      if ("cs.xy_device_gyro_sensor_start.local".equals(paramString1))
      {
        Z(paramLong, paramString2);
        return null;
      }
      if ("cs.xy_device_gyro_sensor_stop.local".equals(paramString1))
      {
        gX(paramLong);
        return null;
      }
    } while (!"cs.report_event.local".equals(paramString1));
    M(paramLong, paramString2);
    return null;
  }
  
  public void a(long paramLong, String paramString, ApolloCmdChannel.b paramb)
  {
    if ((this.is != null) && (this.is.containsKey(paramString))) {
      paramb.f((Bitmap)this.is.get(paramString), 200);
    }
    for (;;)
    {
      return;
      if ((this.ir != null) && (this.ir.containsKey(paramString)))
      {
        ThreadManagerV2.excute(new CmGameSubProcessHandler.10(this, ((ably)this.ir.get(paramString)).aGE, paramb, paramString), 128, null, true);
        return;
      }
      paramb = abmt.a();
      if (paramb != null)
      {
        Object localObject1 = abmt.a(this.mGameId);
        if (localObject1 == null)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.mGameId);
          return;
        }
        Object localObject2 = ((abos)localObject1).c();
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", this.mGameId);
          ((JSONObject)localObject1).put("selfUid", ((CmGameInitParams)localObject2).openId);
          ((JSONObject)localObject1).put("selfKey", "abc");
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(paramString);
          ((JSONObject)localObject1).put("uidList", localObject2);
          paramb.e("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject1).toString(), paramLong, cqp);
          if (QLog.isColorLevel())
          {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "getOpenApiHead by sso");
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString, ApolloCmdChannel.c paramc)
  {
    if ((this.ir != null) && (this.ir.containsKey(paramString))) {
      paramc.BJ(((ably)this.ir.get(paramString)).mNickName);
    }
    for (;;)
    {
      return;
      paramc = abmt.a();
      if (paramc != null)
      {
        Object localObject1 = abmt.a(this.mGameId);
        if (localObject1 == null)
        {
          QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[getUserInfo], launcher is null, mGameId:" + this.mGameId);
          return;
        }
        Object localObject2 = ((abos)localObject1).c();
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("gameId", this.mGameId);
          ((JSONObject)localObject1).put("selfUid", ((CmGameInitParams)localObject2).openId);
          ((JSONObject)localObject1).put("selfKey", "abc");
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(paramString);
          ((JSONObject)localObject1).put("uidList", localObject2);
          paramc.e("ltgame_native_api.batch_get_user_info", ((JSONObject)localObject1).toString(), paramLong, cqq);
          if (QLog.isColorLevel())
          {
            QLog.d("cmgame_process.CmGameSubProcessHandler", 2, "getOpenApiNick by sso");
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSubProcessHandler", 2, "GET_OPENID_INFO send e=" + paramString.toString());
        }
      }
    }
  }
  
  public void cDq()
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos == null)
    {
      QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[closeADView], launcher is null.");
      return;
    }
    localabos.cDB();
  }
  
  public void destroyHandler()
  {
    this.ir.clear();
    Iterator localIterator = this.is.values().iterator();
    while (localIterator.hasNext()) {
      ((Bitmap)localIterator.next()).recycle();
    }
    this.is.clear();
  }
  
  public Activity p()
  {
    if (this.aG != null) {
      return (Activity)this.aG.get();
    }
    return null;
  }
  
  public boolean q(Activity paramActivity)
  {
    return false;
  }
  
  public void updateUserInfo(ably paramably)
  {
    if (this.ir != null) {
      this.ir.put(paramably.mOpenId, paramably);
    }
  }
  
  public int zz()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboc
 * JD-Core Version:    0.7.0.1
 */