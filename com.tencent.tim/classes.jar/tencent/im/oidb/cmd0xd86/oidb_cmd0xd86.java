package tencent.im.oidb.cmd0xd86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd86
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uin", "blocked_uin", "source_id", "sub_sourceid", "group_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field blocked_uin = PBField.initUInt64(0L);
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_sourceid = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd86.oidb_cmd0xd86
 * JD-Core Version:    0.7.0.1
 */