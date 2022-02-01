package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameStrangerMatchV2$AddMatchRoomReq
  extends MessageMicro<AddMatchRoomReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field from = PBField.initUInt32(0);
  public final PBUInt32Field game_type = PBField.initUInt32(0);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "roomid", "game_type", "owner_uin", "from" }, new Object[] { localLong, localInteger, localLong, localInteger }, AddMatchRoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchRoomReq
 * JD-Core Version:    0.7.0.1
 */