package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BubbleUpdatePB$RspUpdateTable
  extends MessageMicro
{
  public static final int UINT32_IS_UPDATE_FIELD_NUMBER = 2;
  public static final int UINT32_ITEM_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_item_id", "uint32_is_update" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspUpdateTable.class);
  public final PBUInt32Field uint32_is_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB.RspUpdateTable
 * JD-Core Version:    0.7.0.1
 */