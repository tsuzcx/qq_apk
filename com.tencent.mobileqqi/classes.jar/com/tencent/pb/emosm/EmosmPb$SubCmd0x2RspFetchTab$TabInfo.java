package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x2RspFetchTab$TabInfo
  extends MessageMicro
{
  public static final int FIXED32_EXPIRE_TIME_FIELD_NUMBER = 2;
  public static final int INT32_WORDING_ID_FIELD_NUMBER = 4;
  public static final int UINT32_FLAGS_FIELD_NUMBER = 3;
  public static final int UINT32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32 }, new String[] { "uint32_tab_id", "fixed32_expire_time", "uint32_flags", "int32_wording_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TabInfo.class);
  public final PBFixed32Field fixed32_expire_time = PBField.initFixed32(0);
  public final PBInt32Field int32_wording_id = PBField.initInt32(0);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x2RspFetchTab.TabInfo
 * JD-Core Version:    0.7.0.1
 */