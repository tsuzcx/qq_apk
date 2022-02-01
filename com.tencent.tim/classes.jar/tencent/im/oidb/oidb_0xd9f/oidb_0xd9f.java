package tencent.im.oidb.oidb_0xd9f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd9f
{
  public static final class LongNickItem
    extends MessageMicro<LongNickItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_longnick", "rpt_topic_item" }, new Object[] { "", null }, LongNickItem.class);
    public final PBRepeatMessageField<oidb_0xd9f.TopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9f.TopicItem.class);
    public final PBStringField str_longnick = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "longnick_item" }, new Object[] { null }, RspBody.class);
    public oidb_0xd9f.LongNickItem longnick_item = new oidb_0xd9f.LongNickItem();
  }
  
  public static final class TopicItem
    extends MessageMicro<TopicItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_topic_id", "str_topic", "uint32_frd_num", "rpt_frd_item" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, TopicItem.class);
    public final PBRepeatMessageField<oidb_0xd9f.UinItem> rpt_frd_item = PBField.initRepeatMessage(oidb_0xd9f.UinItem.class);
    public final PBStringField str_topic = PBField.initString("");
    public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  }
  
  public static final class UinItem
    extends MessageMicro<UinItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UinItem.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9f.oidb_0xd9f
 * JD-Core Version:    0.7.0.1
 */