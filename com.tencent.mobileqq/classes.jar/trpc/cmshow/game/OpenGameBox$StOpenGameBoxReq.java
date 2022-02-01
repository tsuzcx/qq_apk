package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OpenGameBox$StOpenGameBoxReq
  extends MessageMicro<StOpenGameBoxReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_style = PBField.initUInt32(0);
  public OpenGameBox.StExtend ext = new OpenGameBox.StExtend();
  public final PBRepeatField<Integer> scene_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "ext", "scene_ids", "app_style" }, new Object[] { null, localInteger, localInteger }, StOpenGameBoxReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StOpenGameBoxReq
 * JD-Core Version:    0.7.0.1
 */