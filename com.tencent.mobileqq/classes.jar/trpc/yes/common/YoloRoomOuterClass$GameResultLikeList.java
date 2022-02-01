package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$GameResultLikeList
  extends MessageMicro<GameResultLikeList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { null }, GameResultLikeList.class);
  public final PBRepeatMessageField<YoloRoomOuterClass.GameResultLikeItem> list = PBField.initRepeatMessage(YoloRoomOuterClass.GameResultLikeItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.GameResultLikeList
 * JD-Core Version:    0.7.0.1
 */