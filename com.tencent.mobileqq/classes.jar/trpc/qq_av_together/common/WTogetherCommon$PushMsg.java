package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherCommon$PushMsg
  extends MessageMicro<PushMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField action_type = PBField.initEnum(0);
  public final PBUInt64Field operate_uin = PBField.initUInt64(0L);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBEnumField room_type = PBField.initEnum(0);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "seq", "room_id", "room_type", "operate_uin", "action_type" }, new Object[] { localLong, localLong, localInteger, localLong, localInteger }, PushMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.PushMsg
 * JD-Core Version:    0.7.0.1
 */