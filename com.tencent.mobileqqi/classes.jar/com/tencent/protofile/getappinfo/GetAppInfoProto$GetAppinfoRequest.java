package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$GetAppinfoRequest
  extends MessageMicro
{
  public static final int CLIENT_ID_FIELD_NUMBER = 1;
  public static final int ICONS_FIELD_NUMBER = 3;
  public static final int OS_FIELD_NUMBER = 5;
  public static final int QQV_FIELD_NUMBER = 4;
  public static final int SDKP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "client_id", "sdkp", "icons", "qqv", "os" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, GetAppinfoRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBRepeatField icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField os = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest
 * JD-Core Version:    0.7.0.1
 */