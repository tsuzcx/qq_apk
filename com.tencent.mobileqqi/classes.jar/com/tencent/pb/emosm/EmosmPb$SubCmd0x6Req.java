package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x6Req
  extends MessageMicro
{
  public static final int STR_ITEM_ID_FIELD_NUMBER = 2;
  public static final int U32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_tab_id", "str_item_id" }, new Object[] { Integer.valueOf(0), "" }, SubCmd0x6Req.class);
  public final PBStringField str_item_id = PBField.initString("");
  public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x6Req
 * JD-Core Version:    0.7.0.1
 */