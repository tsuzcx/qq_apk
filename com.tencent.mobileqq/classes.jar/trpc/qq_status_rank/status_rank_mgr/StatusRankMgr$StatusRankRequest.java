package trpc.qq_status_rank.status_rank_mgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatusRankMgr$StatusRankRequest
  extends MessageMicro<StatusRankRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "status_id", "uin", "genrank" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) }, StatusRankRequest.class);
  public final PBBoolField genrank = PBField.initBool(false);
  public final PBInt32Field status_id = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankRequest
 * JD-Core Version:    0.7.0.1
 */