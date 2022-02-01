package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd
  extends MessageMicro<YoloRoomReadyStatusChangeCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "op" }, new Object[] { Integer.valueOf(0) }, YoloRoomReadyStatusChangeCmd.class);
  public final PBInt32Field op = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd
 * JD-Core Version:    0.7.0.1
 */