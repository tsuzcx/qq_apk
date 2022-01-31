package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SummaryCardBusiEntry$ui
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int JUMP_URL_FIELD_NUMBER = 4;
  public static final int TITLE_FIELD_NUMBER = 2;
  public static final int URL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "content", "jump_url" }, new Object[] { "", "", "", "" }, ui.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.ui
 * JD-Core Version:    0.7.0.1
 */