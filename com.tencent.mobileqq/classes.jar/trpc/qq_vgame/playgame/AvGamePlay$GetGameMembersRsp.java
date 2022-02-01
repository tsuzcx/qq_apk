package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$GetGameMembersRsp
  extends MessageMicro<GetGameMembersRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "members" }, new Object[] { Long.valueOf(0L) }, GetGameMembersRsp.class);
  public final PBRepeatField<Long> members = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.GetGameMembersRsp
 * JD-Core Version:    0.7.0.1
 */