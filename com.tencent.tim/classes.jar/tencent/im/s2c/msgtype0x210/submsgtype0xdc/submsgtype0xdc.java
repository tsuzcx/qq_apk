package tencent.im.s2c.msgtype0x210.submsgtype0xdc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xdc
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_msg_list", "uint32_msg_type", "rpt_msg_list_0x02", "minQqVer" }, new Object[] { null, Integer.valueOf(0), null, "" }, MsgBody.class);
    public final PBStringField minQqVer = PBField.initString("");
    public final PBRepeatMessageField<submsgtype0xdc.MsgContent> rpt_msg_list = PBField.initRepeatMessage(submsgtype0xdc.MsgContent.class);
    public final PBRepeatMessageField<submsgtype0xdc.MsgContent> rpt_msg_list_0x02 = PBField.initRepeatMessage(submsgtype0xdc.MsgContent.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  }
  
  public static final class MsgContent
    extends MessageMicro<MsgContent>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 114, 120 }, new String[] { "uint64_master_pri", "uint64_sub_pri", "uint64_show_times", "uint64_show_beg_ts", "uint64_exp_ts", "uint64_msg_sent_ts", "uint64_action_id", "str_wording", "str_scheme", "str_region_url", "uint64_wording_color", "uint64_msg_id", "uint64_bubble_id", "str_tips", "uint64_game_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Long.valueOf(0L) }, MsgContent.class);
    public final PBStringField str_region_url = PBField.initString("");
    public final PBStringField str_scheme = PBField.initString("");
    public final PBStringField str_tips = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt64Field uint64_action_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_bubble_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_exp_ts = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_game_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_master_pri = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_sent_ts = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_show_beg_ts = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_show_times = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sub_pri = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_wording_color = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc
 * JD-Core Version:    0.7.0.1
 */