package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.ReqBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.RspBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501ReqBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class HwServlet
  extends MSFServlet
{
  private static final String CMD_GET_IP_LIST = "HttpConn.0x6ff_501";
  private static final int CMD_ID_GET_CONFIG = 181;
  private static final int CMD_ID_REPORT_TRAFFIC = 182;
  private static final String CMD_PIC_UP = "LongConn.OffPicUp";
  private static final int HIGHWAY_SERVICE_TYPE = 10;
  private static final String PARAM_FLAG = "flag";
  private static final String PARAM_IP = "ip";
  private static final String PARAM_NETWORKTYPE = "networktype";
  private static final String PARAM_PORT = "port";
  private static final String PARAM_REQUEST_TYPE = "param_req_type";
  private static final String PARAM_SIZE = "buffersize";
  private static final String PARAM_TYPE = "mType";
  private static final String PARAM_UIN = "param_uin";
  private static final String TAG = "ConfigManager";
  private static AppRuntime mApp;
  private static AtomicBoolean mHasStart = new AtomicBoolean(false);
  private static String mUin;
  
  public static void getConfig(AppRuntime paramAppRuntime, String paramString)
  {
    if (mHasStart.get()) {
      return;
    }
    mHasStart.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("ConfigManager", 2, "HwServlet.getConfig()");
    }
    mApp = paramAppRuntime;
    mUin = paramString;
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), HwServlet.class);
    localNewIntent.putExtra("param_req_type", 181);
    localNewIntent.putExtra("param_uin", Long.parseLong(paramString));
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  public static void reportTraffic(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, boolean paramBoolean, long paramLong)
  {
    int k = 1;
    if (paramLong <= 0L) {
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        j = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (j != 1) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        int j;
        NewIntent localNewIntent;
        localException.printStackTrace();
        continue;
      }
      localNewIntent = new NewIntent(paramAppRuntime.getApplication(), HwServlet.class);
      localNewIntent.putExtra("param_req_type", 182);
      localNewIntent.putExtra("ip", paramString1);
      localNewIntent.putExtra("port", paramInt);
      localNewIntent.putExtra("mType", paramString2);
      paramInt = k;
      if (paramBoolean) {
        paramInt = 0;
      }
      localNewIntent.putExtra("flag", paramInt);
      localNewIntent.putExtra("buffersize", paramLong);
      localNewIntent.putExtra("networktype", i);
      paramAppRuntime.startServlet(localNewIntent);
      return;
      if (j == 0)
      {
        i = 1;
      }
      else
      {
        i = j;
        if (isNetworkTypeMobile(j) == true)
        {
          i = 1;
        }
        else
        {
          i = j;
          j = NetConnInfoCenterImpl.getSystemNetworkType();
          i = j;
        }
      }
    }
  }
  
  public static void reportTraffic4GetIpList(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    reportTraffic(paramAppRuntime, paramString, paramInt, "HttpConn.0x6ff_501", paramBoolean, paramLong);
  }
  
  public static void reportTraffic4PicUp(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    reportTraffic(paramAppRuntime, paramString, paramInt, "LongConn.OffPicUp", paramBoolean, paramLong);
  }
  
  private boolean reqGetIPList(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_uin", 0L);
    if ((l == 0L) && (QLog.isColorLevel())) {
      QLog.d("ConfigManager", 2, "HwServlet.reqGetIPList() fail due to uin=0");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfigManager", 2, "HwServlet.reqGetIPList() req get ip list..");
    }
    paramIntent = new subcmd0x501.SubCmd0x501ReqBody();
    paramIntent.uint64_uin.set(l);
    paramIntent.uint32_idc_id.set(0);
    paramIntent.uint32_appid.set(16);
    paramIntent.uint32_login_sig_type.set(1);
    paramIntent.uint32_request_flag.set(3);
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(10));
    paramIntent.rpt_uint32_service_types.set((List)localObject);
    paramIntent.uint32_plat.set(9);
    localObject = new subcmd0x501.ReqBody();
    ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramIntent);
    paramPacket.setSSOCommand("HttpConn.0x6ff_501");
    paramIntent = ((subcmd0x501.ReqBody)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    return true;
  }
  
  private void respGetIPList(Intent paramIntent, FromServiceMsg paramFromServiceMsg, AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      localObject = new StringBuilder().append("HwServlet.respGetIPList()  is ");
      if (bool)
      {
        paramIntent = "";
        QLog.d("ConfigManager", 2, paramIntent + " success");
      }
    }
    else
    {
      if (paramFromServiceMsg.isSuccess()) {
        break label72;
      }
    }
    label72:
    label457:
    label489:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramIntent = "not";
            break;
            paramIntent = new subcmd0x501.RspBody();
            try
            {
              paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
              localObject = new byte[paramFromServiceMsg.getInt() - 4];
              paramFromServiceMsg.get((byte[])localObject);
              paramIntent.mergeFrom((byte[])localObject);
              paramIntent = ((subcmd0x501.SubCmd0x501Rspbody)paramIntent.msg_subcmd_0x501_rsp_body.get()).rpt_msg_httpconn_addrs.get();
              if ((paramIntent == null) || (paramIntent.size() == 0)) {
                break label489;
              }
              paramIntent = paramIntent.iterator();
              do
              {
                if (!paramIntent.hasNext()) {
                  break;
                }
                paramFromServiceMsg = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramIntent.next();
              } while (paramFromServiceMsg.uint32_service_type.get() != 10);
              paramIntent = new HwConfig();
              paramIntent.ipList = new ArrayList();
              paramIntent.netSegConfList = new ArrayList();
              localObject = paramFromServiceMsg.rpt_msg_addrs.get();
              int i;
              if ((localObject != null) && (((List)localObject).size() != 0))
              {
                i = 0;
                while (i < ((List)localObject).size())
                {
                  subcmd0x501.SubCmd0x501Rspbody.IpAddr localIpAddr = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject).get(i);
                  paramIntent.ipList.add(new EndPoint(spliceCircleUrl(localIpAddr.uint32_ip.get()), localIpAddr.uint32_port.get()));
                  i += 1;
                }
              }
              paramFromServiceMsg = paramFromServiceMsg.rpt_msg_netsegconf.get();
              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() != 0))
              {
                i = 0;
                while (i < paramFromServiceMsg.size())
                {
                  localObject = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)paramFromServiceMsg.get(i);
                  paramIntent.netSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject).uint32_curconnnum.get()));
                  i += 1;
                }
              }
              paramFromServiceMsg = ConfigManager.getInstance(null, null, 0, null);
              if (paramFromServiceMsg == null) {
                break label457;
              }
              paramFromServiceMsg.onSrvAddrSsoGet(paramIntent, paramAppRuntime, paramString);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramIntent)
            {
              paramIntent.printStackTrace();
            }
          } while (!QLog.isColorLevel());
          QLog.d("ConfigManager", 2, paramIntent.getMessage());
          return;
        } while (!QLog.isColorLevel());
        QLog.d("ConfigManager", 2, "HwServlet.respGetIPList() cfg == null");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ConfigManager", 2, "HwServlet.respGetIPList() cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigManager", 2, "HwServlet.respGetIPList() srvAddrList == null || srvAddrList.size() == 0");
  }
  
  public static String spliceCircleUrl(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    mHasStart.set(false);
    paramFromServiceMsg.getResultCode();
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigManager", 2, "cmd == null");
      }
      return;
    }
    if (str.equals("HttpConn.0x6ff_501")) {
      respGetIPList(paramIntent, paramFromServiceMsg, mApp, mUin);
    }
    mApp = null;
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    switch (localBundle.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 181: 
      reqGetIPList(paramIntent, paramPacket);
      return;
    }
    sendToMSF(paramIntent, MsfServiceSdk.get().getReportTrafficeMsg4Highway(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwServlet
 * JD-Core Version:    0.7.0.1
 */