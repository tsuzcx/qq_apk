package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$NotOnlineImage
  extends MessageMicro
{
  public static final int BIZ_TYPE_FIELD_NUMBER = 16;
  public static final int DOWNLOAD_PATH_FIELD_NUMBER = 3;
  public static final int FILE_LEN_FIELD_NUMBER = 2;
  public static final int FILE_PATH_FIELD_NUMBER = 1;
  public static final int FLAG_FIELD_NUMBER = 11;
  public static final int IMG_TYPE_FIELD_NUMBER = 5;
  public static final int INDEX_FIELD_NUMBER = 18;
  public static final int OLD_PIC_MD5_FIELD_NUMBER = 20;
  public static final int OLD_VER_SEND_FILE_FIELD_NUMBER = 4;
  public static final int OP_FACE_BUF_FIELD_NUMBER = 19;
  public static final int ORIGINAL_FIELD_NUMBER = 13;
  public static final int PIC_HEIGHT_FIELD_NUMBER = 8;
  public static final int PIC_MD5_FIELD_NUMBER = 7;
  public static final int PIC_WIDTH_FIELD_NUMBER = 9;
  public static final int PREVIEWS_IMAGE_FIELD_NUMBER = 6;
  public static final int RESULT_FIELD_NUMBER = 17;
  public static final int RES_ID_FIELD_NUMBER = 10;
  public static final int STR_BIG_URL_FIELD_NUMBER = 14;
  public static final int STR_ORIG_URL_FIELD_NUMBER = 15;
  public static final int STR_THUMB_URL_FIELD_NUMBER = 12;
  public static final int UINT32_FILE_ID_FIELD_NUMBER = 23;
  public static final int UINT32_THUMB_HEIGHT_FIELD_NUMBER = 22;
  public static final int UINT32_THUMB_WIDTH_FIELD_NUMBER = 21;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field biz_type = PBField.initUInt32(0);
  public final PBBytesField download_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field file_len = PBField.initUInt32(0);
  public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field img_type = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBBoolField old_pic_md5 = PBField.initBool(false);
  public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField op_face_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original = PBField.initUInt32(0);
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBBytesField previews_image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBStringField str_big_url = PBField.initString("");
  public final PBStringField str_orig_url = PBField.initString("");
  public final PBStringField str_thumb_url = PBField.initString("");
  public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 128, 136, 144, 154, 160, 168, 176, 184 }, new String[] { "file_path", "file_len", "download_path", "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", "res_id", "flag", "str_thumb_url", "original", "str_big_url", "str_orig_url", "biz_type", "result", "index", "op_face_buf", "old_pic_md5", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NotOnlineImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.NotOnlineImage
 * JD-Core Version:    0.7.0.1
 */