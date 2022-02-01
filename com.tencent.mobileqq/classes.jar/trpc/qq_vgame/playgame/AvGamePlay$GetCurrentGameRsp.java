package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$GetCurrentGameRsp
  extends MessageMicro<GetCurrentGameRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "roomid", "type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetCurrentGameRsp.class);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.GetCurrentGameRsp
 * JD-Core Version:    0.7.0.1
 */