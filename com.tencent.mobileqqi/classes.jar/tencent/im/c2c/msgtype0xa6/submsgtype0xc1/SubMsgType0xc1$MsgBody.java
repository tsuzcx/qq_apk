package tencent.im.c2c.msgtype0xa6.submsgtype0xc1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xc1$MsgBody
  extends MessageMicro
{
  public static final int BYTES_ENCRYPT_KEY_FIELD_NUMBER = 9;
  public static final int BYTES_FILE_KEY_FIELD_NUMBER = 1;
  public static final int NOT_ONLINE_IMAGE_FIELD_NUMBER = 12;
  public static final int UINT32_ENCRYPT_PREHEAD_LENGTH_FIELD_NUMBER = 7;
  public static final int UINT32_ENCRYPT_TYPE_FIELD_NUMBER = 8;
  public static final int UINT32_LEFT_TIME_FIELD_NUMBER = 11;
  public static final int UINT32_READ_TIMES_FIELD_NUMBER = 10;
  public static final int UINT32_STATUS_FIELD_NUMBER = 4;
  public static final int UINT32_TTL_FIELD_NUMBER = 5;
  public static final int UINT32_TYPE_FIELD_NUMBER = 6;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_TO_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0xc1.NotOnlineImage not_online_image = new SubMsgType0xc1.NotOnlineImage();
  public final PBUInt32Field uint32_encrypt_prehead_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_encrypt_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98 }, new String[] { "bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1.MsgBody
 * JD-Core Version:    0.7.0.1
 */