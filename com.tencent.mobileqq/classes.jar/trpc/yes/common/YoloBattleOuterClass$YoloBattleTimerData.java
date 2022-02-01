package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattleTimerData
  extends MessageMicro<YoloBattleTimerData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloBattleOuterClass.YoloBattleEventReq next_event = new YoloBattleOuterClass.YoloBattleEventReq();
  public final PBInt32Field pre_status_version = PBField.initInt32(0);
  public final PBInt32Field recycle_times = PBField.initInt32(0);
  public final PBUInt64Field timeout = PBField.initUInt64(0L);
  public final PBEnumField timer_type = PBField.initEnum(0);
  public final PBEnumField trigger_filter_type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "timeout", "pre_status_version", "next_event", "timer_type", "recycle_times", "trigger_filter_type" }, new Object[] { Long.valueOf(0L), localInteger, null, localInteger, localInteger, localInteger }, YoloBattleTimerData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleTimerData
 * JD-Core Version:    0.7.0.1
 */