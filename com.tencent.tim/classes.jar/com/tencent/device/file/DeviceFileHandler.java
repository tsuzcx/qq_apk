package com.tencent.device.file;

import acbn;
import acci;
import ahav;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aomh;
import aqhq;
import arwv;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import syw;
import szf;
import szg;
import szy;

public class DeviceFileHandler
  extends RouterHandler
  implements aolm.b
{
  private DeviceNotifyReceiver a;
  protected HashSet<Long> ar;
  protected HashSet<Long> as;
  protected HashMap<Long, aoll> gj;
  protected HashMap<aoll, Integer> gk;
  protected HashMap<Long, Integer> gl;
  private HashMap<Long, Boolean> gm;
  QQAppInterface mApp = null;
  Handler mHandler = new szf(this, Looper.getMainLooper());
  
  public DeviceFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mApp = paramQQAppInterface;
    this.eT = "Device";
    this.ar = new HashSet();
    this.gj = new HashMap();
    this.gk = new HashMap();
    this.as = new HashSet();
    this.gl = new HashMap();
    this.gm = new HashMap();
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferComplete");
    paramQQAppInterface.addAction("SmartDevice_OnMiniFileTransferProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgProgress");
    paramQQAppInterface.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    paramQQAppInterface.addAction("CloudPrintJobNotifyEvent");
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = new DeviceNotifyReceiver();
    this.mApp.getApp().registerReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver, paramQQAppInterface);
  }
  
  private long a(byte[] paramArrayOfByte, MsgCSBody paramMsgCSBody, Long paramLong)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
        }
        return 0L;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      paramMsgCSBody.uMsgType = 529;
      paramMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
      paramMsgCSBody.msgBody0x211.uMsgSubType = 7;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 1;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramArrayOfByte.uint32_appid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramArrayOfByte.uint32_instid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramArrayOfByte.uint64_src_uin.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = paramArrayOfByte.uint32_uin_type.get();
      paramLong = new ArrayList();
      FTNNotify localFTNNotify = new FTNNotify();
      localFTNNotify.uint64_sessionid = this.b.generateSessionID(0);
      localFTNNotify.str_file_name = paramArrayOfByte.str_file_name.get();
      localFTNNotify.str_file_index = new String(paramArrayOfByte.bytes_file_index.get().toByteArray());
      localFTNNotify.bytes_file_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint64_file_len = paramArrayOfByte.uint64_file_length.get();
      localFTNNotify.bytes_originfile_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint32_originfiletype = 0;
      localFTNNotify.uint32_group_id = 0;
      localFTNNotify.uint32_group_size = 0;
      localFTNNotify.uint32_group_curindex = 0;
      localFTNNotify.msg_ActionInfo = new ActionInfo();
      localFTNNotify.msg_ActionInfo.strServiceName = this.eT;
      localFTNNotify.msg_ActionInfo.vServiceInfo = null;
      localFTNNotify.uint32_batchID = 0;
      localFTNNotify.uint32_groupflag = 0;
      long l = localFTNNotify.uint64_sessionid;
      paramLong.add(localFTNNotify);
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])paramLong.toArray(new FTNNotify[paramLong.size()]));
      return localFTNNotify.uint64_sessionid;
    }
  }
  
  public int I(long paramLong)
  {
    int i = 0;
    if (this.gl.containsKey(Long.valueOf(paramLong)))
    {
      i = ((Integer)this.gl.get(Long.valueOf(paramLong))).intValue();
      this.gl.remove(Long.valueOf(paramLong));
    }
    return i;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("Device.file", 1, "OnSessionComplete uSessionID=" + paramLong + " retCode=" + paramInt2 + " TaskStatus=" + paramInt1);
    Session localSession = (Session)this.iF.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionComplete no session for uSessionID=" + paramLong);
      }
      return;
    }
    if (paramInt1 == 2) {}
    for (;;)
    {
      super.notifyUI(103, bool, localSession);
      return;
      bool = false;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(this.eT))
    {
      if (paramSession.actionInfo.vServiceInfo != null) {}
      do
      {
        try
        {
          DeviceProto.MsgActionInfo localMsgActionInfo = (DeviceProto.MsgActionInfo)new DeviceProto.MsgActionInfo().mergeFrom(paramSession.actionInfo.vServiceInfo);
          if (localMsgActionInfo == null)
          {
            QLog.w("Device.file", 1, "OnSessionNew decode bussiness name error");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          Object localObject;
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            localObject = null;
          }
          paramSession.actionInfo.strServiceName = localObject.str_bussiness_name.get();
          paramSession.actionInfo.vServiceInfo = localObject.bytes_buff_with_file.get().toByteArray();
        }
        this.iF.put(Long.valueOf(paramSession.uSessionID), paramSession);
      } while (this.ar.contains(Long.valueOf(paramSession.uSessionID)));
      if ((!paramSession.bSend) && ((szy.aIl.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (szy.aIp.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) || (szy.aIj.equalsIgnoreCase(paramSession.actionInfo.strServiceName))))
      {
        super.b(paramSession, paramNFCInfo, paramFTNInfo, false);
        super.e(paramSession);
      }
      super.notifyUI(100, true, paramSession);
    }
    QLog.d("Device.file", 1, "OnSessionNew uSessionID=" + paramSession.uSessionID + " bussiness=" + paramSession.actionInfo.strServiceName);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionProgress uSessionID=" + paramLong1 + "=====" + (float)((float)paramLong2 * 1.0D / paramLong3));
    }
    Session localSession = (Session)this.iF.get(Long.valueOf(paramLong1));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionProgress no session for uSessionID=" + paramLong1);
      }
      return;
    }
    super.notifyUI(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionStart uSessionID=" + paramLong);
    }
    Session localSession = (Session)this.iF.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionStart no session for uSessionID=" + paramLong);
      }
      return;
    }
    super.notifyUI(101, true, localSession);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public long a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt1 == 3) {
      l = ((syw)paramQQAppInterface.getBusinessHandler(51)).c(paramString, paramInt2);
    }
    return l;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = new MsgCSBody();
      l = a(Base64.decode(paramString1, 2), paramQQAppInterface, Long.valueOf(0L));
      this.ar.add(Long.valueOf(l));
      this.b.OnPbMsgReceive(paramQQAppInterface);
    }
    do
    {
      return l;
      if (paramInt1 == 2)
      {
        l = this.b.generateSessionID(0);
        paramString2 = arwv.toMD5(paramString1) + paramString1.substring(paramString1.lastIndexOf("."));
        paramString2 = acbn.SDCARD_PATH + "smartdevice/" + paramString2;
        if (aqhq.fileExistsAndNotEmpty(paramString2))
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.what = 0;
          paramString1 = new Session();
          paramString1.uSessionID = l;
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramString1, szy.aIo, null);
          paramString1.strFilePathSrc = paramString2;
          paramString1.uFileSizeSrc = aqhq.getFileSizes(paramString2);
          paramQQAppInterface.obj = paramString1;
          this.mHandler.sendMessageDelayed(paramQQAppInterface, 100L);
          return l;
        }
        Object localObject = new Session();
        ((Session)localObject).uSessionID = l;
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, szy.aIo, null);
        this.iF.put(Long.valueOf(l), localObject);
        notifyUI(101, true, localObject);
        localObject = new aoll();
        ((aoll)localObject).f = this;
        ((aoll)localObject).bZ = paramString1;
        ((aoll)localObject).mHttpMethod = 0;
        ((aoll)localObject).atY = paramString2;
        this.gj.put(Long.valueOf(l), localObject);
        paramQQAppInterface.getNetEngine(0).a((aomg)localObject);
        this.mApp = paramQQAppInterface;
        return l;
      }
    } while (paramInt1 != 3);
    l = ((syw)paramQQAppInterface.getBusinessHandler(51)).a(paramString1, paramString2, paramInt2);
    paramQQAppInterface = new Session();
    paramQQAppInterface.uSessionID = l;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(paramQQAppInterface, szy.aIo, null);
    this.iF.put(Long.valueOf(l), paramQQAppInterface);
    notifyUI(101, true, paramQQAppInterface);
    this.as.add(Long.valueOf(l));
    return l;
  }
  
  public DeviceProto.MsgFileKey a(String paramString)
  {
    try
    {
      paramString = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(Base64.decode(paramString, 2));
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
      }
      return paramString;
    }
    catch (InvalidProtocolBufferMicroException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public Session a(Session paramSession)
  {
    Session localSession = new Session();
    localSession.uSessionID = this.b.generateSessionID(0);
    localSession.emFileType = paramSession.emFileType;
    localSession.strFileNameSrc = paramSession.strFileNameSrc;
    localSession.uFileSizeSrc = paramSession.uFileSizeSrc;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, szy.aIk, null);
    this.iF.put(Long.valueOf(localSession.uSessionID), localSession);
    return localSession;
  }
  
  public Session a(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "send file path=" + paramString1 + " servicename=" + paramString2 + " to " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, null, 0, 0, 0L, 0, 0, 0);
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "session create failed");
      }
      return null;
    }
    int i;
    if (paramString2.equalsIgnoreCase(szy.aIk))
    {
      i = 2251;
      switch (ahav.getFileType(paramString1))
      {
      default: 
        localSession.uSessionID = a(this.mApp, paramString1, 3, i);
        localSession.emFileType = i;
        localSession.strFileNameSrc = ahav.getFileName(paramString1);
        localSession.uFileSizeSrc = aqhq.getFileSizes(paramString1);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, szy.aIk, null);
        this.iF.put(Long.valueOf(localSession.uSessionID), localSession);
        notifyUI(101, true, localSession);
      }
    }
    for (;;)
    {
      return localSession;
      i = 2154;
      break;
      i = 2201;
      break;
      i = 2108;
      break;
      localArrayList.add(localSession);
      localSession.uSessionID = this.b.generateSessionID(0);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
      paramString1 = new DeviceProto.MsgActionInfo();
      paramString1.str_bussiness_name.set(paramString2);
      if (paramArrayOfByte != null) {
        paramString1.bytes_buff_with_file.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramString1 = paramString1.toByteArray();
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, this.eT, paramString1);
      if (localArrayList.size() > 0) {
        super.A(localArrayList, false);
      }
    }
  }
  
  public boolean bq(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.gm.containsKey(Long.valueOf(paramLong)))
    {
      bool1 = bool2;
      if (this.gm.get(Long.valueOf(paramLong)) != null) {
        bool1 = ((Boolean)this.gm.get(Long.valueOf(paramLong))).booleanValue();
      }
    }
    return bool1;
  }
  
  public void d(Session paramSession)
  {
    if (paramSession != null) {
      this.iF.put(Long.valueOf(paramSession.uSessionID), paramSession);
    }
  }
  
  public void g(int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((this.gj.containsKey(Long.valueOf(paramLong))) && (this.mApp != null))
    {
      localIterator = this.gj.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          if ((((Long)((Map.Entry)localObject).getKey()).longValue() != paramLong) && (((aoll)((Map.Entry)localObject).getValue()).bZ.equals(((aoll)this.gj.get(Long.valueOf(paramLong))).bZ)))
          {
            this.mApp.getNetEngine(0).b((aomg)((Map.Entry)localObject).getValue());
            localObject = (Session)this.iF.get(((Map.Entry)localObject).getKey());
            if (localObject != null) {
              break;
            }
          }
        }
      }
    }
    while (this.as.contains(Long.valueOf(paramLong)))
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject;
        return;
        super.notifyUI(103, false, localObject);
        localIterator.remove();
      }
      this.mApp.getNetEngine(0).b((aomg)this.gj.get(Long.valueOf(paramLong)));
      this.gj.remove(Long.valueOf(paramLong));
      return;
    }
    super.g(paramInt, paramLong, paramBoolean);
  }
  
  public boolean getAutoDownload()
  {
    return true;
  }
  
  public Class<? extends acci> observerClass()
  {
    return szg.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mApp != null) && (this.mApp.getApp() != null) && (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver != null))
    {
      this.mApp.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileHandler$DeviceNotifyReceiver = null;
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {}
    Iterator localIterator;
    label22:
    Object localObject;
    do
    {
      return;
      localIterator = this.gj.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((aoll)((Map.Entry)localObject).getValue()).bZ.equals(((aoll)paramaomh.b).bZ));
      localObject = (Session)this.iF.get(((Map.Entry)localObject).getKey());
    } while (localObject == null);
    ((Session)localObject).strFilePathSrc = paramaomh.b.atY;
    ((Session)localObject).uFileSizeSrc = paramaomh.apU;
    if (paramaomh.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.notifyUI(103, bool, localObject);
      localIterator.remove();
      break label22;
      break;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.gj.entrySet().iterator();
    for (;;)
    {
      Map.Entry localEntry;
      Session localSession;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (!((aoll)localEntry.getValue()).bZ.equals(((aoll)paramaomg).bZ)) {
          continue;
        }
        int i = 0;
        if (this.gk.containsKey(paramaomg)) {
          i = ((Integer)this.gk.get(paramaomg)).intValue();
        }
        if (i < 10)
        {
          this.gk.put((aoll)paramaomg, Integer.valueOf(i + 1));
          continue;
        }
        this.gk.put((aoll)paramaomg, Integer.valueOf(0));
        localSession = (Session)this.iF.get(localEntry.getKey());
        if (localSession != null) {}
      }
      else
      {
        return;
      }
      localSession.uSessionID = ((Long)localEntry.getKey()).longValue();
      if (localSession.uFileSizeSrc == 0L) {
        localSession.uFileSizeSrc = paramLong2;
      }
      super.notifyUI(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong1 * 1.0D / (float)paramLong2)) });
    }
  }
  
  public class DeviceNotifyReceiver
    extends BroadcastReceiver
  {
    public DeviceNotifyReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      long l1;
      label301:
      int j;
      label386:
      do
      {
        do
        {
          int i;
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
                    do
                    {
                      long l2;
                      long l3;
                      do
                      {
                        do
                        {
                          return;
                          paramContext = paramIntent.getAction();
                        } while (paramContext == null);
                        if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress")) {
                          break;
                        }
                        paramContext = paramIntent.getExtras();
                        l1 = paramContext.getLong("cookie", 0L);
                        l2 = paramContext.getLong("progress", 0L);
                        l3 = paramContext.getLong("total", 0L);
                        paramContext = (Session)DeviceFileHandler.a(DeviceFileHandler.this).get(Long.valueOf(l1));
                      } while (paramContext == null);
                      if (paramContext.uFileSizeSrc == 0L) {
                        paramContext.uFileSizeSrc = l3;
                      }
                      DeviceFileHandler.this.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)((float)l2 * 1.0D / (float)l3)) });
                      return;
                      if (!paramContext.equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete")) {
                        break;
                      }
                      paramContext = paramIntent.getExtras();
                      l1 = paramContext.getLong("cookie", 0L);
                      i = paramContext.getInt("err_code", 0);
                      str = paramContext.getString("filepath");
                      paramIntent = (Session)DeviceFileHandler.b(DeviceFileHandler.this).get(Long.valueOf(l1));
                    } while (paramIntent == null);
                    if (DeviceFileHandler.this.as.contains(Long.valueOf(l1))) {
                      if (!TextUtils.isEmpty(str))
                      {
                        if (str.lastIndexOf(".") > 0)
                        {
                          paramContext = str.substring(str.lastIndexOf("."));
                          paramContext = acbn.SDCARD_PATH + "/smart_device/" + System.currentTimeMillis() + paramContext;
                          aqhq.moveFile(str, paramContext);
                          paramIntent.strFilePathSrc = paramContext;
                          DeviceFileHandler.this.as.remove(Long.valueOf(l1));
                        }
                      }
                      else
                      {
                        if (i == -5103058) {
                          DeviceFileHandler.this.gl.put(Long.valueOf(paramIntent.uSessionID), Integer.valueOf(-5103058));
                        }
                        paramContext = DeviceFileHandler.this;
                        if (i != 0) {
                          break label386;
                        }
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      paramContext.notifyUI(103, bool, paramIntent);
                      return;
                      paramContext = ".amr";
                      break;
                      if (!paramIntent.actionInfo.strServiceName.equalsIgnoreCase(szy.aIk)) {
                        break label301;
                      }
                      paramIntent.vFileMD5Src = str.getBytes();
                      break label301;
                    }
                    if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress")) {
                      break;
                    }
                    paramContext = paramIntent.getExtras();
                  } while (paramContext == null);
                  DeviceFileHandler.this.notifyUI(104, true, paramContext);
                  return;
                  if (!paramContext.equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet")) {
                    break;
                  }
                  paramContext = paramIntent.getExtras();
                } while (paramContext == null);
                DeviceFileHandler.this.notifyUI(105, true, paramContext);
                return;
              } while (!paramContext.equalsIgnoreCase("CloudPrintJobNotifyEvent"));
              paramIntent = paramIntent.getExtras();
            } while (paramIntent == null);
            i = paramIntent.getInt("nType", 0);
            String str = paramIntent.getString("strJobId");
            j = paramIntent.getInt("nEventValue", 0);
            paramContext = null;
            if (TextUtils.isEmpty(str)) {
              break;
            }
            paramContext = (Session)DeviceFileHandler.c(DeviceFileHandler.this).get(Long.valueOf(Long.parseLong(str)));
          } while (paramContext == null);
          switch (i)
          {
          default: 
            return;
          }
        } while (j == 0);
        DeviceFileHandler.this.notifyUI(103, false, paramContext);
        return;
        if (j == 100)
        {
          DeviceFileHandler.this.notifyUI(103, true, paramContext);
          return;
        }
        DeviceFileHandler.this.notifyUI(102, true, new Object[] { paramContext, Float.valueOf((float)(j / 100.0D)) });
        return;
        DeviceFileHandler.this.gl.put(Long.valueOf(paramContext.uSessionID), Integer.valueOf(j));
        DeviceFileHandler.this.notifyUI(103, false, paramContext);
        return;
        l1 = paramIntent.getLong("uDin", 0L);
      } while (l1 == 0L);
      paramContext = DeviceFileHandler.d(DeviceFileHandler.this);
      if (j != 3) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.put(Long.valueOf(l1), Boolean.valueOf(bool));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler
 * JD-Core Version:    0.7.0.1
 */