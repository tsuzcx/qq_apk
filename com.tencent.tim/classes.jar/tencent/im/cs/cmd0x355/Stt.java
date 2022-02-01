package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt
{
  public static final class CorretTextReq
    extends MessageMicro<CorretTextReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 98, 104 }, new String[] { "uint64_sessionid", "uint32_ptt_type", "uint64_sender_uin", "uint64_receiver_uin", "uint32_fileid", "str_Filemd5", "str_file_path", "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text", "uint32_ptt_format" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, CorretTextReq.class);
    }
  }
  
  public static final class CorretTextResp
    extends MessageMicro<CorretTextResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_sessionid", "uint32_error_code", "uint32_seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, CorretTextResp.class);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_req", "msg_c2c_ptt_req", "msg_corret_text_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public Stt.TransC2CPttReq msg_c2c_ptt_req = new Stt.TransC2CPttReq();
    public Stt.CorretTextReq msg_corret_text_req = new Stt.CorretTextReq();
    public Stt.TransGroupPttReq msg_group_ptt_req = new Stt.TransGroupPttReq();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "msg_group_ptt_resp", "msg_c2c_ptt_resp", "msg_corret_text_Resp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public Stt.TransC2CPttResp msg_c2c_ptt_resp = new Stt.TransC2CPttResp();
    public Stt.CorretTextResp msg_corret_text_Resp = new Stt.CorretTextResp();
    public Stt.TransGroupPttResp msg_group_ptt_resp = new Stt.TransGroupPttResp();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class TransC2CPttReq
    extends MessageMicro<TransC2CPttReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 74, 80 }, new String[] { "uint64_sessionid", "uint64_sender_uin", "uint64_receiver_uin", "str_file_path", "uint32_ptt_time", "uint32_filesize", "uint32_ptt_format", "uint32_event_type", "str_filemd5", "uint32_msg_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0) }, TransC2CPttReq.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_filemd5 = PBField.initString("");
    public final PBUInt32Field uint32_event_type = PBField.initUInt32(1);
    public final PBUInt32Field uint32_filesize = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  }
  
  public static final class TransC2CPttResp
    extends MessageMicro<TransC2CPttResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66 }, new String[] { "uint64_sessionid", "uint32_error_code", "uint32_waittime", "uint64_sender_uin", "uint64_receiver_uin", "str_file_path", "uint32_serviceprovider", "str_text" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "" }, TransC2CPttResp.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_serviceprovider = PBField.initUInt32(0);
    public final PBUInt32Field uint32_waittime = PBField.initUInt32(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  }
  
  public static final class TransGroupPttReq
    extends MessageMicro<TransGroupPttReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 74, 80, 88 }, new String[] { "uint64_sessionid", "uint64_sender_uin", "uint64_group_uin", "uint32_fileid", "str_filemd5", "uint32_ptt_time", "uint32_filesize", "uint32_ptt_format", "str_file_path", "uint32_event_type", "uint32_msg_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0) }, TransGroupPttReq.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_filemd5 = PBField.initString("");
    public final PBUInt32Field uint32_event_type = PBField.initUInt32(1);
    public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filesize = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  }
  
  public static final class TransGroupPttResp
    extends MessageMicro<TransGroupPttResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74 }, new String[] { "uint64_sessionid", "uint32_error_code", "uint32_waittime", "uint64_sender_uin", "uint64_group_uin", "uint32_fileid", "str_Filemd5", "uint32_serviceprovider", "str_text" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "" }, TransGroupPttResp.class);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_serviceprovider = PBField.initUInt32(0);
    public final PBUInt32Field uint32_waittime = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt
 * JD-Core Version:    0.7.0.1
 */