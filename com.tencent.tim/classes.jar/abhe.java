import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloGameManager.1;
import com.tencent.mobileqq.apollo.ApolloGameManager.2;
import com.tencent.mobileqq.apollo.ApolloGameManager.3;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollo.STGameLogin.STGameConfInfo;
import com.tencent.pb.apollo.STGameLogin.STGameList;
import com.tencent.pb.apollo.STGameLogin.STGameLoginRsp;
import com.tencent.pb.apollo.STGameLogin.STGameTagInfo;
import com.tencent.pb.apollo.STGameLogin.STGetGameConfRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_game_status.STCMGameMessage.STGameCancel;
import tencent.im.apollo_game_status.STCMGameMessage.STGameInvalid;
import tencent.im.apollo_game_status.STCMGameMessage.STGameJoinRoom;
import tencent.im.apollo_game_status.STCMGameMessage.STGameOver;
import tencent.im.apollo_game_status.STCMGameMessage.STGameQuitRoom;
import tencent.im.apollo_game_status.STCMGameMessage.STGameStart;
import tencent.im.apollo_game_status.STCMGameMessage.STMsgComm;
import tencent.im.apollo_game_status.STCMGameMessage.STScoreInfo;

public class abhe
  implements Handler.Callback, Manager
{
  public static String bfI = "REQ_GAME_KEY";
  public static String bfJ = "REQ_GAME_VAL";
  public static int coC = 1;
  public static int coD = 2;
  public static int coE = 3;
  private long No = 600L;
  private abhe.a jdField_a_of_type_Abhe$a;
  private abkf jdField_a_of_type_Abkf = new abkf(-1, -1);
  public abvi a;
  private WeakReference<XListView> aw;
  private abhc b;
  public AtomicBoolean cg;
  public int coA = -1;
  private int coB = cb("game_json_last_update_in_sec");
  private ConcurrentHashMap<Integer, String> dq = new ConcurrentHashMap();
  private WeakReference<wki> fb;
  public WeakReference<abvn> fc;
  private Runnable fs = new ApolloGameManager.1(this);
  private Map<Integer, MessageForApollo> iQ = new HashMap();
  private auru k;
  private QQAppInterface mApp;
  private long mCreateTime = NetConnInfoCenter.getServerTimeMillis();
  
  public abhe(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "mCreateTime:" + this.mCreateTime, ",gameJsonUpdateT:", Integer.valueOf(this.coB) });
    }
    this.mApp = paramQQAppInterface;
    this.k = new auru(ThreadManager.getSubThreadLooper(), this);
    this.cg = new AtomicBoolean(false);
    this.jdField_a_of_type_Abvi = new abvi();
    new IntentFilter().addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    this.b = new abhc(paramQQAppInterface);
    this.jdField_a_of_type_Abhe$a = new abhe.a(null);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Abhe$a);
  }
  
  public static boolean XY()
  {
    SharedPreferences localSharedPreferences = n();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(bfJ, -1) == coD);
  }
  
  public static boolean XZ()
  {
    SharedPreferences localSharedPreferences = n();
    return (localSharedPreferences != null) && (localSharedPreferences.getInt(bfJ, -1) == coC);
  }
  
  public static void cBB()
  {
    SharedPreferences localSharedPreferences = n();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(bfJ, -1).apply();
    }
  }
  
  public static void cBC()
  {
    n().edit().putInt(bfJ, coD).apply();
  }
  
  public static void cBD()
  {
    n().edit().putInt(bfJ, coC).apply();
  }
  
  public static void cZ(String paramString, int paramInt)
  {
    Object localObject = n();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public static int cb(String paramString)
  {
    int i = -1;
    SharedPreferences localSharedPreferences = n();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, -1);
    }
    return i;
  }
  
  public static SharedPreferences n()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences(bfI + str1, 0);
  }
  
  private void v(List<MessageForApollo> paramList, String paramString)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray;
      MessageForApollo localMessageForApollo;
      for (;;)
      {
        Object localObject;
        JSONObject localJSONObject;
        try
        {
          if (paramList.size() == 0) {
            return;
          }
          localJSONArray = new JSONArray();
          localObject = new JSONObject();
          localMessageForApollo = (MessageForApollo)paramList.get(0);
          ((JSONObject)localObject).put("aioType", localMessageForApollo.istroop);
          ((JSONObject)localObject).put("friendUin", localMessageForApollo.frienduin);
          ((JSONObject)localObject).put("from", paramString);
          ((JSONObject)localObject).put("roomId", localMessageForApollo.roomId);
          ((JSONObject)localObject).put("gameId", localMessageForApollo.gameId);
          ((JSONObject)localObject).put("gameMode", localMessageForApollo.mGameMode);
          ((JSONObject)localObject).put("extendInfo", localMessageForApollo.gameExtendJson);
          paramString = ((JSONObject)localObject).toString();
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (MessageForApollo)paramList.next();
          localJSONObject = new JSONObject();
          localJSONObject.put("gameId", ((MessageForApollo)localObject).gameId);
          localJSONObject.put("roomId", Long.toString(((MessageForApollo)localObject).roomId));
          if (0L == ((MessageForApollo)localObject).roomId) {
            QLog.w("ApolloGameManager", 1, "roomId is 0. gameId:" + localMessageForApollo.gameId + ",gameMode:" + localMessageForApollo.mGameMode);
          }
          localJSONObject.put("gameMode", ((MessageForApollo)localObject).mGameMode);
          localJSONArray.put(localJSONObject);
          if (((MessageForApollo)localObject).istroop != 0) {
            break label395;
          }
          if (((MessageForApollo)localObject).isSend())
          {
            l = Long.parseLong(this.mApp.getCurrentAccountUin());
            localJSONObject.put("sessionId", l);
            if (!((MessageForApollo)localObject).isSend()) {
              continue;
            }
            localJSONObject.put("toUin", Long.parseLong(((MessageForApollo)localObject).frienduin));
            continue;
          }
          long l = Long.parseLong(((MessageForApollo)localObject).frienduin);
        }
        catch (Exception paramList)
        {
          QLog.e("ApolloGameManager", 1, "[MSG_CODE_DO_BULK_REQ], errInfo->" + paramList.getMessage());
          return;
        }
        continue;
        label395:
        localJSONObject.put("sessionId", Long.parseLong(((MessageForApollo)localObject).frienduin));
      }
      paramList = new JSONObject();
      paramList.put("roomList", localJSONArray);
      paramList.put("aioType", ApolloGameUtil.a(this.mApp, localMessageForApollo.istroop, localMessageForApollo.frienduin));
      if (this.mApp != null) {
        ((aqrb)this.mApp.getBusinessHandler(71)).bm("apollo_aio_game.get_game_room_state", paramList.toString(), paramString);
      }
    }
  }
  
  public abhc a()
  {
    return this.b;
  }
  
  public abkf a()
  {
    return this.jdField_a_of_type_Abkf;
  }
  
  public MessageForApollo a(int paramInt)
  {
    return (MessageForApollo)this.iQ.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, apollo_game_status.STCMGameMessage paramSTCMGameMessage)
  {
    if (this.mApp == null) {
      return;
    }
    if (paramSTCMGameMessage == null) {
      try
      {
        QLog.e("ApolloGameManager", 1, "[onGetGameStatus], errInfo->null == gameStatus");
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameManager", 1, "[onGetGameStatus],errInfo->" + paramString.getMessage());
        return;
      }
    }
    MessageForApollo localMessageForApollo = new MessageForApollo();
    Object localObject1 = (apollo_game_status.STCMGameMessage.STMsgComm)paramSTCMGameMessage.msg_comm.get();
    localMessageForApollo.gameStatusStamp = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint64_time_stamp.get();
    localMessageForApollo.roomId = Long.parseLong(((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).str_room_id.get());
    localMessageForApollo.gameId = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_game_id.get();
    localMessageForApollo.mGameMode = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_play_model.get();
    localMessageForApollo.commInfo = new String(((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).str_game_comm_info.get().toByteArray());
    Object localObject2 = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).rpt_uint32_uin_list.get();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        localMessageForApollo.playerList.add(Long.valueOf(aqft.K(localInteger.intValue())));
      }
    }
    localMessageForApollo.roomVol = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject1).uint32_room_vol.get();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "[onGetGameStatus], mGameMode:", Integer.valueOf(localMessageForApollo.mGameMode), ",roomId:", Long.valueOf(localMessageForApollo.roomId), ",gameId:", Integer.valueOf(localMessageForApollo.gameId), ",aioType:", Integer.valueOf(paramInt2), ",friendUin:", paramString, ",from:", Integer.valueOf(paramInt1), ", gameStatusStamp:", Long.valueOf(localMessageForApollo.gameStatusStamp), "roomVol:", Integer.valueOf(localMessageForApollo.roomVol), ",playerSize:", Integer.valueOf(localMessageForApollo.playerList.size()) });
    }
    int i = paramSTCMGameMessage.uint32_msg_cmd.get();
    localMessageForApollo.gameStatus = i;
    switch (i)
    {
    case 1: 
      label476:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "apolloMsg.gameArkInfo:", localMessageForApollo.gameArkInfo });
      }
      localMessageForApollo.frienduin = paramString;
      localMessageForApollo.istroop = paramInt2;
      if (this.k != null) {
        this.k.obtainMessage(5891, localMessageForApollo).sendToTarget();
      }
      break;
    }
    label543:
    while ((!TextUtils.isEmpty(paramSTCMGameMessage)) && (this.mApp != null))
    {
      paramInt2 = ApolloUtil.gi(paramInt2);
      localObject1 = this.mApp.a(false);
      paramInt1 = paramInt2;
      if (localObject1 != null)
      {
        paramInt1 = paramInt2;
        if (((HotChatManager)localObject1).kj(paramString)) {
          paramInt1 = 3;
        }
      }
      VipUtils.a(this.mApp, "cmshow", "Apollo", paramSTCMGameMessage, paramInt1, 0, new String[] { Integer.toString(localMessageForApollo.gameId), Integer.toString(localMessageForApollo.gameStatus), "", Long.toString(localMessageForApollo.roomId) });
      return;
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameJoinRoom)paramSTCMGameMessage.msg_0x01.get()).str_game_join_info.get().toByteArray());
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[START]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameStart)paramSTCMGameMessage.msg_0x03.get()).str_game_start_info.get().toByteArray());
      break label476;
      paramSTCMGameMessage = (apollo_game_status.STCMGameMessage.STGameQuitRoom)paramSTCMGameMessage.msg_0x02.get();
      i = paramSTCMGameMessage.uint32_room_vol.get();
      localMessageForApollo.gameArkInfo = new String(paramSTCMGameMessage.str_game_quit_info.get().toByteArray());
      if (!QLog.isColorLevel()) {
        break label476;
      }
      QLog.d("ApolloGameManager", 2, new Object[] { "[QUIT], roomVol:", Integer.valueOf(i), ",playerSize:", Integer.valueOf(localMessageForApollo.playerList.size()) });
      break label476;
      paramSTCMGameMessage = (apollo_game_status.STCMGameMessage.STGameOver)paramSTCMGameMessage.msg_0x04.get();
      localMessageForApollo.gameArkInfo = new String(paramSTCMGameMessage.str_game_over_info.get().toByteArray());
      localMessageForApollo.overType = paramSTCMGameMessage.uint32_over_type.get();
      localObject1 = paramSTCMGameMessage.rpt_msg_winner_info.get();
      localMessageForApollo.winnerList.clear();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label476;
      }
      localObject2 = (apollo_game_status.STCMGameMessage.STScoreInfo)((List)localObject1).get(0);
      paramSTCMGameMessage = ((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).str_wording.get();
      long l = aqft.K(((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).uint32_winner.get());
      localMessageForApollo.winRecord = paramSTCMGameMessage;
      localMessageForApollo.winnerUin = l;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (apollo_game_status.STCMGameMessage.STScoreInfo)((Iterator)localObject1).next();
        localMessageForApollo.winnerList.add(Long.valueOf(aqft.K(((apollo_game_status.STCMGameMessage.STScoreInfo)localObject2).uint32_winner.get())));
      }
      if (!QLog.isColorLevel()) {
        break label476;
      }
      QLog.d("ApolloGameManager", 2, "[OVER.OneWinner], winRecord:" + paramSTCMGameMessage + ",winUin:" + l);
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[INVALID]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameInvalid)paramSTCMGameMessage.msg_0x05.get()).str_game_invlid_info.get().toByteArray());
      break label476;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[CANCEL]");
      }
      localMessageForApollo.gameArkInfo = new String(((apollo_game_status.STCMGameMessage.STGameCancel)paramSTCMGameMessage.msg_0x06.get()).str_game_cancel_info.get().toByteArray());
      break label476;
      do
      {
        if (paramInt1 != 1) {
          break label543;
        }
        paramSTCMGameMessage = "pull_game_status";
        break label543;
        break;
        paramSTCMGameMessage = "";
      } while (paramInt1 != 0);
      paramSTCMGameMessage = "get_push_status";
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[onAddOrDelRespFromSvr], ret:" + paramLong + ",cmd:" + paramString1 + ",resp:" + paramString2 + ",reqData:" + paramString3);
    }
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        paramString3 = new JSONObject(paramString3);
        Object localObject2 = paramString3.optJSONArray("gameIdList");
        paramString3 = paramString3.optString("from");
        if (("android.web".equals(paramString3)) && (this.fc != null))
        {
          localObject1 = (abvn)this.fc.get();
          if (localObject1 != null) {
            ApolloGameUtil.a((abvn)localObject1, paramLong, paramString1);
          }
        }
        if (0L != paramLong)
        {
          QLog.i("ApolloGameManager", 1, "fail to add or del, ret:" + paramLong);
          return;
        }
        localObject1 = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
          int j = ((JSONArray)localObject2).getInt(i);
          localApolloGameRoamData.gameId = j;
          ((ArrayList)localObject1).add(localApolloGameRoamData);
          if ((!"apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1)) || (ApolloGameUtil.i(this.mApp, j))) {
            break label748;
          }
          ApolloGameUtil.a(this.mApp, j, false);
          break label748;
        }
        paramLong = new JSONObject(paramString2).getJSONObject("data").optLong("timeStamp");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "ts:" + paramLong);
        }
        paramString2 = (abxk)this.mApp.getManager(155);
        if ("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1))
        {
          paramString2.C((ArrayList)localObject1);
          paramString1 = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).edit();
          paramString1.putBoolean("is_add_new_game" + this.mApp.getCurrentAccountUin(), true);
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            localObject2 = (ApolloGameRoamData)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
            if (localObject2 != null)
            {
              paramString1.putInt("new_added_game_id" + this.mApp.getCurrentAccountUin(), ((ApolloGameRoamData)localObject2).gameId);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameManager", 2, new Object[] { "[onAddOrDelRespFromSvr] game id=", Integer.valueOf(((ApolloGameRoamData)localObject2).gameId) });
              }
            }
          }
          paramString1.commit();
          paramString1 = paramString2.a(100);
          if ((paramString1 != null) && (!paramString1.isUpdate))
          {
            paramString1.isUpdate = true;
            paramString2.a(paramString1);
          }
          ApolloGameUtil.i(this.mApp, paramLong);
          ThreadManager.getUIHandler().post(new ApolloGameManager.2(this));
          i = -1;
          if (!"android.web".equals(paramString3)) {
            break label709;
          }
          i = 1;
          if (-1 == i) {
            break label747;
          }
          paramString1 = ((ArrayList)localObject1).iterator();
          if (!paramString1.hasNext()) {
            break label747;
          }
          paramString2 = (ApolloGameRoamData)paramString1.next();
          if (paramString2 == null) {
            continue;
          }
          VipUtils.a(this.mApp, "cmshow", "Apollo", "add_game", i, 0, new String[] { Integer.toString(paramString2.gameId) });
          continue;
        }
        if (!"apollo_aio_game.del_games_from_user_gamepanel".equals(paramString1)) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloGameManager", 1, "[onAddOrDelRespFromSvr], errInfo->" + paramString1.getMessage());
        return;
      }
      paramString2.dv((ArrayList)localObject1);
      continue;
      label709:
      if ("android.playgame".equals(paramString3))
      {
        i = 0;
      }
      else
      {
        boolean bool = "android.wechat".equals(paramString3);
        if (bool)
        {
          i = 2;
          continue;
          label747:
          return;
          label748:
          i += 1;
        }
      }
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((this.mApp == null) || (paramLong != 0L)) {
      QLog.e("ApolloGameManager", 1, new Object[] { "[onGameLoginRespFromSvr] app is null or ret is :", Long.valueOf(paramLong) });
    }
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "onGameListDetailRespFromSvr ret:", Long.valueOf(paramLong) });
      }
      try
      {
        STGameLogin.STGetGameConfRsp localSTGetGameConfRsp = new STGameLogin.STGetGameConfRsp();
        localSTGetGameConfRsp.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = aJ(localSTGetGameConfRsp.game_conf_info.get());
        ((abxk)this.mApp.getManager(155)).iq(paramArrayOfByte);
        i = paramBundle.getInt("key_get_game_detail_from", 0);
        if (i == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameManager", 2, new Object[] { "onGameListDetailRespFromSvr get data when start game size:", Integer.valueOf(paramArrayOfByte.size()) });
          }
          ApolloGameUtil.cGm();
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloGameManager", 1, "Exception:", paramArrayOfByte);
        return;
      }
    } while ((i != 1) && (i != 2));
    ((abhh)this.mApp.getManager(153)).a().c(paramArrayOfByte, paramBundle);
  }
  
  public void a(MessageForApollo paramMessageForApollo, String paramString)
  {
    if ((paramMessageForApollo != null) && (ApolloGameUtil.a(this.mApp, paramMessageForApollo, this.mCreateTime)) && (this.k != null))
    {
      this.k.obtainMessage(5892, new Object[] { paramString, paramMessageForApollo }).sendToTarget();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[pullSingleMsg], roomId:" + paramMessageForApollo.roomId + ",from:" + paramString);
      }
    }
  }
  
  public void a(XListView paramXListView, wki paramwki)
  {
    this.aw = new WeakReference(paramXListView);
    this.fb = new WeakReference(paramwki);
  }
  
  public void a(String paramString1, String paramString2, ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[addOrDelGame2Svr], cmd:" + paramString2);
    }
    if ((this.mApp == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    do
    {
      do
      {
        return;
        for (;;)
        {
          Integer localInteger;
          try
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("cmd", paramString2);
            localJSONObject.put("from", paramString1);
            localJSONArray = new JSONArray();
            paramArrayList = paramArrayList.iterator();
            if (!paramArrayList.hasNext()) {
              break;
            }
            localInteger = (Integer)paramArrayList.next();
            if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString2)) && (!ApolloGameUtil.i(this.mApp, localInteger.intValue())))
            {
              localJSONArray.put(localInteger);
              continue;
            }
            if (!"apollo_aio_game.del_games_from_user_gamepanel".equals(paramString2)) {
              continue;
            }
          }
          catch (Exception paramString1)
          {
            QLog.i("ApolloGameManager", 1, "[addOrDelGame2Svr], errInfo->" + paramString1.getMessage());
            return;
          }
          if (ApolloGameUtil.h(this.mApp, localInteger.intValue())) {
            localJSONArray.put(localInteger);
          }
        }
        if (localJSONArray.length() != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "list is empty, return now.");
        }
      } while ((!"android.web".equals(paramString1)) || (this.fc == null));
      paramString1 = (abvn)this.fc.get();
    } while (paramString1 == null);
    ApolloGameUtil.a(paramString1, -1L, paramString2);
    return;
    localJSONObject.put("gameIdList", localJSONArray);
    paramString1 = localJSONObject.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[addOrDelGame2Svr], reqStr:" + paramString1);
    }
    ((aqrb)this.mApp.getBusinessHandler(71)).l(paramString2, paramString1, -1L, 1);
  }
  
  public List<ApolloGameData> aJ(List<STGameLogin.STGameConfInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get gameData list:");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      STGameLogin.STGameConfInfo localSTGameConfInfo = (STGameLogin.STGameConfInfo)paramList.get(i);
      ApolloGameData localApolloGameData = new ApolloGameData();
      localApolloGameData.gameId = localSTGameConfInfo.game_id.get();
      localApolloGameData.actionId = localSTGameConfInfo.action_id.get();
      localApolloGameData.appId = localSTGameConfInfo.appid.get();
      localApolloGameData.developerName = localSTGameConfInfo.ep_name.get();
      localApolloGameData.minVer = localSTGameConfInfo.g_start_ver.get();
      localApolloGameData.maxVer = localSTGameConfInfo.g_end_ver.get();
      localApolloGameData.name = localSTGameConfInfo.game_name.get();
      localApolloGameData.hasOwnArk = localSTGameConfInfo.has_own_ark.get();
      if (localSTGameConfInfo.isfeatured.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localApolloGameData.isFeatured = bool;
        localApolloGameData.isShow = localSTGameConfInfo.is_show_onpanel.get();
        localApolloGameData.listCoverUrl = localSTGameConfInfo.list_cover_url.get();
        localApolloGameData.logoUrl = localSTGameConfInfo.logo_url.get();
        localApolloGameData.needOpenKey = localSTGameConfInfo.need_open_key.get();
        localApolloGameData.officialAccountUin = String.valueOf(localSTGameConfInfo.puin.get());
        localApolloGameData.screenMode = localSTGameConfInfo.screen_mode.get();
        localApolloGameData.viewMode = localSTGameConfInfo.view_mode.get();
        localArrayList.add(localApolloGameData);
        localStringBuilder.append(localApolloGameData.toString()).append(",");
        i += 1;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "parseSTGameConfInfoList:", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  public void b(int paramInt, List<apollo_game_status.STCMGameMessage> paramList, String paramString)
  {
    if (paramInt != 0) {
      QLog.w("ApolloGameManager", 1, "[onStatusRespFromPull], ret != 0, ret:" + paramInt);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "pull from svr, list.size:" + paramList.size());
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramInt = localJSONObject.optInt("aioType");
        paramString = localJSONObject.optString("friendUin");
        localJSONObject.optString("from");
        if (paramList.size() <= 0) {
          continue;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a(1, paramInt, paramString, (apollo_game_status.STCMGameMessage)paramList.next());
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("ApolloGameManager", 1, "[onStatusRespFromPull], errInfo->" + paramList.getMessage());
      }
    }
  }
  
  public void c(ApolloGameData paramApolloGameData)
  {
    int i = 0;
    if (paramApolloGameData == null) {
      QLog.e("ApolloGameManager", 1, "addGameDataByCheckGame gameData is null");
    }
    abxk localabxk;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localabxk = (abxk)this.mApp.getManager(155);
          localObject = new ApolloGameRoamData();
          ((ApolloGameRoamData)localObject).gameId = paramApolloGameData.gameId;
          ((ApolloGameRoamData)localObject).type = 2;
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject);
          boolean bool = localabxk.C(localArrayList);
          if (!localabxk.a((ApolloGameRoamData)localObject)) {
            i = 1;
          }
          if ((i == 0) && (!bool))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ApolloGameManager", 2, new Object[] { "addGameDataByCheckGame not new user game and just high light game, gameId:", Integer.valueOf(paramApolloGameData.gameId) });
          }
        }
        catch (Exception paramApolloGameData)
        {
          QLog.e("ApolloGameManager", 1, "[addGameDataByCheckGame], errInfo->" + paramApolloGameData.getMessage());
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "addGameDataByCheckGame new gameData:", paramApolloGameData.toString() });
      }
      localObject = new ArrayList();
      ((List)localObject).add(paramApolloGameData);
      localabxk.iq((List)localObject);
    } while (paramApolloGameData.isShow == 0);
    Object localObject = this.mApp.getApplication().getSharedPreferences("apollo_sp", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("is_add_new_game" + this.mApp.getCurrentAccountUin(), true);
    ((SharedPreferences.Editor)localObject).putInt("new_added_game_id" + this.mApp.getCurrentAccountUin(), paramApolloGameData.gameId);
    ((SharedPreferences.Editor)localObject).commit();
    paramApolloGameData = localabxk.a(100);
    if ((paramApolloGameData != null) && (!paramApolloGameData.isUpdate))
    {
      paramApolloGameData.isUpdate = true;
      localabxk.a(paramApolloGameData);
    }
    ThreadManager.getUIHandler().post(new ApolloGameManager.3(this));
  }
  
  public void cBA()
  {
    this.aw = null;
    this.fb = null;
  }
  
  public void cBE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "[reqUsrGameList]");
    }
    if (this.mApp == null) {
      return;
    }
    cBD();
    ((aqrb)this.mApp.getBusinessHandler(71)).efe();
  }
  
  public void gA(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Abkf.gameId = paramInt1;
    this.jdField_a_of_type_Abkf.from = paramInt2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 5891: 
    case 5892: 
      for (;;)
      {
        return true;
        if (!(paramMessage.obj instanceof MessageForApollo)) {
          return true;
        }
        paramMessage = (MessageForApollo)paramMessage.obj;
        ApolloGameUtil.a(this.mApp, paramMessage, this.aw, this.fb);
        continue;
        localObject = (Object[])paramMessage.obj;
        if ((localObject != null) && (localObject.length >= 2))
        {
          paramMessage = (String)localObject[0];
          localObject = (MessageForApollo)localObject[1];
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject);
          v(localArrayList, paramMessage);
        }
      }
    }
    abyv.loadSo("AIO");
    for (;;)
    {
      int i;
      try
      {
        if ((!XZ()) && (!XY())) {
          cBE();
        }
        paramMessage = (Object[])paramMessage.obj;
        i = ((Integer)paramMessage[0]).intValue();
        int j = ((Integer)paramMessage[1]).intValue();
        if (j == 1036) {
          return false;
        }
        localObject = (String)paramMessage[2];
        paramMessage = null;
        if ((1 != i) && (3 != i)) {
          break label281;
        }
        paramMessage = ApolloGameUtil.a(this.mApp, this.mCreateTime, (String)localObject, j, i);
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break;
        }
        v(paramMessage, "aio");
      }
      catch (Throwable paramMessage)
      {
        QLog.e("ApolloGameManager", 1, paramMessage, new Object[0]);
      }
      break;
      label281:
      if (2 == i) {
        paramMessage = ApolloGameUtil.a(this.mApp, this.aw, this.mCreateTime);
      }
    }
  }
  
  public void i(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.mApp == null) || (paramLong != 0L))
    {
      QLog.e("ApolloGameManager", 1, new Object[] { "[onGameLoginRespFromSvr] app is null or ret is :", Long.valueOf(paramLong) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr ret:", Long.valueOf(paramLong) });
    }
    for (;;)
    {
      Object localObject1;
      int n;
      int j;
      int m;
      try
      {
        localObject1 = new STGameLogin.STGameLoginRsp();
        ((STGameLogin.STGameLoginRsp)localObject1).mergeFrom(paramArrayOfByte);
        Object localObject2 = ((STGameLogin.STGameLoginRsp)localObject1).game_list.get();
        List localList1 = ((STGameLogin.STGameLoginRsp)localObject1).game_tag_info.get();
        List localList2 = ((STGameLogin.STGameLoginRsp)localObject1).game_conf_info.get();
        paramLong = ((STGameLogin.STGameLoginRsp)localObject1).svr_ts.get();
        abxk localabxk = (abxk)this.mApp.getManager(155);
        i = 0;
        paramArrayOfByte = null;
        long l = NetConnInfoCenter.getServerTime();
        ConcurrentHashMap localConcurrentHashMap = localabxk.n();
        n = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get roam list:");
        ArrayList localArrayList = new ArrayList();
        j = 0;
        Object localObject3;
        if (j < ((List)localObject2).size())
        {
          localObject3 = (STGameLogin.STGameList)((List)localObject2).get(j);
          localObject1 = new ApolloGameRoamData();
          ((ApolloGameRoamData)localObject1).gameId = ((STGameLogin.STGameList)localObject3).game_id.get();
          ((ApolloGameRoamData)localObject1).type = ((STGameLogin.STGameList)localObject3).tab.get();
          localArrayList.add(localObject1);
          localStringBuilder.append("gameId:").append(((ApolloGameRoamData)localObject1).gameId).append(" type:").append(((ApolloGameRoamData)localObject1).type).append(",");
          if ((i != 0) || (((ApolloGameRoamData)localObject1).type != 1) || (l - paramLong >= 604800000L) || (localabxk.a(((ApolloGameRoamData)localObject1).gameId) == null)) {
            break label986;
          }
          paramArrayOfByte = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0).edit();
          paramArrayOfByte.putBoolean("aio_game_bubble", true);
          paramArrayOfByte.putInt("aio_bubble_recommend_game_id", ((ApolloGameRoamData)localObject1).gameId);
          paramArrayOfByte.commit();
          if (!QLog.isColorLevel()) {
            break label989;
          }
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr save recommend game id=", Integer.valueOf(((ApolloGameRoamData)localObject1).gameId) });
          break label989;
        }
        localStringBuilder.append("\r\n").append("tagInfo:");
        m = 0;
        j = 0;
        i = n;
        if (m < localList1.size())
        {
          localObject1 = (STGameLogin.STGameTagInfo)localList1.get(m);
          n = 0;
          if (n >= localArrayList.size()) {
            break label1016;
          }
          if (((STGameLogin.STGameTagInfo)localObject1).game_id.get() != ((ApolloGameRoamData)localArrayList.get(n)).gameId) {
            break label983;
          }
          localObject2 = (ApolloGameRoamData)localArrayList.get(n);
          ((ApolloGameRoamData)localObject2).tagUrl = ((STGameLogin.STGameTagInfo)localObject1).tag_url.get();
          ((ApolloGameRoamData)localObject2).tagType = ((STGameLogin.STGameTagInfo)localObject1).tag_type.get();
          ((ApolloGameRoamData)localObject2).tagBegTs = ((STGameLogin.STGameTagInfo)localObject1).tag_beg_ts.get();
          ((ApolloGameRoamData)localObject2).tagEndTs = ((STGameLogin.STGameTagInfo)localObject1).tag_end_ts.get();
          localStringBuilder.append("gameId:").append(((ApolloGameRoamData)localObject2).gameId).append("tagUrl:").append(((ApolloGameRoamData)localObject2).tagUrl).append(",tagEndTs:").append(((ApolloGameRoamData)localObject2).tagEndTs).append(",");
          j += 1;
          localObject3 = (ApolloGameRoamData)localConcurrentHashMap.get(Integer.valueOf(((ApolloGameRoamData)localObject2).gameId));
          if ((TextUtils.isEmpty(((ApolloGameRoamData)localObject2).tagUrl)) || ((localObject3 != null) && (((ApolloGameRoamData)localObject3).tagUrl.equals(((ApolloGameRoamData)localObject2).tagUrl)) && (((ApolloGameRoamData)localObject3).tagBegTs == ((ApolloGameRoamData)localObject2).tagBegTs) && (((ApolloGameRoamData)localObject3).tagEndTs == ((ApolloGameRoamData)localObject2).tagEndTs))) {
            break label980;
          }
          if (!QLog.isColorLevel()) {
            break label1004;
          }
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr has new tag gameId:", Integer.valueOf(((ApolloGameRoamData)localObject2).gameId) });
          break label1004;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr:", localStringBuilder.toString() });
        }
        localObject1 = aJ(localList2);
        if (paramArrayOfByte != null)
        {
          localArrayList.remove(paramArrayOfByte);
          if (TextUtils.isEmpty(paramArrayOfByte.tagUrl)) {
            break label977;
          }
          j = 0;
          localArrayList.add(j, paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameManager", 2, new Object[] { "onGameLoginRespFromSvr recommend data:", Integer.valueOf(paramArrayOfByte.gameId), ", will insert:", Integer.valueOf(j) });
          }
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (localabxk.packageList != null) {
            bool1 = true;
          }
        }
        localabxk.Em(bool1);
        localabxk.cGb();
        localabxk.dw(localArrayList);
        localabxk.iq((List)localObject1);
        ApolloGameUtil.i(this.mApp, paramLong);
        cBC();
        ((abhh)this.mApp.getManager(153)).cBM();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("ApolloGameManager", 1, "onGameLoginRespFromSvr Exception:", paramArrayOfByte);
        return;
      }
      label977:
      continue;
      label980:
      break label1007;
      label983:
      break label1007;
      label986:
      break label995;
      label989:
      int i = 1;
      paramArrayOfByte = (byte[])localObject1;
      label995:
      j += 1;
      continue;
      label1004:
      i = 1;
      label1007:
      n += 1;
      continue;
      label1016:
      m += 1;
    }
  }
  
  public void l(Intent paramIntent, int paramInt)
  {
    if ((this.mApp != null) && (paramIntent != null) && (paramIntent.hasExtra("launchApolloGame")) && (paramIntent.getBooleanExtra("launchApolloGame", false)))
    {
      int i = paramIntent.getIntExtra("gameId", -1);
      int j = paramIntent.getIntExtra("gameMode", 0);
      int m = paramIntent.getIntExtra("enter", -1);
      String str1 = paramIntent.getStringExtra("gameName");
      String str2 = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "[launchApolloGame] start launchGame:gameId = " + i + ";gameMode = " + j + ";friendUin = " + str2);
      }
      abhh localabhh = (abhh)this.mApp.getManager(153);
      paramIntent.putExtra("launchApolloGame", false);
      if (BaseActivity.sTopActivity != null)
      {
        paramIntent = new CmGameStartChecker.StartCheckParam(i, true, "launch", 0L, m, j, paramInt, ApolloGameUtil.a(this.mApp, paramInt, str2), str2, 205, str1);
        ApolloGameUtil.a(BaseActivity.sTopActivity, paramIntent);
      }
    }
  }
  
  public void onDestroy()
  {
    this.coA = -1;
    try
    {
      if (this.jdField_a_of_type_Abhe$a != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Abhe$a);
      }
      abyv.cGo();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
  
  public void t(int paramInt1, String paramString, int paramInt2)
  {
    if (abhh.ce("gameSwitch") != 1) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "[bulkPullGameStatus], from:", Integer.valueOf(paramInt1), ",friendUin:", paramString, ",aioType:", Integer.valueOf(paramInt2) });
      }
      if ((1 == paramInt1) && (this.cg != null))
      {
        this.cg.set(true);
        if (this.jdField_a_of_type_Abvi != null) {
          this.jdField_a_of_type_Abvi.cf(this.mApp);
        }
      }
    } while (this.k == null);
    this.k.removeMessages(5893);
    this.k.obtainMessage(5893, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }).sendToTarget();
  }
  
  static class a
    implements INetInfoHandler
  {
    public void onNetMobile2None() {}
    
    public void onNetMobile2Wifi(String paramString)
    {
      abyv.loadSo("onNetMobile2Wifi");
    }
    
    public void onNetNone2Mobile(String paramString) {}
    
    public void onNetNone2Wifi(String paramString)
    {
      abyv.loadSo("onNetNone2Wifi");
    }
    
    public void onNetWifi2Mobile(String paramString) {}
    
    public void onNetWifi2None() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhe
 * JD-Core Version:    0.7.0.1
 */