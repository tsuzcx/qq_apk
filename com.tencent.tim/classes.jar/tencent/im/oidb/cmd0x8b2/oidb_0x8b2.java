package tencent.im.oidb.cmd0x8b2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b2
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_clear_all_administrator = PBField.initBool(false);
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> uint64_administrator_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "string_hot_group_id", "uint64_administrator_uin", "bool_clear_all_administrator", "uint64_group_code" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_jumping_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> uint64_administrator_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "string_hot_group_id", "uint64_administrator_uin", "string_group_memo", "string_jumping_url", "uint64_modify_time", "uint64_group_code" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b2.oidb_0x8b2
 * JD-Core Version:    0.7.0.1
 */