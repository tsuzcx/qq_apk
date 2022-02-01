import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req_Comm;
import com.hiboom.protocol.DiyEmotionPb.Filter_Rsp;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Rsp;
import com.tencent.IndividPub.IndividPub.Platform_Comm_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp;
import com.tencent.IndividPub.IndividPub.expTips_Req;
import com.tencent.IndividPub.IndividPub.expTips_Rsp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.ReportInfoManager.ReportChannlInfo;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitItem;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitReq;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.Gift;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoReq;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoRsp;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Req;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Rsp;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.b;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler.1;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.GetUrlRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.QuickUpdateRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SCPreloadOrReport;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SyncVCRRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.VCR;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueReq;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueRsp;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
import com.tencent.pb.apollo.STExploreInfo.STEntryIdInfo;
import com.tencent.pb.apollo.STExploreInfo.STEntryIdMsg;
import com.tencent.pb.apollo.STExploreInfo.STGetMsgReq;
import com.tencent.pb.apollo.STExploreInfo.STGetMsgRsp;
import com.tencent.pb.apollo.STExploreInfo.STMsgInfo;
import com.tencent.pb.apollo.STGameLogin.STGameLoginReq;
import com.tencent.pb.apollo.STGameLogin.STGetGameConfReq;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.pb.gamecenter.MonitReport.MonitReportReq;
import com.tencent.pb.gamecenter.MonitReport.PublicAccountReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonRsp;
import com.tencent.pb.pendantMarket.PendantMarket.TipsInfo;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlReq;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlRsp;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB.SCPreload;
import com.tencent.pb.scupdate.SCUpdatePB.SCReport;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReq;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReqComm;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRsp;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRspComm;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRReq;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRRsp;
import com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import com.tencent.util.Pair;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STGameStateMsgList;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReadReq;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReadRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReq;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPUsrInfo;
import tencent.im.oidb.qqshop.qqshop_code.SReq;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import tencent.qun.group_effect.group_effect_commu.ReqBody;
import tencent.qun.group_effect.group_effect_commu.RspBody;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyReq0x2000;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyRsp0x2000;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectReq0x2;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class aqrb
  extends accg
{
  public static String TAG = "VasExtensionHandler";
  private static long atH;
  public static String cwl = "Addon.Set";
  public static String cwm = "IndividPub.ExpTips";
  public static String cwn = "SyncVCRReq";
  public static String cwo = "SyncVCRRsp";
  public static String cwp = "GetUrlReq";
  public static String cwq = "GetUrlRsp";
  private List<aqrb.b> IY = new ArrayList();
  private Vector<Long> S = new Vector();
  long atG = 0L;
  public PraiseManager.b b;
  public int ecj;
  public int eck;
  private WeakReference<aqrb.a> it;
  public Bundle mReqBundle;
  
  public aqrb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void C(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleSetUserFlagResponse]");
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("data");
      if (paramIntent != null)
      {
        Object localObject = new WebSSOAgent.UniSsoServerReq();
        try
        {
          ((WebSSOAgent.UniSsoServerReq)localObject).mergeFrom(paramIntent);
          paramIntent = new JSONObject(((WebSSOAgent.UniSsoServerReq)localObject).reqdata.get());
          if (paramIntent.has("flagInfo"))
          {
            paramIntent = paramIntent.getJSONArray("flagInfo");
            if (paramIntent != null)
            {
              i = 0;
              int j = paramIntent.length();
              while (i < j)
              {
                localObject = paramIntent.getJSONObject(i);
                if (localObject != null) {
                  localHashMap.put(Integer.valueOf(((JSONObject)localObject).optInt("type")), Integer.valueOf(((JSONObject)localObject).optInt("value")));
                }
                i += 1;
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label193;
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e(TAG, 1, "[handleSetUserFlagResponse] get request data exception=", paramIntent);
        }
      }
    }
    QLog.d(TAG, 2, new Object[] { "[handleSetUserFlagResponse] flagSettingMap=", localHashMap });
    label193:
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      long l;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        l = paramIntent.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleSetUserFlagResponse] ret=", Long.valueOf(l) });
        }
        if ((l != 0L) || (!localHashMap.containsKey(Integer.valueOf(16)))) {
          break label517;
        }
        i = ((Integer)localHashMap.get(Integer.valueOf(16))).intValue();
        paramIntent = (abhh)this.app.getManager(153);
        paramFromServiceMsg = paramIntent.b(this.app.getCurrentAccountUin());
        if ((paramFromServiceMsg == null) || ((paramFromServiceMsg.apolloAISwitch & 0x10) == i << 4)) {
          break label517;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleSetUserFlagResponse] before update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
        }
        paramFromServiceMsg.apolloAISwitch = (paramFromServiceMsg.apolloAISwitch & 0xFFFFFFEF | paramFromServiceMsg.apolloAISwitch ^ 0x10);
        paramIntent.a(paramFromServiceMsg);
        if (!QLog.isColorLevel()) {
          break label517;
        }
        QLog.d(TAG, 2, new Object[] { "[handleSetUserFlagResponse] after update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "[handleSetUserFlagResponse] exception=", paramIntent);
        notifyUI(22, false, localHashMap);
        return;
      }
      notifyUI(22, bool, localHashMap);
      return;
      boolean bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, new Object[] { "[handleSetUserFlagResponse] failed, result code=", Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      }
      notifyUI(22, false, null);
      return;
      label517:
      if (0L == l) {
        bool = true;
      }
    }
  }
  
  private void G(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramIntent.getIntExtra("id", -1));
    localBundle.putString("name", paramIntent.getStringExtra("name"));
    localBundle.putString("minVersion", paramIntent.getStringExtra("minVersion"));
    localBundle.putInt("feeType", paramIntent.getIntExtra("feeType", 0));
    localBundle.putInt("fromType", paramIntent.getIntExtra("fromType", 0));
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l = paramIntent.ret.get();
        paramIntent = paramIntent.errmsg.get();
        if (l == 0L)
        {
          notifyUI(23, true, localBundle);
          return;
        }
        localBundle.putLong("result", l);
        localBundle.putString("msg", paramIntent);
        QLog.e(TAG, 1, "handlePokeAuthResp failed " + paramIntent);
      }
      catch (Exception paramIntent)
      {
        localBundle.putInt("result", -254);
        localBundle.putString("msg", acfp.m(2131716312));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "handlePokeAuthResp failed ", paramIntent);
        continue;
      }
      notifyUI(23, false, localBundle);
      return;
      localBundle.putInt("result", -255);
      localBundle.putString("msg", acfp.m(2131716313));
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "handlePokeAuthResp fail ret: " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  private void L(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
      QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD fail data = " + paramArrayOfByte + " errorcode = " + paramFromServiceMsg.getResultCode() + " ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq());
    }
    long l;
    do
    {
      for (;;)
      {
        return;
        paramFromServiceMsg = new group_effect_commu.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          l = paramIntent.getLongExtra("usrdata", 0L);
          if (paramFromServiceMsg.ret.get() != 0) {
            break label357;
          }
          paramIntent = (apdr)this.app.getManager(231);
          if (l == 8192L)
          {
            paramFromServiceMsg = (group_effect_commu.TEntryNotifyRsp0x2000)paramFromServiceMsg.st_entry_notify.get();
            if (paramFromServiceMsg != null)
            {
              paramArrayOfByte = (group_effect_commu.TEffectDetail)paramFromServiceMsg.st_userconfig.get();
              paramIntent.arc = (paramFromServiceMsg.notify_interval.get() * 1000);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectCMD ENTER_GROUP success notifyInteval = " + paramIntent.arc);
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD error: " + paramIntent.getMessage());
          return;
        }
      }
    } while (l != 2L);
    paramFromServiceMsg = (group_effect_commu.TGetMyEffectRsp0x2)paramFromServiceMsg.st_get_effect.get();
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.ret.get() != 0)
      {
        QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect fail");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectCMD getMyEffect success");
      }
      paramArrayOfByte = new apdh.a();
      paramArrayOfByte.a(paramFromServiceMsg);
      paramIntent.a(paramArrayOfByte);
      paramIntent.b(paramFromServiceMsg);
      aqmj.u(this.app.getApplication(), this.app.getCurrentAccountUin(), System.currentTimeMillis());
      notifyUI(26, true, null);
      return;
    }
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect rsp is null");
    return;
    label357:
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD error cmd = " + l + " ret = " + paramFromServiceMsg.ret.get());
  }
  
  private void M(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleApolloGameLoginReq] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          if (this.app != null)
          {
            ((abhe)this.app.getManager(211)).i(paramIntent.ret.get(), paramIntent.pbRsqData.get().toByteArray());
            return;
          }
          QLog.e(TAG, 1, "[handleApolloGameLoginReq] app is null");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "[handleApolloGameLoginReq] exception=", paramIntent);
        return;
      }
      QLog.e(TAG, 1, new Object[] { "[handleApolloGameLoginReq] failed ret:", Long.valueOf(paramIntent.ret.get()) });
      return;
    }
    QLog.e(TAG, 1, "[handleApolloGameLoginReq] failed");
  }
  
  private void N(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleGameConfigListReq] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          if (this.app != null)
          {
            ((abhe)this.app.getManager(211)).a(paramFromServiceMsg.ret.get(), paramFromServiceMsg.pbRsqData.get().toByteArray(), paramIntent.getBundleExtra("extras"));
            return;
          }
          QLog.e(TAG, 1, "[handleGameConfigListReq] app is null");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "[handleGameConfigListReq] exception=", paramIntent);
        return;
      }
      QLog.e(TAG, 1, new Object[] { "[handleGameConfigListReq] failed ret:", Long.valueOf(paramFromServiceMsg.ret.get()) });
      return;
    }
    QLog.e(TAG, 1, "[handleGameConfigListReq] failed");
  }
  
  private void O(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleApolloGameDevList]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleApolloGameDevList] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "[handleApolloGameDevList] respData=", paramIntent });
          }
          if ((this.mApp != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            paramFromServiceMsg = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
            paramIntent = new JSONObject(paramIntent).optJSONObject("data");
            i = paramIntent.optInt("innerUin");
            paramArrayOfByte = paramIntent.optJSONArray("gameIdList");
            paramIntent = "";
            if (paramArrayOfByte == null) {
              break label309;
            }
            paramIntent = paramArrayOfByte.toString();
            break label309;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, new Object[] { "[handleApolloGameDevList] innerUin:", Integer.valueOf(i), ",gameIdList:", paramArrayOfByte });
            }
            paramFromServiceMsg.edit().putString(this.mApp.getCurrentAccountUin() + "_" + "cmgame_sp_dev_game_list", paramIntent).commit();
          }
        }
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e(TAG, 1, "[handleApolloGameDevList] exception=", paramIntent);
        return;
      }
      label309:
      if (i == 1) {
        paramIntent = "1";
      }
    }
  }
  
  private void Q(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    label255:
    for (;;)
    {
      try
      {
        paramIntent = (DiyEmotionPb.Filter_Rsp)new DiyEmotionPb.Filter_Rsp().mergeFrom(paramArrayOfByte);
        int i;
        if (paramIntent.ret.get() == 0L)
        {
          i = 1;
          if (i == 0) {
            break label255;
          }
          bool1 = ((Boolean)paramIntent.rspcmd_0x01.is_valid.get(0)).booleanValue();
          paramIntent = new Bundle();
          if (paramFromServiceMsg.getResultCode() == 1002)
          {
            bool2 = true;
            paramIntent.putBoolean("timeout", bool2);
            paramIntent.putBoolean("legalSuccess", bool1);
            long l = SystemClock.uptimeMillis() - atH;
            anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "RichTextIllegalWordTime", bool1, l, 0L, null, "");
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "costTime:" + l + " isTimeOut:" + bool2 + " legalSuccess:" + bool1);
            }
            ((ahxs)this.app.getManager(219)).KG(bool1);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool2 = false;
        continue;
        boolean bool1 = false;
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 2, "diy handler onRecive fail err:" + paramIntent.getMessage());
        return;
      }
    }
  }
  
  private void S(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    QLog.d(TAG, 1, "handleCmGameConnInfoRsp, code=" + paramFromServiceMsg.getResultCode());
    Object localObject = null;
    paramIntent = localObject;
    if (paramArrayOfByte != null)
    {
      paramIntent = localObject;
      if (!paramFromServiceMsg.isSuccess()) {}
    }
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l = paramIntent.ret.get();
        QLog.e(TAG, 2, new Object[] { "[handleCmGameConnInfoRsp] unissoRet=", Long.valueOf(l) });
        if (l != 0L) {
          break label225;
        }
        paramFromServiceMsg = new CmGameMsgTunnel.AddrDistribueRsp();
        paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        int i = paramFromServiceMsg.port.get();
        paramIntent = new abmb.a(paramFromServiceMsg.ip_list.get(), i, paramFromServiceMsg.aes_key.get(), paramFromServiceMsg.distribute_ts.get(), paramFromServiceMsg.sign.get());
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 2, "[handleCmGameConnInfoRsp] failed ", paramIntent);
        paramIntent = localObject;
        continue;
        paramFromServiceMsg.cDb();
        return;
      }
      paramFromServiceMsg = ((abhh)this.mApp.getManager(153)).a();
      if (paramIntent != null)
      {
        paramFromServiceMsg.a(paramIntent);
        return;
      }
      label225:
      paramIntent = null;
    }
  }
  
  private void T(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG + "_apollo_store_stability_", 2, new Object[] { "[handleReportApolloStoreStabilityResp] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() != 0L) {
          QLog.e(TAG + "_apollo_store_stability_", 1, new Object[] { "[handleReportApolloStoreStabilityResp] failed ret:", Long.valueOf(paramIntent.ret.get()) });
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG + "_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] exception=", paramIntent);
        return;
      }
    }
    QLog.e(TAG + "_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] failed");
  }
  
  private void U(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleApolloSetModel; isSuccess: " + paramFromServiceMsg.isSuccess() + ", ret: " + paramFromServiceMsg.getResultCode());
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleApolloSetModel ret: " + paramFromServiceMsg.ret.get());
          }
          int i = paramIntent.getIntExtra("model", 2);
          if (paramFromServiceMsg.ret.get() == 0L)
          {
            paramIntent = (abhh)this.app.getManager(153);
            if (paramIntent != null)
            {
              paramArrayOfByte = paramIntent.b(this.app.getCurrentUin());
              int j = paramArrayOfByte.cmshow3dFlag;
              paramArrayOfByte.cmshow3dFlag = (i | paramArrayOfByte.cmshow3dFlag);
              if (paramArrayOfByte.cmshow3dFlag != j)
              {
                paramIntent.a(paramArrayOfByte);
                paramIntent.gD(j, paramArrayOfByte.cmshow3dFlag);
                paramIntent = new ArrayList();
                paramIntent.add(this.app.getCurrentUin());
                paramArrayOfByte = abrj.a(this.app);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.i(3, paramIntent);
                }
              }
            }
          }
          if (this.it.get() != null)
          {
            paramIntent = (aqrb.a)this.it.get();
            if (paramFromServiceMsg.ret.get() == 0L)
            {
              bool = true;
              paramIntent.DR(bool);
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable paramIntent)
        {
          boolean bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(TAG, 2, "", paramIntent);
          return;
        }
        bool = false;
      }
    }
    QLog.e(TAG, 2, "handleApolloSetModel fail ret: " + paramFromServiceMsg.getResultCode());
  }
  
  private void V(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handleGetArkAds] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = new JSONObject(paramIntent.rspdata.get());
        if (paramIntent != null)
        {
          paramFromServiceMsg = paramIntent.optJSONObject("12818");
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.optInt("ret", 1) == 0))
          {
            paramIntent = (anec)this.app.getManager(12);
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("data");
            if (paramFromServiceMsg != null)
            {
              paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
              if (paramFromServiceMsg != null) {
                paramIntent.a().bf(paramFromServiceMsg);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 1, "[handleGetArkAds] err:" + paramIntent.getMessage());
    }
  }
  
  private void W(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handleReportPadFaceShown] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = new JSONObject(paramIntent.rspdata.get());
        if (paramIntent != null)
        {
          paramIntent = paramIntent.optJSONObject("12827");
          if (paramIntent != null)
          {
            int i = paramIntent.optInt("ret", 1);
            if (i != 0) {
              QLog.e(TAG, 1, "[handleReportPadFaceShown] ret:" + i);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 1, "[handleReportPadFaceShown] err:" + paramIntent.getMessage());
    }
  }
  
  private void X(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleGetGameRegisterInfo] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = new JSONObject(paramIntent.rspdata.get());
          if (paramIntent != null)
          {
            paramFromServiceMsg = paramIntent.optJSONObject("12855");
            if (paramFromServiceMsg != null)
            {
              int i = paramFromServiceMsg.optInt("ret", 1);
              if (i == 0)
              {
                paramIntent = (anec)this.app.getManager(12);
                paramFromServiceMsg = paramFromServiceMsg.optJSONObject("data");
                if (paramFromServiceMsg != null)
                {
                  paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
                  if (paramFromServiceMsg != null) {
                    paramIntent.a().be(paramFromServiceMsg);
                  }
                }
              }
              else
              {
                QLog.e(TAG, 1, "[handleGetGameRegisterInfo] ret:" + i);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "[handleGetGameRegisterInfo] err:" + paramIntent.getMessage());
      }
    }
  }
  
  private void a(Long[] paramArrayOfLong, String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      JSONArray localJSONArray;
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("from", paramString);
        paramString = new JSONArray();
        localJSONArray = new JSONArray();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i].longValue();
          paramString.put(l);
          localJSONArray.put(l);
          i += 1;
        }
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("producer", Build.PRODUCT);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("cpuCount", aqgz.getCpuNumber());
      localJSONObject.put("cpuFrequency", aqgz.getCpuFrequency());
      localJSONObject.put("systemTotalMemory", aqgz.getSystemTotalMemory());
      ((JSONObject)localObject).put("deviceInfo", localJSONObject);
      ((JSONObject)localObject).put("uins", paramString);
      ((JSONObject)localObject).put("3dUins", localJSONArray);
      ((JSONObject)localObject).put("detail", 1);
      ((JSONObject)localObject).put("cmd", "apollo_core.get_avatar");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.app.getApp(), aqre.class);
      paramString.putExtra("cmd", "apollo_core.get_avatar");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("uinArr", paramArrayOfLong);
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        this.S.remove(paramArrayOfLong);
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, paramString.getMessage());
    }
  }
  
  private boolean a(PBUInt32Field paramPBUInt32Field)
  {
    return (paramPBUInt32Field.has()) && (paramPBUInt32Field.get() == 1);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleGameOnlineCountRsp]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(TAG, 1, "[handleGameOnlineCountRsp] data null or rsp failed");
      notifyUI(25, false, null);
      return;
    }
    try
    {
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handleGameOnlineCountRsp] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
      }
      if (paramFromServiceMsg.ret.get() == 0L)
      {
        paramFromServiceMsg = paramFromServiceMsg.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleGameOnlineCountRsp] respData=", paramFromServiceMsg });
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg).optJSONObject("data");
        if (paramIntent != null) {
          paramFromServiceMsg.put("tipsBarAnimation", paramIntent.getBooleanExtra("tipsBarAnimation", false));
        }
        notifyUI(25, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
      return;
    }
    notifyUI(25, false, null);
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleExpireInfoResponse");
    }
    long l2;
    try
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        QLog.e(TAG, 1, "handleExpireInfoResponse, isSuccess false, error code=" + paramFromServiceMsg.getResultCode());
        return;
      }
      paramFromServiceMsg = new IndividPub.expTips_Rsp();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l1 = paramFromServiceMsg.ret.get();
      if (l1 != 0L) {
        QLog.e(TAG, 1, "handleExpireInfoResponse, ret=" + l1 + ", error msg=" + paramFromServiceMsg.errmsg.get());
      }
      l2 = paramIntent.getIntExtra("from", 1);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleExpireInfoResponse, from=" + l2);
      }
      if (l2 == 1L)
      {
        if (l1 != 0L) {
          return;
        }
        paramObject = (IndividPub.expTips_Pull_Rsp)paramFromServiceMsg.rspcmd_0x01.get();
        int i = paramObject.expFlag.get();
        paramIntent = paramObject.content.get();
        paramFromServiceMsg = paramObject.clickText.get();
        int j = paramObject.action.get();
        int k = paramObject.itemId.get();
        paramObject = paramObject.url.get();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleExpireInfoResponse, from aio, expireFlag=" + i + ", expireTipContent=" + paramIntent + ", clickText=" + paramFromServiceMsg + ", action=" + j + ", url=" + paramObject);
        }
        if (i == 0) {
          return;
        }
        SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
        localEditor.putInt("renewal_tail_tip_exit", i);
        localEditor.putInt("renewal_tail_action", j);
        localEditor.putString("renewal_tail_tip", paramIntent);
        localEditor.putString("renewal_tail_click_text", paramFromServiceMsg);
        localEditor.putString("renewal_tail_activity_url", paramObject);
        localEditor.putInt("renewal_tail_item_id", k);
        localEditor.commit();
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_preshow", "", 1, 0, 0, "", String.valueOf(i), "");
        paramIntent = this.app.getHandler(ChatActivity.class);
        if (paramIntent == null) {
          return;
        }
        paramIntent.sendMessage(paramIntent.obtainMessage(26));
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 1, "handleExpireInfoResponse exception", paramIntent);
      return;
    }
    if ((l2 != 2L) && (l2 == 3L)) {}
  }
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramIntent = new Oidb_0x8fc.RspBody();
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            notifyUI(27, true, null);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ColorNick", 2, "handleModifyColorNick sso fail result = " + paramFromServiceMsg.uint32_result.get());
          }
          if (paramFromServiceMsg.uint32_result.has())
          {
            i = paramFromServiceMsg.uint32_result.get();
            if (!paramIntent.strErrInfo.has()) {
              break label213;
            }
            paramIntent = paramIntent.strErrInfo.get();
            notifyUI(27, false, new Object[] { Integer.valueOf(i), paramIntent });
            return;
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("ColorNick", 1, "handleModifyColorNick error: ", paramIntent);
          notifyUI(27, false, Integer.valueOf(-1));
          return;
        }
        int i = -1;
        continue;
        label213:
        paramIntent = "";
      }
    }
  }
  
  private void n(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleExploreInfo]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(TAG, 1, "[handleExploreInfo] data null or rsp failed");
      notifyUI(28, false, null);
    }
    for (;;)
    {
      return;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg = new STExploreInfo.STGetMsgRsp();
        paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        if (!paramFromServiceMsg.eid_list.has()) {
          continue;
        }
        paramArrayOfByte = paramFromServiceMsg.eid_list.get().iterator();
        if (!paramArrayOfByte.hasNext()) {
          continue;
        }
        paramFromServiceMsg = (STExploreInfo.STEntryIdMsg)paramArrayOfByte.next();
        int i = paramFromServiceMsg.entry_id.get();
        int j = paramFromServiceMsg.next_req_ts.get();
        Object localObject = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0);
        if (i == 1)
        {
          paramIntent = "next_req_st_drawer";
          this.ecj = j;
        }
        for (;;)
        {
          ((SharedPreferences)localObject).edit().putInt(paramIntent, j).commit();
          localObject = paramFromServiceMsg.msg_info.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramIntent = (STExploreInfo.STMsgInfo)((Iterator)localObject).next();
            long l = paramIntent.seq.get();
            String str1 = paramIntent.wording.get().toStringUtf8();
            String str2 = paramIntent.jump_url.get().toStringUtf8();
            int k = paramIntent.is_red.get();
            String str3 = paramIntent.icon_url.get().toStringUtf8();
            int m = paramIntent.action_id.get();
            int n = paramIntent.bubble_id.get();
            paramFromServiceMsg = paramIntent.scheme.get();
            paramIntent = paramFromServiceMsg;
            if (abhh.h(this.app, this.app.getCurrentUin()) == 2) {
              paramIntent = "3d_" + paramFromServiceMsg;
            }
            paramFromServiceMsg = new JSONObject();
            paramFromServiceMsg.put("entry_id", i);
            paramFromServiceMsg.put("seq", l);
            paramFromServiceMsg.put("wording", str1);
            paramFromServiceMsg.put("jump_url", str2);
            paramFromServiceMsg.put("is_red", k);
            paramFromServiceMsg.put("icon_url", str3);
            paramFromServiceMsg.put("action_id", m);
            paramFromServiceMsg.put("bubble_id", n);
            paramFromServiceMsg.put("scheme", paramIntent);
            paramFromServiceMsg.put("next_st", j);
            paramFromServiceMsg.put("show_sum", 1);
            QLog.d(TAG, 1, "[handleExploreInfo] id:" + i + ",info:" + paramFromServiceMsg.toString());
            notifyUI(28, true, paramFromServiceMsg.toString());
          }
          break;
          paramIntent = "next_req_st_drawer_friend_card";
          this.eck = j;
        }
        return;
      }
      catch (Exception paramIntent) {}
    }
  }
  
  private void q(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "; isSuccess: " + paramFromServiceMsg.isSuccess() + ", ret: " + paramFromServiceMsg.getResultCode());
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      abhh localabhh;
      ArrayList localArrayList;
      HashMap localHashMap;
      int i;
      long l1;
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleGetUserApolloDress ret: " + paramFromServiceMsg.ret.get());
        }
        if (0L == paramFromServiceMsg.ret.get())
        {
          JSONObject localJSONObject = new JSONObject(paramFromServiceMsg.rspdata.get());
          if (localJSONObject == null) {
            break label921;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetUserApolloDress rootData: " + localJSONObject);
          }
          localabhh = (abhh)this.app.getManager(153);
          localArrayList = new ArrayList();
          JSONArray localJSONArray = localJSONObject.getJSONArray("data");
          localHashMap = new HashMap();
          if (localJSONArray != null)
          {
            i = 0;
            if (i < localJSONArray.length())
            {
              paramFromServiceMsg = (JSONObject)localJSONArray.opt(i);
              l1 = paramFromServiceMsg.optLong("uin");
              ApolloBaseInfo localApolloBaseInfo = localabhh.b(l1 + "");
              long l2 = paramFromServiceMsg.optLong("ts");
              paramArrayOfByte = paramFromServiceMsg.toString();
              paramFromServiceMsg = localApolloBaseInfo.getApolloDress();
              localApolloBaseInfo.setApolloDress(l2, paramArrayOfByte);
              paramArrayOfByte = localApolloBaseInfo.getApolloDress();
              if (paramFromServiceMsg == null)
              {
                paramFromServiceMsg = "";
                break label1099;
                if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.equals(paramFromServiceMsg, paramArrayOfByte)))
                {
                  localApolloBaseInfo.apolloHistoryDress = paramFromServiceMsg;
                  localApolloBaseInfo.appearAction = null;
                  abrd.clearAction(String.valueOf(l1));
                  if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "save history uin:" + l1 + ", dress: " + paramFromServiceMsg + ", new dres: " + paramArrayOfByte);
                  }
                }
                localHashMap.put(localApolloBaseInfo.uin, localApolloBaseInfo);
                localArrayList.add(localApolloBaseInfo);
                i += 1;
                continue;
              }
              paramFromServiceMsg = paramFromServiceMsg.encode();
              break label1099;
              paramArrayOfByte = paramArrayOfByte.encode();
              continue;
            }
          }
          paramFromServiceMsg = localJSONObject.optJSONObject("device");
          if (paramFromServiceMsg != null)
          {
            ApolloUtil.Is(paramFromServiceMsg.optInt("level"));
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "handleGetUserApolloDress MSAA_level deviceJson : " + paramFromServiceMsg);
            }
          }
          paramArrayOfByte = localJSONObject.optJSONArray("data2");
          if (paramArrayOfByte != null)
          {
            i = 0;
            if (i < paramArrayOfByte.length())
            {
              localJSONObject = (JSONObject)paramArrayOfByte.opt(i);
              l1 = localJSONObject.optLong("uin");
              paramFromServiceMsg = (ApolloBaseInfo)localHashMap.get(String.valueOf(l1));
              if (paramFromServiceMsg != null) {
                break label1093;
              }
              paramFromServiceMsg = localabhh.b(l1 + "");
              j = 1;
              paramFromServiceMsg.setApolloDress3D(this.app, localJSONObject);
              if (j != 0) {
                localArrayList.add(paramFromServiceMsg);
              }
              paramFromServiceMsg = paramFromServiceMsg.getApolloDress3D();
              if ((paramFromServiceMsg == null) || (TextUtils.isEmpty(paramFromServiceMsg.bgH))) {
                break label1110;
              }
              abto.a(this.app, paramFromServiceMsg.bgH, null);
              break label1110;
            }
          }
          if (localArrayList.size() <= 0) {
            break label866;
          }
          paramFromServiceMsg = localArrayList.iterator();
          if (!paramFromServiceMsg.hasNext()) {
            break label838;
          }
          paramArrayOfByte = (ApolloBaseInfo)paramFromServiceMsg.next();
          if (paramArrayOfByte == null) {
            continue;
          }
          if (paramArrayOfByte.apolloServerTS != 0L)
          {
            if (paramArrayOfByte.apolloLocalTS == paramArrayOfByte.apolloServerTS) {
              continue;
            }
            paramArrayOfByte.apolloLocalTS = paramArrayOfByte.apolloServerTS;
            continue;
          }
        }
        else
        {
          paramIntent = (Long[])paramIntent.getExtras().get("uinArr");
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "", paramFromServiceMsg);
        }
      }
      for (;;)
      {
        if (paramIntent == null) {
          break label1053;
        }
        j = paramIntent.length;
        i = 0;
        while (i < j)
        {
          l1 = paramIntent[i].longValue();
          this.S.remove(Long.valueOf(l1));
          i += 1;
        }
        paramArrayOfByte.apolloServerTS = paramArrayOfByte.apolloLocalTS;
        break;
        label838:
        localabhh.hW(localArrayList);
        ((abhh)this.app.getManager(153)).hV(localArrayList);
        continue;
        label866:
        paramFromServiceMsg = localHashMap.entrySet().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramArrayOfByte = (Map.Entry)paramFromServiceMsg.next();
          a((String)paramArrayOfByte.getKey(), (ApolloBaseInfo)paramArrayOfByte.getValue());
        }
        continue;
        label921:
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
          j = paramFromServiceMsg.length;
          i = 0;
          while (i < j)
          {
            l1 = paramFromServiceMsg[i].longValue();
            QLog.e(TAG, 2, "handleGetUserApolloDress no dress info uin:" + l1);
            a(String.valueOf(l1), null);
            i += 1;
          }
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleGetUserApolloDress fail ret: " + paramFromServiceMsg.getResultCode());
          }
        }
      }
      label1053:
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "handleGetUserApolloDress done  mSendingQueue size: " + this.S.size());
      }
      return;
      label1093:
      int j = 0;
      continue;
      label1099:
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = "";
        continue;
        label1110:
        i += 1;
      }
    }
  }
  
  private void u(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder().append("handleGetApolloBaseInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label810;
      }
    }
    label810:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d((String)localObject1, 2, i);
      ArrayList localArrayList;
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            paramIntent = new oidb_0x5eb.RspBody();
            paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            paramArrayOfByte = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            localObject1 = (abhh)this.app.getManager(153);
            i = 0;
          }
          for (;;)
          {
            if (i < paramIntent.rpt_msg_uin_data.size())
            {
              ??? = (oidb_0x5eb.UdcUinData)paramIntent.rpt_msg_uin_data.get(i);
              localObject2 = ((oidb_0x5eb.UdcUinData)???).uint64_uin.get() + "";
              ApolloBaseInfo localApolloBaseInfo = ((abhh)localObject1).b((String)localObject2);
              if (((oidb_0x5eb.UdcUinData)???).uint32_apollo_vip_flag.has()) {
                localApolloBaseInfo.apolloVipFlag = ((oidb_0x5eb.UdcUinData)???).uint32_apollo_vip_flag.get();
              }
              if (((oidb_0x5eb.UdcUinData)???).uint32_apollo_vip_level.has()) {
                localApolloBaseInfo.apolloVipLevel = ((oidb_0x5eb.UdcUinData)???).uint32_apollo_vip_level.get();
              }
              if (((oidb_0x5eb.UdcUinData)???).uint32_apollo_status.has()) {
                localApolloBaseInfo.apolloStatus = ((oidb_0x5eb.UdcUinData)???).uint32_apollo_status.get();
              }
              if (((oidb_0x5eb.UdcUinData)???).uint32_apollo_timestamp.has()) {
                localApolloBaseInfo.apolloServerTS = ((oidb_0x5eb.UdcUinData)???).uint32_apollo_timestamp.get();
              }
              if (((oidb_0x5eb.UdcUinData)???).uint32_cmshow_3d_flag.has()) {
                localApolloBaseInfo.cmshow3dFlag = ((oidb_0x5eb.UdcUinData)???).uint32_cmshow_3d_flag.get();
              }
              if (((oidb_0x5eb.UdcUinData)???).uint32_flag_super_yellow_diamond.has()) {
                localApolloBaseInfo.superYellowDiamondFlag = ((oidb_0x5eb.UdcUinData)???).uint32_flag_super_yellow_diamond.get();
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, new Object[] { "handleGetApolloBaseInfo uin: ", localApolloBaseInfo.uin, ",apollo vipFlag: ", Integer.valueOf(localApolloBaseInfo.apolloVipFlag), ", apollo status: ", Integer.valueOf(localApolloBaseInfo.apolloStatus), ", apollo level: ", Integer.valueOf(localApolloBaseInfo.apolloVipLevel), ", svr TS: ", Long.valueOf(localApolloBaseInfo.apolloServerTS), ", cmshow3dFlag=", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
              }
              if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)
              {
                paramFromServiceMsg.add(Long.valueOf(((oidb_0x5eb.UdcUinData)???).uint64_uin.get()));
                localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
                paramArrayOfByte.add(localApolloBaseInfo);
                i += 1;
              }
              else
              {
                synchronized (this.IY)
                {
                  localArrayList = new ArrayList();
                  Iterator localIterator = this.IY.iterator();
                  aqrb.b localb;
                  do
                  {
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localb = (aqrb.b)localIterator.next();
                  } while (!localb.a((String)localObject2, localApolloBaseInfo));
                  localArrayList.add(localb);
                }
                return;
              }
            }
          }
        }
        catch (Throwable paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "", paramIntent);
          }
        }
      }
      do
      {
        this.IY.removeAll(localArrayList);
        break;
        ((abhh)localObject1).hW(paramArrayOfByte);
        m(paramFromServiceMsg, "AIO");
        return;
        paramIntent = paramIntent.getStringArrayExtra("uins");
      } while (paramIntent == null);
      paramFromServiceMsg = new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte = paramIntent[i];
        localObject1 = ((abhh)this.app.getManager(153)).b(paramArrayOfByte);
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS)) {
          paramFromServiceMsg.add(Long.valueOf(Long.parseLong(paramArrayOfByte)));
        }
        i += 1;
      }
      m(paramFromServiceMsg, "AIOPanel");
      return;
    }
  }
  
  public void A(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (this.app == null) {}
    do
    {
      return;
      int j = 0;
      paramIntent = this.app.getHandler(Leba.class);
      qqshop_code.SRsp localSRsp = new qqshop_code.SRsp();
      int i = j;
      if (paramArrayOfByte != null)
      {
        i = j;
        if (!paramFromServiceMsg.isSuccess()) {}
      }
      try
      {
        localSRsp.mergeFrom(paramArrayOfByte);
        i = j;
        if (localSRsp != null)
        {
          i = j;
          if (localSRsp.ret_code.get() == 0)
          {
            if (paramIntent != null) {
              paramIntent.obtainMessage(1134008, localSRsp).sendToTarget();
            }
            i = 1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i = j;
        }
      }
    } while (i != 0);
    paramIntent.obtainMessage(1134007, localSRsp).sendToTarget();
  }
  
  public void B(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleGameStatusResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new apollo_game_status.STGameStateMsgList();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.pbRsqData.get().toByteArray());
        paramIntent = paramIntent.getStringExtra("usrdata");
        ((abhe)this.app.getManager(211)).b((int)paramFromServiceMsg.ret.get(), paramArrayOfByte.rpt_msg_list.get(), paramIntent);
        return;
      }
      QLog.e(TAG, 1, "handleGameStatusResp resp data is err.");
      return;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "errInfo->" + paramIntent.getMessage());
      }
    }
  }
  
  public void B(String paramString, ArrayList<ColorClearableEditText.a> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("ColorNick", 1, "modifyTroopMemberCardInfoWithColorNick paragraphs is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick troopUin = " + paramString);
    }
    Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
    localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    ArrayList localArrayList1 = new ArrayList();
    Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    localMemberInfo.uint64_uin.set(l);
    ArrayList localArrayList2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      ColorClearableEditText.a locala = (ColorClearableEditText.a)localIterator.next();
      Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
      switch (locala.type)
      {
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick type = " + locala.type + " text = " + locala.text);
        }
        localArrayList2.add(localRichCardNameElem);
        break;
        localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(locala.text.getBytes()));
        localStringBuilder.append(locala.text);
        continue;
        paramArrayList = locala.text;
        paramString = paramArrayList;
        if (paramArrayList.substring(0, 1).equals("<")) {
          paramString = paramArrayList.substring(1);
        }
        paramArrayList = paramString;
        if (paramString.substring(paramString.length() - 1).equals(">")) {
          paramArrayList = paramString.substring(0, paramString.length() - 1);
        }
        localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(paramArrayList.getBytes()));
      }
    }
    paramString = new Oidb_0x8fc.CommCardNameBuf();
    paramString.rpt_rich_card_name.set(localArrayList2);
    localMemberInfo.bytes_comm_rich_card_name.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
    localMemberInfo.member_card_name.set(ByteStringMicro.copyFrom(localStringBuilder.toString().getBytes()));
    localArrayList1.add(localMemberInfo);
    localReqBody.rpt_mem_level_info.set(localArrayList1);
    paramString = new Oidb_0x8fc.ClientInfo();
    paramString.uint32_implat.set(109);
    paramString.string_clientver.set(aqgz.getQQVersion());
    localReqBody.msg_client_info.set(paramString);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2300);
    paramString.uint32_service_type.set(3);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = new NewIntent(this.app.getApp(), aqre.class);
    paramArrayList.putExtra("cmd", "OidbSvc.0x8fc_3");
    paramArrayList.putExtra("data", paramString.toByteArray());
    this.app.startServlet(paramArrayList);
  }
  
  public void D(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg = new JSONObject(paramIntent.rspdata.get()).toString();
        paramIntent = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          paramIntent = "{}";
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "[handleGetRedDotInfo] " + paramIntent);
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(TAG, 1, "[handleGetRedDotInfo] ");
    }
  }
  
  public void E(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleApolloGameKey],data:" + paramArrayOfByte);
    }
    try
    {
      Object localObject;
      if (this.mApp != null)
      {
        localObject = this.mApp.getHandler(ChatActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).obtainMessage(73).sendToTarget();
        }
      }
      if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int i = paramIntent.getIntExtra("gameId", 0);
        boolean bool = paramIntent.getBooleanExtra("isCreator", false);
        long l = paramIntent.getLongExtra("roomId", 0L);
        paramArrayOfByte = paramIntent.getStringExtra("from");
        localObject = paramIntent.getStringExtra("version");
        int j = paramIntent.getIntExtra("enter", 0);
        int k = paramIntent.getIntExtra("gameMode", 0);
        String str = paramIntent.getStringExtra("extendJson");
        int m = paramIntent.getIntExtra("src", 0);
        paramIntent = new Bundle();
        paramIntent.putInt("gameId", i);
        paramIntent.putBoolean("isCreator", bool);
        paramIntent.putLong("roomId", l);
        paramIntent.putString("from", paramArrayOfByte);
        paramIntent.putString("oldVersion", (String)localObject);
        paramIntent.putInt("gameMode", k);
        paramIntent.putInt("enter", j);
        paramIntent.putLong("retCode", paramFromServiceMsg.ret.get());
        paramIntent.putString("extendJson", str);
        paramIntent.putInt("src", m);
        paramIntent.putByteArray("data", paramFromServiceMsg.pbRsqData.get().toByteArray());
        notifyUI(21, true, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "ret:" + paramFromServiceMsg.ret.get());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "resp data is err.");
        }
        notifyUI(21, false, null);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "errInfo->" + paramIntent.getMessage());
      }
      notifyUI(21, false, null);
    }
  }
  
  public void F(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder().append("handleGetStrangerVasInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte != null)
      {
        i = paramArrayOfByte.length;
        QLog.d((String)localObject1, 2, i);
      }
    }
    else if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      int i1;
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramArrayOfByte = new oidb_0x5eb.RspBody();
          paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          int i2 = paramArrayOfByte.rpt_msg_uin_data.size();
          localObject1 = new HashSet(i2);
          localObject2 = new ArrayList(i2);
          ArrayList localArrayList = new ArrayList();
          acff localacff = (acff)this.app.getManager(51);
          VasFaceManager localVasFaceManager = ((aqrc)this.app.getManager(235)).a;
          i = 0;
          j = 0;
          i1 = 0;
          if (i1 < i2)
          {
            oidb_0x5eb.UdcUinData localUdcUinData = (oidb_0x5eb.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(i1);
            m = 0;
            String str = String.valueOf(localUdcUinData.uint64_uin.get());
            paramFromServiceMsg = localacff.a(str);
            if (paramFromServiceMsg != null) {
              break label2102;
            }
            paramFromServiceMsg = new ExtensionInfo();
            paramFromServiceMsg.uin = str;
            m = 1;
            if (!localUdcUinData.uint32_vas_font_id.has()) {
              break label2099;
            }
            long l = localUdcUinData.uint32_vas_font_id.get();
            if (!str.equals(this.app.getCurrentAccountUin())) {
              break label2096;
            }
            k = (int)ku.h(l);
            lf.iP = k;
            i = k;
            if (QLog.isColorLevel())
            {
              QLog.d("VasShieldFont", 2, "handleGetStrangerVasInfo: " + lf.iP);
              i = k;
            }
            if ((ku.h(l) == paramFromServiceMsg.uVipFont) && (ku.c(l) == paramFromServiceMsg.vipFontType)) {
              break label2093;
            }
            paramFromServiceMsg.uVipFont = ku.h(l);
            paramFromServiceMsg.vipFontType = ku.c(l);
            paramFromServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
            m = 1;
            if ((!localUdcUinData.uint32_vas_diy_font_timestamp.has()) || (!str.equals(this.app.getCurrentAccountUin()))) {
              break label2086;
            }
            k = localUdcUinData.uint32_vas_diy_font_timestamp.get();
            j = m;
            if (localUdcUinData.uint32_vas_magicfont_flag.has())
            {
              n = localUdcUinData.uint32_vas_magicfont_flag.get();
              j = m;
              if (n != paramFromServiceMsg.magicFont)
              {
                paramFromServiceMsg.magicFont = n;
                paramFromServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                j = 1;
              }
            }
            int n = j;
            if (localUdcUinData.uint32_req_font_effect_id.has())
            {
              m = localUdcUinData.uint32_req_font_effect_id.get();
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleGetStrangerVasInfo uin = " + str + " fontEffect = " + m + " extInfo.fontEffect = " + paramFromServiceMsg.fontEffect);
              }
              if (m != paramFromServiceMsg.fontEffect)
              {
                paramFromServiceMsg.fontEffect = m;
                paramFromServiceMsg.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                j = 1;
              }
              n = j;
              if (QLog.isColorLevel())
              {
                QLog.d(TAG, 2, "handleGetStrangerVasInfo uin = " + str + " extInfo.fontEffect = " + paramFromServiceMsg.fontEffect + " extInfo.fontEffectLastUpdateTime = " + paramFromServiceMsg.fontEffectLastUpdateTime);
                n = j;
              }
            }
            m = n;
            if (localUdcUinData.uint64_face_addon_id.has())
            {
              l = localUdcUinData.uint64_face_addon_id.get();
              m = n;
              if (paramFromServiceMsg.pendantId != l)
              {
                paramFromServiceMsg.pendantId = l;
                paramFromServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                m = 1;
              }
            }
            if (localUdcUinData.uint32_bubble_id.has())
            {
              j = localUdcUinData.uint32_bubble_id.get();
              if ((j >= 0) && (String.valueOf(str).equals(this.app.getCurrentAccountUin()))) {
                ((acle)this.app.getBusinessHandler(13)).JK(j);
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleGetStrangerVasInfo uin= " + str + "bubble id = " + j);
              }
            }
            j = m;
            if (localUdcUinData.uint32_vas_colorring_id.has())
            {
              n = localUdcUinData.uint32_vas_colorring_id.get();
              j = m;
              if (paramFromServiceMsg.colorRingId != n)
              {
                paramFromServiceMsg.colorRingId = n;
                j = 1;
              }
            }
            if (localUdcUinData.uint32_vas_praise_id.has())
            {
              m = localUdcUinData.uint32_vas_praise_id.get();
              if ((m > 0) && (String.valueOf(str).equals(this.app.getCurrentAccountUin()))) {
                PraiseManager.E(this.app, m);
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleGetStrangerVasInfo uin= " + str + "praise id = " + m);
              }
            }
            if ((localUdcUinData.uint64_game_appid.has()) && (localUdcUinData.uint64_game_last_login_time.has()) && (localUdcUinData.uint32_plate_of_king_dan.has()) && (localUdcUinData.uint32_plate_of_king_dan_display_switch.has())) {
              c(str, localUdcUinData.uint64_game_appid.get(), localUdcUinData.uint64_game_last_login_time.get(), localUdcUinData.uint32_plate_of_king_dan.get(), localUdcUinData.uint32_plate_of_king_dan_display_switch.get());
            }
            if (localUdcUinData.uint32_vas_voicebubble_id.has())
            {
              m = localUdcUinData.uint32_vas_voicebubble_id.get();
              if ((m > 0) && (String.valueOf(str).equals(this.app.getCurrentAccountUin())))
              {
                ((acle)this.app.getBusinessHandler(13)).JL(m);
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "handleGetStrangerVasInfo uin= " + str + "voice print bubble id = " + m);
                }
              }
            }
            if (localUdcUinData.uint32_suspend_effect_id.has())
            {
              m = localUdcUinData.uint32_suspend_effect_id.get();
              if ((m >= 0) && (String.valueOf(str).equals(this.app.getCurrentAccountUin()))) {
                ((acle)this.app.getBusinessHandler(13)).dH(str, m);
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "uint32_suspend_effect_id = " + m);
              }
            }
            if (!localUdcUinData.uint32_vas_face_id.has()) {
              break label2083;
            }
            n = paramFromServiceMsg.faceId;
            int i3 = localUdcUinData.uint32_vas_face_id.get();
            if ((paramFromServiceMsg.faceIdUpdateTime != 0L) && (n == i3)) {
              break label2076;
            }
            paramFromServiceMsg.faceId = i3;
            paramFromServiceMsg.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            m = 1;
            if (n != i3) {
              localArrayList.add(str);
            }
            j = m;
            if (QLog.isColorLevel())
            {
              QLog.d(TAG, 1, "uint32_vas_face_id uin: " + str + " oldId: " + n + " newId: " + i3);
              j = m;
            }
            Object localObject3;
            if (localUdcUinData.uint32_bubble_unread_switch.has())
            {
              m = localUdcUinData.uint32_bubble_unread_switch.get();
              localObject3 = (BubbleManager)this.app.getManager(44);
              if (localObject3 != null)
              {
                if (m != 0) {
                  break label2124;
                }
                bool = true;
                ((BubbleManager)localObject3).GM(bool);
              }
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "uint32_bubble_unread_switch : " + m);
              }
            }
            m = j;
            if (localUdcUinData.uint32_vas_pendant_diy_id.has())
            {
              n = localUdcUinData.uint32_vas_pendant_diy_id.get();
              m = j;
              if (paramFromServiceMsg.pendantDiyId != n)
              {
                paramFromServiceMsg.pendantDiyId = n;
                paramFromServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                j = 1;
                if (str.equals(this.app.getCurrentAccountUin())) {
                  ((acle)this.app.getBusinessHandler(13)).bp(n, false);
                }
                m = j;
                if (QLog.isColorLevel())
                {
                  QLog.d(TAG, 2, "handleGetStrangerVasInfo, uin=" + str + ", pendant=" + paramFromServiceMsg.pendantId + ",font=" + paramFromServiceMsg.uVipFont + ", fontType = " + paramFromServiceMsg.vipFontType + ", magicFont = " + paramFromServiceMsg.magicFont + ", colorRing = " + paramFromServiceMsg.colorRingId + ", pendantDiyId = " + paramFromServiceMsg.pendantDiyId);
                  m = j;
                }
              }
            }
            if (localUdcUinData.uint32_rsp_qq_level_icon_type.has())
            {
              j = localUdcUinData.uint32_rsp_qq_level_icon_type.get();
              localObject3 = (acff)this.app.getManager(51);
              Card localCard = ((acff)localObject3).b(str + "");
              if ((localCard != null) && (localCard.mQQLevelType != j))
              {
                localCard.mQQLevelType = j;
                ((acff)localObject3).a(localCard);
                this.app.getBusinessHandler(2).notifyUI(1, true, localCard);
              }
            }
            if (localUdcUinData.uint32_rsp_theme_font_id.has()) {
              aqsd.XT(localUdcUinData.uint32_rsp_theme_font_id.get());
            }
            if (paramIntent.getBooleanExtra("req_roam_type", false)) {
              a(str, localUdcUinData);
            }
            if (paramIntent.getBooleanExtra("req_music_type", false)) {
              notifyUI(36, true, Integer.valueOf(localUdcUinData.uint32_rsp_listen_together_player_id.get()));
            }
            if (m == 0) {
              break label2105;
            }
            paramFromServiceMsg.timestamp = System.currentTimeMillis();
            ((Set)localObject1).add(str);
            ((List)localObject2).add(paramFromServiceMsg);
            break label2105;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "0x5eb self has diy timestamp fontid = " + i + " timestamp = " + j);
          }
          paramIntent = localacff.a(this.app.getCurrentAccountUin());
          ku.a(this.app, this.app.getCurrentAccountUin(), paramIntent, i, j);
          localacff.iN((List)localObject2);
          localVasFaceManager.i(localArrayList);
          localVasFaceManager.h((Collection)localObject2);
          notifyUI(66, true, localObject1);
          return;
        }
        notifyUI(66, false, null);
        return;
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(TAG, 2, "", paramIntent);
      return;
      notifyUI(66, false, null);
      return;
      label2076:
      int m = j;
      continue;
      label2083:
      continue;
      label2086:
      int k = j;
      continue;
      label2093:
      continue;
      label2096:
      continue;
      label2099:
      continue;
      label2102:
      continue;
      label2105:
      i1 += 1;
      int j = k;
      continue;
      i = -1;
      break;
      label2124:
      boolean bool = false;
    }
  }
  
  void H(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()) || (this.app == null)) {
      return;
    }
    for (;;)
    {
      ArrayList localArrayList1;
      abhh localabhh;
      ArrayList localArrayList2;
      int j;
      JSONArray localJSONArray;
      JSONObject localJSONObject;
      int k;
      int i;
      int m;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent.ret.get() != 0L) {
          break;
        }
        paramArrayOfByte = paramIntent.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "handleApolloStandAction response:" + paramArrayOfByte);
        }
        paramIntent = abhh.o();
        paramFromServiceMsg = paramIntent.edit();
        paramArrayOfByte = new JSONObject(paramArrayOfByte).getJSONArray("data");
        int i1 = paramArrayOfByte.length();
        localArrayList1 = new ArrayList();
        localabhh = (abhh)this.app.getManager(153);
        localArrayList2 = new ArrayList();
        j = 0;
        if (j >= i1) {
          break label831;
        }
        localObject2 = paramArrayOfByte.getJSONObject(j);
        localJSONArray = new JSONArray();
        localObject1 = ((JSONObject)localObject2).getString("uin");
        localJSONObject = new JSONObject(paramIntent.getString((String)localObject1, "{}"));
        localObject2 = ((JSONObject)localObject2).getJSONArray("action");
        localObject3 = localJSONObject.optJSONArray("action");
        int i2 = ((JSONArray)localObject2).length();
        localArrayList1.clear();
        k = 0;
        if (k >= i2) {
          break label652;
        }
        int n = 0;
        int i3 = ((JSONArray)localObject2).getJSONObject(k).getInt("id");
        long l1 = ((JSONArray)localObject2).getJSONObject(k).getLong("updateTs");
        i = n;
        if (localObject3 != null)
        {
          int i4 = ((JSONArray)localObject3).length();
          m = 0;
          i = n;
          if (m < i4)
          {
            i = ((JSONArray)localObject3).getJSONObject(m).getInt("id");
            long l2 = ((JSONArray)localObject3).getJSONObject(m).getLong("updateTs");
            if (i != i3) {
              break label852;
            }
            i = n;
            if (l1 != l2)
            {
              QLog.i(TAG, 1, "handleApolloStandAction version update res.");
              i = 1;
            }
          }
        }
        if (!ApolloUtil.aF(i3, 0))
        {
          if (!QLog.isColorLevel()) {
            break label846;
          }
          QLog.i(TAG, 2, "handleApolloStandAction download res first time.");
          break label846;
        }
        if (i != 0)
        {
          Object localObject4 = new ApolloActionData();
          ((ApolloActionData)localObject4).actionId = i3;
          String str = ApolloUtil.a((ApolloActionData)localObject4, 5);
          localObject4 = ApolloUtil.a((ApolloActionData)localObject4, 4);
          Object localObject5 = new File((String)localObject4).getParentFile();
          if (((File)localObject5).exists())
          {
            localObject5 = ((File)localObject5).listFiles();
            if ((localObject5 != null) && (localObject5.length > 0))
            {
              m = localObject5.length;
              i = 0;
              if (i < m)
              {
                localObject5[i].delete();
                i += 1;
                continue;
              }
            }
          }
          abto.b(this.app, (String)localObject4, str);
        }
        if (!((JSONArray)localObject2).getJSONObject(k).has("actPlace")) {
          break label621;
        }
        i = ((JSONArray)localObject2).getJSONObject(k).getInt("actPlace");
        if (i == 1) {
          localArrayList1.add(((JSONArray)localObject2).getJSONObject(k));
        } else if (i == 2) {
          localJSONArray.put(((JSONArray)localObject2).getJSONObject(k));
        }
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "handleApolloStandAction ", paramIntent);
      return;
      label621:
      localArrayList1.add(((JSONArray)localObject2).getJSONObject(k));
      localJSONArray.put(((JSONArray)localObject2).getJSONObject(k));
      break label861;
      label652:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "uin:", localObject1, ",sort result:" + localArrayList1 });
      }
      Object localObject2 = new JSONArray();
      Object localObject3 = localArrayList1.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((JSONArray)localObject2).put((JSONObject)((Iterator)localObject3).next());
      }
      localJSONObject.put("action", localObject2);
      paramFromServiceMsg.putString((String)localObject1, localJSONObject.toString());
      Object localObject1 = localabhh.b((String)localObject1);
      if (localObject1 != null)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("action", localJSONArray);
        ((ApolloBaseInfo)localObject1).appearAction = localJSONObject.toString();
        localArrayList2.add(localObject1);
        break label870;
        label831:
        paramFromServiceMsg.commit();
        localabhh.hW(localArrayList2);
        return;
        label846:
        i = 1;
        continue;
        label852:
        m += 1;
        continue;
        label861:
        k += 1;
        continue;
      }
      label870:
      j += 1;
    }
  }
  
  public void I(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      return;
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      Object localObject4;
      Object localObject3;
      Object localObject5;
      for (;;)
      {
        try
        {
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateRankInfo handleGameRank response code:" + paramIntent.ret.get());
          }
          if ((paramIntent.ret.get() != 0L) || (this.app == null)) {
            break;
          }
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, " updateRankInfo handleGameRank response:" + paramIntent);
          }
          paramArrayOfByte = new JSONObject(paramIntent).optJSONObject("data");
          i = paramArrayOfByte.optInt("gameNum");
          paramIntent = ApolloGameUtil.p();
          if ((paramIntent != null) && (i >= 0))
          {
            paramIntent.edit().putInt("sp.score.num", i).apply();
            ApolloGameUtil.ctD = i;
          }
          localObject1 = paramArrayOfByte.optJSONArray("chgList");
          paramIntent = (abxk)this.app.getManager(155);
          paramFromServiceMsg = this.app.a().createEntityManager();
          if ((paramIntent == null) || (paramFromServiceMsg == null)) {
            break label715;
          }
          if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
            break label542;
          }
          localObject2 = new ArrayList();
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i >= j) {
            break label535;
          }
          localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          if (localObject4 != null)
          {
            localObject3 = new ApolloGameRankData();
            ((ApolloGameRankData)localObject3).mGameId = ((JSONObject)localObject4).optInt("gameId");
            ((ApolloGameRankData)localObject3).mRank = ((JSONObject)localObject4).optInt("chgFlag");
            ((ApolloGameRankData)localObject3).mFriendUin = paramArrayOfByte.optString("sessionId");
            ((ApolloGameRankData)localObject3).mValidTime = (System.currentTimeMillis() + 604800000L);
            ((ArrayList)localObject2).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "updateRankInfo handleGameRank data " + localObject3);
            }
            localObject4 = paramIntent.Q(2147483647);
            if ((localObject4 != null) && (((List)localObject4).size() > 0))
            {
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (ApolloGameRankData)((Iterator)localObject4).next();
                if ((localObject5 == null) || (!((ApolloGameRankData)localObject5).mFriendUin.equals(((ApolloGameRankData)localObject3).mFriendUin)) || (((ApolloGameRankData)localObject5).mRank != 2) || (((ApolloGameRankData)localObject3).mRank != 1)) {
                  continue;
                }
                VipUtils.a(this.mApp, "cmshow", "Apollo", "beyond_notice_disappear", 3, 0, new String[] { String.valueOf(((ApolloGameRankData)localObject5).mGameId) });
                continue;
              }
            }
          }
          i += 1;
        }
        catch (Throwable paramIntent)
        {
          QLog.e(TAG, 1, "[handleGameRank]", paramIntent);
          return;
        }
      }
      label535:
      paramIntent.c(paramFromServiceMsg, (List)localObject2);
      label542:
      paramArrayOfByte = paramArrayOfByte.optJSONArray("gScoreList");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0))
      {
        int k = paramArrayOfByte.length();
        i = 0;
        while (i < k)
        {
          localObject1 = paramArrayOfByte.getJSONObject(i);
          if (localObject1 != null)
          {
            localObject2 = ((JSONObject)localObject1).optJSONArray("gameList");
            if (localObject2 != null)
            {
              int m = ((JSONArray)localObject2).length();
              localObject3 = new ArrayList();
              j = 0;
              while (j < m)
              {
                localObject4 = new ApolloGameScoreData();
                ((ApolloGameScoreData)localObject4).mUin = ((JSONObject)localObject1).optString("uin");
                localObject5 = ((JSONArray)localObject2).getJSONObject(j);
                ((ApolloGameScoreData)localObject4).mGameId = ((JSONObject)localObject5).optInt("gameId");
                ((ApolloGameScoreData)localObject4).mScore = ((JSONObject)localObject5).optInt("score");
                ((ArrayList)localObject3).add(localObject4);
                j += 1;
              }
              paramIntent.b(paramFromServiceMsg, (List)localObject3);
              break label726;
              label715:
              QLog.e(TAG, 1, "[handleGameRank] context is null");
              return;
            }
          }
          label726:
          i += 1;
        }
      }
    }
  }
  
  public void J(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = paramIntent.getIntExtra("id", 0);
    int j = paramIntent.getIntExtra("packageId", 0);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (i > 0)) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(TAG, 2, new Object[] { "handleBuyActionByGold ret: ", Long.valueOf(paramIntent.ret.get()), ", msg: ", paramIntent.rspdata.get() });
        }
        if (paramIntent.ret.get() != 0L) {
          break label396;
        }
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramIntent == null) || (this.app == null)) {
          break label396;
        }
        int k = paramIntent.optInt("isSuccBuy");
        int m = paramIntent.optInt("balance");
        paramIntent = ((abhh)this.app.getManager(153)).a();
        if (paramIntent != null) {
          paramIntent.coS = m;
        }
        if (k != 1) {
          break label396;
        }
        paramIntent = (abxk)this.app.getManager(155);
        paramFromServiceMsg = new ApolloObtainedActionData();
        paramFromServiceMsg.id = i;
        paramFromServiceMsg.beginTs = NetConnInfoCenter.getServerTime();
        paramFromServiceMsg.type = 0;
        paramFromServiceMsg.way = 4;
        paramIntent.a(paramFromServiceMsg);
        paramIntent = new Bundle();
        paramIntent.putInt("jumpPkdId", j);
        paramIntent.putInt("jumpActionId", i);
        notifyUI(9, true, paramIntent);
        paramIntent = new HashMap();
        paramIntent.put("APOLLO_POP_TYPE", "toast");
        paramIntent.put("tips", this.app.getApp().getString(2131690329));
        paramFromServiceMsg = this.app.getHandler(ChatActivity.class);
        if (paramFromServiceMsg == null) {
          break label402;
        }
        paramFromServiceMsg = paramFromServiceMsg.obtainMessage(45);
        paramFromServiceMsg.obj = paramIntent;
        paramFromServiceMsg.sendToTarget();
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "handleBuyActionByGold failed", paramIntent);
        return;
      }
      if (i == 0) {
        ApolloItemBuilder.a(acfp.m(2131716315), 1, BaseApplicationImpl.getContext());
      }
      return;
      label396:
      i = 0;
      continue;
      label402:
      i = 1;
    }
  }
  
  public void K(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleSaveGameListResult]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(TAG, 1, "[handleSaveGameListResult] data null or rsp failed");
      notifyUI(25, false, null);
    }
    for (;;)
    {
      return;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleSaveGameListResult] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "[handleSaveGameListResult] respData=", paramIntent });
          }
          paramIntent = new JSONObject(paramIntent).optJSONObject("data");
          if (paramIntent == null) {
            continue;
          }
          long l = paramIntent.optLong("timeStamp");
          QLog.e(TAG, 1, "[handleSaveGameListResult] last timeStamp : " + l);
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
        return;
      }
    }
    QLog.e(TAG, 1, "[handleSaveGameListResult] ret : " + paramIntent.ret.get());
  }
  
  public void P(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handlePlusUsedAppListRsp]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handlePlusUsedAppListRsp] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = paramIntent.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handlePlusUsedAppListRsp] respData=", paramIntent });
        }
        if (this.mApp != null)
        {
          paramFromServiceMsg = (UsedAppListManager)this.mApp.getManager(288);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.syncRoamUsedListFromSrv(paramIntent);
          }
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(TAG, 1, "[handlePlusUsedAppListRsp] exception=", paramIntent);
    }
  }
  
  public void Q(int paramInt1, int paramInt2, String paramString)
  {
    int j = 0;
    try
    {
      i = aqiw.getSystemNetwork(this.app.getApp().getApplicationContext());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        label28:
        Object localObject;
        int i = 0;
      }
    }
    try
    {
      k = Integer.parseInt(paramString);
      j = k;
    }
    catch (Exception paramString)
    {
      break label28;
    }
    paramString = new qqshop_act.SQQSHPActReq();
    localObject = new qqshop_act.SQQSHPUsrInfo();
    ((qqshop_act.SQQSHPUsrInfo)localObject).carriertype.set(kdm.nf());
    ((qqshop_act.SQQSHPUsrInfo)localObject).net_type.set(i);
    ((qqshop_act.SQQSHPUsrInfo)localObject).src.set(kdm.cS(paramInt2));
    ((qqshop_act.SQQSHPUsrInfo)localObject).src_idx.set(j);
    paramString.act_id.set(paramInt1);
    paramString.usr_info.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), aqre.class);
    ((NewIntent)localObject).putExtra("cmd", "SQQShopAct.ReqAct");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 3000L);
    this.app.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopJd", 2, "jd red packet sent.");
    }
  }
  
  public void R(long paramLong, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), aqre.class);
    localNewIntent.putExtra("cmd", cwl);
    localNewIntent.putExtra("pendantId", paramLong);
    localNewIntent.putExtra("seriesId", paramInt1);
    localNewIntent.putExtra("uin", this.app.getCurrentAccountUin());
    PendantMarket.SetAddonReq localSetAddonReq = new PendantMarket.SetAddonReq();
    localSetAddonReq.cmd.set(2);
    localSetAddonReq.int_platform.set(2);
    localSetAddonReq.long_addon_id.set(paramLong);
    localSetAddonReq.str_qq_version.set("3.4.4");
    if (paramInt2 != -1) {
      localSetAddonReq.int_from_type.set(paramInt2);
    }
    localNewIntent.putExtra("data", localSetAddonReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.app.startServlet(localNewIntent);
  }
  
  public void R(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleApolloLoginReq]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handleApolloWhiteList] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = paramIntent.rspdata.get();
        paramFromServiceMsg = new JSONObject(paramIntent).optJSONObject("data");
        if (paramFromServiceMsg != null)
        {
          int i = paramIntent.indexOf("bitmap\":");
          if (i >= 0)
          {
            int j = paramIntent.indexOf(",", i);
            if (j >= 0) {
              ThreadManagerV2.executeOnSubThread(new VasExtensionHandler.1(this, paramIntent.substring(i + 8, j), paramFromServiceMsg.optJSONArray("val_list")));
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(TAG, 1, paramIntent, new Object[] { " handle err" });
    }
  }
  
  public void VA(String paramString)
  {
    String str1 = this.app.getCurrentAccountUin();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramString))) {}
    String str2;
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = "hot_friend_new_boat_graytip_sp" + str1 + "_" + paramString;
      str2 = "hot_friend_new_boat_graytip_sp" + str1 + "_" + paramString + "_tips";
      localObject2 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
      str1 = ((SharedPreferences)localObject2).getString(str2, "");
    } while (i == 0);
    ((SharedPreferences)localObject2).edit().remove((String)localObject1).remove(str2).commit();
    switch (i)
    {
    default: 
      QLog.e(TAG, 1, "showIfHadNewBoatTips have error type " + i);
      return;
    }
    if (TextUtils.isEmpty(str1))
    {
      QLog.e(TAG, 1, "showIfHadNewBoatTips grayStr null ");
      return;
    }
    if (str1.contains("gray_small_ship")) {}
    for (Object localObject1 = str1.replace("gray_small_ship", " ");; localObject1 = str1)
    {
      if (((String)localObject1).contains("gray_big_ship")) {
        localObject1 = ((String)localObject1).replace("gray_big_ship", " ");
      }
      for (;;)
      {
        paramString = new ahwa(paramString, paramString, (String)localObject1, 0, -5020, 2097156, anaz.gQ());
        if (!TextUtils.isEmpty(str1))
        {
          str1 = ajnl.b(this.app, 12L, 1L);
          str2 = ajnl.b(this.app, 12L, 2L);
          i = ((String)localObject1).lastIndexOf(str1);
          int j = ((String)localObject1).lastIndexOf(str2);
          localObject1 = new Bundle();
          localObject2 = new Bundle();
          if (i >= 0)
          {
            ((Bundle)localObject1).putString("image_resource", "gray_small_ship");
            paramString.addHightlightItem(i - 1, i, (Bundle)localObject1);
            ((Bundle)localObject2).putInt("key_action", 11);
            ((Bundle)localObject2).putString("key_action_DATA", str1);
            paramString.addHightlightItem(i, str1.length() + i, (Bundle)localObject2);
          }
          if (j >= 0)
          {
            ((Bundle)localObject1).putString("image_resource", "gray_big_ship");
            paramString.addHightlightItem(j - 1, j, (Bundle)localObject1);
            ((Bundle)localObject2).putInt("key_action", 11);
            ((Bundle)localObject2).putString("key_action_DATA", str2);
            paramString.addHightlightItem(j, str2.length() + j, (Bundle)localObject2);
          }
        }
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).hasRead = 0;
        ((MessageForUniteGrayTip)localObject1).subType = 0;
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString);
        ahwb.a(this.app, (MessageForUniteGrayTip)localObject1);
        return;
      }
    }
  }
  
  public void VB(String paramString)
  {
    QLog.d(TAG, 1, "getGameRegisterInfo");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("game_appid", paramString);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "3.4.4.3058");
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12855", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.app.getApp(), aqre.class);
      paramString.putExtra("cmd", "QQVacCommSvc.get_game_register_info");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "[getGameRegisterInfo] exception=", paramString);
    }
  }
  
  public void Vw(String paramString)
  {
    if (this.app != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.app.getLongAccountUin()));
      m(localArrayList, paramString);
    }
  }
  
  public void Vx(String paramString)
  {
    Z(new String[] { paramString });
  }
  
  public void Vy(String paramString)
  {
    qqshop_code.SReq localSReq = new qqshop_code.SReq();
    localSReq.appid.set(100273020);
    localSReq.version.set(1);
    PBStringField localPBStringField = localSReq.redirect_uri;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    localPBStringField.set(str);
    paramString = new NewIntent(this.app.getApp(), aqre.class);
    paramString.putExtra("cmd", "SQQShopAuthCodeSvc.AuthCode");
    paramString.putExtra("data", localSReq.toByteArray());
    paramString.putExtra("timeout", 3000L);
    this.app.startServlet(paramString);
  }
  
  public void Vz(String paramString)
  {
    Object localObject1 = this.app.getCurrentAccountUin();
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = "special_care_tip_show_" + (String)localObject1 + "_" + paramString;
      localObject2 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
    } while (i == 0);
    ((SharedPreferences)localObject2).edit().remove((String)localObject1).commit();
    switch (i)
    {
    default: 
      QLog.e(TAG, 1, "showIfHadSpecialCareTip have error type " + i);
      return;
    case 1: 
      localObject1 = this.app.getApp().getString(2131694497);
    }
    for (;;)
    {
      paramString = new ahwa(paramString, paramString, (String)localObject1, 0, -5020, 2097156, anaz.gQ());
      localObject2 = new Bundle();
      String str = acfp.m(2131716314);
      if (!TextUtils.isEmpty(str))
      {
        ((Bundle)localObject2).putInt("key_action", 21);
        ((Bundle)localObject2).putString("key_action_DATA", Integer.toString(i));
        int j = ((String)localObject1).lastIndexOf(str);
        if (j >= 0) {
          paramString.addHightlightItem(j, str.length() + j, (Bundle)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("reactive", 2, "showIfHadSpecialCareTip grayStr=" + (String)localObject1 + "spanPos=" + j + "iconName=" + str);
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Care", "CareTipShow", "", 1, 0, 0, null, Integer.toString(i), null);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = 0;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString);
      ahwb.a(this.app, (MessageForUniteGrayTip)localObject1);
      return;
      localObject1 = this.app.getApp().getString(2131694500);
      continue;
      localObject1 = this.app.getApp().getString(2131694499);
      continue;
      localObject1 = this.app.getApp().getString(2131694496);
      continue;
      localObject1 = this.app.getApp().getString(2131694498);
      continue;
      localObject1 = this.app.getApp().getString(2131694495);
    }
  }
  
  public void X(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[reportGamePubAccountMsgList] status:" + paramInt + ",msg:" + paramString1 + ",url:" + paramString2);
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = Long.valueOf(0L);; paramString1 = Long.valueOf(Long.parseLong(paramString1)))
    {
      localPublicAccountReq.msgid.set(paramString1.longValue());
      localPublicAccountReq.url.set(paramString2);
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramString1 = new NewIntent(this.app.getApp(), aqre.class);
      paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString1);
      return;
    }
  }
  
  public void XN(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "requestExpireInfo, from=" + paramInt);
    }
    IndividPub.expTips_Req localexpTips_Req = new IndividPub.expTips_Req();
    Object localObject = new IndividPub.Platform_Comm_Req();
    ((IndividPub.Platform_Comm_Req)localObject).platForm.set(109L);
    ((IndividPub.Platform_Comm_Req)localObject).osver.set(Build.VERSION.RELEASE);
    ((IndividPub.Platform_Comm_Req)localObject).mqqver.set("3.4.4.3058");
    localexpTips_Req.comm.set((MessageMicro)localObject);
    localexpTips_Req.cmd.set(1);
    localexpTips_Req.setHasFlag(true);
    localObject = new IndividPub.expTips_Pull_Req();
    ((IndividPub.expTips_Pull_Req)localObject).from.set(paramInt);
    localexpTips_Req.reqcmd_0x01.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), aqre.class);
    ((NewIntent)localObject).putExtra("cmd", cwm);
    ((NewIntent)localObject).putExtra("data", localexpTips_Req.toByteArray());
    ((NewIntent)localObject).putExtra("from", paramInt);
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void XO(int paramInt)
  {
    if (this.app == null) {
      QLog.e(TAG, 1, "[getExploreInfo] app is null");
    }
    long l;
    do
    {
      do
      {
        return;
      } while (abhh.h(this.app, this.app.getCurrentUin()) != 2);
      l = NetConnInfoCenter.getServerTime();
      if (paramInt != 1) {
        break;
      }
      if (this.ecj == 0) {
        this.ecj = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0).getInt("next_req_st_drawer", (int)l);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getExploreInfo] exploreDrawerSt:" + this.ecj + ",currentTime:" + l + "|" + paramInt);
      }
    } while (this.ecj > l);
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 1, "[getExploreInfo] get info");
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STExploreInfo.STGetMsgReq();
        ((STExploreInfo.STGetMsgReq)localObject).app_type.set(1);
        STExploreInfo.STEntryIdInfo localSTEntryIdInfo = new STExploreInfo.STEntryIdInfo();
        localSTEntryIdInfo.num.set(1);
        localSTEntryIdInfo.entry_id.set(paramInt);
        ((STExploreInfo.STGetMsgReq)localObject).eid_list.add(localSTEntryIdInfo);
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STExploreInfo.STGetMsgReq)localObject).toByteArray()));
        localObject = new NewIntent(this.app.getApp(), aqre.class);
        ((NewIntent)localObject).putExtra("cmd", "cmshowar_message_plat.get_msg");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, "[getExploreInfo] exception=", localException);
        return;
      }
      if (this.eck == 0) {
        this.eck = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0).getInt("next_req_st_drawer_friend_card", (int)l);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getExploreInfo] exploreFriendCardSt:" + this.eck + ",currentTime:" + l + "|" + paramInt);
      }
    } while (this.eck <= l);
  }
  
  public void XP(int paramInt)
  {
    QLog.d(TAG, 1, "reportPadFaceShown");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", Long.parseLong(this.app.getCurrentAccountUin()));
      localJSONObject2.put("id", paramInt);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "3.4.4.3058");
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12827", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "QQVacCommSvc.report_padface_shown");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[reportPadFaceShown] exception=", localException);
    }
  }
  
  public void XQ(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "sendKapuReportDownload sourceId:", Integer.valueOf(paramInt) });
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("actId", 1);
      ((JSONObject)localObject).put("sourceId", paramInt);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "cmshowar_activity_template.report_user_source");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[sendKapuReportDownload] exception=", localException);
    }
  }
  
  public void Y(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "[handleKapuReportDownload] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(TAG, 1, "[handleKapuReportDownload] err:" + paramIntent.getMessage());
    }
  }
  
  public void Z(int paramInt, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[reportGamePubAccountMsgList] status:" + paramInt + " size:" + paramList.size());
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    Iterator localIterator = paramList.iterator();
    MonitReport.PublicAccountReq localPublicAccountReq;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localPublicAccountReq = new MonitReport.PublicAccountReq();
      localPublicAccountReq.action.set(paramInt);
      paramList = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
      if (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("pa_msgId"))) {
        break label300;
      }
      paramList = "0";
    }
    label300:
    for (;;)
    {
      localPublicAccountReq.msgid.set(Long.parseLong(paramList));
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      break;
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramList = new NewIntent(this.app.getApp(), aqre.class);
      paramList.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramList.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramList);
      return;
    }
  }
  
  public void Z(String[] paramArrayOfString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        try
        {
          long l = Long.parseLong(str);
          ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_level.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_status.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_timestamp.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_cmshow_3d_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_super_yellow_diamond.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(15);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.app.getApp(), aqre.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x5eb_15");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("uins", paramArrayOfString);
    this.app.startServlet((NewIntent)localObject);
  }
  
  public JSONObject a(String paramString, List<ApolloGameScoreData> paramList)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("uin", Long.parseLong(paramString));
      paramString = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("gameId", localApolloGameScoreData.mGameId);
        localJSONObject2.put("score", localApolloGameScoreData.mScore);
        paramString.put(localJSONObject2);
      }
      localJSONObject1.put("gameList", paramString);
    }
    catch (Throwable paramString)
    {
      QLog.e(TAG, 1, "[getScoreParam]", paramString);
      return null;
    }
    return localJSONObject1;
  }
  
  public void a(int paramInt, Bundle paramBundle, PraiseManager.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "requestPraiseAuth, praiseId=" + paramInt);
    }
    Object localObject = new praise_sso.TSsoCmd0x1Req();
    ((praise_sso.TSsoCmd0x1Req)localObject).i32_itemId.set(paramInt);
    praise_sso.TPraiseSsoReq localTPraiseSsoReq = new praise_sso.TPraiseSsoReq();
    localTPraiseSsoReq.i32_cmd.set(1);
    localTPraiseSsoReq.i32_implat.set(109);
    localTPraiseSsoReq.str_qq_ver.set("3.4.4.3058");
    localTPraiseSsoReq.st_cmd0x1_req.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), aqre.class);
    ((NewIntent)localObject).putExtra("cmd", "Praise.sso");
    ((NewIntent)localObject).putExtra("data", localTPraiseSsoReq.toByteArray());
    this.mReqBundle = paramBundle;
    this.b = paramb;
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, float paramFloat, int paramInt3, String paramString3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.check_act");
      if (TextUtils.isEmpty(paramString3)) {}
      for (localObject = "android";; localObject = "android." + paramString3)
      {
        localJSONObject.put("from", localObject);
        localJSONObject.put("actid", paramInt1);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        localObject = new NewIntent(this.app.getApp(), aqre.class);
        ((NewIntent)localObject).putExtra("cmd", "apollo_core.check_act");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("actionId", paramInt1);
        if (!TextUtils.isEmpty(paramString1)) {
          ((NewIntent)localObject).putExtra("actionText", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((NewIntent)localObject).putExtra("textType", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          ((NewIntent)localObject).putExtra("optFrom", paramString3);
        }
        ((NewIntent)localObject).putExtra("audioId", paramInt2);
        ((NewIntent)localObject).putExtra("audioTime", paramFloat);
        ((NewIntent)localObject).putExtra("isPlayDefultAudio", paramInt3);
        this.app.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "checkActionAuth failed id: " + paramInt1, paramString1);
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[getGameOnlineUserCount] gameId=", Integer.valueOf(paramInt1), ", from=", paramString1 });
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
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_playing_usernum");
      ((JSONObject)localObject).put("from", paramString1);
      ((JSONObject)localObject).put("gameId", paramInt1);
      ((JSONObject)localObject).put("opType", paramInt2);
      ((JSONObject)localObject).put("theme", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString1 = new NewIntent(this.app.getApp(), aqre.class);
      paramString1.putExtra("cmd", "apollo_aio_game.get_playing_usernum");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString1.putExtra("tipsBarAnimation", paramBoolean);
      this.app.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "[getGameOnlineUserCount] exception=", paramString1);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    boolean bool = paramIntent.getBooleanExtra("isCMShowJSRequest", false);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (bool)
      {
        d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (str.equals(cwl))
      {
        a(paramIntent, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_avatar".equals(str))
      {
        q(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.set_status".equals(str))
      {
        r(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_user_info".equals(str))
      {
        s(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.check_act".equals(str))
      {
        t(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x5eb_15".equals(str))
      {
        u(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_extend.zan".equals(str))
      {
        v(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_extend.set_user_flag".equals(str))
      {
        C(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (cwm.equals(str))
      {
        f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("scupdate.handle".equals(str))
      {
        w(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_motto.get_user_motto".equals(str))
      {
        x(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopAct.ReqAct".equals(str))
      {
        y(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopActRead.GetActStatus".equals(str))
      {
        z(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopAuthCodeSvc.AuthCode".equals(str))
      {
        A(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.check_game_v2".equals(str))
      {
        E(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.get_game_room_state".equals(str))
      {
        B(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x5eb_99".equals(str))
      {
        F(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("Praise.sso".equals(str))
      {
        g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("vaspoke.check".equals(str))
      {
        G(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_terminal_info.get_user_appear_info".equals(str))
      {
        H(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.get_playing_usernum".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.join_av_room".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.get_av_ctrl_param".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.get_usraccinfo".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_currency.buy_item_by_curre".equals(str))
      {
        J(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_red_dot.get_reddot_info".equals(str))
      {
        D(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_router_game.game_relation_linkcmd_get_rank_chg".equals(str))
      {
        I(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.save_user_gamepanel_gamelist".equals(str))
      {
        K(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("Groupeffect.commop".equals(str))
      {
        L(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("gxzbpublic.filter".equals(str))
      {
        Q(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_dc_report.service_monit".equals(str))
      {
        T(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_router_game.apl_sq_wl_linkcmd_get_all".equals(str))
      {
        R(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x8fc_3".equals(str))
      {
        h(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("ltgame_addr_distribute.get_iplist".equals(str))
      {
        S(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_router_game.apl_plus_d_linkcmd_get".equals(str))
      {
        P(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (("apollo_game_login.get_user_game_list_info".equals(str)) || ("apollo_aio_game.get_user_game_list_info".equals(str)))
      {
        M(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (("apollo_game_login.get_game_conf_info".equals(str)) || ("apollo_aio_game.get_game_conf_info".equals(str)))
      {
        N(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.get_user_dev_gamelist".equals(str))
      {
        O(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.set_model".equals(str))
      {
        U(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("cmshowar_message_plat.get_msg".equals(str))
      {
        n(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("QQVacCommSvc.get_feeds".equals(str))
      {
        o(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("QQVacCommSvc.get_padface_add".equals(str))
      {
        V(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("QQVacCommSvc.report_padface_shown".equals(str))
      {
        W(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("QQVacCommSvc.get_friends".equals(str))
      {
        p(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("QQVacCommSvc.get_game_register_info".equals(str))
      {
        X(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("cmshowar_activity_template.report_user_source".equals(str))
      {
        Y(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "unknow cmd :" + str);
  }
  
  public void a(Intent paramIntent, byte[] paramArrayOfByte)
  {
    Object localObject1 = new PendantMarket.SetAddonRsp();
    try
    {
      ((PendantMarket.SetAddonRsp)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "handlePendantAuthRsp rsp.mergeFrom e=" + paramArrayOfByte);
        paramArrayOfByte = null;
      }
      Bundle localBundle = new Bundle();
      int i = paramArrayOfByte.int_result.get();
      localBundle.putLong("pendantId", paramIntent.getLongExtra("pendantId", -1L));
      localBundle.getInt("seriesId", paramIntent.getIntExtra("seriesId", -1));
      localBundle.putString("uin", paramIntent.getStringExtra("uin"));
      if (i == 0) {
        break label579;
      }
      if (!paramArrayOfByte.tips_info.has()) {
        break label377;
      }
      Object localObject2 = new PendantMarket.TipsInfo();
      try
      {
        ((PendantMarket.TipsInfo)localObject2).mergeFrom(paramArrayOfByte.tips_info.toByteArray());
        localObject3 = new PendantTipsInfo();
        boolean bool = ((PendantMarket.TipsInfo)localObject2).valid.get();
        ((PendantTipsInfo)localObject3).valid = bool;
        if (bool)
        {
          ((PendantTipsInfo)localObject3).type = ((PendantMarket.TipsInfo)localObject2).type.get();
          localObject1 = ((PendantMarket.TipsInfo)localObject2).title_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = acfp.m(2131716310);
          }
          ((PendantTipsInfo)localObject3).titleWording = paramIntent;
          ((PendantTipsInfo)localObject3).wording = ((PendantMarket.TipsInfo)localObject2).wording.get();
          localObject1 = ((PendantMarket.TipsInfo)localObject2).right_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = acfp.m(2131716311);
          }
          ((PendantTipsInfo)localObject3).rightBtnWording = paramIntent;
          localObject1 = ((PendantMarket.TipsInfo)localObject2).left_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = acfp.m(2131716309);
          }
          ((PendantTipsInfo)localObject3).leftBtnWording = paramIntent;
          ((PendantTipsInfo)localObject3).vipType = ((PendantMarket.TipsInfo)localObject2).vip_type.get();
          ((PendantTipsInfo)localObject3).vipMonth = ((PendantMarket.TipsInfo)localObject2).vip_month.get();
          ((PendantTipsInfo)localObject3).url = ((PendantMarket.TipsInfo)localObject2).url.get();
        }
        localBundle.putSerializable("tipsInfo", (Serializable)localObject3);
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        for (;;)
        {
          label377:
          QLog.e(TAG, 1, "handlePendantAuthRsp tipsInfo.mergeFrom e=" + paramIntent);
        }
        if (!paramArrayOfByte.str_msg.has()) {
          break label565;
        }
      }
      if (!QLog.isColorLevel()) {
        break label409;
      }
      QLog.e("VasExtensionHandler", 2, "response from server error: " + i);
      label409:
      localBundle.putInt("result", i);
      switch (i)
      {
      case 1002: 
      case 1004: 
      case 2001: 
      case 2002: 
      default: 
        notifyUI(1, false, localBundle);
        return;
      }
      paramIntent = paramArrayOfByte.str_msg.get();
      label526:
      if (!paramArrayOfByte.str_url.has()) {
        break label572;
      }
      label565:
      label572:
      for (paramArrayOfByte = paramArrayOfByte.str_url.get();; paramArrayOfByte = "")
      {
        localBundle.putString("tips", paramIntent);
        localBundle.putString("url", paramArrayOfByte);
        break;
        paramIntent = "";
        break label526;
      }
      label579:
      if (this.app == null) {
        break label679;
      }
      localObject2 = (acff)this.app.getManager(51);
      Object localObject3 = paramIntent.getStringExtra("uin");
      localObject1 = ((acff)localObject2).a((String)localObject3);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 != null) {
        break label640;
      }
      paramArrayOfByte = new ExtensionInfo();
      paramArrayOfByte.uin = ((String)localObject3);
      label640:
      paramArrayOfByte.pendantId = paramIntent.getLongExtra("pendantId", -1L);
      paramArrayOfByte.pendantDiyId = paramIntent.getIntExtra("pendantDiyId", 0);
      paramArrayOfByte.timestamp = System.currentTimeMillis();
      ((acff)localObject2).a(paramArrayOfByte);
      label679:
      notifyUI(1, true, localBundle);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  public void a(aqrb.a parama)
  {
    if (parama == null)
    {
      this.it = null;
      return;
    }
    this.it = new WeakReference(parama);
  }
  
  public void a(aqrb.b paramb)
  {
    synchronized (this.IY)
    {
      this.IY.add(paramb);
      return;
    }
  }
  
  public void a(ReportInfoManager.ReportChannlInfo paramReportChannlInfo)
  {
    QLog.d(TAG, 1, "reportGameCenterChannel");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("qq_version", "3.4.4.3058");
      Field[] arrayOfField = paramReportChannlInfo.getClass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localJSONObject2.put(localField.getName(), localField.get(paramReportChannlInfo));
        i += 1;
      }
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12886", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramReportChannlInfo = new NewIntent(this.app.getApp(), aqre.class);
      paramReportChannlInfo.putExtra("cmd", "QQVacCommSvc.report_channel");
      paramReportChannlInfo.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramReportChannlInfo);
      return;
    }
    catch (Exception paramReportChannlInfo)
    {
      paramReportChannlInfo.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      QLog.e(TAG, 1, "[doSaveGameList] empty list");
      return;
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
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.save_user_gamepanel_gamelist");
      ((JSONObject)localObject).put("from", "android");
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
      ((JSONObject)localObject).put("gameIdList", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[doSaveGameList] " + ((JSONObject)localObject).toString());
      }
      paramArrayOfInt = new NewIntent(paramQQAppInterface.getApp(), aqre.class);
      paramArrayOfInt.putExtra("cmd", "apollo_aio_game.save_user_gamepanel_gamelist");
      paramArrayOfInt.putExtra("data", localUniSsoServerReq.toByteArray());
      paramQQAppInterface.startServlet(paramArrayOfInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e(TAG, 1, "[getGameOnlineUserCount] exception=", paramQQAppInterface);
    }
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, List<String> paramList, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.d(TAG, 1, "getGamePubAccountFeeds");
    Object localObject;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    try
    {
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("msg_id", paramLong1);
      localJSONObject2.put("msg_time", paramLong2);
      localJSONObject2.put("title", "");
      localJSONObject2.put("tt", 1);
      localJSONObject2.put("uin", "");
      localJSONObject2.put("appid", paramString2);
      localJSONObject2.put("ext_json", paramString3);
      paramString3 = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString3.put((String)paramList.next());
      }
      localJSONObject2.put("view_feed_id_list", paramString3);
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "[getCmGameConnInfo] exception=", paramString1);
      return;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localJSONObject2.put("get_top_card", i);
      localJSONObject2.put("qq_version", "3.4.4");
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12787", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramList = new NewIntent(this.app.getApp(), aqre.class);
      paramList.putExtra("cmd", "QQVacCommSvc.get_feeds");
      paramList.putExtra("data", localUniSsoServerReq.toByteArray());
      paramList.putExtra("msgId", paramString1);
      paramList.putExtra("msgSeq", paramLong1);
      paramList.putExtra("appId", paramString2);
      paramList.putExtra("fromBottom", paramBoolean);
      this.app.startServlet(paramList);
      return;
    }
  }
  
  void a(String paramString, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = 0;
    long l;
    if ("apollo_game_av.join_av_room".equals(paramString))
    {
      l = paramIntent.getLongExtra("usrdata", 0L);
      if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
        asrt.a().a(l, false, null);
      }
    }
    for (;;)
    {
      return;
      paramString = new WebSSOAgent.UniSsoServerRsp();
      paramIntent = new qqavopensdkSsoTunnel.STAudioVideoRsp();
      try
      {
        paramString.mergeFrom(paramArrayOfByte);
        paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
        paramString = ((qqavopensdkSsoTunnel.RspBody)((qqavopensdkSsoTunnel.STAudioVideoRsp)paramIntent.get()).rspbody.get()).bytes_rspbody.get().toByteArray();
        asrt.a().a(l, true, paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(TAG, 1, "handleRoomSSOInfoCallback error:", paramString);
        return;
      }
      if ("apollo_game_av.get_av_ctrl_param".equals(paramString))
      {
        l = paramIntent.getLongExtra("usrdata", 0L);
        if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
        {
          asrt.a().a(l, false, null);
          return;
        }
        paramString = new WebSSOAgent.UniSsoServerRsp();
        paramIntent = new qqavopensdkSsoTunnel.STAVCtrlParamRsp();
        try
        {
          paramString.mergeFrom(paramArrayOfByte);
          paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
          paramString = ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)paramIntent.get()).ctrlParam.get().toByteArray();
          asrt.a().a(l, true, paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e(TAG, 1, "handleRoomSSOInfoCallback error:", paramString);
          return;
        }
      }
      if ((!"apollo_game_av.get_usraccinfo".equals(paramString)) || (paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
        continue;
      }
      paramString = new GetTinyID.STTinyID2UserAccInfoRsp();
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        paramString.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        paramString = ((GetTinyID.STTinyID2UserAccInfoRsp)paramString.get()).user_acc_info.get();
        if ((paramString == null) || (paramString.size() <= 0)) {
          continue;
        }
        paramIntent = new ArrayList(paramString.size());
        paramFromServiceMsg = new ArrayList(paramString.size());
        while (i < paramString.size())
        {
          paramIntent.add(Long.valueOf(((GetTinyID.STUserAccInfo)paramString.get(i)).tinyid.get()));
          paramFromServiceMsg.add(((GetTinyID.STUserAccInfo)paramString.get(i)).identifier.get());
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(TAG, 1, "handleRoomSSOInfoCallback error:", paramString);
      }
    }
  }
  
  public void a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (this.IY)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.IY.iterator();
      while (localIterator.hasNext())
      {
        aqrb.b localb = (aqrb.b)localIterator.next();
        if (localb.b(paramString, paramApolloBaseInfo)) {
          localArrayList.add(localb);
        }
      }
    }
    this.IY.removeAll(localArrayList);
  }
  
  public void a(String paramString1, List<ApolloGameScoreData> paramList1, String paramString2, List<ApolloGameScoreData> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getApolloStandAction.");
    }
    if ((this.app == null) || (TextUtils.isEmpty(paramString1)) || (paramList1 == null)) {
      QLog.e(TAG, 1, "[requestGameRank] uin is empty");
    }
    do
    {
      return;
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_router_game.game_relation_linkcmd_get_rank_chg");
        ((JSONObject)localObject).put("from", "android");
        ((JSONObject)localObject).put("aioType", 1);
        ((JSONObject)localObject).put("sessionId", Long.parseLong(paramString2));
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(a(paramString1, paramList1));
        localJSONArray.put(a(paramString2, paramList2));
        ((JSONObject)localObject).put("gScoreList", localJSONArray);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "requestGameRank request:" + localObject);
        }
        paramString1 = new NewIntent(this.app.getApp(), aqre.class);
        paramString1.putExtra("cmd", "apollo_router_game.game_relation_linkcmd_get_rank_chg");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString1);
        VipUtils.a(this.app, "cmshow", "Apollo", "get_rank_compare", 1, 0, new String[0]);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getApolloStandAction failed ", paramString1);
  }
  
  protected void a(String paramString, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (a(paramUdcUinData.roam_flag_svip_5year)) {
      i = 5;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onGetRoamType: " + i);
      }
      this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_flag" + paramString, i).commit();
      this.app.getBusinessHandler(13).notifyUI(114, true, new Object[] { paramString, Integer.valueOf(i) });
      return;
      if ((a(paramUdcUinData.roam_flag_svip_2year)) || (a(paramUdcUinData.roam_flag_svip_forever))) {
        i = 4;
      } else if (a(paramUdcUinData.roam_flag_vip_30day)) {
        i = 3;
      } else if (a(paramUdcUinData.roam_flag_qq_7day)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 0;
    Object localObject1 = new oidb_0x5eb.ReqBody();
    Object localObject2 = new ArrayList();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i];
      if (!((List)localObject2).contains(str)) {
        ((List)localObject2).add(str);
      }
      i += 1;
    }
    paramArrayOfString = (String[])((List)localObject2).toArray(new String[1]);
    k = paramArrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i < k)
      {
        localObject2 = paramArrayOfString[i];
        try
        {
          long l = Long.parseLong((String)localObject2);
          ((oidb_0x5eb.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    boolean bool2 = false;
    boolean bool1 = false;
    i = j;
    if (i < paramArrayOfInt.length)
    {
      switch (paramArrayOfInt[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_font_id_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_magicfont_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_face_addon_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_bubble_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_colorring_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_praise_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_game_appid.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_game_last_login_time.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_voicebubble_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_plate_of_king_dan.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_plate_of_king_dan_display_switch.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_pendant_diy_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_suspend_effect_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_face_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_diy_font_timestamp_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_font_effect_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_qq_7day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_vip_30day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_2year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_5year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_forever.set(1);
        bool1 = true;
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_qq_level_icon_type_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_theme_font_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_bubble_unread_switch.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_listen_together_player_id.set(1);
        bool2 = true;
      }
    }
    QLog.d(TAG, 2, "batchGetStrangerVasInfo, uins: " + Arrays.toString(paramArrayOfString) + " fields: " + Arrays.toString(paramArrayOfInt));
    paramArrayOfInt = new oidb_sso.OIDBSSOPkg();
    paramArrayOfInt.uint32_command.set(1515);
    paramArrayOfInt.uint32_service_type.set(99);
    paramArrayOfInt.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.app.getApp(), aqre.class);
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x5eb_99");
    ((NewIntent)localObject1).putExtra("data", paramArrayOfInt.toByteArray());
    ((NewIntent)localObject1).putExtra("req_roam_type", bool1);
    ((NewIntent)localObject1).putExtra("req_music_type", bool2);
    ((NewIntent)localObject1).putExtra("uins", paramArrayOfString);
    this.app.startServlet((NewIntent)localObject1);
  }
  
  public void aF(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      paramString = "";
      localObject = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "content == null");
        localObject = paramString;
      }
    }
    paramString = new DiyEmotionPb.Filter_Req();
    paramString.cmd.set(1);
    DiyEmotionPb.Filter_Req_Comm localFilter_Req_Comm = new DiyEmotionPb.Filter_Req_Comm();
    localFilter_Req_Comm.platform.set(1L);
    localFilter_Req_Comm.mqqver.set("3.4.4");
    localFilter_Req_Comm.osver.set(Build.VERSION.RELEASE);
    DiyEmotionPb.Filter_Text_Req localFilter_Text_Req = new DiyEmotionPb.Filter_Text_Req();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localFilter_Text_Req.text.set(localArrayList);
    paramString.comm.set(localFilter_Req_Comm);
    paramString.reqcmd_0x01.set(localFilter_Text_Req);
    if (this.app != null)
    {
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "gxzbpublic.filter");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 30000L);
      atH = SystemClock.uptimeMillis();
      this.app.startServlet((NewIntent)localObject);
    }
  }
  
  public void aM(long paramLong1, long paramLong2)
  {
    group_effect_commu.ReqBody localReqBody = new group_effect_commu.ReqBody();
    localReqBody.u64_cmd.set(paramLong1);
    localReqBody.u64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localReqBody.i32_implat.set(109);
    localReqBody.str_version.set(aqgz.getQQVersion());
    Object localObject;
    if (paramLong1 == 8192L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "sendTroopEnterEffectCMD ENTER_GROUP troopId = " + paramLong2);
      }
      localObject = new group_effect_commu.TEntryNotifyReq0x2000();
      ((group_effect_commu.TEntryNotifyReq0x2000)localObject).group_id.set(paramLong2);
      localReqBody.st_entry_notify.set((MessageMicro)localObject);
    }
    for (;;)
    {
      localObject = new NewIntent(this.mApp.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "Groupeffect.commop");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).putExtra("usrdata", paramLong1);
      this.app.startServlet((NewIntent)localObject);
      return;
      if (paramLong1 == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "sendTroopEnterEffectCMD GET_MY_EFFECT troopId = " + paramLong2);
        }
        localObject = new group_effect_commu.TGetMyEffectReq0x2();
        localReqBody.st_get_effect.set((MessageMicro)localObject);
      }
    }
  }
  
  public void ab(String paramString1, String paramString2, int paramInt)
  {
    QLog.d(TAG, 1, "[reportGameAchievement]");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString1);
      localJSONObject2.put("tt", 1);
      localJSONObject2.put("type", paramInt);
      localJSONObject2.put("uin", paramString2);
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("13077", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.app.getApp(), aqre.class);
      paramString2.putExtra("cmd", "GameCenterWebSvc.13077");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("appid", paramString1);
      this.app.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "[reportGameAchievement] exception=", paramString1);
    }
  }
  
  public void ag(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "");
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
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_core.get_user_info");
        if (!TextUtils.isEmpty(paramString2)) {
          break label335;
        }
        paramString2 = "android";
        localJSONObject.put("from", paramString2);
        localJSONObject.put("touin", Long.valueOf(paramString1));
        localJSONObject.put("mask", i);
        localObject = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder().append("skey=");
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2 = "";
        }
        localJSONObject.put("Cookie", paramString2);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        paramString2 = new NewIntent(this.app.getApp(), aqre.class);
        paramString2.putExtra("cmd", "apollo_core.get_user_info");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString2.putExtra("touin", paramString1);
        paramString2.putExtra("mask", i);
        this.app.startServlet(paramString2);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "getUserApolloInfo failed ", paramString1);
      return;
      label335:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
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
      ((JSONObject)localObject).put("id", paramInt1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "vaspoke.check");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 20000);
      ((NewIntent)localObject).putExtra("id", paramInt1);
      ((NewIntent)localObject).putExtra("name", paramString1);
      ((NewIntent)localObject).putExtra("minVersion", paramString2);
      ((NewIntent)localObject).putExtra("feeType", paramInt2);
      ((NewIntent)localObject).putExtra("fromType", paramInt3);
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "handlePokeAuth failed ", paramString1);
    }
  }
  
  public boolean bX(String paramString1, String paramString2)
  {
    try
    {
      SCUpdatePB.SCUpdateReq localSCUpdateReq = new SCUpdatePB.SCUpdateReq();
      localSCUpdateReq.comm.plat.set(109);
      localSCUpdateReq.comm.qver.set(ByteStringMicro.copyFrom("3.4.4.3058".getBytes()));
      localSCUpdateReq.comm.osrelease.set(ByteStringMicro.copyFrom(String.valueOf(Build.VERSION.SDK_INT).getBytes()));
      localSCUpdateReq.comm.network.set(aqiw.getNetworkType(this.app.getApplication()));
      localSCUpdateReq.comm.setHasFlag(true);
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("cookie")) {
        localSCUpdateReq.comm.cookie.set(paramString2.optLong("cookie"));
      }
      long l1;
      int i;
      long l2;
      long l3;
      Object localObject;
      int j;
      SCUpdatePB.ItemVersion localItemVersion;
      if (cwn.equals(paramString1))
      {
        localSCUpdateReq.cmd.set(1);
        l1 = paramString2.optLong("seq");
        i = paramString2.optInt("sync_mode");
        l2 = paramString2.optLong("plver");
        l3 = paramString2.optLong("rpver");
        localSCUpdateReq.req0x01.seq.set(l1);
        localSCUpdateReq.req0x01.sync_mode.set(i);
        localSCUpdateReq.req0x01.plver.set(l2);
        localSCUpdateReq.req0x01.rpver.set(l3);
        paramString1 = paramString2.optJSONArray("item_list");
        if (paramString1 != null)
        {
          i = 0;
          while (i < paramString1.length())
          {
            localObject = paramString1.getJSONObject(i);
            j = ((JSONObject)localObject).optInt("bid");
            paramString2 = ((JSONObject)localObject).optString("scid");
            localObject = ((JSONObject)localObject).optString("version");
            localItemVersion = new SCUpdatePB.ItemVersion();
            localItemVersion.bid.set(j);
            localItemVersion.scid.set(paramString2);
            localItemVersion.version.set((String)localObject);
            localSCUpdateReq.req0x01.item_list.add(localItemVersion);
            i += 1;
          }
        }
        localSCUpdateReq.req0x01.setHasFlag(true);
      }
      for (;;)
      {
        localSCUpdateReq.setHasFlag(true);
        paramString1 = new NewIntent(this.app.getApp(), aqre.class);
        paramString1.putExtra("cmd", "scupdate.handle");
        paramString1.putExtra("data", localSCUpdateReq.toByteArray());
        this.app.startServlet(paramString1);
        return true;
        if (cwp.equals(paramString1))
        {
          localSCUpdateReq.cmd.set(2);
          l1 = paramString2.optLong("delta_mode");
          l2 = paramString2.optLong("storage_mode");
          l3 = paramString2.optLong("compress_mode");
          paramString1 = paramString2.optString("from");
          localSCUpdateReq.comm.from.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
          localSCUpdateReq.req0x02.delta_mode.set((int)l1);
          localSCUpdateReq.req0x02.storage_mode.set((int)l2);
          localSCUpdateReq.req0x02.compress_mode.set((int)l3);
          paramString1 = paramString2.optJSONArray("item_list");
          if (paramString1 != null)
          {
            i = 0;
            while (i < paramString1.length())
            {
              localObject = paramString1.getJSONObject(i);
              j = ((JSONObject)localObject).optInt("bid");
              paramString2 = ((JSONObject)localObject).optString("scid");
              localObject = ((JSONObject)localObject).optString("srcMd5");
              localItemVersion = new SCUpdatePB.ItemVersion();
              localItemVersion.bid.set(j);
              localItemVersion.scid.set(paramString2);
              localItemVersion.version.set((String)localObject);
              localSCUpdateReq.req0x02.item_list.add(localItemVersion);
              i += 1;
            }
          }
          localSCUpdateReq.req0x02.setHasFlag(true);
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = paramString1.getStackTrace();
        i = 0;
        while (i < paramString1.length)
        {
          QLog.e(TAG, 2, paramString1[i].toString());
          i += 1;
        }
      }
    }
  }
  
  public void bm(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[getGameStatusReq], cmd:" + paramString1 + ",reqData:" + paramString2 + ",extraInfo:" + paramString3);
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set(paramString2);
      paramString2 = new NewIntent(this.app.getApp(), aqre.class);
      paramString2.putExtra("usrdata", paramString3);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "getGameStatusReq failed ", paramString1);
    }
  }
  
  public void c(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleNamePlateOfKingInfo : uin = " + paramString + ", gameId = " + paramLong1 + ", gameLoginTime = " + paramLong2 + ", dan = " + paramInt1 + ", dansSwitch = " + paramInt2);
    }
    Object localObject = (acff)this.app.getManager(51);
    Card localCard = ((acff)localObject).b(paramString);
    localObject = ((acff)localObject).e(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.app.getCurrentUin().equals(paramString)))
    {
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      String str = "plate_of_king_display_switch_" + this.app.getCurrentUin();
      if (paramInt2 == 1)
      {
        bool1 = true;
        localEditor.putBoolean(str, bool1).apply();
      }
    }
    else if (localCard != null)
    {
      localCard.namePlateOfKingGameId = paramLong1;
      localCard.namePlateOfKingLoginTime = paramLong2;
      localCard.namePlateOfKingDan = paramInt1;
      if (paramInt2 != 1) {
        break label326;
      }
    }
    label326:
    for (boolean bool1 = true;; bool1 = false)
    {
      localCard.namePlateOfKingDanDisplatSwitch = bool1;
      this.app.getBusinessHandler(2).notifyUI(1, true, localCard);
      if (localObject != null)
      {
        ((Friends)localObject).namePlateOfKingGameId = paramLong1;
        ((Friends)localObject).namePlateOfKingLoginTime = paramLong2;
        ((Friends)localObject).namePlateOfKingDan = paramInt1;
        bool1 = bool2;
        if (paramInt2 == 1) {
          bool1 = true;
        }
        ((Friends)localObject).namePlateOfKingDanDisplatSwitch = bool1;
        this.app.getBusinessHandler(1).notifyUI(3, true, paramString);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      for (;;)
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp;
        Object localObject;
        try
        {
          if (!paramFromServiceMsg.isSuccess()) {
            break;
          }
          localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
          localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get()).toString();
          paramFromServiceMsg = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            paramFromServiceMsg = "{}";
          }
          long l = paramIntent.getLongExtra("usrdata", 0L);
          paramArrayOfByte = paramIntent.getStringExtra("cmd");
          int i = paramIntent.getIntExtra("callFrom", 0);
          localObject = (abhe)this.app.getManager(211);
          if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramArrayOfByte)) || ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramArrayOfByte)))
          {
            ((abhe)localObject).a(localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d(TAG, 2, "ret:" + localUniSsoServerRsp.ret.get() + ",data:" + paramFromServiceMsg + ",cmd:" + paramArrayOfByte);
            return;
          }
          if (i != 4) {
            break label312;
          }
          ApolloCmdChannel.getChannel(this.app).callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg);
          continue;
          QLog.d(TAG, 2, "errInfo->" + paramIntent.getMessage());
        }
        catch (Exception paramIntent)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
        label312:
        if ("apollo_terminal_info.get_user_slaves_v2".equals(paramArrayOfByte))
        {
          localObject = ((abhh)this.app.getManager(153)).a();
          if (localObject != null) {
            ((abhs)localObject).l(localUniSsoServerRsp.ret.get(), paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resp data is err.");
    }
    if ("apollo_aio_game.check_game_v2".equals("")) {
      notifyUI(21, false, null);
    }
  }
  
  public void d(long... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getApolloStandAction.");
    }
    if (paramVarArgs.length == 0) {}
    do
    {
      return;
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_terminal_info.get_user_appear_info");
        ((JSONObject)localObject).put("from", "android");
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        while (i < paramVarArgs.length)
        {
          localJSONArray.put(paramVarArgs[i]);
          i += 1;
        }
        ((JSONObject)localObject).put("touins", localJSONArray);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramVarArgs = new NewIntent(this.app.getApp(), aqre.class);
        paramVarArgs.putExtra("cmd", "apollo_terminal_info.get_user_appear_info");
        paramVarArgs.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramVarArgs);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getApolloStandAction failed ", paramVarArgs);
  }
  
  public void dX(int paramInt, String paramString)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
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
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_status");
        if (!TextUtils.isEmpty(paramString)) {
          break label211;
        }
        paramString = "android";
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("status", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.app.getApp(), aqre.class);
        paramString.putExtra("cmd", "apollo_core.set_status");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("apollo_status", paramInt);
        this.app.startServlet(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "changeApolloStatus failed ", paramString);
      return;
      label211:
      paramString = "android." + paramString;
    }
  }
  
  public void e(List<Integer> paramList, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if ((this.app == null) || (paramList == null) || (paramList.size() == 0))
        {
          QLog.e(TAG, 1, "[getGameConfigListReq] app is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STGameLogin.STGetGameConfReq();
        ((STGameLogin.STGetGameConfReq)localObject).game_id_list.set(paramList);
        ((STGameLogin.STGetGameConfReq)localObject).from.set("android");
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STGameLogin.STGetGameConfReq)localObject).toByteArray()));
        boolean bool = ((abhh)this.app.getManager(153)).jn(this.app.getCurrentUin());
        if (bool)
        {
          paramList = "apollo_aio_game.get_game_conf_info";
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, new Object[] { "getGameConfigListReq isGameWhiteUser:", Boolean.valueOf(bool) });
          }
          localObject = new NewIntent(this.app.getApp(), aqre.class);
          ((NewIntent)localObject).putExtra("extras", paramBundle);
          ((NewIntent)localObject).putExtra("cmd", paramList);
          ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
          this.app.startServlet((NewIntent)localObject);
          return;
        }
      }
      catch (Exception paramList)
      {
        QLog.e(TAG, 1, "[getGameConfigListReq] exception=", paramList);
        return;
      }
      paramList = "apollo_game_login.get_game_conf_info";
    }
  }
  
  public void efe()
  {
    for (;;)
    {
      try
      {
        if (this.app == null)
        {
          QLog.e(TAG, 1, "[getApolloLoginData] app is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STGameLogin.STGameLoginReq();
        long l = ApolloGameUtil.g(this.app);
        ((STGameLogin.STGameLoginReq)localObject).local_ts.set((int)l);
        ((STGameLogin.STGameLoginReq)localObject).from.set("android");
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STGameLogin.STGameLoginReq)localObject).toByteArray()));
        boolean bool = ((abhh)this.app.getManager(153)).jn(this.app.getCurrentUin());
        if (bool)
        {
          localObject = "apollo_aio_game.get_user_game_list_info";
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, new Object[] { "getApolloGameLoginReq isGameWhiteUser:", Boolean.valueOf(bool), " ts:", Long.valueOf(l) });
          }
          NewIntent localNewIntent = new NewIntent(this.app.getApp(), aqre.class);
          localNewIntent.putExtra("cmd", (String)localObject);
          localNewIntent.putExtra("data", localUniSsoServerReq.toByteArray());
          this.app.startServlet(localNewIntent);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, "[getApolloGameLoginReq] exception=", localException);
        return;
      }
      String str = "apollo_game_login.get_user_game_list_info";
    }
  }
  
  public void eff()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(TAG, 1, "[getApolloGameDevList] app is null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_user_dev_gamelist");
      ((JSONObject)localObject).put("from", "android");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getApolloGameDevList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_aio_game.get_user_dev_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[getApolloGameDevList] exception=", localException);
    }
  }
  
  public void efg()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(TAG, 1, "[requestApolloWhiteList] app is null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_sq_wl_linkcmd_get_all");
      ((JSONObject)localObject).put("from", "android");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[requestApolloWhiteList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_sq_wl_linkcmd_get_all");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[requestApolloWhiteList] exception=", localException);
    }
  }
  
  public void efh()
  {
    QLog.d(TAG, 1, "getCmGameConnInfo");
    try
    {
      if (this.app == null)
      {
        QLog.e(TAG, 1, "[getCmGameConnInfo] app null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      CmGameMsgTunnel.AddrDistribueReq localAddrDistribueReq = new CmGameMsgTunnel.AddrDistribueReq();
      localAddrDistribueReq.appid.set(2);
      localAddrDistribueReq.net_type.set(abmt.getNetType());
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(localAddrDistribueReq.toByteArray()));
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_addr_distribute.get_iplist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 15000L);
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[getCmGameConnInfo] exception=", localException);
    }
  }
  
  public void efi()
  {
    a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 45033 });
  }
  
  protected void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handlePraiseAuthResponse");
    }
    for (;;)
    {
      int i;
      try
      {
        if (!paramFromServiceMsg.isSuccess())
        {
          QLog.e(TAG, 1, "handlePraiseAuthResponse, isSuccess false, error code=" + paramFromServiceMsg.getResultCode());
          return;
        }
        paramIntent = new praise_sso.TPraiseSsoRsp();
        paramIntent.mergeFrom((byte[])paramObject);
        i = paramIntent.i32_ret.get();
        paramIntent = (praise_sso.TSsoCmd0x1Rsp)paramIntent.st_cmd0x1_rsp.get();
        int j = paramIntent.i32_itemId.get();
        paramIntent = paramIntent.str_url.get();
        if (i == 0)
        {
          PraiseManager.E(this.app, j);
          if ((this.mReqBundle == null) || (this.b == null)) {
            break;
          }
          this.b.a(i, j, paramIntent, this.mReqBundle);
          this.mReqBundle = null;
          this.b = null;
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "handlePraiseAuthResponse exception", paramIntent);
        return;
      }
      QLog.e(TAG, 1, "handlePraiseAuthResponse, ret=" + i);
    }
  }
  
  public void getUsedAppList()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(TAG, 1, "[getUsedAppList]");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[getUsedAppList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_plus_d_linkcmd_get");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[getUsedAppList] exception=", localException);
    }
  }
  
  public void gr(String paramString, int paramInt)
  {
    QLog.d(TAG, 1, "getGameFriendList");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("friend_type", paramInt);
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12825", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.app.getApp(), aqre.class);
      paramString.putExtra("cmd", "QQVacCommSvc.get_friends");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "[getGameFriendList] exception=", paramString);
    }
  }
  
  public void gs(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_model");
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("model", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.app.getApp(), aqre.class);
        paramString.putExtra("cmd", "apollo_core.set_model");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("model", paramInt);
        this.app.startServlet(paramString);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, paramString.getMessage());
      }
    }
  }
  
  public void iq(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
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
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_extend.zan");
        if (!TextUtils.isEmpty(paramString2)) {
          break label202;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString1));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString1 = new NewIntent(this.app.getApp(), aqre.class);
        paramString1.putExtra("cmd", "apollo_extend.zan");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "changeApolloStatus failed ", paramString1);
      return;
      label202:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void ir(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
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
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_motto.get_user_motto");
        if (!TextUtils.isEmpty(paramString2)) {
          break label249;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        paramString2 = new JSONArray();
        paramString2.put(Long.parseLong(paramString1));
        ((JSONObject)localObject).put("uins", paramString2);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString2 = new NewIntent(this.app.getApp(), aqre.class);
        paramString2.putExtra("cmd", "apollo_motto.get_user_motto");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 2, "getUserSignStr uin: " + paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "getUserSignStr failed ", paramString1);
      return;
      label249:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void l(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[doCMGameReq], cmd:" + paramString1 + ",reqData:" + paramString2 + ",luaR:" + paramLong + ", app: " + this.app);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if ("apollo_aio_game.report_user_track".equals(paramString1))
      {
        localObject = ApolloUtil.a(paramString2).toByteArray();
        byte[] arrayOfByte = paramString2.getBytes();
        if ((localObject != null) && (localObject.length > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set pb data, orgByte:" + arrayOfByte.length + ",pbByte:" + localObject.length);
          }
          localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom((byte[])localObject));
        }
      }
      for (;;)
      {
        localObject = new NewIntent(this.app.getApp(), aqre.class);
        ((NewIntent)localObject).putExtra("usrdata", paramLong);
        ((NewIntent)localObject).putExtra("cmd", paramString1);
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("callFrom", paramInt);
        ((NewIntent)localObject).putExtra("isCMShowJSRequest", true);
        if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.get_user_uin_or_openid".equals(paramString1)) || ("apollo_terminal_info.get_user_slaves_v2".equals(paramString1))) {
          ((NewIntent)localObject).putExtra("reqData", paramString2);
        }
        this.app.startServlet((NewIntent)localObject);
        return;
        localUniSsoServerReq.reqdata.set(paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public void m(int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(TAG, 1, "getPadFaceAd");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", Long.parseLong(this.app.getCurrentAccountUin()));
      localJSONObject2.put("id", paramInt2);
      localJSONObject2.put("redpoint", paramInt1);
      localJSONObject2.put("last_time", paramLong);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "3.4.4.3058");
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12818", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject).putExtra("cmd", "QQVacCommSvc.get_padface_add");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "[getPadFaceAd] exception=", localException);
    }
  }
  
  public void m(ArrayList<Long> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList.removeAll(this.S);
    Object localObject = paramArrayList;
    if (paramArrayList.size() > 1)
    {
      paramArrayList = new HashSet(paramArrayList);
      localObject = new ArrayList();
      ((ArrayList)localObject).addAll(paramArrayList);
    }
    this.S.addAll((Collection)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getGetUserApolloDress uinList size: " + ((ArrayList)localObject).size() + ", queue size: " + this.S.size() + ",from: " + paramString);
    }
    int i = 0;
    label132:
    if (i < ((ArrayList)localObject).size()) {
      if (i + 16 >= ((ArrayList)localObject).size()) {
        break label197;
      }
    }
    label197:
    for (int j = i + 16;; j = ((ArrayList)localObject).size())
    {
      a((Long[])new ArrayList(((ArrayList)localObject).subList(i, j)).toArray(new Long[0]), paramString);
      i += 16;
      break label132;
      break;
    }
  }
  
  public boolean mF(int paramInt)
  {
    Object localObject = kdm.h();
    if (localObject != null) {
      this.atG = ((SharedPreferences)localObject).getLong("last_jd_req", 0L);
    }
    if (System.currentTimeMillis() - this.atG < 7200000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcshopJd", 2, "failed redInterval return.");
      }
      return false;
    }
    localObject = new qqshop_act.SQQSHPActReadReq();
    ((qqshop_act.SQQSHPActReadReq)localObject).act_id.set(paramInt);
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), aqre.class);
    localNewIntent.putExtra("cmd", "SQQShopActRead.GetActStatus");
    localNewIntent.putExtra("data", ((qqshop_act.SQQSHPActReadReq)localObject).toByteArray());
    localNewIntent.putExtra("timeout", 3000L);
    this.app.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopJd", 2, "jd check sent:" + paramInt);
    }
    return true;
  }
  
  public void nc(List<String> paramList)
  {
    QLog.d(TAG, 1, "[reportDislikeItem]");
    Object localObject;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    try
    {
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      localJSONObject2.put("op_item_id_list", localJSONArray);
    }
    catch (Exception paramList)
    {
      QLog.e(TAG, 1, "[reportDislikeItem] exception=", paramList);
      return;
    }
    localJSONObject1.put("req", localJSONObject2);
    ((JSONObject)localObject).put("12815", localJSONObject1);
    localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
    paramList = new NewIntent(this.app.getApp(), aqre.class);
    paramList.putExtra("cmd", "QQVacCommSvc.dislike");
    paramList.putExtra("data", localUniSsoServerReq.toByteArray());
    this.app.startServlet(paramList);
  }
  
  public void o(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Long.valueOf(paramIntent.getLongExtra("msgSeq", 0L));
    arrayOfObject[1] = Boolean.valueOf(paramIntent.getBooleanExtra("fromBottom", true));
    String str = paramIntent.getStringExtra("msgId");
    paramIntent = paramIntent.getStringExtra("appId");
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      int j;
      Object localObject1;
      int k;
      ArrayList localArrayList;
      FeedsItemData.TopCardInfo localTopCardInfo;
      boolean bool;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "[handleGamePubAccountFeeds] ret=", paramFromServiceMsg.ret.get() + ",data:" + paramFromServiceMsg.rspdata.get() });
          }
          if (paramFromServiceMsg.ret.get() == 0L)
          {
            paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
            j = 0;
            i = j;
            if (paramFromServiceMsg == null) {
              break label2051;
            }
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("12787");
            i = j;
            if (paramFromServiceMsg == null) {
              break label2051;
            }
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("data");
            i = j;
            if (paramFromServiceMsg == null) {
              break label2051;
            }
            localObject1 = paramFromServiceMsg.optJSONObject("rsp");
            i = j;
            if (localObject1 == null) {
              break label2051;
            }
            paramFromServiceMsg = ((JSONObject)localObject1).optJSONArray("feed_list");
            paramArrayOfByte = ((JSONObject)localObject1).optJSONObject("layer_condition");
            k = 1;
            localArrayList = new ArrayList();
            localTopCardInfo = new FeedsItemData.TopCardInfo();
            localObject1 = ((JSONObject)localObject1).optJSONObject("top_card");
            Object localObject2;
            if (localObject1 != null)
            {
              if (((JSONObject)localObject1).optInt("top_card_display_flag", 1) != 0) {
                break label2076;
              }
              bool = false;
              localTopCardInfo.showTopCard = bool;
              localTopCardInfo.msgId = str;
              localObject2 = ((JSONObject)localObject1).optJSONObject("game_info");
              localTopCardInfo.gameInfo = new FeedsItemData.GameInfo();
              if (localObject2 != null)
              {
                localTopCardInfo.gameInfo.gameName = ((JSONObject)localObject2).optString("name");
                localTopCardInfo.gameInfo.gameIcon = ((JSONObject)localObject2).optString("icon");
                localTopCardInfo.gameInfo.gamePkgName = ((JSONObject)localObject2).optString("pkg_name");
                localTopCardInfo.gameInfo.gamePkgSize = ((JSONObject)localObject2).optInt("pkg_size");
                localTopCardInfo.gameInfo.gameStatus = ((JSONObject)localObject2).optInt("status");
                localTopCardInfo.gameInfo.gameApkUrl = ((JSONObject)localObject2).optString("apk_url");
                localTopCardInfo.gameInfo.gameAppId = ((JSONObject)localObject2).optString("appid");
                localTopCardInfo.gameInfo.gameVersionCode = ((JSONObject)localObject2).optString("version_code");
                localTopCardInfo.gameInfo.gameTicket = ((JSONObject)localObject2).optString("tickets");
              }
              localTopCardInfo.actionDesc = ((JSONObject)localObject1).optString("game_info_text");
              localTopCardInfo.prioritiesIconFlag = ((JSONObject)localObject1).optInt("priorities_icon_flag");
              localObject2 = ((JSONObject)localObject1).optJSONArray("entry_list");
              localObject3 = new FeedsItemData.LabelInfo();
              localTopCardInfo.labelInfos = new ArrayList();
              if (((JSONObject)localObject1).optInt("friend_display_flag", 1) != 0) {
                break label2082;
              }
              bool = false;
              ((FeedsItemData.LabelInfo)localObject3).showFriend = bool;
              if (((FeedsItemData.LabelInfo)localObject3).showFriend)
              {
                ((FeedsItemData.LabelInfo)localObject3).isFriend = true;
                ((FeedsItemData.LabelInfo)localObject3).friendType = ((JSONObject)localObject1).optInt("friend_type");
                ((FeedsItemData.LabelInfo)localObject3).friendNum = ((JSONObject)localObject1).optInt("game_friend_total_num");
                ((FeedsItemData.LabelInfo)localObject3).reportId = "10001";
                localObject4 = ((JSONObject)localObject1).optJSONArray("friend_list");
                localObject5 = new ArrayList();
                if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
                {
                  i = 0;
                  j = ((JSONArray)localObject4).length();
                  while (i < j)
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject4).getJSONObject(i);
                    FeedsItemData.FriendInfo localFriendInfo = new FeedsItemData.FriendInfo();
                    localFriendInfo.icon = localJSONObject.optString("icon");
                    localFriendInfo.name = localJSONObject.optString("name");
                    localFriendInfo.uin = localJSONObject.optString("uin");
                    ((List)localObject5).add(localFriendInfo);
                    i += 1;
                  }
                  ((FeedsItemData.LabelInfo)localObject3).friendList = ((List)localObject5);
                }
                localTopCardInfo.labelInfos.add(localObject3);
              }
              localObject4 = ((JSONObject)localObject1).optJSONObject("friend_red_point");
              ((FeedsItemData.LabelInfo)localObject3).redInfo = new FeedsItemData.RedInfo();
              if (localObject4 != null)
              {
                ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointId = ((JSONObject)localObject4).optString("red_point_id");
                ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointStartTime = ((JSONObject)localObject4).optLong("begin_time");
                ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointEndTime = ((JSONObject)localObject4).optLong("end_time");
              }
              if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
              {
                i = 0;
                while (i < ((JSONArray)localObject2).length())
                {
                  localObject4 = ((JSONArray)localObject2).getJSONObject(i);
                  localObject3 = new FeedsItemData.LabelInfo();
                  ((FeedsItemData.LabelInfo)localObject3).iconUrl = ((JSONObject)localObject4).optString("entry_icon");
                  ((FeedsItemData.LabelInfo)localObject3).name = ((JSONObject)localObject4).optString("entry_name");
                  ((FeedsItemData.LabelInfo)localObject3).jumpUrl = ((JSONObject)localObject4).optString("entry_url");
                  ((FeedsItemData.LabelInfo)localObject3).desc = ((JSONObject)localObject4).optString("entry_text");
                  ((FeedsItemData.LabelInfo)localObject3).reportId = ((JSONObject)localObject4).optString("report_id");
                  ((FeedsItemData.LabelInfo)localObject3).msgId = str;
                  ((FeedsItemData.LabelInfo)localObject3).appId = paramIntent;
                  localObject5 = ((JSONObject)localObject4).optJSONObject("red_point");
                  ((FeedsItemData.LabelInfo)localObject3).redInfo = new FeedsItemData.RedInfo();
                  if (localObject5 != null)
                  {
                    ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointId = ((JSONObject)localObject5).optString("red_point_id");
                    ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointStartTime = ((JSONObject)localObject5).optLong("begin_time");
                    ((FeedsItemData.LabelInfo)localObject3).redInfo.redPointEndTime = ((JSONObject)localObject5).optLong("end_time");
                  }
                  localObject4 = ((JSONObject)localObject4).optJSONArray("entry_icon_list");
                  ((FeedsItemData.LabelInfo)localObject3).icons = new ArrayList();
                  if (localObject4 != null)
                  {
                    j = 0;
                    while (j < ((JSONArray)localObject4).length())
                    {
                      ((FeedsItemData.LabelInfo)localObject3).icons.add(((JSONArray)localObject4).getJSONObject(j).optString("entry_icon"));
                      j += 1;
                    }
                  }
                  localTopCardInfo.labelInfos.add(localObject3);
                  i += 1;
                }
              }
              localObject2 = ((JSONObject)localObject1).optJSONObject("banner");
              if (localObject2 != null)
              {
                localTopCardInfo.bannerIconZip = ((JSONObject)localObject2).optString("banner_icon_zip");
                localTopCardInfo.bannerGap = ((JSONObject)localObject2).optInt("banner_gap", 60);
                localTopCardInfo.bannerUrl = ((JSONObject)localObject2).optString("banner_url");
                localTopCardInfo.bannerBeginTime = ((JSONObject)localObject2).optLong("begin_time", 0L);
                localTopCardInfo.bannerEndTime = ((JSONObject)localObject2).optLong("end_time", 0L);
              }
              localObject1 = ((JSONObject)localObject1).optJSONArray("priorities");
              if (localObject1 != null)
              {
                localTopCardInfo.priorities = new ArrayList();
                i = 0;
                if (i < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).optString(i, "");
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    break label2088;
                  }
                  localTopCardInfo.priorities.add(localObject2);
                  break label2088;
                }
              }
            }
            if ((paramFromServiceMsg == null) || (paramFromServiceMsg.length() <= 0)) {
              break label2009;
            }
            int m = paramFromServiceMsg.length();
            i = 0;
            for (;;)
            {
              if (i >= m) {
                break label2009;
              }
              localObject1 = new FeedsItemData();
              localObject2 = paramFromServiceMsg.getJSONObject(i);
              localObject3 = ((JSONObject)localObject2).optJSONObject("feed_info");
              ((FeedsItemData)localObject1).msgId = str;
              ((FeedsItemData)localObject1).authorName = ((JSONObject)localObject3).optString("anchor_name");
              ((FeedsItemData)localObject1).authorIcon = ((JSONObject)localObject3).optString("anchor_icon");
              ((FeedsItemData)localObject1).type = ((JSONObject)localObject3).optInt("feed_type");
              ((FeedsItemData)localObject1).feedId = ((JSONObject)localObject3).optString("feed_id");
              ((FeedsItemData)localObject1).coverImgUrl = ((JSONObject)localObject3).optString("cover_url");
              ((FeedsItemData)localObject1).commentNum = ((JSONObject)localObject3).optInt("comment_num");
              ((FeedsItemData)localObject1).title = ((JSONObject)localObject3).optString("title");
              ((FeedsItemData)localObject1).jumpUrl = ((JSONObject)localObject3).optString("jump_url");
              ((FeedsItemData)localObject1).algorithmId = ((JSONObject)localObject3).optString("algorithm_id");
              ((FeedsItemData)localObject1).label = ((JSONObject)localObject3).optString("label");
              ((FeedsItemData)localObject1).rcmdReason = ((JSONObject)localObject3).optString("rcmd_reason");
              ((FeedsItemData)localObject1).subTitle = ((JSONObject)localObject3).optString("sub_title");
              ((FeedsItemData)localObject1).operateText = ((JSONObject)localObject3).optString("operate_text");
              ((FeedsItemData)localObject1).groupId = ((JSONObject)localObject3).optString("group_id");
              if (((FeedsItemData)localObject1).type != 1) {
                break;
              }
              ((FeedsItemData)localObject1).videoUrl = ((JSONObject)localObject3).optString("live_stream_url");
              ((FeedsItemData)localObject1).videoViewers = ((JSONObject)localObject3).optInt("live_online_num");
              ((FeedsItemData)localObject1).videoSrcName = ((JSONObject)localObject3).optString("video_source");
              ((FeedsItemData)localObject1).videoSrcImg = ((JSONObject)localObject3).optString("video_source_icon");
              ((FeedsItemData)localObject1).viewersNum = ((JSONObject)localObject3).optInt("vv");
              localObject2 = ((JSONObject)localObject2).optJSONObject("game_info");
              ((FeedsItemData)localObject1).gameInfo = new FeedsItemData.GameInfo();
              ((FeedsItemData)localObject1).gameInfo.gameName = ((JSONObject)localObject2).optString("name");
              ((FeedsItemData)localObject1).gameInfo.gameIcon = ((JSONObject)localObject2).optString("icon");
              ((FeedsItemData)localObject1).gameInfo.gamePkgName = ((JSONObject)localObject2).optString("pkg_name");
              ((FeedsItemData)localObject1).gameInfo.gamePkgSize = ((JSONObject)localObject2).optInt("pkg_size");
              ((FeedsItemData)localObject1).gameInfo.gameStatus = ((JSONObject)localObject2).optInt("status");
              ((FeedsItemData)localObject1).gameInfo.gameApkUrl = ((JSONObject)localObject2).optString("apk_url");
              ((FeedsItemData)localObject1).gameInfo.gameAppId = ((JSONObject)localObject2).optString("appid");
              ((FeedsItemData)localObject1).gameInfo.gameVersionCode = ((JSONObject)localObject2).optString("version_code");
              ((FeedsItemData)localObject1).gameInfo.gameTicket = ((JSONObject)localObject2).optString("tickets");
              localArrayList.add(localObject1);
              i += 1;
            }
            if (((FeedsItemData)localObject1).type == 2)
            {
              ((FeedsItemData)localObject1).videoUrl = ((JSONObject)localObject3).optString("video_url");
              ((FeedsItemData)localObject1).videoDuration = ((JSONObject)localObject3).optInt("video_duration");
              ((FeedsItemData)localObject1).videoSrcType = ((JSONObject)localObject3).optInt("video_source_type");
              ((FeedsItemData)localObject1).videoVid = ((JSONObject)localObject3).optString("video_vid");
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Exception paramIntent)
        {
          notifyUI(29, false, arrayOfObject);
          QLog.e(TAG, 1, "[handleGamePubAccountFeeds] err:" + paramIntent.getMessage());
        }
        if (((FeedsItemData)localObject1).type == 7)
        {
          localObject4 = ((JSONObject)localObject3).optJSONArray("gift_list");
          ((FeedsItemData)localObject1).giftList = new ArrayList();
          if (localObject4 != null)
          {
            j = 0;
            while (j < ((JSONArray)localObject4).length())
            {
              localObject5 = new FeedsItemData.Gift();
              ((FeedsItemData.Gift)localObject5).picture = ((JSONArray)localObject4).getJSONObject(j).optString("picture");
              ((FeedsItemData.Gift)localObject5).text = ((JSONArray)localObject4).getJSONObject(j).optString("text");
              ((FeedsItemData)localObject1).giftList.add(localObject5);
              j += 1;
            }
          }
        }
      }
      label2009:
      arrayOfObject[2] = localArrayList;
      arrayOfObject[3] = paramArrayOfByte;
      arrayOfObject[4] = localTopCardInfo;
      arrayOfObject[5] = str;
      arrayOfObject[6] = paramIntent;
      notifyUI(29, true, arrayOfObject);
      int i = k;
      label2051:
      if (i == 0)
      {
        notifyUI(29, false, arrayOfObject);
        return;
        notifyUI(29, false, arrayOfObject);
        return;
        label2076:
        bool = true;
        continue;
        label2082:
        bool = true;
        continue;
        label2088:
        i += 1;
      }
    }
  }
  
  public void o(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("3.4.4");
      Object localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      if ((paramString1 == null) && (paramString2 == null))
      {
        QLog.e(TAG + "_apollo_store_stability_", 1, "reportApolloStoreStabilityData. cmd == null || url == null");
        return;
      }
      localObject2 = new WebSsoBody.STServiceMonitReq();
      WebSsoBody.STServiceMonitItem localSTServiceMonitItem = new WebSsoBody.STServiceMonitItem();
      localSTServiceMonitItem.errcode.set(paramInt1);
      if (!TextUtils.isEmpty(paramString1)) {
        localSTServiceMonitItem.cmd.set(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localSTServiceMonitItem.url.set(paramString2);
      }
      localSTServiceMonitItem.cost.set(paramInt2);
      localSTServiceMonitItem.src.set(1);
      ((WebSsoBody.STServiceMonitReq)localObject2).list.add(localSTServiceMonitItem);
      ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((WebSsoBody.STServiceMonitReq)localObject2).toByteArray()));
      localObject2 = new NewIntent(this.app.getApp(), aqre.class);
      ((NewIntent)localObject2).putExtra("cmd", "apollo_dc_report.service_monit");
      ((NewIntent)localObject2).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      this.app.startServlet((NewIntent)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportApolloStoreStabilityData cmd: ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" url:");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" errcode:");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" cost:");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d(TAG + "_apollo_store_stability_", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG + "_apollo_store_stability_", 1, "reportApolloStoreStabilityData failed ", paramString1);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aqrd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void p(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleGetGameFriend] ret=", paramIntent.ret.get() + ",data:" + paramIntent.rspdata.get() });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = new JSONObject(paramIntent.rspdata.get());
          if (paramIntent == null) {
            break label414;
          }
          paramFromServiceMsg = paramIntent.optJSONObject("12825");
          paramIntent.optInt("ecode");
          if (paramFromServiceMsg == null) {
            break label414;
          }
          paramIntent = paramFromServiceMsg.optJSONObject("data");
          if (paramIntent == null) {
            break label414;
          }
          paramIntent = paramIntent.optJSONObject("rsp");
          if (paramIntent == null) {
            break label414;
          }
          paramIntent.optString("appid");
          paramIntent = paramIntent.optJSONArray("friend_list");
          paramFromServiceMsg = new ArrayList();
          i = 0;
          if (i < paramIntent.length())
          {
            paramArrayOfByte = new FeedsItemData.FriendInfo();
            paramArrayOfByte.icon = paramIntent.getJSONObject(i).optString("icon");
            paramArrayOfByte.name = paramIntent.getJSONObject(i).optString("name");
            paramArrayOfByte.uin = paramIntent.getJSONObject(i).optString("uin");
            paramArrayOfByte.loginTime = paramIntent.getJSONObject(i).optLong("login_time");
            paramArrayOfByte.partition = paramIntent.getJSONObject(i).optString("partition");
            paramArrayOfByte.roleName = paramIntent.getJSONObject(i).optString("role_name");
            paramArrayOfByte.jumpUrl = paramIntent.getJSONObject(i).optString("jump_url");
            paramFromServiceMsg.add(paramArrayOfByte);
            i += 1;
            continue;
          }
          notifyUI(31, true, paramFromServiceMsg);
          i = 1;
          if (i == 0) {
            notifyUI(31, false, null);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        notifyUI(31, false, null);
        QLog.e(TAG, 1, "[handleGetGameFriend] err:" + paramIntent.getMessage());
        return;
      }
      notifyUI(31, false, null);
      return;
      label414:
      int i = 0;
    }
  }
  
  public void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int i = paramIntent.getIntExtra("apollo_status", 0);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleChangeApolloStatus ret: " + paramFromServiceMsg.ret.get() + ", apollo status:" + i);
        }
        paramIntent = new Pair(this.app.getCurrentUin(), Integer.valueOf(i));
        if (0L != paramFromServiceMsg.ret.get()) {
          break label198;
        }
        if (i != 0)
        {
          paramFromServiceMsg = (abhh)this.app.getManager(153);
          paramArrayOfByte = paramFromServiceMsg.b(this.app.getCurrentUin());
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte.apolloStatus = i;
            paramFromServiceMsg.a(paramArrayOfByte);
          }
          notifyUI(3, true, paramIntent);
          return;
        }
        notifyUI(3, false, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(TAG, 2, "handleChangeApolloStatus failed ", paramIntent);
      return;
      label198:
      notifyUI(3, false, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramIntent.getStringExtra("touin");
    int i = paramIntent.getIntExtra("mask", 0);
    int j;
    int k;
    Object localObject4;
    int m;
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(TAG, 2, "handleGetUserApolloInfo ret: " + paramIntent.ret.get() + ", msg: " + paramIntent.rspdata.get() + ", touin:" + (String)localObject1 + ", mask: " + i);
        }
        if (0L != paramIntent.ret.get()) {
          break label1383;
        }
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramIntent == null) || (this.app == null)) {
          break label1383;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleGetUserApolloInfo apollo data: " + paramIntent.toString());
        }
        paramFromServiceMsg = (abhh)this.app.getManager(153);
        if (paramFromServiceMsg == null) {
          break label1383;
        }
        paramArrayOfByte = paramFromServiceMsg.b((String)localObject1);
        j = 0;
        i = j;
        if (paramIntent.has("vip"))
        {
          k = paramIntent.getInt("vip");
          i = j;
          if (k != paramArrayOfByte.apolloVipFlag)
          {
            paramArrayOfByte.apolloVipFlag = k;
            i = 1;
          }
        }
        j = i;
        if (paramIntent.has("viplevel"))
        {
          k = paramIntent.getInt("viplevel");
          j = i;
          if (k != paramArrayOfByte.apolloVipLevel)
          {
            paramArrayOfByte.apolloVipLevel = k;
            j = 1;
          }
        }
        if (!paramIntent.has("userstatus")) {
          break label1363;
        }
        i = paramIntent.getInt("userstatus");
        if (i == paramArrayOfByte.apolloStatus) {
          break label1363;
        }
        paramArrayOfByte.apolloStatus = i;
        j = 1;
        if (!paramIntent.has("actlist")) {
          break label1100;
        }
        localObject2 = paramIntent.getJSONArray("actlist");
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "[handleGetUserApolloInfo] user action list=", localObject2 });
        }
        localObject1 = new HashMap(((JSONArray)localObject2).length());
        localObject4 = new JSONArray();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new Bundle();
          localObject5 = ((JSONArray)localObject2).getJSONObject(i);
          k = ((JSONObject)localObject5).optInt("id");
          ((Bundle)localObject3).putLong("beginTs", ((JSONObject)localObject5).optLong("beginTs"));
          ((Bundle)localObject3).putLong("endts", ((JSONObject)localObject5).optLong("endts"));
          m = ((JSONObject)localObject5).optInt("way");
          ((Bundle)localObject3).putInt("way", m);
          ((Bundle)localObject3).putInt("slaveActId", ((JSONObject)localObject5).optInt("slaveActId"));
          if (k == 0) {
            break label1366;
          }
          ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
          break label1366;
          label573:
          ((JSONObject)localObject5).put("type", k);
          ((JSONArray)localObject4).put(localObject5);
          i += 1;
        }
        if (((HashMap)localObject1).size() <= 0) {
          break label1108;
        }
        if (this.mApp == null) {
          return;
        }
        localObject3 = (abhh)this.mApp.getManager(153);
        if (localObject3 != null) {
          ((abhh)localObject3).ii = ((HashMap)localObject1);
        }
        localObject2 = (abxk)this.mApp.getManager(155);
        if (localObject2 == null) {
          break label1383;
        }
        ((abxk)localObject2).q((JSONArray)localObject4);
        Object localObject5 = ((abxk)localObject2).K(1);
        localObject4 = ((abxk)localObject2).dI();
        k = 0;
        i = 0;
        if (localObject5 == null) {
          break label1393;
        }
        k = 0;
        label699:
        if (k < ((List)localObject5).size())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)((List)localObject5).get(k);
          if (!((HashMap)localObject1).containsKey(Integer.valueOf(localApolloActionData.actionId))) {
            break label1384;
          }
          Bundle localBundle = (Bundle)((HashMap)localObject1).get(Integer.valueOf(localApolloActionData.actionId));
          if (localObject3 != null) {
            ((abhh)localObject3).a(localApolloActionData, localBundle);
          }
          m = 1;
          i = m;
          if (!QLog.isColorLevel()) {
            break label1384;
          }
          QLog.d(TAG, 2, "handleGetUserApolloInfo update actlist id: " + localApolloActionData.actionId);
          i = m;
          break label1384;
        }
        k = i;
        if (this.mApp == null) {
          break label1393;
        }
        k = i;
        if (localObject2 == null) {
          break label1393;
        }
        k = i;
        if (i == 0) {
          break label1393;
        }
        ((abxk)localObject2).im((List)localObject5);
        k = i;
      }
      catch (Exception paramIntent)
      {
        Object localObject2;
        Object localObject3;
        label867:
        int n;
        if (!QLog.isColorLevel()) {
          break label1383;
        }
      }
      if (m < ((List)localObject4).size())
      {
        localObject3 = (ApolloActionData)((List)localObject4).get(m);
        if (!((HashMap)localObject1).containsKey(Integer.valueOf(((ApolloActionData)localObject3).actionId))) {
          break label1407;
        }
        ((ApolloActionData)localObject3).isShow = 1;
        n = 1;
        i = n;
        if (!QLog.isColorLevel()) {
          break label1407;
        }
        QLog.d(TAG, 2, new Object[] { "[handleGetUserApolloInfo] set user action ", Integer.valueOf(((ApolloActionData)localObject3).actionId), " visible" });
        i = n;
        break label1407;
      }
      m = i;
      if (this.mApp == null) {
        break label1416;
      }
      m = i;
      if (localObject2 == null) {
        break label1416;
      }
      m = i;
      if (i == 0) {
        break label1416;
      }
      ((abxk)localObject2).im((List)localObject4);
      m = i;
      break label1416;
    }
    label1100:
    label1363:
    for (;;)
    {
      label1012:
      notifyUI(9, true, null);
      label1020:
      localObject1 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((abxk)localObject2).a(((Integer)((Iterator)localObject1).next()).intValue()) == null)
        {
          paramFromServiceMsg.cBK();
          continue;
          QLog.e(TAG, 2, "handleGetUserApolloInfo failed", paramIntent);
          return;
        }
      }
      label1108:
      label1366:
      label1383:
      label1384:
      label1393:
      label1407:
      do
      {
        notifyUI(9, false, null);
        break label1020;
        notifyUI(9, false, null);
        if (paramIntent.has("CurrencyInfo"))
        {
          i = paramIntent.getJSONObject("CurrencyInfo").optInt("balance");
          localObject1 = paramFromServiceMsg.a();
          if (localObject1 != null)
          {
            ((abhs)localObject1).coS = i;
            if (((abhs)localObject1).bDc) {
              ((abhs)localObject1).cCa();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "balance:", Integer.valueOf(i) });
          }
        }
        if (paramIntent.has("zancount")) {
          notifyUI(6, true, Integer.valueOf(paramIntent.optInt("zancount")));
        }
        if (paramIntent.has("gameCoinInfo"))
        {
          i = paramIntent.getJSONObject("gameCoinInfo").optInt("balance", 0);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "[handleGetUserApolloInfo] game coin count=", Integer.valueOf(i) });
          }
          ApolloGameUtil.c(this.app, i);
        }
        if (j != 0)
        {
          paramFromServiceMsg.a(paramArrayOfByte);
          return;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "handleGetUserApolloInfo fail ret: " + paramFromServiceMsg.getResultCode());
          }
          if (1 == (i & 0x100))
          {
            notifyUI(6, false, Integer.valueOf(0));
            return;
          }
        }
        do
        {
          m = 0;
          break label1416;
          break;
          k = 0;
          if (m != 6) {
            break label573;
          }
          k = 6;
          break label573;
          return;
          k += 1;
          break label699;
        } while (localObject4 == null);
        m = 0;
        i = 0;
        break label867;
        m += 1;
        break label867;
        if (m != 0) {
          break label1012;
        }
      } while (k == 0);
    }
  }
  
  public void t(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = paramIntent.getIntExtra("actionId", 0);
    String str1 = paramIntent.getStringExtra("actionText");
    String str2 = paramIntent.getStringExtra("textType");
    String str3 = paramIntent.getStringExtra("optFrom");
    int j = paramIntent.getIntExtra("audioId", 0);
    float f = paramIntent.getFloatExtra("audioTime", 0.0F);
    int k = paramIntent.getIntExtra("isPlayDefultAudio", 0);
    paramIntent = new HashMap();
    paramIntent.put("id", i + "");
    paramIntent.put("actionText", str1);
    paramIntent.put("textType", str2);
    paramIntent.put("optFrom", str3);
    paramIntent.put("audioId", "" + j);
    paramIntent.put("audioTime", "" + f);
    paramIntent.put("isPlayDefultAudio", "" + k);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramFromServiceMsg.rspdata.has())) {
          QLog.d(TAG, 2, "handleCheckActionAuth ret: " + paramFromServiceMsg.ret.get() + ", msg: " + paramFromServiceMsg.rspdata.get());
        }
        paramIntent.put("ret", paramFromServiceMsg.ret.get() + "");
        if (0L == paramFromServiceMsg.ret.get())
        {
          notifyUI(5, true, paramIntent);
          return;
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("data").getJSONObject("acresult");
        paramIntent.put("type", paramFromServiceMsg.optInt("type") + "");
        paramIntent.put("id", paramFromServiceMsg.optInt("id") + "");
        paramIntent.put("content", paramFromServiceMsg.optString("msg"));
        paramIntent.put("url", paramFromServiceMsg.optString("url"));
        notifyUI(5, false, paramIntent);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "handleChangeApolloStatus failed ", paramFromServiceMsg);
        }
        paramIntent.put("ret", "-1");
        notifyUI(5, false, paramIntent);
        return;
      }
    }
    paramIntent.put("ret", paramFromServiceMsg.getResultCode() + "");
    notifyUI(5, false, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void v(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleSetZanCount ret: " + paramIntent.ret.get());
        }
        if (0L == paramIntent.ret.get())
        {
          notifyUI(7, true, Integer.valueOf(new JSONObject(paramIntent.rspdata.get()).getJSONObject("data").optInt("zancount")));
          return;
        }
        notifyUI(7, false, Long.valueOf(paramIntent.ret.get()));
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "handleChangeApolloStatus failed ", paramIntent);
        }
        notifyUI(7, false, Integer.valueOf(-1));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(7, false, Integer.valueOf(paramFromServiceMsg.getResultCode()));
  }
  
  protected void w(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = new SCUpdatePB.SCUpdateRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "handleQuickUpdate ret: " + paramIntent.ret.get());
        }
        l = 0L;
        if (paramIntent.comm.cookie.has()) {
          l = paramIntent.comm.cookie.get();
        }
        if (paramIntent.ret.get() == 0L)
        {
          Object localObject;
          if (paramIntent.cmd.get() == 1)
          {
            paramFromServiceMsg = new VasQuickUpdateManager.SyncVCRRsp();
            paramFromServiceMsg.cookie = l;
            paramFromServiceMsg.seq = paramIntent.rsp0x01.seq.get();
            paramFromServiceMsg.continue_flag = paramIntent.rsp0x01.continue_flag.get();
            paramFromServiceMsg.polltime = paramIntent.comm.polltime.get();
            paramFromServiceMsg.sync_switch = paramIntent.rsp0x01.sync_switch.get();
            i = 0;
            while (i < paramIntent.rsp0x01.vcr_list.size())
            {
              paramArrayOfByte = (SCUpdatePB.VCR)paramIntent.rsp0x01.vcr_list.get(i);
              localObject = new VasQuickUpdateManager.VCR();
              ((VasQuickUpdateManager.VCR)localObject).set(paramArrayOfByte);
              paramFromServiceMsg.vcr_list.add(localObject);
              i += 1;
            }
            paramFromServiceMsg.preload.ver = paramIntent.rsp0x01.preload.plver.get();
            paramFromServiceMsg.preload.setList(paramIntent.rsp0x01.preload.item_list);
            paramFromServiceMsg.report.ver = paramIntent.rsp0x01.report.rpver.get();
            paramFromServiceMsg.report.setList(paramIntent.rsp0x01.report.item_list);
            notifyUI(16, true, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() != 2) {
            return;
          }
          paramFromServiceMsg = new VasQuickUpdateManager.GetUrlRsp();
          paramFromServiceMsg.cookie = l;
          int i = 0;
          while (i < paramIntent.rsp0x02.update_list.size())
          {
            paramArrayOfByte = (SCUpdatePB.UpdateInfo)paramIntent.rsp0x02.update_list.get(i);
            localObject = new VasQuickUpdateManager.UpdateInfo();
            ((VasQuickUpdateManager.UpdateInfo)localObject).set(paramArrayOfByte, i);
            paramFromServiceMsg.update_list.add(localObject);
            i += 1;
          }
          notifyUI(17, true, paramFromServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        QLog.e(TAG, 1, "handleQuickUpdate error: ", paramFromServiceMsg);
        paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
        paramFromServiceMsg.ret = -1L;
        paramFromServiceMsg.cookie = 0L;
        if (paramIntent.cmd.get() == 1)
        {
          notifyUI(16, false, paramFromServiceMsg);
          return;
          QLog.e(TAG, 1, "handleQuickUpdate result = " + paramIntent.ret.get() + "msg = " + paramIntent.msg.get());
          paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
          paramFromServiceMsg.ret = paramIntent.ret.get();
          paramFromServiceMsg.cookie = l;
          if (paramIntent.cmd.get() == 1)
          {
            notifyUI(16, false, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() == 2) {
            notifyUI(17, false, paramFromServiceMsg);
          }
        }
        else if (paramIntent.cmd.get() == 2)
        {
          notifyUI(17, false, paramFromServiceMsg);
        }
      }
    }
  }
  
  public void x(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (0L == paramIntent.ret.get())
        {
          paramFromServiceMsg = new JSONObject(paramIntent.rspdata.get()).optJSONArray("data").optJSONObject(0);
          paramIntent = paramFromServiceMsg.optString("motto_content");
          paramFromServiceMsg = paramFromServiceMsg.optLong("uin") + "";
          paramArrayOfByte = (abhh)this.app.getManager(153);
          if (paramArrayOfByte != null)
          {
            ApolloBaseInfo localApolloBaseInfo = paramArrayOfByte.b(paramFromServiceMsg);
            if (localApolloBaseInfo != null)
            {
              localApolloBaseInfo.apolloSignStr = paramIntent;
              localApolloBaseInfo.apolloLocalSignTs = localApolloBaseInfo.apolloSignValidTS;
              paramArrayOfByte.a(localApolloBaseInfo);
            }
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(TAG, 2, "handleGetSignStr uin: " + paramFromServiceMsg + ", sign: " + paramIntent);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(TAG, 2, "handleGetSignStr err  ret: " + paramIntent.ret.get());
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, "handleGetSignStr error", paramIntent);
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "handleGetSignStr fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  void y(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = new qqshop_act.SQQSHPActRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent != null) {
          notifyUI(13, true, paramIntent);
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        if ("jd red packet response:" + paramIntent == null) {}
        for (paramIntent = "-1";; paramIntent = "" + paramIntent.code.get())
        {
          QLog.i("EcshopJd", 2, paramIntent);
          return;
        }
        notifyUI(13, false, null);
      }
      catch (Exception paramIntent)
      {
        notifyUI(13, false, null);
        return;
      }
    }
    else
    {
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  void z(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = kdm.h();
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = new qqshop_act.SQQSHPActReadRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.code.get() == 0)) {
          notifyUI(14, true, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.i("EcshopJd", 2, "jd check response:" + paramFromServiceMsg.code.get());
          return;
          notifyUI(14, false, null);
          paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        }
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis() - 5400000L).commit();
      }
      catch (Exception paramFromServiceMsg)
      {
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        notifyUI(14, false, null);
        return;
      }
    }
    else
    {
      notifyUI(14, false, null);
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public static abstract interface a
  {
    public abstract void DR(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo);
    
    public abstract boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrb
 * JD-Core Version:    0.7.0.1
 */