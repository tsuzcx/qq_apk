package com.tencent.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CodeGenerate
{
  public static final class CodeGenerateReq
    extends MessageMicro<CodeGenerateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122 }, new String[] { "uin", "cn", "guid", "device_id", "device_type", "device_name", "token_md5", "timestamp", "random", "sign", "h_location", "h_model", "h_edition", "h_qq_appid", "h_qq_guid" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "" }, CodeGenerateReq.class);
    public final PBStringField cn = PBField.initString("");
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField device_name = PBField.initString("");
    public final PBStringField device_type = PBField.initString("");
    public final PBStringField guid = PBField.initString("");
    public final PBStringField h_edition = PBField.initString("");
    public final PBStringField h_location = PBField.initString("");
    public final PBStringField h_model = PBField.initString("");
    public final PBStringField h_qq_appid = PBField.initString("");
    public final PBStringField h_qq_guid = PBField.initString("");
    public final PBStringField random = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0L);
    public final PBStringField token_md5 = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class CodeGenerateRes
    extends MessageMicro<CodeGenerateRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "retcode", "retmsg", "uin", "cn", "token", "token_md5", "pay_type", "valid_end", "random", "pay_desc", "code_prefix", "forbid_watch" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "" }, CodeGenerateRes.class);
    public final PBStringField cn = PBField.initString("");
    public final PBStringField code_prefix = PBField.initString("");
    public final PBStringField forbid_watch = PBField.initString("");
    public final PBStringField pay_desc = PBField.initString("");
    public final PBStringField pay_type = PBField.initString("");
    public final PBStringField random = PBField.initString("");
    public final PBStringField retcode = PBField.initString("");
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBStringField token_md5 = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBStringField valid_end = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qwallet.CodeGenerate
 * JD-Core Version:    0.7.0.1
 */