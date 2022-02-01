package tencent.im.medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common
{
  public static final class BindInfo
    extends MessageMicro<BindInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_fri_uin", "str_fri_nick", "uint64_time", "uint32_bind_status" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0) }, BindInfo.class);
    public final PBStringField str_fri_nick = PBField.initString("");
    public final PBUInt32Field uint32_bind_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  }
  
  public static final class MedalInfo
    extends MessageMicro<MedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32, 42, 48, 56, 66, 90, 248, 290, 320, 328, 336, 344, 352, 360, 368, 378, 386, 392, 402, 410, 418, 426, 434, 442, 448, 456, 466, 472, 480, 488, 496 }, new String[] { "uint32_id", "uint32_type", "uint32_seq", "str_name", "uint32_newflag", "uint64_time", "msg_bind_fri", "str_desc", "uint32_level", "rpt_taskinfos", "uint32_point", "uint32_point_level2", "uint32_point_level3", "uint32_seq_level2", "uint32_seq_level3", "uint64_time_level2", "uint64_time_level3", "str_desc_level2", "str_desc_level3", "uint32_endtime", "str_detail_url", "str_detail_url_2", "str_detail_url_3", "str_task_desc", "str_task_desc_2", "str_task_desc_3", "uint32_level_count", "uint32_no_progress", "str_resource", "uint32_fromuin_level", "uint32_unread", "uint32_unread_2", "uint32_unread_3" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, "", Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MedalInfo.class);
    public common.BindInfo msg_bind_fri = new common.BindInfo();
    public final PBRepeatMessageField<common.MedalTaskInfo> rpt_taskinfos = PBField.initRepeatMessage(common.MedalTaskInfo.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_desc_level2 = PBField.initString("");
    public final PBStringField str_desc_level3 = PBField.initString("");
    public final PBStringField str_detail_url = PBField.initString("");
    public final PBStringField str_detail_url_2 = PBField.initString("");
    public final PBStringField str_detail_url_3 = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_resource = PBField.initString("");
    public final PBStringField str_task_desc = PBField.initString("");
    public final PBStringField str_task_desc_2 = PBField.initString("");
    public final PBStringField str_task_desc_3 = PBField.initString("");
    public final PBUInt32Field uint32_endtime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fromuin_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_newflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_no_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point_level2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point_level3 = PBField.initUInt32(0);
    public final PBUInt64Field uint32_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint32_seq_level2 = PBField.initUInt64(0L);
    public final PBUInt64Field uint32_seq_level3 = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_3 = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time_level2 = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time_level3 = PBField.initUInt64(0L);
  }
  
  public static final class MedalTaskInfo
    extends MessageMicro<MedalTaskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 256, 264, 272, 280 }, new String[] { "uint32_taskid", "int32_task_value", "uint32_tar_value", "uint32_tar_value_level2", "uint32_tar_value_level3" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MedalTaskInfo.class);
    public final PBInt32Field int32_task_value = PBField.initInt32(0);
    public final PBUInt32Field uint32_tar_value = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tar_value_level2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tar_value_level3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.medal.common
 * JD-Core Version:    0.7.0.1
 */