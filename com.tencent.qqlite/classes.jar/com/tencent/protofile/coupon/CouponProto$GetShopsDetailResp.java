package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetShopsDetailResp
  extends MessageMicro
{
  public static final int RETCODE_FIELD_NUMBER = 1;
  public static final int SHOPS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsDetailResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBRepeatMessageField shops = PBField.initRepeatMessage(CouponProto.Shop.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetShopsDetailResp
 * JD-Core Version:    0.7.0.1
 */