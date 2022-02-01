package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloRoomEnterAction
  extends MessageMicro<YoloRoomEnterAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_id", "enter_room_text" }, new Object[] { null, "" }, YoloRoomEnterAction.class);
  public final PBStringField enter_room_text = PBField.initString("");
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterAction
 * JD-Core Version:    0.7.0.1
 */