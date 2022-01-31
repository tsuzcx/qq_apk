package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$AIOTopTipsInfo
  extends MessageMicro
{
  public static final int OPT_BYTES_ACTIONDATA_A_FIELD_NUMBER = 8;
  public static final int OPT_BYTES_ACTIONDATA_FIELD_NUMBER = 6;
  public static final int OPT_BYTES_ACTIONDATA_I_FIELD_NUMBER = 7;
  public static final int OPT_BYTES_CONTENT_FIELD_NUMBER = 1;
  public static final int OPT_BYTES_URL_FIELD_NUMBER = 4;
  public static final int OPT_BYTES_URL_P_FIELD_NUMBER = 5;
  public static final int OPT_ENUM_ACTION_FIELD_NUMBER = 3;
  public static final int OPT_UINT32_ICON_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_actionData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_actionData_a = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_actionData_i = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField opt_bytes_url_p = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField opt_enum_action = PBField.initEnum(1);
  public final PBUInt32Field opt_uint32_icon = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "opt_bytes_content", "opt_uint32_icon", "opt_enum_action", "opt_bytes_url", "opt_bytes_url_p", "opt_bytes_actionData", "opt_bytes_actionData_i", "opt_bytes_actionData_a" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, AIOTopTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.AIOTopTipsInfo
 * JD-Core Version:    0.7.0.1
 */