package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniGameDataOuterClass$YoloBattleMiniGameResult
  extends MessageMicro<YoloBattleMiniGameResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field battle_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<MiniGameDataOuterClass.YoloBattleMiniGamePlayerResult> battle_result = PBField.initRepeatMessage(MiniGameDataOuterClass.YoloBattleMiniGamePlayerResult.class);
  public final PBInt32Field battle_result_code = PBField.initInt32(0);
  public final PBInt32Field battle_result_flag = PBField.initInt32(0);
  public final PBBoolField has_strong_check = PBField.initBool(false);
  public final PBInt32Field strong_check_cost_ms = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "battle_id", "battle_result_flag", "battle_result", "battle_result_code", "has_strong_check", "strong_check_cost_ms" }, new Object[] { Long.valueOf(0L), localInteger, null, localInteger, Boolean.valueOf(false), localInteger }, YoloBattleMiniGameResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MiniGameDataOuterClass.YoloBattleMiniGameResult
 * JD-Core Version:    0.7.0.1
 */