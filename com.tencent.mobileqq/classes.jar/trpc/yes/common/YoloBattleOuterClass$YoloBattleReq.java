package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleOuterClass$YoloBattleReq
  extends MessageMicro<YoloBattleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "battle_cmd", "base_info" }, new Object[] { Integer.valueOf(1), null }, YoloBattleReq.class);
  public YoloBattleOuterClass.YoloBattleBaseInfo base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public final PBEnumField battle_cmd = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleReq
 * JD-Core Version:    0.7.0.1
 */