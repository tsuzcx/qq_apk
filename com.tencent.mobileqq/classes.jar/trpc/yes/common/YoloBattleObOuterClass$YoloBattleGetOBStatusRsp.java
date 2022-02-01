package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleObOuterClass$YoloBattleGetOBStatusRsp
  extends MessageMicro<YoloBattleGetOBStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "msg", "url", "status_desc", "status", "pic_url", "game_matrix_ret" }, new Object[] { "", "", "", Integer.valueOf(0), "", Long.valueOf(0L) }, YoloBattleGetOBStatusRsp.class);
  public final PBInt64Field game_matrix_ret = PBField.initInt64(0L);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBStringField status_desc = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleGetOBStatusRsp
 * JD-Core Version:    0.7.0.1
 */