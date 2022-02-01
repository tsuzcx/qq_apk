package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QPSingleUpdateProto
{
  public static final class FileItem
    extends MessageMicro<FileItem>
  {
    public static final int BYTES_HASH_FIELD_NUMBER = 2;
    public static final int BYTES_NAME_FIELD_NUMBER = 1;
    public static final int BYTES_UPDATED_HASH_FIELD_NUMBER = 3;
    public static final int UINT32_NEED_UPDATE_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_hash = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_updated_hash = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_name", "bytes_hash", "bytes_updated_hash", "uint32_need_update" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, FileItem.class);
    }
  }
  
  public static final class Head
    extends MessageMicro<Head>
  {
    public static final int BYTES_PHONE_IMEI_FIELD_NUMBER = 15;
    public static final int BYTES_PHONE_MODEL_FIELD_NUMBER = 14;
    public static final int BYTES_PHONE_NUM_FIELD_NUMBER = 16;
    public static final int MSG_LOGIN_SIG_FIELD_NUMBER = 9;
    public static final int UINT32_ACTUAL_IP_FIELD_NUMBER = 12;
    public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 10;
    public static final int UINT32_CLIENT_PORT_FIELD_NUMBER = 11;
    public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 6;
    public static final int UINT32_COMMAND_FIELD_NUMBER = 2;
    public static final int UINT32_EMULATOR_FLAG_FIELD_NUMBER = 22;
    public static final int UINT32_FLAG_FIELD_NUMBER = 21;
    public static final int UINT32_LOCALID_FIELD_NUMBER = 8;
    public static final int UINT32_NET_TYPE_FIELD_NUMBER = 17;
    public static final int UINT32_PUBNO_FIELD_NUMBER = 7;
    public static final int UINT32_QDUN_VER_FIELD_NUMBER = 13;
    public static final int UINT32_RESULT_FIELD_NUMBER = 20;
    public static final int UINT32_RETRY_TIMES_FIELD_NUMBER = 5;
    public static final int UINT32_SEQ_FIELD_NUMBER = 3;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 19;
    public static final int UINT32_TIMESTAMP_FIELD_NUMBER = 18;
    public static final int UINT32_VERSION_FIELD_NUMBER = 4;
    public static final int UINT64_TIMESTAMPNEW_FIELD_NUMBER = 23;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_phone_imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_phone_model = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
    public QPSingleUpdateProto.LoginSig msg_login_sig = new QPSingleUpdateProto.LoginSig();
    public final PBFixed32Field uint32_actual_ip = PBField.initFixed32(0);
    public final PBFixed32Field uint32_client_ip = PBField.initFixed32(0);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emulator_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_localid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qdun_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestampnew = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 85, 88, 101, 104, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184 }, new String[] { "uint64_uin", "uint32_command", "uint32_seq", "uint32_version", "uint32_retry_times", "uint32_client_type", "uint32_pubno", "uint32_localid", "msg_login_sig", "uint32_client_ip", "uint32_client_port", "uint32_actual_ip", "uint32_qdun_ver", "bytes_phone_model", "bytes_phone_imei", "bytes_phone_num", "uint32_net_type", "uint32_timestamp", "uint32_subcmd", "uint32_result", "uint32_flag", "uint32_emulator_flag", "uint64_timestampnew" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, Head.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    public static final int BYTES_SIG_FIELD_NUMBER = 2;
    public static final int UINT32_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_sig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_REPORT_FIELD_NUMBER = 2;
    public static final int RPT_FILE_ITEM_LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_file_item_list", "msg_report" }, new Object[] { null, null }, ReqBody.class);
    public QPSingleUpdateProto.UploadBody msg_report = new QPSingleUpdateProto.UploadBody();
    public final PBRepeatMessageField<QPSingleUpdateProto.FileItem> rpt_file_item_list = PBField.initRepeatMessage(QPSingleUpdateProto.FileItem.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int BYTES_PACKET_HASH_FIELD_NUMBER = 5;
    public static final int BYTES_PACKET_URL_FIELD_NUMBER = 4;
    public static final int RPT_FILE_ITEM_LIST_FIELD_NUMBER = 6;
    public static final int UINT32_DOWNLOAD_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_FORCE_DOWNLOAD_FIELD_NUMBER = 2;
    public static final int UINT32_GETPHONENUMBER_FLAG_FIELD_NUMBER = 7;
    public static final int UINT32_UPDATE_VAILABLE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_packet_hash = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_packet_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<QPSingleUpdateProto.FileItem> rpt_file_item_list = PBField.initRepeatMessage(QPSingleUpdateProto.FileItem.class);
    public final PBUInt32Field uint32_download_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_force_download = PBField.initUInt32(0);
    public final PBUInt32Field uint32_getphonenumber_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_vailable = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56 }, new String[] { "uint32_update_vailable", "uint32_force_download", "uint32_download_type", "bytes_packet_url", "bytes_packet_hash", "rpt_file_item_list", "uint32_getphonenumber_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class UploadBody
    extends MessageMicro<UploadBody>
  {
    public static final int BYTES_FAILED_REASON_FIELD_NUMBER = 3;
    public static final int BYTES_FAILED_STEP_FIELD_NUMBER = 2;
    public static final int UINT32_SUC_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_failed_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_failed_step = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_suc = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_suc", "bytes_failed_step", "bytes_failed_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, UploadBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdateProto
 * JD-Core Version:    0.7.0.1
 */