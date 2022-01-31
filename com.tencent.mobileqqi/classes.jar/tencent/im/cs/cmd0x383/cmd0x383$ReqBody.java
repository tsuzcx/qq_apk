package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ReqBody
  extends MessageMicro
{
  public static final int APP_ID_ANDROID_CLIENT = 3;
  public static final int APP_ID_ANPING_SVR = 100;
  public static final int APP_ID_DISCUSS_SVR = 13;
  public static final int APP_ID_FEEDS_TRANS_SVR = 17;
  public static final int APP_ID_GROUPACTIVE_SVR = 16;
  public static final int APP_ID_GROUPCARD_SVR = 15;
  public static final int APP_ID_GROUPSPACE_SVR = 11;
  public static final int APP_ID_IOS_CLIENT = 2;
  public static final int APP_ID_OFFlINE_SVR = 12;
  public static final int APP_ID_PC_CLIENT = 1;
  public static final int APP_ID_PC_CLIENT_WEB = 4;
  public static final int APP_ID_WEIYUN_SVR = 14;
  public static final int MSG_COPY_TO_REQ_BODY_FIELD_NUMBER = 112;
  public static final int MSG_DEL_FILE_REQ_BODY_FIELD_NUMBER = 14;
  public static final int MSG_DOWNLOAD_REQ_BODY_FIELD_NUMBER = 13;
  public static final int MSG_FEED_MSG_V2_REQ_BODY_FIELD_NUMBER = 18;
  public static final int MSG_GET_FILE_LIST_REQ_BODY_FIELD_NUMBER = 113;
  public static final int MSG_GET_FILE_LIST_V2_REQ_BODY_FIELD_NUMBER = 117;
  public static final int MSG_RESEND_REQ_BODY_FIELD_NUMBER = 12;
  public static final int MSG_TRANS_FILE_REQ_BODY_FIELD_NUMBER = 16;
  public static final int MSG_UPLOAD_REQ_BODY_FIELD_NUMBER = 11;
  public static final int UINT32_APP_ID_FIELD_NUMBER = 2;
  public static final int UINT64_GROUPCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 130, 146, 898, 906, 938 }, new String[] { "uint64_groupcode", "uint32_app_id", "msg_upload_req_body", "msg_resend_req_body", "msg_download_req_body", "msg_del_file_req_body", "msg_trans_file_req_body", "msg_feed_msg_v2_req_body", "msg_copy_to_req_body", "msg_get_file_list_req_body", "msg_get_file_list_v2_req_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public cmd0x383.ApplyCopyToReqBody msg_copy_to_req_body = new cmd0x383.ApplyCopyToReqBody();
  public cmd0x383.ApplyDelFileReqBody msg_del_file_req_body = new cmd0x383.ApplyDelFileReqBody();
  public cmd0x383.ApplyDownloadReqBody msg_download_req_body = new cmd0x383.ApplyDownloadReqBody();
  public cmd0x383.ApplyFeedMsgV2ReqBody msg_feed_msg_v2_req_body = new cmd0x383.ApplyFeedMsgV2ReqBody();
  public cmd0x383.ApplyGetFileListReqBody msg_get_file_list_req_body = new cmd0x383.ApplyGetFileListReqBody();
  public cmd0x383.ApplyGetFileListV2ReqBody msg_get_file_list_v2_req_body = new cmd0x383.ApplyGetFileListV2ReqBody();
  public cmd0x383.ApplyResendReqBody msg_resend_req_body = new cmd0x383.ApplyResendReqBody();
  public cmd0x383.ApplyTransFileReqBody msg_trans_file_req_body = new cmd0x383.ApplyTransFileReqBody();
  public cmd0x383.ApplyUploadReqBody msg_upload_req_body = new cmd0x383.ApplyUploadReqBody();
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ReqBody
 * JD-Core Version:    0.7.0.1
 */