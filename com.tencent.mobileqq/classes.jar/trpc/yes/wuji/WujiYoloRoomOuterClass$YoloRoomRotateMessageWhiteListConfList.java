package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiYoloRoomOuterClass$YoloRoomRotateMessageWhiteListConfList
  extends MessageMicro<YoloRoomRotateMessageWhiteListConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, YoloRoomRotateMessageWhiteListConfList.class);
  public final PBRepeatMessageField<WujiYoloRoomOuterClass.YoloRoomRotateMessageWhiteListConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass.YoloRoomRotateMessageWhiteListConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.YoloRoomRotateMessageWhiteListConfList
 * JD-Core Version:    0.7.0.1
 */