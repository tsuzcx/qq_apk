package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$MyCouponFavourListResp
  extends MessageMicro
{
  public static final int COUPONS_FIELD_NUMBER = 2;
  public static final int RETCODE_FIELD_NUMBER = 1;
  public static final int TS_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "coupons", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, MyCouponFavourListResp.class);
  public final PBRepeatMessageField coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.MyCouponFavourListResp
 * JD-Core Version:    0.7.0.1
 */