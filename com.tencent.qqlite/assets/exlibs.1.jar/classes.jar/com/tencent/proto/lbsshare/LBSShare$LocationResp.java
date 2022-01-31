package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$LocationResp
  extends MessageMicro
{
  public static final int EC_FIELD_NUMBER = 1;
  public static final int IS_FOREIGN_FIELD_NUMBER = 5;
  public static final int MYLBS_FIELD_NUMBER = 3;
  public static final int NEXT_FIELD_NUMBER = 4;
  public static final int POILIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "ec", "poilist", "mylbs", "next", "is_foreign" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0) }, LocationResp.class);
  public final PBUInt32Field ec = PBField.initUInt32(0);
  public final PBUInt32Field is_foreign = PBField.initUInt32(0);
  public LBSShare.POI mylbs = new LBSShare.POI();
  public final PBUInt32Field next = PBField.initUInt32(0);
  public final PBRepeatMessageField poilist = PBField.initRepeatMessage(LBSShare.POI.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.LocationResp
 * JD-Core Version:    0.7.0.1
 */