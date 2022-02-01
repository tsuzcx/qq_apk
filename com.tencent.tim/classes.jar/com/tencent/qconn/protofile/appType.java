package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appType
{
  public static final class AndroidInfo
    extends MessageMicro<AndroidInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apk_download_url", "pack_name", "class_name", "source_url", "offical_website", "message_tail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
    public final PBStringField apk_download_url = PBField.initString("");
    public final PBStringField bundleid = PBField.initString("");
    public final PBStringField class_name = PBField.initString("");
    public final PBStringField message_tail = PBField.initString("");
    public final PBStringField offical_website = PBField.initString("");
    public final PBStringField pack_name = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
  }
  
  public static final class AuthItem
    extends MessageMicro<AuthItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "default_flag", "id", "title", "api_list", "is_new", "logo_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, AuthItem.class);
    public final PBStringField api_list = PBField.initString("");
    public final PBSInt32Field default_flag = PBField.initSInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBSInt32Field is_new = PBField.initSInt32(0);
    public final PBStringField logo_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class IOSInfo
    extends MessageMicro<IOSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "schema", "bundleid", "appstore_id", "source_url", "offical_website", "message_tail", "a_bundleid" }, new Object[] { "", "", "", "", "", "", "" }, IOSInfo.class);
    public final PBStringField a_bundleid = PBField.initString("");
    public final PBStringField appstore_id = PBField.initString("");
    public final PBStringField bundleid = PBField.initString("");
    public final PBStringField message_tail = PBField.initString("");
    public final PBStringField offical_website = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "type", "sig", "appid" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class MsgIconsurl
    extends MessageMicro<MsgIconsurl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "size", "url" }, new Object[] { "", "" }, MsgIconsurl.class);
    public final PBStringField size = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class PassData
    extends MessageMicro<PassData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, PassData.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.appType
 * JD-Core Version:    0.7.0.1
 */