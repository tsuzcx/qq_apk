import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.2;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.8;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zpf
  extends Handler
{
  public zpf(TroopMemberApiService paramTroopMemberApiService) {}
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("ALD_CONFIG_RESULT");
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if ((str == null) || (localJSONObject == null)) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopMemberApiService", 2, "handleGetALDConfig result parse error.");
        }
        localObject = null;
      }
      paramBundle.putString("ALD_CONFIG_RESULT", Aladdin.getConfig(localObject.optInt("id")).getString(localObject.optString("key", ""), ""));
      this.a.a(154, paramBundle);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("BUNDLE_KEY_JS_OBJ");
    Object localObject1;
    Parcelable localParcelable;
    int i;
    String str2;
    JSONArray localJSONArray;
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      if ((str1 == null) || (localJSONObject == null)) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult(server) result parse error.");
        localObject1 = null;
      }
      localParcelable = paramBundle.getParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA");
      i = ((JSONObject)localObject1).optInt("biuAfterComment", 0);
      str2 = new String(Base64.decode(((JSONObject)localObject1).optString("comment"), 0));
      localJSONArray = ((JSONObject)localObject1).optJSONArray("linkList");
      if (localJSONArray == null) {
        break label284;
      }
    }
    Object localObject2 = new zpi(this).getType();
    label284:
    for (localObject2 = (List)new Gson().fromJson(localJSONArray.toString(), (Type)localObject2);; localObject2 = null)
    {
      int j = ((JSONObject)localObject1).optInt("feedsType");
      paramBundle = new zpj(this, (JSONObject)localObject1, str2, localJSONArray, paramBundle);
      if ((localParcelable instanceof FirstCommentCreateData))
      {
        localObject1 = (FirstCommentCreateData)localParcelable;
        ((FirstCommentCreateData)localObject1).a(str2);
        ((FirstCommentCreateData)localObject1).a((List)localObject2);
        localObject2 = oxr.a;
        if (i == 1) {}
        for (bool = true;; bool = false)
        {
          ((oxr)localObject2).a((FirstCommentCreateData)localObject1, paramBundle, str1, j, false, bool);
          return;
        }
      }
      if (!(localParcelable instanceof SubCommentCreateData)) {
        break;
      }
      localObject1 = (SubCommentCreateData)localParcelable;
      ((SubCommentCreateData)localObject1).d(str2);
      ((SubCommentCreateData)localObject1).a((List)localObject2);
      localObject2 = oxr.a;
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((oxr)localObject2).a((SubCommentCreateData)localObject1, paramBundle, str1, j, false, bool);
        return;
      }
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)TroopMemberApiService.d(this.a);
    Object localObject3 = ((avsy)TroopMemberApiService.e(this.a).getManager(11)).a();
    String str1 = "";
    Object localObject2 = "";
    if (localObject3 != null) {
      str1 = ((RespondQueryQQBindingStat)localObject3).mobileNo;
    }
    String str2 = ((QQAppInterface)localObject1).getCurrentNickname();
    localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getString("cur_city", null);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((String)localObject3).split("-");
      localObject1 = localObject2;
      if (localObject3.length > 0)
      {
        localObject2 = localObject3[0];
        localObject1 = localObject2;
        if (localObject3.length < 2) {}
      }
    }
    for (localObject1 = localObject3[1];; localObject1 = localObject3)
    {
      paramBundle.putString("phone", str1);
      paramBundle.putString("name", str2);
      paramBundle.putString("city", (String)localObject2);
      paramBundle.putString("area", (String)localObject1);
      return;
      localObject3 = "";
      localObject2 = localObject1;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject7 = TroopMemberApiService.c(this.a);
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if ((localObject7 instanceof QQAppInterface))
    {
      localObject5 = (amoo)((QQAppInterface)localObject7).getBusinessHandler(22);
      localObject6 = (amuu)((QQAppInterface)localObject7).getBusinessHandler(3);
      localObject1 = (anca)((QQAppInterface)localObject7).getBusinessHandler(20);
    }
    if ((paramMessage == null) || (localObject7 == null) || (!(localObject7 instanceof QQAppInterface))) {}
    Object localObject8;
    do
    {
      return;
      localObject8 = paramMessage.getData();
    } while (localObject8 == null);
    ((Bundle)localObject8).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    label756:
    int i;
    int j;
    long l1;
    boolean bool;
    long l2;
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    case 5: 
    case 10: 
    case 14: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 33: 
    case 40: 
    case 43: 
    case 48: 
    case 49: 
    case 50: 
    case 57: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 68: 
    case 78: 
    case 79: 
    case 83: 
    case 89: 
    case 90: 
    case 91: 
    case 109: 
    case 112: 
    case 123: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    default: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    case 147: 
    case 34: 
    case 41: 
    case 75: 
    case 73: 
    case 70: 
    case 38: 
    case 35: 
    case 36: 
    case 120: 
    case 153: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.jdField_b_of_type_AndroidOsMessenger = paramMessage.replyTo;
        if (paramMessage.obj != null)
        {
          localObject1 = ((Bundle)paramMessage.obj).getString("processName");
          if (localObject1 != null)
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramMessage.replyTo);
            continue;
            this.a.jdField_b_of_type_AndroidOsMessenger = null;
            if (paramMessage.obj != null)
            {
              localObject1 = ((Bundle)paramMessage.obj).getString("processName");
              if (localObject1 != null)
              {
                this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
                continue;
                this.a.jdField_a_of_type_Amzb = new amzb(((AppRuntime)localObject7).getAccount());
                continue;
                localObject1 = ((Bundle)localObject8).getString("gcode");
                localObject5 = String.valueOf(8000000);
                localObject6 = nmy.a().a((String)localObject1, (String)localObject5);
                if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  this.a.a((String)localObject1, (String)localObject5, ((AppRuntime)localObject7).getAccount(), (String)localObject6);
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                    continue;
                    this.a.a().a((AppRuntime)localObject7, (Bundle)localObject8);
                    continue;
                    this.a.a().a((AppRuntime)localObject7, (Bundle)localObject8);
                    continue;
                    localObject5 = ((Bundle)localObject8).getString("troopUin");
                    if (localObject1 != null)
                    {
                      ((anca)localObject1).b((String)localObject5);
                      continue;
                      localObject5 = ((Bundle)localObject8).getString("troopUin");
                      localObject6 = ((Bundle)localObject8).getString("troopCode");
                      if (localObject1 != null) {
                        ((anca)localObject1).a(true, (String)localObject5, (String)localObject6, 0);
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject6);
                        continue;
                        localObject1 = ((Bundle)localObject8).getString("path");
                        this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject8).getString("photoPath");
                        this.a.jdField_c_of_type_Int = ((Bundle)localObject8).getInt("seq", -1);
                        awkl.a((QQAppInterface)localObject7, (String)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
                        continue;
                        localObject5 = ((Bundle)localObject8).getByteArray("xmlData");
                        localObject1 = ((Bundle)localObject8).getString("friendUin");
                        i = ((Bundle)localObject8).getInt("directionFlag");
                        j = ((Bundle)localObject8).getInt("from");
                        if ((localObject7 instanceof QQAppInterface))
                        {
                          localObject6 = (QQAppInterface)localObject7;
                          if (!awhm.a((AppInterface)localObject6, (String)localObject1))
                          {
                            l1 = bbko.a();
                            localObject7 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                            localObject5 = bchh.a((byte[])localObject5, -1);
                            if (localObject5 != null)
                            {
                              ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                              localObject8 = (MessageForStructing)bbli.a(-2011);
                              ((MessageForStructing)localObject8).init((String)localObject7, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                              ((MessageForStructing)localObject8).structingMsg = ((AbsStructMsg)localObject5);
                              ((MessageForStructing)localObject8).msgData = ((MessageForStructing)localObject8).structingMsg.getBytes();
                              ((MessageForStructing)localObject8).isread = true;
                              awhm.a((AppInterface)localObject6, (String)localObject1);
                              awhm.a((MessageRecord)localObject8, "isFaceScoreBubbleMsg", true);
                              awhm.a((MessageRecord)localObject8, "isFaceScoreSecondMember", true);
                              awhm.a.add(localObject1);
                              if (i == 1) {}
                              for (bool = true;; bool = false)
                              {
                                abwz.a((MessageRecord)localObject8, bool);
                                ((QQAppInterface)localObject6).getMessageFacade().addMessage((MessageRecord)localObject8, ((MessageForStructing)localObject8).selfuin);
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject8);
                                break;
                              }
                              localObject1 = ((Bundle)localObject8).getString("troopUin");
                              localObject5 = ((Bundle)localObject8).getString("memUin");
                              i = ((Bundle)localObject8).getInt("serviceType");
                              localObject6 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
                              if (localObject6 != null)
                              {
                                localObject8 = new ArrayList();
                                ((List)localObject8).add(Long.valueOf(Long.parseLong((String)localObject5)));
                                ((amtp)localObject6).a((QQAppInterface)localObject7, (String)localObject1, (List)localObject8, i);
                                continue;
                                l1 = ((Bundle)localObject8).getLong("dwGroupCode");
                                l2 = ((Bundle)localObject8).getLong("cGroupOption");
                                long l3 = ((Bundle)localObject8).getLong("dwGroupClass");
                                localObject5 = ((Bundle)localObject8).getString("strGroupName");
                                i = ((Bundle)localObject8).getInt("wGroupFace");
                                localObject6 = ((Bundle)localObject8).getString("strGroupMemo");
                                localObject7 = ((Bundle)localObject8).getString("strFingerMemo");
                                j = ((Bundle)localObject8).getInt("nFlag");
                                if (localObject1 != null)
                                {
                                  ((anca)localObject1).a(l1, l2, l3, (String)localObject5, i, (String)localObject6, (String)localObject7, j);
                                  continue;
                                  localObject5 = ((Bundle)localObject8).getString("troopUin");
                                  if (localObject1 != null)
                                  {
                                    ((anca)localObject1).n((String)localObject5);
                                    continue;
                                    localObject1 = ((Bundle)localObject8).getString("troopUin");
                                    bool = ((Bundle)localObject8).getBoolean("isChecked");
                                    if (localObject5 != null)
                                    {
                                      ((amoo)localObject5).c((String)localObject1, bool);
                                      continue;
                                      localObject1 = ((Bundle)localObject8).getString("troopUin");
                                      bool = ((Bundle)localObject8).getBoolean("isChecked");
                                      if (localObject5 != null)
                                      {
                                        ((amoo)localObject5).a((String)localObject1, bool);
                                        continue;
                                        if (localObject5 != null) {
                                          ((amoo)localObject5).b(((Bundle)localObject8).getString("troopUin"), ((Bundle)localObject8).getBoolean("isChecked"));
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    case 122: 
      localObject1 = ((Bundle)localObject8).getString("content");
      i = ((Bundle)localObject8).getInt("seq");
      localObject5 = (amqd)((QQAppInterface)localObject7).getBusinessHandler(8);
      if (localObject5 != null) {
        if (((amqd)localObject5).a((String)localObject1, 0).longValue() > 0L) {
          bool = true;
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSuccess", bool);
      ((Bundle)localObject1).putInt("seq", i);
      this.a.a(122, (Bundle)localObject1);
      break label756;
      bool = false;
      continue;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      if (localObject1 != null) {
        ((anca)localObject1).j((String)localObject5);
      }
      if (!QLog.isDevelopLevel()) {
        break label756;
      }
      QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject5 }));
      break label756;
      if (localObject6 == null) {
        break label756;
      }
      localObject1 = ((Bundle)localObject8).getString("methord_name");
      if ("getGroupInArea".equals(localObject1))
      {
        ((amuu)localObject6).a(((Bundle)localObject8).getString("areaName"), ((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("startIndex"), ((Bundle)localObject8).getInt("count"), ((Bundle)localObject8).getInt("iFilterId"));
        break label756;
      }
      if ("getNearbyTroops".equals(localObject1))
      {
        ((amuu)localObject6).a(((Bundle)localObject8).getBoolean("isFirst"), ((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("sortType"), ((Bundle)localObject8).getString("strGroupArea"), ((Bundle)localObject8).getInt("iFilterId"));
        break label756;
      }
      if ("getAreaList".equals(localObject1))
      {
        ((amuu)localObject6).a(((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("radius"), ((Bundle)localObject8).getBoolean("isClickable"));
        break label756;
      }
      if (!"getNewNearbyTroop".equals(localObject1)) {
        break label756;
      }
      ((amuu)localObject6).a(((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"));
      break label756;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject6 = ((Bundle)localObject8).getString("memberUin");
      i = ((Bundle)localObject8).getInt("titleId");
      localObject7 = (TroopManager)((AppRuntime)localObject7).getManager(52);
      if ((localObject7 == null) || (i <= 0)) {
        break label756;
      }
      ((TroopManager)localObject7).a((String)localObject5, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      ((anca)localObject1).notifyUI(144, true, new Object[] { localObject5, localObject6, Integer.valueOf(i) });
      break label756;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject5 = ((Bundle)localObject8).getStringArray("paths");
      if (((localObject7 instanceof QQAppInterface)) && (localObject5 != null) && (localObject5.length > 0))
      {
        localObject6 = (azvi)((AppRuntime)localObject7).getManager(36);
        if (localObject6 != null)
        {
          localObject7 = new int[localObject5.length];
          localObject8 = new int[localObject5.length];
          i = 0;
          if (i < localObject8.length)
          {
            localObject9 = ((azvi)localObject6).a(localObject5[i]);
            if (localObject9 != null)
            {
              localObject7[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).iNewFlag.get();
              localObject8[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).type.get();
            }
            for (;;)
            {
              i += 1;
              break;
              localObject7[i] = 0;
              localObject8[i] = -1;
            }
          }
          ((Bundle)localObject1).putIntArray("iNewFlags", (int[])localObject7);
          ((Bundle)localObject1).putIntArray("types", (int[])localObject8);
        }
      }
      this.a.a(11, (Bundle)localObject1);
      break label756;
      new Bundle().putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject1 = ((Bundle)localObject8).getString("path");
      if (!(localObject7 instanceof QQAppInterface)) {
        break label756;
      }
      localObject5 = (azvi)((AppRuntime)localObject7).getManager(36);
      if (localObject5 == null) {
        break label756;
      }
      ((azvi)localObject5).b((String)localObject1);
      break label756;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject6 = ((Bundle)localObject8).getString("processName");
      if (localObject1 == null) {
        break label756;
      }
      ((anca)localObject1).b((String)localObject5, (String)localObject6);
      break label756;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("method", "changeAnonymousNick");
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      l1 = ((Bundle)localObject8).getLong("bubbleId");
      i = ((Bundle)localObject8).getInt("headId");
      localObject6 = ((Bundle)localObject8).getString("nickName");
      j = ((Bundle)localObject8).getInt("expireTime");
      localObject7 = ((Bundle)localObject8).getString("rankColor");
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
      {
        nmy.a().a((String)localObject5, l1, i, (String)localObject6, j, "", (String)localObject7);
        ((Bundle)localObject1).putBoolean("result", true);
      }
      for (;;)
      {
        this.a.a(13, (Bundle)localObject1);
        break;
        ((Bundle)localObject1).putBoolean("result", false);
      }
      i = ((Bundle)localObject8).getInt("appid");
      localObject5 = ((Bundle)localObject8).getString("token");
      ((anca)localObject1).a(i, ((Bundle)localObject8).getString("openGroupId"), (String)localObject5, ((Bundle)localObject8).getString("url"), ((Bundle)localObject8).getInt("seq"));
      break label756;
      i = ((Bundle)localObject8).getInt("seq");
      if (this.a.jdField_a_of_type_Acjx == null) {
        this.a.jdField_a_of_type_Acjx = new acjx((AppRuntime)localObject7, this.a);
      }
      this.a.jdField_a_of_type_Acjx.a(118, (Bundle)localObject8, i);
      break label756;
      i = ((Bundle)localObject8).getInt("appid");
      localObject5 = ((Bundle)localObject8).getString("token");
      ((anca)localObject1).a(i, ((Bundle)localObject8).getString("openId"), (String)localObject5, ((Bundle)localObject8).getInt("seq"));
      break label756;
      bool = ((Bundle)localObject8).getBoolean("isTroopAppListChanged");
      localObject1 = (bfaa)((AppRuntime)localObject7).getManager(109);
      if (localObject1 == null) {
        break label756;
      }
      ((bfaa)localObject1).a(bool);
      break label756;
      bool = ((Bundle)localObject8).getBoolean("isTroopProfileAppListChanged");
      localObject1 = ((Bundle)localObject8).getString("profileAppListChangedTroopUin");
      localObject5 = (bfaa)((AppRuntime)localObject7).getManager(109);
      if (localObject5 == null) {
        break label756;
      }
      ((bfaa)localObject5).a(bool, (String)localObject1);
      break label756;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject1 = ((Bundle)localObject8).getString("opn");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
        break label756;
      }
      if (((String)localObject1).equals("g_homework"))
      {
        l1 = Long.parseLong((String)localObject5);
        localObject1 = "";
        if (bfby.a((QQAppInterface)localObject7, l1)) {
          localObject1 = "role=teacher&";
        }
        localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject6).putExtra("url", "https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
        ((Intent)localObject6).setFlags(268435456);
        this.a.startActivity((Intent)localObject6);
        break label756;
      }
      if (!((String)localObject1).equals("g_troop_reward")) {
        break label756;
      }
      bfdi.a((QQAppInterface)localObject7, this.a, (String)localObject5, true);
      break label756;
      ((Bundle)localObject8).putBoolean("isSuccess", true);
      ((Bundle)localObject8).putString("data", TroopBarPublishActivity.w);
      this.a.a(81, (Bundle)localObject8);
      break label756;
      this.a.a((Bundle)localObject8);
      break label756;
      if (TroopMemberApiService.a((AppRuntime)localObject7, new zpg(this, (Bundle)localObject8))) {
        break label756;
      }
      this.a.a(16, (Bundle)localObject8);
      break label756;
      l1 = ((Bundle)localObject8).getLong("uiResId");
      localObject1 = ajek.a().a(l1);
      if ((localObject1 != null) && (((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
      {
        ((Bundle)localObject8).putString("packageName", ((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
        ((Bundle)localObject8).putString("imageUrl", ((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL);
        ((Bundle)localObject8).putString("name", ((aqmf)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        if (((aqmf)localObject1).jdField_a_of_type_Byte == 0)
        {
          bool = true;
          label3333:
          ((Bundle)localObject8).putBoolean("isOpen", bool);
          ((Bundle)localObject8).putInt("type", 0);
          ((Bundle)localObject8).putBoolean("has", true);
        }
      }
      for (;;)
      {
        this.a.a(18, (Bundle)localObject8);
        break;
        bool = false;
        break label3333;
        ((Bundle)localObject8).putBoolean("has", false);
      }
      ajek.a |= 0x1;
      bool = ((Bundle)localObject8).getBoolean("isChecked");
      l1 = ((Bundle)localObject8).getLong("uiResId");
      ((Bundle)localObject8).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
      this.a.a(17, (Bundle)localObject8);
      break label756;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      Object localObject9 = ((Bundle)localObject8).getString("troopName");
      ((Bundle)localObject8).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject7).getManager(52);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).b((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject9);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject7).getCurrentAccountUin();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      for (;;)
      {
        String str2;
        for (;;)
        {
          localObject9 = (anca)((QQAppInterface)localObject7).getBusinessHandler(20);
          if (localObject9 != null) {
            ((anca)localObject9).j((String)localObject5);
          }
          if ((localObject6 != null) && (localObject1 != null)) {
            ((TroopManager)localObject6).e((TroopInfo)localObject1);
          }
          if (!(localObject7 instanceof QQAppInterface)) {
            break;
          }
          this.a.a(19, (Bundle)localObject8);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          l1 = ((Bundle)localObject8).getLong("troopCode");
          localObject1 = ((Bundle)localObject8).getString("filePath");
          localObject5 = ((Bundle)localObject8).getString("fileName");
          l2 = ((Bundle)localObject8).getLong("fileSize");
          i = ((Bundle)localObject8).getInt("busid");
          localObject1 = bfby.a((QQAppInterface)localObject7, l1, null, (String)localObject1, (String)localObject5, l2, i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
          if (!TextUtils.isEmpty(((Bundle)localObject8).getString("callback"))) {
            ((Bundle)localObject5).putString("callback", ((Bundle)localObject8).getString("callback"));
          }
          ((Bundle)localObject5).putString("method", "getFileInfo");
          TroopMemberApiService.a(this.a, (QQAppInterface)localObject7, l1, HWTroopFileStatusInfo.parse((becp)localObject1), (Bundle)localObject5);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Uee == null) {
            this.a.jdField_a_of_type_Uee = new uee(this.a, (QQAppInterface)localObject7);
          }
          if (((Bundle)localObject8).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Uee.a((Bundle)localObject8);
            break;
          }
          this.a.jdField_a_of_type_Uee.c((Bundle)localObject8);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Uee == null) {
            this.a.jdField_a_of_type_Uee = new uee(this.a, (QQAppInterface)localObject7);
          }
          if (((Bundle)localObject8).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Uee.b((Bundle)localObject8);
            break;
          }
          this.a.jdField_a_of_type_Uee.d((Bundle)localObject8);
          break;
          if (this.a.jdField_a_of_type_Uee == null) {
            break;
          }
          this.a.jdField_a_of_type_Uee.a();
          break;
          this.a.d = ((Bundle)localObject8).getInt("appId");
          this.a.e = ((Bundle)localObject8).getInt("seq");
          if (this.a.d == 0) {
            break;
          }
          localObject1 = (bfaa)((AppRuntime)localObject7).getManager(109);
          if (localObject1 == null) {
            break;
          }
          localObject5 = new ArrayList();
          if ((((bfaa)localObject1).a(0)) && (!((bfaa)localObject1).b(0)))
          {
            localObject6 = ((bfaa)localObject1).a(false, 0);
            if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
            {
              localObject6 = ((List)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (TroopAIOAppInfo)((Iterator)localObject6).next();
                ((ArrayList)localObject5).add(Integer.valueOf(((TroopAIOAppInfo)localObject7).appid));
                if (((TroopAIOAppInfo)localObject7).appid == this.a.d)
                {
                  QQToast.a(BaseApplication.getContext(), 2, 2131719064, 0).b(this.a.getResources().getDimensionPixelSize(2131299076));
                  return;
                }
              }
            }
            ((ArrayList)localObject5).add(Integer.valueOf(this.a.d));
            localObject6 = new ArrayList();
            ((ArrayList)localObject6).add(Integer.valueOf(this.a.d));
            ((bfaa)localObject1).a((ArrayList)localObject5, (ArrayList)localObject6);
            break;
          }
          this.a.jdField_a_of_type_Boolean = true;
          ((bfaa)localObject1).a(true, 0);
          break;
          l1 = ((Bundle)localObject8).getLong("roomid", 0L);
          localObject1 = ((Bundle)localObject8).getString("roomname");
          localObject5 = ((Bundle)localObject8).getString("userdata");
          localObject6 = ((Bundle)localObject8).getString("vasname");
          i = ((Bundle)localObject8).getInt("fromid", 0);
          ((auqu)((QQAppInterface)localObject7).getManager(108)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
          break;
          localObject1 = ((Bundle)localObject8).getString("appType");
          localObject5 = ((Bundle)localObject8).getString("openType");
          localObject6 = ((Bundle)localObject8).getString("uri");
          localObject9 = ((Bundle)localObject8).getString("action");
          str2 = ((Bundle)localObject8).getString("pluginPackageName");
          localObject8 = ((Bundle)localObject8).getString("pluginParams");
          auoc.a((QQAppInterface)localObject7, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject9, str2, (String)localObject8);
          break;
          localObject1 = ((Bundle)localObject8).getString("pluginPackageName");
          localObject5 = ((Bundle)localObject8).getString("appType");
          aunt.a(((QQAppInterface)localObject7).getApp(), (String)localObject1, (String)localObject5).a();
          break;
          try
          {
            l1 = ((Bundle)localObject8).getLong("troopPubAccountUin");
            localObject1 = ((Bundle)localObject8).getLongArray("troopUinList");
            if ((localObject1 == null) || (localObject1.length <= 0)) {
              break;
            }
            localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
            i = 0;
            while (i < localObject1.length)
            {
              localObject6 = ((TroopManager)localObject5).b(localObject1[i] + "");
              if (localObject6 != null) {
                ((TroopInfo)localObject6).associatePubAccount = l1;
              }
              ((TroopManager)localObject5).b((TroopInfo)localObject6);
              i += 1;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException1) {}
        }
        QLog.e("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + localException1.toString());
        break label756;
        Object localObject2 = ((Bundle)localObject8).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
        if (localObject5 == null) {
          break label756;
        }
        localObject2 = ((TroopManager)localObject5).b((String)localObject2);
        if (localObject2 == null) {
          break label756;
        }
        ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
        ((TroopManager)localObject5).b((TroopInfo)localObject2);
        break label756;
        localObject2 = ((Bundle)localObject8).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
        if (localObject5 != null)
        {
          localObject2 = ((TroopManager)localObject5).b((String)localObject2);
          if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
            bool = true;
          }
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              ((Bundle)localObject8).putBoolean("hasOrgs", bool);
              this.a.a(46, (Bundle)localObject8);
              break label756;
              bool = false;
              continue;
              localObject2 = ((Bundle)localObject8).getString("localFilePath");
              localObject5 = ((Bundle)localObject8).getString("fileDisPlayName");
              beyy.a(this.a, (String)localObject2, (String)localObject5);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              i = ((Bundle)localObject8).getInt("rewardMoney");
              localObject5 = ((Bundle)localObject8).getString("rewardContent");
              localObject6 = ((Bundle)localObject8).getString("mediaPath");
              j = ((Bundle)localObject8).getInt("rewardType");
              bfdi.a = ((Bundle)localObject8).getInt("imageMaxWidthPixels", 1080);
              bfdi.b = ((Bundle)localObject8).getInt("imageMaxHeightPixels", 1920);
              ((bfdi)((AppRuntime)localObject7).getManager(152)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
              break label756;
              ((anca)localObject2).a(((Bundle)localObject8).getLong("troopUin"), ((Bundle)localObject8).getInt("flag"));
              break label756;
              localObject2 = (QQAppInterface)localObject7;
              ((Bundle)localObject8).putInt("fontSize", QQAppInterface.curBrowserFontSizeIndex);
              this.a.a(52, (Bundle)localObject8);
              break label756;
              i = ((Bundle)localObject8).getInt("fontSize", 1);
              localObject2 = (QQAppInterface)localObject7;
              QQAppInterface.curBrowserFontSizeIndex = i;
              ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("rewardId");
              localObject5 = ((bfdi)((AppRuntime)localObject7).getManager(152)).a((String)localObject2, (String)localObject5);
              localObject2 = "";
              if (localObject5 != null) {
                localObject2 = ((MessageForTroopReward)localObject5).mediaPath;
              }
              ((Bundle)localObject8).putString("videoPath", (String)localObject2);
              this.a.a(55, (Bundle)localObject8);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("largeImageFile");
              localObject6 = ((Bundle)localObject8).getString("fileName");
              l1 = ((Bundle)localObject8).getLong("progressTotal");
              i = ((Bundle)localObject8).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject7, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("filePath");
              localObject6 = ((Bundle)localObject8).getString("fileName");
              i = ((Bundle)localObject8).getInt("size");
              j = ((Bundle)localObject8).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject7, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, j, i);
              break label756;
              localObject5 = (TroopPluginManager)((AppRuntime)localObject7).getManager(119);
              localObject6 = ((Bundle)localObject8).getString("troopUin");
              i = ((Bundle)localObject8).getInt("seq");
              localObject7 = ((Bundle)localObject8).getString("processName");
              if (localObject5 == null) {
                break label756;
              }
              ((TroopPluginManager)localObject5).a("troop_manage_plugin.apk", new zpk(this, (anca)localObject2, (String)localObject6, i, (String)localObject7));
              break label756;
              localObject2 = ((Bundle)localObject8).getString("appid");
              localObject5 = ((Bundle)localObject8).getString("pkgname");
              this.a.a((String)localObject5, (String)localObject2);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("hashName");
              ((Bundle)localObject8).putByteArray("decryptResult", PreloadManager.a().b((String)localObject2));
              this.a.a(66, (Bundle)localObject8);
              break label756;
              ((anca)localObject2).a(((Bundle)localObject8).getString("troopUin"), "", ((Bundle)localObject8).getInt("statOption"), ((Bundle)localObject8).getString("authKey"), null, null, null);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("groupCode");
              localObject5 = ((Bundle)localObject8).getString("groupMemberUin");
              i = ((Bundle)localObject8).getInt("seq");
              ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (TroopManager)((AppRuntime)localObject7).getManager(52), (String)localObject2, (String)localObject5, (Bundle)localObject8, i), 8, null, true);
              break label756;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              localObject5 = ((bgog)((AppRuntime)localObject7).getManager(47)).a(1);
              localObject6 = new File(awia.jdField_a_of_type_JavaLangString + File.separator + "nearby_heart.mp4");
              if (!((File)localObject6).exists()) {
                ((File)localObject6).mkdirs();
              }
              for (;;)
              {
                ((bgoj)localObject5).a(new bgoe("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject6), new zpl(this, (Bundle)localObject2), new Bundle());
                break;
                ((File)localObject6).delete();
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              bool = false;
              if ((localObject7 instanceof QQAppInterface))
              {
                localObject5 = (QQAppInterface)localObject7;
                if ((!((QQAppInterface)localObject5).isVideoChatting()) || (((QQAppInterface)localObject5).getAVNotifyCenter().k())) {
                  break label5715;
                }
              }
              label5715:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
                this.a.a(84, (Bundle)localObject2);
                break;
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              if ((localObject7 instanceof QQAppInterface))
              {
                localObject6 = (bezh)((AppRuntime)localObject7).getManager(224);
                if (localObject6 != null)
                {
                  localObject5 = ((bezh)localObject6).a();
                  localObject6 = ((bezh)localObject6).b();
                  ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject5);
                  ((Bundle)localObject2).putString("title", (String)localObject6);
                }
              }
              this.a.a(76, (Bundle)localObject2);
              break label756;
              if (!(localObject7 instanceof QQAppInterface)) {
                break label756;
              }
              bool = bbxj.a((QQAppInterface)localObject7, BaseApplicationImpl.getContext());
              if (!QLog.isColorLevel()) {
                break label756;
              }
              QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
              break label756;
              ((Bundle)localObject8).putInt("currentFragment", SplashActivity.a);
              this.a.a(80, (Bundle)localObject8);
              break label756;
              localObject2 = (seh)((AppRuntime)localObject7).getManager(226);
              ((seh)localObject2).a(this.a);
              ((seh)localObject2).a(((Bundle)localObject8).getString("videoPath"), (Bundle)localObject8);
              break label756;
              i = ((Bundle)localObject8).getInt("subCmd");
              localObject2 = (bedt)((QQAppInterface)localObject7).getManager(231);
              switch (i)
              {
              }
              for (;;)
              {
                this.a.a(87, (Bundle)localObject8);
                break;
                ((bedt)localObject2).a(((Bundle)localObject8).getInt("effectId"), ((Bundle)localObject8).getString("effectName"), ((Bundle)localObject8).getInt("svipLevel"), ((Bundle)localObject8).getInt("svipType"));
                continue;
                localObject5 = ((Bundle)localObject8).getStringArrayList("statusList");
                if (localObject5 != null) {
                  ((bedt)localObject2).a((ArrayList)localObject5);
                }
              }
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("path");
              i = ((Bundle)localObject8).getInt("msgTailType", 0);
              localObject6 = new Intent();
              ((Intent)localObject6).putExtra("send_in_background", true);
              ((Intent)localObject6).putExtra("file_send_path", (String)localObject5);
              ((Intent)localObject6).putExtra("file_send_size", new File((String)localObject5).length());
              ((Intent)localObject6).putExtra("file_send_duration", ShortVideoUtils.getDurationOfVideo((String)localObject5));
              ((Intent)localObject6).putExtra("uin", (String)localObject2);
              ((Intent)localObject6).putExtra("uintype", 1);
              ((Intent)localObject6).putExtra("file_source", "album_flow");
              ((Intent)localObject6).putExtra("short_video_msg_tail_type", i);
              new alcj((Intent)localObject6).execute(new Void[0]);
              this.a.a(87, (Bundle)localObject8);
              break label756;
              l1 = ((Bundle)localObject8).getLong("roomId");
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("jumpType", 1);
              ((Bundle)localObject2).putString("roomid", String.valueOf(l1));
              ((aupc)((AppRuntime)localObject7).getManager(306)).a((Bundle)localObject2);
              break label756;
              ((aupc)((AppRuntime)localObject7).getManager(306)).a();
              break label756;
              if (this.a.jdField_b_of_type_Boolean) {
                break;
              }
              this.a.jdField_b_of_type_Boolean = true;
              bool = NetworkUtil.isNetworkAvailable(null);
              VideoEnvironment.LogDownLoad("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
              if (bool)
              {
                VideoEnvironment.LogDownLoad("TroopMemberApiService", amtj.a(2131714658), null);
                ShortVideoResourceManager.b((QQAppInterface)localObject7, new zpm(this, (AppRuntime)localObject7, (Bundle)localObject8));
                break label756;
              }
              ((Bundle)localObject8).putInt("result", -1);
              this.a.a(93, (Bundle)localObject8);
              break label756;
              i = ((Bundle)localObject8).getInt("isGroupCode");
              localObject2 = ((Bundle)localObject8).getString("roomId");
              localObject5 = ((Bundle)localObject8).getString("action");
              localObject6 = ((Bundle)localObject8).getString("fromId");
              localObject9 = ((Bundle)localObject8).getString("backType");
              str2 = ((Bundle)localObject8).getString("openType");
              localObject8 = ((Bundle)localObject8).getString("extra");
              ((auna)((AppRuntime)localObject7).getManager(236)).a(this.a, (String)localObject2, ((QQAppInterface)localObject7).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject9, str2, (String)localObject8);
              break label756;
              ((Bundle)localObject8).getString("fromId");
              ((auna)((AppRuntime)localObject7).getManager(236)).a(null, 10L);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("uin");
              i = ((Bundle)localObject8).getInt("index");
              localObject2 = nxz.a().a((String)localObject2);
              if (localObject2 == null) {
                break label756;
              }
              localObject5 = (nyd)((AppRuntime)localObject7).getManager(238);
              if (localObject5 == null) {
                break label756;
              }
              ((nyd)localObject5).a((nxq)localObject2, i);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = ((Bundle)localObject8).getString("nick");
              localObject7 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject7 == null) {
                break label756;
              }
              ((amtp)localObject7).a((String)localObject2, (String)localObject5, (String)localObject6);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject6 == null) {
                break label756;
              }
              ((amtp)localObject6).a((String)localObject2, (String)localObject5);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject5 == null) {
                break label756;
              }
              ((amtp)localObject5).a((String)localObject2);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = ((Bundle)localObject8).getString("nick");
              localObject7 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject7 == null) {
                break label756;
              }
              ((amtp)localObject7).b((String)localObject2, (String)localObject5, (String)localObject6);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject6 == null) {
                break label756;
              }
              ((amtp)localObject6).b((String)localObject2, (String)localObject5);
              break label756;
              ((Bundle)localObject8).getString("troopCode");
              localObject2 = ((Bundle)localObject8).getString("rid");
              localObject5 = new zpo(this, (Bundle)localObject8);
              this.a.jdField_a_of_type_Amuf = new amuf((QQAppInterface)localObject7, (amug)localObject5, (String)localObject2);
              this.a.jdField_a_of_type_Amuf.b(10000L);
              break label756;
              this.a.f = ((Bundle)localObject8).getInt("seq", -1);
              localObject2 = ((Bundle)localObject8).getStringArrayList("tinyIdList");
              localObject5 = (amtp)((QQAppInterface)localObject7).getBusinessHandler(35);
              if (localObject5 == null) {
                break label756;
              }
              ((amtp)localObject5).a((ArrayList)localObject2);
              break label756;
              localObject2 = ((Bundle)localObject8).getString("schoolName");
              i = ((Bundle)localObject8).getInt("isValid");
              localObject5 = (awkr)((QQAppInterface)localObject7).getBusinessHandler(60);
              if (localObject5 == null) {
                break label756;
              }
              ((awkr)localObject5).a((String)localObject2, i);
              break label756;
              localObject2 = ((Bundle)localObject8).getStringArrayList("preloadList");
              localObject5 = (oat)((AppRuntime)localObject7).getManager(248);
              if (localObject5 == null) {
                break label756;
              }
              ((oat)localObject5).a((ArrayList)localObject2);
              break label756;
              localObject2 = (oat)((AppRuntime)localObject7).getManager(248);
              if (localObject2 == null) {
                break label756;
              }
              ((oat)localObject2).a();
              break label756;
              i = ((Bundle)localObject8).getInt("topicId");
              j = ((Bundle)localObject8).getInt("followInfo");
              if (pkm.a().a(i, j)) {
                break label756;
              }
              pkm.a().d(i, j);
              break label756;
              ((Bundle)localObject8).putInt("readinjoy_to_wx_config", bkwm.o((AppRuntime)localObject7));
              this.a.a(113, (Bundle)localObject8);
              break label756;
              ((vkz)((QQAppInterface)localObject7).getBusinessHandler(98)).c(((Bundle)localObject8).getInt("reqUserSetEnableAlbumScan"));
              break label756;
              if (this.a.jdField_a_of_type_Pxu == null) {
                this.a.jdField_a_of_type_Pxu = new pxu((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Pxu.b((Bundle)localObject8);
              break label756;
              if (this.a.jdField_a_of_type_Pxu == null) {
                this.a.jdField_a_of_type_Pxu = new pxu((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Pxu.c((Bundle)localObject8);
              break label756;
              if (this.a.jdField_a_of_type_Pxu == null) {
                this.a.jdField_a_of_type_Pxu = new pxu((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Pxu.a((Bundle)localObject8);
              break label756;
              this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject8).getString("callback");
              this.a.g = ((Bundle)localObject8).getInt("seq");
              localObject5 = ((Bundle)localObject8).getString("troopUin");
              localObject6 = ((Bundle)localObject8).getString("chatType");
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && ("group".equals(localObject6)))
              {
                if (localObject2 == null) {
                  break label756;
                }
                ((anca)localObject2).a((String)localObject5, false, "TroopMemberApiService111", true, true, false, false);
                break label756;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject5 + ", chatType=" + (String)localObject6);
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("isSuccess", false);
              ((Bundle)localObject2).putInt("seq", this.a.g);
              ((Bundle)localObject2).putString("callback", this.a.jdField_c_of_type_JavaLangString);
              this.a.a(112, (Bundle)localObject2);
              break label756;
              localObject2 = new Intent(((QQAppInterface)localObject7).getApp().getApplicationContext(), SplashActivity.class);
              ((Intent)localObject2).putExtras((Bundle)localObject8);
              localObject2 = AIOUtils.setOpenAIOIntent((Intent)localObject2, null);
              localObject5 = ForwardUtils.sessionFromIntent((Intent)localObject2);
              ForwardUtils.handleAppShareAction((QQAppInterface)localObject7, ((QQAppInterface)localObject7).getApp().getApplicationContext(), (SessionInfo)localObject5, (Intent)localObject2);
              break label756;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_BEACON_REPORT");
              }
              bcqg.a(((Bundle)localObject8).getBundle("reportData"));
              break label756;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_PRELOAD");
              }
              if (!(localObject7 instanceof QQAppInterface)) {
                break label756;
              }
              ((bcpa)((AppRuntime)localObject7).getManager(362)).a(BaseApplicationImpl.getContext());
              break label756;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
              }
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("type");
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject5)) || (beyy.a((QQAppInterface)localObject7, (String)localObject2) == 0)) {
                break label756;
              }
              beyy.a((QQAppInterface)localObject7, (String)localObject2);
              break label756;
              l1 = ((Bundle)localObject8).getLong("followUin");
              i = ((Bundle)localObject8).getInt("followInfo");
              if ((i != 2) && (i != 1)) {
                break label756;
              }
              localObject2 = pkp.a();
              if (i == 2) {}
              for (bool = true;; bool = false)
              {
                ((pkp)localObject2).b(l1, bool);
                ThreadManager.post(new TroopMemberApiService.IncomingHandler.8(this, l1, i), 8, null, true);
                break;
              }
              localObject5 = ((Bundle)localObject8).getString("url");
              i = ((Bundle)localObject8).getInt("type", -1);
              j = ((Bundle)localObject8).getInt("msgfrom", 0);
              localObject6 = ((Bundle)localObject8).getString("senderUin");
              localObject9 = ((Bundle)localObject8).getString("chatId");
              str2 = ((Bundle)localObject8).getString("source");
              k = ((Bundle)localObject8).getInt("seq");
              localObject2 = ((Bundle)localObject8).getString("processName");
              localObject8 = ((Bundle)localObject8).getString("originUrl");
              localObject7 = (bgsw)((AppRuntime)localObject7).getManager(290);
              if (localObject7 != null)
              {
                ((bgsw)localObject7).a((String)localObject5, i, j, (String)localObject6, (String)localObject9, str2, (String)localObject8, new zpp(this, k, (String)localObject2));
                break label756;
              }
              localObject5 = new Bundle();
              ((Bundle)localObject5).putInt("seq", k);
              ((Bundle)localObject5).putString("processName", (String)localObject2);
              this.a.a(121, (Bundle)localObject5);
              break label756;
              try
              {
                localObject2 = (bgsw)((AppRuntime)localObject7).getManager(290);
                if (localObject2 == null) {
                  break label8113;
                }
                ((bgsw)localObject2).a((Bundle)localObject8);
              }
              catch (Throwable localThrowable)
              {
                QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
              }
            }
            break label756;
            label8113:
            if (!QLog.isColorLevel()) {
              break label756;
            }
            QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
            break label756;
            Object localObject3 = (bgsw)((AppRuntime)localObject7).getManager(290);
            localObject5 = ((Bundle)localObject8).getString("appid");
            localObject6 = ((Bundle)localObject8).getString("openid");
            localObject7 = ((Bundle)localObject8).getString("troopuin");
            i = ((Bundle)localObject8).getInt("seq");
            localObject8 = ((Bundle)localObject8).getString("processName");
            if (localObject3 != null)
            {
              ((bgsw)localObject3).a((String)localObject5, (String)localObject6, (String)localObject7, new zph(this, i, (String)localObject8));
              break label756;
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("seq", i);
            ((Bundle)localObject3).putString("processName", (String)localObject8);
            ((Bundle)localObject3).putInt("result", -1);
            this.a.a(146, (Bundle)localObject3);
            break label756;
            ((Bundle)localObject8).putString("nickName", ((QQAppInterface)localObject7).getCurrentNickname());
            this.a.a(128, (Bundle)localObject8);
            break label756;
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject3 = this.a.getApplicationContext())
            {
              KandianSubscribeManager.a((Context)localObject3, 3, 4);
              break;
            }
            if (((Bundle)localObject8).getBoolean("open_readinjoy_tab"))
            {
              bkwm.d(1);
              bkwm.a(true);
              bkwm.a(true);
            }
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject4 = this.a.getApplicationContext())
            {
              for (;;)
              {
                if (!bkwm.k()) {
                  break label8474;
                }
                j = 12;
                try
                {
                  localObject5 = ((Bundle)localObject8).getString("from");
                  i = j;
                  if (!TextUtils.isEmpty((CharSequence)localObject5))
                  {
                    i = j;
                    if (TextUtils.isDigitsOnly((CharSequence)localObject5)) {
                      i = Integer.valueOf((String)localObject5).intValue();
                    }
                  }
                  ((Context)localObject3).startActivity(okj.a((Context)localObject3, i));
                }
                catch (Exception localException2) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
              break;
            }
            label8474:
            localObject5 = (QQAppInterface)localObject7;
            if (bkwm.a((QQAppInterface)localObject5))
            {
              okj.a((QQAppInterface)localObject5, (Context)localObject4, 2, 0);
              break label756;
            }
            okj.a((Context)localObject4, null, -1L, 2);
            break label756;
            i = ((Bundle)localObject8).getInt("seq");
            localObject4 = (QQAppInterface)localObject7;
            localObject5 = ((amsw)((AppRuntime)localObject7).getManager(51)).b(((QQAppInterface)localObject4).getCurrentUin());
            if (localObject5 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "get user gender:" + ((Card)localObject5).shGender);
              }
              ((Bundle)localObject8).putShort("gender", ((Card)localObject5).shGender);
            }
            ((Bundle)localObject8).putString("facePath", ((QQAppInterface)localObject4).getCustomFaceFilePath(1, ((QQAppInterface)localObject4).getCurrentAccountUin(), 0));
            ((Bundle)localObject8).putInt("seq", i);
            this.a.a(126, (Bundle)localObject8);
            break label756;
            i = ((Bundle)localObject8).getInt("start");
            j = ((Bundle)localObject8).getInt("msgType");
            int k = ((Bundle)localObject8).getInt("count");
            localObject4 = bdla.a(this.a.getApplicationContext(), (QQAppInterface)localObject7, i, j, k);
            if (localObject4 != null) {
              ((Bundle)localObject8).putString("sayhiinfo", ((JSONObject)localObject4).toString());
            }
            this.a.a(129, (Bundle)localObject8);
            break label756;
            i = ((Bundle)localObject8).getInt("clearType");
            j = ((Bundle)localObject8).getInt("msgType");
            localObject4 = ((Bundle)localObject8).getString("uin");
            bdla.a((QQAppInterface)localObject7, (String)localObject4, i, j);
            break label756;
            i = ((Bundle)localObject8).getInt("deleteType");
            localObject4 = ((Bundle)localObject8).getString("uin");
            j = ((Bundle)localObject8).getInt("msgType");
            bdla.b((QQAppInterface)localObject7, (String)localObject4, i, j);
            break label756;
            bool = ((Bundle)localObject8).getBoolean("isSuccess");
            localObject4 = ((Bundle)localObject8).getString("pkgname");
            pkp.a().a(null, 101, bool, new String[] { localObject4 });
            break label756;
            localObject4 = txf.a(2);
            if ((localObject4 == null) || (!(localObject4 instanceof trr))) {
              break label756;
            }
            ((trr)localObject4).a((Bundle)localObject8);
            break label756;
            twr.a();
            break label756;
            c((Bundle)localObject8);
            this.a.a(141, (Bundle)localObject8);
            break label756;
            localObject4 = ((Bundle)localObject8).getString("uin");
            zkf.c(BaseApplicationImpl.getContext(), (String)localObject4, null);
            break label756;
            localObject5 = ((Bundle)localObject8).getString("code");
            localObject4 = new String[4];
            localObject4[0] = "0";
            localObject4[1] = "0";
            localObject4[2] = "0";
            localObject4[3] = "0";
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject5))
              {
                localObject5 = new JSONObject((String)localObject5);
                localObject4[0] = ((JSONObject)localObject5).optString("country", "0");
                localObject4[1] = ((JSONObject)localObject5).optString("province", "0");
                localObject4[2] = ((JSONObject)localObject5).optString("city", "0");
                localObject4[3] = ((JSONObject)localObject5).optString("area", "0");
              }
              if (this.a.jdField_a_of_type_Ampm == null)
              {
                this.a.jdField_a_of_type_Ampm = ((ampm)((AppRuntime)localObject7).getManager(59));
                this.a.jdField_a_of_type_Ampm.a(this);
              }
              localObject5 = new Intent(BaseApplicationImpl.getContext(), LocationSelectActivity.class);
              ((Intent)localObject5).putExtra("param_is_popup", false);
              ((Intent)localObject5).putExtra("param_req_type", 2);
              ((Intent)localObject5).putExtra("param_location", (String[])localObject4);
              ((Intent)localObject5).putExtra("param_location_param", this.a.jdField_a_of_type_Ampm.b((String[])localObject4));
              BaseApplicationImpl.getContext().startActivity((Intent)localObject5);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
          if (BaseActivity.sTopActivity != null) {}
          for (localObject4 = BaseActivity.sTopActivity; localObject4 != null; localObject4 = this.a.getApplicationContext())
          {
            KandianDailyManager.a((Context)localObject4);
            break;
          }
          bool = ((Bundle)localObject8).getBoolean("isOpen");
          localObject4 = ((Bundle)localObject8).getString("troopUin");
          if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject4, Boolean.valueOf(bool) }));
          }
          ((bepr)((AppRuntime)localObject7).getManager(346)).a((String)localObject4, bool);
          break label756;
          localObject4 = ((Bundle)localObject8).getString("groupCode");
          String str1 = ((Bundle)localObject8).getString("appID");
          localObject6 = ((Bundle)localObject8).getString("url");
          localObject7 = ((Bundle)localObject8).getString("source");
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", new Object[] { localObject4, str1, localObject6, localObject7 }));
          }
          localObject7 = new SessionInfo();
          ((SessionInfo)localObject7).curFriendUin = ((String)localObject4);
          ((SessionInfo)localObject7).curType = 1;
          if (BaseActivity.sTopActivity != null)
          {
            localObject4 = BaseActivity.sTopActivity;
            label9420:
            if ((localObject4 instanceof BaseActivity)) {
              break label9688;
            }
            localObject4 = null;
          }
          label9688:
          for (;;)
          {
            bfaf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), (BaseActivity)localObject4, (SessionInfo)localObject7, Long.parseLong(str1), (String)localObject6, 1, 0);
            break;
            localObject4 = this.a.getApplicationContext();
            break label9420;
            short s = ((Bundle)localObject8).getShort("tmpPushType");
            ((Bundle)localObject8).putBoolean("enable", ((avnl)((AppRuntime)localObject7).getManager(303)).a(s));
            ((Bundle)localObject8).putInt("seq", ((Bundle)localObject8).getInt("seq"));
            this.a.a(151, (Bundle)localObject8);
            break;
            s = ((Bundle)localObject8).getShort("tmpPushType");
            bool = ((Bundle)localObject8).getBoolean("enable");
            ((avnl)((AppRuntime)localObject7).getManager(303)).a(s, bool, true);
            ((Bundle)localObject8).putBoolean("enable", bool);
            ((Bundle)localObject8).putBoolean("success", true);
            ((Bundle)localObject8).putInt("seq", ((Bundle)localObject8).getInt("seq"));
            this.a.a(152, (Bundle)localObject8);
            break;
            b((Bundle)localObject8);
            break;
            a((Bundle)localObject8);
            break;
            if (localObject4 == null) {
              break;
            }
            ((anca)localObject4).a(((Bundle)localObject8).getString("troopUin", ""), ((Bundle)localObject8).getInt("opType", 0), ((Bundle)localObject8).getString("startTroopUin", ""));
            break;
          }
          bool = false;
        }
        continue;
        Object localObject4 = null;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpf
 * JD-Core Version:    0.7.0.1
 */