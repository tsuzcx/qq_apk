package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg
{
  public static final class FoldMsg
    extends MessageMicro<FoldMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field fold_flags = PBField.initUInt32(0);
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField redbag_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField redbag_index = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field redbag_sender_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "fold_flags", "redbag_sender_uin", "redbag_id", "msg_content", "redbag_index" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, FoldMsg.class);
    }
  }
  
  public static final class ForwardExtra
    extends MessageMicro<ForwardExtra>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "foward_orgId", "foward_orgUin", "foward_orgUinType", "foward_orgUrl", "foward_thumbPath", "foward_orgFileSizeType" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, ForwardExtra.class);
    public final PBInt32Field foward_orgFileSizeType = PBField.initInt32(0);
    public final PBUInt64Field foward_orgId = PBField.initUInt64(0L);
    public final PBStringField foward_orgUin = PBField.initString("");
    public final PBInt32Field foward_orgUinType = PBField.initInt32(0);
    public final PBStringField foward_orgUrl = PBField.initString("");
    public final PBStringField foward_thumbPath = PBField.initString("");
  }
  
  public static final class PicRec
    extends MessageMicro<PicRec>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bigMsgUrl = PBField.initString("");
    public final PBStringField bigthumbMsgUrl = PBField.initString("");
    public final PBBoolField bool_story_pic_send_to_recent = PBField.initBool(false);
    public final PBBytesField bytes_pb_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField enableEnc = PBField.initBool(false);
    public final PBInt32Field fileSizeFlag = PBField.initInt32(0);
    public RichMsg.ForwardExtra fowardInfo = new RichMsg.ForwardExtra();
    public final PBUInt64Field groupFileID = PBField.initUInt64(0L);
    public final PBBoolField isRead = PBField.initBool(false);
    public final PBInt32Field isReport = PBField.initInt32(0);
    public final PBStringField localPath = PBField.initString("");
    public final PBStringField localUUID = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt32Field notPredownloadReason = PBField.initUInt32(0);
    public final PBInt32Field preDownNetwork = PBField.initInt32(0);
    public final PBInt32Field preDownState = PBField.initInt32(0);
    public final PBInt32Field previewed = PBField.initInt32(0);
    public final PBStringField rawMsgUrl = PBField.initString("");
    public final PBStringField serverStorageSource = PBField.initString("");
    public final PBUInt64Field size = PBField.initUInt64(0L);
    public final PBStringField thumbMsgUrl = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBInt32Field uiOperatorFlag = PBField.initInt32(0);
    public final PBUInt32Field uint32_current_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_image_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    public final PBStringField uuid = PBField.initString("");
    public final PBInt32Field version = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88, 96, 106, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 258, 266, 272 }, new String[] { "localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "thumbMsgUrl", "bigMsgUrl", "rawMsgUrl", "fileSizeFlag", "uiOperatorFlag", "fowardInfo", "version", "isReport", "groupFileID", "localUUID", "preDownState", "preDownNetwork", "previewed", "uint32_thumb_width", "uint32_thumb_height", "uint32_width", "uint32_height", "uint32_image_type", "uint32_show_len", "uint32_download_len", "uint32_current_len", "notPredownloadReason", "enableEnc", "bigthumbMsgUrl", "bytes_pb_reserved", "bool_story_pic_send_to_recent" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "", localByteStringMicro, Boolean.valueOf(false) }, PicRec.class);
    }
  }
  
  public static final class PttRec
    extends MessageMicro<PttRec>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 72, 80, 88, 98, 104, 112, 122, 128, 136, 144, 152, 160, 170, 176, 186, 192, 200, 208 }, new String[] { "localPath", "size", "type", "isRead", "uuid", "md5", "serverStorageSource", "version", "isReport", "pttFlag", "groupFileID", "sttText", "longPttVipFlag", "expandStt", "group_file_key", "msgRecTime", "msgTime", "voiceType", "voiceLength", "voiceChangeFlag", "directUrl", "busiType", "fullLocalPath", "extFlag", "redpack_type", "autototext_voice" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Boolean.valueOf(false), "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, PttRec.class);
    public final PBUInt32Field autototext_voice = PBField.initUInt32(0);
    public final PBUInt32Field busiType = PBField.initUInt32(0);
    public final PBStringField directUrl = PBField.initString("");
    public final PBBoolField expandStt = PBField.initBool(false);
    public final PBUInt64Field extFlag = PBField.initUInt64(0L);
    public final PBStringField fullLocalPath = PBField.initString("");
    public final PBUInt64Field groupFileID = PBField.initUInt64(0L);
    public final PBStringField group_file_key = PBField.initString("");
    public final PBBoolField isRead = PBField.initBool(false);
    public final PBInt32Field isReport = PBField.initInt32(0);
    public final PBStringField localPath = PBField.initString("");
    public final PBInt32Field longPttVipFlag = PBField.initInt32(0);
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt64Field msgRecTime = PBField.initUInt64(0L);
    public final PBUInt64Field msgTime = PBField.initUInt64(0L);
    public final PBInt32Field pttFlag = PBField.initInt32(0);
    public final PBUInt32Field redpack_type = PBField.initUInt32(0);
    public final PBStringField serverStorageSource = PBField.initString("");
    public final PBUInt64Field size = PBField.initUInt64(0L);
    public final PBStringField sttText = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField uuid = PBField.initString("");
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBUInt32Field voiceChangeFlag = PBField.initUInt32(0);
    public final PBUInt32Field voiceLength = PBField.initUInt32(0);
    public final PBUInt32Field voiceType = PBField.initUInt32(0);
  }
  
  public static final class VideoFile
    extends MessageMicro<VideoFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_mediacodec_encode = PBField.initBool(false);
    public final PBBoolField bool_story_video_send_to_recent = PBField.initBool(false);
    public final PBBoolField bool_support_progressive = PBField.initBool(false);
    public final PBBytesField bytes_camera_video_templateid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_camera_video_templatename = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hotvideo_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hotvideo_icon_sub = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hotvideo_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hotvideo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_local_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_shortVideoId = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_file_source_dir = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_lastmodified = PBField.initUInt64(0L);
    public final PBUInt32Field red_envelope_pay_stat = PBField.initUInt32(0);
    public final PBUInt32Field uin32_from_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uin32_to_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uin32_uiOperatorFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_local_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_video_kandian_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_tail_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_envelope_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_video_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_transfered_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_binary_set = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 98, 106, 112, 120, 128, 136, 144, 152, 162, 168, 176, 184, 194, 200, 208, 216, 224, 232, 240, 250, 258, 266, 274, 280, 288, 296, 306, 312, 320, 328, 338, 346 }, new String[] { "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_status", "uint32_file_progress", "uint32_file_type", "bytes_thumb_file_md5", "bytes_source", "file_lastmodified", "uint32_thumb_file_size", "uint32_busi_type", "uin32_from_chat_type", "uin32_to_chat_type", "uin32_uiOperatorFlag", "bytes_video_file_source_dir", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "bytes_local_file_md5", "uint32_is_local_video", "uint32_transfered_size", "uint32_sub_busi_type", "uint32_video_attr", "uint32_video_binary_set", "bool_is_mediacodec_encode", "bytes_hotvideo_icon", "bytes_hotvideo_title", "bytes_hotvideo_url", "bytes_hotvideo_icon_sub", "uint32_special_video_type", "uint32_msg_tail_type", "uint32_red_envelope_type", "bytes_shortVideoId", "red_envelope_pay_stat", "uint32_long_video_kandian_type", "bool_story_video_send_to_recent", "bytes_camera_video_templateid", "bytes_camera_video_templatename" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro12, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro13, localByteStringMicro14 }, VideoFile.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     localpb.richMsg.RichMsg
 * JD-Core Version:    0.7.0.1
 */