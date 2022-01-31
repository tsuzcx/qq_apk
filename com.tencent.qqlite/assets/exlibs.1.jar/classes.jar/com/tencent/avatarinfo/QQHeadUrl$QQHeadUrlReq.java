package com.tencent.avatarinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQHeadUrl$QQHeadUrlReq
  extends MessageMicro
{
  public static final int DSTENCRYPTTYPE_FIELD_NUMBER = 5;
  public static final int DSTUSRINFOS_FIELD_NUMBER = 4;
  public static final int DSTUSRTYPE_FIELD_NUMBER = 3;
  public static final int SRCUIN_FIELD_NUMBER = 2;
  public static final int SRCUSRTYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "srcUsrType", "srcUin", "dstUsrType", "dstUsrInfos", "dstEncryptType" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, QQHeadUrlReq.class);
  public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
  public final PBRepeatMessageField dstUsrInfos = PBField.initRepeatMessage(QQHeadUrl.ReqUsrInfo.class);
  public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
  public final PBUInt64Field srcUin = PBField.initUInt64(0L);
  public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq
 * JD-Core Version:    0.7.0.1
 */