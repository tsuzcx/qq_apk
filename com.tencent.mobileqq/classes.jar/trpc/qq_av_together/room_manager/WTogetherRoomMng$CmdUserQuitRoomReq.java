package trpc.qq_av_together.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherRoomMng$CmdUserQuitRoomReq
  extends MessageMicro<CmdUserQuitRoomReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "from", "room_id", "client_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CmdUserQuitRoomReq.class);
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBEnumField from = PBField.initEnum(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserQuitRoomReq
 * JD-Core Version:    0.7.0.1
 */