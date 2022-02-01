package tencent.im.oidb.oidb_0xda6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xda6
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "keyword" }, new Object[] { "" }, ReqBody.class);
    public final PBStringField keyword = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topic_item" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xda6.UserTopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xda6.UserTopicItem.class);
  }
  
  public static final class UinItem
    extends MessageMicro<UinItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UinItem.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UserTopicItem
    extends MessageMicro<UserTopicItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56 }, new String[] { "uint32_topic_id", "str_topic", "uint32_total_num", "uint32_frd_num", "rpt_frd_item", "uint32_audit_state", "uint32_apply_num" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, UserTopicItem.class);
    public final PBRepeatMessageField<oidb_0xda6.UinItem> rpt_frd_item = PBField.initRepeatMessage(oidb_0xda6.UinItem.class);
    public final PBStringField str_topic = PBField.initString("");
    public final PBUInt32Field uint32_apply_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audit_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xda6.oidb_0xda6
 * JD-Core Version:    0.7.0.1
 */