package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameStrangerMatchV2$AddMatchUserRsp
  extends MessageMicro<AddMatchUserRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField extra_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field game_type = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "res", "extra_info", "game_type" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, AddMatchUserRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatchV2.AddMatchUserRsp
 * JD-Core Version:    0.7.0.1
 */