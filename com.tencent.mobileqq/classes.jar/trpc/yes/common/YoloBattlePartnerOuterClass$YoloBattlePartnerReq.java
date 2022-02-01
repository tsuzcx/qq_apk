package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattlePartnerOuterClass$YoloBattlePartnerReq
  extends MessageMicro<YoloBattlePartnerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 802 }, new String[] { "cmd", "room_id", "req_message" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, YoloBattlePartnerReq.class);
  public final PBEnumField cmd = PBField.initEnum(1);
  public YoloBattlePartnerOuterClass.YoloBattlePartnerReqMessage req_message = new YoloBattlePartnerOuterClass.YoloBattlePartnerReqMessage();
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.YoloBattlePartnerReq
 * JD-Core Version:    0.7.0.1
 */