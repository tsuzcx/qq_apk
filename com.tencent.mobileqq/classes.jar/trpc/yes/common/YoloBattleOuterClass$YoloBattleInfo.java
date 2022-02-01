package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattleInfo
  extends MessageMicro<YoloBattleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloBattleOuterClass.YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public final PBUInt64Field battle_create_time = PBField.initUInt64(0L);
  public final PBEnumField battle_type = PBField.initEnum(0);
  public final PBStringField extra_data = PBField.initString("");
  public final PBInt32Field max_event_id = PBField.initInt32(0);
  public YoloBattleOuterClass.YoloBattlePlayerInfo player_info = new YoloBattleOuterClass.YoloBattlePlayerInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "battle_base_info", "player_info", "max_event_id", "battle_create_time", "extra_data", "battle_type" }, new Object[] { null, null, localInteger, Long.valueOf(0L), "", localInteger }, YoloBattleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleInfo
 * JD-Core Version:    0.7.0.1
 */