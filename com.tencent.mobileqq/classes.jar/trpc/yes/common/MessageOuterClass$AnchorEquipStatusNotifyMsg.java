package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MessageOuterClass$AnchorEquipStatusNotifyMsg
  extends MessageMicro<AnchorEquipStatusNotifyMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "equip_status", "game_info" }, new Object[] { Integer.valueOf(0), null }, AnchorEquipStatusNotifyMsg.class);
  public final PBInt32Field equip_status = PBField.initInt32(0);
  public GameDataServerOuterClass.AnchorGameInfo game_info = new GameDataServerOuterClass.AnchorGameInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.AnchorEquipStatusNotifyMsg
 * JD-Core Version:    0.7.0.1
 */