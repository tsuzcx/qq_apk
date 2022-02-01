package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameList$CmdRoomDeleteReq
  extends MessageMicro<CmdRoomDeleteReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "roomid" }, new Object[] { Long.valueOf(0L) }, CmdRoomDeleteReq.class);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdRoomDeleteReq
 * JD-Core Version:    0.7.0.1
 */