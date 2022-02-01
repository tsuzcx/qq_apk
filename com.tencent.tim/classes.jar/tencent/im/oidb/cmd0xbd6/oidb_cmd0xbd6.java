package tencent.im.oidb.cmd0xbd6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbd6
{
  public static final class Invitee
    extends MessageMicro<Invitee>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_uin", "uint32_from", "uint32_ts" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, Invitee.class);
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ts = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_rowkey" }, new Object[] { "" }, ReqBody.class);
    public final PBStringField str_rowkey = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "invite_times_limit", "remain_invite_times", "rpt_msg_invited" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public final PBUInt32Field invite_times_limit = PBField.initUInt32(0);
    public final PBUInt32Field remain_invite_times = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xbd6.Invitee> rpt_msg_invited = PBField.initRepeatMessage(oidb_cmd0xbd6.Invitee.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6
 * JD-Core Version:    0.7.0.1
 */