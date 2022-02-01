package tencent.im.oidb.cmd0xe3a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3a
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_uin", "uint64_group_id", "uint32_group_type", "uint32_group_total_person", "uint64_last_graybar_insert_time", "uint32_graybar_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_graybar_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_total_person = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_graybar_insert_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_next_time_for_aio_report" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
    public final PBUInt64Field uint64_next_time_for_aio_report = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3a.oidb_0xe3a
 * JD-Core Version:    0.7.0.1
 */