package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloRoomGameResultLikeAction
  extends MessageMicro<YoloRoomGameResultLikeAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "from_user_id", "to_user_id", "msg_id", "list" }, new Object[] { null, null, "", null }, YoloRoomGameResultLikeAction.class);
  public CommonOuterClass.QQUserId from_user_id = new CommonOuterClass.QQUserId();
  public YoloRoomOuterClass.GameResultLikeList list = new YoloRoomOuterClass.GameResultLikeList();
  public final PBStringField msg_id = PBField.initString("");
  public CommonOuterClass.QQUserId to_user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomGameResultLikeAction
 * JD-Core Version:    0.7.0.1
 */