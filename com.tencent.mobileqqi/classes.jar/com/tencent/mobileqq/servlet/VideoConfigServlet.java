package com.tencent.mobileqq.servlet;

import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class VideoConfigServlet
  extends MSFServlet
{
  private static final int a = 33;
  
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
  
  private void a(VideoCallMsg paramVideoCallMsg)
  {
    boolean bool2 = true;
    int i;
    int j;
    if ((paramVideoCallMsg != null) && (paramVideoCallMsg.vMsg != null) && (paramVideoCallMsg.vMsg.length > 39))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramVideoCallMsg.vMsg);
      localByteBuffer.position(39);
      while (localByteBuffer.hasRemaining())
      {
        i = localByteBuffer.getShort();
        j = localByteBuffer.getShort();
        if (i != 12)
        {
          localByteBuffer.position(localByteBuffer.position() + j);
        }
        else if (j == 15)
        {
          i = localByteBuffer.get();
          j = localByteBuffer.get();
          if (localByteBuffer.get() != 1) {
            break label305;
          }
          bool1 = true;
          AudioHelper.a(0, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = localByteBuffer.get();
          j = localByteBuffer.get();
          if (localByteBuffer.get() != 1) {
            break label311;
          }
          bool1 = true;
          label152:
          AudioHelper.a(1, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = localByteBuffer.get();
          j = localByteBuffer.get();
          if (localByteBuffer.get() != 1) {
            break label317;
          }
          bool1 = true;
          label191:
          AudioHelper.a(2, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = localByteBuffer.get();
          j = localByteBuffer.get();
          if (localByteBuffer.get() != 1) {
            break label323;
          }
        }
      }
    }
    label305:
    label311:
    label317:
    label323:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AudioHelper.a(3, new AudioHelper.AudioPlayerParameter(i, j, bool1));
      if (ConfigSystemImpl.a(String.valueOf(AppSetting.a), getAppRuntime().getApplication(), paramVideoCallMsg.vMsg))
      {
        paramVideoCallMsg = new Intent("tencent.video.q2v.UpdateConfig");
        paramVideoCallMsg.putExtra("uin", getAppRuntime().getAccount());
        getAppRuntime().getApplication().sendBroadcast(paramVideoCallMsg);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label152;
      bool1 = false;
      break label191;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((paramIntent != null) && ("VideoCCSvc.PutInfo".equalsIgnoreCase(str)))
    {
      if (!paramFromServiceMsg.isSuccess()) {
        break label64;
      }
      a((VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
      if (QLog.isColorLevel()) {
        QLog.d("svenxu", 2, "VideoConfigServlet receive resp: result = success");
      }
    }
    label64:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("svenxu", 2, "VideoConfigServlet receive resp: result = failed");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("svenxu", 2, "VideoConfigServlet send request.");
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getInt("reqType", 0) == 8)
    {
      paramPacket.setServantName("MultiVideo");
      paramPacket.setFuncName("MultiVideoMsg");
      paramPacket.setSSOCommand("MultiVideo.c2s");
      paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
      MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
      localMultiVideoMsg.ver = paramIntent.getByte("ver");
      localMultiVideoMsg.type = paramIntent.getByte("type");
      localMultiVideoMsg.csCmd = paramIntent.getShort("cscmd");
      localMultiVideoMsg.from_uin = a(String.valueOf(paramIntent.getLong("from_uin")));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramIntent.getLong("toUin")));
      localMultiVideoMsg.to_uin = localArrayList;
      localMultiVideoMsg.msg_time = paramIntent.getLong("msg_time");
      localMultiVideoMsg.msg_type = paramIntent.getLong("msg_type");
      localMultiVideoMsg.msg_seq = paramIntent.getLong("msg_seq");
      localMultiVideoMsg.msg_uid = paramIntent.getLong("msg_uid");
      localMultiVideoMsg.video_buff = paramIntent.getByteArray("vMsg");
      paramPacket.addRequestPacket("MultiVideoMsg", localMultiVideoMsg);
      return;
    }
    paramPacket.setServantName("VideoSvc");
    paramPacket.setFuncName("SendVideoMsg");
    paramPacket.setSSOCommand("VideoCCSvc.PutInfo");
    paramIntent = new VideoCallMsg();
    paramIntent.ver = 1;
    paramIntent.type = 1;
    paramIntent.lUin = a(getAppRuntime().getAccount());
    paramIntent.lPeerUin = 0L;
    paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    paramIntent.cVerifyType = 0;
    paramIntent.uSeqId = 0;
    paramIntent.uSessionId = 0;
    paramIntent.vMsg = ConfigSystemImpl.a(String.valueOf(AppSetting.a), getAppRuntime().getApplication());
    paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.VideoConfigServlet
 * JD-Core Version:    0.7.0.1
 */