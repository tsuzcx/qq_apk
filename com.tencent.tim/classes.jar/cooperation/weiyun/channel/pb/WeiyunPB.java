package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB
{
  public static final class AioPicAndVideoCopyToWeiyunMsgReq
    extends MessageMicro<AioPicAndVideoCopyToWeiyunMsgReq>
  {
    public static final int PIC_VIDEO_2QCLOUD_LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pic_video_2qcloud_list" }, new Object[] { null }, AioPicAndVideoCopyToWeiyunMsgReq.class);
    public final PBRepeatMessageField<WeiyunPB.PicVideo2QcloudItem> pic_video_2qcloud_list = PBField.initRepeatMessage(WeiyunPB.PicVideo2QcloudItem.class);
  }
  
  public static final class AioPicAndVideoCopyToWeiyunMsgRsp
    extends MessageMicro<AioPicAndVideoCopyToWeiyunMsgRsp>
  {
    public static final int TASK_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "task_id" }, new Object[] { "" }, AioPicAndVideoCopyToWeiyunMsgRsp.class);
    public final PBStringField task_id = PBField.initString("");
  }
  
  public static final class CrossBidProxyCopyFileToOtherBidMsgReq
    extends MessageMicro<CrossBidProxyCopyFileToOtherBidMsgReq>
  {
    public static final int DST_BID_FIELD_NUMBER = 200;
    public static final int DST_UIN_FIELD_NUMBER = 201;
    public static final int EXTENSION_REQ_FIELD_NUMBER = 300;
    public static final int FILE_MD5_FIELD_NUMBER = 101;
    public static final int FILE_NAME_FIELD_NUMBER = 102;
    public static final int FILE_SHA_FIELD_NUMBER = 103;
    public static final int FILE_SIZE_FIELD_NUMBER = 100;
    public static final int GROUP_USER = 1;
    public static final int NORMAL_USER = 0;
    public static final int SRC_BID_FIELD_NUMBER = 20;
    public static final int SRC_FILE_ID_FIELD_NUMBER = 31;
    public static final int SRC_GROUP_FIELD_NUMBER = 22;
    public static final int SRC_PDIR_KEY_FIELD_NUMBER = 30;
    public static final int SRC_UIN_FIELD_NUMBER = 21;
    public static final int USER_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field dst_bid = PBField.initUInt32(0);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
    public WeiyunPB.ExtensionReq extension_req = new WeiyunPB.ExtensionReq();
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField file_name = PBField.initString("");
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBUInt32Field src_bid = PBField.initUInt32(0);
    public final PBStringField src_file_id = PBField.initString("");
    public final PBUInt64Field src_group = PBField.initUInt64(0L);
    public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field src_uin = PBField.initUInt64(0L);
    public final PBEnumField user_type = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160, 168, 176, 242, 250, 800, 810, 818, 826, 1600, 1608, 2402 }, new String[] { "user_type", "src_bid", "src_uin", "src_group", "src_pdir_key", "src_file_id", "file_size", "file_md5", "file_name", "file_sha", "dst_bid", "dst_uin", "extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, "", Long.valueOf(0L), localByteStringMicro2, "", localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), null }, CrossBidProxyCopyFileToOtherBidMsgReq.class);
    }
  }
  
  public static final class CrossBidProxyCopyFileToOtherBidMsgRsp
    extends MessageMicro<CrossBidProxyCopyFileToOtherBidMsgRsp>
  {
    public static final int DST_PATH_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dst_path = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dst_path" }, new Object[] { localByteStringMicro }, CrossBidProxyCopyFileToOtherBidMsgRsp.class);
    }
  }
  
  public static final class CrossBidProxyOfflineFileGetListMsgReq
    extends MessageMicro<CrossBidProxyOfflineFileGetListMsgReq>
  {
    public static final int UINT32_FTN_BID_FIELD_NUMBER = 10;
    public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
    public static final int UINT32_OFFLINE_TYPE_FIELD_NUMBER = 1;
    public static final int UINT32_OFFSET_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "uint32_offline_type", "uint32_offset", "uint32_number", "uint32_ftn_bid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CrossBidProxyOfflineFileGetListMsgReq.class);
    public final PBUInt32Field uint32_ftn_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offline_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  }
  
  public static final class CrossBidProxyOfflineFileGetListMsgRsp
    extends MessageMicro<CrossBidProxyOfflineFileGetListMsgRsp>
  {
    public static final int RPT_MSG_RECV_OFFLINE_FILE_FIELD_NUMBER = 1;
    public static final int RPT_MSG_SEND_OFFLINE_FILE_FIELD_NUMBER = 3;
    public static final int UINT32_RECV_FILE_TOTAL_FIELD_NUMBER = 2;
    public static final int UINT32_RECV_LIST_END_FIELD_NUMBER = 7;
    public static final int UINT32_SEND_FILE_TOTAL_FIELD_NUMBER = 4;
    public static final int UINT32_SEND_LIST_END_FIELD_NUMBER = 8;
    public static final int UINT64_TOT_LIMIT_FIELD_NUMBER = 5;
    public static final int UINT64_USED_LIMIT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64 }, new String[] { "rpt_msg_recv_offline_file", "uint32_recv_file_total", "rpt_msg_send_offline_file", "uint32_send_file_total", "uint64_tot_limit", "uint64_used_limit", "uint32_recv_list_end", "uint32_send_list_end" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, CrossBidProxyOfflineFileGetListMsgRsp.class);
    public final PBRepeatMessageField<WeiyunPB.OfflineFileInfo> rpt_msg_recv_offline_file = PBField.initRepeatMessage(WeiyunPB.OfflineFileInfo.class);
    public final PBRepeatMessageField<WeiyunPB.OfflineFileInfo> rpt_msg_send_offline_file = PBField.initRepeatMessage(WeiyunPB.OfflineFileInfo.class);
    public final PBUInt32Field uint32_recv_file_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_list_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_file_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_list_end = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0L);
  }
  
  public static final class DirFileDupItem
    extends MessageMicro<DirFileDupItem>
  {
    public static final int CONFLICT_TYPE_FIELD_NUMBER = 1;
    public static final int DUP_DIR_KEY_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 10;
    public static final int FILE_ATTR_FIELD_NUMBER = 9;
    public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 23;
    public static final int FILE_CTIME_FIELD_NUMBER = 4;
    public static final int FILE_CURSIZE_FIELD_NUMBER = 6;
    public static final int FILE_ID_FIELD_NUMBER = 3;
    public static final int FILE_MD5_FIELD_NUMBER = 8;
    public static final int FILE_MTIME_FIELD_NUMBER = 22;
    public static final int FILE_SHA_FIELD_NUMBER = 7;
    public static final int FILE_SIZE_FIELD_NUMBER = 5;
    public static final int FILE_VERSION_FIELD_NUMBER = 12;
    public static final int PDIR_KEY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public static final int dup_dir = 2;
    public static final int dup_file = 1;
    public final PBInt32Field conflict_type = PBField.initInt32(0);
    public final PBBytesField dup_dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_attr = PBField.initUInt32(0);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBInt64Field file_ctime = PBField.initInt64(0L);
    public final PBInt64Field file_cursize = PBField.initInt64(0L);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_size = PBField.initInt64(0L);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 72, 82, 96, 170, 176, 184 }, new String[] { "conflict_type", "pdir_key", "file_id", "file_ctime", "file_size", "file_cursize", "file_sha", "file_md5", "file_attr", "filename", "file_version", "dup_dir_key", "file_mtime", "file_attr_mtime" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L) }, DirFileDupItem.class);
    }
  }
  
  public static final class DirFileOwnerInfo
    extends MessageMicro<DirFileOwnerInfo>
  {
    public static final int OWNER_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "owner_uin" }, new Object[] { Long.valueOf(0L) }, DirFileOwnerInfo.class);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  }
  
  public static final class DiskAlbumStatusReportReq
    extends MessageMicro<DiskAlbumStatusReportReq>
  {
    public static final int DURING_DAYS_FIELD_NUMBER = 2;
    public static final int NEW_PIC_NUMBER_FIELD_NUMBER = 1;
    public static final int NEW_USER_FIELD_NUMBER = 3;
    public static final int UNBAKED_PIC_NUMBER_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "new_pic_number", "during_days", "new_user", "unbaked_pic_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, DiskAlbumStatusReportReq.class);
    public final PBUInt32Field during_days = PBField.initUInt32(0);
    public final PBUInt32Field new_pic_number = PBField.initUInt32(0);
    public final PBBoolField new_user = PBField.initBool(false);
    public final PBUInt32Field unbaked_pic_number = PBField.initUInt32(0);
  }
  
  public static final class DiskAlbumStatusReportRsp
    extends MessageMicro<DiskAlbumStatusReportRsp>
  {
    public static final int NEED_RED_TOUCH_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "need_red_touch" }, new Object[] { Boolean.valueOf(false) }, DiskAlbumStatusReportRsp.class);
    public final PBBoolField need_red_touch = PBField.initBool(false);
  }
  
  public static final class DiskDirFileBatchDeleteExMsgReq
    extends MessageMicro<DiskDirFileBatchDeleteExMsgReq>
  {
    public static final int DELETE_COMPLETELY_FIELD_NUMBER = 3;
    public static final int DIR_LIST_FIELD_NUMBER = 1;
    public static final int FILE_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "dir_list", "file_list", "delete_completely" }, new Object[] { null, null, Boolean.valueOf(false) }, DiskDirFileBatchDeleteExMsgReq.class);
    public final PBBoolField delete_completely = PBField.initBool(false);
    public final PBRepeatMessageField<WeiyunPB.DiskSimpleDirItem> dir_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleDirItem.class);
    public final PBRepeatMessageField<WeiyunPB.DiskSimpleFileItem> file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItem.class);
  }
  
  public static final class DiskDirFileBatchDeleteExMsgRsp
    extends MessageMicro<DiskDirFileBatchDeleteExMsgRsp>
  {
    public static final int DIR_LIST_FIELD_NUMBER = 3;
    public static final int FILE_LIST_FIELD_NUMBER = 4;
    public static final int FREED_INDEX_CNT_FIELD_NUMBER = 2;
    public static final int FREED_SPACE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "freed_space", "freed_index_cnt", "dir_list", "file_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null }, DiskDirFileBatchDeleteExMsgRsp.class);
    public final PBRepeatMessageField<WeiyunPB.DiskSimpleDirItemResult> dir_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleDirItemResult.class);
    public final PBRepeatMessageField<WeiyunPB.DiskSimpleFileItemResult> file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItemResult.class);
    public final PBUInt32Field freed_index_cnt = PBField.initUInt32(0);
    public final PBInt64Field freed_space = PBField.initInt64(0L);
  }
  
  public static final class DiskFileBatchDownloadMsgReq
    extends MessageMicro<DiskFileBatchDownloadMsgReq>
  {
    public static final int DOWNLOAD_TYPE_FIELD_NUMBER = 4;
    public static final int FILE_LIST_FIELD_NUMBER = 1;
    public static final int FILE_OWNER_FIELD_NUMBER = 2;
    public static final int NEED_THUMB_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "file_list", "file_owner", "need_thumb", "download_type" }, new Object[] { null, Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0) }, DiskFileBatchDownloadMsgReq.class);
    public final PBUInt32Field download_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<WeiyunPB.DiskSimpleFileItem> file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItem.class);
    public final PBUInt64Field file_owner = PBField.initUInt64(0L);
    public final PBBoolField need_thumb = PBField.initBool(false);
  }
  
  public static final class DiskFileBatchDownloadMsgRsp
    extends MessageMicro<DiskFileBatchDownloadMsgRsp>
  {
    public static final int FILE_LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "file_list" }, new Object[] { null }, DiskFileBatchDownloadMsgRsp.class);
    public final PBRepeatMessageField<WeiyunPB.DiskFileDownloadRspItem> file_list = PBField.initRepeatMessage(WeiyunPB.DiskFileDownloadRspItem.class);
  }
  
  public static final class DiskFileDocDownloadAbsMsgReq
    extends MessageMicro<DiskFileDocDownloadAbsMsgReq>
  {
    public static final int FILE_ID_FIELD_NUMBER = 2;
    public static final int FILE_OWNER_FIELD_NUMBER = 3;
    public static final int PDIR_KEY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBUInt64Field file_owner = PBField.initUInt64(0L);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "pdir_key", "file_id", "file_owner" }, new Object[] { localByteStringMicro, "", Long.valueOf(0L) }, DiskFileDocDownloadAbsMsgReq.class);
    }
  }
  
  public static final class DiskFileDocDownloadAbsMsgRsp
    extends MessageMicro<DiskFileDocDownloadAbsMsgRsp>
  {
    public static final int COOKIE_FIELD_NUMBER = 6;
    public static final int DOWNLOADDNS_FIELD_NUMBER = 2;
    public static final int DOWNLOADIP_FIELD_NUMBER = 1;
    public static final int DOWNLOADKEY_FIELD_NUMBER = 5;
    public static final int DOWNLOADPORT_FIELD_NUMBER = 3;
    public static final int DOWNLOAD_URL_FIELD_NUMBER = 7;
    public static final int FILESHA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cookie = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField downloaddns = PBField.initString("");
    public final PBStringField downloadip = PBField.initString("");
    public final PBBytesField downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field downloadport = PBField.initUInt32(0);
    public final PBBytesField filesha = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58 }, new String[] { "downloadip", "downloaddns", "downloadport", "filesha", "downloadkey", "cookie", "download_url" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", "" }, DiskFileDocDownloadAbsMsgRsp.class);
    }
  }
  
  public static final class DiskFileDownloadRspItem
    extends MessageMicro<DiskFileDownloadRspItem>
  {
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
    public static final int COOKIE_NAME_FIELD_NUMBER = 5;
    public static final int COOKIE_VALUE_FIELD_NUMBER = 6;
    public static final int DOWNLOAD_URL_FIELD_NUMBER = 13;
    public static final int ENCODE_URL_FIELD_NUMBER = 2;
    public static final int FILE_ID_FIELD_NUMBER = 7;
    public static final int FILE_MD5_FIELD_NUMBER = 8;
    public static final int FILE_MTIME_FIELD_NUMBER = 10;
    public static final int INSIDE_DOWNLOAD_IP_FIELD_NUMBER = 11;
    public static final int OUTSIDE_DOWNLOAD_IP_FIELD_NUMBER = 12;
    public static final int RETCODE_FIELD_NUMBER = 1;
    public static final int RETMSG_FIELD_NUMBER = 21;
    public static final int SERVER_NAME_FIELD_NUMBER = 3;
    public static final int SERVER_PORT_FIELD_NUMBER = 4;
    public static final int VIDEO_URL_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count = PBField.initUInt32(0);
    public final PBStringField cookie_name = PBField.initString("");
    public final PBStringField cookie_value = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBBytesField encode_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBStringField inside_download_ip = PBField.initString("");
    public final PBStringField outside_download_ip = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    public final PBStringField video_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 98, 106, 170, 200 }, new String[] { "retcode", "encode_url", "server_name", "server_port", "cookie_name", "cookie_value", "file_id", "file_md5", "video_url", "file_mtime", "inside_download_ip", "outside_download_ip", "download_url", "retmsg", "channel_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), "", "", "", localByteStringMicro2, "", Long.valueOf(0L), "", "", "", "", Integer.valueOf(0) }, DiskFileDownloadRspItem.class);
    }
  }
  
  public static final class DiskPicBackupReq
    extends MessageMicro<DiskPicBackupReq>
  {
    public static final int AUTO_CREATE_USER_FIELD_NUMBER = 9;
    public static final int AUTO_FLAG_FIELD_NUMBER = 11;
    public static final int BACKUP_DIR_NAME_FIELD_NUMBER = 10;
    public static final int BACKUP_TYPE_FIELD_NUMBER = 31;
    public static final int EDIT_FIELD_NUMBER = 41;
    public static final int EXT_INFO_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 1;
    public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 7;
    public static final int FILE_MD5_FIELD_NUMBER = 3;
    public static final int FILE_SHA_FIELD_NUMBER = 2;
    public static final int FILE_SIZE_FIELD_NUMBER = 4;
    public static final int FIRST_256K_CRC_FIELD_NUMBER = 13;
    public static final int UPLOAD_TYPE_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField auto_create_user = PBField.initBool(false);
    public final PBBoolField auto_flag = PBField.initBool(false);
    public final PBStringField backup_dir_name = PBField.initString("");
    public final PBUInt32Field backup_type = PBField.initUInt32(0);
    public final PBBoolField edit = PBField.initBool(false);
    public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
    public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBStringField filename = PBField.initString("");
    public final PBUInt32Field first_256k_crc = PBField.initUInt32(0);
    public final PBUInt32Field upload_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 56, 72, 82, 88, 104, 170, 248, 328 }, new String[] { "filename", "file_sha", "file_md5", "file_size", "upload_type", "file_exist_option", "auto_create_user", "backup_dir_name", "auto_flag", "first_256k_crc", "ext_info", "backup_type", "edit" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "", Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, DiskPicBackupReq.class);
    }
  }
  
  public static final class DiskPicBackupRsp
    extends MessageMicro<DiskPicBackupRsp>
  {
    public static final int BACKUP_PATH_FIELD_NUMBER = 17;
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 30;
    public static final int CHECK_KEY_FIELD_NUMBER = 7;
    public static final int COUPON_COUNT_FIELD_NUMBER = 31;
    public static final int DUP_ITEM_FIELD_NUMBER = 22;
    public static final int EXT_INFO_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_BACKUP_FIELD_NUMBER = 13;
    public static final int FILE_CTIME_FIELD_NUMBER = 3;
    public static final int FILE_EXIST_FIELD_NUMBER = 8;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_KEY_FIELD_NUMBER = 10;
    public static final int FILE_VERSION_FIELD_NUMBER = 9;
    public static final int INSIDE_UPLOAD_IP_FIELD_NUMBER = 14;
    public static final int OUTSIDE_UPLOAD_IP_FIELD_NUMBER = 15;
    public static final int PDIR_KEY_FIELD_NUMBER = 11;
    public static final int PDIR_MTIME_FIELD_NUMBER = 4;
    public static final int PPDIR_KEY_FIELD_NUMBER = 12;
    public static final int SERVER_NAME_FIELD_NUMBER = 5;
    public static final int SERVER_PORT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField backup_path = PBField.initString("");
    public final PBUInt32Field channel_count = PBField.initUInt32(0);
    public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field coupon_count = PBField.initUInt32(0);
    public WeiyunPB.DirFileDupItem dup_item = new WeiyunPB.DirFileDupItem();
    public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
    public final PBBoolField file_backup = PBField.initBool(false);
    public final PBUInt64Field file_ctime = PBField.initUInt64(0L);
    public final PBBoolField file_exist = PBField.initBool(false);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBStringField inside_upload_ip = PBField.initString("10.130.69.41");
    public final PBStringField outside_upload_ip = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 104, 114, 122, 138, 170, 178, 240, 248 }, new String[] { "file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "pdir_key", "ppdir_key", "file_backup", "inside_upload_ip", "outside_upload_ip", "backup_path", "ext_info", "dup_item", "channel_count", "coupon_count" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Boolean.valueOf(false), "10.130.69.41", "", "", null, null, Integer.valueOf(0), Integer.valueOf(0) }, DiskPicBackupRsp.class);
    }
  }
  
  public static final class DiskSimpleDirItem
    extends MessageMicro<DiskSimpleDirItem>
  {
    public static final int DIR_KEY_FIELD_NUMBER = 1;
    public static final int DIR_NAME_FIELD_NUMBER = 2;
    public static final int PDIR_KEY_FIELD_NUMBER = 5;
    public static final int PPDIR_KEY_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField dir_name = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 42 }, new String[] { "dir_key", "dir_name", "ppdir_key", "pdir_key" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3 }, DiskSimpleDirItem.class);
    }
  }
  
  public static final class DiskSimpleDirItemResult
    extends MessageMicro<DiskSimpleDirItemResult>
  {
    public static final int DIR_KEY_FIELD_NUMBER = 1;
    public static final int PDIR_KEY_FIELD_NUMBER = 5;
    public static final int PPDIR_KEY_FIELD_NUMBER = 4;
    public static final int RETCODE_FIELD_NUMBER = 2;
    public static final int RETMSG_FIELD_NUMBER = 21;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 34, 42, 170 }, new String[] { "dir_key", "retcode", "ppdir_key", "pdir_key", "retmsg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, "" }, DiskSimpleDirItemResult.class);
    }
  }
  
  public static final class DiskSimpleFileItem
    extends MessageMicro<DiskSimpleFileItem>
  {
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int PDIR_KEY_FIELD_NUMBER = 3;
    public static final int PPDIR_KEY_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 58 }, new String[] { "file_id", "filename", "pdir_key", "ppdir_key" }, new Object[] { "", "", localByteStringMicro1, localByteStringMicro2 }, DiskSimpleFileItem.class);
    }
  }
  
  public static final class DiskSimpleFileItemResult
    extends MessageMicro<DiskSimpleFileItemResult>
  {
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int PDIR_KEY_FIELD_NUMBER = 5;
    public static final int PPDIR_KEY_FIELD_NUMBER = 4;
    public static final int RETCODE_FIELD_NUMBER = 2;
    public static final int RETMSG_FIELD_NUMBER = 21;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 34, 42, 170 }, new String[] { "file_id", "retcode", "ppdir_key", "pdir_key", "retmsg" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "" }, DiskSimpleFileItemResult.class);
    }
  }
  
  public static final class ExtensionReq
    extends MessageMicro<ExtensionReq>
  {
    public static final int BYTES_SIG_FIELD_NUMBER = 20;
    public static final int INT32_PHONE_CONVERT_TYPE_FIELD_NUMBER = 4;
    public static final int STR_DST_PHONENUM_FIELD_NUMBER = 3;
    public static final int UINT64_ID_FIELD_NUMBER = 1;
    public static final int UINT64_ROUTE_ID_FIELD_NUMBER = 100;
    public static final int UINT64_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
    public final PBStringField str_dst_phonenum = PBField.initString("");
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_route_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 800 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, ExtensionReq.class);
    }
  }
  
  public static final class FileExtInfo
    extends MessageMicro<FileExtInfo>
  {
    public static final int ALBUM_OWNER_UIN_FIELD_NUMBER = 214;
    public static final int APP_DATA_FIELD_NUMBER = 301;
    public static final int APP_NAME_FIELD_NUMBER = 6;
    public static final int BACKUP_FLAG_FIELD_NUMBER = 11;
    public static final int BATCH_ID_FIELD_NUMBER = 210;
    public static final int CAN_ACCEL_FIELD_NUMBER = 203;
    public static final int COMMENT_COUNT_FIELD_NUMBER = 215;
    public static final int COOKIE_NAME_FIELD_NUMBER = 14;
    public static final int COOKIE_VALUE_FIELD_NUMBER = 15;
    public static final int DEV_MAC_FIELD_NUMBER = 1;
    public static final int DEV_NAME_FIELD_NUMBER = 4;
    public static final int DEV_OS_FIELD_NUMBER = 5;
    public static final int DEV_SHOW_TYPE_FIELD_NUMBER = 2;
    public static final int DEV_TYPE_FIELD_NUMBER = 3;
    public static final int EVENT_ID_FIELD_NUMBER = 150;
    public static final int EXT_STATUS_FIELD_NUMBER = 20;
    public static final int FROM_SOURCE_FIELD_NUMBER = 25;
    public static final int GROUP_ID_FIELD_NUMBER = 24;
    public static final int HEIGHT_FIELD_NUMBER = 28;
    public static final int LATITUDE_FIELD_NUMBER = 23;
    public static final int LIKE_COUNT_FIELD_NUMBER = 216;
    public static final int LONGITUDE_FIELD_NUMBER = 22;
    public static final int LONG_TIME_FIELD_NUMBER = 91;
    public static final int MUSIC_DETAIL_INFO_FIELD_NUMBER = 43;
    public static final int NUMBER_FIELD_NUMBER = 211;
    public static final int ORG_FILE_SHA_FIELD_NUMBER = 30;
    public static final int ORG_FILE_SIZE_FIELD_NUMBER = 29;
    public static final int ORIENTATION_FIELD_NUMBER = 31;
    public static final int ORIGIN_PIC_SHA_FIELD_NUMBER = 52;
    public static final int OVERWRITE_FIELD_NUMBER = 501;
    public static final int OWER_INFO_FIELD_NUMBER = 801;
    public static final int TAKE_DEV_TYPE_FIELD_NUMBER = 9;
    public static final int TAKE_TIME_FIELD_NUMBER = 21;
    public static final int THUMB_URL_FIELD_NUMBER = 13;
    public static final int TOTAL_NUM_FIELD_NUMBER = 212;
    public static final int TPLINK_KEY_FIELD_NUMBER = 204;
    public static final int UPLOAD_APPID_FIELD_NUMBER = 51;
    public static final int UPLOAD_IPADDR_FIELD_NUMBER = 401;
    public static final int UPLOAD_NICKNAME_FIELD_NUMBER = 219;
    public static final int UPLOAD_UIN_FIELD_NUMBER = 213;
    public static final int WEIYUN_HOST_FIELD_NUMBER = 201;
    public static final int WEIYUN_PORT_FIELD_NUMBER = 202;
    public static final int WIDTH_FIELD_NUMBER = 27;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field album_owner_uin = PBField.initUInt64(0L);
    public final PBStringField app_data = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBBoolField backup_flag = PBField.initBool(false);
    public final PBStringField batch_id = PBField.initString("");
    public final PBBoolField can_accel = PBField.initBool(false);
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBStringField cookie_name = PBField.initString("");
    public final PBStringField cookie_value = PBField.initString("");
    public final PBStringField dev_mac = PBField.initString("");
    public final PBStringField dev_name = PBField.initString("");
    public final PBStringField dev_os = PBField.initString("");
    public final PBInt32Field dev_show_type = PBField.initInt32(0);
    public final PBStringField dev_type = PBField.initString("");
    public final PBStringField event_id = PBField.initString("");
    public final PBInt32Field ext_status = PBField.initInt32(0);
    public final PBInt32Field from_source = PBField.initInt32(0);
    public final PBInt32Field group_id = PBField.initInt32(1);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBInt64Field long_time = PBField.initInt64(0L);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public WeiyunPB.MusicDetailItem music_detail_info = new WeiyunPB.MusicDetailItem();
    public final PBUInt32Field number = PBField.initUInt32(0);
    public final PBBytesField org_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field org_file_size = PBField.initUInt64(0L);
    public final PBUInt32Field orientation = PBField.initUInt32(0);
    public final PBBytesField origin_pic_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field overwrite = PBField.initInt32(0);
    public WeiyunPB.DirFileOwnerInfo ower_info = new WeiyunPB.DirFileOwnerInfo();
    public final PBStringField take_dev_type = PBField.initString("");
    public final PBInt64Field take_time = PBField.initInt64(0L);
    public final PBStringField thumb_url = PBField.initString("");
    public final PBUInt32Field total_num = PBField.initUInt32(0);
    public final PBInt64Field tplink_key = PBField.initInt64(0L);
    public final PBUInt32Field upload_appid = PBField.initUInt32(0);
    public final PBStringField upload_ipaddr = PBField.initString("");
    public final PBStringField upload_nickname = PBField.initString("");
    public final PBUInt64Field upload_uin = PBField.initUInt64(0L);
    public final PBStringField weiyun_host = PBField.initString("");
    public final PBInt32Field weiyun_port = PBField.initInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 74, 88, 106, 114, 122, 160, 168, 177, 185, 192, 200, 216, 224, 232, 242, 248, 346, 408, 418, 728, 1202, 1610, 1616, 1624, 1632, 1682, 1688, 1696, 1704, 1712, 1720, 1728, 1754, 2410, 3210, 4008, 6410 }, new String[] { "dev_mac", "dev_show_type", "dev_type", "dev_name", "dev_os", "app_name", "take_dev_type", "backup_flag", "thumb_url", "cookie_name", "cookie_value", "ext_status", "take_time", "longitude", "latitude", "group_id", "from_source", "width", "height", "org_file_size", "org_file_sha", "orientation", "music_detail_info", "upload_appid", "origin_pic_sha", "long_time", "event_id", "weiyun_host", "weiyun_port", "can_accel", "tplink_key", "batch_id", "number", "total_num", "upload_uin", "album_owner_uin", "comment_count", "like_count", "upload_nickname", "app_data", "upload_ipaddr", "overwrite", "ower_info" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), "", "", Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), null }, FileExtInfo.class);
    }
  }
  
  public static final class FileItem
    extends MessageMicro<FileItem>
  {
    public static final int APPID_FIELD_NUMBER = 12;
    public static final int APP_DATA_FIELD_NUMBER = 30;
    public static final int APP_NAME_FIELD_NUMBER = 13;
    public static final int BATCH_ID_FIELD_NUMBER = 102;
    public static final int DIFF_VERSION_FIELD_NUMBER = 18;
    public static final int EXT_INFO_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_ATTR_FIELD_NUMBER = 9;
    public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 11;
    public static final int FILE_CTIME_FIELD_NUMBER = 7;
    public static final int FILE_CURSIZE_FIELD_NUMBER = 4;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_MD5_FIELD_NUMBER = 6;
    public static final int FILE_MTIME_FIELD_NUMBER = 8;
    public static final int FILE_SHA_FIELD_NUMBER = 5;
    public static final int FILE_SIZE_FIELD_NUMBER = 3;
    public static final int FILE_STATUS_FIELD_NUMBER = 14;
    public static final int FILE_VERSION_FIELD_NUMBER = 10;
    public static final int HAS_BEEN_DELETED_FIELD_NUMBER = 20;
    public static final int LIB_ID_FIELD_NUMBER = 22;
    public static final int OP_RETCODE_FIELD_NUMBER = 101;
    public static final int PDIR_KEY_FIELD_NUMBER = 16;
    public static final int PDIR_NAME_FIELD_NUMBER = 50;
    public static final int PPDIR_KEY_FIELD_NUMBER = 15;
    public static final int STAR_FLAG_FIELD_NUMBER = 17;
    public static final int STAR_TIME_FIELD_NUMBER = 19;
    public static final int VIDEO_TRANSCODE_STATE_FIELD_NUMBER = 23;
    static final MessageMicro.FieldMap __fieldMap__;
    public static final int file_lib_id_CloudAlbum = 24;
    public static final int file_lib_id_Document = 1;
    public static final int file_lib_id_Music = 3;
    public static final int file_lib_id_Other = 5;
    public static final int file_lib_id_Photo = 2;
    public static final int file_lib_id_Video = 4;
    public final PBBytesField app_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField batch_id = PBField.initString("");
    public final PBInt64Field diff_version = PBField.initInt64(0L);
    public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
    public final PBUInt64Field file_attr = PBField.initUInt64(0L);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBInt64Field file_ctime = PBField.initInt64(0L);
    public final PBInt64Field file_cursize = PBField.initInt64(0L);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_mtime = PBField.initInt64(0L);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field file_size = PBField.initInt64(0L);
    public final PBUInt32Field file_status = PBField.initUInt32(0);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBBoolField has_been_deleted = PBField.initBool(false);
    public final PBInt32Field lib_id = PBField.initInt32(0);
    public final PBInt32Field op_retcode = PBField.initInt32(0);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pdir_name = PBField.initString("");
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field star_flag = PBField.initInt32(0);
    public final PBInt64Field star_time = PBField.initInt64(0L);
    public final PBUInt32Field video_transcode_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 112, 122, 130, 136, 144, 152, 160, 170, 176, 184, 242, 402, 808, 818 }, new String[] { "file_id", "filename", "file_size", "file_cursize", "file_sha", "file_md5", "file_ctime", "file_mtime", "file_attr", "file_version", "file_attr_mtime", "appid", "app_name", "file_status", "ppdir_key", "pdir_key", "star_flag", "diff_version", "star_time", "has_been_deleted", "ext_info", "lib_id", "video_transcode_state", "app_data", "pdir_name", "op_retcode", "batch_id" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, "", Integer.valueOf(0), "" }, FileItem.class);
    }
  }
  
  public static final class LibInfoListGetMsgReq
    extends MessageMicro<LibInfoListGetMsgReq>
  {
    public static final int COUNT_FIELD_NUMBER = 40;
    public static final int GROUP_ID_FIELD_NUMBER = 50;
    public static final int LIB_ID_FIELD_NUMBER = 10;
    public static final int LOAD_TYPE_FIELD_NUMBER = 20;
    public static final int LOCAL_VERSION_FIELD_NUMBER = 30;
    public static final int SCENE_ID_FIELD_NUMBER = 60;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 320, 400, 480 }, new String[] { "lib_id", "load_type", "local_version", "count", "group_id", "scene_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LibInfoListGetMsgReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBInt32Field group_id = PBField.initInt32(0);
    public final PBInt32Field lib_id = PBField.initInt32(0);
    public final PBInt32Field load_type = PBField.initInt32(0);
    public final PBStringField local_version = PBField.initString("");
    public final PBInt32Field scene_id = PBField.initInt32(0);
  }
  
  public static final class LibInfoListGetMsgRsp
    extends MessageMicro<LibInfoListGetMsgRsp>
  {
    public static final int FILEITEM_ITEMS_FIELD_NUMBER = 40;
    public static final int FINISH_FLAG_FIELD_NUMBER = 10;
    public static final int OVERFLOW_FLAG_FIELD_NUMBER = 20;
    public static final int SERVER_VERSION_FIELD_NUMBER = 30;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 322 }, new String[] { "finish_flag", "overflow_flag", "server_version", "FileItem_items" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), "", null }, LibInfoListGetMsgRsp.class);
    public final PBRepeatMessageField<WeiyunPB.FileItem> FileItem_items = PBField.initRepeatMessage(WeiyunPB.FileItem.class);
    public final PBInt32Field finish_flag = PBField.initInt32(0);
    public final PBBoolField overflow_flag = PBField.initBool(false);
    public final PBStringField server_version = PBField.initString("");
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int REQMSG_BODY_FIELD_NUMBER = 1;
    public static final int RSPMSG_BODY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ReqMsg_body", "RspMsg_body" }, new Object[] { null, null }, MsgBody.class);
    public WeiyunPB.ReqMsgBody ReqMsg_body = new WeiyunPB.ReqMsgBody();
    public WeiyunPB.RspMsgBody RspMsg_body = new WeiyunPB.RspMsgBody();
  }
  
  public static final class MsgHead
    extends MessageMicro<MsgHead>
  {
    public static final int APPID_FIELD_NUMBER = 5;
    public static final int AUTH_CODE_FIELD_NUMBER = 31;
    public static final int CAN_ACCEL_FIELD_NUMBER = 203;
    public static final int CLIENTIP_FIELD_NUMBER = 8;
    public static final int CMD_FIELD_NUMBER = 4;
    public static final int DISASTER_FLAG_FIELD_NUMBER = 91;
    public static final int EMULATOR_FLAG_FIELD_NUMBER = 16;
    public static final int ENCRYPTKEY_FIELD_NUMBER = 11;
    public static final int ENCRYPT_FIELD_NUMBER = 9;
    public static final int FIX_VERSION_FIELD_NUMBER = 19;
    public static final int KEYTYPE_FIELD_NUMBER = 10;
    public static final int LOGIN_KEYTYPE_FIELD_NUMBER = 12;
    public static final int LOGIN_KEY_FIELD_NUMBER = 13;
    public static final int MAJOR_VERSION_FIELD_NUMBER = 14;
    public static final int MINOR_VERSION_FIELD_NUMBER = 15;
    public static final int NETTYPE_FIELD_NUMBER = 7;
    public static final int QUA_FIELD_NUMBER = 18;
    public static final int RETCODE_FIELD_NUMBER = 101;
    public static final int RETMSG_FIELD_NUMBER = 102;
    public static final int ReqMsg = 1;
    public static final int RspMsg = 2;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int SRC_MODULE_ID_FIELD_NUMBER = 21;
    public static final int TPLINK_KEY_FIELD_NUMBER = 204;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    public static final int VERIFY_SESSION_FIELD_NUMBER = 32;
    public static final int VERSION_FIELD_NUMBER = 6;
    public static final int WEIYUN_HOST_FIELD_NUMBER = 201;
    public static final int WEIYUN_PORT_FIELD_NUMBER = 202;
    public static final int ZIP_FLAG_FIELD_NUMBER = 17;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBStringField auth_code = PBField.initString("");
    public final PBBoolField can_accel = PBField.initBool(false);
    public final PBStringField clientip = PBField.initString("");
    public final PBEnumField cmd = PBField.initEnum(26113);
    public final PBInt32Field disaster_flag = PBField.initInt32(0);
    public final PBInt32Field emulator_flag = PBField.initInt32(0);
    public final PBInt32Field encrypt = PBField.initInt32(0);
    public final PBBytesField encryptkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field fix_version = PBField.initInt32(0);
    public final PBInt32Field keytype = PBField.initInt32(0);
    public final PBBytesField login_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field login_keytype = PBField.initInt32(0);
    public final PBInt32Field major_version = PBField.initInt32(0);
    public final PBInt32Field minor_version = PBField.initInt32(0);
    public final PBInt32Field nettype = PBField.initInt32(0);
    public final PBStringField qua = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBInt32Field src_module_id = PBField.initInt32(0);
    public final PBInt64Field tplink_key = PBField.initInt64(0L);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBStringField verify_session = PBField.initString("");
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBStringField weiyun_host = PBField.initString("");
    public final PBInt32Field weiyun_port = PBField.initInt32(0);
    public final PBInt32Field zip_flag = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 90, 96, 106, 112, 120, 128, 136, 146, 152, 168, 250, 258, 728, 808, 818, 1610, 1616, 1624, 1632 }, new String[] { "uin", "seq", "type", "cmd", "appid", "version", "nettype", "clientip", "encrypt", "keytype", "encryptkey", "login_keytype", "login_key", "major_version", "minor_version", "emulator_flag", "zip_flag", "qua", "fix_version", "src_module_id", "auth_code", "verify_session", "disaster_flag", "retcode", "retmsg", "weiyun_host", "weiyun_port", "can_accel", "tplink_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(26113), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, MsgHead.class);
    }
  }
  
  public static final class MusicDetailItem
    extends MessageMicro<MusicDetailItem>
  {
    public static final int SINGER_LOGO_FIELD_NUMBER = 40;
    public static final int SINGER_NAME_FIELD_NUMBER = 30;
    public static final int SPECIAL_ISSUE_LOGO_FIELD_NUMBER = 60;
    public static final int SPECIAL_ISSUE_NAME_FIELD_NUMBER = 50;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 242, 322, 402, 482 }, new String[] { "singer_name", "singer_logo", "special_issue_name", "special_issue_logo" }, new Object[] { "", "", "", "" }, MusicDetailItem.class);
    public final PBStringField singer_logo = PBField.initString("");
    public final PBStringField singer_name = PBField.initString("");
    public final PBStringField special_issue_logo = PBField.initString("");
    public final PBStringField special_issue_name = PBField.initString("");
  }
  
  public static final class OfflineFileInfo
    extends MessageMicro<OfflineFileInfo>
  {
    public static final int BYTES_10M_MD5_FIELD_NUMBER = 100;
    public static final int BYTES_UUID_FIELD_NUMBER = 6;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 7;
    public static final int UINT32_ABS_FILE_TYPE_FIELD_NUMBER = 90;
    public static final int UINT32_DANGER_EVEL_FIELD_NUMBER = 2;
    public static final int UINT32_LIFE_TIME_FIELD_NUMBER = 4;
    public static final int UINT32_UPLOAD_TIME_FIELD_NUMBER = 5;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 720, 802 }, new String[] { "uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2 }, OfflineFileInfo.class);
    }
  }
  
  public static final class PicVideo2QcloudItem
    extends MessageMicro<PicVideo2QcloudItem>
  {
    public static final int BOOL_AUTO_CREATE_USER_FIELD_NUMBER = 8;
    public static final int IMAGE_TYPE_FIELD_NUMBER = 13;
    public static final int RAW_URL_FIELD_NUMBER = 12;
    public static final int STR_DST_ID_FIELD_NUMBER = 2;
    public static final int STR_FILE_ID_FIELD_NUMBER = 5;
    public static final int STR_FILE_MD5_FIELD_NUMBER = 11;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 9;
    public static final int STR_SRC_ID_FIELD_NUMBER = 1;
    public static final int UINT32_BID_FIELD_NUMBER = 4;
    public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_USER_TYPE_FIELD_NUMBER = 10;
    public static final int UINT64_FILE_ID_FIELD_NUMBER = 6;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 74, 80, 90, 98, 104 }, new String[] { "str_src_id", "str_dst_id", "uint32_chat_type", "uint32_bid", "str_file_id", "uint64_file_id", "uint64_file_size", "bool_auto_create_user", "str_file_name", "uint32_user_type", "str_file_md5", "raw_url", "image_type" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(true), "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, PicVideo2QcloudItem.class);
    public final PBBoolField bool_auto_create_user = PBField.initBool(true);
    public final PBInt32Field image_type = PBField.initInt32(0);
    public final PBStringField raw_url = PBField.initString("");
    public final PBStringField str_dst_id = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_md5 = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_src_id = PBField.initString("");
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  }
  
  public static final class PwdQueryMsgReq
    extends MessageMicro<PwdQueryMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], PwdQueryMsgReq.class);
  }
  
  public static final class PwdQueryMsgRsp
    extends MessageMicro<PwdQueryMsgRsp>
  {
    public static final int PWD_OPEN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pwd_open" }, new Object[] { Boolean.valueOf(false) }, PwdQueryMsgRsp.class);
    public final PBBoolField pwd_open = PBField.initBool(false);
  }
  
  public static final class PwdVerifyMsgReq
    extends MessageMicro<PwdVerifyMsgReq>
  {
    public static final int CS_SIG_FIELD_NUMBER = 2;
    public static final int PWD_MD5_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pwd_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pwd_md5", "cs_sig" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, PwdVerifyMsgReq.class);
    }
  }
  
  public static final class PwdVerifyMsgRsp
    extends MessageMicro<PwdVerifyMsgRsp>
  {
    public static final int CS_SIG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "cs_sig" }, new Object[] { localByteStringMicro }, PwdVerifyMsgRsp.class);
    }
  }
  
  public static final class QqSdkFileUploadMsgReq
    extends MessageMicro<QqSdkFileUploadMsgReq>
  {
    public static final int AUTO_CREATE_USER_FIELD_NUMBER = 11;
    public static final int EXT_INFO_FIELD_NUMBER = 20;
    public static final int FILENAME_FIELD_NUMBER = 3;
    public static final int FILE_ATTR_FIELD_NUMBER = 8;
    public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 7;
    public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 10;
    public static final int FILE_MD5_FIELD_NUMBER = 5;
    public static final int FILE_SHA_FIELD_NUMBER = 4;
    public static final int FILE_SIZE_FIELD_NUMBER = 6;
    public static final int PDIR_KEY_FIELD_NUMBER = 2;
    public static final int PPDIR_KEY_FIELD_NUMBER = 1;
    public static final int UPLOAD_TYPE_FIELD_NUMBER = 9;
    public static final int USE_MUTIL_CHANNEL_FIELD_NUMBER = 30;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField auto_create_user = PBField.initBool(false);
    public WeiyunPB.FileExtInfo ext_info = new WeiyunPB.FileExtInfo();
    public final PBUInt64Field file_attr = PBField.initUInt64(0L);
    public final PBUInt64Field file_attr_mtime = PBField.initUInt64(0L);
    public final PBUInt32Field file_exist_option = PBField.initUInt32(0);
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field upload_type = PBField.initUInt32(0);
    public final PBBoolField use_mutil_channel = PBField.initBool(false);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 162, 240 }, new String[] { "ppdir_key", "pdir_key", "filename", "file_sha", "file_md5", "file_size", "file_attr_mtime", "file_attr", "upload_type", "file_exist_option", "auto_create_user", "ext_info", "use_mutil_channel" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "", localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, Boolean.valueOf(false) }, QqSdkFileUploadMsgReq.class);
    }
  }
  
  public static final class QqSdkFileUploadMsgRsp
    extends MessageMicro<QqSdkFileUploadMsgRsp>
  {
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
    public static final int CHECK_KEY_FIELD_NUMBER = 7;
    public static final int DUP_ITEM_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_CTIME_FIELD_NUMBER = 3;
    public static final int FILE_EXIST_FIELD_NUMBER = 8;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_KEY_FIELD_NUMBER = 10;
    public static final int FILE_MTIME_FIELD_NUMBER = 23;
    public static final int FILE_VERSION_FIELD_NUMBER = 9;
    public static final int FLOW_FILE_SIZE_FIELD_NUMBER = 40;
    public static final int INSIDE_UPLOAD_IP_FIELD_NUMBER = 11;
    public static final int LIB_ID_FIELD_NUMBER = 16;
    public static final int NEED_ADD_EVERY_DAY_FIELD_NUMBER = 30;
    public static final int OUTSIDE_UPLOAD_IP_FIELD_NUMBER = 12;
    public static final int PDIR_KEY_FIELD_NUMBER = 101;
    public static final int PDIR_MTIME_FIELD_NUMBER = 4;
    public static final int PPDIR_KEY_FIELD_NUMBER = 100;
    public static final int REMAIN_FLOW_SIZE_FIELD_NUMBER = 50;
    public static final int SERVER_NAME_FIELD_NUMBER = 5;
    public static final int SERVER_PORT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count = PBField.initUInt32(0);
    public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public WeiyunPB.DirFileDupItem dup_item = new WeiyunPB.DirFileDupItem();
    public final PBUInt64Field file_ctime = PBField.initUInt64(0L);
    public final PBBoolField file_exist = PBField.initBool(false);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_mtime = PBField.initUInt64(0L);
    public final PBUInt32Field file_version = PBField.initUInt32(0);
    public final PBStringField filename = PBField.initString("");
    public final PBInt64Field flow_file_size = PBField.initInt64(0L);
    public final PBStringField inside_upload_ip = PBField.initString("");
    public final PBUInt32Field lib_id = PBField.initUInt32(0);
    public final PBBoolField need_add_every_day = PBField.initBool(false);
    public final PBStringField outside_upload_ip = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0L);
    public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field remain_flow_size = PBField.initInt64(0L);
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 128, 170, 184, 200, 240, 320, 400, 802, 810 }, new String[] { "file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "inside_upload_ip", "outside_upload_ip", "lib_id", "dup_item", "file_mtime", "channel_count", "need_add_every_day", "flow_file_size", "remain_flow_size", "ppdir_key", "pdir_key" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2, "", "", Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, QqSdkFileUploadMsgRsp.class);
    }
  }
  
  public static final class ReqMsgBody
    extends MessageMicro<ReqMsgBody>
  {
    public static final int AIOPICANDVIDEOCOPYTOWEIYUNMSGREQ_BODY_FIELD_NUMBER = 246001;
    public static final int CROSSBIDPROXYCOPYFILETOOTHERBIDMSGREQ_BODY_FIELD_NUMBER = 245700;
    public static final int CROSSBIDPROXYOFFLINEFILEGETLISTMSGREQ_BODY_FIELD_NUMBER = 245706;
    public static final int DISKALBUMSTATUSREPORTREQ_BODY_FIELD_NUMBER = 2804;
    public static final int DISKDIRFILEBATCHDELETEEXMSGREQ_BODY_FIELD_NUMBER = 2509;
    public static final int DISKFILEBATCHDOWNLOADMSGREQ_BODY_FIELD_NUMBER = 2402;
    public static final int DISKFILEDOCDOWNLOADABSMSGREQ_BODY_FIELD_NUMBER = 2414;
    public static final int DISKPICBACKUPREQ_BODY_FIELD_NUMBER = 2803;
    public static final int LIBINFOLISTGETMSGREQ_BODY_FIELD_NUMBER = 26113;
    public static final int PWDQUERYMSGREQ_BODY_FIELD_NUMBER = 11001;
    public static final int PWDVERIFYMSGREQ_BODY_FIELD_NUMBER = 11005;
    public static final int QQSDKFILEUPLOADMSGREQ_BODY_FIELD_NUMBER = 246000;
    public static final int WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER = 12102;
    public static final int WEIYUNTRIALCOUPONUSEMSGREQ_BODY_FIELD_NUMBER = 245520;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 19218, 19314, 20074, 22426, 22434, 88010, 88042, 96818, 208906, 1964162, 1965602, 1965650, 1968002, 1968010 }, new String[] { "DiskFileBatchDownloadMsgReq_body", "DiskFileDocDownloadAbsMsgReq_body", "DiskDirFileBatchDeleteExMsgReq_body", "DiskPicBackupReq_body", "DiskAlbumStatusReportReq_body", "PwdQueryMsgReq_body", "PwdVerifyMsgReq_body", "WeiyunShareAddFromMobileQQMsgReq_body", "LibInfoListGetMsgReq_body", "WeiyunTrialCouponUseMsgReq_body", "CrossBidProxyCopyFileToOtherBidMsgReq_body", "CrossBidProxyOfflineFileGetListMsgReq_body", "QqSdkFileUploadMsgReq_body", "AioPicAndVideoCopyToWeiyunMsgReq_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqMsgBody.class);
    public WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq AioPicAndVideoCopyToWeiyunMsgReq_body = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq();
    public WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq CrossBidProxyCopyFileToOtherBidMsgReq_body = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
    public WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq CrossBidProxyOfflineFileGetListMsgReq_body = new WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq();
    public WeiyunPB.DiskAlbumStatusReportReq DiskAlbumStatusReportReq_body = new WeiyunPB.DiskAlbumStatusReportReq();
    public WeiyunPB.DiskDirFileBatchDeleteExMsgReq DiskDirFileBatchDeleteExMsgReq_body = new WeiyunPB.DiskDirFileBatchDeleteExMsgReq();
    public WeiyunPB.DiskFileBatchDownloadMsgReq DiskFileBatchDownloadMsgReq_body = new WeiyunPB.DiskFileBatchDownloadMsgReq();
    public WeiyunPB.DiskFileDocDownloadAbsMsgReq DiskFileDocDownloadAbsMsgReq_body = new WeiyunPB.DiskFileDocDownloadAbsMsgReq();
    public WeiyunPB.DiskPicBackupReq DiskPicBackupReq_body = new WeiyunPB.DiskPicBackupReq();
    public WeiyunPB.LibInfoListGetMsgReq LibInfoListGetMsgReq_body = new WeiyunPB.LibInfoListGetMsgReq();
    public WeiyunPB.PwdQueryMsgReq PwdQueryMsgReq_body = new WeiyunPB.PwdQueryMsgReq();
    public WeiyunPB.PwdVerifyMsgReq PwdVerifyMsgReq_body = new WeiyunPB.PwdVerifyMsgReq();
    public WeiyunPB.QqSdkFileUploadMsgReq QqSdkFileUploadMsgReq_body = new WeiyunPB.QqSdkFileUploadMsgReq();
    public WeiyunPB.WeiyunShareAddFromMobileQQMsgReq WeiyunShareAddFromMobileQQMsgReq_body = new WeiyunPB.WeiyunShareAddFromMobileQQMsgReq();
    public WeiyunPB.WeiyunTrialCouponUseMsgReq WeiyunTrialCouponUseMsgReq_body = new WeiyunPB.WeiyunTrialCouponUseMsgReq();
  }
  
  public static final class RspMsgBody
    extends MessageMicro<RspMsgBody>
  {
    public static final int AIOPICANDVIDEOCOPYTOWEIYUNMSGRSP_BODY_FIELD_NUMBER = 246001;
    public static final int CROSSBIDPROXYCOPYFILETOOTHERBIDMSGRSP_BODY_FIELD_NUMBER = 245700;
    public static final int CROSSBIDPROXYOFFLINEFILEGETLISTMSGRSP_BODY_FIELD_NUMBER = 245706;
    public static final int DISKALBUMSTATUSREPORTRSP_BODY_FIELD_NUMBER = 2804;
    public static final int DISKDIRFILEBATCHDELETEEXMSGRSP_BODY_FIELD_NUMBER = 2509;
    public static final int DISKFILEBATCHDOWNLOADMSGRSP_BODY_FIELD_NUMBER = 2402;
    public static final int DISKFILEDOCDOWNLOADABSMSGRSP_BODY_FIELD_NUMBER = 2414;
    public static final int DISKPICBACKUPRSP_BODY_FIELD_NUMBER = 2803;
    public static final int LIBINFOLISTGETMSGRSP_BODY_FIELD_NUMBER = 26113;
    public static final int PWDQUERYMSGRSP_BODY_FIELD_NUMBER = 11001;
    public static final int PWDVERIFYMSGRSP_BODY_FIELD_NUMBER = 11005;
    public static final int QQSDKFILEUPLOADMSGRSP_BODY_FIELD_NUMBER = 246000;
    public static final int WEIYUNSHAREADDFROMMOBILEQQMSGRSP_BODY_FIELD_NUMBER = 12103;
    public static final int WEIYUNTRIALCOUPONUSEMSGRSP_BODY_FIELD_NUMBER = 245520;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 19218, 19314, 20074, 22426, 22434, 88010, 88042, 96826, 208906, 1964162, 1965602, 1965650, 1968002, 1968010 }, new String[] { "DiskFileBatchDownloadMsgRsp_body", "DiskFileDocDownloadAbsMsgRsp_body", "DiskDirFileBatchDeleteExMsgRsp_body", "DiskPicBackupRsp_body", "DiskAlbumStatusReportRsp_body", "PwdQueryMsgRsp_body", "PwdVerifyMsgRsp_body", "WeiyunShareAddFromMobileQQMsgRsp_body", "LibInfoListGetMsgRsp_body", "WeiyunTrialCouponUseMsgRsp_body", "CrossBidProxyCopyFileToOtherBidMsgRsp_body", "CrossBidProxyOfflineFileGetListMsgRsp_body", "QqSdkFileUploadMsgRsp_body", "AioPicAndVideoCopyToWeiyunMsgRsp_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspMsgBody.class);
    public WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp AioPicAndVideoCopyToWeiyunMsgRsp_body = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp();
    public WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp CrossBidProxyCopyFileToOtherBidMsgRsp_body = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp();
    public WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp CrossBidProxyOfflineFileGetListMsgRsp_body = new WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp();
    public WeiyunPB.DiskAlbumStatusReportRsp DiskAlbumStatusReportRsp_body = new WeiyunPB.DiskAlbumStatusReportRsp();
    public WeiyunPB.DiskDirFileBatchDeleteExMsgRsp DiskDirFileBatchDeleteExMsgRsp_body = new WeiyunPB.DiskDirFileBatchDeleteExMsgRsp();
    public WeiyunPB.DiskFileBatchDownloadMsgRsp DiskFileBatchDownloadMsgRsp_body = new WeiyunPB.DiskFileBatchDownloadMsgRsp();
    public WeiyunPB.DiskFileDocDownloadAbsMsgRsp DiskFileDocDownloadAbsMsgRsp_body = new WeiyunPB.DiskFileDocDownloadAbsMsgRsp();
    public WeiyunPB.DiskPicBackupRsp DiskPicBackupRsp_body = new WeiyunPB.DiskPicBackupRsp();
    public WeiyunPB.LibInfoListGetMsgRsp LibInfoListGetMsgRsp_body = new WeiyunPB.LibInfoListGetMsgRsp();
    public WeiyunPB.PwdQueryMsgRsp PwdQueryMsgRsp_body = new WeiyunPB.PwdQueryMsgRsp();
    public WeiyunPB.PwdVerifyMsgRsp PwdVerifyMsgRsp_body = new WeiyunPB.PwdVerifyMsgRsp();
    public WeiyunPB.QqSdkFileUploadMsgRsp QqSdkFileUploadMsgRsp_body = new WeiyunPB.QqSdkFileUploadMsgRsp();
    public WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp WeiyunShareAddFromMobileQQMsgRsp_body = new WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp();
    public WeiyunPB.WeiyunTrialCouponUseMsgRsp WeiyunTrialCouponUseMsgRsp_body = new WeiyunPB.WeiyunTrialCouponUseMsgRsp();
  }
  
  public static final class ShareFileItem
    extends MessageMicro<ShareFileItem>
  {
    public static final int FILE_ID_FIELD_NUMBER = 2;
    public static final int PDIR_KEY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pdir_key", "file_id" }, new Object[] { localByteStringMicro, "" }, ShareFileItem.class);
    }
  }
  
  public static final class WeiyunShareAddFromMobileQQMsgReq
    extends MessageMicro<WeiyunShareAddFromMobileQQMsgReq>
  {
    public static final int ENABLE_QQ_ADD_FRIEND_FIELD_NUMBER = 4;
    public static final int FILE_FIELD_NUMBER = 20;
    public static final int FILE_NAME_FIELD_NUMBER = 35;
    public static final int FILE_SHA_FIELD_NUMBER = 36;
    public static final int FILE_SIZE_FIELD_NUMBER = 34;
    public static final int PASS_WORD_FIELD_NUMBER = 3;
    public static final int QR_FLAG_FIELD_NUMBER = 5;
    public static final int SHARE_NAME_FIELD_NUMBER = 1;
    public static final int SOURCE_FIELD_NUMBER = 2;
    public static final int SRC_APPID_FIELD_NUMBER = 32;
    public static final int SRC_FULL_PATH_FIELD_NUMBER = 33;
    public static final int SRC_UIN_FIELD_NUMBER = 31;
    public static final int WEIYUN_SHARE_AUTH_INFO_FIELD_NUMBER = 10;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField enable_qq_add_friend = PBField.initBool(false);
    public WeiyunPB.ShareFileItem file = new WeiyunPB.ShareFileItem();
    public final PBStringField file_name = PBField.initString("");
    public final PBStringField file_sha = PBField.initString("");
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBStringField pass_word = PBField.initString("");
    public final PBInt32Field qr_flag = PBField.initInt32(0);
    public final PBStringField share_name = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBUInt32Field src_appid = PBField.initUInt32(0);
    public final PBBytesField src_full_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field src_uin = PBField.initUInt64(0L);
    public WeiyunPB.WeiyunShareAuthInfo weiyun_share_auth_info = new WeiyunPB.WeiyunShareAuthInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 82, 162, 248, 256, 266, 272, 282, 290 }, new String[] { "share_name", "source", "pass_word", "enable_qq_add_friend", "qr_flag", "weiyun_share_auth_info", "file", "src_uin", "src_appid", "src_full_path", "file_size", "file_name", "file_sha" }, new Object[] { "", Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), null, null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), "", "" }, WeiyunShareAddFromMobileQQMsgReq.class);
    }
  }
  
  public static final class WeiyunShareAddFromMobileQQMsgRsp
    extends MessageMicro<WeiyunShareAddFromMobileQQMsgRsp>
  {
    public static final int ICON_FIELD_NUMBER = 91;
    public static final int RAW_URL_FIELD_NUMBER = 10;
    public static final int SHARE_CNT_FIELD_NUMBER = 40;
    public static final int SHARE_KEY_FIELD_NUMBER = 60;
    public static final int SHARE_NAME_FIELD_NUMBER = 30;
    public static final int SHARE_PWD_FIELD_NUMBER = 50;
    public static final int SHORT_URL_FIELD_NUMBER = 20;
    public static final int THUMB_URL_FIELD_NUMBER = 90;
    public static final int WEIYUN_SHARE_AUTH_INFO_FIELD_NUMBER = 80;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 320, 402, 482, 642, 722, 730 }, new String[] { "raw_url", "short_url", "share_name", "share_cnt", "share_pwd", "share_key", "weiyun_share_auth_info", "thumb_url", "icon" }, new Object[] { "", "", "", Integer.valueOf(0), "", "", null, "", "" }, WeiyunShareAddFromMobileQQMsgRsp.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField raw_url = PBField.initString("");
    public final PBInt32Field share_cnt = PBField.initInt32(0);
    public final PBStringField share_key = PBField.initString("");
    public final PBStringField share_name = PBField.initString("");
    public final PBStringField share_pwd = PBField.initString("");
    public final PBStringField short_url = PBField.initString("");
    public final PBStringField thumb_url = PBField.initString("");
    public WeiyunPB.WeiyunShareAuthInfo weiyun_share_auth_info = new WeiyunPB.WeiyunShareAuthInfo();
  }
  
  public static final class WeiyunShareAuthInfo
    extends MessageMicro<WeiyunShareAuthInfo>
  {
    public static final int AUTH_LEVEL_FIELD_NUMBER = 10;
    public static final int EXPIRED_TIME_FIELD_NUMBER = 20;
    public static final int LIMIT_VISIT_COUNT_FIELD_NUMBER = 30;
    public static final int PASS_WORD_FIELD_NUMBER = 40;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322 }, new String[] { "auth_level", "expired_time", "limit_visit_count", "pass_word" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, WeiyunShareAuthInfo.class);
    public final PBInt32Field auth_level = PBField.initInt32(0);
    public final PBUInt32Field expired_time = PBField.initUInt32(0);
    public final PBInt32Field limit_visit_count = PBField.initInt32(0);
    public final PBStringField pass_word = PBField.initString("");
  }
  
  public static final class WeiyunTrialCouponUseMsgReq
    extends MessageMicro<WeiyunTrialCouponUseMsgReq>
  {
    public static final int BUSINESS_ID_FIELD_NUMBER = 10;
    public static final int FILE_ITEM_FIELD_NUMBER = 50;
    public static final int USE_NUM_FIELD_NUMBER = 20;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 160, 402 }, new String[] { "business_id", "use_num", "file_item" }, new Object[] { "", Integer.valueOf(1), null }, WeiyunTrialCouponUseMsgReq.class);
    public final PBStringField business_id = PBField.initString("");
    public WeiyunPB.FileItem file_item = new WeiyunPB.FileItem();
    public final PBInt32Field use_num = PBField.initInt32(1);
  }
  
  public static final class WeiyunTrialCouponUseMsgRsp
    extends MessageMicro<WeiyunTrialCouponUseMsgRsp>
  {
    public static final int USER_STATICS_LEVEL_FIELD_NUMBER = 20;
    public static final int WEIYUN_VIP_FLAG_FIELD_NUMBER = 10;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160 }, new String[] { "weiyun_vip_flag", "user_statics_level" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, WeiyunTrialCouponUseMsgRsp.class);
    public final PBInt32Field user_statics_level = PBField.initInt32(0);
    public final PBInt32Field weiyun_vip_flag = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB
 * JD-Core Version:    0.7.0.1
 */