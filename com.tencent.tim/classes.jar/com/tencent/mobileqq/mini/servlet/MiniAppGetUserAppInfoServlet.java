package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppInfoRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.content.Intent;
import android.os.Bundle;
import aqnv;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;

public class MiniAppGetUserAppInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPIDS = "key_appids";
  public static final String KEY_EXT = "key_ext";
  public static final String TAG = "MiniAppGetUserAppInfoServlet";
  
  public MiniAppGetUserAppInfoServlet()
  {
    this.observerId = 1008;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    INTERFACE.StGetUserAppInfoRsp localStGetUserAppInfoRsp = new INTERFACE.StGetUserAppInfoRsp();
    localStGetUserAppInfoRsp.mergeFrom(paramArrayOfByte);
    if (localStGetUserAppInfoRsp.userAppList != null)
    {
      paramArrayOfByte = (INTERFACE.StUserAppInfo)localStGetUserAppInfoRsp.userAppList.get().get(0);
      paramBundle.putInt("like_num", paramArrayOfByte.likeNum.get());
      paramBundle.putInt("do_like", paramArrayOfByte.doLike.get());
      paramBundle.putSerializable("mini_app_info_data", MiniAppInfo.from(paramArrayOfByte));
      notifyObserver(paramIntent, 1008, true, paramBundle, MiniAppObserver.class);
      return;
    }
    notifyObserver(paramIntent, 1008, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject2 = paramIntent.getStringArrayListExtra("key_appids");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    int i = paramIntent.getIntExtra("key_index", -1);
    Object localObject1 = null;
    if (arrayOfByte != null) {
      localObject1 = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject1).mergeFrom(arrayOfByte);
      localObject2 = new GetUserAppInfoRequest((COMM.StCommonExt)localObject1, (List)localObject2).encode(paramIntent, i, getTraceId());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.mini_app_userapp.GetUserAppInfo");
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
          QLog.e("MiniAppGetUserAppInfoServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppInfoServlet
 * JD-Core Version:    0.7.0.1
 */