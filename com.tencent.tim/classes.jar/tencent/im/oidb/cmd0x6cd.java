package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x6cd
{
  public static final class MessageRec
    extends MessageMicro<MessageRec>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_seq", "uint32_time", "bytes_content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, MessageRec.class);
    }
  }
  
  public static final class PullRedpointReq
    extends MessageMicro<PullRedpointReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_taskid", "uint64_last_pull_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PullRedpointReq.class);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_pull_seq = PBField.initUInt64(0L);
  }
  
  public static final class RedpointInfo
    extends MessageMicro<RedpointInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104, 114 }, new String[] { "uint32_taskid", "uint64_cur_seq", "uint64_pull_seq", "uint64_read_seq", "uint32_pull_times", "uint32_last_pull_time", "int32_remained_time", "uint32_last_recv_time", "uint64_from_id", "enum_redpoint_type", "msg_redpoint_extra_info", "str_config_version", "uint32_do_activity", "rpt_msg_unread_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(1), null, "", Integer.valueOf(0), null }, RedpointInfo.class);
    public final PBEnumField enum_redpoint_type = PBField.initEnum(1);
    public final PBInt32Field int32_remained_time = PBField.initInt32(0);
    public cmd0x6cd.RepointExtraInfo msg_redpoint_extra_info = new cmd0x6cd.RepointExtraInfo();
    public final PBRepeatMessageField<cmd0x6cd.MessageRec> rpt_msg_unread_msg = PBField.initRepeatMessage(cmd0x6cd.MessageRec.class);
    public final PBStringField str_config_version = PBField.initString("");
    public final PBUInt32Field uint32_do_activity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_pull_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_recv_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pull_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cur_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pull_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0L);
  }
  
  public static final class RepointExtraInfo
    extends MessageMicro<RepointExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_tips = PBField.initString("");
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_count", "str_icon_url", "str_tips", "bytes_data" }, new Object[] { Integer.valueOf(0), "", "", localByteStringMicro }, RepointExtraInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "rpt_last_pull_redpoint", "rpt_unfinished_redpoint", "msg_pull_single_task", "uint32_ret_msg_rec" }, new Object[] { null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public cmd0x6cd.PullRedpointReq msg_pull_single_task = new cmd0x6cd.PullRedpointReq();
    public final PBRepeatMessageField<cmd0x6cd.PullRedpointReq> rpt_last_pull_redpoint = PBField.initRepeatMessage(cmd0x6cd.PullRedpointReq.class);
    public final PBRepeatMessageField<cmd0x6cd.PullRedpointReq> rpt_unfinished_redpoint = PBField.initRepeatMessage(cmd0x6cd.PullRedpointReq.class);
    public final PBUInt32Field uint32_ret_msg_rec = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_redpoint", "rpt_unfinished_redpoint" }, new Object[] { null, null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x6cd.RedpointInfo> rpt_msg_redpoint = PBField.initRepeatMessage(cmd0x6cd.RedpointInfo.class);
    public final PBRepeatMessageField<cmd0x6cd.PullRedpointReq> rpt_unfinished_redpoint = PBField.initRepeatMessage(cmd0x6cd.PullRedpointReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cd
 * JD-Core Version:    0.7.0.1
 */