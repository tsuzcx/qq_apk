package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class signature$SignatureKickResult
  extends MessageMicro
{
  public static final int BYTES_DATA_FIELD_NUMBER = 3;
  public static final int STR_CONTENT_FIELD_NUMBER = 2;
  public static final int STR_TITLE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_title", "str_content", "bytes_data" }, new Object[] { "", "", localByteStringMicro }, SignatureKickResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.ims.signature.SignatureKickResult
 * JD-Core Version:    0.7.0.1
 */