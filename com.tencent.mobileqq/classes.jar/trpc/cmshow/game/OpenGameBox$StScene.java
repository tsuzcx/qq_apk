package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OpenGameBox$StScene
  extends MessageMicro<StScene>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "scene_id", "refresh_interval", "items" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, StScene.class);
  public final PBRepeatMessageField<OpenGameBox.StBoxItem> items = PBField.initRepeatMessage(OpenGameBox.StBoxItem.class);
  public final PBUInt64Field refresh_interval = PBField.initUInt64(0L);
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StScene
 * JD-Core Version:    0.7.0.1
 */