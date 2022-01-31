package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyGetFileListRspBody$FileInfo
  extends MessageMicro
{
  public static final int BYTES_MD5_FIELD_NUMBER = 13;
  public static final int BYTES_SHA3_FIELD_NUMBER = 12;
  public static final int BYTES_SHA_FIELD_NUMBER = 11;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
  public static final int STR_FILE_PATH_FIELD_NUMBER = 1;
  public static final int STR_LOCAL_PATH_FIELD_NUMBER = 14;
  public static final int STR_UPLOADER_NAME_FIELD_NUMBER = 25;
  public static final int UINT32_BUS_ID_FIELD_NUMBER = 4;
  public static final int UINT32_DEAD_TIME_FIELD_NUMBER = 8;
  public static final int UINT32_DOWNLOAD_TIMES_FIELD_NUMBER = 10;
  public static final int UINT32_MODIFY_TIME_FIELD_NUMBER = 9;
  public static final int UINT32_UPLOAD_TIME_FIELD_NUMBER = 7;
  public static final int UINT32_UPLOAD_UIN_FIELD_NUMBER = 5;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 3;
  public static final int UINT64_UPLOADED_SIZE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBStringField str_uploader_name = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106, 114, 202 }, new String[] { "str_file_path", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint32_upload_uin", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", "" }, FileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo
 * JD-Core Version:    0.7.0.1
 */