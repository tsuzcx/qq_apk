package tencent.im.oidb.cmd0x5ea;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UpdatePhotoList
{
  public static final class HeadInfo
    extends MessageMicro<HeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58 }, new String[] { "uint32_headid", "str_headurl", "uint32_is_curhead", "str_video_url", "uint32_video_time", "uint32_video_size", "str_video_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, HeadInfo.class);
    public final PBStringField str_headurl = PBField.initString("");
    public final PBStringField str_video_id = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
    public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_curhead = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "rpt_uint32_headids", "str_upload_url", "uint32_copy_count_from_qzone", "msg_lbs_info", "rpt_msg_rich_headids", "msg_verify_video_info" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
    public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
    public UpdatePhotoList.RichHead msg_verify_video_info = new UpdatePhotoList.RichHead();
    public final PBRepeatMessageField<UpdatePhotoList.RichHead> rpt_msg_rich_headids = PBField.initRepeatMessage(UpdatePhotoList.RichHead.class);
    public final PBRepeatField<Integer> rpt_uint32_headids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField str_upload_url = PBField.initString("");
    public final PBUInt32Field uint32_copy_count_from_qzone = PBField.initUInt32(0);
  }
  
  public static final class RichHead
    extends MessageMicro<RichHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_headid", "str_video_id" }, new Object[] { Integer.valueOf(0), "" }, RichHead.class);
    public final PBStringField str_video_id = PBField.initString("");
    public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "rpt_msg_headinfo", "str_errorinfo", "uint32_import_state", "uint32_import_count", "uint32_import_rest_count", "uint32_rest_count_in_qzone", "msg_verify_video_info" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public UpdatePhotoList.HeadInfo msg_verify_video_info = new UpdatePhotoList.HeadInfo();
    public final PBRepeatMessageField<UpdatePhotoList.HeadInfo> rpt_msg_headinfo = PBField.initRepeatMessage(UpdatePhotoList.HeadInfo.class);
    public final PBStringField str_errorinfo = PBField.initString("");
    public final PBUInt32Field uint32_import_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_import_rest_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_import_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rest_count_in_qzone = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ea.UpdatePhotoList
 * JD-Core Version:    0.7.0.1
 */