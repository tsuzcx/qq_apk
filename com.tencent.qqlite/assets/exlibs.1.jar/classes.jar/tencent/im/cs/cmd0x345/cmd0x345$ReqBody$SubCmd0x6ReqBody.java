package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x6ReqBody
  extends MessageMicro
{
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 4;
  public static final int BYTES_SIG_FIELD_NUMBER = 13;
  public static final int BYTES_UUID_FIELD_NUMBER = 3;
  public static final int STR_DST_PHONE_NUMBER_FIELD_NUMBER = 12;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 7;
  public static final int STR_SRC_FILE_PATH_FIELD_NUMBER = 8;
  public static final int STR_SRC_PARENT_FOLDER_FIELD_NUMBER = 9;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 10;
  public static final int UINT32_DST_BUS_ID_FIELD_NUMBER = 1;
  public static final int UINT64_APP_ID_FIELD_NUMBER = 11;
  public static final int UINT64_DST_UIN_FIELD_NUMBER = 5;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 6;
  public static final int UINT64_SRC_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_TALK_TYPE_FIELD_NUMBER = 14;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_dst_phone_number = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_src_file_path = PBField.initString("");
  public final PBStringField str_src_parent_folder = PBField.initString("");
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_talk_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 74, 80, 88, 98, 106, 112 }, new String[] { "uint32_dst_bus_id", "uint64_src_uin", "bytes_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "str_src_file_path", "str_src_parent_folder", "uint32_client_type", "uint64_app_id", "str_dst_phone_number", "bytes_sig", "uint64_talk_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", localByteStringMicro3, Long.valueOf(0L) }, SubCmd0x6ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody
 * JD-Core Version:    0.7.0.1
 */