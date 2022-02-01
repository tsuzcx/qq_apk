package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xc85
{
  public static final class InteractionDetailInfo
    extends MessageMicro<InteractionDetailInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 808, 816, 824, 834, 842 }, new String[] { "uint32_continuous_record_days", "uint32_send_day_time", "uint32_recv_day_time", "str_send_record", "str_recv_record" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, InteractionDetailInfo.class);
    public final PBStringField str_recv_record = PBField.initString("");
    public final PBStringField str_send_record = PBField.initString("");
    public final PBUInt32Field uint32_continuous_record_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_day_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_day_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 808, 816, 824, 832 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_op", "uint32_interval_days" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_interval_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 808, 816, 826 }, new String[] { "uint32_result", "uint32_recent_interaction_time", "interaction_detail_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
    public cmd0xc85.InteractionDetailInfo interaction_detail_info = new cmd0xc85.InteractionDetailInfo();
    public final PBUInt32Field uint32_recent_interaction_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc85
 * JD-Core Version:    0.7.0.1
 */