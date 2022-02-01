package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleSmobaOuterClass$YoloSmobaCreateBattleReq
  extends MessageMicro<YoloSmobaCreateBattleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "smoba_config", "check_valid" }, new Object[] { null, Boolean.valueOf(false) }, YoloSmobaCreateBattleReq.class);
  public final PBBoolField check_valid = PBField.initBool(false);
  public YoloBattleSmobaOuterClass.YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass.YoloSmobaBattleConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaCreateBattleReq
 * JD-Core Version:    0.7.0.1
 */