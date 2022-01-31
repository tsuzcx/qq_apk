package tencent.im.s2c.msgtype0x210.submsgtype0x1a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x1a$MsgBody
  extends MessageMicro
{
  public static final int BYTES_FILE_KEY_FIELD_NUMBER = 1;
  public static final int STRING_DESC_FIELD_NUMBER = 6;
  public static final int UINT32_CAPTURE_TIMES_FIELD_NUMBER = 8;
  public static final int UINT32_FROM_UIN_FIELD_NUMBER = 2;
  public static final int UINT32_STATUS_FIELD_NUMBER = 4;
  public static final int UINT32_TO_UIN_FIELD_NUMBER = 3;
  public static final int UINT32_TTL_FIELD_NUMBER = 5;
  public static final int UINT32_TYPE_FIELD_NUMBER = 7;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 9;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_desc = PBField.initString("");
  public final PBUInt32Field uint32_capture_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 80 }, new String[] { "bytes_file_key", "uint32_from_uin", "uint32_to_uin", "uint32_status", "uint32_ttl", "string_desc", "uint32_type", "uint32_capture_times", "uint64_from_uin", "uint64_to_uin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a.MsgBody
 * JD-Core Version:    0.7.0.1
 */