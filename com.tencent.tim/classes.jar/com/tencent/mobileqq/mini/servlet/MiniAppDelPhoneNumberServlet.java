package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersRsp;
import android.content.Intent;
import android.os.Bundle;
import aqnv;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class MiniAppDelPhoneNumberServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_user_info.DelPhoneNumbers";
  public static final String KEY_PURE_PHONE_NUMBER = "purePhoneNumber";
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    INTERFACE.StDelPhoneNumbersRsp localStDelPhoneNumbersRsp = new INTERFACE.StDelPhoneNumbersRsp();
    long l = paramBundle.getLong("retCode");
    String str = paramBundle.getString("errMsg");
    if ((localStDelPhoneNumbersRsp != null) && (l == 0L))
    {
      localStDelPhoneNumbersRsp.mergeFrom(paramArrayOfByte);
      notifyObserver(paramIntent, 1074, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1074, false, paramBundle, MiniAppObserver.class);
    QLog.e("MiniAppAbstractServlet", 1, "MiniAppDelPhoneNumberServlet retCode : " + l + "; errMsg : " + str);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    this.observerId = 1074;
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("purePhoneNumber");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new MiniAppDelPhoneNumberServlet.1(this, (String)localObject1, (String)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.DelPhoneNumbers");
    paramPacket.putSendData(aqnv.I((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppDelPhoneNumberServlet
 * JD-Core Version:    0.7.0.1
 */