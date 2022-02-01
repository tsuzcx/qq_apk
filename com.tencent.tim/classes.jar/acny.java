import MQQ.GuanjiaReportRsp;
import MQQ.ItemCfgInfo;
import MQQ.ItemCfgList;
import MQQ.PayRuleCfg;
import MQQ.PrivExtV2Rsp;
import MQQ.ShowRangeTime;
import MQQ.ShowRule;
import MQQ.TrafficResultInfo;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import QC.LoginInfo;
import QC.MessageShow;
import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniSetReq;
import QQService.EVIPSPEC;
import VIP.GetCustomOnlineStatusRsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler.1;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class acny
  extends accg
{
  public static String KEY_TYPE = "k_type";
  public static String KEY_UIN;
  private static String TAG = "VipInfoHandler";
  public static String bpX = "k_skey";
  public static String bpY = "k_phone_num";
  public static String bpZ = "k_is_king_card";
  public static String bqa = "k_card_type";
  public static String bqb = "k_card_status";
  public static String bqc = "k_hasImsi";
  public static String bqd = "key_has_double_imsi";
  public static String bqe = "key_imsi_one";
  public static String bqf = "key_imsi_two";
  public static String bqg = "k_sequence";
  public static String bqh = "uin";
  public static String bqi = "login_info";
  public static String bqj = "state";
  private static final Object cE = new Object();
  private static HashMap<String, PayRuleCfg> jh = new HashMap();
  private String bqk;
  
  static
  {
    KEY_UIN = "k_uin";
  }
  
  public acny(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(PayRuleCfg paramPayRuleCfg)
  {
    return (paramPayRuleCfg.clubType - 1) * 3 + paramPayRuleCfg.userType;
  }
  
  private int a(VipUserInfo paramVipUserInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipUserInfo == null) || (paramInt1 > 2) || (paramInt1 < 1)) {
      return paramInt2;
    }
    if (1 == paramInt1) {}
    for (paramInt1 = paramVipUserInfo.iOpenVip;; paramInt1 = paramVipUserInfo.iOpenSVip) {
      return (paramInt1 << 8 | (byte)paramVipUserInfo.iVipType) << 16 | (short)paramVipUserInfo.iVipLevel;
    }
  }
  
  public static PayRuleCfg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(TAG, 1, "getPayRule: empty uin");
      ??? = null;
      return ???;
    }
    for (;;)
    {
      synchronized (jh)
      {
        Object localObject2 = (PayRuleCfg)jh.get(paramString);
        ??? = localObject2;
        if (localObject2 != null) {
          break;
        }
        ??? = a(paramString, "payRule.cfg");
        if (??? == null)
        {
          ??? = new PayRuleCfg();
          ((PayRuleCfg)???).enable = 0;
          synchronized (jh)
          {
            PayRuleCfg localPayRuleCfg = (PayRuleCfg)jh.get(paramString);
            localObject2 = localPayRuleCfg;
            if (localPayRuleCfg == null)
            {
              jh.put(paramString, ???);
              localObject2 = ???;
            }
            return localObject2;
          }
        }
      }
    }
  }
  
  private static PayRuleCfg a(String arg0, String paramString2)
  {
    paramString2 = new File(BaseApplicationImpl.getContext().getFilesDir(), ??? + File.separator + paramString2);
    synchronized (cE)
    {
      paramString2 = aqhq.fileToBytes(paramString2);
      if (paramString2 != null) {
        return (PayRuleCfg)awck.decodeWup(PayRuleCfg.class, paramString2);
      }
    }
    return null;
  }
  
  private LoginInfo a()
  {
    try
    {
      String str1 = this.app.getCurrentAccountUin();
      String str2 = ((TicketManager)this.app.getManager(2)).getSkey(str1);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str1);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = str2;
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = aqgz.getQQVersion();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(PayRuleCfg paramPayRuleCfg)
  {
    if (paramPayRuleCfg == null) {
      return "null";
    }
    return Base64.encodeToString(awck.encodeWup(paramPayRuleCfg), 2) + "\n" + paramPayRuleCfg;
  }
  
  private void a(@NonNull PrivExtV2Rsp paramPrivExtV2Rsp, String paramString)
  {
    paramPrivExtV2Rsp = paramPrivExtV2Rsp.vipInfo;
    if (paramPrivExtV2Rsp == null) {
      return;
    }
    acff localacff = (acff)this.app.getManager(51);
    Friends localFriends = localacff.d(paramString);
    localFriends.qqVipInfo = a(paramPrivExtV2Rsp, 1, localFriends.qqVipInfo);
    localFriends.superVipInfo = a(paramPrivExtV2Rsp, 2, localFriends.superVipInfo);
    SharedPreferences localSharedPreferences = this.app.getApplication().getApplicationContext().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (paramPrivExtV2Rsp.iUpdateTime > 0L) {
      localSharedPreferences.edit().putLong("sp_vip_info_request_time", paramPrivExtV2Rsp.iUpdateTime);
    }
    if (paramPrivExtV2Rsp.iUpdateFreq > 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_update_freq", paramPrivExtV2Rsp.iUpdateFreq);
    }
    if (paramPrivExtV2Rsp.iCanUseRed >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", paramPrivExtV2Rsp.iCanUseRed);
    }
    if (paramPrivExtV2Rsp.iRedDisable >= 0) {
      localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramPrivExtV2Rsp.iRedDisable);
    }
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramPrivExtV2Rsp.iRedPackId);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramPrivExtV2Rsp.sRedPackRemard);
    localSharedPreferences.edit().commit();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "redpacketinfo : icanusedred = " + paramPrivExtV2Rsp.iCanUseRed + ";iRedDisable = " + paramPrivExtV2Rsp.iRedDisable + "iRedPacketId = " + paramPrivExtV2Rsp.iRedPackId + ";sRedPackRemard = " + paramPrivExtV2Rsp.sRedPackRemard);
    }
    localacff.e(localFriends);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.app.getAccount())) && ((paramPrivExtV2Rsp.iCanUseRed >= 0) || (paramPrivExtV2Rsp.iRedDisable >= 0)))
    {
      paramString = (acgn)this.app.getManager(131);
      paramString.x(paramPrivExtV2Rsp.iCanUseRed, paramPrivExtV2Rsp.iRedDisable, true);
      paramString.ca(paramPrivExtV2Rsp.iRedPackId, paramPrivExtV2Rsp.sRedPackRemard);
    }
    paramString = paramPrivExtV2Rsp.sUri;
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "vip url = " + paramString);
      }
      paramString = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramString);
      if (Build.VERSION.SDK_INT >= 9) {
        break label508;
      }
      paramString.commit();
    }
    for (;;)
    {
      aquu.a().a(this.app, paramPrivExtV2Rsp);
      return;
      label508:
      paramString.apply();
    }
  }
  
  private void a(VipMedalList paramVipMedalList, String paramString)
  {
    this.bqk = null;
    if (paramVipMedalList == null)
    {
      QLog.e("QVipSettingMe." + TAG, 1, "medal info is null!");
      return;
    }
    if (paramVipMedalList.bUpdate == 0)
    {
      QLog.e("QVipSettingMe." + TAG, 1, "bUpdate=" + paramVipMedalList.bUpdate + " it do not need to update medal info");
      return;
    }
    acff localacff = (acff)this.app.getManager(51);
    paramString = localacff.d(paramString);
    paramVipMedalList = MedalList.parse(paramVipMedalList);
    if (paramVipMedalList != null) {}
    try
    {
      paramString.medalsInfo = paramVipMedalList.convert();
      this.bqk = paramString.medalsInfo;
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + TAG, 1, "medalList receiver form service :" + paramString.medalsInfo);
      }
      localacff.e(paramString);
      return;
    }
    catch (JSONException paramVipMedalList)
    {
      for (;;)
      {
        QLog.e("QVipSettingMe." + TAG, 1, "medalList convert faile :" + paramVipMedalList);
      }
    }
  }
  
  public static void a(String paramString, PayRuleCfg paramPayRuleCfg)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(TAG, 1, "writePayRule: empty uin");
      return;
    }
    synchronized (jh)
    {
      jh.put(paramString, paramPayRuleCfg);
      ThreadManager.getSubThreadHandler().post(new VipInfoHandler.1(paramString, paramPayRuleCfg));
      return;
    }
  }
  
  private static void a(String paramString1, String arg1, PayRuleCfg paramPayRuleCfg)
  {
    paramString1 = new File(BaseApplicationImpl.getContext().getFilesDir(), paramString1 + File.separator + ???);
    paramPayRuleCfg = awck.encodeWup(paramPayRuleCfg);
    synchronized (cE)
    {
      aqhq.writeFile(paramPayRuleCfg, paramString1.getAbsolutePath());
      return;
    }
  }
  
  private static boolean a(PayRuleCfg paramPayRuleCfg1, PayRuleCfg paramPayRuleCfg2)
  {
    if (paramPayRuleCfg1 == paramPayRuleCfg2) {
      return true;
    }
    if ((paramPayRuleCfg1 == null) || (paramPayRuleCfg2 == null)) {
      return false;
    }
    return Arrays.equals(awck.encodeWup(paramPayRuleCfg1), awck.encodeWup(paramPayRuleCfg2));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, PayRuleCfg paramPayRuleCfg, boolean paramBoolean)
  {
    if ((paramPayRuleCfg != null) && (paramPayRuleCfg.enable == 1) && (paramPayRuleCfg.rule != null)) {}
    Object localObject;
    switch (paramPayRuleCfg.rule.showType)
    {
    default: 
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("needShowPayButton: cfg=").append(paramPayRuleCfg).append(" enable=");
        if (paramPayRuleCfg != null) {
          break label379;
        }
      }
      break;
    }
    label379:
    for (paramQQAppInterface = Boolean.valueOf(false);; paramQQAppInterface = Integer.valueOf(paramPayRuleCfg.enable))
    {
      QLog.d("VipInfoHandler", 2, paramQQAppInterface);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_LIMIT_DAY count remain: " + paramPayRuleCfg.rule.showCount);
      }
      if (paramPayRuleCfg.rule.showCount > 0)
      {
        if (!paramBoolean)
        {
          localObject = paramPayRuleCfg.rule;
          ((ShowRule)localObject).showCount -= 1;
          a(paramQQAppInterface.getCurrentUin(), paramPayRuleCfg);
        }
        return true;
      }
      return false;
      long l1 = aqvl.c(paramQQAppInterface, "last_pull_pay_rule", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_DATE " + paramPayRuleCfg.rule.showCount + " offset " + (l2 - l1));
      }
      return l2 - l1 < paramPayRuleCfg.rule.showCount * 24 * 3600L;
      l1 = NetConnInfoCenter.getServerTime();
      if (paramPayRuleCfg.rule.rangTimes != null)
      {
        paramQQAppInterface = paramPayRuleCfg.rule.rangTimes.iterator();
        while (paramQQAppInterface.hasNext())
        {
          paramPayRuleCfg = (ShowRangeTime)paramQQAppInterface.next();
          if ((paramPayRuleCfg.beginTime <= l1) && (l1 <= paramPayRuleCfg.endTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME needShowPayButton");
            }
            return true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipInfoHandler", 2, "needShowPayButton: _ESHOW_RANGE_TIME dontShow");
      }
      return false;
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, PrivExtV2Rsp paramPrivExtV2Rsp, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString(KEY_UIN);
      Object localObject = paramPrivExtV2Rsp.vipInfo;
      a(paramPrivExtV2Rsp.medalInfoList, paramFromServiceMsg);
      if (localObject != null) {
        if (((VipUserInfo)localObject).bUpdate == 0)
        {
          QLog.e("QVipSettingMe." + TAG, 1, "bUpdate=" + ((VipUserInfo)localObject).bUpdate + " it do not need to update vip info");
          aqux.a(paramPrivExtV2Rsp.trafficResult, paramToServiceMsg.extraData);
          if ((localObject != null) && (((VipUserInfo)localObject).bUpdate == 1) && (paramPrivExtV2Rsp.trafficResult != null) && (paramPrivExtV2Rsp.trafficResult.bUpdate == 1) && (paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1)) {
            aqvl.d(this.app, "setting_me_get_vip_info_sequence", NetConnInfoCenter.getServerTime());
          }
          aqvl.d(this.app, "setting_me_last_request_success_time", NetConnInfoCenter.getServerTime());
          aqvl.x(this.app, "setting_me_vip_sync_freq", paramPrivExtV2Rsp.iSyncFreq);
          if ((paramPrivExtV2Rsp.medalInfoList != null) && (paramPrivExtV2Rsp.medalInfoList.bUpdate == 1)) {
            if (avqy.a().getVipType() <= 0) {
              break label677;
            }
          }
        }
      }
      label677:
      for (long l = 1L;; l = 0L)
      {
        aqvl.d(this.app, "key_long_setting_me_vip_medal_list_record", l);
        paramToServiceMsg = paramPrivExtV2Rsp.itemCfgList;
        if (paramToServiceMsg != null)
        {
          l = aqvl.c(this.app, "name_plate_config_version", 0L);
          localObject = afab.j(this.app, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.i("QVipSettingMe." + TAG, 2, "vipinfo NamePlate response localVersion = " + l + " netVersion = " + paramToServiceMsg.iItemCfgVer + " \nlocalCfgInfo = " + (String)localObject);
          }
          if ((l != paramToServiceMsg.iItemCfgVer) || (TextUtils.isEmpty((CharSequence)localObject)))
          {
            aqvl.d(this.app, "name_plate_config_version", paramToServiceMsg.iItemCfgVer);
            g(paramPrivExtV2Rsp.itemCfgList.itemCfgInfo, paramFromServiceMsg);
          }
        }
        if (paramPrivExtV2Rsp.payRule == null) {
          break label683;
        }
        QLog.e(TAG, 1, new Object[] { "privExtRsp.payRule ", paramPrivExtV2Rsp.payRule.iconText, " url=", paramPrivExtV2Rsp.payRule.iconUrl, " update=", Integer.valueOf(paramPrivExtV2Rsp.payRule.update), " new:\n", a(paramPrivExtV2Rsp.payRule) });
        if (paramPrivExtV2Rsp.payRule.update == 1)
        {
          aqvl.d(this.app, "last_pull_pay_rule", NetConnInfoCenter.getServerTime());
          paramToServiceMsg = a(paramFromServiceMsg, "payRuleOrigin.cfg");
          boolean bool = a(paramToServiceMsg, paramPrivExtV2Rsp.payRule);
          QLog.e(TAG, 1, new Object[] { "privExtRsp.payRule equals=" + bool, " old:\n", a(paramToServiceMsg) });
          if (!bool)
          {
            a(paramFromServiceMsg, "payRuleOrigin.cfg", paramPrivExtV2Rsp.payRule);
            a(paramFromServiceMsg, paramPrivExtV2Rsp.payRule);
            notifyUI(4, true, null);
          }
        }
        return paramBoolean;
        if ((((VipUserInfo)localObject).iOpenVip >= 0) && (((VipUserInfo)localObject).iOpenSVip >= 0))
        {
          a(paramPrivExtV2Rsp, paramFromServiceMsg);
          break;
        }
        paramBoolean = false;
        break;
        QLog.e("QVipSettingMe." + TAG, 1, "request vip user info rsp null!");
        break;
      }
      label683:
      QLog.e(TAG, 1, "privExtRsp.payRule is null");
      return paramBoolean;
    }
    QLog.e(TAG, 1, "ClubInfoSvc.queryPrivExt failed:" + paramFromServiceMsg.getBusinessFailCode());
    arts.a().a("ClubInfoSvc.queryPrivExt", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, "[CMD:ClubInfoSvc.queryPrivExtfailed]", true);
    return paramBoolean;
  }
  
  public static void cf(int paramInt, String paramString)
  {
    awmu localawmu = new awmu();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localawmu.mTraceId = (str + "_" + l);
    localawmu.eBX = 1;
    localawmu.mAppId = "tianshu.47";
    localawmu.cNQ = "tianshu.47";
    localawmu.cNR = paramString;
    localawmu.cRG = "";
    localawmu.aBn = l;
    localawmu.mActionId = paramInt;
    localawmu.eBB = 1;
    localawmu.eBZ = 1;
    awmt.a().a(localawmu);
  }
  
  public static int e(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int k = 0;
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    int i;
    label35:
    int j;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface == null) {
        break label119;
      }
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label102;
      }
      i = 1;
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label107;
      }
      j = 1;
      label48:
      int m = paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
      if (paramQQAppInterface.getServiceLevel(EVIPSPEC.E_SP_QQVIP) + m > 0) {
        break label113;
      }
      label70:
      if (j != 1) {
        break label129;
      }
      i = 3;
    }
    for (;;)
    {
      j = i;
      if (paramBoolean) {
        j = i + 4;
      }
      return j;
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      break;
      label102:
      i = 0;
      break label35;
      label107:
      j = 0;
      break label48;
      label113:
      k = 1;
      break label70;
      label119:
      if (paramBoolean) {
        return 99;
      }
      return 98;
      label129:
      if (i == 1) {
        i = 4;
      } else if (k == 1) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  private void g(ArrayList<ItemCfgInfo> paramArrayList, String paramString)
  {
    if (paramArrayList == null)
    {
      QLog.e("QVipSettingMe." + TAG, 1, "NamePlateCfgInfo is null!");
      return;
    }
    acff localacff = (acff)this.app.getManager(51);
    paramString = localacff.d(paramString);
    try
    {
      paramString.nameplateCfgInfo = afab.q(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe." + TAG, 2, "handleNamePlateCfgInfoRsp cfginfo :\n " + paramString.nameplateCfgInfo);
      }
      localacff.e(paramString);
      return;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        paramArrayList.printStackTrace();
      }
    }
  }
  
  public void FL(boolean paramBoolean)
  {
    UniSetReq localUniSetReq = new UniSetReq();
    localUniSetReq.stUniBusinessItem = new UniBusinessItem();
    localUniSetReq.stUniBusinessItem.appid = 36;
    localUniSetReq.stUniBusinessItem.itemid = 0;
    localUniSetReq.stMessageShow = new MessageShow();
    localUniSetReq.stMessageShow.bOpen = paramBoolean;
    a(localUniSetReq, null, false);
  }
  
  public void a(UniGetReq paramUniGetReq, acci paramacci, boolean paramBoolean)
  {
    paramacci = createToServiceMsg("QCUniBusinessLogic.uniGet", paramacci, paramBoolean);
    paramUniGetReq.stLogin = a();
    paramacci.extraData.putSerializable("req", paramUniGetReq);
    send(paramacci);
  }
  
  public void a(UniSetReq paramUniSetReq, acci paramacci, boolean paramBoolean)
  {
    paramacci = createToServiceMsg("QCUniBusinessLogic.uniSet", paramacci, paramBoolean);
    paramUniSetReq.stLogin = a();
    paramacci.extraData.putSerializable("req", paramUniSetReq);
    send(paramacci);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3)
  {
    int i = 0;
    if ("ORDER".equals(paramString3)) {
      i = 1;
    }
    for (;;)
    {
      paramString3 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.guanjiaReport");
      paramString3.extraData.putString(KEY_UIN, paramString1);
      paramString3.extraData.putString(bpY, paramString2);
      paramString3.extraData.putBoolean(bpZ, paramBoolean);
      paramString3.extraData.putInt(bqa, paramInt);
      paramString3.extraData.putInt(bqb, i);
      send(paramString3);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "guanjiaReport: isKingCard=" + paramBoolean);
      }
      return;
      if ("ACTIVESUCC".equals(paramString3)) {
        i = 2;
      } else if ("GOODCHG".equals(paramString3)) {
        i = 3;
      } else if ("CANCEL".equals(paramString3)) {
        i = 4;
      }
    }
  }
  
  public void fg(String paramString1, String paramString2)
  {
    k(paramString1, paramString2, 1562146740L);
  }
  
  public void hZ(long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "VipCustom.GetCustomOnlineStatus");
    localToServiceMsg.extraData.putLong(bqh, paramLong);
    send(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "send to server");
    }
  }
  
  public void k(String paramString1, String paramString2, long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ClubInfoSvc.queryPrivExt");
    localToServiceMsg.extraData.putString(KEY_UIN, paramString2);
    localToServiceMsg.extraData.putInt(KEY_TYPE, 1);
    localToServiceMsg.extraData.putString(bpX, paramString1);
    if (paramLong > 0L) {
      localToServiceMsg.extraData.putLong(bqg, paramLong);
    }
    send(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("QVipSettingMe." + TAG, 2, "sendGetBaseVipInfoReq: on send--cmd=ClubInfoSvc.queryPrivExt seq=" + paramLong);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acnz.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramToServiceMsg.getServiceCmd();
    int i = Integer.valueOf(paramToServiceMsg.extraData.getInt(KEY_TYPE)).intValue();
    Long.valueOf(paramToServiceMsg.extraData.getLong(bqg)).longValue();
    boolean bool = paramFromServiceMsg.isSuccess();
    if ("ClubInfoSvc.queryPrivExt".equals(str))
    {
      if (i != 1) {
        break label382;
      }
      bool = a(paramToServiceMsg, paramFromServiceMsg, (PrivExtV2Rsp)paramObject, bool);
    }
    label382:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onReceive: GetBaseVipInfoReq,isSuccess=" + bool);
      }
      notifyUI(1, bool, paramObject);
      return;
      if ("ClubInfoSvc.guanjiaReport".equals(str))
      {
        if (bool)
        {
          paramToServiceMsg = (GuanjiaReportRsp)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onReceive: " + paramToServiceMsg.ret);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 2, "onReceive: guanjiaReport,isSuccess=" + bool);
        return;
      }
      if ("VipCustom.GetCustomOnlineStatus".equals(str))
      {
        if (!bool) {
          break;
        }
        paramToServiceMsg = (GetCustomOnlineStatusRsp)paramObject;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "onReceive: CUSTOM_ONLINE_STATUS " + paramToServiceMsg.sMsg + " " + paramToServiceMsg.sMsg);
        }
        if (TextUtils.isEmpty(paramToServiceMsg.sBuffer)) {
          break;
        }
        try
        {
          paramFromServiceMsg = new CustomOnlineStatusPb.CustomOnlineStatusMsg();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.sBuffer.getBytes());
          aqqb.a().a(paramFromServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          QLog.d(TAG, 1, paramToServiceMsg, new Object[0]);
          return;
        }
      }
      if ("QCUniBusinessLogic.uniSet".equals(str))
      {
        notifyUI(paramToServiceMsg, 2, bool, paramObject);
        return;
      }
      if (!"QCUniBusinessLogic.uniGet".equals(str)) {
        break;
      }
      notifyUI(paramToServiceMsg, 3, bool, paramObject);
      return;
    }
  }
  
  public String rP()
  {
    return this.bqk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acny
 * JD-Core Version:    0.7.0.1
 */