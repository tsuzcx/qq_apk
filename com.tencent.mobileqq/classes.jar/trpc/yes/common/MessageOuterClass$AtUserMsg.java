package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MessageOuterClass$AtUserMsg
  extends MessageMicro<AtUserMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "text", "user_list", "show_type" }, new Object[] { "", null, Integer.valueOf(0) }, AtUserMsg.class);
  public final PBInt32Field show_type = PBField.initInt32(0);
  public final PBStringField text = PBField.initString("");
  public final PBRepeatMessageField<MessageOuterClass.AtUser> user_list = PBField.initRepeatMessage(MessageOuterClass.AtUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.AtUserMsg
 * JD-Core Version:    0.7.0.1
 */