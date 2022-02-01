package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloBattleSmobaOuterClass$SmobaPlayerRecordByDay
  extends MessageMicro<SmobaPlayerRecordByDay>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field battle_num = PBField.initInt32(0);
  public final PBInt32Field win_battle_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "battle_num", "win_battle_num" }, new Object[] { localInteger, localInteger }, SmobaPlayerRecordByDay.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.SmobaPlayerRecordByDay
 * JD-Core Version:    0.7.0.1
 */