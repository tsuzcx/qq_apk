package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class BubbleUpdatePB$ReqUpdateTable
  extends MessageMicro
{
  public static final int UINT32_ITEM_ID_FIELD_NUMBER = 1;
  public static final int UINT32_VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_item_id", "uint32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqUpdateTable.class);
  public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdateTable
 * JD-Core Version:    0.7.0.1
 */