package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloSmobaRoomChangeRoleCmd
  extends MessageMicro<YoloSmobaRoomChangeRoleCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "role_id", "role_abs_info", "role_info" }, new Object[] { null, null, null }, YoloSmobaRoomChangeRoleCmd.class);
  public GameDataServerOuterClass.GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass.GameRoleAbsInfo();
  public GameDataServerOuterClass.GameRoleId role_id = new GameDataServerOuterClass.GameRoleId();
  public GameDataServerOuterClass.GameRoleInfo role_info = new GameDataServerOuterClass.GameRoleInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomChangeRoleCmd
 * JD-Core Version:    0.7.0.1
 */