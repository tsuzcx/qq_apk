package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttCenter
{
  public static final class PttIntrodApplyUploadReq
    extends MessageMicro<PttIntrodApplyUploadReq>
  {
    public static final int BYTES_MD5_FIELD_NUMBER = 3;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_file_size", "str_file_name", "bytes_md5" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro }, PttIntrodApplyUploadReq.class);
    }
  }
  
  public static final class PttIntrodApplyUploadResp
    extends MessageMicro<PttIntrodApplyUploadResp>
  {
    public static final int BYTES_UP_FILEKEY_FIELD_NUMBER = 4;
    public static final int BYTES_UP_UKEY_FIELD_NUMBER = 5;
    public static final int INT32_RET_CODE_FIELD_NUMBER = 1;
    public static final int RPT_MSG_TRYUP_IPLIST_FIELD_NUMBER = 3;
    public static final int STR_RET_MSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_up_filekey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<PttCenter.ServerListInfo> rpt_msg_tryup_iplist = PBField.initRepeatMessage(PttCenter.ServerListInfo.class);
    public final PBStringField str_ret_msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_msg_tryup_iplist", "bytes_up_filekey", "bytes_up_ukey" }, new Object[] { Integer.valueOf(0), "", null, localByteStringMicro1, localByteStringMicro2 }, PttIntrodApplyUploadResp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_PTTINTRODAPPLYUPLOAD_REQ_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_cmd", "uint32_seq", "msg_pttIntrodApplyUpload_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public PttCenter.PttIntrodApplyUploadReq msg_pttIntrodApplyUpload_req = new PttCenter.PttIntrodApplyUploadReq();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_PTTINTRODAPPLYUPLOAD_RESP_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_cmd", "uint32_seq", "msg_pttIntrodApplyUpload_resp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public PttCenter.PttIntrodApplyUploadResp msg_pttIntrodApplyUpload_resp = new PttCenter.PttIntrodApplyUploadResp();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class ServerListInfo
    extends MessageMicro<ServerListInfo>
  {
    public static final int UINT32_UP_IP_FIELD_NUMBER = 1;
    public static final int UINT32_UP_PORT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_up_ip", "uint32_up_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ServerListInfo.class);
    public final PBUInt32Field uint32_up_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_up_port = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pttcenterservice.PttCenter
 * JD-Core Version:    0.7.0.1
 */