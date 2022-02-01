package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloSmobaRoomChooceHeroCmd
  extends MessageMicro<YoloSmobaRoomChooceHeroCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "game_rolo_hero_info", "hero_lane_type" }, new Object[] { null, Integer.valueOf(0) }, YoloSmobaRoomChooceHeroCmd.class);
  public GameDataServerOuterClass.GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass.GameRoleHeroInfo();
  public final PBInt32Field hero_lane_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd
 * JD-Core Version:    0.7.0.1
 */