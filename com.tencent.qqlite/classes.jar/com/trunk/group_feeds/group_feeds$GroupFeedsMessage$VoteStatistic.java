package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_feeds$GroupFeedsMessage$VoteStatistic
  extends MessageMicro
{
  public static final int VOTE_ID_FIELD_NUMBER = 1;
  public static final int VOTE_ID_NUM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "vote_id", "vote_id_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VoteStatistic.class);
  public final PBInt32Field vote_id = PBField.initInt32(0);
  public final PBInt32Field vote_id_num = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.VoteStatistic
 * JD-Core Version:    0.7.0.1
 */