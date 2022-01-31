package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$ReqBody
  extends MessageMicro
{
  public static final int MSG_APPLY_COPY_FROM_REQ_FIELD_NUMBER = 17;
  public static final int MSG_APPLY_COPY_TO_REQ_FIELD_NUMBER = 90000;
  public static final int MSG_APPLY_DOWNLOAD_ABS_REQ_FIELD_NUMBER = 13;
  public static final int MSG_APPLY_DOWNLOAD_REQ_FIELD_NUMBER = 14;
  public static final int MSG_APPLY_FORWARD_FILE_REQ_FIELD_NUMBER = 9;
  public static final int MSG_APPLY_LIST_DOWNLOAD_REQ_FIELD_NUMBER = 15;
  public static final int MSG_APPLY_UPLOAD_HIT_REQ_FIELD_NUMBER = 8;
  public static final int MSG_APPLY_UPLOAD_REQ_FIELD_NUMBER = 7;
  public static final int MSG_DELETE_FILE_REQ_FIELD_NUMBER = 11;
  public static final int MSG_DOWNLOAD_SUCC_REQ_FIELD_NUMBER = 12;
  public static final int MSG_EXTENSION_REQ_FIELD_NUMBER = 99999;
  public static final int MSG_FILE_QUERY_REQ_FIELD_NUMBER = 16;
  public static final int MSG_RECALL_FILE_REQ_FIELD_NUMBER = 6;
  public static final int MSG_RECV_LIST_QUERY_REQ_FIELD_NUMBER = 3;
  public static final int MSG_RENEW_FILE_REQ_FIELD_NUMBER = 5;
  public static final int MSG_SEND_LIST_QUERY_REQ_FIELD_NUMBER = 4;
  public static final int MSG_UPLOAD_SUCC_REQ_FIELD_NUMBER = 10;
  public static final int UINT32_BUSINESS_ID_FIELD_NUMBER = 101;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 102;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_SEQ_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 808, 816, 720002, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_req", "msg_send_list_query_req", "msg_renew_file_req", "msg_recall_file_req", "msg_apply_upload_req", "msg_apply_upload_hit_req", "msg_apply_forward_file_req", "msg_upload_succ_req", "msg_delete_file_req", "msg_download_succ_req", "msg_apply_download_abs_req", "msg_apply_download_req", "msg_apply_list_download_req", "msg_file_query_req", "msg_apply_copy_from_req", "uint32_business_id", "uint32_client_type", "msg_apply_copy_to_req", "msg_extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
  public cmd0x346.ApplyCopyFromReq msg_apply_copy_from_req = new cmd0x346.ApplyCopyFromReq();
  public cmd0x346.ApplyCopyToReq msg_apply_copy_to_req = new cmd0x346.ApplyCopyToReq();
  public cmd0x346.ApplyDownloadAbsReq msg_apply_download_abs_req = new cmd0x346.ApplyDownloadAbsReq();
  public cmd0x346.ApplyDownloadReq msg_apply_download_req = new cmd0x346.ApplyDownloadReq();
  public cmd0x346.ApplyForwardFileReq msg_apply_forward_file_req = new cmd0x346.ApplyForwardFileReq();
  public cmd0x346.ApplyListDownloadReq msg_apply_list_download_req = new cmd0x346.ApplyListDownloadReq();
  public cmd0x346.ApplyUploadHitReq msg_apply_upload_hit_req = new cmd0x346.ApplyUploadHitReq();
  public cmd0x346.ApplyUploadReq msg_apply_upload_req = new cmd0x346.ApplyUploadReq();
  public cmd0x346.DeleteFileReq msg_delete_file_req = new cmd0x346.DeleteFileReq();
  public cmd0x346.DownloadSuccReq msg_download_succ_req = new cmd0x346.DownloadSuccReq();
  public cmd0x346.ExtensionReq msg_extension_req = new cmd0x346.ExtensionReq();
  public cmd0x346.FileQueryReq msg_file_query_req = new cmd0x346.FileQueryReq();
  public cmd0x346.RecallFileReq msg_recall_file_req = new cmd0x346.RecallFileReq();
  public cmd0x346.RecvListQueryReq msg_recv_list_query_req = new cmd0x346.RecvListQueryReq();
  public cmd0x346.RenewFileReq msg_renew_file_req = new cmd0x346.RenewFileReq();
  public cmd0x346.SendListQueryReq msg_send_list_query_req = new cmd0x346.SendListQueryReq();
  public cmd0x346.UploadSuccReq msg_upload_succ_req = new cmd0x346.UploadSuccReq();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ReqBody
 * JD-Core Version:    0.7.0.1
 */