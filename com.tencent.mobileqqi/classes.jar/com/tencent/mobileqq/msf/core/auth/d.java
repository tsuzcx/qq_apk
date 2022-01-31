package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class d
{
  public static final int a = 604800000;
  public static final int b = 21600000;
  public static final String d = "_new_version_never_change_token";
  public static boolean e = true;
  private static final String f = "MSF.C.TokenChecker";
  private static final String g = "_lastchecktokentime";
  private static final int h = 1800000;
  private static final int i = 1800000;
  private static long j = -1L;
  b c;
  
  public d(b paramb)
  {
    this.c = paramb;
    if (TextUtils.isEmpty(k.a().getConfig("_new_version_never_change_token"))) {}
    for (e = false;; e = true)
    {
      if (!e) {
        k.a().n_setConfig("_lastchecktokentime", String.valueOf(0));
      }
      return;
    }
  }
  
  private long a(String paramString)
  {
    long l1 = this.c.a.getWtLoginCenter().a(paramString, 64);
    long l2 = this.c.a.getWtLoginCenter().a(paramString, 262144);
    if (l1 > l2) {
      return l2;
    }
    return l1;
  }
  
  private long b(String paramString)
  {
    long l1 = this.c.a.getWtLoginCenter().a(paramString, 4096);
    long l4 = this.c.a.getWtLoginCenter().a(paramString, 524288);
    long l3 = this.c.a.getWtLoginCenter().a(paramString, 131072);
    long l2 = this.c.a.getWtLoginCenter().a(paramString, 32);
    long l5 = this.c.a.getWtLoginCenter().a(paramString, 1048576);
    if (l1 > l4)
    {
      l1 = l4;
      if (l1 <= l3) {
        break label133;
      }
      l1 = l3;
      label110:
      if (l1 <= l2) {
        break label136;
      }
      l1 = l2;
    }
    label133:
    label136:
    for (;;)
    {
      if (l1 <= l5) {
        return l1;
      }
      return l5;
      break;
      break label110;
    }
    return l1;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (j == -1L)
    {
      str = k.a().getConfig("_lastchecktokentime");
      if (str != null) {}
    }
    while ((l < j) || (l - j >= 1800000L))
    {
      do
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.TokenChecker", 2, "doCheck, lastCheckTime=" + j + ", now=" + l);
        }
        j = l;
        k.a().n_setConfig("_lastchecktokentime", String.valueOf(l));
        b();
        return;
        j = Long.parseLong(str);
      } while (l - j >= 1800000L);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = paramFromServiceMsg.getUin();
              paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
              if (paramFromServiceMsg.isSuccess()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("MSF.C.TokenChecker", 2, "onChangeTokenResult fail, uin=" + str + ", errorcode=" + paramFromServiceMsg.getBusinessFailCode());
            return;
            if (!paramToServiceMsg.equals("login.chgTok_A2D2")) {
              break;
            }
            paramToServiceMsg = (RespondCustomSig)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
          } while (paramToServiceMsg == null);
          Iterator localIterator = paramToServiceMsg.SigList.iterator();
          paramFromServiceMsg = null;
          CustomSigContent localCustomSigContent = null;
          paramToServiceMsg = (ToServiceMsg)localObject;
          localObject = localCustomSigContent;
          while (localIterator.hasNext())
          {
            localCustomSigContent = (CustomSigContent)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "onChangeTokenResult, content.ulSigType=" + localCustomSigContent.ulSigType + ", uin=" + str);
            }
            if (localCustomSigContent.ulSigType == 0L) {
              localObject = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 18L) {
              paramFromServiceMsg = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 20L) {
              paramToServiceMsg = localCustomSigContent.SigContent;
            }
          }
        } while ((localObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null));
        l = System.currentTimeMillis();
      } while (l - this.c.n(str).A() <= 1800000L);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 succ, uin=" + str);
      }
      this.c.a(str, (byte[])localObject, paramFromServiceMsg, paramToServiceMsg, l);
      this.c.q(str);
      return;
    } while ((!paramToServiceMsg.equals("login.chgTok_WEBVIEW_KEY")) || (!QLog.isColorLevel()));
    QLog.d("MSF.C.TokenChecker", 2, "renew webview key succ for " + str);
  }
  
  public void b()
  {
    new e(this, "threadCheckToken").start();
  }
  
  void c()
  {
    long l3 = System.currentTimeMillis();
    Iterator localIterator = this.c.d().iterator();
    while (localIterator.hasNext())
    {
      String str = ((SimpleAccount)localIterator.next()).getUin();
      if (this.c.i(str))
      {
        long l4 = a(str);
        long l2 = com.tencent.mobileqq.msf.core.a.a.t();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 604800000L;
        }
        Object localObject;
        if (l3 - l4 > l1)
        {
          localObject = new ToServiceMsg("", str, "login.chgTok_A2D2");
          ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
          ((ToServiceMsg)localObject).getAttributes().put("to_login_token_cmdhead", Integer.valueOf(9));
          ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
          ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
          ((ToServiceMsg)localObject).setAppId(this.c.a.getMsfAppid());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          HashMap localHashMap = new HashMap();
          RequestCustomSig localRequestCustomSig = new RequestCustomSig();
          localRequestCustomSig.ulCustumFlag = 1970272L;
          localRequestCustomSig.reserved = new byte[0];
          localHashMap.put("RequestCustomSig", localRequestCustomSig);
          ((ToServiceMsg)localObject).getAttributes().put("to_login_token_map", localHashMap);
          this.c.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 for " + str);
          }
        }
        l4 = b(str);
        l2 = com.tencent.mobileqq.msf.core.a.a.u();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 21600000L;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("MainService onTicketChanged, now: ").append(l3).append(" lastCheckWebviewKeyTime: ").append(l4).append(" interval: ").append(l3 - l4).append(" needChangeToken: ");
          if (l3 - l4 <= l1) {
            break label527;
          }
        }
        label527:
        for (boolean bool = true;; bool = false)
        {
          QLog.d("MSF.C.TokenChecker", 2, bool);
          if ((e) && (l3 - l4 <= l1)) {
            break;
          }
          localObject = new ToServiceMsg("", str, "login.chgTok_WEBVIEW_KEY");
          ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
          ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
          ((ToServiceMsg)localObject).setAppId(this.c.a.getMsfAppid());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
          this.c.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.TokenChecker", 2, "renew webview key for " + str);
          break;
        }
      }
    }
    e = true;
    k.a().n_setConfig("_new_version_never_change_token", String.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.d
 * JD-Core Version:    0.7.0.1
 */