package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$GetShopsByIdsResp
  extends MessageMicro
{
  public static final int EC_FIELD_NUMBER = 1;
  public static final int SHOPS_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ec", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByIdsResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBRepeatMessageField shops = PBField.initRepeatMessage(LBSShare.DPBiz.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp
 * JD-Core Version:    0.7.0.1
 */