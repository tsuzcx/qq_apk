package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$GetAnchorRoomInfoRsp
  extends MessageMicro<GetAnchorRoomInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field equip_setting_status = PBField.initInt32(0);
  public GameDataServerOuterClass.AnchorGameInfo game_info = new GameDataServerOuterClass.AnchorGameInfo();
  public final PBInt32Field refresh_interval = PBField.initInt32(0);
  public final PBRepeatMessageField<GameDataServerOuterClass.TextShowInfo> text_show_list = PBField.initRepeatMessage(GameDataServerOuterClass.TextShowInfo.class);
  public final PBStringField tips = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "game_info", "text_show_list", "tips", "refresh_interval", "equip_setting_status" }, new Object[] { null, null, "", localInteger, localInteger }, GetAnchorRoomInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorRoomInfoRsp
 * JD-Core Version:    0.7.0.1
 */