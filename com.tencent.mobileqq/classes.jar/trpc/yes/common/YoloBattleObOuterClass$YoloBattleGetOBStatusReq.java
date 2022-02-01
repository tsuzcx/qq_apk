package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class YoloBattleObOuterClass$YoloBattleGetOBStatusReq
  extends MessageMicro<YoloBattleGetOBStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field game_matrix_ret = PBField.initInt64(0L);
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ob_id", "game_matrix_ret" }, new Object[] { localLong, localLong }, YoloBattleGetOBStatusReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleGetOBStatusReq
 * JD-Core Version:    0.7.0.1
 */