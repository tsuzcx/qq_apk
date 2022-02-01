package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x9fa
{
  public static final class AddFeedbackHateGroupCmd
    extends MessageMicro<AddFeedbackHateGroupCmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_group_code" }, new Object[] { Long.valueOf(0L) }, AddFeedbackHateGroupCmd.class);
    public final PBRepeatField<Long> uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ChannelInfo
    extends MessageMicro<ChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_channel_status", "uint64_channel_optime" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ChannelInfo.class);
    public final PBUInt32Field uint32_channel_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_optime = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class FeedbackData
    extends MessageMicro<FeedbackData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_feedback" }, new Object[] { null }, FeedbackData.class);
    public final PBRepeatMessageField<oidb_0x9fa.FeedbackDataItem> msg_feedback = PBField.initRepeatMessage(oidb_0x9fa.FeedbackDataItem.class);
  }
  
  public static final class FeedbackDataItem
    extends MessageMicro<FeedbackDataItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint64_feedback_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FeedbackDataItem.class);
    public final PBUInt64Field uint64_feedback_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetFeedbackHateGroupCmd
    extends MessageMicro<GetFeedbackHateGroupCmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "page_no", "page_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetFeedbackHateGroupCmd.class);
    public final PBInt32Field page_no = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
  }
  
  public static final class GetSimilarGroupWebInfo
    extends MessageMicro<GetSimilarGroupWebInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetSimilarGroupWebInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class QueryRecommendChannelCmd
    extends MessageMicro<QueryRecommendChannelCmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, QueryRecommendChannelCmd.class);
    public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint32_appid", "uint32_cmdid", "int32_channel", "msg_add_hate_group", "msg_channel_status", "msg_channel_set", "msg_get_hate_group", "msg_get_web_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
    public final PBInt32Field int32_channel = PBField.initInt32(0);
    public oidb_0x9fa.AddFeedbackHateGroupCmd msg_add_hate_group = new oidb_0x9fa.AddFeedbackHateGroupCmd();
    public oidb_0x9fa.SetRecommendChannelCmd msg_channel_set = new oidb_0x9fa.SetRecommendChannelCmd();
    public oidb_0x9fa.QueryRecommendChannelCmd msg_channel_status = new oidb_0x9fa.QueryRecommendChannelCmd();
    public oidb_0x9fa.GetFeedbackHateGroupCmd msg_get_hate_group = new oidb_0x9fa.GetFeedbackHateGroupCmd();
    public oidb_0x9fa.GetSimilarGroupWebInfo msg_get_web_info = new oidb_0x9fa.GetSimilarGroupWebInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x9fa.ChannelInfo> msg_channel = PBField.initRepeatMessage(oidb_0x9fa.ChannelInfo.class);
    public oidb_0x9fa.FeedbackData msg_feed_data = new oidb_0x9fa.FeedbackData();
    public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public oidb_0x9fa.SimilarGroupWebInfo web_info = new oidb_0x9fa.SimilarGroupWebInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_cmdid", "uint32_result", "bytes_errMsg", "msg_feed_data", "msg_channel", "web_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
    }
  }
  
  public static final class SetRecommendChannelCmd
    extends MessageMicro<SetRecommendChannelCmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_channel" }, new Object[] { null }, SetRecommendChannelCmd.class);
    public final PBRepeatMessageField<oidb_0x9fa.ChannelInfo> msg_channel = PBField.initRepeatMessage(oidb_0x9fa.ChannelInfo.class);
  }
  
  public static final class SimilarGroupWebInfo
    extends MessageMicro<SimilarGroupWebInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_url" }, new Object[] { localByteStringMicro }, SimilarGroupWebInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa
 * JD-Core Version:    0.7.0.1
 */