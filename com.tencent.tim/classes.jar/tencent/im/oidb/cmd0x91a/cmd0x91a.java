package tencent.im.oidb.cmd0x91a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public final class cmd0x91a
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_result_status", "uint32_audit_times_max", "uint32_audit_times_remain", "group_info", "uint64_group_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, RspBody.class);
    public oidb_0x88d.GroupInfo group_info = new oidb_0x88d.GroupInfo();
    public final PBUInt32Field uint32_audit_times_max = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audit_times_remain = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91a.cmd0x91a
 * JD-Core Version:    0.7.0.1
 */