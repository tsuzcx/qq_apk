package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameNotify$NotifyMatchV2UserCreateRoom
  extends MessageMicro<NotifyMatchV2UserCreateRoom>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field game_type = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seq", "game_type" }, new Object[] { localInteger, localInteger }, NotifyMatchV2UserCreateRoom.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchV2UserCreateRoom
 * JD-Core Version:    0.7.0.1
 */