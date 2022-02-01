package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleBeginEvent
  extends MessageMicro<YoloSmobaBattleBeginEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField battle_id = PBField.initString("");
  public final PBRepeatMessageField<SmobaDataOuterClass.OneCamp> camps = PBField.initRepeatMessage(SmobaDataOuterClass.OneCamp.class);
  public final PBInt32Field create_type = PBField.initInt32(0);
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBInt32Field game_type = PBField.initInt32(0);
  public final PBInt32Field is_warm_battle = PBField.initInt32(0);
  public final PBInt32Field level_id = PBField.initInt32(0);
  public final PBInt32Field map_acnt_num = PBField.initInt32(0);
  public final PBInt32Field map_type = PBField.initInt32(0);
  public final PBStringField ob_schema = PBField.initString("");
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 82, 90 }, new String[] { "game_id", "game_type", "map_acnt_num", "map_type", "level_id", "start_time", "battle_id", "is_warm_battle", "create_type", "camps", "ob_schema" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, null, "" }, YoloSmobaBattleBeginEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleBeginEvent
 * JD-Core Version:    0.7.0.1
 */