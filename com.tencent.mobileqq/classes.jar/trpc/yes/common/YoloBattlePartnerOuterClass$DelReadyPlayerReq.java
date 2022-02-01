package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattlePartnerOuterClass$DelReadyPlayerReq
  extends MessageMicro<DelReadyPlayerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "ready_uid" }, new Object[] { Long.valueOf(0L) }, DelReadyPlayerReq.class);
  public final PBUInt64Field ready_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.DelReadyPlayerReq
 * JD-Core Version:    0.7.0.1
 */