package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.medal.common.MedalInfo;

public final class cmd0x7a8
{
  public static final class MedalNews
    extends MessageMicro<MedalNews>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_fri_uin", "str_fri_nick", "msg_medal" }, new Object[] { Long.valueOf(0L), "", null }, MedalNews.class);
    public common.MedalInfo msg_medal = new common.MedalInfo();
    public final PBStringField str_fri_nick = PBField.initString("");
    public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 112, 120, 128, 136, 144 }, new String[] { "uint64_req_uin", "uint32_only_obtained", "uint32_read_report", "uint32_sort_type", "uint32_only_new", "rpt_filter_medal_ids", "uint32_only_summary", "uint32_do_scan", "uint32_start_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Integer> rpt_filter_medal_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_do_scan = PBField.initUInt32(0);
    public final PBUInt32Field uint32_only_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_only_obtained = PBField.initUInt32(0);
    public final PBUInt32Field uint32_only_summary = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_report = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 64, 72, 80, 90, 96 }, new String[] { "str_nick", "uint32_metal_rank", "uint32_fri_count", "uint32_metal_count", "uint32_metal_total", "rpt_msg_medal", "uint32_total_point", "int32_new_count", "int32_upgrade_count", "str_prompt_params", "uint32_now" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_new_count = PBField.initInt32(0);
    public final PBInt32Field int32_upgrade_count = PBField.initInt32(0);
    public final PBRepeatMessageField<common.MedalInfo> rpt_msg_medal = PBField.initRepeatMessage(common.MedalInfo.class);
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_prompt_params = PBField.initString("");
    public final PBUInt32Field uint32_fri_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_metal_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_metal_rank = PBField.initUInt32(0);
    public final PBUInt32Field uint32_metal_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_point = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7a8
 * JD-Core Version:    0.7.0.1
 */