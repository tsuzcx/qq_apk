package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$RspBody
  extends MessageMicro
{
  public static final int MSG_APPLY_COPY_FROM_RSP_FIELD_NUMBER = 17;
  public static final int MSG_APPLY_COPY_TO_RSP_FIELD_NUMBER = 90000;
  public static final int MSG_APPLY_DOWNLOAD_ABS_RSP_FIELD_NUMBER = 13;
  public static final int MSG_APPLY_DOWNLOAD_RSP_FIELD_NUMBER = 14;
  public static final int MSG_APPLY_FORWARD_FILE_RSP_FIELD_NUMBER = 9;
  public static final int MSG_APPLY_LIST_DOWNLOAD_RSP_FIELD_NUMBER = 15;
  public static final int MSG_APPLY_UPLOAD_HIT_RSP_FIELD_NUMBER = 8;
  public static final int MSG_APPLY_UPLOAD_RSP_FIELD_NUMBER = 7;
  public static final int MSG_DELETE_FILE_RSP_FIELD_NUMBER = 11;
  public static final int MSG_DOWNLOAD_SUCC_RSP_FIELD_NUMBER = 12;
  public static final int MSG_EXTENSION_RSP_FIELD_NUMBER = 99999;
  public static final int MSG_FILE_QUERY_RSP_FIELD_NUMBER = 16;
  public static final int MSG_RECALL_FILE_RSP_FIELD_NUMBER = 6;
  public static final int MSG_RECV_LIST_QUERY_RSP_FIELD_NUMBER = 3;
  public static final int MSG_RENEW_FILE_RSP_FIELD_NUMBER = 5;
  public static final int MSG_SEND_LIST_QUERY_RSP_FIELD_NUMBER = 4;
  public static final int MSG_UPLOAD_SUCC_RSP_FIELD_NUMBER = 10;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 720002, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_rsp", "msg_send_list_query_rsp", "msg_renew_file_rsp", "msg_recall_file_rsp", "msg_apply_upload_rsp", "msg_apply_upload_hit_rsp", "msg_apply_forward_file_rsp", "msg_upload_succ_rsp", "msg_delete_file_rsp", "msg_download_succ_rsp", "msg_apply_download_abs_rsp", "msg_apply_download_rsp", "msg_apply_list_download_rsp", "msg_file_query_rsp", "msg_apply_copy_from_rsp", "msg_apply_copy_to_rsp", "msg_extension_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public cmd0x346.ApplyCopyFromRsp msg_apply_copy_from_rsp = new cmd0x346.ApplyCopyFromRsp();
  public cmd0x346.ApplyCopyToRsp msg_apply_copy_to_rsp = new cmd0x346.ApplyCopyToRsp();
  public cmd0x346.ApplyDownloadAbsRsp msg_apply_download_abs_rsp = new cmd0x346.ApplyDownloadAbsRsp();
  public cmd0x346.ApplyDownloadRsp msg_apply_download_rsp = new cmd0x346.ApplyDownloadRsp();
  public cmd0x346.ApplyForwardFileRsp msg_apply_forward_file_rsp = new cmd0x346.ApplyForwardFileRsp();
  public cmd0x346.ApplyListDownloadRsp msg_apply_list_download_rsp = new cmd0x346.ApplyListDownloadRsp();
  public cmd0x346.ApplyUploadHitRsp msg_apply_upload_hit_rsp = new cmd0x346.ApplyUploadHitRsp();
  public cmd0x346.ApplyUploadRsp msg_apply_upload_rsp = new cmd0x346.ApplyUploadRsp();
  public cmd0x346.DeleteFileRsp msg_delete_file_rsp = new cmd0x346.DeleteFileRsp();
  public cmd0x346.DownloadSuccRsp msg_download_succ_rsp = new cmd0x346.DownloadSuccRsp();
  public cmd0x346.ExtensionRsp msg_extension_rsp = new cmd0x346.ExtensionRsp();
  public cmd0x346.FileQueryRsp msg_file_query_rsp = new cmd0x346.FileQueryRsp();
  public cmd0x346.RecallFileRsp msg_recall_file_rsp = new cmd0x346.RecallFileRsp();
  public cmd0x346.RecvListQueryRsp msg_recv_list_query_rsp = new cmd0x346.RecvListQueryRsp();
  public cmd0x346.RenewFileRsp msg_renew_file_rsp = new cmd0x346.RenewFileRsp();
  public cmd0x346.SendListQueryRsp msg_send_list_query_rsp = new cmd0x346.SendListQueryRsp();
  public cmd0x346.UploadSuccRsp msg_upload_succ_rsp = new cmd0x346.UploadSuccRsp();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.RspBody
 * JD-Core Version:    0.7.0.1
 */