package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetShopsDetailReq
  extends MessageMicro
{
  public static final int BIDS_FIELD_NUMBER = 1;
  public static final int SHIDS_FIELD_NUMBER = 2;
  public static final int SOURCE_IDS_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "shids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetShopsDetailReq.class);
  public final PBRepeatField bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetShopsDetailReq
 * JD-Core Version:    0.7.0.1
 */