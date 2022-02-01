package tencent.im.oidb.cmd0x908;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x908
{
  public static final class ChildChannelStatus
    extends MessageMicro<ChildChannelStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_channel_header_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_child_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscription_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_system_recomm = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "uint32_child_channel_id", "uint32_status", "bytes_channel_header_url", "uint32_subscription_count", "uint32_system_recomm", "uint32_is_topic" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ChildChannelStatus.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_parent_channel_id", "rpt_child_channel_list", "uint32_req_channel_subscription_count", "uint32_req_channel_header_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatField<Integer> rpt_child_channel_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_parent_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_channel_header_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_channel_subscription_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_parent_channel_id", "rpt_child_channel_status_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x908.ChildChannelStatus> rpt_child_channel_status_list = PBField.initRepeatMessage(oidb_cmd0x908.ChildChannelStatus.class);
    public final PBUInt32Field uint32_parent_channel_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x908.oidb_cmd0x908
 * JD-Core Version:    0.7.0.1
 */