package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class OpenGameBox$StExtend
  extends MessageMicro<StExtend>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str2str", "str2bytes", "attachInfo" }, new Object[] { null, null, "" }, StExtend.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBRepeatMessageField<OpenGameBox.BytesEntry> str2bytes = PBField.initRepeatMessage(OpenGameBox.BytesEntry.class);
  public final PBRepeatMessageField<OpenGameBox.Entry> str2str = PBField.initRepeatMessage(OpenGameBox.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.cmshow.game.OpenGameBox.StExtend
 * JD-Core Version:    0.7.0.1
 */