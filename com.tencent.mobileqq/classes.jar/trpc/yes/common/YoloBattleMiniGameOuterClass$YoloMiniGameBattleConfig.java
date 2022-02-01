package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig
  extends MessageMicro<YoloMiniGameBattleConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBInt32Field mode_id = PBField.initInt32(0);
  public final PBStringField version = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "game_id", "mode_id", "version" }, new Object[] { localInteger, localInteger, "" }, YoloMiniGameBattleConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig
 * JD-Core Version:    0.7.0.1
 */