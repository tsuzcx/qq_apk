package trpc.qq_av_together.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_av_together.common.WTogetherCommon.Result;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;

public final class WTogetherRoomMng$CmdUserEnterRoomRsp
  extends MessageMicro<CmdUserEnterRoomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "room_info" }, new Object[] { null, null }, CmdUserEnterRoomRsp.class);
  public WTogetherCommon.Result res = new WTogetherCommon.Result();
  public WTogetherCommon.RoomInfo room_info = new WTogetherCommon.RoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.room_manager.WTogetherRoomMng.CmdUserEnterRoomRsp
 * JD-Core Version:    0.7.0.1
 */