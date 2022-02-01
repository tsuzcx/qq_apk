package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x74b
{
  public static final class HeadInfo
    extends MessageMicro<HeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34, 40, 48, 88 }, new String[] { "uint32_id", "rpt_videoheadlist", "str_photohead", "uint32_timestamp", "uint32_type", "uint32_invalid" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HeadInfo.class);
    public final PBRepeatMessageField<oidb_0x74b.VideoHeadInfo> rpt_videoheadlist = PBField.initRepeatMessage(oidb_0x74b.VideoHeadInfo.class);
    public final PBStringField str_photohead = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invalid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class OneUinHeadInfo
    extends MessageMicro<OneUinHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 88 }, new String[] { "uint64_uin", "uint32_timestamp", "rpt_msg_head_list", "uint64_tinyid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, OneUinHeadInfo.class);
    public final PBRepeatMessageField<oidb_0x74b.HeadInfo> rpt_msg_head_list = PBField.initRepeatMessage(oidb_0x74b.HeadInfo.class);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "rpt_uint64_uin", "rpt_uint64_tinyid", "rpt_uint32_video_size", "rpt_head_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Integer> rpt_head_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_video_size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_head_list" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x74b.OneUinHeadInfo> rpt_msg_uin_head_list = PBField.initRepeatMessage(oidb_0x74b.OneUinHeadInfo.class);
  }
  
  public static final class VideoHeadInfo
    extends MessageMicro<VideoHeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_url", "uint32_video_size" }, new Object[] { "", Integer.valueOf(0) }, VideoHeadInfo.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b
 * JD-Core Version:    0.7.0.1
 */