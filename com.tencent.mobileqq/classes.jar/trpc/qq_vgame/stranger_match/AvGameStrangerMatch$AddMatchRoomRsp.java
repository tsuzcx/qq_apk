package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameStrangerMatch$AddMatchRoomRsp
  extends MessageMicro<AddMatchRoomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "res", "shard_id" }, new Object[] { null, Integer.valueOf(0) }, AddMatchRoomRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt32Field shard_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomRsp
 * JD-Core Version:    0.7.0.1
 */