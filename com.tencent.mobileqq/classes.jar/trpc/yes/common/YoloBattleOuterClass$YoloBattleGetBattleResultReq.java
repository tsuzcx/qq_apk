package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloBattleOuterClass$YoloBattleGetBattleResultReq
  extends MessageMicro<YoloBattleGetBattleResultReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "get_last_n" }, new Object[] { Integer.valueOf(0) }, YoloBattleGetBattleResultReq.class);
  public final PBInt32Field get_last_n = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleGetBattleResultReq
 * JD-Core Version:    0.7.0.1
 */