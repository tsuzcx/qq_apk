package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class group_feeds$CmtRecordSet
  extends MessageMicro
{
  public static final int CMR_RECORD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cmr_record" }, new Object[] { null }, CmtRecordSet.class);
  public final PBRepeatMessageField cmr_record = PBField.initRepeatMessage(group_feeds.GroupCommentRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.CmtRecordSet
 * JD-Core Version:    0.7.0.1
 */