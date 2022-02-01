package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleObOuterClass$YoloBattleSyncOBStatusReq
  extends MessageMicro<YoloBattleSyncOBStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "ob_id", "status", "status_desc", "device_id", "pic_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "" }, YoloBattleSyncOBStatusReq.class);
  public final PBStringField device_id = PBField.initString("");
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  public final PBStringField pic_url = PBField.initString("");
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBStringField status_desc = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleSyncOBStatusReq
 * JD-Core Version:    0.7.0.1
 */