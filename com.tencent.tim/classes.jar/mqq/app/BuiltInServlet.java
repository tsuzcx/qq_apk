package mqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import mqq.observer.CheckConErroObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.ServerConfigObserver;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import protocol.KQQConfig.GetResourceRespV2;

public class BuiltInServlet
  extends MSFServlet
  implements Constants.Action
{
  public static final String KEY_TLV_543_IN_TLV_119 = "tlv543In119";
  public static final String MSF_KEY_SIG_INFO = "sigInfo";
  public static final String MSF_KEY_USER_SIG_INFO = "userSigInfo";
  private boolean isRegist;
  
  private void addOpenSdkExtra(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (!"com.tencent.tim:openSdk".equals(paramIntent.getStringExtra("process"))) {}
    for (;;)
    {
      return;
      paramIntent = paramIntent.getBundleExtra("extra");
      if (paramIntent != null)
      {
        Iterator localIterator = paramIntent.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramToServiceMsg.addAttribute(str, paramIntent.get(str));
          QLog.d("BuiltInServlet", 1, "BuiltInServlet --> key=" + str + ", value=" + paramIntent.get(str));
        }
      }
    }
  }
  
  private void bundlePutTlv543(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if ((paramFromServiceMsg == null) || (paramBundle == null)) {}
    do
    {
      do
      {
        do
        {
          WUserSigInfo localWUserSigInfo1;
          do
          {
            return;
            WUserSigInfo localWUserSigInfo2 = (WUserSigInfo)paramFromServiceMsg.getAttribute("userSigInfo");
            localWUserSigInfo1 = localWUserSigInfo2;
            if (localWUserSigInfo2 != null) {
              break;
            }
            localWUserSigInfo1 = (WUserSigInfo)paramFromServiceMsg.getAttribute("sigInfo");
          } while (localWUserSigInfo1 == null);
          paramFromServiceMsg = localWUserSigInfo1.loginResultTLVMap;
        } while (paramFromServiceMsg == null);
        paramFromServiceMsg = (tlv_t)paramFromServiceMsg.get(Integer.valueOf(1347));
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg = paramFromServiceMsg.get_data();
    } while (paramFromServiceMsg == null);
    paramBundle.putByteArray("tlverror", paramFromServiceMsg);
  }
  
  private void bundlePutTlv543In119(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if ((paramFromServiceMsg == null) || (paramBundle == null)) {}
    do
    {
      do
      {
        do
        {
          WUserSigInfo localWUserSigInfo1;
          do
          {
            return;
            WUserSigInfo localWUserSigInfo2 = (WUserSigInfo)paramFromServiceMsg.getAttribute("userSigInfo");
            localWUserSigInfo1 = localWUserSigInfo2;
            if (localWUserSigInfo2 != null) {
              break;
            }
            localWUserSigInfo1 = (WUserSigInfo)paramFromServiceMsg.getAttribute("sigInfo");
          } while (localWUserSigInfo1 == null);
          paramFromServiceMsg = localWUserSigInfo1.loginResultTLVMap;
        } while (paramFromServiceMsg == null);
        paramFromServiceMsg = (tlv_t)paramFromServiceMsg.get(Integer.valueOf(1676611));
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg = paramFromServiceMsg.get_data();
    } while (paramFromServiceMsg == null);
    paramBundle.putByteArray("tlv543In119", paramFromServiceMsg);
  }
  
  static boolean isQQUin(String paramString)
  {
    boolean bool2 = false;
    try
    {
      long l = Long.parseLong(paramString);
      boolean bool1 = bool2;
      if (l > 9999L)
      {
        bool1 = bool2;
        if (l < 4000000000L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("action", 0);
    }
    Object localObject9 = new Bundle();
    Object localObject12;
    int j;
    label318:
    Object localObject7;
    label341:
    Object localObject2;
    long l1;
    long l2;
    Object localObject11;
    Object localObject8;
    switch (i)
    {
    default: 
    case 2205: 
    case 2206: 
    case 2207: 
    case 1001: 
      for (;;)
      {
        return;
        Object localObject10 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject12 = paramFromServiceMsg.getBusinessFailMsg();
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        if (!paramFromServiceMsg.getAttributes().containsKey("resp_verify_image")) {
          break label5800;
        }
        Object localObject1 = (byte[])paramFromServiceMsg.getAttribute("resp_verify_image");
        if (!paramFromServiceMsg.getAttributes().containsKey("resp_verify_msg")) {
          break label5794;
        }
        localObject7 = (String)paramFromServiceMsg.getAttribute("resp_verify_msg");
        ((Bundle)localObject9).putString("uin", (String)localObject10);
        ((Bundle)localObject9).putInt("resultCode", i);
        ((Bundle)localObject9).putString("errorMsg", (String)localObject12);
        ((Bundle)localObject9).putInt("ret", j);
        ((Bundle)localObject9).putString("notice", (String)localObject7);
        ((Bundle)localObject9).putByteArray("image", (byte[])localObject1);
        notifyObserver(paramIntent, 2205, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        localObject7 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject10 = paramFromServiceMsg.getBusinessFailMsg();
        localObject12 = (String)paramFromServiceMsg.getAttribute("userAccount");
        Object localObject13 = (byte[])paramFromServiceMsg.getAttribute("userInput");
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
        localObject1 = null;
        if (paramFromServiceMsg.getAttributes().containsKey("image_buf")) {
          localObject1 = (byte[])paramFromServiceMsg.getAttribute("image_buf");
        }
        ((Bundle)localObject9).putString("uin", (String)localObject7);
        ((Bundle)localObject9).putInt("resultCode", i);
        ((Bundle)localObject9).putString("errorMsg", (String)localObject10);
        ((Bundle)localObject9).putString("userAccount", (String)localObject12);
        ((Bundle)localObject9).putByteArray("userInput", (byte[])localObject13);
        ((Bundle)localObject9).putInt("ret", j);
        ((Bundle)localObject9).putParcelable("lastError", localErrMsg);
        ((Bundle)localObject9).putByteArray("image", (byte[])localObject1);
        notifyObserver(paramIntent, 2206, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        localObject1 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject7 = paramFromServiceMsg.getBusinessFailMsg();
        localObject10 = (String)paramFromServiceMsg.getAttribute("userAccount");
        localObject12 = (byte[])paramFromServiceMsg.getAttribute("pictureData");
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        localObject13 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
        ((Bundle)localObject9).putString("uin", (String)localObject1);
        ((Bundle)localObject9).putInt("resultCode", i);
        ((Bundle)localObject9).putString("errorMsg", (String)localObject7);
        ((Bundle)localObject9).putString("userAccount", (String)localObject10);
        ((Bundle)localObject9).putByteArray("pictureData", (byte[])localObject12);
        ((Bundle)localObject9).putInt("ret", j);
        ((Bundle)localObject9).putParcelable("lastError", (Parcelable)localObject13);
        notifyObserver(paramIntent, 2207, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BuiltInServlet", 2, "login in back from msf build servlets start");
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        ((Bundle)localObject9).putString("uin", paramFromServiceMsg.getUin());
        ((Bundle)localObject9).putString("alias", paramIntent.getStringExtra("account"));
        ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
        localObject7 = paramFromServiceMsg.getAttribute("resp_login_url");
        localObject1 = "";
        if ((localObject7 instanceof String)) {
          localObject1 = (String)localObject7;
        }
        localObject7 = paramFromServiceMsg.getAttribute("resp_logini_ret");
        i = 0;
        if ((localObject7 instanceof Integer)) {
          i = ((Integer)localObject7).intValue();
        }
        localObject10 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
        localObject7 = null;
        if ((localObject10 instanceof byte[])) {
          localObject7 = (byte[])localObject10;
        }
        try
        {
          localObject10 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
          if (localObject10 != null)
          {
            ((Bundle)localObject9).putInt("errorver", ((ErrMsg)localObject10).getVersion());
            ((Bundle)localObject9).putString("title", ((ErrMsg)localObject10).getTitle());
          }
          ((Bundle)localObject9).putString("errorurl", (String)localObject1);
          ((Bundle)localObject9).putInt("loginret", i);
          ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
          ((Bundle)localObject9).putByteArray("lhsig", (byte[])localObject7);
          if (paramFromServiceMsg.isSuccess())
          {
            MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
            localObject1 = paramIntent.getStringExtra("account");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
            }
          }
        }
        catch (Exception localException15)
        {
          for (;;)
          {
            try
            {
              bundlePutTlv543In119(paramFromServiceMsg, (Bundle)localObject9);
              getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
              notifyObserver(paramIntent, 1001, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
              return;
              localException15 = localException15;
              QLog.e("mqq", 1, "getAttribute error:" + localException15.getMessage());
            }
            catch (Exception localException1)
            {
              QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + localException1.getMessage());
              continue;
            }
            MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
            try
            {
              bundlePutTlv543(paramFromServiceMsg, (Bundle)localObject9);
            }
            catch (Exception localException2)
            {
              QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + localException2.getMessage());
            }
          }
        }
      }
    case 1035: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "sub account login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      ((Bundle)localObject9).putString("uin", paramFromServiceMsg.getUin());
      ((Bundle)localObject9).putString("alias", paramIntent.getStringExtra("subaccount"));
      ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject2 = paramIntent.getStringExtra("subaccount");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject2);
        }
      }
      for (;;)
      {
        localObject2 = (String)paramFromServiceMsg.getAttribute("mainaccount");
        ((Bundle)localObject9).putString("submainaccount", (String)localObject2);
        localObject7 = getAppRuntime().getApplication().getFirstSimpleAccount();
        long l3 = System.currentTimeMillis();
        l1 = l3;
        if (localObject7 != null) {
          l2 = l3;
        }
        try
        {
          long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject7).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = 1L + l4;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error");
              l1 = l3;
            }
          }
        }
        catch (Exception localException14)
        {
          for (;;)
          {
            localException14.printStackTrace();
            l1 = l2;
          }
        }
        if (paramFromServiceMsg.getUin() != null) {
          getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
        }
        if (localObject2 != null) {
          getAppRuntime().getApplication().setProperty((String)localObject2 + Constants.Key._logintime, String.valueOf(l1 + 1L));
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
        }
        notifyObserver(paramIntent, 1035, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, SubAccountObserver.class);
        return;
        MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      }
    case 1100: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_account...");
      }
      ((Bundle)localObject9).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      ((Bundle)localObject9).putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
      if (paramFromServiceMsg.isSuccess())
      {
        ((Bundle)localObject9).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        ((Bundle)localObject9).putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        ((Bundle)localObject9).putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        ((Bundle)localObject9).putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        ((Bundle)localObject9).putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
        ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
        ((Bundle)localObject9).putString("uin", paramFromServiceMsg.getUin());
        notifyObserver(paramIntent, 1100, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, SSOAccountObserver.class);
        if (paramFromServiceMsg.getResultCode() != 1013) {
          break;
        }
        report(paramFromServiceMsg.getUin(), false, "ssoLoginAppTimeout", 0L, 0L, null, true);
        return;
        ((Bundle)localObject9).putInt("ret", -1);
      }
    case 1101: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_no_passwd...");
      }
      ((Bundle)localObject9).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        ((Bundle)localObject9).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        ((Bundle)localObject9).putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        ((Bundle)localObject9).putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
        ((Bundle)localObject9).putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        ((Bundle)localObject9).putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        ((Bundle)localObject9).putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject9).putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        ((Bundle)localObject9).putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1101, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, SSOAccountObserver.class);
        return;
        ((Bundle)localObject9).putInt("ret", -1);
      }
    case 1102: 
      ((Bundle)localObject9).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localObject2 = paramFromServiceMsg.getAttribute("dwSrcAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          ((Bundle)localObject9).putLong("dwSrcAppid", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwMainSigMap");
        if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
          ((Bundle)localObject9).putInt("dwMainSigMap", ((Integer)localObject2).intValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwSubSrcAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          ((Bundle)localObject9).putLong("dwSubSrcAppid", ((Long)localObject2).longValue());
        }
        ((Bundle)localObject9).putByteArray("dstAppName", (byte[])paramFromServiceMsg.getAttribute("dstAppName"));
        localObject2 = paramFromServiceMsg.getAttribute("dwDstSsoVer");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          ((Bundle)localObject9).putLong("dwDstSsoVer", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwDstAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          ((Bundle)localObject9).putLong("dwDstAppid", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwSubDstAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          ((Bundle)localObject9).putLong("dwSubDstAppid", ((Long)localObject2).longValue());
        }
        ((Bundle)localObject9).putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        ((Bundle)localObject9).putParcelable("fastLoginInfo", (Parcelable)paramFromServiceMsg.getAttribute("fastLoginInfo"));
        ((Bundle)localObject9).putByteArray("dstAppVer", (byte[])paramFromServiceMsg.getAttribute("dstAppVer"));
        ((Bundle)localObject9).putByteArray("dstAppSign", (byte[])paramFromServiceMsg.getAttribute("dstAppSign"));
        ((Bundle)localObject9).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      }
      ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject9).putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        ((Bundle)localObject9).putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        notifyObserver(paramIntent, 1102, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, SSOAccountObserver.class);
        return;
        ((Bundle)localObject9).putInt("ret", -1);
      }
    case 1037: 
      localObject12 = (String)paramFromServiceMsg.getAttribute("MSF.getKey");
      localObject11 = paramFromServiceMsg.getUin();
      localObject8 = null;
      localObject2 = localObject8;
      if (localObject12 != null)
      {
        localObject2 = ((String)localObject12).split(";");
        if (localObject2 == null) {
          break label5788;
        }
      }
      break;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        if (localObject2.length <= 0) {
          break label5788;
        }
        i = 0;
        if (i >= localObject2.length) {
          break label5788;
        }
        localObject12 = localObject2[i];
        if ((localObject12 == null) || (((String)localObject12).length() == 0) || (!((String)localObject12).startsWith("UIN=" + (String)localObject11 + ","))) {
          break label5806;
        }
        j = ((String)localObject12).indexOf("A2=");
        if (j < 0) {
          break label5806;
        }
        localObject12 = ((String)localObject12).substring(j);
        if ((localObject12 == null) || (((String)localObject12).length() == 0)) {
          break label5806;
        }
        localObject12 = ((String)localObject12).split(",");
        if ((localObject12 == null) || (localObject12.length <= 0) || (localObject12[0] == null) || (localObject12[0].length() <= "A2=".length() + 1)) {
          break label5806;
        }
        localObject2 = localObject12[0].substring("A2=".length());
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        localObject3 = localObject8;
        continue;
      }
      ((Bundle)localObject9).putString("uin", (String)localObject11);
      ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject9).putString("subaccountA2", (String)localObject2);
      ((Bundle)localObject9).putString("mainaccount", (String)paramFromServiceMsg.getAttribute("mainaccount"));
      notifyObserver(paramIntent, 1037, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, SubAccountObserver.class);
      return;
      notifyObserver(paramIntent, 1040, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
      return;
      if ((!"push.register".equals(paramFromServiceMsg.getServiceCmd())) && (!"push.unRegister".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      getAppRuntime().getOnlineStatus();
      l2 = -1L;
      l1 = 0L;
      boolean bool2;
      label3122:
      boolean bool3;
      label3134:
      boolean bool1;
      if (paramFromServiceMsg.isSuccess()) {
        if ("push.register".equals(paramFromServiceMsg.getServiceCmd())) {
          if ((paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
          {
            localObject8 = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
            if ((localObject8 != null) && (((SvcRespRegister)localObject8).cReplyCode == 0)) {
              if (((SvcRespRegister)localObject8).bUpdateFlag == 1)
              {
                bool2 = true;
                if (((SvcRespRegister)localObject8).bLargeSeqUpdate != 1) {
                  break label3502;
                }
                bool3 = true;
                i = ((SvcRespRegister)localObject8).iStatus;
                l1 = ((SvcRespRegister)localObject8).timeStamp;
                localObject3 = AppRuntime.Status.build(i);
                l2 = ((SvcRespRegister)localObject8).uExtOnlineStatus;
                if (localObject3 != null) {
                  break label5779;
                }
                QLog.d("mqq", 1, String.format("invalid iStatus: %s", new Object[] { Integer.valueOf(i) }));
                if (!paramFromServiceMsg.attributes.containsKey("attr_online_status")) {
                  break label3508;
                }
                i = ((Integer)paramFromServiceMsg.getAttribute("attr_online_status")).intValue();
                paramFromServiceMsg = AppRuntime.Status.build(i);
                QLog.d("mqq", 1, String.format("update iStatus: %s", new Object[] { Integer.valueOf(i) }));
                label3245:
                if (paramFromServiceMsg != null) {
                  break label5773;
                }
                paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
                QLog.e("mqq", 1, "register.push onlineStatus == null");
                bool1 = true;
              }
            }
          }
        }
      }
      for (;;)
      {
        boolean bool4 = bool3;
        bool3 = bool2;
        bool2 = bool4;
        for (;;)
        {
          bool4 = paramIntent.getBooleanExtra("isUserSet", false);
          getAppRuntime().getOnlineStatus();
          getAppRuntime().getExtOnlineStatus();
          getAppRuntime().setOnlineStatus(paramFromServiceMsg);
          if (l2 != -1L) {
            getAppRuntime().setExtOnlineStatus(l2);
          }
          ((Bundle)localObject9).putSerializable("onlineStatus", paramFromServiceMsg);
          ((Bundle)localObject9).putLong("extOnlineStatus", l2);
          ((Bundle)localObject9).putBoolean("isChanged", bool3);
          ((Bundle)localObject9).putLong("timeStamp", l1);
          ((Bundle)localObject9).putBoolean("isLargeChanged", bool2);
          ((Bundle)localObject9).putBoolean("isUserSet", bool4);
          notifyObserver(paramIntent, 1002, bool1, (Bundle)localObject9, AccountObserver.class);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("mqq", 2, String.format("register.push, isSuc = %s, onlineStatus = %s, isUserSet = %s, isChanged = %s, timeStamp = %s, isLargeChanged = %s, iStatus = %s, extStatus = %s", new Object[] { Boolean.valueOf(bool1), paramFromServiceMsg, Boolean.valueOf(bool4), Boolean.valueOf(bool3), Long.valueOf(l1), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(l2) }));
          return;
          bool2 = false;
          break label3122;
          label3502:
          bool3 = false;
          break label3134;
          label3508:
          QLog.d("mqq", 1, String.format("don't containsKey attr_online_status", new Object[0]));
          paramFromServiceMsg = (FromServiceMsg)localObject3;
          break label3245;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          if (localObject8 != null)
          {
            i = ((SvcRespRegister)localObject8).cReplyCode;
            label3553:
            if (localObject8 != null) {
              break label3612;
            }
          }
          label3612:
          for (bool1 = true;; bool1 = false)
          {
            QLog.d("mqq", 1, String.format("register.push resp is null [%s], cReplyCode: [%s]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) }));
            i = 0;
            bool3 = false;
            bool1 = false;
            bool2 = false;
            break;
            i = -1;
            break label3553;
          }
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
          QLog.d("mqq", 1, "register.push return empty packet! status: " + paramFromServiceMsg);
          bool3 = false;
          l2 = -1L;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = true;
          continue;
          paramFromServiceMsg = AppRuntime.Status.offline;
          bool3 = false;
          l2 = -1L;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = true;
          continue;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          QLog.d("mqq", 1, "register.push fail!");
          bool3 = false;
          l2 = -1L;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = false;
        }
        ((Bundle)localObject9).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject9).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount callback");
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            localException4.printStackTrace();
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
            ((Bundle)localObject9).putInt("code", j);
            ((Bundle)localObject9).putByteArray("mobile", arrayOfByte1);
            if (paramIntent.hasExtra("inviteCode")) {
              ((Bundle)localObject9).putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
            }
            notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
            return;
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            continue;
          }
          if (paramFromServiceMsg.getBusinessFailCode() == 3001)
          {
            Object localObject4 = paramFromServiceMsg.getBusinessFailMsg();
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              try
              {
                j = Integer.valueOf((String)localObject4).intValue();
                localObject4 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
                ((Bundle)localObject9).putInt("code", j);
                ((Bundle)localObject9).putByteArray("mobile", (byte[])localObject4);
                if (paramIntent.hasExtra("inviteCode")) {
                  ((Bundle)localObject9).putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
                }
              }
              catch (Exception localException6)
              {
                localException6.printStackTrace();
              }
            }
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        int k;
        int m;
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          ((Bundle)localObject9).putInt("code", j);
          ((Bundle)localObject9).putInt("next_chk_time", k);
          ((Bundle)localObject9).putInt("total_time_over", m);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException7)
        {
          for (;;)
          {
            localException7.printStackTrace();
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject9).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          String str1 = (String)paramFromServiceMsg.getAttribute("bind_qq_uin");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject9).putString("bind_qq_uin", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_nick");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject9).putString("bind_qq_nick", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_faceUrl");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject9).putString("bind_qq_face_url", str1);
          }
        }
        catch (Exception localException8)
        {
          for (;;)
          {
            localException8.printStackTrace();
          }
        }
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        ((Bundle)localObject9).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          String str2 = (String)paramFromServiceMsg.getAttribute("res_register_errmsg", "");
          localObject8 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject11 = (String)paramFromServiceMsg.getAttribute("resp_register_nick", "");
          localObject12 = (String)paramFromServiceMsg.getAttribute("resp_register_picture_url", "");
          ((Bundle)localObject9).putInt("code", j);
          ((Bundle)localObject9).putInt("next_chk_time", k);
          ((Bundle)localObject9).putInt("total_time_over", m);
          ((Bundle)localObject9).putString("errmsg", str2);
          ((Bundle)localObject9).putString("uin", (String)localObject8);
          ((Bundle)localObject9).putString("nick", (String)localObject11);
          ((Bundle)localObject9).putString("faceUrl", (String)localObject12);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException9)
        {
          for (;;)
          {
            localException9.printStackTrace();
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_contactssig", new byte[0]);
            localObject8 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
            localObject11 = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
            localObject12 = (byte[])paramFromServiceMsg.getAttribute("resp_register_supersig", null);
            if ((localObject11 != null) && (localObject11.length > 0))
            {
              ((Bundle)localObject9).putByteArray("lhsig", (byte[])localObject11);
              if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "builtInServlet|LiangHao_lhsig= " + new String((byte[])localObject11));
              }
            }
            ((Bundle)localObject9).putByteArray("resp_register_supersig", (byte[])localObject12);
            ((Bundle)localObject9).putInt("code", j);
            ((Bundle)localObject9).putByteArray("promptInfo", arrayOfByte2);
            ((Bundle)localObject9).putString("uin", (String)localObject8);
            if (QLog.isColorLevel()) {
              QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive code= " + j + ",uin=" + (String)localObject8);
            }
          }
          catch (Exception localException10)
          {
            localException10.printStackTrace();
            continue;
          }
          if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
            ((Bundle)localObject9).putBoolean("reg_Lianghao", true);
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive failed = " + paramFromServiceMsg.getBusinessFailCode());
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject9).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException11)
        {
          for (;;)
          {
            localException11.printStackTrace();
          }
        }
        ((Bundle)localObject9).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          String str3 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject8 = (String)paramFromServiceMsg.getAttribute("to_register_cr_mobile", "");
          ((Bundle)localObject9).putInt("code", j);
          ((Bundle)localObject9).putString("uin", str3);
          ((Bundle)localObject9).putString("phone", (String)localObject8);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException12)
        {
          for (;;)
          {
            localException12.printStackTrace();
          }
        }
        notifyObserver(paramIntent, 1007, paramFromServiceMsg.isSuccess(), null, AccountObserver.class);
        return;
        ((Bundle)localObject9).putSerializable("map", paramFromServiceMsg.attributes);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        ((Bundle)localObject9).putString("key", (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        Object localObject5 = paramIntent.getStringExtra("uin");
        localObject8 = paramIntent.getStringExtra("cmd");
        l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
        paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramIntent.order(ByteOrder.BIG_ENDIAN);
        i = paramIntent.getInt();
        localObject9 = new byte[i - 4];
        paramIntent.get((byte[])localObject9, 0, i - 4);
        if (paramFromServiceMsg.isSuccess())
        {
          WtloginMsfListener.onAsyncReceive((String)localObject5, (String)localObject8, l1, (byte[])localObject9);
          return;
        }
        WtloginMsfListener.onAsyncReceiveFail((String)localObject5, (String)localObject8, l1, paramFromServiceMsg.getBusinessFailCode());
        return;
        if (paramFromServiceMsg.isSuccess())
        {
          localObject5 = new UniPacket(true);
          ((UniPacket)localObject5).setEncodeName("utf-8");
          ((UniPacket)localObject5).decode(paramFromServiceMsg.getWupBuffer());
          ((Bundle)localObject9).putSerializable("jce", (GetResourceRespV2)((UniPacket)localObject5).getByClass("GetResourceRespV2", new GetResourceRespV2()));
        }
        ((Bundle)localObject9).putInt("iPluginType", paramIntent.getIntExtra("iPluginType", 64));
        notifyObserver(paramIntent, 1018, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, ServerConfigObserver.class);
        return;
        paramIntent = paramFromServiceMsg.getUin();
        paramFromServiceMsg = (HashMap)paramFromServiceMsg.getAttributes().get("keyMap");
        if ((TextUtils.isEmpty(paramIntent)) || (getAppRuntime() == null) || (!paramIntent.equals(getAppRuntime().getAccount()))) {
          break;
        }
        ((TicketManager)getAppRuntime().getManager(2)).setAlterTicket(paramFromServiceMsg);
        return;
        localObject5 = paramFromServiceMsg.getUin();
        localObject8 = (byte[])paramFromServiceMsg.getAttributes().get("da2");
        ((Bundle)localObject9).putString("account", (String)localObject5);
        ((Bundle)localObject9).putString("da2", new String((byte[])localObject8));
        notifyObserver(paramIntent, 1046, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
        return;
        ((Bundle)localObject9).putString("msf_con_erro", (String)paramFromServiceMsg.getAttribute("msf_con_erro", ""));
        notifyObserver(paramIntent, 2201, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, CheckConErroObserver.class);
        return;
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          bundlePutTlv543In119(paramFromServiceMsg, (Bundle)localObject9);
          ((Bundle)localObject9).putString("account", paramFromServiceMsg.getUin());
          ((Bundle)localObject9).putInt("code", paramFromServiceMsg.getResultCode());
          ((Bundle)localObject9).putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
          ((Bundle)localObject9).putString("error", paramFromServiceMsg.getBusinessFailMsg());
          notifyObserver(paramIntent, 2400, paramFromServiceMsg.isSuccess(), (Bundle)localObject9, AccountObserver.class);
          return;
        }
        catch (Exception localException13)
        {
          for (;;)
          {
            QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + localException13.getMessage());
          }
        }
        label5773:
        bool1 = true;
        continue;
        label5779:
        bool1 = true;
        paramFromServiceMsg = localException13;
      }
      label5788:
      Object localObject6 = null;
      continue;
      label5794:
      localObject8 = null;
      break label341;
      label5800:
      localObject6 = null;
      break label318;
      label5806:
      i += 1;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void report(String paramString1, boolean paramBoolean1, String paramString2, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "10000";
    }
    if (((localObject == null) || (((String)localObject).length() >= 1)) || (paramHashMap == null))
    {
      paramString1 = new HashMap();
      paramHashMap = new RdmReq();
      paramHashMap.eventName = paramString2;
      paramHashMap.elapse = paramLong1;
      paramHashMap.size = paramLong2;
      paramHashMap.isSucceed = paramBoolean1;
      paramHashMap.isRealTime = paramBoolean2;
      paramHashMap.isMerge = false;
      paramHashMap.isRealTime = true;
      paramHashMap.params = paramString1;
    }
    try
    {
      paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
      MsfServiceSdk.get().sendMsg(paramString1);
      return;
    }
    catch (Exception paramString1) {}
    localObject = paramHashMap.keySet().iterator();
    for (;;)
    {
      paramString1 = paramHashMap;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramString1 = (String)((Iterator)localObject).next();
      if ((String)paramHashMap.get(paramString1) == null) {
        paramHashMap.put(paramString1, "");
      }
    }
  }
  
  public void service(Intent paramIntent)
  {
    super.service(paramIntent);
    Object localObject2;
    Object localObject3;
    int j;
    boolean bool;
    switch (paramIntent.getIntExtra("action", 0))
    {
    default: 
    case 1001: 
    case 2201: 
    case 1035: 
    case 2123: 
    case 1100: 
    case 2205: 
    case 2206: 
    case 2207: 
    case 1101: 
    case 1102: 
    case 1037: 
    case 1040: 
    case 1002: 
    case 1025: 
    case 1026: 
    case 1041: 
    case 1003: 
    case 1020: 
    case 1004: 
    case 1022: 
    case 1005: 
    case 1008: 
    case 1009: 
    case 1007: 
    case 1030: 
    case 2203: 
    case 1032: 
    case 1012: 
    case 1018: 
    case 1042: 
    case 1043: 
    case 1044: 
    case 2124: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getByteArrayExtra("password");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, (byte[])localObject2);; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, (byte[])localObject2))
                {
                  localObject2 = paramIntent.getByteArrayExtra("resp_register_supersig");
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  ((ToServiceMsg)localObject1).addAttribute("resp_register_supersig", localObject2);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = getAppRuntime().getService().msfSub.getCheckMsfConErroMsg();
                ((ToServiceMsg)localObject1).setTimeout(10000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("subaccount");
                localObject3 = paramIntent.getStringExtra("subpassword");
                localObject2 = paramIntent.getStringExtra("mainaccount");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
                  ((ToServiceMsg)localObject1).addAttribute("mainaccount", localObject2);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("uin");
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRefreshTicketsMsg((String)localObject1));
                return;
                localObject2 = paramIntent.getStringExtra("process");
                localObject1 = paramIntent.getStringExtra("ssoAccount");
                localObject3 = paramIntent.getStringExtra("ssoPassword");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "ssoAccountAction");
                  ((ToServiceMsg)localObject1).addAttribute("appid", Long.valueOf(paramIntent.getLongExtra("appid", 16L)));
                  ((ToServiceMsg)localObject1).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                  ((ToServiceMsg)localObject1).addAttribute("process", localObject2);
                  addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject1);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getStringExtra("password");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdMsg((String)localObject1, MD5.toMD5Byte((String)localObject2));
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getStringExtra("verifyCode");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdImageMsg((String)localObject1, (String)localObject2);
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdRefreshImageMsg((String)localObject1);
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("process");
                localObject3 = paramIntent.getStringExtra("ssoAccount");
                localObject2 = paramIntent.getStringExtra("from_where");
                localObject3 = getAppRuntime().getService().msfSub.getLoginWithoutPasswdMsg((String)localObject3);
                ((ToServiceMsg)localObject3).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                ((ToServiceMsg)localObject3).addAttribute("dwSrcAppid", Long.valueOf(paramIntent.getLongExtra("dwSrcAppid", 16L)));
                ((ToServiceMsg)localObject3).addAttribute("dwDstAppid", Long.valueOf(paramIntent.getLongExtra("dwDstAppid", 16L)));
                ((ToServiceMsg)localObject3).addAttribute("process", localObject1);
                if ((localObject2 != null) && (((String)localObject2).length() > 0))
                {
                  ((ToServiceMsg)localObject3).addAttribute("from_where", localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("builtInservert", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
                  }
                }
                addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject3);
                ((ToServiceMsg)localObject3).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject3);
                return;
                localObject4 = paramIntent.getStringExtra("ssoAccount");
                localObject1 = paramIntent.getByteArrayExtra("dstAppName");
                l1 = paramIntent.getLongExtra("dwDstSsoVer", 0L);
                long l2 = paramIntent.getLongExtra("dwDstAppid", 0L);
                long l3 = paramIntent.getLongExtra("dwSubDstAppid", 0L);
                localObject2 = paramIntent.getByteArrayExtra("dstAppVer");
                localObject3 = paramIntent.getByteArrayExtra("dstAppSign");
                localObject4 = getAppRuntime().getService().msfSub.getA1WithA1((String)localObject4);
                ((ToServiceMsg)localObject4).addAttribute("dstAppName", localObject1);
                ((ToServiceMsg)localObject4).addAttribute("dwDstSsoVer", Long.valueOf(l1));
                ((ToServiceMsg)localObject4).addAttribute("dwDstAppid", Long.valueOf(l2));
                ((ToServiceMsg)localObject4).addAttribute("dwSubDstAppid", Long.valueOf(l3));
                ((ToServiceMsg)localObject4).addAttribute("dstAppVer", localObject2);
                ((ToServiceMsg)localObject4).addAttribute("dstAppSign", localObject3);
                ((ToServiceMsg)localObject4).addAttribute("fastLoginInfo", new WFastLoginInfo());
                localObject1 = paramIntent.getStringExtra("process");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((ToServiceMsg)localObject4).addAttribute("process", localObject1);
                }
                addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject4);
                ((ToServiceMsg)localObject4).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject4);
                return;
                localObject2 = paramIntent.getStringExtra("subaccountuin");
                localObject1 = paramIntent.getStringExtra("mainaccount");
                localObject2 = getAppRuntime().getService().msfSub.getKeyMsg((String)localObject2);
                ((ToServiceMsg)localObject2).setTimeout(10000L);
                ((ToServiceMsg)localObject2).addAttribute("from_where", "subaccount");
                ((ToServiceMsg)localObject2).addAttribute("mainaccount", localObject1);
                sendToMSF(paramIntent, (ToServiceMsg)localObject2);
                return;
                localObject1 = new CommandCallbackerInfo();
                ((CommandCallbackerInfo)localObject1).uin = getAppRuntime().getAccount();
                localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                localObject3 = new ArrayList();
                j = localObject2.length;
                i = 0;
                while (i < j)
                {
                  ((ArrayList)localObject3).add(localObject2[i]);
                  i += 1;
                }
                ((CommandCallbackerInfo)localObject1).cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                return;
                if (!this.isRegist)
                {
                  localObject1 = new CommandCallbackerInfo();
                  ((CommandCallbackerInfo)localObject1).uin = getAppRuntime().getAccount();
                  localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                  localObject3 = new ArrayList();
                  j = localObject2.length;
                  i = 0;
                  while (i < j)
                  {
                    ((ArrayList)localObject3).add(localObject2[i]);
                    i += 1;
                  }
                  ((CommandCallbackerInfo)localObject1).cmds = ((ArrayList)localObject3);
                  sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                  this.isRegist = true;
                }
                localObject2 = new PushRegisterInfo();
                if (paramIntent.getBooleanExtra("kick", false))
                {
                  b = 1;
                  ((PushRegisterInfo)localObject2).bKikPC = b;
                  ((PushRegisterInfo)localObject2).bKikWeak = 0;
                  localObject3 = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
                  bool = paramIntent.getBooleanExtra("isUserSet", false);
                  ((PushRegisterInfo)localObject2).iStatus = ((AppRuntime.Status)localObject3).getValue();
                  l1 = paramIntent.getLongExtra("extOnlineStatus", -1L);
                  ((PushRegisterInfo)localObject2).extStatus = l1;
                  if ((localObject3 == AppRuntime.Status.online) && (l1 == 1000L))
                  {
                    ((PushRegisterInfo)localObject2).batteryCapacity = paramIntent.getIntExtra("batteryCapacity", 0);
                    ((PushRegisterInfo)localObject2).powerConnect = paramIntent.getIntExtra("powerConnect", -1);
                  }
                  localObject1 = new ArrayList();
                  ((ArrayList)localObject1).add(Long.valueOf(1L));
                  ((ArrayList)localObject1).add(Long.valueOf(2L));
                  ((ArrayList)localObject1).add(Long.valueOf(4L));
                  ((PushRegisterInfo)localObject2).pushIds = ((ArrayList)localObject1);
                  ((PushRegisterInfo)localObject2).timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                  ((PushRegisterInfo)localObject2).iLargeSeq = paramIntent.getLongExtra("K_SEQ", 0L);
                  ((PushRegisterInfo)localObject2).uin = getAppRuntime().getAccount();
                  if (localObject3 != AppRuntime.Status.offline) {
                    break label2040;
                  }
                  localObject1 = getAppRuntime().getService().msfSub.getUnRegisterPushMsg((PushRegisterInfo)localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.contacts.", 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + localObject3 + ", " + ((PushRegisterInfo)localObject2).timeStamp + ", " + ((PushRegisterInfo)localObject2).iLargeSeq + ", isUserSet: " + bool);
                  }
                  if (!bool) {
                    break label2060;
                  }
                  ((ToServiceMsg)localObject1).getAttributes().put("regPushReason", RegPushReason.setOnlineStatus);
                }
                for (;;)
                {
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                  b = 0;
                  break;
                  localObject1 = getAppRuntime().getService().msfSub.getRegisterPushMsg((PushRegisterInfo)localObject2);
                  break label1934;
                  ((ToServiceMsg)localObject1).getAttributes().put("regPushReason", RegPushReason.appRegister);
                }
                j = paramIntent.getIntExtra("appid", 0);
                localObject1 = paramIntent.getStringExtra("processName");
                localObject2 = paramIntent.getStringExtra("broadcastName");
                localObject4 = paramIntent.getStringArrayExtra("commands");
                localObject3 = new ArrayList();
                int k = localObject4.length;
                i = 0;
                while (i < k)
                {
                  ((ArrayList)localObject3).add(localObject4[i]);
                  i += 1;
                }
                localObject4 = new NotifyRegisterInfo();
                ((NotifyRegisterInfo)localObject4).uin = getAppRuntime().getAccount();
                ((NotifyRegisterInfo)localObject4).notifyIds = new ArrayList();
                ((NotifyRegisterInfo)localObject4).notifyProperties = new HashMap();
                localObject5 = new CommandCallbackerInfo();
                ((CommandCallbackerInfo)localObject5).uin = getAppRuntime().getAccount();
                ((CommandCallbackerInfo)localObject5).cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, MsfServiceSdk.get().getRegisterProxyMsg(j, getAppRuntime().getAccount(), (String)localObject1, (String)localObject2, (NotifyRegisterInfo)localObject4, (CommandCallbackerInfo)localObject5));
                return;
                i = paramIntent.getIntExtra("appid", 0);
                sendToMSF(paramIntent, MsfServiceSdk.get().getUnRegisterProxyMsg(i, getAppRuntime().getAccount(), paramIntent.getStringExtra("processName")));
                return;
                localObject1 = paramIntent.getStringExtra("countryCode");
                localObject2 = paramIntent.getStringExtra("phoneNumber");
                localObject1 = (String)localObject1 + "-" + (String)localObject2;
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegQueryAccountMsg((String)localObject1));
              } while (!QLog.isColorLevel());
              QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount");
              return;
              localObject1 = paramIntent.getStringExtra("countryCode");
              localObject2 = paramIntent.getStringExtra("phoneNumber");
              Object localObject5 = paramIntent.getStringExtra("inviteCode");
              long l1 = paramIntent.getLongExtra("appid", 0L);
              Object localObject4 = paramIntent.getStringExtra("verifySig");
              String str1 = (String)localObject1 + "-" + (String)localObject2;
              String str2 = paramIntent.getStringExtra("appVersion");
              byte b = paramIntent.getByteExtra("language", (byte)2);
              localObject1 = paramIntent.getStringExtra("wifi_mac");
              localObject3 = paramIntent.getStringExtra("os_language");
              i = paramIntent.getIntExtra("qq_language", 0);
              localObject2 = paramIntent.getStringExtra("gps_location");
              localObject4 = getAppRuntime().getService().msfSub.getRegisterCommitMobileMsg((String)localObject4, (byte)0, b, (byte)0, "", str2, str1, Long.valueOf(l1));
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                ((ToServiceMsg)localObject4).getAttributes().put("To_register_Invitation_code", localObject5);
              }
              localObject5 = ((ToServiceMsg)localObject4).getAttributes();
              if (localObject1 == null)
              {
                localObject1 = "";
                ((HashMap)localObject5).put("wifi_mac", localObject1);
                localObject5 = ((ToServiceMsg)localObject4).getAttributes();
                if (localObject3 != null) {
                  break label2668;
                }
                localObject1 = "";
                ((HashMap)localObject5).put("os_language", localObject1);
                ((ToServiceMsg)localObject4).getAttributes().put("qq_language", Integer.valueOf(i));
                localObject3 = ((ToServiceMsg)localObject4).getAttributes();
                if (localObject2 != null) {
                  break label2675;
                }
              }
              for (localObject1 = "";; localObject1 = localObject2)
              {
                ((HashMap)localObject3).put("gps_location", localObject1);
                sendToMSF(paramIntent, (ToServiceMsg)localObject4);
                return;
                break;
                localObject1 = localObject3;
                break label2602;
              }
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterSendReSendSmsMsg());
              return;
              localObject1 = paramIntent.getStringExtra("code");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitSmsCodeMsg((String)localObject1));
              return;
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterQueryUpSmsStatMsg());
              return;
              localObject1 = paramIntent.getStringExtra("password");
              localObject2 = paramIntent.getStringExtra("nick");
              localObject3 = paramIntent.getStringExtra("code");
              bool = true;
              if (paramIntent.hasExtra("bindMobile")) {
                bool = paramIntent.getBooleanExtra("bindMobile", true);
              }
              localObject4 = paramIntent.getStringExtra("lhuin");
              localObject5 = paramIntent.getStringExtra("unBindlhUin");
              str1 = paramIntent.getStringExtra("appVersion");
              str2 = paramIntent.getStringExtra("wx_token");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitPassMsg((String)localObject3, (String)localObject1, (String)localObject2, bool, (String)localObject4, (String)localObject5, str1, str2));
              return;
              localObject1 = paramIntent.getStringExtra("account");
              i = paramIntent.getIntExtra("appid", 0);
              localObject2 = paramIntent.getStringExtra("appVersion");
              localObject2 = getAppRuntime().getService().msfSub.checkQuickRegisterAccount((String)localObject1, i, (byte)2, (String)localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + (String)localObject1);
              }
              sendToMSF(paramIntent, (ToServiceMsg)localObject2);
              return;
              localObject1 = paramIntent.getStringExtra("account");
              localObject3 = paramIntent.getStringExtra("password");
              localObject2 = paramIntent.getStringExtra("nick");
              i = paramIntent.getIntExtra("appid", 0);
              localObject4 = paramIntent.getStringExtra("appVersion");
              localObject3 = getAppRuntime().getService().msfSub.getQuickRegisterAccount((String)localObject1, (String)localObject3, (String)localObject2, i, (byte)2, (String)localObject4);
              if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + (String)localObject1 + ",nick=" + (String)localObject2);
              }
              sendToMSF(paramIntent, (ToServiceMsg)localObject3);
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              localObject2 = paramIntent.getStringExtra("alias");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getDelLoginedAccount(getAppRuntime().getAccount(), (String)localObject1, (String)localObject2));
              return;
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getKeyMsg(getAppRuntime().getAccount()));
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              localObject2 = paramIntent.getStringExtra("cmd");
              localObject3 = paramIntent.getByteArrayExtra("busBuf");
              i = paramIntent.getIntExtra("timeout", 30000);
              l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getSendWtPkgMsg((String)localObject1, l1, (String)localObject2, (byte[])localObject3, i));
              return;
              localObject1 = (HashMap)paramIntent.getSerializableExtra("mapSt");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, (HashMap)localObject1));
              return;
              b = paramIntent.getByteExtra("type", (byte)0);
              localObject1 = paramIntent.getStringExtra("content");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getReportMsg(b, (String)localObject1));
              return;
              localObject1 = getAppRuntime().getService().msfSub.getPluginConfigMsg(getAppRuntime().getAccount());
              ((ToServiceMsg)localObject1).putWupBuffer(paramIntent.getByteArrayExtra("buffer"));
              ((ToServiceMsg)localObject1).setTimeout(10000L);
              sendToMSF(paramIntent, (ToServiceMsg)localObject1);
              return;
              i = paramIntent.getIntExtra("value", 1);
              localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "Msf.NetException");
              ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand._msf_NetException);
              ((ToServiceMsg)localObject1).addAttribute("NetExceptionType", Integer.valueOf(i));
              ((ToServiceMsg)localObject1).setNeedCallback(false);
            } while (localObject1 == null);
            if (QLog.isColorLevel()) {
              QLog.d("MSFServlet", 2, "ACTION_NET_EXCEPTION_EVENT send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
            }
            sendToMSF(paramIntent, (ToServiceMsg)localObject1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSFServlet", 4, "WIRELESS_PSWREQ:");
            }
            i = paramIntent.getIntExtra("cmd", 1);
            localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "KsidTrans.Trans");
            ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_PSWREQ);
            ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
            ((ToServiceMsg)localObject1).setNeedCallback(false);
          } while (localObject1 == null);
          if (QLog.isColorLevel()) {
            QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_PSWREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
          }
          sendToMSF(paramIntent, (ToServiceMsg)localObject1);
          return;
          i = paramIntent.getIntExtra("cmd", 1);
          localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "PwdProtect.DataUpload");
          ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_MEIBAOREQ);
          ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
          ((ToServiceMsg)localObject1).setNeedCallback(false);
        } while (localObject1 == null);
        if (QLog.isColorLevel()) {
          QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
        }
        sendToMSF(paramIntent, (ToServiceMsg)localObject1);
        return;
        localObject1 = paramIntent.getStringExtra("uin");
        localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "");
        ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.getAlterTickets);
        ((ToServiceMsg)localObject1).setNeedCallback(true);
      } while (localObject1 == null);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2200: 
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_UNGUARD_APP send now");
      }
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), null, "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.gm_GuardEvent);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      ((ToServiceMsg)localObject1).addAttribute("k_event", Integer.valueOf(paramIntent.getIntExtra("k_event", 0)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg0", Long.valueOf(paramIntent.getLongExtra("k_arg0", 0L)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg1", Long.valueOf(paramIntent.getLongExtra("k_arg1", 0L)));
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2126: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.startPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2127: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.stopPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2128: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      bool = paramIntent.getBooleanExtra("opened", false);
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.openPCActive);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).getAttributes().put("opened", Boolean.valueOf(bool));
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2202: 
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_msgsignal);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 1046: 
      localObject1 = paramIntent.getStringExtra("account");
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "login.chgTok_DA2");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_refreshDA2);
      ((ToServiceMsg)localObject1).setNeedCallback(true);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2204: 
      localObject1 = paramIntent.getStringExtra("longitude");
      localObject2 = paramIntent.getStringExtra("latitude");
      localObject3 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand.msf_save_geoginfo);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_lontitude", localObject1);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_latitude", localObject2);
      ((ToServiceMsg)localObject3).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject3);
      return;
    case 2210: 
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      i = paramIntent.getIntExtra("opType", 0);
      j = paramIntent.getIntExtra("manualLogLevel", 2);
      ((ToServiceMsg)localObject1).getAttributes().put("opType", Integer.valueOf(i));
      ((ToServiceMsg)localObject1).getAttributes().put("manualLogLevel", Integer.valueOf(j));
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_manual_set_log_level);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2400: 
      label1934:
      label2040:
      localObject1 = paramIntent.getStringExtra("account");
      label2060:
      label2602:
      label2668:
      label2675:
      localObject1 = getAppRuntime().getService().msfSub.getLoginByWxMsg((String)localObject1);
      ((ToServiceMsg)localObject1).setTimeout(40000L);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    }
    Object localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
    int i = paramIntent.getIntExtra("localeId", 0);
    ((ToServiceMsg)localObject1).getAttributes().put("localeId", Integer.valueOf(i));
    ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_update_locale_id);
    ((ToServiceMsg)localObject1).setNeedCallback(false);
    sendToMSF(paramIntent, (ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.BuiltInServlet
 * JD-Core Version:    0.7.0.1
 */