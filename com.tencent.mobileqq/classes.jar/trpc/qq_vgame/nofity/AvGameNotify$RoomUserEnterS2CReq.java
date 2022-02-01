package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameNotify$RoomUserEnterS2CReq
  extends MessageMicro<RoomUserEnterS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "room_info", "type", "enter_uin", "inviter_uin" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, RoomUserEnterS2CReq.class);
  public final PBUInt64Field enter_uin = PBField.initUInt64(0L);
  public final PBUInt64Field inviter_uin = PBField.initUInt64(0L);
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.RoomUserEnterS2CReq
 * JD-Core Version:    0.7.0.1
 */