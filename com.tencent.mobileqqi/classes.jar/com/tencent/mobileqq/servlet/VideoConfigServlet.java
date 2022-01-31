package com.tencent.mobileqq.servlet;

import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
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
      paramVideoCallMsg = ByteBuffer.wrap(paramVideoCallMsg.vMsg);
      paramVideoCallMsg.position(39);
      while (paramVideoCallMsg.hasRemaining())
      {
        i = paramVideoCallMsg.getShort();
        j = paramVideoCallMsg.getShort();
        if (i != 12)
        {
          paramVideoCallMsg.position(paramVideoCallMsg.position() + j);
        }
        else if (j == 15)
        {
          i = paramVideoCallMsg.get();
          j = paramVideoCallMsg.get();
          if (paramVideoCallMsg.get() != 1) {
            break label228;
          }
          bool1 = true;
          AudioHelper.a(0, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = paramVideoCallMsg.get();
          j = paramVideoCallMsg.get();
          if (paramVideoCallMsg.get() != 1) {
            break label234;
          }
          bool1 = true;
          label139:
          AudioHelper.a(1, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = paramVideoCallMsg.get();
          j = paramVideoCallMsg.get();
          if (paramVideoCallMsg.get() != 1) {
            break label240;
          }
          bool1 = true;
          label175:
          AudioHelper.a(2, new AudioHelper.AudioPlayerParameter(i, j, bool1));
          i = paramVideoCallMsg.get();
          j = paramVideoCallMsg.get();
          if (paramVideoCallMsg.get() != 1) {
            break label246;
          }
        }
      }
    }
    label228:
    label234:
    label240:
    label246:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AudioHelper.a(3, new AudioHelper.AudioPlayerParameter(i, j, bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label139;
      bool1 = false;
      break label175;
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
    paramIntent.getInt("reqType", 0);
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
    paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.VideoConfigServlet
 * JD-Core Version:    0.7.0.1
 */