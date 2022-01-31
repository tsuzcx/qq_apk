package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$NotOnlineFile
  extends MessageMicro
{
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 4;
  public static final int BYTES_FILE_NAME_FIELD_NUMBER = 5;
  public static final int BYTES_FILE_UUID_FIELD_NUMBER = 3;
  public static final int BYTES_NOTE_FIELD_NUMBER = 7;
  public static final int BYTES_SIG_FIELD_NUMBER = 2;
  public static final int UINT32_ABS_FILE_TYPE_FIELD_NUMBER = 53;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 54;
  public static final int UINT32_DANGER_EVEL_FIELD_NUMBER = 50;
  public static final int UINT32_EXPIRE_TIME_FIELD_NUMBER = 55;
  public static final int UINT32_FILE_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_LIFE_TIME_FIELD_NUMBER = 51;
  public static final int UINT32_MICRO_CLOUD_FIELD_NUMBER = 10;
  public static final int UINT32_RESERVED_FIELD_NUMBER = 8;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 9;
  public static final int UINT32_UPLOAD_TIME_FIELD_NUMBER = 52;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_note = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_micro_cloud = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 400, 408, 416, 424, 432, 440 }, new String[] { "uint32_file_type", "bytes_sig", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint64_file_size", "bytes_note", "uint32_reserved", "uint32_subcmd", "uint32_micro_cloud", "uint32_danger_evel", "uint32_life_time", "uint32_upload_time", "uint32_abs_file_type", "uint32_client_type", "uint32_expire_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NotOnlineFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.NotOnlineFile
 * JD-Core Version:    0.7.0.1
 */