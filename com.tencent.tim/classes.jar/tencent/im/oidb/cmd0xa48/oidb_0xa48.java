package tencent.im.oidb.cmd0xa48;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa48
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_groupcode" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_send_list_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0xa48.SendListRsp msg_send_list_rsp = new oidb_0xa48.SendListRsp();
  }
  
  public static final class SendItem
    extends MessageMicro<SendItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, SendItem.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SendListRsp
    extends MessageMicro<SendListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_today_birth", "rpt_send_gift", "rpt_recv_gift" }, new Object[] { null, null, null }, SendListRsp.class);
    public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_recv_gift = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
    public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_send_gift = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
    public final PBRepeatMessageField<oidb_0xa48.SendItem> rpt_today_birth = PBField.initRepeatMessage(oidb_0xa48.SendItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa48.oidb_0xa48
 * JD-Core Version:    0.7.0.1
 */