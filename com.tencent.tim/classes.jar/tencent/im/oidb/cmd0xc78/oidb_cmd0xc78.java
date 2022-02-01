package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc78
{
  public static final class AppFileMsgInfo
    extends MessageMicro<AppFileMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha1", "file_size" }, new Object[] { "", "", Integer.valueOf(0) }, AppFileMsgInfo.class);
    public final PBUInt32Field file_size = PBField.initUInt32(0);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
  }
  
  public static final class AppMsgInfo
    extends MessageMicro<AppMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "url", "title", "description", "thumb_url" }, new Object[] { "", "", "", "" }, AppMsgInfo.class);
    public final PBStringField description = PBField.initString("");
    public final PBStringField thumb_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class CheckShareExtensionReq
    extends MessageMicro<CheckShareExtensionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 90, 98, 106, 114, 122 }, new String[] { "uin", "src", "ios_boundle_id", "android_package_names", "content_type", "user_flag1", "user_flag2", "texts", "imgs", "videos", "files", "app_msgs" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null }, CheckShareExtensionReq.class);
    public final PBRepeatField<String> android_package_names = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0xc78.AppMsgInfo> app_msgs = PBField.initRepeatMessage(oidb_cmd0xc78.AppMsgInfo.class);
    public final PBUInt32Field content_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xc78.AppFileMsgInfo> files = PBField.initRepeatMessage(oidb_cmd0xc78.AppFileMsgInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc78.ImgInfo> imgs = PBField.initRepeatMessage(oidb_cmd0xc78.ImgInfo.class);
    public final PBStringField ios_boundle_id = PBField.initString("");
    public final PBStringField src = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xc78.TextInfo> texts = PBField.initRepeatMessage(oidb_cmd0xc78.TextInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt64Field user_flag1 = PBField.initUInt64(0L);
    public final PBUInt64Field user_flag2 = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_cmd0xc78.VideoInfo> videos = PBField.initRepeatMessage(oidb_cmd0xc78.VideoInfo.class);
  }
  
  public static final class CheckShareExtensionRsp
    extends MessageMicro<CheckShareExtensionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "result", "jump_result", "jump_url", "uint32_level", "uint32_sub_level" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, CheckShareExtensionRsp.class);
    public final PBUInt32Field jump_result = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
  }
  
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "md5", "sha1", "width", "height", "qr_decode_type", "qr_code_result" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, ImgInfo.class);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField qr_code_result = PBField.initString("");
    public final PBStringField qr_decode_type = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "check_share_extension_req" }, new Object[] { null }, ReqBody.class);
    public oidb_cmd0xc78.CheckShareExtensionReq check_share_extension_req = new oidb_cmd0xc78.CheckShareExtensionReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "wording", "check_share_extension_rsp" }, new Object[] { "", null }, RspBody.class);
    public oidb_cmd0xc78.CheckShareExtensionRsp check_share_extension_rsp = new oidb_cmd0xc78.CheckShareExtensionRsp();
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class TextInfo
    extends MessageMicro<TextInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "text_content" }, new Object[] { "" }, TextInfo.class);
    public final PBStringField text_content = PBField.initString("");
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha1", "play_duration" }, new Object[] { "", "", Integer.valueOf(0) }, VideoInfo.class);
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt32Field play_duration = PBField.initUInt32(0);
    public final PBStringField sha1 = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc78.oidb_cmd0xc78
 * JD-Core Version:    0.7.0.1
 */