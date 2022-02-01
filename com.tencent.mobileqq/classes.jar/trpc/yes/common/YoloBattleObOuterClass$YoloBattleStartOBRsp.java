package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleObOuterClass$YoloBattleStartOBRsp
  extends MessageMicro<YoloBattleStartOBRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field game_matrix_ret = PBField.initInt64(0L);
  public final PBStringField msg = PBField.initString("");
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  public final PBStringField url = PBField.initString("");
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "msg", "ob_id", "url", "yolo_battle_id", "game_matrix_ret" }, new Object[] { "", localLong, "", localLong, localLong }, YoloBattleStartOBRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleStartOBRsp
 * JD-Core Version:    0.7.0.1
 */