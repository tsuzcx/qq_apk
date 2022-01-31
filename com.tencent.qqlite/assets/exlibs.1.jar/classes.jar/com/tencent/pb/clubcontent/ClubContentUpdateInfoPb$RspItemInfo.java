package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$RspItemInfo
  extends MessageMicro
{
  public static final int STR_EXTEND_FIELD_NUMBER = 4;
  public static final int STR_NAME_FIELD_NUMBER = 1;
  public static final int UINT_UPDATE_FLAG_FIELD_NUMBER = 3;
  public static final int UINT_VERSION_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "str_name", "uint_version", "uint_update_flag", "str_extend" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "" }, RspItemInfo.class);
  public final PBStringField str_extend = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint_update_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo
 * JD-Core Version:    0.7.0.1
 */