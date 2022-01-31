package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x89a$GroupNewGuidelinesInfo
  extends MessageMicro
{
  public static final int BOOL_ENABLED_FIELD_NUMBER = 1;
  public static final int STRING_CONTENT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_enabled = PBField.initBool(false);
  public final PBBytesField string_content = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "bool_enabled", "string_content" }, new Object[] { Boolean.valueOf(false), localByteStringMicro }, GroupNewGuidelinesInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupNewGuidelinesInfo
 * JD-Core Version:    0.7.0.1
 */