package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleObOuterClass$YoloBattleCloseOBRsp
  extends MessageMicro<YoloBattleCloseOBRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg", "game_matrix_ret" }, new Object[] { "", Long.valueOf(0L) }, YoloBattleCloseOBRsp.class);
  public final PBInt64Field game_matrix_ret = PBField.initInt64(0L);
  public final PBStringField msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleCloseOBRsp
 * JD-Core Version:    0.7.0.1
 */