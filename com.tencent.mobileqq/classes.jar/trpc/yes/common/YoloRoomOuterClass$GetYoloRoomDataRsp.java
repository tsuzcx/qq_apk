package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$GetYoloRoomDataRsp
  extends MessageMicro<GetYoloRoomDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomAction> action_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomAction.class);
  public final PBInt32Field has_more = PBField.initInt32(0);
  public final PBInt32Field online_num = PBField.initInt32(0);
  public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "has_more", "action_list", "online_num", "uid_list" }, new Object[] { localInteger, null, localInteger, Long.valueOf(0L) }, GetYoloRoomDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.GetYoloRoomDataRsp
 * JD-Core Version:    0.7.0.1
 */