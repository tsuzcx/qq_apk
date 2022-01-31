package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$TimeReqBody
  extends MessageMicro
{
  public static final int IPROTOCOLVER_FIELD_NUMBER = 1;
  public static final int RPTMSGAPPINFO_FIELD_NUMBER = 5;
  public static final int RPTSETTING_FIELD_NUMBER = 6;
  public static final int SCLIENTVER_FIELD_NUMBER = 3;
  public static final int UICLIENTPLATID_FIELD_NUMBER = 2;
  public static final int UIUIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptMsgAppInfo", "rptSetting" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null, null }, TimeReqBody.class);
  public final PBInt32Field iProtocolVer = PBField.initInt32(0);
  public final PBRepeatMessageField rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
  public final PBRepeatMessageField rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
  public final PBStringField sClientVer = PBField.initString("");
  public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeReqBody
 * JD-Core Version:    0.7.0.1
 */