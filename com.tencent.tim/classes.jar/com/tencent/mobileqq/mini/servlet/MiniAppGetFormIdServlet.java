package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetFormIdRsp;
import android.content.Intent;
import android.os.Bundle;
import aqnv;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.app.Packet;

public class MiniAppGetFormIdServlet
  extends MiniAppAbstractServlet
{
  private static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetFormId";
  
  public MiniAppGetFormIdServlet()
  {
    this.observerId = 1020;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    INTERFACE.StGetFormIdRsp localStGetFormIdRsp = new INTERFACE.StGetFormIdRsp();
    localStGetFormIdRsp.mergeFrom(paramArrayOfByte);
    paramBundle.putString("formId", localStGetFormIdRsp.formId.get());
    notifyObserver(paramIntent, 1020, true, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("key_appid");
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte = new MiniAppGetFormIdServlet.1(this, (String)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetFormId");
    paramPacket.putSendData(aqnv.I((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetFormIdServlet
 * JD-Core Version:    0.7.0.1
 */