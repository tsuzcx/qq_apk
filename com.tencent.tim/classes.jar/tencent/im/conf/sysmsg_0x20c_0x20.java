package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_0x20c_0x20
{
  public static final class Convert2Group
    extends MessageMicro<Convert2Group>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "u64_operator", "u64_discuss_code", "u64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, Convert2Group.class);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
    public final PBUInt64Field u64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field u64_operator = PBField.initUInt64(0L);
  }
  
  public static final class MemberNumRemind
    extends MessageMicro<MemberNumRemind>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u64_discuss_code", "u32_mem_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MemberNumRemind.class);
    public final PBUInt32Field u32_mem_num = PBField.initUInt32(0);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
  }
  
  public static final class SysMsgBody
    extends MessageMicro<SysMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "u32_cmd", "msg_convert_to_group", "msg_mem_num_remind", "msg_upload_file_remind" }, new Object[] { Integer.valueOf(0), null, null, null }, SysMsgBody.class);
    public sysmsg_0x20c_0x20.Convert2Group msg_convert_to_group = new sysmsg_0x20c_0x20.Convert2Group();
    public sysmsg_0x20c_0x20.MemberNumRemind msg_mem_num_remind = new sysmsg_0x20c_0x20.MemberNumRemind();
    public sysmsg_0x20c_0x20.UploadFileRemind msg_upload_file_remind = new sysmsg_0x20c_0x20.UploadFileRemind();
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
  }
  
  public static final class UploadFileRemind
    extends MessageMicro<UploadFileRemind>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_discuss_code" }, new Object[] { Long.valueOf(0L) }, UploadFileRemind.class);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.conf.sysmsg_0x20c_0x20
 * JD-Core Version:    0.7.0.1
 */