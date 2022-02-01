package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameStrangerMatchV2$AddMatchRoomRsp
  extends MessageMicro<AddMatchRoomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField extra_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "extra_info" }, new Object[] { null, localByteStringMicro }, AddMatchRoomRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchRoomRsp
 * JD-Core Version:    0.7.0.1
 */