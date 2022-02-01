package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameNotify$RoomUserExitS2CReq
  extends MessageMicro<RoomUserExitS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 32, 40, 48, 56, 66, 74 }, new String[] { "exit_reason", "room_info", "exit_uin", "new_owner_uin", "heartbeat_timeout", "sub_reason", "onwer_tip", "exiter_tip" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "" }, RoomUserExitS2CReq.class);
  public final PBUInt32Field exit_reason = PBField.initUInt32(0);
  public final PBUInt64Field exit_uin = PBField.initUInt64(0L);
  public final PBStringField exiter_tip = PBField.initString("");
  public final PBUInt32Field heartbeat_timeout = PBField.initUInt32(0);
  public final PBUInt64Field new_owner_uin = PBField.initUInt64(0L);
  public final PBStringField onwer_tip = PBField.initString("");
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
  public final PBUInt32Field sub_reason = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.RoomUserExitS2CReq
 * JD-Core Version:    0.7.0.1
 */