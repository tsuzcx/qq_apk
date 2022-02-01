package tencent.im.oidb.cmd0x9c6;

import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9c6
{
  public static final class InterestMsg
    extends MessageMicro<InterestMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_ddwUin", "msg_interest_tag", "rpt_latest_interest_tags", "uint32_mod_time" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, InterestMsg.class);
    public appoint_define.InterestTag msg_interest_tag = new appoint_define.InterestTag();
    public final PBRepeatMessageField<appoint_define.InterestTag> rpt_latest_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
    public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ddwUin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_uins", "uint32_tag_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_interests", "str_error" }, new Object[] { null, "" }, RspBody.class);
    public final PBRepeatMessageField<cmd0x9c6.InterestMsg> rpt_msg_interests = PBField.initRepeatMessage(cmd0x9c6.InterestMsg.class);
    public final PBStringField str_error = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c6.cmd0x9c6
 * JD-Core Version:    0.7.0.1
 */