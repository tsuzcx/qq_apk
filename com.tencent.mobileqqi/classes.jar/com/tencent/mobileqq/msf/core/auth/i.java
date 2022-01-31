package com.tencent.mobileqq.msf.core.auth;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.n;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class i
{
  static final String a = "MSF.C.WTLoginCenter.MsfProvider";
  static ConcurrentHashMap b = new ConcurrentHashMap();
  public static final int c = 262208;
  public static final int d = 1970272;
  public static final int e = 1708064;
  
  public static int a(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WtloginMsfListener paramWtloginMsfListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "SendData uin:" + paramString1 + " serviceCmd:" + paramString2 + " timeout:" + paramInt + " isWTSendSelf:" + paramBoolean + " wUserSigInfo:" + HexUtil.bytes2HexStr(paramWUserSigInfo._reserveData));
    }
    Object localObject;
    ToServiceMsg localToServiceMsg2;
    MsfCommand localMsfCommand;
    ToServiceMsg localToServiceMsg1;
    if (!paramBoolean)
    {
      paramInt = c(paramWUserSigInfo);
      localObject = (k)b.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find WtloginWrapper sendData for " + paramInt);
        return -1;
      }
      ((k)localObject).c = paramWtloginMsfListener;
      localToServiceMsg2 = ((k)localObject).d;
      if ((localToServiceMsg2.getMsfCommand() == MsfCommand.wt_name2uin) && (paramString2.equals("wtlogin.login"))) {
        ((k)localObject).e.getAccountCenter().a(localToServiceMsg2.getUin(), paramString1);
      }
      localMsfCommand = localToServiceMsg2.getMsfCommand();
      paramWtloginMsfListener = (WtloginMsfListener)localObject;
      paramWUserSigInfo = localMsfCommand;
      localToServiceMsg1 = localToServiceMsg2;
      if (localMsfCommand != MsfCommand.wt_CheckSMSVerifyLoginAccount)
      {
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
        paramWUserSigInfo = localMsfCommand;
        localToServiceMsg1 = localToServiceMsg2;
        if (localMsfCommand != MsfCommand.wt_RefreshSMSVerifyLoginCode)
        {
          paramWtloginMsfListener = (WtloginMsfListener)localObject;
          paramWUserSigInfo = localMsfCommand;
          localToServiceMsg1 = localToServiceMsg2;
          if (localMsfCommand != MsfCommand.wt_VerifySMSVerifyLoginCode)
          {
            if (!paramString2.equals("wtlogin.login")) {
              break label347;
            }
            paramWUserSigInfo = MsfCommand.wt_loginAuth;
            localToServiceMsg1 = localToServiceMsg2;
            paramWtloginMsfListener = (WtloginMsfListener)localObject;
          }
        }
      }
    }
    for (;;)
    {
      paramInt = paramArrayOfByte.length + 4;
      localObject = ByteBuffer.allocate(paramInt);
      ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
      ((ByteBuffer)localObject).putInt(paramInt);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      localToServiceMsg1.setUin(paramString1);
      localToServiceMsg1.setServiceCmd(paramString2);
      localToServiceMsg1.setMsfCommand(paramWUserSigInfo);
      localToServiceMsg1.putWupBuffer(((ByteBuffer)localObject).array());
      return paramWtloginMsfListener.e.sendSsoMsg(localToServiceMsg1);
      label347:
      paramWtloginMsfListener = (WtloginMsfListener)localObject;
      paramWUserSigInfo = localMsfCommand;
      localToServiceMsg1 = localToServiceMsg2;
      if (paramString2.equals("wtlogin.name2uin"))
      {
        paramWUserSigInfo = MsfCommand.wt_name2uin;
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
        localToServiceMsg1 = localToServiceMsg2;
        continue;
        localToServiceMsg1 = new ToServiceMsg("", paramString1, paramString2);
        localToServiceMsg1.setAppId(h.d.getMsfAppid());
        localToServiceMsg1.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg1.setTimeout(paramInt);
        MsfSdkUtils.addToMsgProcessName("*", localToServiceMsg1);
        paramWUserSigInfo = MsfCommand.wt_other;
        localToServiceMsg1.setMsfCommand(paramWUserSigInfo);
        a(localToServiceMsg1);
        a(h.d, localToServiceMsg1);
        localObject = (k)b.get(Integer.valueOf(localToServiceMsg1.getRequestSsoSeq()));
        ((k)localObject).c = paramWtloginMsfListener;
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
      }
    }
  }
  
  static k a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if ((paramToServiceMsg.getMsfCommand() == MsfCommand.refreVerifyCode) || (paramToServiceMsg.getMsfCommand() == MsfCommand.submitVerifyCode) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_CheckPictureAndGetSt) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_RefreshPictureData))
      {
        paramMsfCore = (k)b.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        localObject = paramMsfCore;
        if (paramMsfCore != null) {
          break label119;
        }
      }
      try
      {
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find wtloginMsfListener VerifyCode for " + paramToServiceMsg.getRequestSsoSeq());
        return null;
      }
      catch (Exception paramToServiceMsg) {}
      if (paramToServiceMsg.getRequestSsoSeq() == -1) {
        paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      }
      Object localObject = new k(paramMsfCore, paramToServiceMsg);
      label119:
      paramMsfCore = (MsfCore)localObject;
      ((k)localObject).d = paramToServiceMsg;
      paramMsfCore = (MsfCore)localObject;
      b.put(Integer.valueOf(((k)localObject).d.getRequestSsoSeq()), localObject);
      return localObject;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramMsfCore = null;
      }
    }
    paramToServiceMsg.printStackTrace();
    return paramMsfCore;
  }
  
  public static k a(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (k)b.get(Integer.valueOf(i));
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    int k;
    int j;
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 3))
    {
      k = util.buf_to_int32(paramArrayOfByte, 0);
      j = 4;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (paramArrayOfByte.length < j + 1)) {}
      int m;
      do
      {
        do
        {
          do
          {
            return null;
            m = util.buf_to_int8(paramArrayOfByte, j);
            j += 1;
          } while (paramArrayOfByte.length < j + m);
          paramString = new String(paramArrayOfByte, j, m);
          m = j + m;
        } while (paramArrayOfByte.length < m + 2);
        j = util.buf_to_int32(paramArrayOfByte, m);
        m += 4;
      } while (paramArrayOfByte.length < m + j);
      String str = new String(paramArrayOfByte, m, j);
      util.LOGI("key_data:" + paramString + " value:" + str);
      if (paramString.equals("pic_reason")) {
        return str;
      }
      i += 1;
      j += m;
    }
  }
  
  public static void a(int paramInt) {}
  
  public static void a(MsfCore paramMsfCore, WtloginHelper paramWtloginHelper, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      return;
    }
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + " wtlogin succ.");
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()) {}
    for (Object localObject1 = String.valueOf(localWloginSimpleInfo._uin);; localObject1 = paramString)
    {
      byte[] arrayOfByte2 = new byte[16];
      byte[] arrayOfByte3 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 262144);
      Object localObject2 = new byte[0];
      try
      {
        arrayOfByte1 = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 262144);
        localObject2 = arrayOfByte1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte1;
          byte[] arrayOfByte4;
          byte[] arrayOfByte5;
          byte[] arrayOfByte6;
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error " + localException);
          continue;
          int i = 2;
        }
      }
      arrayOfByte1 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
      arrayOfByte4 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 524288);
      arrayOfByte5 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 131072);
      arrayOfByte6 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
      paramWUserSigInfo = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
      f.a(arrayOfByte2, 0, (byte[])localObject2, localObject2.length);
      localObject1 = new a((String)localObject1);
      ((a)localObject1).e(arrayOfByte1);
      ((a)localObject1).h(arrayOfByte3);
      ((a)localObject1).j(arrayOfByte2);
      ((a)localObject1).b(new String(arrayOfByte4));
      ((a)localObject1).a(arrayOfByte5);
      ((a)localObject1).b(arrayOfByte6);
      ((a)localObject1).c(paramWUserSigInfo);
      ((a)localObject1).d(com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg));
      if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue())
      {
        ((a)localObject1).b(localWloginSimpleInfo._age[0]);
        ((a)localObject1).n(localWloginSimpleInfo._nick);
        if (localWloginSimpleInfo._gender[0] == 1)
        {
          i = 1;
          ((a)localObject1).c(i);
          ((a)localObject1).a(util.buf_to_int16(localWloginSimpleInfo._face, 0));
        }
      }
      else
      {
        paramFromServiceMsg.addAttribute("resp_simpleAccount", paramMsfCore.getAccountCenter().c((a)localObject1).p().toStoreString());
        paramFromServiceMsg.setMsgSuccess();
        paramFromServiceMsg.addAttribute("__attribute_tag_servertimediff", Long.valueOf(paramWtloginHelper.GetTimeDifference() * 1000L));
        paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (paramToServiceMsg.getAttribute("__timestamp_app2msf") == null) {
      paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
    }
    paramToServiceMsg.addAttribute("to_wtlogin_oldcmd", paramToServiceMsg.getServiceCmd());
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    k localk = (k)b.get(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
    if (localk == null)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find wtloginMsfListener onRecvData for " + paramFromServiceMsg.getRequestSsoSeq());
      return;
    }
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onRecvData find wtloginMsfListener for " + paramFromServiceMsg.getRequestSsoSeq());
    Object localObject = (String)paramToServiceMsg.getAttribute("to_wtlogin_oldcmd");
    if (localObject != null) {
      paramToServiceMsg.setServiceCmd((String)localObject);
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg.order(ByteOrder.BIG_ENDIAN);
      int i = paramToServiceMsg.getInt();
      localObject = new byte[i - 4];
      paramToServiceMsg.get((byte[])localObject, 0, i - 4);
      localk.c.onReceiveData(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), (byte[])localObject);
      return;
    }
    localk.c.onReceiveFail(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), paramFromServiceMsg.getBusinessFailCode());
  }
  
  public static void a(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      paramString1 = h.e.GetDevLockInfo(paramString1, paramLong);
      if (paramFromServiceMsg.getAttribute("timeLimit") != null) {
        paramString1.TimeLimit = ((Integer)paramFromServiceMsg.getAttribute("timeLimit")).intValue();
      }
      if ((paramString1 != null) && (QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "GetDevLockInfo: " + paramString1.Mobile + " " + paramString1.DevSetup);
      }
      paramFromServiceMsg.addAttribute("resp_devlockinfo", paramString1);
      paramFromServiceMsg.setBusinessFail(2016, paramString2);
      paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd exception " + paramString1.toString(), paramString1);
    }
  }
  
  public static k b(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (k)b.remove(Integer.valueOf(i));
  }
  
  public static WUserSigInfo b(int paramInt)
  {
    try
    {
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(paramInt);
      return localWUserSigInfo;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "getWUSigInfoFromSeq error " + paramInt, localException);
    }
    return null;
  }
  
  public static void b(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = h.e.GetPictureData(paramFromServiceMsg.getUin(), paramLong);
      n.a(paramFromServiceMsg);
      VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
      localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
      localVerifyCodeInfo.verifyimage = arrayOfByte;
      try
      {
        localVerifyCodeInfo.verifyNote = a(paramString1, h.e.GetPicturePrompt(paramString1, paramLong));
        VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
        paramFromServiceMsg.setBusinessFail(2002, paramString2);
        paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "getImagePrompt exception " + paramString1.toString(), paramString1);
          localVerifyCodeInfo.verifyNote = "getTipErr";
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd exception " + paramString1.toString(), paramString1);
    }
  }
  
  public static int c(WUserSigInfo paramWUserSigInfo)
  {
    try
    {
      int i = MsfSdkUtils.convertBytes2Int(paramWUserSigInfo._reserveData);
      return i;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "getSsoSeqFromInfo error " + paramWUserSigInfo, localException);
    }
    return -1;
  }
  
  /* Error */
  public static WUserSigInfo c(int paramInt)
  {
    // Byte code:
    //   0: new 60	oicq/wlogin_sdk/request/WUserSigInfo
    //   3: dup
    //   4: invokespecial 535	oicq/wlogin_sdk/request/WUserSigInfo:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: iload_0
    //   12: invokestatic 539	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:convertInt2Bytes	(I)[B
    //   15: putfield 64	oicq/wlogin_sdk/request/WUserSigInfo:_reserveData	[B
    //   18: aload 4
    //   20: astore_3
    //   21: getstatic 586	com/tencent/mobileqq/msf/core/auth/h:c	[Ljava/lang/String;
    //   24: ifnull +86 -> 110
    //   27: aload 4
    //   29: astore_3
    //   30: getstatic 586	com/tencent/mobileqq/msf/core/auth/h:c	[Ljava/lang/String;
    //   33: arraylength
    //   34: ifle +76 -> 110
    //   37: getstatic 586	com/tencent/mobileqq/msf/core/auth/h:c	[Ljava/lang/String;
    //   40: astore 5
    //   42: aload 5
    //   44: arraylength
    //   45: istore_2
    //   46: iconst_0
    //   47: istore_1
    //   48: aload 4
    //   50: astore_3
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +57 -> 110
    //   56: aload 5
    //   58: iload_1
    //   59: aaload
    //   60: astore_3
    //   61: aload 4
    //   63: getfield 590	oicq/wlogin_sdk/request/WUserSigInfo:_domains	Ljava/util/List;
    //   66: aload_3
    //   67: invokeinterface 595 2 0
    //   72: pop
    //   73: iload_1
    //   74: iconst_1
    //   75: iadd
    //   76: istore_1
    //   77: goto -29 -> 48
    //   80: astore_3
    //   81: ldc 8
    //   83: iconst_1
    //   84: new 37	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 541
    //   94: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_0
    //   98: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: aload_3
    //   105: invokestatic 543	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_3
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramInt	int
    //   47	30	1	i	int
    //   45	9	2	j	int
    //   20	47	3	localWUserSigInfo1	WUserSigInfo
    //   80	25	3	localException	Exception
    //   109	2	3	localWUserSigInfo2	WUserSigInfo
    //   7	55	4	localWUserSigInfo3	WUserSigInfo
    //   40	17	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	18	80	java/lang/Exception
    //   21	27	80	java/lang/Exception
    //   30	46	80	java/lang/Exception
    //   61	73	80	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.i
 * JD-Core Version:    0.7.0.1
 */