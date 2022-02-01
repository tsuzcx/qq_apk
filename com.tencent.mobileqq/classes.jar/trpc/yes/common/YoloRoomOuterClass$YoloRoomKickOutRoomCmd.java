package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomKickOutRoomCmd
  extends MessageMicro<YoloRoomKickOutRoomCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field is_close_pos = PBField.initInt32(0);
  public final PBUInt64Field reason = PBField.initUInt64(0L);
  public final PBUInt32Field second = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uid", "is_close_pos", "reason", "second" }, new Object[] { localLong, localInteger, localLong, localInteger }, YoloRoomKickOutRoomCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutRoomCmd
 * JD-Core Version:    0.7.0.1
 */