package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OpenGameBox$StOpenGameBoxReq
  extends MessageMicro<StOpenGameBoxReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "ext", "scene_ids" }, new Object[] { null, Integer.valueOf(0) }, StOpenGameBoxReq.class);
  public OpenGameBox.StExtend ext = new OpenGameBox.StExtend();
  public final PBRepeatField<Integer> scene_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StOpenGameBoxReq
 * JD-Core Version:    0.7.0.1
 */