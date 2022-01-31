package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$ReqItemInfo
  extends MessageMicro
{
  public static final int STR_NAME_FIELD_NUMBER = 1;
  public static final int UINT_VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_name", "uint_version" }, new Object[] { "", Integer.valueOf(0) }, ReqItemInfo.class);
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo
 * JD-Core Version:    0.7.0.1
 */