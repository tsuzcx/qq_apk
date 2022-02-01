package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$CSmobaBattleInitInfo
  extends MessageMicro<CSmobaBattleInitInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field battle_start_tm = PBField.initInt64(0L);
  public final PBInt32Field flag = PBField.initInt32(0);
  public YoloBattleSmobaOuterClass.YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass.YoloSmobaSchema();
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "flag", "yolo_battle_id", "smoba_schema", "battle_start_tm" }, new Object[] { Integer.valueOf(0), localLong, null, localLong }, CSmobaBattleInitInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.CSmobaBattleInitInfo
 * JD-Core Version:    0.7.0.1
 */