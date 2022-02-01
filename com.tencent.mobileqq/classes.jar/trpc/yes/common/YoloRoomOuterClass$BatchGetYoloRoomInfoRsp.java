package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$BatchGetYoloRoomInfoRsp
  extends MessageMicro<BatchGetYoloRoomInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "all_room_info" }, new Object[] { null }, BatchGetYoloRoomInfoRsp.class);
  public final PBRepeatMessageField<YoloRoomOuterClass.AllYoloRoomInfo> all_room_info = PBField.initRepeatMessage(YoloRoomOuterClass.AllYoloRoomInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.BatchGetYoloRoomInfoRsp
 * JD-Core Version:    0.7.0.1
 */