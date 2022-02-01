package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd
  extends MessageMicro<YoloRoomKickOutSpeakingCmd>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field is_close_pos = PBField.initInt32(0);
  public final PBInt32Field no_action = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 808 }, new String[] { "uid", "is_close_pos", "no_action" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, YoloRoomKickOutSpeakingCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutSpeakingCmd
 * JD-Core Version:    0.7.0.1
 */