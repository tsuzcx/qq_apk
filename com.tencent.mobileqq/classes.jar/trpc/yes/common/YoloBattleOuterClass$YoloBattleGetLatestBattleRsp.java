package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattleGetLatestBattleRsp
  extends MessageMicro<YoloBattleGetLatestBattleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "yolo_battle_id_list" }, new Object[] { Long.valueOf(0L) }, YoloBattleGetLatestBattleRsp.class);
  public final PBRepeatField<Long> yolo_battle_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleGetLatestBattleRsp
 * JD-Core Version:    0.7.0.1
 */