package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class OpenGameBox$StOpenGameBoxRsp
  extends MessageMicro<StOpenGameBoxRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "scenes" }, new Object[] { null, null }, StOpenGameBoxRsp.class);
  public OpenGameBox.StExtend ext = new OpenGameBox.StExtend();
  public final PBRepeatMessageField<OpenGameBox.StScene> scenes = PBField.initRepeatMessage(OpenGameBox.StScene.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StOpenGameBoxRsp
 * JD-Core Version:    0.7.0.1
 */