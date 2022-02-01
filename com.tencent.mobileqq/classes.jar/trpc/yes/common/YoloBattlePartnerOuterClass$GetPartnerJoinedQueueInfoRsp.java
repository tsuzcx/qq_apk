package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class YoloBattlePartnerOuterClass$GetPartnerJoinedQueueInfoRsp
  extends MessageMicro<GetPartnerJoinedQueueInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "joined_queue_num" }, new Object[] { Long.valueOf(0L) }, GetPartnerJoinedQueueInfoRsp.class);
  public final PBInt64Field joined_queue_num = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.GetPartnerJoinedQueueInfoRsp
 * JD-Core Version:    0.7.0.1
 */