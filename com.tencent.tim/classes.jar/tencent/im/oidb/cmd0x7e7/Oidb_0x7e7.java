package tencent.im.oidb.cmd0x7e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x7e7
{
  public static final class PlatformInfo
    extends MessageMicro<PlatformInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field build_no = PBField.initUInt64(0L);
    public final PBBytesField os_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field pub_no = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "os_name", "build_no", "pub_no" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L) }, PlatformInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cmd_id = PBField.initUInt32(0);
    public final PBBytesField cmd_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field corp_uin = PBField.initUInt64(0L);
    public final PBUInt32Field env = PBField.initUInt32(0);
    public final PBBytesField json_string = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public Oidb_0x7e7.PlatformInfo platform_info = new Oidb_0x7e7.PlatformInfo();
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
    public final PBUInt64Field user_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64, 74 }, new String[] { "cmd_id", "cmd_key", "env", "platform", "platform_info", "corp_uin", "user_uin", "timestamp", "json_string" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2 }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBBytesField ret_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "ret_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7e7.Oidb_0x7e7
 * JD-Core Version:    0.7.0.1
 */