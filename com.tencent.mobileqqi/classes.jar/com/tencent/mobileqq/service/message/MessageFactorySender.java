package com.tencent.mobileqq.service.message;

import AccostSvc.ClientMsg;
import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.ReqDeleteBlackList;
import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqInsertBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespSvrMsg;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.PullGroupSeqParam;
import MessageSvcPack.SvcDelMsgInfo;
import MessageSvcPack.SvcRequestBatchGetGroupOfflineMsgNum;
import MessageSvcPack.SvcRequestDelMsgV2;
import MessageSvcPack.SvcRequestDelRoamMsg;
import MessageSvcPack.SvcRequestGroupMsgReadConfirm;
import MessageSvcPack.SvcRequestMsgReadedReport;
import MessageSvcPack.SvcRequestPullGroupMsgSeq;
import MessageSvcPack.SvcRequestSendVideoMsg;
import MessageSvcPack.SvcRequestSetConfMsgRead;
import MessageSvcPack.SvcRequestSetRoamMsg;
import MessageSvcPack.SvcRequestSetRoamMsgAllUser;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.SvcRespPushMsg;
import QQService.CSRespPushStreamMsg;
import QQService.CSUploadStreamMsg;
import QQService.FileDeleteReq;
import QQService.FileDownloadReq;
import QQService.FileUploadReq;
import QQService.ReqGetSign;
import QQService.ReqOffFilePack;
import QQService.ReqTmpChatPicDownload;
import QQService.StreamData;
import QQService.StreamInfo;
import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import android.os.RemoteException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RoamInfoListWrapper;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageFactorySender
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "MessageFactorySender";
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  private boolean A(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    FileDownloadReq localFileDownloadReq = new FileDownloadReq();
    paramToServiceMsg = paramToServiceMsg.extraData;
    localFileDownloadReq.lFromUIN = paramToServiceMsg.getLong("CMD_PARAM_DOWNLOAD_LFROMUIN");
    localFileDownloadReq.lToUIN = paramToServiceMsg.getLong("CMD_PARAM_DOWNLOAD_LTOUIN");
    localFileDownloadReq.cType = paramToServiceMsg.getByte("CMD_PARAM_DOWNLOAD_CTYPE");
    localFileDownloadReq.cVer = 1;
    localFileDownloadReq.strFilePath = paramToServiceMsg.getString("CMD_PARAM_DOWNLOAD_FILEPATH");
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("FileDownloadReq");
    paramUniPacket.put("FileDownloadReq", localFileDownloadReq);
    return true;
  }
  
  private boolean B(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    FileDeleteReq localFileDeleteReq = new FileDeleteReq();
    paramToServiceMsg = paramToServiceMsg.extraData;
    localFileDeleteReq.lFromUIN = paramToServiceMsg.getLong("CMD_PARAM_DELETE_LFROMUIN");
    localFileDeleteReq.lToUIN = paramToServiceMsg.getLong("CMD_PARAM_DELETE_LTOUIN");
    localFileDeleteReq.cType = paramToServiceMsg.getByte("CMD_PARAM_DELETE_CTYPE");
    localFileDeleteReq.cVer = 1;
    localFileDeleteReq.strFilePath = paramToServiceMsg.getString("CMD_PARAM_DELETE_FILEPATH");
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("FileDeleteReq");
    paramUniPacket.put("FileDeleteReq", localFileDeleteReq);
    return true;
  }
  
  public static long a(long paramLong)
  {
    return 0L | paramLong;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setMsgFail();
    try
    {
      paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("OnlinePush");
    paramUniPacket.setFuncName("SvcRespPushMsg");
    paramUniPacket.setRequestId(paramToServiceMsg.extraData.getInt("seq"));
    SvcRespPushMsg localSvcRespPushMsg = new SvcRespPushMsg();
    localSvcRespPushMsg.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcRespPushMsg.svrip = paramToServiceMsg.extraData.getInt("svrip");
    if (localSvcRespPushMsg.lUin < 10000L) {
      return false;
    }
    if (paramToServiceMsg.extraData.getSerializable("delMsgInfos") != null)
    {
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("delMsgInfos");
      localSvcRespPushMsg.vDelInfos = paramToServiceMsg;
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        DelMsgInfo localDelMsgInfo = (DelMsgInfo)paramToServiceMsg.next();
        if (QLog.isColorLevel()) {
          QLog.d("MessageHandler", 2, "createC2COnlinePushBuff uin: " + localDelMsgInfo.lFromUin + " seq: " + localDelMsgInfo.shMsgSeq);
        }
        if ((localDelMsgInfo.vMsgCookies != null) && (QLog.isColorLevel())) {
          QLog.d("MessageHandler", 2, "createC2COnlinePushBuff Cookies: " + HexUtil.bytes2HexStr(localDelMsgInfo.vMsgCookies));
        }
      }
    }
    paramUniPacket.put("resp", localSvcRespPushMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int j = 0;
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("DelMsgV2");
    SvcRequestDelMsgV2 localSvcRequestDelMsgV2 = new SvcRequestDelMsgV2();
    localSvcRequestDelMsgV2.lUin = Long.parseLong(paramToServiceMsg.getUin());
    localSvcRequestDelMsgV2.vDelInfos = new ArrayList();
    localSvcRequestDelMsgV2.vAccostMsg = new ArrayList();
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("fromUin");
    Object localObject1 = paramToServiceMsg.extraData.getIntArray("msgTime");
    Object localObject2 = paramToServiceMsg.extraData.getShortArray("msgSeq");
    int i;
    Object localObject3;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      while (i < arrayOfLong.length)
      {
        localObject3 = new SvcDelMsgInfo();
        ((SvcDelMsgInfo)localObject3).lFromUin = arrayOfLong[i];
        ((SvcDelMsgInfo)localObject3).uMsgTime = localObject1[i];
        ((SvcDelMsgInfo)localObject3).shMsgSeq = localObject2[i];
        localSvcRequestDelMsgV2.vDelInfos.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createDelMessageBuff i: " + i + " fromUin:" + arrayOfLong[i] + " msgTime: " + localObject1[i] + " msgSeq:" + localObject2[i]);
        }
        i += 1;
      }
    }
    arrayOfLong = paramToServiceMsg.extraData.getLongArray("accostFromUin");
    localObject1 = paramToServiceMsg.extraData.getLongArray("accostToUin");
    localObject2 = paramToServiceMsg.extraData.getLongArray("accostMsgId");
    paramToServiceMsg = paramToServiceMsg.extraData.getShortArray("accostMsgType");
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = j;
      while (i < arrayOfLong.length)
      {
        localObject3 = new AccostMsg();
        ((AccostMsg)localObject3).lFromMID = arrayOfLong[i];
        ((AccostMsg)localObject3).lToMID = localObject1[i];
        ((AccostMsg)localObject3).uMsgID = localObject2[i];
        ((AccostMsg)localObject3).shMsgType = paramToServiceMsg[i];
        ((AccostMsg)localObject3).strMsg = new byte[1];
        localSvcRequestDelMsgV2.vAccostMsg.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createDelMessageBuff i: " + i + " accostFromUin:" + arrayOfLong[i] + " accostMsgId: " + localObject2[i] + " accostMsgType:" + paramToServiceMsg[i]);
        }
        i += 1;
      }
    }
    paramUniPacket.put("req_DelMsgV2", localSvcRequestDelMsgV2);
    return true;
  }
  
  /* Error */
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ldc_w 266
    //   9: invokevirtual 81	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc_w 351
    //   16: invokevirtual 86	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   19: new 353	MessageSvcPack/SvcRequestGetMsgV2
    //   22: dup
    //   23: invokespecial 354	MessageSvcPack/SvcRequestGetMsgV2:<init>	()V
    //   26: astore 10
    //   28: aload 10
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 133	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   35: invokespecial 356	com/tencent/mobileqq/service/message/MessageFactorySender:a	(Ljava/lang/String;)J
    //   38: putfield 357	MessageSvcPack/SvcRequestGetMsgV2:lUin	J
    //   41: aload 10
    //   43: getfield 357	MessageSvcPack/SvcRequestGetMsgV2:lUin	J
    //   46: lstore 8
    //   48: lload 8
    //   50: lconst_0
    //   51: lcmp
    //   52: ifne +8 -> 60
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 7
    //   59: ireturn
    //   60: aload_1
    //   61: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   64: ldc_w 359
    //   67: invokevirtual 163	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   70: istore 5
    //   72: aload_1
    //   73: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   76: ldc_w 361
    //   79: invokevirtual 56	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   82: istore_3
    //   83: aload_1
    //   84: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   87: ldc_w 363
    //   90: invokevirtual 367	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   93: astore 11
    //   95: aload_1
    //   96: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   99: ldc_w 369
    //   102: invokevirtual 163	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   105: istore 6
    //   107: aload_1
    //   108: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   111: ldc_w 371
    //   114: invokevirtual 56	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   117: istore 4
    //   119: aload_1
    //   120: getfield 33	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   123: ldc_w 373
    //   126: invokevirtual 367	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   129: astore_1
    //   130: aload 10
    //   132: iload 5
    //   134: putfield 376	MessageSvcPack/SvcRequestGetMsgV2:uDateTime	I
    //   137: aload 10
    //   139: iconst_1
    //   140: putfield 379	MessageSvcPack/SvcRequestGetMsgV2:cMsgStoreType	B
    //   143: aload 10
    //   145: iconst_1
    //   146: putfield 382	MessageSvcPack/SvcRequestGetMsgV2:cRecivePic	B
    //   149: aload 10
    //   151: bipush 15
    //   153: putfield 385	MessageSvcPack/SvcRequestGetMsgV2:shAbility	S
    //   156: aload 10
    //   158: iload_3
    //   159: putfield 387	MessageSvcPack/SvcRequestGetMsgV2:cChannel	B
    //   162: aload 10
    //   164: aload 11
    //   166: putfield 389	MessageSvcPack/SvcRequestGetMsgV2:vCookies	[B
    //   169: aload 10
    //   171: iconst_0
    //   172: putfield 392	MessageSvcPack/SvcRequestGetMsgV2:cUnFilter	B
    //   175: aload 10
    //   177: iload 6
    //   179: putfield 394	MessageSvcPack/SvcRequestGetMsgV2:cSyncFlag	I
    //   182: aload 10
    //   184: bipush 20
    //   186: putfield 397	MessageSvcPack/SvcRequestGetMsgV2:shLatestRambleNumber	S
    //   189: aload 10
    //   191: iconst_3
    //   192: putfield 400	MessageSvcPack/SvcRequestGetMsgV2:shOtherRambleNumber	S
    //   195: aload 10
    //   197: iconst_1
    //   198: putfield 403	MessageSvcPack/SvcRequestGetMsgV2:cChannelEx	B
    //   201: aload 10
    //   203: aload_1
    //   204: putfield 405	MessageSvcPack/SvcRequestGetMsgV2:vSyncCookie	[B
    //   207: aload 10
    //   209: iconst_0
    //   210: putfield 408	MessageSvcPack/SvcRequestGetMsgV2:cRambleFlag	B
    //   213: aload 10
    //   215: iconst_0
    //   216: putfield 392	MessageSvcPack/SvcRequestGetMsgV2:cUnFilter	B
    //   219: aload 10
    //   221: iconst_0
    //   222: putfield 411	MessageSvcPack/SvcRequestGetMsgV2:cInst	B
    //   225: aload 10
    //   227: iload 4
    //   229: putfield 414	MessageSvcPack/SvcRequestGetMsgV2:cOnlineSyncFlag	B
    //   232: aload 10
    //   234: iconst_1
    //   235: putfield 417	MessageSvcPack/SvcRequestGetMsgV2:cContextFlag	B
    //   238: aload 10
    //   240: lconst_1
    //   241: putfield 420	MessageSvcPack/SvcRequestGetMsgV2:lGeneralAbi	J
    //   244: aload_2
    //   245: ldc_w 422
    //   248: aload 10
    //   250: invokevirtual 90	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   253: iconst_1
    //   254: istore 7
    //   256: goto -201 -> 55
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	MessageFactorySender
    //   0	264	1	paramToServiceMsg	ToServiceMsg
    //   0	264	2	paramUniPacket	UniPacket
    //   82	77	3	b1	byte
    //   117	111	4	b2	byte
    //   70	63	5	i	int
    //   105	73	6	j	int
    //   1	254	7	bool	boolean
    //   46	3	8	l	long
    //   26	223	10	localSvcRequestGetMsgV2	MessageSvcPack.SvcRequestGetMsgV2
    //   93	72	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	48	259	finally
    //   60	253	259	finally
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("GroupMsgReadConfirm");
    SvcRequestGroupMsgReadConfirm localSvcRequestGroupMsgReadConfirm = new SvcRequestGroupMsgReadConfirm();
    localSvcRequestGroupMsgReadConfirm.uGroupCode = paramToServiceMsg.extraData.getLong("groupuin");
    localSvcRequestGroupMsgReadConfirm.uLastReadSeq = paramToServiceMsg.extraData.getLong("lastReadSeq");
    paramUniPacket.put("req_GroupMsgReadConfirm", localSvcRequestGroupMsgReadConfirm);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("DisMsgReadConfirm");
    SvcRequestSetConfMsgRead localSvcRequestSetConfMsgRead = new SvcRequestSetConfMsgRead();
    localSvcRequestSetConfMsgRead.lConfUin = paramToServiceMsg.extraData.getLong("groupuin");
    localSvcRequestSetConfMsgRead.lLastReadSeq = paramToServiceMsg.extraData.getLong("lastReadSeq");
    paramUniPacket.put("req_DisMsgReadConfirm", localSvcRequestSetConfMsgRead);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("MsgReadedReport");
    SvcRequestMsgReadedReport localSvcRequestMsgReadedReport = new SvcRequestMsgReadedReport();
    if (paramToServiceMsg.extraData.getSerializable("vMsgKey") != null) {
      localSvcRequestMsgReadedReport.vMsgKey = ((ArrayList)paramToServiceMsg.extraData.getSerializable("vMsgKey"));
    }
    localSvcRequestMsgReadedReport.vSyncCookie = paramToServiceMsg.extraData.getByteArray("vSyncCookie");
    localSvcRequestMsgReadedReport.bPbReadedReport = paramToServiceMsg.extraData.getBoolean("bPbReadedReport");
    paramUniPacket.put("req_MsgReadedReport", localSvcRequestMsgReadedReport);
    return true;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("GetGroupUnRead");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestBatchGetGroupOfflineMsgNum localSvcRequestBatchGetGroupOfflineMsgNum = new SvcRequestBatchGetGroupOfflineMsgNum();
    localSvcRequestBatchGetGroupOfflineMsgNum.vGroupCode = new ArrayList();
    localSvcRequestBatchGetGroupOfflineMsgNum.lUin = a(paramToServiceMsg.getUin());
    if (localSvcRequestBatchGetGroupOfflineMsgNum.lUin == 0L) {
      return false;
    }
    paramToServiceMsg = localBundle.getStringArray("array_groupuin");
    int i = 0;
    for (;;)
    {
      if (i >= paramToServiceMsg.length) {
        break label120;
      }
      long l = a(paramToServiceMsg[i]);
      if (l == 0L) {
        break;
      }
      localSvcRequestBatchGetGroupOfflineMsgNum.vGroupCode.add(Long.valueOf(l));
      i += 1;
    }
    label120:
    paramUniPacket.put("req_GetGroupUnRead", localSvcRequestBatchGetGroupOfflineMsgNum);
    return true;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = (SvrMsg)paramToServiceMsg.extraData.getSerializable("SvrMsg");
    paramToServiceMsg = new RespSvrMsg(new RespHeader(paramToServiceMsg.stHeader.shVersion, paramToServiceMsg.stHeader.lMID, 0, ""), paramToServiceMsg.stMsg);
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_SVR_Msg");
    paramUniPacket.put("RespSvrMsg", paramToServiceMsg);
    return true;
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a;
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    if (l < 0L) {
      return false;
    }
    localObject = new ReqGetBlackList((AccostSvc.ReqHeader)localObject, l, 1, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_GET_BlackList");
    paramUniPacket.put("ReqGetBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a;
    String str = paramToServiceMsg.extraData.getString("deleteUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqDeleteBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_DELETE_BlackList");
    paramUniPacket.put("ReqDeleteBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a;
    String str = paramToServiceMsg.extraData.getString("insertUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqInsertBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_INSERT_BlackList");
    paramUniPacket.put("ReqInsertBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    AccostSvc.ReqHeader localReqHeader = new AccostSvc.ReqHeader();
    localReqHeader.shVersion = 0;
    localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    localReqHeader.iAppID = AppSetting.a;
    long l1 = paramToServiceMsg.extraData.getLong("to");
    Object localObject2 = paramToServiceMsg.extraData.getString("msg");
    boolean bool = paramToServiceMsg.extraData.getBoolean("hello");
    byte b = paramToServiceMsg.extraData.getByte("cType");
    Object localObject1 = paramToServiceMsg.extraData.getString("pyNickname");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      long l3;
      long l4;
      int j;
      if (b == 18)
      {
        localObject2 = ((String)localObject2).getBytes();
        l3 = paramToServiceMsg.extraData.getLong("timeOut");
        Object localObject3 = new MsgItem(b, (byte[])localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject3);
        localObject3 = new UserInfo();
        ((UserInfo)localObject3).nickname = ((String)localObject1);
        localObject1 = new RichMsg((ArrayList)localObject2, "", (UserInfo)localObject3, 0);
        l4 = Long.valueOf(paramToServiceMsg.getUin()).longValue();
        j = (int)(System.currentTimeMillis() / 1000L);
        if (!bool) {
          break label314;
        }
      }
      label314:
      for (int i = 1;; i = 2)
      {
        localObject1 = new ClientMsg(localReqHeader, new Msg((short)5, l2, l4, l1, j, i, ((RichMsg)localObject1).toByteArray(), 0L, 0L));
        paramUniPacket.setServantName("AccostObj");
        paramUniPacket.setFuncName("CMD_CLT_Msg");
        paramUniPacket.put("ClientMsg", localObject1);
        paramToServiceMsg.setTimeout(l3);
        return true;
        localObject2 = MessageUtils.a((String)localObject2);
        break;
      }
    }
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VideoSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = a(paramToServiceMsg.getUin());
    localVideoCallMsg.lPeerUin = localBundle.getLong("toUin");
    localVideoCallMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localVideoCallMsg.cVerifyType = 0;
    localVideoCallMsg.uSeqId = 0;
    localVideoCallMsg.uSessionId = 0;
    localVideoCallMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("VideoCallMsg", localVideoCallMsg);
    return true;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MultiVideo");
    paramUniPacket.setFuncName("MultiVideos2cack");
    paramToServiceMsg = paramToServiceMsg.extraData;
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = paramToServiceMsg.getByte("ver");
    localMultiVideoMsg.type = paramToServiceMsg.getByte("type");
    localMultiVideoMsg.csCmd = paramToServiceMsg.getShort("cscmd");
    localMultiVideoMsg.subCmd = paramToServiceMsg.getShort("subcmd");
    localMultiVideoMsg.from_uin = a(String.valueOf(paramToServiceMsg.getLong("from_uin")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramToServiceMsg.getLong("to_uin")));
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.msg_time = paramToServiceMsg.getLong("msg_time");
    localMultiVideoMsg.msg_type = paramToServiceMsg.getLong("msg_type");
    localMultiVideoMsg.msg_seq = paramToServiceMsg.getLong("msg_seq");
    localMultiVideoMsg.msg_uid = paramToServiceMsg.getLong("msg_uid");
    localMultiVideoMsg.video_buff = paramToServiceMsg.getByteArray("video_buff");
    paramUniPacket.put("MultiVideoMsg", localMultiVideoMsg);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSendVideoMsg localSvcRequestSendVideoMsg = new SvcRequestSendVideoMsg();
    localSvcRequestSendVideoMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSendVideoMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestSendVideoMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localSvcRequestSendVideoMsg.cVerifyType = localBundle.getByte("cVerifyType");
    localSvcRequestSendVideoMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("req_SendVideoMsg", localSvcRequestSendVideoMsg);
    paramToServiceMsg = "null";
    if (localSvcRequestSendVideoMsg.vMsg != null) {
      paramToServiceMsg = String.valueOf(localSvcRequestSendVideoMsg.vMsg[2]);
    }
    ReportLog.a("Video", "Send video message :selfUin = " + localSvcRequestSendVideoMsg.lUin + " " + "toUin = " + localSvcRequestSendVideoMsg.lPeerUin + " " + "buffer[2] = " + paramToServiceMsg);
    return true;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqOffFilePack");
    Bundle localBundle = paramToServiceMsg.extraData;
    int k = localBundle.getInt("offfile_type");
    ReqOffFilePack localReqOffFilePack = new ReqOffFilePack();
    localReqOffFilePack.lUIN = a(paramToServiceMsg.getUin());
    paramToServiceMsg = localBundle.getByteArray("filepath");
    int j;
    long l;
    if (paramToServiceMsg == null)
    {
      j = 0;
      l = a(localBundle.getString("uin"));
    }
    int i;
    switch (k)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        paramUniPacket.put("ReqOffFilePack", localReqOffFilePack);
        return true;
        j = paramToServiceMsg.length;
        break;
        if (paramToServiceMsg != null)
        {
          localReqOffFilePack.vBody = new byte[10 + j];
          localReqOffFilePack.vBody[0] = 3;
          localReqOffFilePack.vBody[1] = 6;
          PkgTools.a(localReqOffFilePack.vBody, 2, (short)0);
          PkgTools.a(localReqOffFilePack.vBody, 4, (short)0);
          PkgTools.a(localReqOffFilePack.vBody, 6, (short)1);
          PkgTools.a(localReqOffFilePack.vBody, 8, (short)j);
          PkgTools.a(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
          continue;
          localReqOffFilePack.vBody = new byte[13];
          localReqOffFilePack.vBody[0] = 6;
          PkgTools.a(localReqOffFilePack.vBody, 1, l);
          PkgTools.a(localReqOffFilePack.vBody, 5, 0L);
          PkgTools.a(localReqOffFilePack.vBody, 9, 0L);
        }
      }
    case 2: 
      i = localBundle.getByte("result");
      if (paramToServiceMsg == null) {
        break;
      }
    }
    for (k = 8 + j;; k = 8)
    {
      localReqOffFilePack.vBody = new byte[k];
      localReqOffFilePack.vBody[0] = 2;
      localReqOffFilePack.vBody[1] = i;
      PkgTools.a(localReqOffFilePack.vBody, 2, l);
      PkgTools.a(localReqOffFilePack.vBody, 6, (short)j);
      PkgTools.a(localReqOffFilePack.vBody, 8, paramToServiceMsg, j);
      break;
      localBundle.getInt("vip_level");
      byte[] arrayOfByte1 = localBundle.getByteArray("sig");
      l = localBundle.getLong("filesize");
      byte[] arrayOfByte2 = localBundle.getByteArray("filemd5");
      localReqOffFilePack.vBody = a(arrayOfByte1, paramToServiceMsg, localBundle.getByteArray("filename"), arrayOfByte2, l);
      break;
      if (paramToServiceMsg == null) {
        break;
      }
      localReqOffFilePack.vBody = new byte[10 + j];
      localReqOffFilePack.vBody[0] = 3;
      localReqOffFilePack.vBody[1] = 6;
      PkgTools.a(localReqOffFilePack.vBody, 2, (short)0);
      PkgTools.a(localReqOffFilePack.vBody, 4, (short)0);
      PkgTools.a(localReqOffFilePack.vBody, 6, (short)1);
      PkgTools.a(localReqOffFilePack.vBody, 8, (short)j);
      PkgTools.a(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
      break;
    }
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqGetSign");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqGetSign localReqGetSign = new ReqGetSign();
    localReqGetSign.lUIN = a(paramToServiceMsg.getUin());
    localReqGetSign.uSSOVer = localBundle.getInt("ssover");
    localReqGetSign.uAppID = localBundle.getInt("app_id");
    localReqGetSign.cA2Type = localBundle.getByte("a2type");
    localReqGetSign.vA2 = new byte[0];
    localReqGetSign.vCiphertext = localBundle.getByteArray("enkey");
    paramUniPacket.put("ReqGetSign", localReqGetSign);
    return true;
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqTmpChatPicDownload");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqTmpChatPicDownload localReqTmpChatPicDownload = new ReqTmpChatPicDownload();
    localReqTmpChatPicDownload.lUIN = a(paramToServiceMsg.getUin());
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    localReqTmpChatPicDownload.lSeq = i;
    localReqTmpChatPicDownload.strFlieKey = localBundle.getString("filekey");
    localReqTmpChatPicDownload.getPicSize = localBundle.getByte("picscale");
    paramUniPacket.put("ReqTmpChatPicDownload", localReqTmpChatPicDownload);
    return true;
  }
  
  private boolean t(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.SetRoamMsgAllUser");
    paramUniPacket.setFuncName("SetRoamMsgAllUser");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSetRoamMsgAllUser localSvcRequestSetRoamMsgAllUser = new SvcRequestSetRoamMsgAllUser();
    localSvcRequestSetRoamMsgAllUser.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSetRoamMsgAllUser.shType = localBundle.getShort("shType");
    localSvcRequestSetRoamMsgAllUser.cValue = localBundle.getByte("cValue");
    localSvcRequestSetRoamMsgAllUser.cVerifyType = 0;
    paramUniPacket.put("req_SetRoamMsgAllUser", localSvcRequestSetRoamMsgAllUser);
    return true;
  }
  
  private boolean u(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.SetRoamMsg");
    paramUniPacket.setFuncName("SetRoamMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSetRoamMsg localSvcRequestSetRoamMsg = new SvcRequestSetRoamMsg();
    localSvcRequestSetRoamMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSetRoamMsg.shType = localBundle.getShort("shType");
    localSvcRequestSetRoamMsg.vRoamInfo = ((RoamInfoListWrapper)localBundle.getParcelable("roamInfo")).a();
    localSvcRequestSetRoamMsg.cVerifyType = 0;
    paramUniPacket.put("req_SetRoamMsgAllUser", localSvcRequestSetRoamMsg);
    return true;
  }
  
  private boolean v(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.DelRoamMsg");
    paramUniPacket.setFuncName("DelRoamMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestDelRoamMsg localSvcRequestDelRoamMsg = new SvcRequestDelRoamMsg();
    localSvcRequestDelRoamMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestDelRoamMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestDelRoamMsg.cVerifyType = 0;
    paramUniPacket.put("req_DelRoamMsg", localSvcRequestDelRoamMsg);
    return true;
  }
  
  private boolean w(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSUploadStreamMsgBuf");
    long l1 = b(Long.valueOf(paramToServiceMsg.extraData.getString("uin")).longValue());
    String str1 = paramToServiceMsg.extraData.getString("filepath");
    Object localObject = paramToServiceMsg.extraData.getString("selfuin");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    int i = paramToServiceMsg.extraData.getInt("msgseq");
    long l2 = paramToServiceMsg.extraData.getLong("random");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a((String)localObject);
    paramToServiceMsg.lToUIN = a(str2);
    paramToServiceMsg.iMsgId = StreamDataManager.c(str1);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = StreamDataManager.b(str1);
    paramToServiceMsg.shFlowLayer = StreamDataManager.a(str1);
    localObject = new StreamData();
    ((StreamData)localObject).shPackSeq = localShort.shortValue();
    if (((StreamData)localObject).shPackSeq < paramToServiceMsg.shPackNum) {
      paramToServiceMsg.shPackNum = 0;
    }
    ((StreamData)localObject).vData = StreamDataManager.a(str1, localShort.shortValue());
    boolean bool = StreamDataManager.b(str1);
    if (bool)
    {
      paramToServiceMsg.shPackNum = 0;
      paramToServiceMsg.oprType = 1;
      StreamDataManager.a(str1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("StreamPtt", 2, "shPackSeq:" + localShort + " shPackNum:" + paramToServiceMsg.shPackNum + ",layer:" + paramToServiceMsg.shFlowLayer + ",msgId:" + paramToServiceMsg.iMsgId + " cancelled:" + bool);
    }
    new QQService.ReqHeader((short)0, paramUniPacket.getRequestId(), l1);
    if ((i != 0) || (l2 != 0L))
    {
      paramToServiceMsg.msgSeq = i;
      paramToServiceMsg.random = l2;
      paramUniPacket.put("CSUploadStreamMsg", new CSUploadStreamMsg((short)10, paramUniPacket.getRequestId(), paramToServiceMsg, (StreamData)localObject, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet()));
    }
    for (;;)
    {
      return true;
      paramUniPacket.put("CSUploadStreamMsg", new CSUploadStreamMsg((short)1, paramUniPacket.getRequestId(), paramToServiceMsg, (StreamData)localObject, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet()));
    }
  }
  
  private boolean x(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSRespPushStreamMsgBuf");
    String str1 = paramToServiceMsg.extraData.getString("filepath");
    String str2 = paramToServiceMsg.extraData.getString("selfuin");
    String str3 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    long l = paramToServiceMsg.extraData.getLong("lkey");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a(str3);
    paramToServiceMsg.lToUIN = a(str2);
    paramToServiceMsg.iMsgId = StreamDataManager.c(str1);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = 0;
    paramToServiceMsg.shFlowLayer = StreamDataManager.a(str1);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "createReqpushStreamMsg ---streaminfo.lFromUIN= " + paramToServiceMsg.lFromUIN + "---streaminfo.shFlowLayer = " + paramToServiceMsg.shFlowLayer + "---streaminfo.lToUIN = " + paramToServiceMsg.lToUIN + "---streaminfo.iMsgId = " + paramToServiceMsg.iMsgId + "---PackSeq = " + localShort + "---lKey = " + l);
    }
    paramUniPacket.put("CSRespPushStreamMsg", new CSRespPushStreamMsg((short)1, paramUniPacket.getRequestId(), paramToServiceMsg, localShort.shortValue(), l));
    return true;
  }
  
  private boolean y(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("PullGroupMsgSeq");
    SvcRequestPullGroupMsgSeq localSvcRequestPullGroupMsgSeq = new SvcRequestPullGroupMsgSeq();
    localSvcRequestPullGroupMsgSeq.setFilter(1);
    localSvcRequestPullGroupMsgSeq.vGroupInfo = new ArrayList();
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("array_groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("lastSeqAry");
    int i = 0;
    while (i < arrayOfString.length)
    {
      PullGroupSeqParam localPullGroupSeqParam = new PullGroupSeqParam();
      localPullGroupSeqParam.lGroupCode = Long.valueOf(arrayOfString[i]).longValue();
      localPullGroupSeqParam.lLastSeqId = paramToServiceMsg[i];
      localSvcRequestPullGroupMsgSeq.vGroupInfo.add(localPullGroupSeqParam);
      i += 1;
    }
    paramUniPacket.put("req_PullGroupMsgSeq", localSvcRequestPullGroupMsgSeq);
    return true;
  }
  
  private boolean z(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    FileUploadReq localFileUploadReq = new FileUploadReq();
    paramToServiceMsg = paramToServiceMsg.extraData;
    localFileUploadReq.lFromUIN = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_FROM_UIN");
    localFileUploadReq.lToUIN = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_TO_UIN");
    localFileUploadReq.cType = paramToServiceMsg.getByte("CMD_PARAM_UPLOAD_TYPE");
    localFileUploadReq.nSendVipLevel = 3;
    localFileUploadReq.nRecvVipLevel = 3;
    localFileUploadReq.vSkey = new byte[] { 0 };
    localFileUploadReq.uFileSize = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_FILE_SIZE");
    localFileUploadReq.vFileMD5 = paramToServiceMsg.getByteArray("CMD_PARAM_UPLOAD_FILE_MD5");
    localFileUploadReq.strFileName = paramToServiceMsg.getString("CMD_PARAM_UPLOAD_FILE_NAME");
    localFileUploadReq.cVer = paramToServiceMsg.getByte("CMD_PARAM_UPLOAD_VER");
    localFileUploadReq.vData = paramToServiceMsg.getByteArray("CMD_PARAM_UPLOAD_DATA");
    localFileUploadReq.uWebSvrIP = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_SVR_IP");
    localFileUploadReq.shWebSvrPort = paramToServiceMsg.getShort("CMD_PARAM_UPLOAD_SVR_PORT");
    localFileUploadReq.vEncryptBuff = paramToServiceMsg.getByteArray("CMD_PARAM_UPLOAD_ENCRYP_BUF");
    localFileUploadReq.vTokenKey = paramToServiceMsg.getByteArray("CMD_PARAM_UPLOAD_TOKEN_KEY");
    localFileUploadReq.cKeyType = 8;
    localFileUploadReq.uSrcIns = 1001L;
    localFileUploadReq.uDstIns = 1L;
    localFileUploadReq.lSessionId = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_SESSIONID");
    localFileUploadReq.vOrgFileMD5 = paramToServiceMsg.getByteArray("CMD_PARAM_UPLOAD_ORGFILE_MD5");
    localFileUploadReq.uOrgFileType = paramToServiceMsg.getLong("CMD_PARAM_UPLOAD_ORGFILE_TYPE");
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("FileUploadReq");
    paramUniPacket.put("FileUploadReq", localFileUploadReq);
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.GroupMsgReadConfirm".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.DisMsgReadConfirm".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.MsgReadedReport".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.GetGroupUnRead".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return s(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return t(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SetRoamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return u(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return v(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return w(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.RespPushStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return x(paramToServiceMsg, paramUniPacket);
    }
    if ("VideoCCSvc.PutInfo".equals(paramToServiceMsg.getServiceCmd())) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if ("MultiVideo.s2cack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if ("OnlinePush.RespPush".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ClientMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqInsertBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqDeleteBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.SvrMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return y(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.FileUploadReq".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return z(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.FileDownloadReq".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return A(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.FileDeleteReq".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return B(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong)
  {
    int i1 = 2;
    int i;
    int j;
    label17:
    int k;
    label24:
    int m;
    label32:
    int n;
    label40:
    label44:
    byte[] arrayOfByte;
    if (paramArrayOfByte1 == null)
    {
      i = 2;
      if (paramArrayOfByte1 != null) {
        break label341;
      }
      j = 2;
      if (paramArrayOfByte3 != null) {
        break label350;
      }
      k = 2;
      if (paramArrayOfByte4 != null) {
        break label359;
      }
      m = 1;
      if (paramArrayOfByte4 != null) {
        break label369;
      }
      n = 1;
      if (paramArrayOfByte2 != null) {
        break label379;
      }
      arrayOfByte = new byte[i1 + (n + (j + (5 + i) + 6 + k + m))];
      arrayOfByte[0] = 1;
      PkgTools.a(arrayOfByte, 1, 0L);
      if (paramArrayOfByte1 == null) {
        break label388;
      }
      PkgTools.a(arrayOfByte, 5, (short)paramArrayOfByte1.length);
      PkgTools.a(arrayOfByte, 7, paramArrayOfByte1, paramArrayOfByte1.length);
      i = paramArrayOfByte1.length + 7;
      label112:
      if (paramArrayOfByte1 == null) {
        break label402;
      }
      PkgTools.a(arrayOfByte, i, (short)paramArrayOfByte1.length);
      i += 2;
      PkgTools.a(arrayOfByte, i, paramArrayOfByte1, paramArrayOfByte1.length);
      i += paramArrayOfByte1.length;
      label149:
      PkgTools.a(arrayOfByte, i, (short)0);
      i += 2;
      PkgTools.a(arrayOfByte, i, paramLong);
      i += 4;
      if (paramArrayOfByte3 == null) {
        break label419;
      }
      PkgTools.a(arrayOfByte, i, (short)paramArrayOfByte3.length);
      i += 2;
      PkgTools.a(arrayOfByte, i, paramArrayOfByte3, paramArrayOfByte3.length);
      i += paramArrayOfByte3.length;
      label215:
      if (paramArrayOfByte4 == null) {
        break label436;
      }
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      PkgTools.a(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
      label255:
      if (paramArrayOfByte4 == null) {
        break label451;
      }
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      PkgTools.a(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
    }
    for (;;)
    {
      if (paramArrayOfByte2 == null) {
        break label466;
      }
      PkgTools.a(arrayOfByte, i, (short)paramArrayOfByte2.length);
      i += 2;
      PkgTools.a(arrayOfByte, i, paramArrayOfByte2, paramArrayOfByte2.length);
      i = paramArrayOfByte2.length;
      return arrayOfByte;
      i = paramArrayOfByte1.length + 2;
      break;
      label341:
      j = paramArrayOfByte1.length + 2;
      break label17;
      label350:
      k = paramArrayOfByte3.length + 2;
      break label24;
      label359:
      m = paramArrayOfByte4.length + 1;
      break label32;
      label369:
      n = paramArrayOfByte4.length + 1;
      break label40;
      label379:
      i1 = paramArrayOfByte2.length + 2;
      break label44;
      label388:
      PkgTools.a(arrayOfByte, 5, (short)0);
      i = 7;
      break label112;
      label402:
      PkgTools.a(arrayOfByte, i, (short)0);
      i += 2;
      break label149;
      label419:
      PkgTools.a(arrayOfByte, i, (short)0);
      i += 2;
      break label215;
      label436:
      arrayOfByte[i] = 0;
      i += 1;
      break label255;
      label451:
      arrayOfByte[i] = 0;
      i += 1;
    }
    label466:
    PkgTools.a(arrayOfByte, i, (short)0);
    return arrayOfByte;
  }
  
  long b(long paramLong)
  {
    return 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageFactorySender
 * JD-Core Version:    0.7.0.1
 */