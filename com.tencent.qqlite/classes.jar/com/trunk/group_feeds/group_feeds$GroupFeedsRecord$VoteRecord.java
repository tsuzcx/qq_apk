package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class group_feeds$GroupFeedsRecord$VoteRecord
  extends MessageMicro
{
  public static final int VOTE_ID_FIELD_NUMBER = 1;
  public static final int VOTE_TIME_FIELD_NUMBER = 3;
  public static final int VOTE_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 29 }, new String[] { "vote_id", "vote_uin", "vote_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VoteRecord.class);
  public final PBRepeatField vote_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBFixed32Field vote_time = PBField.initFixed32(0);
  public final PBFixed32Field vote_uin = PBField.initFixed32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsRecord.VoteRecord
 * JD-Core Version:    0.7.0.1
 */