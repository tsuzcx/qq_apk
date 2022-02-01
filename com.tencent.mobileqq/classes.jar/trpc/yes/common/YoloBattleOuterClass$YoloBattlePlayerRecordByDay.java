package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattlePlayerRecordByDay
  extends MessageMicro<YoloBattlePlayerRecordByDay>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 162 }, new String[] { "uid", "today_begin", "smoba_record_by_day" }, new Object[] { Long.valueOf(0L), "", null }, YoloBattlePlayerRecordByDay.class);
  public YoloBattleSmobaOuterClass.SmobaPlayerRecordByDay smoba_record_by_day = new YoloBattleSmobaOuterClass.SmobaPlayerRecordByDay();
  public final PBStringField today_begin = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattlePlayerRecordByDay
 * JD-Core Version:    0.7.0.1
 */