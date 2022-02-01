package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattleBaseInfo
  extends MessageMicro<YoloBattleBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField battle_game = PBField.initEnum(0);
  public YoloBattleOuterClass.YoloBattleDyeInfo dye_info = new YoloBattleOuterClass.YoloBattleDyeInfo();
  public final PBEnumField from_scene = PBField.initEnum(1);
  public final PBStringField game_battle_id = PBField.initString("");
  public final PBEnumField life_cycle = PBField.initEnum(0);
  public final PBBoolField need_battle_ob = PBField.initBool(false);
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
  public final PBUInt32Field yolo_battle_status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 162, 800, 808, 818 }, new String[] { "from_scene", "battle_game", "life_cycle", "need_battle_ob", "dye_info", "yolo_battle_status", "yolo_battle_id", "game_battle_id" }, new Object[] { Integer.valueOf(1), localInteger, localInteger, Boolean.valueOf(false), null, localInteger, Long.valueOf(0L), "" }, YoloBattleBaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleBaseInfo
 * JD-Core Version:    0.7.0.1
 */