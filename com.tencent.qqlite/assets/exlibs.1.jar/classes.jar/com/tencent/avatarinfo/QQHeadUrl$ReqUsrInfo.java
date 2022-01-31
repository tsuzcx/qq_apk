package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$ReqUsrInfo
  extends MessageMicro
{
  public static final int DSTENCID_FIELD_NUMBER = 3;
  public static final int DSTUIN_FIELD_NUMBER = 1;
  public static final int TIMESTAMP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "dstUin", "timestamp", "dstEncid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, ReqUsrInfo.class);
  public final PBStringField dstEncid = PBField.initString("");
  public final PBUInt64Field dstUin = PBField.initUInt64(0L);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo
 * JD-Core Version:    0.7.0.1
 */