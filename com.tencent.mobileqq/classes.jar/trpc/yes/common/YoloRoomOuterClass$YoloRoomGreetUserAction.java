package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloRoomGreetUserAction
  extends MessageMicro<YoloRoomGreetUserAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_id", "greet_user_id", "greet_words" }, new Object[] { null, null, "" }, YoloRoomGreetUserAction.class);
  public CommonOuterClass.QQUserId greet_user_id = new CommonOuterClass.QQUserId();
  public final PBStringField greet_words = PBField.initString("");
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomGreetUserAction
 * JD-Core Version:    0.7.0.1
 */