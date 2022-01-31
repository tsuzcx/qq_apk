package com.tencent.open.pcpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MessageContent$MsgContent
  extends MessageMicro
{
  public static final int APPID_FIELD_NUMBER = 1;
  public static final int APPNAME_FIELD_NUMBER = 5;
  public static final int APPSIZE_FIELD_NUMBER = 8;
  public static final int APPURL_FIELD_NUMBER = 6;
  public static final int FILETYPE_FIELD_NUMBER = 9;
  public static final int ICONURL_FIELD_NUMBER = 7;
  public static final int PKGNAME_FIELD_NUMBER = 3;
  public static final int SOURCE_FIELD_NUMBER = 10;
  public static final int SRCICONURL_FIELD_NUMBER = 11;
  public static final int VERSIONCODE_FIELD_NUMBER = 4;
  public static final int VIA_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90 }, new String[] { "appid", "via", "pkgname", "versioncode", "appname", "appurl", "iconurl", "appsize", "filetype", "source", "srciconurl" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "" }, MsgContent.class);
  public final PBInt64Field appid = PBField.initInt64(0L);
  public final PBStringField appname = PBField.initString("");
  public final PBStringField appsize = PBField.initString("");
  public final PBStringField appurl = PBField.initString("");
  public final PBInt32Field filetype = PBField.initInt32(0);
  public final PBStringField iconurl = PBField.initString("");
  public final PBStringField pkgname = PBField.initString("");
  public final PBStringField source = PBField.initString("");
  public final PBStringField srciconurl = PBField.initString("");
  public final PBInt32Field versioncode = PBField.initInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.pcpush.MessageContent.MsgContent
 * JD-Core Version:    0.7.0.1
 */