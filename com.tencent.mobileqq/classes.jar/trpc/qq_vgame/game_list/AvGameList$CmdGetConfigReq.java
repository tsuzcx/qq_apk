package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameList$CmdGetConfigReq
  extends MessageMicro<CmdGetConfigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "game_type", "roomid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, CmdGetConfigReq.class);
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdGetConfigReq
 * JD-Core Version:    0.7.0.1
 */