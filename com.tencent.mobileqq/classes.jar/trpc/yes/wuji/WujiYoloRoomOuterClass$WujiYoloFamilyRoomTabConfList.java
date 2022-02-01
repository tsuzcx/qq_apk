package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiYoloRoomOuterClass$WujiYoloFamilyRoomTabConfList
  extends MessageMicro<WujiYoloFamilyRoomTabConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, WujiYoloFamilyRoomTabConfList.class);
  public final PBRepeatMessageField<WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConf> data = PBField.initRepeatMessage(WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloFamilyRoomTabConfList
 * JD-Core Version:    0.7.0.1
 */