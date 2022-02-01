package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.aio.media.open.aio_media_open.ReqOpenIdentify;
import tencent.aio.media.open.aio_media_open.ReqOpenStart;
import tencent.aio.media.open.aio_media_open.ResultInfo;
import tencent.aio.media.open.aio_media_open.RspOpenIdentify;
import tencent.aio.media.open.aio_media_open.RspOpenStart;

public class TogetherBusinessServlet
  extends MSFServlet
{
  private ResultInfo a(aio_media_open.ResultInfo paramResultInfo)
  {
    int i;
    boolean bool;
    if (!paramResultInfo.uint32_result.has())
    {
      i = -1;
      if (paramResultInfo.bool_show_err.has()) {
        break label59;
      }
      bool = false;
      label24:
      if (paramResultInfo.bytes_errmsg.has()) {
        break label70;
      }
    }
    label59:
    label70:
    for (paramResultInfo = "";; paramResultInfo = paramResultInfo.bytes_errmsg.get().toStringUtf8())
    {
      return new ResultInfo(i, paramResultInfo, bool);
      i = paramResultInfo.uint32_result.get();
      break;
      bool = paramResultInfo.bool_show_err.get();
      break label24;
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), TogetherBusinessServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("bundle", paramBundle);
    localNewIntent.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void j(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getBundleExtra("bundle");
    paramIntent = ((Bundle)localObject2).getString("req_data", "");
    Object localObject1 = ((Bundle)localObject2).getString("req_sign", "");
    long l = ((Bundle)localObject2).getLong("uin", -1L);
    int i = ((Bundle)localObject2).getInt("session_type", -1);
    localObject2 = new aio_media_open.ReqOpenIdentify();
    ((aio_media_open.ReqOpenIdentify)localObject2).enum_aio_type.set(i);
    ((aio_media_open.ReqOpenIdentify)localObject2).uint64_id.set(l);
    ((aio_media_open.ReqOpenIdentify)localObject2).bytes_req_data.set(ByteStringMicro.copyFromUtf8(paramIntent));
    ((aio_media_open.ReqOpenIdentify)localObject2).bytes_req_sign.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    paramIntent = ((aio_media_open.ReqOpenIdentify)localObject2).toByteArray();
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.setSSOCommand("QQAIOMediaSvc.open_identify");
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  private void k(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getBundleExtra("bundle");
    paramIntent = ((Bundle)localObject2).getString("req_data", "");
    Object localObject1 = ((Bundle)localObject2).getString("req_sign", "");
    long l = ((Bundle)localObject2).getLong("uin", -1L);
    int i = ((Bundle)localObject2).getInt("session_type", -1);
    localObject2 = new aio_media_open.ReqOpenStart();
    ((aio_media_open.ReqOpenStart)localObject2).enum_aio_type.set(i);
    ((aio_media_open.ReqOpenStart)localObject2).uint64_id.set(l);
    ((aio_media_open.ReqOpenStart)localObject2).bytes_req_data.set(ByteStringMicro.copyFromUtf8(paramIntent));
    ((aio_media_open.ReqOpenStart)localObject2).bytes_req_sign.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    paramIntent = ((aio_media_open.ReqOpenStart)localObject2).toByteArray();
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.setSSOCommand("QQAIOMediaSvc.open_start");
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  private void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        aio_media_open.RspOpenIdentify localRspOpenIdentify = new aio_media_open.RspOpenIdentify();
        localRspOpenIdentify.mergeFrom(paramFromServiceMsg);
        if (!localRspOpenIdentify.bytes_button_text.has())
        {
          paramFromServiceMsg = "";
          if (!localRspOpenIdentify.bytes_confirm_text.has())
          {
            localObject = "";
            if (!localRspOpenIdentify.msg_result.has()) {
              break label297;
            }
            localResultInfo = a((aio_media_open.ResultInfo)localRspOpenIdentify.msg_result.get());
            if (localRspOpenIdentify.uint32_business_type.has()) {
              continue;
            }
            i = 0;
            paramFromServiceMsg = new RspOpenIdentify(localResultInfo, paramFromServiceMsg, (String)localObject, i);
            localObject = new Bundle();
            ((Bundle)localObject).putSerializable("QQAIOMediaSvc.open_identify", paramFromServiceMsg);
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.d("TogetherBusinessServlet", 2, new Object[] { "handleIdentifyPackage succsss=", paramFromServiceMsg });
            }
            notifyObserver(paramIntent, 12, true, (Bundle)localObject, null);
          }
        }
        else
        {
          paramFromServiceMsg = localRspOpenIdentify.bytes_button_text.get().toStringUtf8();
          continue;
        }
        localObject = localRspOpenIdentify.bytes_confirm_text.get().toStringUtf8();
        continue;
        int i = localRspOpenIdentify.uint32_business_type.get();
        continue;
        QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage error=", paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 12, false, null, null);
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      return;
      notifyObserver(paramIntent, 12, false, null, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage not ok");
      return;
      label297:
      ResultInfo localResultInfo = null;
    }
  }
  
  private void t(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new aio_media_open.RspOpenStart();
        ((aio_media_open.RspOpenStart)localObject).mergeFrom(paramFromServiceMsg);
        int i;
        if (!((aio_media_open.RspOpenStart)localObject).enum_jump_type.has())
        {
          i = -1;
          if (!((aio_media_open.RspOpenStart)localObject).bytes_jump_url.has())
          {
            paramFromServiceMsg = "";
            if (!((aio_media_open.RspOpenStart)localObject).msg_result.has()) {
              break label286;
            }
            localObject = a((aio_media_open.ResultInfo)((aio_media_open.RspOpenStart)localObject).msg_result.get());
            paramFromServiceMsg = new RspOpenStart((ResultInfo)localObject, i, paramFromServiceMsg);
            localObject = new Bundle();
            ((Bundle)localObject).putSerializable("QQAIOMediaSvc.open_start", paramFromServiceMsg);
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.d("TogetherBusinessServlet", 2, new Object[] { "handleStartPackage succsss=", paramFromServiceMsg });
            }
            if (paramIntent.getBundleExtra("bundle") != null) {
              ((Bundle)localObject).putBundle("bundle", paramIntent.getBundleExtra("bundle"));
            }
            notifyObserver(paramIntent, 13, true, (Bundle)localObject, null);
          }
        }
        else
        {
          i = ((aio_media_open.RspOpenStart)localObject).enum_jump_type.get();
          continue;
        }
        paramFromServiceMsg = ((aio_media_open.RspOpenStart)localObject).bytes_jump_url.get().toStringUtf8();
        continue;
        QLog.d("TogetherBusinessServlet", 2, "handleStartPackage error=", paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 13, false, null, null);
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      return;
      notifyObserver(paramIntent, 13, false, null, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TogetherBusinessServlet", 2, "handleStartPackage not ok");
      return;
      label286:
      Object localObject = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    String str1;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
      if (bool)
      {
        str1 = "";
        QLog.d("TogetherBusinessServlet", 2, str1 + " success");
      }
    }
    else
    {
      if (!"QQAIOMediaSvc.open_identify".equals(str2)) {
        break label99;
      }
      s(paramIntent, paramFromServiceMsg);
    }
    label99:
    while (!"QQAIOMediaSvc.open_start".equals(str2))
    {
      return;
      str1 = "not";
      break;
    }
    t(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessServlet", 2, "req:" + str);
    }
    if ("QQAIOMediaSvc.open_identify".equals(str)) {
      j(paramIntent, paramPacket);
    }
    while (!"QQAIOMediaSvc.open_start".equals(str)) {
      return;
    }
    k(paramIntent, paramPacket);
  }
  
  public static final class ResultInfo
    implements Serializable
  {
    public final String errorMsg;
    public final int resultCode;
    public final boolean showErrorMsg;
    
    public ResultInfo(int paramInt, String paramString, boolean paramBoolean)
    {
      this.resultCode = paramInt;
      this.errorMsg = paramString;
      this.showErrorMsg = paramBoolean;
    }
    
    public String toString()
    {
      return "ResultInfo=" + super.toString() + " resultCode=" + this.resultCode + " errorMsg=" + this.errorMsg + " showErrorMsg=" + this.showErrorMsg;
    }
  }
  
  public static final class RspOpenIdentify
    implements Serializable
  {
    public final int businessType;
    public final String buttonText;
    public final String confirmText;
    public final TogetherBusinessServlet.ResultInfo resultInfo;
    
    public RspOpenIdentify(TogetherBusinessServlet.ResultInfo paramResultInfo, String paramString1, String paramString2, int paramInt)
    {
      this.resultInfo = paramResultInfo;
      this.buttonText = paramString1;
      this.confirmText = paramString2;
      this.businessType = paramInt;
    }
    
    public String toString()
    {
      return "RspOpenIdentify=" + super.toString() + " buttonText=" + this.buttonText + " confirmText=" + this.confirmText + " resultInfo=" + this.resultInfo;
    }
  }
  
  public static final class RspOpenStart
    implements Serializable
  {
    public final int jumpType;
    public final String jumpUrl;
    public final TogetherBusinessServlet.ResultInfo resultInfo;
    
    public RspOpenStart(TogetherBusinessServlet.ResultInfo paramResultInfo, int paramInt, String paramString)
    {
      this.resultInfo = paramResultInfo;
      this.jumpType = paramInt;
      this.jumpUrl = paramString;
    }
    
    public String toString()
    {
      return "RspOpenStart=" + super.toString() + " jumpType=" + this.jumpType + " jumpUrl=" + this.jumpUrl + " resultInfo=" + this.resultInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet
 * JD-Core Version:    0.7.0.1
 */