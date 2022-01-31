package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_dynamic_search$RequestBody
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int EXTENSION_REQUEST_INFO_FIELD_NUMBER = 4;
  public static final int KEY_WORD_FIELD_NUMBER = 2;
  public static final int RESULT_ID_FIELD_NUMBER = 5;
  public static final int SEARCH_REQUEST_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public mobileqq_dynamic_search.ExtensionRequestInfo extension_request_info = new mobileqq_dynamic_search.ExtensionRequestInfo();
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_dynamic_search.RootSearcherRequest search_request = new mobileqq_dynamic_search.RootSearcherRequest();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "cmd", "key_word", "search_request", "extension_request_info", "result_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, localByteStringMicro2 }, RequestBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody
 * JD-Core Version:    0.7.0.1
 */