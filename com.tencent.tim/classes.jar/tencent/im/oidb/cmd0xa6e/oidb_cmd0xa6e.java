package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa6e
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 88, 96 }, new String[] { "rpt_topiclist", "uint32_req_pv", "uint32_req_followed_count", "uint32_req_ugc_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_topiclist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_followed_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_pv = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_ugc_count = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topicinfo" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xa6e.TopicInfo> rpt_topicinfo = PBField.initRepeatMessage(oidb_cmd0xa6e.TopicInfo.class);
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 88, 96 }, new String[] { "uint64_topic_id", "uint32_pv", "uint32_followed_count", "uint32_ugc_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TopicInfo.class);
    public final PBUInt32Field uint32_followed_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pv = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ugc_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e
 * JD-Core Version:    0.7.0.1
 */