import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xa02.cmd0xa02.ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class anfb
  extends MSFServlet
{
  private void a(VideoCallMsg paramVideoCallMsg)
  {
    boolean bool2 = false;
    if (paramVideoCallMsg == null)
    {
      igd.aK("VideoConfigServlet", "handleVideoConfigMessage error videoMsg = null");
      return;
    }
    int[] arrayOfInt;
    int i;
    int j;
    if ((paramVideoCallMsg != null) && (paramVideoCallMsg.vMsg != null))
    {
      arrayOfInt = imh.d(paramVideoCallMsg.vMsg);
      if (arrayOfInt != null)
      {
        i = arrayOfInt[0];
        j = arrayOfInt[1];
        if (arrayOfInt[2] != 1) {
          break label283;
        }
        bool1 = true;
        label61:
        AudioHelper.a(0, new AudioHelper.a(i, j, bool1));
        i = arrayOfInt[3];
        j = arrayOfInt[4];
        if (arrayOfInt[5] != 1) {
          break label289;
        }
        bool1 = true;
        label97:
        AudioHelper.a(1, new AudioHelper.a(i, j, bool1));
        i = arrayOfInt[6];
        j = arrayOfInt[7];
        if (arrayOfInt[8] != 1) {
          break label295;
        }
      }
    }
    label283:
    label289:
    label295:
    for (boolean bool1 = true;; bool1 = false)
    {
      AudioHelper.a(2, new AudioHelper.a(i, j, bool1));
      i = arrayOfInt[9];
      j = arrayOfInt[10];
      bool1 = bool2;
      if (arrayOfInt[11] == 1) {
        bool1 = true;
      }
      AudioHelper.a(3, new AudioHelper.a(i, j, bool1));
      bool1 = imh.isNeedStartVideoProcess(String.valueOf(AppSetting.getAppId()), getAppRuntime().getApplication(), paramVideoCallMsg.vMsg);
      QLog.d("VideoConfigServlet", 1, "handleVideoConfigMessage needStartVideoProc = " + bool1);
      if (!bool1) {
        break;
      }
      paramVideoCallMsg = new Intent("tencent.video.q2v.UpdateConfig");
      paramVideoCallMsg.putExtra("uin", getAppRuntime().getAccount());
      getAppRuntime().getApplication().sendBroadcast(paramVideoCallMsg);
      return;
      bool1 = false;
      break label61;
      bool1 = false;
      break label97;
    }
  }
  
  private long u(String paramString)
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
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (paramIntent != null)
    {
      if (!"VideoCCSvc.Adaptation".equalsIgnoreCase(str)) {
        break label85;
      }
      QLog.w("VideoConfigServlet", 1, "VideoConfigServlet, isSuccess[" + paramFromServiceMsg.isSuccess() + "]");
      if (paramFromServiceMsg.isSuccess()) {
        a((VideoCallMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "VideoCallMsg", new VideoCallMsg()));
      }
    }
    label85:
    do
    {
      do
      {
        do
        {
          return;
        } while (!"OidbSvc.0xa02".equalsIgnoreCase(str));
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        try
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramIntent = new byte[i];
          aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramIntent);
          if (paramFromServiceMsg.uint32_result.get() != 0)
          {
            igd.aJ("VideoConfigServlet", "cmd0xa02 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
            return;
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      } while (!paramFromServiceMsg.bytes_bodybuffer.has());
      paramIntent = new cmd0xa02.RspBody();
      paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramIntent = paramIntent.rpt_tinyid2useracc_info.get();
      igd.aJ("VideoConfigServlet", "cmd0xa02 onReceive list = " + paramIntent.toString());
      new ArrayList();
      paramIntent = jkm.m(paramIntent);
      paramFromServiceMsg = (QQAppInterface)getAppRuntime();
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg.a().bA(paramIntent);
    return;
    igd.aJ("VideoConfigServlet", "cmd0xa02 onReceive not success!");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (AudioHelper.aCz()) {
      AudioHelper.b("VideoConfigServlet.onSend", (Bundle)localObject1, true);
    }
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      i = ((Bundle)localObject1).getInt("reqType", 0);
      if (i == 8)
      {
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideoMsg");
        paramPacket.setSSOCommand("MultiVideo.c2s");
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject1).getByte("ver");
        paramIntent.type = ((Bundle)localObject1).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject1).getShort("cscmd");
        paramIntent.from_uin = u(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject2);
        paramIntent.msg_time = ((Bundle)localObject1).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject1).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject1).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject1).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
      }
      if (i != 15) {
        break;
      }
      paramIntent = new cmd0xa02.ReqBody();
      localObject1 = (ArrayList)((Bundle)localObject1).getSerializable("tinyid_list");
    } while (((ArrayList)localObject1).size() <= 0);
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = new cmd0xa02.TinyID();
      ((cmd0xa02.TinyID)localObject2).uint64_tinyid.set(((Long)((ArrayList)localObject1).get(i)).longValue());
      paramIntent.rpt_tinyid.add((MessageMicro)localObject2);
      i += 1;
    }
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2562);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    localObject1 = new byte[paramIntent.length + 4];
    aqoj.DWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
    aqoj.b((byte[])localObject1, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xa02");
    paramPacket.putSendData((byte[])localObject1);
    igd.aJ("VideoConfigServlet", "cmd0xa02 onSend");
    return;
    paramPacket.setServantName("VideoSvc");
    paramPacket.setFuncName("SendVideoMsg");
    paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
    paramIntent = new VideoCallMsg();
    paramIntent.ver = 1;
    paramIntent.type = 1;
    paramIntent.lUin = u(getAppRuntime().getAccount());
    paramIntent.lPeerUin = 0L;
    paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    paramIntent.cVerifyType = 0;
    paramIntent.uSeqId = 0;
    paramIntent.uSessionId = 0;
    paramIntent.vMsg = imh.a(paramIntent.lUin, String.valueOf(AppSetting.getAppId()), getAppRuntime().getApplication());
    paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfb
 * JD-Core Version:    0.7.0.1
 */