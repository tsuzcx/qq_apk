package com.tencent.now_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pb_now_proxy
{
  public static final class AuthInfo
    extends MessageMicro<AuthInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "original_id", "original_key", "original_id_type" }, new Object[] { "", "", Integer.valueOf(0) }, AuthInfo.class);
    public final PBStringField original_id = PBField.initString("");
    public final PBUInt32Field original_id_type = PBField.initUInt32(0);
    public final PBStringField original_key = PBField.initString("");
  }
  
  public static final class ForwardReq
    extends MessageMicro<ForwardReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField a2 = PBField.initString("");
    public final PBRepeatMessageField<pb_now_proxy.AuthInfo> authInfo = PBField.initRepeatMessage(pb_now_proxy.AuthInfo.class);
    public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field codec = PBField.initUInt32(0);
    public final PBStringField original_id = PBField.initString("");
    public final PBUInt32Field original_id_type = PBField.initUInt32(0);
    public final PBStringField original_key = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field stream_type = PBField.initUInt32(0);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt32Field target_env = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBStringField token = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("");
    public final PBUInt32Field version_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90, 98, 104, 112, 122, 128, 138 }, new String[] { "cmd", "subcmd", "uid", "tinyid", "a2", "platform", "version", "busi_buf", "version_code", "stream_type", "original_id", "original_key", "original_id_type", "codec", "token", "target_env", "authInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null }, ForwardReq.class);
    }
  }
  
  public static final class ForwardRsp
    extends MessageMicro<ForwardRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field busi_error_code = PBField.initUInt32(0);
    public final PBStringField busi_error_msg = PBField.initString("");
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field proxy_code = PBField.initUInt32(0);
    public final PBUInt32Field report = PBField.initUInt32(0);
    public final PBUInt32Field stream_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "proxy_code", "err_msg", "busi_buf", "report", "stream_type", "busi_error_code", "busi_error_msg" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ForwardRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.now_proxy.pb_now_proxy
 * JD-Core Version:    0.7.0.1
 */