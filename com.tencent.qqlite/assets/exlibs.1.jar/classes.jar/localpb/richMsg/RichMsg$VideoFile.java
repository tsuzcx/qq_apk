package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$VideoFile
  extends MessageMicro
{
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 2;
  public static final int BYTES_FILE_NAME_FIELD_NUMBER = 3;
  public static final int BYTES_FILE_UUID_FIELD_NUMBER = 1;
  public static final int BYTES_SOURCE_FIELD_NUMBER = 13;
  public static final int BYTES_THUMB_FILE_MD5_FIELD_NUMBER = 12;
  public static final int FILE_LASTMODIFIED_FIELD_NUMBER = 14;
  public static final int UINT32_FILE_FORMAT_FIELD_NUMBER = 4;
  public static final int UINT32_FILE_PROGRESS_FIELD_NUMBER = 10;
  public static final int UINT32_FILE_SIZE_FIELD_NUMBER = 6;
  public static final int UINT32_FILE_STATUS_FIELD_NUMBER = 9;
  public static final int UINT32_FILE_TIME_FIELD_NUMBER = 5;
  public static final int UINT32_FILE_TYPE_FIELD_NUMBER = 11;
  public static final int UINT32_THUMB_HEIGHT_FIELD_NUMBER = 8;
  public static final int UINT32_THUMB_WIDTH_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_lastmodified = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_progress = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112 }, new String[] { "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_status", "uint32_file_progress", "uint32_file_type", "bytes_thumb_file_md5", "bytes_source", "file_lastmodified" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L) }, VideoFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.RichMsg.VideoFile
 * JD-Core Version:    0.7.0.1
 */