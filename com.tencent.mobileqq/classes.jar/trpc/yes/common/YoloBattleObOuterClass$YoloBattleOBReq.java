package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleObOuterClass$YoloBattleOBReq
  extends MessageMicro<YoloBattleOBReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "cmd" }, new Object[] { Integer.valueOf(1) }, YoloBattleOBReq.class);
  public final PBEnumField cmd = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBReq
 * JD-Core Version:    0.7.0.1
 */