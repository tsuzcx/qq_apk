package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$GetAnchorRoomInfoReq
  extends MessageMicro<GetAnchorRoomInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "anchor_id", "game_id", "room_id" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, GetAnchorRoomInfoReq.class);
  public final PBStringField anchor_id = PBField.initString("");
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorRoomInfoReq
 * JD-Core Version:    0.7.0.1
 */