package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaHeroConf;

public final class GameDataServerOuterClass$GameRoleHeroInfo
  extends MessageMicro<GameRoleHeroInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fail_num = PBField.initUInt32(0);
  public final PBUInt32Field fight_score = PBField.initUInt32(0);
  public WujiSmobaOuterClass.WujiSmobaHeroConf hero_info = new WujiSmobaOuterClass.WujiSmobaHeroConf();
  public final PBUInt32Field skilled = PBField.initUInt32(0);
  public final PBUInt32Field skilled_level = PBField.initUInt32(0);
  public final PBStringField skilled_title = PBField.initString("");
  public final PBUInt32Field title_location_type = PBField.initUInt32(0);
  public final PBUInt32Field title_rank = PBField.initUInt32(0);
  public final PBUInt32Field win_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72 }, new String[] { "hero_info", "win_num", "fail_num", "skilled", "skilled_level", "skilled_title", "fight_score", "title_location_type", "title_rank" }, new Object[] { null, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger }, GameRoleHeroInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GameRoleHeroInfo
 * JD-Core Version:    0.7.0.1
 */