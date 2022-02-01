package tencent.im.oidb.oidb_0xd9e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd9e
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqBody.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topic_item" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xd9e.UserTopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9e.UserTopicItem.class);
  }
  
  public static final class UserTopicItem
    extends MessageMicro<UserTopicItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_topic_id", "str_topic", "uint32_total_num", "uint32_frd_num" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, UserTopicItem.class);
    public final PBStringField str_topic = PBField.initString("");
    public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9e.oidb_0xd9e
 * JD-Core Version:    0.7.0.1
 */