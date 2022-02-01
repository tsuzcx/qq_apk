package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PicSearchWordsSvr
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "bytes_appid", "bytes_version", "uin32_gender", "uint32_age" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public PicSearchWordsSvr.WordsMsg words_msg = new PicSearchWordsSvr.WordsMsg();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_result", "bytes_fail_msg", "words_msg", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class WordsMsg
    extends MessageMicro<WordsMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_words_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_words_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_words_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_words_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_words_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "bytes_words_version", "bytes_words_url", "bytes_words_md5", "uint32_words_type", "bytes_words_other" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, WordsMsg.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.PicSearchWordsSvr
 * JD-Core Version:    0.7.0.1
 */