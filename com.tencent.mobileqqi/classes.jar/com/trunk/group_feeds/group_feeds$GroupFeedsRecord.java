package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$GroupFeedsRecord
  extends MessageMicro
{
  public static final int BADNUM_FIELD_NUMBER = 10;
  public static final int COMMENTNUM_FIELD_NUMBER = 11;
  public static final int CONTENT_FIELD_NUMBER = 17;
  public static final int FACE_FIELD_NUMBER = 15;
  public static final int FEEDSTIME_FIELD_NUMBER = 6;
  public static final int FROMUIN_FIELD_NUMBER = 3;
  public static final int GOODNUM_FIELD_NUMBER = 9;
  public static final int GROUPCODE_FIELD_NUMBER = 2;
  public static final int LASTMODTIME_FIELD_NUMBER = 8;
  public static final int MSGFLAG_FIELD_NUMBER = 5;
  public static final int MSGTYPE_FIELD_NUMBER = 4;
  public static final int RESERVE_FIELD_NUMBER = 16;
  public static final int SRVTIME_FIELD_NUMBER = 7;
  public static final int TOPIC_ID_FIELD_NUMBER = 18;
  public static final int VERSION_FIELD_NUMBER = 1;
  public static final int VISITNUM_FIELD_NUMBER = 12;
  public static final int VOTENUM_FIELD_NUMBER = 20;
  public static final int VOTEOPTIONNUM_FIELD_NUMBER = 19;
  public static final int V_RECORD_FIELD_NUMBER = 22;
  public static final int V_STATISTIC_FIELD_NUMBER = 21;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFixed32Field badnum = PBField.initFixed32(0);
  public final PBFixed32Field commentnum = PBField.initFixed32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField face = PBField.initRepeatMessage(group_feeds.GroupFeedsRecord.FaceRecord.class);
  public final PBFixed32Field feedstime = PBField.initFixed32(0);
  public final PBFixed32Field fromuin = PBField.initFixed32(0);
  public final PBFixed32Field goodnum = PBField.initFixed32(0);
  public final PBFixed32Field groupcode = PBField.initFixed32(0);
  public final PBFixed32Field lastmodtime = PBField.initFixed32(0);
  public final PBFixed32Field msgflag = PBField.initFixed32(0);
  public final PBInt32Field msgtype = PBField.initInt32(0);
  public final PBBytesField reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field srvtime = PBField.initFixed32(0);
  public final PBBytesField topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField v_record = PBField.initRepeatMessage(group_feeds.GroupFeedsRecord.VoteRecord.class);
  public final PBRepeatMessageField v_statistic = PBField.initRepeatMessage(group_feeds.GroupFeedsRecord.VoteStatistic.class);
  public final PBInt32Field version = PBField.initInt32(0);
  public final PBFixed32Field visitnum = PBField.initFixed32(0);
  public final PBInt32Field votenum = PBField.initInt32(0);
  public final PBInt32Field voteoptionnum = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29, 32, 45, 53, 61, 69, 77, 85, 93, 101, 122, 130, 138, 146, 152, 160, 170, 178 }, new String[] { "version", "groupcode", "fromuin", "msgtype", "msgflag", "feedstime", "srvtime", "lastmodtime", "goodnum", "badnum", "commentnum", "visitnum", "face", "reserve", "content", "topic_id", "voteoptionnum", "votenum", "v_statistic", "v_record" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), null, null }, GroupFeedsRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsRecord
 * JD-Core Version:    0.7.0.1
 */