package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_bmqq$CorpcardReqBody
  extends MessageMicro
{
  public static final int UINT64_QQUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_qquin" }, new Object[] { Long.valueOf(0L) }, CorpcardReqBody.class);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardReqBody
 * JD-Core Version:    0.7.0.1
 */