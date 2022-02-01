package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SmobaDataOuterClass$GameCampSettleInfo
  extends MessageMicro<GameCampSettleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field battle_duration = PBField.initUInt32(0);
  public final PBUInt32Field battle_start_time = PBField.initUInt32(0);
  public final PBEnumField battle_tag = PBField.initEnum(0);
  public final PBStringField battle_tag_name = PBField.initString("");
  public final PBInt32Field campresult = PBField.initInt32(0);
  public final PBRepeatMessageField<SmobaDataOuterClass.PlayerSettleInfo> campsettledetail = PBField.initRepeatMessage(SmobaDataOuterClass.PlayerSettleInfo.class);
  public final PBInt32Field total_dead_count = PBField.initInt32(0);
  public final PBInt32Field total_kill_count = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "campresult", "campsettledetail", "battle_start_time", "battle_duration", "battle_tag", "total_kill_count", "total_dead_count", "battle_tag_name" }, new Object[] { localInteger, null, localInteger, localInteger, localInteger, localInteger, localInteger, "" }, GameCampSettleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.GameCampSettleInfo
 * JD-Core Version:    0.7.0.1
 */