package tencent.im.s2c.msgtype0x210.submsgtype0x66;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x66$MsgBody
  extends MessageMicro
{
  public static final int BYTES_PUSH_DATA_FIELD_NUMBER = 2;
  public static final int UINT32_TIMESTAMP_FIELD_NUMBER = 3;
  public static final int UINT32_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_push_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_push_data", "uint32_timestamp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody
 * JD-Core Version:    0.7.0.1
 */