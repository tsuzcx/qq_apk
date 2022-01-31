package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetAppInfoProto$IOSInfo
  extends MessageMicro
{
  public static final int APPSTOREID_FIELD_NUMBER = 3;
  public static final int A_BUNDLEID_FIELD_NUMBER = 7;
  public static final int BOUNDLEID_FIELD_NUMBER = 2;
  public static final int MESSAGETAIL_FIELD_NUMBER = 6;
  public static final int OFFICALWEBSITE_FIELD_NUMBER = 5;
  public static final int SOURCEURL_FIELD_NUMBER = 4;
  public static final int URLSCHEMA_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "urlSchema", "boundleID", "appstoreID", "sourceUrl", "officalwebsite", "messagetail", "a_bundleid" }, new Object[] { "", "", "", "", "", "", "" }, IOSInfo.class);
  public final PBStringField a_bundleid = PBField.initString("");
  public final PBStringField appstoreID = PBField.initString("");
  public final PBStringField boundleID = PBField.initString("");
  public final PBStringField messagetail = PBField.initString("");
  public final PBStringField officalwebsite = PBField.initString("");
  public final PBStringField sourceUrl = PBField.initString("");
  public final PBStringField urlSchema = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto.IOSInfo
 * JD-Core Version:    0.7.0.1
 */