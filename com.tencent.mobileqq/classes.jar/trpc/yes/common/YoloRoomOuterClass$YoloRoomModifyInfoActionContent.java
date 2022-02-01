package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomModifyInfoActionContent
  extends MessageMicro<YoloRoomModifyInfoActionContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "room_params", "smoba_room_params" }, new Object[] { Integer.valueOf(0), null, null }, YoloRoomModifyInfoActionContent.class);
  public YoloRoomOuterClass.YoloRoomParams room_params = new YoloRoomOuterClass.YoloRoomParams();
  public YoloRoomOuterClass.YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass.YoloSmobaRoomParams();
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent
 * JD-Core Version:    0.7.0.1
 */