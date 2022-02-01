package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameNotify$RoomUserChangeStatusS2CReq
  extends MessageMicro<RoomUserChangeStatusS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "user_status", "room_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RoomUserChangeStatusS2CReq.class);
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBEnumField user_status = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.RoomUserChangeStatusS2CReq
 * JD-Core Version:    0.7.0.1
 */