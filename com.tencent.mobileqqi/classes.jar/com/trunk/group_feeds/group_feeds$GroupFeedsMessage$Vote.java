package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$GroupFeedsMessage$Vote
  extends MessageMicro
{
  public static final int MAX_VOT_FIELD_NUMBER = 2;
  public static final int OPTS_FIELD_NUMBER = 3;
  public static final int TITLE_FIELD_NUMBER = 1;
  public static final int VOT_DEADLINE_FIELD_NUMBER = 6;
  public static final int VOT_DES_FIELD_NUMBER = 4;
  public static final int VOT_RES_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 53 }, new String[] { "title", "max_vot", "opts", "vot_des", "vot_res", "vot_deadline" }, new Object[] { null, Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, Vote.class);
  public final PBInt32Field max_vot = PBField.initInt32(0);
  public final PBRepeatMessageField opts = PBField.initRepeatMessage(group_feeds.GroupFeedsMessage.ContentList.class);
  public group_feeds.GroupFeedsMessage.ContentList title = new group_feeds.GroupFeedsMessage.ContentList();
  public final PBFixed32Field vot_deadline = PBField.initFixed32(0);
  public group_feeds.GroupFeedsMessage.ContentList vot_des = new group_feeds.GroupFeedsMessage.ContentList();
  public group_feeds.GroupFeedsMessage.ContentList vot_res = new group_feeds.GroupFeedsMessage.ContentList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.Vote
 * JD-Core Version:    0.7.0.1
 */