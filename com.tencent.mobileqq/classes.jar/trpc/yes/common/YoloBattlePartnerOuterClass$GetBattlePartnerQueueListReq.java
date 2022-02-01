package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattlePartnerOuterClass$GetBattlePartnerQueueListReq
  extends MessageMicro<GetBattlePartnerQueueListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
  public final PBInt32Field end = PBField.initInt32(0);
  public final PBInt32Field start = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "end", "anchor_uid" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, GetBattlePartnerQueueListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.GetBattlePartnerQueueListReq
 * JD-Core Version:    0.7.0.1
 */