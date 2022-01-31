package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class EmosmPb$SubCmd0x2ReqFetchTab
  extends MessageMicro
{
  public static final int FIXED32_TIMESTAMP_FIELD_NUMBER = 1;
  public static final int INT32_SEGMENT_FLAG_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16 }, new String[] { "fixed32_timestamp", "int32_segment_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x2ReqFetchTab.class);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x2ReqFetchTab
 * JD-Core Version:    0.7.0.1
 */