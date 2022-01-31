import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.2;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.9;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class wjk
  extends Handler
{
  public wjk(TroopMemberApiService paramTroopMemberApiService) {}
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)TroopMemberApiService.d(this.a);
    Object localObject3 = ((aroh)TroopMemberApiService.e(this.a).getManager(11)).a();
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
    Object localObject8 = TroopMemberApiService.c(this.a);
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if ((localObject8 instanceof QQAppInterface))
    {
      localObject5 = (ajex)((QQAppInterface)localObject8).a(22);
      localObject6 = (ajlf)((QQAppInterface)localObject8).a(3);
      localObject1 = (ajtg)((QQAppInterface)localObject8).a(20);
    }
    if ((paramMessage == null) || (localObject8 == null) || (!(localObject8 instanceof QQAppInterface))) {}
    Object localObject7;
    do
    {
      return;
      localObject7 = paramMessage.getData();
    } while (localObject7 == null);
    label700:
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
    case 83: 
    case 89: 
    case 90: 
    case 91: 
    case 112: 
    case 121: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    default: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    case 145: 
    case 34: 
    case 41: 
    case 75: 
    case 73: 
    case 70: 
    case 38: 
    case 35: 
    case 36: 
    case 118: 
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
                this.a.jdField_a_of_type_Ajqg = new ajqg(((AppRuntime)localObject8).getAccount());
                continue;
                localObject1 = ((Bundle)localObject7).getString("gcode");
                localObject5 = ((Bundle)localObject7).getString("anId");
                localObject6 = mnf.a().a((String)localObject1, (String)localObject5);
                if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  this.a.a((String)localObject1, (String)localObject5, ((AppRuntime)localObject8).getAccount(), (String)localObject6);
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                    continue;
                    this.a.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                    continue;
                    this.a.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                    continue;
                    localObject5 = ((Bundle)localObject7).getString("troopUin");
                    if (localObject1 != null)
                    {
                      ((ajtg)localObject1).b((String)localObject5);
                      continue;
                      localObject5 = ((Bundle)localObject7).getString("troopUin");
                      localObject6 = ((Bundle)localObject7).getString("troopCode");
                      if (localObject1 != null) {
                        ((ajtg)localObject1).a(true, (String)localObject5, (String)localObject6, 0);
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject6);
                        continue;
                        localObject1 = ((Bundle)localObject7).getString("path");
                        this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject7).getString("photoPath");
                        this.a.jdField_c_of_type_Int = ((Bundle)localObject7).getInt("seq", -1);
                        asfn.a((QQAppInterface)localObject8, (String)localObject1, this.a.jdField_a_of_type_Axvs);
                        continue;
                        localObject5 = ((Bundle)localObject7).getByteArray("xmlData");
                        localObject1 = ((Bundle)localObject7).getString("friendUin");
                        i = ((Bundle)localObject7).getInt("directionFlag");
                        j = ((Bundle)localObject7).getInt("from");
                        if ((localObject8 instanceof QQAppInterface))
                        {
                          localObject6 = (QQAppInterface)localObject8;
                          if (!ascq.a((AppInterface)localObject6, (String)localObject1))
                          {
                            l1 = awao.a();
                            localObject7 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                            localObject5 = awuw.a((byte[])localObject5, -1);
                            if (localObject5 != null)
                            {
                              ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                              localObject8 = (MessageForStructing)awbi.a(-2011);
                              ((MessageForStructing)localObject8).init((String)localObject7, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                              ((MessageForStructing)localObject8).structingMsg = ((AbsStructMsg)localObject5);
                              ((MessageForStructing)localObject8).msgData = ((MessageForStructing)localObject8).structingMsg.getBytes();
                              ((MessageForStructing)localObject8).isread = true;
                              ascq.a((AppInterface)localObject6, (String)localObject1);
                              ascq.a((MessageRecord)localObject8, "isFaceScoreBubbleMsg", true);
                              ascq.a((MessageRecord)localObject8, "isFaceScoreSecondMember", true);
                              ascq.a.add(localObject1);
                              if (i == 1) {}
                              for (bool = true;; bool = false)
                              {
                                akbm.a((MessageRecord)localObject8, bool);
                                ((QQAppInterface)localObject6).a().a((MessageRecord)localObject8, ((MessageForStructing)localObject8).selfuin);
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject8);
                                break;
                              }
                              localObject1 = ((Bundle)localObject7).getString("troopUin");
                              localObject5 = ((Bundle)localObject7).getString("memUin");
                              i = ((Bundle)localObject7).getInt("serviceType");
                              localObject6 = (ajkc)((QQAppInterface)localObject8).a(35);
                              if (localObject6 != null)
                              {
                                localObject7 = new ArrayList();
                                ((List)localObject7).add(Long.valueOf(Long.parseLong((String)localObject5)));
                                ((ajkc)localObject6).a((QQAppInterface)localObject8, (String)localObject1, (List)localObject7, i);
                                continue;
                                l1 = ((Bundle)localObject7).getLong("dwGroupCode");
                                l2 = ((Bundle)localObject7).getLong("cGroupOption");
                                long l3 = ((Bundle)localObject7).getLong("dwGroupClass");
                                localObject5 = ((Bundle)localObject7).getString("strGroupName");
                                i = ((Bundle)localObject7).getInt("wGroupFace");
                                localObject6 = ((Bundle)localObject7).getString("strGroupMemo");
                                localObject8 = ((Bundle)localObject7).getString("strFingerMemo");
                                j = ((Bundle)localObject7).getInt("nFlag");
                                if (localObject1 != null)
                                {
                                  ((ajtg)localObject1).a(l1, l2, l3, (String)localObject5, i, (String)localObject6, (String)localObject8, j);
                                  continue;
                                  localObject5 = ((Bundle)localObject7).getString("troopUin");
                                  if (localObject1 != null)
                                  {
                                    ((ajtg)localObject1).n((String)localObject5);
                                    continue;
                                    localObject1 = ((Bundle)localObject7).getString("troopUin");
                                    bool = ((Bundle)localObject7).getBoolean("isChecked");
                                    if (localObject5 != null)
                                    {
                                      ((ajex)localObject5).b((String)localObject1, bool);
                                      continue;
                                      localObject1 = ((Bundle)localObject7).getString("troopUin");
                                      bool = ((Bundle)localObject7).getBoolean("isChecked");
                                      if (localObject5 != null) {
                                        ((ajex)localObject5).a((String)localObject1, bool);
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
    case 120: 
      localObject1 = ((Bundle)localObject7).getString("content");
      i = ((Bundle)localObject7).getInt("seq");
      localObject5 = (ajgm)((QQAppInterface)localObject8).a(8);
      if (localObject5 != null) {
        if (((ajgm)localObject5).a((String)localObject1, 0).longValue() > 0L) {
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
      this.a.a(120, (Bundle)localObject1);
      break label700;
      bool = false;
      continue;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      if (localObject1 != null) {
        ((ajtg)localObject1).j((String)localObject5);
      }
      if (!QLog.isDevelopLevel()) {
        break label700;
      }
      QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject5 }));
      break label700;
      if (localObject6 == null) {
        break label700;
      }
      localObject1 = ((Bundle)localObject7).getString("methord_name");
      if ("getGroupInArea".equals(localObject1))
      {
        ((ajlf)localObject6).a(((Bundle)localObject7).getString("areaName"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("startIndex"), ((Bundle)localObject7).getInt("count"), ((Bundle)localObject7).getInt("iFilterId"));
        break label700;
      }
      if ("getNearbyTroops".equals(localObject1))
      {
        ((ajlf)localObject6).a(((Bundle)localObject7).getBoolean("isFirst"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("sortType"), ((Bundle)localObject7).getString("strGroupArea"), ((Bundle)localObject7).getInt("iFilterId"));
        break label700;
      }
      if ("getAreaList".equals(localObject1))
      {
        ((ajlf)localObject6).a(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("radius"), ((Bundle)localObject7).getBoolean("isClickable"));
        break label700;
      }
      if (!"getNewNearbyTroop".equals(localObject1)) {
        break label700;
      }
      ((ajlf)localObject6).a(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"));
      break label700;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject6 = ((Bundle)localObject7).getString("memberUin");
      i = ((Bundle)localObject7).getInt("titleId");
      localObject7 = (TroopManager)((AppRuntime)localObject8).getManager(52);
      if ((localObject7 == null) || (i <= 0)) {
        break label700;
      }
      ((TroopManager)localObject7).a((String)localObject5, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      ((ajtg)localObject1).notifyUI(144, true, new Object[] { localObject5, localObject6, Integer.valueOf(i) });
      break label700;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject5 = ((Bundle)localObject7).getStringArray("paths");
      if (((localObject8 instanceof QQAppInterface)) && (localObject5 != null) && (localObject5.length > 0))
      {
        localObject6 = (auqh)((AppRuntime)localObject8).getManager(36);
        if (localObject6 != null)
        {
          localObject7 = new int[localObject5.length];
          localObject8 = new int[localObject5.length];
          i = 0;
          if (i < localObject8.length)
          {
            localObject9 = ((auqh)localObject6).a(localObject5[i]);
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
      break label700;
      new Bundle().putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject1 = ((Bundle)localObject7).getString("path");
      if (!(localObject8 instanceof QQAppInterface)) {
        break label700;
      }
      localObject5 = (auqh)((AppRuntime)localObject8).getManager(36);
      if (localObject5 == null) {
        break label700;
      }
      ((auqh)localObject5).b((String)localObject1);
      break label700;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject6 = ((Bundle)localObject7).getString("processName");
      if (localObject1 == null) {
        break label700;
      }
      ((ajtg)localObject1).b((String)localObject5, (String)localObject6);
      break label700;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("method", "changeAnonymousNick");
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      l1 = ((Bundle)localObject7).getLong("bubbleId");
      i = ((Bundle)localObject7).getInt("headId");
      localObject6 = ((Bundle)localObject7).getString("nickName");
      j = ((Bundle)localObject7).getInt("expireTime");
      localObject7 = ((Bundle)localObject7).getString("rankColor");
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
      {
        mnf.a().a((String)localObject5, l1, i, (String)localObject6, j, "", (String)localObject7);
        ((Bundle)localObject1).putBoolean("result", true);
      }
      for (;;)
      {
        this.a.a(13, (Bundle)localObject1);
        break;
        ((Bundle)localObject1).putBoolean("result", false);
      }
      i = ((Bundle)localObject7).getInt("appid");
      localObject5 = ((Bundle)localObject7).getString("token");
      ((ajtg)localObject1).a(i, ((Bundle)localObject7).getString("openGroupId"), (String)localObject5, ((Bundle)localObject7).getString("url"), ((Bundle)localObject7).getInt("seq"));
      break label700;
      i = ((Bundle)localObject7).getInt("seq");
      if (this.a.jdField_a_of_type_Zrz == null) {
        this.a.jdField_a_of_type_Zrz = new zrz((AppRuntime)localObject8, this.a);
      }
      this.a.jdField_a_of_type_Zrz.a(116, (Bundle)localObject7, i);
      break label700;
      i = ((Bundle)localObject7).getInt("appid");
      localObject5 = ((Bundle)localObject7).getString("token");
      ((ajtg)localObject1).a(i, ((Bundle)localObject7).getString("openId"), (String)localObject5, ((Bundle)localObject7).getInt("seq"));
      break label700;
      bool = ((Bundle)localObject7).getBoolean("isTroopAppListChanged");
      localObject1 = (azhi)((AppRuntime)localObject8).getManager(109);
      if (localObject1 == null) {
        break label700;
      }
      ((azhi)localObject1).a(bool);
      break label700;
      bool = ((Bundle)localObject7).getBoolean("isTroopProfileAppListChanged");
      localObject1 = ((Bundle)localObject7).getString("profileAppListChangedTroopUin");
      localObject5 = (azhi)((AppRuntime)localObject8).getManager(109);
      if (localObject5 == null) {
        break label700;
      }
      ((azhi)localObject5).a(bool, (String)localObject1);
      break label700;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject1 = ((Bundle)localObject7).getString("opn");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
        break label700;
      }
      if (((String)localObject1).equals("g_homework"))
      {
        l1 = Long.parseLong((String)localObject5);
        localObject1 = "";
        if (azjg.a((QQAppInterface)localObject8, l1)) {
          localObject1 = "role=teacher&";
        }
        localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject6).putExtra("url", "http://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
        ((Intent)localObject6).setFlags(268435456);
        this.a.startActivity((Intent)localObject6);
        break label700;
      }
      if (!((String)localObject1).equals("g_troop_reward")) {
        break label700;
      }
      azko.a((QQAppInterface)localObject8, this.a, (String)localObject5, true);
      break label700;
      ((Bundle)localObject7).putBoolean("isSuccess", true);
      ((Bundle)localObject7).putString("data", TroopBarPublishActivity.F);
      this.a.a(81, (Bundle)localObject7);
      break label700;
      this.a.a((Bundle)localObject7);
      break label700;
      if (TroopMemberApiService.a((AppRuntime)localObject8, new wjl(this, (Bundle)localObject7))) {
        break label700;
      }
      this.a.a(16, (Bundle)localObject7);
      break label700;
      l1 = ((Bundle)localObject7).getLong("uiResId");
      localObject1 = afqa.a().a(l1);
      if ((localObject1 != null) && (((amnq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
      {
        ((Bundle)localObject7).putString("packageName", ((amnq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
        ((Bundle)localObject7).putString("imageUrl", ((amnq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL);
        ((Bundle)localObject7).putString("name", ((amnq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        if (((amnq)localObject1).jdField_a_of_type_Byte == 0)
        {
          bool = true;
          label3209:
          ((Bundle)localObject7).putBoolean("isOpen", bool);
          ((Bundle)localObject7).putInt("type", 0);
          ((Bundle)localObject7).putBoolean("has", true);
        }
      }
      for (;;)
      {
        this.a.a(18, (Bundle)localObject7);
        break;
        bool = false;
        break label3209;
        ((Bundle)localObject7).putBoolean("has", false);
      }
      afqa.jdField_a_of_type_Int |= 0x1;
      bool = ((Bundle)localObject7).getBoolean("isChecked");
      l1 = ((Bundle)localObject7).getLong("uiResId");
      ((Bundle)localObject7).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
      this.a.a(17, (Bundle)localObject7);
      break label700;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      Object localObject9 = ((Bundle)localObject7).getString("troopName");
      ((Bundle)localObject7).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject8).getManager(52);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).b((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject9);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject8).getCurrentAccountUin();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      for (;;)
      {
        String str;
        for (;;)
        {
          localObject9 = (ajtg)((QQAppInterface)localObject8).a(20);
          if (localObject9 != null) {
            ((ajtg)localObject9).j((String)localObject5);
          }
          if ((localObject6 != null) && (localObject1 != null)) {
            ((TroopManager)localObject6).e((TroopInfo)localObject1);
          }
          if (!(localObject8 instanceof QQAppInterface)) {
            break;
          }
          this.a.a(19, (Bundle)localObject7);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          l1 = ((Bundle)localObject7).getLong("troopCode");
          localObject1 = ((Bundle)localObject7).getString("filePath");
          localObject5 = ((Bundle)localObject7).getString("fileName");
          l2 = ((Bundle)localObject7).getLong("fileSize");
          i = ((Bundle)localObject7).getInt("busid");
          localObject1 = azjg.a((QQAppInterface)localObject8, l1, null, (String)localObject1, (String)localObject5, l2, i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
          if (!TextUtils.isEmpty(((Bundle)localObject7).getString("callback"))) {
            ((Bundle)localObject5).putString("callback", ((Bundle)localObject7).getString("callback"));
          }
          ((Bundle)localObject5).putString("method", "getFileInfo");
          TroopMemberApiService.a(this.a, (QQAppInterface)localObject8, l1, HWTroopFileStatusInfo.parse((ayqd)localObject1), (Bundle)localObject5);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Rrw == null) {
            this.a.jdField_a_of_type_Rrw = new rrw(this.a, (QQAppInterface)localObject8);
          }
          if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Rrw.a((Bundle)localObject7);
            break;
          }
          this.a.jdField_a_of_type_Rrw.c((Bundle)localObject7);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Rrw == null) {
            this.a.jdField_a_of_type_Rrw = new rrw(this.a, (QQAppInterface)localObject8);
          }
          if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Rrw.b((Bundle)localObject7);
            break;
          }
          this.a.jdField_a_of_type_Rrw.d((Bundle)localObject7);
          break;
          if (this.a.jdField_a_of_type_Rrw == null) {
            break;
          }
          this.a.jdField_a_of_type_Rrw.a();
          break;
          this.a.d = ((Bundle)localObject7).getInt("appId");
          this.a.e = ((Bundle)localObject7).getInt("seq");
          if (this.a.d == 0) {
            break;
          }
          localObject1 = (azhi)((AppRuntime)localObject8).getManager(109);
          if (localObject1 == null) {
            break;
          }
          localObject5 = new ArrayList();
          if ((((azhi)localObject1).a(0)) && (!((azhi)localObject1).b(0)))
          {
            localObject6 = ((azhi)localObject1).a(false, 0);
            if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
            {
              localObject6 = ((List)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (TroopAIOAppInfo)((Iterator)localObject6).next();
                ((ArrayList)localObject5).add(Integer.valueOf(((TroopAIOAppInfo)localObject7).appid));
                if (((TroopAIOAppInfo)localObject7).appid == this.a.d)
                {
                  bbmy.a(BaseApplication.getContext(), 2, 2131654502, 0).b(this.a.getResources().getDimensionPixelSize(2131167766));
                  return;
                }
              }
            }
            ((ArrayList)localObject5).add(Integer.valueOf(this.a.d));
            localObject6 = new ArrayList();
            ((ArrayList)localObject6).add(Integer.valueOf(this.a.d));
            ((azhi)localObject1).a((ArrayList)localObject5, (ArrayList)localObject6);
            break;
          }
          this.a.jdField_a_of_type_Boolean = true;
          ((azhi)localObject1).a(true, 0);
          break;
          l1 = ((Bundle)localObject7).getLong("roomid", 0L);
          localObject1 = ((Bundle)localObject7).getString("roomname");
          localObject5 = ((Bundle)localObject7).getString("userdata");
          localObject6 = ((Bundle)localObject7).getString("vasname");
          i = ((Bundle)localObject7).getInt("fromid", 0);
          ((aqpp)((QQAppInterface)localObject8).getManager(108)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
          break;
          localObject1 = ((Bundle)localObject7).getString("appType");
          localObject5 = ((Bundle)localObject7).getString("openType");
          localObject6 = ((Bundle)localObject7).getString("uri");
          localObject9 = ((Bundle)localObject7).getString("action");
          str = ((Bundle)localObject7).getString("pluginPackageName");
          localObject7 = ((Bundle)localObject7).getString("pluginParams");
          aqlw.a((QQAppInterface)localObject8, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject9, str, (String)localObject7);
          break;
          localObject1 = ((Bundle)localObject7).getString("pluginPackageName");
          localObject5 = ((Bundle)localObject7).getString("appType");
          aqln.a(((QQAppInterface)localObject8).getApp(), (String)localObject1, (String)localObject5).a();
          break;
          try
          {
            l1 = ((Bundle)localObject7).getLong("troopPubAccountUin");
            localObject1 = ((Bundle)localObject7).getLongArray("troopUinList");
            if ((localObject1 == null) || (localObject1.length <= 0)) {
              break;
            }
            localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
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
        break label700;
        Object localObject2 = ((Bundle)localObject7).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
        if (localObject5 == null) {
          break label700;
        }
        localObject2 = ((TroopManager)localObject5).b((String)localObject2);
        if (localObject2 == null) {
          break label700;
        }
        ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
        ((TroopManager)localObject5).b((TroopInfo)localObject2);
        break label700;
        localObject2 = ((Bundle)localObject7).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
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
            ((Bundle)localObject7).putBoolean("hasOrgs", bool);
            this.a.a(46, (Bundle)localObject7);
            break label700;
            bool = false;
            continue;
            localObject2 = ((Bundle)localObject7).getString("localFilePath");
            localObject5 = ((Bundle)localObject7).getString("fileDisPlayName");
            azgh.a(this.a, (String)localObject2, (String)localObject5);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            i = ((Bundle)localObject7).getInt("rewardMoney");
            localObject5 = ((Bundle)localObject7).getString("rewardContent");
            localObject6 = ((Bundle)localObject7).getString("mediaPath");
            j = ((Bundle)localObject7).getInt("rewardType");
            azko.jdField_a_of_type_Int = ((Bundle)localObject7).getInt("imageMaxWidthPixels", 1080);
            azko.b = ((Bundle)localObject7).getInt("imageMaxHeightPixels", 1920);
            ((azko)((AppRuntime)localObject8).getManager(152)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
            break label700;
            ((ajtg)localObject2).a(((Bundle)localObject7).getLong("troopUin"), ((Bundle)localObject7).getInt("flag"));
            break label700;
            localObject2 = (QQAppInterface)localObject8;
            ((Bundle)localObject7).putInt("fontSize", QQAppInterface.b);
            this.a.a(52, (Bundle)localObject7);
            break label700;
            i = ((Bundle)localObject7).getInt("fontSize", 1);
            localObject2 = (QQAppInterface)localObject8;
            QQAppInterface.b = i;
            ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            localObject5 = ((Bundle)localObject7).getString("rewardId");
            localObject5 = ((azko)((AppRuntime)localObject8).getManager(152)).a((String)localObject2, (String)localObject5);
            localObject2 = "";
            if (localObject5 != null) {
              localObject2 = ((MessageForTroopReward)localObject5).mediaPath;
            }
            ((Bundle)localObject7).putString("videoPath", (String)localObject2);
            this.a.a(55, (Bundle)localObject7);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            localObject5 = ((Bundle)localObject7).getString("largeImageFile");
            localObject6 = ((Bundle)localObject7).getString("fileName");
            l1 = ((Bundle)localObject7).getLong("progressTotal");
            i = ((Bundle)localObject7).getInt("busId");
            TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            localObject5 = ((Bundle)localObject7).getString("filePath");
            localObject6 = ((Bundle)localObject7).getString("fileName");
            i = ((Bundle)localObject7).getInt("size");
            j = ((Bundle)localObject7).getInt("busId");
            TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, j, i);
            break label700;
            localObject5 = (TroopPluginManager)((AppRuntime)localObject8).getManager(119);
            localObject6 = ((Bundle)localObject7).getString("troopUin");
            i = ((Bundle)localObject7).getInt("seq");
            localObject7 = ((Bundle)localObject7).getString("processName");
            if (localObject5 == null) {
              break label700;
            }
            ((TroopPluginManager)localObject5).a("troop_manage_plugin.apk", new wjo(this, (ajtg)localObject2, (String)localObject6, i, (String)localObject7));
            break label700;
            localObject2 = ((Bundle)localObject7).getString("appid");
            localObject5 = ((Bundle)localObject7).getString("pkgname");
            this.a.a((String)localObject5, (String)localObject2);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("hashName");
            ((Bundle)localObject7).putByteArray("decryptResult", PreloadManager.a().b((String)localObject2));
            this.a.a(66, (Bundle)localObject7);
            break label700;
            ((ajtg)localObject2).a(((Bundle)localObject7).getString("troopUin"), "", ((Bundle)localObject7).getInt("statOption"), ((Bundle)localObject7).getString("authKey"), null, null, null);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("groupCode");
            localObject5 = ((Bundle)localObject7).getString("groupMemberUin");
            i = ((Bundle)localObject7).getInt("seq");
            ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (TroopManager)((AppRuntime)localObject8).getManager(52), (String)localObject2, (String)localObject5, (Bundle)localObject7, i), 8, null, true);
            break label700;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
            localObject5 = ((bato)((AppRuntime)localObject8).getManager(47)).a(1);
            localObject6 = new File(asdd.jdField_a_of_type_JavaLangString + File.separator + "nearby_heart.mp4");
            if (!((File)localObject6).exists()) {
              ((File)localObject6).mkdirs();
            }
            for (;;)
            {
              ((batr)localObject5).a(new batm("http://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject6), new wjp(this, (Bundle)localObject2), new Bundle());
              break;
              ((File)localObject6).delete();
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
            bool = false;
            if ((localObject8 instanceof QQAppInterface))
            {
              localObject5 = (QQAppInterface)localObject8;
              if ((!((QQAppInterface)localObject5).c()) || (((QQAppInterface)localObject5).a().k())) {
                break label5566;
              }
            }
            label5566:
            for (bool = true;; bool = false)
            {
              ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
              this.a.a(84, (Bundle)localObject2);
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
            if ((localObject8 instanceof QQAppInterface))
            {
              localObject6 = (azgp)((AppRuntime)localObject8).getManager(224);
              if (localObject6 != null)
              {
                localObject5 = ((azgp)localObject6).a();
                localObject6 = ((azgp)localObject6).b();
                ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject5);
                ((Bundle)localObject2).putString("title", (String)localObject6);
              }
            }
            this.a.a(76, (Bundle)localObject2);
            break label700;
            if (!(localObject8 instanceof QQAppInterface)) {
              break label700;
            }
            bool = awlw.a((QQAppInterface)localObject8, BaseApplicationImpl.getContext());
            if (!QLog.isColorLevel()) {
              break label700;
            }
            QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("packageName");
            localObject5 = ((Bundle)localObject7).getString("pluginId");
            localObject6 = ((Bundle)localObject7).getString("versionCode");
            mrl.a().a((String)localObject2, (String)localObject5, (String)localObject6);
            mrl.a().a((QQAppInterface)localObject8);
            ((Bundle)localObject7).putInt("state", mrk.jdField_a_of_type_Int);
            ((Bundle)localObject7).putString("version", mrk.jdField_a_of_type_JavaLangString);
            ((Bundle)localObject7).putLong("size", mrk.jdField_a_of_type_Long);
            this.a.a(78, (Bundle)localObject7);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("via");
            localObject5 = ((Bundle)localObject7).getString("startParam");
            i = ((Bundle)localObject7).getInt("action");
            mrl.a().a((String)localObject2, i, (String)localObject5, new wjq(this, (Bundle)localObject7, i));
            break label700;
            ((Bundle)localObject7).putInt("currentFragment", SplashActivity.jdField_a_of_type_Int);
            this.a.a(80, (Bundle)localObject7);
            break label700;
            localObject2 = (qjf)((AppRuntime)localObject8).getManager(226);
            ((qjf)localObject2).a(this.a);
            ((qjf)localObject2).a(((Bundle)localObject7).getString("videoPath"), (Bundle)localObject7);
            break label700;
            i = ((Bundle)localObject7).getInt("subCmd");
            localObject2 = (ayrg)((QQAppInterface)localObject8).getManager(231);
            switch (i)
            {
            }
            for (;;)
            {
              this.a.a(87, (Bundle)localObject7);
              break;
              ((ayrg)localObject2).a(((Bundle)localObject7).getInt("effectId"), ((Bundle)localObject7).getString("effectName"), ((Bundle)localObject7).getInt("svipLevel"), ((Bundle)localObject7).getInt("svipType"));
              continue;
              localObject5 = ((Bundle)localObject7).getStringArrayList("statusList");
              if (localObject5 != null) {
                ((ayrg)localObject2).a((ArrayList)localObject5);
              }
            }
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            localObject5 = ((Bundle)localObject7).getString("path");
            i = ((Bundle)localObject7).getInt("msgTailType", 0);
            localObject6 = new Intent();
            ((Intent)localObject6).putExtra("send_in_background", true);
            ((Intent)localObject6).putExtra("file_send_path", (String)localObject5);
            ((Intent)localObject6).putExtra("file_send_size", new File((String)localObject5).length());
            ((Intent)localObject6).putExtra("file_send_duration", ShortVideoUtils.b((String)localObject5));
            ((Intent)localObject6).putExtra("uin", (String)localObject2);
            ((Intent)localObject6).putExtra("uintype", 1);
            ((Intent)localObject6).putExtra("file_source", "album_flow");
            ((Intent)localObject6).putExtra("short_video_msg_tail_type", i);
            new ahui((Intent)localObject6).execute(new Void[0]);
            this.a.a(87, (Bundle)localObject7);
            break label700;
            l1 = ((Bundle)localObject7).getLong("roomId");
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("jumpType", 1);
            ((Bundle)localObject2).putString("roomid", String.valueOf(l1));
            ((aqod)((AppRuntime)localObject8).getManager(306)).a((Bundle)localObject2);
            break label700;
            ((aqod)((AppRuntime)localObject8).getManager(306)).a();
            break label700;
            if (this.a.jdField_b_of_type_Boolean) {
              break;
            }
            this.a.jdField_b_of_type_Boolean = true;
            bool = badq.g(null);
            VideoEnvironment.a("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
            if (bool)
            {
              VideoEnvironment.a("TroopMemberApiService", ajjy.a(2131649850), null);
              ShortVideoResourceManager.a((QQAppInterface)localObject8, new wjr(this, (AppRuntime)localObject8, (Bundle)localObject7));
              break label700;
            }
            ((Bundle)localObject7).putInt("result", -1);
            this.a.a(93, (Bundle)localObject7);
            break label700;
            i = ((Bundle)localObject7).getInt("isGroupCode");
            localObject2 = ((Bundle)localObject7).getString("roomId");
            localObject5 = ((Bundle)localObject7).getString("action");
            localObject6 = ((Bundle)localObject7).getString("fromId");
            localObject9 = ((Bundle)localObject7).getString("backType");
            str = ((Bundle)localObject7).getString("openType");
            localObject7 = ((Bundle)localObject7).getString("extra");
            ((aqkz)((AppRuntime)localObject8).getManager(236)).a(this.a, (String)localObject2, ((QQAppInterface)localObject8).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject9, str, (String)localObject7);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("uin");
            i = ((Bundle)localObject7).getInt("index");
            localObject2 = myd.a().a((String)localObject2);
            if (localObject2 == null) {
              break label700;
            }
            localObject5 = (myh)((AppRuntime)localObject8).getManager(238);
            if (localObject5 == null) {
              break label700;
            }
            ((myh)localObject5).a((mxu)localObject2, i);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopCode");
            localObject5 = ((Bundle)localObject7).getString("uin");
            localObject6 = ((Bundle)localObject7).getString("nick");
            localObject7 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject7 == null) {
              break label700;
            }
            ((ajkc)localObject7).a((String)localObject2, (String)localObject5, (String)localObject6);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopCode");
            localObject5 = ((Bundle)localObject7).getString("uin");
            localObject6 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject6 == null) {
              break label700;
            }
            ((ajkc)localObject6).a((String)localObject2, (String)localObject5);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopCode");
            localObject5 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject5 == null) {
              break label700;
            }
            ((ajkc)localObject5).a((String)localObject2);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopCode");
            localObject5 = ((Bundle)localObject7).getString("uin");
            localObject6 = ((Bundle)localObject7).getString("nick");
            localObject7 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject7 == null) {
              break label700;
            }
            ((ajkc)localObject7).b((String)localObject2, (String)localObject5, (String)localObject6);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("troopCode");
            localObject5 = ((Bundle)localObject7).getString("uin");
            localObject6 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject6 == null) {
              break label700;
            }
            ((ajkc)localObject6).b((String)localObject2, (String)localObject5);
            break label700;
            ((Bundle)localObject7).getString("troopCode");
            localObject2 = ((Bundle)localObject7).getString("rid");
            localObject5 = new wjt(this, (Bundle)localObject7);
            this.a.jdField_a_of_type_Ajkr = new ajkr((QQAppInterface)localObject8, (ajks)localObject5, (String)localObject2);
            this.a.jdField_a_of_type_Ajkr.b(10000L);
            break label700;
            this.a.f = ((Bundle)localObject7).getInt("seq", -1);
            localObject2 = ((Bundle)localObject7).getStringArrayList("tinyIdList");
            localObject5 = (ajkc)((QQAppInterface)localObject8).a(35);
            if (localObject5 == null) {
              break label700;
            }
            ((ajkc)localObject5).a((ArrayList)localObject2);
            break label700;
            localObject2 = ((Bundle)localObject7).getString("schoolName");
            i = ((Bundle)localObject7).getInt("isValid");
            localObject5 = (asft)((QQAppInterface)localObject8).a(60);
            if (localObject5 == null) {
              break label700;
            }
            ((asft)localObject5).a((String)localObject2, i);
            break label700;
            localObject2 = ((Bundle)localObject7).getStringArrayList("preloadList");
            localObject5 = (nau)((AppRuntime)localObject8).getManager(248);
            if (localObject5 == null) {
              break label700;
            }
            ((nau)localObject5).a((ArrayList)localObject2);
            break label700;
            localObject2 = (nau)((AppRuntime)localObject8).getManager(248);
            if (localObject2 == null) {
              break label700;
            }
            ((nau)localObject2).a();
            break label700;
            i = ((Bundle)localObject7).getInt("topicId");
            j = ((Bundle)localObject7).getInt("followInfo");
            if (ogy.a().a(i, j)) {
              break label700;
            }
            ogy.a().d(i, j);
            break label700;
            ((Bundle)localObject7).putInt("readinjoy_to_wx_config", bgmq.t((AppRuntime)localObject8));
            this.a.a(113, (Bundle)localObject7);
            break label700;
            if (this.a.jdField_a_of_type_Ore == null) {
              this.a.jdField_a_of_type_Ore = new ore((AppRuntime)localObject8, this.a);
            }
            this.a.jdField_a_of_type_Ore.b((Bundle)localObject7);
            break label700;
            ((sfz)((QQAppInterface)localObject8).a(98)).c(((Bundle)localObject7).getInt("reqUserSetEnableAlbumScan"));
            break label700;
            if (this.a.jdField_a_of_type_Ore == null) {
              this.a.jdField_a_of_type_Ore = new ore((AppRuntime)localObject8, this.a);
            }
            this.a.jdField_a_of_type_Ore.c((Bundle)localObject7);
            break label700;
            if (this.a.jdField_a_of_type_Ore == null) {
              this.a.jdField_a_of_type_Ore = new ore((AppRuntime)localObject8, this.a);
            }
            this.a.jdField_a_of_type_Ore.d((Bundle)localObject7);
            break label700;
            if (this.a.jdField_a_of_type_Ore == null) {
              this.a.jdField_a_of_type_Ore = new ore((AppRuntime)localObject8, this.a);
            }
            this.a.jdField_a_of_type_Ore.a((Bundle)localObject7);
            break label700;
            this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject7).getString("callback");
            this.a.g = ((Bundle)localObject7).getInt("seq");
            localObject5 = ((Bundle)localObject7).getString("troopUin");
            localObject6 = ((Bundle)localObject7).getString("chatType");
            if ((!TextUtils.isEmpty((CharSequence)localObject5)) && ("group".equals(localObject6)))
            {
              if (localObject2 == null) {
                break label700;
              }
              ((ajtg)localObject2).a((String)localObject5, false, "TroopMemberApiService111", true, true, false, false);
              break label700;
            }
            if (QLog.isColorLevel()) {
              QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject5 + ", chatType=" + (String)localObject6);
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("isSuccess", false);
            ((Bundle)localObject2).putInt("seq", this.a.g);
            ((Bundle)localObject2).putString("callback", this.a.jdField_c_of_type_JavaLangString);
            this.a.a(112, (Bundle)localObject2);
            break label700;
            localObject2 = new Intent(((QQAppInterface)localObject8).getApp().getApplicationContext(), SplashActivity.class);
            ((Intent)localObject2).putExtras((Bundle)localObject7);
            localObject2 = aciy.a((Intent)localObject2, null);
            localObject5 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a((QQAppInterface)localObject8, ((QQAppInterface)localObject8).getApp().getApplicationContext(), (SessionInfo)localObject5, (Intent)localObject2);
            break label700;
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
            }
            localObject2 = ((Bundle)localObject7).getString("troopUin");
            localObject5 = ((Bundle)localObject7).getString("type");
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject5)) || (azgh.a((QQAppInterface)localObject8, (String)localObject2) == 0)) {
              break label700;
            }
            azgh.a((QQAppInterface)localObject8, (String)localObject2);
            break label700;
            l1 = ((Bundle)localObject7).getLong("followUin");
            i = ((Bundle)localObject7).getInt("followInfo");
            if ((i != 2) && (i != 1)) {
              break label700;
            }
            localObject2 = ohb.a();
            if (i == 2) {}
            for (bool = true;; bool = false)
            {
              ((ohb)localObject2).b(l1, bool);
              ThreadManager.post(new TroopMemberApiService.IncomingHandler.9(this, l1, i), 8, null, true);
              break;
            }
            localObject5 = ((Bundle)localObject7).getString("url");
            i = ((Bundle)localObject7).getInt("type", -1);
            j = ((Bundle)localObject7).getInt("msgfrom", 0);
            localObject6 = ((Bundle)localObject7).getString("senderUin");
            localObject9 = ((Bundle)localObject7).getString("chatId");
            str = ((Bundle)localObject7).getString("source");
            k = ((Bundle)localObject7).getInt("seq");
            localObject2 = ((Bundle)localObject7).getString("processName");
            localObject7 = ((Bundle)localObject7).getString("originUrl");
            localObject8 = (baxz)((AppRuntime)localObject8).getManager(290);
            if (localObject8 != null)
            {
              ((baxz)localObject8).a((String)localObject5, i, j, (String)localObject6, (String)localObject9, str, (String)localObject7, new wjm(this, k, (String)localObject2));
              break label700;
            }
            localObject5 = new Bundle();
            ((Bundle)localObject5).putInt("seq", k);
            ((Bundle)localObject5).putString("processName", (String)localObject2);
            this.a.a(119, (Bundle)localObject5);
            break label700;
            try
            {
              localObject2 = (baxz)((AppRuntime)localObject8).getManager(290);
              if (localObject2 == null) {
                break label8038;
              }
              ((baxz)localObject2).a((Bundle)localObject7);
            }
            catch (Throwable localThrowable)
            {
              QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
            }
          }
          break label700;
          label8038:
          if (!QLog.isColorLevel()) {
            break label700;
          }
          QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
          break label700;
          Object localObject3 = (baxz)((AppRuntime)localObject8).getManager(290);
          localObject5 = ((Bundle)localObject7).getString("appid");
          localObject6 = ((Bundle)localObject7).getString("openid");
          localObject8 = ((Bundle)localObject7).getString("troopuin");
          i = ((Bundle)localObject7).getInt("seq");
          localObject7 = ((Bundle)localObject7).getString("processName");
          if (localObject3 != null)
          {
            ((baxz)localObject3).a((String)localObject5, (String)localObject6, (String)localObject8, new wjn(this, i, (String)localObject7));
            break label700;
          }
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("seq", i);
          ((Bundle)localObject3).putString("processName", (String)localObject7);
          ((Bundle)localObject3).putInt("result", -1);
          this.a.a(144, (Bundle)localObject3);
          break label700;
          ((Bundle)localObject7).putString("nickName", ((QQAppInterface)localObject8).getCurrentNickname());
          this.a.a(126, (Bundle)localObject7);
          break label700;
          if (BaseActivity.sTopActivity != null) {}
          for (localObject3 = BaseActivity.sTopActivity;; localObject3 = this.a.getApplicationContext())
          {
            KandianSubscribeManager.a((Context)localObject3, 3, 4);
            break;
          }
          if (BaseActivity.sTopActivity != null) {}
          for (localObject3 = BaseActivity.sTopActivity;; localObject4 = this.a.getApplicationContext())
          {
            for (;;)
            {
              if (!bgmq.k()) {
                break label8367;
              }
              j = 12;
              try
              {
                localObject5 = ((Bundle)localObject7).getString("from");
                i = j;
                if (!TextUtils.isEmpty((CharSequence)localObject5))
                {
                  i = j;
                  if (TextUtils.isDigitsOnly((CharSequence)localObject5)) {
                    i = Integer.valueOf((String)localObject5).intValue();
                  }
                }
                ((Context)localObject3).startActivity(nji.a((Context)localObject3, i));
              }
              catch (Exception localException2) {}
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
            break;
          }
          label8367:
          localObject5 = (QQAppInterface)localObject8;
          if (bgmq.a((QQAppInterface)localObject5))
          {
            nji.a((QQAppInterface)localObject5, (Context)localObject4, 2, 0);
            break label700;
          }
          nji.a((Context)localObject4, null, -1L, 2);
          break label700;
          i = ((Bundle)localObject7).getInt("seq");
          localObject4 = (QQAppInterface)localObject8;
          localObject5 = ((ajjj)((AppRuntime)localObject8).getManager(51)).b(((QQAppInterface)localObject4).c());
          if (localObject5 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberApiService", 2, "get user gender:" + ((Card)localObject5).shGender);
            }
            ((Bundle)localObject7).putShort("gender", ((Card)localObject5).shGender);
          }
          ((Bundle)localObject7).putString("facePath", ((QQAppInterface)localObject4).a(1, ((QQAppInterface)localObject4).getCurrentAccountUin(), 0));
          ((Bundle)localObject7).putInt("seq", i);
          this.a.a(124, (Bundle)localObject7);
          break label700;
          i = ((Bundle)localObject7).getInt("start");
          j = ((Bundle)localObject7).getInt("msgType");
          int k = ((Bundle)localObject7).getInt("count");
          localObject4 = axzv.a(this.a.getApplicationContext(), (QQAppInterface)localObject8, i, j, k);
          if (localObject4 != null) {
            ((Bundle)localObject7).putString("sayhiinfo", ((JSONObject)localObject4).toString());
          }
          this.a.a(127, (Bundle)localObject7);
          break label700;
          i = ((Bundle)localObject7).getInt("clearType");
          j = ((Bundle)localObject7).getInt("msgType");
          localObject4 = ((Bundle)localObject7).getString("uin");
          axzv.a((QQAppInterface)localObject8, (String)localObject4, i, j);
          break label700;
          i = ((Bundle)localObject7).getInt("deleteType");
          localObject4 = ((Bundle)localObject7).getString("uin");
          j = ((Bundle)localObject7).getInt("msgType");
          axzv.b((QQAppInterface)localObject8, (String)localObject4, i, j);
          break label700;
          bool = ((Bundle)localObject7).getBoolean("isSuccess");
          localObject4 = ((Bundle)localObject7).getString("pkgname");
          ohb.a().a(null, 101, bool, new String[] { localObject4 });
          break label700;
          localObject4 = npt.a(2);
          if ((localObject4 == null) || (!(localObject4 instanceof nmy))) {
            break label700;
          }
          ((nmy)localObject4).a((Bundle)localObject7);
          break label700;
          npj.a();
          break label700;
          a((Bundle)localObject7);
          this.a.a(139, (Bundle)localObject7);
          break label700;
          localObject4 = ((Bundle)localObject7).getString("uin");
          wen.b(BaseApplicationImpl.getContext(), (String)localObject4, null);
          break label700;
          if (BaseActivity.sTopActivity != null) {}
          for (localObject4 = BaseActivity.sTopActivity; localObject4 != null; localObject4 = this.a.getApplicationContext())
          {
            KandianDailyManager.a((Context)localObject4);
            break;
          }
          bool = ((Bundle)localObject7).getBoolean("isOpen");
          localObject4 = ((Bundle)localObject7).getString("troopUin");
          if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject4, Boolean.valueOf(bool) }));
          }
          ((azcd)((AppRuntime)localObject8).getManager(346)).a((String)localObject4, bool);
          break label700;
          bool = false;
        }
        continue;
        Object localObject4 = null;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wjk
 * JD-Core Version:    0.7.0.1
 */