package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import aqnv;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppGetAuthListServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_EXT = "key_ext";
  public static final String KEY_GET_AUTH_LIST_RESULT = "key_get_auth_list_result";
  public static final String TAG = "MiniAppGetAuthListServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
          continue;
        }
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(aqnv.J(paramFromServiceMsg.getWupBuffer()));
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppGetAuthListServlet", 2, "onReceive. inform MiniAppDelUserAppServlet resultcode success.");
        }
        localBundle.putByteArray("key_get_auth_list_result", localStQWebRsp.busiBuff.get().toByteArray());
        notifyObserver(paramIntent, 1043, true, localBundle, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppGetAuthListServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1043, false, localBundle, MiniAppObserver.class);
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppGetAuthListServlet", 2, "onReceive. inform MiniAppDelUserAppServlet resultcode fail.");
      }
      notifyObserver(paramIntent, 1043, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringExtra("key_appid");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetAuthListsRequest((COMM.StCommonExt)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_user_info.GetAuthList");
      paramPacket.putSendData(aqnv.I((byte[])localObject1));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      super.onSend(paramIntent, paramPacket);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppGetAuthListServlet", 2, "onSend. mergeFrom extData exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetAuthListServlet
 * JD-Core Version:    0.7.0.1
 */