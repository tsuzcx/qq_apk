package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleResultRsp
  extends MessageMicro<YoloSmobaBattleResultRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "smoba_battle_results" }, new Object[] { null }, YoloSmobaBattleResultRsp.class);
  public final PBRepeatMessageField<YoloBattleSmobaOuterClass.YoloSmobaBattleResult> smoba_battle_results = PBField.initRepeatMessage(YoloBattleSmobaOuterClass.YoloSmobaBattleResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleResultRsp
 * JD-Core Version:    0.7.0.1
 */