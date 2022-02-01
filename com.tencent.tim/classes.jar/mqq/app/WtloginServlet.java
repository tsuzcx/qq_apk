package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class WtloginServlet
  extends MSFServlet
  implements Constants.Action
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int k = 0;
    int j = 0;
    if (paramFromServiceMsg.getBusinessFailCode() == 3002) {}
    Bundle localBundle;
    for (int i = 2107;; i = paramIntent.getIntExtra("action", 0))
    {
      localBundle = new Bundle();
      switch (i)
      {
      default: 
        return;
      }
    }
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putLong("dwAppid", ((Long)paramFromServiceMsg.attributes.get("dwAppid")).longValue());
      localBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      localBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      localBundle.putString("userPasswd", (String)paramFromServiceMsg.attributes.get("userPasswd"));
      localBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2100, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      localBundle.putLong("dwDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwDstAppid")).longValue());
      localBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      localBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2101, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      localBundle.putLong("dwDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwDstAppid")).longValue());
      localBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      localBundle.putByteArray("appid", (byte[])paramFromServiceMsg.attributes.get("appid"));
      localBundle.putByteArray("openid", (byte[])paramFromServiceMsg.attributes.get("openid"));
      localBundle.putByteArray("accessToken", (byte[])paramFromServiceMsg.attributes.get("accessToken"));
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2208, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      localBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2102, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2103, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putByteArray("appName", (byte[])paramFromServiceMsg.attributes.get("appName"));
      localBundle.putLong("time", ((Long)paramFromServiceMsg.attributes.get("time")).longValue());
      localBundle.putStringArrayList("data", (ArrayList)paramFromServiceMsg.attributes.get("data"));
      localBundle.putByteArray("errMsg", (byte[])paramFromServiceMsg.attributes.get("errMsg"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2104, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putByteArray("appName", (byte[])paramFromServiceMsg.attributes.get("appName"));
      localBundle.putLong("time", ((Long)paramFromServiceMsg.attributes.get("time")).longValue());
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putByteArray("errMsg", (byte[])paramFromServiceMsg.attributes.get("errMsg"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2105, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      localBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      localBundle.putLong("dwSubSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubSrcAppid")).longValue());
      localBundle.putByteArray("dstAppName", (byte[])paramFromServiceMsg.attributes.get("dstAppName"));
      localBundle.putLong("dwDstSsoVer", ((Long)paramFromServiceMsg.attributes.get("dwDstSsoVer")).longValue());
      localBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      localBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      localBundle.putByteArray("dstAppVer", (byte[])paramFromServiceMsg.attributes.get("dstAppVer"));
      localBundle.putByteArray("dstAppSign", (byte[])paramFromServiceMsg.attributes.get("dstAppSign"));
      localBundle.putParcelable("userSigInfo", (WUserSigInfo)paramFromServiceMsg.attributes.get("userSigInfo"));
      localBundle.putParcelable("fastLoginInfo", (WFastLoginInfo)paramFromServiceMsg.attributes.get("fastLoginInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2106, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putParcelable("devLockInfo", (Parcelable)paramFromServiceMsg.attributes.get("devLockInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2108, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putParcelable("devLockInfo", (Parcelable)paramFromServiceMsg.attributes.get("devLockInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2109, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2110, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2111, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putLong("smsAppid", ((Long)paramFromServiceMsg.attributes.get("smsAppid")).longValue());
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putInt("remainMsgCnt", ((Integer)paramFromServiceMsg.attributes.get("remainMsgCnt")).intValue());
      localBundle.putInt("timeLimit", ((Integer)paramFromServiceMsg.attributes.get("timeLimit")).intValue());
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2112, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2113, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      localBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      localBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      localBundle.putParcelable("st", null);
      localBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2114, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    localBundle.putString("error", (String)paramFromServiceMsg.attributes.get("error"));
    localBundle.putInt("cmd", ((Integer)paramFromServiceMsg.attributes.get("cmd")).intValue());
    notifyObserver(paramIntent, 2107, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
    return;
    Object localObject1;
    if (paramFromServiceMsg.attributes != null)
    {
      localObject2 = paramFromServiceMsg.getAttribute("userAccount");
      localObject1 = Long.valueOf(0L);
      if (localObject2 != null) {
        localObject1 = (Long)localObject2;
      }
      localBundle.putLong("userAccount", ((Long)localObject1).longValue());
      localBundle.putByteArray("supersig", (byte[])paramFromServiceMsg.attributes.get("supersig"));
      localBundle.putByteArray("contactssig", (byte[])paramFromServiceMsg.attributes.get("contactssig"));
      localBundle.putByteArray("msg", (byte[])paramFromServiceMsg.attributes.get("msg"));
      localObject2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localBundle.putByteArray("lhsig", (byte[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|lhsig= " + new String((byte[])localObject2));
        }
      }
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      i = paramFromServiceMsg.getBusinessFailCode();
      if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
        break label4653;
      }
    }
    Integer localInteger;
    label4621:
    label4626:
    label4635:
    label4644:
    label4653:
    for (Object localObject2 = (Integer)localObject2;; localInteger = Integer.valueOf(i))
    {
      localBundle.putInt("ret", ((Integer)localObject2).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|RegGetAccount|ret=" + localObject2 + ",uin=" + localObject1);
      }
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
        localBundle.putBoolean("reg_LiangHao", true);
      }
      notifyObserver(paramIntent, 2117, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
      return;
      if (paramFromServiceMsg.attributes != null)
      {
        localBundle.putString("countryCode", (String)paramFromServiceMsg.attributes.get("countryCode"));
        localBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
        localBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
        localBundle.putString("msg", (String)paramFromServiceMsg.attributes.get("msg"));
        localObject1 = paramFromServiceMsg.getAttribute("ret");
        i = paramFromServiceMsg.getBusinessFailCode();
        if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
          break label4644;
        }
      }
      for (localObject1 = (Integer)localObject1;; localObject1 = Integer.valueOf(i))
      {
        localBundle.putInt("ret", ((Integer)localObject1).intValue());
        notifyObserver(paramIntent, 2118, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
        return;
        if (paramFromServiceMsg.attributes != null)
        {
          localBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
          localBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
          localBundle.putString("msg", (String)paramFromServiceMsg.attributes.get("msg"));
          localObject1 = paramFromServiceMsg.getAttribute("ret");
          i = paramFromServiceMsg.getBusinessFailCode();
          if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
            break label4635;
          }
        }
        for (localObject1 = (Integer)localObject1;; localObject1 = Integer.valueOf(i))
        {
          localBundle.putInt("ret", ((Integer)localObject1).intValue());
          notifyObserver(paramIntent, 2119, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
          return;
          if (paramFromServiceMsg.attributes != null)
          {
            localBundle.putString("msgCode", (String)paramFromServiceMsg.attributes.get("msgCode"));
            localBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
            localBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
            localObject1 = paramFromServiceMsg.getAttribute("ret");
            i = paramFromServiceMsg.getBusinessFailCode();
            if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
              break label4626;
            }
          }
          for (localObject1 = (Integer)localObject1;; localObject1 = Integer.valueOf(i))
          {
            localBundle.putInt("ret", ((Integer)localObject1).intValue());
            notifyObserver(paramIntent, 2120, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
            return;
            Object localObject3;
            if (paramFromServiceMsg.attributes != null)
            {
              getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
              localBundle.putString("uin", paramFromServiceMsg.getUin());
              localBundle.putString("alias", paramIntent.getStringExtra("userAccount"));
              localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
              localBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
              localBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
              localObject3 = paramFromServiceMsg.getAttribute("resp_login_url");
              localObject2 = "";
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if ((localObject3 instanceof String)) {
                  localObject1 = (String)localObject3;
                }
              }
              localObject2 = paramFromServiceMsg.getAttribute("resp_logini_ret");
              if ((localObject2 == null) || (!(localObject2 instanceof Integer))) {
                break label4621;
              }
            }
            for (i = ((Integer)localObject2).intValue();; i = 0)
            {
              localObject2 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
              if ((localObject2 != null) && ((localObject2 instanceof byte[]))) {}
              for (localObject2 = (byte[])localObject2;; localInteger = null)
              {
                localBundle.putString("errorurl", (String)localObject1);
                localBundle.putInt("loginret", i);
                localBundle.putInt("code", paramFromServiceMsg.getResultCode());
                localBundle.putByteArray("lhsig", (byte[])localObject2);
                String str;
                if (paramFromServiceMsg.isSuccess())
                {
                  if (!"com.tencent.tim:openSdk".equals(getAppRuntime().getApplication().getQQProcessName()))
                  {
                    MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), true, false);
                    if (!paramFromServiceMsg.getUin().equals(paramIntent.getStringExtra("userAccount"))) {
                      MsfSdkUtils.delSimpleAccount(paramIntent.getStringExtra("userAccount"));
                    }
                  }
                  localObject1 = paramIntent.getStringExtra("userAccount");
                  if (!TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
                    localObject2 = MsfSdkUtils.getLoginedAccountList();
                    if (localObject2 != null)
                    {
                      i = j;
                      if (i < ((List)localObject2).size())
                      {
                        localObject3 = (SimpleAccount)((List)localObject2).get(i);
                        if (localObject3 == null) {}
                        for (;;)
                        {
                          i += 1;
                          break;
                          localObject3 = ((SimpleAccount)localObject3).getUin();
                          str = getAppRuntime().getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3);
                          if ((!TextUtils.isEmpty(str)) && (str.equals(localObject1)) && (!((String)localObject3).equals(paramFromServiceMsg.getUin()))) {
                            getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3, (String)localObject3);
                          }
                        }
                      }
                    }
                  }
                }
                getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
                localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
                localBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
                i = paramFromServiceMsg.getResultCode();
                localObject1 = paramFromServiceMsg.attributes.get("ret");
                if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
                  i = ((Integer)localObject1).intValue();
                }
                long l1;
                long l2;
                for (;;)
                {
                  localBundle.putInt("ret", i);
                  notifyObserver(paramIntent, 2121, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
                  return;
                  long l3;
                  if (paramFromServiceMsg.attributes != null)
                  {
                    getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
                    if (paramFromServiceMsg.isSuccess())
                    {
                      MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), true, false);
                      if (!paramFromServiceMsg.getUin().equals(paramIntent.getStringExtra("userAccount"))) {
                        MsfSdkUtils.delSimpleAccount(paramIntent.getStringExtra("userAccount"));
                      }
                      localObject1 = paramIntent.getStringExtra("userAccount");
                      if (!TextUtils.isEmpty((CharSequence)localObject1))
                      {
                        getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
                        localObject2 = MsfSdkUtils.getLoginedAccountList();
                        if (localObject2 != null)
                        {
                          i = k;
                          if (i < ((List)localObject2).size())
                          {
                            localObject3 = (SimpleAccount)((List)localObject2).get(i);
                            if (localObject3 == null) {}
                            for (;;)
                            {
                              i += 1;
                              break;
                              localObject3 = ((SimpleAccount)localObject3).getUin();
                              str = getAppRuntime().getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3);
                              if ((!TextUtils.isEmpty(str)) && (str.equals(localObject1)) && (!((String)localObject3).equals(paramFromServiceMsg.getUin()))) {
                                getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3, (String)localObject3);
                              }
                            }
                          }
                        }
                      }
                    }
                    localObject1 = (String)paramFromServiceMsg.getAttribute("mainaccount");
                    localBundle.putString("submainaccount", (String)localObject1);
                    localObject2 = getAppRuntime().getApplication().getFirstSimpleAccount();
                    l3 = System.currentTimeMillis();
                    l1 = l3;
                    if (localObject2 != null) {
                      l2 = l3;
                    }
                  }
                  try
                  {
                    long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
                    l1 = l3;
                    if (l3 <= l4)
                    {
                      l3 = 1L + l4;
                      l1 = l3;
                      l2 = l3;
                      if (QLog.isColorLevel())
                      {
                        l2 = l3;
                        QLog.d("mqq", 2, "CNR account savetime => system time is error..");
                        l1 = l3;
                      }
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localException.printStackTrace();
                      l1 = l2;
                    }
                  }
                  if (paramFromServiceMsg.getUin() != null) {
                    getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
                  }
                  if (localObject1 != null) {
                    getAppRuntime().getApplication().setProperty((String)localObject1 + Constants.Key._logintime, String.valueOf(l1 + 1L));
                  }
                  getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
                  localBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
                  localBundle.putString("userAccount", paramFromServiceMsg.getUin());
                  i = paramFromServiceMsg.getResultCode();
                  localObject1 = paramFromServiceMsg.attributes.get("ret");
                  if ((localObject1 != null) && ((localObject1 instanceof Integer)))
                  {
                    i = ((Integer)localObject1).intValue();
                    localBundle.putInt("ret", i);
                    notifyObserver(paramIntent, 2122, paramFromServiceMsg.isSuccess(), localBundle, WtloginObserver.class);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void service(Intent paramIntent)
  {
    super.service(paramIntent);
    int i = paramIntent.getIntExtra("action", 0);
    Object localObject = MsfServiceSdk.get().getMsfServiceName();
    switch (i)
    {
    default: 
      return;
    case 2100: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetStWithPasswd((String)localObject, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("appid", 0L), paramIntent.getStringExtra("passwd"), 30000L));
      return;
    case 2101: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetStWithoutPasswd((String)localObject, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), 30000L));
      return;
    case 2208: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetOpenKeyWithoutPasswd((String)localObject, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), 30000L));
      return;
    case 2102: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckPictureAndGetSt((String)localObject, paramIntent.getStringExtra("uin"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2103: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshPictureData((String)localObject, paramIntent.getStringExtra("uin"), 30000L));
      return;
    case 2104: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_VerifyCode((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getBooleanExtra("close", false), paramIntent.getByteArrayExtra("code"), paramIntent.getIntArrayExtra("tlv"), paramIntent.getIntExtra("version", 0), 30000L));
      return;
    case 2105: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CloseCode((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getByteArrayExtra("code"), paramIntent.getIntExtra("version", 0), paramIntent.getStringArrayListExtra("data"), 30000L));
      return;
    case 2213: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CancelCode((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getByteArrayExtra("code"), 30000L));
      return;
    case 2106: 
      WFastLoginInfo localWFastLoginInfo = (WFastLoginInfo)((NewIntent)paramIntent).intentMap.get("fastLoginInfo");
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetA1WithA1((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwSubSrcAppid", 0L), paramIntent.getByteArrayExtra("dstAppName"), paramIntent.getLongExtra("dwDstSsoVer", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), paramIntent.getLongExtra("dwSubDstAppid", 0L), paramIntent.getByteArrayExtra("dstAppVer"), paramIntent.getByteArrayExtra("dstAppSign"), localWFastLoginInfo, 30000L));
      return;
    case 2108: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckDevLockStatus((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), 30000L));
      return;
    case 2109: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_AskDevLockSms((String)localObject, paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2110: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckDevLockSms((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), paramIntent.getStringExtra("smsCode"), paramIntent.getByteArrayExtra("sppKey"), 30000L));
      return;
    case 2111: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CloseDevLock((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), 30000L));
      return;
    case 2125: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_setRegDevLockFlag((String)localObject, paramIntent.getIntExtra("flag", 0), 30000L));
      return;
    case 2129: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_SetDevlockMobileType((String)localObject, paramIntent.getIntExtra("mobile_type", 0), 30000L));
      return;
    case 2112: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshSMSData((String)localObject, paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2113: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckSMSAndGetSt((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2114: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckSMSAndGetStExt((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2117: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RegGetSMSVerifyLoginAccount((String)localObject, paramIntent.getByteArrayExtra("msgchk"), paramIntent.getByteArrayExtra("nick"), paramIntent.getStringExtra("lhuin"), paramIntent.getStringExtra("unBindlhUin"), paramIntent.getStringExtra("appVersion"), 30000L));
      return;
    case 2118: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckSMSVerifyLoginAccount((String)localObject, paramIntent.getStringExtra("userAccount"), paramIntent.getStringExtra("countryCode"), paramIntent.getIntExtra("appid", 0), 30000L));
      return;
    case 2119: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshSMSVerifyLoginCode((String)localObject, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2120: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_VerifySMSVerifyLoginCode((String)localObject, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getStringExtra("code"), 30000L));
      return;
    case 2121: 
      localObject = MsfMsgUtil.get_wt_GetStViaSMSVerifyLogin((String)localObject, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getIntExtra("appid", 0), 30000L);
      ((ToServiceMsg)localObject).addAttribute("from_where", paramIntent.getStringExtra("from_where"));
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
      return;
    }
    sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetSubaccountStViaSMSVerifyLogin((String)localObject, paramIntent.getStringExtra("mainaccount"), paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getIntExtra("appid", 0), 30000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.WtloginServlet
 * JD-Core Version:    0.7.0.1
 */