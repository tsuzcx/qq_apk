package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x6f5
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_qq_version", "uint32_qq_platform" }, new Object[] { "", Integer.valueOf(0) }, ReqBody.class);
    public final PBStringField str_qq_version = PBField.initString("");
    public final PBUInt32Field uint32_qq_platform = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_config_version", "rpt_task_info" }, new Object[] { "", null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x6f5.TaskInfo> rpt_task_info = PBField.initRepeatMessage(cmd0x6f5.TaskInfo.class);
    public final PBStringField str_config_version = PBField.initString("");
  }
  
  public static final class TaskInfo
    extends MessageMicro<TaskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_task_id", "uint32_appid", "uint32_passthrough_level", "uint32_show_level", "uint32_extra", "uint32_priority" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TaskInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_extra = PBField.initUInt32(0);
    public final PBUInt32Field uint32_passthrough_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f5
 * JD-Core Version:    0.7.0.1
 */