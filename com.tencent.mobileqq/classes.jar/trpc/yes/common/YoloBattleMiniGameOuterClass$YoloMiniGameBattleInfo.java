package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleInfo
  extends MessageMicro<YoloMiniGameBattleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig();
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBStringField extra_data = PBField.initString("");
  public final PBEnumField last_event_type = PBField.initEnum(0);
  public final PBEnumField status = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32, 40, 50 }, new String[] { "status", "config", "expire_time", "last_event_type", "extra_data" }, new Object[] { localInteger, null, localInteger, localInteger, "" }, YoloMiniGameBattleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameBattleInfo
 * JD-Core Version:    0.7.0.1
 */