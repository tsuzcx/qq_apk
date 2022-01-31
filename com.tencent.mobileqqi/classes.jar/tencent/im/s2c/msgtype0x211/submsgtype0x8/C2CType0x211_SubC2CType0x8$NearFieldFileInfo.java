package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8$NearFieldFileInfo
  extends MessageMicro
{
  public static final int INT32_TIMEOUT_FIELD_NUMBER = 8;
  public static final int STR_FILE_MD5_FIELD_NUMBER = 3;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 1;
  public static final int STR_FILE_THUMB_MD5_FIELD_NUMBER = 5;
  public static final int STR_FILE_THUMB_URL_FIELD_NUMBER = 6;
  public static final int STR_FILE_URL_FIELD_NUMBER = 4;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_ID_FIELD_NUMBER = 9;
  public static final int UINT64_SESSION_ID_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 64, 72 }, new String[] { "str_file_name", "uint64_file_size", "str_file_md5", "str_file_url", "str_file_thumb_md5", "str_file_thumb_url", "uint64_session_id", "int32_timeout", "uint64_group_id" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, NearFieldFileInfo.class);
  public final PBInt32Field int32_timeout = PBField.initInt32(0);
  public final PBStringField str_file_md5 = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_file_thumb_md5 = PBField.initString("");
  public final PBStringField str_file_thumb_url = PBField.initString("");
  public final PBStringField str_file_url = PBField.initString("");
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NearFieldFileInfo
 * JD-Core Version:    0.7.0.1
 */