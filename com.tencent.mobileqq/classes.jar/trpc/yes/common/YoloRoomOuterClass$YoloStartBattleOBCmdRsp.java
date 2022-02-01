package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloStartBattleOBCmdRsp
  extends MessageMicro<YoloStartBattleOBCmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ob_id", "url", "game_matrix_ret" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, YoloStartBattleOBCmdRsp.class);
  public final PBInt32Field game_matrix_ret = PBField.initInt32(0);
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloStartBattleOBCmdRsp
 * JD-Core Version:    0.7.0.1
 */