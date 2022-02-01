package tencent.im.oidb.cmd0xe63;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe63
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_req_type", "rpt_uint64_uin_for_check" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin_for_check = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bool_online_status_visible_to_all_frd", "rpt_uint64_uin_can_see_my_online_status", "rpt_uint64_uin_online_status_visible_to_me" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
    public final PBBoolField bool_online_status_visible_to_all_frd = PBField.initBool(false);
    public final PBRepeatField<Long> rpt_uint64_uin_can_see_my_online_status = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uin_online_status_visible_to_me = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe63.oidb_cmd0xe63
 * JD-Core Version:    0.7.0.1
 */