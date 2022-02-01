package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloRoomRotateMessage
  extends MessageMicro<YoloRoomRotateMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<YoloRoomOuterClass.RotateMessageLabel> label = PBField.initRepeatMessage(YoloRoomOuterClass.RotateMessageLabel.class);
  public final PBUInt32Field message_time = PBField.initUInt32(0);
  public final PBStringField message_tpl = PBField.initString("");
  public final PBInt32Field message_type = PBField.initInt32(0);
  public final PBInt32Field show_time = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "message_type", "message_time", "message_tpl", "label", "show_time" }, new Object[] { localInteger, localInteger, "", null, localInteger }, YoloRoomRotateMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage
 * JD-Core Version:    0.7.0.1
 */