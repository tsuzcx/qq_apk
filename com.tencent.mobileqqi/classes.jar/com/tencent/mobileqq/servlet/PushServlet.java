package com.tencent.mobileqq.servlet;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.PushReq;
import KQQ.CheckUpdateResp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcRespRegister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.Constants.Key;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class PushServlet
  extends MSFServlet
{
  private void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null))
    {
      Object localObject = paramFileStoragePushFSSvcList.vUrlEncodeServiceList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("PushServlet", 2, "info.sip" + localFileStorageServerListInfo.sIP + ",info.port" + localFileStorageServerListInfo.iPort);
        }
      }
      localObject = (QQAppInterface)getAppRuntime();
      SosoSrvAddrProvider.a().a(paramFileStoragePushFSSvcList.vUrlEncodeServiceList);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: FMT SERVER ADDR LIST");
    }
    paramArrayOfByte = new JceInputStream(paramArrayOfByte);
    Object localObject = new FileStoragePushFSSvcList();
    ((FileStoragePushFSSvcList)localObject).readFrom(paramArrayOfByte);
    FMTSrvAddrProvider.a().a((FileStoragePushFSSvcList)localObject);
    a((FileStoragePushFSSvcList)localObject);
    b((FileStoragePushFSSvcList)localObject);
    if ((((FileStoragePushFSSvcList)localObject).vGPicDownLoadList == null) && (QLog.isColorLevel())) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: vGPicDownLoadList ==null");
    }
    paramArrayOfByte = FMTSrvAddrProvider.a().a();
    localObject = (QQAppInterface)getAppRuntime();
    ((QQAppInterface)localObject).a();
    Context localContext = BaseApplication.getContext();
    String str = ((QQAppInterface)localObject).a();
    ConfigManager.getInstance(localContext, (AppRuntime)localObject, ((QQAppInterface)localObject).a(), str).onSrvAddrPush(localContext, (AppRuntime)localObject, str, paramArrayOfByte);
  }
  
  private void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    QQAppInterface localQQAppInterface;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.bigDataChannel != null))
    {
      paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.bigDataChannel;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      long l = paramFileStoragePushFSSvcList.uSig_Uin;
      if (localQQAppInterface.getLongAccountUin() == l)
      {
        arrayOfByte1 = paramFileStoragePushFSSvcList.sBigdata_key_session;
        arrayOfByte2 = paramFileStoragePushFSSvcList.sBigdata_sig_session;
        paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.vBigdata_iplists.iterator();
        while (paramFileStoragePushFSSvcList.hasNext())
        {
          Object localObject = (BigDataIpList)paramFileStoragePushFSSvcList.next();
          if (((BigDataIpList)localObject).uService_type == 5L)
          {
            localObject = ((BigDataIpList)localObject).vIplist;
            if (localObject != null)
            {
              paramFileStoragePushFSSvcList = new String[((ArrayList)localObject).size()];
              int i = 0;
              while (i < ((ArrayList)localObject).size())
              {
                BigDataIpInfo localBigDataIpInfo = (BigDataIpInfo)((ArrayList)localObject).get(i);
                paramFileStoragePushFSSvcList[i] = CircleManager.a(localBigDataIpInfo.sIp, (int)localBigDataIpInfo.uPort);
                i += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((CircleManager)localQQAppInterface.getManager(33)).a(arrayOfByte1, arrayOfByte2, paramFileStoragePushFSSvcList);
      return;
      paramFileStoragePushFSSvcList = null;
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "cmd_connOpened", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PbGetMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullDisGroupSeq", "RegPrxySvc.NoticeEnd", "cmd_connClosed", "ConfigPushSvc.PushReq", "StatSvc.register", "cmd_connAllFailed", "cmd_recvFirstResp", "cmd_connWeakNet", "MultiVideo.s2c", "MultiVideo.c2sack", "ProfileService.CheckUpdateReq", "cmd_netNeedSignon" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    String str = paramFromServiceMsg.getServiceCmd();
    if ("cmd_connOpened".equals(str)) {
      localQQAppInterface.c();
    }
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
              if ("cmd_connClosed".equals(str))
              {
                ((SaveTrafficHandler)localQQAppInterface.a(18)).a();
                localQQAppInterface.f();
                return;
              }
              if ("cmd_connWeakNet".equals(str))
              {
                localQQAppInterface.e();
                return;
              }
              if ("cmd_netNeedSignon".equals(str))
              {
                localQQAppInterface.b((String)paramFromServiceMsg.getAttribute("signonurl"));
                return;
              }
              if ("cmd_recvFirstResp".equals(str))
              {
                localQQAppInterface.g();
                return;
              }
              if ("cmd_connAllFailed".equals(str))
              {
                localQQAppInterface.h();
                return;
              }
              if (!"ConfigPushSvc.PushReq".equals(str)) {
                break;
              }
              paramIntent = new UniPacket(true);
              paramIntent.setEncodeName("utf-8");
              paramIntent.decode(paramFromServiceMsg.getWupBuffer());
              paramIntent = (PushReq)paramIntent.getByClass("PushReq", new PushReq());
            } while ((paramIntent == null) || (paramIntent.type != 2));
            a(paramIntent.jcebuf);
            return;
            if (!"StatSvc.register".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            paramIntent = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
          } while ((paramIntent == null) || (paramIntent.cReplyCode != 0));
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "PushServlet.onReceive " + paramIntent.timeStamp + ", " + paramIntent.bUpdateFlag);
          }
          if (paramIntent.timeStamp != 0L) {
            localQQAppInterface.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramIntent.timeStamp).commit();
          }
        } while ((localQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L) != 0L) && (paramIntent.bUpdateFlag != 1));
        localQQAppInterface.a.a(paramIntent.bUpdateFlag);
        return;
        if (("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PullDisMsgSeq".equals(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          for (;;)
          {
            if (("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
              paramIntent.extraData.putBoolean("req_pb_protocol_flag", true);
            }
            paramIntent.extraData.putBoolean("used_register_proxy", true);
            localQQAppInterface.a.f();
            ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
            return;
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
        }
        if (("MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          QLog.d("dimontang", 1, "RECEIVED PUSH: MULTI VIDEO S2C");
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          for (;;)
          {
            ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
            return;
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
        }
      } while (!"ProfileService.CheckUpdateReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "push command:" + paramFromServiceMsg.getServiceCmd() + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq());
      }
    } while (paramFromServiceMsg.getRequestSsoSeq() > 0);
    paramIntent = new UniPacket(true);
    try
    {
      paramIntent.setEncodeName("utf-8");
      paramIntent.decode(paramFromServiceMsg.getWupBuffer());
      label822:
      paramIntent = (CheckUpdateResp)paramIntent.getByClass("CheckUpdateResp", new CheckUpdateResp());
      ((FriendListHandler)localQQAppInterface.a(1)).a(paramIntent);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      break label822;
    }
    catch (RuntimeException paramFromServiceMsg)
    {
      break label822;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.PushServlet
 * JD-Core Version:    0.7.0.1
 */