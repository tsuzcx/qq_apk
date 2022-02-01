package tencent.im.oidb.cmd0x9e9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9e9
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_user", "uint32_start", "uint32_size" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public cmd0x9e9.User msg_user = new cmd0x9e9.User();
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_total_point", "int64_total_divide_point", "bool_is_end" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, RspBody.class);
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBInt64Field int64_total_divide_point = PBField.initInt64(0L);
    public final PBInt64Field int64_total_point = PBField.initInt64(0L);
  }
  
  public static final class User
    extends MessageMicro<User>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_client", "bytes_version", "uint32_portal" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, User.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9e9.cmd0x9e9
 * JD-Core Version:    0.7.0.1
 */