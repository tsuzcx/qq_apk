package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x758
{
  public static final class InviteUinInfo
    extends MessageMicro<InviteUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint64_judge_group_code", "uint64_judge_conf_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, InviteUinInfo.class);
    public final PBUInt64Field uint64_judge_conf_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_judge_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "uint64_join_group_code", "be_invited_uin_info", "string_msg", "uint32_main_source_id", "uint32_sub_source_id", "string_verify_token", "uint32_verify_type" }, new Object[] { Long.valueOf(0L), null, "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x758.InviteUinInfo> be_invited_uin_info = PBField.initRepeatMessage(cmd0x758.InviteUinInfo.class);
    public final PBStringField string_msg = PBField.initString("");
    public final PBStringField string_verify_token = PBField.initString("");
    public final PBUInt32Field uint32_main_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_join_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint64_current_max_msgseq", "string_verify_url", "uint32_verify_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, RspBody.class);
    public final PBStringField string_verify_url = PBField.initString("");
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_current_max_msgseq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x758.cmd0x758
 * JD-Core Version:    0.7.0.1
 */