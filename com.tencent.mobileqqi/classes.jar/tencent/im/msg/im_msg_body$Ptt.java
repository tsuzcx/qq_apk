package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$Ptt
  extends MessageMicro
{
  public static final int BOOL_VALID_FIELD_NUMBER = 11;
  public static final int BYTES_FILE_KEY_FIELD_NUMBER = 14;
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 4;
  public static final int BYTES_FILE_NAME_FIELD_NUMBER = 5;
  public static final int BYTES_FILE_UUID_FIELD_NUMBER = 3;
  public static final int BYTES_RESERVE_FIELD_NUMBER = 7;
  public static final int BYTES_SHORTCUT_FIELD_NUMBER = 13;
  public static final int BYTES_SIGNATURE_FIELD_NUMBER = 12;
  public static final int UINT32_FILE_ID_FIELD_NUMBER = 8;
  public static final int UINT32_FILE_SIZE_FIELD_NUMBER = 6;
  public static final int UINT32_FILE_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_MAGIC_PTT_INDEX_FIELD_NUMBER = 15;
  public static final int UINT32_SERVER_IP_FIELD_NUMBER = 9;
  public static final int UINT32_SERVER_PORT_FIELD_NUMBER = 10;
  public static final int UINT64_SRC_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_valid = PBField.initBool(false);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_shortcut = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_magic_ptt_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 106, 114, 120 }, new String[] { "uint32_file_type", "uint64_src_uin", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "bytes_reserve", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "bool_valid", "bytes_signature", "bytes_shortcut", "bytes_file_key", "uint32_magic_ptt_index" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0) }, Ptt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.Ptt
 * JD-Core Version:    0.7.0.1
 */