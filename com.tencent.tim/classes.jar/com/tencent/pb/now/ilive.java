package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive
{
  public static final class iLiveRequest
    extends MessageMicro<iLiveRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field auth_appid = PBField.initUInt64(0L);
    public final PBUInt32Field auth_ip = PBField.initUInt32(0);
    public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field auth_type = PBField.initUInt32(0);
    public final PBBytesField binary_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField business = PBField.initString("");
    public final PBUInt64Field buss_id = PBField.initUInt64(0L);
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public final PBUInt32Field client_port = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field codec = PBField.initUInt32(0);
    public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt64Field original_auth_appid = PBField.initUInt64(0L);
    public final PBBytesField original_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field original_id_type = PBField.initUInt32(0);
    public final PBBytesField original_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field original_key_type = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field service_ip = PBField.initUInt32(0);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154, 162, 168, 176, 184, 192, 200 }, new String[] { "version", "cmd", "subcmd", "seq", "uid", "binary_body", "ex", "client_type", "client_ip", "service_ip", "business", "auth_key", "auth_type", "auth_ip", "auth_appid", "tinyid", "client_port", "flag", "original_id", "original_key", "original_key_type", "original_id_type", "original_auth_appid", "buss_id", "codec" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, iLiveRequest.class);
    }
  }
  
  public static final class iLiveResponse
    extends MessageMicro<iLiveResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField binary_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 88 }, new String[] { "version", "cmd", "subcmd", "seq", "uid", "err_code", "err_msg", "binary_body", "ex", "client_type", "flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, iLiveResponse.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive
 * JD-Core Version:    0.7.0.1
 */