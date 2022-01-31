package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$CustomFace
  extends MessageMicro
{
  public static final int BIZ_TYPE_FIELD_NUMBER = 17;
  public static final int BYTES_BUFFER_FIELD_NUMBER = 4;
  public static final int BYTES_FLAG_FIELD_NUMBER = 5;
  public static final int BYTES_GUID_FIELD_NUMBER = 1;
  public static final int BYTES_MD5_FIELD_NUMBER = 13;
  public static final int BYTES_OLD_DATA_FIELD_NUMBER = 6;
  public static final int BYTES_SIGNATURE_FIELD_NUMBER = 11;
  public static final int IMAGE_TYPE_FIELD_NUMBER = 20;
  public static final int INDEX_FIELD_NUMBER = 21;
  public static final int REPEAT_IMAGE_FIELD_NUMBER = 19;
  public static final int REPEAT_INDEX_FIELD_NUMBER = 18;
  public static final int STR_BIG_URL_FIELD_NUMBER = 15;
  public static final int STR_FILE_PATH_FIELD_NUMBER = 2;
  public static final int STR_ORIG_URL_FIELD_NUMBER = 16;
  public static final int STR_SHORTCUT_FIELD_NUMBER = 3;
  public static final int STR_THUMB_URL_FIELD_NUMBER = 14;
  public static final int UINT32_FILE_ID_FIELD_NUMBER = 7;
  public static final int UINT32_FILE_TYPE_FIELD_NUMBER = 10;
  public static final int UINT32_HEIGHT_FIELD_NUMBER = 23;
  public static final int UINT32_ORIGIN_FIELD_NUMBER = 26;
  public static final int UINT32_SERVER_IP_FIELD_NUMBER = 8;
  public static final int UINT32_SERVER_PORT_FIELD_NUMBER = 9;
  public static final int UINT32_SIZE_FIELD_NUMBER = 25;
  public static final int UINT32_SOURCE_FIELD_NUMBER = 24;
  public static final int UINT32_THUMB_HEIGHT_FIELD_NUMBER = 28;
  public static final int UINT32_THUMB_WIDTH_FIELD_NUMBER = 27;
  public static final int UINT32_USEFUL_FIELD_NUMBER = 12;
  public static final int UINT32_WIDTH_FIELD_NUMBER = 22;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field biz_type = PBField.initUInt32(0);
  public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_old_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field image_type = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field repeat_image = PBField.initUInt32(0);
  public final PBUInt32Field repeat_index = PBField.initUInt32(0);
  public final PBStringField str_big_url = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_orig_url = PBField.initString("");
  public final PBStringField str_shortcut = PBField.initString("");
  public final PBStringField str_thumb_url = PBField.initString("");
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_origin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_useful = PBField.initUInt32(0);
  public final PBUInt32Field uint32_width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224 }, new String[] { "bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height" }, new Object[] { localByteStringMicro1, "", "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CustomFace.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.CustomFace
 * JD-Core Version:    0.7.0.1
 */