import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.ReqGroupVideo.ReqGetInvitedMemberList;
import com.tencent.av.ReqGroupVideo.ReqGroupVideoTerminate;
import com.tencent.av.ReqGroupVideo.RspGroupVideoTerminate;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.common.ErrorInfo;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.AVReport.ReceiverNodeStage;
import com.tencent.av.report.AVReport.SenderNodeStage;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.RspBody;
import tencent.im.cs.longconn.hd_video.VideoHead;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_ReqBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_RspBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625.OpenIDInfoReq;
import tencent.im.oidb.cmd0x626.Oidb_0x626.Tiny2Open_RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class iho
  extends MSFServlet
{
  private VideoAppInterface a;
  
  private void B(byte[] paramArrayOfByte)
  {
    QLog.w("VideoServlet", 1, "showNotification() enter");
    if (paramArrayOfByte == null)
    {
      QLog.w("VideoServlet", 1, "showNotification() return ! video_buff = null");
      return;
    }
    paramArrayOfByte = ihk.a(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (!paramArrayOfByte.sD()))
    {
      QLog.w("VideoServlet", 1, "showNotification() return ! videoPacket == null && videoPacket is not isRequestMsg");
      return;
    }
    ikp.kQ(34);
    jkq.a("VideoServlet", igv.a(3, String.valueOf(paramArrayOfByte.kY), new int[0]), this.a, paramArrayOfByte);
  }
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendMultiVideoAck, seq: " + paramMultiVideoMsg.msg_seq + ", videoMsg.type:" + paramMultiVideoMsg.type + ", videoMsg.from_uin:" + paramMultiVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramMultiVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramMultiVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 9);
    localNewIntent.putExtra("ver", paramMultiVideoMsg.ver);
    localNewIntent.putExtra("type", paramMultiVideoMsg.type);
    localNewIntent.putExtra("cscmd", paramMultiVideoMsg.csCmd);
    localNewIntent.putExtra("subcmd", paramMultiVideoMsg.subCmd);
    localNewIntent.putExtra("from_uin", paramMultiVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramMultiVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramMultiVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramMultiVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramMultiVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramMultiVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramMultiVideoMsg.msg_time);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  private void a(SharpVideoMsg paramSharpVideoMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "sendSharpVideoAck, seq: " + paramSharpVideoMsg.msg_seq + ", videoMsg.type:" + paramSharpVideoMsg.type + ", videoMsg.from_uin:" + paramSharpVideoMsg.from_uin + ", videoMsg.to_uin.get(0):" + paramSharpVideoMsg.to_uin.get(0) + ", +videoMsg.to_uin.size():" + paramSharpVideoMsg.to_uin.size());
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), iho.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("reqType", 5);
    localNewIntent.putExtra("ver", paramSharpVideoMsg.ver);
    localNewIntent.putExtra("type", paramSharpVideoMsg.type);
    localNewIntent.putExtra("from_uin", paramSharpVideoMsg.from_uin);
    localNewIntent.putExtra("to_uin", (Serializable)paramSharpVideoMsg.to_uin.get(0));
    localNewIntent.putExtra("video_buff", paramSharpVideoMsg.video_buff);
    localNewIntent.putExtra("msg_seq", paramSharpVideoMsg.msg_seq);
    localNewIntent.putExtra("msg_uid", paramSharpVideoMsg.msg_uid);
    localNewIntent.putExtra("msg_type", paramSharpVideoMsg.msg_type);
    localNewIntent.putExtra("msg_time", paramSharpVideoMsg.msg_time);
    localNewIntent.putExtra("terminal_type", paramSharpVideoMsg.call_type);
    localNewIntent.putExtra("erroMsg", "success");
    service(localNewIntent);
  }
  
  public static long[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject1;
    long l3;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("parseVideoMsgSubServiceTypeAndRoomID,").append(paramString2).append(" parseSubType:").append(paramString1).append(", buff.len=");
      if (paramArrayOfByte == null)
      {
        i = 0;
        QLog.d("VideoServlet", 2, i);
      }
    }
    else
    {
      j = -1;
      l3 = -1L;
      if (!"SharpSvr.c2sack".equalsIgnoreCase(paramString1)) {
        break label484;
      }
      localObject1 = new hd_video.RspBody();
      if (paramArrayOfByte == null) {
        break label407;
      }
    }
    for (;;)
    {
      int k;
      try
      {
        localObject1 = (hd_video.RspBody)((hd_video.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (((hd_video.RspBody)localObject1).msg_video_head.has())
        {
          localObject1 = (hd_video.VideoHead)((hd_video.RspBody)localObject1).msg_video_head.get();
          j = ((hd_video.VideoHead)localObject1).enum_body_type.get();
          l2 = ((hd_video.VideoHead)localObject1).uint64_uin.get();
          if (((hd_video.VideoHead)localObject1).int32_sub_service_type.has()) {
            i = ((hd_video.VideoHead)localObject1).int32_sub_service_type.get();
          }
        }
      }
      catch (Exception localException1)
      {
        j = -1;
        l2 = -1L;
      }
      try
      {
        k = ((hd_video.VideoHead)localObject1).uint32_seq.get();
        l1 = ((hd_video.VideoHead)localObject1).uint64_room_id.get();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          Object localObject2;
          l2 = -1L;
          j = i;
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, paramString2 + " bodyType=" + j + ", subServiceType=" + i + ", uin=" + l2 + ", seq=" + k + ", roomId=" + l1);
        }
        l2 = i;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder().append("parseVideoMsgSubServiceTypeAndRoomID,").append(paramString2).append(" parseSubType = ").append(paramString1).append(", buff.len = ");
          if (paramArrayOfByte != null) {
            break label933;
          }
          j = 0;
          QLog.d("VideoServlet", 2, j + ",subServiceType = " + i + ",roomId = " + l1);
        }
        return new long[] { l2, l1 };
      }
      catch (Exception localException4)
      {
        l2 = l1;
        j = i;
        break label427;
      }
      i = paramArrayOfByte.length;
      break;
      i = -1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("VideoServlet", 2, paramString2 + " head not exist");
      }
      label407:
      i = -1;
      l1 = -1L;
      continue;
      label427:
      l1 = l2;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("VideoServlet", 2, paramString2 + " invalid format:" + localException1.toString());
        l1 = l2;
        i = j;
        continue;
        label484:
        i = j;
        l1 = l3;
        if ("SharpSvr.s2c".equalsIgnoreCase(paramString1))
        {
          localObject2 = new hd_video.MsgBody();
          i = j;
          l1 = l3;
          if (paramArrayOfByte != null)
          {
            k = j;
            l2 = l3;
            for (;;)
            {
              try
              {
                localObject2 = (hd_video.MsgBody)((hd_video.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
                k = j;
                l2 = l3;
                if (!((hd_video.MsgBody)localObject2).msg_video_head.has()) {
                  break label868;
                }
                k = j;
                l2 = l3;
                localObject2 = (hd_video.VideoHead)((hd_video.MsgBody)localObject2).msg_video_head.get();
                k = j;
                l2 = l3;
                int m = ((hd_video.VideoHead)localObject2).enum_body_type.get();
                k = j;
                l2 = l3;
                long l4 = ((hd_video.VideoHead)localObject2).uint64_uin.get();
                k = j;
                l2 = l3;
                if (!((hd_video.VideoHead)localObject2).int32_sub_service_type.has()) {
                  break label862;
                }
                k = j;
                l2 = l3;
                j = ((hd_video.VideoHead)localObject2).int32_sub_service_type.get();
                k = j;
                l2 = l3;
                int n = ((hd_video.VideoHead)localObject2).uint32_seq.get();
                k = j;
                l2 = l3;
                l3 = ((hd_video.VideoHead)localObject2).uint64_room_id.get();
                i = j;
                l1 = l3;
                k = j;
                l2 = l3;
                if (!QLog.isColorLevel()) {
                  break;
                }
                k = j;
                l2 = l3;
                QLog.d("VideoServlet", 2, paramString2 + " bodyType=" + m + ", subServiceType=" + j + ", uin=" + l4 + ", seq=" + n + ", roomId=" + l3);
                i = j;
                l1 = l3;
              }
              catch (Exception localException2)
              {
                i = k;
                l1 = l2;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("VideoServlet", 2, paramString2 + " invalid format:" + localException2.toString());
              i = k;
              l1 = l2;
              break;
              label862:
              j = -1;
            }
            label868:
            i = j;
            l1 = l3;
            k = j;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              k = j;
              l2 = l3;
              QLog.e("VideoServlet", 2, paramString2 + " head not exist");
              i = j;
              l1 = l3;
              continue;
              label933:
              j = paramArrayOfByte.length;
            }
          }
        }
      }
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null)
    {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
      paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
    }
    for (;;)
    {
      ((VideoAppInterface)getAppRuntime()).f(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
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
        long l = jji.B(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  void a(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.I("onRsp_chat_room", paramIntent.getExtras());
    ilu localilu = null;
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    Object localObject = localilu;
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = localilu;
      if (i > 0)
      {
        localObject = new byte[i];
        aqoj.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
    }
    localilu = this.a.a();
    if (localilu != null) {
      localilu.a(paramInt, paramFromServiceMsg.isSuccess(), paramFromServiceMsg.getResultCode(), paramIntent, (byte[])localObject);
    }
  }
  
  void a(String paramString, Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.I("req_chat_room", paramBundle);
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand(paramString);
    paramPacket.setTimeout(10000L);
    paramString = paramBundle.getByteArray("vMsg");
    if (paramString != null) {
      paramPacket.putSendData(aqnv.I(paramString));
    }
  }
  
  void a(Packet paramPacket, Bundle paramBundle)
  {
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("MultiVideo.c2s");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = paramBundle.getByte("ver");
    localMultiVideoMsg.type = paramBundle.getByte("type");
    localMultiVideoMsg.csCmd = paramBundle.getShort("cscmd");
    localMultiVideoMsg.from_uin = u(String.valueOf(paramBundle.getLong("from_uin")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramBundle.getLong("toUin")));
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.msg_time = paramBundle.getLong("msg_time");
    localMultiVideoMsg.msg_type = paramBundle.getLong("msg_type");
    localMultiVideoMsg.msg_seq = paramBundle.getLong("msg_seq");
    localMultiVideoMsg.msg_uid = paramBundle.getLong("msg_uid");
    localMultiVideoMsg.video_buff = paramBundle.getByteArray("vMsg");
    paramPacket.addRequestPacket("MultiVideoMsg", localMultiVideoMsg);
  }
  
  void b(SharpVideoMsg paramSharpVideoMsg)
  {
    boolean bool = false;
    byte[] arrayOfByte = paramSharpVideoMsg.video_buff;
    long l1 = paramSharpVideoMsg.from_uin;
    long l2 = ((Long)paramSharpVideoMsg.to_uin.get(0)).longValue();
    Friends localFriends = (Friends)((VideoAppInterface)getAppRuntime()).getEntityManagerFactory(null).createEntityManager().find(Friends.class, String.valueOf(l1));
    Object localObject;
    if (localFriends != null)
    {
      localObject = localFriends.getFriendNick();
      bool = localFriends.isFriend();
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(l2));
      localBundle.putString("fromUin", jji.al(l1));
      localBundle.putByteArray("buffer", arrayOfByte);
      localBundle.putLong("time", paramSharpVideoMsg.msg_time);
      localBundle.putString("name", (String)localObject);
      localBundle.putBoolean("isFriend", bool);
      this.a.b().ai(localBundle);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleSharpVideoMessage, friendName[").append((String)localObject).append("], friendRemark[");
        if (localFriends != null) {
          break label245;
        }
      }
    }
    label245:
    for (paramSharpVideoMsg = "";; paramSharpVideoMsg = localFriends.remark)
    {
      QLog.w("VideoServlet", 1, paramSharpVideoMsg + "], isFriend[" + bool + "]");
      return;
      localObject = jji.al(l1);
      break;
    }
  }
  
  void b(Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.I("inviteMember_msg", paramBundle);
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("QQRTCSvc.group_video_invite_list");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    long l1 = paramBundle.getLong("groupuin");
    long l2 = paramBundle.getLong("groupcode");
    paramBundle = new ReqGroupVideo.ReqGetInvitedMemberList();
    paramBundle.uint64_group.set(l1);
    paramBundle.uint64_room_id.set(l2);
    paramPacket.putSendData(aqnv.I(paramBundle.toByteArray()));
  }
  
  void c(SharpVideoMsg paramSharpVideoMsg)
  {
    paramSharpVideoMsg = paramSharpVideoMsg.video_buff;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("buffer", paramSharpVideoMsg);
    this.a.b().aj(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "handle Sharp Video c2s Ack Message OK");
    }
  }
  
  /* Error */
  void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: ldc_w 626
    //   3: aload_1
    //   4: invokevirtual 401	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   7: invokestatic 407	com/tencent/mobileqq/utils/AudioHelper:I	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   10: aload_2
    //   11: invokevirtual 411	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   14: arraylength
    //   15: iconst_4
    //   16: isub
    //   17: istore_3
    //   18: iload_3
    //   19: newarray byte
    //   21: astore 11
    //   23: aload 11
    //   25: iconst_0
    //   26: aload_2
    //   27: invokevirtual 411	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   30: iconst_4
    //   31: iload_3
    //   32: invokestatic 420	aqoj:copyData	([BI[BII)V
    //   35: new 628	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList
    //   38: dup
    //   39: invokespecial 629	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:<init>	()V
    //   42: astore 10
    //   44: aload 10
    //   46: aload 11
    //   48: invokevirtual 630	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   51: pop
    //   52: aload 10
    //   54: getfield 634	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:result	Lcom/tencent/av/common$ErrorInfo;
    //   57: invokevirtual 637	com/tencent/av/common$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: checkcast 636	com/tencent/av/common$ErrorInfo
    //   63: astore_2
    //   64: aload_2
    //   65: invokestatic 642	ijl:a	(Lcom/tencent/av/common$ErrorInfo;)I
    //   68: istore 4
    //   70: aload_2
    //   71: getfield 646	com/tencent/av/common$ErrorInfo:bytes_errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   74: invokevirtual 649	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   77: ifeq +356 -> 433
    //   80: aload_2
    //   81: getfield 646	com/tencent/av/common$ErrorInfo:bytes_errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   84: invokevirtual 652	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   87: invokevirtual 657	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   90: astore_2
    //   91: aload 10
    //   93: getfield 658	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:uint64_group	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   96: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   99: lstore 5
    //   101: aload 10
    //   103: getfield 659	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:uint64_room_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   106: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   109: lstore 7
    //   111: new 108	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 499	java/util/ArrayList:<init>	()V
    //   118: astore 11
    //   120: aload 10
    //   122: getfield 663	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:rpt_member_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   125: invokevirtual 666	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   128: ifeq +74 -> 202
    //   131: iconst_0
    //   132: istore_3
    //   133: iload_3
    //   134: aload 10
    //   136: getfield 663	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:rpt_member_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   139: invokevirtual 667	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   142: if_icmpge +60 -> 202
    //   145: aload 10
    //   147: getfield 663	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:rpt_member_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   150: iload_3
    //   151: invokevirtual 670	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   154: checkcast 672	com/tencent/av/ReqGroupVideo$MemberInfo
    //   157: invokevirtual 673	com/tencent/av/ReqGroupVideo$MemberInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   160: checkcast 672	com/tencent/av/ReqGroupVideo$MemberInfo
    //   163: astore 12
    //   165: aload 11
    //   167: new 675	inx
    //   170: dup
    //   171: aload 12
    //   173: getfield 678	com/tencent/av/ReqGroupVideo$MemberInfo:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   176: invokevirtual 285	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   179: aload 12
    //   181: getfield 681	com/tencent/av/ReqGroupVideo$MemberInfo:uint32_invite_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: invokevirtual 300	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   187: i2l
    //   188: invokespecial 684	inx:<init>	(JJ)V
    //   191: invokevirtual 510	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   194: pop
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: goto -66 -> 133
    //   202: aload_1
    //   203: ldc_w 686
    //   206: iconst_1
    //   207: invokevirtual 690	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   210: istore 9
    //   212: aload_0
    //   213: getfield 61	iho:a	Lcom/tencent/av/app/VideoAppInterface;
    //   216: instanceof 132
    //   219: ifeq +170 -> 389
    //   222: aload_0
    //   223: getfield 61	iho:a	Lcom/tencent/av/app/VideoAppInterface;
    //   226: astore_1
    //   227: iload 9
    //   229: ifne +104 -> 333
    //   232: aload_1
    //   233: invokevirtual 576	com/tencent/av/app/VideoAppInterface:b	()Lcom/tencent/av/VideoController;
    //   236: lload 5
    //   238: lload 7
    //   240: aload 11
    //   242: invokevirtual 693	com/tencent/av/VideoController:b	(JJLjava/util/ArrayList;)V
    //   245: ldc 15
    //   247: iconst_1
    //   248: new 72	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 695
    //   258: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 4
    //   263: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 697
    //   269: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 699
    //   279: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: lload 5
    //   284: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 701
    //   290: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: lload 7
    //   295: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: ldc_w 703
    //   301: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: iload 9
    //   306: invokevirtual 591	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   309: ldc_w 705
    //   312: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 10
    //   317: getfield 663	com/tencent/av/ReqGroupVideo$RspGetInvitedMemberList:rpt_member_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   320: invokevirtual 667	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   323: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 23	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: return
    //   333: aload_0
    //   334: getfield 61	iho:a	Lcom/tencent/av/app/VideoAppInterface;
    //   337: iconst_4
    //   338: anewarray 707	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: sipush 709
    //   346: invokestatic 712	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: lload 5
    //   354: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: lload 7
    //   362: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: aload 11
    //   370: aastore
    //   371: invokevirtual 716	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   374: goto -129 -> 245
    //   377: astore_1
    //   378: ldc 15
    //   380: iconst_1
    //   381: ldc_w 718
    //   384: aload_1
    //   385: invokestatic 721	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   388: return
    //   389: aload_0
    //   390: getfield 61	iho:a	Lcom/tencent/av/app/VideoAppInterface;
    //   393: iconst_4
    //   394: anewarray 707	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: sipush 708
    //   402: invokestatic 712	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   405: aastore
    //   406: dup
    //   407: iconst_1
    //   408: lload 5
    //   410: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: lload 7
    //   418: invokestatic 506	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   421: aastore
    //   422: dup
    //   423: iconst_3
    //   424: aload 11
    //   426: aastore
    //   427: invokevirtual 716	com/tencent/av/app/VideoAppInterface:l	([Ljava/lang/Object;)V
    //   430: goto -185 -> 245
    //   433: ldc_w 372
    //   436: astore_2
    //   437: goto -346 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	iho
    //   0	440	1	paramIntent	Intent
    //   0	440	2	paramFromServiceMsg	FromServiceMsg
    //   17	182	3	i	int
    //   68	194	4	j	int
    //   99	310	5	l1	long
    //   109	308	7	l2	long
    //   210	95	9	bool	boolean
    //   42	274	10	localRspGetInvitedMemberList	com.tencent.av.ReqGroupVideo.RspGetInvitedMemberList
    //   21	404	11	localObject	Object
    //   163	17	12	localMemberInfo	com.tencent.av.ReqGroupVideo.MemberInfo
    // Exception table:
    //   from	to	target	type
    //   35	91	377	java/lang/Exception
    //   91	131	377	java/lang/Exception
    //   133	195	377	java/lang/Exception
    //   202	227	377	java/lang/Exception
    //   232	245	377	java/lang/Exception
    //   245	332	377	java/lang/Exception
    //   333	374	377	java/lang/Exception
    //   389	430	377	java/lang/Exception
  }
  
  void c(Packet paramPacket, Bundle paramBundle)
  {
    AudioHelper.I("req_group_video_terminate_msg", paramBundle);
    paramPacket.setServantName("MultiVideo");
    paramPacket.setFuncName("MultiVideoMsg");
    paramPacket.setSSOCommand("QQRTCSvc.group_video_terminate_msg");
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    long l1 = paramBundle.getLong("selfuin");
    long l2 = paramBundle.getLong("groupuin");
    long l3 = paramBundle.getLong("groupcode");
    paramBundle = new ReqGroupVideo.ReqGroupVideoTerminate();
    paramBundle.uint64_operator.set(l1);
    paramBundle.uint64_group.set(l2);
    paramBundle.uint64_room_id.set(l3);
    paramPacket.putSendData(aqnv.I(paramBundle.toByteArray()));
  }
  
  void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AudioHelper.I("onRsp_group_video_terminate_msg", paramIntent.getExtras());
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    paramIntent = new byte[i];
    aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    try
    {
      paramFromServiceMsg = new ReqGroupVideo.RspGroupVideoTerminate();
      paramFromServiceMsg.mergeFrom(paramIntent);
      paramIntent = (common.ErrorInfo)paramFromServiceMsg.result.get();
      i = ijl.a(paramIntent);
      if (paramIntent.bytes_errmsg.has()) {}
      for (paramIntent = paramIntent.bytes_errmsg.get().toStringUtf8();; paramIntent = "")
      {
        QLog.w("VideoServlet", 1, "onRsp_group_video_terminate_msg, uint32_errcode[" + i + "], bytes_errmsg[" + paramIntent + "]");
        return;
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.w("VideoServlet", 1, "onRsp_group_video_terminate_msg, Exception", paramIntent);
    }
  }
  
  void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(str2))
    {
      paramIntent = (String)paramFromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
      if (paramIntent != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "parse getGatewayIpMsg Ok " + paramIntent + " cmd " + str2);
        }
        this.a.b().S(paramIntent, 0);
      }
    }
    label648:
    label664:
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (MsfMsgUtil.getSetConnStatusMsg(null, 0).getServiceCmd().equalsIgnoreCase(str2))
            {
              paramIntent = (Integer)paramFromServiceMsg.getAttribute("status");
              if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, String.format("onReceive SetConnStatusMsg status=%s", new Object[] { paramIntent }));
              }
              if (paramIntent != null)
              {
                paramFromServiceMsg = this.a.a();
                if (paramFromServiceMsg != null) {
                  paramFromServiceMsg.kx(paramIntent.intValue());
                }
              }
            }
            else
            {
              int i;
              if ("OidbSvc.0x625".equalsIgnoreCase(str2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive");
                }
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    i = paramFromServiceMsg.getWupBuffer().length - 4;
                    paramIntent = new byte[i];
                    aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (paramFromServiceMsg.bytes_bodybuffer.has())
                  {
                    paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                    paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                    paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                    }
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                }
              }
              else
              {
                if (!"OidbSvc.0xa02".equalsIgnoreCase(str2)) {
                  break label664;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
                }
                if (!paramFromServiceMsg.isSuccess()) {
                  break label648;
                }
                try
                {
                  i = paramFromServiceMsg.getWupBuffer().length - 4;
                  paramIntent = new byte[i];
                  aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                  paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                  paramFromServiceMsg.mergeFrom(paramIntent);
                  if (paramFromServiceMsg.uint32_result.get() != 0)
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                  }
                }
                catch (Exception paramIntent)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                  }
                  paramIntent.printStackTrace();
                  return;
                }
              }
            }
          }
        } while (!paramFromServiceMsg.bytes_bodybuffer.has());
        paramIntent = new cmd0xa02.RspBody();
        paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramIntent = paramIntent.rpt_tinyid2useracc_info.get();
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
        }
        new ArrayList();
        paramIntent = jkm.m(paramIntent);
        this.a.b().bx(paramIntent);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
      return;
      if ("QQRTCSvc.echo".equalsIgnoreCase(str2))
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "CMD_QQRTCSVC_ECHO onReceive isSuccess = " + bool);
        }
        this.a.b().hS(bool);
        return;
      }
      if ("QQRTCSvc.group_video_terminate_msg".equalsIgnoreCase(str2))
      {
        d(paramIntent, paramFromServiceMsg);
        return;
      }
      if ("QQRTCSvc.group_video_invite_list".equalsIgnoreCase(str2))
      {
        c(paramIntent, paramFromServiceMsg);
        return;
      }
      if ("CliLogSvc.UploadReq".equals(str2))
      {
        ClientLogReport.instance().handleServerResp(paramIntent, paramFromServiceMsg);
        return;
      }
      if ("QQRTCSvc.chatroom_get_msg".equalsIgnoreCase(str2))
      {
        a(22, paramIntent, paramFromServiceMsg);
        return;
      }
      if ("QQRTCSvc.chatroom_send_msg".equalsIgnoreCase(str2))
      {
        a(21, paramIntent, paramFromServiceMsg);
        return;
      }
      f(paramIntent, paramFromServiceMsg);
      localBundle = paramIntent.getExtras();
      byte[] arrayOfByte = localBundle.getByteArray("vMsg");
      String str1 = "null";
      paramIntent = str1;
      if (arrayOfByte != null)
      {
        paramIntent = str1;
        if (arrayOfByte.length > 2) {
          paramIntent = String.valueOf(arrayOfByte[2]);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoServlet", 2, "handleRecieveMsg: cmd = " + str2 + ", friendUin = " + localBundle.getLong("toUin") + ", buffer[2] = " + paramIntent + ", result = " + String.valueOf(paramFromServiceMsg.isSuccess()));
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  int kG()
  {
    if (aqge.LR() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoServlet", 2, "phone ring mode is slient");
      }
      return 1;
    }
    return 0;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = ((VideoAppInterface)getAppRuntime());
    itm.a().Vc = true;
    itm.a().of = System.currentTimeMillis();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    label735:
    label1790:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            String str = paramFromServiceMsg.getServiceCmd();
            long l1 = 0L;
            if (paramIntent != null) {
              l1 = jlc.a(paramIntent);
            }
            Object localObject = new StringBuilder().append("onReceive, cmd[").append(str).append("], seq[").append(l1).append("], request[");
            if (paramIntent != null) {}
            for (boolean bool = true;; bool = false)
            {
              QLog.w("VideoServlet", 1, bool + "], currentThread[" + Thread.currentThread().getId() + "]");
              if ("SharpSvr.c2s".equalsIgnoreCase(str)) {
                anot.a(null, "CliOper", "", "", "0X80088B1", "0X80088B1", 0, 0, "", "", "", "");
              }
              if (paramIntent == null) {
                break;
              }
              e(paramIntent, paramFromServiceMsg);
              return;
            }
            int i;
            if ("SharpSvr.s2c".equalsIgnoreCase(str))
            {
              paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
              l1 = System.currentTimeMillis();
              localObject = a(paramIntent.video_buff, "SharpSvr.s2c", "--video--");
              i = (int)localObject[0];
              long l2 = localObject[1];
              QLog.w("VideoServlet", 1, "avideo onReceive[CMD_SHARPVIDEO_S2C] seq[" + paramIntent.msg_seq + "], msg_type[" + paramIntent.msg_type + "], type[" + paramIntent.type + "], serviceType[" + i + "], roomId[" + l2 + "]|" + l1);
              if (i != 1013)
              {
                if (paramIntent.msg_type == 3L)
                {
                  ihq.m("Video:Servlet", 5000L);
                  B(paramIntent.video_buff);
                  this.a.b().uploadSharpNode(209, String.valueOf(paramIntent.from_uin));
                  this.a.b().uploadSharpNode(200, String.valueOf(paramIntent.from_uin));
                  if (this.a.b().kx() != 0) {
                    break label735;
                  }
                  this.a.b().uploadSharpNode(205, String.valueOf(paramIntent.from_uin));
                }
                for (;;)
                {
                  if (!itm.a().isReported) {
                    itm.a().cx(paramIntent.msg_seq);
                  }
                  itm.a().a("eVideoRecvInviteMsg", 3L, paramIntent.msg_seq, ((Long)paramIntent.to_uin.get(0)).longValue(), paramIntent.from_uin, 0);
                  localObject = paramIntent.msg_seq + "-" + paramIntent.msg_uid;
                  this.a.e(paramIntent.from_uin, (String)localObject, anaz.gQ());
                  if (this.a.RA)
                  {
                    this.a.RA = false;
                    this.a.RB = true;
                    ikp.s(l2, 35);
                    localObject = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
                    if (localObject != null)
                    {
                      l1 = ((Long)localObject).longValue();
                      this.a.b().l(String.valueOf(paramIntent.from_uin), l1);
                    }
                  }
                  try
                  {
                    localObject = ihk.a(paramIntent.video_buff);
                    QLog.w("tagSharpSvr", 1, "<-- onReceive() cmd = " + str + " , msg_type = " + paramIntent.msg_type + ", bodyType = " + ((ihk.a)localObject).alZ);
                    a(paramIntent);
                    if ((!AVReport.a().UN) && (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage != AVReport.ReceiverNodeStage.other) && (paramFromServiceMsg.getAttributes() != null))
                    {
                      paramFromServiceMsg = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                      if (paramFromServiceMsg != null) {
                        AVReport.a().nw = ((Long)paramFromServiceMsg).longValue();
                      }
                    }
                    b(paramIntent);
                    return;
                    this.a.b().uploadSharpNode(204, String.valueOf(paramIntent.from_uin));
                    continue;
                    ikp.bT(l2);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      localException.printStackTrace();
                    }
                  }
                }
              }
            }
            else
            {
              if ("SharpSvr.c2sack".equalsIgnoreCase(localException))
              {
                if ((AVReport.a().UN) && (paramFromServiceMsg.getAttributes() != null))
                {
                  if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage != AVReport.SenderNodeStage.SendAVRoomReq) {
                    break label1164;
                  }
                  paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_net2msf_boot");
                  if (paramIntent != null) {
                    AVReport.a().nh = ((Long)paramIntent).longValue();
                  }
                  paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                  if (paramIntent != null) {
                    AVReport.a().ne = ((Long)paramIntent).longValue();
                  }
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "Receive sharp video message c2s ack,cmd=SharpSvr.c2sack");
                  }
                  paramIntent = (SharpVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
                  paramFromServiceMsg = a(paramIntent.video_buff, "SharpSvr.c2sack", "--video--");
                  i = (int)paramFromServiceMsg[0];
                  l1 = paramFromServiceMsg[1];
                  QLog.w("VideoServlet", 1, "avideo onReceive[c2s ack], seq[" + paramIntent.msg_seq + "], msg_type[" + paramIntent.msg_type + "], type[" + paramIntent.type + "], serviceType[" + i + "], roomId[" + l1 + "]");
                  if (i == 1013) {
                    break;
                  }
                  if (paramIntent.msg_type == 2L)
                  {
                    paramFromServiceMsg = igv.a().a();
                    if (paramFromServiceMsg != null)
                    {
                      paramFromServiceMsg.bP(l1);
                      if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "avideo onReceive set sessioninfo roomid ,id = " + l1);
                      }
                      ((ikr)this.a.a(4)).bV(l1);
                    }
                  }
                  try
                  {
                    paramFromServiceMsg = ihk.a(paramIntent.video_buff);
                    QLog.w("tagSharpSvr", 1, "<-- onReceive() cmd = " + localException + " , msg_type = " + paramIntent.msg_type + ", bodyType = " + paramFromServiceMsg.alZ);
                    c(paramIntent);
                    return;
                    if (AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage == AVReport.SenderNodeStage.SendRequestReq)
                    {
                      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.other;
                      paramIntent = paramFromServiceMsg.getAttributes().get("__timestamp_msf2net_boot_sharp_c2s");
                      if (paramIntent != null) {
                        AVReport.a().nl = ((Long)paramIntent).longValue();
                      }
                    }
                  }
                  catch (Exception paramFromServiceMsg)
                  {
                    for (;;)
                    {
                      paramFromServiceMsg.printStackTrace();
                    }
                  }
                }
              }
              if ("MultiVideo.s2c".equalsIgnoreCase(localException))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
                }
                paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                a(paramIntent);
                this.a.b().w(paramIntent.video_buff);
                return;
              }
              if ("MultiVideo.c2sack".equalsIgnoreCase(localException))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "Receive multi video message c2s ack,cmd=MultiVideo.c2sack");
                }
                paramIntent = (MultiVideoMsg)decodePacket(paramFromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
                this.a.b().x(paramIntent.video_buff);
                return;
              }
              if ("OidbSvc.0x625".equalsIgnoreCase(localException))
              {
                if (paramFromServiceMsg.isSuccess())
                {
                  try
                  {
                    paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
                    paramIntent = new byte[paramFromServiceMsg.getInt() - 4];
                    paramFromServiceMsg.get(paramIntent);
                    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                    paramFromServiceMsg.mergeFrom(paramIntent);
                    if (paramFromServiceMsg.uint32_result.get() != 0)
                    {
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    paramIntent.printStackTrace();
                    return;
                  }
                  if (paramFromServiceMsg.bytes_bodybuffer.has())
                  {
                    paramIntent = new Oidb_0x625.Open2Tiny_RspBody();
                    paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                    paramIntent = paramIntent.msg_tinyid_rsp_info.get();
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + paramIntent.toString());
                    }
                  }
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                }
              }
              else
              {
                if (!"OidbSvc.0xa02".equalsIgnoreCase(localException)) {
                  break label1806;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
                }
                if (!paramFromServiceMsg.isSuccess()) {
                  break label1790;
                }
                try
                {
                  i = paramFromServiceMsg.getWupBuffer().length - 4;
                  paramIntent = new byte[i];
                  aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
                  paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
                  paramFromServiceMsg.mergeFrom(paramIntent);
                  if (paramFromServiceMsg.uint32_result.get() != 0)
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + paramFromServiceMsg.uint32_result.get());
                  }
                }
                catch (Exception paramIntent)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                  }
                  paramIntent.printStackTrace();
                  return;
                }
              }
            }
          }
        } while (!paramFromServiceMsg.bytes_bodybuffer.has());
        paramIntent = new Oidb_0x626.Tiny2Open_RspBody();
        paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramIntent = paramIntent.msg_openid_rsp_info.get();
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + paramIntent.toString());
      return;
    } while (!QLog.isColorLevel());
    label1164:
    QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
    return;
    label1806:
    f(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            long l2 = jlc.a(paramIntent);
            long l1 = l2;
            if (l2 == 0L)
            {
              l1 = AudioHelper.hG();
              jlc.a(paramIntent, l1);
            }
            i = ((Bundle)localObject1).getInt("reqType", -1);
            QLog.w("VideoServlet", 1, "onSend, reqType[" + i + "], seq[" + l1 + "]");
            switch (i)
            {
            case 11: 
            case 16: 
            case 17: 
            default: 
              paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
              if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, " onSend " + paramIntent);
              }
              break;
            }
          } while (paramIntent == null);
          QLog.d("VideoServlet", 2, " onSend " + paramIntent.getServiceCmd());
          paramPacket.setSSOCommand(paramIntent.getServiceCmd());
          paramPacket.putSendData(paramIntent.getWupBuffer());
          paramPacket.setTimeout(paramIntent.getTimeout());
          paramPacket.setAttributes(paramIntent.getAttributes());
        } while (paramIntent.isNeedCallback());
        paramPacket.setNoResponse();
        return;
        paramPacket.setServantName("VideoSvc");
        paramPacket.setFuncName("SendVideoMsg");
        paramPacket.setSSOCommand("VideoCCSvc.Adaptation");
        paramIntent = new VideoCallMsg();
        paramIntent.ver = 1;
        paramIntent.type = 1;
        paramIntent.lUin = u(((Bundle)localObject1).getString("selfuin"));
        paramIntent.lPeerUin = ((Bundle)localObject1).getLong("toUin");
        paramIntent.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
        paramIntent.cVerifyType = 0;
        paramIntent.uSeqId = 0;
        paramIntent.uSessionId = 0;
        paramIntent.vMsg = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("VideoCallMsg", paramIntent);
        return;
        anot.a(null, "CliOper", "", "", "0X80088B0", "0X80088B0", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!!=====");
        }
        paramPacket.setServantName("SharpSvr");
        paramPacket.setFuncName("c2s");
        paramPacket.setSSOCommand("SharpSvr.c2s");
        paramPacket.setNoResponse();
        paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
        paramIntent = new SharpVideoMsg();
        paramIntent.ver = 1;
        paramIntent.type = 1;
        paramIntent.from_uin = u(String.valueOf(((Bundle)localObject1).getLong("selfuin")));
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject1).getLong("toUin")));
        paramIntent.to_uin = ((ArrayList)localObject3);
        paramIntent.msg_time = 0L;
        paramIntent.msg_type = 0L;
        paramIntent.msg_seq = 0L;
        paramIntent.msg_uid = 0L;
        paramIntent.video_buff = ((Bundle)localObject1).getByteArray("vMsg");
        paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
        try
        {
          paramPacket = ihk.a(paramIntent.video_buff);
          QLog.w("tagSharpSvr", 1, "--> onSend() cmd = SharpSvr.c2s , msg_type = " + paramIntent.msg_type + ", bodyType = " + paramPacket.alZ);
          return;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
        paramPacket = new ToServiceMsg(null, this.a.getCurrentAccountUin(), "SharpSvr.s2cack");
        paramPacket.setMsfCommand(MsfCommand.sendVideoAck);
        paramPacket.setNeedCallback(false);
        localObject3 = new SharpVideoMsg();
        ((SharpVideoMsg)localObject3).ver = ((Bundle)localObject1).getByte("ver");
        ((SharpVideoMsg)localObject3).type = ((Bundle)localObject1).getByte("type");
        ((SharpVideoMsg)localObject3).from_uin = u(String.valueOf(((Bundle)localObject1).getLong("from_uin")));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(((Bundle)localObject1).getLong("to_uin")));
        ((SharpVideoMsg)localObject3).to_uin = localArrayList;
        ((SharpVideoMsg)localObject3).msg_time = ((Bundle)localObject1).getLong("msg_time");
        ((SharpVideoMsg)localObject3).msg_type = ((Bundle)localObject1).getLong("msg_type");
        ((SharpVideoMsg)localObject3).msg_seq = ((Bundle)localObject1).getLong("msg_seq");
        ((SharpVideoMsg)localObject3).msg_uid = ((Bundle)localObject1).getLong("msg_uid");
        ((SharpVideoMsg)localObject3).video_buff = ((Bundle)localObject1).getByteArray("video_buff");
        ((SharpVideoMsg)localObject3).call_type = ((Bundle)localObject1).getShort("terminal_type");
        ((SharpVideoMsg)localObject3).client_state = kG();
        localObject1 = new UniPacket();
        ((UniPacket)localObject1).setServantName("SharpSvr");
        ((UniPacket)localObject1).setFuncName("s2cack");
        ((UniPacket)localObject1).put("SharpVideoMsg", localObject3);
        paramPacket.putWupBuffer(((UniPacket)localObject1).encode());
        paramPacket.addAttribute("stype", Long.valueOf(((SharpVideoMsg)localObject3).msg_type));
        if (((SharpVideoMsg)localObject3).msg_type == 3L)
        {
          itm.a().a("eVideoSendACK", ((SharpVideoMsg)localObject3).msg_type, ((SharpVideoMsg)localObject3).msg_seq, ((Long)((SharpVideoMsg)localObject3).to_uin.get(0)).longValue(), ((SharpVideoMsg)localObject3).from_uin, 0);
          itm.a().aqC();
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoServlet", 2, "send sharp s2c ack message,cmd=s2cack seq:" + ((SharpVideoMsg)localObject3).msg_seq + " type:" + ((SharpVideoMsg)localObject3).msg_type);
        }
        try
        {
          localObject1 = ihk.a(((SharpVideoMsg)localObject3).video_buff);
          QLog.w("tagSharpSvr", 1, "--> onSend() cmd = SharpSvr.s2cack , msg_type = " + ((SharpVideoMsg)localObject3).msg_type + ", bodyType = " + ((ihk.a)localObject1).alZ);
          sendToMSF(paramIntent, paramPacket);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        paramIntent = new StrupBuff();
        paramIntent.prefix = "";
        localObject3 = new ArrayList();
        localObject2 = localException.getString("vMsg");
        if (localObject2 != null) {}
        try
        {
          ((ArrayList)localObject3).add(((String)localObject2).getBytes("utf-8"));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("custom_set", localObject3);
          paramIntent.logstring = new HashMap((Map)localObject2);
          paramIntent.encoding = 2;
          paramPacket.setSSOCommand("CliLogSvc.UploadReq");
          paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
          paramPacket.setFuncName("UploadReq");
          paramPacket.addRequestPacket("Data", paramIntent);
          paramPacket.setNoResponse();
          return;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
        paramPacket = MsfMsgUtil.getGatewayIpMsg(null);
        paramPacket.setTimeout(30000L);
        paramPacket.setNeedCallback(true);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.getAppid());
        sendToMSF(paramIntent, paramPacket);
        return;
        i = ((Bundle)localObject2).getInt("status");
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, String.format("onSend SetConnStatusMsg status=%s", new Object[] { Integer.valueOf(i) }));
        }
        paramPacket = MsfMsgUtil.getSetConnStatusMsg(null, i);
        paramPacket.setTimeout(30000L);
        paramPacket.setNeedCallback(true);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.getAppid());
        sendToMSF(paramIntent, paramPacket);
        return;
        boolean bool = ((Bundle)localObject2).getBoolean("keepAlive");
        if (QLog.isColorLevel()) {
          QLog.d("VideoServlet", 2, String.format("onSend keepProcessAliveMsg keepAlive=%s", new Object[] { Boolean.valueOf(bool) }));
        }
        paramPacket = MsfMsgUtil.keepProcessAliveMsg(null, bool);
        paramPacket.setNeedRemindSlowNetwork(false);
        paramPacket.setAppId(this.a.getAppid());
        sendToMSF(paramIntent, paramPacket);
        return;
        a(paramPacket, (Bundle)localObject2);
        return;
        c(paramPacket, (Bundle)localObject2);
        return;
        paramIntent.putExtra("requestInviteMemberMode", ((Bundle)localObject2).getBoolean("selfuin"));
        b(paramPacket, (Bundle)localObject2);
        return;
        paramPacket.setServantName("MultiVideo");
        paramPacket.setFuncName("MultiVideos2cack");
        paramPacket.setSSOCommand("MultiVideo.s2cack");
        paramIntent = new MultiVideoMsg();
        paramIntent.ver = ((Bundle)localObject2).getByte("ver");
        paramIntent.type = ((Bundle)localObject2).getByte("type");
        paramIntent.csCmd = ((Bundle)localObject2).getShort("cscmd");
        paramIntent.subCmd = ((Bundle)localObject2).getShort("subcmd");
        paramIntent.from_uin = u(String.valueOf(((Bundle)localObject2).getLong("from_uin")));
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject2).getLong("to_uin")));
        paramIntent.to_uin = ((ArrayList)localObject3);
        paramIntent.msg_time = ((Bundle)localObject2).getLong("msg_time");
        paramIntent.msg_type = ((Bundle)localObject2).getLong("msg_type");
        paramIntent.msg_seq = ((Bundle)localObject2).getLong("msg_seq");
        paramIntent.msg_uid = ((Bundle)localObject2).getLong("msg_uid");
        paramIntent.video_buff = ((Bundle)localObject2).getByteArray("video_buff");
        paramPacket.addRequestPacket("MultiVideoMsg", paramIntent);
        return;
        paramIntent = new Oidb_0x625.Open2Tiny_ReqBody();
        localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("openid_list");
        i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          localObject3 = new Oidb_0x625.OpenIDInfoReq();
          ((Oidb_0x625.OpenIDInfoReq)localObject3).bytes_openid.set(ByteStringMicro.copyFromUtf8((String)((ArrayList)localObject2).get(i)));
          ((Oidb_0x625.OpenIDInfoReq)localObject3).uint32_acounttype.set(101);
          ((Oidb_0x625.OpenIDInfoReq)localObject3).uint32_appid.set(1600000144);
          paramIntent.msg_openid_req_info.add((MessageMicro)localObject3);
          i += 1;
        }
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1573);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
        paramIntent = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
        localObject2 = new byte[paramIntent.length + 4];
        aqoj.DWord2Byte((byte[])localObject2, 0, paramIntent.length + 4);
        aqoj.b((byte[])localObject2, 4, paramIntent, paramIntent.length);
        paramPacket.setSSOCommand("OidbSvc.0x625");
        paramPacket.putSendData((byte[])localObject2);
      } while (!QLog.isColorLevel());
      QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onSend");
      return;
      paramIntent = new cmd0xa02.ReqBody();
      localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("tinyid_list");
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        localObject3 = new cmd0xa02.TinyID();
        ((cmd0xa02.TinyID)localObject3).uint64_tinyid.set(((Long)((ArrayList)localObject2).get(i)).longValue());
        paramIntent.rpt_tinyid.add((MessageMicro)localObject3);
        i += 1;
      }
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2562);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
      paramIntent = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localObject2 = new byte[paramIntent.length + 4];
      aqoj.DWord2Byte((byte[])localObject2, 0, paramIntent.length + 4);
      aqoj.b((byte[])localObject2, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("OidbSvc.0xa02");
      paramPacket.putSendData((byte[])localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("VideoServlet", 2, "CMD_OIDB_0xA02 onSend");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!! 0xc2=====");
    }
    paramPacket.setServantName("SharpSvr");
    paramPacket.setFuncName("c2s");
    paramPacket.setSSOCommand("SharpSvr.c2s");
    paramPacket.setNoResponse();
    paramPacket.addAttribute("remind_slown_network", Boolean.valueOf(true));
    paramIntent = new SharpVideoMsg();
    paramIntent.ver = 1;
    paramIntent.type = -62;
    paramIntent.from_uin = u(String.valueOf(((Bundle)localObject2).getLong("selfuin")));
    Object localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(Long.valueOf(((Bundle)localObject2).getLong("toUin")));
    paramIntent.to_uin = ((ArrayList)localObject3);
    paramIntent.msg_time = 0L;
    paramIntent.msg_type = 0L;
    paramIntent.msg_seq = 0L;
    paramIntent.msg_uid = 0L;
    paramIntent.video_buff = ((Bundle)localObject2).getByteArray("vMsg");
    paramPacket.addRequestPacket("SharpVideoMsg", paramIntent);
    return;
    paramPacket.setSSOCommand("QQRTCSvc.echo");
    paramPacket.setTimeout(10000L);
    if (QLog.isColorLevel()) {
      QLog.d("VideoServlet", 2, "onSend with cmd: CMD_QQRTCSVC_ECHO");
    }
    paramPacket.putSendData(aqnv.I(((Bundle)localObject2).getByteArray("vMsg")));
    return;
    a("QQRTCSvc.chatroom_get_msg", paramPacket, (Bundle)localObject2);
    return;
    a("QQRTCSvc.chatroom_send_msg", paramPacket, (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iho
 * JD-Core Version:    0.7.0.1
 */