package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$AndroidInfo
  extends MessageMicro
{
  public static final int APKDOWNURL_FIELD_NUMBER = 1;
  public static final int BUNDLEID_FIELD_NUMBER = 7;
  public static final int CLASSNAME_FIELD_NUMBER = 3;
  public static final int MESSAGETAIL_FIELD_NUMBER = 6;
  public static final int OFFICALWEBSITE_FIELD_NUMBER = 5;
  public static final int PACKNAME_FIELD_NUMBER = 2;
  public static final int SOURCEURL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apkDownUrl", "packName", "className", "sourceUrl", "officalwebsite", "messagetail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
  public final PBStringField apkDownUrl = PBField.initString("");
  public final PBStringField bundleid = PBField.initString("");
  public final PBStringField className = PBField.initString("");
  public final PBStringField messagetail = PBField.initString("");
  public final PBStringField officalwebsite = PBField.initString("");
  public final PBStringField packName = PBField.initString("");
  public final PBStringField sourceUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo
 * JD-Core Version:    0.7.0.1
 */