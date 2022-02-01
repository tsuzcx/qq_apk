package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameStrangerMatchV2$AddMatchUserReq
  extends MessageMicro<AddMatchUserReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "game_type", "from" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, AddMatchUserReq.class);
  public final PBUInt32Field from = PBField.initUInt32(0);
  public final PBUInt32Field game_type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchUserReq
 * JD-Core Version:    0.7.0.1
 */