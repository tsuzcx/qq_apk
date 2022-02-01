package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloStartBattleOBCmd
  extends MessageMicro<YoloStartBattleOBCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "device_id", "yolo_battle_id" }, new Object[] { "", Long.valueOf(0L) }, YoloStartBattleOBCmd.class);
  public final PBStringField device_id = PBField.initString("");
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloStartBattleOBCmd
 * JD-Core Version:    0.7.0.1
 */