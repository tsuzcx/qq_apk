package trpc.qq_status_rank.status_rank_mgr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatusRankMgr$StatusRankResponse
  extends MessageMicro<StatusRankResponse>
{
  public static final int FAILED = 3;
  public static final int NOT_ALLOWED = 1;
  public static final int NOT_SETTED = 2;
  public static final int SUCCESS = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<StatusRankMgr.MapFieldEntry> extra = PBField.initRepeatMessage(StatusRankMgr.MapFieldEntry.class);
  public final PBBoolField first_time = PBField.initBool(false);
  public final PBBoolField in_status = PBField.initBool(false);
  public final PBUInt64Field rank = PBField.initUInt64(0L);
  public final PBEnumField res = PBField.initEnum(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "res", "rank", "first_time", "in_status", "extra" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localBoolean, localBoolean, null }, StatusRankResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankResponse
 * JD-Core Version:    0.7.0.1
 */