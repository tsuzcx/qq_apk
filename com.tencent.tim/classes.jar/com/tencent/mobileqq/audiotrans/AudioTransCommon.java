package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransCommon
{
  public static final class AudioCryptInfo
    extends MessageMicro<AudioCryptInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_crypt_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_key_len = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_crypt_type", "uint32_key_len", "bytes_key_buf" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro }, AudioCryptInfo.class);
    }
  }
  
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "str_uin", "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0) }, MemberInfo.class);
    public final PBEnumField enum_net_type = PBField.initEnum(1);
    public final PBEnumField enum_term = PBField.initEnum(1);
    public final PBStringField str_uin = PBField.initString("");
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  }
  
  public static final class NetAddr
    extends MessageMicro<NetAddr>
  {
    public static final int PT_TCP = 1;
    public static final int PT_UDP = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24, 37 }, new String[] { "fixed32_IP", "uint32_port", "enum_proto_type", "fixed32_inner_IP" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, NetAddr.class);
    public final PBEnumField enum_proto_type = PBField.initEnum(1);
    public final PBFixed32Field fixed32_IP = PBField.initFixed32(0);
    public final PBFixed32Field fixed32_inner_IP = PBField.initFixed32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class TranslateResult
    extends MessageMicro<TranslateResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_src_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tar_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_end_seq = PBField.initInt32(0);
    public final PBInt32Field int32_start_seq = PBField.initInt32(0);
    public final PBInt32Field int32_status = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBUInt32Field uint32_rel_ts = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "int32_end_seq", "int32_start_seq", "bytes_src_text", "bytes_tar_text", "int32_status", "int32_type", "uint32_rel_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TranslateResult.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransCommon
 * JD-Core Version:    0.7.0.1
 */