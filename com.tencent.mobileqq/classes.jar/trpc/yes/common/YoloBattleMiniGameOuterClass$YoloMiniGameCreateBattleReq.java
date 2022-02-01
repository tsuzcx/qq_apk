package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleReq
  extends MessageMicro<YoloMiniGameCreateBattleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 82 }, new String[] { "config", "force_check_mode", "extra_data" }, new Object[] { null, Integer.valueOf(0), "" }, YoloMiniGameCreateBattleReq.class);
  public YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig();
  public final PBStringField extra_data = PBField.initString("");
  public final PBInt32Field force_check_mode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameCreateBattleReq
 * JD-Core Version:    0.7.0.1
 */