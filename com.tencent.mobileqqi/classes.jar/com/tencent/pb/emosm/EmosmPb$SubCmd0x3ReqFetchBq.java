package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$SubCmd0x3ReqFetchBq
  extends MessageMicro
{
  public static final int RPT_BYTES_BQID_FIELD_NUMBER = 2;
  public static final int UINT32_TAB_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField rpt_bytes_bqid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_tab_id", "rpt_bytes_bqid" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SubCmd0x3ReqFetchBq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x3ReqFetchBq
 * JD-Core Version:    0.7.0.1
 */