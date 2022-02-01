package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleOuterClass$YoloBattleGetLatestBattleReq
  extends MessageMicro<YoloBattleGetLatestBattleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "last_n", "extra_key" }, new Object[] { Integer.valueOf(0), "" }, YoloBattleGetLatestBattleReq.class);
  public final PBStringField extra_key = PBField.initString("");
  public final PBUInt32Field last_n = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleGetLatestBattleReq
 * JD-Core Version:    0.7.0.1
 */