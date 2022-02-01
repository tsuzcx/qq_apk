package com.tencent.ark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ArkAppPanelList
{
  public static final class AppDetail
    extends MessageMicro<AppDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "appName", "cnName", "iconUrl" }, new Object[] { "", "", "" }, AppDetail.class);
    public final PBStringField appName = PBField.initString("");
    public final PBStringField cnName = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RespBody
    extends MessageMicro<RespBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "apps" }, new Object[] { null }, RespBody.class);
    public final PBRepeatMessageField<ArkAppPanelList.AppDetail> apps = PBField.initRepeatMessage(ArkAppPanelList.AppDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkAppPanelList
 * JD-Core Version:    0.7.0.1
 */