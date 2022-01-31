package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NearHornPb$MyHornInfo
  extends MessageMicro
{
  public static final int COMMENT_CNT_FIELD_NUMBER = 4;
  public static final int CONTENT_FIELD_NUMBER = 3;
  public static final int DISTANCE_FIELD_NUMBER = 5;
  public static final int HORN_KEY_FIELD_NUMBER = 1;
  public static final int PLACE_FIELD_NUMBER = 7;
  public static final int PUBLISH_TIME_FIELD_NUMBER = 2;
  public static final int TIME_INTERVAL_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58 }, new String[] { "horn_key", "publish_time", "content", "comment_cnt", "distance", "time_interval", "place" }, new Object[] { "", Long.valueOf(0L), "", Integer.valueOf(0), "", "", "" }, MyHornInfo.class);
  public final PBUInt32Field comment_cnt = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public final PBStringField distance = PBField.initString("");
  public final PBStringField horn_key = PBField.initString("");
  public final PBStringField place = PBField.initString("");
  public final PBInt64Field publish_time = PBField.initInt64(0L);
  public final PBStringField time_interval = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.MyHornInfo
 * JD-Core Version:    0.7.0.1
 */