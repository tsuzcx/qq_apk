package tencent.im.oidb.cmd0xbd4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbd4
{
  public static final class InviteReq
    extends MessageMicro<InviteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_rowkey", "rpt_msg_invitee" }, new Object[] { "", null }, InviteReq.class);
    public final PBRepeatMessageField<oidb_cmd0xbd4.Invitee> rpt_msg_invitee = PBField.initRepeatMessage(oidb_cmd0xbd4.Invitee.class);
    public final PBStringField str_rowkey = PBField.initString("");
  }
  
  public static final class Invitee
    extends MessageMicro<Invitee>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_from", "uint32_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, Invitee.class);
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ts = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_invite_req" }, new Object[] { null }, ReqBody.class);
    public oidb_cmd0xbd4.InviteReq msg_invite_req = new oidb_cmd0xbd4.InviteReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4
 * JD-Core Version:    0.7.0.1
 */