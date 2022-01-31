package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

public class h
{
  static final String a = "MSF.C.WTLoginCenter";
  public static final long b = 16L;
  public static final String[] c = { "game.qq.com" };
  public static MsfCore d;
  public static WtloginHelper e;
  public static final byte f = 1;
  private static final String g = "_wtlastchecklocaltokentime_";
  private static final int h = 43200000;
  private static final long i = 9L;
  private static final long j = 8L;
  private final int k = 100;
  
  private int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        k localk = i.a(d, paramToServiceMsg);
        int n = 0;
        long l1 = 16L;
        long l2 = paramToServiceMsg.getAppId();
        if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_A2D2"))
        {
          n = 262208;
          m = 1;
          if ((!com.tencent.mobileqq.msf.core.a.a.f()) || (m == 0)) {
            continue;
          }
          localk.a = true;
          e.SetTimeOut((int)paramToServiceMsg.getTimeout());
          i.a(paramToServiceMsg);
          if ((0x100000 & n) == 1048576)
          {
            localObject = i.c(paramToServiceMsg.getRequestSsoSeq());
            if (paramBoolean1) {
              continue;
            }
            parama = new byte[1][];
            parama[0] = new byte[1];
            parama[0][0] = 1;
            m = e.GetStWithoutPasswd(paramToServiceMsg.getUin(), 16L, l1, -1L, n, l2, new long[0], (WUserSigInfo)localObject, new byte[0][], parama);
            a(paramToServiceMsg, localk, m, "sendChangeTokenMsg");
            return m;
          }
        }
        else
        {
          if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY"))
          {
            n = 1708064;
            m = 1;
            continue;
          }
          localObject = (HashMap)paramToServiceMsg.getAttributes().get("to_login_token_map");
          if ((((RequestCustomSig)((HashMap)localObject).get("RequestCustomSig")).ulCustumFlag & 0x2000) != 8192L) {
            break label356;
          }
          n = 16384;
          l1 = 715019303L;
          l2 = Long.parseLong((String)((HashMap)localObject).get("OpenAppid"));
          m = 1;
          continue;
        }
        Object localObject = i.b(paramToServiceMsg.getRequestSsoSeq());
        continue;
        if (parama == null)
        {
          QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error account is null.");
          return -1;
        }
        m = e.GetStWithoutPasswd(parama.d(), 16L, 16L, paramToServiceMsg.getAppId(), n, parama.f(), parama.i(), parama.k(), (WUserSigInfo)localObject);
        continue;
        return 1;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error " + paramToServiceMsg.toString(), paramToServiceMsg);
        return 0;
      }
      label356:
      int m = 0;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, k paramk, int paramInt, String paramString)
  {
    if (paramInt != -1001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter", 2, "call " + paramString + " ret  " + paramInt);
      }
      paramk.a(paramString, 0, i.b(paramToServiceMsg.getRequestSsoSeq()));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.j.a(paramToServiceMsg);
    d.getAccountCenter().m(localFromServiceMsg.getUin());
    localFromServiceMsg.setBusinessFail(2001, localFromServiceMsg.getBusinessFailMsg());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    d.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
    QLog.d("MSF.C.WTLoginCenter", 1, "found accountToken " + localFromServiceMsg.getUin() + " is expired on call " + paramString);
  }
  
  static void a(String paramString)
  {
    QLog.d("MSF.C.WTLoginCenter", 2, "updateCheckTime " + paramString);
    long l = System.currentTimeMillis();
    com.tencent.mobileqq.msf.core.k.a().setConfig("_wtlastchecklocaltokentime_" + paramString, String.valueOf(l));
  }
  
  public static byte[] a()
  {
    return e.GetGuid();
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int n;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (c != null)
      {
        bool1 = bool2;
        if (c.length > 0)
        {
          arrayOfString = c;
          n = arrayOfString.length;
          m = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (m < n)
      {
        if (paramString.equals(arrayOfString[m])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
  
  private boolean d(String paramString)
  {
    long l1;
    if (com.tencent.mobileqq.msf.core.a.a.f())
    {
      l1 = System.currentTimeMillis();
      paramString = com.tencent.mobileqq.msf.core.k.a().getConfig("_wtlastchecklocaltokentime_" + paramString);
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    long l2;
    do
    {
      return false;
      l2 = Long.parseLong(paramString);
    } while ((l1 <= l2) || (l1 - l2 > 43200000L));
    return true;
  }
  
  public void A(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    String str3 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str2 = (String)paramToServiceMsg.getAttribute("userAccount");
    String str1 = str2;
    if (!str3.startsWith("86")) {
      str1 = "00" + str3 + str2;
    }
    a(paramToServiceMsg, localk, e.VerifySMSVerifyLoginCode(str1, (String)paramToServiceMsg.getAttribute("code"), localWUserSigInfo), "wt_VerifySMSVerifyLoginCode");
  }
  
  public void B(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    long l = paramToServiceMsg.getAppId();
    Object localObject = (String)paramToServiceMsg.getAttribute("from_where", null);
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("ssoAccountAction")))
    {
      localWUserSigInfo._login_bitmap = 2;
      l = 2L;
    }
    for (;;)
    {
      String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
      String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
      localObject = str1;
      if (!str2.startsWith("86")) {
        localObject = "00" + str2 + str1;
      }
      a(paramToServiceMsg, localk, e.GetStViaSMSVerifyLogin((String)localObject, 16L, l, 1970272, localWUserSigInfo), "wt_GetStViaSMSVerifyLogin");
      return;
      localWUserSigInfo._login_bitmap = 0;
    }
  }
  
  public int a(a parama, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (d(parama.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, parama.d() + " setKeyToWtlogin not reach time limit, return ...");
        }
      }
      else
      {
        byte[] arrayOfByte = parama.k();
        int m = MsfCore.getNextSeq();
        ToServiceMsg localToServiceMsg = new ToServiceMsg("", parama.d(), "login.getSid");
        localToServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
        localToServiceMsg.setRequestSsoSeq(m);
        localToServiceMsg.setAppId(100);
        localToServiceMsg.setTimeout(30000L);
        k localk = i.a(d, localToServiceMsg);
        localk.b = false;
        i.a(localToServiceMsg);
        localk.a = true;
        m = e.GetStWithoutPasswd(parama.d(), 16L, 16L, localToServiceMsg.getAppId(), paramInt, parama.f(), parama.i(), arrayOfByte, i.b(m));
        a(localToServiceMsg, localk, m, "setWt");
        paramInt = m;
        if (!QLog.isColorLevel()) {
          return paramInt;
        }
        QLog.d("MSF.C.WTLoginCenter", 2, "call setWt for " + parama.d());
        return m;
      }
    }
    catch (Exception parama)
    {
      QLog.d("MSF.C.WTLoginCenter", 1, "call setWt error " + parama, parama);
      return -1;
    }
    paramInt = 1;
    return paramInt;
  }
  
  public int a(a parama, boolean paramBoolean)
  {
    return a(parama, 1970272, paramBoolean);
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RefreshPictureData(paramToServiceMsg.getUin(), localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "sendChangeUinMsg");
    return m;
  }
  
  int a(ToServiceMsg paramToServiceMsg, WtloginHelper paramWtloginHelper)
  {
    if (!paramWtloginHelper.IsNeedLoginWithPasswd(paramToServiceMsg.getUin(), 16L).booleanValue()) {
      return 1;
    }
    paramWtloginHelper = d.getAccountCenter().n(paramToServiceMsg.getUin());
    if ((paramWtloginHelper != null) && (paramWtloginHelper.o())) {
      return 0;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "checkIsNeedLoginWithPasswd " + MD5.toMD5(paramToServiceMsg.getUin()) + " IsNeedLoginWithPasswd");
    paramWtloginHelper = com.tencent.mobileqq.msf.core.j.a(paramToServiceMsg);
    paramWtloginHelper.setBusinessFail(2001, paramToServiceMsg.getUin() + " not login");
    MsfSdkUtils.addFromMsgProcessName("*", paramWtloginHelper);
    d.addRespToQuque(paramToServiceMsg, paramWtloginHelper);
    return -1;
  }
  
  public int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    Object localObject1 = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    try
    {
      localObject1 = new String((byte[])localObject1, "ISO-8859-1");
      if (paramBoolean)
      {
        localObject2 = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
        localObject3 = paramToServiceMsg.getUin();
        paramToServiceMsg.setUin((String)localObject2);
        paramToServiceMsg.addAttribute("to_login_changeuin", localObject3);
      }
      Object localObject2 = i.a(d, paramToServiceMsg);
      ((k)localObject2).a = true;
      i.a(paramToServiceMsg);
      localObject3 = i.c(paramToServiceMsg.getRequestSsoSeq());
      String str2 = (String)paramToServiceMsg.getAttribute("from_where", null);
      long l = paramToServiceMsg.getAppId();
      if ((str2 != null) && (str2.equalsIgnoreCase("ssoAccountAction")))
      {
        ((WUserSigInfo)localObject3)._login_bitmap = 2;
        l = 2L;
        int m = e.GetStWithPasswdMd5(paramToServiceMsg.getUin(), 16L, l, 1970272, (String)localObject1, (WUserSigInfo)localObject3);
        a(paramToServiceMsg, (k)localObject2, m, "sendChangeUinMsg");
        return m;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject3;
        localUnsupportedEncodingException.printStackTrace();
        String str1 = "";
        continue;
        ((WUserSigInfo)localObject3)._login_bitmap = 0;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    paramString = e.GetLocalTicket(paramString, 16L, paramInt);
    if (paramString == null) {
      return 0L;
    }
    return paramString._create_time * 1000L;
  }
  
  public void a(MsfCore paramMsfCore)
  {
    d = paramMsfCore;
    oicq.wlogin_sdk.tools.util.LOGCAT_OUT = false;
    e = new WtloginHelper(BaseApplication.getContext());
    e.SetTimeOut(40000);
    WtloginHelper.setProductType(15);
    e.SetMsfTransportFlag(1);
    paramMsfCore = new j(paramMsfCore);
    e.SetListener(paramMsfCore);
    com.tencent.mobileqq.msf.core.NetConnInfoCenter.GUID = e.GetGuid();
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("to_verify_code");
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.CheckPictureAndGetSt(paramToServiceMsg.getUin(), str.getBytes(), localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "sendChangeUinMsg");
    return m;
  }
  
  public int b(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    try
    {
      i.a(d, paramToServiceMsg);
      m = a(paramToServiceMsg, e);
      QLog.d("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin checkIsNeedLoginWithPasswd " + m + " process:" + com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg) + " cmd:" + paramToServiceMsg.getServiceCmd());
      switch (m)
      {
      case -1: 
        a(paramToServiceMsg, "changeTokenAfterLogin");
        return -1;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      int m;
      QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error " + paramToServiceMsg.toString(), paramToServiceMsg);
      return 0;
    }
    return a(paramToServiceMsg, true, d.getAccountCenter().n(paramToServiceMsg.getUin()), paramBoolean);
    m = a(paramToServiceMsg, false, null, paramBoolean);
    return m;
    return 0;
  }
  
  public int c(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("to_register_cr_mobile");
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WTLoginCenter.RegQueryAccount");
    }
    int m = e.RegQueryAccount(1, str.getBytes(), 16L, localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegQueryAccount");
    return m;
  }
  
  /* Error */
  public HashMap c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 8
    //   6: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   9: aload_1
    //   10: ldc2_w 11
    //   13: bipush 64
    //   15: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +657 -> 677
    //   23: aload_2
    //   24: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +648 -> 677
    //   32: aload_2
    //   33: invokestatic 557	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   36: astore_2
    //   37: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   40: aload_1
    //   41: ldc2_w 11
    //   44: ldc_w 558
    //   47: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +620 -> 672
    //   55: aload_3
    //   56: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +611 -> 672
    //   64: new 38	java/lang/String
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 561	java/lang/String:<init>	([B)V
    //   72: astore_3
    //   73: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   76: aload_1
    //   77: ldc2_w 11
    //   80: ldc_w 562
    //   83: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull +576 -> 666
    //   93: aload 4
    //   95: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +564 -> 666
    //   105: new 38	java/lang/String
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 561	java/lang/String:<init>	([B)V
    //   114: astore 4
    //   116: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   119: aload_1
    //   120: ldc2_w 11
    //   123: sipush 4096
    //   126: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnull +527 -> 660
    //   136: aload 5
    //   138: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   141: astore 5
    //   143: aload 5
    //   145: ifnull +515 -> 660
    //   148: new 38	java/lang/String
    //   151: dup
    //   152: aload 5
    //   154: invokespecial 561	java/lang/String:<init>	([B)V
    //   157: astore 5
    //   159: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   162: aload_1
    //   163: ldc2_w 11
    //   166: bipush 32
    //   168: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   171: astore 6
    //   173: aload 6
    //   175: ifnull +479 -> 654
    //   178: aload 6
    //   180: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   183: astore 6
    //   185: aload 6
    //   187: ifnull +467 -> 654
    //   190: aload 6
    //   192: invokestatic 557	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   195: astore 6
    //   197: getstatic 87	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   200: aload_1
    //   201: ldc2_w 11
    //   204: ldc 101
    //   206: invokevirtual 466	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   209: astore 9
    //   211: aload 9
    //   213: ifnull +435 -> 648
    //   216: aload 9
    //   218: getfield 551	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   221: astore 7
    //   223: aload 7
    //   225: ifnull +417 -> 642
    //   228: new 38	java/lang/String
    //   231: dup
    //   232: aload 7
    //   234: invokespecial 561	java/lang/String:<init>	([B)V
    //   237: astore 7
    //   239: aload 9
    //   241: getfield 566	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   244: ifnull +395 -> 639
    //   247: aload 9
    //   249: getfield 566	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   252: ldc 40
    //   254: invokeinterface 571 2 0
    //   259: ifeq +380 -> 639
    //   262: new 38	java/lang/String
    //   265: dup
    //   266: aload 9
    //   268: getfield 566	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
    //   271: ldc 40
    //   273: invokeinterface 572 2 0
    //   278: checkcast 109	[B
    //   281: invokespecial 561	java/lang/String:<init>	([B)V
    //   284: astore 8
    //   286: aload 5
    //   288: astore 11
    //   290: aload_2
    //   291: astore 10
    //   293: aload_3
    //   294: astore 9
    //   296: aload 4
    //   298: astore 5
    //   300: aload 11
    //   302: astore 4
    //   304: aload 6
    //   306: astore_3
    //   307: aload 7
    //   309: astore_2
    //   310: new 134	java/util/HashMap
    //   313: dup
    //   314: invokespecial 573	java/util/HashMap:<init>	()V
    //   317: astore 6
    //   319: aload 6
    //   321: ldc_w 575
    //   324: aload_1
    //   325: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: aload 6
    //   331: ldc_w 581
    //   334: aload 10
    //   336: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload 6
    //   342: ldc_w 583
    //   345: aload 9
    //   347: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: aload 6
    //   353: ldc_w 585
    //   356: aload 5
    //   358: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: aload 6
    //   364: ldc_w 587
    //   367: aload 4
    //   369: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload 6
    //   375: ldc_w 589
    //   378: aload 8
    //   380: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload 6
    //   386: ldc_w 591
    //   389: aload_3
    //   390: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 593
    //   399: aload_2
    //   400: invokevirtual 579	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: pop
    //   404: aload 6
    //   406: areturn
    //   407: astore 8
    //   409: aconst_null
    //   410: astore_3
    //   411: aconst_null
    //   412: astore 4
    //   414: aconst_null
    //   415: astore 5
    //   417: aconst_null
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 7
    //   423: aconst_null
    //   424: astore_2
    //   425: aload 8
    //   427: invokevirtual 594	java/lang/Exception:printStackTrace	()V
    //   430: aload 11
    //   432: astore 8
    //   434: aload 6
    //   436: astore 9
    //   438: aload 7
    //   440: astore 10
    //   442: goto -132 -> 310
    //   445: astore 8
    //   447: aconst_null
    //   448: astore_3
    //   449: aconst_null
    //   450: astore 4
    //   452: aconst_null
    //   453: astore 5
    //   455: aconst_null
    //   456: astore 6
    //   458: aload_2
    //   459: astore 7
    //   461: aconst_null
    //   462: astore_2
    //   463: goto -38 -> 425
    //   466: astore 8
    //   468: aconst_null
    //   469: astore 9
    //   471: aconst_null
    //   472: astore 4
    //   474: aconst_null
    //   475: astore 5
    //   477: aload_3
    //   478: astore 6
    //   480: aload_2
    //   481: astore 7
    //   483: aconst_null
    //   484: astore_2
    //   485: aload 9
    //   487: astore_3
    //   488: goto -63 -> 425
    //   491: astore 8
    //   493: aconst_null
    //   494: astore 10
    //   496: aconst_null
    //   497: astore 9
    //   499: aload 4
    //   501: astore 5
    //   503: aload_3
    //   504: astore 6
    //   506: aload_2
    //   507: astore 7
    //   509: aconst_null
    //   510: astore_2
    //   511: aload 10
    //   513: astore_3
    //   514: aload 9
    //   516: astore 4
    //   518: goto -93 -> 425
    //   521: astore 9
    //   523: aconst_null
    //   524: astore 10
    //   526: aload 4
    //   528: astore 6
    //   530: aload_3
    //   531: astore 7
    //   533: aload_2
    //   534: astore 8
    //   536: aconst_null
    //   537: astore_2
    //   538: aload 10
    //   540: astore_3
    //   541: aload 5
    //   543: astore 4
    //   545: aload 6
    //   547: astore 5
    //   549: aload 7
    //   551: astore 6
    //   553: aload 8
    //   555: astore 7
    //   557: aload 9
    //   559: astore 8
    //   561: goto -136 -> 425
    //   564: astore 8
    //   566: aload 4
    //   568: astore 7
    //   570: aload_3
    //   571: astore 9
    //   573: aload_2
    //   574: astore 10
    //   576: aconst_null
    //   577: astore_2
    //   578: aload 6
    //   580: astore_3
    //   581: aload 5
    //   583: astore 4
    //   585: aload 7
    //   587: astore 5
    //   589: aload 9
    //   591: astore 6
    //   593: aload 10
    //   595: astore 7
    //   597: goto -172 -> 425
    //   600: astore 8
    //   602: aload_3
    //   603: astore 9
    //   605: aload 7
    //   607: astore_3
    //   608: aload 6
    //   610: astore 10
    //   612: aload 4
    //   614: astore 6
    //   616: aload_2
    //   617: astore 7
    //   619: aload_3
    //   620: astore_2
    //   621: aload 10
    //   623: astore_3
    //   624: aload 5
    //   626: astore 4
    //   628: aload 6
    //   630: astore 5
    //   632: aload 9
    //   634: astore 6
    //   636: goto -211 -> 425
    //   639: goto -353 -> 286
    //   642: aconst_null
    //   643: astore 7
    //   645: goto -406 -> 239
    //   648: aconst_null
    //   649: astore 7
    //   651: goto -365 -> 286
    //   654: aconst_null
    //   655: astore 6
    //   657: goto -460 -> 197
    //   660: aconst_null
    //   661: astore 5
    //   663: goto -504 -> 159
    //   666: aconst_null
    //   667: astore 4
    //   669: goto -553 -> 116
    //   672: aconst_null
    //   673: astore_3
    //   674: goto -601 -> 73
    //   677: aconst_null
    //   678: astore_2
    //   679: goto -642 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	h
    //   0	682	1	paramString	String
    //   18	661	2	localObject1	Object
    //   50	624	3	localObject2	Object
    //   86	582	4	localObject3	Object
    //   129	533	5	localObject4	Object
    //   171	485	6	localObject5	Object
    //   221	429	7	localObject6	Object
    //   4	375	8	str	String
    //   407	19	8	localException1	Exception
    //   432	1	8	localObject7	Object
    //   445	1	8	localException2	Exception
    //   466	1	8	localException3	Exception
    //   491	1	8	localException4	Exception
    //   534	26	8	localObject8	Object
    //   564	1	8	localException5	Exception
    //   600	1	8	localException6	Exception
    //   209	306	9	localObject9	Object
    //   521	37	9	localException7	Exception
    //   571	62	9	localObject10	Object
    //   291	331	10	localObject11	Object
    //   1	430	11	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   6	19	407	java/lang/Exception
    //   23	28	407	java/lang/Exception
    //   32	37	407	java/lang/Exception
    //   37	51	445	java/lang/Exception
    //   55	60	445	java/lang/Exception
    //   64	73	445	java/lang/Exception
    //   73	88	466	java/lang/Exception
    //   93	100	466	java/lang/Exception
    //   105	116	466	java/lang/Exception
    //   116	131	491	java/lang/Exception
    //   136	143	491	java/lang/Exception
    //   148	159	491	java/lang/Exception
    //   159	173	521	java/lang/Exception
    //   178	185	521	java/lang/Exception
    //   190	197	521	java/lang/Exception
    //   197	211	564	java/lang/Exception
    //   216	223	564	java/lang/Exception
    //   228	239	564	java/lang/Exception
    //   239	286	600	java/lang/Exception
  }
  
  public int d(ToServiceMsg paramToServiceMsg)
  {
    Byte localByte1 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_country");
    Byte localByte2 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_language");
    Byte localByte3 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_pigType");
    String str1 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appName");
    String str2 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    String str3 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_mobile");
    long l = ((Long)paramToServiceMsg.getAttributes().get("appid")).longValue();
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RegSubmitMobile(str3.getBytes(), str1.getBytes(), str2.getBytes(), localByte1.byteValue(), localByte2.byteValue(), localByte3.byteValue(), 16L, l, localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegSubmitMobile");
    return m;
  }
  
  public int e(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RegRequestServerResendMsg(localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegRequestServerResendMsg");
    return m;
  }
  
  public int f(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("To_register_smsCode");
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RegSubmitMsgChk(str.getBytes(), localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegSubmitMsgChk");
    return m;
  }
  
  public int g(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RegQueryClientSendedMsgStatus(localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegQueryClientSendedMsgStatus");
    return m;
  }
  
  public int h(ToServiceMsg paramToServiceMsg)
  {
    String str1 = (String)paramToServiceMsg.getAttributes().get("To_register_smsCode");
    String str2 = (String)paramToServiceMsg.getAttributes().get("To_register_pass");
    String str3 = (String)paramToServiceMsg.getAttributes().get("To_register_nick");
    k localk = i.a(d, paramToServiceMsg);
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    int m = e.RegGetAccount(str1.getBytes(), "qqpassport".getBytes(), str2.getBytes(), str3.getBytes(), 1, localWUserSigInfo);
    a(paramToServiceMsg, localk, m, "RegGetAccount");
    return m;
  }
  
  public void i(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.GetStWithPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), (String)paramToServiceMsg.getAttribute("passwd"), localWUserSigInfo), "wt_GetStWithPasswd");
  }
  
  public void j(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    String str = (String)paramToServiceMsg.getAttribute("from_where", null);
    long l2 = paramToServiceMsg.getAppId();
    long l1 = l2;
    if (str != null)
    {
      l1 = l2;
      if (str.equalsIgnoreCase("ssoAccountAction"))
      {
        l2 = 2L;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("wtlogin_center", 2, "wt_GetStWithoutPasswd localappid = 2");
          l1 = l2;
        }
      }
    }
    a(paramToServiceMsg, localk, e.GetStWithoutPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), l1, 1970272, localWUserSigInfo), "wt_GetStWithoutPasswd");
  }
  
  public void k(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CheckPictureAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo), "wt_CheckPictureAndGetSt");
  }
  
  public void l(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.RefreshPictureData(paramToServiceMsg.getUin(), localWUserSigInfo), "wt_RefreshPictureData");
  }
  
  public void m(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.VerifyCode(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), ((Boolean)paramToServiceMsg.getAttribute("close")).booleanValue(), (byte[])paramToServiceMsg.getAttribute("code"), (int[])paramToServiceMsg.getAttribute("tlv"), ((Integer)paramToServiceMsg.getAttribute("version")).intValue(), localWUserSigInfo), "wt_VerifyCode");
  }
  
  public void n(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    Object localObject = (ArrayList)paramToServiceMsg.getAttribute("data");
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(HexUtil.hexStr2Bytes((String)((Iterator)localObject).next()));
    }
    a(paramToServiceMsg, localk, e.CloseCode(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), (byte[])paramToServiceMsg.getAttribute("code"), ((Integer)paramToServiceMsg.getAttribute("version")).intValue(), localArrayList, localWUserSigInfo), "wt_CloseCode");
  }
  
  public void o(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.GetA1WithA1(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwSubSrcAppid")).longValue(), (byte[])paramToServiceMsg.getAttribute("dstAppName"), ((Long)paramToServiceMsg.getAttribute("dwDstSsoVer")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwSubDstAppid")).longValue(), (byte[])paramToServiceMsg.getAttribute("dstAppVer"), (byte[])paramToServiceMsg.getAttribute("dstAppSign"), localWUserSigInfo, (WFastLoginInfo)paramToServiceMsg.getAttribute("fastLoginInfo")), "wt_GetA1WithA1");
  }
  
  public void p(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CheckDevLockStatus(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), localWUserSigInfo), "wt_CheckDevLockStatus");
  }
  
  public void q(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.AskDevLockSms(paramToServiceMsg.getUin(), 16L, 8L, localWUserSigInfo), "wt_AskDevLockSms");
  }
  
  public void r(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CheckDevLockSms(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), (String)paramToServiceMsg.getAttribute("smdCode"), (byte[])paramToServiceMsg.getAttribute("sppKey"), localWUserSigInfo), "wt_CheckDevLockSms");
  }
  
  public void s(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CloseDevLock(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), localWUserSigInfo), "wt_CloseDevLock");
  }
  
  public void t(ToServiceMsg paramToServiceMsg)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("flag")).intValue();
    e.SetRegDevLockFlag(m);
  }
  
  public void u(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.RefreshSMSData(paramToServiceMsg.getUin(), 9L, localWUserSigInfo), "wt_RefreshSMSData");
  }
  
  public void v(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo), "wt_CheckSMSAndGetSt");
  }
  
  public void w(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo, (byte[][])null), "wt_CheckSMSAndGetSt");
  }
  
  public void x(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    a(paramToServiceMsg, localk, e.RegGetSMSVerifyLoginAccount((byte[])paramToServiceMsg.getAttribute("msgchk"), "qqpassport".getBytes(), (byte[])paramToServiceMsg.getAttribute("nick"), localWUserSigInfo), "wt_RegGetSMSVerifyLoginAccount");
  }
  
  public void y(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
    if (!str2.startsWith("86")) {
      str1 = "00" + str2 + str1;
    }
    for (;;)
    {
      a(paramToServiceMsg, localk, e.CheckSMSVerifyLoginAccount(16L, paramToServiceMsg.getAppId(), str1, localWUserSigInfo), "wt_CheckSMSVerifyLoginAccount");
      return;
    }
  }
  
  public void z(ToServiceMsg paramToServiceMsg)
  {
    k localk = i.a(d, paramToServiceMsg);
    localk.g = true;
    i.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = i.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localk.f;
    String str3 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str2 = (String)paramToServiceMsg.getAttribute("userAccount");
    String str1 = str2;
    if (!str3.startsWith("86")) {
      str1 = "00" + str3 + str2;
    }
    a(paramToServiceMsg, localk, e.RefreshSMSVerifyLoginCode(str1, localWUserSigInfo), "wt_RefreshSMSVerifyLoginCode");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.h
 * JD-Core Version:    0.7.0.1
 */