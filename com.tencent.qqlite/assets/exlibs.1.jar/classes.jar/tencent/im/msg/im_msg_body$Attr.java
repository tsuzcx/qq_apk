package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$Attr
  extends MessageMicro
{
  public static final int CHAR_SET_FIELD_NUMBER = 7;
  public static final int CODE_PAGE_FIELD_NUMBER = 1;
  public static final int COLOR_FIELD_NUMBER = 4;
  public static final int EFFECT_FIELD_NUMBER = 6;
  public static final int FONT_NAME_FIELD_NUMBER = 9;
  public static final int PITCH_AND_FAMILY_FIELD_NUMBER = 8;
  public static final int RANDOM_FIELD_NUMBER = 3;
  public static final int RESERVE_DATA_FIELD_NUMBER = 10;
  public static final int SIZE_FIELD_NUMBER = 5;
  public static final int TIME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field char_set = PBField.initUInt32(78);
  public final PBSInt32Field code_page = PBField.initSInt32(-1);
  public final PBUInt32Field color = PBField.initUInt32(0);
  public final PBUInt32Field effect = PBField.initUInt32(7);
  public final PBStringField font_name = PBField.initString("Times New Roman");
  public final PBUInt32Field pitch_and_family = PBField.initUInt32(90);
  public final PBUInt32Field random = PBField.initUInt32(0);
  public final PBBytesField reserve_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field size = PBField.initUInt32(10);
  public final PBUInt32Field time = PBField.initUInt32(1);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "code_page", "time", "random", "color", "size", "effect", "char_set", "pitch_and_family", "font_name", "reserve_data" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(7), Integer.valueOf(78), Integer.valueOf(90), "Times New Roman", localByteStringMicro }, Attr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.Attr
 * JD-Core Version:    0.7.0.1
 */