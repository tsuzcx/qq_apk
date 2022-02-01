package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloCloseBattleOBCmdRsp
  extends MessageMicro<YoloCloseBattleOBCmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "game_matrix_ret" }, new Object[] { Integer.valueOf(0) }, YoloCloseBattleOBCmdRsp.class);
  public final PBInt32Field game_matrix_ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloCloseBattleOBCmdRsp
 * JD-Core Version:    0.7.0.1
 */