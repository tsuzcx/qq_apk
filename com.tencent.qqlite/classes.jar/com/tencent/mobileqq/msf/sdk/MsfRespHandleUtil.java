package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.b.e;
import com.tencent.mobileqq.msf.core.b.e.a;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfRespHandleUtil
{
  public static final String tag = "MSF.D.RespHandleUtil";
  IAuthHandler authHandler;
  IMsfMsgHandler msfMsgHandler;
  INotifyHandler notifyHandler;
  IPushHandler pushHandler;
  IRegisterUinHandler registerUinHandler;
  IServerInfoHandler serverInfoHandler;
  IServerMsgPushHandler serverMsgPushHandler;
  
  public MsfRespHandleUtil(IMsfHandler[] paramArrayOfIMsfHandler)
  {
    if (paramArrayOfIMsfHandler != null)
    {
      int j = paramArrayOfIMsfHandler.length;
      int i = 0;
      if (i < j)
      {
        IMsfHandler localIMsfHandler = paramArrayOfIMsfHandler[i];
        if ((localIMsfHandler instanceof IAuthHandler)) {
          this.authHandler = ((IAuthHandler)localIMsfHandler);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localIMsfHandler instanceof IMsfMsgHandler)) {
            this.msfMsgHandler = ((IMsfMsgHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof INotifyHandler)) {
            this.notifyHandler = ((INotifyHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerInfoHandler)) {
            this.serverInfoHandler = ((IServerInfoHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IPushHandler)) {
            this.pushHandler = ((IPushHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IRegisterUinHandler)) {
            this.registerUinHandler = ((IRegisterUinHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerMsgPushHandler)) {
            this.serverMsgPushHandler = ((IServerMsgPushHandler)localIMsfHandler);
          }
        }
      }
    }
  }
  
  public boolean handlePushMsg(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onConnOpened)
        {
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 2;
          if (this.serverMsgPushHandler == null) {
            break label424;
          }
          this.serverMsgPushHandler.onConnOpened(paramFromServiceMsg);
          bool1 = true;
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvConfigPush)
          {
            bool2 = bool1;
            if (this.serverMsgPushHandler != null)
            {
              this.serverMsgPushHandler.onRecvServerConfigPush(paramFromServiceMsg);
              bool2 = true;
            }
            if (bool2) {
              break;
            }
            if (this.pushHandler == null) {
              continue;
            }
            this.pushHandler.onRecvCmdPush(paramFromServiceMsg);
            return true;
          }
        }
        else
        {
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onReceFirstResp)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 4;
            if (this.serverMsgPushHandler == null) {
              break label424;
            }
            this.serverMsgPushHandler.onReceFirstResp(paramFromServiceMsg);
            bool1 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onOepnConnAllFailed)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 3;
            if (this.serverMsgPushHandler == null) {
              break label424;
            }
            this.serverMsgPushHandler.onOpenConnAllFailed(paramFromServiceMsg);
            bool1 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onConnClosed) {
            break label424;
          }
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 1;
          if (this.serverMsgPushHandler == null) {
            break label424;
          }
          this.serverMsgPushHandler.onConnClose(paramFromServiceMsg);
          bool1 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvNotifyMsg)
        {
          bool2 = bool1;
          if (this.notifyHandler == null) {
            continue;
          }
          long l = ((Long)paramFromServiceMsg.getAttributes().get("notifyId")).longValue();
          this.notifyHandler.onRecvNotify(l, paramFromServiceMsg);
          bool2 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerPush)
        {
          bool2 = bool1;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onRegisterPushResp(null, paramFromServiceMsg);
          bool2 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onTicketChanged)
        {
          bool2 = bool1;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onTicketChanged();
          bool2 = true;
          continue;
        }
        bool2 = bool1;
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onProxyIpChanged) {
          continue;
        }
        bool2 = bool1;
        if (this.pushHandler == null) {
          continue;
        }
        this.pushHandler.onProxyIpChanged(paramFromServiceMsg.getUin());
        bool2 = true;
        continue;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 18);
        }
        return false;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("MSF.D.RespHandleUtil", 1, "handle push msg error " + paramFromServiceMsg, paramFromServiceMsg);
        return true;
      }
      label424:
      boolean bool1 = false;
    }
    return bool2;
  }
  
  /* Error */
  public boolean handleRespMsg(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 211	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 214	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   9: istore 4
    //   11: aload_2
    //   12: invokevirtual 217	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   15: astore 9
    //   17: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +28 -> 48
    //   23: ldc 8
    //   25: iconst_2
    //   26: new 186	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   33: ldc 223
    //   35: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_2
    //   49: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   52: getstatic 229	com/tencent/mobileqq/msf/sdk/MsfCommand:loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   55: if_acmpeq +13 -> 68
    //   58: aload_2
    //   59: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   62: getstatic 232	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_loginAuth	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   65: if_acmpne +54 -> 119
    //   68: aload_0
    //   69: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   72: ifnull +1641 -> 1713
    //   75: aload_0
    //   76: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   79: iload_3
    //   80: iload 4
    //   82: aload 9
    //   84: aload_1
    //   85: aload_2
    //   86: invokeinterface 236 6 0
    //   91: iconst_1
    //   92: istore 6
    //   94: iload 6
    //   96: ifne +1495 -> 1591
    //   99: aload_0
    //   100: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   103: ifnull +1678 -> 1781
    //   106: aload_0
    //   107: getfield 35	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:msfMsgHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IMsfMsgHandler;
    //   110: aload_1
    //   111: aload_2
    //   112: invokeinterface 239 3 0
    //   117: iconst_1
    //   118: ireturn
    //   119: aload_2
    //   120: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   123: getstatic 242	com/tencent/mobileqq/msf/sdk/MsfCommand:changeUinLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   126: if_acmpeq +13 -> 139
    //   129: aload_2
    //   130: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   133: getstatic 245	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_GetStViaSMSVerifyLogin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   136: if_acmpne +32 -> 168
    //   139: aload_0
    //   140: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   143: ifnull +1570 -> 1713
    //   146: aload_0
    //   147: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   150: iload_3
    //   151: iload 4
    //   153: aload 9
    //   155: aload_1
    //   156: aload_2
    //   157: invokeinterface 248 6 0
    //   162: iconst_1
    //   163: istore 6
    //   165: goto -71 -> 94
    //   168: aload_2
    //   169: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   172: getstatic 251	com/tencent/mobileqq/msf/sdk/MsfCommand:changeToken	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   175: if_acmpeq +13 -> 188
    //   178: aload_2
    //   179: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   182: getstatic 254	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_exchange	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   185: if_acmpne +147 -> 332
    //   188: aload_0
    //   189: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   192: ifnull +1521 -> 1713
    //   195: aconst_null
    //   196: astore 8
    //   198: aload_2
    //   199: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   202: istore 6
    //   204: aload 8
    //   206: astore 7
    //   208: iload 6
    //   210: ifeq +54 -> 264
    //   213: aload_2
    //   214: invokevirtual 181	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   217: astore 7
    //   219: new 259	com/qq/jce/wup/UniPacket
    //   222: dup
    //   223: iconst_1
    //   224: invokespecial 262	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   227: astore 10
    //   229: aload 10
    //   231: ldc_w 264
    //   234: invokevirtual 267	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   237: aload 10
    //   239: aload 7
    //   241: invokevirtual 271	com/qq/jce/wup/UniPacket:decode	([B)V
    //   244: aload 10
    //   246: ldc_w 273
    //   249: new 275	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   252: dup
    //   253: invokespecial 276	com/tencent/msf/service/protocol/security/RespondCustomSig:<init>	()V
    //   256: invokevirtual 280	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 275	com/tencent/msf/service/protocol/security/RespondCustomSig
    //   262: astore 7
    //   264: aload_0
    //   265: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   268: iload_3
    //   269: iload 4
    //   271: aload 9
    //   273: aload 7
    //   275: aload_1
    //   276: aload_2
    //   277: invokeinterface 284 7 0
    //   282: iconst_1
    //   283: istore 6
    //   285: goto -191 -> 94
    //   288: astore 7
    //   290: aload 7
    //   292: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   295: aload 8
    //   297: astore 7
    //   299: goto -35 -> 264
    //   302: astore_1
    //   303: ldc 8
    //   305: iconst_1
    //   306: new 186	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 289
    //   316: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: aload_1
    //   327: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: iconst_1
    //   331: ireturn
    //   332: aload_2
    //   333: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   336: getstatic 292	com/tencent/mobileqq/msf/sdk/MsfCommand:submitPuzzleVerifyCodeTicket	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   339: if_acmpne +32 -> 371
    //   342: aload_0
    //   343: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   346: ifnull +1367 -> 1713
    //   349: aload_0
    //   350: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   353: iload_3
    //   354: iload 4
    //   356: aload 9
    //   358: aload_1
    //   359: aload_2
    //   360: invokeinterface 236 6 0
    //   365: iconst_1
    //   366: istore 6
    //   368: goto -274 -> 94
    //   371: aload_2
    //   372: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   375: getstatic 295	com/tencent/mobileqq/msf/sdk/MsfCommand:submitVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   378: if_acmpne +32 -> 410
    //   381: aload_0
    //   382: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   385: ifnull +1328 -> 1713
    //   388: aload_0
    //   389: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   392: iload_3
    //   393: iload 4
    //   395: aload 9
    //   397: aload_1
    //   398: aload_2
    //   399: invokeinterface 236 6 0
    //   404: iconst_1
    //   405: istore 6
    //   407: goto -313 -> 94
    //   410: aload_2
    //   411: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   414: getstatic 298	com/tencent/mobileqq/msf/sdk/MsfCommand:refreVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   417: if_acmpne +32 -> 449
    //   420: aload_0
    //   421: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   424: ifnull +1289 -> 1713
    //   427: aload_0
    //   428: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   431: iload_3
    //   432: iload 4
    //   434: aload 9
    //   436: aload_1
    //   437: aload_2
    //   438: invokeinterface 236 6 0
    //   443: iconst_1
    //   444: istore 6
    //   446: goto -352 -> 94
    //   449: aload_2
    //   450: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   453: getstatic 301	com/tencent/mobileqq/msf/sdk/MsfCommand:delLoginedAccount	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   456: if_acmpne +32 -> 488
    //   459: aload_0
    //   460: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   463: ifnull +1250 -> 1713
    //   466: aload_0
    //   467: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   470: iload_3
    //   471: iload 4
    //   473: aload 9
    //   475: aload_1
    //   476: aload_2
    //   477: invokeinterface 304 6 0
    //   482: iconst_1
    //   483: istore 6
    //   485: goto -391 -> 94
    //   488: aload_2
    //   489: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   492: getstatic 307	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_name2uin	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   495: if_acmpne +32 -> 527
    //   498: aload_0
    //   499: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   502: ifnull +1211 -> 1713
    //   505: aload_0
    //   506: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   509: iload_3
    //   510: iload 4
    //   512: aload 9
    //   514: aload_1
    //   515: aload_2
    //   516: invokeinterface 310 6 0
    //   521: iconst_1
    //   522: istore 6
    //   524: goto -430 -> 94
    //   527: aload_2
    //   528: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   531: getstatic 313	com/tencent/mobileqq/msf/sdk/MsfCommand:onRecvVerifyCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   534: if_acmpne +35 -> 569
    //   537: aload_0
    //   538: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   541: ifnull +1172 -> 1713
    //   544: aload_2
    //   545: invokestatic 319	com/tencent/mobileqq/msf/sdk/VerifyCodeInfo:getVerifyCodeInfo	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/mobileqq/msf/sdk/VerifyCodeInfo;
    //   548: astore 7
    //   550: aload_0
    //   551: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   554: aload 7
    //   556: aload_1
    //   557: aload_2
    //   558: invokeinterface 323 4 0
    //   563: iconst_1
    //   564: istore 6
    //   566: goto -472 -> 94
    //   569: aload_2
    //   570: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   573: getstatic 326	com/tencent/mobileqq/msf/sdk/MsfCommand:reportMsg	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   576: if_acmpne +32 -> 608
    //   579: aload_0
    //   580: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   583: ifnull +1130 -> 1713
    //   586: aload_0
    //   587: getfield 43	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:serverInfoHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IServerInfoHandler;
    //   590: iload_3
    //   591: iload 4
    //   593: aload 9
    //   595: aload_1
    //   596: aload_2
    //   597: invokeinterface 329 6 0
    //   602: iconst_1
    //   603: istore 6
    //   605: goto -511 -> 94
    //   608: aload_2
    //   609: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   612: getstatic 332	com/tencent/mobileqq/msf/sdk/MsfCommand:getServerConfig	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   615: if_acmpne +98 -> 713
    //   618: aload_2
    //   619: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   622: istore 6
    //   624: iload 6
    //   626: ifeq +49 -> 675
    //   629: aload_2
    //   630: invokevirtual 114	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   633: ldc_w 334
    //   636: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   639: checkcast 336	java/lang/Integer
    //   642: invokevirtual 339	java/lang/Integer:intValue	()I
    //   645: istore_3
    //   646: aload_2
    //   647: invokevirtual 114	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   650: ldc_w 341
    //   653: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   656: checkcast 161	java/lang/String
    //   659: astore 7
    //   661: aload_1
    //   662: invokestatic 346	com/tencent/mobileqq/msf/service/g:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   665: iload_3
    //   666: aload 7
    //   668: aload_1
    //   669: invokevirtual 349	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   672: invokestatic 355	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:writeServerConfig	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   675: iconst_1
    //   676: istore 6
    //   678: goto -584 -> 94
    //   681: astore 7
    //   683: ldc 8
    //   685: iconst_1
    //   686: new 186	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   693: ldc_w 357
    //   696: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 7
    //   701: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -35 -> 675
    //   713: aload_2
    //   714: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   717: getstatic 135	com/tencent/mobileqq/msf/sdk/MsfCommand:registerPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   720: if_acmpne +27 -> 747
    //   723: aload_0
    //   724: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   727: ifnull +986 -> 1713
    //   730: aload_0
    //   731: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   734: aload_1
    //   735: aload_2
    //   736: invokeinterface 139 3 0
    //   741: iconst_1
    //   742: istore 6
    //   744: goto -650 -> 94
    //   747: aload_2
    //   748: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   751: getstatic 363	com/tencent/mobileqq/msf/sdk/MsfCommand:unRegisterPush	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   754: if_acmpne +27 -> 781
    //   757: aload_0
    //   758: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   761: ifnull +952 -> 1713
    //   764: aload_0
    //   765: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   768: aload_1
    //   769: aload_2
    //   770: invokeinterface 366 3 0
    //   775: iconst_1
    //   776: istore 6
    //   778: goto -684 -> 94
    //   781: aload_2
    //   782: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   785: getstatic 369	com/tencent/mobileqq/msf/sdk/MsfCommand:registerCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   788: if_acmpne +27 -> 815
    //   791: aload_0
    //   792: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   795: ifnull +918 -> 1713
    //   798: aload_0
    //   799: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   802: aload_1
    //   803: aload_2
    //   804: invokeinterface 372 3 0
    //   809: iconst_1
    //   810: istore 6
    //   812: goto -718 -> 94
    //   815: aload_2
    //   816: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   819: getstatic 375	com/tencent/mobileqq/msf/sdk/MsfCommand:resetCmdCallback	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   822: if_acmpne +27 -> 849
    //   825: aload_0
    //   826: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   829: ifnull +884 -> 1713
    //   832: aload_0
    //   833: getfield 47	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:pushHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IPushHandler;
    //   836: aload_1
    //   837: aload_2
    //   838: invokeinterface 378 3 0
    //   843: iconst_1
    //   844: istore 6
    //   846: goto -752 -> 94
    //   849: aload_2
    //   850: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   853: getstatic 381	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_queryMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   856: if_acmpne +89 -> 945
    //   859: aload_0
    //   860: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   863: ifnull +850 -> 1713
    //   866: iconst_0
    //   867: newarray byte
    //   869: astore 7
    //   871: aload_2
    //   872: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   875: ifeq +901 -> 1776
    //   878: aload_2
    //   879: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   882: ldc_w 387
    //   885: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   888: checkcast 336	java/lang/Integer
    //   891: invokevirtual 339	java/lang/Integer:intValue	()I
    //   894: istore_3
    //   895: aload_2
    //   896: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   899: ldc_w 389
    //   902: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   905: checkcast 391	[B
    //   908: checkcast 391	[B
    //   911: astore 8
    //   913: aload 8
    //   915: astore 7
    //   917: aload_0
    //   918: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   921: iload_3
    //   922: aload 7
    //   924: aload_1
    //   925: aload_2
    //   926: invokeinterface 395 5 0
    //   931: iconst_1
    //   932: istore 6
    //   934: goto -840 -> 94
    //   937: aload 8
    //   939: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   942: goto -25 -> 917
    //   945: aload_2
    //   946: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   949: getstatic 398	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitMobile	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   952: if_acmpne +118 -> 1070
    //   955: aload_0
    //   956: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   959: ifnull +754 -> 1713
    //   962: iconst_0
    //   963: newarray byte
    //   965: astore 9
    //   967: iconst_0
    //   968: newarray byte
    //   970: astore 8
    //   972: aload_2
    //   973: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   976: ifeq +787 -> 1763
    //   979: aload_2
    //   980: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   983: ldc_w 387
    //   986: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   989: checkcast 336	java/lang/Integer
    //   992: invokevirtual 339	java/lang/Integer:intValue	()I
    //   995: istore_3
    //   996: aload_2
    //   997: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1000: ldc_w 389
    //   1003: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1006: checkcast 391	[B
    //   1009: checkcast 391	[B
    //   1012: astore 7
    //   1014: aload_2
    //   1015: ldc_w 400
    //   1018: iconst_0
    //   1019: newarray byte
    //   1021: invokevirtual 403	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1024: checkcast 391	[B
    //   1027: checkcast 391	[B
    //   1030: astore 8
    //   1032: aload_0
    //   1033: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1036: iload_3
    //   1037: aload 7
    //   1039: aload 8
    //   1041: aload_1
    //   1042: aload_2
    //   1043: invokeinterface 407 6 0
    //   1048: iconst_1
    //   1049: istore 6
    //   1051: goto -957 -> 94
    //   1054: aload 7
    //   1056: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1059: aload 8
    //   1061: astore 7
    //   1063: aload 9
    //   1065: astore 8
    //   1067: goto -35 -> 1032
    //   1070: aload_2
    //   1071: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1074: getstatic 410	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_reSendSms	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1077: if_acmpne +132 -> 1209
    //   1080: aload_0
    //   1081: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1084: ifnull +629 -> 1713
    //   1087: iconst_0
    //   1088: newarray byte
    //   1090: astore 8
    //   1092: aload_2
    //   1093: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1096: ifeq +652 -> 1748
    //   1099: aload_2
    //   1100: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1103: ldc_w 387
    //   1106: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: checkcast 336	java/lang/Integer
    //   1112: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1115: istore 4
    //   1117: aload_2
    //   1118: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1121: ldc_w 389
    //   1124: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 391	[B
    //   1130: checkcast 391	[B
    //   1133: astore 7
    //   1135: aload_2
    //   1136: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1139: ldc_w 412
    //   1142: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1145: checkcast 336	java/lang/Integer
    //   1148: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1151: istore_3
    //   1152: aload_2
    //   1153: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1156: ldc_w 414
    //   1159: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1162: checkcast 336	java/lang/Integer
    //   1165: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1168: istore 5
    //   1170: aload_0
    //   1171: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1174: iload 4
    //   1176: aload 7
    //   1178: iload_3
    //   1179: iload 5
    //   1181: aload_1
    //   1182: aload_2
    //   1183: invokeinterface 418 7 0
    //   1188: iconst_1
    //   1189: istore 6
    //   1191: goto -1097 -> 94
    //   1194: aload 7
    //   1196: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1199: iconst_0
    //   1200: istore 5
    //   1202: aload 8
    //   1204: astore 7
    //   1206: goto -36 -> 1170
    //   1209: aload_2
    //   1210: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1213: getstatic 421	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitSmsCode	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1216: if_acmpne +66 -> 1282
    //   1219: aload_0
    //   1220: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1223: astore 7
    //   1225: aload 7
    //   1227: ifnull +486 -> 1713
    //   1230: aload_2
    //   1231: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1234: ifeq +573 -> 1807
    //   1237: aload_2
    //   1238: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1241: ldc_w 387
    //   1244: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1247: checkcast 336	java/lang/Integer
    //   1250: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1253: istore_3
    //   1254: aload_0
    //   1255: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1258: iload_3
    //   1259: aload_1
    //   1260: aload_2
    //   1261: invokeinterface 425 4 0
    //   1266: iconst_1
    //   1267: istore 6
    //   1269: goto -1175 -> 94
    //   1272: astore 7
    //   1274: aload 7
    //   1276: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1279: goto +528 -> 1807
    //   1282: aload_2
    //   1283: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1286: getstatic 428	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_commitPass	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1289: if_acmpne +115 -> 1404
    //   1292: aload_0
    //   1293: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1296: ifnull +417 -> 1713
    //   1299: ldc_w 430
    //   1302: astore 8
    //   1304: iconst_0
    //   1305: newarray byte
    //   1307: astore 9
    //   1309: aload_2
    //   1310: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1313: ifeq +421 -> 1734
    //   1316: aload_2
    //   1317: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1320: ldc_w 387
    //   1323: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1326: checkcast 336	java/lang/Integer
    //   1329: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1332: istore_3
    //   1333: aload_2
    //   1334: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1337: ldc_w 432
    //   1340: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1343: checkcast 161	java/lang/String
    //   1346: astore 7
    //   1348: aload_2
    //   1349: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1352: ldc_w 434
    //   1355: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: checkcast 391	[B
    //   1361: checkcast 391	[B
    //   1364: astore 8
    //   1366: aload_0
    //   1367: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1370: iload_3
    //   1371: aload 7
    //   1373: aload 8
    //   1375: aload_1
    //   1376: aload_2
    //   1377: invokeinterface 438 6 0
    //   1382: iconst_1
    //   1383: istore 6
    //   1385: goto -1291 -> 94
    //   1388: aload 7
    //   1390: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1393: aload 8
    //   1395: astore 7
    //   1397: aload 9
    //   1399: astore 8
    //   1401: goto -35 -> 1366
    //   1404: aload_2
    //   1405: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1408: getstatic 441	com/tencent/mobileqq/msf/sdk/MsfCommand:regUin_querySmsStat	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1411: if_acmpne +132 -> 1543
    //   1414: aload_0
    //   1415: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1418: ifnull +295 -> 1713
    //   1421: iconst_0
    //   1422: newarray byte
    //   1424: astore 8
    //   1426: aload_2
    //   1427: invokevirtual 257	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1430: ifeq +289 -> 1719
    //   1433: aload_2
    //   1434: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1437: ldc_w 387
    //   1440: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1443: checkcast 336	java/lang/Integer
    //   1446: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1449: istore 4
    //   1451: aload_2
    //   1452: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1455: ldc_w 389
    //   1458: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1461: checkcast 391	[B
    //   1464: checkcast 391	[B
    //   1467: astore 7
    //   1469: aload_2
    //   1470: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1473: ldc_w 412
    //   1476: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1479: checkcast 336	java/lang/Integer
    //   1482: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1485: istore_3
    //   1486: aload_2
    //   1487: getfield 385	com/tencent/qphone/base/remote/FromServiceMsg:attributes	Ljava/util/HashMap;
    //   1490: ldc_w 414
    //   1493: invokevirtual 122	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1496: checkcast 336	java/lang/Integer
    //   1499: invokevirtual 339	java/lang/Integer:intValue	()I
    //   1502: istore 5
    //   1504: aload_0
    //   1505: getfield 51	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:registerUinHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IRegisterUinHandler;
    //   1508: iload 4
    //   1510: aload 7
    //   1512: iload_3
    //   1513: iload 5
    //   1515: aload_1
    //   1516: aload_2
    //   1517: invokeinterface 444 7 0
    //   1522: iconst_1
    //   1523: istore 6
    //   1525: goto -1431 -> 94
    //   1528: aload 7
    //   1530: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1533: iconst_0
    //   1534: istore 5
    //   1536: aload 8
    //   1538: astore 7
    //   1540: goto -36 -> 1504
    //   1543: aload_2
    //   1544: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1547: getstatic 447	com/tencent/mobileqq/msf/sdk/MsfCommand:getKey	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1550: if_acmpne +163 -> 1713
    //   1553: aload_0
    //   1554: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   1557: astore 7
    //   1559: aload 7
    //   1561: ifnull +152 -> 1713
    //   1564: aload_0
    //   1565: getfield 31	com/tencent/mobileqq/msf/sdk/MsfRespHandleUtil:authHandler	Lcom/tencent/mobileqq/msf/sdk/handler/IAuthHandler;
    //   1568: aload_1
    //   1569: aload_2
    //   1570: invokeinterface 450 3 0
    //   1575: iconst_1
    //   1576: istore 6
    //   1578: goto -1484 -> 94
    //   1581: astore 7
    //   1583: aload 7
    //   1585: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1588: goto -13 -> 1575
    //   1591: iload 6
    //   1593: ireturn
    //   1594: astore 7
    //   1596: iconst_0
    //   1597: istore_3
    //   1598: goto -70 -> 1528
    //   1601: astore 8
    //   1603: iconst_0
    //   1604: istore_3
    //   1605: aload 7
    //   1607: astore 9
    //   1609: aload 8
    //   1611: astore 7
    //   1613: aload 9
    //   1615: astore 8
    //   1617: goto -89 -> 1528
    //   1620: astore 9
    //   1622: aload 7
    //   1624: astore 8
    //   1626: aload 9
    //   1628: astore 7
    //   1630: goto -102 -> 1528
    //   1633: astore 7
    //   1635: goto -247 -> 1388
    //   1638: astore 10
    //   1640: aload 7
    //   1642: astore 8
    //   1644: aload 10
    //   1646: astore 7
    //   1648: goto -260 -> 1388
    //   1651: astore 7
    //   1653: iconst_0
    //   1654: istore_3
    //   1655: goto -461 -> 1194
    //   1658: astore 8
    //   1660: iconst_0
    //   1661: istore_3
    //   1662: aload 7
    //   1664: astore 9
    //   1666: aload 8
    //   1668: astore 7
    //   1670: aload 9
    //   1672: astore 8
    //   1674: goto -480 -> 1194
    //   1677: astore 9
    //   1679: aload 7
    //   1681: astore 8
    //   1683: aload 9
    //   1685: astore 7
    //   1687: goto -493 -> 1194
    //   1690: astore 7
    //   1692: goto -638 -> 1054
    //   1695: astore 10
    //   1697: aload 7
    //   1699: astore 8
    //   1701: aload 10
    //   1703: astore 7
    //   1705: goto -651 -> 1054
    //   1708: astore 8
    //   1710: goto -773 -> 937
    //   1713: iconst_0
    //   1714: istore 6
    //   1716: goto -1622 -> 94
    //   1719: aload 8
    //   1721: astore 7
    //   1723: iconst_0
    //   1724: istore_3
    //   1725: iconst_0
    //   1726: istore 4
    //   1728: iconst_0
    //   1729: istore 5
    //   1731: goto -227 -> 1504
    //   1734: ldc_w 430
    //   1737: astore 7
    //   1739: aload 9
    //   1741: astore 8
    //   1743: iconst_0
    //   1744: istore_3
    //   1745: goto -379 -> 1366
    //   1748: aload 8
    //   1750: astore 7
    //   1752: iconst_0
    //   1753: istore_3
    //   1754: iconst_0
    //   1755: istore 4
    //   1757: iconst_0
    //   1758: istore 5
    //   1760: goto -590 -> 1170
    //   1763: aload 8
    //   1765: astore 7
    //   1767: aload 9
    //   1769: astore 8
    //   1771: iconst_0
    //   1772: istore_3
    //   1773: goto -741 -> 1032
    //   1776: iconst_0
    //   1777: istore_3
    //   1778: goto -861 -> 917
    //   1781: iconst_0
    //   1782: ireturn
    //   1783: astore 8
    //   1785: iconst_0
    //   1786: istore_3
    //   1787: goto -850 -> 937
    //   1790: astore 7
    //   1792: iconst_0
    //   1793: istore_3
    //   1794: goto -740 -> 1054
    //   1797: astore 7
    //   1799: iconst_0
    //   1800: istore_3
    //   1801: iconst_0
    //   1802: istore 4
    //   1804: goto -610 -> 1194
    //   1807: iconst_0
    //   1808: istore_3
    //   1809: goto -555 -> 1254
    //   1812: astore 7
    //   1814: iconst_0
    //   1815: istore_3
    //   1816: goto -428 -> 1388
    //   1819: astore 7
    //   1821: iconst_0
    //   1822: istore_3
    //   1823: iconst_0
    //   1824: istore 4
    //   1826: goto -298 -> 1528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1829	0	this	MsfRespHandleUtil
    //   0	1829	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	1829	2	paramFromServiceMsg	FromServiceMsg
    //   4	1819	3	i	int
    //   9	1816	4	j	int
    //   1168	591	5	k	int
    //   92	1623	6	bool	boolean
    //   206	68	7	localObject1	Object
    //   288	3	7	localException1	Exception
    //   297	370	7	localObject2	Object
    //   681	19	7	localException2	Exception
    //   869	357	7	localObject3	Object
    //   1272	3	7	localException3	Exception
    //   1346	214	7	localObject4	Object
    //   1581	3	7	localException4	Exception
    //   1594	12	7	localException5	Exception
    //   1611	18	7	localException6	Exception
    //   1633	8	7	localException7	Exception
    //   1646	1	7	localObject5	Object
    //   1651	12	7	localException8	Exception
    //   1668	18	7	localException9	Exception
    //   1690	8	7	localException10	Exception
    //   1703	63	7	localObject6	Object
    //   1790	1	7	localException11	Exception
    //   1797	1	7	localException12	Exception
    //   1812	1	7	localException13	Exception
    //   1819	1	7	localException14	Exception
    //   196	1341	8	localObject7	Object
    //   1601	9	8	localException15	Exception
    //   1615	28	8	localObject8	Object
    //   1658	9	8	localException16	Exception
    //   1672	28	8	localObject9	Object
    //   1708	12	8	localException17	Exception
    //   1741	29	8	localException18	Exception
    //   1783	1	8	localException19	Exception
    //   15	1599	9	localObject10	Object
    //   1620	7	9	localException20	Exception
    //   1664	7	9	localObject11	Object
    //   1677	91	9	localException21	Exception
    //   227	18	10	localUniPacket	com.qq.jce.wup.UniPacket
    //   1638	7	10	localException22	Exception
    //   1695	7	10	localException23	Exception
    // Exception table:
    //   from	to	target	type
    //   213	264	288	java/lang/Exception
    //   0	48	302	java/lang/Exception
    //   48	68	302	java/lang/Exception
    //   68	91	302	java/lang/Exception
    //   99	117	302	java/lang/Exception
    //   119	139	302	java/lang/Exception
    //   139	162	302	java/lang/Exception
    //   168	188	302	java/lang/Exception
    //   188	195	302	java/lang/Exception
    //   198	204	302	java/lang/Exception
    //   264	282	302	java/lang/Exception
    //   290	295	302	java/lang/Exception
    //   332	365	302	java/lang/Exception
    //   371	404	302	java/lang/Exception
    //   410	443	302	java/lang/Exception
    //   449	482	302	java/lang/Exception
    //   488	521	302	java/lang/Exception
    //   527	563	302	java/lang/Exception
    //   569	602	302	java/lang/Exception
    //   608	624	302	java/lang/Exception
    //   683	710	302	java/lang/Exception
    //   713	741	302	java/lang/Exception
    //   747	775	302	java/lang/Exception
    //   781	809	302	java/lang/Exception
    //   815	843	302	java/lang/Exception
    //   849	871	302	java/lang/Exception
    //   917	931	302	java/lang/Exception
    //   937	942	302	java/lang/Exception
    //   945	972	302	java/lang/Exception
    //   1032	1048	302	java/lang/Exception
    //   1054	1059	302	java/lang/Exception
    //   1070	1092	302	java/lang/Exception
    //   1170	1188	302	java/lang/Exception
    //   1194	1199	302	java/lang/Exception
    //   1209	1225	302	java/lang/Exception
    //   1254	1266	302	java/lang/Exception
    //   1274	1279	302	java/lang/Exception
    //   1282	1299	302	java/lang/Exception
    //   1304	1309	302	java/lang/Exception
    //   1366	1382	302	java/lang/Exception
    //   1388	1393	302	java/lang/Exception
    //   1404	1426	302	java/lang/Exception
    //   1504	1522	302	java/lang/Exception
    //   1528	1533	302	java/lang/Exception
    //   1543	1559	302	java/lang/Exception
    //   1583	1588	302	java/lang/Exception
    //   629	675	681	java/lang/Exception
    //   1230	1254	1272	java/lang/Exception
    //   1564	1575	1581	java/lang/Exception
    //   1451	1469	1594	java/lang/Exception
    //   1469	1486	1601	java/lang/Exception
    //   1486	1504	1620	java/lang/Exception
    //   1333	1348	1633	java/lang/Exception
    //   1348	1366	1638	java/lang/Exception
    //   1117	1135	1651	java/lang/Exception
    //   1135	1152	1658	java/lang/Exception
    //   1152	1170	1677	java/lang/Exception
    //   996	1014	1690	java/lang/Exception
    //   1014	1032	1695	java/lang/Exception
    //   895	913	1708	java/lang/Exception
    //   871	895	1783	java/lang/Exception
    //   972	996	1790	java/lang/Exception
    //   1092	1117	1797	java/lang/Exception
    //   1309	1333	1812	java/lang/Exception
    //   1426	1451	1819	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil
 * JD-Core Version:    0.7.0.1
 */