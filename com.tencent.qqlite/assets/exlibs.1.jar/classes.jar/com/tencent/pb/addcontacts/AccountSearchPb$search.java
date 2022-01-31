package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSearchPb$search
  extends MessageMicro
{
  public static final int COUNT_FIELD_NUMBER = 2;
  public static final int END_FIELD_NUMBER = 3;
  public static final int HIGHLIGHT_FIELD_NUMBER = 6;
  public static final int KEYWORD_FIELD_NUMBER = 4;
  public static final int LIST_FIELD_NUMBER = 5;
  public static final int START_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "start", "count", "end", "keyword", "list", "highlight" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, search.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field end = PBField.initUInt32(0);
  public final PBRepeatField highlight = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField keyword = PBField.initString("");
  public final PBRepeatMessageField list = PBField.initRepeatMessage(AccountSearchPb.record.class);
  public final PBInt32Field start = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.search
 * JD-Core Version:    0.7.0.1
 */