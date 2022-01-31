package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.e;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class b
{
  public static final String d = "grayCheck";
  private static final String i = "QQ";
  private static final String j = "MSF.C.AccountCenter";
  private static final String k = "key_account_head_";
  private static final String l = "__loginSdk_uinMapping";
  MsfCore a;
  ConcurrentHashMap b = new ConcurrentHashMap();
  public c c;
  public f e;
  public g f;
  public d g;
  int h = 0;
  private ConcurrentHashMap m = new ConcurrentHashMap();
  private ConcurrentHashMap n = new ConcurrentHashMap();
  private String o = "0";
  private String p = "key_main_account";
  
  public b(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
    paramMsfCore = MsfStore.getNativeConfigStore().getConfig(this.p);
    if (!TextUtils.isEmpty(paramMsfCore)) {
      this.o = paramMsfCore;
    }
    this.e = new f(this);
    this.f = new g(this);
    this.g = new d(this);
    this.c = new c(this);
  }
  
  private long a(String paramString, int paramInt)
  {
    paramString = h.e.GetLocalTicket(paramString, 16L, paramInt);
    if (paramString != null)
    {
      long l1 = paramString._create_time * 1000L;
      if (l1 > 0L) {
        return l1;
      }
    }
    if ((paramInt == 64) || (paramInt == 262144) || (paramInt == 524288)) {
      return System.currentTimeMillis() - 604800000L;
    }
    return System.currentTimeMillis() - 21600000L;
  }
  
  private void a(ArrayList paramArrayList)
  {
    b(paramArrayList);
    if (paramArrayList.size() == 0)
    {
      String[] arrayOfString = MsfStore.getNativeConfigStore().n_getConfigList("key_account_head_");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        QLog.d("MSF.C.AccountCenter", 1, "try load accounts " + arrayOfString.length);
        int i2 = arrayOfString.length;
        int i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            Object localObject = arrayOfString[i1];
            try
            {
              localObject = a.c((String)localObject);
              ((a)localObject).d("QQ");
              paramArrayList.add(localObject);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.AccountCenter", 2, "load account " + ((a)localObject).d() + " logined:" + ((a)localObject).o());
              }
              i1 += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.w("MSF.C.AccountCenter", 1, "parse account error " + localThrowable.toString(), localThrowable);
              }
            }
          }
        }
      }
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    Iterator localIterator = h.e.GetAllLoginInfo().iterator();
    while (localIterator.hasNext())
    {
      WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
      String str;
      Object localObject;
      byte[] arrayOfByte2;
      byte[] arrayOfByte3;
      byte[] arrayOfByte1;
      try
      {
        str = String.valueOf(localWloginLoginInfo.mUin);
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.AccountCenter", 4, "loadAccountInfoFromWt uin: " + str);
        }
        if (h.e.IsNeedLoginWithPasswd(str, 16L).booleanValue()) {
          continue;
        }
        localObject = h.e.GetLocalSig(str, 16L);
        arrayOfByte2 = WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 64);
        arrayOfByte3 = WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 262144);
        arrayOfByte1 = WtloginHelper.GetTicketSigKey((WUserSigInfo)localObject, 262144);
        if ((localObject != null) && (arrayOfByte2 != null) && (arrayOfByte2.length != 0) && (arrayOfByte3 != null) && (arrayOfByte3.length != 0) && (arrayOfByte1 != null) && (arrayOfByte1.length != 0)) {
          break label251;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("MSF.C.AccountCenter", 2, "load account from wt failed, because of invalid token " + str);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel())
      {
        QLog.w("MSF.C.AccountCenter", 2, "parse account from wt error " + localThrowable.toString(), localThrowable);
        continue;
        label251:
        a locala = new a(str);
        locala.e(arrayOfByte2);
        locala.h(arrayOfByte3);
        arrayOfByte2 = new byte[16];
        f.a(arrayOfByte2, 0, arrayOfByte1, arrayOfByte1.length);
        locala.j(arrayOfByte2);
        locala.a(WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 131072));
        locala.b(WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 4096));
        locala.c(WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 32));
        locala.b(new String(WtloginHelper.GetTicketSig((WUserSigInfo)localObject, 524288)));
        locala.a(true);
        locala.a(System.currentTimeMillis());
        long l1 = a(str, 64);
        long l2 = a(str, 262144);
        if (l1 > l2)
        {
          l1 = l2;
          label400:
          locala.b(l1);
          locala.c(a(str, 524288));
          l1 = a(str, 4096);
          l2 = a(str, 32);
          locala.d(l1);
          if (l1 <= l2) {
            break label632;
          }
          l1 = l2;
          label455:
          locala.e(l1);
          if (localThrowable.mLoginBitmap == 0) {
            locala.d("QQ");
          }
          localObject = new WloginSimpleInfo();
          if (h.e.GetBasicUserInfo(str, (WloginSimpleInfo)localObject).booleanValue())
          {
            locala.b(localObject._age[0]);
            locala.n(((WloginSimpleInfo)localObject)._nick);
            if (localObject._gender[0] != 1) {
              break label635;
            }
          }
        }
        label632:
        label635:
        for (int i1 = 1;; i1 = 2)
        {
          locala.c(i1);
          locala.a(util.buf_to_int16(((WloginSimpleInfo)localObject)._face, 0));
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.AccountCenter", 2, "load account from wt " + locala.d() + " logined:" + locala.o() + " mLoginBitmap:" + localThrowable.mLoginBitmap);
          }
          paramArrayList.add(locala);
          break;
          break label400;
          break label455;
        }
      }
    }
  }
  
  private void d(a parama)
  {
    try
    {
      a(parama);
      CodecWarpper.setAccountKey(parama.d(), parama.e(), parama.f(), parama.g(), parama.h(), parama.i(), parama.j(), parama.k(), parama.m(), parama.l());
      l.a(parama.d(), false);
      String str = MsfStore.getNativeConfigStore().getConfig("__loginSdk_uinMapping_" + parama.d());
      if ((str != null) && (str.length() > 0)) {
        this.m.put(parama.d(), str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AccountCenter", 2, "handle account " + parama.d() + " logined:" + parama.o() + " len:" + parama.k().length);
      }
      return;
    }
    catch (Throwable parama)
    {
      QLog.w("MSF.C.AccountCenter", 1, "parse account error " + parama.toString(), parama);
    }
  }
  
  private void j()
  {
    try
    {
      if (!MsfSdkUtils.getNewAppUinStoreFile().exists())
      {
        Iterator localIterator = this.n.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((a)localEntry.getValue()).z().equals("QQ"))
          {
            MsfSdkUtils.addSimpleAccount(((a)localEntry.getValue()).d());
            if (((a)localEntry.getValue()).o()) {
              MsfSdkUtils.updateSimpleAccount(((a)localEntry.getValue()).d(), true);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AccountCenter", 2, "add simpleAccount store error " + localException, localException);
      }
    }
  }
  
  private void r(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.n.remove(paramString);
      MsfStore.getNativeConfigStore().n_removeConfig("key_account_head_" + paramString);
      MsfStore.getNativeConfigStore().n_removeConfig("__loginSdk_uinMapping_" + paramString);
    }
    try
    {
      new WtloginHelper(BaseApplication.getContext()).ClearUserLoginData(paramString, 16L);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("MSF.C.AccountCenter", 1, "del wttoken error " + paramString);
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(paramToServiceMsg);
    String str = (String)paramToServiceMsg.getAttributes().get("to_verify_code");
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), str, localVerifyCodeInfo));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int a(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), arrayOfByte, paramInt1, paramInt2, paramArrayOfByte));
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    Object localObject = (HashMap)paramToServiceMsg.getAttributes().get("to_login_token_map");
    int i1 = ((Integer)paramToServiceMsg.getAttributes().get("to_login_token_cmdhead")).intValue();
    localObject = this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), i1, (HashMap)localObject);
    paramToServiceMsg.setServiceCmd("login.chgTok");
    paramToServiceMsg.putWupBuffer((byte[])localObject);
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public void a()
  {
    if (this.n.size() > 0)
    {
      Iterator localIterator = this.n.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (a)this.n.get(localObject);
        if ((localObject != null) && (localObject != null) && (((a)localObject).o()) && (((a)localObject).z().equals("QQ"))) {
          try
          {
            this.a.getWtLoginCenter().a((a)localObject, false);
          }
          catch (Throwable localThrowable)
          {
            QLog.d("MSF.C.AccountCenter", 1, "load " + MD5.toMD5(((a)localObject).d()) + " set key to wt error " + localThrowable, localThrowable);
          }
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    this.h = paramInt;
    QLog.d("MSF.C.AccountCenter", 1, "set time interv is " + paramInt);
  }
  
  void a(a parama)
  {
    this.n.put(parama.d(), parama);
  }
  
  public void a(String paramString, long paramLong)
  {
    a locala = n(paramString);
    if (locala == null) {
      return;
    }
    locala.e(paramLong);
    o(paramString);
  }
  
  void a(String paramString, k paramk)
  {
    a(paramString, paramk.d);
  }
  
  void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals(paramString2)))
    {
      this.m.put(paramString2, paramString1);
      MsfStore.getNativeConfigStore().n_setConfig("__loginSdk_uinMapping_" + paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AccountCenter", 2, "saveUinMapping src:" + paramString1 + " real:" + paramString2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    a locala = n(paramString1);
    if (locala == null) {
      return;
    }
    locala.b(paramString2);
    locala.c(paramLong);
    o(paramString1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    a locala = n(paramString);
    if (locala == null) {}
    while (Arrays.equals(locala.a(), paramArrayOfByte)) {
      return;
    }
    locala.a(paramArrayOfByte);
    o(paramString);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    a locala = n(paramString);
    if (locala == null) {}
    while (Arrays.equals(locala.b(), paramArrayOfByte)) {
      return;
    }
    locala.b(paramArrayOfByte);
    locala.d(paramLong);
    o(paramString);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong)
  {
    a locala = n(paramString);
    if (locala == null) {
      return;
    }
    locala.e(paramArrayOfByte1);
    locala.h(paramArrayOfByte2);
    locala.j(paramArrayOfByte3);
    locala.b(paramLong);
    o(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    a((ArrayList)localObject);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      d((a)((Iterator)localObject).next());
    }
    if (paramBoolean) {
      j();
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = new ArrayList();
    b((ArrayList)localObject);
    localObject = ((ArrayList)localObject).iterator();
    boolean bool2;
    for (boolean bool1 = false; ((Iterator)localObject).hasNext(); bool1 = bool2)
    {
      a locala = (a)((Iterator)localObject).next();
      bool2 = bool1;
      if (locala.d().equals(paramString))
      {
        bool2 = bool1;
        if (locala.o()) {
          bool2 = true;
        }
      }
      d(locala);
    }
    return bool1;
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = VerifyCodeInfo.getVerifyCodeInfo(paramToServiceMsg);
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), localVerifyCodeInfo));
    return this.a.sendSsoMsg(paramToServiceMsg);
  }
  
  public int b(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    com.tencent.msf.service.protocol.security.f localf = new com.tencent.msf.service.protocol.security.f();
    localf.a = n(paramToServiceMsg.getUin()).g();
    localf.b = "00".getBytes();
    localHashMap.put("RequestReFetchSid", localf);
    paramToServiceMsg.putWupBuffer(this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 6, localHashMap));
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public String b()
  {
    Object localObject2 = d();
    Object localObject1 = new StringBuffer();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(localSimpleAccount.toStoreString() + ";");
    }
    localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(";")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    return localObject1;
  }
  
  void b(a parama)
  {
    long l1 = System.currentTimeMillis();
    parama.a(true);
    parama.a(l1);
    String str1 = parama.d();
    byte[] arrayOfByte1 = parama.f();
    byte[] arrayOfByte2 = parama.g();
    byte[] arrayOfByte3 = parama.h();
    byte[] arrayOfByte4 = parama.i();
    byte[] arrayOfByte5 = parama.j();
    byte[] arrayOfByte6 = parama.k();
    String str2 = parama.l();
    CodecWarpper.setAccountKey(str1, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, new byte[0], str2);
    CodecWarpper.setUseSimpleHead(parama.d(), false);
    a(parama);
    o(parama.d());
    l.a(parama.d(), false);
  }
  
  public void b(String paramString)
  {
    try
    {
      if (!this.b.containsKey(paramString))
      {
        a locala = new a(paramString);
        this.b.put(paramString, locala);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!this.o.equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "setMainAccount: " + MsfSdkUtils.getShortUin(paramString1) + " src: " + paramString2);
      }
      this.o = paramString1;
      MsfStore.getNativeConfigStore().setConfig(this.p, this.o);
      if ((this.a != null) && (this.a.getSsoListManager() != null)) {
        this.a.getSsoListManager().b(paramString1);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("mqq", 2, "setMainAccount: failed " + MsfSdkUtils.getShortUin(paramString1));
  }
  
  public void b(String paramString, byte[] paramArrayOfByte)
  {
    a locala = n(paramString);
    if (locala == null) {}
    while (Arrays.equals(locala.c(), paramArrayOfByte)) {
      return;
    }
    locala.c(paramArrayOfByte);
    o(paramString);
  }
  
  public int c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
    Object localObject2 = paramToServiceMsg.getUin();
    paramToServiceMsg.setUin((String)localObject1);
    paramToServiceMsg.addAttribute("to_login_changeuin", localObject2);
    localObject1 = new HashMap();
    localObject2 = new e();
    ((e)localObject2).b = 0;
    ((e)localObject2).a = 1;
    ((e)localObject2).c = new byte[0];
    ((HashMap)localObject1).put("RequestNameExchangeUin", localObject2);
    localObject1 = this.e.a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin(), 13, (HashMap)localObject1);
    paramToServiceMsg.setServiceCmd("login.chguin");
    paramToServiceMsg.putWupBuffer((byte[])localObject1);
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    this.a.sendSsoMsg(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  a c(a parama)
  {
    a locala = n(parama.d());
    if (locala == null)
    {
      b(parama);
      return parama;
    }
    if ((parama.f() != null) && (parama.f().length > 0)) {
      locala.e(parama.f());
    }
    if ((parama.i() != null) && (parama.i().length > 0)) {
      locala.h(parama.i());
    }
    if ((parama.k() != null) && (parama.k().length > 0)) {
      locala.j(parama.k());
    }
    if ((parama.l() != null) && (parama.l().length() > 0)) {
      locala.b(parama.l());
    }
    if ((parama.a() != null) && (parama.a().length > 0)) {
      locala.a(parama.a());
    }
    if ((parama.b() != null) && (parama.b().length > 0)) {
      locala.b(parama.b());
    }
    if ((parama.c() != null) && (parama.c().length > 0)) {
      locala.c(parama.c());
    }
    if ((parama.z() != null) && (parama.z().length() > 0)) {
      locala.d(parama.z());
    }
    b(locala);
    return locala;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((String)localIterator.next());
    }
    return localArrayList;
  }
  
  public boolean c(String paramString)
  {
    com.tencent.mobileqq.msf.core.a.a(System.currentTimeMillis());
    r(paramString);
    this.a.sender.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.AccountCenter", 2, "del user " + paramString + " succ.");
    }
    return true;
  }
  
  public long d(String paramString)
  {
    paramString = n(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.A();
  }
  
  public ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.n.get(localObject);
      if (localObject != null) {
        localArrayList.add(((a)localObject).p());
      }
    }
    return localArrayList;
  }
  
  int e()
  {
    return this.h;
  }
  
  public long e(String paramString)
  {
    paramString = n(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.B();
  }
  
  public long f(String paramString)
  {
    paramString = n(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.C();
  }
  
  public byte[] f()
  {
    return util.get_ksid(BaseApplication.getContext());
  }
  
  public long g(String paramString)
  {
    paramString = n(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.D();
  }
  
  public ConcurrentHashMap g()
  {
    return this.n;
  }
  
  public String h()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.n.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      localStringBuffer.append("UIN=" + locala.d() + ",LOGINED=" + locala.o() + ",A2=" + HexUtil.bytes2HexStr(locala.f()) + ",D2=" + HexUtil.bytes2HexStr(locala.i()) + ",KEY=" + HexUtil.bytes2HexStr(locala.k())).append(";");
    }
    return localStringBuffer.toString();
  }
  
  public String h(String paramString)
  {
    paramString = n(paramString);
    if ((paramString != null) && (paramString.o())) {
      return paramString.l();
    }
    return null;
  }
  
  public String i()
  {
    return this.o;
  }
  
  public boolean i(String paramString)
  {
    paramString = n(paramString);
    return (paramString != null) && (paramString.o());
  }
  
  public String j(String paramString)
  {
    return (String)this.m.get(paramString);
  }
  
  public String k(String paramString)
  {
    Iterator localIterator = this.m.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getValue();
      if ((str.equalsIgnoreCase(paramString)) && (l(str))) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  public boolean l(String paramString)
  {
    boolean bool = false;
    try
    {
      long l1 = Long.parseLong(paramString);
      if (l1 > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  /* Error */
  public void m(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mobileqq/msf/core/auth/b:o	Ljava/lang/String;
    //   6: aload_1
    //   7: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: ldc 54
    //   16: ldc_w 768
    //   19: invokevirtual 770	com/tencent/mobileqq/msf/core/auth/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 64	com/tencent/mobileqq/msf/core/auth/b:a	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   26: ldc_w 768
    //   29: invokevirtual 773	com/tencent/mobileqq/msf/core/MsfCore:stopPCActivePolling	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 558	com/tencent/mobileqq/msf/core/auth/b:n	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/auth/a;
    //   37: astore_2
    //   38: aload_1
    //   39: iconst_0
    //   40: invokestatic 384	com/tencent/mobileqq/msf/core/l:a	(Ljava/lang/String;Z)V
    //   43: aload_2
    //   44: ifnull +20 -> 64
    //   47: aload_2
    //   48: iconst_0
    //   49: invokevirtual 296	com/tencent/mobileqq/msf/core/auth/a:a	(Z)V
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 560	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokestatic 776	com/tencent/qphone/base/util/CodecWarpper:nateiveRemoveAccountKey	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: aload_1
    //   65: invokestatic 779	com/tencent/qphone/base/util/CodecWarpper:removeAccountKey	(Ljava/lang/String;)V
    //   68: goto -7 -> 61
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	b
    //   0	76	1	paramString	String
    //   37	11	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	32	71	finally
    //   32	43	71	finally
    //   47	61	71	finally
    //   64	68	71	finally
  }
  
  a n(String paramString)
  {
    return (a)this.n.get(paramString);
  }
  
  void o(String paramString)
  {
    a locala = n(paramString);
    String str = locala.q();
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.AccountCenter", 4, "storeAccount uin:" + paramString);
    }
    MsfStore.getNativeConfigStore().n_setConfig("key_account_head_" + locala.d(), str);
  }
  
  public String p(String paramString)
  {
    String str = "";
    a locala = n(paramString);
    paramString = str;
    if (locala != null) {
      paramString = locala.q();
    }
    return paramString;
  }
  
  public void q(String paramString)
  {
    Object localObject = n(paramString);
    if (localObject == null) {
      return;
    }
    String str = ((a)localObject).d();
    byte[] arrayOfByte1 = ((a)localObject).f();
    byte[] arrayOfByte2 = ((a)localObject).g();
    byte[] arrayOfByte3 = ((a)localObject).h();
    byte[] arrayOfByte4 = ((a)localObject).i();
    byte[] arrayOfByte5 = ((a)localObject).j();
    byte[] arrayOfByte6 = ((a)localObject).k();
    localObject = ((a)localObject).l();
    CodecWarpper.setAccountKey(str, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, new byte[0], (String)localObject);
    l.a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.b
 * JD-Core Version:    0.7.0.1
 */