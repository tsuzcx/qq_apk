package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.qq.jce.wup.WupHexUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.msf.service.protocol.security.l;
import com.tencent.msf.service.protocol.security.o;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class g
{
  public static final String a = "MSF.C.AccountRespHandler";
  b b;
  
  public g(b paramb)
  {
    this.b = paramb;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    k localk;
    label161:
    Object localObject2;
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
    {
      localObject1 = new UniPacket(true);
      ((UniPacket)localObject1).setEncodeName("UTF-8");
      ((UniPacket)localObject1).decode(paramFromServiceMsg.getWupBuffer());
      localk = (k)((UniPacket)localObject1).getByClass("RespondHeader", new k());
      a locala;
      if (localk != null)
      {
        if (!this.b.b.containsKey(localk.d)) {
          this.b.b(localk.d);
        }
        locala = (a)this.b.b.get(localk.d);
        if (localk.f != 101) {
          break label161;
        }
        this.b.e.a(paramToServiceMsg, paramFromServiceMsg, (UniPacket)localObject1, localk);
        this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      }
      do
      {
        return;
        if ((localk.f != 0) && (localk.f != 10)) {
          break;
        }
        switch (localk.b)
        {
        case 17: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 16: 
        default: 
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 0: 
          this.b.e.a(paramToServiceMsg, paramFromServiceMsg, localk);
          return;
        case 14: 
          localObject2 = (o)((UniPacket)localObject1).getByClass("ResponseAuthWlogin", new o());
          if (localObject2 != null)
          {
            localObject2 = ((o)localObject2).d;
            if ((localObject2 == null) || (localObject2.length <= 0)) {}
          }
          this.b.e.a((UniPacket)localObject1, locala);
          this.b.e.a(paramToServiceMsg, paramFromServiceMsg, localk);
          return;
        case 1: 
          try
          {
            if (((UniPacket)localObject1).getServantName().equals("Login.Register"))
            {
              this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.d("MSF.C.AccountRespHandler", 2, "handle _CMD_ID_VERIFY_PIC failed.", paramToServiceMsg);
            return;
          }
          localObject2 = (o)((UniPacket)localObject1).getByClass("ResponseAuthWlogin", new o());
          if (localObject2 != null)
          {
            localObject2 = ((o)localObject2).d;
            if ((localObject2 == null) || (localObject2.length <= 0)) {}
          }
          this.b.e.a((UniPacket)localObject1, locala);
          this.b.e.a(paramToServiceMsg, paramFromServiceMsg, localk);
          return;
        case 6: 
          localObject1 = (l)((UniPacket)localObject1).getByClass("RespondReFetchSid", new l());
          this.b.a(paramFromServiceMsg.getUin(), new String(((l)localObject1).b), System.currentTimeMillis());
          paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), ((l)localObject1).b);
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
          {
            this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 9: 
          RespondCustomSig localRespondCustomSig = (RespondCustomSig)((UniPacket)localObject1).getByClass("RespondCustomSig", new RespondCustomSig());
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          int i = 0;
          if (i < localRespondCustomSig.SigList.size())
          {
            localObject1 = (CustomSigContent)localRespondCustomSig.SigList.get(i);
            int k;
            Object localObject3;
            byte[] arrayOfByte;
            Object localObject4;
            if (((CustomSigContent)localObject1).ulSigType == 13L)
            {
              k = 1;
              localObject3 = new Cryptor();
              arrayOfByte = ((CustomSigContent)localObject1).SigContent;
              localObject2 = locala.f();
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (localObject2.length != 0) {}
              }
              else
              {
                localObject4 = this.b.n(localk.d);
                localObject1 = localObject2;
                if (localObject4 != null) {
                  localObject1 = ((a)localObject4).f();
                }
              }
              if ((localObject1 == null) || (localObject1.length == 0)) {
                QLog.d("MSF.C.AccountRespHandler", 2, "A2 is null!");
              }
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              localObject1 = MD5.toMD5Byte((byte[])localObject1);
              if ((localObject1 == null) || (localObject1.length == 0))
              {
                QLog.d("MSF.C.AccountRespHandler", 2, "dekey A2 is null!");
              }
              else
              {
                localObject1 = ((Cryptor)localObject3).decrypt(arrayOfByte, (byte[])localObject1);
                if ((localObject1 == null) || (localObject1.length == 0))
                {
                  QLog.d("MSF.C.AccountRespHandler", 2, "D3 decrypt by A2 failed, D3 is " + HexUtil.bytes2HexStr(arrayOfByte));
                }
                else
                {
                  localObject2 = new byte[4];
                  localObject3 = new byte[16];
                  arrayOfByte = new byte[2];
                  f.a((byte[])localObject2, 0, (byte[])localObject1, 4);
                  f.a((byte[])localObject3, 0, (byte[])localObject1, 4, 16);
                  f.a(arrayOfByte, 0, (byte[])localObject1, 20, 2);
                  localObject4 = new int[2];
                  localObject4[0] = arrayOfByte[0];
                  localObject4[0] <<= 8;
                  localObject4[1] = arrayOfByte[1];
                  j = localObject4[0] + localObject4[1];
                  if (localObject1.length != j + 22)
                  {
                    QLog.d("MSF.C.AccountRespHandler", 2, "D3.length is " + localObject1.length + ", but expected to be " + (j + 22));
                  }
                  else
                  {
                    arrayOfByte = new byte[j];
                    f.a(arrayOfByte, 0, (byte[])localObject1, 22, j);
                    localArrayList.add(WupHexUtil.bytes2HexStr((byte[])localObject2) + "," + WupHexUtil.bytes2HexStr((byte[])localObject3) + "," + WupHexUtil.bytes2HexStr(arrayOfByte));
                    continue;
                    localArrayList.add(((CustomSigContent)localObject1).toString());
                    k = j;
                    if (((CustomSigContent)localObject1).ulSigType == 3L)
                    {
                      paramFromServiceMsg.addAttribute("A8", localObject1);
                      k = j;
                    }
                  }
                }
              }
            }
          }
          if (j != 0) {
            paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), localArrayList);
          }
          while (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
          {
            this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
            return;
            paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), localRespondCustomSig);
          }
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 13: 
          this.b.a(paramToServiceMsg.getUin(), localk);
          locala.d(localk.e);
          paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), localk.d);
          localObject1 = (p)((UniPacket)localObject1).getByClass("ResponseNameExchangeUin", new p());
          if (localObject1 != null)
          {
            localObject2 = ((p)localObject1).d;
            if ((localObject2 != null) && (localObject2.length > 0)) {}
            paramFromServiceMsg.addAttribute("__base_tag_sigSession", ((p)localObject1).e);
          }
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        paramToServiceMsg = (com.tencent.msf.service.protocol.security.j)((UniPacket)localObject1).getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j());
      } while (paramToServiceMsg == null);
      NetConnInfoCenter.handleGetServerTimeResp(paramToServiceMsg.b);
      return;
      if (localk.f == 203)
      {
        localObject1 = (i)((UniPacket)localObject1).getByClass("RespondAuth", new i());
        if ((localObject1 == null) || (((i)localObject1).b == null)) {
          break label2038;
        }
      }
    }
    label2038:
    for (Object localObject1 = ((i)localObject1).b;; localObject1 = "password error")
    {
      paramFromServiceMsg.setBusinessFail(2005, (String)localObject1);
      this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (localk.f == 235)
      {
        localObject1 = (com.tencent.msf.service.protocol.security.j)((UniPacket)localObject1).getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j());
        if (localObject1 != null)
        {
          this.b.a((int)(((com.tencent.msf.service.protocol.security.j)localObject1).b - System.currentTimeMillis() / 1000L));
          if ((paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
          {
            if (paramToServiceMsg.getAttribute("to_login_alsoCheckTime") != null) {
              break;
            }
            paramToServiceMsg.addAttribute("to_login_alsoCheckTime", Integer.valueOf(1));
            if (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth)
            {
              this.b.a.login(paramToServiceMsg);
              return;
            }
            if (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin)
            {
              this.b.a.ChangeUinLogin(paramToServiceMsg);
              return;
            }
            if (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin)
            {
              this.b.a.wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
              return;
            }
            QLog.d("AuthRespHandler", 2, "HandlerLoginResp authResp.result == com.tencent.msf.service.protocol.security.Const.RESULT_A1Overtime and go else?? what happen?");
            return;
          }
        }
        paramFromServiceMsg.setBusinessFail(1012, "client time error");
        this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      localObject1 = (i)((UniPacket)localObject1).getByClass("RespondAuth", new i());
      if ((localObject1 != null) && (((i)localObject1).b != null)) {}
      for (localObject1 = ((i)localObject1).b;; localObject1 = "loginFailed.")
      {
        if ((localk.b == 14) || (localk.b == 0)) {
          this.b.m(paramFromServiceMsg.getUin());
        }
        paramFromServiceMsg.setBusinessFail(localk.f, (String)localObject1);
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
        {
          this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
        if ((paramToServiceMsg.getMsfCommand() != MsfCommand.changeUinLogin) && (paramToServiceMsg.getMsfCommand() != MsfCommand.loginAuth) && (paramToServiceMsg.getMsfCommand() != MsfCommand.wt_GetStViaSMSVerifyLogin)) {
          break;
        }
        boolean bool = paramFromServiceMsg.getServiceCmd().equals("login.chguin");
        long l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        long l3 = com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
        localObject1 = "0";
        localObject2 = "0";
        if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
          localObject1 = (String)paramToServiceMsg.getAttribute("_tag_socket");
        }
        if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
          localObject2 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
        }
        if (paramFromServiceMsg.getBusinessFailCode() == 1002)
        {
          long l1 = 0L;
          if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
          {
            if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
              l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
            }
            this.b.a.getStatReporter().a(false, l2, 1014, l3, (String)localObject1, (String)localObject2, bool, l1);
            return;
          }
          this.b.a.getStatReporter().a(false, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject1, (String)localObject2, bool, 0L);
          return;
        }
        if (paramFromServiceMsg.getBusinessFailCode() == 2008)
        {
          this.b.a.getStatReporter().a(paramToServiceMsg.getUin(), false, l2, paramFromServiceMsg.getBusinessFailCode(), l3);
          return;
        }
        this.b.a.getStatReporter().a(true, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject1, (String)localObject2, bool, 0L);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.g
 * JD-Core Version:    0.7.0.1
 */