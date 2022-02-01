package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class AvGameNotify$RoomOwnerChangeGameS2CReq
  extends MessageMicro<RoomOwnerChangeGameS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "game_type" }, new Object[] { Integer.valueOf(0) }, RoomOwnerChangeGameS2CReq.class);
  public final PBEnumField game_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerChangeGameS2CReq
 * JD-Core Version:    0.7.0.1
 */