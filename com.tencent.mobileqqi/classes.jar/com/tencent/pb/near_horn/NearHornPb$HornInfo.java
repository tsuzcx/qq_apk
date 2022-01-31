package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NearHornPb$HornInfo
  extends MessageMicro
{
  public static final int COMMENT_CNT_FIELD_NUMBER = 9;
  public static final int DISTANCE_FIELD_NUMBER = 5;
  public static final int HORN_CONTENT_FIELD_NUMBER = 8;
  public static final int HORN_KEY_FIELD_NUMBER = 1;
  public static final int NICK_FIELD_NUMBER = 3;
  public static final int PLACE_FIELD_NUMBER = 7;
  public static final int PORTRAIT_FIELD_NUMBER = 4;
  public static final int PUBLISH_TIME_FIELD_NUMBER = 11;
  public static final int SEG_FIELD_NUMBER = 10;
  public static final int STATUS_FIELD_NUMBER = 12;
  public static final int TIME_INTERVAL_FIELD_NUMBER = 6;
  public static final int UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field comment_cnt = PBField.initInt32(0);
  public final PBStringField distance = PBField.initString("");
  public final PBStringField horn_content = PBField.initString("");
  public final PBStringField horn_key = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField place = PBField.initString("");
  public final PBStringField portrait = PBField.initString("");
  public final PBInt64Field publish_time = PBField.initInt64(0L);
  public final PBBytesField seg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBStringField time_interval = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 82, 88, 96 }, new String[] { "horn_key", "uin", "nick", "portrait", "distance", "time_interval", "place", "horn_content", "comment_cnt", "seg", "publish_time", "status" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", "", "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, HornInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.HornInfo
 * JD-Core Version:    0.7.0.1
 */