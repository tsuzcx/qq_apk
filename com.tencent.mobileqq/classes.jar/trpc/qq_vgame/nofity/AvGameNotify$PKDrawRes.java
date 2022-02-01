package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameNotify$PKDrawRes
  extends MessageMicro<PKDrawRes>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_draw = PBField.initBool(false);
  public final PBUInt32Field peer_cost = PBField.initUInt32(0);
  public final PBUInt32Field self_cost = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24, 32, 40 }, new String[] { "is_draw", "self_cost", "peer_cost" }, new Object[] { Boolean.valueOf(false), localInteger, localInteger }, PKDrawRes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.PKDrawRes
 * JD-Core Version:    0.7.0.1
 */