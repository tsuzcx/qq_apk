package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$STRecommendTabInfo
  extends MessageMicro
{
  public static final int I32_TAB_TYPE_FIELD_NUMBER = 3;
  public static final int STR_TAB_NAME_FIELD_NUMBER = 2;
  public static final int U32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "u32_tab_id", "str_tab_name", "i32_tab_type" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, STRecommendTabInfo.class);
  public final PBInt32Field i32_tab_type = PBField.initInt32(0);
  public final PBStringField str_tab_name = PBField.initString("");
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo
 * JD-Core Version:    0.7.0.1
 */