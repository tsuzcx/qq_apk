package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6e7
{
  public static final class CombineKey
    extends MessageMicro<CombineKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_ext1", "uint64_ext2", "uint64_ext3" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, CombineKey.class);
    public final PBUInt64Field uint64_ext1 = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ext2 = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ext3 = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_group_code", "str_app_src", "str_version", "uint64_number", "combine_key" }, new Object[] { Long.valueOf(0L), "", "", Long.valueOf(0L), null }, ReqBody.class);
    public oidb_0x6e7.CombineKey combine_key = new oidb_0x6e7.CombineKey();
    public final PBStringField str_app_src = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_number = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_white", "uint32_interval", "int64_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBInt64Field int64_data = PBField.initInt64(0L);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_white = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e7.oidb_0x6e7
 * JD-Core Version:    0.7.0.1
 */