package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$ReportReq
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "data" }, new Object[] { Integer.valueOf(0), "" }, ReportReq.class);
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.ReportReq
 * JD-Core Version:    0.7.0.1
 */