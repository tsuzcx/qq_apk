package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyBusinessFavourListResp
  extends MessageMicro
{
  public static final int BUSINESSES_FIELD_NUMBER = 2;
  public static final int RETCODE_FIELD_NUMBER = 1;
  public static final int TS_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "businesses", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, MyBusinessFavourListResp.class);
  public final PBRepeatMessageField businesses = PBField.initRepeatMessage(CouponProto.Business.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.MyBusinessFavourListResp
 * JD-Core Version:    0.7.0.1
 */