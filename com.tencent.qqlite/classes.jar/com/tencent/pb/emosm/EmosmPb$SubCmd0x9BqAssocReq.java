package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmosmPb$SubCmd0x9BqAssocReq
  extends MessageMicro
{
  public static final int RPT_STR_BQ_ITEM_ID_FIELD_NUMBER = 2;
  public static final int STR_KEY_WORD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_key_word", "rpt_str_bq_item_id" }, new Object[] { "", "" }, SubCmd0x9BqAssocReq.class);
  public final PBRepeatField rpt_str_bq_item_id = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_key_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x9BqAssocReq
 * JD-Core Version:    0.7.0.1
 */