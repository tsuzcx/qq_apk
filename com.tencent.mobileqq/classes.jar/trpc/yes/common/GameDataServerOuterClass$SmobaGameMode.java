package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$SmobaGameMode
  extends MessageMicro<SmobaGameMode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBInt32Field game_type = PBField.initInt32(0);
  public final PBInt32Field max_player = PBField.initInt32(0);
  public final PBInt32Field min_player = PBField.initInt32(0);
  public final PBStringField mode_name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 40, 48 }, new String[] { "game_mode", "mode_name", "game_type", "min_player", "max_player" }, new Object[] { localInteger, "", localInteger, localInteger, localInteger }, SmobaGameMode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaGameMode
 * JD-Core Version:    0.7.0.1
 */