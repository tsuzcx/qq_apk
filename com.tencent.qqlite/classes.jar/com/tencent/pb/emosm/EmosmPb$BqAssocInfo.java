package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$BqAssocInfo
  extends MessageMicro
{
  public static final int I32_TAB_RINGTYPE_FIELD_NUMBER = 5;
  public static final int I32_TAB_TYPE_FIELD_NUMBER = 4;
  public static final int RPT_STR_ITEM_KEYWORD_FIELD_NUMBER = 9;
  public static final int STR_ITEM_ID_FIELD_NUMBER = 6;
  public static final int STR_ITEM_KEY_FIELD_NUMBER = 8;
  public static final int STR_ITEM_NAME_FIELD_NUMBER = 7;
  public static final int STR_TAB_NAME_FIELD_NUMBER = 2;
  public static final int U32_TAB_FEETYPE_FIELD_NUMBER = 3;
  public static final int U32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66, 74 }, new String[] { "u32_tab_id", "str_tab_name", "u32_tab_feetype", "i32_tab_type", "i32_tab_ringtype", "str_item_id", "str_item_name", "str_item_key", "rpt_str_item_keyword" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, BqAssocInfo.class);
  public final PBInt32Field i32_tab_ringtype = PBField.initInt32(0);
  public final PBInt32Field i32_tab_type = PBField.initInt32(0);
  public final PBRepeatField rpt_str_item_keyword = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_item_id = PBField.initString("");
  public final PBStringField str_item_key = PBField.initString("");
  public final PBStringField str_item_name = PBField.initString("");
  public final PBStringField str_tab_name = PBField.initString("");
  public final PBUInt32Field u32_tab_feetype = PBField.initUInt32(0);
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.BqAssocInfo
 * JD-Core Version:    0.7.0.1
 */