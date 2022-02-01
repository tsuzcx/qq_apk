import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;

public class jlo
  extends accg
{
  static String TAG = "VideoC2CHandler";
  public C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader a = new C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader();
  public String mPeerUin;
  public long qh;
  
  public jlo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, anbn paramanbn, long paramLong1, int paramInt2, long paramLong2)
  {
    return anbh.a(this.app, paramInt1, paramString, paramanbn, paramLong1, paramInt2);
  }
  
  private void a(C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader paramMsgHeader)
  {
    if (this.mPeerUin != null)
    {
      long l = jji.B(this.mPeerUin);
      paramMsgHeader.uint64_to_uin.set(l);
    }
    if (this.qh != 0L) {
      paramMsgHeader.uint64_room_id.set(this.qh);
    }
    paramMsgHeader.setHasFlag(true);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, C2CType0x211_SubC2CType0xb.MsgBody paramMsgBody, long paramLong2)
  {
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "send0x211C2CQavMsg QavMsgRecord:" + paramLong2);
    }
    return a(paramLong1, this.mPeerUin, 529, 11, paramInt, paramMsgBody, paramLong2);
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_QAV", true);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    paramLong1 = ahav.ge();
    long l = ahav.bA();
    Object localObject = new anbn();
    ((anbn)localObject).dEY = paramInt2;
    ((anbn)localObject).msg = paramArrayOfByte;
    paramString = a(13, paramString, (anbn)localObject, l, anbk.ac(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.getAppId());
    paramArrayOfByte.uint32_instid.set(AppSetting.getAppId());
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    localObject = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(AppSetting.getAppId());
    paramArrayOfByte.uint32_instid.set(AppSetting.getAppId());
    ((im_msg_head.InstInfo)localObject).setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject);
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void axN()
  {
    C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
    a(this.a);
    this.a.uint32_body_type.set(102);
    this.a.uint32_session_type.set(0);
    localMsgBody.msg_msg_header.set(this.a);
    localMsgBody.setHasFlag(true);
    a(1L, 102, localMsgBody, 1L);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlo
 * JD-Core Version:    0.7.0.1
 */