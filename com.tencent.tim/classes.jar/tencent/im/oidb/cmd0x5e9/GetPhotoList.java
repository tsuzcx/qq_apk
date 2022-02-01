package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetPhotoList
{
  public static final class HeadInfo
    extends MessageMicro<HeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32, 40, 48, 56, 64, 74, 80, 88, 98 }, new String[] { "uint32_headid", "str_headurl", "uint32_is_curhead", "uint32_flag", "uint32_proc_state", "uint32_face", "uint32_charm", "str_video_url", "uint32_video_time", "uint32_video_size", "str_video_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, HeadInfo.class);
    public final PBStringField str_headurl = PBField.initString("");
    public final PBStringField str_video_id = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_headid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_curhead = PBField.initUInt32(0);
    public final PBUInt32Field uint32_proc_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_uin", "uint32_fetch_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_fetch_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_heads" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<GetPhotoList.UinHeadInfo> rpt_msg_uin_heads = PBField.initRepeatMessage(GetPhotoList.UinHeadInfo.class);
  }
  
  public static final class UinHeadInfo
    extends MessageMicro<UinHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint64_uin", "uint32_timestamp", "uint32_headcount", "rpt_msg_headinfo", "str_headurl", "msg_verify_video_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, "", null }, UinHeadInfo.class);
    public GetPhotoList.HeadInfo msg_verify_video_info = new GetPhotoList.HeadInfo();
    public final PBRepeatMessageField<GetPhotoList.HeadInfo> rpt_msg_headinfo = PBField.initRepeatMessage(GetPhotoList.HeadInfo.class);
    public final PBStringField str_headurl = PBField.initString("");
    public final PBUInt32Field uint32_headcount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e9.GetPhotoList
 * JD-Core Version:    0.7.0.1
 */