package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd
  extends MessageMicro<YoloRoomSpeakingPosStatusChangeCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field op = PBField.initInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op", "pos" }, new Object[] { localInteger, localInteger }, YoloRoomSpeakingPosStatusChangeCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd
 * JD-Core Version:    0.7.0.1
 */