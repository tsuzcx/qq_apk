import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.1;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.2;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar.b;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollo.CmGameMsgTunnel.PushMsgInfo;
import com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthReq;
import com.tencent.pb.apollo.LGSessionKey.MsgAuthRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class abmi
  implements Handler.Callback, BusinessObserver
{
  private static SparseArray<QuickInputTipsBar.b> bZ = new SparseArray();
  private CopyOnWriteArrayList<abmi.b> G = new CopyOnWriteArrayList();
  private abmi.c jdField_a_of_type_Abmi$c;
  private abmi.d jdField_a_of_type_Abmi$d;
  private boolean bDX;
  private SparseArray<Long> bY;
  public QQLruCache<String, String> e = new QQLruCache(2016, 16, 32);
  public QQLruCache<String, String> f = new QQLruCache(2017, 16, 64);
  private auru m = new auru(ThreadManager.getSubThreadLooper(), this);
  private QQAppInterface mApp;
  private List<Integer> wo = new ArrayList();
  
  public abmi(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    cDl();
    cDk();
  }
  
  private void BZ(String paramString)
  {
    long l;
    int i;
    int j;
    Object localObject2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject1 = new JSONObject(paramString);
      if (localObject1 == null) {
        break label245;
      }
      l = ((JSONObject)localObject1).optLong("roomId");
      i = ((JSONObject)localObject1).optInt("gameId");
      j = ((JSONObject)localObject1).optInt("state");
      paramString = ((JSONObject)localObject1).optString("playMate");
      localObject2 = abmh.c(this.mApp, paramString, 1036);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onPushTempGameStatus msgList == null || msgList.isEmpty()");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onPushGameStatus failed ", paramString);
      return;
    }
    paramString = ((JSONObject)localObject1).optJSONArray("result");
    Object localObject1 = ((JSONObject)localObject1).optJSONArray("winner");
    if ((j >= 4) && (l > 0L) && (i > 0))
    {
      localObject2 = abmh.a((List)localObject2, i, l);
      if (localObject2 != null)
      {
        ((MessageForApollo)localObject2).gameStatus = 2;
        if (paramString == null) {
          break label246;
        }
        ((MessageForApollo)localObject2).commInfo = paramString.toString();
        break label246;
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        paramString = ((JSONArray)localObject1).optString(i);
        ((MessageForApollo)localObject2).winnerList.add(Long.valueOf(ApolloUtil.Q(paramString)));
        i += 1;
      }
      else
      {
        label245:
        label246:
        do
        {
          ApolloGameUtil.a(this.mApp, (MessageForApollo)localObject2);
          ((abhe)this.mApp.getManager(211)).a().e((MessageForApollo)localObject2);
          return;
        } while (localObject1 == null);
        i = 0;
      }
    }
  }
  
  public static QuickInputTipsBar.b a(int paramInt)
  {
    return (QuickInputTipsBar.b)bZ.get(paramInt);
  }
  
  private void b(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.bDX = false;
    Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1036);
    localIntent.putExtra("troop_uin", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("uinname", paramString2);
    }
    localIntent.putExtra("leftViewText", acfp.m(2131704136));
    localIntent.putExtra("key_show_one_more_page", paramBoolean);
    localIntent.putExtra("key_req_data", paramString3);
    paramString3 = BaseActivity.sTopActivity;
    paramString2 = paramString3;
    if (paramString3 == null)
    {
      paramString2 = paramString3;
      if (SplashActivity.dO != null) {
        paramString2 = (Context)SplashActivity.dO.get();
      }
    }
    if (paramString2 == null)
    {
      paramString2 = BaseApplicationImpl.getContext();
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      paramString2.startActivity(localIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "openAio friendUin:", paramString1 });
      return;
      localIntent.addFlags(4194304);
    }
  }
  
  private void b(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    int j = this.G.size();
    int i = 0;
    while (i < j)
    {
      abmi.b localb = (abmi.b)this.G.get(i);
      if (localb != null) {
        localb.b(paramBoolean, paramString, paramInt, paramLong);
      }
      i += 1;
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.mApp == null)) {}
    label185:
    label3003:
    label3133:
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      String str = paramBundle.getString("key1");
      Object localObject1 = paramBundle.getString("cmd");
      QLog.i("CmGameTemp_CmGameTempSessionHandler", 2, "onReceive cmd" + (String)localObject1 + ",isSuccess:" + paramBoolean + ",svrRet:" + paramInt);
      Object localObject2;
      long l1;
      int i;
      label348:
      label372:
      int j;
      int k;
      if (paramBoolean)
      {
        Object localObject3;
        try
        {
          localObject3 = paramBundle.getByteArray("data");
          localObject2 = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject3);
          l1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
          QLog.i("CmGameTemp_CmGameTempSessionHandler", 2, "onReceive cmd:" + (String)localObject1 + " retCode:" + l1);
          if ("apollo_router_game.apl_audio_linkcmd_save_audio_data".equals(localObject1))
          {
            i = this.G.size();
            paramInt = 0;
            if (paramInt >= i) {
              continue;
            }
            paramBundle = (abmi.b)this.G.get(paramInt);
            if (paramBundle == null) {
              break label2984;
            }
            paramBundle.Hs((int)l1);
            break label2984;
          }
          if ("apollo_router_game.apl_audio_linkcmd_query_status".equals(localObject1))
          {
            if (l1 == 0L)
            {
              localObject1 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optJSONArray("data");
              paramInt = 0;
              i = ((JSONArray)localObject1).length();
              if (paramInt >= i) {
                continue;
              }
              paramBundle = ((JSONArray)localObject1).getJSONObject(paramInt);
              if ((paramBundle == null) || (!str.equals(paramBundle.opt("playmate")))) {
                break label3003;
              }
              i = this.G.size();
              paramInt = 0;
              if (paramInt >= i) {
                continue;
              }
              localObject1 = (abmi.b)this.G.get(paramInt);
              if (localObject1 == null) {
                break label2991;
              }
              if (paramBundle.optInt("status") != 0) {
                break label2998;
              }
              paramBoolean = false;
              ((abmi.b)localObject1).aZ(str, paramBoolean);
              break label2991;
            }
            i = this.G.size();
            paramInt = 0;
            if (paramInt >= i) {
              continue;
            }
            paramBundle = (abmi.b)this.G.get(paramInt);
            if (paramBundle == null) {
              break label3010;
            }
            paramBundle.aZ(str, false);
            break label3010;
          }
          if ("apollo_router_game.apl_audio_linkcmd_get_id".equals(localObject1))
          {
            if (l1 != 0L) {
              continue;
            }
            i = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optInt("id");
            localObject1 = paramBundle.getString("key1");
            j = Integer.parseInt(paramBundle.getString("key2", "0"));
            k = this.G.size();
            paramInt = 0;
            label482:
            if (paramInt >= k) {
              continue;
            }
            paramBundle = (abmi.b)this.G.get(paramInt);
            if (paramBundle == null) {
              break label3017;
            }
            paramBundle.X((String)localObject1, i, j);
            break label3017;
          }
          if ("ltgame_userstatus.query_status".equals(localObject1))
          {
            if (l1 != 0L) {
              continue;
            }
            paramBundle = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
            if (QLog.isColorLevel()) {
              QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[onReceive] cmd:" + (String)localObject1 + ",data:" + paramBundle.toString());
            }
            paramBundle = paramBundle.getJSONArray("statusDetail");
            if ((paramBundle != null) && (paramBundle.length() > 0))
            {
              paramBundle = paramBundle.getJSONObject(0);
              l1 = paramBundle.optLong("uin");
              i = paramBundle.optInt("status");
              j = paramBundle.getInt("lastTs");
              k = this.G.size();
              paramInt = 0;
              if (paramInt >= k) {
                continue;
              }
              paramBundle = (abmi.b)this.G.get(paramInt);
              if (paramBundle == null) {
                break label3024;
              }
              paramBundle.S(String.valueOf(l1), i, j);
              break label3024;
            }
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive cmd" + (String)localObject1 + " statuDetails is null or size < 1");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramBundle, new Object[0]);
          return;
        }
        if ("ltgame_playmate.invite_playmate".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          i = this.G.size();
          paramInt = 0;
          if (paramInt >= i) {
            break label3036;
          }
          paramBundle = (abmi.b)this.G.get(paramInt);
          if (paramBundle == null) {
            break label3031;
          }
          paramBundle.ym(str);
          break label3031;
        }
        if ("ltgame_playmate.accept_playmate".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          i = this.G.size();
          paramInt = 0;
          label840:
          if (paramInt >= i) {
            break label3043;
          }
          paramBundle = (abmi.b)this.G.get(paramInt);
          if (paramBundle == null) {
            break label3038;
          }
          paramBundle.yn(str);
          break label3038;
        }
        JSONArray localJSONArray;
        abxk localabxk;
        ArrayList localArrayList;
        label1015:
        JSONObject localJSONObject;
        if ("ltgame_gamepanel.query_top_gamelist".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          this.jdField_a_of_type_Abmi$d = new abmi.d();
          this.jdField_a_of_type_Abmi$d.bhb = str;
          localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
          localObject3 = new ArrayList();
          localJSONArray = ((JSONObject)localObject2).getJSONArray("topGameList");
          this.jdField_a_of_type_Abmi$d.description = ((JSONObject)localObject2).optString("description", acfp.m(2131704134));
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localabxk = (abxk)this.mApp.getManager(155);
            localArrayList = new ArrayList();
            j = localJSONArray.length();
            paramInt = 0;
            if (paramInt < j)
            {
              localJSONObject = localJSONArray.getJSONObject(paramInt);
              if (localJSONObject == null) {
                break label3045;
              }
              k = localJSONObject.optInt("gameId", 0);
              localObject1 = localJSONObject.optString("description", "");
              this.jdField_a_of_type_Abmi$d.wp.add(Integer.valueOf(k));
              this.jdField_a_of_type_Abmi$d.wq.add(localObject1);
              if (localJSONObject.optInt("isGameApp") != 1) {
                break label3052;
              }
              i = 1;
              label1105:
              localObject2 = localabxk.a(k);
              localObject1 = localObject2;
              if (i != 0)
              {
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = new ApolloGameData();
                  ((ApolloGameData)localObject1).gameId = k;
                }
                ((ApolloGameData)localObject1).isGameApp = true;
                ((ApolloGameData)localObject1).name = localJSONObject.optString("gameName");
                ((ApolloGameData)localObject1).listCoverUrl = localJSONObject.optString("listCoverUrl");
                ((ApolloGameData)localObject1).gameAppid = localJSONObject.optString("gameAppId");
                ((ApolloGameData)localObject1).gameAppPkgName = localJSONObject.optString("packageName");
                ((List)localObject3).add(localObject1);
              }
              if (localObject1 != null)
              {
                this.jdField_a_of_type_Abmi$d.sc.add(localObject1);
                break label3045;
              }
              localArrayList.add(Integer.valueOf(k));
              break label3045;
            }
            if (((List)localObject3).size() > 0) {
              ((abxk)this.mApp.getManager(155)).iq((List)localObject3);
            }
            if (localArrayList.size() > 0)
            {
              localObject1 = (aqrb)this.mApp.getBusinessHandler(71);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("key_get_game_detail_from", 1);
              ((Bundle)localObject2).putString("key_get_game_detail_friuin", str);
              ((aqrb)localObject1).e(localArrayList, paramBundle);
              return;
            }
            i = this.G.size();
            paramInt = 0;
            label1351:
            if (paramInt >= i) {
              break label3063;
            }
            paramBundle = (abmi.b)this.G.get(paramInt);
            if (paramBundle == null) {
              break label3058;
            }
            paramBundle.a(str, this.jdField_a_of_type_Abmi$d);
            break label3058;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onReceive] cmd:", localObject1, ",gameList is null or size = 0" });
          return;
        }
        if ("ltgame_gamepanel.query_self_gamelist".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          localJSONArray = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).getJSONArray("selfGameList");
          if (QLog.isColorLevel()) {
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[onReceive] selfGameList:" + localJSONArray.toString());
          }
          localArrayList = new ArrayList();
          this.wo.clear();
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localObject3 = new ArrayList();
            localObject2 = new ArrayList();
            localabxk = (abxk)this.mApp.getManager(155);
            j = localJSONArray.length();
            paramInt = 0;
            if (paramInt < j)
            {
              localJSONObject = localJSONArray.getJSONObject(paramInt);
              if (localJSONObject == null) {
                break label3065;
              }
              k = localJSONObject.optInt("gameId", 0);
              if (localJSONObject.optInt("isGameApp") != 1) {
                break label3072;
              }
              i = 1;
              label1610:
              localObject1 = localabxk.a(k);
              paramBundle = (Bundle)localObject1;
              if (i != 0)
              {
                paramBundle = (Bundle)localObject1;
                if (localObject1 == null)
                {
                  paramBundle = new ApolloGameData();
                  paramBundle.gameId = k;
                }
                paramBundle.isGameApp = true;
                paramBundle.name = localJSONObject.optString("gameName");
                paramBundle.listCoverUrl = localJSONObject.optString("listCoverUrl");
                paramBundle.gameAppid = localJSONObject.optString("gameAppId");
                paramBundle.gameAppPkgName = localJSONObject.optString("packageName");
                localArrayList.add(paramBundle);
              }
              this.wo.add(Integer.valueOf(k));
              if (paramBundle == null) {
                break label3065;
              }
              ((ArrayList)localObject2).add(paramBundle);
              break label3065;
            }
            if (localArrayList.size() > 0) {
              ((abxk)this.mApp.getManager(155)).iq(localArrayList);
            }
            if (((ArrayList)localObject3).size() > 0)
            {
              paramBundle = (aqrb)this.mApp.getBusinessHandler(71);
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_get_game_detail_from", 2);
              ((Bundle)localObject1).putString("key_get_game_detail_friuin", str);
              paramBundle.e((List)localObject3, (Bundle)localObject1);
            }
            Collections.sort((List)localObject2, this.jdField_a_of_type_Abmi$c);
            i = this.G.size();
            paramInt = 0;
            if (paramInt >= i) {
              break label3083;
            }
            paramBundle = (abmi.b)this.G.get(paramInt);
            if (paramBundle == null) {
              break label3078;
            }
            paramBundle.r(str, (List)localObject2);
            break label3078;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onReceive] cmd:", localObject1, ",gameList is null or size = 0" });
          return;
        }
        if ("ltgame_playmate.get_playmate_info".equals(localObject1))
        {
          if (l1 != 0L) {
            continue;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (!TextUtils.isEmpty(paramBundle))
          {
            localObject1 = new JSONObject(paramBundle);
            paramBundle = new xxh.b();
            paramBundle.age = ((JSONObject)localObject1).optInt("age");
            paramBundle.sex = ((JSONObject)localObject1).optInt("sex");
            paramBundle.nickName = ((JSONObject)localObject1).optString("nickname");
            paramBundle.city = ((JSONObject)localObject1).optString("city");
            paramBundle.aWT = ((JSONObject)localObject1).optString("head");
            paramBundle.province = ((JSONObject)localObject1).optString("province");
            paramBundle.uin = ((JSONObject)localObject1).optString("mate_uin");
            paramBundle.relationShip = ((JSONObject)localObject1).optInt("relationship");
            if (!TextUtils.isEmpty(paramBundle.nickName)) {
              this.e.put(str, paramBundle.nickName);
            }
            if (!TextUtils.isEmpty(paramBundle.aWT)) {
              this.f.put(str, paramBundle.aWT);
            }
            i = this.G.size();
            paramInt = 0;
            label2115:
            if (paramInt >= i) {
              break label3090;
            }
            localObject1 = (abmi.b)this.G.get(paramInt);
            if (localObject1 == null) {
              break label3085;
            }
            ((abmi.b)localObject1).a(str, paramBundle);
            break label3085;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[onReceive] cmd:" + (String)localObject1 + ", resp is null");
          return;
        }
        if ("ltgame_msg_auth.get_sign".equals(localObject1))
        {
          if (l1 == 0L)
          {
            paramBundle = new LGSessionKey.MsgAuthRsp();
            paramBundle.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "onReceive msgAuthRsp.sign:", paramBundle.sign.get().toStringUtf8(), " expired_ts:", Long.valueOf(paramBundle.expired_ts.get()), " create_ts:", Long.valueOf(paramBundle.create_ts.get()) });
            return;
          }
          if (l1 == -10002L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a(acfp.m(2131704133), 1, BaseApplicationImpl.getContext());
            return;
          }
          if (l1 == -10000L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a("获取签名里面的src_uid和自己的uin不一致", 1, BaseApplicationImpl.getContext());
            return;
          }
          if (l1 == -10001L)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            ApolloItemBuilder.a(acfp.m(2131704139), 1, BaseApplicationImpl.getContext());
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          ApolloItemBuilder.a(acfp.m(2131704135) + l1, 1, BaseApplicationImpl.getContext());
          return;
        }
        long l2;
        if ("ltgame_usermatch.create_roomid".equals(localObject1))
        {
          localObject1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "onReceive mRespStr:", localObject1 });
          }
          i = Integer.parseInt(paramBundle.getString("key2"));
          j = Integer.parseInt(str);
          l2 = ApolloUtil.d((String)localObject1, "roomId");
          k = this.G.size();
          paramInt = 0;
          label2512:
          if (paramInt >= k) {
            break label3097;
          }
          paramBundle = (abmi.b)this.G.get(paramInt);
          if (paramBundle == null) {
            break label3092;
          }
          if (l1 != 0L) {
            break label3099;
          }
          paramBoolean = true;
          label2543:
          paramBundle.a(paramBoolean, i, l2, j);
          break label3092;
        }
        if ("ltgame_status_svr.one_more_req".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          l2 = Long.parseLong(paramBundle.getString("key3"));
          j = this.G.size();
          paramInt = 0;
          if (paramInt >= j) {
            break label3109;
          }
          paramBundle = (abmi.b)this.G.get(paramInt);
          if (paramBundle == null) {
            break label3104;
          }
          if (l1 != 0L) {
            break label3111;
          }
          paramBoolean = true;
          label2636:
          paramBundle.a(paramBoolean, str, i, l2);
          break label3104;
        }
        if ("ltgame_status_svr.one_more_rsp".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          l2 = Long.parseLong(paramBundle.getString("key3"));
          boolean bool = Boolean.parseBoolean(paramBundle.getString("key4"));
          j = this.G.size();
          paramInt = 0;
          if (paramInt >= j) {
            break label3121;
          }
          paramBundle = (abmi.b)this.G.get(paramInt);
          if (paramBundle == null) {
            break label3116;
          }
          if (l1 != 0L) {
            break label3123;
          }
          paramBoolean = true;
          paramBundle.a(bool, paramBoolean, str, i, l2);
          break label3116;
        }
        if ("ltgame_status_svr.game_over_pull".equals(localObject1))
        {
          if (l1 == 0L)
          {
            er(str, ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
            return;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive get gameStatus error, retCode:" + l1);
          return;
        }
        if ("ltgame_status_svr.create_sy_vteamid".equals(localObject1))
        {
          i = Integer.parseInt(paramBundle.getString("key2"));
          j = Integer.parseInt(paramBundle.getString("key3"));
          k = this.G.size();
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= k) {
          break label3133;
        }
        paramBundle = (abmi.b)this.G.get(paramInt);
        if (paramBundle != null)
        {
          paramBundle.a(i, str, l1, ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get(), j);
          break label3128;
          if (!"ltgame_robot_manage.send_arkmsg_to_rb".equals(localObject1)) {
            break;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          if (l1 == 0L) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            t(paramBoolean, str, paramBundle);
            return;
          }
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onReceive isSuccess: false, cmd:" + (String)localObject1);
          return;
          paramInt += 1;
          break label185;
          paramInt += 1;
          break label312;
          paramBoolean = true;
          break label348;
          paramInt += 1;
          break label269;
          label3010:
          paramInt += 1;
          break label372;
          label3017:
          paramInt += 1;
          break label482;
          label3024:
          paramInt += 1;
          break label662;
          label3031:
          paramInt += 1;
          break label778;
          label3036:
          break;
          label3038:
          paramInt += 1;
          break label840;
          label3043:
          break;
          label3045:
          paramInt += 1;
          break label1015;
          label3052:
          i = 0;
          break label1105;
          label3058:
          paramInt += 1;
          break label1351;
          label3063:
          break;
          label3065:
          paramInt += 1;
          break label1566;
          i = 0;
          break label1610;
          paramInt += 1;
          break label1845;
          break;
          paramInt += 1;
          break label2115;
          break;
          paramInt += 1;
          break label2512;
          break;
          paramBoolean = false;
          break label2543;
          paramInt += 1;
          break label2605;
          break;
          paramBoolean = false;
          break label2636;
          paramInt += 1;
          break label2710;
          break;
          paramBoolean = false;
          break label2741;
        }
        paramInt += 1;
      }
    }
  }
  
  private void c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      List localList = abmh.b(this.mApp, paramString, paramInt2, paramInt1, paramLong);
      if ((localList == null) || (localList.isEmpty()))
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "pushInviteMsg targMsgList is empty");
        return;
      }
      int i = this.G.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        abmi.b localb = (abmi.b)this.G.get(paramInt1);
        if (localb != null) {
          localb.f(paramString, paramInt2, localList);
        }
        paramInt1 += 1;
      }
    }
  }
  
  private void cDk()
  {
    int i = 0;
    this.bY = new SparseArray();
    Object localObject = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0).getString("apollo_temp_aio_game_list" + this.mApp.getCurrentAccountUin(), "");
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "[initGameTimeStamp] game timestamp:" + ((String)localObject).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      while (i + 1 < j)
      {
        this.bY.put(Integer.parseInt(localObject[i]), Long.valueOf(Long.parseLong(localObject[(i + 1)])));
        i += 2;
      }
    }
    this.jdField_a_of_type_Abmi$c = new abmi.c(this.bY);
  }
  
  private void cDl()
  {
    ThreadManagerV2.excute(new CmGameTempSessionHandler.1(this), 16, null, false);
  }
  
  private void er(String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      int j;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "onQueryTempGameStatusRsp gameStatusJson:" + paramString2);
        }
        paramString2 = new JSONObject(paramString2).optJSONArray("data");
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          paramString1 = abmh.c(this.mApp, paramString1, 1036);
          if ((paramString1 == null) || (paramString1.isEmpty()))
          {
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 2, "onQueryTempGameStatusRsp msgList == null || msgList.isEmpty()");
            return;
          }
          abhc localabhc = ((abhe)this.mApp.getManager(211)).a();
          int i = 0;
          if (i < paramString2.length())
          {
            localObject2 = paramString2.getJSONObject(i);
            if (localObject2 != null)
            {
              long l = ((JSONObject)localObject2).optLong("roomId");
              j = ((JSONObject)localObject2).optInt("gameId");
              int k = ((JSONObject)localObject2).optInt("state");
              Object localObject1 = ((JSONObject)localObject2).optJSONArray("result");
              localObject2 = ((JSONObject)localObject2).optJSONArray("winner");
              if ((k >= 4) && (l > 0L) && (j > 0))
              {
                MessageForApollo localMessageForApollo = abmh.a(paramString1, j, l);
                if (localMessageForApollo != null)
                {
                  localMessageForApollo.gameStatus = 2;
                  if (localObject1 == null) {
                    break label317;
                  }
                  localMessageForApollo.commInfo = ((JSONArray)localObject1).toString();
                  break label317;
                  if (j < ((JSONArray)localObject2).length())
                  {
                    localObject1 = ((JSONArray)localObject2).optString(j);
                    localMessageForApollo.winnerList.add(Long.valueOf(ApolloUtil.Q((String)localObject1)));
                    j += 1;
                    continue;
                  }
                  ApolloGameUtil.a(this.mApp, localMessageForApollo);
                  localabhc.e(localMessageForApollo);
                }
              }
            }
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "onQueryTempGameStatusRsp failed ", paramString1);
      }
      label317:
      if (localObject2 != null) {
        j = 0;
      }
    }
  }
  
  private void gV(long paramLong)
  {
    int j = this.G.size();
    int i = 0;
    while (i < j)
    {
      abmi.b localb = (abmi.b)this.G.get(i);
      if (localb != null) {
        localb.yo(String.valueOf(paramLong));
      }
      i += 1;
    }
  }
  
  private void gW(long paramLong)
  {
    int j = this.G.size();
    int i = 0;
    while (i < j)
    {
      abmi.b localb = (abmi.b)this.G.get(i);
      if (localb != null) {
        localb.yp(String.valueOf(paramLong));
      }
      i += 1;
    }
  }
  
  public static void p(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {}
    for (;;)
    {
      int j;
      try
      {
        if (paramJSONArray.length() <= 0) {
          break label201;
        }
        bZ.clear();
        k = paramJSONArray.length();
        i = wja.dp2px(7.0F, BaseApplicationImpl.getContext().getResources());
        if (aqgz.getDesity() > 2.0F) {
          break label202;
        }
        i = wja.dp2px(9.0F, BaseApplicationImpl.getContext().getResources());
      }
      catch (Exception paramJSONArray)
      {
        int k;
        int i;
        JSONObject localJSONObject;
        QuickInputTipsBar.b localb;
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramJSONArray, new Object[0]);
      }
      if (j < k)
      {
        localJSONObject = paramJSONArray.optJSONObject(j);
        if (localJSONObject != null)
        {
          localb = new QuickInputTipsBar.b();
          localb.mText = localJSONObject.optString("tips");
          localb.mId = localJSONObject.optInt("id");
          localb.mTipsType = localJSONObject.optInt("tipsType");
          if (!TextUtils.isEmpty(localb.mText))
          {
            if (localb.mTipsType == 1) {
              localb.mText = new aofk(aofy.fx(localJSONObject.optInt("tips")), 3, i);
            }
            bZ.put(localb.mId, localb);
          }
        }
        j += 1;
      }
      else
      {
        label201:
        return;
        label202:
        j = 0;
      }
    }
  }
  
  private void u(String paramString, int paramInt, long paramLong)
  {
    int j = this.G.size();
    int i = 0;
    while (i < j)
    {
      abmi.b localb = (abmi.b)this.G.get(i);
      if (localb != null) {
        localb.u(paramString, paramInt, paramLong);
      }
      i += 1;
    }
  }
  
  public void Ca(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "queryTempGameStatus ");
      }
      localObject2 = abmh.b(this.mApp, paramString, 1036, 1);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "queryTempGameStatus msgList == null || msgList.isEmpty()");
        return;
      }
      localObject1 = new JSONArray();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageForApollo)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("roomId", String.valueOf(((MessageForApollo)localObject3).roomId));
        localJSONObject.put("gameId", ((MessageForApollo)localObject3).gameId);
        ((JSONArray)localObject1).put(localJSONObject);
      }
      localObject3 = new WebSSOAgent.UniSsoServerReqComm();
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
      return;
    }
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("3.4.4");
    Object localObject2 = new WebSSOAgent.UniSsoServerReq();
    ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("cmd", "ltgame_status_svr.game_over_pull");
    ((JSONObject)localObject3).put("query", localObject1);
    ((JSONObject)localObject3).put("from", "android");
    ((JSONObject)localObject3).put("extendInfo", "");
    ((WebSSOAgent.UniSsoServerReq)localObject2).reqdata.set(((JSONObject)localObject3).toString());
    Object localObject1 = new NewIntent(this.mApp.getApp(), abka.class);
    ((NewIntent)localObject1).putExtra("timeout", 10000L);
    ((NewIntent)localObject1).putExtra("cmd", "ltgame_status_svr.game_over_pull");
    ((NewIntent)localObject1).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
    ((NewIntent)localObject1).putExtra("key1", paramString);
    ((NewIntent)localObject1).setObserver(this);
    this.mApp.startServlet((NewIntent)localObject1);
  }
  
  public void Cb(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_gamepanel.query_top_gamelist");
      ((JSONObject)localObject).put("playFrdUin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_gamepanel.query_top_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
    }
  }
  
  public void Cc(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_gamepanel.query_self_gamelist");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_gamepanel.query_self_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryAllGameList failed ", paramString);
    }
  }
  
  public void Cd(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.close_aio_push");
      ((JSONObject)localObject).put("playmate", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.close_aio_push");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "reportUserExitAio failed ", paramString);
    }
  }
  
  public void Ce(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_userstatus.query_status");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(Long.parseLong(paramString));
      ((JSONObject)localObject).putOpt("uinList", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_userstatus.query_status");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void Cf(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.invite_playmate");
      ((JSONObject)localObject).put("add_uin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.invite_playmate");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void Cg(String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.accept_playmate");
      ((JSONObject)localObject).put("accept_uin", Long.parseLong(paramString));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.accept_playmate");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "acceptPlayMate failed ", paramString);
    }
  }
  
  public void Ch(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (localObject1 != null)
          {
            localObject1 = ((ChatFragment)localObject1).a();
            if ((localObject1 instanceof xxh))
            {
              localObject1 = (xxh)localObject1;
              Object localObject2 = new JSONObject(paramString);
              int i = ((JSONObject)localObject2).optInt("scoreState");
              int j = ((JSONObject)localObject2).optInt("gameId");
              String str = ((JSONObject)localObject2).optString("friendUin");
              localObject2 = ((JSONObject)localObject2).optString("nickName");
              if ((localObject1 == null) || (!((xxh)localObject1).SY()))
              {
                b(str, (String)localObject2, true, paramString);
                return;
              }
              xxh.bkr = true;
              ((xxh)localObject1).w(j, i, paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramString, new Object[0]);
        return;
      }
      Object localObject1 = null;
    }
  }
  
  public void Hv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[updateTempPanelGame] updateGameList:", Integer.valueOf(paramInt) });
    }
    this.bY.put(paramInt, Long.valueOf(System.currentTimeMillis()));
    Object localObject1 = new StringBuilder();
    int i = this.bY.size();
    paramInt = 0;
    while (paramInt < i)
    {
      ((StringBuilder)localObject1).append(this.bY.keyAt(paramInt));
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.bY.valueAt(paramInt));
      if (paramInt != i - 1) {
        ((StringBuilder)localObject1).append(",");
      }
      paramInt += 1;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "[updateTempPanelGame] time list:" + ((StringBuilder)localObject1).toString());
    }
    ((SharedPreferences)localObject2).edit().putString("apollo_temp_aio_game_list" + this.mApp.getCurrentAccountUin(), ((StringBuilder)localObject1).toString()).commit();
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 != null)
      {
        localObject1 = ((ChatFragment)localObject1).a();
        if (!(localObject1 instanceof xxh)) {}
      }
    }
    for (localObject1 = (xxh)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = ((xxh)localObject1).cN();
        if (localObject2 != null) {
          break label285;
        }
      }
      label285:
      do
      {
        return;
        Collections.sort((List)localObject2, this.jdField_a_of_type_Abmi$c);
        ((xxh)localObject1).gs((List)localObject2);
      } while (((xxh)localObject1).a == null);
      ((xxh)localObject1).a.cGk();
      return;
    }
  }
  
  public void Y(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_playmate.get_playmate_info");
      ((JSONObject)localObject).put("oidb", paramInt2);
      ((JSONObject)localObject).put("mask", "11111111111");
      ((JSONObject)localObject).put("mate_uin", Long.parseLong(paramString));
      String str = ((TicketManager)this.mApp.getManager(2)).getSkey(this.mApp.getCurrentAccountUin());
      ((JSONObject)localObject).put("Cookie", "skey=" + str);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_playmate.get_playmate_info");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[queryVirtualRoomInfo] gameId=", Integer.valueOf(paramInt1), ", appid=", paramString1, ", partition=", Integer.valueOf(paramInt2), ", playmateUin=", paramString2, ", reqCode=", Integer.valueOf(paramInt3) });
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", paramString1);
      ((JSONObject)localObject).put("partition", paramInt2);
      ((JSONObject)localObject).put("playmate", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString1 = new NewIntent(this.mApp.getApp(), abka.class);
      paramString1.putExtra("cmd", "ltgame_status_svr.create_sy_vteamid");
      paramString1.putExtra("key1", paramString2);
      paramString1.putExtra("key2", String.valueOf(paramInt1));
      paramString1.putExtra("key3", String.valueOf(paramInt3));
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString1.setObserver(this);
      this.mApp.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[queryVirtualRoomInfo] failed, exception=", paramString1);
    }
  }
  
  public void a(abmi.b paramb)
  {
    this.G.remove(paramb);
    this.G.add(paramb);
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "addMsgUIHandler size:" + this.G.size() + " cmGameMsgUIHandler:" + paramb);
  }
  
  public void b(abmi.b paramb)
  {
    this.G.remove(paramb);
    QLog.i("CmGameTemp_CmGameTempSessionHandler", 1, "removeMsgUIHandler size:" + this.G.size() + " cmGameMsgUIHandler:" + paramb);
  }
  
  public void b(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    if (paramTunnelMsgStream == null) {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] stream null");
    }
    label248:
    label763:
    for (;;)
    {
      return;
      String str = paramTunnelMsgStream.cmd.get();
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[handleCmGamePushMsg] stream cmd=", str });
      int j;
      long l1;
      long l2;
      long l3;
      try
      {
        CmGameMsgTunnel.PushMsgInfo localPushMsgInfo = new CmGameMsgTunnel.PushMsgInfo();
        localPushMsgInfo.mergeFrom(paramTunnelMsgStream.busi_buff.get().toByteArray());
        j = localPushMsgInfo.gameid.get();
        l1 = localPushMsgInfo.accept_uid.get();
        l2 = localPushMsgInfo.invite_uid.get();
        l3 = localPushMsgInfo.roomid.get();
        i = localPushMsgInfo.ret.get();
        paramTunnelMsgStream = localPushMsgInfo.ext_info.get();
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "[handleCmGamePushMsg] gameId=", Integer.valueOf(j), ", acceptUin=", Long.valueOf(l1), ", inviteUin=", Long.valueOf(l2), ", roomId=", Long.valueOf(l3), ", ret=", Integer.valueOf(i), ", extInfo=", paramTunnelMsgStream });
        }
        if ("close_aio".equals(str))
        {
          j = this.G.size();
          i = 0;
          if (i >= j) {
            continue;
          }
          paramTunnelMsgStream = (abmi.b)this.G.get(i);
          if (paramTunnelMsgStream == null) {
            break label740;
          }
          paramTunnelMsgStream.yl(String.valueOf(l2));
          break label740;
        }
        if ("mphone_status".equals(str))
        {
          if (TextUtils.isEmpty(paramTunnelMsgStream)) {
            break label735;
          }
          i = new JSONObject(paramTunnelMsgStream).optInt("status", 0);
          int k = this.G.size();
          j = 0;
          if (j >= k) {
            continue;
          }
          paramTunnelMsgStream = (abmi.b)this.G.get(j);
          if (paramTunnelMsgStream == null) {
            break label747;
          }
          paramTunnelMsgStream.cF(String.valueOf(l2), i);
          break label747;
        }
        if ("accept_invite".equals(str))
        {
          i = 1036;
          if (!TextUtils.isEmpty(paramTunnelMsgStream)) {
            i = new JSONObject(paramTunnelMsgStream).optInt("aioType");
          }
          c(String.valueOf(l1), j, l3, i);
          return;
        }
      }
      catch (Exception paramTunnelMsgStream)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] exception=", paramTunnelMsgStream);
        return;
      }
      boolean bool;
      if ("one_more_rsp".equals(str))
      {
        if (i == 1)
        {
          bool = true;
          b(bool, String.valueOf(l1), j, l3);
        }
      }
      else
      {
        if ("one_more_req".equals(str))
        {
          u(String.valueOf(l2), j, l3);
          return;
        }
        if ("match_complete".equals(str))
        {
          abmh.a(this.mApp, String.valueOf(l1), l3, j);
          return;
        }
        if ("push_invite_msg".equals(str))
        {
          gV(l2);
          return;
        }
        if ("push_accept_msg".equals(str))
        {
          gW(l1);
          return;
        }
        if ("game_over".equals(str))
        {
          BZ(paramTunnelMsgStream);
          return;
        }
        if ("match_success".equals(str))
        {
          if (TextUtils.isEmpty(paramTunnelMsgStream)) {
            continue;
          }
          paramTunnelMsgStream = new JSONObject(paramTunnelMsgStream);
          l1 = paramTunnelMsgStream.optLong("matchedUin");
          if (paramTunnelMsgStream.optInt("isRobot") != 1) {
            break label760;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label763;
        }
        abmk.Ci(String.valueOf(l1));
        return;
        if ("robot_send_arkmsg".equals(str))
        {
          if (TextUtils.isEmpty(paramTunnelMsgStream)) {
            break;
          }
          paramTunnelMsgStream = new JSONObject(paramTunnelMsgStream);
          i = paramTunnelMsgStream.optInt("gameId");
          l1 = ApolloUtil.Q(paramTunnelMsgStream.optString("roomId"));
          l2 = paramTunnelMsgStream.optLong("rbUin");
          paramTunnelMsgStream = paramTunnelMsgStream.optString("rbOpenId");
          abmh.a(this.mApp, String.valueOf(l2), paramTunnelMsgStream, l1, i);
          return;
        }
        QLog.w("CmGameTemp_CmGameTempSessionHandler", 1, "[handleCmGamePushMsg] cmd not support, cmd=" + str);
        return;
        i = 0;
        break label317;
        i += 1;
        break label248;
        j += 1;
        break label328;
        bool = false;
        break label447;
      }
    }
  }
  
  public void c(List<ApolloGameData> paramList, Bundle paramBundle)
  {
    int j = 0;
    Object localObject = (abxk)this.mApp.getManager(155);
    int i = paramBundle.getInt("key_get_game_detail_from");
    paramList = paramBundle.getString("key_get_game_detail_friuin");
    int k;
    if (i == 1)
    {
      this.jdField_a_of_type_Abmi$d.sc.clear();
      k = this.jdField_a_of_type_Abmi$d.sc.size();
      i = 0;
      while (i < k)
      {
        int n = ((Integer)this.jdField_a_of_type_Abmi$d.wp.get(i)).intValue();
        paramBundle = ((abxk)localObject).a(n);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_Abmi$d.sc.add(paramBundle);
          i += 1;
        }
        else
        {
          QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onGetGameConfigList] gameData is null,gameId:", Integer.valueOf(n) });
        }
      }
    }
    for (;;)
    {
      return;
      k = this.G.size();
      i = j;
      while (i < k)
      {
        paramBundle = (abmi.b)this.G.get(i);
        if (paramBundle != null) {
          paramBundle.a(paramList, this.jdField_a_of_type_Abmi$d);
        }
        i += 1;
      }
      continue;
      if (i == 2)
      {
        paramBundle = new ArrayList();
        Iterator localIterator = this.wo.iterator();
        while (localIterator.hasNext())
        {
          i = ((Integer)localIterator.next()).intValue();
          ApolloGameData localApolloGameData = ((abxk)localObject).a(i);
          if (localApolloGameData != null) {
            paramBundle.add(localApolloGameData);
          } else {
            QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, new Object[] { "[onGetGameConfigList] gameData is null,gameId:", Integer.valueOf(i) });
          }
        }
        Collections.sort(paramBundle, this.jdField_a_of_type_Abmi$c);
        j = this.G.size();
        i = 0;
        while (i < j)
        {
          localObject = (abmi.b)this.G.get(0);
          if (localObject != null) {
            ((abmi.b)localObject).r(paramList, paramBundle);
          }
          i += 1;
        }
      }
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.one_more_rsp");
      ((JSONObject)localObject).put("matchB", this.mApp.getCurrentAccountUin());
      ((JSONObject)localObject).put("matchA", paramString);
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("from", "android");
      ((JSONObject)localObject).put("extendInfo", "");
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        ((JSONObject)localObject).put("type", i);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        localObject = new NewIntent(this.mApp.getApp(), abka.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.one_more_rsp");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString);
        ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
        ((NewIntent)localObject).putExtra("key3", String.valueOf(paramLong));
        ((NewIntent)localObject).putExtra("key4", String.valueOf(paramBoolean));
        ((NewIntent)localObject).setObserver(this);
        this.mApp.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void cDm()
  {
    this.m.removeMessages(255);
    this.bDX = true;
  }
  
  public void df(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_query_status");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      ((JSONObject)localObject).put("playmate", localJSONArray);
      ((JSONObject)localObject).put("from", String.valueOf(paramInt));
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_query_status");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "[queryUserAudioStatus] failed ", paramString);
    }
  }
  
  public void dg(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_get_id");
      ((JSONObject)localObject).put("friendUin", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_get_id");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryTopGameList failed ", paramString);
    }
  }
  
  public void es(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_userstatus.report_status");
      ((JSONObject)localObject).put("src", "AIO");
      ((JSONObject)localObject).put("motion", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.mApp.getApp(), abka.class);
      paramString2.putExtra("timeout", 10000L);
      paramString2.putExtra("cmd", "ltgame_userstatus.report_status");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("key1", paramString1);
      paramString2.setObserver(this);
      this.mApp.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "reportUserStatus failed ", paramString1);
    }
  }
  
  public void et(String paramString1, String paramString2)
  {
    if ((this.mApp == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "checkAndOpenCmGameAio friendUin:", paramString1 });
    }
    b(paramString1, paramString2, false, "");
  }
  
  public void g(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_save_audio_data");
      ((JSONObject)localObject).put("uin", paramString1);
      ((JSONObject)localObject).put("recordUrl", paramString2);
      ((JSONObject)localObject).put("totalTime", paramLong);
      ((JSONObject)localObject).put("extendInfo", "");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.mApp.getApp(), abka.class);
      paramString2.putExtra("timeout", 5000L);
      paramString2.putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_save_audio_data");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("key1", paramString1);
      paramString2.setObserver(this);
      this.mApp.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryAllGameList failed ", paramString1);
    }
  }
  
  public void g(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((JSONObject)localObject).put("status", i);
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(paramString);
        ((JSONObject)localObject).put("playmate", localJSONArray);
        ((JSONObject)localObject).put("from", paramInt + "");
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        localObject = new NewIntent(this.mApp.getApp(), abka.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_audio_linkcmd_report_status");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString);
        ((NewIntent)localObject).setObserver(this);
        this.mApp.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "addPlayMate failed ", paramString);
    }
  }
  
  public void gF(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_usermatch.create_roomid");
      ((JSONObject)localObject).put("gameId", paramInt1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_usermatch.create_roomid");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", String.valueOf(paramInt2));
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt1));
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "createRoomIdAsync failed ", localException);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "handleMessage msg.what:", Integer.valueOf(paramMessage.what) });
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (!(paramMessage.obj instanceof String));
    z((String)paramMessage.obj, "", false);
    return false;
  }
  
  public void onDestroy()
  {
    this.bDX = true;
    this.G.clear();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.mApp == null)) {
      return;
    }
    ThreadManagerV2.excute(new CmGameTempSessionHandler.2(this, paramInt, paramBoolean, paramBundle), 16, null, false);
  }
  
  public void t(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, "onCheckRobotGameModeRsp rspStr:" + paramString2);
        }
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null) {
          continue;
        }
        int j = paramString2.optInt("gameId");
        long l = Long.parseLong(paramString2.optString("roomId"));
        paramString2 = paramString2.optString("rbOpenId");
        int k = this.G.size();
        int i = 0;
        while (i < k)
        {
          abmi.b localb = (abmi.b)this.G.get(i);
          if (localb != null) {
            localb.a(paramBoolean, paramString1, j, l, paramString2);
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d("CmGameTemp_CmGameTempSessionHandler", 1, paramString1, new Object[0]);
      }
    }
  }
  
  public void x(String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_status_svr.one_more_req");
      ((JSONObject)localObject).put("matchA", this.mApp.getCurrentAccountUin());
      ((JSONObject)localObject).put("matchB", paramString);
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("from", "android");
      ((JSONObject)localObject).put("extendInfo", "");
      ((JSONObject)localObject).put("type", 0);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_status_svr.one_more_req");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).putExtra("key2", String.valueOf(paramInt));
      ((NewIntent)localObject).putExtra("key3", String.valueOf(paramLong));
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "queryUserTempInfoAsync failed ", paramString);
    }
  }
  
  public void y(String paramString, int paramInt, long paramLong)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "ltgame_robot_manage.send_arkmsg_to_rb");
      ((JSONObject)localObject).put("gameId", paramInt);
      ((JSONObject)localObject).put("rbUin", Long.parseLong(paramString));
      ((JSONObject)localObject).put("roomId", String.valueOf(paramLong));
      ((JSONObject)localObject).put("from", "android.aio");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.mApp.getApp(), abka.class);
      ((NewIntent)localObject).putExtra("timeout", 10000L);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_robot_manage.send_arkmsg_to_rb");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("key1", paramString);
      ((NewIntent)localObject).setObserver(this);
      this.mApp.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, "createRoomIdAsync failed ", paramString);
    }
  }
  
  public void z(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new LGSessionKey.MsgAuthReq();
        ((LGSessionKey.MsgAuthReq)localObject).appid.set(2);
        ((LGSessionKey.MsgAuthReq)localObject).src_uid.set(this.mApp.getLongAccountUin());
        ((LGSessionKey.MsgAuthReq)localObject).dst_uid.set(Long.parseLong(paramString1));
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((LGSessionKey.MsgAuthReq)localObject).toByteArray()));
        localObject = new NewIntent(BaseApplicationImpl.getContext(), abka.class);
        ((NewIntent)localObject).putExtra("timeout", 10000L);
        ((NewIntent)localObject).putExtra("cmd", "ltgame_msg_auth.get_sign");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("key1", paramString1);
        ((NewIntent)localObject).putExtra("key2", paramString2);
        if (paramBoolean)
        {
          paramString2 = "1";
          ((NewIntent)localObject).putExtra("key3", paramString2);
          ((NewIntent)localObject).setObserver(this);
          this.mApp.startServlet((NewIntent)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CmGameTemp_CmGameTempSessionHandler", 2, new Object[] { "queryNewSessionKey friendUin:", paramString1 });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("CmGameTemp_CmGameTempSessionHandler", 1, paramString1, new Object[0]);
        return;
      }
      paramString2 = "0";
    }
  }
  
  public static class a
    implements abmi.b
  {
    public void Hs(int paramInt) {}
    
    public void S(String paramString, int paramInt1, int paramInt2) {}
    
    public void X(String paramString, int paramInt1, int paramInt2) {}
    
    public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2) {}
    
    public void a(String paramString, abmi.d paramd) {}
    
    public void a(String paramString, xxh.b paramb) {}
    
    public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2) {}
    
    public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong) {}
    
    public void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2) {}
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong) {}
    
    public void aZ(String paramString, boolean paramBoolean) {}
    
    public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong) {}
    
    public void cF(String paramString, int paramInt) {}
    
    public void f(String paramString, int paramInt, List<MessageForApollo> paramList) {}
    
    public void r(String paramString, List<ApolloGameData> paramList) {}
    
    public void u(String paramString, int paramInt, long paramLong) {}
    
    public void yl(String paramString) {}
    
    public void ym(String paramString) {}
    
    public void yn(String paramString) {}
    
    public void yo(String paramString) {}
    
    public void yp(String paramString) {}
  }
  
  public static abstract interface b
  {
    public abstract void Hs(int paramInt);
    
    public abstract void S(String paramString, int paramInt1, int paramInt2);
    
    public abstract void X(String paramString, int paramInt1, int paramInt2);
    
    public abstract void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2);
    
    public abstract void a(String paramString, abmi.d paramd);
    
    public abstract void a(String paramString, xxh.b paramb);
    
    public abstract void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2);
    
    public abstract void a(boolean paramBoolean, String paramString, int paramInt, long paramLong);
    
    public abstract void a(boolean paramBoolean, String paramString1, int paramInt, long paramLong, String paramString2);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong);
    
    public abstract void aZ(String paramString, boolean paramBoolean);
    
    public abstract void b(boolean paramBoolean, String paramString, int paramInt, long paramLong);
    
    public abstract void cF(String paramString, int paramInt);
    
    public abstract void f(String paramString, int paramInt, List<MessageForApollo> paramList);
    
    public abstract void r(String paramString, List<ApolloGameData> paramList);
    
    public abstract void u(String paramString, int paramInt, long paramLong);
    
    public abstract void yl(String paramString);
    
    public abstract void ym(String paramString);
    
    public abstract void yn(String paramString);
    
    public abstract void yo(String paramString);
    
    public abstract void yp(String paramString);
  }
  
  static class c
    implements Comparator<ApolloGameData>
  {
    SparseArray<Long> ca;
    
    c(SparseArray paramSparseArray)
    {
      this.ca = paramSparseArray;
    }
    
    public int a(ApolloGameData paramApolloGameData1, ApolloGameData paramApolloGameData2)
    {
      long l2 = 0L;
      long l1;
      if (this.ca.get(paramApolloGameData1.gameId) == null)
      {
        l1 = 0L;
        if (this.ca.get(paramApolloGameData2.gameId) != null) {
          break label63;
        }
      }
      for (;;)
      {
        if (l1 <= l2) {
          break label85;
        }
        return -1;
        l1 = ((Long)this.ca.get(paramApolloGameData1.gameId)).longValue();
        break;
        label63:
        l2 = ((Long)this.ca.get(paramApolloGameData2.gameId)).longValue();
      }
      label85:
      if (l1 < l2) {
        return 1;
      }
      return 0;
    }
  }
  
  public class d
  {
    public String bhb;
    public String description;
    public List<ApolloGameData> sc = new ArrayList();
    public List<Integer> wp = new ArrayList();
    public List<String> wq = new ArrayList();
    
    public d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmi
 * JD-Core Version:    0.7.0.1
 */