package tencent.im.oidb.cmd0x9c5;

import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9c5
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int RPT_UINT32_TAG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint32_tag_type" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Integer> rpt_uint32_tag_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_INTEREST_TAGS_FIELD_NUMBER = 1;
    public static final int STR_ERROR_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_interest_tags", "str_error" }, new Object[] { null, "" }, RspBody.class);
    public final PBRepeatMessageField<appoint_define.InterestTag> msg_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
    public final PBStringField str_error = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c5.cmd0x9c5
 * JD-Core Version:    0.7.0.1
 */