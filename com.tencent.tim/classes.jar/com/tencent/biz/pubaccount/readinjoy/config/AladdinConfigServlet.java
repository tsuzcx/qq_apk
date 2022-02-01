package com.tencent.biz.pubaccount.readinjoy.config;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import anpc;
import aqgz;
import aqoj;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.CPU;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Camera;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Config;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigResult;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigSeq;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.DeviceInfo;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Memory;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.OS;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBody;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType1;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType2;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBody;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBodyType1;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBodyType2;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Screen;
import com.tencent.aladdin.config.network.oidb_cmd0xbf8.Storage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kxm;
import kyc;
import kyg;
import kyi;
import lup;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class AladdinConfigServlet
  extends MSFServlet
{
  private static void a(int paramInt, List<ConfigResult> paramList, Intent paramIntent)
  {
    boolean bool = true;
    HashMap localHashMap = new HashMap();
    int i = paramIntent.getIntExtra("key_req_type", 0);
    localHashMap.put("param_OpCode", String.valueOf(i));
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    if (i == 0)
    {
      int k = paramList.size();
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        if (ConfigResult.a((ConfigResult)paramList.next()) != 0) {}
        for (int j = 1;; j = 0)
        {
          i = j + i;
          break;
        }
      }
      localHashMap.put("param_ConfigCount", String.valueOf(k));
      localHashMap.put("param_FailCount", String.valueOf(i));
    }
    long l = paramIntent.getLongExtra("key_packet_receive_timestamp", 0L) - paramIntent.getLongExtra("key_packet_send_timestamp", 0L);
    localHashMap.put("param_CostTime", String.valueOf(l));
    paramList = anpc.a(kxm.getAppRuntime().getApplication());
    paramIntent = kxm.getAccount();
    if (paramInt == 0) {}
    for (;;)
    {
      paramList.collectPerformance(paramIntent, "actKanDianAladdinResult", bool, l, 0L, localHashMap, null, false);
      return;
      bool = false;
    }
  }
  
  private void ackConfigResults(String paramString, ArrayList<ConfigResult> paramArrayList)
  {
    QLog.d("AladdinConfigServlet", 2, "[ackConfigResults] for " + paramArrayList);
    AppRuntime localAppRuntime = getAppRuntime();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), AladdinConfigServlet.class);
    localNewIntent.putExtra("key_uin", localAppRuntime.getAccount());
    localNewIntent.putExtra("key_cookie", paramString);
    localNewIntent.putExtra("key_req_type", 1);
    localNewIntent.putExtra("key_config_result_list", paramArrayList);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private static void handleAckRsp(oidb_cmd0xbf8.RspBodyType2 paramRspBodyType2)
  {
    QLog.d("AladdinConfigServlet", 2, "[handleAckRsp] " + pbToString(paramRspBodyType2));
    paramRspBodyType2 = paramRspBodyType2.msg.get();
    QLog.d("AladdinConfigServlet", 2, "[handleAckRsp] msg=" + paramRspBodyType2);
  }
  
  private ArrayList<ConfigResult> handleRspBody(oidb_cmd0xbf8.RspBodyType1 paramRspBodyType1)
  {
    QLog.d("AladdinConfigServlet", 2, "[handleRspBody] " + pbToString(paramRspBodyType1));
    Object localObject = paramRspBodyType1.rpt_config_list.get();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i;
    if (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xbf8.Config localConfig = (oidb_cmd0xbf8.Config)((Iterator)localObject).next();
      int j = localConfig.id.get();
      int k = localConfig.version.get();
      String str = localConfig.content.get();
      for (i = localConfig.wipe_flag.get();; i = 1)
      {
        try
        {
          boolean bool = handleSingleConfigRsp(j, k, str, i);
          if (!bool) {
            continue;
          }
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("AladdinConfigServlet", 1, "[handleRspBody] ", localException);
            i = 1;
          }
        }
        localArrayList.add(new ConfigResult(j, k, i));
        break;
      }
    }
    ackConfigResults(paramRspBodyType1.cookie.get(), localArrayList);
    return localArrayList;
  }
  
  private boolean handleSingleConfigRsp(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    QLog.d("AladdinConfigServlet", 2, "[handleSingleConfigRsp] id = " + paramInt1 + ", version = " + paramInt2 + ", content = " + paramString + ", wipeFlag = " + paramInt3);
    if (paramInt2 > kyg.getConfigVersionById(paramInt1)) {}
    try
    {
      AladdinConfigHandler localAladdinConfigHandler = Aladdin.getConfigHandlerById(paramInt1);
      if (paramInt3 != 0) {
        localAladdinConfigHandler.onWipeConfig(paramInt3);
      }
      for (bool1 = bool2;; bool1 = localAladdinConfigHandler.onReceiveConfig(paramInt1, paramInt2, paramString))
      {
        kyg.setConfigVersionById(paramInt1, paramInt2);
        return bool1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("AladdinConfigServlet", 1, "[handleSingleConfigRsp] ", paramString);
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = ((Boolean)awit.f("should_request_aladdin_config", Boolean.valueOf(true))).booleanValue();
    QLog.i("AladdinConfigServlet", 1, "[maybeGetAllConfigs] shouldRequest=" + bool);
    if (bool) {
      kyi.aIi();
    }
  }
  
  private static oidb_cmd0xbf8.ReqBody makeAckBody(String paramString, List<ConfigResult> paramList)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    oidb_cmd0xbf8.ReqBodyType2 localReqBodyType2 = new oidb_cmd0xbf8.ReqBodyType2();
    localReqBodyType2.cookie.set(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ConfigResult)paramString.next();
      oidb_cmd0xbf8.ConfigResult localConfigResult = new oidb_cmd0xbf8.ConfigResult();
      localConfigResult.id.set(paramList.getId());
      localConfigResult.ret_code.set(paramList.getRetCode());
      localConfigResult.version.set(paramList.getVersion());
      localReqBodyType2.rpt_ret_list.add(localConfigResult);
    }
    localReqBody.req_type.set(1);
    localReqBody.body_type_2.set(localReqBodyType2);
    QLog.d("AladdinConfigServlet", 2, "[makeAckBody] " + pbToString(localReqBody));
    return localReqBody;
  }
  
  private static oidb_cmd0xbf8.DeviceInfo makeDeviceInfo()
  {
    oidb_cmd0xbf8.DeviceInfo localDeviceInfo = new oidb_cmd0xbf8.DeviceInfo();
    localDeviceInfo.os.set(new oidb_cmd0xbf8.OS());
    localDeviceInfo.os.type.set(2);
    localDeviceInfo.os.version.set(aqgz.getDeviceOSVersion());
    localDeviceInfo.os.sdk.set(String.valueOf(aqgz.getOsVersion()));
    localDeviceInfo.os.kernel.set(System.getProperty("os.version"));
    localDeviceInfo.cpu.set(new oidb_cmd0xbf8.CPU());
    localDeviceInfo.cpu.model.set(aqgz.getCpuType());
    localDeviceInfo.cpu.cores.set(aqgz.getCpuNumber());
    localDeviceInfo.cpu.frequency.set((int)aqgz.getCpuFrequency());
    localDeviceInfo.memory.set(new oidb_cmd0xbf8.Memory());
    localDeviceInfo.memory.total.set(aqgz.getSystemTotalMemory());
    localDeviceInfo.storage.set(new oidb_cmd0xbf8.Storage());
    localDeviceInfo.storage.builtin.set(aqgz.getRomMemroy()[0]);
    localDeviceInfo.storage.external.set(aqgz.getSDCardMemory()[0]);
    localDeviceInfo.screen.set(new oidb_cmd0xbf8.Screen());
    localDeviceInfo.screen.dpi.set(aqgz.getDispalyDpi());
    localDeviceInfo.screen.width.set((int)aqgz.hK());
    localDeviceInfo.screen.height.set((int)aqgz.hL());
    localDeviceInfo.camera.set(new oidb_cmd0xbf8.Camera());
    return localDeviceInfo;
  }
  
  private static oidb_cmd0xbf8.ReqBody makeReqBody(@NonNull int[] paramArrayOfInt)
  {
    oidb_cmd0xbf8.ReqBody localReqBody = new oidb_cmd0xbf8.ReqBody();
    oidb_cmd0xbf8.ReqBodyType1 localReqBodyType1 = new oidb_cmd0xbf8.ReqBodyType1();
    localReqBodyType1.app_version.set("3.4.4");
    localReqBodyType1.device_info.set(makeDeviceInfo());
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      oidb_cmd0xbf8.ConfigSeq localConfigSeq = new oidb_cmd0xbf8.ConfigSeq();
      localConfigSeq.id.set(k);
      localConfigSeq.version.set(kyg.getConfigVersionById(k));
      localReqBodyType1.rpt_config_list.add(localConfigSeq);
      i += 1;
    }
    localReqBody.req_type.set(0);
    localReqBody.body_type_1.set(localReqBodyType1);
    QLog.d("AladdinConfigServlet", 2, "[makeReqBody] " + pbToString(localReqBody));
    return localReqBody;
  }
  
  private static byte[] n(byte[] paramArrayOfByte)
  {
    long l = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    aqoj.DWord2Byte(arrayOfByte, 0, 4L + l);
    aqoj.b(arrayOfByte, 4, paramArrayOfByte, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] o(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    aqoj.copyData(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public static <T extends MessageMicro> String pbToString(T paramT)
  {
    if (QLog.isColorLevel()) {}
    return "";
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.i("AladdinConfigServlet", 1, "[onReceive] cmd=" + paramFromServiceMsg.getServiceCmd() + " appSeq=" + paramFromServiceMsg.getAppSeq() + " success=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    oidb_cmd0xbf8.RspBody localRspBody = new oidb_cmd0xbf8.RspBody();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int j;
      try
      {
        int i = lup.parseOIDBPkg(paramFromServiceMsg, o(paramFromServiceMsg.getWupBuffer()), localRspBody);
        QLog.i("AladdinConfigServlet", 1, "[onReceive] result=" + i);
        if (i != 0) {
          break label245;
        }
        j = localRspBody.rsp_type.get();
        QLog.i("AladdinConfigServlet", 1, "[onReceive] rspType=" + j);
        if (j == 0)
        {
          paramFromServiceMsg = handleRspBody((oidb_cmd0xbf8.RspBodyType1)localRspBody.body_type_1.get());
          paramIntent.putExtra("key_packet_receive_timestamp", System.currentTimeMillis());
          a(i, paramFromServiceMsg, paramIntent);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("AladdinConfigServlet", 1, "[onReceive] ", paramIntent);
        return;
      }
      if (j == 1) {
        handleAckRsp((oidb_cmd0xbf8.RspBodyType2)localRspBody.body_type_2.get());
      }
      label245:
      paramFromServiceMsg = localArrayList;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_req_type", 0);
    Object localObject1 = null;
    Object localObject2;
    if (i == 0)
    {
      localObject2 = paramIntent.getIntArrayExtra("key_config_id_list");
      if (localObject2 != null) {
        localObject1 = makeReqBody((int[])localObject2);
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = lup.makeOIDBPkg("OidbSvc.0xbf8", 3064, 0, ((oidb_cmd0xbf8.ReqBody)localObject1).toByteArray());
        paramPacket.setSSOCommand(((ToServiceMsg)localObject1).getServiceCmd());
        paramPacket.putSendData(n(((ToServiceMsg)localObject1).getWupBuffer()));
        paramPacket.setAttributes(((ToServiceMsg)localObject1).getAttributes());
        paramIntent.putExtra("key_packet_send_timestamp", System.currentTimeMillis());
      }
      QLog.i("AladdinConfigServlet", 1, "[onSend] reqType=" + i);
      return;
      if (i == 1)
      {
        localObject2 = paramIntent.getParcelableArrayListExtra("key_config_result_list");
        String str = paramIntent.getStringExtra("key_cookie");
        if (localObject2 != null) {
          localObject1 = makeAckBody(str, (List)localObject2);
        }
      }
      else
      {
        QLog.i("AladdinConfigServlet", 1, "[onSend] unknown reqType = " + i);
      }
    }
  }
  
  public static class ConfigResult
    implements Parcelable
  {
    public static final Parcelable.Creator<ConfigResult> CREATOR = new kyc();
    private final int id;
    private final int retCode;
    private final int version;
    
    ConfigResult(int paramInt1, int paramInt2, int paramInt3)
    {
      this.id = paramInt1;
      this.version = paramInt2;
      this.retCode = paramInt3;
    }
    
    public ConfigResult(Parcel paramParcel)
    {
      this.id = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.retCode = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public int getRetCode()
    {
      return this.retCode;
    }
    
    public int getVersion()
    {
      return this.version;
    }
    
    public String toString()
    {
      return "ConfigResult{id=" + this.id + ", version=" + this.version + ", retCode=" + this.retCode + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.id);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.retCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet
 * JD-Core Version:    0.7.0.1
 */