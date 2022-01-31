package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_dynamic_search$ResponseBody
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int ITEM_GROUPS_FIELD_NUMBER = 4;
  public static final int KEY_WORD_FIELD_NUMBER = 3;
  public static final int RETCODE_FIELD_NUMBER = 2;
  public static final int SEARCH_ID_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBRepeatMessageField item_groups = PBField.initRepeatMessage(mobileqq_dynamic_search.ResultItemGroup.class);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBUInt64Field search_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "cmd", "retcode", "key_word", "item_groups", "search_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L) }, ResponseBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody
 * JD-Core Version:    0.7.0.1
 */