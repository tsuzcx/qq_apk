package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloCloseBattleOBCmd
  extends MessageMicro<YoloCloseBattleOBCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ob_id", "yolo_battle_id" }, new Object[] { localLong, localLong }, YoloCloseBattleOBCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloCloseBattleOBCmd
 * JD-Core Version:    0.7.0.1
 */